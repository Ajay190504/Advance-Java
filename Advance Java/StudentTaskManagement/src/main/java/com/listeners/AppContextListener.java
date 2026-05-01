package com.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        // App startup log
        System.out.println("Application Started");

        // Set global attributes (can be accessed anywhere)
        context.setAttribute("appName", "Student Task Management System");

        // Example: DB config (optional)
        context.setAttribute("DB_URL", "jdbc:mysql://localhost:3306/student_task");
        context.setAttribute("DB_USER", "root");
        context.setAttribute("DB_PASS", "root");

        System.out.println("Context Initialized Successfully");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        // 🔹 Cleanup tasks
        System.out.println("Application Stopped");

        // Example: remove attributes
        context.removeAttribute("appName");
        context.removeAttribute("DB_URL");
        context.removeAttribute("DB_USER");
        context.removeAttribute("DB_PASS");
        
        System.out.println("Context Destroyed Successfully");
    }
}