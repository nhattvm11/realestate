<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 5/8/18
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:url var="payURL" value="/pay"/>
<form method="post" action="${payURL}">
    <button type="submit"> Process Payment </button>
</form>
</body>
</html>
