

$(document).ready(function() {


	$('#custom-alert-message').hide();
	$('#errormessagediv').text("");

	var messagehiddeninput = document.getElementById("messagehiddeninput").value;
	var errorhiddeninput = document.getElementById("errorhiddeninput").value;
	if (messagehiddeninput != "") {
		$('#errormessagediv').text(messagehiddeninput);
		$('#custom-alert-message').show();
	} else if (errorhiddeninput != "") {

		$('#errormessagediv').text(errorhiddeninput);
		$('#custom-alert-message').show();
	} else {

		$('#errormessagediv').text("");
		$('#custom-alert-message').hide();
	}


	$('#verifyandregister').prop('disabled', true);
	$("#fnameforreg").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$("#mnameforreg").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$("#lnameforreg").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$("#neetregno").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 65 && inputValue <= 120) && !(inputValue >= 48 && inputValue <= 57) && (inputValue != 32 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$("#dnbpdcetno").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 65 && inputValue <= 120) && !(inputValue >= 48 && inputValue <= 57) && (inputValue != 32 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	/*$("#aadhaarnumber").keydown(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 48 && inputValue <= 57) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});*/

	$("#otpforforgot").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 48 && inputValue <= 57) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$("#otp").keypress(function(event) {
		var inputValue = event.which;
		// allow letters and whitespaces only.
		if (!(inputValue >= 48 && inputValue <= 57) && (inputValue != 32 && inputValue != 0 && inputValue != 8)) {
			event.preventDefault();
		}
	});
	$('#dnbdiv').hide();
	$('input[type=radio][name=apptype]').change(function() {

		if (this.value == "NEET-PG") {
			$('#nameforreg').attr('placeholder',
				'Enter your Name as per NEET');
			$('#neetdiv').show();
			$('#dnbdiv').hide();
		} else if (this.value == "DNB-PDCET") {
			$('#nameforreg').attr('placeholder',
				'Enter your Name as per DNB-PDCET');

			$('#dnbdiv').show();
			$('#neetdiv').hide();
		}
	});





});
function sendOTPOnEmail() {

	$('#regModal').block({ message: 'Please wait....' });

	var apptype = $("input[name='apptype']:checked").val();
	var neetregnumber = "";
	var dnbpdcetnumber = "";
	var neetregnumberorpgdcer = "";
	if (apptype == "NEET-PG") {
		neetregnumberorpgdcer = document.getElementById("neetregno").value.trim();
		neetregnumber = document.getElementById("neetregno").value.trim();
	} else {
		neetregnumberorpgdcer = document.getElementById("dnbpdcetno").value.trim();
		dnbpdcetnumber = document.getElementById("dnbpdcetno").value.trim();
	}
	var fnameforreg = document.getElementById("fnameforreg").value.trim();
	var mnameforreg = document.getElementById("mnameforreg").value.trim();
	var lnameforreg = document.getElementById("lnameforreg").value.trim();
	var emailforreg = document.getElementById("emailforreg").value.trim();

	//var aadhaarnumber = document.getElementById("aadhaarnumber").value;
	var servicetype = $('#servicetype').val();
	if (fnameforreg == "" || fnameforreg == null || fnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter First Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (fnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'First Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (mnameforreg == "" || mnameforreg == null || mnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Middle Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (mnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'Middle Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (lnameforreg == "" || lnameforreg == null || lnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Last Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (lnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'Last Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (emailforreg == "" || emailforreg == null || emailforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Email',
		});
		$('#regModal').unblock();
		return false;
	}
	if (document.getElementById("emailforreg").value.length < 6) {

		$.alert({
			title: '',
			content: 'Email must be of atleast 6 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (apptype == "NEET-PG") {
		if (neetregnumber == "" || neetregnumber == null || neetregnumber == undefined) {

			$.alert({
				title: '',
				content: 'Please Enter NEET Registration Number',
			});
			$('#regModal').unblock();
			return false;
		}
		if (neetregnumber.length < 6) {

			$.alert({
				title: '',
				content: 'NEET Registration Number must be of atleast 6 letters.',
			});
			$('#regModal').unblock();
			return false;
		}
	} else {
		if (dnbpdcetnumber == "" || dnbpdcetnumber == null || dnbpdcetnumber == undefined) {

			$.alert({
				title: '',
				content: 'Please Enter DNB-PDCET Number',
			});
			$('#regModal').unblock();
			return false;
		}
		if (dnbpdcetnumber.length < 6) {

			$.alert({
				title: '',
				content: 'DNB-PDCET Registration Number must be of atleast 6 letters.',
			});
			$('#regModal').unblock();
			return false;
		}
	}
	/*if (aadhaarnumber == "" || aadhaarnumber == null || aadhaarnumber == undefined) {
		swal('Please Enter Aadhaar Number');
		$('#regModal').unblock();
		return false;
	}*/
	/*if (aadhaarnumber.length !== 12) {
		swal('Aadhaar Number must be of 12 digits.');
		$('#regModal').unblock();
		return false;
	}*/
	var emailcheck = ValidateEmail(document.getElementById("emailforreg").value.trim());
	if (emailcheck) {
		var jsondata = {
			"fnameforreg": fnameforreg,
			"mnameforreg": mnameforreg,
			"lnameforreg": lnameforreg,
			"emailforreg": emailforreg,
			"neetregnumber": neetregnumberorpgdcer,
			//"aadhaarnumber": aadhaarnumber,
			"servicetype": servicetype,
			"apptype": apptype,

		}
		$('#otpNo').prop('disabled', true);
		$
			.ajax(
				{
					url: '/AFMS/CheckEmailExistandSendEmail',
					type: "POST",
					data: JSON
						.stringify(jsondata),
					contentType: 'application/json',
					cors: true,
					dataType: 'json',

				})
			.done(
				function(data) {
					$('#otpNo').prop('disabled', false);
					$('#regModal').unblock();
					if (data.status == '1') {


						$.alert({
							title: '',
							content: data.message,
						});
						timer(60);
						$('#verifyandregister').prop('disabled', false);
					} else {

						$.alert({
							title: '',
							content: data.message,
						});




					}
				})
			.fail(function(jqXHR, textStatus) {

				$('#regModal').unblock();

				$.alert({
					title: '',
					content: jqXHR.responseText,
				});

			});
	} else {
		$('#regModal').unblock();

		$.alert({
			title: '',
			content: 'Please Enter Valid Email Address',
		});
		return false
	}
}

function ValidateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
		return (true)
	}

	$.alert({
		title: '',
		content: 'You have entered an invalid email address!',
	});
	return (false)
}
function ValidateOTP(otp) {
	if (otp.length == 6) {
		return true;
	} else {
		return false;
	}
}


function VerifyOTPandRegister() {

	var apptype = $("input[name='apptype']:checked").val();
	var neetregnumber = "";
	var dnbpdcetnumber = "";
	var neetregnumberorpgdcer = "";
	if (apptype == "NEET-PG") {
		neetregnumberorpgdcer = document.getElementById("neetregno").value.trim();
		neetregnumber = document.getElementById("neetregno").value.trim();
	} else {
		neetregnumberorpgdcer = document.getElementById("dnbpdcetno").value.trim();
		dnbpdcetnumber = document.getElementById("dnbpdcetno").value.trim();
	}
	var fnameforreg = document.getElementById("fnameforreg").value.trim();
	var mnameforreg = document.getElementById("mnameforreg").value.trim();
	var lnameforreg = document.getElementById("lnameforreg").value.trim();
	var emailforreg = document.getElementById("emailforreg").value.trim();
	//var neetregnumber = document.getElementById("neetregno").value;
	//	var aadhaarnumber = document.getElementById("aadhaarnumber").value;
	var servicetype = $('#servicetype').val();
	if (fnameforreg == "" || fnameforreg == null || fnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter First Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (fnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'First Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (mnameforreg == "" || mnameforreg == null || mnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Middle Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (mnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'Middle Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (lnameforreg == "" || lnameforreg == null || lnameforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Last Name',
		});
		$('#regModal').unblock();
		return false;
	}
	if (lnameforreg.length < 3) {

		$.alert({
			title: '',
			content: 'Last Name must be of atleast 3 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (emailforreg == "" || emailforreg == null || emailforreg == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Email',
		});
		$('#regModal').unblock();
		return false;
	}
	if (document.getElementById("emailforreg").value.length < 6) {

		$.alert({
			title: '',
			content: 'Email must be of atleast 6 letters.',
		});
		$('#regModal').unblock();
		return false;
	}
	if (apptype == "NEET-PG") {
		if (neetregnumber == "" || neetregnumber == null || neetregnumber == undefined) {

			$.alert({
				title: '',
				content: 'Please Enter NEET Registration Number',
			});
			$('#regModal').unblock();
			return false;
		}
		if (neetregnumber.length < 6) {

			$.alert({
				title: '',
				content: 'NEET Registration Number must be of atleast 6 letters.',
			});
			$('#regModal').unblock();
			return false;
		}
	} else {
		if (dnbpdcetnumber == "" || dnbpdcetnumber == null || dnbpdcetnumber == undefined) {

			$.alert({
				title: '',
				content: 'Please Enter DNB-PDCET Number',
			});
			$('#regModal').unblock();
			return false;
		}
		if (dnbpdcetnumber.length < 6) {

			$.alert({
				title: '',
				content: 'DNB-PDCET Registration Number must be of atleast 6 letters.',
			});
			$('#regModal').unblock();
			return false;
		}
	}
	/*if (aadhaarnumber == "" || aadhaarnumber == null || aadhaarnumber == undefined) {
		swal('Please Enter Aadhaar Number');
		$('#regModal').unblock();
		return false;
	}
	if (aadhaarnumber.length !== 12) {
		swal('Aadhaar Number must be of 12 digits.');
		$('#regModal').unblock();
		return false;
	}*/

	var otpcheck = ValidateOTP(document.getElementById("otp").value.trim());
	var emailcheck = ValidateEmail(document.getElementById("emailforreg").value.trim());

	if (otpcheck && emailcheck) {
		$('#regModal').block({ message: 'Please wait....' });
		var jsondataforreg = {
			"fnameforreg": fnameforreg,
			"mnameforreg": mnameforreg,
			"lnameforreg": lnameforreg,
			"emailforreg": emailforreg,
			"neetregnumber": neetregnumberorpgdcer,
			//"aadhaarnumber": aadhaarnumber,
			"servicetype": servicetype,
			"otpvalue": document.getElementById("otp").value,
			"apptype": apptype
		}
		$
			.ajax(
				{
					url: '/AFMS/VerifyEmailandRegister',
					type: "POST",
					data: JSON
						.stringify(jsondataforreg),
					contentType: 'application/json',
					cors: true,
					dataType: 'json',

				})
			.done(
				function(data) {
					$('#regModal').unblock();
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
				$('#regModal').unblock();

				$.alert({
					title: '',
					content: jqXHR.responseText,
				});
			});
	} else {

		if (!otpcheck) {

			$.alert({
				title: '',
				content: 'OTP must be of 6 digits',
			});
		} else {

			$.alert({
				title: '',
				content: 'You have entered an invalid email address!',
			});
		}
	}
}


function sendOTPForForgotPassword() {

	$('#forgotModal').block({ message: 'Please wait....' });

	var username = document.getElementById("usernameforforgot").value.trim();

	var emailforforgot = document.getElementById("emailforforgot").value.trim();


	if (username == "" || username == null || username == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter User Name',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (username.length < 3) {

		$.alert({
			title: '',
			content: 'User Name must be of atleast 3 letters.',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (emailforforgot == "" || emailforforgot == null || emailforforgot == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Email',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (emailforforgot.length < 6) {

		$.alert({
			title: '',
			content: 'Email must be of atleast 6 letters.',
		});
		$('#forgotModal').unblock();
		return false;
	}

	var emailcheck = ValidateEmail(emailforforgot);
	if (emailcheck) {
		var jsondata = {
			"username": username,
			"emailforforgot": emailforforgot


		}
		$('#otpNoforforgot').prop('disabled', true);
		$
			.ajax(
				{
					url: '/AFMS/CheckEmailForForgot',
					type: "POST",
					data: JSON
						.stringify(jsondata),
					contentType: 'application/json',
					cors: true,
					dataType: 'json',

				})
			.done(
				function(data) {
					$('#otpNoforforgot').prop('disabled', false);
					$('#forgotModal').unblock();
					if (data.status == '1') {


						$.alert({
							title: '',
							content: data.message,
						});
						timerForgot(60);
						$('#verify').prop('disabled', false);
					} else {

						$.alert({
							title: '',
							content: data.message,
						});
					}
				})
			.fail(function(jqXHR, textStatus) {

				$('#forgotModal').unblock();

				$.alert({
					title: '',
					content: jqXHR.responseText,
				});

			});
	} else {
		$('#forgotModal').unblock();

		$.alert({
			title: '',
			content: 'Please Enter Valid Email Address',
		});
		return false
	}
}

function VerifyOTP() {

	var username = document.getElementById("usernameforforgot").value.trim();

	var emailforforgot = document.getElementById("emailforforgot").value.trim();
	if (username == "" || username == null || username == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter User Name',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (username.length < 3) {

		$.alert({
			title: '',
			content: 'User Name must be of atleast 3 letters.',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (emailforforgot == "" || emailforforgot == null || emailforforgot == undefined) {

		$.alert({
			title: '',
			content: 'Please Enter Email',
		});
		$('#forgotModal').unblock();
		return false;
	}
	if (emailforforgot.length < 6) {

		$.alert({
			title: '',
			content: 'Email must be of atleast 6 letters.',
		});
		$('#forgotModal').unblock();
		return false;
	}

	var emailcheck = ValidateEmail(emailforforgot);
	var otpcheck = ValidateOTP(document.getElementById("otpforforgot").value.trim());


	if (otpcheck && emailcheck) {
		$('#forgotModal').block({ message: 'Please wait....' });
		var jsondataforreg = {
			"username": username,
			"emailforforgot": emailforforgot,
			"otpvalue": document.getElementById("otpforforgot").value,

		}
		$
			.ajax(
				{
					url: '/AFMS/VerifyEmailandChangePassword',
					type: "POST",
					data: JSON
						.stringify(jsondataforreg),
					contentType: 'application/json',
					cors: true,
					dataType: 'json',

				})
			.done(
				function(data) {
					$('#forgotModal').unblock();
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
				$('#forgotModal').unblock();

				$.alert({
					title: '',
					content: jqXHR.responseText,
				});
			});
	} else {

		if (!otpcheck) {

			$.alert({
				title: '',
				content: 'OTP must be of 6 digits',
			});
		} else {

			$.alert({
				title: '',
				content: 'You have entered an invalid email address!',
			});
		}
	}
}

var timerOnforgot = true;
function timerForgot(remaining) {
	var m = Math.floor(remaining / 60);
	var s = remaining % 60;

	m = m < 10 ? '0' + m : m;
	s = s < 10 ? '0' + s : s;
	document.getElementById('timerforgot').innerHTML = '<span class="timer"><b>OTP Expires in '
		+ m + ':' + s + '</b></span>';
	remaining -= 1;

	if (remaining >= 0 && timerOn) {
		setTimeout(function() {
			timer(remaining);
		}, 1000);
		$("#otpNoforforgot").html('Resend OTP');
		$("#otpNoforforgot").attr('disabled', true);
		return;
	} else {
		$("#otpNoforforgot").attr('disabled', false);
		return;
	}
	if (!timerOnforgot) {
		return;
	}
	/* 	$("input#otpNo").val("Resend OTP");*/
	$("input#otpNoforforgot").attr('disabled', false);

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

var csrfparname = "${_csrf.parameterName}";
var csrfvalue = "${_csrf.token}";
jQuery('#csrfIdSet').attr('name', csrfparname);
jQuery('#csrfIdSet').attr('value', csrfvalue);
$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});

var yuji = "/auth/login_check";
//var yuji = "<c:url value='/auth/login_check?targetUrl=${targetUrl}' />";
var numb = [1, 2, 3, 4, 5];
var imageSlides = new Array();
var circles = new Array();

jQuery(document)
	.ready(
		function() {

			/* $('body').bind('cut copy paste', function(e) {
				e.preventDefault();
			}); */
			$(".dropdown").hover(
				function() {
					var dropdownMenu = $(this).children(
						".dropdown-menu");
					if (dropdownMenu.is(":visible")) {
						dropdownMenu.parent().toggleClass();
					}
				});

			/*var msg = "";
			msg = jQuery('label#msg').text();
			if ('${error}' != "") {
				jQuery("div#errorDiv").show();
			}
			if ('${msg}' != "") {
				window.alert = function(al, $) {
					return function(msg) {
						al.call(window, msg);
						$(window).trigger("okbuttonclicked");
					};
				}(window.alert, window.jQuery);

				$(window).on(
						"okbuttonclicked",
						function() {
							console.log("you clicked ok");
							window.location = window.location.href
									.split("?")[0];
						});
				alert('${msg}');
				jQuery("div#errorDiv").show();
			}*/

			// Start Canvas Capcha
			function captcha() {
				$("#capcha").attr("src", "genCapchaCode");
			}
			;
			function clear() {
				$("#txtInput").val("");
			}
			;
			$("#btnrefresh").click(function() {
				clear();
				captcha();
			})
			// End Canvas Capcha

			jQuery(document)
				.on(
					'keypress',
					function(event) {
						var regex = new RegExp(
							"^[a-zA-Z0-9\\[\\] \\+ \\* \\-.,/ ~!@#$^&%_]+$");
						var key = String
							.fromCharCode(!event.charCode ? event.which
								: event.charCode);
						if (!regex.test(key)) {
							event.preventDefault();
							return false;
						}
					});
		});

function validation() {
	var ck_username = /^[A-Za-z0-9_]{1,20}$/;
	var ck_password = /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;
	var a = document.getElementById("username");
	$('#errormessagediv').text('');
	$('#custom-alert-message').hide();
	if (a.value == "" || a.value == "'" || a.value == null
		|| a.value.toString().trim() == "" || a.value == "'''") {
		$('#errormessagediv').text('Please Enter Username');
		$('#custom-alert-message').show();
		//		$.alert({
		//			title: '',
		//			content: 'Please Enter User name',
		//			buttons: {
		//				OK: {
		//					text: 'OK',
		//					btnClass: 'btn-blue',
		//					keys: ['enter', 'shift'],
		//					action: function() {
		//						window.location.reload();
		//					}
		//				}
		//			}
		//		});
		a.focus();
		return false;
	}
	var b = document.getElementById("password");
	if (b.value == "" || b.value == "'" || b.value == null
		|| b.value.toString().trim() == "") {
		$('#errormessagediv').text('Please Enter password');
		$('#custom-alert-message').show();
		//		$.alert({
		//			title: '',
		//			content: 'Please Enter Password',
		//			buttons: {
		//				OK: {
		//					text: 'OK',
		//					btnClass: 'btn-blue',
		//					keys: ['enter', 'shift'],
		//					action: function() {
		//						window.location.reload();
		//					}
		//				}
		//			}
		//		});
		b.focus();
		return false;
	}
	var iCapcha = removeSpaces(jQuery('#txtInput').val());
	if (iCapcha == "" || iCapcha.length != 5) {

		$.alert({
			title: '',
			content: 'Please Enter Captcha!',
			buttons: {
				OK: {
					text: 'OK',
					btnClass: 'btn-blue',
					keys: ['enter', 'shift'],
					action: function() {
						//						window.location.reload();
					}
				}
			}
		});
		jQuery('#txtInput').focus();
		return false;
	}
	
	
	if (iCapcha != "") {
		var test = ValidCaptcha(iCapcha);
		if (test != "0") {
			var returnvalue = "False";
			jQuery('#csrfIdSet').attr('name', csrfparname);
			jQuery('#csrfIdSet').attr('value', csrfvalue);
			//jQuery('#myFormId').attr('action', yuji);
			$("input#username").attr("disabled", false);
			$("input#password").attr("disabled", false);
			GenerateKey();
			var username = GenerateEncryptedValue(document
				.getElementById("username").value.trim());
			document.getElementById("username").value = username;
			var password = GenerateEncryptedValue(document
				.getElementById("password").value.trim());
			document.getElementById("password").value = password;

			//$("#myFormId").submit();
			returnvalue = "True";
			return true;
		} else {
			$('#errormessagediv').text('Please Enter Valid Captcha!!');

			$('#custom-alert-message').show();
			//			alert("Captcha Validation failed!");
			jQuery('#txtInput').focus();
			return false;
			returnvalue = "False";
		}
	}
	if (returnvalue == "False") {
		return false;
	} else {
		return true;
	}
	//	return false;
}
// Validate the Entered input aganist the generated security code function   
function ValidCaptcha(iCapcha) {
	var test = "0";
	try {
		$.ajax({
			url: contextPath + "/checkCapchaCode",
			type: 'POST',
			data: {
				iCapcha: iCapcha
			},
			success: function(data) {
				if (data) {
					test = data;
				}
			},
			async: false,
		});
	} catch (err) {
		console.log(err.message);
	}
	return test;
}
// Remove the spaces from the entered and generated code
function removeSpaces(string) {
	return string.split(' ').join('');
} document.onkeydown = function(e) {
	if (e.keyCode == 123) {
		return false;
	}
	if (e.keyCode == 44) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'S'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'H'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'A'.charCodeAt(0)) {
		return false;
	}
	if (e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)) {
		return false;
	}
}

var timerOn = true;
function timer(remaining) {
	var m = Math.floor(remaining / 60);
	var s = remaining % 60;

	m = m < 10 ? '0' + m : m;
	s = s < 10 ? '0' + s : s;
	document.getElementById('timer').innerHTML = '<span class="timer"><b>OTP Expires in '
		+ m + ':' + s + '</b></span>';
	remaining -= 1;

	if (remaining >= 0 && timerOn) {
		setTimeout(function() {
			timer(remaining);
		}, 1000);
		$("#otpNo").html('Resend OTP');
		$("#otpNo").attr('disabled', true);
		return;
	} else {
		$("#otpNo").attr('disabled', false);
		return;
	}
	if (!timerOn) {
		return;
	}
	$("input#otpNo").attr('disabled', false);

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
	document.forms["loginForm"]["salt"].value = salt;
	document.forms["loginForm"]["iv"].value = iv;
	document.forms["loginForm"]["key"].value = passphrse;
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


function ValidCaptcha(iCapcha) {
	var test = "0";
	try {
		$.ajax({
			url: "checkCapchaCode",
			type: 'POST',
			data: {
				iCapcha: iCapcha
			},
			success: function(data) {
				if (data) {
					test = data;
				}
			},
			async: false,
		});
	} catch (err) {
		console.log(err.message);
	}
	return test;
}
function removeSpaces(string) {
	return string.split(' ').join('');
}
function aboutus() {
	$("#home").hide();
	$("#contact").hide();
	$("#about").show();
}
function contactus() {
	$("#home").hide();
	$("#about").hide();
	$("#contact").show();
}


function isValidUserName(userName) {
	// Use a regular expression to check if the API Name contains only alphabets, numbers, spaces, and underscores
	var regex = /^[a-zA-Z0-9_@\s]+$/;
	return regex.test(userName);
}

async function validation1() {

	var ck_username = /^[A-Za-z0-9_]{1,20}$/;
	var ck_password = /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;
	var a = document.getElementById("username");
	if (a.value == "" || a.value == "'" || a.value == null
		|| a.value.toString().trim() == "" || a.value == "'''") {

		/*$.alert({
			title: '',
			content: 'Enter username',
		});*/
		$('#errormessagediv').text('Please Enter UserName');
		$('#custom-alert-message').show();
		a.focus();
		return false;
	}
	var b = document.getElementById("password");
	if (b.value == "" || b.value == "'" || b.value == null
		|| b.value.toString().trim() == "") {

		/*$.alert({
			title: '',
			content: 'Enter password',
		});*/
		$('#errormessagediv').text('Please Enter Password');
		$('#custom-alert-message').show();
		b.focus();
		return false;
	}
	var iCapcha = removeSpaces(jQuery('#txtInput').val());

	if (iCapcha == "" || iCapcha == "'" || iCapcha == null
		|| iCapcha.toString().trim() == "") {

		/*$.alert({
			title: '',
			content: 'Enter password',
		});*/
		$('#errormessagediv').text('Please Enter Captcha');
		$('#custom-alert-message').show();
		b.focus();
		return false;
	}

//
//     if (iCapcha != "") {
//	        var test = ValidCaptcha(iCapcha);
//
//	    }
//
//   var username = "";
//		var password = "";
//
////		GenerateKey();
//		//		username = GenerateEncryptedValue(document.getElementById("username").value.trim());
//		//		password = GenerateEncryptedValue(document.getElementById("password").value.trim());
//
//		var username = await encryptData(document
//			.getElementById("username").value.trim());
//		var password = await encryptData(document
//			.getElementById("password").value.trim());
//
//
//		document.getElementById("username").value = username;
//		document.getElementById("password").value = password;
//		jQuery('#csrfIdSet').attr('name', csrfparname);
//		jQuery('#csrfIdSet').attr('value', csrfvalue);
//
//
//		$("input#username").attr("disabled", false);
//		$("input#password").attr("disabled", false);
//		return true;
		
		
		

	var test = ValidCaptcha(iCapcha);
	

	test =1;
	    
	if (test != "0") {
		var returnvalue = "False";
		var username = "";
		var password = "";

//		GenerateKey();
		//		username = GenerateEncryptedValue(document.getElementById("username").value.trim());
		//		password = GenerateEncryptedValue(document.getElementById("password").value.trim());

		var username = await encryptData(document
			.getElementById("username").value.trim());
		var password = await encryptData(document
			.getElementById("password").value.trim());


		document.getElementById("username").value = username;
		document.getElementById("password").value = password;
		jQuery('#csrfIdSet').attr('name', csrfparname);
		jQuery('#csrfIdSet').attr('value', csrfvalue);


		$("input#username").attr("disabled", false);
		$("input#password").attr("disabled", false);
		returnvalue = "True";

	} else {
		$('#errormessagediv').text('Captcha Validation Failed!!');
		$('#custom-alert-message').show();
		b.focus();
		return false;
		returnvalue = "False";
	}


	if (returnvalue == "False") {
		return false;
	} else {
		return true;
	}

}

document.addEventListener('DOMContentLoaded', function() {
	$("body").on("contextmenu", function() {
		return false;
	});

	//	document.forms['loginForm'].addEventListener('submit', function(event) {
	//		if (!validation()) event.preventDefault();
	//	});

	document.forms['loginForm'].addEventListener('submit', async function(event) {
		event.preventDefault();
		await GenerateKey();
		var kak = await validation1();
		if (kak) {
			this.submit();
		}
	});
});



//	document.getElementById('otpNo').onclick =
//		function() {
//			return sendOTPOnEmail();
//		};

//	document.getElementById('verifyandregister').onclick =
//		function() {
//			return VerifyOTPandRegister();
//		};

//	document.getElementById('otpNoforforgot').onclick =
//		function() {
//			return sendOTPForForgotPassword();
//		};

//	document.getElementById('verify').onclick =
//		function() {
//			return VerifyOTP();
//		};


window.history.forward();
function noBack() {
	window.history.forward();
}