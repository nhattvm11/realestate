<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header>
    <div class="slider" id="slide">
        <div id="rev_slider_1_1_wrapper" class="rev_slider_wrapper fullwidthbanner-container" style="margin:0px auto;background-color:#E9E9E9;padding:0px;margin-top:0px;margin-bottom:0px;max-height:570px;">
            <!-- START REVOLUTION SLIDER 4.6.3 fullwidth mode -->
            <div id="rev_slider_1_1" class="rev_slider fullwidthabanner" style="display:none;max-height:700px;height:700px;">
                <ul>
                    <!-- SLIDE  -->
                    <c:forEach items="${sliderArticles}" var="sl">
                        <li data-transition="random" data-slotamount="7" data-masterspeed="300" data-saveperformance="off">
                            <!-- MAIN IMAGE -->
                            <img src="${pageContext.request.contextPath}${sl.thumbnail}" alt="vacation_house_interior-wallpaper-1920x1200-1920x664" data-lazyload="/realestate${sl.thumbnail}" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat">
                            <!-- LAYERS -->
                            <!-- LAYER NR. 1 -->
                            <div class="tp-caption fullstate-title sft tp-resizeme" data-x="right" data-hoffset="-80" data-y="120" data-speed="500" data-start="500" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300" style="z-index: 5; max-width: auto; max-height: auto; white-space: nowrap;">
                                ${sl.title}
                            </div>

                            <!-- LAYER NR. 2 -->
                            <div class="tp-caption fullstate-p lfr tp-resizeme" data-x="right" data-hoffset="-80" data-y="210" data-speed="500" data-start="800" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300" style="z-index: 6; max-width: auto; max-height: auto; white-space: normal;">
                                ${sl.description}
                            </div>

                            <!-- LAYER NR. 3 -->
                            <div class="tp-caption fullstate-item sfr tp-resizeme" data-x="right" data-hoffset="-80" data-y="290" data-speed="500" data-start="1100" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300" style="z-index: 7; max-width: auto; max-height: auto; white-space: normal;">
                                ${sl.price} $
                            </div>


                            <!-- LAYER NR. 6 -->
                            <div class="tp-caption fullstate-bottom sfb tp-resizeme" data-x="right" data-hoffset="-80" data-y="355" data-speed="500" data-start="2000" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300" style="z-index: 10; max-width: auto; max-height: auto; white-space: normal;">
                                <a href="#" style="color: white">Detail</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="tp-bannertimer"></div>
            </div>

            <style scoped></style>

            <script type="text/javascript">
                /******************************************
                 -	PREPARE PLACEHOLDER FOR SLIDER	-
                 ******************************************/

                var setREVStartSize = function () {
                    var tpopt = new Object();
                    tpopt.startwidth = 1310;
                    tpopt.startheight = 700;
                    tpopt.container = jQuery('#rev_slider_1_1');
                    tpopt.fullScreen = "off";
                    tpopt.forceFullWidth = "off";

                    tpopt.container.closest(".rev_slider_wrapper").css({
                        height: tpopt.container.height()
                    });
                    tpopt.width = parseInt(tpopt.container.width(), 0);
                    tpopt.height = parseInt(tpopt.container.height(), 0);
                    tpopt.bw = tpopt.width / tpopt.startwidth;
                    tpopt.bh = tpopt.height / tpopt.startheight;
                    if (tpopt.bh > tpopt.bw) tpopt.bh = tpopt.bw;
                    if (tpopt.bh < tpopt.bw) tpopt.bw = tpopt.bh;
                    if (tpopt.bw < tpopt.bh) tpopt.bh = tpopt.bw;
                    if (tpopt.bh > 1) {
                        tpopt.bw = 1;
                        tpopt.bh = 1
                    }
                    if (tpopt.bw > 1) {
                        tpopt.bw = 1;
                        tpopt.bh = 1
                    }
                    tpopt.height = Math.round(tpopt.startheight * (tpopt.width / tpopt.startwidth));
                    if (tpopt.height > tpopt.startheight && tpopt.autoHeight != "on") tpopt.height = tpopt.startheight;
                    if (tpopt.fullScreen == "on") {
                        tpopt.height = tpopt.bw * tpopt.startheight;
                        var cow = tpopt.container.parent().width();
                        var coh = jQuery(window).height();
                        if (tpopt.fullScreenOffsetContainer != undefined) {
                            try {
                                var offcontainers = tpopt.fullScreenOffsetContainer.split(",");
                                jQuery.each(offcontainers, function (e, t) {
                                    coh = coh - jQuery(t).outerHeight(true);
                                    if (coh < tpopt.minFullScreenHeight) coh = tpopt.minFullScreenHeight
                                })
                            } catch (e) { }
                        }
                        tpopt.container.parent().height(coh);
                        tpopt.container.height(coh);
                        tpopt.container.closest(".rev_slider_wrapper").height(coh);
                        tpopt.container.closest(".forcefullwidth_wrapper_tp_banner").find(".tp-fullwidth-forcer").height(coh);
                        tpopt.container.css({
                            height: "100%"
                        });
                        tpopt.height = coh;
                    } else {
                        tpopt.container.height(tpopt.height);
                        tpopt.container.closest(".rev_slider_wrapper").height(tpopt.height);
                        tpopt.container.closest(".forcefullwidth_wrapper_tp_banner").find(".tp-fullwidth-forcer").height(tpopt.height);
                    }
                };

                /* CALL PLACEHOLDER */
                setREVStartSize();

                var tpj = jQuery;
                tpj.noConflict();
                var revapi1;

                tpj(document).ready(function () {

                    if (tpj('#rev_slider_1_1').revolution == undefined) {
                        revslider_showDoubleJqueryError('#rev_slider_1_1');
                    } else {
                        revapi1 = tpj('#rev_slider_1_1').show().revolution({
                            dottedOverlay: "none",
                            delay: 5500,
                            startwidth: 1310,
                            startheight: 700,
                            hideThumbs: 200,

                            thumbWidth: 100,
                            thumbHeight: 50,
                            thumbAmount: 3,

                            minHeight: 600,

                            simplifyAll: "off",

                            navigationType: "none",
                            navigationArrows: "solo",
                            navigationStyle: "round",

                            touchenabled: "on",
                            onHoverStop: "off",
                            nextSlideOnWindowFocus: "off",

                            swipe_threshold: 0.7,
                            swipe_min_touches: 1,
                            drag_block_vertical: false,

                            keyboardNavigation: "off",

                            navigationHAlign: "center",
                            navigationVAlign: "bottom",
                            navigationHOffset: 0,
                            navigationVOffset: 20,

                            soloArrowLeftHalign: "left",
                            soloArrowLeftValign: "center",
                            soloArrowLeftHOffset: 20,
                            soloArrowLeftVOffset: 0,

                            soloArrowRightHalign: "right",
                            soloArrowRightValign: "center",
                            soloArrowRightHOffset: 20,
                            soloArrowRightVOffset: 0,

                            shadow: 2,
                            fullWidth: "on",
                            fullScreen: "off",

                            spinner: "spinner0",

                            stopLoop: "off",
                            stopAfterLoops: -1,
                            stopAtSlide: -1,

                            shuffle: "off",

                            autoHeight: "off",
                            forceFullWidth: "off",

                            hideThumbsOnMobile: "off",
                            hideNavDelayOnMobile: 1500,
                            hideBulletsOnMobile: "off",
                            hideArrowsOnMobile: "off",
                            hideThumbsUnderResolution: 0,

                            hideSliderAtLimit: 0,
                            hideCaptionAtLimit: 0,
                            hideAllCaptionAtLilmit: 0,
                            startWithSlide: 0
                        });

                    }
                }); /*ready*/
            </script>

        </div>
        <!-- END REVOLUTION SLIDER -->
    </div>

