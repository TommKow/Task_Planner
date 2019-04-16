<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head></head>
<body>
<h1>Login</h1>
<form method="post" action="/login">
    <div class="form-group">
        <label for="username">Nazwa użytkownika</label>
        <input type="text" required name="username" id="username" class="form-control" placeholder="Podaj nazwę użytkownika"/>
    </div>
    <div class="form-group">
        <label for="password">Hasło</label>
        <input type="password" required name="password" id="password" class="form-control" placeholder="Podaj hasło"/>
    </div>
    <button class="btn btn-primary" type="submit">Zaloguj</button>
    <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
</form>
</body>
</html>
