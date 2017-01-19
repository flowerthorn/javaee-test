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
        application.setAttribute("onlinenum", 0);
        

		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:db");
			/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=chatdatabase","sa","123456");*/
			String sql="select num from emp ";
			PreparedStatement pss=cn.prepareStatement(sql);
			ResultSet rs=pss.executeQuery();
			if(rs.next())
			{     		//初始化点击次数
				int num=rs.getInt("num");
				System.out.print(num);
				application.setAttribute("num", num);
				}
			
			
		}catch(Exception e){
			System.out.print("数据库读入错误");
		}
		
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
        //退出时写回数据库
    	Connection cn=null;
    	ServletContext application=arg0.getServletContext();
    	try{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:db");
    		/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=chatdatabase","sa","123456");*/
			String sql="update emp set num=? ";
			PreparedStatement pss=cn.prepareStatement(sql);
				int num=(Integer)application.getAttribute("num");
				pss.setInt(1, num);
				pss.executeUpdate();

		}catch(Exception e){
			System.out.print("数据库写入连接错误");
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
