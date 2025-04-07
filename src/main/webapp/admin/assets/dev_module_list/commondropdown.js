$(document).ready(function() {
	getStream();
	getSection();
	getAdmissionType();
	getClass();
	getFeeGroup();
	getNationality();
	getReligion();
	getCast();
	getLanguage();
	getCountry();
	getStuHouse();
	getQuota();
	getCategoryName();
	getTitleName();
	getSchool();
	getBoardingCategory();
	getBoard();
	//	getDesignationName();
	//	getQualificationName();
	getDesignationName();
	getQualificationName();
		getStaffcategoryName();
        getPFtype();
	
	

	getPickRoutName();
	getDropRoutName();

});

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("categoryId").onchange =
		function() {

			var category_id = $('#categoryId').val();

			return getSubCategoryName(category_id, 'add', 0);
		};

	document.getElementById("country").onchange =
		function() {

			var id = $('#country').val();

			return getStateNameForStudent(id, 'student', 'add', 0);
		};

	document.getElementById("prCountry").onchange =
		function() {

			var id = $('#prCountry').val();

			return getStateNameForStudent(id, 'permanent', 'add', 0);
		};

	document.getElementById("fCountry").onchange =
		function() {

			var id = $('#fCountry').val();

			return getStateNameForStudent(id, 'father', 'add', 0);
		};

	document.getElementById("mCountry").onchange =
		function() {

			var id = $('#mCountry').val();

			return getStateNameForStudent(id, 'mother', 'add', 0);
		};

	document.getElementById("stateId").onchange =
		function() {

			var id = $('#stateId').val();

			return getCityNameForStudent(id, 'student', 'add', 0);
		};

	document.getElementById("prState").onchange =
		function() {

			var id = $('#prState').val();

			return getCityNameForStudent(id, 'permanent', 'add', 0);
		};

	document.getElementById("fState").onchange =
		function() {
			var id = $('#fState').val();
			return getCityNameForStudent(id, 'father', 'add', 0);
		};

	document.getElementById("mState").onchange =
		function() {
			var id = $('#mState').val();
			return getCityNameForStudent(id, 'mother', 'add', 0);
		};



	document.getElementById("pickRoute").onchange =
		function() {

			var id = $('#pickRoute').val();

			return getPickStopName(id, 'add', 0);
		};

	document.getElementById("dropRoute").onchange =
		function() {

			var id = $('#dropRoute').val();

			return getDropStopName(id, 'add', 0);
		};





});

function getCityNameForStudent(id, type, optype, cityid) {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/FriendsForLife/admin/getCityName',
			type: "POST",
			data: { "id": id },
			cors: true,
			dataType: 'json',

		})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select City--</option>";
				$.each(data.cityList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.cityName + "</option>";
				});
				if (type == "student") {
					$('#cityId').html(selectHtml);
					if (optype == 'Edit') {
						$('#cityId').val(cityid);
					}
				}
				else if (type == "permanent") {
					$('#prCityId').html(selectHtml);
					if (optype == 'Edit') {
						$('#prCityId').val(cityid);
					}
				}
				else if (type == "father") {
					$('#fCity').html(selectHtml);
					if (optype == 'Edit') {
						$('#fCity').val(cityid);
					}
				}
				else if (type == "mother") {
					$('#mCity').html(selectHtml);
					if (optype == 'Edit') {
						$('#mCity').val(cityid);
					}
				}


			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getStateNameForStudent(id, type, optype, stateid) {
	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getStateName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select State--</option>";
				$.each(data.stateList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.stateName + "</option>";
				});
				if (type == "student") {
					$('#stateId').html(selectHtml);
					if (optype == 'Edit') {
						$('#stateId').val(stateid);
					}
				}
				else if (type == "permanent") {
					$('#prState').html(selectHtml);
					if (optype == 'Edit') {
						$('#prState').val(stateid);
					}

				} else if (type == "father") {
					$('#fState').html(selectHtml);
					if (optype == 'Edit') {
						$('#fState').val(stateid);
					}
				} else if (type == "mother") {
					$('#mState').html(selectHtml);
					if (optype == 'Edit') {
						$('#mState').val(stateid);
					}
				}


			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}


