<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jobsPlanner</title>
</head>
<body>

    <a class="btn btn-primary" href="/jobplanner/add" role="button">Add Job Planner</a>
    <a class="btn btn-primary" href="/user/logged" role="button">User Panel</a>
    <a class="btn btn-primary" href="/jobplanner/all/1" role="button">Builders</a>
    <a class="btn btn-primary" href="/jobplanner/all/2" role="button">Electrics</a>
    <a class="btn btn-primary" href="/jobplanner/all/3" role="button">Instalers</a>
    <a class="btn btn-primary" href="/jobplanner/all" role="button">All</a>


<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">TEAM</th>
        <th scope="col">DATE</th>
        <th scope="col">EMPLOYEE</th>
        <th scope="col">LOCALIZATION</th>
        <th scope="col">DESCRIPTION</th>
        <th scope="col">JOB</th>
        <th scope="col">WORK QUANTITY</th>
    </tr>
    </thead>
    <tr>
        <c:forEach items="${jobplanners}" var="job">
    <tr>

        <th scope="row">${job.id}</th>
        <td>${job.team}</td>
        <td>${job.created}</td>
        <td>${job.employees}</td>
        <td>${job.localizations}</td>
        <td>${job.description}</td>
        <td>${job.job}</td>
        <td>${job.workQuantity}</td>

        <td><a class="btn btn-primary" href="" role="button">Generuj Zlecenie</a></td>

    </tr>
    </c:forEach><br>
    <tr>
        <c:forEach items="${jobPlannerByTeam}" var="job">
    <tr>

        <th scope="row">${job.id}</th>
        <td>${job.team}</td>
        <td>${job.created}</td>
        <td>${job.employees}</td>
        <td>${job.localizations}</td>
        <td>${job.description}</td>
        <td>${job.job}</td>
        <td>${job.workQuantity}</td>

        <td><a class="btn btn-primary" href="" role="button">Generuj Zlecenie</a></td>

    </tr>
    </c:forEach><br>



</table>
</body>
</html>