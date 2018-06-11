<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 6/7/18
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Something went wrong</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<spring:url var="home" value="/home"/>
<div class="container">
    <div class="jumbotron">
        <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#d9534f;"></i></div>
        <h1 class="text-center">Sorry, Something went wrong<p> </p><p><small class="text-center"> Oh noes everything broke</small></p></h1>
        <p class="text-center">Try pressing the back button or clicking on this button.</p>
        <p class="text-center"><a class="btn btn-primary" href="${home}"><i class="fa fa-home"></i> Take Me Home</a></p>
    </div>
</div>
</body>
</html>
