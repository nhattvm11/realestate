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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/realestate/ckeditor/ckeditor.js"></script>
</head>
<body>
    <h2>Create Article</h2>

    <form:form method="post" modelAttribute="article" action="/realestate/article/create">

        Type <form:select path="typeId" items="${types}"/><br>
        <form:errors path="typeId"/>

        Property Type <form:select path="propertyId" items="${propertyTypes}"/><br>
        <form:errors path="propertyId"/>

        address <form:input path="address"/><br>
        <form:errors path="address"/>

        city <form:select path="cityId" items="${cities}" /><br>
        <form:errors path="cityId"/>

        District
        <div id="District">
            <select name="DistrictId">
                <option>--Select City--</option>
            </select>
        </div>
        <form:errors path="districtId"/>
        <br>

        Title <form:input path="title"/><br>
        <form:errors path="title"/>

        Area Size <form:input path="areasize" /><br>
        <form:errors path="areasize"/>

        BedRoom <form:input path="bedroom" /><br>
        <form:errors path="bedroom"/>

        BathRoom <form:input path="bathroom" /><br>
        <form:errors path="bathroom"/>

        LivingRoom <form:input path="livingroom" /><br>
        <form:errors path="livingroom"/>

        Tiers <form:input path="tier" /><br>
        <form:errors path="tier"/>

        Direction <form:select path="directionId" items="${directions}"/><br>
        <form:errors path="directionId"/>

        Price <form:input path="price" /><br>
        <form:errors path="price"/>

        Description <form:textarea path="description" /><br>
        <form:errors path="description"/>

        Feature <form:checkboxes element="li" path="features" items="${features}"/><br>

        <input type="submit" value="Create Article"/>
    </form:form>
</body>

<script type="text/javascript">

    $(document).ready(function () {
        $('#cityId').change(function () {
            $.ajax({
                type: "post",
                url: "/realestate/article/districts",
                data: { cityId: $('#cityId').val() },
                datatype: "json",
                traditional: true,
                success: function (data) {
                    var district = "<select id='districtId' name = 'districtId'>";
                    for (var i = 0; i < data.length; i++) {
                        district = district + '<option value=' + data[i].id + '>' + data[i].districtName + '</option>';
                    }
                    district = district + '</select>';
                    $('#District').html(district);
                }
            });
        });

        CKEDITOR.replace("description");
        $(function () {
            $('input[type="submit"]').click(function () {
                CKEDITOR.instances.Body.updateElement();
            });
        });
    });
</script>
</html>
