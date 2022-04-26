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


  <a href="/user/${userId}">
    Профиль
  </a><br>


  <c:forEach items="${guardsList}" var="guard">
    <a href="/guards/${guard.id}">
        ${guard.name} <br>
    </a>

  </c:forEach>




</body>
</html>
