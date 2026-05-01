package com.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        // Store start time for duration tracking
        req.setAttribute("startTime", System.currentTimeMillis());

        System.out.println("---- Request Initialized ----");
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("Method: " + req.getMethod());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        Long startTime = (Long) req.getAttribute("startTime");
        long duration = 0;

        if (startTime != null) {
            duration = System.currentTimeMillis() - startTime;
        }

        System.out.println("---- Request Completed ----");
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("Time Taken: " + duration + " ms");
        System.out.println("---------------------------");
    }
}