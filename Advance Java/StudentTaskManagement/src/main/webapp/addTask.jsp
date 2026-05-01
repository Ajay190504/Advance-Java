<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>

<div class="page-center">

    <div class="container">

        <h2>Add New Task</h2>

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

            <div class="form-group">
                <input type="text"
                       name="title"
                       placeholder="Enter Task Title"
                       required>
            </div>

            <div class="form-group">
                <textarea name="description"
                          placeholder="Enter Description"
                          required></textarea>
            </div>

            <button type="submit" class="primary-btn">Add Task</button>

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