<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%
	HttpSession sess = request.getSession(false);
	if (sess.getAttribute("userId") != null) {
		sess.invalidate();
		System.out.print("jsp session login");
		response.sendRedirect("/login");
		return;
	}
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="admin/login_file/favicon.png" >
	<title><spring:message code="myapp.title" /></title>
	<link rel="stylesheet" href="admin/login_file/style.css">
	<script src="admin/login_file/jquery-3.4.1.min.js"></script> 
	
	<!-- <script type="text/javascript">
var areYouReallySure = false;
function areYouSure() {
    if(allowPrompt){
        if (!areYouReallySure && true) {
            areYouReallySure = true;
            var confMessage = "***************************************\n\n W A I T !!! \n\nBefore leaving our site, follow CodexWorld for getting regular updates on Programming and Web Development.\n\n\nCLICK THE *CANCEL* BUTTON RIGHT NOW\n\n***************************************";
            return confMessage;
        }
    }else{
        allowPrompt = true;
    }
}

var allowPrompt = true;
window.onbeforeunload = areYouSure;
</script> -->
	
	<script type="text/javascript">
	  	var csrfparname ="${_csrf.parameterName}";
	  	var csrfvalue="${_csrf.token}";
		var yuji = "<c:url value='/auth/login_check?targetUrl=${targetUrl}' />";
		
		
		jQuery(document).ready(function() {
			var Navigation = document.getElementById("navbarSupportedContent");
			var navs = Navigation.getElementsByClassName("nav-link");
			for (var i = 0; i < navs.length; i++) {
				navs[i].addEventListener("mouseenter", function() {
			    	var current = document.getElementsByClassName("active");
			    	if (current.length > 0) {
			    		current[0].className = current[0].className.replace(" active", "");
					}
					this.className += " active";
				});
			}
			
			$('body').bind('cut copy paste', function (e) {
				e.preventDefault();
			});
			$(".dropdown").hover(function(){
				var dropdownMenu = $(this).children(".dropdown-menu");
				if(dropdownMenu.is(":visible")){
					dropdownMenu.parent().toggleClass("open");
				}
			});
			$(window).scroll(function() {
			    if ($(document).scrollTop() > 50) {
			      $(".header_bottom").addClass("head_nav");
			    } else {
			      $(".header_bottom").removeClass("head_nav");
			    }
			});
			
			var msg = "";
	   		msg = jQuery('label#msg').text();
	   		if('${error}' != ""){
				jQuery("div#errorDiv").show();
			}
			if('${msg}' != ""){
				window.alert = function(al, $){
				    return function(msg) {
				        al.call(window,msg);
				        $(window).trigger("okbuttonclicked");
				    };
				}(window.alert, window.jQuery);

				$(window).on("okbuttonclicked", function() {
				    console.log("you clicked ok");
				    window.location = window.location.href.split("?")[0];
				});
				alert('${msg}');
				jQuery("div#errorDiv").show();
			}	
			
			// Start Canvas Capcha
			function captcha() {
				$("#capcha").attr("src", "genCapchaCode");
			};
			function clear() {
				$("#txtInput").val("");
			};
			$("#btnrefresh").click(function() {
			    clear();
			    captcha();
			})
	   		// End Canvas Capcha
	   		
	   		jQuery(document).on('keypress', function(event) {
	     		var regex = new RegExp("^[a-zA-Z0-9\\[\\] \\+ \\* \\-.,/ ~!@#$^&%_]+$");
	     	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	     	    if (!regex.test(key)) {
	     	       event.preventDefault();
	     	       return false;
	     	    } 
	     	});
		});	
	    
	    function validation() {
			var ck_username = /^[A-Za-z0-9_]{1,20}$/;
			var ck_password =  /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;
			var a = document.getElementById("username");
			if (a.value == "" ||a.value == "'" || a.value == null || a.value.toString().trim() == "" ||a.value == "'''" ) {
				alert("Enter username");
				a.focus();
				return false;
			}
			var b = document.getElementById("password");
			if (b.value == "" || b.value == "'"|| b.value == null || b.value.toString().trim() == "" ) {
				alert("Enter password");
				b.focus();
				return false;
			}	
			var iCapcha = removeSpaces(jQuery('#txtInput').val());
			if(iCapcha == "" || iCapcha.length != 5){
				alert("Enter valid Captcha!");
				jQuery('#txtInput').focus();
		    	return false;
		    }
			if(iCapcha != ""){
				var test = ValidCaptcha(iCapcha);
				if(test != "0"){
					jQuery('#csrfIdSet').attr('name',csrfparname);
			    	jQuery('#csrfIdSet').attr('value',csrfvalue);
			    	jQuery('#myFormId').attr('action', yuji);
			    	return true;
				}else{
					alert("Captcha Validation failed!");
					jQuery('#txtInput').focus();
					return false;
				}
			}
			return false;
		}
		// Validate the Entered input aganist the generated security code function   
		function ValidCaptcha(iCapcha){
			var test = "0";
	    	try{
				$.ajax({
					url : "checkCapchaCode?"+csrfparname+"="+csrfvalue,
					type : 'POST',
					data : {iCapcha:iCapcha},
					success : function(data) {
						if(data){
							test = data;
			     		}
					},
					async : false,
				});
	    	}catch(err){
	    		console.log(err.message);
	    	}
			return test;
	    }
		// Remove the spaces from the entered and generated code
		function removeSpaces(string)
		{
		    return string.split(' ').join('');
		}
		function aboutus(){
			$("#login").hide();
			$("#contact_us").hide();
			
			$("#about_us").show();
			$(".carousel-item img").css("height", "300px");
		}
		
		function contactus(){
			$("#login").hide();
			$("#about_us").hide();
			
			$("#contact_us").show();
			$(".carousel-item img").css("height", "300px");
		}
	</script>
	<script>
		document.onkeydown = function(e) {
			if(e.keyCode == 123) { return false; }
			if(e.keyCode == 44) {  return false; }
			if(e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)){ return false; } 
			if(e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'S'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'H'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'A'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)){ return false; }
		}  
	</script>
	
	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>
	<style type="text/css">
	.about_us_text {
	    max-width: 295px;
	    position: absolute;
	    /* right: 15px; */
	    text-align : center;
	    background-color: rgba(255,255,255,0.8);
	    background-color: #1fc8db;
	    background-image: linear-gradient(141deg,#9fb8ad 0,#1fc8db 51%,#2cb5e8 75%);
	    border: 1px solid #ccc;
	    border-radius: 10px;
	    top: 15px;
	    opacity: .9;
	}
	</style>
</head>
<body oncontextmenu="return false">
		<header id="header" class="header">
			<div class="header_top">
	    		<div class="row">
			      	<div class="col-md-2">
			          	<img src="admin/login_file/logo2.png" class="img-fluid" style="height: 50px;">         	
					</div>
					<div class="col-md-8">
						<div class="heading_content">
							<h1><spring:message code="myapp.name" /></h1>
						</div>
					</div>
			      	<div class="col-md-2">
			        	<img src="admin/login_file/logo2.png" class="img-fluid" style="height: 50px;float: right;">
					</div>
				</div>
			</div>
	  	
		<div class="header_bottom">
			<div class="header_navigation">
					<div class="row">
						<div class="col-md-9">
							<nav class="navbar navbar-expand-lg navbar-light header_nav">
								<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarSupportedContent">
									<ul class="navbar-nav header_list">
										<li class="nav-item">
											<a class="nav-link header_home active" href="login">Home </a>
										</li>
										<li class="nav-item">
											<a href="#" class="nav-link" onclick="aboutus();">About us</a>
										</li>
										<li class="nav-item dropdown">
											<a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Menu</a>
											<div class="dropdown-menu" aria-labelledby="navbarDropdown">
												<a class="dropdown-item" href="#">Sub Menu 1</a>
											  	<a class="dropdown-item" href="#">Sub Menu 2</a>
											</div>
										</li>
										<li class="nav-item"><a href="#" class="nav-link" onclick="contactus();">Contact us</a></li>
									</ul>
								</div>
							</nav>
						</div>
						<!-- <div class="col-md-3">
							<div class="login_button">
								<a href="#" class="btn btn-primary" role="button">Login</a> 
							</div>
						</div> -->
					</div>
			</div>
		</div> <!-- end of header_bottom-->
		<div class="ticker dash-tic">
			<h3>${layout}</h3>
	 	</div>
	  	</header>  <!-- end of header-->
	  	
<div class="middle_content" id="login">
		<div>
			<img src="admin/login_file/BackgroundImage.jpg" class="img-fluid" alt="banner" style="width: 100%;height: 485px;">
		</div>
				<div class="login-content" >
					<div class="login-logo"> 
							<h2>LOGIN</h2>
							<p>Please enter your credentials to login.</p>
							<p style="color: red;"><c:if test="${not empty error}">${error}</c:if></p>
							<p style="color: red;"><c:if test="${not empty msg}">${msg}</c:if></p>				
					</div>
					<div class="login-form">
						<form role="form"  name='loginForm' action="#" method='POST' id="myFormId" class="login-form inputHeight">
							<div class="form-group">
								<input id="username" type='text' name='username' class="form-control disablecopypaste" maxlength="30" size="35" autocomplete="off" placeholder="Enter Username">					
							</div>
							<div class="form-group">
								<input id="password" type='text' name='password' class="form-control disablecopypaste" maxlength="28" size="35" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!^\\&_.~*]).{8,28}$" autocomplete="off" placeholder="Enter Password"  />
							</div>
							<div class="row">
								<div class="col-md-6 col-sm-6 enter_captcha" style="padding-left:2px;padding-right: 2px;">
									<div class="form-group">
										<input type='text' class="form-control disablecopypaste" size="35" id="txtInput" name="txtInput"  placeholder="Enter Captcha" maxlength="5" autocomplete="off"/>	
									</div>
								</div>
								<div class="col-md-6 col-sm-6" style="padding-left: 2px;padding-right: 2px;">
									<div class="form-group captcha">
										<div class="input-group">
											<img id="capcha" src="genCapchaCode" style="padding:0rem 0rem;" width="70%" class="form-control disablecopypaste"/>
											<span class="input-group-btn">
												<button class="btn btn-primary btn-sm" id="btnrefresh" tabindex="-1" type="button">
													<img src="admin/login_file/referesh.ico">
												 </button>
											</span>
										</div>
									</div>	
								</div>
							</div>
							<div class="form-group login">
								<button type="submit" class="btn btn-success" onclick="return validation();">LOGIN</button>
								<div class="tooltip">
									<a>Reset Password</a>
									<span class="tooltiptext">Please click <a target="_blank" href="/doc/Request_for_New_Password.pdf" >here</a> to download the reset password form and send it to Authorized Person.</span>
								</div>
							</div>
							<input type="hidden" id="csrfIdSet" name="" value="" />
						</form>
					</div>
				</div>
