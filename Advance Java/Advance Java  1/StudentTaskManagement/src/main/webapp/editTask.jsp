<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.model.Task" %>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    Task t = (Task) request.getAttribute("task");

    if(t == null){
        response.sendRedirect(request.getContextPath() + "/TaskServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="page-center">

    <div class="container">

        <h2>Edit Task</h2>

        <%
            String error = (String) request.getAttribute("error");
            if(error != null){
        %>
            <div class="error"><%= error %></div>
        <%
            }
        %>

        <form action="${pageContext.request.contextPath}/TaskServlet"
              method="post"
              class="form">

            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%= t.getId() %>">

            <div class="form-group">
                <input type="text"
                       name="title"
                       value="<%= t.getTitle() %>"
                       placeholder="Enter title"
                       required>
            </div>

            <div class="form-group">
                <textarea name="description"
                          placeholder="Enter description"
                          required><%= t.getDescription() %></textarea>
            </div>

            <button type="submit" class="primary-btn">Update Task</button>

        </form>

        <div class="center-text">
            <a href="${pageContext.request.contextPath}/TaskServlet">
                ← Back to Dashboard
            </a>
        </div>

    </div>

</div>

</body>
</html>