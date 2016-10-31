package com.city.oa.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcessAction
 */
@WebServlet(
		urlPatterns = { 
				"/LoginProcessAction", 
				"/login.do"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:odbc:db"), 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver")
		})
public class LoginProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection cn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcessAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		try{
			Class.forName(driver);
			cn=DriverManager.getConnection(url);
			
		}catch(Exception e){
			System.out.println("Init Error:"+e.getMessage());
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try{
			if(cn!=null&&(!cn.isClosed())){
				cn.close();cn=null;
			}
		}catch(Exception e){
			System.out.println("Destory Error:"+e.getMessage());
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		String password=request.getParameter("ps");
		String choice=request.getParameter("choice");
        if(id==null||id.trim().length()==0){
        	response.sendRedirect("login.jsp");
        	
        } 
        else if(password==null||password.trim().length()==0){
        	response.sendRedirect("login.jsp");
        	
        } 
        else if(choice==null||choice.trim().length()==0){
        	response.sendRedirect("login.jsp");
        	
        } 
       
        else {
        	String sql="select * from EMP where EMPID=? and PASSWORD=?";
        		//Connection cn=null;
        		boolean check=false;
        		try{PreparedStatement ps=cn.prepareStatement(sql);
        		ps.setString(1, id);
        		ps.setString(2, password);
        		ResultSet rs=ps.executeQuery();
        		if((rs.next())){
        			
        			check=true;
        			
        		}
        		rs.close();
        		ps.close();
        			
        		}catch(Exception e){
        			response.sendRedirect("login.jsp");
        		}finally{
        			try{cn.close();}catch(Exception e){}
        		}
        		if(check){
        			//合法
        	        HttpSession session=request.getSession();
        	        session.setAttribute("userid", id);
        	        Cookie cookie01=new Cookie("userid",id);
        	        if(choice.equals("day")){
        	        	cookie01.setMaxAge(24*60*60); 
        	        }
        	        else{
        	        	cookie01.setMaxAge(7*24*60*60); 
        	        }
        	        
        	        response.addCookie(cookie01);
        			response.sendRedirect("main.do");
        		}
        		else{
        			response.sendRedirect("login.jsp");
        		}
        	
        	
        }	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
