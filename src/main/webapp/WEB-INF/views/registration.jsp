
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 40px">
        <div class="col-1"></div>
        <div class="col-10" style="padding-bottom: 20px"><h2>Rejestracja</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-6">
            <form:form modelAttribute="registrationForm" method="post">
                <div class="form-group">

                </div>
                <div class="form-group">
                    <form:label path="username">Nazwa uzytkownika </form:label>
                    <form:input path="username" required="true" class="form-control"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="form-group">
                <form:label path="password">Hasło</form:label>
                <form:input path="password" required="true" class="form-control"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                <form:label path="firstName">Imię</form:label>
                <form:input path="firstName" required="true" class="form-control"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
                <div class="form-group">
                <form:label path="lastName">Nazwisko</form:label>
                <form:input path="lastName" required="true" class="form-control"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>


                <button class="btn btn-primary" type="submit">Zarejestruj</button>
                <button class="btn btn-secondary" type="reset">Wyczyść dane</button>

            </form:form>
        </div>
        <div class="col-5"></div>
    </div>
</div>
</body>
</html>

