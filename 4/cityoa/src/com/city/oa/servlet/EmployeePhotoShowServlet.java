package com.city.oa.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
 * Servlet implementation class EmployeePhotoShowServlet
 */
@WebServlet(
		urlPatterns = { 
				"/EmployeePhotoShowServlet", 
				"/employee/showphoto.do"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:odbc:db"), 
				@WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver")
		})
public class EmployeePhotoShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection cn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeePhotoShowServlet() {
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
		String empId=request.getParameter("empId");
		 System.out.println(empId);	
		 String sql="select PHOTO,FILETYPE,FILENAME from EMP where EMPID=?";
		 int len=0;
		 byte[]data=new byte[300];
		 try{
			 PreparedStatement ps=cn.prepareStatement(sql);
			 ps.setString(1, empId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 String fileType=rs.getString("FILETYPE");
				 response.setContentType(fileType);
				 OutputStream out=response.getOutputStream();
				 InputStream in=rs.getBinaryStream("PHOTO");
				 while((len=in.read(data))!=-1){
					 out.write(data,0,len);
				 }
				 in.close();out.close();
				 
				 
				 
			 }
			 
			 
		 }catch(Exception e){
			 System.out.print("È¡µÃ¼ÇÂ¼´íÎó£º"+e.getMessage());
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
