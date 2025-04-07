<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="assets/css/outercss/outer_style.css">
<script src="assets/dev_module_list/header.js"></script>
<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky custom-header-area">
	<div class="container-fluid">
		<div class="custom-header">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-header-top">
						<div class="main-nav">
							<!-- ***** main nav left start ***** -->
							<div class="main-nav-left">
								<div class="main-nav-ll">
									<!-- ***** logo start ***** -->
									<div class="custom-header-logo">
										<a href="landing" class="logo"> <img
											src="admin/assets/images/outerimages/logo.png"
											class="img-fluid" title="Society Logo" alt="society logo">
										</a>
									</div>
									<!-- ***** logo end ***** -->
								</div>
								<div class="main-nav-lr">
									<div class="custom-logo-input">
										<!-- 									26-6-23 -->
										<!-- ***** header top logo start ***** -->
										<div class="head-top-logo custom-head-top-logo-name">
											<span class="logo-sidetext">भारतीय वायु सेना शैक्षिक
												और सांस्कृतिक सोसायटी | Indian Air Force Educational and
												Cultural Society</span>
										</div>
										<div class="head-top-logo custom-head-top-logo">
											<a href="https://india.gov.in" title="Government of India"
												target="blank" class="logo-subtext"> <img
												alt="Government of India"
												src="admin/assets/images/outerimages/government_of_india.png">
												<span class="logo-sidetext">भारत सरकार | Government
													of India</span>
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
							</div>
							<!-- ***** main nav left end ***** -->



							<!-- ***** main nav right start ***** -->
							<div class="main-nav-right">
								<div class="main-nav-rr">
									<div class="custom-header-link">
										<ul class="d-flex link-list">
											<li><a href="screen_reader_access"> Screen Reader
													Access </a></li>
											<li><a href="#top"> Skip to main content </a></li>
										</ul>
									</div>
									<div class="dropdown">
										<div class="custom-header-dropdown">
											<button class="btn btn-secondary dropdown-toggle"
												type="button" data-bs-toggle="dropdown"
												aria-expanded="false" title="Resize Font">
												<i class="ri-font-size-2"></i><span
													class="custom-angle-down"><i
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
								<div class="main-nav-rl">
									<div class="custom-header-btn">
										<div class="main-button">
											<a href="signin">Sign In</a>
										</div>
									</div>

									<!-- Menu Toggle btn-->
									<div class="menu-toggle">
										<button type="button" id="menu-btn">
											<span class="icon-bar"></span> <span class="icon-bar"></span>
											<span class="icon-bar"></span>
										</button>
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

								<li><a href="CATA"> <span class="title">Cat
											'A' Est</span> <span class="menu-icon-right"><i
											class="fa fa-angle-down"></i></span>
								</a>
									<!-- <ul class="roDropDown" id="roDropDown">
									<li><a href="https://ndacivrect.gov.in/">MCTE</a></li>
									<li><a href="https://www.university.youth4work.com/mcte_military-college-of-telecommunication-engineering">
									NDA</a></li>
									<li><a href="">INF</a></li>
									<li><a href="https://www.ima-usa.com/">IMA</a></li>
																				<li><a href="iaf_edu_airhq">Air HQ Region</a></li>
																				<li><a href="iaf_edu_wac">WAC Region</a></li>
																				<li><a href="iaf_edu_swac">SWAC Region</a></li>
																				<li><a href="iaf_edu_eac">EAC Region</a></li>
																				<li><a href="iaf_edu_cac">CAC Region</a></li>
																				<li><a href="iaf_edu_sac">SAC Region</a></li>
																				<li><a href="iaf_edu_mc">MC Region</a></li>
																				<li><a href="iaf_edu_tc">TC Region</a></li>
									</ul> --></li>
								<li><a href="javascript:;"> <span class="title">Outreach</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<!-- 									26-6-23 -->
										<li class="d-none"><a href="gallery">Photo Gallery</a></li>
										<li><a href="video_gallery">Videos</a></li>
										<li><a href="https://www.cbse.gov.in/" target="_blank">CBSE</a></li>
										<li><a href="https://ncert.nic.in/" target="_blank">NCERT</a></li>
										<li><a href="https://kvsangathan.nic.in/" target="_blank">KVS</a></li>
										<li><a href="https://www.cdac.in/" target="_blank">C-DAC
										</a></li>
										<li><a href="https://www.nda.nic.in/" target="_blank">NDA</a></li>
										<li><a href="https://aim.gov.in/atl.php" target="_blank">ATL</a></li>
										<li><a href="https://agnipathvayu.cdac.in/AV/"
											target="_blank">CASB</a></li>
									</ul></li>
								<!-- 									26-6-23 -->
								<li><a href="javascript:;"> <span class="title">Achievement</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li class=""><a href="#">Schools</a>
											<ul class="sub-menu">
												<li class=""><a href="#" id="bestInAcaSchool"
													name="bestInAcaSchool">Best in Academics</a></li>
												<!-- 									26-6-23 -->
												<li class=""><a href="#" id="bestInSportsSchool"
													name="bestInSportsSchool">Best in Sports</a></li>
												<li class=""><a href="#" id="overAllBestSchool"
													name="overAllBestSchool">Overall Best</a></li>
												<li class=""><a href="#" id="otherAward"
													name="otherAward">Any other awards</a></li>
											</ul></li>
										<li class=""><a href="#">Students</a>
											<ul class="sub-menu">
												<li class=""><a href="#" id="bestInAcaStudent"
													name="bestInAcaStudent">Best in Academics</a></li>
												<li class=""><a href="#" id="bestInSportsStud"
													name="bestInSportsStud">Best in Sports</a></li>
												<li class=""><a href="#" id="bestInCompetitiveExams"
													name="bestInCompetitiveExams">Best in competitive Exams</a></li>
												<li class=""><a href="#" id="bestInCoScholastic"
													name="bestInCoScholastic">Best in Co-scholastic</a></li>
											</ul></li>
										<li class=""><a href="#">Staff</a>
											<ul class="sub-menu">
												<!-- 									26-6-23 -->
												<li class=""><a href="#" id="bestTeacher"
													name="bestTeacher">Best Teacher</a></li>
												<li class=""><a href="#" id="bestAdmin"
													name="bestAdmin">Best Admin</a></li>

											</ul></li>
									</ul></li>

								<li><a href="javascript:;"> <span class="title">MISC</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<!-- 									26-6-23 -->
										<li><a href="#" id="gpais_id" name="gpais_id">GPAIS</a></li>
										<li><a href="#" id="books_id" name="books_id">Books</a></li>
										<li><a href="#" id="uniform_id" name="uniform_id">Uniform</a></li>
										<li><a href="#" id="calendar_id" name="calendar_id">Calendar</a></li>
										<!-- 									</ul></li> -->
									</ul></li>

								<li><a href="javascript:;"> <span class="title">Publication</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span>
								</a>
									<ul>
										<li><a href="#" id="annualReports" name="annualReports">Annual
												Reports</a></li>
										<li><a href="#" id="yearlyPerformanceReview"
											name="yearlyPerformanceReview">Yearly Performance Review</a></li>
										<li><a href="#" id="magazinesId" name="magazinesId">Magazines</a></li>
										<li><a href="#" id="activityReports"
											name="activityReports">Activity Reports</a></li>
									</ul></li>


								<!-- 									26-6-23 -->
								<!-- 								<li class="last"><a href="javascript:;"> <span -->
								<!-- 										class="title">Upcoming Events</span><span -->
								<!-- 										class="menu-icon-right"><i class="fa fa-angle-down"></i></span> -->
								<!-- 								</a> -->
								<!-- 									<ul> -->
								<!-- 										<li><a href="#">Events</a></li> -->
								<!-- 									</ul></li> -->

								<!-- 							<li><a href="javascript:;"> <span class="title">MOUs</span><span -->
								<!-- 									class="menu-icon-right"><i class="fa fa-angle-down"></i></span> -->
								<!-- 							</a> -->
								<!-- 								<ul class="sub-menu" class="mouDropDown" id="mouDropDown"> -->
								<!-- 									<ul class="sub-menu"></ul> -->
								<!-- 								</ul></li> -->


								<li><a href="javascript:;"> <span class="title">MOUs</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span></a>
									<ul class="mouDropDown" id="mouDropDown">
										<!-- 										<li><a href="reg_page">Registration</a></li> -->
										<!-- 										<li><a href="aim">Aim</a></li> -->
										<!-- 										<li><a href="objective">Objective</a></li> -->
										<!-- 										<li><a href="bog">Governing Body</a></li> -->
									</ul></li>

								<li><a href="javascript:;"> <span class="title">Feedback</span><span
										class="menu-icon-right"><i class="fa fa-angle-down"></i></span></a>
									<ul id="feedbackList">

									</ul></li>

							</ul>
						</nav>
					</div>
					<!-- ***** Menu End ***** -->
				</div>
			</div>
		</div>
	</div>
</header>
<!-- ***** Header Area End ***** -->