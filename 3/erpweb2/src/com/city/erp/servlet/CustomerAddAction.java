package com.city.erp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerAddAction
 */
@WebServlet(
		urlPatterns = { 
				"/CustomerAddAction", 
				"/customer/add.do"
		}, 
		initParams = { 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver"), 
				@WebInitParam(name = "url", value = "jdbc:odbc:db")
		})
public class CustomerAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection cn=null;
       

    public CustomerAddAction() {
        super();
     
    }

    public void init(ServletConfig config) throws ServletException {
		
    	
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		try{
			Class.forName(driver);
			cn=DriverManager.getConnection(url);
			
		}catch(Exception e){
			System.out.println("Init Error:"+e.getMessage());
		}
	}

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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String jianjie=request.getParameter("jianjie");
		String number=request.getParameter("number");
		String total=request.getParameter("total");
		String type=request.getParameter("type");
		String fanwei=request.getParameter("fanwei");
		
		try{
			String sql="inser into Customer values(?,?,?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,jianjie);
			ps.setString(4,number);
			ps.setString(5,total);
			ps.setString(6,type);
			ps.setString(7,fanwei);	
			ps.executeUpdate();
			ps.close();
			response.sendRedirect("success.jsp");
		}catch(Exception e){
			System.out.print("123");
			response.sendRedirect("add.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
