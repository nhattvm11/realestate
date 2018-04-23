<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta charset="UTF-8" />
    <title>
        Title
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="Just another WordPress site">

    <script type="text/javascript">
        var lang_one_moment = "One Moment ...";
        var mdf_tax_loader = '<img src="/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/images/tax_loader.gif" alt="loader" />';
        var mdf_tooltip_theme = "shadow";
        var tooltip_max_width = parseInt(220, 10);
        var under_title_out = parseInt(1, 10);
        var post_features_panel_auto = 1;
        var ajaxurl = "/fullestate/wp-admin/admin-ajax.php";
        var mdf_front_qtrans_lang = "";
    </script>

    <style id='rs-plugin-settings-inline-css' type='text/css'>
        .tp-caption a {
            color: #ff7302;
            text-shadow: none;
            -webkit-transition: all 0.2s ease-out;
            -moz-transition: all 0.2s ease-out;
            -o-transition: all 0.2s ease-out;
            -ms-transition: all 0.2s ease-out
        }

        .tp-caption a:hover {
            color: #ffa902
        }

        .largeredbtn {
            font-family: "Raleway", sans-serif;
            font-weight: 900;
            font-size: 16px;
            line-height: 60px;
            color: #fff !important;
            text-decoration: none;
            padding-left: 40px;
            padding-right: 80px;
            padding-top: 22px;
            padding-bottom: 22px;
            background: rgb(234, 91, 31);
            background: -moz-linear-gradient(top, rgba(234, 91, 31, 1) 0%, rgba(227, 58, 12, 1) 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(234, 91, 31, 1)), color-stop(100%, rgba(227, 58, 12, 1)));
            background: -webkit-linear-gradient(top, rgba(234, 91, 31, 1) 0%, rgba(227, 58, 12, 1) 100%);
            background: -o-linear-gradient(top, rgba(234, 91, 31, 1) 0%, rgba(227, 58, 12, 1) 100%);
            background: -ms-linear-gradient(top, rgba(234, 91, 31, 1) 0%, rgba(227, 58, 12, 1) 100%);
            background: linear-gradient(to bottom, rgba(234, 91, 31, 1) 0%, rgba(227, 58, 12, 1) 100%);
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#ea5b1f', endColorstr='#e33a0c', GradientType=0)
        }

        .largeredbtn:hover {
            background: rgb(227, 58, 12);
            background: -moz-linear-gradient(top, rgba(227, 58, 12, 1) 0%, rgba(234, 91, 31, 1) 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(227, 58, 12, 1)), color-stop(100%, rgba(234, 91, 31, 1)));
            background: -webkit-linear-gradient(top, rgba(227, 58, 12, 1) 0%, rgba(234, 91, 31, 1) 100%);
            background: -o-linear-gradient(top, rgba(227, 58, 12, 1) 0%, rgba(234, 91, 31, 1) 100%);
            background: -ms-linear-gradient(top, rgba(227, 58, 12, 1) 0%, rgba(234, 91, 31, 1) 100%);
            background: linear-gradient(to bottom, rgba(227, 58, 12, 1) 0%, rgba(234, 91, 31, 1) 100%);
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#e33a0c', endColorstr='#ea5b1f', GradientType=0)
        }

        .fullrounded img {
            -webkit-border-radius: 400px;
            -moz-border-radius: 400px;
            border-radius: 400px
        }
    </style>


    <link rel="stylesheet" href="/realestate/Content/bootstrap.css">
    <script src="/realestate/js/modernizr-2.6.2.js"></script>
    <link rel="stylesheet" href="/realestate/Content/fullestate/wp-content/plugins/contact-form-7/includes/css/styles1.css">


    <link rel='stylesheet' id='rs-plugin-settings-css' href='/realestate/Content/fullestate/wp-content/plugins/revslider/rs-plugin/css/settings.css' type='text/css' media='all' />

    <link rel='stylesheet' id='maison_style-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/style1.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='style_fs-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/css/style2.css?ver=4.1.18' type='text/css' media='all' />

    <link rel='stylesheet' id='load-gm-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-location-field/load-gm.css?ver=4.1.18' type='text/css' media='all' />

    <link rel='stylesheet' id='theme-color-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/css/skins/green/green.css?ver=4.1.18' type='text/css' media='all' />


    <%--<link rel='stylesheet' id='theme-color-css' href='http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/@color/@colorcss' type='text/css' media='all' />--%>

    <link rel='stylesheet' id='iconf-font-awesome-styles-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-icon/assets/css/font-awesome.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='iconf-font-awesome-corp-styles-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-icon/assets/css/font-awesome-corp.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='iconf-font-awesome-ext-styles-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-icon/assets/css/font-awesome-ext.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='iconf-font-awesome-social-styles-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-icon/assets/css/font-awesome-social.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='iconf-font-awesome-more-ie7-css' href='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-icon/assets/css/font-awesome-more-ie7.min.css?ver=4.1.18' type='text/css' media='all' />



    <link rel='stylesheet' id='meta_data_filter_front-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/css/front.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='tooltipster-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/tooltipster/css/tooltipster.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='tooltipster_theme-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/tooltipster/css/themes/tooltipster-shadow.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='malihu-custom-scrollbar-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/malihu-custom-scrollbar/jquery.mCustomScrollbar.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='ion.range-slider-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/ion.range-slider/css/ion.rangeSlider.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='ion.range-slider-skin-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/ion.range-slider/css/ion.rangeSlider.skinNice.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='mdf_skin_default-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/views/shortcode/skins/default/styles2.css?ver=4.1.18' type='text/css' media='all' />
    <link rel='stylesheet' id='mdf_skin_default_slider-css' href='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/views/shortcode/skins/default/slider.css?ver=4.1.18' type='text/css' media='all' />

    <script type='text/javascript' src='/realestate/Content/fullestate/wp-includes/js/jquery/jquery.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-includes/js/jquery/jquery-migrate.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/lib.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-includes/js/jquery/ui/core.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/front.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/mailchimp/js/scrollTo.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/contact-form-7/includes/js/jquery.form.min.js'></script>
    <script type='text/javascript'>
        /* <![CDATA[ */
        var mailchimpSF = {
            "ajax_url": "http:\/\/wp.iwthemes.com\/fullestate\/"
        };
        /* ]]> */
    </script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/mailchimp/js/mailchimp.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/mailchimp//js/datepicker.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/revslider/rs-plugin/js/jquery.themepunch.tools.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/revslider/rs-plugin/js/jquery.themepunch.revolution.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/contact-form-7/includes/js/scripts.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/nav/tinynav.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/nav/superfish.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-includes/js/hoverIntent.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/efect_switcher/jquery.content-panel-switcher.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/totop/jquery.ui.totop.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/slide/camera.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/slide/jquery.easing.1.3.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/bootstrap/bootstrap.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/inc/acf-location-field/js/load-gm.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/owlcarousel/owl.carousel.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/parallax/jquery.inview.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/parallax/nbw-parallax.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/theme-options/theme-options.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/theme-options/jquery.cookies.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/themes/fullestate/js/main.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/tooltipster/js/jquery.tooltipster.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/malihu-custom-scrollbar/jquery.mousewheel.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/malihu-custom-scrollbar/jquery.mCustomScrollbar.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/malihu-custom-scrollbar/jquery.mCustomScrollbar.concat.min.js'></script>
    <script type='text/javascript' src='/realestate/Content/fullestate/wp-content/plugins/meta-data-filter/js/ion.range-slider/ion.rangeSlider.min.js'></script>
    <script type="text/javascript">
        jQuery(function ($) {
            $('.date-pick').each(function () {
                var format = $(this).data('format') || 'mm/dd/yyyy';
                format = format.replace(/yyyy/i, 'yy');
                $(this).datepicker({
                    autoFocusNextInput: true,
                    constrainInput: false,
                    changeMonth: true,
                    changeYear: true,
                    beforeShow: function (input, inst) {
                        $('#ui-datepicker-div').addClass('show');
                    },
                    dateFormat: format.toLowerCase(),
                });
            });
            d = new Date();
            $('.birthdate-pick').each(function () {
                var format = $(this).data('format') || 'mm/dd';
                format = format.replace(/yyyy/i, 'yy');
                $(this).datepicker({
                    autoFocusNextInput: true,
                    constrainInput: false,
                    changeMonth: true,
                    changeYear: false,
                    minDate: new Date(d.getFullYear(), 1 - 1, 1),
                    maxDate: new Date(d.getFullYear(), 12 - 1, 31),
                    beforeShow: function (input, inst) {
                        $('#ui-datepicker-div').removeClass('show');
                    },
                    dateFormat: format.toLowerCase(),
                });

            });

        });
    </script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            // CUSTOM AJAX CONTENT LOADING FUNCTION
            var ajaxRevslider = function (obj) {

                // obj.type : Post Type
                // obj.id : ID of Content to Load
                // obj.aspectratio : The Aspect Ratio of the Container / Media
                // obj.selector : The Container Selector where the Content of Ajax will be injected. It is done via the Essential Grid on Return of Content

                var content = "<h2>THIS IS SOME TITLE</h2><br/>";

                content += "Type:" + obj.type + "</br>";
                content += "ID:" + obj.id + "</br>";
                content += "Aspect Ratio:" + obj.aspectratio + "</br>";

                data = {};

                data.action = 'revslider_ajax_call_front';
                data.client_action = 'get_slider_html';
                data.token = '14fec7a0f5';
                data.type = obj.type;
                data.id = obj.id;
                data.aspectratio = obj.aspectratio;

                // SYNC AJAX REQUEST
                jQuery.ajax({
                    type: "post",
                    url: "/fullestate/wp-admin/admin-ajax.php",
                    dataType: 'json',
                    data: data,
                    async: false,
                    success: function (ret, textStatus, XMLHttpRequest) {
                        if (ret.success == true)
                            content = ret.data;
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });

                // FIRST RETURN THE CONTENT WHEN IT IS LOADED !!
                return content;
            };

            // CUSTOM AJAX FUNCTION TO REMOVE THE SLIDER
            var ajaxRemoveRevslider = function (obj) {
                return jQuery(obj.selector + " .rev_slider").revkill();
            }

            // EXTEND THE AJAX CONTENT LOADING TYPES WITH TYPE AND FUNCTION
            var extendessential = setInterval(function () {
                if (jQuery.fn.tpessential != undefined) {
                    clearInterval(extendessential);
                    if (typeof (jQuery.fn.tpessential.defaults) !== 'undefined')
                        jQuery.fn.tpessential.defaults.ajaxTypes.push({
                            type: "revslider",
                            func: ajaxRevslider,
                            killfunc: ajaxRemoveRevslider,
                            openAnimationSpeed: 0.3
                        });
                    // type:  Name of the Post to load via Ajax into the Essential Grid Ajax Container
                    // func: the Function Name which is Called once the Item with the Post Type has been clicked
                    // killfunc: function to kill in case the Ajax Window going to be removed (before Remove function !
                    // openAnimationSpeed: how quick the Ajax Content window should be animated (default is 0.3)
                }
            }, 30);
        });
    </script>
    <link rel="Shortcut Icon" type="image/x-icon" href="" />
    <style type="text/css">
        .recentcomments a {
            display: inline !important;
            padding: 0 !important;
            margin: 0 !important;
        }
    </style>
