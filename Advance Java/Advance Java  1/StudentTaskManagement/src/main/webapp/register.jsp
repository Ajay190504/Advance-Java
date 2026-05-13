<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<%
    if(session.getAttribute("user") != null){
        response.sendRedirect(request.getContextPath() + "/TaskServlet");
        return;
    }
%>

<div class="page-center">

    <div class="container">

        <h2>Create Account</h2>

        <%
            String error = (String) request.getAttribute("error");
            if(error != null){
        %>
            <div class="error"><%= error %></div>
        <%
            }
        %>

        <form action="${pageContext.request.contextPath}/register"
              method="post"
              class="form">

            <div class="form-group">
                <input type="text"
                       name="name"
                       placeholder="Enter Name"
                       required>
            </div>

            <div class="form-group">
                <input type="email"
                       name="email"
                       placeholder="Enter Email"
                       required>
            </div>

            <div class="form-group">
                <input type="password"
                       name="password"
                       placeholder="Enter Password"
                       required>
            </div>

            <button type="submit" class="primary-btn">Register</button>

        </form>

        <div class="center-text">
            <span>Already have an account?</span>
            <a href="${pageContext.request.contextPath}/login.jsp"
               class="inline-link">Login</a>
        </div>

    </div>

</div>

</body>
</html>