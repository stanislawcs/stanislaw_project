<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userId==null}">
    <:redirect url="/registration/user"/>
</c:if>

<html>
<head>
    <link href="../css/style.css"  rel="stylesheet"/>
    <Title>
        SSO/User/HomePage
    </Title>
</head>

<body>

<a href="/guards/user">
    Список охранников
</a>

<a href="/settings/user">
    Настройки
</a>
<a href="/logout/user">
    Выход
</a>
<br>

    <div class="user-photo">
        <img src="../${image}" alt="user-photo"/><br>
    </div>





<br>${username}<br>

<c:if test="${ThisIsYou == true}">
    This is main user page
</c:if>

<c:if test="${ThisIsYou == false}">
    This is not main user page
</c:if>

</body>
</html>