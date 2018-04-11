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
        <div>${errors.typeId}</div>

        Property Type <form:select path="propertyId" items="${propertyTypes}"/><br>
        <div>${errors.propertyId}</div>

        address <form:input path="address"/><br>
        <div>${errors.address}</div>


        city <form:select path="cityId" items="${cities}" /><br>
        <div>${errors.cityId}</div>

        District
        <div id="District">
            <select name="DistrictId">
                <option>--Select City--</option>
            </select>
        </div>
        <div>${errors.districtId}</div>
        <br>

        Title <form:input path="title"/><br>
        <div>${errors.title}</div>

        Area Size <form:input path="areasize" /><br>
        <div>${errors.areasize}</div>

        BedRoom <form:input path="bedroom" /><br>
        <div>${errors.bedroom}</div>

        BathRoom <form:input path="bathroom" /><br>
        <div>${errors.bathroom}</div>

        LivingRoom <form:input path="livingroom" /><br>
        <div>${errors.livingroom}</div>

        Tiers <form:input path="tier" /><br>
        <div>${errors.tier}</div>

        Direction <form:select path="directionId" items="${directions}"/><br>
        <div>${errors.directionId}</div>

        Price <form:input path="price" /><br>
        <div>${errors.price}</div>

        Description <form:textarea path="description" /><br>
        <div>${errors.description}</div>

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
