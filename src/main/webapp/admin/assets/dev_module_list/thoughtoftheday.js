$(document).ready(function() {
	mockjax1('thoughtofthedaytbl');
	dt = dataTable('thoughtofthedaytbl');
	$("#fillform").show();
	$("#UploadExcel").hide();
	//	$(".hide1").hide();
	//	$(".hide2").hide();
	$(".upload").click(function() {
		if ($(this).is(":checked")) {
			$(".hide2").show();
			$(".hide1").hide();
		} else {
			$(".hide1").hide();
		}
	});
	$(".fill").click(function() {
		if ($(this).is(":checked")) {
			$(".hide1").show();
			$(".hide2").hide();
		} else {
			$(".hide2").hide();
		}
	});


});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("thoughtbtn").onclick =
		function() {
			return SaveThoughtData();
		};

	document.getElementById("resetbtn").onclick =
		function() {
			return ResetInput();
		};

	document.getElementById('thought').onkeypress =
		function() {
			return OnlyAlphabetAndSpace(event);
		};


});


function SaveThoughtData() {

	var savetype = $('input[name="Choise"]:checked').val();

	if (savetype == "Fillform") {
		var thoughtOfDay = document.getElementById("thought").value;


		var res = CheckNullorBlank('thought');
		if (res !== "true") {
			$.confirm({
				title: '',
				content: res + "Thoughts",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-green',
						keys: ['enter', 'shift'],

					}
				}
			});
			$('#thought').focus();
			return false;
		}
		var res = MinumumLengthCheck('thought', 2);
		if (res !== "true") {
			$.confirm({
				title: '',
				content: "Thoughts" + res,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-green',
						keys: ['enter', 'shift'],

					}
				}
			});
			$('#thought').focus();
			return false;
		}
		var res = MaximumLengthCheck('thought', 128);
		if (res !== "true") {
			$.confirm({
				title: '',
				content: "Thoughts" + res,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-green',
						keys: ['enter', 'shift'],
					}
				}
			});
			$('#thought').focus();
			return false;
		}

		$('#categorydiv').block({ message: 'Please wait....' });
		if (document.getElementById("actiontype").value == "add") {
			var jsondata = {
				"id": -1,
				"thoughtOfDay": thoughtOfDay,

			}
		} else {
			var jsondata = {
				"id": document.getElementById("id").value,
				"thoughtOfDay": thoughtOfDay,

			}
		}


		$
			.ajax(
				{
					url: '../admin/SaveThoughtData',
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
						$.alert({
							title: '',
							content: data.message,
						});
					}
				})
			.fail(function(jqXHR, textStatus) {
				$('#categorydiv').unblock();
				$.alert({
					title: '',
					content: jqXHR.responseText,
				});

			});
	}
	else {
		SaveThoughtDataUsingExcel();
	}

}

function SaveThoughtDataUsingExcel() {
	var file_data = $('#thoughtdoc').prop('files')[0];
	var filename = $('#thoughtdoc').val().split('\\').pop();
	
	 if (file_data == undefined || file_data == "" || file_data == null) {
        $.confirm({
				title: '',
				content: "Please choose File",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-green',
						keys: ['enter', 'shift'],
					}
				}
			});
			$('#thought').focus(); 

		
		return false;
	}
	
	var attachFileName = $('#thoughtdoc').prop('files')[0].name;
	var form_data = new FormData();
	form_data.append('uploadDocument', file_data);
	form_data.append('uploadedDocumentName', filename);
	form_data.append('attachmentName', attachFileName);
    
    
   
	
	if (attachFileName.length > 64) {
		alert('File name length should be less than 64 characters');


		return false;
	} else {
		if (!isValidFileName(attachFileName)) {
			alert(' File name, Please use only standard alphanumerics');

			return false;

		}
	} 

	$
		.ajax(
			{
				url: '../admin/UploadExcelForThoughtOfDay',
				type: "POST",
				data: form_data,
				enctype: 'multipart/form-data',
				processData: false,
				contentType: false,
				crossDomain: true

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
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
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
	var orderColunm = '2';
	var orderColunm = order[0][0] + 1;
	var orderType = order[0][1];

	jsondata = [];

	$('#categorydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadThoughtData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
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
							statusData.action
						]);
						FilteredRecords = data.TotalCount;
					}
					$('#categorydiv').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#categorydiv').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
			alert(jqXHR.responseText);
		});

}

function GetThoughtData(id) {
	$('#categorydiv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id
	}

	$.ajax({
		url: '../admin/GetThoughtDataForUpdate',
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
					document.getElementById("thought").value = data.thoughtoftheday;
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("thoughtbtn").innerHTML = "Update";
					$(".hide1").show();
					$(".hide2").hide();
				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
			alert(jqXHR.responseText);

		});

}


function DeleteThoughtData(id) {
	$('#categorydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeleteThoughtData',
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
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#categorydiv').unblock();
			alert(jqXHR.responseText);

		});
}
function ResetInput() {
	window.location.reload();
}

function setevents() {

	document.querySelectorAll('.delete_thought').forEach((items, index) => {
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
						btnClass: 'btn-blue	',
						keys: ['enter', 'shift'],
						action: function() {
							DeleteThoughtData(hid);

						}
					}
				}
			});
		});
	});

	document.querySelectorAll('.edit_thought').forEach((items, index) => {
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
							GetThoughtData(hid);
						}
					}
				}
			});
		});
	});

}