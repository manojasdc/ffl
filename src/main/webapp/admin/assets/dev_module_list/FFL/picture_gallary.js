$(document).ready(function() {

	//
	mockjax1('photogallarytbl');
	dt = dataTable('photogallarytbl');
	//
	//	$('#PDFModal .close').on('click', function() {
	//		$('#PDFModal').modal('hide');
	//	});
	//
	$("#viewimage").hide();

});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("journalbtn").onclick =
		function() {

			return SavePictureGallaryData();
		};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

});

function ResetInput() {
	window.location.reload();
}

//
function GetpicturegallaryDataForUpdate(id) {
	$('#categorydiv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetpicturegallaryDataForUpdate',
		type: "POST",
		data: JSON.stringify(jsondata),
		contentType: 'application/json',
		cors: true,
		dataType: 'json',

	})
		.done(

			function(data) {
				console.log(data);
				$('#categorydiv').unblock();
				if (data.status == '1') {
					document.getElementById("description").value = data.description;
					document.getElementById("category").value = data.category;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("journalbtn").innerHTML = "Update";
					document.getElementById("titleupdate").innerHTML = "Update Picture Gallery";
					document.getElementById("reset").innerHTML = "Cancel";

					$("#viewimage").show();
					document.getElementById('viewimage').onclick =
						function() {
							return Getimageforuser1(data.docid);
						};

					//					alert(data.uploadPdf)

					//					$(".hide1").show();
					//					$(".hide2").hide();
				} else {
					$('#journaldiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
//			alert(jqXHR.responseText);

		});

}
//
function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg/pdf;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}
//
//
function DeletepicturegallaryData(id) {
	$('#categorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeletepicturegallaryData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#categorydiv').unblock();
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
			$('#categorydiv').unblock();
//			alert(jqXHR.responseText);

		});
}
function SavePictureGallaryData() {

	var actiontype = document.getElementById("actiontype").value;

	var category = document.getElementById("category").value;
	if (category == -1) {
		$.confirm({
			title: '',
			content: "Please Select Picture Category",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#category').focus();
					}
				}
			}
		});
		return false; // Prevent further action (e.g., form submission)
	}

	var description = document.getElementById("description").value;
	var res = CheckNullorBlank('description');
	if (res !== "true") {
		$('#description').focus();
		$.confirm({
			title: '',
			content: "Please Enter Picture Description ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}

	var res = MinumumLengthCheck('description', 2);
	if (res !== "true") {
		$('#description').focus();
		$.confirm({
			title: '',
			content: "Picture Description Should Contains at least 2 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}

	var res = MaximumLengthCheck('description', 256);
	if (res !== "true") {
		$('#description').focus();
		$.confirm({
			title: '',
			content: "Picture Description Should Contains Only 256 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}


	if (document.getElementById("actiontype").value == "add") {

		var res = CheckNullorBlank('imageUpload');
		if (res !== "true") {
			$.confirm({
				title: '',
				content: "Please Upload Picture",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							$('#imageUpload').focus();
						}
					}
				}
			});

			return false;
		}

		img_size = 2097152;

		var filesizeDocument = $('#imageUpload')[0].files[0].size;

		if (filesizeDocument > img_size) {
			$('#imageUpload').focus();
			$.confirm({
				title: '',
				content: "Please Upload Maximum 2 mb Image or PDF",
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

	$('#journaldiv').block({ message: 'Please wait....' });



	var actionType = "";
	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"description": description,
			"category": category,


		}
		actionType = "add";
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"description": description,
			"category": category,
		}
		actionType = "update";
	}

	var formData = new FormData();
	formData.append("picturegallary", JSON.stringify(jsondata));
	formData.append("imageUpload", $('input[type=file]')[0].files[0])

	$.ajax(
		{
			url: '../admin/SavePictureGallaryData',
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
				$('#journaldiv').unblock();
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
			$('#journaldiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}

////
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
				"targets": [0, 3, 4], // The column index you want to disable sorting for (0-based)
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

	$('#societydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadPictureGallaryData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.description,
							statusData.category,
							statusData.ShowImage,
							statusData.action

						]);

					}
					$('#journaldiv').unblock();
					FilteredRecords = data.TotalCount;
					setTimeout(setevents, 1000);
				} else {
					$('#journaldiv').unblock();
					$.alert({
						title: '',
						content: data.message,
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

var a = "false";
function setevents() {

	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			//alert("hida" + hida);
			Getimageforuser1(hida);

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
								GetpicturegallaryDataForUpdate(hida);
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
								DeletepicturegallaryData(hida);
							}
						}
					}
				});
			}
		});
	});

}
//
function ResetInput() {
	window.location.reload();
}
//
//
//
function Getimageforuser1(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getimageforuser1',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',
			})
		.done(
			function(data) {
				if (data.status == '1') {
					if (data.data.DocumentImageType == "jpeg" || data.data.DocumentImageType == "jpg" || data.data.DocumentImageType == "png") {
						ViewImage(data.data.document);
					} else if (data.data.DocumentImageType == "pdf") {
						//					document.getElementById("uploadPdf").value = data.id;
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
		.fail(function(jqXHR, textStatus) {
			$('#journaldiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}
//
//
//