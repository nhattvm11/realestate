<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 4/24/18
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        a {
            text-decoration: none;
            color: #fff;
        }

        a:hover {
            text-decoration: none;
            color: #fff;
        }
    </style>
</head>
<body>
<spring:url var="createURL" value="/feature/create"/>
<form:form method="POST" action="${createURL}" modelAttribute="feature" cssClass="form-horizontal">
    <fieldset>

    <!-- Form Name -->
    <legend>Create feature</legend>

    <div class="form-group">
        <label class="col-md-4 control-label" for="textinput2">Feature name</label>
        <div class="col-md-4">
            <form:input path="featureName" type="text" cssClass="form-control input-md" name="textinput" id="textinput2"  placeholder="Enter feature Name" />
            <form:errors path="featureName" cssClass="error"/>
        </div>
    </div>

        <spring:url var="noURL" value="/features"/>
        <div class="form-group">
            <label class="col-md-4 control-label" for="btnsave">Save Changes</label>
            <div class="col-md-8">
                <input type="submit" id="btnsave" name="btnsave" class="btn btn-success" value="Yes"/>
                <button id="btncancel" name="btncancel" class="btn btn-danger"><a href="${noURL}">No</a></button>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
