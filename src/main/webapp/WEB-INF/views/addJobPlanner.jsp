<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<html>
<head>
    <title>addJobPlanner</title>
</head>
<body>
<div class="container">
    <div class="row" style="">
        <div class="col-1"></div>
        <div class="col-10" style=""><h2>ADD JOB</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row" style="">
        <div class="col-1"></div>
        <div class="col-8">
            <form:form method="post" modelAttribute="jobPlanner">
                <div class="form-group row">
                    <form:label path="created" class="col-sm-3 col-form-label">Date</form:label>
                    <div class="col-sm-6">
                        <form:input path="created" placeholder="${LocalDateTime.now()}" readonly="true"/>
                    </div>
                </div>
                <div class="form-group row">
                    <form:label path="team" class="col-sm-3 col-form-label">Teams</form:label>
                    <div class="col-sm-6">
                        <form:select path="team" cssClass="custom-select" id="inputGroupSelect02">
                            <form:option value="-1" label="--Please Select--"/>
                            <form:options items="${teams}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="employees" class="col-sm-3 col-form-label">Employees</form:label>
                    <div class="col-sm-6">
                        <script>
                        $(document).ready(function () {
                        $('.mdb-select').multiEntry();
                        });
                        </script>
                    <form:select path="employees" cssClass="mdb-select colorful-select dropdown-primary md-form" multiple="multiple">

                        <form:option value="-1" label="--Please Select--"/>
                        <form:options items="${employees}" itemValue="id" itemLabel="firstName"/>

                    </form:select>
                        <button class="btn-save btn btn-primary btn-sm">add Employee</button>
                    </div>
                </div>
                <div class="form-group row">
                    <form:label path="localizations" class="col-sm-3 col-form-label">Localizations</form:label>
                    <div class="col-sm-6">
                        <form:select path="localizations">
                            <form:option value="-1" label="--Please Select--"/>
                            <form:options items="${localizations}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <form:label path="job" class="col-sm-3 col-form-label">Jobs</form:label>
                    <div class="col-sm-6">
                        <form:select path="job">
                            <form:option value="-1" label="--Please Select--"/>
                            <form:options items="${jobs}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:input path="workQuantity" type="number"/>
                    </div>
                </div>
                <div class="form-group row">
                    <form:label path="description" class="col-sm-3 col-form-label">Description</form:label>
                    <div class="col-sm-6">
                        <form:input path="description" placeholder="Description"/>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">ADD JOB</button>
                    </div>
                </div>
            </form:form>
            <div class="col-1"></div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="app.js"></script>
</body>

</html>
