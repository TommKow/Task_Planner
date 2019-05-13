<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userLocalization</title>
</head>
<body>
        <a class="btn btn-primary" href="/user/logged" role="button">User Panel</a>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">ACCOUNT</th>
            </tr>
            </thead>
            <tr>
                <c:forEach items="${localizations}" var="localization">
            <tr>

                <th scope="row">${localization.id}</th>
                <td>${localization.name}</td>
                <td>${localization.account}</td>

                <td><a class="btn btn-primary" href="/localization/findjob/${localization.id}" role="button">Show Job</a></td>
                <td><a class="btn btn-primary" href="/localization/findjob/${localization.id}" role="button">Show WorkQ</a></td>
            </tr>
            </c:forEach><br>



        <%--<div class="form-group row">--%>
            <%--<form:label path="localization" class="col-sm-3 col-form-label">Localization</form:label>--%>
            <%--<div class="col-sm-6">--%>
                <%--<form:select path="localization" cssClass="custom-select" id="inputGroupSelect02">--%>
                    <%--<form:option value="-1" label="--Please Select--"/>--%>
                    <%--<form:options items="${localizations}" itemValue="id" itemLabel="name"/>--%>
                <%--</form:select>--%>
                <%--<button type="submit" class="btn btn-primary">FIND</button>--%>
            <%--</div>--%>
        <%--</div>--%>
</body>
</html>
