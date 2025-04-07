$(document).ready(function() {

	//	getInstitute();
	getInstitute(1, -1);
	getCountry();

	var currentYear = new Date().getFullYear();
	var years = [];
	for (var i = 0; i < 25; i++) {
		years.push(currentYear - i);
	}
	var select = document.getElementById('passoutYear_1');
	for (var i = 0; i < years.length; i++) {
		var option = document.createElement('option');
		option.text = years[i];
		option.value = years[i];
		select.appendChild(option);
	}

	let count = 1;

	$(document).on('click', '.btnadd', function() {
		var totalelements = document.querySelectorAll('.CommonLibraryBookClass');

		for (var i = 1; i <= totalelements.length; i++) {


			if ($('#instituteId_' + i).val() == -1) {
				$('#instituteId_' + i).focus();
				$.confirm({
					title: '',
					content: "Please Select Institute at the Row " + i,
					buttons: {
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
							}
						}
					}
				});
				return false;
			}

			var res = CheckNullorBlank('rollNumber_' + i);
			if (res !== "true") {
				$('#rollNumber_' + i).focus();
				$.confirm({
					title: '',
					content: "Please Select Course No. at the Row " + i,
					buttons: {
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
							}
						}
					}
				});
				return false;
			}

			var res = OnlyAlphaNumericWithoutSpaceRegExpCapital('rollNumber_' + i);
			if (res !== "true") {
				$('#rollNumber_' + i).focus();
				$.confirm({
					title: '',
					content: "Course Name & Number. Should Contains Only Capital AlphaNumeric Value at the Row " + i,
					buttons: {
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
							}
						}
					}
				});
				return false;
			}

			//			var res = CheckNullorBlank('passoutYear_' + i);
			if ($('#passoutYear_' + i).val() == -1) {

				$('#passoutYear_' + i).focus();
				$.confirm({
					title: '',
					content: "Please Select Pass Out Year at the Row " + i,
					buttons: {
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
							}
						}
					}
				});
				return false;
			}





		}

		for (var i = totalelements.length; i >= 1; i--) {

			for (var k = 1; k < i; k++) {
				if ($('#instituteId_' + i).val() == $('#instituteId_' + k).val() && $('#rollNumber_' + i).val() == $('#rollNumber_' + k).val()) {
					$.confirm({
						title: '',
						content: "Same Course No. is Exist for Institute at Row " + i,
						buttons: {
							OK: {
								text: 'OK',
								btnClass: 'btn-blue',
								keys: ['enter', 'shift'],
								action: function() {
								}
							}
						}
					});
					return false;
				}
			}


		}

		let html = ""
		count++


		html += `
				<tr id="bookreport_${count}" class="CommonLibraryBookClass">
				
					<td>
					<div class="form-group">
																<select name="instituteId_${count}"
																	class="singleselect form-control instituteclass" id="instituteId_${count}">
																	<option value="-1">---Select Institute---</option>

																</select>
														</div>
					</td>
					<td>
					<div class="form-group">
															<input type="text" class="form-control" id="rollNumber_${count}"
																placeholder="Enter Enrollment No." name="rollNumber_${count}"
																autocomplete="off" tabindex="1" maxlength="10">
														</div>
						</td>
						
						<td>
						<div class="form-group" >
															<select name="passoutYear_${count}"
																class="singleselect form-control " id="passoutYear_${count}">
																<option value="-1">---Select Passout Year---</option>

															</select>
														</div>
						</td>

					<td>
						<ul class="custom-btn-group btn-group-sm">
						<li class="list-inline-item">
							<button type="button" class="btn btn-info icon-btn btnadd" title="Add">
									<i class="ri-add-line"></i>
							</button></li>
						<li class="list-inline-item">
							<button type="button" class="btn btn-warning icon-btn btndelete1" data-trid="bookreport_${count}" title="Delete">
									<i class="ri-delete-bin-2-fill"></i>
							</button></li>
						</ul>
					</td>
				</tr>`

		$('#bkreport').append(html);
		getInstitute(count, -1);


		var currentYear = new Date().getFullYear();
		var years = [];
		for (var i = 0; i < 25; i++) {
			years.push(currentYear - i);
		}
		var select = document.getElementById('passoutYear_' + count);
		for (var i = 0; i < years.length; i++) {
			var option = document.createElement('option');
			option.text = years[i];
			option.value = years[i];
			select.appendChild(option);
		}
		$(`#passoutYear_${count}`).select2();

	})


	$(document).on('click', '.btndelete1', function() {
		let id = $(this).data('trid');
		count = count - 1;;
		$(`#${id}`).remove();
	})

