<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="admin/assets/dev_module_list/header.js"></script>
<!-- <script src="admin/assets/vendor/g_translate/g_translate.js"></script> -->
<%-- <script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit" nonce="${cspNonce}"></script> --%>

<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky ">
<div class="custom-header-area">
	<div class="container-fluid">
		<div class="custom-header">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-header-top">
						<div class="main-nav">
							<!-- ***** main nav left start ***** -->
							<div class="main-nav-left">
								<div class="main-nav-ll">									
									<div class="custom-header-logo">
										<a href="#" class="logo hl1"> <img
											src="admin/assets/images/indianarmylogo.webp"
											class="img-fluid w-100" title="Indian Army Logo"
											alt="Indian Army Logo">
										</a>
										
									</div>

									<!-- ***** logo end ***** -->
								</div>
								
							</div>
							<!-- ***** main nav left end ***** -->
							<div class="main-nav-center">
								<div class="header-text">
									<h2>Indian Army Foreign Training Portal</h2>
								</div>
							</div>


							<!-- ***** main nav right start ***** -->
							<div class="main-nav-right custom-main-nav">
								<div class="main-nav-rr">
									<div class="custom-header-logo">
										<a href="#" class="logo hl2"> <img
											src="admin/assets/images/indianflag.webp"
											class="img-fluid w-100" title="Indian Flag"
											alt="Indian Flag">
										</a>
										
									</div>
								</div>
								
							</div>
							<!-- ***** main nav left end ***** -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	<div class="custom-info-block">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="custom-info-sec">
			<div class="custom-info-left">
				<div class="custom-header-link">
					<ul class="d-flex link-list">
						<li><a href="screen_reader"> Screen Reader Access</a></li>
						<li><a href="#top"> Skip to main content </a></li>
					</ul>
				</div>
				<div class="font-size-block">
					<div class="dropdown">
						<div class="custom-header-dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								data-bs-toggle="dropdown" aria-expanded="false"
								title="Resize Font">
								<i class="ri-font-size-2"></i><span class="custom-angle-down"><i
									class="fa fa-angle-down"></i></span>
							</button>
							<ul class="dropdown-menu">
								<li><a id="btn-increase" class="dropdown-item"
									title="Increase font size">A+</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a id="btn-orig" class="dropdown-item"
									title="Reset font size">A</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a id="btn-decrease" class="dropdown-item"
									title="Decrease font size">A-</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="switch-mode custom-switch-mode">
								<ul class="switch-btn-list">
									<li class="switch-btn"><button type="button" id="light"
											class="sbtn light-btn" title="Light Mode">
											<i class="fa fa-sun"></i>
										</button></li>
									<li class="switch-btn"><button type="button" id="dark"
											class="sbtn dark-btn" title="Dark Mode">
											<i class="fa fa-moon"></i>
										</button></li>
								</ul>
							</div>
				<div id="google_translate_element" class="custom-lang" title="Change Language"></div>
               </div>
               <div class="custom-info-right">
						<div class="social-buttons">
						<a href="#"
								class="social-buttons__button social-button social-button--x"
								aria-label="X"> <span class="social-button__inner">
									<i class="fa-brands fa-x-twitter"></i>
							</span>
							</a> 
							<a href="#"
								class="social-buttons__button social-button social-button--facebook"
								aria-label="Facebook"> <span class="social-button__inner">
									<i class="fab fa-facebook-f"></i>
							</span>
							</a> <a href="#"
								class="social-buttons__button social-button social-button--linkedin"
								aria-label="LinkedIn"> <span class="social-button__inner">
									<i class="fab fa-linkedin-in"></i>
							</span>
							</a> 
							<a href="#"
								target="_blank"
								class="social-buttons__button social-button social-button--instagram"
								aria-label="InstaGram"> <span class="social-button__inner">
									<i class="fab fa-instagram"></i>
							</span>
							</a>
							<a href="#"
								target="_blank"
								class="social-buttons__button social-button social-button--yt"
								aria-label="Youtube"> <span class="social-button__inner">
									<i class="fab fa-youtube"></i>
							</span>
							</a>
							<a href="#"
								target="_blank"
								class="social-buttons__button social-button social-button--sc"
								aria-label="Soundcloud"> <span class="social-button__inner">
									<i class="fa-brands fa-soundcloud"></i>
							</span>
							</a>
						</div>
						<!-- ***** search start ***** -->
					<div class="search-input custom-search-block">
						<form id="search" action="#">
									<div class="form-group">
										<input type="text" placeholder="Type Something"
											id='searchText' name="searchKeyword" onkeypress="handle" />
										<button class="btn icon-btn search-icon" type="button">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</form>
					</div>
					<!-- ***** search start ***** -->
					<div class="main-button wn-block">
					<a href="#" class="btn it-btn wn-btn btn-sm"><span class="btn-icon"><i class="fa fa-bell"></i></span><span class="btn-text">What's New</span></a>
					</div>
				</div>
			</div>
			</div>
			</div>
			</div>
	</div>
</header>
<!-- ***** Header Area End ***** -->

