$(document).ready(function() {
	getEvents(-1);
	getYear();
getEventsListForSociety(0);

});


function getEvents(slectedevent) {
	console.log("in cate console")
	$('#gallerydiv').block({ message: 'Please wait....' });
		var jsondata = {
		"type": "video"
	}
	$
		.ajax(
			{
				url: '../admin/getEventsForSociety',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {
				$('#subcategorydiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Events--</option>";
				$.each(data.eventList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.eventName + "</option>";
				});
				$('#eventsSocietyDropdown').html(selectHtml);
				if(slectedevent!=-1){
					document.getElementById("eventsSocietyDropdown").value = slectedevent;
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#gallerydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getYear() {
	const d = new Date();
	let currentyear = d.getFullYear();
	var selectHtmlm = "";
	selectHtmlm = selectHtmlm + "<option value='-1'>--Select--</option>";
	for (var i = 0; i < 10; i++) {
		var loopyear = parseInt(parseInt(currentyear) - parseInt(i));
		selectHtmlm = selectHtmlm + "<option value='" + loopyear + "'>" + loopyear + "</option>";
	}
	$('#yearSociety').html(selectHtmlm);

}

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("searchsocityVideo").onclick =
		function() {

			getEventsListForSociety(0);
		};

	document.getElementById("ShowAllEventsSocietyVideo").onclick =
		function() {
			return getEventsListForSociety(1);
		};
});

function getEventsListForSociety(showAll) {
	$('#gallerydiv').block({ message: 'Please wait....' });
	if (showAll == 1) {
		getEvents(-1);
		getYear();

	}
	var event = document.getElementById("eventsSocietyDropdown").value;
	var year = document.getElementById("yearSociety").value;
	document.getElementById("eventsSociety").innerHTML = "";

	

	var jsondata = {
		"showAll": showAll,
		"event": event,
		"year": year,
		"type": "video"
	}

	$
		.ajax(
			{
				url: '../getEventsListForSocietyDefault',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var htm = "";

					for (var value of data.imagedata) {
						console.log(value.eventname + " " + value.title);

						htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
						htm = htm + ` <div class="custom-card-block">`;
						htm = htm + ` <div class="custom-thumb">`;
						htm = htm + ` <video controls>`;
						htm = htm + ` <source src=${value.gallaryphoto} type="video/mp4">`;
						htm = htm + ` </video></div>`;
						htm = htm + ` <div class="custom-card-title">`;
//						htm = htm + ` <span class="author">Event Place Static</span>`;
						htm = htm + ` <h4>${value.eventname}</h4>`;
						htm = htm + ` </div></div></div>`;

					}
					
					$('#eventsSociety').append(htm);
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
									//									window.location.reload();
								}
							}
						}
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#gallerydiv').unblock();
			alert(jqXHR.responseText);
		});

}


















