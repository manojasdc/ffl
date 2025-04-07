
$(document).ready(function() {


	getROName();
	$("#RO").hide();
	$("#School").hide();
	mockjax1('notificationtbl');
	dt = dataTable('notificationtbl');

});



document.addEventListener('DOMContentLoaded', function() {


	document.getElementById("multiselect2").onchange =
		function() {


			var x = document.getElementById("multiselect2").value;
			//if (x === "1") {
			//$("#CompanyCode").show();
			//} else {
			//$("#CompanyCode").hide();
			//}
			if (x === "2") {

				$("#RO").show();
				$("#School").hide();
			}

			else if (x === "3") {
				$("#RO").show();
				$("#School").show();
			} else {
				$("#RO").hide();
				$("#School").hide();
			}
		};

	document.getElementById("roId").onchange =
		function() {

			var id = $('#roId').val();
			if (id == "All") {
				return 0;
			} else {
				return LoadSchoolData(id);
			}


		};
	document.getElementById("savebtn").onclick =
		function() {



			return SaveNotificationData();
		};
	//		
	//		document.getElementById("reset").onclick =
	//			function() {
	//				return ResetInput();
	//		};


	$('.regOffice').on("select2:select", function(e) {
		var data = e.params.data.text;
		if (data == 'All') {
			$(".regOffice > option").prop("selected", "selected");
			$(".regOffice option[value='-1']").prop("selected", false);
			$(".regOffice option[value='All']").prop("selected", false);
			$(".regOffice").trigger("change");
		}
	});
	$('.school').on("select2:select", function(e) {
		var data = e.params.data.text;
		if (data == 'All') {
			$(".school > option").prop("selected", "selected");
			$(".school option[value='-1']").prop("selected", false);
			$(".school option[value='All']").prop("selected", false);
			$(".school").trigger("change");
		}
	});

});



function LoadSchoolData(id) {



	var roId = "";
	for (var value of id) {
		roId += value + ",";
	}

	var jsondata = {
		"id": roId

	}

	$
		.ajax(
			{
				url: '../admin/LoadSchoolData1',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {

				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1' disabled>Please Select</option>" + "<option value='All'>All</option>";
				$.each(data.schoolList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.SchoolName + "</option>";
				});
				$('#schoolId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#citydiv').unblock();
			alert(jqXHR.responseText);

		});
}



function getROName() {

	$
		.ajax(
			{
				url: '../admin/getROName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {

				var selectHtml = "";
				var all = "all";
				selectHtml = selectHtml + "<option value='-1' disabled>Please Select</option>" + "<option value='All'>All</option>";

				$.each(data.roList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.ROName + "</option>";
				});
				$('#roId').html(selectHtml);
				//				jQuery('#coursenamedrp').multiselect({
				//					columns: 1,
				//					placeholder: 'Select Course Name',
				//					data: selectHtml
				//				});
			})
		.fail(function(jqXHR, textStatus) {
			$('#statediv').unblock();
			alert(jqXHR.responseText);

		});
}

