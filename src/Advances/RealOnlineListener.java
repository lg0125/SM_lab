package Advances;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class RealOnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener , ServletRequestListener {

    // Public constructor is required by servlet spec
    public RealOnlineListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }

    @Override
    @SuppressWarnings("unchecked")
    public void requestInitialized(ServletRequestEvent sre) {

        Date date = new Date();

        Long time = date.getTime();

        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        HttpSession session = request.getSession();

        String id = request.getSession().getId();

        Map<String,Long> sessionMap = (HashMap<String,Long>) session.getServletContext().getAttribute("sessionMap");

        if(sessionMap == null) sessionMap = new HashMap<>();

        if(!sessionMap.containsKey(id)) sessionMap.put(id,time);

        ArrayList<String> list = new ArrayList<>();

        for(Map.Entry<String,Long> entry:sessionMap.entrySet()){

            String key = entry.getKey();

            if(key.equals(id)){

                entry.setValue(time);

            }

            Long value = entry.getValue();

            if((time - value)/1000 > 30){

                list.add(key);

            }

        }

        for(String key:list){
            sessionMap.remove(key);
        }

        session.getServletContext().setAttribute("sessionMap",sessionMap);

        session.getServletContext().setAttribute("real_num",sessionMap.size());

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
