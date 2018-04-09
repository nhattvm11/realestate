<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 4/9/18
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        input.hidden {
            position: absolute;
            left: -9999px;
        }

        #profile-image1 {
            cursor: pointer;

            width: 100px;
            height: 100px;
            border:2px solid #03b1ce ;}
        .tital{ font-size:16px; font-weight:500;}
        .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}
    </style>
</head>
<body>
<c:set var="user" value="${user}" />
<div class="container">
    <div class="row">
        <div class="col-md-7 ">

            <div class="panel panel-default">
                <div class="panel-heading">  <h4 >User Profile</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">
                            <div class="col-sm-6">
                                <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive">

                                    <input id="profile-image-upload" class="hidden" type="file">
                                    <div style="color:#999;" >click here to change profile image</div>
                                    <!--Upload Image Js And Css-->




                                </div>

                                <br>

                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;">${user.username} </h4></span>
                                <span><p>${user.levelByLevelId}</p></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">

                            <c:forEach items="${user.contactsById}" var="contact">
                                <c:if test="${contact.mainContact}">
                                    <div class="col-sm-5 col-xs-6 tital " >Name:</div><div class="col-sm-7 col-xs-6 ">${contact.contactName}</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital " >Address:</div><div class="col-sm-7"> ${contact.address}</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital " >Email:</div><div class="col-sm-7"> ${contact.email}</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital " >Phone Number:</div><div class="col-sm-7">${contact.phone}</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital " >Date Of Joining:</div><div class="col-sm-7">${user.dateCreate}</div>
                                </c:if>
                            </c:forEach>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->

                    </div>


                </div>
            </div>
        </div>
        <script>
            $(function() {
                $('#profile-image1').on('click', function() {
                    $('#profile-image-upload').click();
                });
            });
        </script>









    </div>
</div>





</body>
</html>
