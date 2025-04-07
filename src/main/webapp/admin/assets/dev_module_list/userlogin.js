document.addEventListener('DOMContentLoaded', function() {
	document.getElementById("userbtn").onclick =
		async function() {
			await GenerateKey();
			return await SaveUserData();
		};
	document.getElementById('reset').onclick =
		function() {
			return ResetInput();
		};
	document.getElementById('login_name').onkeypress =
		function() {
			return OnlyLetterRegEx(event, this);
		};

	document.getElementById('user_name').onkeypress =
		function() {
			return OnlyLetterRegEx(event, this);
		};

	/*document.getElementById('army_no').onkeypress =
		function() {
			return OnlyAlphaNumericWithoutSpaceRegExp(event, this);
		};
*/
	document.getElementById('user_password').onkeypress =
		function() {
			return OnlyAlphaNumericSpecialCharacterWithoutSpaceRegExp(event, this);
		};

	document.getElementById('user_re_password').onkeypress =
		function() {
			return OnlyAlphaNumericSpecialCharacterWithoutSpaceRegExp(event, this);
		};

	document.getElementById('user_role_id').onchange = function() {
		var selectedOption = this.options[this.selectedIndex];
		var selectedText = selectedOption.innerText;
		if (selectedText === 'EMBASSY ADMIN') {
			$("#hidecountryname").show();
			$("#hideinstitutename").hide();
			
			getCountry();
		} else {
			$("#hidecountryname").hide();
			$("#hideinstitutename").show();
			getInstitute();
			
		}
	};

});

function ResetInput() {
	window.location.reload();
}
var Base64 = {
	_keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	encode: function(e) {
		var t = "";
		var n, r, i, s, o, u, a;
		var f = 0;
		e = Base64._utf8_encode(e);
		while (f < e.length) {
			n = e.charCodeAt(f++);
			r = e.charCodeAt(f++);
			i = e.charCodeAt(f++);
			s = n >> 2;
			o = (n & 3) << 4 | r >> 4;
			u = (r & 15) << 2 | i >> 6;
			a = i & 63;
			if (isNaN(r)) {
				u = a = 64
			} else if (isNaN(i)) {
				a = 64
			}
			t = t + this._keyStr.charAt(s) + this._keyStr.charAt(o)
				+ this._keyStr.charAt(u) + this._keyStr.charAt(a)
		}
		return t
	},
	decode: function(e) {
		var t = "";
		var n, r, i;
		var s, o, u, a;
		var f = 0;
		e = e.replace(/[^A-Za-z0-9+/=]/g, "");
		while (f < e.length) {
			s = this._keyStr.indexOf(e.charAt(f++));
			o = this._keyStr.indexOf(e.charAt(f++));
			u = this._keyStr.indexOf(e.charAt(f++));
			a = this._keyStr.indexOf(e.charAt(f++));
			n = s << 2 | o >> 4;
			r = (o & 15) << 4 | u >> 2;
			i = (u & 3) << 6 | a;
			t = t + String.fromCharCode(n);
			if (u != 64) {
				t = t + String.fromCharCode(r)
			}
			if (a != 64) {
				t = t + String.fromCharCode(i)
			}
		}
		t = Base64._utf8_decode(t);
		return t
	},
	_utf8_encode: function(e) {
		e = e.replace(/rn/g, "n");
		var t = "";
		for (var n = 0; n < e.length; n++) {
			var r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r)
			} else if (r > 127 && r < 2048) {
				t += String.fromCharCode(r >> 6 | 192);
				t += String.fromCharCode(r & 63 | 128)
			} else {
				t += String.fromCharCode(r >> 12 | 224);
				t += String.fromCharCode(r >> 6 & 63 | 128);
				t += String.fromCharCode(r & 63 | 128)
			}
		}
		return t
	},
	_utf8_decode: function(e) {
		var t = "";
		var n = 0;
		var r = c1 = c2 = 0;
		while (n < e.length) {
			r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r);
				n++
			} else if (r > 191 && r < 224) {
				c2 = e.charCodeAt(n + 1);
				t += String.fromCharCode((r & 31) << 6 | c2 & 63);
				n += 2
			} else {
				c2 = e.charCodeAt(n + 1);
				c3 = e.charCodeAt(n + 2);
				t += String.fromCharCode((r & 15) << 12
					| (c2 & 63) << 6 | c3 & 63);
				n += 3
			}
		}
		return t
	}
}
var $ = jQuery.noConflict();

