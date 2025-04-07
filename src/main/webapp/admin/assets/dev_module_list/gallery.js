$(document).ready(function() {
	getEvents(-1);
	getYear();
	$(".monthSocietyDiv").hide();

	var CategoryName = document.getElementById("CategoryName").value;
	var CatType = document.getElementById("CatType").value;

	if (CategoryName != "") {

		if (CatType == 'Society') {
			$(".monthSocietyDiv").show();
			getEventsListForSociety(0);
		} else {
			$(".monthSocietyDiv").hide();
			getImagesSchoolWise(CategoryName);

		}
	}
	else {
		getEventsListForSociety(0);
	}

});

function getImagesSchoolWise(cat){
		var Jsondata = {
		"selectedCat": cat
	}
	$
		.ajax(
			{
				url: '/FriendsForLife/getImagesSchoolWise',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(Jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var countEvent = 300;
					var htm = "";
					var count = 0;
					var currentEventId = data.imagedata[0].schoolId;
					var currentEvent = data.imagedata[0].schoolTitle;


					htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
					htm = htm + ` <div class="events_item custom-gallery">`;
					htm = htm + ` <div class="demo-gallery single-img-gallery">`;
					htm = htm + ` <ul`;
					htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

					for (var value of data.imagedata) {
						count++;
						if (currentEventId != value.schoolId) {


							htm = htm + ` </ul>`;
							htm = htm + ` </div>`;
							htm = htm + ` <div class="custom-down-content">`;
							//							htm = htm + ` <span class="author">Event Place</span>`;
							htm = htm + ` <h6>${currentEvent}</h6>`;
							htm = htm + ` </div></div></div>`;

							countEvent++;
							currentEventId = value.schoolId;
							currentEvent = value.schoolTitle;


							htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
							htm = htm + ` <div class="events_item custom-gallery">`;
							htm = htm + ` <div class="demo-gallery single-img-gallery">`;
							htm = htm + ` <ul `;
							htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.photo}`;
							htm = htm + ` data-sub-html="<h4>${value.schoolTitle}</h4><p></p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.photo} ></a>`;
							htm = htm + `	</li>`;

						} else {
							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.photo}`;
							htm = htm + ` data-sub-html="<h4>${value.schoolTitle}</h4><p> </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.photo} ></a>`;
							htm = htm + ` </li>`;
						}

					}
					htm = htm + ` </ul>`;
					htm = htm + ` </div><div class="custom-down-content">`;
					//					htm = htm + ` <span class="author">Event Place</span>`;
					htm = htm + ` <h6>${currentEvent}</h6>`;
					htm = htm + ` </div></div></div>`;

					$('#eventsSchool').html(htm);
					for (var ii = 300; ii <= countEvent; ii++) {
						$('#lightgallery_' + `${ii}`).lightGallery();
					}

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

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("searchsocityImages").onclick =
		function() {

			getEventsListForSociety(0);
		};

	document.getElementById("ShowAllEventsSociety").onclick =
		function() {
			return getEventsListForSociety(1);
		};
});

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
					//	window.location.reload();
				}
			}
		}
	});
}

//function getEvents(slectedevent) {
//	console.log("in cate console")
//	$('#gallerydiv').block({ message: 'Please wait....' });
//	$
//		.ajax(
//			{
//				url: '/FriendsForLife/admin/getEventsForSociety',
//				type: "POST",
//				cors: true,
//				dataType: 'json',
//
//			})
//		.done(
//			function(data) {
//				$('#subcategorydiv').unblock();
//				var selectHtml = "";
//				selectHtml = selectHtml + "<option value='-1'>--Select Events--</option>";
//				$.each(data.eventList, function(jdIndex, jdData) {
//					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.eventName + "</option>";
//				});
//				$('#eventsSocietyDropdown').html(selectHtml);
//				if(slectedevent!=-1){
//					document.getElementById("eventsSocietyDropdown").value = slectedevent;
//				}
//
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#gallerydiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
//
//		});
//}

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

