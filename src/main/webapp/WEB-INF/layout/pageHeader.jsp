<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jBar">
    <div class="container">
        <div class="row">
            <form>
                <div class="col-md-2">
                    <h1>Login Area</h1>
                </div>

                <div class="col-md-4">
                    <input type="text" name="log" placeholder="Your Account Id" required>
                </div>

                <div class="col-md-3">
                    <input type="password" name="pwd" placeholder="Your Password">
                </div>

                <div class="col-md-3">
                    <input type="submit" class="botton" value="Sign in">
                    <span>Or</span>
                    <input type="button" class="botton" value="Register">
                </div>

                <input type="hidden" name="redirect_to" value="/fullestate/" />

                <p class="jTrigger downarrow">Close Login</p>
            </form>
        </div>
    </div>
</div>
<span class="jRibbon jTrigger up">Login</span>

<section class="info_head">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul>
                    <li>
                        <a href="#">
                            <i class="icon-headphones" style="color: #232323; font-size: 13px;"></i>01800034567
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="icon-comment" style="color: #232323; font-size: 13px;"></i>Live chat
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="icon-beaker" style="color: #232323; font-size: 13px;"></i>Contact
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>

<nav>
    <div class="container">
        <div class="row">
            <!-- Logo-->
            <div class="col-md-3">
                <div class="logo">
                    <a style="color: #ffffff; font-style: normal; font-family: arial; font-size: 30px;  top:-5px;" href="${pageContext.request.contextPath}/home">

                        <img src="/realestate/Content/fullestate/wp-content/uploads/2015/03/logo.png" alt="Logo" class="logo_img" />

                    </a>
                </div>
            </div>
            <!-- End Logo-->
            <!-- Menu-->
            <div class="col-md-9">
                <div class="menu-main-menu-container">
                    <ul id="menu" class="sf-menu">
                        <li id="menu-item-1430" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1430">
                            <a href="#">Rent</a>
                            <ul class="sub-menu">
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/rent-apartment">Apartment</a></li>
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/rent-land">Land</a></li>
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/rent-house">House</a></li>
                            </ul>
                        </li>
                        <li id="menu-item-1437" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1437">
                            <a href="#">Sale</a>
                            <ul class="sub-menu">
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/sale-apartment">Apartment</a></li>
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/sale-land">Land</a></li>
                                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="${pageContext.request.contextPath}/article/sale-house">House</a></li>
                            </ul>
                        </li>
                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1642"><a href="">About</a></li>

                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1642"><a href="">Contact</a></li>

                        <c:choose>
                            <c:when test="${role=='user'}">
                                <li id="menu-item-1433" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1433">
                                    <a href="#">Accout</a>
                                    <ul class="sub-menu">
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1641"><a href="${pageContext.request.contextPath}/article/list">Manager</a></li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1640"><a>Change Password</a></li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1639"><a>Logout</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:when test="${role=='admin'}">
                                <li id="menu-item-1433" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1433">
                                    <a href="#">Accout</a>
                                    <ul class="sub-menu">
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1641"><a href="${pageContext.request.contextPath}/admin/article/list">Manager</a></li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1640"><a>Change Password</a></li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1639"><a>Logout</a></li>
                                    </ul>
                                </li>
                            </c:when>

                        </c:choose>

                    </ul>
                </div>
            </div>
            <!-- End Menu-->
        </div>
    </div>
</nav>
