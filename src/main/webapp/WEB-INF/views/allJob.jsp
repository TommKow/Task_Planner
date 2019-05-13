<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<html>
<head>
    <title>allJob</title>
</head>
<body>


<a class="btn btn-primary" href="/job/add" role="button">Add Job</a>
<a class="btn btn-primary" href="/user/admin" role="button">ADMIN Panel</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NAME</th>
        <th scope="col">ACCOUNT</th>
    </tr>
    </thead>
    <tr>
        <c:forEach items="${jobs}" var="job">
    <tr>

        <th scope="row">${job.id}</th>
        <td>${job.name}</td>
        <td>${job.account}</td>

        <td><a class="btn btn-primary" href="/job/edit/${job.id}" role="button">Edit</a></td>
        <td><a class="btn btn-primary" href="/job/delete/${job.id}" role="button" onclick="if (!(confirm('Czy napewno ?'))) return false" >Delete</a></td>
    </tr>
    </c:forEach><br>



</table>
</body>
</html>
