<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addEmployee</title>
</head>
<body>
<div class="container">
    <div class="row" style="">
        <div class="col-1"></div>
        <div class="col-10" style=""><h2>ADD EMPLOYEE</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row" style="">
        <div class="col-1"></div>
        <div class="col-8">
        <form:form method="post" modelAttribute="employeeDto">
            <div class="form-group row">
                <form:label path="firstName" class="col-sm-3 col-form-label">Name</form:label>
                <div class="col-sm-6">
                    <form:input path="firstName" class="form-control"  placeholder="First Name"/>
                    <form:errors path="*" cssClass="error"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="lastName" class="col-sm-3 col-form-label">Last Name</form:label>
                <div class="col-sm-6">
                    <form:input path="lastName" placeholder="Last Name"/>
                </div>
            </div>

            <div class="form-group row">
            <form:label path="address" class="col-sm-3 col-form-label">Address</form:label>
                <div class="col-sm-6">
            <form:input path="address" placeholder="Address"/>
                </div>
            </div>
            <div class="form-group row">
            <form:label path="phoneNumber" class="col-sm-3 col-form-label">Phone Number</form:label>
                <div class="col-sm-6">
            <form:input path="phoneNumber" placeholder="Phone Number"/><br>
                </div>
            </div>
            <div class="form-group row">
            <form:label path="salaryPm" class="col-sm-3 col-form-label">Salary Per Month</form:label>
                <div class="col-sm-6">
            <form:input path="salaryPm" placeholder="Salary"/><br>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">ADD EMPLOYEE</button>
                </div>
            </div>
        </form:form>
            <div class="col-1"></div>
        </div>
    </div>
</div>
</body>
</html>