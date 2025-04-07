var waitTimeAll = 0;
$(document).ready(function() {
	getAllNotifications(1);
	waitTimeAll = 0;


});


document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("refresh-button").onclick = function() {
		$("#page1").parent().siblings().removeClass("active");
		$("#page1").parent().addClass("active");
		return getAllNotifications(1);
	};

	document.getElementById("clearAll").onclick = function() {

		$.confirm({
			title: '',
			content: "Are You Sure You Want to Clear All Notifications ?",


			buttons: {


				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						ClearAllNotification();
						//window.location.reload();
					}
				}
			}
		});
	};

	var totalpages = document.getElementById("totalpage").value;

	var data = "";
	var counter = 1;

	for (var i = 0; i < totalpages; i++) {

		data += '<li' + (counter === 1 ? ' class="active"' : '')
			+ '><a href="javascript:void(0)" id="page' + counter + '">'
			+ counter + '</a></li>';
		counter++;
	}
	$("#pagination").append(data);
	for (var i = 0; i < totalpages; i++) {

		(function() {
			var idval = i + 1;

			document.getElementById("page" + idval).onclick = function() {

				for (var j = 1; j <= totalpages; j++) {
					$("#page" + j).parent().removeClass("active");
				}

				$(this).parent().addClass("active");
				return LoadPageData(idval);
			};

		})();
	}

});

function MarkAsReadNotificationAll(id) {

	var jsondata = {
		"id": id,

	}
	$
		.ajax(
			{
				url: '../admin/MarkAsReadNotification',
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
//									$("#page1").parent().siblings().removeClass("active");
//									$("#page1").parent().addClass("active");
//									getAllNotifications(1);
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
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});


}


function getAllNotifications(page) {


	var jsondata = {
		"currentPage": page,


	}
	$
		.ajax(
			{
				url: '../admin/getAllNotifications',
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
					$("#allNData").empty();

					$("#allNData").append(data.notdata);

					var pageNumber = page;
					// Current page number
					var itemsPerPage = 10; // Items per page
					var totalItems = data.NotificationCounts;

					// Total count of items
					var paginationInfo = displayPaginationInfo(pageNumber, itemsPerPage, totalItems);

					document.getElementById("paginationInfo").innerHTML = paginationInfo;
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

	waitTime = 0;
	document.getElementById("lastUpdateAll").innerHTML = "Last updated Just Now";
	setTimeout(seteventsAll, 1000);
}

function displayPaginationInfo(pageNumber, itemsPerPage, totalItems) {
	if (totalItems === 0) {
		var startItem = (pageNumber - 1) * itemsPerPage;
		var endItem = Math.min(startItem + itemsPerPage - 1, totalItems);
	}
	else {
		var startItem = (pageNumber - 1) * itemsPerPage + 1;
		var endItem = Math.min(startItem + itemsPerPage - 1, totalItems);
	}
	var infoString = "Displaying " + startItem + "-" + endItem + " of " + totalItems + " / per page " + itemsPerPage;
	return infoString;
}



function ClearAllNotification() {

	$
		.ajax(
			{
				url: '../admin/ClearAllNotification',
				type: "POST",

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
//									$("#page1").parent().siblings().removeClass("active");
//									$("#page1").parent().addClass("active");
//									getAllNotifications(1);
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
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});


}

function LoadPageData(pageid) {
	getAllNotifications(pageid)
}

function incwaitTimeAll() {
	waitTimeAll += 1;
	document.getElementById("lastUpdateAll").innerHTML = "Last updated " + waitTimeAll + " min ago";
}


function seteventsAll() {

	document.querySelectorAll('.markasreadClassAll').forEach((items, index) => {
		items.addEventListener('click', event => {

			var val = parseInt(index) + 1;

			var id = document.getElementById('hid' + val).value;


			MarkAsReadNotificationAll(id);
		});
	});

}

setInterval(incwaitTimeAll, 60000);
