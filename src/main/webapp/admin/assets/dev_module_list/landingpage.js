
$(document).ready(function() {

//	getNotifications();

	//		getROName();
	//			$("#RO").hide();
	//		$("#School").hide();



});


function getNotifications() {



	$('#attendancediv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/LoadDashboardviewNotificationData',
				type: "POST",

				cors: true,
				dataType: 'json'

			})
		.done(
			function(data) {
				//	$('#attendancediv').unblock();


				var selectHtml = data.display;
				//selectHtml = selectHtml + "<span class='latest-update'>Latest :</span>";

				//$.each(data.classlist, function(jdIndex, jdData) {
				//	selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				//});
				$('#marqueeList').html(selectHtml);

				setTimeout(setevents_landing, 1000);

			}

		)
		.fail(function(jqXHR, textStatus) {
			$('#attendancediv').unblock();
			//alert(jqXHR.responseText);
			$.confirm({
				title: '',
				content: jqXHR.responseText,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							window.location.reload();
						}
					}
				}
			});

		});
}




function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);

}



function GetImage(id) {

	$('#societydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetImage',
		type: "POST",
		data: JSON
			.stringify(jsondata),
		contentType: 'application/json',
		cors: true,
		dataType: 'json',
	})
		.done(
			function(data) {

				if (data.data.NotificationImageType == "jpeg" || data.data.NotificationImageType == "jpg" || data.data.NotificationImageType == "png") {
					ViewImage(data.data.NotificationImage);
				} else if (data.data.NotificationImageType == "pdf") {
					GeneratePDF(data.data.NotificationImage);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#societydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function GetDocumentForMou(id) {
	var jsondata = {
		"id": id
	}

	$.ajax(
		{
			url: '../admin/GetDocumentForMou',
			type: "POST",
			data: JSON.stringify(jsondata),
			contentType: 'application/json',
			cors: true,
			dataType: 'json',
		})
		.done(
			function(data) {
				if (data.status == '1') {

					if (data.data.mouImageType == "pdf") {
						GeneratePDF(data.data.mouImage)
					} else {
						alert("No Pdf Available");
					}

				} else {
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#homework_material_div').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}
//function _base64ToArrayBuffer(base64) {
//	var binary_string = window.atob(base64);
//	var len = binary_string.length;
//
//
//	var bytes = new Uint8Array(len);
//	for (var i = 0; i < len; i++) {
//		bytes[i] = binary_string.charCodeAt(i);
//	}
//	return bytes;
//}
//
//function GeneratePDF(base64data) {
//	var file = new Blob(
//		[_base64ToArrayBuffer(base64data)],
//		{ type: 'application/pdf' }
//	);
//	var fileURL = URL.createObjectURL(file);
//	var newWindow = window.open(fileURL, '_blank');
//	newWindow.onload = function() {
//		const embedTag = newWindow.document.getElementsByTagName('embed')[0]; // or document.querySelector('embed');
//		embedTag.style.position = 'absolute';
//	};
//
//}



function setevents_landing() {

	document.querySelectorAll('.image_status12').forEach((items, index) => {

		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('viewnoti' + val).value;
			GetImage(hida);
		});
	});

//	document.querySelectorAll('.document_status').forEach((items, index) => {
//		items.addEventListener('click', event => {
//			var val = parseInt(index) + 1;
//			var hida = document.getElementById('hida' + val).value;
//			GetDocumentForMou(hida);
//		});
//	});


}


function ResetInput() {
	window.location.reload();
}



