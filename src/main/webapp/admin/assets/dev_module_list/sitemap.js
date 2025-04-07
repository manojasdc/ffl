$(document).ready(function() {
	getROName1();
//	getMous1()

	$.ajax({
		url: "/FriendsForLife/feedback-forms",
		type: "GET",
		success: function(feedbackForms) {
			$.each(feedbackForms, function(index, feedbackForm) {
				var listItem = "<li><a href='#'>" + feedbackForm.feedbackTitle + "</a></li>";
				$("#feedbackList1").append(listItem);
			});
		},
		error: function() {
			$("#feedbackList1").append("<li>Error retrieving feedback forms.</li>");
		}
	});

});


function getROName1() {

	$('#roDropDown1').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getRONameWithoutSocietyRO',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#roDropDown1').unblock();
				var selectHtml = "";

				selectHtml = selectHtml + "<li><a href='iaf_edu_airhq?id=1'>Air HQ Region</a></li> ";
				//	selectHtml = selectHtml ;
				$.each(data.roList, function(jdIndex, jdData) {


					selectHtml = selectHtml + "<li><a href='iaf_edu_airhq?id=" + jdData.id + "' value='" + jdData.id + "'>" + jdData.ROName + "</a></li>";
					//<li><a href="iaf_edu_wac">WAC Region</a></li>

				});
				//alert(""+selectHtml);

				$('#roDropDown1').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#roDropDown1').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});


}
function getMous1() {

	$('#mouDropDown_sitemap').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getMouNameandLinks_sitemap',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#mouDropDown_sitemap').unblock();
				var selectHtml = "";

				//				selectHtml = selectHtml + "<li class=''><a href='#'>Mou Documents</a><ul class='custom-sublist sub-menu1'> ";
				//
				//				$.each(data.mouList, function(jdIndex, jdData) {
				//					selectHtml = selectHtml + "<li class=''>" + jdData.universityFiles + "</li>";
				//				});
				//
				//				selectHtml = selectHtml + "</ul></li><li class=''><a href=''>Links For University</a><ul class='custom-sublist sub-menu1'>";

				selectHtml = selectHtml + "<ul class='custom-sublist sub-menu1'>"

				$.each(data.mouList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<li class=''><a target='_blank' href='" + jdData.universityUrl + "'>" + jdData.universityName + "</a></li>";
				});

				$('#mouDropDown_sitemap').html(selectHtml);
				setTimeout(setevents, 1000);
			})
		.fail(function(jqXHR, textStatus) {
			$('#mouDropDown_sitemap').unblock();
			alert(jqXHR.responseText)

		});


}


function GetDocumentForMou(id) {
	var jsondata = {
		"id": id
	}

	$.ajax(
		{
			url: '/FriendsForLife/admin/GetDocumentForMou',
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



function setevents() {



	document.querySelectorAll('.document_status_sitemap').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida_sitemap = document.getElementById('hida_sitemap' + val).value;
			GetDocumentForMou(hida_sitemap);
		});
	});


}

