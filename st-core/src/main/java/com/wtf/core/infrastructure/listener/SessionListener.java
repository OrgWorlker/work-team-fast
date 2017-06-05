package com.wtf.core.infrastructure.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
 * The type Session listener.
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
        final ServletContext context = session.getServletContext();
        if (context.getAttribute("count") == null) {
            context.setAttribute("count", 0);
        } else {
            int count = (Integer) context.getAttribute("count");
            context.setAttribute("count", count + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        if (context.getAttribute("count") == null) {
            context.setAttribute("count", 0);
        } else {
            int count = (Integer) context.getAttribute("count");
            if (count < 1) {
                count = 1;
            }
            context.setAttribute("count", count - 1);
        }
        HttpSession session = httpSessionEvent.getSession();
        String name = (String) session.getAttribute("name");
        HashSet<String> nameSet = (HashSet<String>) context.getAttribute("nameSet");
        nameSet.remove(name);
    }
}
