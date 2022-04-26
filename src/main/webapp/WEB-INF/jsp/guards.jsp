<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${guardId == null}||${userId == null}">
    <c:redirect url="/registration"/>
</c:if>

<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${role!='USER'}">
    <a href="/guard/${guardId}">
        Профиль
    </a>
    <br>
    <form method="post" action="/guards">
        <input type="text" name="search"/>
        <button type="submit">Найти</button>
    </form><br><br>


    <c:forEach items="${guardsList}" var="guard">


        <c:if test="${guardId != guard.id}">
            <a href="/guard/${guard.id}">
                    ${guard.name} <br>
            </a>
        </c:if>

    </c:forEach>
</c:if>




</body>
</html>