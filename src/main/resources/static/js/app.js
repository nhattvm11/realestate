$(document).ready(function() {

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

    $('#upload-button').on("click", function(e) {
        var url = "/realestate/article/create";
        $.ajax({
            type: "POST",
            url: url,
            data: $("#formCreate").serialize(),
            success: function(data)
            {
                myDropzone.options.url = "/realestate/article/uploadImage/"+data;
                myDropzone.processQueue();
            },
            error: function (data) {
                alert("Loi");
            },
        });

        e.preventDefault();
    });

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