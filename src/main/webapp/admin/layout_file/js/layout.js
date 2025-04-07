var $ = jQuery;
jQuery(function($) {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});

var roleAccess = '${roleAccess}';
var role = '${role}';
var user_agent = '${user_agent}';
var army_no = '${army_no}';
var otpKey = '${otpKey}';
var $ = jQuery;
var tbl, div;
function resetTimer() {
	if (jQuery('#div_timeout').length) { jQuery('#div_timeout').html(timeout()); }
}
function timeout() { return '1800'; }
function getsubmodule(id) { localStorage.setItem("subModule", id); }
function getmodule(id) { localStorage.setItem("Module", id); }
function getpagelink(id) { localStorage.setItem("pagelink", id); }

var key = "${_csrf.parameterName}";
var value = "${_csrf.token}";



jQuery(document).ready(function() {
	/* jQuery('body').bind('cut copy paste', function (e) {
	  e.preventDefault();
  }); */



	// set current sub module
	jQuery('ul#Dropdown_' + localStorage.getItem("Module")).parent().attr("class", "nav-item dropdown dropdown-item show");
	jQuery('ul#Dropdown_' + localStorage.getItem("subModule")).parent().attr("class", "dropdown-item dropdown create_search  show");
	jQuery('ul#Dropdown_' + localStorage.getItem("subModule")).attr("class", "dropdown-menu scrollbar show");
	jQuery('ul#Dropdown_' + localStorage.getItem("Module")).attr("class", "dropdown-menu show");
	jQuery('li#Dropdown_scr' + localStorage.getItem("pagelink")).attr("class", "dropdown-item active");

	setInterval(function() {
		var today = new Date();
		var date = ("0" + today.getDate()).slice(-2) + '-' + ("0" + (today.getMonth() + 1)).slice(-2) + '-' + today.getFullYear();
		var time = ("0" + today.getHours()).slice(-2) + ":" + ("0" + today.getMinutes()).slice(-2);// + ":" + ("0" + today.getSeconds()).slice(-2);
		var dateTime = date + ' ' + time;
		jQuery("#datetime").text(dateTime);

		if (jQuery('#div_timeout').length) {
			var tt = jQuery('#div_timeout').html();
			if (tt === undefined) {
				tt = timeout();
			}
			var ct = parseInt(tt, 10) - 1;
			jQuery('#div_timeout').html(ct.toString().padStart(3, '0'));
			if (ct === 0) {
				formSubmit();
			}
		} else {
			formSubmit();
		}
	}, 1000);
	try {
		var msg = document.getElementById("msg").value;
		if (msg != null) {
			alert(msg);
		}
	}
	catch (e) {
	}
});
function formSubmit() {
	document.getElementById("logoutForm").submit();
}
popupWindow = null;
function parent_disable() {
	if (popupWindow && !popupWindow.closed)
		popupWindow.focus();
}

document.onkeydown = function(e) {
	if (e.keyCode == 123) { return false; }
	if (e.keyCode == 44) { return false; }
	if (e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.keyCode == 'S'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.keyCode == 'H'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.keyCode == 'A'.charCodeAt(0)) { return false; }
	if (e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)) { return false; }
}

var username = "${username}";
var curDate = "${curDate}";




document.addEventListener('DOMContentLoaded', function() {

	/*document.getElementById('wrapper').onfocus =
		function() {
			return parent_disable();
		};

	document.getElementById('wrapper').onclick =
		function() {
			return parent_disable();
		};*/

	document.getElementById('logout').onclick =
		function() {
			localStorage.clear();
			return formSubmit();

		};

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

window.history.forward();
function noBack() {
	window.history.forward();
}
