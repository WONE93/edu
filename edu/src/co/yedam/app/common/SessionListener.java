package co.yedam.app.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent session)  { 
    	System.out.println("세션생성" +session.getSession().getId());
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("세션제거");
    }

	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         System.out.println("세션에 속성 추가" + event.getName() +
        		 					" : " + event.getValue());
      
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { //세션에 새로운 속성이 추가될때
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { //속성값이 변경될때
        	
    }
	
}
