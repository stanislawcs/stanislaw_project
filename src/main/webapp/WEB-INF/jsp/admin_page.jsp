<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/guard/${guardId}">
    Профиль
</a>

<a href="/admin/add-guard">
    Добавить сотрудника
</a>

<br><br>

<c:forEach items="${guardsList}" var="securityGuard">

        <a href="/guard/${securityGuard.id}">
                ${securityGuard.name}
        </a>

        <form action="/admin-action" method="post">
                        <button type="submit" name="adminActionButton" value="DELETE ${securityGuard.id}">Delete</button>
                        </form>

        </c:forEach>





    </html>
