package com.city.oa.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeShowServlet
 */
@WebServlet(
		urlPatterns = { 
				"/EmployeeShowServlet", 
				"/employee/show.do"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:odbc:db"), 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver")
		})
public class EmployeeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection cn=null;
    public EmployeeShowServlet() {
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
	 String empId=request.getParameter("empId");
	 System.out.println(empId);
		response.setCharacterEncoding("GBK");	
		
	 String sql="select NAME,AGE,SEX from EMP where EMPID=?";
	 PrintWriter out=response.getWriter();
	 try{
		 PreparedStatement ps=cn.prepareStatement(sql);
		 ps.setString(1, empId);
		 ResultSet rs=ps.executeQuery();
		out.println("<HTML>");
			out.print("<HEAD><TITLE>标题</TITLE></HEAD>");
			out.print("<Body>");
		 if(rs.next()){
			 //String fileType=rs.getString("FILETYPE");
			// response.setContentType(fileType);
	
			out.println("<tr><td>姓名："+rs.getString("NAME")+"</td></tr></br>");
			out.println("<tr><td>年龄："+rs.getString("AGE")+"</td></tr></br>");
			out.println("<tr><td>性别："+rs.getString("SEX")+"</td></tr>");
			out.println("图片:<img src='showphoto.do?empId="+empId+"'/>");
			out.println("</HTML></BODY>");
			
			
		 }
		 rs.close();ps.close();
		  out.flush();out.close();
		 
	 }catch(Exception e){
		 System.out.print("取得记录错误："+e.getMessage());
	 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
