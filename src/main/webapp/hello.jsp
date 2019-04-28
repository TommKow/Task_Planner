<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
