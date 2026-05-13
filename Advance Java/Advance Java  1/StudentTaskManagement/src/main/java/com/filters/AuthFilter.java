package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Get session once
        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        // Normalize URI (remove context path)
        String uri = req.getRequestURI().substring(req.getContextPath().length());

        // Allow public resources
        boolean allowed = uri.equals("/") ||
                          uri.equals("/index.jsp") ||
                          uri.equals("/login.jsp") ||
                          uri.equals("/register.jsp") ||
                          uri.equals("/login") ||
                          uri.equals("/register") ||
                          uri.startsWith("/css/") ||
                          uri.startsWith("/js/") ||
                          uri.startsWith("/images/");

        if (loggedIn || allowed) {
            chain.doFilter(request, response);
        } else {
            // Always use context path
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}