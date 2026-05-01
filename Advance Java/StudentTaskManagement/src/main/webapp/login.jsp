<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

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

        <h2>Login</h2>

        <%
            String error = (String) request.getAttribute("error");
            if(error != null){
        %>
            <div class="error"><%= error %></div>
        <%
            }
        %>

        <form action="${pageContext.request.contextPath}/login"
              method="post"
              class="form">

            <div class="form-group">
                <input type="email" name="email"
                       placeholder="Enter Email"
                       required>
            </div>

            <div class="form-group">
                <input type="password" name="password"
                       placeholder="Enter Password"
                       required>
            </div>

            <button type="submit" class="primary-btn">Login</button>

        </form>

        <div class="center-text">
            <a href="${pageContext.request.contextPath}/register.jsp">
                Create Account
            </a>
        </div>

    </div>

</div>

</body>
</html>