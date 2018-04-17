<%--
  Created by IntelliJ IDEA.
  User: Anh
  Date: 4/11/2018
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <script type="text/javascript" src="/realestate/ckeditor/ckeditor.js"></script>

    <link href="/realestate/Content/polygon/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/realestate/Content/polygon/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/realestate/Content/polygon/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="/realestate/Content/polygon/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="/realestate/Content/polygon/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/realestate/Content/polygon/build/css/custom.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css"
          href='/realestate/css/dropzone.css'>

    <%--<script src="/realestate/Content/jquery-1.10.2.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <!-- Bootstrap -->
    <script src="/realestate/Content/polygon/vendors/bootstrap/dist/js/bootstrap.min.js"></script>


</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <tiles:insertAttribute name="header" />
        <!-- /top navigation -->
        <!-- page content -->
        <div class="right_col" role="main">
            <tiles:insertAttribute name="body" />
        </div>
        <!-- /page content -->
        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>
<script src="/realestate/Content/polygon/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/realestate/Content/polygon/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="/realestate/Content/polygon/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- jQuery Sparklines -->
<script src="/realestate/Content/polygon/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- morris.js -->
<script src="/realestate/Content/polygon/vendors/raphael/raphael.min.js"></script>
<script src="/realestate/Content/polygon/vendors/morris.js/morris.min.js"></script>
<!-- gauge.js -->
<script src="/realestate/Content/polygon/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="/realestate/Content/polygon/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- Skycons -->
<script src="/realestate/Content/polygon/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="/realestate/Content/polygon/vendors/Flot/jquery.flot.js"></script>
<script src="/realestate/Content/polygon/vendors/Flot/jquery.flot.pie.js"></script>
<script src="/realestate/Content/polygon/vendors/Flot/jquery.flot.time.js"></script>
<script src="/realestate/Content/polygon/vendors/Flot/jquery.flot.stack.js"></script>
<script src="/realestate/Content/polygon/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="/realestate/Content/polygon/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="/realestate/Content/polygon/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="/realestate/Content/polygon/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="/realestate/Content/polygon/vendors/DateJS/build/date.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/realestate/Content/polygon/vendors/moment/min/moment.min.js"></script>
<script src="/realestate/Content/polygon/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="/realestate/Content/polygon/build/js/custom.min.js"></script>


<script type="text/javascript"
        src='/realestate/js/dropzone.js'></script>
<script type="text/javascript"
        src='/realestate/js/app.js'></script>

</body>

</html>
