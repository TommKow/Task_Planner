<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 14.04.19
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HEllO</title>
</head>
<body>
        <p>HELLO !!!!!!!!</p>
        <c:forEach items="${userDto}" var="user">
            ${user.username}
        </c:forEach>
            ${userDto.username}
</body>
</html>
