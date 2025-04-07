
$(document).ready(function() {
	mockjax1('screentbl');
	dt = dataTable('screentbl');


	$("#screen_name").keypress(function(event) {
		var inputValue = event.which;

		// allow letters and whitespaces only.
		if (!(inputValue == 32) && // space
			!(inputValue > 48 && inputValue < 58) && // numeric (0-9)
			!(inputValue > 64 && inputValue < 91) && // upper alpha (A-Z)
			!(inputValue > 96 && inputValue < 123)) {
			event.preventDefault();
		}
	});

	getModuleName1();


	//getSubModuleName1();
});
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("save_btn").onclick =
		function() {
			SaveScreenMasterData();
		};

	document.getElementById("resetbtn").onclick =
		function() {
			clearall();
		};

	document.getElementById("screen_module_id").onchange =
		function() {

			var id = $('#screen_module_id').val();

			return getSubModuleName1(id);
		};

	//			document.getElementById("update_btn").onclick =
	//		function() {
	//			return isValid();
	//		};
	//		
	//			document.getElementById("btn_report").onclick =
	//		function() {
	//			return reportScreen();
	//		};
});


function clearall() {

	window.location.reload();


}

function getSubModuleName1(id) {

	$('#submodulemasterdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/getSubModuleName1',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#submodulemasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>---Select---</option>";
				$.each(data.submodulelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.subname + "</option>";
				});
				$('#screen_submodule_id').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#submodulemasterdiv').unblock();
//			alert(jqXHR.responseText);

		});

}

function getModuleName1() {

	$('#submodulemasterdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/getModuleName1',
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
				$('#screen_module_id').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#submodulemasterdiv').unblock();
//			alert(jqXHR.responseText);

		});

}

$(document).ready(function() {
	console.log("ready!");
});


function SaveScreenMasterData() {

	var screen_name = document.getElementById("screen_name").value.trim();
	var screen_url = document.getElementById("screen_url").value.trim();
	var screen_module_id = $('#screen_module_id').val().trim();
	var screen_submodule_id = $('#screen_submodule_id').val().trim();

	if (screen_name == "" || screen_name == null || screen_name == undefined) {
		$.confirm({
			title: '',
			content: "Please Enter Screen Name",
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
	if (screen_name.length < 2) {
		$.confirm({
			title: '',
			content: "Screen Name must be of atleast 2 letters",
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

	

	if (screen_url == "" || screen_url == null || screen_url == undefined) {
		$.confirm({
			title: '',
			content: "Please Enter Screen URL",
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
	if (screen_url.length < 2) {
		$.confirm({
			title: '',
			content: "Screen url must be of atleast 2 letters",
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
	if (screen_module_id == "" || screen_module_id == null || screen_module_id == undefined || screen_module_id == "-1") {
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
	if (screen_submodule_id == "" || screen_submodule_id == null || screen_submodule_id == undefined || screen_submodule_id == "-1") {
		$.confirm({
			title: '',
			content: "Please Select Sub Module Name",
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



	//debugger;

	$('#modulemasterdiv').block({ message: 'Please wait....' });

	$('#titlediv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {

			"screen_name": screen_name,
			"screen_id": document.getElementById("screen_id").value,
			"actiontype": document.getElementById("actiontype").value,
			"screen_url": screen_url,
			"screen_module_id": screen_module_id,
			"screen_submodule_id": screen_submodule_id


		}
	} else {
		var jsondata = {
			//   				"id": document.getElementById("id").value,

			"screen_name": screen_name,
			"actiontype": document.getElementById("actiontype").value,
			"screen_id": document.getElementById("screen_id").value,

			"screen_url": screen_url,
			"screen_module_id": screen_module_id,
			"screen_submodule_id": screen_submodule_id
		}
	}

	$
		.ajax(
			{
				url: '../admin/SaveScreenMasterData',
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
				"targets": [0,4], // The column index you want to disable sorting for (0-based)
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

	$('#screentbl').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadScreenMasterData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.screen_name,
							//							statusData.screen_url,
							statusData.screen_module_id,
							statusData.screen_submodule_id,
							statusData.action
						]);
						FilteredRecords = data.TotalCount;
					}
					$('#screentbl').unblock();
					setTimeout(setevents, 1000);
				} else {
					$('#screentbl').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#screentbl').unblock();
//			alert(jqXHR.responseText);
		});

}

//for update
function GetScreenData(screen_id) {

	$('#screenmasterdiv').block({ message: 'Please wait....' });
	var h4Element = document.getElementById("screenMasterHeader");
	h4Element.textContent = "Update Screen Master Data";
	var jsondata = {
		"screen_id": screen_id
	}

	$
		.ajax(
			{
				url: '../admin/GetScreenDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#screenmasterdiv').unblock();
				if (data.status == '1') {
					//					getModuleName1();
					document.getElementById("screen_name").value = data.screen_name;
					document.getElementById("screen_url").value = data.screen_url;
					document.getElementById("screen_id").value = data.screen_id;
					document.getElementById("screen_module_id").value = data.screen_module_id;
					$('#screen_module_id').select2();
					getSubModuleName1(data.screen_module_id);
					document.getElementById("screen_submodule_id").value = data.screen_submodule_id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("save_btn").innerHTML = "Update";
					document.getElementById("resetbtn").innerHTML = "Back";
				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			//swal(jqXHR.responseText);
//			alert('File upload failed ...');
		});
}

var a ="false";
function setevents() {

	document.querySelectorAll('.edit_screen').forEach((items, index) => {
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
//							ResetInput();
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";
								GetScreenData(id);
							}
						}
					}
				});
			}
		});
	});
	
	document.querySelectorAll('.delete_screen').forEach((items, index) => {
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
//							ResetInput();
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";
								DeleteScreenModuleData(id);
							}
						}
					}
				});
			}
		});
	});



}






function DeleteScreenModuleData(screen_id) {
	$('#screenmasterdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"screen_id": screen_id
	}

	$
		.ajax(
			{
				url: '../admin/DeleteScreenModuleData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#screenmasterdiv').unblock();
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
			$('#screenmasterdiv').unblock();
//			alert(jqXHR.responseText);

		});

}





