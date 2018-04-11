{ jQuery(document).ready(function($) {

	//=================================== Theme Options ====================================//

	$('.wide').click(function() {
		$('.boxed').removeClass('active');
		$('.boxed-margin').removeClass('active');
		$('.semiboxed').removeClass('active');
		$(this).addClass('active');
		$('.patterns').css('display' , 'none');
		$('#layout').removeClass('layout-semiboxed').removeClass('layout-boxed').removeClass('layout-boxed-margin').addClass('layout-wide');
	});
	$('.semiboxed').click(function() {
		$('.wide').removeClass('active');
		$('.boxed').removeClass('active');
		$('.boxed-margin').removeClass('active');
		$(this).addClass('active');
		$('.patterns').css('display' , 'block');
		$('#layout').removeClass('layout-wide').removeClass('layout-boxed').removeClass('layout-boxed-margin').addClass('layout-semiboxed');
	});
	$('.boxed').click(function() {
		$('.wide').removeClass('active');
		$('.boxed-margin').removeClass('active');
		$('.semiboxed').removeClass('active');
		$(this).addClass('active');
		$('.patterns').css('display' , 'block');
		$('#layout').removeClass('layout-semiboxed').removeClass('layout-boxed-margin').removeClass('layout-wide').addClass('layout-boxed');
	});
	$('.boxed-margin').click(function() {
		$('.boxed').removeClass('active');
		$('.wide').removeClass('active');
		$('.semiboxed').removeClass('active');
		$(this).addClass('active');
		$('.patterns').css('display' , 'block');
		$('#layout').removeClass('layout-semiboxed').removeClass('layout-wide').removeClass('layout-boxed').addClass('layout-boxed-margin');
	});

	//=================================== Skins Changer ====================================//


   // Color changer
   $(".red").click(function(){
   		$.post("/Home/SaveColor", { color: "red" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
    	$("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/red/red.css");
    	$(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/red/logo.png");
        return false;
   });
   $(".blue").click(function(){
   		$.post("/Home/SaveColor", { color: "blue" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
        $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/blue/blue.css");
        $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/blue/logo.png");
        return false;
	 });
	 $(".yellow").click(function(){
	 	$.post("/Home/SaveColor", { color: "yellow" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
         $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/yellow/yellow.css");
         $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/yellow/logo.png");
         return false;
   });
	 $(".green").click(function(){
	 	$.post("/Home/SaveColor", { color: "green" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
          $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/green/green.css");
        $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/green/logo.png");
        return false;
  });
  $(".orange").click(function(){
  		$.post("/Home/SaveColor", { color: "orange" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
        $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/orange/orange.css");
        $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/orange/logo.png");
        return false;
  });
  $(".purple").click(function(){
  		$.post("/Home/SaveColor", { color: "purple" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
       $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/purple/purple.css");
       $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/purple/logo.png");
       return false;
  });
 	$(".pink").click(function(){
 		$.post("/Home/SaveColor", { color: "pink" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
       $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/pink/pink.css");
       $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/pink/logo.png");
        return false;
 	});
	$(".cocoa").click(function(){
		$.post("/Home/SaveColor", { color: "cocoa" })
                                    .done(function (response) {
                                        if (response == "Ok") {
                                        	return true;
                                        }
                                    });
        $("#theme-color-css").attr("href", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/cocoa/cocoa.css");
        $(".logo_img").attr("src", "http://wp.iwthemes.com/fullestate/wp-content/themes/fullestate/css/skins/cocoa/logo.png");
        return false;
   });


	//=================================== Background Options ====================================//
	
	$('#theme-options ul.backgrounds li').click(function(){
	var 	$bgSrc = $(this).css('background-image');
		if ($(this).attr('class') == 'bgnone')
			$bgSrc = "none";

		$('body').css('background-image',$bgSrc);
		$.cookie('background', $bgSrc);
		$.cookie('backgroundclass', $(this).attr('class').replace(' active',''));
		$(this).addClass('active').siblings().removeClass('active');
	});

	//=================================== Panel Options ====================================//

	$('.openclose').click(function(){
		if ($('#theme-options').css('left') == "-220px")
		{
			$left = "0px";
			$.cookie('displayoptions', "0");
		} else {
			$left = "-220px";
			$.cookie('displayoptions', "1");
		}
		$('#theme-options').animate({
			left: $left
		},{
			duration: 500			
		});

	});

	$(function(){
		$('#theme-options').fadeIn();
		$bgSrc = $.cookie('background');
		$('body').css('background-image',$bgSrc);

		if ($.cookie('displayoptions') == "1")
		{
			$('#theme-options').css('left','-220px');
		} else if ($.cookie('displayoptions') == "0") {
			$('#theme-options').css('left','0');
		} else {
			$('#theme-options').delay(800).animate({
				left: "-220px"
			},{
				duration: 500				
			});
			$.cookie('displayoptions', "1");
		}
		$('#theme-options ul.backgrounds').find('li.' + $.cookie('backgroundclass')).addClass('active');

	});

});}