</head>

<body class="home page page-id-319 page-template-default" style="padding-top: 0">

<!-- layout-->
<div id="layout" class="layout-semiboxed">


    <div class="line"></div>
    <!-- End Login Client -->
    <!-- Info Head -->
    <tiles:insertAttribute name="header" />
    <!-- End Nav-->

    <tiles:insertAttribute name="body" />

    <tiles:insertAttribute name="footer" />


    <script type='text/javascript'>
        /* <![CDATA[ */
        var _wpcf7 = {
            "loaderUrl": "http:\/\/wp.iwthemes.com\/fullestate\/wp-content\/plugins\/contact-form-7\/images\/ajax-loader.gif",
            "sending": "Sending ..."
        };
        /* ]]> */
    </script>

</div>
<!-- End layout-->
<!-- Style Switcher Theme -->
<!-- Theme-options -->
<div id="theme-options">
    <div class="openclose"></div>
    <div class="title">
        <span>THEME OPTIONS</span>
        <p>Choose a combination of predefined colors here. Here are some examples. You can create any additional number on your backend theme, also can choose the background you want and four differents layouts.</p>
    </div>
    <span>SKINS COLOR</span>
    <ul class="colorbox">
        <li>
            <a class="color red" href="?theme=red" title="Red Skin"></a>
        </li>
        <li>
            <a class="color blue" href="?theme=blue" title="Blue Skin"></a>
        </li>
        <li>
            <a class="color yellow" href="?theme=yellow" title="Yellow Skin"></a>
        </li>
        <li>
            <a class="color green" href="?theme=green" title="Green Skin"></a>
        </li>
        <li>
            <a class="color orange" href="?theme=orange" title="Orange Skin"></a>
        </li>
        <li>
            <a class="color purple" href="?theme=purple" title="Purple Skin"></a>
        </li>
        <li>
            <a class="color pink" href="?theme=pink" title="Pink Skin"></a>
        </li>
        <li>
            <a class="cocoa" href="?theme=cocoa" title="Cocoa Skin"></a>
        </li>
    </ul>

    <span>LAYOUT STYLE</span>
    <ul class="layout-style">
        <li class="wide">Wide</li>
        <li class="semiboxed active">Semiboxed</li>
        <li class="boxed">Boxed</li>
        <li class="boxed-margin">Boxed Margin</li>
    </ul>
    <div class="patterns">
        <span>BACKGROUND PATTERNS</span>
        <ul class="backgrounds">
            <li class="bgnone" title="None - Default"></li>
            <li class="bg1"></li>
            <li class="bg2"></li>
            <li class="bg3"></li>
            <li class="bg4 "></li>
            <li class="bg5"></li>
            <li class="bg6"></li>
            <li class="bg7"></li>
            <li class="bg8"></li>
            <li class="bg9 "></li>
            <li class="bg10"></li>
            <li class="bg11"></li>
            <li class="bg12"></li>
            <li class="bg13"></li>
            <li class="bg14"></li>
            <li class="bg15"></li>
            <li class="bg16"></li>
            <li class="bg17"></li>
            <li class="bg18"></li>
            <li class="bg19"></li>
            <li class="bg20"></li>
            <li class="bg21"></li>
            <li class="bg22"></li>
            <li class="bg23"></li>
            <li class="bg24"></li>
            <li class="bg25"></li>
            <li class="bg26"></li>
        </ul>
    </div>
</div>
<!-- End Theme-options -->
<!-- End Style Switcher Theme -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.3.2/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.3.2/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/remarkable/1.7.1/remarkable.min.js"></script>
<%--<script src="@Url.Content("~/Scripts/app.jsx")"></script>--%>

</body>

</html>