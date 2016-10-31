package com.city.oa.action;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class MainPageAction
 */
@WebServlet(
		urlPatterns = { 
				"/MainPageAction", 
				"/main.do"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:odbc:db"), 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver")
		})
public class MainPageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAction() {
        super();
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
		Cookie[] cookie=request.getCookies();
		response.setCharacterEncoding("GBK");	
		PrintWriter out=response.getWriter();
		String a=null;
		String b=null;
		for(int i=0;i<cookie.length;i++){
			if(cookie[i].getName().equals("userid")){
				a=cookie[i].getValue();
			}
}
		HttpSession httpsession=request.getSession();
	     b=(String)httpsession.getAttribute("userid");
	  
	  
		out.println("<html><head>lhx</head>");
		out.println("<body>");
		out.println("<h1>系统主页</h1>");
		out.println("<p>Session中的账号"+b+"</p>");
		out.println("<p>Cookie中的账号"+a+"</p>");
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