$(document).ready(function() {

	getRoleDetail();
	getInstitute();
	mockjax1('usertbl');
	dt = dataTable('usertbl');
	$(".roleTypeShowHideDiv").hide();
	$(".schoolShowHideDiv").hide();
    $("#hidecountryname").hide();
	$('[data-bs-toggle="popover"]').popover();
});


function dataTable(tableName) {
	var table = $('#' + tableName).DataTable({
		"order": [[0, ""]],
		//		"lengthMenu": [[10, 25, 50, 100, 200, -1], [10, 25, 50, 100, 200, "All"]],
		"lengthMenu": [[10, 25, /*50*/, 100, -1], [10, 25, /*50*/, 100, "All"]],
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
		"columnDefs": [
			{
				"targets": [0, 4], // The column index you want to disable sorting for (0-based)
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
	var orderColunm = '2';
	var orderColunm = order[0][0] + 1;
	//alert(orderColunm);
	//var orderColunm = "d.id"

	var orderType = order[0][1];

	jsondata = [];

	$('#userdiv').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '../admin/LoadUserData?pageno=' + currentPage + '&&length=' + pageLength + "&&search=" + Search.toLowerCase() + "&&order=" + order,
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',
			async: false
		})
		.done(
			function(data) {

				if (data.status == '1') {
					var length = Object.keys(data.data).length;
					for (var i = 0; i < length; i++) {
						var statusData = data.data[i];
						jsondata.push([
							statusData.srno,
							statusData.login_name,
							statusData.user_name,
							/*statusData.army_no,*/
							statusData.institute_name,
							statusData.action

						]);


					}
					FilteredRecords = data.TotalCount;
					$('#userdiv').unblock();

					setTimeout(setevents, 1000);
				} else {
					$('#userdiv').unblock();
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#usertbl').unblock();
			alert(jqXHR.responseText);
		});
}

function getInstitute() {

	$('#registrationdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getInstitute',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>---Select Institute---</option>";
				$.each(data.institutelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.institute_name + "</option>";
				});

				$('#instituteId').html(selectHtml);
				$('#registrationdiv').unblock();

			})
		.fail(function(jqXHR, textStatus) {
			$('#registrationdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}


function getCountry() {

	$('#halloffamediv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getCountry',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>---Select Country---</option>";
				$.each(data.countrylist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.country_name + "</option>";
				});

				$('#countryId').html(selectHtml);
				$('#halloffamediv').unblock();

			})
		.fail(function(jqXHR, textStatus) {
			$('#halloffamediv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
		}

/*Get Role Detail*/

function getRoleDetail() {

	$('#userdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/getRoleDetail',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#userdiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--Select Role--</option>";
				$.each(data.roleList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.roleName + "</option>";

				});
				$('#user_role_id').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#userdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});
}
function GenerateEncryptedValue(palintext) {

	var iterationCount = 1000;
	var keySize = 128;
	var otpvalue = palintext;
	var aesUtil = new AesUtil(keySize, iterationCount);
	var ciphertext = aesUtil.encrypt(document.getElementById("salt").value,
		document.getElementById("iv").value, document
			.getElementById("key").value, otpvalue);

	return ciphertext;
}
function GenerateKey() {
	var iterationCount = 1000;
	var keySize = 128;

	var passphrse = Base64.encode(GenerateRandomNumber());
	//var passphrse = $('#key').val();

	var iv = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);
	var salt = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);

	//var aesUtil = new AesUtil(keySize, iterationCount);
	//var ciphertext = aesUtil.encrypt(salt, iv, passphrse, otpvalue);
	//document.getElementById("OTPEncrypted").value = ciphertext;
	document.forms["userCreationMasterForm"]["salt"].value = salt;
	document.forms["userCreationMasterForm"]["iv"].value = iv;
	document.forms["userCreationMasterForm"]["key"].value = passphrse;
}
function GenerateRandomNumber() {

	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 5; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}
function generateRandomKey(length) {
	let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	let key = '';
	for (let i = 0; i < length; i++) {
		key += characters.charAt(Math.floor(Math.random() * characters.length));
	}
	return key;
}

/*Save User Data*/

async function SaveUserData() {

	var login_name = document.getElementById("login_name").value;
	var user_name = document.getElementById("user_name").value;
/*	var army_no = document.getElementById("army_no").value;*/
	var user_password = document.getElementById("user_password").value;
	var user_re_password = document.getElementById("user_re_password").value;
	var user_role_id = document.getElementById("user_role_id").value;
	var instituteId = document.getElementById("instituteId").value;
    var countryId = document.getElementById("countryId").value;
	//Changes
	/*VALIDATIONS*/
	var res = CheckNullorBlank('login_name');//LOGIN_NAME
	if (res !== "true") {
		$('#login_name').focus();

		$.confirm({
			title: '',
			content: res + "Login Name ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MinumumLengthCheck('login_name', 2);
	if (res !== "true") {
		$('#login_name').focus();
		$.confirm({
			title: '',
			content: "Login Name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('login_name', 70);
	if (res !== "true") {
		$('#login_name').focus();
		$.confirm({
			title: '',
			content: "Login Name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = OnlyAlphaNumericWithUnderscoreRegExp('login_name');
	if (res !== "true") {
		$('#login_name').focus();
		$.confirm({
			title: '',
			content: "Login Name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}

	var res = CheckNullorBlank('user_name');//USER_NAME
	if (res !== "true") {
		$('#user_name').focus();
		$.confirm({
			title: '',
			content: res + "User name ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MinumumLengthCheck('user_name', 2);
	if (res !== "true") {
		$('#user_name').focus();
		$.confirm({
			title: '',
			content: "User name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('user_name', 70);
	if (res !== "true") {
		$('#user_name').focus();
		$.confirm({
			title: '',
			content: "User name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = OnlyAlphaNumericWithUnderscoreRegExp('user_name');
	if (res !== "true") {
		$('#user_name').focus();
		$.confirm({
			title: '',
			content: "User name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}


	/*var res = CheckNullorBlank('army_no');//ARMY_NUMBER
	if (res !== "true") {
		$('#army_no').focus();
		$.confirm({
			title: '',
			content: res + "Army number  ",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MinumumLengthCheck('army_no', 2);
	if (res !== "true") {
		$('#army_no').focus();
		$.confirm({
			title: '',
			content: "Army number  " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('army_no', 70);
	if (res !== "true") {
		$('#army_no').focus();
		$.confirm({
			title: '',
			content: "Army number  " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}*/
	/*var res = OnlyAlphaNumericWithoutSpaceRegExp('army_no');
	if (res !== "true") {
		$('#army_no').focus();
		$.confirm({
			title: '',
			content: "Army number  " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}*/
	var res = CheckNullorBlank('user_password');//PASSWORD
	if (res !== "true") {
		$('#user_password').focus();
		$.confirm({
			title: '',
			content: "Please Enter Password",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}


	var res = MinumumLengthCheck('user_password', 8);
	if (res !== "true") {
		$('#user_password').focus();
		$.confirm({
			title: '',
			content: res + " Password",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		$('#user_password').focus();
		return false;
	}
	var res = MaximumLengthCheck('user_password', 28);
	if (res !== "true") {
		$('#user_password').focus();
		$.confirm({
			title: '',
			content: res + "Password",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,28}$/;//For Alphabet and Space
	if (!regex.test(user_password)) {
		$.confirm({
			title: '',
			content: "Password pattern doesn't match",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});

		return false;
	}
	var res = OnlyAlphaNumericSpecialCharacterWithoutSpaceRegExp('user_password');
	if (res !== "true") {
		$('#user_password').focus();
		$.confirm({
			title: '',
			content: "Please Enter Password.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	var res = CheckNullorBlank('user_re_password');//RE_PASSWORD
	if (res !== "true") {
		$('#user_re_password').focus();
		$.confirm({
			title: '',
			content: res + " Re-Password",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}

	if (user_role_id == -1) {
		$('#user_role_id').focus();
		$.confirm({
			title: '',
			content: "Please Select Role",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
		var user_role_idselect = document.getElementById("user_role_id");
	var user_role_id_text = user_role_idselect.options[user_role_idselect.selectedIndex].text;
	
	if (user_role_id_text == 'ADMIN') { 
		if (instituteId == -1) {
		$('#instituteId').focus();
		$.confirm({
			title: '',
			content: "Please Select Institute Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	}
	else{
		if (countryId == -1) {
		$('#countryId').focus();
		$.confirm({
			title: '',
			content: "Please Select Country Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;
	}
	}

	var login_name = $('#login_name').val().trim();
	var user_name = $('#user_name').val().trim();
	/*var army_no = $('#army_no').val().trim();*/
	var user_password = $('#user_password').val().trim();
	var user_re_password = $('#user_re_password').val().trim();
	//	var user_role_id = $('#user_role_id').val().trim();
	if (user_password == user_re_password) {
		$('#userdiv').block({ message: 'Please wait....' });
		if (document.getElementById("actiontype").value == "add") {

			login_name = await encryptData(login_name);
			user_name = await encryptData(user_name);
			/*army_no = await encryptData(army_no);*/
			user_password = await encryptData(user_password);
			user_re_password = await encryptData(user_re_password);
			user_role_id = await encryptData(user_role_id);
			instituteId = await encryptData(instituteId);
            countryId  = await encryptData(countryId);           
            if (user_role_id_text == 'INSTITUTE ADMIN'){
			var jsondata = {

				"login_name": login_name,
				"user_name": user_name,
				/*"army_no": army_no,*/
				"user_password": user_password,
				"user_re_password": user_re_password,
				"user_role_id": user_role_id,
				"instituteId": instituteId,

			}
			}
			else{
				var jsondata = {
				"login_name": login_name,
				"user_name": user_name,
				/*"army_no": army_no,*/
				"user_password": user_password,
				"user_re_password": user_re_password,
				"user_role_id": user_role_id,
				"instituteId": countryId,
				}
			}
			var salt = document.getElementById("salt").value;
			var iv = document.getElementById("iv").value;
			var key = document.getElementById("key").value;

			var key1 = generateRandomKey("6");
			var key2 = generateRandomKey("6");
			var key3 = generateRandomKey("6");
			var key4 = generateRandomKey("6");

			var jsonObjects = [];
			var jsonObject = {
				[key1]: JSON.stringify(jsondata)
			};
			jsonObjects.push(jsonObject);
			var jsonObject = {
				[key2]: salt
			};
			jsonObjects.push(jsonObject);
			var jsonObject = {
				[key3]: iv
			};
			jsonObjects.push(jsonObject);
			var jsonObject = {
				[key4]: key
			};
			jsonObjects.push(jsonObject);

			var jsondata1 = {
				"data": Base64.encode(JSON.stringify(jsonObjects))
			}
		} else {
			if (user_role_id_text == 'ADMIN'){
			var jsondata1 = {
				"userId": document.getElementById("id").value,
				"login_name": login_name,
				"userName": user_name,
				/*"army_no": army_no,*/
				"password": user_password,
				"instituteId": instituteId,

			}
			}
			else{
				var jsondata1 = {
				"userId": document.getElementById("id").value,
				"login_name": login_name,
				"userName": user_name,
				/*"army_no": army_no,*/
				"password": user_password,
				"instituteId": countryId,

			}
			}

		}
	}
	else {
		$.confirm({
			title: '',
			content: "Password and Confirm Password must be same.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],

				}
			}
		});
		return false;

	}
	$
		.ajax(
			{
				url: '../admin/SaveUserData',
				type: "POST",
				data: JSON.stringify(jsondata1),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#userdiv').unblock();
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
									window.location.reload();
								}
							}
						}
					});
				} else {
					$.alert({
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
			$('#userdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
			//alert('File upload failed ...');
		});


}
/*Delete User Data*/
//function DeleteUser(id) {
//	$('#userdiv').block({ message: 'Please wait....' });
//	var jsondata = {
//		"id": id
//		
//	}
//	$
//		.ajax(
//			{
//				url: '/FriendsForLife/admin/DeleteUser',
//				type: "POST",
//				data: JSON
//					.stringify(jsondata),
//				contentType: 'application/json',
//				cors: true,
//				dataType: 'json',
//
//			})
//		.done(
//			function(data) {
//				$('#userdiv').unblock();
//				if (data.status == '1') {
//					$.confirm({
//							title: '',
//							content: data.message,
//
//
//							buttons: {
//
//
//								OK: {
//									text: 'OK',
//									btnClass: 'btn-blue',
//									keys: ['enter', 'shift'],
//									action: function() {
//										window.location.reload();
//									}
//								}
//							}
//						});
//				} else {
//					alert(data.message);
//				}
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#userdiv').unblock();
//			alert(jqXHR.responseText);
//
//		});
//}


/*Update User Data*/
//function GetUserUpdate(id) {
//
//	$('#userdiv').block({ message: 'Please wait....' });
//	var jsondata = {
//		"id": id
//
//	}
//
//	$
//		.ajax(
//			{
//				url: '/FriendsForLife/admin/GetUserUpdate',
//				type: "POST",
//				data: JSON
//					.stringify(jsondata),
//				contentType: 'application/json',
//				cors: true,
//				dataType: 'json',
//
//			})
//		.done(
//			function(data) {
//				$('#userdiv').unblock();
//				if (data.status == '1') {
//					document.getElementById("login_name").value = data.login_name;
//					document.getElementById("user_password").value = data.password;
//					document.getElementById("user_name").value = data.user_name;
//					document.getElementById("army_no").value = data.army_no;
//					document.getElementById("id").value = data.id;
//					document.getElementById("actiontype").value = "Edit";
//					document.getElementById("userbtn").value = "Update";
//					
//				} else {
//					$.alert({
//						title: '',
//						content: data.message,
//					});
//				}
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#userdiv').unblock();
//			alert(jqXHR.responseText);
//		});
//}


function setevents() {

	document.querySelectorAll('.actdeactclass').forEach((items1, index1) => {
		items1.addEventListener('click', event => {
			var val = parseInt(index1) + 1;
			var hid = document.getElementById('hid' + val).value;
			var hida = document.getElementById('hida' + val).value;

			if (hida == "Deactivate") {
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Deactivate This User?',
					buttons: {

						cancel: function(button) {
							//return false;
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								ActivateDeactivateUser(hid, "Deactivate");
							}
						}
					}
				});
			} else {
				$.confirm({
					title: '',
					content: 'Are You Sure You Want to Activate The User?',

					buttons: {

						cancel: function(button) {
							//return false;
						},
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
								ActivateDeactivateUser(hid, "Activate");
							}
						}
					}
				});
			}


		});
	});




}
function ActivateDeactivateUser(hid, action) {
	//alert(action);
	$('#userdiv').block({ message: 'Please wait....' });
	var jsondata = {
		"userid": hid,
		"action": action
	}

	$
		.ajax(
			{
				url: '../admin/ActivateDeactivateUser',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#userdiv').unblock();
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
									window.location.reload();
								}
							}
						}
					});
				} else {
					alert(data.message);
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#userdiv').unblock();
			alert(jqXHR.responseText);
			//alert('File upload failed ...');
		});

}