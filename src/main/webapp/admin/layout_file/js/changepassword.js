$(document).ready(function() {
	var firsttime = document.getElementById("firsttimechange").value;

	if (firsttime == 'true') {
		swal("You have to Change the Password First to access the Service")
			.then((value) => {


			});
	}
});
function ChangePassword() {

	var newpass = $("#new_pass").val().trim();
	var confirmapss = $("#c_password").val().trim();
	if ($("#old_pass").val().trim() == "") {
		swal("Please Enter Old Password");
		$("#old_pass").focus();
		return false;
	}
	if ($("#old_pass").val().trim() < 8) {
		swal("Password must be of atleast 8 letters");
		$("#old_pass").focus();
		return false;
	}
	if ($("#new_pass").val().trim() == "") {
		swal("Please Enter  New Password");
		$("#new_pass").focus();
		return false;
	}
	if ($("#new_pass").val().trim() < 8) {
		swal("New Password must be of atleast 8 letters");
		$("#new_pass").focus();
		return false;
	}
	if ($("#old_pass").val().trim() == newpass) {
		swal("Old Password and Confirm Password can not be same");
		$("#new_pass").focus();
		return false;
	}
	var reg = /^(?=.{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?\W).*$/;
	if (!reg.test(newpass)) {
		swal('Please Enter New Password in Defined Format');
		return false;
	}
	if ($("#c_password").val().trim() == "") {
		swal("Please Enter Confirm  Password");
		$("#c_password").focus();
		return false;
	}
	if ($("#c_password").val().trim() < 8) {
		swal("Confirm Password must be of atleast 8 letters");
		$("#c_password").focus();
		return false;
	}
	if (!reg.test(confirmapss)) {
		swal('Please Enter New Password in Defined Format');
		return false;
	}
	if ($("#new_pass").val().trim() != $("#c_password").val().trim()) {
		swal("New Password and Confirm Password does not match");
		$("#new_pass").focus();
		return false;
	}


	GenerateKey();
	var old_pass = GenerateEncryptedValue($("#old_pass").val().trim());
	var new_pass = GenerateEncryptedValue(newpass);
	var con_pass = GenerateEncryptedValue(confirmapss);

	var jsondata = {
		"old_pass": old_pass,
		"new_pass": new_pass,
		"c_password": con_pass,
		"salt": $("#salt").val().trim(),
		"iv": $("#iv").val().trim(),
		"key": $("#key").val().trim()
	}

	$('#chnagepassworddiv').block({ message: 'Please wait....' });


	$.ajax(
		{
			url: '/AFMS/ChangePasswordSubmit',
			type: "POST",
			data: JSON
				.stringify(jsondata),

			contentType: 'application/json',
			dataType: 'json',

		})
		.done(
			function(data) {
				$('#chnagepassworddiv').unblock();
				if (data.status == '1') {

					if (data.firsttimechange == 'true') {

						swal("Password Chnaged Successfully.Now Login again to access the service")
							.then((value) => {
								document.getElementById("logoutForm").submit();

							});
					} else {
						swal(data.message);
					}
				} else {
					swal(data.message);
				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#chnagepassworddiv').unblock();
			swal(jqXHR.responseText);
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

	var passphrse = Base64.encode(GenerateRandomNumber());
	//var passphrse = $('#key').val();

	var iv = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);
	var salt = CryptoJS.lib.WordArray.random(128 / 8).toString(
		CryptoJS.enc.Hex);

	//var aesUtil = new AesUtil(keySize, iterationCount);
	//var ciphertext = aesUtil.encrypt(salt, iv, passphrse, otpvalue);
	//document.getElementById("OTPEncrypted").value = ciphertext;
	document.getElementById("salt").value = salt;
	document.getElementById("iv").value = iv;
	document.getElementById("key").value = passphrse;
}
function GenerateRandomNumber() {

	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 5; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}