<%--
  Created by IntelliJ IDEA.
  User: Stanislaw
  Date: 24.04.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSO/Objects</title>
</head>
<body>
<c:if test="${role!='USER'}">
    <a href="/guard/${guardId}">
        Профиль
    </a><br>
</c:if>
<a href="https://www.citymoscow.ru/">
    Москва Сити
</a>

</body>
</html>
