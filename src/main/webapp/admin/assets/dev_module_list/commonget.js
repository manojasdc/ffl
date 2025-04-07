$(document).ready(function() {	

	getDesignationName();
	getQualificationName();
	getTitleName();
	getCountryName();

});

document.addEventListener('DOMContentLoaded', function() {

		document.getElementById("regoffice_country").onchange =
		function() {
			
			var id = $('#regoffice_country').val();
			
			return getStateName(id,'regoffice');
		};
		
		document.getElementById("regoffice_person_country").onchange =
		function() {
			
			var id = $('#regoffice_person_country').val();
			
			return getStateName(id,'person');
		};
		
		document.getElementById("regoffice_state").onchange =
		function() {
			
			var id = $('#regoffice_state').val();
			
			return getCityName(id, 'regoffice');
		};
		
		document.getElementById("regoffice_person_state").onchange =
		function() {
			
			var id = $('#regoffice_person_state').val();
			
			return getCityName(id, 'person');
		};
		
		
		
		
		
});

function getDesignationName() {

	$('#regofficediv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getDesignationName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Designation--</option>";
				$.each(data.designationList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.designationName + "</option>";
				});
				$('#regoffice_person_designation').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#regofficediv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getQualificationName() {

	$('#regofficediv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getQualificationName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Qualification--</option>";
				$.each(data.qualificationList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.qualificationName + "</option>";
				});
				$('#regoffice_person_qualification').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#regofficediv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getTitleName() {

	$('#regofficediv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getTitleName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Title--</option>";
				$.each(data.titleList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.titleName + "</option>";
				});
				$('#regoffice_person_title').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#regofficediv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}


function getCountryName() {


	$('#regofficediv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getCountryName',
				type: "POST",

				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Country--</option>";
				$.each(data.countryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.countryName + "</option>";
				});
				$('#regoffice_country').html(selectHtml);
				$('#regoffice_person_country').html(selectHtml);
				//				jQuery('#coursenamedrp').multiselect({
				//					columns: 1,
				//					placeholder: 'Select Course Name',
				//					data: selectHtml
				//				});
			})
		.fail(function(jqXHR, textStatus) {
			$('#regofficediv').unblock();
			alert(jqXHR.responseText);

		});
}

function getStateName(id, type) {


	$('#regofficediv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getStateName',
				type: "POST",
				data: { "id" : id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
			

				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select State--</option>";
				$.each(data.stateList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.stateName + "</option>";
				});
				if (type == "regoffice"){
				   $('#regoffice_state').html(selectHtml);
				}
				else if (type == "person"){
				   $('#regoffice_person_state').html(selectHtml);
				}
				})
	.fail(function(jqXHR, textStatus) {
		$('#regofficediv').unblock();
		alert(jqXHR.responseText);

	});

}


function getCityName(id, type) {


	$('#regofficediv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getCityName',
				type: "POST",
				data: { "id" : id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
			

				$('#regofficediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select City--</option>";
				$.each(data.cityList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.cityName + "</option>";
				});
				if (type == "regoffice"){
				   $('#regoffice_city').html(selectHtml);
				}
				else if (type == "person"){
				   $('#regoffice_person_city').html(selectHtml);
				}
				})
	.fail(function(jqXHR, textStatus) {
		$('#regofficediv').unblock();
		alert(jqXHR.responseText);

	});

}

