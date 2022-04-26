<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userId == null}">
    <:redirect url="/registration/user"/>
</c:if>

<html>
<head>
    <title>SSO</title>
</head>
<body>

<form method="post" action="/add-photo/user" enctype="multipart/form-data">
    Выберите фото профиля<br>
    <input type="file" name="image">
    <button type="submit">Загрузить</button>
</form>

</body>
</html>
