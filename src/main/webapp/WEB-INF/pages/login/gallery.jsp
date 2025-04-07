<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />

<!-- Select Start -->
<link rel="stylesheet"
	href="admin/assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet"
	href="admin/assets/vendor/dropDown/custom-select2.css">

<link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">
<script src="admin/assets/vendor/dropDown/select2.min.js"></script>
<script src="admin/assets/vendor/dropDown/custom-select2.js"></script>

<link href="admin/assets/vendor/lightbox/css/custom_lightbox.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="admin/assets/vendor/lightbox/css/lightgallery.css">
<link rel="stylesheet"
	href="admin/assets/dev_module_list/css/commonstyle.css">
<link rel="stylesheet" href="admin/assets/css/outercss/responsive.css">

<script src="admin/assets/vendor/lightbox/js/custom_lightbox.js"></script>

<script src="admin/assets/vendor/lightbox/js/picturefill.min.js"></script>
<script src="admin/assets/vendor/lightbox/js/lightgallery-all.min.js"></script>
<script src="admin/assets/vendor/lightbox/js/jquery.mousewheel.min.js"></script>

<script src="admin/assets/dev_module_list/gallery.js"></script>
<!-- <link href="admin/layout_file/css/jquery-confirm.min.css" > -->
<!-- <script src="admin/layout_file/js/jquery-confirm.min.js"></script> -->
<!-- jquery confirm alert start -->
<link rel="stylesheet"
	href="admin/assets/vendor/jquery_confirm/jquery-confirm.min.css">
<script type="text/javascript"
	src="admin/assets/vendor/jquery_confirm/jquery-confirm.min.js"></script>
<!-- Jquery confirm alert end -->

<!-- Select End -->


<div class="gallerydiv">
	<div class="main-page-content custom-gallery-page" id="top">
		<div class="custom-main-breadcrum">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="custom-breadcrum">
							<div class="iq-members">
								<h1 class="page-title">Gallery</h1>
							</div>
							<div class="page-breadcrumb">
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item"><a href="landing">Home</a></li>
										<li class="breadcrumb-item active" aria-current="Gallery">Gallery</li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="CategoryName" id="CategoryName"
		value="${CategoryName}" /> <input type="hidden" name="CatType"
		id="CatType" value="${CatType}" />

	<div class="section custom-section-bg monthSocietyDiv">
		<div class="container">
			<div class="row align-items-end d-flex justify-content-end">

				<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
					<div class="form-group">
						<label>Events<span class="mandatory">*</span></label> <select
							name="type" class="singleselect form-control"
							id="eventsSocietyDropdown"><option value='-1'>--Select
								Event--</option>

						</select>
					</div>
				</div>

				<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
					<div class="form-group">
						<label>Year<span class="mandatory">*</span></label> <select
							name="type" class="singleselect form-control" id="yearSociety">
						</select>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
					<button id="searchsocityImages" type="button"
						class="btn btn-dark custom-btn btnsearch">
						<i class="ri-search-line"></i>Search
					</button>
				</div>

				<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
					<button id="ShowAllEventsSociety" type="button"
						class="btn btn-dark custom-btn btnsearch">Show All Events</button>
				</div>
			</div>

		</div>
	</div>
	<div class="container">
		<div class="row" id="eventsSociety" name="eventsSociety"></div>
	</div>
</div>

<section class="section gallery custom-section-gallery">
	<div class="container">
		<div class="row" id="eventsSchool"></div>
	</div>
</section>
</div>
