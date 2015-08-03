/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.proqramci;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Ilkin Abdullayev
 */
public class SessionListener implements HttpSessionListener {
    
    public static Map<String,HttpSession> maps=new HashMap<String,HttpSession>();

    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (this) {
            sessionCount++;
        }

        System.out.println("Session Created: " + se.getSession().getId());
        System.out.println("Total Sessions: " + sessionCount);
        maps.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this) {
            sessionCount--;
        }
        System.out.println("Session Destroyed: " + se.getSession().getId());
        System.out.println("Total Sessions: " + sessionCount);        
        maps.remove(se.getSession().getId());
    }

}
