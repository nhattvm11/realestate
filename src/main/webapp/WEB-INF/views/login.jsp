<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 1/10/18
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href='/realestate/ckeditor/css/login.css' type="text/css" >
</head>
<body>

<div class="container">
    <div class="row">

        <div class="pen-title">
            <h1>Login Form</h1>
        </div>
        <div class="container">
            <div class="card"></div>
            <div class="card">
                <h1 class="title">Login</h1>

                <spring:url var="loginURL" value="/login"/>
                <form method="post" action="${loginURL}">
                    <div class="input-container">
                        <input type="text" id="Username" name="username" required="required"/>
                        <label for="Username">Username</label>
                        <div class="bar"></div>
                    </div>
                    <div class="input-container">
                        <input type="password" id="Password" name="password" required="required"/>
                        <label for="Password">Password</label>
                        <div class="bar"></div>
                    </div>
                    <div class="button-container">
                        <button type="submit"><span>Go</span></button>
                    </div>
                    <div class="footer"><a href="#">Forgot your password?</a></div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
