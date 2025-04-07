$(document).ready(function() {
	
	document.getElementById('publisherDate').max = new Date().toISOString().split('T')[0];

	mockjax1('journaltbl');
	dt = dataTable('journaltbl');

	$("#viewimage").hide();
	$("#viewimage1").hide();

});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("journalbtn").onclick =
		function() {

			return SaveUserEJournalData();
		};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

	const pasteBox1 = document.getElementById("publisherDate");
	pasteBox1.onpaste = e => {
		e.preventDefault();
		return false;
	};

	$("#publisherDate").on("keydown", function(e) {
		e.preventDefault();
	});

	document.getElementById('bookLength').onkeypress =
		function() {
			return AllowOnlyDigit(event, this);
		};

});

function ResetInput() {
	window.location.reload();
}

function GetuserejournalDataForUpdate(id) {
	$('#categorydiv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetuserejournalDataForUpdate',
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
					document.getElementById("name").value = data.name;
					document.getElementById("description").value = data.description;
					document.getElementById("category").value = data.category;

					document.getElementById("publisher").value = data.publisher;
					document.getElementById("publisherDate").value = data.publisherDate;
					document.getElementById("language").value = data.language;
					document.getElementById("bookLength").value = data.bookLength;
					document.getElementById("author").value = data.author;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("journalbtn").innerHTML = "Update";
					document.getElementById("titleupdate").innerHTML = "Update E-Journal";
					document.getElementById("reset").innerHTML = "Cancel";

					$("#viewimage").show();
					document.getElementById('viewimage').onclick =
						function() {
							return GetPDFuser1(data.docid);
						};
					$("#viewimage1").show();
					document.getElementById('viewimage1').onclick =
						function() {
							return Getcoverphoto(data.docid);
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
			$('#categorydiv').unblock();
//			alert(jqXHR.responseText);

		});

}

function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg/pdf;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}

function ViewImage1(base64) {

	var image = new Image();

	image.src = "data:image/jpg/pdf;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);
}


