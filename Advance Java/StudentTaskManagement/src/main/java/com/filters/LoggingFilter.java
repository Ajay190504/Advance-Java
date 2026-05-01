package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        long startTime = System.currentTimeMillis();

        // BEFORE request processing
        System.out.println("Request Start");
        System.out.println("Method: " + method);
        System.out.println("URI: " + uri +
                (query != null ? "?" + query : ""));

        // Continue chain
        chain.doFilter(req, res);

        long endTime = System.currentTimeMillis();

        // 🔹 AFTER request processing
        System.out.println("Request End");
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
        System.out.println("------------------------------------");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}