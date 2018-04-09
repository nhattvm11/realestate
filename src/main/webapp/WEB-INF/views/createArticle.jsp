<%--
  Created by IntelliJ IDEA.
  User: Anh
  Date: 4/9/2018
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>create Article</title>
</head>
<body>
    <h2>Create Article</h2>

    <form:form method="post" modelAttribute="article">

        Type <form:select path="typeId" items="${types}"/>

        Property Type <form:select path="propertyId" items="${propertyTypes}"/>

        address <form:input path="address"/>

        city <form:select path="cityId" items="${cities}" />

        Title <form:input path="title"/>

        Area Size <form:input path="areasize" />

        BedRoom <form:input path="bedroom" />

        BathRoom <form:input path="bathroom" />

        LivingRoom <form:input path="livingroom" />

        Tiers <form:input path="tier" />

        Direction <form:select path="directionId" items="${directions}"/>

        Price <form:input path="price" />

        Description <form:input path="description" />

        Feature <form:checkboxes element="li" path="features" items="${features}"/>

        <input type="submit" value="Create Article"/>
    </form:form>
</body>
</html>
