//var contextPath = document.getElementById("contextPath").value;

$(document).ready(function() {
	mockjax1('linkrolemastertbl');
	dt = dataTable('linkrolemastertbl');
	getRoleType();
	getModuleMaster();
	//	getSubModuleMaster();
	//	getScreenMaster();
});



document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("module").onchange =
		function() {

			var id = $('#module').val();

			return getSubModuleMaster(id);
		};

	document.getElementById("sub_module").onchange =
		function() {

			var id = $('#sub_module').val();


			return getScreenMaster(id);
		};


	document.getElementById("submitbtn").onclick =
		function() {
			return SaveRoleMasterData();
		};


	document.getElementById("resetbtn").onclick =
		function() {
			clearall();
		};
	//	document.getElementById("reset").onclick =
	//		function() {
	//			return ResetInput();
	//		};
});



function clearall() {

	window.location.reload();


}
function getRoleType() {
	$('#rolemasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getRoleType',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#rolemasterdiv').unblock();

				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Role Name--</option>";
				$.each(data.roletypelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.roletype + "</option>";
				});
				$('#role_name').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getModuleMaster() {

	$('#rolemasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getModuleMaster',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#rolemasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Module Master--</option>";
				$.each(data.modulemasterlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.modulemaster + "</option>";
				});
				$('#module').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getSubModuleMaster(id) {

	$('#rolemasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getSubModuleMaster',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#rolemasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Sub-Module Master--</option>";
				$.each(data.submodulemasterlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.submodulemaster + "</option>";
				});
				$('#sub_module').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function getScreenMaster(id) {


	$('#rolemasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getScreenMaster',
				type: "POST",
				cors: true,
				data: { "id": id },
				dataType: 'json',

			})
		.done(
			function(data) {

				$('#rolemasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Screen Master--</option>";
				$.each(data.screenmasterlist, function(jdIndex, jdData) {

					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.screenmaster + "</option>";

				});
				$('#screenid').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}


function SaveRoleMasterData() {

	var role_name = document.getElementById("role_name").value;
	var module_name = document.getElementById("module").value;
	var sub_module = document.getElementById("sub_module").value;
	var screenid = document.getElementById("screenid").value;

	if (document.getElementById("actiontype").value == "add") {

		var jsondata = {

			"roleid": role_name,
			"moduleid": module_name,
			"submoduleid": sub_module,
			"screenid": screenid,
			"actiontype": "add",
		}
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"roleid": role_name,
			"moduleid": module_name,
			"submoduleid": sub_module,
			"screenid": screenid,
			"actiontype": "update",

		}
	}

	$
		.ajax(
			{
				url: '../admin/SaveRoleMasterData',
				type: "POST",
				//				data: formData,
				data: JSON.stringify(jsondata),
				dataType: 'json',
				processData: false,
				contentType: false,
				cache: false,
				//				enctype: 'multipart/form-data',

			})
		.done(
			function(data) {
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
			$('#rolemasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
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
				"targets": [0,1,5], // The column index you want to disable sorting for (0-based)
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
	var orderColunm = '5';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#rolemasterdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadRoleMasterData1?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
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
							statusData.role_name,
							statusData.module,
							statusData.sub_module,
							statusData.screen,
							statusData.action

						]);
						FilteredRecords = data.TotalCount;
					}
					$('#rolemasterdiv').unblock();
					setTimeout(setevents, 1000);

				} else {
					$('#rolemasterdiv').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			alert(jqXHR.responseText);
		});
}





function GetRoleMasterDataForUpdate(id) {
	$('#rolemasterdiv').block({ message: 'Please wait....' });
	var h4Element = document.getElementById("LinkRoleMasterHeader");
	h4Element.textContent = "Update Link Role Master Data";
	var jsondata = {
		"id": id

	}
	//alert(id);
	$
		.ajax(
			{
				url: '../admin/GetRoleMasterDataForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#rolemasterdiv').unblock();
				if (data.status == '1') {

					document.getElementById("id").value = data.id;

					document.getElementById("role_name").value = data.role_name;
					document.getElementById("module").value = data.module;

					//					$('#module').select2();
					getSubModuleMaster(data.module, 'add', 0);
					document.getElementById("sub_module").value = data.sub_module;
					//	alert(data.sub_module)
					//					$('#sub_module').select2();
					getScreenMaster(data.sub_module);
					document.getElementById("screenid").value = data.screen;

					//					alert(data.screen)

					document.getElementById("actiontype").value = "Edit";
					document.getElementById("submitbtn").innerHTML = "Update";
					document.getElementById("resetbtn").innerHTML = "Back";

				}
				else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#rolemasterdiv').unblock();
//			alert(jqXHR.responseText);
		});
}

function DeleteRoleMasterData(id) {
	$('#rolemasterdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}

	$
		.ajax(
			{
				url: '../admin/DeleteRoleMasterData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})

		.done(
			function(data) {
				$('#rolemasterdiv').unblock();
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
			$('#rolemasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}



function ResetInput() {
	window.location.reload();
}
var a = "false";
function setevents() {


	document.querySelectorAll('.editrolemaster').forEach((items, index) => {
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
							a = "false";
							//							ResetInput();

							//						return false;
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";
								GetRoleMasterDataForUpdate(id);
							}
						}
					}
				});
			}
		});
	});




	document.querySelectorAll('.deleterolemaster').forEach((items, index) => {
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
							//						return false;
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								a = "false";

								DeleteRoleMasterData(id);
							}
						}
					}
				});
			}

		});
	});

}