<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${guardId == null}">
    <:redirect url="/registration"/>
</c:if>

<html>
<head>
    <link href="../css/style.css"  rel="stylesheet"/>
    <title>SSO/HomePage</title>
</head>
<body>

<a href="/guards">
    Список охранников
</a>

<c:if test="${role == 'ADMIN'}">
    <a href="/admin">
        Админ панель
   </a>
</c:if>

 <a href="/settings">
        Настройки
    </a>
<a href="/objects">
    Список объектов
</a>

<a href="/logout">
Выход
</a>


<br> ${name} <br>


    <div class="guard-photo">
        <img src="../${img}" alt="guard-photo"/><br>
    </div>




<c:if test="${ThisIsMainGuard == true}">
    This is main guard page
</c:if>

<c:if test="${ThisIsMainGuard == false}">
    This is not main guard page
</c:if>

</body>
</html>