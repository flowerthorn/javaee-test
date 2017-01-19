package com.city.info;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionAttributeListener
 *
 */
@WebListener
public class SessionAttributeListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
        String name=event.getName();
        String id=(String)event.getValue();
        HttpSession session=event.getSession();
        ServletContext application=session.getServletContext();
        if(name!=null&&name.equals("id")&&id!=null){
        	int onlinenum=(Integer)application.getAttribute("onlinenum")-1;
        	application.setAttribute("onlinenum", onlinenum);
        	
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
           String name=event.getName();
           String id=(String)event.getValue();
           HttpSession session=event.getSession();
           ServletContext application=session.getServletContext();
           if(name!=null&&name.equals("id")&&id!=null){
        	   int onlinenum=(Integer)application.getAttribute("onlinenum"+1);
        	   application.setAttribute("onlinenum", onlinenum);
        	   
           }
    }



	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
