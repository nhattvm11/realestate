<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 4/5/18
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Website CSS style -->
    <link rel="stylesheet" href='<c:url value="/static/ckeditor/css/register.css"/>' type="text/css" media="all">
    <!-- Website Font style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row main">
<div class="main-login main-center">
<h5>Enter new password</h5>
    <div class="container">
        <div class="row main">
            <div class="main-login main-center">
                <h5>Enter new password</h5>
                <%--<form class="" method="post" action="/register">--%>
                <form:form method="POST" action="/realestate/api/v1/public/newpass" modelAttribute="user">
                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">New password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <%--<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>--%>
                                <form:input path="password" type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required="required"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <%--<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required/>--%>
                                <form:input path="confirmPassword" type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required="required"/>
                                <form:errors path="confirmPassword" cssClass="error"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <input type="submit" class="btn btn-success btn-lg btn-block login-button" value="Submit"/>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
