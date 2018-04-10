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
    <link rel="stylesheet" href='<c:url value="/WEB-INF/resources/css/editProfile.css"/>' type="text/css">
</head>
<body>
<div id="sc-edprofile">
    <h1>Edit Profile Form</h1>
    <div class="sc-container">
        <input type="text" placeholder="Username" />
        <input type="text" placeholder="Email Address" />
        <input type="password" placeholder="Password" />
        <input type="text" placeholder="Website" />
        <input type="text" placeholder="First Name" />
        <input type="text" placeholder="Last Name" />
        <textarea placeholder="Bio" /></textarea>
        <select>
            <option value="">Male</option>
            <option value="">Female</option>
        </select>
        <input type="text" placeholder="Facebook Profile URL" />
        <input type="text" placeholder="Twitter Profile URL" />
        <input type="text" placeholder="Google+ Profile URL" />
        <input type="text" placeholder="LinkedIn Profile URL" />
        <input type="submit" value="Register" />
    </div>
</div>
</body>
</html>
