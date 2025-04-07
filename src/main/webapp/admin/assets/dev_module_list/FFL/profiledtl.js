


$(document).ready(function() {

	const currentDate = new Date();
	const eighteenYearsAgo = new Date(currentDate.getFullYear() - 18, currentDate.getMonth(), currentDate.getDate());
	dateOfBirth.max = eighteenYearsAgo.toISOString().split("T")[0];

	loadProfiledtl()

	const fileInput = document.getElementById('photo');

	// Add an event listener to the file input element
	fileInput.addEventListener('change', (e) => {
		const file = fileInput.files[0];
		const reader = new FileReader();

		// Read the file as a base64 encoded string
		reader.onload = () => {
			const base64String = reader.result;
			const imgElement = document.querySelector('.crm-profile-pic');

			// Update the src attribute of the img element with the base64 encoded string
			imgElement.src = base64String;
		};

		reader.readAsDataURL(file);
	});

});
async function decryptData(password, encryptedData) {
	const { ciphertext, iv, authTag, salt } = encryptedData;

	const key = await deriveKey(password, salt);

	// Recombine ciphertext and authentication tag
	const dataWithAuthTag = new Uint8Array(ciphertext.length + authTag.length);
	dataWithAuthTag.set(ciphertext, 0);
	dataWithAuthTag.set(authTag, ciphertext.length);

	// Decrypt using AES-GCM
	const decryptedContent = await window.crypto.subtle.decrypt(
		{
			name: "AES-GCM",
			iv: iv,
			tagLength: 128,
		},
		key,
		dataWithAuthTag
	);

	return new TextDecoder().decode(decryptedContent);
}

document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("submitbtn").onclick =
	
		async function() {
			await GenerateKey();
			return await saveProfiledtl();
		};


	document.getElementById('contactNo').onkeypress =
		function() {
			return AllowOnlyDigit(event, this);
		};

	const pasteBox1 = document.getElementById("dateOfBirth");
	pasteBox1.onpaste = e => {
		e.preventDefault();
		return false;
	};

	$("#dateOfBirth").on("keydown", function(e) {
		e.preventDefault();
	});

	document.getElementById("reset").onclick =
		function() {

			return ResetInput();
		};

});

function ResetInput() {
	window.location.reload();
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
async function saveProfiledtl() {

	var name = document.getElementById("name").value;
	var emailId = document.getElementById("emailId").value;
	var contactNo = document.getElementById("contactNo").value;
	var gender = $("input:radio[name=gender]:checked").val()
	var dateOfBirth = document.getElementById("dateOfBirth").value;
	var address = document.getElementById("address").value;
	var actiontype = document.getElementById("actiontype").value;
	$('#profiledtl').block({ message: 'Please wait....' });

	var res = CheckNullorBlank('name');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Name",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#name').focus();
					}
				}
			}
		});
		return false;
	}
	var res = CheckNullorBlank('emailId');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Email Id",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#emailId').focus();
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
			content: "Please Enter Valid Email ID", /*Like gmail.com , gov.in and nic.in*/
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

	var res = CheckNullorBlank('contactNo');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + " Contact Number",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#contactNo').focus();
					}
				}
			}
		});
		return false;
	}
	var res = MinumumLengthCheck('contactNo', 10);
	if (res !== "true") {
		$('#contactNo').focus();
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
	}

	var res = OnlyDifitRegEx('contactNo');
	if (res !== "true") {
		$('#contactNo').focus();
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

	var res = OnlyDifitRegExformobile('contactNo');
	if (res !== "true") {
		$('#contactNo').focus();
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
	}
	var res = CheckRadioSelected('gender');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Gender",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#gender').focus();
					}
				}
			}
		});
		return false;
	}
	var res = CheckNullorBlank('dateOfBirth');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: "Please Select Date of Birth",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#dateOfBirth').focus();
					}
				}
			}
		});
		return false;
	}

	var res = CheckNullorBlank('address');
	if (res !== "true") {
		$.confirm({
			title: '',
			content: res + "Addess",
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						$('#address').focus();
					}
				}
			}
		});
		return false;
	}

	GenerateKey1();

	contactNumber = await encryptData(contactNo);
	emailId = await encryptData(emailId);
	var salt = document.getElementById("salt").value;
	var iv = document.getElementById("iv").value;
	var key = document.getElementById("key").value;




	var key1 = generateRandomKey("6");
	var key2 = generateRandomKey("6");
	var key3 = generateRandomKey("6");
	var key4 = generateRandomKey("6");
	var key4 = generateRandomKey("6");
	var key5 = generateRandomKey("6");
	var key6 = generateRandomKey("6");
	var key7 = generateRandomKey("6");
	var key8 = generateRandomKey("6");
	var key9 = generateRandomKey("6");


     var jsonObjects = [];

	var jsonObject = {
		[key1]: name
	};

	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key2]: emailId
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key3]: dateOfBirth
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key4]: contactNumber
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key5]: gender
	};
	jsonObjects.push(jsonObject);
	var jsonObject = {
		[key6]: address
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


	var jsondata = {
		"data": Base64.encode(JSON.stringify(jsonObjects))
	}



	if (document.getElementById("actiontype").value == "add") {
		//		var jsondata = {
		//
		//			"name": name,
		//			"emailId": emailId,
		//			"dateOfBirth": dateOfBirth,
		//			"contactNo": contactNo,
		//			"gender": gender,
		//			"address": address,
		//		}
	}
	else {
//		var jsondata = {
//			//			"id": document.getElementById("id").value,
//			"name": name,
//			"emailId": emailId,
//			"dateOfBirth": dateOfBirth,
//			"contactNo": contactNo,
//			"gender": gender,
//			"address": address,
//		}
	}

	var formData = new FormData();
	formData.append("ProfileDtl", JSON.stringify(jsondata));
	formData.append("uploadImage", $('input[type=file]')[0].files[0])

	$.ajax(
		{
			url: '../admin/saveProfiledtl',
			type: "POST",
			data: formData,
			dataType: 'json',
			processData: false,
			contentType: false,
			cache: false,
			enctype: 'multipart/form-data',


		})
		.done(
			function(data) {
				$('#profiledtl').unblock();
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
			$('#profiledtl').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});

}


