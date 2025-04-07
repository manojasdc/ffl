$(document).ready(function() {

//	document.getElementById("generatenewform").addEventListener("click", function() {
//		window.open("https://docs.google.com/forms/d/e/your_form_id/viewform", "_blank");
//	});


	mockjax1('feedbacktbl');
	dt = dataTable('feedbacktbl');


});




document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("streambtn").onclick =
		function() {

			return SaveFeedbackFormData();
		};
	document.getElementById('reset').onclick =
		function() {
			return ResetInput();
		};
});



function ResetInput() {
	window.location.reload();
}


function SaveFeedbackFormData() {
	var feedbackTitle = document.getElementById("feedbackTitle").value;
	var feedbackURL = document.getElementById("feedbackURL").value;

	var resTitle = CheckNullorBlank('feedbackTitle');
	if (resTitle !== "true") {
		$.confirm({
			title: '',
			content: resTitle + " Feedback Title",
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
		$('#feedbackTitle').focus();
		return false;
	}

	var resURL = CheckNullorBlank('feedbackURL');
	if (resURL !== "true") {
		$.confirm({
			title: '',
			content: resURL + " Feedback URL",
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
		$('#feedbackURL').focus();
		return false;
	}

	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"feedbackTitle": feedbackTitle,
			"feedbackUrl": feedbackURL

		}
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"feedbackTitle": feedbackTitle,
			"feedbackUrl": feedbackURL

		}
	}




	$.ajax({
		type: "POST",
		url: "../admin/SaveFeedbackFormData",
		data: JSON
			.stringify(jsondata),
		contentType: 'application/json',
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#subcategorydiv').unblock();

				if (data.status == '1') {
					$.confirm({
						title: '',
						content: data.message,
						buttons: {


							OK: {
								text: 'OK',
								btnClass: 'btn-blue	',
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
			$('#subcategorydiv').unblock();
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
	var orderColunm = '3';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#subcategorydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadFeedbackFormData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
			type: "POST",
			contentType: 'application/json',
			dataType: 'json'

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
							statusData.url,
							statusData.action

						]);
						FilteredRecords = data.TotalCount;
					}
					$('#subcategorydiv').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#subcategorydiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#subcategorydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}


function GetFeedBackData(id) {
	$('#subcategorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/GetFeedbackDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#subcategorydiv').unblock();
				if (data.status == '1') {
					document.getElementById("feedbackTitle").value = data.title;
					document.getElementById("feedbackURL").value = data.feedbackurl;
					document.getElementById("id").value = data.id;
				
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("streambtn").innerHTML = "Update";

				} else {

					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#subcategorydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}
function DeleteDocumentData(id) {
	$('#subcategorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteFeedBackData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#subcategorydiv').unblock();

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
			$('#subcategorydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}
function ResetInput() {
	window.location.reload();
}
function setevents() {

	document.querySelectorAll('.delete_feedbackform').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			$.confirm({
						title: '',
						content: 'Are You Sure You Want to Delete This Data?',
						buttons: {

					cancel: function(button) {
						//return false;
					},

							OK: {
								text: 'OK',
								btnClass: 'btn-blue',
								keys: ['enter', 'shift'],
								action: function() {
							DeleteDocumentData(hid);
						}
							}
						}
					});

		});
	});

	document.querySelectorAll('.edit_feedbackform').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
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
									GetFeedBackData(hid);
						}
							}
						}
					});
		});
	});


}



















































