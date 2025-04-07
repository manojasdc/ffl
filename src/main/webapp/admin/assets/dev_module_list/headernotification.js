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

									//									window.location.reload();
									getNotifications();
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
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});


}


var waitTimeAll = 0;
$(document).ready(function() {
	getNotifications();
	waitTimeAll = 0;


});

function getNotifications() {


	var jsondata = {
	}
	$
		.ajax(
			{
				url: '../admin/getNotifications',
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

					document.getElementById("allData").innerHTML = data.notdata
					document.getElementById("notificationcount").innerHTML = data.NotificationCounts;
				} else {

				}
			})
		.fail(function(jqXHR, textStatus) {

		});

	waitTime = 0;
	document.getElementById("lastUpdateAll").innerHTML = "Last updated Just Now";
	setTimeout(seteventsheader, 1000);
}


function incWaitTime() {
	waitTime += 1;
	document.getElementById("lastUpdateAll").innerHTML = "Last updated " + waitTime + " min ago";
}

function seteventsheader() {


	document.querySelectorAll('.markasreadClass').forEach((items, index1) => {
		items.addEventListener('click', event => {

			var val1 = parseInt(index1) + 1;

			var id1 = document.getElementById('hidv' + val1).value;

			MarkAsReadNotificationAll(id1);
		});
	});

}
//
setInterval(incWaitTime, 60000);