</header>

<div class="content_info">
    <!-- Newsletter Box -->
    <div class="filter-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="mdf_shortcode_container  mdf_shortcode_skin_default">
                        <form method="get" id="searchForm" action="/realestate/article/search">
                        <div class="mdf_input_container_block mdf_input_container_block_0">
                            <div class="mdf_input_container">
                                <select id="typeId" name="type" class="mdf_filter_select">
                                    <c:forEach var = "item" items="${types.keySet()}">
                                        <option value = "typeByTypeId:${item}">${types.get(item)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mdf_input_container">
                                <select id="propertyId" name="property" class="mdf_filter_select">
                                    <c:forEach var = "item" items="${propertyTypes.keySet()}">
                                        <option value = "propertyTypeByPropertyId:${item}">${propertyTypes.get(item)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mdf_input_container">
                                <select id="cityId" name="city" class="mdf_filter_select">
                                    <c:forEach var = "item" items="${cities.keySet()}">
                                        <option value = "${item}">${cities.get(item)}</option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="mdf_input_container" id="District">
                                <select id='districtId' name="district" class = "form-control">
                                    <option value="">--Select City--</option>
                                </select>
                            </div>
                            <div class="mdf_input_container">
                                <select id="directionId" name="direction" class="mdf_filter_select">
                                    <c:forEach var = "item" items="${directions.keySet()}">
                                        <option value = "directionByDirectionId:${item}">${directions.get(item)}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="mdf_input_container" style="margin-top: 15px">
                                <select id="areasize" name="area" class="mdf_filter_select">
                                    <option value="">All Areasize</option>
                                    <option value="areasize>30,areasize<50">30-50 m2</option>
                                    <option value="areasize>50,areasize<80">50-80m2</option>
                                    <option value="areasize>80,areasize<100">80-100 m2</option>
                                    <option value="areasize>100,areasize<150">100-150 m2</option>
                                    <option value="areasize>150,areasize<200">150-200 m2</option>
                                    <option value="areasize>200,areasize<250">200-250 m2</option>
                                    <option value="areasize>250,areasize<300">250-300 m2</option>
                                    <option value="areasize>300,areasize<500">300-500 m2</option>
                                    <option value="areasize>500">>= 500 m2</option>
                                </select>
                            </div>

                            <div class="mdf_input_container" style="margin-top: 15px">
                                <select id="price" name="price" class="mdf_filter_select">
                                    <option value="">All Price</option>
                                    <option value="price<500">Below 500 mil</option>
                                    <option value="price>500,price<800">500 - 800 mil</option>
                                    <option value="price>800,price<1000">800 mil - 1 bil</option>
                                    <option value="price>1000,price<2000">1-2 bil</option>
                                    <option value="price>2000,price<3000">2-3 bil</option>
                                    <option value="price>3000,price<5000">3-5 bil</option>
                                    <option value="price>5000,price<7000">5-7 bil</option>
                                    <option value="price>7000,price<10000">7-10 bil</option>
                                    <option value="price>10000,price<20000">10-20 bil</option>
                                    <option value="price>20000">Over 20 bil</option>
                                </select>
                            </div>

                            <div class="mdf_input_container" style="margin-top: 15px">
                                <select id="tier" name="tier" class="mdf_filter_select">
                                    <option value="">All Tiers</option>
                                    <option value="tier:1">1 floor</option>
                                    <option value="tier:2">2 floors</option>
                                    <option value="tier:3">3 floors</option>
                                    <option value="tier:4">4 floors</option>
                                    <option value="tier:5">5 floors</option>
                                    <option value="tier:6">6 floors</option>
                                    <option value="tier:7">7 floors</option>
                                    <option value="tier:8">8 floors</option>
                                    <option value="tier:9">9 floors</option>
                                    <option value="tier:10">10 floors</option>
                                    <option value="tier:11">Over 10 floors</option>
                                </select>
                            </div>

                            <div class="mdf_input_container" style="margin-top: 15px">
                                <select id="bedroom" name="bedroom" class="mdf_filter_select">
                                    <option value="">All Rooms</option>
                                    <option value="tier:1">1 Room</option>
                                    <option value="tier:2">2 Rooms</option>
                                    <option value="tier:3">3 Rooms</option>
                                    <option value="tier:4">4 Rooms</option>
                                    <option value="tier:5">5 Rooms</option>
                                </select>
                            </div>

                            <div class="mdf_input_container" style="margin-top: 15px">
                                <select id="bathroom" name="bathroom" class="mdf_filter_select">
                                    <option value="">All Bathrooms</option>
                                    <option value="tier:1">1 Bathroom</option>
                                    <option value="tier:2">2 Bathrooms</option>
                                    <option value="tier:3">3 Bathrooms</option>
                                    <option value="tier:4">4 Bathrooms</option>
                                    <option value="tier:5">5 Bathrooms</option>
                                </select>
                            </div>
                        </div>

                        <div class="mdf_shortcode_submit_button">
                            <input type="submit" id="btn_search" class="button mdf_button" name="" value="Search">
                        </div>

                        <div class="mdf_one_moment_txt" style="display: none;">
                            <span><img src="/Content/fullestate/wp-content/plugins/meta-data-filter/images/tax_loader.gif" alt="loader"></span>
                        </div>
                        </form>

                        <style>
                            select {
                                border-radius: 5px !important;
                            }
                        </style>

                        <script type="text/javascript">
                            jQuery(function () {
                                mdf_init_search_form("598c636822dc1", "property", "/fullestate/result-horizontal-filter?", 0, 0);
                            });
                        </script>
                        <script type="text/javascript">
                            jQuery(document).ready(function () {
                                jQuery('#cityId').change(function () {
                                    jQuery.ajax({
                                        type: "post",
                                        url: "/realestate/article/districts",
                                        data: {cityId: jQuery('#cityId').val()},
                                        datatype: "json",
                                        traditional: true,
                                        success: function (data) {
                                            var district = "<select id='districtId' name = 'districtId'>";
                                            for (var i = 0; i < data.length; i++) {
                                                district = district + '<option value='+ 'districtByDistrictId:' + data[i].id + '>' + data[i].districtName + '</option>';
                                            }
                                            district = district + '</select>';
                                            jQuery('#District').html(district);
                                        }
                                    });
                                });

//                                jQuery('#searchForm').submit(function (e) {
//                                    var criteria = 'cityByCityId:'+jQuery('#cityId').val()+ ',' + jQuery('#typeId').val()+','
//                                        + jQuery('#propertyId').val()+','
//                                        + jQuery('#districtId').val()+','
//                                        + jQuery('#directionId').val()+','
//                                        + jQuery('#areasize').val()+','
//                                        + jQuery('#price').val()+','
//                                        + jQuery('#bedroom').val()+','
//                                        + jQuery('#bathroom').val()+','
//                                        + jQuery('#tier').val();
//
//                                    jQuery('#searchForm').action = '/realestate/article/search?searchTerm='+criteria;
//                                    e.preventDefault();
//                                });

                            });
                        </script>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Newsletter Box -->
    <section class="section_area ">
        <div class=" paddings">
            <div class="container">

                <!-- Divisor Top-->
                <!-- End Divisor Top-->
                <!-- Bar properties-->
                <div id="bar" class="bar_properties">
                    <div class="row">
                        <div class="col-md-5">
                            <strong>Filter :</strong>
                            <ul>
                                <li class="f-type active" data-type="sale"><a href="#">Vip Sale</a></li>
                                <li class="f-type" data-type="rent"><a href="#">Vip Rent</a></li>
                                <li class="f-type" data-type="offer"><a href="#">Free</a></li>
                            </ul>
                        </div>


                    </div>
                </div>
                <!-- End Bar properties-->

                <div class="row padding_top_mini order-container " data-layout="home" id="article-list">
                    <c:forEach items="${rentArticles}" var="rent">
                        <div style="display: none" class="col-xs-12 col-sm-6 col-md-4 col-lg-3 order" data-price="56000" data-date="20140904" data-type="rent">
                            <div class="item_property">
                                <div class="head_property">
                                    <a href="${pageContext.request.contextPath}/article/detail/${rent.id}">
                                    <img src="${pageContext.request.contextPath}${rent.thumbnail}" alt="Image" style="width: 262px; height: 169px">
                                    <h5><c:out value="${rent.cityId}"/></h5>
                                    </a>
                                </div>
                                <div class="info_property">
                                    <ul>
                                        <li style="background-color: #f9f9f9"><div style="overflow: hidden; text-overflow: ellipsis; height:72px"><a href="#"> ${rent.title}</a></div></li>
                                        <li><strong>Price:</strong><span>$ <c:out value="${rent.price}"/></span></li>
                                        <li class="resalt"><strong>Area:</strong><span><c:out value="${rent.areasize}"/></span></li>
                                        <li><strong>View:</strong><span><c:out value="${rent.view}"/></span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <c:forEach items="${saleArticles}" var="sale">
                        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 order" data-price="56000" data-date="20140904" data-type="sale">
                            <div class="item_property">
                                <div class="head_property">
                                    <a href="${pageContext.request.contextPath}/article/detail/${sale.id}">
                                        <img src="${pageContext.request.contextPath}${sale.thumbnail}" alt="Image" style="width: 262px; height: 169px">
                                        <h5>${sale.cityId}</h5>
                                    </a>
                                </div>
                                <div class="info_property">
                                    <ul>
                                        <li style="background-color: #f9f9f9"><div style="overflow: hidden; text-overflow: ellipsis; height:72px"><a href="#"> ${sale.title}</a></div></li>
                                        <li><strong>Price:</strong><span>$ ${sale.price}</span></li>
                                        <li class="resalt"><strong>Area:</strong><span>${sale.areasize}</span></li>
                                        <li><strong>View:</strong><span>${sale.view}</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <c:forEach items="${normalArticles}" var="nor">
                        <div style="display: none" class="col-xs-12 col-sm-6 col-md-4 col-lg-3 order" data-price="56000" data-date="20140904" data-type="offer">
                            <div class="item_property">
                                <div class="head_property">
                                    <a href="${pageContext.request.contextPath}/article/detail/${nor.id}">
                                        <img src="${pageContext.request.contextPath}${nor.thumbnail}" alt="Image" style="width: 262px; height: 169px">
                                        <h5>${nor.cityId}</h5>
                                    </a>
                                </div>
                                <div class="info_property">
                                    <ul>
                                        <li style="background-color: #f9f9f9"><div style="overflow: hidden; text-overflow: ellipsis; height:72px"><a href="#"> ${nor.title}</a></div></li>
                                        <li><strong>Price:</strong><span>$ ${nor.price}</span></li>
                                        <li class="resalt"><strong>Area:</strong><span>${nor.areasize}</span></li>
                                        <li><strong>View:</strong><span>${nor.view}</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div id="test"></div>
                    <!-- End Button-->
                    <!-- Divisor Bottom-->

                    <div class="col-md-12">
                        <div class="divisor divisor-bottom">
                            <div class="circle_left"></div>
                            <div class="circle_right"></div>
                        </div>
                    </div>
                    <!-- End Divisor Bottom -->

                </div>
            </div>
        </div>


    </section>

    <section class="section_area ">
        <div class=" paddings">
            <div class="container">

                <!-- Divisor Bottom-->
                <!-- End Divisor Bottom-->

                <div class="content-carousel">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Title-->
                            <div class="titles">
                                <span>Under construction and on planes</span>
                                <br>
                                <h1>NEW PROJECTS</h1>
                            </div>
                            <!-- End Title-->
                        </div>
                    </div>

                    <!-- Carousel Properties -->
                    <div id="properties-carousel" class="properties-carousel">
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
                    <!-- Divisor Bottom-->
                    <!-- End Divisor Bottom-->

                </div>
            </div>
        </div>
    </section>
</div>