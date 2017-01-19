package com.city.info;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserAccessNumCount
 *
 */
@WebListener
public class UserAccessNumCount implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public UserAccessNumCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
    	  ServletContext application=arg0.getServletContext();
          Integer num=(Integer)application.getAttribute("num");
          if(num!=null){
          	num++;
          	application.setAttribute("num", num);
          }
      }
    }
	
