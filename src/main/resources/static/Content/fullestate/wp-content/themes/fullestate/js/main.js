(function($){
$(document).ready(function(){	

    //=================================== Nav Responsive ===============================//
    $('#menu').tinyNav({
       active: 'selected'
    });

    //=================================== Nav Superfish ===============================//
    jQuery(document).ready(function() {
      jQuery('ul.sf-menu').superfish();
    });
      
   //=================================== efect_switcher  ===================================//
		
	
    $.jcps.slider(500, '.switcher-panel', '.set2');
  
    //=================================== Subtmit Form Agent =================================//
  
    $('#form').submit(function(event) {  
      event.preventDefault();  
      var url = $(this).attr('action');  
      var datos = $(this).serialize();  
      $.get(url, datos, function(resultado) {  
        jQuery('.result').fadeIn('fast');
        $('.result').html(resultado);
              jQuery('.result').delay(1600)
              jQuery('.result').fadeOut('slow');
      });  
    });  
 
                  
    //=================================== camera  ===================================//

    if ($('#slide_details').length) {
      $('#slide_details').camera({        
        height: '52.5%',
        navigation: true  
      });
    }
	
  //=================================== Totop  ===================================//
    
	$().UItoTop({ 		
		scrollSpeed:500,
		easingType:'linear'
	});	

	
	//=================================== Parallax Efect =====================================//
   
  $('.bg_parallax, .section_title').parallax("40%", .3);
  

	//=================================== Sponsors Carousel  =================================// 

	$('.sponsors').owlCarousel({
		items:6,
		loop:true,
		margin:10,
    navigation:true,
		dots:false,
		autoplayTimeout:4000,
		autoplay:true,
		responsive:{
			320:{
				items:1
			},	
			480:{
				items:2
			},
			678:{
				items:3
			},
			960:{
				items:5
			},
			1280:{
				items:6
			}
		}
	});

	//=================================== Testimonial Carousel  =================================// 

	$('.testimonial-carousel').owlCarousel({
		items:1,
		loop:true,
		margin:10,
		autoplay:true,
		autoplayTimeout:3000,
		responsive:{	
			480:{
				items:1
			},
			678:{
				items:1
			},
			960:{
				items:1
			}
		}
	});

	//=================================== Properties Carousel  =================================// 

	$('#properties-carousel').owlCarousel({
		items:4,
		loop:true,
		navigation:true,
		dots:false,
		margin:30,
		autoplay:true,
		autoplayTimeout:3000,
		responsive:{
			170:{
				items:1
			},	
			500:{
				items:2
			},
			678:{
				items:2
			},
			768:{
				items:3
			},
			960:{
				items:4
			}
		}
	});

	//=================================== jBar  ===================================//
	$('.jBar').hide();
		$('.jRibbon').show().removeClass('up', 500);
		$('.jTrigger').click(function(){
            $('.jRibbon').toggleClass('up', 500);
			$('.jBar').slideToggle();
		});
      
	//=================================== Tabs defauld  ===================================//
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content
	
	//=================================== Tabs On Click Event  ===================================//
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content
		var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active content
		return false;
	});
	

	//=================================== Tooltips ==================================//

		$('.sponsors, .social, .tooltip_hover').tooltip({
      selector: "[data-toggle=tooltip]",
      container: "body"
   	});
  
    
    //=================================== Paginator  ===================================//
    $('.paginator').click(function(){
        show = $(this).data('page');
        $('.paginator').each(function(e){
            if($(this).hasClass('active')){
                hidden = $(this).data('page');
                $('.hidden'+hidden).hide();
                $(this).removeClass('active');
            }
        });
        $('.hidden'+show).fadeIn("slow");
        $(this).addClass('active');
    });
    
    
    //=================================== Order bar property (price,date) ===================================//
    
    function order_param(arr,arr1,arr2,ord){
       var val = 0
        ,current = 0
        ,html = ''
        date = 0;
       if(ord == 'asc')
           for(i in arr) {
               for(j in arr){
                  current = arr[i];
                  //alert(val+'  '+current);
                  if(current < arr[j]){
                    val = current;
                    html = arr1[i]
                    date = arr2[i]
                    
                    arr[i] = arr[j];
                    arr1[i] = arr1[j];
                    arr2[i] = arr2[j];
                    
                    arr[j] = val;
                    arr1[j] = html;
                    arr2[j] = date;
                  }
               }
           }
       else
          for(i in arr) {
               for(j in arr){
                  current = arr[i];
                  if(current > arr[j]){
                    val = current;
                    html = arr1[i]
                    date = arr2[i]
                    
                    arr[i] = arr[j];
                    arr1[i] = arr1[j];
                    arr2[i] = arr2[j];
                    
                    arr[j] = val;
                    arr1[j] = html;
                    arr2[j] = date;
                  }
               }
           } 
       return arr1;
   }                                    
    $('.btn_order').click(function(e){
        e.preventDefault();
        var arr_price = []
            ,arr_html = []
            ,arr_date = []
            ,arr_type = []
            ,print_html = ''
        
        tag = $('.order-container').data('layout');
        order = $(this).data('order');
        type = $(this).data('type');
       // if(order == 'asc'){
        $('.order').each(function(index,e){
            arr_price[index] = $(e).data('price');
            arr_date[index] = $(e).data('date');
            arr_type[index] = $(e).data('type');
            arr_html[index] = $(e).html(); 
        });   
       /* }else{
            $('.order').each(function(index,e){
                arr_price[index] = $(e).data('price');
                arr_date[index] = $(e).data('date');
                arr_type[index] = $(e).data('type');
                arr_html[index] = $(e).html(); 
            });  
        }     */
        if(type == 'date')
            arr_html = order_param(arr_date,arr_html,arr_price,order);
        else
            arr_html = order_param(arr_price,arr_html,arr_date,order);
            
        num_page = 0;
        counter = $('.counter-page').data('count');
        //alert(tag);
        var c = 0;
        for(i in arr_html){
            //alert(c%counter+' '+c+' '+counter);
            num_page = (c%counter == 0)?num_page+1:num_page;    
            c++;
            if(tag == 'box')
                print_html += '<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4 order show'+num_page+'" data-price="'+arr_price[i]+'" data-date="'+arr_date[i]+'" data-type="'+arr_type[i]+'">'+arr_html[i]+'</div>';
            if(tag == 'list')
                print_html += '<article id="show'+num_page+'" class="item_property_h order show-off show'+num_page+'" data-price="'+arr_price[i]+'" data-date="'+arr_date[i]+'" data-type="'+arr_type[i]+'">'+arr_html[i]+'</article>';
            if(tag == 'home')
                print_html += '<div class="col-md-3 order" data-price="'+arr_price[i]+'" data-date="'+arr_date[i]+'" data-type="'+arr_type[i]+'">'+arr_html[i]+'</div>';
            if(tag == 'home-list')
                print_html += '<article class="item_property_h order show-off show'+num_page+'" data-price="'+arr_price[i]+'" data-date="'+arr_date[i]+'" data-type="'+arr_type[i]+'">'+arr_html[i]+'</article>';
        }
        $('.order-container').html(print_html);
        $('.page-my li').each(function(){
            value = $(this).data('in');
            if($(this).hasClass('active')){
                $('.order').hide();
                $('.show'+value+'.order').show('fast');
            }
            
        });
    });
    
    //********PAGINATION PROPERTIES*****************************************/
  
    function hide_properties(){
        $('.show-off').hide();
        $('.show1').show();
    }
    hide_properties();
    
    $('.page-my li').click(function(e){
       e.preventDefault();
       $('.page-my li').removeClass('active');
       $(this).addClass('active');
       show = $(this).data('in');
        if($(this).hasClass('active')){
            $('.order').hide();
            $('.show'+show+'.order').show('fast');
        } 
       /*$('.show-off').each(function(i,el){
           aux = $(el).attr('id');
           if(aux == 'show'+show)
            $(this).fadeIn(3000); 
           else
            $(this).hide();
       });*/
    });
    
    //=================================== Slider  ===================================//
     /* $(".news_slider").responsiveSlides({
        speed: 1000
      });*/
    
    //=================================== Filter home bar property (rent,sale,offer)===================================//
    
    $('.f-type').click(function(e){
        e.preventDefault();
        $('.f-type').each(function(){
            $(this).removeClass('active');
        });
        $(this).addClass('active');    
        
        show = $(this).data('type');
        if(show == 'all'){
            $('.order').show('slow');
        }else{
            $('.order').each(function(){
                $(this).hide();
                if($(this).data('type') == show){
                    $(this).show('slow');
                }
            });
        }
    });
    
});

})(jQuery);