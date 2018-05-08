<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="/realestate/js/lightbox-plus-jquery.min.js"></script>
<div class="section_title" style="background-image: url('${pageContext.request.contextPath}${article.thumbnail}'); background-position: 40% 6px;">
    <div class="container">
        <div class="row">
            <div class="col-md-12" style="width: auto !important;">
                <h1>
                    ${article.title}
                    <span><a href="/realestate/home">Home </a> / ${article.title}</span>
                </h1>
            </div>
        </div>
    </div>
</div>
<div class="content_info">

    <div class="newsletter_box">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h3>
                        STAY INFORMED<span>- Lorem ipsum dolor sit amet, consectetuer adipiscing elit Lorem ipsum.</span>
                    </h3>
                </div>

                <div class="col-md-4">
                    <div>
                        <div class="widget-area" role="complementary">
                            <div id="mailchimpsf_widget-2" class="widget widget_mailchimpsf_widget">
                                <h2>Sign up for list1</h2>
                                <style>
                                    .widget_mailchimpsf_widget .widget-title {
                                        line-height: 1.4em;
                                        margin-bottom: 0.75em;
                                    }

                                    #mc_subheader {
                                        line-height: 1.25em;
                                        margin-bottom: 18px;
                                    }

                                    .mc_merge_var {
                                        margin-bottom: 1.0em;
                                    }

                                    .mc_var_label,
                                    .mc_interest_label {
                                        display: block;
                                        margin-bottom: 0.5em;
                                    }

                                    .mc_input {
                                        -moz-box-sizing: border-box;
                                        -webkit-box-sizing: border-box;
                                        box-sizing: border-box;
                                        width: 100%;
                                    }

                                    .mc_input.mc_phone {
                                        width: auto;
                                    }

                                    .hover_property_h img{
                                        height: 100%;
                                    }

                                    select.mc_select {
                                        margin-top: 0.5em;
                                        width: 100%;
                                    }

                                    .mc_address_label {
                                        margin-top: 1.0em;
                                        margin-bottom: 0.5em;
                                        display: block;
                                    }

                                    .mc_address_label ~ select {
                                        width: 100%;
                                    }

                                    .mc_list li {
                                        list-style: none;
                                        background: none !important;
                                    }

                                    .mc_interests_header {
                                        margin-top: 1.0em;
                                        margin-bottom: 0.5em;
                                    }

                                    .mc_interest label,
                                    .mc_interest input {
                                        margin-bottom: 0.4em;
                                    }

                                    #mc_signup_submit {
                                        margin-top: 1.5em;
                                        width: 80%;
                                    }

                                    #mc_unsub_link a {
                                        font-size: 0.75em;
                                    }

                                    #mc_unsub_link {
                                        margin-top: 1.0em;
                                    }

                                    .mc_header_address,
                                    .mc_email_format {
                                        display: block;
                                        font-weight: bold;
                                        margin-top: 1.0em;
                                        margin-bottom: 0.5em;
                                    }

                                    .mc_email_options {
                                        margin-top: 0.5em;
                                    }

                                    .mc_email_type {
                                        padding-left: 4px;
                                    }
                                </style>

                                <div id="mc_signup">
                                    <form method="post" action="#mc_signup" id="mc_signup_form">
                                        <input type="hidden" id="mc_submit_type" name="mc_submit_type" value="html" />
                                        <input type="hidden" name="mcsf_action" value="mc_submit_signup_form" />
                                        <input type="hidden" id="_mc_submit_signup_form_nonce" name="_mc_submit_signup_form_nonce" value="f0abad1987" />

                                        <div class="mc_form_inside">

                                            <div class="updated" id="mc_message">
                                            </div>
                                            <!-- /mc_message -->

                                            <div class="mc_merge_var">
                                                <label for="mc_mv_EMAIL" class="mc_var_label mc_header mc_header_email">Email Address</label>
                                                <input type="text" size="18" placeholder="" name="mc_mv_EMAIL" id="mc_mv_EMAIL" class="mc_input" />
                                            </div>
                                            <!-- /mc_merge_var -->
                                            <div class="mc_signup_submit">
                                                <input type="submit" name="mc_signup_submit" id="mc_signup_submit" value="Subscribe" class="button" />
                                            </div>
                                            <!-- /mc_signup_submit -->

                                            <br />
                                            <div id="mc_display_rewards" align="center">
                                                powered by <a href="http://www.mailchimp.com/affiliates/?aid=f174eb3741769728b51bf9721&#038;afl=1">MailChimp</a>!
                                            </div>
                                            <!-- /mc_display_rewards -->

                                        </div>
                                        <!-- /mc_form_inside -->
                                    </form>
                                    <!-- /mc_signup_form -->
                                </div>
                                <!-- /mc_signup_container -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">


        <div class="row paddings">

            <div class="row">
                <div class="container" style="padding-left: 100px; padding-right: 100px">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <c:forEach begin="0" end="${article.pictures.size()-1}" varStatus="loop">
                                <c:choose>
                                    <c:when test="${loop.index == 0}">
                                        <li data-target="#myCarousel" data-slide-to="${loop.index}" class="active"></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li data-target="#myCarousel" data-slide-to="${loop.index}"></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" style="height: 500px">
                            <c:forEach begin="0" end="${article.pictures.size()-1}" varStatus="loop">
                                <c:choose>
                                    <c:when test="${loop.index == 0}">
                                        <div class="item active" style="height: 100%">
                                            <img class="example-image" src="${pageContext.request.contextPath}${article.pictures.get(loop.index).url}" alt="img" style="width:100%; height: 100%">
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="item" style="height: 100%">
                                            <img class="example-image" src="${pageContext.request.contextPath}${article.pictures.get(loop.index).url}" alt="img" style="width:100%; height: 100%">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-left: 15px; margin-right: 15px">
                <link rel="stylesheet" href="/realestate/Content/lightbox.min.css">
                <section>

                    <style type="text/css">
                        .example-image-link img {
                            width: 100%;
                            height: 200px;
                        }

                        div.scrollmenu {
                            background-color: #333;
                            overflow: auto;
                            white-space: nowrap;
                            height: 250px;
                        }

                        div.scrollmenu a {
                            display: inline-block;
                            color: white;
                            text-align: center;
                            padding: 14px;
                            text-decoration: none;
                        }

                        div.scrollmenu a:hover {
                            background-color: #777;
                        }
                    </style>
                    <div>
                        <div class="scrollmenu">
                            <c:forEach var="pic" items="${article.pictures}">
                                <a class="example-image-link" href="${pageContext.request.contextPath}${pic.url}" data-lightbox="example-set" data-title="" style="width: 300px">
                                    <img class="example-image" src="${pageContext.request.contextPath}${pic.url}" alt="" />
                                </a>
                            </c:forEach>
                        </div>

                    </div>
                </section>
            </div>

        </div>

        <div class="row">
            <div class="col-md-12">

                <!--NAV TABS-->
                <ul class="tabs">
                    <li><a href="#tab1">More Details</a></li>
                    <li><a href="#tab2">Contact Agent</a></li>
                    <li><a href="#tab3">Comments</a></li>
                </ul>

                <!--CONTAINER TABS-->
                <div class="tab_container">
                    <!--Tab1 Genral info-->
                    <div id="tab1" class="tab_content">
                        <div class="row">
                            <div class="col-md-6">

                                <h4>General Features</h4>
                                <div class="row">
                                    <c:forEach items="${features.keySet()}" var="ft">
                                    <div class="col-md-4">
                                        <ul class="general_info">
                                            <li>
                                                <c:choose>
                                                    <c:when test="${features.get(ft)}">
                                                        <i class="icon-ok"></i>${ft}
                                                    </c:when>

                                                    <c:otherwise>
                                                        <i class="icon-remove"></i>${ft}
                                                    </c:otherwise>
                                                </c:choose>
                                            </li>
                                        </ul>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="col-md-6">
                                ${article.description}
                            </div>
                        </div>

                        <!-- Divisor-->
                        <div class="divisor margins">
                            <div class="circle_left"></div>
                            <div class="circle_right"></div>
                        </div>
                        <!-- End Divisor-->

                        <div class="row">
                            <div class="col-md-12">
                                <div class="map_area">
                                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEUhgpaRslz8IddVuYTz5miCWWTS_caiI" async="" defer="defer" type="text/javascript"></script>
                                    <div class="acf-map">
                                        <div class="marker" data-lat="${coordinate[0]}" data-lng="${coordinate[1]}"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Tab1 Genral info-->
                    <!--Tab2 Contact Agent-->
                    <div id="tab2" class="tab_content">
                        <div class="row">
                            <div class="col-md-7">
                                <h4>Contact Agent</h4>
                                <form id="form" action="/fullestate/wp-content/themes/fullestate/js/agent-contact/send_mail.php">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <input type="text" placeholder="Your Name" name="Name" required>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="email" placeholder="Your Email" name="Email" required>
                                        </div>
                                    </div>
                                    <textarea placeholder="Your Message..." name="message"></textarea>

                                    <input type="hidden" name="from" value="jd@iwthemes.com">
                                    <input type="hidden" name="location" value="Chicago City 639">
                                    <input class="button" type="submit" value="Send Message" name="Submit">
                                </form>
                                <div class="result"></div>
                            </div>
                            <div class="col-md-5">
                                <div class="row item_agent">
                                    <div class="col-md-6 image_agent">
                                        <img src="/realestate/Content/fullestate/wp-content/uploads/2014/11/1.jpg" alt="George Frurt">
                                    </div>
                                    <div class="col-md-6 info_agent">
                                        <h5>@Model.Contact.ContactName</h5>
                                        <ul>
                                            <li>
                                                <i class="icon-envelope"></i>
                                                <a href="#" target="_self">
                                                    @Model.Contact.Email
                                                </a>
                                            </li>
                                            <li>
                                                <i class="icon-mobile-phone"></i>
                                                <a href="#" target="_self">
                                                    @Model.Contact.Phone
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Tab2 Contact Agent-->
                    <!--Tab3 Map-->
                    <!--Tab3 commnets-->
                    <div id="tab3" class="tab_content">

                        <!-- If comments are open, but there are no comments. -->
                        <script>
                            (function (d, s, id) {
                                var js, fjs = d.getElementsByTagName(s)[0];
                                if (d.getElementById(id)) return;
                                js = d.createElement(s); js.id = id;
                                js.src = "https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.12&appId=224991638234719&autoLogAppEvents=1";
                                fjs.parentNode.insertBefore(js, fjs);
                            }(document, 'script', 'facebook-jssdk'));</script>
                        <div id="fb-root"></div>
                        <div class="fb-comments" data-href="https://realestate.com/${article.id}" data-width="1096" data-numposts="10"></div>
                    </div>
                    <!--End Tab3 commnets-->

                </div>
                <!--END CONTAINER TABS-->
            </div>
        </div>


        <div class="row paddings">
            <div class="col-md-12">
                <!-- Content Carousel Properties -->
                <div class="content-carousel">

                    <!-- Title-->
                    <div class="titles">
                        <span>RECENTS</span>
                        <br>
                        <h1>CAROUSEL PROPERTIES</h1>
                    </div>
                    <!-- End Title-->
                    <!-- Carousel Properties -->
                    <div id="properties-carousel" class="properties-carousel">
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/boston-city-huert/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/10.jpg" alt="Image">
                                    <h5>Boston City Huert</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$250000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/miami-city-gart/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/9.jpg" alt="Image">
                                    <h5>Miami City Gart</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Miami</span></li>
                                    <li><strong>Price:</strong><span>$850000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/new-york-296-2/">
                                    <div class="title offer"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/8.jpg" alt="Image">
                                    <h5>New York City 58</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>New York</span></li>
                                    <li><strong>Price:</strong><span>$50000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/san-francisco-no-9632/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/6.jpg" alt="Image">
                                    <h5>San Francisco No 9632</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>San Francisco</span></li>
                                    <li><strong>Price:</strong><span>$750000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/los-angeles-5836/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/7.jpg" alt="Image">
                                    <h5>Los Angeles 5836</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Los angeles</span></li>
                                    <li><strong>Price:</strong><span>$900000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/dallas-city-sw-789/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/5.jpg" alt="Image">
                                    <h5>Dallas City SW 789</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$300000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/florida-sw-5896/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/4.jpg" alt="Image">
                                    <h5>Florida Sw 5896</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$520000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/india-chicago-sw-85/">
                                    <div class="title offer"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/3.jpg" alt="Image">
                                    <h5>India Chicago SW 85</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$36000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/chicago-city-639-2/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/1.jpg" alt="Image">
                                    <h5>Chicago City NW 589</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Chicago City 639</span></li>
                                    <li><strong>Price:</strong><span>$56000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/hiron-new-york-895/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/2.jpg" alt="Image">
                                    <h5>Hiron New York 895</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$520 000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/chicago-city-639/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/1.jpg" alt="Image">
                                    <h5>Chicago City 639</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Chicago City 639</span></li>
                                    <li><strong>Price:</strong><span>$56000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/hiron-new-yor-38/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/2.jpg" alt="Image">
                                    <h5>Hiron New York 38</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$520 000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/india-chicago-sw/">
                                    <div class="title offer"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/3.jpg" alt="Image">
                                    <h5>India Chicago SW</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$36000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/florida-nw-326/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/4.jpg" alt="Image">
                                    <h5>Florida Nw 326</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$520000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/dallas-city-nw-305/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/5.jpg" alt="Image">
                                    <h5>Dallas City NW 305</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$300000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/san-francisco-sw/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/6.jpg" alt="Image">
                                    <h5>San Francisco SW</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>San Francisco</span></li>
                                    <li><strong>Price:</strong><span>$750000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/los-angeles-896/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/7.jpg" alt="Image">
                                    <h5>Los Angeles 896</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Los angeles</span></li>
                                    <li><strong>Price:</strong><span>$900000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/new-york-296/">
                                    <div class="title offer"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/8.jpg" alt="Image">
                                    <h5>New York 296</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>New York</span></li>
                                    <li><strong>Price:</strong><span>$50000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/miami-city-589/">
                                    <div class="title sale"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/9.jpg" alt="Image">
                                    <h5>Miami City 589</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Miami</span></li>
                                    <li><strong>Price:</strong><span>$850000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                        <!-- Item Property-->
                        <div class="item_property">
                            <div class="head_property">
                                <a href="/fullestate/property/boston-city-58/">
                                    <div class="title rent"></div>
                                    <img src="/realestate/Content/fullestate/wp-content/uploads/2014/09/10.jpg" alt="Image">
                                    <h5>Boston City 58</h5>
                                </a>
                            </div>
                            <div class="info_property">
                                <ul>
                                    <li><strong>Place:</strong><span>Boston</span></li>
                                    <li><strong>Price:</strong><span>$250000</span></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Item Property-->
                    </div>
                    <!-- End Carousel Properties -->
                </div>
            </div>

        </div>
    </div>
</div>