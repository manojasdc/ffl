<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="admin/assets/js/outerjs/togglepassword.js"></script>
<script src="admin/assets/dev_module_list/FFL/AESGCM.js"></script>
<script src="admin/login_file/js/AesUtil.js"></script>

<script src="admin/login_file/js/loginfunction.js"></script>
<sec:csrfMetaTags />

<div class="main-page-content custom-signin-page" id="top">
	<div class="custom-main-breadcrum">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<!--<div class="iq-members">
							<h1 class="page-title">Sign In</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="landing">Home</a></li>
									<li class="breadcrumb-item active" aria-current="signin">Sign
										In</li>
								</ol>
							</nav>
						</div>-->
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="contact-us section custom-contact-block">
		<div class="container">
			<div class="background-header-sticky">
				<div class="row">
					<div
						class="col-lg-6 col-md-12 col-sm-12 col-12 align-self-center order-lg-1 order-2">
						<div class="section-heading">
							<!-- 							<h6>Sign In to Explore More</h6> -->
							<!-- 							<h2>Sign In to Explore More</h2> -->
							<div class="special-offer">
								<span class="offer"><em><i class="fa fa-user-plus"
										aria-hidden="true"></i></em></span>
								<h4>
									<em>New User ?</em>
								</h4>
								<h6>
									Click Here For <em>Sign Up</em>
								</h6>
								<a href="signup"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-12 col-sm-12 col-12 order-lg-2 order-1">
						<div class="contact-us-content sign-in-content">
							<h2 class="sign-in-content-label">Sign In</h2>
							<form role="form" name='loginForm'
								action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />"
								method='POST' id="myFormId" class="login-form inputHeight">
								<input type="hidden" id="error"	name="error" value='${error}'>
								<input id="username1" type="text" name="fakeusernameremembered" class="d-none">
								<input type="hidden" id="salt" name="salt" /> 
								<input type="hidden" id="iv" name="iv" />
								<input type="hidden" id="key" name="key" /> 
								<input type="hidden" id="csrfIdSet" name="" value="" /> 
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								 
								<div class="row">
									<!-- 									<div class="col-lg-12 col-md-12 col-sm-12 col-12"> -->
									<!-- 										<p class="text-white"> -->
									<%-- 											<c:if test="${not empty error}">${error}</c:if> --%>
									<!-- 										</p> -->
									<!-- 										<p class="text-white"> -->
									<%-- 											<c:if test="${not empty msg}">${msg}</c:if> --%>
									<!-- 										</p> -->
									<!-- 									</div> -->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-12">
											<div class="custom-alert-message" id="custom-alert-message">
												<p class="alert-text" id="errormessagediv"
													name="errormessagediv"></p>
												<input type="hidden" name="errorhiddeninput"
													id="errorhiddeninput"
													value='<c:if test="${not empty error}">${error}</c:if>' />
												<input type="hidden" name="messagehiddeninput"
													id="messagehiddeninput"
													value='<c:if test="${not empty msg}">${msg}</c:if>' />
											</div>
										</div>
<!-- 										<div class="col-lg-12 col-md-12 col-sm-12 col-12 d-none"> -->
<!-- 											<div class="alert alert-danger alert-dismissible" -->
<!-- 												role="alert"> -->
<!-- 												<div class="iq-alert-text"> -->
<!-- 													<b>Login Failed!</b> Captcha Validation failed! -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<fieldset>
											<label>User ID<span class="mandatory">*</span></label> <input
												id="username" type='text' name='username'
												class="form-control disablecopypaste" maxlength="30"
												size="35" autocomplete="off" placeholder="Enter User ID">
										</fieldset>
									</div>

									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<fieldset class="custom-password-feild">
											<label>Password<span class="mandatory">*</span></label> <input
												id="password" type='password' name='password'
												class="form-control disablecopypaste" maxlength="28"
												size="35"
												pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!^\\&_.~*]).{8,28}$"
												autocomplete="off" placeholder="Enter Password" /> <span
												class="icon"><i class="fa fa-eye-slash eye-icon"
												aria-hidden="true" id="togglePassword"></i></span>
										</fieldset>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-12">
										<fieldset>
											<label>Captcha<span class="mandatory">*</span></label> <input
												type='text' class="form-control disablecopypaste" size="35"
												id="txtInput" name="txtInput" placeholder="Enter Captcha" value="AAAAA"
												maxlength="5" autocomplete="off" />
										</fieldset>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-12">
										<fieldset>
											<div class="input-group custom-captcha">
												<img id="capcha" src="genCapchaCode" class="imgcaptcha"
													class="form-control disablecopypaste" /> <span
													class="input-group-btn d-flex">
													<button class="main-button btnrefresh" id="btnrefresh"
														tabindex="-1" type="button">
														<i class="ri-refresh-line"></i>
														<!-- <img src="admin/assets/images/outerimages/referesh.ico"> -->
													</button>
												</span>
											</div>
										</fieldset>
									</div>
									<input type="hidden" id="csrfIdSet" name="" value="" /> <input
										type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
										<button type="submit" id="loginbutton" class="btn btn-a"
											title="Sign in">Sign In</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