function DeleteuserejournalData(id) {
	$('#categorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteuserejournalData',
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
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
//			alert(jqXHR.responseText);

		});
}
function SaveUserEJournalData() {

	var name = document.getElementById("name").value;
	var description = document.getElementById("description").value;
	var category = document.getElementById("category").value;
	var publisher = document.getElementById("publisher").value;
	var publisherDate = document.getElementById("publisherDate").value;
	var language = document.getElementById("language").value;
	var bookLength = document.getElementById("bookLength").value;
	var author = document.getElementById("author").value;
	//	var coverPhoto = document.getElementById("coverPhoto").value;

	var actiontype = document.getElementById("actiontype").value;

	var res = CheckNullorBlank('name');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal Title",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#name').focus();
					}
				}
			}
		});

		return false;
	}

	var res = MinumumLengthCheck('name', 2);
	if (res !== "true") {
		$('#name').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Journal Title.",
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


	var res = CheckNullorBlank('description');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal description",
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

	var res = CheckNullorBlank('category');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal Category",
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
		return false;
	}

	var res = CheckNullorBlank('publisher');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal publisher",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#publisher').focus();
					}
				}
			}
		});

		return false;
	}

	var res = MinumumLengthCheck('publisher', 2);
	if (res !== "true") {
		$('#publisher').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Publisher.",
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


	var res = CheckNullorBlankDate('publisherDate');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Publisher Date",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#publisherDate').focus();
					}
				}
			}
		});

		return false;
	}

	var res = CheckNullorBlank('language');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal language",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#language').focus();
					}
				}
			}
		});
		return false;
	}


	var res = MinumumLengthCheck('language', 2);
	if (res !== "true") {
		$('#language').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Language.",
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

	var res = CheckNullorBlank('bookLength');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Journal Book Length",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#bookLength').focus();
					}
				}
			}
		});
		return false;
	}

	var res = OnlyDifitRegExDecimal('bookLength');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: "Book Length " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#bookLength').focus();
					}
				}
			}
		});
		return false;
	}

	var res = validateFourDigitNumber('bookLength');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: "maximum Book Length is in 4 digit.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#bookLength').focus();
					}
				}
			}
		});
		return false;
	}



	if (document.getElementById("actiontype").value == "add") {
		img_size = 2097152;
		var res = CheckNullorBlank('coverPhoto');
		if (res !== "true") {
			$.confirm({
				title: '',
				content: "Please Upload Cover Photo",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							$('#coverPhoto').focus();
						}
					}
				}
			});
			return false;
		}

		var filesizeDocument1 = $('#coverPhoto')[0].files[0].size;

		if (filesizeDocument1 > img_size) {
			$('#coverPhoto').focus();
			$.confirm({
				title: '',
				content: "Please Upload document upto Maximum 2 MB size For Cover Photo?",
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


		var res = CheckNullorBlank('uploadPdf');
		if (res !== "true") {
			$.confirm({
				title: '',
				content: "Please Upload Journal Pdf",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
							$('#uploadPdf').focus();
						}
					}
				}
			});
			return false;
		}


		var filesizeDocument = $('#uploadPdf')[0].files[0].size;

		if (filesizeDocument > img_size) {
			$('#uploadPdf').focus();
			$.confirm({
				title: '',
				content: "Please Upload document upto Maximum 2 MB size For Upload Journal PDF?",
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


	var res = CheckNullorBlank('author');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Author Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#author').focus();
					}
				}
			}
		});
		return false;
	}

	var res = MinumumLengthCheck('author', 2);
	if (res !== "true") {
		$('#author').focus();
		$.confirm({
			title: '',
			content: "Please enter at least two letters of Author.",
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



	$('#journaldiv').block({ message: 'Please wait....' });
	var actionType = "";



	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"name": name,
			"description": description,
			"category": category,
			"publisher": publisher,
			"publisherDate": publisherDate,
			"language": language,
			"bookLength": bookLength,
			"author": author,
			//			"coverPhoto": coverPhoto,


		}
		actionType = "add";
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"name": name,
			"description": description,
			"category": category,
			"publisher": publisher,
			"publisherDate": publisherDate,
			"language": language,
			"bookLength": bookLength,
			"author": author,
			//			"coverPhoto": coverPhoto,
		}

		actionType = "update";

	}

	var formData = new FormData();
	formData.append("journaldetail", JSON.stringify(jsondata));
	formData.append("uploadPdf", $('#uploadPdf')[0].files[0])
	formData.append("coverphoto", $('#coverPhoto')[0].files[0])

	$.ajax(
		{
			url: '../admin/SaveUserEJournalData',
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

//
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
				"targets": [0, 5, 10, 11], // The column index you want to disable sorting for (0-based)
				"orderable": false,
			}]

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
			url: '../admin/LoadUserJournalData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.name,
							statusData.description,
							statusData.author,
							statusData.category,
							statusData.ShowImage,

							statusData.publisher,
							statusData.publisherDate,
							statusData.language,
							statusData.bookLength,
							statusData.coverPhoto,
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
			GetPDFuser1(hida);

		});
	});

	document.querySelectorAll('.coverphoto').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			//alert("hida" + hida);
			Getcoverphoto(hida);

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
								GetuserejournalDataForUpdate(hida);
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
								DeleteuserejournalData(hida);
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



function GetPDFuser1(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/GetPDFuser1',
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


function Getcoverphoto(id) {

	$('#journaldiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}


	$
		.ajax(
			{
				url: '../admin/Getcoverphoto',
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

		});
}


// added by me


/*function FutureDateCheck(publisherDate) {
    // Get the date value from the input field
    var dateInput = $('#' + publisherDate).val().trim();

    // Convert input value to a JavaScript Date object
    var enteredDate = new Date(dateInput);

    // Get today's date without time for comparison
    var today = new Date();
    today.setHours(0, 0, 0, 0); // Reset hours to 00:00:00 to compare only dates

    var message = "";

    // Validation logic: Check if the entered date is in the future
    if (enteredDate > today) {
        message = "Publisher Date cannot be a future date.";
    } else {
        message = "true"; // Valid date
    }

    return message;
}



var res = FutureDateCheck('publisherDate');
if (res !== "true") {
    $('#publisherDate').focus();
    $.confirm({
        title: '',
        content: res, // Display the error message returned by the function
        buttons: {
            OK: {
                text: 'OK',
                btnClass: 'btn-blue',
                keys: ['enter', 'shift'],
                action: function() {
                    // Additional actions can be added here if needed
                }
            }
        }
    });
    return false;
}
*/