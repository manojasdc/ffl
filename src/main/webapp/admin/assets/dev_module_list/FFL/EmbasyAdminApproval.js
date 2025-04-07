
$(document).ready(function() {

	mockjax1('EmbasyAdminApprovaltbl');
	dt = dataTable('EmbasyAdminApprovaltbl');

});


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
		ajax: function(data, callback) {
			loadRegistrationDetails(data, callback);
		},
		'processing': true,
		"serverSide": true,
		"columnDefs": [
			{
				"targets": [0, 9], // The column index you want to disable sorting for (0-based)
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
				async: true
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

function loadRegistrationDetails(data, callback) {


	var table = $('#EmbasyAdminApprovaltbl').DataTable();
//	var info = table.page.info();
//	var currentPage = info.page;
//	var pageLength = info.length;
//	var startPage = info.start;
//	var endPage = info.end;
//	var Search = table.search();
//	var order = table.order();
//	var orderColunm = '25';
//	var orderColunm = order[0][0] + 1;
//
//	var orderType = order[0][1];
	
	//var info = data.page.info();
	//	var currentPage = info.page;
	//	var pageLength = info.length;
	//	var startPage = info.start;
	//	var endPage = info.end;

	var info = table.page.info();
	var pageLength = info.length;
	var startPage = info.page;
	var endPage = info.end;
	var Search = table.search();
	var order = table.order();
	var orderColunm = $(table.column(order[0][0]).header()).html().toLowerCase();
	var orderType = order[0][1];

	jsondata = [];

	$('#registrationdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadEmbasyApprovalData?pageno=' + startPage + '&&length=' + pageLength + "&&search=" + Search + "&&order=" + order,
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',

		})
		.done(
			async function(data) {

				const base64Salt = base64ToUint8Array(document.getElementById("GeneratedSalt").value);
				const base64Iv = base64ToUint8Array(document.getElementById("GeneratedIV").value);
				const password = document.getElementById("Generatedpassword").value;
				const key = await deriveKey(password, base64Salt);


				if (data.status == '1') {
					var jsondata = [];
					var length = Object.keys(data.data).length;
					for (var i = 0; i < length; i++) {
						var statusData = data.data[i];

						var base64AuthTag = statusData.EmailIDAuth;
						var base64Ciphertext = statusData.EmailID;
						var encryptedData = {
							iv: base64Iv,
							ciphertext: base64ToUint8Array(base64Ciphertext),
							authTag: base64ToUint8Array(base64AuthTag),
						};
						var decryptedEmail = await decryptServerDatakak(encryptedData, key);
						base64AuthTag = statusData.ContactNoAuth;
						base64Ciphertext = statusData.ContactNo;
						encryptedData = {
							iv: base64Iv,
							ciphertext: base64ToUint8Array(base64Ciphertext),
							authTag: base64ToUint8Array(base64AuthTag),
						};
						var decryptedcontact = await decryptServerDatakak(encryptedData, key);
						base64AuthTag = statusData.rollNumberAuth;
						base64Ciphertext = statusData.rollNumber;
						encryptedData = {
							iv: base64Iv,
							ciphertext: base64ToUint8Array(base64Ciphertext),
							authTag: base64ToUint8Array(base64AuthTag),
						};
						var decryptedRoll = await decryptServerDatakak(encryptedData, key);


						jsondata.push([

							statusData.srno,
							statusData.alumniName,
							decryptedEmail,
							decryptedcontact,
							statusData.passoutYear,
							decryptedRoll,
							statusData.instituteName,
							statusData.country,
							//							statusData.registrationStatus,
							statusData.embasyStatus,
							statusData.action

						]);

					}
					$('#registrationdiv').unblock();
					FilteredRecords = data.TotalCount;
					callback({
						draw: data.draw,
						recordsTotal: jsondata.length,
						recordsFiltered: FilteredRecords,
						data: jsondata
					});


					setTimeout(setevents, 1000);
				} else {
					$('#registrationdiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#registrationdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}

function ApproveEmbasy(id) {
	$('#registrationdiv').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id,
	}
	$
		.ajax(
			{
				url: '../admin/ApproveEmbasy',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#registrationdiv').unblock();
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
									var table = $('#registrationtbl').DataTable();
									table.ajax.reload();
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
			$('#registrationdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}

function RejectEmbasy(id) {
	$('#registrationdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id,
	}
	$
		.ajax(
			{
				url: '../admin/RejectEmbasy',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#registrationdiv').unblock();
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
									var table = $('#registrationtbl').DataTable();
									table.ajax.reload();
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
			$('#registrationdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}


var a = "false";
function setevents() {

	document.querySelectorAll('.approve_alumni').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Approve Registration?<br><br>',
					buttons: {
						cancel: function(button) {
							a = "false";
						},
						OK: {
							text: 'Yes',
							btnClass: 'btn-blue',
							keys: ['enter'],
							action: function() {
								a = "false";
								ApproveEmbasy(hid);

							}
						}
					}
				});
			}
		});
	});

	document.querySelectorAll('.reject_alumni').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			if (a == "false") {
				a = "true";
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Reject Registration?<br><br>',

					buttons: {
						cancel: function(button) {
							a = "false";
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter'],
							action: function() {
								a = "false";
								RejectEmbasy(hid);
							}
						}
					},
					onClose: function() {
					}
				});
			}
		});
	});

}




function ResetInput() {
	window.location.reload();
}










