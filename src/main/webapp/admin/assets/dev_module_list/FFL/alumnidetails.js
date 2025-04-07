
$(document).ready(function() {


	mockjax1('alumnitbl');
	dt = dataTable('alumnitbl');
	$("#viewimage").hide();

	getCountryName();
});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("countryId").onchange =
		function() {
			var id = $('#countryId').val();
			return getStateName(id, 0, "ADD");
		};
	document.getElementById("stateId").onchange =
		function() {
			var id = $('#stateId').val();
			return getCityName(id, 0, "ADD");
		};

	document.getElementById("submitBtn").onclick =
		function() {

			return saveAlumnidata();
		};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

});

function ResetInput() {
	window.location.reload();
}




function getCityName(id, cityid, type) {

	$('#schooldiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getCityName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select City--</option>";
				$.each(data.cityList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.cityName + "</option>";
				});
				$('#cityId').html(selectHtml);
				if (type = 'Edit') {
					$('#cityId').val(cityid);
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#schooldiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getStateName(id, stateid, type) {

	$('#schooldiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getStateName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select State--</option>";
				$.each(data.stateList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.stateName + "</option>";
				});
				$('#stateId').html(selectHtml);
				if (type = 'Edit') {
					$('#stateId').val(stateid);
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#schooldiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getCountryName() {

	$('#schooldiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getCountryName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Country--</option>";
				$.each(data.countryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.countryName + "</option>";
				});
				$('#countryId').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#schooldiv').unblock();
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



function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}


function saveAlumnidata() {
	var img_pdf_length = 2097152;
	var cityId = document.getElementById("cityId").value;
	var stateId = document.getElementById("stateId").value;
	var countryId = document.getElementById("countryId").value;
	var line1 = document.getElementById("line1").value;
	var line2 = document.getElementById("line2").value;
	var pincode = document.getElementById("pincode").value;
	var actiontype = document.getElementById("actiontype").value;

	if (document.getElementById("actiontype").value == "add") {
		var res = CheckNullorBlank('profilePicture');
		if (res !== "true") {
			$('#profilePicture').focus();
			$.confirm({
				title: '',
				content: "Please Upload profile Picture",
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

		var filesizeDocument = $('#profilePicture')[0].files[0].size;

		if (filesizeDocument > img_pdf_length) {
			$('#profilePicture').focus();
			$.confirm({
				title: '',
				content: "Please Upload Maximum 2 MB document",
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

	var res = CheckNullorBlank('line1');
	if (res !== "true") {
		$('#line1').focus();
		$.confirm({
			title: '',
			content: res + "Line 1",
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
	var res = MinumumLengthCheck('line1', 2);
	if (res !== "true") {
		$('#line1').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Line 1.",
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

	var res = MaximumLengthCheck('line1', 512);
	if (res !== "true") {
		$('#line1').focus();
		$.confirm({
			title: '',
			content: " Line 1 Should Contains Only 256 Digits.",
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

	var res = OnlyAlphaNumericSpecialCharacterWithSpaceRegExp('line1');
	if (res !== "true") {
		$('#line1').focus();
		$.confirm({
			title: '',
			content: "Line 1 Should Contains Only AlphaNumeric And Special character Value with Space",
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
	var res = CheckNullorBlank('line2');
	if (res !== "true") {
		$('#line2').focus();
		$.confirm({
			title: '',
			content: res + "Line 2",
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

	var res = MinumumLengthCheck('line2', 2);
	if (res !== "true") {
		$('#line2').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Line 2.",
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

	var res = MaximumLengthCheck('line2', 512);
	if (res !== "true") {
		$('#line2').focus();
		$.confirm({
			title: '',
			content: " Line 2 Should Contains Only 256 Digits.",
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


	var res = OnlyAlphaNumericSpecialCharacterWithSpaceRegExp('line2');
	if (res !== "true") {
		$('#line2').focus();
		$.confirm({
			title: '',
			content: "Line 2 Should Contains Only AlphaNumeric And Special character Value with Space",
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
	var res = CheckNullorBlank('pincode');
	if (res !== "true") {
		$('#pincode').focus();
		$.confirm({
			title: '',
			content: res + "Pincode",
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


	$('#halloffamediv').block({ message: 'Please wait....' });

	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"cityId": cityId,
			"stateId": stateId,
			"countryId": countryId,
			"line1": line1,
			"line2": line2,
			"pincode": pincode
		}
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"cityId": cityId,
			"stateId": stateId,
			"countryId": countryId,
			"line1": line1,
			"line2": line2,
			"pincode": pincode
		}

	}

	var formData = new FormData();
	formData.append("alumnidetails", JSON.stringify(jsondata));
	formData.append("uploadImage", $('input[type=file]')[0].files[0])

	$.ajax(
		{
			url: '../admin/saveAlumnidata',
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
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
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
				"targets": [0, 8, 9], // The column index you want to disable sorting for (0-based)
				"orderable": false,
			}],

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
			url: '../admin/Loadalumnidetails?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.line1,
							statusData.line2,
							statusData.countryId,
							statusData.stateId,
							statusData.cityId,
							statusData.pincode,
							//							statusData.rejectedRemarks,
							statusData.ShowImage,
							//statusData.rejectedRemarks,
							statusData.action
						]);

						FilteredRecords = data.TotalCount;
					}
					$('#halloffamediv').unblock();
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
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}


function Getimageforalumni(id) {

	$('#halloffamediv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getimageforalumni',
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


function DeleteAlumni(id) {
	$('#categorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteAlumni',
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

function getAlumniforUpdate(id) {
	$('#halloffamediv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/getAlumniforUpdate',
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

					document.getElementById("line1").value = data.line1;
					document.getElementById("line2").value = data.line2;
					document.getElementById("countryId").value = data.countryId;
					$("#countryId").select2();
					getStateName(data.countryId, data.stateId, "Edit");
					getCityName(data.stateId, data.cityId, "Edit");

					//					document.getElementById("stateId").value = data.stateId;
					//					document.getElementById("cityId").value = data.cityId;
					document.getElementById("pincode").value = data.pincode;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("submitBtn").innerHTML = "Update";
					$("#viewimage").show();
					document.getElementById('viewimage').onclick =
						function() {
							return Getimageforalumni(data.docid);
						};


				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
//			alert(jqXHR.responseText);

		});

}
function setevents() {

	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			Getimageforalumni(hida);


		});
	});
	document.querySelectorAll('.edit_imagedata').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;


			$.confirm({
				title: '',
				content: 'Are You Sure You Want to Update This Data?',
				buttons: {

					cancel: function(button) {
						//return false;
					},

					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							getAlumniforUpdate(hida);
						}
					}
				}
			});
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
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							DeleteAlumni(hida);
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


