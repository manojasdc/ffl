
$(document).ready(function() {
	getMiscActivity(1);
	$("#miscData").on("click", ".read-more-btn", function() {
		var btn = $(this);
		var text = btn.closest(".blog-desc").find(".read-more-text");
		text.toggleClass("read-more read-less");
		btn.text(text.hasClass("read-less") ? "Read more.." : "Read less..");
	});
	$("#miscData").on("click", ".open-image", function() {
		let mimeType = $(this).attr("data-image").match(/^data:(image\/[a-zA-Z0-9.+-]+);base64,/);
		let byteCharacters = atob($(this).attr("data-image").split(",")[1]);
		let byteArrays = [];

		for (let i = 0; i < byteCharacters.length; i++) {
			byteArrays.push(byteCharacters.charCodeAt(i));
		}

		let blob = new Blob([new Uint8Array(byteArrays)], { type: mimeType[1] });
		let blobUrl = URL.createObjectURL(blob);

		window.open(blobUrl, "_blank");
})

});


document.addEventListener('DOMContentLoaded', function() {

	var totalpages = document.getElementById("totalpage").value;

	var data = "";
	var counter = 1;

	for (var i = 0; i < totalpages; i++) {

		data += '<li'
			+ '><a href="javascript:void(0)"' + (counter === 1 ? ' class="active"' : '') + ' id="page' + counter + '">'
			+ counter + '</a></li>';
		counter++;
	}
	$("#pagination").append(data);
	for (var i = 0; i < totalpages; i++) {

		(function() {
			var idval = i + 1;

			document.getElementById("page" + idval).onclick = function() {

				for (var j = 1; j <= totalpages; j++) {
					$("#page" + j).removeClass("active");
				}

				$(this).addClass("active");
				return LoadPageData(idval);
			};

		})();
	}


	document.addEventListener('click', function(event) {
    var opendocumentElement = event.target.closest('.opendocument');
    if (opendocumentElement) {
        event.preventDefault();
       
        var id = opendocumentElement.getAttribute('value');
       
        Getactimage(id);
    }
});
	
	
    

});

// Added by me

/*function openBase64Image(base64Image) {
    let byteCharacters = atob(base64Image.split(",")[1]); 
    let byteArrays = [];
    
    for (let i = 0; i < byteCharacters.length; i++) {
        byteArrays.push(byteCharacters.charCodeAt(i));
    }

    let blob = new Blob([new Uint8Array(byteArrays)], { type: "image/jpeg" }); // Change MIME type as needed
    let imageUrl = URL.createObjectURL(blob);
    
    window.open(imageUrl, "_blank");
}*/

function Getactimage(id) {

	$('#activitydiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getactimage',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',
			})
		.done(
			function(data) {
				if (data.data.DocumentImageType == "jpeg" || data.data.DocumentImageType == "jpg" || data.data.DocumentImageType == "png") {
					ViewImage(data.data.document);
				} else if (data.data.DocumentImageType == "pdf") {
					GeneratePDF(data.data.document);

				} else if (data.data.DocumentImageType == "mp4") {
					ViewVideo(data.data.document);

				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#activitydiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getMiscActivity(page) {

	var jsondata = {
		"currentPage": page,
	}
	$
		.ajax(
			{
				url: '../admin/getMiscActivity',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#work').unblock();
				if (data.status == '1') {
					$("#miscData").empty();
					$("#miscData").append(data.miscData);

					var pageNumber = page;
					var totalPages = data.TotalPages;
				} else {
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}


function LoadPageData(pageid) {
	getMiscActivity(pageid)
}

function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg/pdf;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}

function ViewVideo(base64) {
	var video = document.createElement('video');
	video.src = "data:video/mp4;base64," + base64;
	video.controls = true;

	var w = window.open("");
	w.document.write(video.outerHTML);
}


function _base64ToArrayBuffer(base64) {
	var binary_string = window.atob(base64);
	var len = binary_string.length;


	var bytes = new Uint8Array(len);
	for (var i = 0; i < len; i++) {
		bytes[i] = binary_string.charCodeAt(i);
	}
	return bytes;
}

function GeneratePDF(base64data) {

	var file = new Blob(
		[_base64ToArrayBuffer(base64data)],
		{ type: 'application/pdf' }
	);
	var fileURL = URL.createObjectURL(file);
	var newWindow = window.open(fileURL, '_blank');
	newWindow.onload = function() {
		const embedTag = newWindow.document.getElementsByTagName('embed')[0]; // or document.querySelector('embed');
		embedTag.style.position = 'absolute';
	};

}




