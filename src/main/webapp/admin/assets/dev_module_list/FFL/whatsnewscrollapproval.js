$(document).ready(function() {


	mockjax1('whatsnewtbl');
	dt = dataTable('whatsnewtbl');

});

document.addEventListener('DOMContentLoaded', function() {


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
		ajax: '/test1',
		'processing': true,
		"serverSide": true,
		"serverSide": true,
		"columnDefs": [
			{
				"targets": [0, 2], // The column index you want to disable sorting for (0-based)
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
			url: '../admin/LoadWhatsNewpprovalData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search +"&&order=" + order,
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
							statusData.description,
							statusData.action

						]);

						FilteredRecords = data.TotalCount;
					}
					$('#journaldiv').unblock();
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

function RejectApprovalforNewScroll(id, remarks) {
	$('#work').block({ message: 'Please wait....' });
	var jsondata = {
		"id": id,
		"rejectedRemarks": remarks,

	}
	//	console.log(remarks);
	$
		.ajax(
			{
				url: '../admin/RejectApprovalforNewScroll',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#work').unblock();
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
									var table = $('#whatsnewtbl').DataTable();
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
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}

function acceptApprovalforNewScroll(id) {
	$('#work').block({ message: 'Please wait....' });

	var jsondata = {
		"id": id,
	}
	$
		.ajax(
			{
				url: '../admin/acceptApprovalforNewScroll',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#work').unblock();
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
									var table = $('#whatsnewtbl').DataTable();
									table.ajax.reload();
									//window.location.reload();
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
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});
}



function setevents() {

	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			//alert("hida" + hida);
			Getimageforactivity(hida);

		});
	});

	document.querySelectorAll('.approvecls1').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			$.confirm({
				title: '',
				content: 'Are You Sure You Want to Accept this Work ?<br><br>',
				//				+'<h6>Add Remarks</h6>' +'<input type="text" class="remarks form-control" placeholder="Please Enter Remarks"/>',


				buttons: {

					cancel: function(button) {
						//return false;
					},
					OK: {
						text: 'Yes',
						btnClass: 'btn-blue',
						keys: ['enter'],
						action: function() {
							//							var remarks = this.$content.find('.remarks').val();
							acceptApprovalforNewScroll(hid);

						}
					}
				}
			});
		});
	});

	document.querySelectorAll('.rejectcls').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hid = document.getElementById('hid' + val).value;
			$.confirm({
				title: '',
				content: 'Are You Sure You Want to Reject this  Request?<br><br>' +
					'<h6>Add Reject Remarks</h6>' + '<textarea class="remarks" id="remark_dtl" name="remark_dtl" placeholder="Enter Your Remarks" rows="10" cols="40"> </textarea>',

				buttons: {
					cancel: function(button) {
						// The dialog will close when the Cancel button is clicked
					},
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter'],
						action: function() {
							var remarks = this.$content.find('.remarks').val();
							if (remarks.trim() === "") {
								$.alert({
									title: '',
									content: 'Please Enter Remarks.',
									onClose: function() {
										// Prevent the main confirmation dialog from closing
										return false;
									}
								});
								// Prevent the main confirmation dialog from closing
								return false;
							} else {
								// Remarks are entered, proceed with the action
								RejectApprovalforNewScroll(hid, remarks);
							}
						}
					}
				},
				onClose: function() {
				}
			});
		});
	});

	/*	document.querySelectorAll('.delete_imagedata').forEach((items, index) => {
			items.addEventListener('click', event => {
				var val = parseInt(index) + 1;
				var hida = document.getElementById('hida' + val).value;
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Delete This Data?',
					buttons: {
	
	
						OK: {
							text: 'OK',
							btnClass: 'btn-green',
							keys: ['enter', 'shift'],
							action: function() {
								DeletePDFData(hida);
							}
						}
					}
				});
	
			});
		});*/

}

function ResetInput() {
	window.location.reload();
}


