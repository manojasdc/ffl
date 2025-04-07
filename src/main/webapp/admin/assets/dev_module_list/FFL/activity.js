
$(document).ready(function() {

	mockjax1('activitytbl');
	dt = dataTable('activitytbl');
	$("#viewimage").hide();
	$("#viewimage1").hide();

	/*var currentYear = new Date().getFullYear();
	var years = [];
	for (var i = 0; i < 50; i++) {
		years.push(currentYear - i);
	}
	var select = document.getElementById('year');
	for (var i = 0; i < years.length; i++) {
		var option = document.createElement('option');
		option.text = years[i];
		option.value = years[i];
		select.appendChild(option);
	}*/

	var role = document.getElementById("role").value;
	if (role === "USER") {
		$("#usershow").show();
		getInstitute();
	}
	else {
		$("#usershow").hide();
	}


});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("submitBtn").onclick =
		function() {

			return saveActivityDetail();
		};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

});

function ResetInput() {
	window.location.reload();
}


function getInstitute() {

	$('#registrationdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getInstituteforActivity',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>---Select Institute---</option>";
				$.each(data.institutelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.institute_name + "</option>";
				});

				$('#instituteId').html(selectHtml);
				$('#registrationdiv').unblock();

			})
		.fail(function(jqXHR, textStatus) {
			$('#registrationdiv').unblock();
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

function ViewVideo(base64) {
	var video = document.createElement('video');
	video.src = "data:video/mp4;base64," + base64;
	video.controls = true;

	var w = window.open("");
	w.document.write(video.outerHTML);
}


function saveActivityDetail() {

	
	var miscTitle = document.getElementById("miscTitle").value;
	var miscDescription = document.getElementById("miscDescription").value;
	//var year = document.getElementById("year").value;
	var actiontype = document.getElementById("actiontype").value;
	var role = document.getElementById("role").value;
	if (role === "USER") {
		var instituteId = document.getElementById("instituteId").value
	}

	//	$('#activitydiv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {
		var res = CheckNullorBlank('uploadImage');
		if (res !== "true") {
			$('#uploadImage').focus();
			$.confirm({
				title: '',
				content: "Please Upload Blog Document",
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

		var res = CheckNullorBlank('image');
		if (res !== "true") {
			$('#image').focus();

			$.confirm({
				title: '',
				content: "Please Upload Image",
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

		img_size = 2097152;

		var filesizeDocument = $('#image')[0].files[0].size;

		if (filesizeDocument > img_size) {
			$('#image').focus();
			$.confirm({
				title: '',
				content: "Please Upload Maximum 2 mb Blog Image.",
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

		var filesizeDocument1 = $('#uploadImage')[0].files[0].size;

		if (filesizeDocument1 > img_size) {
			$('#uploadImage').focus();
			$.confirm({
				title: '',
				content: "Please Upload Maximum 2 mb Blog Document. ",
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







	var res = CheckNullorBlank('miscTitle');
	if (res !== "true") {
		$('#miscTitle').focus();

		$.confirm({
			title: '',
			content: res + "Blog Title",
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


	var res = MinumumLengthCheck('miscTitle', 2);
	if (res !== "true") {
		$('#miscTitle').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Title.",
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

	var res = MaximumLengthCheck('miscTitle', 100);
	if (res !== "true") {
		$('#miscTitle').focus();
		$.confirm({
			title: '',
			content: "Blog Title Should Contains Only 100 Digits.",
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



	var res = CheckNullorBlank('miscDescription');
	if (res !== "true") {
		$('#miscTitle').focus();
		$.confirm({
			title: '',
			content: res + " Blog Description",
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



	var res = MinumumLengthCheck('miscDescription', 2);
	if (res !== "true") {
		$('#miscDescription').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Blog Description.",
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


	var res = MaximumLengthCheck('miscDescription', 256);
	if (res !== "true") {
		$('#miscDescription').focus();
		$.confirm({
			title: '',
			content: "Blog Description Should Contains Only 256 Digits and Characters.",
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

	/*var res = CheckNullorBlank('year');
	if (res !== "true") {
		$('#year').focus();
		$.confirm({
			title: '',
			content: "Please select Year.",
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
	}*/


	var instituteId = document.getElementById("instituteId").value;
	if (instituteId == -1) {
		$.confirm({
			title: '',
			content: "Please Select Institute Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#instituteId').focus();
					}
				}
			}
		});
		return false; // Prevent further action (e.g., form submission)
	}

	var actionType = "";
	if (document.getElementById("actiontype").value == "add") {
		if (role === "USER") {
			var jsondata = {

				"miscTitle": miscTitle,
				"miscDescription": miscDescription,
				//"year": year,
				"instituteMap": instituteId,


			}
		}
		else {

			var jsondata = {

				"miscTitle": miscTitle,
				"miscDescription": miscDescription,
				//"year": year,


			}
		}
		actionType = "add";
	} else {
		if (role === "USER") {
			var jsondata = {
				"id": document.getElementById("id").value,
				"miscTitle": miscTitle,
				"miscDescription": miscDescription,
				//"year": year,
				"instituteMap": instituteId,


			}
		}
		else {
			var jsondata = {
				"id": document.getElementById("id").value,
				"miscTitle": miscTitle,
				"miscDescription": miscDescription,
				//"year": year,
			}
		}
		actionType = "update";

	}

	var formData = new FormData();
	formData.append("activitydetail", JSON.stringify(jsondata));
	formData.append("uploadImage", $('#uploadImage')[0].files[0])
	formData.append("uploadbackgroundImage", $('#image')[0].files[0])

	$.ajax(
		{
			url: '../admin/saveActivityDetail',
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
				$('#activitydiv').unblock();
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
			$('#activitydiv').unblock();
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
				"targets": [0,3,4,5], // The column index you want to disable sorting for (0-based)
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

	$('#activitydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadActivity?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.title,
							statusData.description,
							//statusData.year,
							statusData.ShowImage,
							statusData.rejectedRemarks,
							statusData.action
						]);


					}
					$('#activitydiv').unblock();
					FilteredRecords = data.TotalCount;
					setTimeout(setevents, 1000);
				} else {
					$('#activitydiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

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


function Getactimage(id) {

	$('#activitydiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id,
		
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
				if (data.status == '1') {
					if (data.data.DocumentImageType == "jpeg" || data.data.DocumentImageType == "jpg" || data.data.DocumentImageType == "png") {
						ViewImage(data.data.document);
					} else if (data.data.DocumentImageType == "pdf") {
						GeneratePDF(data.data.document);

					} else if (data.data.DocumentImageType == "mp4") {
						ViewVideo(data.data.document);

					}
				}
				else {
					$.alert({
						title: '',
						content: data.message,
					});
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


function deleteActivity(id) {
	$('#activitydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/deleteActivity',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#activitydiv').unblock();
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
			$('#activitydiv').unblock();
//			alert(jqXHR.responseText);

		});
}

function GetActivityDetailforUpdate(id) {
	$('#activitydiv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetActivityDetailforUpdate',
		type: "POST",
		data: JSON.stringify(jsondata),
		contentType: 'application/json',
		cors: true,
		dataType: 'json',

	})
		.done(

			function(data) {
				console.log(data);
				$('#activitydiv').unblock();
				if (data.status == '1') {
					document.getElementById("id").value = data.id;
					document.getElementById("miscTitle").value = data.title;
					document.getElementById("miscDescription").value = data.desc;
					//document.getElementById("year").value = data.year;
					//					document.getElementById("instituteId").value = data.instituteId;

					$('#instituteId').val(data.instituteId);
					$('#instituteId').select2();
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("submitBtn").innerHTML = "Update";
					document.getElementById("titleupdate").innerHTML = "Update Blog";
					document.getElementById("reset").innerHTML = "Cancel";

					$("#viewimage").show();
					document.getElementById('viewimage').onclick = function() {
						return Getactimage(data.docid);
					};
					$("#viewimage1").show();
					document.getElementById('viewimage1').onclick =
						function() {
							return Getcoverphoto1(data.docid);
						};


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
			$('#activitydiv').unblock();
//			alert(jqXHR.responseText);

		});

}

function Getcoverphoto1(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getcoverphoto1',
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

var a = "false";
function setevents() {

	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {

			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;

			Getactimage(hida);


		});
	});
	// Assuming the role is passed from the server as a global variable
	const userRole = document.getElementById("role").value; // Fetch the role from a hidden input or a similar element

	if (userRole === "ADMIN") {
	    // Allow only institute users to bind update and delete functionality

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
	                            a = "false";
	                        },
	                        OK: {
	                            text: 'OK',
	                            btnClass: 'btn-blue',
	                            keys: ['enter', 'shift'],
	                            action: function() {
	                                GetActivityDetailforUpdate(hida);
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
	                            a = "false";
	                        },
	                        OK: {
	                            text: 'OK',
	                            btnClass: 'btn-blue',
	                            keys: ['enter', 'shift'],
	                            action: function() {
	                                deleteActivity(hida);
	                            }
	                        }
	                    }
	                });
	            }
	        });
	    });
	} else {
	    // Disable buttons for non-institute users
	    document.querySelectorAll('.edit_imagedata, .delete_imagedata').forEach(button => {
	        button.style.pointerEvents = "none";
	        button.style.opacity = "0.5"; // Visually disable the buttons
	    });
	}


function ResetInput() {
	window.location.reload();
}

}