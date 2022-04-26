<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO/Login</title>
</head>
<body>
${message}<br>
<form method="post" action="/login">
    <input type="text" name="passportNumber" placeholder="Enter your passport number"/><br>
    <input type="password" name="password" placeholder="Enter your password"><br>
    <button type="submit" >Submit</button>
    <a href="/registration">Registration</a>

</form>
</body>
</html>