function base64ToUint8Array(base64) {

	const binaryString = atob(base64);
	const bytes = new Uint8Array(binaryString.length);
	for (let i = 0; i < binaryString.length; i++) {
		bytes[i] = binaryString.charCodeAt(i);
	}
	return bytes;
}



async function deriveKey(password, salt) {
	try {
		const encodedPassword = new TextEncoder().encode(password);
		const baseKey = await window.crypto.subtle.importKey(
			"raw",
			encodedPassword,
			{ name: "PBKDF2" },
			false,
			["deriveKey"]
		);

		return await window.crypto.subtle.deriveKey(
			{
				name: "PBKDF2",
				salt: salt,
				iterations: 600000,
				hash: "SHA-256",
			},
			baseKey,
			{ name: "AES-GCM", length: 256 },
			true,
			["decrypt"]
		);
	} catch (error) {
		console.error("Error deriving key:", error);
		throw error;
	}
}
async function decryptServerDatakak(encryptedData, key) {
	try {
		const { ciphertext, iv, authTag } = encryptedData;

		const dataWithAuthTag = new Uint8Array(ciphertext.length + authTag.length);
		dataWithAuthTag.set(authTag, 0);
		dataWithAuthTag.set(ciphertext, authTag.length);

		const decryptedContent = await window.crypto.subtle.decrypt(
			{
				name: "AES-GCM",
				iv: iv,
				tagLength: 128,
			},
			key,
			dataWithAuthTag
		);

		return new TextDecoder().decode(decryptedContent);
	} catch (error) {
		console.error("Error decrypting data:", error);
		throw error;
	}
}

function loadProfiledtl() {
	$.ajax({
		url: '../admin/loadProfiledtl',
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(jsondata),
		cors: true,
		dataType: 'json',
	})
		.done(async function(data) {
			try {

				if (data.status == '1') {

					var base64Salt = document.getElementById("GeneratedSalt").value; // Replace with Base64 value from Java
					var base64Iv = document.getElementById("GeneratedIV").value; // Replace with Base64 value from Java
					var base64Ciphertext = data.emailId; // Replace with Base64 value from Java
					var base64AuthTag = data.emailIdAuth; // Replace with Base64 value from Java
					var password = document.getElementById("Generatedpassword").value; // Same password used in Java

					// Convert Base64-encoded values to Uint8Array
					var encryptedData = {
						salt: base64ToUint8Array(base64Salt),
						iv: base64ToUint8Array(base64Iv),
						ciphertext: base64ToUint8Array(base64Ciphertext),
						authTag: base64ToUint8Array(base64AuthTag),
					};

					// Decrypt the data
					decryptData(password, encryptedData)
						.then(decryptedData => {
							console.log("Decrypted Data:", decryptedData);
							document.getElementById("emailId").value = decryptedData;
						})
						.catch(error => {
							console.error("Decryption failed:", error);
						});
					base64Ciphertext = data.contactNo; // Replace with Base64 value from Java
					base64AuthTag = data.contactNoAuth; // Replace with Base64 value from Java

					encryptedData = {
						salt: base64ToUint8Array(base64Salt),
						iv: base64ToUint8Array(base64Iv),
						ciphertext: base64ToUint8Array(base64Ciphertext),
						authTag: base64ToUint8Array(base64AuthTag),
					};

					// Decrypt the data
					decryptData(password, encryptedData)
						.then(decryptedData => {
							console.log("Decrypted Data:", decryptedData);
							document.getElementById("contactNo").value = decryptedData;
						})
						.catch(error => {
							console.error("Decryption failed:", error);
						});



					document.getElementById("name").value = data.name;
					document.getElementById("dateOfBirth").value = data.dateOfBirth || '';
					document.getElementById("address").value = data.address;
					document.getElementById("submitbtn").value = "Edit";
					document.querySelector(`input[name="gender"][value="${data.gender}"]`).checked = true;
					const imgElement = document.querySelector('.crm-profile-pic');
					imgElement.src = "data:image/png;base64," + data.uploadPic;
				}
				else {

				}

			} catch (error) {
				console.error("Error loading profile details:", error);
				$.alert({
					title: '',
					content: 'Failed to load profile details. Please try again.',
				});
			}
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.error("Error loading profile details:", errorThrown);
//			$.alert({
//				title: '',
//				content: 'Failed to load profile details. Please try again.',
//			});
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


