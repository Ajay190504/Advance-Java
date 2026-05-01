package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter({"/register", "/login"})
public class ValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("ValidationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        String uri = request.getRequestURI();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Trim inputs
        if (name != null) name = name.trim();
        if (email != null) email = email.trim();
        if (password != null) password = password.trim();

        // REGISTER VALIDATION
        if (uri.endsWith("/register")) {

            if (name == null || name.isEmpty() ||
                email == null || email.isEmpty() ||
                password == null || password.isEmpty()) {

                req.setAttribute("error", "All fields are required");
                req.getRequestDispatcher("register.jsp").forward(req, res);
                return;
            }

            if (password.length() < 6) {
                req.setAttribute("error", "Password must be at least 6 characters");
                req.getRequestDispatcher("register.jsp").forward(req, res);
                return;
            }
        }

        // LOGIN VALIDATION
        if (uri.endsWith("/login")) {

            if (email == null || email.isEmpty() ||
                password == null || password.isEmpty()) {

                req.setAttribute("error", "Email and Password required");
                req.getRequestDispatcher("login.jsp").forward(req, res);
                return;
            }
        }

        // Continue request
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("ValidationFilter destroyed");
    }
}