$(document).ready(function() {

    var my_delay = 2000;
    $(function () {
        callAjax();
    });
    function callAjax() {
        $.ajax({
            type: "post",
            url: "/realestate/admin/article/confirmArts",
            data: {},
            datatype: "json",
            traditional: true,
            success: function (data) {
                var confirmA = "";
                if (data.length <= 10){
                    for (var i = 0; i < data.length; i++) {
                        confirmA = confirmA + "<li><a class = 'confirm' aid = "+ data[i].id + "><span>" + "<span class='time'>3 mins ago</span></span><span class='message'>" + data[i].title + "</span></a ></li >";
                    }
                }else {
                    for (var i = 0; i < 10; i++) {
                        confirmA = confirmA + "<li><a class = 'confirm' aid = "+ data[i].id + "><span>" + "<span class='time'>3 mins ago</span></span><span class='message'>" + data[i].title + "</span></a ></li >";
                    }
                }
                confirmA += "<li><div class='text-center'><a href='/realestate/article/activeArticles'><strong>See All Alerts</strong><i class='fa fa-angle-right'></i></a></div></li>"
                $('#menu1').html(confirmA);
                $('.count').html(data.length + "");
                $(".confirm").click(function () {
                    var del = $(this);
                    if (confirm("Bạn có muốn chấp nhận tin đăng này?")) {
                        $.post("/realestate/admin/article/activeArticle", { id: del.attr("aid") })
                            .done(function () {
                                    del.parent().remove();
                            });
                    }
                });
                setTimeout(callAjax, my_delay);
            }
        });
    }

    $('#cityId').change(function () {
        $.ajax({
            type: "post",
            url: "/realestate/article/districts",
            data: {cityId: $('#cityId').val()},
            datatype: "json",
            traditional: true,
            success: function (data) {
                var district = "<select id='districtId' class = 'form-control' name = 'districtId'>";
                for (var i = 0; i < data.length; i++) {
                    district = district + '<option value=' + data[i].id + '>' + data[i].districtName + '</option>';
                }
                district = district + '</select>';
                $('#District').html(district);
            }
        });
    });

    CKEDITOR.replace("description");
    $('#update-button').on("click", function(e) {
        var ArticleId = $('#articleId').val();
        var url = "/realestate/article/update/"+ArticleId;
        for (instance in CKEDITOR.instances) {
            CKEDITOR.instances[instance].updateElement();
        }
        $.ajax({
            type: "POST",
            url: url,
            processData: false,
            contentType: false,
            data: new FormData($("#formUpdate")[0]),
            processData: false,
            success: function(data)
            {
                myDropzone.options.url = "/realestate/article/uploadImage/"+data;
                myDropzone.processQueue();

                document.getElementById("address-error").innerHTML = ''   ;
                document.getElementById("title-error").innerHTML = "";
                document.getElementById("areasize-error").innerHTML = "";
                document.getElementById("bedroom-error").innerHTML = "";
                document.getElementById("bathroom-error").innerHTML = "";
                document.getElementById("livingroom-error").innerHTML = "";
                document.getElementById("tier-error").innerHTML = "";
                document.getElementById("price-error").innerHTML = "";
                document.getElementById("description-error").innerHTML = "";
                document.getElementById("typeId-error").innerHTML = "";
                document.getElementById("property-error").innerHTML = "";
                document.getElementById("districtId-error").innerHTML = "";
                document.getElementById("directionId-error").innerHTML = "";
            },
            error: function (data) {
                var response = data.responseJSON;
                document.getElementById("address-error").innerHTML = response.address   ;
                document.getElementById("title-error").innerHTML = response.title;
                document.getElementById("areasize-error").innerHTML = response.areasize;
                document.getElementById("bedroom-error").innerHTML = response.bedroom;
                document.getElementById("bathroom-error").innerHTML = response.bathroom;
                document.getElementById("livingroom-error").innerHTML = response.livingroom;
                document.getElementById("tier-error").innerHTML = response.tier;
                document.getElementById("price-error").innerHTML = response.price;
                document.getElementById("description-error").innerHTML = response.description;
                document.getElementById("typeId-error").innerHTML = response.typeId;
                document.getElementById("property-error").innerHTML = response.propertyId;
                document.getElementById("districtId-error").innerHTML = response.districtId;
                document.getElementById("directionId-error").innerHTML = response.directionId;


            },
        });

        e.preventDefault();
    });

    $('#upload-button').on("click", function(e) {
        var url = "/realestate/article/create";

        for (instance in CKEDITOR.instances) {
            CKEDITOR.instances[instance].updateElement();
        }
        $.ajax({
            url: url,
            method: "post",
            processData: false,
            contentType: false,
            data: new FormData($("#formArticle")[0]),
            processData: false,
            success: function(data)
            {
                myDropzone.options.url = "/realestate/article/uploadImage/"+data;
                myDropzone.processQueue();

                document.getElementById("address-error").innerHTML = ''   ;
                document.getElementById("title-error").innerHTML = "";
                document.getElementById("areasize-error").innerHTML = "";
                document.getElementById("bedroom-error").innerHTML = "";
                document.getElementById("bathroom-error").innerHTML = "";
                document.getElementById("livingroom-error").innerHTML = "";
                document.getElementById("tier-error").innerHTML = "";
                document.getElementById("price-error").innerHTML = "";
                document.getElementById("description-error").innerHTML = "";
                document.getElementById("typeId-error").innerHTML = "";
                document.getElementById("property-error").innerHTML = "";
                document.getElementById("districtId-error").innerHTML = "";
                document.getElementById("directionId-error").innerHTML = "";
            },
            error: function (data) {
                var response = data.responseJSON;
                document.getElementById("address-error").innerHTML = response.address   ;
                document.getElementById("title-error").innerHTML = response.title;
                document.getElementById("areasize-error").innerHTML = response.areasize;
                document.getElementById("bedroom-error").innerHTML = response.bedroom;
                document.getElementById("bathroom-error").innerHTML = response.bathroom;
                document.getElementById("livingroom-error").innerHTML = response.livingroom;
                document.getElementById("tier-error").innerHTML = response.tier;
                document.getElementById("price-error").innerHTML = response.price;
                document.getElementById("description-error").innerHTML = response.description;
                document.getElementById("typeId-error").innerHTML = response.typeId;
                document.getElementById("property-error").innerHTML = response.propertyId;
                document.getElementById("districtId-error").innerHTML = response.districtId;
                document.getElementById("directionId-error").innerHTML = response.directionId;


            },
        });

        e.preventDefault();
    });

    $(".removepicture").click(function () {
        var del = $(this);
        if (confirm("Are you sure to remove this picture?")) {
            $.post("/articles/removePicture", { id: del.attr("pid") })
                .done(function (response) {
                    if (response == "Deleted") {
                        del.parent().remove();
                    }
                });
        }
    });

	$(".file-dropzone").on('dragover', handleDragEnter);
	$(".file-dropzone").on('dragleave', handleDragLeave);
	$(".file-dropzone").on('drop', handleDragLeave);

	function handleDragEnter(e) {

		this.classList.add('drag-over');
	}

	function handleDragLeave(e) {

		this.classList.remove('drag-over');
	}

    // var myDropzone = new Dropzone(element, {
    //     url: "uploadDropzone",
    //     autoProcessQueue: false,
    // });

	var myDropzone = Dropzone.forElement(".dropzone");





    myDropzone.on("uploadprogress", function(file, progress) {

        progress = parseFloat(progress).toFixed(0);

        var progressBar = file.previewElement.getElementsByClassName("dz-upload")[0];
        progressBar.innerHTML = progress + "%";
    });

    myDropzone.on("successmultiple", function(files, serverResponse) {
        showInformationDialog(files, serverResponse);
    });


	// "dropzoneForm" is the camel-case version of the form id "dropzone-form"
	// Dropzone.options.dropzoneForm = {
    //
	// 	url : "uploadDropzone",
     //    autoProcessQueue : false,
	// 	uploadMultiple : true,
	// 	maxFilesize : 256, // MB
	// 	parallelUploads : 100,
	// 	maxFiles : 100,
	// 	addRemoveLinks : true,
	// 	previewsContainer : ".dropzone-previews",
    //
	// 	// The setting up of the dropzone
	// 	init : function() {
    //
	// 		var myDropzone = this;
    //
	// 		// first set autoProcessQueue = false
	// 		$('#upload-button').on("click", function(e) {
	// 			myDropzone.processQueue();
	// 		});
    //
	// 		// customizing the default progress bar
	// 		this.on("uploadprogress", function(file, progress) {
    //
	// 			progress = parseFloat(progress).toFixed(0);
    //
	// 			var progressBar = file.previewElement.getElementsByClassName("dz-upload")[0];
	// 			progressBar.innerHTML = progress + "%";
	// 		});
    //
	// 		// displaying the uploaded files information in a Bootstrap dialog
	// 		this.on("successmultiple", function(files, serverResponse) {
	// 			showInformationDialog(files, serverResponse);
	// 		});
	// 	}
	// }

	function showInformationDialog(files, objectArray) {

		var responseContent = "";

		for (var i = 0; i < objectArray.length; i++) {

			var infoObject = objectArray[i];

			for ( var infoKey in infoObject) {
				if (infoObject.hasOwnProperty(infoKey)) {
					responseContent = responseContent + " " + infoKey + " -> " + infoObject[infoKey] + "<br>";
				}
			}
			responseContent = responseContent + "<hr>";
		}
	}



});