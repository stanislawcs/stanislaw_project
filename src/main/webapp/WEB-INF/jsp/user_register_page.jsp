<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO/Registration/User</title>
</head>
<body>
${messages}<br>
<form method="post" action="/registration/user">
    <input type="text" name="username" placeholder="Input your username"><br>
    <input type ="password" name="password" placeholder="Create your password"><br>
    <input type ="password" name ="repassword" placeholder="Repeat your password"><br>
    <button type="submit">Submit</button>
    <a href="/login/user">Login</a>
</form>
</body>
</html>