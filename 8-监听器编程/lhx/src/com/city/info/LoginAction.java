package com.city.info;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet(
		urlPatterns = { 
				"/LoginAction", 
				"/login.do"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:odbc:db"), 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver")
		})
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String ps=request.getParameter("ps");
		 if(id==null||id.trim().length()==0){
	        	response.sendRedirect("login.jsp");
	        	
	        } 
	        else if(ps==null||ps.trim().length()==0){
	        	response.sendRedirect("login.jsp");
	        	
	        } 
	        else{
	        	HttpSession session=request.getSession();
     	        session.setAttribute("id", id);
     	        //web上下文对象
     	        ServletContext application=request.getServletContext();
     	        //取得在线人数
     	        Integer onlinenum=(Integer)application.getAttribute("onlinenum");
     	        if(onlinenum==null){
     	        	application.setAttribute("onlinenum", new Integer(1));
     	        }
     	        else{
     	        	application.setAttribute("onlinenum", ++onlinenum);
     	        	
     	        }}
	    
		 response.sendRedirect("main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
