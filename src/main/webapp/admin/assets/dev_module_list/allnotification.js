
$(document).ready(function() {
	mockjax1('viewnotificationtbl1');
	dt = dataTable('viewnotificationtbl1');




});


function dataTable(tableName) {

	var table = $('#' + tableName).DataTable({
		"order": [[0, "asc"]],
		//		"lengthMenu": [[10, 25, 50, 100, 200, -1], [10, 25, 50, 100, 200, "All"]],
		"lengthMenu": [[20, 30, 50, 100, -1], [20, 30, 50, 100, "All"]],
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
	var orderColunm = '25';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#societydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../LoadviewNotificationData22?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search,
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
							statusData.notificationTitle,

							statusData.description,

							statusData.ShowImage

						]);
						FilteredRecords = data.TotalCount;
					}
					$('#societydiv').unblock();
					setTimeout(setevents, 1000);

				} else {
					$('#societydiv').unblock();
					$.alert({
						title: '',
						content: data.message,
					});

				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#societydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function ViewImage(base64) {

	var image = new Image();

	image.src = "data:image/jpg;base64," + base64;

	var w = window.open("");
	w.document.write(image.outerHTML);

}




function GetImage(id) {

	$('#societydiv').block({ message: 'Please wait....' });
	var jsondata = {

		"id": id
	}



	$
		.ajax(
			{
				url: '/FriendsForLife/admin/GetImage',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',
			})
		.done(
			function(data) {
				//				$('#societydiv').unblock();
				//				if (data.status == '1') {
				//
				//					document.getElementById("id").value = data.id;
				//
				//		//			document.getElementById("actiontype").value = "Edit";
				if (data.data.NotificationImageType == "jpeg" || data.data.NotificationImageType == "jpg" || data.data.NotificationImageType == "png") {
					ViewImage(data.data.NotificationImage);
				} else if (data.data.NotificationImageType == "pdf") {
					GeneratePDF(data.data.NotificationImage);

				}

				//
				//
				//				} else {
				//
				//					$.alert({
				//						title: '',
				//						content: data.message,
				//					});
				//
				//				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#societydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}
function _base64ToArrayBuffer(base64) {
	var binary_string = window.atob(base64);
	var len = binary_string.length;


	var bytes = new Uint8Array(len);
	for (var i = 0; i < len; i++) {
		bytes[i] = binary_string.charCodeAt(i);
	}
	return bytes;
}


function GeneratePDF(base64Data) {

	var file = new Blob(
		[_base64ToArrayBuffer(base64Data)],
		{ type: 'application/pdf' }
	);
	var fileURL = URL.createObjectURL(file);
	var newWindow = window.open(fileURL, '_blank');

	newWindow.onload = function() {
		const embedTag = newWindow.document.getElementsByTagName('embed')[0]; // or document.querySelector('embed');
		embedTag.style.position = 'absolute';
	};


}



function setevents() {

	document.querySelectorAll('.image_status1').forEach((items, index) => {

		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('viewnot' + val).value;

			GetImage(hida);

		});
	});



}




function ResetInput() {
	window.location.reload();
}









