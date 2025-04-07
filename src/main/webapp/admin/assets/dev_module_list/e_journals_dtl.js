$(document).ready(function() {
	var urlParams = new URLSearchParams(window.location.search);
	var journalId = urlParams.get('id');
	if (journalId) {
		getEjournaldtl(journalId);
	}
});
document.addEventListener('DOMContentLoaded', function() {

	document.addEventListener('click', (event) => {
		if (event.target.matches('.journalpdf1')) {
				event.preventDefault();
				var hid = $('#hid').val();
	
				GetPDFuser1(hid);
			}

	});



	//		document.addEventListener('click', (event) => {
	//		if (event.target.matches('.journalpdf')) {
	//			event.preventDefault();
	//			
	//			var hid = $('.journalpdf').val();
	//			GetPDFuser1(hid);
	//		}

	//	});

	var totalpages = document.getElementById("totalpage").value;
	var data = "";
	var counter = 1;

	for (var i = 0; i < totalpages; i++) {

		data += '<li' + (counter === 1 ? ' class="active"' : '')
			+ '><a href="javascript:void(0)" id="page' + counter + '">'
			+ counter + '</a></li>';
		counter++;
	}
	$("#pagination").append(data);
	for (var i = 0; i < totalpages; i++) {

		(function() {
			var idval = i + 1;

			document.getElementById("page" + idval).onclick = function() {

				for (var j = 1; j <= totalpages; j++) {
					$("#page" + j).parent().removeClass("active");
				}

				$(this).parent().addClass("active");
				return LoadPageData(idval);
			};

		})();
	}

});
function getEjournaldtl(id) {
	$.ajax({
		url: '../admin/getEjournaldtl',
		type: "GET",
		data: { id: id },
		dataType: 'json',
	})
		.done(function(data) {
			$('#E_Journal_dtlPage').unblock();
			if (data.status == '1') {
				$("#EjournalDtl").empty();

				$("#EjournalDtl").append(data.journaldtl);
			} else {
				$.alert({
					title: '',
					content: data.message,
				});
			}
		})
		.fail(function(jqXHR, textStatus) {
			$('#E_Journal_dtlPage').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});
}


function GetPDFuser1(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/GetPDFJournal',
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

function LoadPageData(pageid) {
	getEjournaldtl(pageid);
}





