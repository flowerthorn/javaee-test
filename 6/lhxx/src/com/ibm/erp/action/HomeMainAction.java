package com.ibm.erp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeMainAction
 */
@WebServlet({ "/HomeMainAction", "/main.do" })
public class HomeMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomeMainAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		response.setCharacterEncoding("GBK");	
		PrintWriter out=response.getWriter();
		String a=null;
		String b=null;	
		ServletContext application =request.getServletContext();
		List list=(List)application.getAttribute("userlist");
		HttpSession httpsession=request.getSession();
	
		 a=(String)httpsession.getAttribute("onlinenum");
	     b=(String)httpsession.getAttribute("id");

			out.println("<html><head></head>");
			out.println("<body>");
			out.println("<h1>city系统主页</h1>");
			out.println("<p>当前用户"+b+"</p><br/>");
			out.println("<p>用户列表</p>");
			for(Object o:list){
				out.println((String)o);
				out.println("<br/>");
			}
			
			out.println("<a href='logout.do'>注销</a>");
			out.println("</body>");
			out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
