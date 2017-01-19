package com.city.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebApplicationListener
 *
 */
@WebListener
public class WebApplicationListener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public WebApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  {      
    	Connection cn=null;
        ServletContext application=event.getServletContext();
        application.setAttribute("id", 0);
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:db");
			
		}catch(Exception e){
			System.out.println("Init Error:"+e.getMessage());
		}
		try{
			String sql="select num from emp ";
			PreparedStatement pss=cn.prepareStatement(sql);
			ResultSet rs=pss.executeQuery();
			if(rs.next()){
				int num=rs.getInt("num");
				application.setAttribute("num", num);
			}
			
			
		}catch(Exception e){
			System.out.print("错误");
		}
		
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
        //写数据库
    	Connection cn=null;
    	ServletContext application=arg0.getServletContext();
    	try{
			String sql="update emp set num=? ";
			PreparedStatement pss=cn.prepareStatement(sql);
				int num=(Integer)application.getAttribute("num");
				pss.setInt(1, num);
				pss.executeUpdate();

		}catch(Exception e){
			System.out.print("错误");
		}
		
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
