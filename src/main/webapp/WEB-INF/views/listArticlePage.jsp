<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <div class="section_title" style="background-image: url('https://www.facebook.com/'); background-position: 40% 6px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="width: auto !important;">
                    <h1>
                        01-Blog-Full-Width                                                                <span><a href="http://wp.iwthemes.com/fullestate">Home </a> / 01-Blog-Full-Width</span>
                    </h1>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" value="${pageInfo}" id="page-numbers"/>

    <div class="content_info">
        <!-- Newsletter Box -->
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
        <!-- End Newsletter Box -->
        <input type="hidden" value="${searchTerm}" id="searchTerm"/>
        <div class="container">
            <div class="row paddings">

                <div class="col-md-4 col-lg-3">
                    <div>
                        <div class="widget-area" role="complementary">

                            <div class="widget widget-meta-data-filter">
                                <h3>Meta Data Filter</h3>

                                <%--<form method="get">--%>
                                    <div class="mdf_one_moment_txt">
                                        <span><img src="/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/images/tax_loader.gif" alt="loader" /></span>
                                    </div>
                                    <h6>Wordpress Meta Data and Taxonomies Filter</h6>

                                    <input type="hidden" name="mdf[filter_post_blocks][]" value="42" />

                                    <h4 class="data-filter-section-title">Properties Filter</h4>

                                    <div class="mdf_filter_section">
                                        <table style="width: 98%;">

                                            <tr>

                                                <td>
                                                    <div class="mdf_input_container">
                                                        <h5 class="data-filter-section-title" style="margin-bottom: 4px;" for="598ec9cf189d3">Price:&nbsp;<span class="mdf_range">
                                                                <input type="text" id="min_price" value="0" class="mdf_range_min" data-slider-id="ui_slider_item_598ec9cf189d3" />
                                                                -
                                                                <input type="text" id="max_price" value="1000000" class="mdf_range_max" data-slider-id="ui_slider_item_598ec9cf189d3" />
                                                                    </span> &nbsp;(0)&nbsp;
                                                        </h5>
                                                        <div class="ui_slider_item ui_slider_item_598ec9cf17607" id="ui_slider_item_598ec9cf189d3"></div>
                                                        <input type="hidden" name="mdf[medafi_5407b92c399dc]" id="598ec9cf189d3" data-min="0" data-max="1000000" data-min-now="0" data-max-now="1000000" data-step="0" data-slider-prefix="$" data-slider-postfix="" data-slider-prettify="1" value="0^1000000" />
                                                    </div>
                                                </td>

                                            </tr>

                                            <tr>

                                                <td>
                                                    <div class="mdf_input_container">
                                                        <h5 class="data-filter-section-title" style="margin-bottom: 4px;" for="medafi_5407ba3d0ee02">Area:&nbsp;                                        </h5>
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
                                                </td>

                                            </tr>

                                            <tr>

                                                <td>
                                                    <div class="mdf_input_container">
                                                        <h5 class="data-filter-section-title" style="margin-bottom: 4px;" for="medafi_5407baa865119">Number of Tiers:&nbsp;                                        </h5>
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
                                                </td>

                                            </tr>

                                        </table>
                                    </div>

                                    <input type="hidden" name="meta_data_filter_bool" value="AND" />

                                    <input type="hidden" class="hidden_page_mdf_for_ajax" value="" />
                                    <input type="hidden" name="mdf_tax_bool" value="AND" />
                                    <input type="hidden" name="mdf[mdf_widget_options][slug]" value="property" />
                                    <input type="hidden" name="mdf[mdf_widget_options][meta_data_filter_cat]" value="23" />
                                    <input type="hidden" name="mdf[mdf_widget_options][show_items_count_dynam]" value="1" />
                                    <input type="hidden" name="mdf[mdf_widget_options][taxonomies_options_post_recount_dyn]" value="1" />
                                    <input type="hidden" name="mdf[mdf_widget_options][taxonomies_options_hide_terms_0]" value="0" />
                                    <input type="hidden" name="mdf[mdf_widget_options][hide_meta_filter_values]" value="0" />
                                    <input type="hidden" name="mdf[mdf_widget_options][hide_tax_filter_values]" value="0" />
                                    <input type="hidden" name="mdf[mdf_widget_options][search_result_page]" value="/fullestate/properties-result-page" />
                                    <input type="hidden" name="mdf[mdf_widget_options][search_result_tpl]" value="inc/mdf/result1" />

                                    <input type="hidden" value="23" name="meta_data_filter_cat" />

                                    <div style="float: left;">
                                        <input type="submit" id="filter_button" class="button mdf_button" name="" value="Filter" />
                                    </div>

                                    <div style="clear: both;"></div>

                                <%--</form>--%>
                                <br />

                                <script type="text/javascript">
                                    jQuery(function() {
                                        mdf_init_search_form("598ec9cf17607", "property", "/fullestate/properties-result-page?", 0, 1);
                                    });
                                </script>

                            </div>
                        </div>
                    </div>
                </div>

                <link href="/realestate/Content/PagedList.css" rel="stylesheet" type="text/css" />
                <div class="col-md-8 col-lg-9 counter-page" data-count="4">

                    <!-- Bar properties-->
                    <div id="bar" class="bar_properties">
                        <div class="row">
                            <div class="col-md-8">
                                <strong>Order BY :</strong>
                                <ul class="tooltip_hover">
                                    <li>
                                        <a href="#">Recent ads</a>
                                        <a href="#" data-toggle="tooltip" title="Sort Ascending" class="btn_order" data-order="asc" data-type="date">
                                            <i class="icon-caret-up"></i>
                                        </a>
                                        <a href="#" data-toggle="tooltip" title="Sort Descending" class="btn_order" data-order="desc" data-type="date">
                                            <i class="icon-caret-down"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Price</a>
                                        <a href="#" data-toggle="tooltip" title="Sort Ascending" class="btn_order" data-order="asc" data-type="price">
                                            <i class="icon-caret-up"></i>
                                        </a>
                                        <a href="#" data-toggle="tooltip" title="Sort Descending" class="btn_order" data-order="desc" data-type="price">
                                            <i class="icon-caret-down"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-4">
                                <ul class="text_right tooltip_hover">
                                    <li title="Grid Layout" data-toggle="tooltip" class="">
                                        <a href="//Content/fullestate/02-properties-style/?layout=box">
                                            <i class="icon-th-large"></i>
                                        </a>
                                    </li>
                                    <li title="List Layout" data-toggle="tooltip" class="active">
                                        <a href="//Content/fullestate/02-properties-style/?layout=list">
                                            <i class="icon-list"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- End Bar properties-->
                    <div class="order-container" data-cprop="20" data-layout="home-list">
                        <c:forEach var="item" items="${data}">
                            <article class="item_property_h order show-off show1" data-price="${item.price}" data-date="" data-type="rent">
                                <div class="col-md-4">
                                    <div class="image_property_h">
                                        <div class="hover_property_h" style="width: 277px; height:178px">
                                            <img src="${pageContext.request.contextPath}${item.thumbnail}" alt="Image List">
                                            <a href="#">
                                                <span class="listing-cover-plus">+</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="info_property_h">
                                        <h4><a href="#">${item.address}</a><span> ${item.cityId} </span></h4>
                                        <p>${item.description}</p>
                                    </div>
                                </div>
                                <div class="line_property"><span>$ ${item.price}</span>${item.typeId}</div>
                            </article>
                        </c:forEach>

                        <div class="pagination-container">
                            <ul class="pagination">
                                <c:forEach begin="0" end="${pageInfo-1}" varStatus="loop">
                                    <c:choose>
                                        <c:when test="${currentPage == loop.index}">
                                            <li class="active">
                                                <a id="page-${loop.index}" class="not-active" style="pointer-events: none;" href="">${loop.index}</a>
                                            </li>
                                        </c:when>

                                        <c:otherwise>
                                            <li>
                                                <a id="page-${loop.index}" href="">${loop.index}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>