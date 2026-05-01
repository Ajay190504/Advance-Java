package com.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            res.sendRedirect(req.getContextPath() + "/TaskServlet");
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}