function SaveNotificationData() {
	var x = document.getElementById("multiselect2").value;
	var notificationTitle = document.getElementById("notificationTitle").value;
	//var NotificationImage = document.getElementById("NotificationImage").value;
	var description = document.getElementById("description").value;

	//validations
	var res = CheckNullorBlank('notificationTitle');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Notification Title",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#notificationTitle').focus();
					}
				}
			}
		});
		return false;
	}

	var res = OnlyAlphaNumericSpecialCharacterWithSpaceRegExp('notificationTitle');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Notification Title",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#notificationTitle').focus();
					}
				}
			}
		});
		return false;
	}
	
		//Image and PDF validations 
	var file_data = $('#NotificationImage').prop('files')[0];
	var filename = $('#NotificationImage').val().split('\\').pop();

	if (file_data == undefined || file_data == "" || file_data == null) {

		$.confirm({
			title: '',
			content: "Please choose File ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-green',
					keys: ['enter', 'shift'],
					action: function() {
						$('#NotificationImage').focus();
					}
				}
			}
		});
		return false;
	}

	var extDocument = $('#NotificationImage').val().split('.');
	var extvalueDocument = extDocument[extDocument.length - 1];

	if ((extvalueDocument != 'pdf') && 
	(extvalueDocument != 'JPG' && extvalueDocument != 'PNG' && extvalueDocument != 'JPEG' && extvalueDocument != 'jpg' && extvalueDocument != 'png' && extvalueDocument != 'jpeg')) {
		$.confirm({
			title: '',
			content: "Please attach document with .pdf OR with JPG,PNG or JPEG Extension Extension ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-green',
					keys: ['enter', 'shift'],
					action: function() {
						$('#NotificationImage').focus();
					}
				}
			}
		});
		return false;
	}

	var filesizeDocument = $('#NotificationImage')[0].files[0].size;

	if (filesizeDocument > 2097152) {

		$.confirm({
			title: '',
			content: "Please Upload Maximum 2 MB document",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-green',
					keys: ['enter', 'shift'],
					action: function() {
						$('#NotificationImage').focus();
					}
				}
			}
		});
		return false;
	}

	var res = CheckNullorBlank('description');
	if (res !== "true") {

		$.confirm({
			title: '',
			content: res + " Notification Description",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#description').focus();
					}
				}
			}
		});
		return false;
	}

	var res = OnlyAlphaNumericSpecialCharacterWithSpaceRegExp('description');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Notification Description",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#description').focus();
					}
				}
			}
		});
		return false;
	}
	var send_to = $('#multiselect2').val();
	if (send_to == "-1") {
		$('#multiselect2').focus();
		$.confirm({
			title: '',
			content: "Please Select Any Option",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift']
				}
			}
		});
		return false;
	}

	$('#addnotificationdiv').block({ message: 'Please wait....' });


	if (x == "1") {
		if (document.getElementById("actiontype").value == "add") {
			var jsondata = {
				"send_to": x,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		} else {
			var jsondata = {
				"id": document.getElementById("id").value,
				"send_to": x,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		}
	} else if (x == "2") {
		var id = $('#roId').val();

		var roId = "";
		for (var value of id) {
			roId += value + ",";
		}


		if (document.getElementById("actiontype").value == "add") {
			var jsondata = {
				"send_to": x,
				"roIds": roId,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		} else {
			var jsondata = {
				"id": document.getElementById("id").value,
				"roIds": roId,
				"send_to": x,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		}


	}
	else if (x == "3") {


		var id = $('#schoolId').val();
		var schoolId = "";
		for (var value of id) {
			schoolId += value + ",";
		}


		if (document.getElementById("actiontype").value == "add") {
			var jsondata = {
				"send_to": x,
				"schoolIds": schoolId,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		} else {
			var jsondata = {
				"id": document.getElementById("id").value,
				"schoolIds": schoolId,
				"send_to": x,
				"notificationTitle": notificationTitle,
				//	"NotificationImage": NotificationImage,
				"description": description

			}
		}



	}

	var formData = new FormData();
	formData.append("notificationdetail", JSON.stringify(jsondata));
	formData.append("NotificationImage", $('input[type=file]')[0].files[0])

	$.ajax(
		{
			url: '../admin/SaveNotificationData',
			type: "POST",
			data: formData,
			dataType: 'json',
			processData: false,
			contentType: false,
			cache: false,
			enctype: 'multipart/form-data',


		})
		.done(
			function(data) {
				$('#addnotificationdiv').unblock();
				if (data.status == '1') {
					$.confirm({
						title: '',
						content: data.message,
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
				} else {
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#addnotificationdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});
}



function dataTable(tableName) {
	var table = $('#' + tableName).DataTable({
		"order": [[0, "asc"]],
		//		"lengthMenu": [[10, 25, 50, 100, 200, -1], [10, 25, 50, 100, 200, "All"]],
		"lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"scrollY": "400px",
		"scrollX": true,
		"scrollCollapse": true,
		"sPaginationType": "full_numbers",
		"bDestroy": true,
		"bLengthChange": true,
		'language': {
			'loadingRecords': '&nbsp;',
			'processing': '<div class="spinner"></div>'
		},
		ajax: '/test1',
		'processing': true,
		"serverSide": true

	});
	return table;
}
function mockjax1(tableName) {

	$.mockjax({
		url: '/test1',
		responseTime: 1000,
		response: function(settings) {
			$.ajaxSetup({
				async: false
			});
			data(tableName);
			this.responseText = {
				draw: settings.data.draw,
				data: jsondata,
				recordsTotal: jsondata.length,
				recordsFiltered: FilteredRecords
			};


		}
	});
}

function data(tableName) {


	var table = $('#' + tableName).DataTable();
	var info = table.page.info();
	var currentPage = info.page;
	var pageLength = info.length;
	var startPage = info.start;
	var endPage = info.end;
	var Search = table.search();
	var order = table.order();
	var orderColunm = '25';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#societydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadNotificationData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',

		})
		.done(
			function(data) {

				if (data.status == '1') {
					var length = Object.keys(data.data).length;
					for (var i = 0; i < length; i++) {
						var statusData = data.data[i];

						jsondata.push([
							statusData.srno,
							statusData.NotificationTitle,
							statusData.NotificationDescription,
							statusData.send,

							//		statusData.SchoolName,
							statusData.ShowImage,
							statusData.action


						]);



						FilteredRecords = data.TotalCount;
					}
					$('#societydiv').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#societydiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

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


function GetImage(id) {

	$('#societydiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
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


function DeleteImageData(id) {
	$('#societydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteImageData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#societydiv').unblock();

				if (data.status == '1') {
					$.confirm({
						title: '',
						content: data.message,
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
				} else {

					$.alert({
						title: '',
						content: data.message,
					});

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

function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg;base64," + base64;

	var w = window.open("about:blank");
	w.document.write(image.outerHTML);

}

/*function _base64ToArrayBuffer(base64) {
	var binary_string = window.atob(base64);
	var len = binary_string.length;
	var bytes = new Uint8Array(len);
	for (var i = 0; i < len; i++) {
		bytes[i] = binary_string.charCodeAt(i);
	}
	return bytes.buffer;
}*/
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

	document.querySelectorAll('.image_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			//alert("hida" + hida);
			GetImage(hida);

		});
	});

	document.querySelectorAll('.delete_imagedata').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			$.confirm({
				title: '',
				content: 'Are You Sure You Want to Delete This Data?',
				buttons: {


					OK: {
						text: 'OK',
						btnClass: 'btn-green',
						keys: ['enter', 'shift'],
						action: function() {
							DeleteImageData(hida);
						}
					}
				}
			});

		});
	});

}

function ResetInput() {
	window.location.reload();
}


