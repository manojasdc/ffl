$(document).ready(function() {
	getallnews(1);


});





document.addEventListener('DOMContentLoaded', function() {


	var totalpages = document.getElementById("totalpage").value;

	var data = "";
	var counter = 1;

	for (var i = 0; i < totalpages; i++) {

		data += '<li' 
			+ '><a href="javascript:void(0)"'+ (counter === 1 ? ' class="active"' : '')+' id="page' + counter + '">'
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

	

	document.addEventListener('click', (event) => {
		if (event.target.matches('.openpdf')) {
			event.preventDefault();
			var val = Array.from(document.querySelectorAll('.openpdf')).indexOf(event.target) + 1;
			var hid = document.getElementById('hid' + val).value;
			GetPDFuser1(hid);
		}

	});

	document.addEventListener('click', (event) => {
		if (event.target.matches('.openpdf1')) {
			event.preventDefault();
			var val = Array.from(document.querySelectorAll('.openpdf1')).indexOf(event.target) + 1;

			var hid = document.getElementById('hid' + val).value;
			GetPDFuser1(hid);
		}

	});

	


});

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

function GetPDFuser1(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/GetPDFNews',
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
					//					document.getElementById("uploadPdf").value = data.id;
					GeneratePDF(data.data.document);

				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#journaldiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getallnews(page) {

	var jsondata = {
		"currentPage": page,

	}
	$
		.ajax(
			{
				url: '../admin/getallnews',
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
					//					if(data.notdata === ""){
					//						$("#allNData").append("No data Found");
					//					}
					//					else{
					$("#allNData").empty();

					$("#allNData").append(data.notdata);

					var pageNumber = page;
					// Current page number

					var totalItems = data.NewsLettersCount;
					//                    }
					// Total count of items
					//					var paginationInfo = displayPaginationInfo(pageNumber, itemsPerPage, totalItems);

					//					document.getElementById("paginationInfo").innerHTML = paginationInfo;
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
	getallnews(pageid)
}