</div> <!-- end of middle_content -->
			
		<div class="middle_content" id="about_us" style="display: none;text-align: center;padding-top: 20px;">
			<div class="row">
				<div class="col-md-6">
					<h4 class="about_heading">About Us</h4>
					<p class="about_content">About Us Content</p>
				</div>
				<div class="col-md-6">
					<h4 class="about_heading">OUR AIM</h4>
					<p class="about_content">Our AIM Content</p>
				</div>
			</div>
		</div> <!-- end of middle_content -->
		
		<div class="middle_content"id="contact_us" style="display: none;text-align: center;padding-top: 20px;">
			<div class="row" style="justify-content:center;">
				<div class="col-md-4"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 1 : </p> <h5>1234</h5></div></div>
			</div>
			<div class="row">
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 2 : </p> <h5>1234</h5></div></div>
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 3 : </p> <h5>1234</h5></div></div>
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 4 : </p> <h5>1234, 1234</h5></div></div>
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 5 : </p> <h5>1234, 1234</h5></div></div>
			</div>
			<div class="row" style="justify-content:center;">
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 6 : </p> <h5> 1234, 1234</h5></div></div>
			   	<div class="col-md-3"><div class="contact_info"><img alt="Refersh" src="admin/login_file/telephone.ico"><p> Contact Us 7 : </p> <h5>1234, 1234</h5></div></div>
			</div>
			<div style="margin-top: 15px;">
				<p class="about_heading">Please Note :</p>
				<ul style="display: inline-block;list-style-type: square;color:#672a2a;font-weight: 600;font-size: 16px;">
				    <li style="margin-bottom: 8px;">Office timings are 0900h-1300h and 1400h-1730h.</li>
					<li style="text-align: left;">Offices are closed on Saturday and Sundays.</li>
				</ul>
			</div>
		</div> <!-- end of middle_content -->
		
	<div class="digital_india" style="position: fixed;bottom: 40px;">
		<img src="admin/login_file/digitalindia.png" class="img-fluid">
	</div>
	<footer class="footer">
		<p>All rights reserved with Project Owner.
		<span style="float: right;">Connected to ${server} || Last Updated 10-12-2020 Visitors ${visiter_count}</span></p>
	</footer>
</body>
</html>
