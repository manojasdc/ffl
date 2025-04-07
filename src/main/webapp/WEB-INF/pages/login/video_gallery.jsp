<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />

<script src="admin/assets/dev_module_list/video_gallery.js"></script>

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
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script src="admin/assets/vendor/lightbox/js/custom_lightbox.js"></script>

<script src="admin/assets/vendor/lightbox/js/picturefill.min.js"></script>
<script src="admin/assets/vendor/lightbox/js/lightgallery-all.min.js"></script>
<script src="admin/assets/vendor/lightbox/js/jquery.mousewheel.min.js"></script>


<div class="gallerydiv">
	<div class="main-page-content custom-gallery-page" id="top">
		<div class="custom-main-breadcrum">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="custom-breadcrum">
							<div class="iq-members">
								<h1 class="page-title">Video Gallery</h1>
							</div>
							<div class="page-breadcrumb">
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item"><a href="landing">Home</a></li>
										<li class="breadcrumb-item active" aria-current="Gallery">Video
											Gallery</li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="gallery custom-section-gallery">
		<div class="container">


			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">

					<div class="section custom-section-bg custom-section-bg-full">
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
											name="type" class="singleselect form-control"
											id="yearSociety">
										</select>
									</div>
								</div>
								<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
									<button id="searchsocityVideo" type="button"
										class="btn btn-dark custom-btn btnsearch">
										<i class="ri-search-line"></i>Search
									</button>
								</div>

								<div class="col-lg-2 col-md-4 col-sm-12 col-12 filter-tab">
									<button id="ShowAllEventsSocietyVideo" type="button"
										class="btn btn-dark custom-btn btnsearch">Show All
										Events</button>
								</div>
							</div>

						</div>
					</div>
					<div class="row" id="eventsSociety" name="eventsSociety"></div>
				</div>



			</div>
		</div>
	</section>
</div>



