<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">

<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky custom-header-area">
	<div class="container">
		<div class="custom-header">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-header-top">
						<div class="main-nav">
							<!-- ***** main nav left start ***** -->
							<div class="main-nav-left">
								<!-- ***** logo start ***** -->
								<div class="custom-header-logo">
									<a href="landing" class="logo"> <img
										src="admin/assets/images/outerimages/Society Logo.png"
										class="img-fluid" title="IAF Logo" alt="iaf logo">
									</a>
								</div>
								<!-- ***** logo end ***** -->
								<div class="custom-logo-input">
									<!-- ***** header top logo start ***** -->
									<div class="head-top-logo">
										<a href="https://india.gov.in" title="Government of India"
											target="blank" class="logo-subtext"> <img
											alt="Government of India"
											src="admin/assets/images/outerimages/government_of_india.png">
											<span class="logo-sidetext">भारत सरकार | Government of
												India</span>
										</a>
									</div>
									<!-- ***** header top logo end ***** -->
									<!-- ***** search start ***** -->
									<div class="search-input">
										<form id="search" action="#">
											<input type="text" placeholder="Type Something"
												id='searchText' name="searchKeyword" onkeypress="handle" />
											<i class="fa fa-search"></i>
										</form>
									</div>
									<!-- ***** search start ***** -->
								</div>
							</div>
							<!-- ***** main nav left end ***** -->
							<!-- ***** main nav right start ***** -->
							<div class="main-nav-right">
								<div class="custom-header-link">
									<ul class="d-flex link-list">
										<li><a href="#"> Screen Reader Access </a></li>
										<li><a href="#top"> Skip to main content </a></li>
									</ul>
								</div>
								<div class="dropdown">
									<div class="custom-header-dropdown">
										<button class="btn btn-secondary dropdown-toggle"
											type="button" data-bs-toggle="dropdown" aria-expanded="false"
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
								<div class="custom-header-btn">
									<div class="main-button">
										<a href="signin">Sign In</a>
									</div>
								</div>
							</div>
							<!-- ***** main nav left end ***** -->
						</div>
					</div>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-header-menu">
						<!-- ***** Menu Start ***** -->
						<nav>
							<!-- Menu Toggle btn-->
							<div class="menu-toggle">
								<button type="button" id="menu-btn">
									<span class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</div>
							<!-- Responsive Menu Structure-->
							<ul id="respMenu" class="ace-responsive-menu"
								data-menu-style="horizontal">
								<li><a href="landing"> <span class="title">Home</span>
								</a></li>
								<li><a href="javascript:;"> <span class="title">About
											Us</span><span class="menu-icon-right"><i
											class="fa fa-angle-down"></i></span></a>
									<ul>
										<li><a href="reg_page">Registration</a></li>
										<li><a href="aim">Aim</a></li>
										<li><a href="objective">Objective</a></li>
										<li><a href="bog">Governing Body</a></li>
									</ul></li>
								<li><a href="javascript:;"> <span class="title">AF
											Schools</span><span class="menu-icon-right"><i
											class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="iaf_edu_airhq">Air HQ Region</a></li>
										<li><a href="iaf_edu_wac">WAC Region</a></li>
										<li><a href="iaf_edu_swac">SWAC Region</a></li>
										<li><a href="iaf_edu_eac">EAC Region</a></li>
										<li><a href="iaf_edu_cac">CAC Region</a></li>
										<li><a href="iaf_edu_sac">SAC Region</a></li>
										<li><a href="iaf_edu_mc">MC Region</a></li>
										<li><a href="iaf_edu_tc">TC Region</a></li>
									</ul></li>
								<li><a href="javascript:;"> <span class="title">Outreach</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="#">Presentations</a></li>
										<li><a href="video_gallery">Videos</a></li>
										<li><a href="gallery">Photo Gallery</a></li>
										<li><a href="#">YouTube Channel</a></li>
										<li><a href="#">Social Media</a></li>
										<li><a href="#">Newsletters</a></li>
										<li><a href="#">Online Contests</a></li>
									</ul></li>

								<li><a href="javascript:;"> <span class="title">Achievement</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul class="sub-menu" style="display: none;">
									<li class=""><a href="#"> Schools-Best in Academics</a>
											<ul class="sub-menu">
												<li class=""><a href="#">Overall Best</a></li>
												<li class=""><a href="#">Any other awards</a></li>
											</ul></li>
										<li class=""><a href="#">Students-Best in Academics</a>
											<ul class="sub-menu">
												<li class=""><a href="#">Best in Sports</a></li>
												<li class=""><a href="#">Best in competitive Exams</a></li>
												<li class=""><a href="#">Best in Co-scholastic</a></li>
											</ul></li>
										<li class=""><a href="#">Staff</a>
											<ul class="sub-menu">
												<li class=""><a href="#">Best Teacher</a>
													<ul class="sub-menu">
														<li class=""><a href="#">PGT</a></li>
														<li class=""><a href="#">TGT</a></li>
														<li class=""><a href="#">PRT</a></li>
														<li class=""><a href="#">NTT</a></li>
														<li class=""><a href="#">HWT</a></li>
														<li class=""><a href="#">Co-Scholastic</a></li>
													</ul></li>
												</li>
												<li class=""><a href="#">Best Admin</a>
													<ul class="sub-menu">
														<li class=""><a href="#">OS</a></li>
														<li class=""><a href="#">Accounts Clerk </a></li>
														<li class=""><a href="#">Clerk MTS</a></li>
														<li class=""><a href="#">Helpers</a></li>
													</ul>
												</li>

											</ul></li>
									</ul></li>
									
								<li><a href="javascript:;"> <span class="title">MISC</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="#">GPIAS</a></li>
										<li><a href="#">Books</a></li>
										<li><a href="#">Uniform</a></li>
										<li><a href="#">Calendar</a></li>
									</ul></li>
								<!-- 								<li><a href="javascript:;"> <span class="title">EVC's -->
								<!-- 											Forum</span><span class="menu-icon-right"><i -->
								<!-- 											class="fa fa-angle-down"></i></span> -->
								<!-- 								</a> -->
								<!-- 									<ul> -->
								<!-- 										<li><a href="#">Know Your EVC</a></li> -->
								<!-- 										<li><a href="#">Important Messages</a></li> -->
								<!-- 										<li><a href="#">Write to EVC</a></li> -->
								<!-- 									</ul></li> -->
								<li><a href="javascript:;"> <span class="title">Publication</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="#">Notifications</a></li>
										<li><a href="#">Annual Reports</a></li>
										<li><a href="#">Yearly Performance Review</a></li>
										<li><a href="#">Magazines</a></li>
										<li><a href="#">Activity Reports</a></li>
										<li><a href="#">Notification</a></li>
									</ul></li>
								<li class="last"><a href="javascript:;"> <span
										class="title">Upcoming Events</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="#">Events</a></li>
									</ul></li>

							</ul>
						</nav>
					</div>
					<!-- ***** Menu End ***** -->
				</div>
			</div>
		</div>
	</div>
	</div>
</header>
<!-- ***** Header Area End ***** -->