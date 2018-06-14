<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${pageContext.request.contextPath}/home" class="site_title"><i class="fa fa-paw"></i> <span>HOME</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_pic">
                <img data-cfsrc="images/img.jpg" alt="..." class="img-circle profile_img" style="display:none;visibility:hidden;"><noscript><img src="images/img.jpg" alt="..." class="img-circle profile_img"></noscript>
            </div>
            <div class="profile_info">
                <span>Hello </span>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>Dashboard</h3>
                <ul class="nav side-menu">
                    <c:choose>
                        <c:when test="${role=='admin'}">
                            <li>
                                <a><i class="fa fa-newspaper-o"></i>Article Manager <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/admin/article/list">List Articles</a></li>
                                    <li><a href="${pageContext.request.contextPath}/article/create">Create Article</a></li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a><i class="fa fa-newspaper-o"></i>Article Manager <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/article/list">List Articles</a></li>
                                    <li><a href="${pageContext.request.contextPath}/article/create">Create Article</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li>
                        <a><i class="fa fa-male"></i> Profile Manager <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${pageContext.request.contextPath}/users/contacts">List Contacts</a></li>
                            <li><a href="${pageContext.request.contextPath}/users/contact/create">Create Contact</a></li>
                            <li><a href="">Edit Profile</a></li>
                        </ul>
                    </li>

                    <c:choose>
                        <c:when test="${role=='admin'}">
                            <li>
                                <a><i class="fa fa-bolt"></i> Features <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/admin/features">List Features</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/feature/create">Create Feature</a></li>
                                </ul>
                            </li>

                            <li>
                                <a><i class="fa fa-database"></i> Properties <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/admin/properties">List Properties</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/property/create">Create Property</a></li>
                                </ul>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>


        </div>
        <!-- /sidebar menu -->
        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <spring:url var="logoutURL" value="/logout"/>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="${logoutURL}/logout">
            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img data-cfsrc="images/img.jpg" alt="" style="display:none;visibility:hidden;"><noscript><img src="images/img.jpg" alt=""></noscript>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="#"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>


                <c:choose>
                    <c:when test="${role=='admin'}">
                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green count">0</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">

                            </ul>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </nav>
    </div>
</div>

