<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.model.Task"%>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="dashboard-page">

<div class="dashboard">

    <div class="navbar">
        <h2>My Tasks</h2>
        <a href="${pageContext.request.contextPath}/logout"
           class="logout-link">Logout</a>
    </div>

    <div class="top-actions">
        <a href="${pageContext.request.contextPath}/addTask.jsp"
           class="add-btn">+ Add Task</a>
    </div>

    <hr>

    <%
        List<Task> tasks = (List<Task>) request.getAttribute("tasks");

        if(tasks == null || tasks.isEmpty()){
    %>
        <p class="empty">No tasks found.</p>
    <%
        } else {
            for(Task t : tasks) {
    %>

    <div class="task">

        <div class="task-content">
            <h3><%= t.getTitle() %></h3>
            <p><%= t.getDescription() %></p>
        </div>

        <div class="actions">

            <form action="${pageContext.request.contextPath}/TaskServlet"
                  method="get">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="<%= t.getId() %>">
                <button type="submit" class="edit-btn">Edit</button>
            </form>

            <form action="${pageContext.request.contextPath}/TaskServlet"
                  method="get"
                  onsubmit="return confirm('Delete this task?');">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= t.getId() %>">
                <button type="submit" class="delete-btn">Delete</button>
            </form>

        </div>

    </div>

    <%
            }
        }
    %>

</div>

</body>
</html>