package com.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionListener implements HttpSessionListener {

    // Track active sessions
    private static final AtomicInteger activeSessions = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        int count = activeSessions.incrementAndGet();

        System.out.println("---- Session Created ----");
        System.out.println("Session ID: " + session.getId());
        System.out.println("Active Sessions: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        int count = activeSessions.decrementAndGet();

        System.out.println("---- Session Destroyed ----");
        System.out.println("Session ID: " + session.getId());
        System.out.println("Active Sessions: " + count);
    }
}