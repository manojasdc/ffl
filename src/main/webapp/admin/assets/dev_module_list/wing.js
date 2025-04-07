$(document).ready(function() {
	mockjax1('wingtbl');
	dt = dataTable('wingtbl');
	
	
});

document.addEventListener('DOMContentLoaded', function() {
	
	document.getElementById('wing_name').onkeypress =
		function() {
			return OnlyAlphabetAndSpace(event);
		};
	document.getElementById("wingbtn").onclick =
		function() {
			return SaveData();
		};
	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};
});

function SaveData() {
	var wingname = document.getElementById("wing_name").value.trim();

	var res = CheckNullorBlank('wing_name');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Wing Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
//					action: function() {
//						window.location.reload();
//					}
				}
			}
		});
		$('#wing_name').focus();
		return false;
	}

	var res1 = OnlyAlphabeAndSpaceRegExp('wing_name');
	if (res1 !== "true") {
		$.confirm({
			title: '',
			content: res1,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
//					action: function() {
//						window.location.reload();
//					}
				}
			}
		});
		$('#wing_name').focus();
		return false;
	}


	$('#wingdiv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"wingName": wingname,
		}
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"wingName": wingname,
		}
	}

	$
		.ajax(
			{
				url: '../admin/SaveWingData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#wingdiv').unblock();
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
			$('#wingdiv').unblock();
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
	var orderType = order[0][1];

	jsondata = [];

	$('#wingdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadWingData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',
			async: false

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
							statusData.action
						]);
						FilteredRecords = data.TotalCount;
					}
					$('#wingdiv').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#wingdiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#wingdiv').unblock();
			alert(jqXHR.responseText);
		});
}




function DeleteWingData(id) {
	$('#wingdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteWingData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#wingdiv').unblock();
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
			$('#wingdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});
}


function getWingData(id) {
	$('#wingdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/getWingDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#wingdiv').unblock();
				if (data.status == '1') {
					document.getElementById("wing_name").value = data.wing;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("wingbtn").innerHTML = "Update";
				} else {
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#wingdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});
}

function setevents() {
	document.querySelectorAll('.edit_wing').forEach((items, index) => {
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
							getWingData(hid);

						}
					}
				}
			});
		});
	});

	document.querySelectorAll('.delete_wing').forEach((items, index) => {
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
							DeleteWingData(hid);
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