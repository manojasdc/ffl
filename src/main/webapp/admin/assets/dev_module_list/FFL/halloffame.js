
$(document).ready(function() {


	mockjax1('halloffametbl');
	dt = dataTable('halloffametbl');
	$("#viewimage").hide();


});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("submitBtn").onclick =
		function() {

			return saveHallOfFame();
		};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};


});

function ResetInput() {
	alert("hi")
	window.location.reload();
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



function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}


function saveHallOfFame() {

	var achievement = document.getElementById("achievement").value;
	var actiontype = document.getElementById("actiontype").value;

	img_size = 2097152;

	//	$('#halloffamediv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {

		var res = CheckNullorBlankDate('uploadPic');
		if (res !== "true") {
			$('#uploadPic').focus();
			$.confirm({
				title: '',
				content: res + " Upload Photo",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							//						window.location.reload();
						}
					}
				}
			});

			return false;
		}

		var filesizeDocument = $('#uploadPic')[0].files[0].size;

		if (filesizeDocument > img_size) {
			$('#uploadPic').focus();
			$.confirm({
				title: '',
				content: "Please Upload Maximum 2 MB Image",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							//window.location.reload();
						}
					}
				}
			});

			return false;
		}

	}
	var res = CheckNullorBlank('achievement');
	if (res !== "true") {
		$('#achievement').focus();
		$.confirm({
			title: '',
			content: res + "Achievement",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						//						window.location.reload();
					}
				}
			}
		});

		return false;
	}


	var res = MinumumLengthCheck('achievement', 2);
	if (res !== "true") {
		$('#achievement').focus();
		$.confirm({
			title: '',
			content: "Achievement Should Contains at least 2 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('achievement', 256);
	if (res !== "true") {
		$('#achievement').focus();
		$.confirm({
			title: '',
			content: "Achievement Should Contains Only 256 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}

	var actionType = "";

	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"achievement": achievement,

		}
		actionType = "add";
	}

	else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"achievement": achievement,
		}
		actionType = "update";
		//		alert(actionType)

	}

	var formData = new FormData();
	formData.append("halloffamedetail", JSON.stringify(jsondata));
	formData.append("uploadImage", $('input[type=file]')[0].files[0])

	$.ajax(
		{
			url: '../admin/saveHallOfFame',
			type: "POST",
			data: formData,
			dataType: 'json',
			processData: false,
			contentType: false,
			cache: false,
			enctype: 'multipart/form-data',
			headers: {
				'X-Action-Type': actionType // Custom header
			}


		})
		.done(
			function(data) {
				$('#halloffamediv').unblock();
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
							buttons: {
							OK: {
								text: 'OK',
								btnClass: 'btn-blue',
								keys: ['enter', 'shift'],
								action: function() {
//									window.location.reload();
								}
							}
						}
						});
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
function dataTable(tableName) {
	var table = $('#' + tableName).DataTable({
		"order": [[0, "null"]],
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
		"serverSide": true,
		"columnDefs": [
			{
				"targets": [0, 2, 3], // The column index you want to disable sorting for (0-based)
				"orderable": false
			}
		]

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

	$('#halloffamediv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadhallOfFame?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.achievement,
							statusData.ShowImage,
							//							statusData.rejectedRemarks,
							statusData.action
						]);


					}
					$('#halloffamediv').unblock();
					FilteredRecords = data.TotalCount;
					setTimeout(setevents, 1000);
				} else {
					$('#halloffamediv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,

			});

		});
}


function Getimage(id) {

	$('#halloffamediv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getimage',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',
			})
		.done(function(data) {
			if (data.status == '1') {
				if (data.data.DocumentImageType == "jpeg" || data.data.DocumentImageType == "jpg" || data.data.DocumentImageType == "png") {
					ViewImage(data.data.document);
				} else if (data.data.DocumentImageType == "pdf") {
					GeneratePDF(data.data.document);
				} 
			} else {
				$('#halloffamediv').unblock();
				$.alert({
					title: '',
					content: data.message,
				});
			}
		})
}


function DeleteHallOfFame(id) {
	$('#categorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteHallOfFame',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#halloffamediv').unblock();
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
					$('#journaldiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
//			alert(jqXHR.responseText);

		});
}

function GetHallOfFameForUpdate(id) {
	$('#halloffamediv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetHallOfFameForUpdate',
		type: "POST",
		data: JSON.stringify(jsondata),
		contentType: 'application/json',
		cors: true,
		dataType: 'json',

	})
		.done(

			function(data) {
				console.log(data);
				$('#halloffamediv').unblock();
				if (data.status == '1') {

					document.getElementById("achievement").value = data.achievement;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("submitBtn").innerHTML = "Update";
					document.getElementById("titleupdate").innerHTML = "Update  Hall Of Fame";
					document.getElementById("reset").innerHTML = "Cancel";
					$("#viewimage").show();
					document.getElementById('viewimage').onclick =
						function() {
							return Getimage(data.docid);
						};


				} else {
					$('#journaldiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
//			alert(jqXHR.responseText);

		});

}

var a = "false";

function setevents() {

	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			Getimage(hida);


		});
	});
	document.querySelectorAll('.edit_imagedata').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;

			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Update This Data?',
					buttons: {

						cancel: function(button) {
							//							ResetInput();
							a = "false";
						},

						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								GetHallOfFameForUpdate(hida);
							}
						}
					}
				});
			}
		});
	});


	document.querySelectorAll('.delete_imagedata').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Delete This Data?',
					buttons: {
						cancel: function(button) {
							//							ResetInput();
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								DeleteHallOfFame(hida);
							}
						}
					}
				});

			}
		});
	});

}

function ResetInput() {
	window.location.reload();
}




