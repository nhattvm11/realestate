<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 4/10/18
  Time: 3:02 PM
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
<spring:url var="editURL" value="/users/edit"/>
<form:form method="POST" action="${editURL}" modelAttribute="user" cssClass="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>User Profile</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput1">User ID</label>
            <div class="col-md-4">
                <form:input path="id" type="text" cssClass="form-control input-md" name="idUser" id="textinput1"  placeholder="Id" readonly="true"/>
                <form:errors path="id" cssClass="error"/>
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="textinput10">Contact ID</label>--%>
            <%--<div class="col-md-4">--%>
                <%--<form:input path="idContact" type="hidden" cssClass="form-control input-md" name="idUser" id="textinput10"  placeholder="Id" disabled="true"/>--%>
                <%--<form:errors path="idContact" cssClass="error"/>--%>
            <%--</div>--%>
        <%--</div>--%>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput2">Username</label>
            <div class="col-md-4">
                <form:input path="username" type="text" cssClass="form-control input-md" name="textinput" id="textinput2"  placeholder="Enter your Name" readonly="true"/>
                <form:errors path="username" cssClass="error"/>
            </div>
        </div>

                <!-- Text input-->
                <%--<div class="form-group">--%>
                    <%--<label class="col-md-4 control-label" for="textinput3">Email</label>--%>
                    <%--<div class="col-md-4">--%>
                        <%--<form:input path="email" type="email" cssClass="form-control input-md" name="textinput" id="textinput3"  placeholder="Enter your Email"/>--%>
                        <%--<form:errors path="email" cssClass="error"/>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput4">Address</label>
                    <div class="col-md-4">
                        <form:input path="address" type="text" cssClass="form-control input-md" name="textinput" id="textinput4"  placeholder="Enter your Address"/>
                        <form:errors path="address" cssClass="error"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput5">Phone number</label>
                    <div class="col-md-4">
                        <form:input path="phone" type="text" cssClass="form-control input-md" name="textinput" id="textinput5"  placeholder="Enter your Phone"/>
                        <form:errors path="phone" cssClass="error"/>
                    </div>
                </div>

                <!-- Button (Double) -->
                <spring:url var="noURL" value="/users/${user.id}"/>
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
