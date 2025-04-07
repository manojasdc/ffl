<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">
<script src="admin/assets/dev_module_list/sitemap.js"></script>
<div class="main-page-content custom-aim-page" id="top">
	<div class="custom-main-breadcrum">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Sitemap</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="landing">Home</a></li>
									<li class="breadcrumb-item active" aria-current="Sitemap">Sitemap</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container custom-sitemap-container">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 col-lg-6 section-md-t3">
						<div class="title-box-d">
							<h3 class="title-d">Quick Links</h3>
						</div>
						<div class="customlist">
							<ul class="custom-mainlist">
								<li><a href="landing">Home</a></li>
								<li>About Us
									<ul class="custom-sublist">
										<li><a href="reg_page">Registration</a></li>
										<li><a href="aim">Aim</a></li>
										<li><a href="objective">Objective</a></li>
										<li><a href="bog">Governing Body</a></li>
									</ul>
								</li>
								<li>AF Schools
									<ul class="custom-sublist roDropDown1" id="roDropDown1">
<!-- 										<li><a href="iaf_edu_airhq">Air HQ Region</a></li> -->
<!-- 										<li><a href="iaf_edu_wac">WAC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_swac">SWAC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_eac">EAC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_cac">CAC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_sac">SAC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_mc">MC Region</a></li> -->
<!-- 										<li><a href="iaf_edu_tc">TC Region</a></li> -->

									</ul>
								</li>
								<li>Outreach
									<ul class="custom-sublist">
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
									</ul>
								</li>
								<li>Achievement
									<ul class="custom-main-sublist">
										<li>Schools
											<ul class="custom-sublist">
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in Academics</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in Sports</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Overall Best</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Any other awards</a></li>
											</ul>
										</li>
										<li>Students
											<ul class="custom-sublist">
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in Academics</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in Sports</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in competitive Exams</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best in Co-scholastic</a></li>
											</ul>
										</li>
										<li>Staff
											<ul class="custom-sublist">
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best Teacher</a></li>
												<li class=""><a href="admin/assets/pdf/sample.pdf"
													target="_blank">Best Admin</a></li>
											</ul>


										</li>
									</ul>
								</li>

								<li>MISC
									<ul class="custom-sublist">
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">GPAIS</a></li>
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Books</a></li>
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Uniform</a></li>
										<li><a href="calendar">Calendar</a></li>

									</ul>
								</li>
								<li>Publication
									<ul class="custom-sublist">
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Annual
												Reports</a></li>
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Yearly
												Performance Review</a></li>
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Magazines</a></li>
										<li><a href="admin/assets/pdf/sample.pdf" target="_blank">Activity
												Reports</a></li>
									</ul>
								</li>
								<li>MoU
									<ul class="custom-main-sublist mouDropDown_sitemap"  id="mouDropDown_sitemap">
										
<!-- 										<li><a href="https://www.andhrauniversity.edu.in/" -->
<!-- 											target="_blank">Andhra University</a></li> -->
<!-- 										<li><a href="https://manavrachna.edu.in/" target="_blank">Manav -->
<!-- 												Rachna</a></li> -->
<!-- 										<li><a href="https://rru.ac.in/" target="_blank">RRU</a></li> -->
<!-- 										<li><a href="https://www.flame.edu.in/" target="_blank">FLAME</a></li> -->
<!-- 										<li><a href="https://www.ups.com/" target="_blank">UPES</a></li> -->
									</ul>
								</li>

								<li><a href="#">Feedback</a>
								<ul class="custom-sublist feedbackList1" id="feedbackList1">

									</ul>
								
								</li>
								<li><a href="signin">Sign In</a></li>
							</ul>
						</div>
					</div>

					<div class="col-md-6 col-lg-6 section-md-t3">
						<div class="title-box-d">
							<h3 class="title-d">Footer Links</h3>
						</div>
						<div class="customlist">
							<ul class="custom-mainlist">

								<li>Quick Links
									<ul class="custom-sublist">
										<li><a href="#">Website Policies</a></li>
										<li><a href="#">Help</a></li>
										<li><a href="#">Terms and Conditions</a></li>
									</ul>
								</li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>



</div>
