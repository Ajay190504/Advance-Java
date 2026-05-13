package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // Get and sanitize input
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null) email = email.trim();
        if (password != null) password = password.trim();

        try {
            // Authenticate user
            User u = new UserDAO().login(email, password);

            if (u != null) {

                // Prevent session fixation
                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = req.getSession(true);
                newSession.setAttribute("user", u);

                System.out.println("Login Success: " + u.getEmail());

                res.sendRedirect(req.getContextPath() + "/TaskServlet");

            } else {
                // Invalid login → forward with error
                req.setAttribute("error", "Invalid email or password");
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error", "Something went wrong");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}