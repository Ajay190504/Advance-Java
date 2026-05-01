package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import com.dao.TaskDAO;
import com.model.Task;
import com.model.User;

@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {

    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
        System.out.println("TaskServlet Initialized");
    }

    // HANDLE GET (View / Delete / Edit)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        User u = (User) session.getAttribute("user");
        String action = req.getParameter("action");

        try {

            // DELETE TASK
            if ("delete".equals(action)) {
                int id = parseId(req.getParameter("id"));
                if (id == -1) {
                    res.sendRedirect(req.getContextPath() + "/TaskServlet");
                    return;
                }

                taskDAO.deleteTask(id, u.getId());
                res.sendRedirect(req.getContextPath() + "/TaskServlet");
                return;
            }

            // LOAD EDIT PAGE
            if ("edit".equals(action)) {
                int id = parseId(req.getParameter("id"));
                if (id == -1) {
                    res.sendRedirect(req.getContextPath() + "/TaskServlet");
                    return;
                }

                Task task = taskDAO.getTaskById(id, u.getId());

                if (task == null) {
                    res.sendRedirect(req.getContextPath() + "/TaskServlet");
                    return;
                }

                req.setAttribute("task", task);
                req.getRequestDispatcher("editTask.jsp").forward(req, res);
                return;
            }

            // DEFAULT → SHOW TASK LIST
            List<Task> tasks = taskDAO.getTasksByUser(u.getId());

            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error", "Unable to load tasks");
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);
        }
    }

    // HANDLE POST (Add / Update)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        User u = (User) session.getAttribute("user");
        String action = req.getParameter("action");

        String title = sanitize(req.getParameter("title"));
        String description = sanitize(req.getParameter("description"));

        try {

            // ADD TASK
            if (action == null) {

                if (title.isEmpty() || description.isEmpty()) {
                    req.setAttribute("error", "All fields are required");
                    req.getRequestDispatcher("addTask.jsp").forward(req, res);
                    return;
                }

                Task t = new Task();
                t.setTitle(title);
                t.setDescription(description);
                t.setUserId(u.getId());

                taskDAO.addTask(t);

                res.sendRedirect(req.getContextPath() + "/TaskServlet");
                return;
            }

            // UPDATE TASK
            if ("update".equals(action)) {

                int id = parseId(req.getParameter("id"));
                if (id == -1) {
                    res.sendRedirect(req.getContextPath() + "/TaskServlet");
                    return;
                }

                if (title.isEmpty() || description.isEmpty()) {
                    Task existingTask = taskDAO.getTaskById(id, u.getId());
                    if (existingTask == null) {
                        res.sendRedirect(req.getContextPath() + "/TaskServlet");
                        return;
                    }
                    req.setAttribute("task", existingTask);
                    req.setAttribute("error", "All fields are required");
                    req.getRequestDispatcher("editTask.jsp").forward(req, res);
                    return;
                }

                Task t = new Task();
                t.setId(id);
                t.setTitle(title);
                t.setDescription(description);
                t.setUserId(u.getId());

                taskDAO.updateTask(t);

                res.sendRedirect(req.getContextPath() + "/TaskServlet");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error", "Operation failed");
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);
        }
    }

    // Utility: Safe ID parsing
    private int parseId(String idStr) {
        try {
            return Integer.parseInt(idStr);
        } catch (Exception e) {
            return -1;
        }
    }

    // Utility: sanitize input
    private String sanitize(String input) {
        return input == null ? "" : input.trim();
    }

    @Override
    public void destroy() {
        System.out.println("TaskServlet Destroyed");
    }
}
