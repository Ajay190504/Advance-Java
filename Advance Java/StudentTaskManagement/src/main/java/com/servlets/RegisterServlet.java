package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // 🔹 Get and sanitize input
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (name != null) name = name.trim();
        if (email != null) email = email.trim();
        if (password != null) password = password.trim();

        try {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            u.setPassword(password);

            boolean status = new UserDAO().register(u);

            if (status) {
                System.out.println("User Registered: " + email);

                // ✅ Redirect (PRG pattern)
                res.sendRedirect(req.getContextPath() + "/login.jsp");

            } else {
                // ❌ Registration failed (e.g., duplicate email)
                req.setAttribute("error", "Registration failed (Email may already exist)");
                req.getRequestDispatcher("register.jsp").forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error", "Something went wrong");
            req.getRequestDispatcher("register.jsp").forward(req, res);
        }
    }
}