/*
$(document).ready(function() {

	getMonths();
	getYear();
	getRODetails();
	getEventsListForSociety(0);
//	getEventsListForRo(0);
//	getEventsListForSchool(0);

});

function getEventsListForSchool(showAll) {
	$('#gallerydiv').block({ message: 'Please wait....' });
	if (showAll == 1) {
		getMonths();
		getYear();
		getRODetails();
		getSchoolDetail(-1);
	}
	var RoId = document.getElementById("RoSchool").value;
	var SchoolId = document.getElementById("SchoolSchool").value;
	var month = document.getElementById("monthSchool").value;
	var year = document.getElementById("yearSchool").value;
	document.getElementById("eventsSchool").innerHTML = "";
	if (RoId == null || RoId == "") {
		RoId = -1;
	}
	if (SchoolId == null || SchoolId == "") {
		SchoolId = -1;
	}

	var jsondata = {
		"SchoolId": SchoolId,
		"showAll": showAll,
		"RoId": RoId,
		"month": month,
		"year": year,
		"type": "video"
	}

	$
		.ajax(
			{
				url: '/FriendsForLife/getEventsListForSchool',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var htm = "";

					for (var value of data.imagedata) {
						console.log(value.eventname + " " + value.title);

						htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
						htm = htm + ` <div class="custom-card-block">`;
						htm = htm + ` <div class="custom-thumb">`;
						htm = htm + ` <video controls>`;
						htm = htm + ` <source src=${value.gallaryphoto} type="video/mp4">`;
						htm = htm + ` </video></div>`;
						htm = htm + ` <div class="custom-card-title">`;
//						htm = htm + ` <span class="author">Event Place Static</span>`;
						htm = htm + ` <h4>${value.eventname}</h4>`;
						htm = htm + ` </div></div></div>`;

					}

					$('#eventsSchool').append(htm);

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
			$('#gallerydiv').unblock();
			alert(jqXHR.responseText);
		});

}




function getEventsListForRo(showAll) {
	$('#gallerydiv').block({ message: 'Please wait....' });
	if (showAll == 1) {
		getMonths();
		getYear();
		getRODetails();

	}
	var RoId = document.getElementById("RoId").value;
	var month = document.getElementById("monthRo").value;
	var year = document.getElementById("yearRo").value;
	document.getElementById("eventsRo").innerHTML = "";
	
	if (RoId == null || RoId == "") {
		RoId = -1;
	}
	var jsondata = {
		"showAll": showAll,
		"RoId": RoId,
		"month": month,
		"year": year,
		"type": "video"
	}

	$.ajax({
				url: '/FriendsForLife/getEventsListForRo',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var htm = "";

					for (var value of data.imagedata) {
						console.log(value.eventname + " " + value.title);

						htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
						htm = htm + ` <div class="custom-card-block">`;
						htm = htm + ` <div class="custom-thumb">`;
						htm = htm + ` <video controls>`;
						htm = htm + ` <source src=${value.gallaryphoto} type="video/mp4">`;
						htm = htm + ` </video></div>`;
						htm = htm + ` <div class="custom-card-title">`;
//						htm = htm + ` <span class="author">Event Place Static</span>`;
						htm = htm + ` <h4>${value.eventname}</h4>`;
						htm = htm + ` </div></div></div>`;

					}

					$('#eventsRo').append(htm);

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
			$('#gallerydiv').unblock();
			alert(jqXHR.responseText);
		});

}



function getRODetails() {
	$('#gallerydiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/FriendsForLife/admin/getROName',
			type: "POST",
			cors: true,
			dataType: 'json',

		})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select RO--</option>";
				$.each(data.roList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.ROName + "</option>";
				});
				$('#RoId').html(selectHtml);
				$('#RoSchool').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#gallerydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}



function getYear() {
	const d = new Date();
	let currentyear = d.getFullYear();
	var selectHtmlm = "";
	selectHtmlm = selectHtmlm + "<option value='-1'>--Select--</option>";
	for (var i = 0; i < 10; i++) {
		var loopyear = parseInt(parseInt(currentyear) - parseInt(i));
		selectHtmlm = selectHtmlm + "<option value='" + loopyear + "'>" + loopyear + "</option>";
	}
	$('#yearSociety').html(selectHtmlm);
	$('#yearRo').html(selectHtmlm);
	$('#yearSchool').html(selectHtmlm);
}


function getMonths() {
	var month = ["January", "February", "March", "April", "May", "June", "July",
		"August", "September", "October", "November", "December"];
	var selectHtmlm = "";
	selectHtmlm = selectHtmlm + "<option value='-1'>--Select--</option>";
	for (var i = 0; i < 12; i++) {
		selectHtmlm = selectHtmlm + "<option value='" + parseInt(i + 1) + "'>" + month[i] + "</option>";

	}
	$('#monthSociety').html(selectHtmlm);
	$('#monthRo').html(selectHtmlm);
	$('#monthSchool').html(selectHtmlm);
}

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("searchsocityImages").onclick =
		function() {
			var month = document.getElementById("monthSociety").value;
			var year = document.getElementById("yearSociety").value;
			if (month != -1 && year == -1) {
				return confermmsg();
			} else {
				return getEventsListForSociety(0);
			}

		};
		
	document.getElementById("pills-profile-tab").onclick =
		function() {
			return getEventsListForRo(0);
		};
		
	document.getElementById("pills-contact-tab").onclick =
		function() {
			return getEventsListForSchool(0);
		};
		
	document.getElementById("ShowAllEventsSociety").onclick =
		function() {
			return getEventsListForSociety(1);
		};

	document.getElementById("searchROImages").onclick =
		function() {
			var month = document.getElementById("monthRo").value;
			var year = document.getElementById("yearRo").value;
			if (month != -1 && year == -1) {
				return confermmsg();
			} else {
				return getEventsListForRo(0);
			}

		};

	document.getElementById("ShowAllEventsRO").onclick =
		function() {
			return getEventsListForRo(1);
		};

	document.getElementById("RoSchool").onchange =
		function() {
			var id = $('#RoSchool').val();
			return getSchoolDetail(id);
		};

	document.getElementById("ShowAllEventsSchool").onclick =
		function() {
			return getEventsListForSchool(1);
		};

	document.getElementById("searchSchoolImages").onclick =
		function() {
			var month = document.getElementById("monthSchool").value;
			var year = document.getElementById("yearSchool").value;
			if (month != -1 && year == -1) {
				return confermmsg();
			} else {
				return getEventsListForSchool(0);
			}

		};
});

function getSchoolDetail(sid) {

	$('#accessdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getSchoolDetail',
				type: "POST",
				data: { "id": sid },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#accessdiv').unblock();

				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select School--</option>";
				$.each(data.SchoolList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.SchoolName + "</option>";

				});
				$('#SchoolSchool').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#accessdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function confermmsg() {
	$.confirm({
		title: '',
		content: 'Please Select Year',
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


function getEventsListForSociety(showAll) {
	$('#gallerydiv').block({ message: 'Please wait....' });
	if (showAll == 1) {
		getMonths();
		getYear();

	}
	var month = document.getElementById("monthSociety").value;
	var year = document.getElementById("yearSociety").value;
	document.getElementById("eventsSociety").innerHTML = "";

	if (month != -1 && year == -1) {
		$.confirm({
			title: '',
			content: 'Please Select Year',
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

	var jsondata = {
		"showAll": showAll,
		"month": month,
		"year": year,
		"type": "video"
	}

	$
		.ajax(
			{
				url: '/FriendsForLife/getEventsListForSociety',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var htm = "";

					for (var value of data.imagedata) {
						console.log(value.eventname + " " + value.title);

						htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
						htm = htm + ` <div class="custom-card-block">`;
						htm = htm + ` <div class="custom-thumb">`;
						htm = htm + ` <video controls>`;
						htm = htm + ` <source src=${value.gallaryphoto} type="video/mp4">`;
						htm = htm + ` </video></div>`;
						htm = htm + ` <div class="custom-card-title">`;
//						htm = htm + ` <span class="author">Event Place Static</span>`;
						htm = htm + ` <h4>${value.eventname}</h4>`;
						htm = htm + ` </div></div></div>`;

					}
					
					$('#eventsSociety').append(htm);
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
									//									window.location.reload();
								}
							}
						}
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#gallerydiv').unblock();
			alert(jqXHR.responseText);
		});

}
*/