function getSchoolImagesroWise(selectedRo) {
	var Jsondata = {
		"selectedRo": selectedRo
	}
	$
		.ajax(
			{
				url: '/FriendsForLife/getSchoolImagesroWise',
				type: "POST",
				cors: true,
				dataType: 'json',
				data: JSON.stringify(Jsondata),
				contentType: 'application/json'

			})
		.done(
			function(data) {

				$('#gallerydiv').unblock();
				if (data.status == '1') {
					var countEvent = 300;
					var htm = "";
					var count = 0;
					var currentEventId = data.imagedata[0].schoolId;
					var currentEvent = data.imagedata[0].schoolTitle;


					htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
					htm = htm + ` <div class="events_item custom-gallery">`;
					htm = htm + ` <div class="demo-gallery single-img-gallery">`;
					htm = htm + ` <ul`;
					htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

					for (var value of data.imagedata) {
						count++;
						if (currentEventId != value.schoolId) {


							htm = htm + ` </ul>`;
							htm = htm + ` </div>`;
							htm = htm + ` <div class="custom-down-content">`;
							//							htm = htm + ` <span class="author">Event Place</span>`;
							htm = htm + ` <h6>${currentEvent}</h6>`;
							htm = htm + ` </div></div></div>`;

							countEvent++;
							currentEventId = value.schoolId;
							currentEvent = value.schoolTitle;


							htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
							htm = htm + ` <div class="events_item custom-gallery">`;
							htm = htm + ` <div class="demo-gallery single-img-gallery">`;
							htm = htm + ` <ul `;
							htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.photo}`;
							htm = htm + ` data-sub-html="<h4>${value.schoolTitle}</h4><p></p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.photo} ></a>`;
							htm = htm + `	</li>`;

						} else {
							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.photo}`;
							htm = htm + ` data-sub-html="<h4>${value.schoolTitle}</h4><p> </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.photo} ></a>`;
							htm = htm + ` </li>`;
						}

					}
					htm = htm + ` </ul>`;
					htm = htm + ` </div><div class="custom-down-content">`;
					//					htm = htm + ` <span class="author">Event Place</span>`;
					htm = htm + ` <h6>${currentEvent}</h6>`;
					htm = htm + ` </div></div></div>`;

					$('#eventsSchool').html(htm);
					for (var ii = 300; ii <= countEvent; ii++) {
						$('#lightgallery_' + `${ii}`).lightGallery();
					}

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
		"type": 'image'
	}

	$
		.ajax(
			{
				url: '/FriendsForLife/getEventsListForSocietyDefault',
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
					var countEvent = 100;
					var htm = "";
					var count = 0;
					var currentEventId = data.imagedata[0].eventId;
					var currentEvent = data.imagedata[0].eventname;

					htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
					htm = htm + ` <div class="events_item custom-gallery">`;
					htm = htm + ` <div class="demo-gallery">`;
					htm = htm + ` <ul`;
					htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

					for (var value of data.imagedata) {
						count++;
						if (currentEventId != value.eventId) {


							htm = htm + ` </ul>`;
							htm = htm + ` </div>`;
							htm = htm + ` <div class="custom-down-content">`;
							//							htm = htm + ` <span class="author">Event Place</span>`;
							htm = htm + ` <h6>${currentEvent}</h6>`;
							htm = htm + ` </div></div></div>`;

							countEvent++;
							currentEventId = value.eventId;
							currentEvent = value.eventname;


							htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
							htm = htm + ` <div class="events_item custom-gallery">`;
							htm = htm + ` <div class="demo-gallery">`;
							htm = htm + ` <ul `;
							htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.gallaryphoto}  style="    float: left; width:  100px; height: 100px; object-fit: cover;"`;
							htm = htm + ` data-sub-html="<h4 >${value.title}</h4><p>${value.description} </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.gallaryphoto} ></a>`;
							htm = htm + `	</li>`;

						} else {
							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.gallaryphoto}  style="    float: left; width:  100px; height: 100px; object-fit: cover;"`;
							htm = htm + ` data-sub-html="<h4 >${value.title}</h4><p>${value.description} </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.gallaryphoto} ></a>`;
							htm = htm + ` </li>`;
						}

					}
					htm = htm + ` </ul>`;
					htm = htm + ` </div><div class="custom-down-content">`;
					//					htm = htm + ` <span class="author">Event Place</span>`;
					htm = htm + ` <h6>${currentEvent}</h6>`;
					htm = htm + ` </div></div></div>`;

					$('#eventsSociety').html(htm);
					getEvents(event);
					//					$('#eventsSchool').html(htm);
					for (var ii = 100; ii <= countEvent; ii++) {
						$('#lightgallery_' + `${ii}`).lightGallery();
					}

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





function getEventsListForSchool(showAll) {
	$('#gallerydiv').block({ message: 'Please wait....' });
	var RoId = 1;
	var roid = document.getElementById("roid").value;
	if (roid == "" || roid == null) {
		RoId = 1
	} else {
		RoId = roid
	}

	if (showAll == 1) {
		getEvents(-1);
		getYear();
		//		getRODetails(-1);
		getSchoolDetail(RoId);
	}

	var SchoolId = document.getElementById("SchoolSchool").value;
	var month = document.getElementById("monthSchool").value;
	var year = document.getElementById("yearSchool").value;
	document.getElementById("eventsSchool").innerHTML = "";

	if (SchoolId == null || SchoolId == "") {
		SchoolId = -1;
	}

	var jsondata = {
		"SchoolId": SchoolId,
		"showAll": showAll,
		"RoId": RoId,
		"month": month,
		"year": year,
		"type": 'image'
	}

	$
		.ajax(
			{
				url: '/FriendsForLife/getImageForRoGallery',
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
					var countEvent = 300;
					var htm = "";
					var count = 0;
					var currentEventId = data.imagedata[0].eventId;
					var currentEvent = data.imagedata[0].eventname;

					htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
					htm = htm + ` <div class="events_item custom-gallery">`;
					htm = htm + ` <div class="demo-gallery single-img-gallery">`;
					htm = htm + ` <ul`;
					htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

					for (var value of data.imagedata) {
						count++;
						if (currentEventId != value.eventId) {


							htm = htm + ` </ul>`;
							htm = htm + ` </div>`;
							htm = htm + ` <div class="custom-down-content">`;
							//							htm = htm + ` <span class="author">Event Place</span>`;
							htm = htm + ` <h6>${currentEvent}</h6>`;
							htm = htm + ` </div></div></div>`;

							countEvent++;
							currentEventId = value.eventId;
							currentEvent = value.eventname;


							htm = htm + ` <div class="col-lg-3 col-md-6 col-sm-12 col-12">`;
							htm = htm + ` <div class="events_item custom-gallery">`;
							htm = htm + ` <div class="demo-gallery single-img-gallery">`;
							htm = htm + ` <ul `;
							htm = htm + ` id="lightgallery_${countEvent}" class="list-unstyled">`;

							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.gallaryphoto}`;
							htm = htm + ` data-sub-html="<h4 >${value.title}</h4><p>${value.description} </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.gallaryphoto} ></a>`;
							htm = htm + `	</li>`;

						} else {
							htm = htm + `<li `;
							htm = htm + ` data-responsive="img/${count}-375.jpg 375, img/${count}-480.jpg 480, img/${count}.jpg 800"`;
							htm = htm + ` data-src=${value.gallaryphoto}`;
							htm = htm + ` data-sub-html="<h4 >${value.title}</h4><p>${value.description} </p>">`;
							htm = htm + ` <a href=""> <img class="img-responsive" src=${value.gallaryphoto} ></a>`;
							htm = htm + ` </li>`;
						}

					}
					htm = htm + ` </ul>`;
					htm = htm + ` </div><div class="custom-down-content">`;
					//					htm = htm + ` <span class="author">Event Place</span>`;
					htm = htm + ` <h6>${currentEvent}</h6>`;
					htm = htm + ` </div></div></div>`;

					$('#eventsSchool').html(htm);
					for (var ii = 300; ii <= countEvent; ii++) {
						$('#lightgallery_' + `${ii}`).lightGallery();
					}

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


function getEvents(slectedevent) {
	console.log("in cate console")
	$('#gallerydiv').block({ message: 'Please wait....' });
	var jsondata = {
		"type": "image"
	}
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getEventsForSociety',
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
				if (slectedevent != -1) {
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