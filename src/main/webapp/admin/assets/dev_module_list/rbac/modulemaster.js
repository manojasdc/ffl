
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("modulebtn").onclick =
		function() {
			return SaveModuleMasterData();
		};

	document.getElementById("reset_btn").onclick =
		function() {
			ResetInput();
		};
	

});


$(document).ready(function() {
	mockjax1('modulemastertbl');
	dt = dataTable('modulemastertbl');

});

//$(document).ready(function() {
//	var table = $('#modulemastertbl').DataTable({
//		rowReorder: {
//			selector: 'td:nth-child(2)'
//		},
//		responsive: true,
//		"scrollY": "400px",
//		"scrollX": true,
//		"scrollCollapse": true,
//		"bDestroy": true
//	});
//
//
//});
$(document).ready(function() {

	$("#modulename").keypress(function(event) {
		var inputValue = event.which;

		// allow letters and whitespaces only.
		if (!(inputValue == 32) && // space
			!(inputValue > 48 && inputValue < 58) && // numeric (0-9)
			!(inputValue > 64 && inputValue < 91) && // upper alpha (A-Z)
			!(inputValue > 96 && inputValue < 123)) {
			event.preventDefault();
		}
	});
	$('#modulemasterdiv').block({ message: 'Please wait....' });

	//	$.ajax(
	//		{
	//			url: '../admin/LoadModuleMasterData',
	//			type: "POST",
	//			contentType: 'application/json',
	//			dataType: 'json',
	//
	//		})
	//		.done(
	//			function(data) {
	////alert(data.status)
	//				if (data.status == '1') {
	//
	//
	//					$.confirm({
	//						title: '',
	//						content: data.message,
	//
	//
	//						buttons: {
	//
	//
	//							OK: {
	//								text: 'OK',
	//								btnClass: 'btn-blue',
	//								keys: ['enter', 'shift'],
	//								action: function() {
	//									window.location.reload();
	//								}
	//							}
	//						}
	//					});
	//
	//					var length = Object.keys(data.data).length;
	//
	//					$('#modulemastertbl').dataTable().fnClearTable();
	//					for (var i = 0; i < length; i++) {
	//						var statusData = data.data[i];
	//						$('#modulemastertbl').dataTable().fnAddData([
	//							statusData.srno,
	//							statusData.modulename,
	//							statusData.action
	//
	//
	//						]);
	//					}
	//					setTimeout(setevents, 1000);
	//					$('#modulemasterdiv').unblock();
	//				} else {
	//					$('#modulemasterdiv').unblock();
	//					alert(data.message);
	//				}
	//
	//			})
	//		.fail(function(jqXHR, textStatus) {
	//			$('#modulemasterdiv').unblock();
	//			alert(jqXHR.responseText);
	//		});

});
function SaveModuleMasterData() {

	var modulename = document.getElementById("modulename").value.trim();

	if (modulename == "" || modulename == null || modulename == undefined) {
		$.confirm({
			title: '',
			content: "Please Enter Module Name",
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
		return false;
	}
	if (modulename.length < 2) {
		$.confirm({
			title: '',
			content: "Module Name must be of atleast 2 letters",
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
		return false;
	}

	$('#modulemasterdiv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"modulename": modulename,
			"actiontype": document.getElementById("actiontype").value

		}
	} else {
		var jsondata = {
			//   				"id": document.getElementById("id").value,
			"modulename": modulename,
			"actiontype": document.getElementById("actiontype").value,
			"moduleid": document.getElementById("moduleid").value

		}
	}

	$
		.ajax(
			{
				url: '../admin/SaveModuleMasterData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//   	 				$('#titlediv').unblock();
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
//			alert(jqXHR.responseText);
			//alert('File upload failed ...');
		});

}

function GetModuleData(moduleid) {


	$('#modulemasterdiv').block({ message: 'Please wait....' });

	var h4Element = document.getElementById("moduleHeader");
	h4Element.textContent = "Update Module Data";

	var jsondata = {
		"moduleid": moduleid
	}

	$
		.ajax(
			{
				url: '../admin/GetModuleDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#modulemasterdiv').unblock();
				if (data.status == '1') {
					document.getElementById("modulename").value = data.modulename;
					document.getElementById("moduleid").value = data.moduleid;

					document.getElementById("actiontype").value = "Edit";
					document.getElementById("modulebtn").innerHTML = "Update";
					document.getElementById("reset_btn").innerHTML = "Back";
				} else {
					//					alert("----jj");
					alert(data.message);

				}
			})
		.fail(function(jqXHR, textStatus) {
			//alert(jqXHR.responseText);
//			alert('File upload failed ...');
		});
}
function DeleteModuleData(moduleid) {
	$('#modulemasterdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"moduleid": moduleid
	}

	$
		.ajax(
			{
				url: '../admin/DeleteModuleData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#modulemasterdiv').unblock();
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
			$('#modulemasterdiv').unblock();
//			alert(jqXHR.responseText);

		});

}

function ResetInput() {
	window.location.reload();
}

//set events
var a = "false";
function setevents() {

	document.querySelectorAll('.edit_module').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var id = document.getElementById('hid' + val).value;

			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Update This Data?',
					buttons: {
						cancel: function(button) {
							ResetInput();
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";
								GetModuleData(id);
							}
						}
					}
				});
			}
		});
	});
	
	document.querySelectorAll('.delete_module').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var id = document.getElementById('hid' + val).value;

			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Delete This Data?',
					buttons: {
						cancel: function(button) {
							ResetInput();
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";
								DeleteModuleData(id);
							}
						}
					}
				});
			}
		});
	});

}

function dataTable(tableName) {
	var table = $('#' + tableName).DataTable({
		"order": [[1, "asc"]],
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
		"columnDefs": [
			{
				"targets": [0, 2], // The column index you want to disable sorting for (0-based)
				"orderable": false,
			}],
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
//------------------------------------

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
	var orderType = order[0][1];

	jsondata = [];

	$('#modulemastertbl').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadModuleData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.modulename,
							statusData.action
						]);
						FilteredRecords = data.TotalCount;
					}
					$('#modulemastertbl').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#modulemastertbl').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#modulemastertbl').unblock();
//			alert(jqXHR.responseText);
		});

}


