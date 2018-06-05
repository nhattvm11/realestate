<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 4/24/18
  Time: 3:45 PM
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
</head>
<body>
<spring:url var="createURL" value="/feature/create"/>
<spring:url var="deleteURL" value="/feature/delete/"/>

<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <a href="${createURL}" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new feature</a>
            <tr>
                <th>Name</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <c:forEach items="${features}" var="feature">
                <tr>
                    <spring:url var="deleteURL" value="/feature/delete/${feature.id}"/>
                    <spring:url var="editURL" value="/feature/delete/"/>
                    <td>${feature.featureName}</td>
                    <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="${deleteURL}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
