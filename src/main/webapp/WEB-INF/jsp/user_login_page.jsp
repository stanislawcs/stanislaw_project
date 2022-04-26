<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO/Login/User</title>
</head>
<body>
${messages}<br>
<form method="post" action="/login/user">
    <input type="text" name="username" placeholder="Enter your username"/><br>
    <input type="password" name="password" placeholder="Enter your password"><br>
    <button type="submit">Submit</button>
    <a href="/registration/user">Registration</a>
</form>
</body>
</html>