
$(document).ready(function() {

	var role = document.getElementById("role").value;
	if (role === "USER") {
		$("#usershow").show();
		$("#user").hide();
		getInstitute();

	}
	else {
		$("#usershow").hide();
		$("#user").show();


		$
			.ajax(
				{
					url: '../admin/getwhatsnewscroll',
					type: "POST",
					//				data: JSON
					//					.stringify(jsondata),
					contentType: 'application/json',
					cors: true,
					dataType: 'json',

				})
			.done(
				function(data) {
					$('#work').unblock();
					if (data.status == '1') {
						$("#allwhatsnew").empty();

						$("#allwhatsnew").append(data.notdata);


					} else {
						$.alert({
							title: '',
							content: data.message,
						});
					}
				})
			.fail(function(jqXHR, textStatus) {
				$('#work').unblock();
//				$.alert({
//					title: '',
//					content: jqXHR.responseText,
//				});
			});



	}


});

document.addEventListener('DOMContentLoaded', function() {
	var role = document.getElementById("role").value;
	if (role === "USER") {

		document.getElementById("instituteId").onchange = function() {

			getuserdashboarddtl(this.value);
			getwhatsnewscrollforuser(this.value);
		};
	}


});

function ResetInput() {
	window.location.reload();
}


function getInstitute() {

	$('#registrationdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getInstituteforActivity',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//				$('#schooldiv').unblock();
				var selectHtml = "";
				//				selectHtml = selectHtml + "<option value='-1'>---Select Institute---</option>";
				$.each(data.institutelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.institute_name + "</option>";
				});

				$('#instituteId').html(selectHtml);
				var institutemap = data.institutelist[0].id;
				getuserdashboarddtl(institutemap);
				getwhatsnewscrollforuser(institutemap);
				$('#registrationdiv').unblock();

			})
		.fail(function(jqXHR, textStatus) {
			$('#registrationdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}


function getuserdashboarddtl(institute) {

	var jsondata = {
		"institute": institute,

	}


	$
		.ajax(
			{
				url: '../admin/getuserdashboarddtl',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				if (data.status == '1') {
					$("#userjournaldashboard").html(data.Ejournalcount);
					$("#usernewsdashboard").html(data.NewsLettersCount);
					$("#userhalloffamedashboard").html(data.HallofFameCount);
					$("#userpicturedashboard").html(data.photogallaryCount);
					$("#useractivitydashboard").html(data.ActivityCount);
				}
				else {
					$.alert({
						title: '',
						content: data.message,
					});
					$("#userjournaldashboard").html(0);
					$("#usernewsdashboard").html(0);
					$("#userhalloffamedashboard").html(0);
					$("#userpicturedashboard").html(0);
					$("#useractivitydashboard").html(0);
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

function getwhatsnewscrollforuser(institute) {

	var jsondata = {
		"institute": institute,

	}

	$
		.ajax(
			{
				url: '../admin/getwhatsnewscrollforuser',
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
					$("#allwhatsnew").empty();

					$("#allwhatsnew").append(data.notdata);


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





