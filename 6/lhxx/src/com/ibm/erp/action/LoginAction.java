package com.ibm.erp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet({ "/LoginAction", "/login.do" })
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginAction() {
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}


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
     	        	
     	        }
     	        //取得用户在线列表
     	        List userlist=(List)application.getAttribute("userlist");
     	        if(userlist==null){
     	        	userlist=new ArrayList<>();
     	        	userlist.add(id);
     	        	application.setAttribute("userlist", userlist);  	        	
     	        }
     	        else{
     	        	userlist.add(id);
     	        }
     	       response.sendRedirect("main.do");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