function getCountry() {
	console.log("hello");
	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/FriendsForLife/admin/getCountry',
			type: "POST",
			cors: true,
			dataType: 'json',

		})
		.done(
			function(data) {
				console.log("in country", data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Country--</option>";
				$.each(data.countryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.countryName + "</option>";
				});
				$('#country').html(selectHtml);
				$('#prCountry').html(selectHtml);
				$('#birthCountry').html(selectHtml);
				$('#fCountry').html(selectHtml);
				$('#mCountry').html(selectHtml);
				$('#sclcountry').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getDesignationName() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
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
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Designation--</option>";
				$.each(data.designationList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.designationName + "</option>";
				});
				$('#fDesignation').html(selectHtml);
				$('#mDesignation').html(selectHtml);
				$('#stafffatheroccu').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getQualificationName() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
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
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Qualification--</option>";
				$.each(data.qualificationList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.qualificationName + "</option>";
				});
				$('#mQualification').html(selectHtml);
				$('#fQualification').html(selectHtml);
				$('#staffqua').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}


function getTitleName() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
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
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Title--</option>";
				$.each(data.titleList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.titleName + "</option>";
				});
				$('#fTitle').html(selectHtml);
				$('#mTitle').html(selectHtml);
				$('#stafftitlename').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

//stream dropdown
function getStream() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getStream',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Stream Name---</option>";
				$.each(data.streamlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#streamId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//getSchool dropdown
function getSchool() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getSchool',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select School Name---</option>";
				$.each(data.schoollist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#prevSchoolName').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//section dropdown
function getSection() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });

	$.ajax({
		url: '/FriendsForLife/admin/getSection',
		type: "POST",

		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Section Name---</option>";
				$.each(data.sectionlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#sectionId').html(selectHtml);
                $('#SectionId').html(selectHtml);
				$('#fromsectionId').html(selectHtml);
                $('#tosectionId').html(selectHtml);
                
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//admission type dropdown
function getAdmissionType() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getAdmissionType',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Admission Type---</option>";
				$.each(data.admissiontypelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#admissionType').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//class joinclass dropdown
function getClass() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getClass',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Class---</option>";
				$.each(data.classlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#classId').html(selectHtml);
				$('#joinClass').html(selectHtml);
				$('#prevClass').html(selectHtml);
				$('#ClassId').html(selectHtml);
				$('#fromclassId').html(selectHtml);
				$('#toclassId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//admission type dropdown
function getFeeGroup() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getFeeGroup',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Your Fee Group---</option>";
				$.each(data.feegrouplist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#feeGroup').html(selectHtml);
				$('#feesGroupId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}



//class joinclass dropdown
function getNationality() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getNationality',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Nationality Type---</option>";
				$.each(data.nationalitylist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#nationality').html(selectHtml);
				$('#fNationality').html(selectHtml);
				$('#mNationality').html(selectHtml);
				$('#staffnationality').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}


function getReligion() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getReligion',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Religion---</option>";
				$.each(data.religionlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#religionId').html(selectHtml);
				$('#staffreligion').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}


//class joinclass dropdown
function getCast() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getCast',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Cast---</option>";
				$.each(data.castlist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#castId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//class joinclass dropdown
function getLanguage() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getLanguage',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Language---</option>";
				$.each(data.languagelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#motherTongue').html(selectHtml);
				$('#languageKnown').html(selectHtml);
				$('#stafflanguage').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

function getCategoryName() {
	console.log("in cate console")
	$('#subcategorydiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getCategoryName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#subcategorydiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Category--</option>";
				$.each(data.categoryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.categoryName + "</option>";
				});
				$('#categoryId').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#subcategorydiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getSubCategoryName(category_id, optype, subCategoryId) {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getSubCategoryName',
				type: "POST",
				data: { "category_id": category_id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Sub Category--</option>";
				$.each(data.subCategoryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.subCategoryName + "</option>";
				});
				$('#subCategoryId').html(selectHtml);
				$('#SubcategoryId').html(selectHtml);
				if (optype == 'Edit') {
					$('#subCategoryId').val(subCategoryId);
				}
				if (optype == 'Edit_fee') {
                    $('#SubcategoryId').val(subCategoryId);
                }
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

//class joinclass dropdown
function getQuota() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getQuota',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Quota---</option>";
				$.each(data.quotalist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#quota').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//class joinclass dropdown
function getStuHouse() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getStuHouse',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				console.log(data);
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select House---</option>";
				$.each(data.stuhouselist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#houseId').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//getBoardingCategory dropdown
function getBoardingCategory() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getBoardingCategory',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Boarding Category---</option>";
				$.each(data.boardingCategoryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#boardingCategory').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}

//getBoard dropdown
function getBoard() {

	$('#studentmasterdiv').block({ message: 'Please wait....' });
	$.ajax({
		url: '/FriendsForLife/admin/getBoard',
		type: "POST",
		cors: true,
		dataType: 'json',

	})
		.done(
			function(data) {
				$('#studentmasterdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Board---</option>";
				$.each(data.boardList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#board').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#studentmasterdiv').unblock();
			alert(jqXHR.responseText);

		});
}


function getDropStopName(id, optype, dropStopid) {
	$('#TransportDetailsdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getDropStopName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#TransportDetailsdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Drop Stop Name---</option>";
				$.each(data.dropStopList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.dropStopName + "</option>";
				});
				$('#dropStop').html(selectHtml);
				if (optype == 'Edit') {
					$('#dropStop').val(dropStopid);
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#TransportDetailsdiv').unblock();
			alert(jqXHR.responseText);

		});

}

function getDropRoutName() {


	$('#TransportDetailsdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getDropRoutName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#TransportDetailsdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Drop Route Name---</option>";
				$.each(data.dropRouteList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.dropRoute + "</option>";
				});
				$('#dropRoute').html(selectHtml);
				//				jQuery('#coursenamedrp').multiselect({
				//					columns: 1,
				//					placeholder: 'Select Course Name',
				//					data: selectHtml
				//				});
			})
		.fail(function(jqXHR, textStatus) {
			$('#TransportDetailsdiv').unblock();
			alert(jqXHR.responseText);

		});
}

function getPickStopName(id, optype, pickStopid) {
	$('#TransportDetailsdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getPickStopName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {


				$('#TransportDetailsdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Pick Up Stop Name---</option>";
				$.each(data.pickStopList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.pickStopName + "</option>";
				});
				$('#pickStop').html(selectHtml);
				if (optype == 'Edit') {
					$('#pickStop').val(pickStopid);
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#TransportDetailsdiv').unblock();
			alert(jqXHR.responseText);

		});

}

function getPickRoutName() {


	$('#TransportDetailsdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getPickRoutName',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#TransportDetailsdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>Select Pick Up Route</option>";
				$.each(data.pickRoute, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.pickRoute + "</option>";
				});
				$('#pickRoute').html(selectHtml);
				//				jQuery('#coursenamedrp').multiselect({
				//					columns: 1,
				//					placeholder: 'Select Course Name',
				//					data: selectHtml
				//				});
			})
		.fail(function(jqXHR, textStatus) {
			$('#TransportDetailsdiv').unblock();
			alert(jqXHR.responseText);

		});
}
function getStaffcategoryName(id) {

	$('#staffdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getStaffcategoryName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#staffdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Category--</option>";
				$.each(data.staffcategoryList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.staffcategory + "</option>";
				});
				$('#staffcategory').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#staffdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

function getPFtype(id) {

	$('#staffdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getPFtype',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#staffdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select PF Type--</option>";
				$.each(data.pftypeList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.pytype + "</option>";
				});
				$('#staffpftype').html(selectHtml);
			})
		.fail(function(jqXHR, textStatus) {
			$('#staffdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}

