
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("submodulebtn").onclick =
		function() {
			return SaveSubModuleMasterData();
		};

	document.getElementById("reset_btn").onclick =
		function() {
			ResetInput();
		};
});



$(document).ready(function() {
	//	var table = $('#submodulemastertbl').DataTable({
	//		rowReorder: {
	//			selector: 'td:nth-child(2)'
	//		},
	//		responsive: true,
	//		"scrollY": "400px",
	//		"scrollX": true,
	//		"scrollCollapse": true,
	//	});
	mockjax1('submodulemastertbl');
	dt = dataTable('submodulemastertbl');
	getModuleName();
});
$(document).ready(function() {

	$("#submodname").keypress(function(event) {
		var inputValue = event.which;

		// allow letters and whitespaces only.
		if (!(inputValue == 32) && // space
			!(inputValue > 48 && inputValue < 58) && // numeric (0-9)
			!(inputValue > 64 && inputValue < 91) && // upper alpha (A-Z)
			!(inputValue > 96 && inputValue < 123)) {
			event.preventDefault();
		}
	});
	$('#submodulemasterdiv').block({ message: 'Please wait....' });
	//	$.ajax(
	//		{
	//			url: '../admin/LoadSubModuleMasterData',
	//			type: "POST",
	//			contentType: 'application/json',
	//			dataType: 'json',
	//
	//		})
	//		.done(
	//			function(data) {
	//
	//				if (data.status == '1') {
	//
	//
	//					var length = Object.keys(data.data).length;
	//
	//					$('#submodulemastertbl').dataTable().fnClearTable();
	//					for (var i = 0; i < length; i++) {
	//						var statusData = data.data[i];
	//						$('#submodulemastertbl').dataTable().fnAddData([
	//							statusData.srno,
	//							statusData.modulename,
	//							statusData.submodulename,
	//							statusData.action
	//
	//
	//						]);
	//					}
	//					$('#submodulemasterdiv').unblock();
	//				} else {
	//					$('#submodulemasterdiv').unblock();
	//					alert(data.message);
	//				}
	//
	//			})
	//		.fail(function(jqXHR, textStatus) {
	//			$('#submodulemasterdiv').unblock();
	//			alert(jqXHR.responseText);
	//		});

});
function SaveSubModuleMasterData() {

	var submodname = document.getElementById("submodname").value.trim();
	var modulename = $('#modulename').val().trim();


	if (modulename == "" || modulename == null || modulename == undefined || modulename == "-1") {
		$.confirm({
			title: '',
			content: "Please Select Module Name",
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

	if (submodname == "" || submodname == null || submodname == undefined) {
		$.confirm({
			title: '',
			content: "Please Enter Sub Module Name",
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
	if (submodname.length < 2) {
		$.confirm({
			title: '',
			content: "Sub Module Name must be of atleast 2 letters",
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

	$('#submodulemasterdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"submodname": submodname,
		"modulename": modulename,

		"actiontype": document.getElementById("actiontype").value,
		"submoduleid": document.getElementById("submoduleid").value
	}

	$
		.ajax(
			{
				url: '../admin/SaveSubModuleMasterData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#submodulemasterdiv').unblock();
				//				alert(data.status)
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

					//					alert(data.message)
					//						.then((value) => {
					//							window.location.reload();
					//						});


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
			//swal('File upload failed ...');
		});

}

function GetSubModuleData(submoduleid) {

	$('#submodulemasterdiv').block({ message: 'Please wait....' });
	
	var h4Element = document.getElementById("submoduleHeader");
	h4Element.textContent = "Update Sub Module Data";
	
	var jsondata = {
		"submoduleid": submoduleid
	}

	$
		.ajax(
			{
				url: '../admin/GetSubModuleDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#submodulemasterdiv').unblock();
				if (data.status == '1') {
					document.getElementById("submodname").value = data.submodname;
					document.getElementById("submoduleid").value = data.submoduleid;

					var modulename = data.modulename;

					$('#submodulemasterdiv').block({ message: 'Please wait....' });
					$.ajax(
						{
							url: '../admin/getModuleName',
							type: "POST",

							cors: true,
							dataType: 'json',
						})
						.done(
							function(data) {
								$('#submodulemasterdiv').unblock();
								var selectHtml = "";
								selectHtml = selectHtml + "<option value='-1'>---Select---</option>";
								$.each(data.modulelist, function(jdIndex, jdData) {
									selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
								});
								$('#modulename').html(selectHtml);
								$('#modulename').val(modulename);
							})
						.fail(function(jqXHR, textStatus) {
							$('#submodulemasterdiv').unblock();
							alert(jqXHR.responseText);

						});
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("submodulebtn").innerHTML = "Update";
					document.getElementById("reset_btn").innerHTML = "Back";
				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			//swal(jqXHR.responseText);
//			alert('File upload failed ...');
		});
}
function DeleteSubModuleData(submoduleid) {
	$('#submodulemasterdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"submoduleid": submoduleid
	}

	$
		.ajax(
			{
				url: '../admin/DeleteSubModuleData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#submodulemasterdiv').unblock();
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
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#submodulemasterdiv').unblock();
//			alert(jqXHR.responseText);

		});

}

function ResetInput() {
	window.location.reload();
}
function getModuleName() {


	$('#submodulemasterdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/getModuleName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#submodulemasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>---Select---</option>";
				$.each(data.modulelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#modulename').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#submodulemasterdiv').unblock();
//			alert(jqXHR.responseText);

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
		"serverSide": true,
		"columnDefs": [
			{
				"targets": [0,3], // The column index you want to disable sorting for (0-based)
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
			//			url: '/admin/LoadSubModuleMasterData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
			url: '../admin/LoadSubModuleMasterData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.submodulename,
							statusData.action
						]);
						FilteredRecords = data.TotalCount;
					}
					$('#submodulemastertbl').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#submodulemastertbl').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#submodulemastertbl').unblock();
//			alert(jqXHR.responseText);
		});

}

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
								GetSubModuleData(id);
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
								DeleteSubModuleData(id);
								a = "false";
							}
						}
					}
				});
			}
		});
	});


}


