<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<html>
<head>
    <title>userLocalizationByJob</title>
</head>
<body>
<div class="container">
    <div class="row" style="">
        <div class="col-1"></div>
        <%--<div class="col-10" style=""><h2>LOCALIZATION :  ${localization.name}</h2></div>--%>
        <div class="col-1"></div>
    </div>
    <div class="row" style="">
        <div class="col-1"></div>
        <a class="btn btn-primary" href="/user/logged" role="button">User Panel</a>
        <div class="col-8">
<table>


            <tr>

                <c:forEach items="${localizationByJob}" var="job">
                    <tr>
                    <th scope="row">${job.id}</th>
                    <td>${job.name}</td>
                </c:forEach><br>

            <h3>Sum of work quantity on localization ${localization.name} = ${localizationByWorkQ} r-g</h3>

            </tr>
            </tr>
</table>
            <div class="col-1"></div>
        </div>
    </div>
</div>
</body>
</html>