/*	$('countryId').on('change', function() {
	  alert( this.value );
	});*/
});

document.addEventListener('DOMContentLoaded', function() {
	document.getElementById("countryId").onchange=function(){
			/*document.getElementById("countryId").value=this.options[this.selectedIndex].getAttribute("data");*/
			 /*alert(this.options[this.selectedIndex].getAttribute("data"));*/
			 var num=this.options[this.selectedIndex].getAttribute("data");
			 $("#contactPrefix").val('+'+num);

		}



	document.getElementById("signUpButton").onclick =
	
	
	async	function() {
		await GenerateKey();
			return await SaveRegistrationDetails();
		};
	
		
	document.getElementById('contactNumber').onkeypress =
		function() {
			return AllowOnlyDigit(event, this);
		};
//	document.getElementById('rollNumber_').onkeypress =
//		function() {
//			return AllowOnlyDigit(event, this);
//		};
//	document.getElementById('passoutYear_').onkeypress =
//		function() {
//			return AllowOnlyDigit(event, this);
//		};
	document.getElementById('alumniName').onkeypress =
		function() {
			return OnlyAlphaNumericWithSpace(event, this);
		};
	document.getElementById('Username').onkeypress =
		function() {
			return OnlyAlphaNumAndUnderscoreRegExp(event, this);
		};
});

