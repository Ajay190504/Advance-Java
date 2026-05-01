package com.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        handleLogout(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        handleLogout(req, res);
    }

    private void handleLogout(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession(false);

        if (session != null) {
            System.out.println("Logging out session: " + session.getId());

            // Optional: remove specific attributes
            session.removeAttribute("user");

            // Invalidate session
            session.invalidate();
        }

        // Context-safe redirect
        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}