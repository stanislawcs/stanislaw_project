<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO/Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
${message}<br>
<form method="post" action="/registration">
    <input type="text" name="name" placeholder="Input your name"><br>
    <input type="text" name="passportNumber" placeholder="Input your passport number"><br>
    <input type ="password" name="password" placeholder="Create your password"><br>
    <input type ="password" name ="repassword" placeholder="Repeat your password"><br>
    <button type="submit">Submit</button>
    <a href="/login">Login</a>
</form>
</body>
</html>