function getCountry() {

	$('#halloffamediv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: 'admin/getCountry',
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
					selectHtml = selectHtml + "<option data='" + jdData.code + "' value='" + jdData.id + "'>" + jdData.country_name + "</option>";
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



function getInstitute(id, val) {

	$('#registrationdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: 'admin/getInstitute',
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

				//				$('#instituteId').html(selectHtml);
				$('#instituteId_' + id).html(selectHtml);
				$('#instituteId_' + id).select2();
				$('#instituteId_' + id).val(val);

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

function generateRandomKey(length) {
	let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	let key = '';
	for (let i = 0; i < length; i++) {
		key += characters.charAt(Math.floor(Math.random() * characters.length));
	}
	return key;
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

function GenerateKey1() {
	var iterationCount = 1000;
	var keySize = 128;

	var val = GenerateRandomNumber1();
	var passphrse = Base64.encode(val);
	var iv = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);
	var salt = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);
	document.getElementById("salt").value = salt;
	document.getElementById("iv").value = iv;
	document.getElementById("key").value = passphrse;



}
function GenerateRandomNumber1() {

	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 5; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}

async function SaveRegistrationDetails() {

	var alumniName = document.getElementById("alumniName").value;
	var userName = document.getElementById("Username").value;
	var contactNumber = document.getElementById("contactNumber").value;
	var emailId = document.getElementById("emailId").value;
	var gender = $("input:radio[name=gender]:checked").val()
	var countryId = document.getElementById("countryId").value;

	var res = CheckNullorBlank('alumniName');
	if (res !== "true") {
		$('#alumniName').focus();
		$.confirm({
			title: '',
			content: res + "Alumni Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	var res = OnlyAlphabeAndSpaceRegExp('alumniName');
	if (res !== "true") {
		$('#alumniName').focus();
		$.confirm({
			title: '',
			content: "Alumni Name " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('alumniName', 125);
	if (res !== "true") {
		$('#alumniName').focus();
		$.confirm({
			title: '',
			content: "Alumni Name Should Contains Only 125 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}

	var res = CheckNullorBlank('contactNumber');
	if (res !== "true") {
		$('#contactNumber').focus();
		$.confirm({
			title: '',
			content: res + " Contact Number",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}

	/*var res = MinumumLengthCheck('contactNumber', 10);
	if (res !== "true") {
		$('#contactNumber').focus();
		$.confirm({
			title: '',
			content: "Contact Number Should Contains at least 10 digit.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}*/
	
	
	var res = MinumumLengthCheck('contactNumber', 7);
		if (res !== "true") {
			$('#contactNumber').focus();
			$.confirm({
				title: '',
				content: "Contact Number Should Contains at least 7 digit.",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}
		
		var res = MaximumLengthCheck('contactNumber', 10);
		if (res !== "true") {
			$('#contactNumber').focus();
			$.confirm({
				title: '',
				content: "Contact Number Should Contains Max 10 digit.",
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}




	var res = OnlyDifitRegEx('contactNumber');
	if (res !== "true") {
		$('#contactNumber').focus();
		$.confirm({
			title: '',
			content: " Contact Number" + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
/*
	var res = OnlyDifitRegExformobile('contactNumber');
	if (res !== "true") {
		$('#contactNumber').focus();
		$.confirm({
			title: '',
			content: "First Digit of Contact Number Must start with 6,7,8 or 9  digit",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});

		return false;
	}*/

	var res = CheckNullorBlank('Username');
	if (res !== "true") {
		$('#Username').focus();
		$.confirm({
			title: '',
			content: res + "User ID",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	var res = OnlyAlphaNumAndUnderscoreRegExp('Username');
	if (res !== "true") {
		$('#Username').focus();
		$.confirm({
			title: '',
			content: "User ID " + res,
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	
	
	// added by mee
	
	
	
	
	
	var res = MaximumLengthCheck('Username', 125);
	if (res !== "true") {
		$('#Username').focus();
		$.confirm({
			title: '',
			content: "User ID Should Contains Only 125 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}


	var res = CheckNullorBlank('emailId');
	if (res !== "true") {
		$('#emailId').focus();
		$.confirm({
			title: '',
			content: res + " Email Id",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}
	var res = validateEmail2($('#emailId').val());

	if (res !== true) {
		$('#emailId').focus();
		$.confirm({
			title: '',
			content: "Please Enter Valid Email ID ", /*Like gmail.com , gov.in and nic.in*/
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						// Additional action if needed
					}
				}
			}
		});
		return false;
	}
	var res = MaximumLengthCheck('emailId', 125);
	if (res !== "true") {
		$('#emailId').focus();
		$.confirm({
			title: '',
			content: "Email ID Should Contains Only 256 Characters.",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}


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
	var res = CheckRadioSelected('gender');
	if (res !== "true") {
		$('#gender').focus();
		$.confirm({
			title: '',
			content: res + "Gender",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
					}
				}
			}
		});
		return false;
	}

	var totalelements = document.querySelectorAll('.CommonLibraryBookClass');

	for (var i = 1; i <= totalelements.length; i++) {


		if ($('#instituteId_' + i).val() == -1) {
			$('#instituteId_' + i).focus();
			$.confirm({
				title: '',
				content: "Please Select Institute at the Row " + i,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}

		var res = CheckNullorBlank('rollNumber_' + i);
		if (res !== "true") {
			$('#rollNumber_' + i).focus();
			$.confirm({
				title: '',
				content: "Please Select Course No. at the Row " + i,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}

		var res = OnlyAlphaNumericWithoutSpaceRegExpCapital('rollNumber_' + i);
		if (res !== "true") {
			$('#rollNumber_' + i).focus();
			$.confirm({
				title: '',
				content: "Course No. Should Contains Only Capital AlphaNumeric Value at the Row " + i,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}

		var res = CheckNullorBlank('passoutYear_' + i);
		if (res !== "true") {
			$('#passoutYear_' + i).focus();
			$.confirm({
				title: '',
				content: "Please Select Pass Out Year at the Row " + i,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}

		var res = OnlyDifitRegEx('passoutYear_' + i);
		if (res !== "true") {
			$('#passoutYear_' + i).focus();
			$.confirm({
				title: '',
				content: "Please Select Pass Out Year at the Row " + i,
				buttons: {
					OK: {
						text: 'OK',
						btnClass: 'btn-blue',
						keys: ['enter', 'shift'],
						action: function() {
						}
					}
				}
			});
			return false;
		}

		for (var k = 1; k < i; k++) {
			if ($('#instituteId_' + i).val() == $('#instituteId_' + k).val() && $('#rollNumber_' + i).val() == $('#rollNumber_' + k).val()) {
				$.confirm({
					title: '',
					content: "Same Course No. is Exist for Institute at Row " + i,
					buttons: {
						OK: {
							text: 'OK',
							btnClass: 'btn-blue',
							keys: ['enter', 'shift'],
							action: function() {
							}
						}
					}
				});
				return false;
			}
		}

	}
	

	userName = await encryptData(userName);
	contactNumber = await encryptData(contactNumber);
	emailId = await encryptData(emailId);
	var salt = document.getElementById("salt").value;
	var iv = document.getElementById("iv").value;
	var key = document.getElementById("key").value;
	var password = document.getElementById("passsWord").value;




	var key1 = generateRandomKey("6");
	var key2 = generateRandomKey("6");
	var key3 = generateRandomKey("6");
	var key4 = generateRandomKey("6");
	var key5 = generateRandomKey("6");
	var key6 = generateRandomKey("6");
	var key7 = generateRandomKey("6");
	var key8 = generateRandomKey("6");
	var key9 = generateRandomKey("6");
	var key10 = generateRandomKey("6");


	var jsonObjects = [];
	var jsonObject = {
		[key1]: alumniName
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key2]: userName
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key3]: contactNumber
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key4]: emailId
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key5]: gender
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key6]: countryId
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key7]: salt
	};
	jsonObjects.push(jsonObject);


	var jsonObject = {
		[key8]: iv
	};
	jsonObjects.push(jsonObject);

	var jsonObject = {
		[key9]: key
	};
	jsonObjects.push(jsonObject);
	
	var jsonObject = {
			[key10]: password
		};
		jsonObjects.push(jsonObject);


	var jsondata = {
		"data": Base64.encode(JSON.stringify(jsonObjects))
	}



	$('#registrationdiv').block(	{
	    message: '<h3>Please wait....</h3>',
		css: {
		        padding: '10px',
		        margin: '0',
		        width: '200px',  // Smaller width
		        position: 'fixed',
		        top: '50%',
		        left: '50%',
		        transform: 'translate(-50%, -50%)',
		        textAlign: 'center',
		        color: '#000',
		        border: '2px solid #aaa',  // Slightly thinner border
		        backgroundColor: '#fff',
		        cursor: 'wait',
		        zIndex: 9999,
		        fontSize: '14px',  // Smaller font size
		        fontWeight: 'normal',
		        borderRadius: '5px'  // Rounded edges for a neater look
		    },
		    overlayCSS: {
		        backgroundColor: '#000',
		        opacity: 0.3,  // Lighter overlay
		        cursor: 'default',
		        position: 'fixed',
		        top: 0,
		        left: 0,
		        width: '100%',
		        height: '100%',
		        zIndex: 9998
		    }
	});
	if (document.getElementById("actiontype").value == "add") {
		//		var jsondata = {
		//			"alumniName": alumniName,
		//			"userName": userName,
		//			"contactNumber": contactNumber,
		//			"emailId": emailId,
		//			"gender": gender,
		//			"countryId": countryId,
		//
		//		}

		jsonlistcls = [];

		var count = 1;
		var jsonarray = document.querySelectorAll('select.instituteclass');


		for (var i = 0; i < jsonarray.length; i++) {

			item = {};
			item["instituteId_"] = document.getElementById("instituteId_" + (count)).value;
			var rollno =  await encryptData(document.getElementById("rollNumber_" + (count)).value);
			item["rollNumber_"] = rollno;

			item["passoutYear_"] = document.getElementById("passoutYear_" + (count)).value;
			jsonlistcls.push(item);
			count++;

		}

	} else {


	}
	var formData = new FormData();
	formData.append("tbRegistrationDetail", JSON.stringify(jsondata));
	formData.append("registrationchild", JSON.stringify(jsonlistcls));
	$
		.ajax(
			{
				url: 'admin/SaveRegistrationDetails',
				type: "POST",
				data: formData,
				dataType: 'json',
				processData: false,
				contentType: false,
				cache: false,


			})
		.done(
			function(data) {
				$('#registrationdiv').unblock();
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
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#registrationdiv').unblock();
			alert(jqXHR.responseText);

		});
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
