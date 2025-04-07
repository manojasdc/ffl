

$(document).ready(function() {
	mockjax1('facultysubjectmaptbl');
	dt = dataTable('facultysubjectmaptbl');

getclassName();
getsectionName();

getFacultyName();


getsubjectName();


});



document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("facultysubjectmapbtn").onclick =
		function() {
			return SavefacultysubjectmapData();
		};
		
		document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};
		
		
});



function getFacultyName() {
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getFacultyName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#facultysubjectmapdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Faculty---</option>";
				$.each(data.facultylist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#facultyName').html(selectHtml);
				})
	.fail(function(jqXHR, textStatus) {
		$('#facultysubjectmapdiv').unblock();
		alert(jqXHR.responseText);

	});

}

function getclassName() {
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getclassName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#facultysubjectmapdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Class Name---</option>";
				$.each(data.classList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.ClassId + "</option>";
				});
				$('#className').html(selectHtml);
				})
	.fail(function(jqXHR, textStatus) {
		$('#facultysubjectmapdiv').unblock();
		alert(jqXHR.responseText);

	});

}


function getsectionName() {
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getsectionName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#facultysubjectmapdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Section Name---</option>";
				$.each(data.sectionList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.SectionId + "</option>";
				});
				$('#sectionName').html(selectHtml);
				})
	.fail(function(jqXHR, textStatus) {
		$('#facultysubjectmapdiv').unblock();
		alert(jqXHR.responseText);

	});

}






function getsubjectName() {
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getsubjectName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#facultysubjectmapdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Subject Name---</option>";
				$.each(data.subjectList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.subjectName + "</option>";
				});
				$('#subjectName').html(selectHtml);
				})
	.fail(function(jqXHR, textStatus) {
		$('#facultysubjectmapdiv').unblock();
		alert(jqXHR.responseText);

	});

}













function SavefacultysubjectmapData() {
	var facultyName = document.getElementById("facultyName").value;
	var className = document.getElementById("className").value;
	var sectionName = document.getElementById("sectionName").value;
	var subjectName  = document.getElementById("subjectName").value;



if (facultyName == "-1") {
				$.confirm({
			title: '',
			content:  "Please Select Faculty ",
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
		$('#facultyName').focus();
		return false;
	}

if (className == "-1") {
				$.confirm({
			title: '',
			content:  "Please Select Class ",
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
		$('#className').focus();
		return false;
	}

if (sectionName == "-1") {
				$.confirm({
			title: '',
			content:  "Please Select Section ",
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
		$('#sectionName').focus();
		return false;
	}

if (subjectName == "-1") {
				$.confirm({
			title: '',
			content:  "Please Select Subject ",
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
		$('#subjectName').focus();
		return false;
	}




	
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	if (document.getElementById("actiontype").value == "add") {
		var jsondata = {
		"staffId": facultyName,
			"classId": className,
			"sectionId": sectionName,
			"subjectId": subjectName,
		
//			"tbAccountDtl": {
//  				"id": dropRoute
//  			}
		}
	} else {
		var jsondata = {
			"id": document.getElementById("id").value,
			"staffId": facultyName,
			"classId": className,
			"sectionId": sectionName,
			"subjectId": subjectName,
			


		}
	}

	$
		.ajax(
			{
				url: '../admin/SavefacultysubjectmapData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#facultysubjectmapdiv').unblock();
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
			$('#facultysubjectmapdiv').unblock();
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
		"bDestroy": true,
		"scrollCollapse": true,
		"sPaginationType": "full_numbers",
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
	var orderColunm = '6';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadfacultysubjectmapData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
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
							//statusData.name,
							statusData.facultyName,
							statusData.className,
							statusData.sectionName,
							statusData.subjectName,
							
							statusData.action

						]);
						FilteredRecords = data.TotalCount;
					}
					$('#facultysubjectmapdiv').unblock();
						setTimeout(setevents, 1000);

				} else {
					$('#facultysubjectmapdiv').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#facultysubjectmapdiv').unblock();
			alert(jqXHR.responseText);
		});
}

function getfacultysubjectmapData(id) {
	/*$('#').block({ message: 'Please wait....' });*/
	
	var jsondata = {
		"id": id

	}
	
	$
		.ajax(
			{
				url: '../admin/GetfacultysubjectmapForUpdate',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#facultysubjectmapdiv').unblock();
				if (data.status == '1') {
					document.getElementById("facultyName").value = data.facultyName;
					document.getElementById("className").value = data.className;
					document.getElementById("sectionName").value = data.sectionName;
					document.getElementById("subjectName").value = data.subjectName;
					
				
					document.getElementById("id").value = data.id;
					document.getElementById("actiontype").value = "Edit";
					document.getElementById("facultysubjectmapbtn").value = "Update";
				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#facultysubjectmapdiv').unblock();
			alert(jqXHR.responseText);
		});
}

function setevents() {
	document.querySelectorAll('.edit_facultysubjectmap').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			getfacultysubjectmapData(hid);
		});
	});

	document.querySelectorAll('.delete_facultysubjectmap').forEach((items, index) => {
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
						DeletefacultysubjectmapData(hid);
						}
					}
				}
			});

		});
	});
}

function DeletefacultysubjectmapData(id) {
	$('#facultysubjectmapdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id
	}
	$
		.ajax(
			{
				url: '../admin/DeletefacultysubjectmapData',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
				.done(
			function(data) {
				$('#facultysubjectmapdiv').unblock();

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
			$('#facultysubjectmapdiv').unblock();
			$.confirm({
							title: '',
							content: jqXHR.responseText,
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
function ResetInput() {
	window.location.reload();
}

