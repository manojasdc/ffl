<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>

<!-- Select End -->

<!-- light-box -->
<link href="assets/vendor/lightbox/css/custom_lightbox.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="assets/vendor/lightbox/css/lightgallery.css">
<script src="assets/vendor/lightbox/js/custom_lightbox.js"></script>
<script src="assets/vendor/lightbox/js/transition.js"></script>
<script src="assets/vendor/lightbox/js/collapse.js"></script>
<script src="assets/vendor/lightbox/js/lightgallery.js"></script>
<script src="assets/vendor/lightbox/js/lg-fullscreen.js"></script>
<script src="assets/vendor/lightbox/js/lg-thumbnail.js"></script>
<script src="assets/vendor/lightbox/js/lg-video.js"></script>
<script src="assets/vendor/lightbox/js/lg-autoplay.js"></script>
<script src="assets/vendor/lightbox/js/lg-zoom.js"></script>
<script src="assets/vendor/lightbox/js/jquery.mousewheel.min.js"></script>
<script src="assets/dev_module_list/viewphotogallary.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>

<!-- light-box -->


<div class="content-page Picture_gallery">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Picture Gallery</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">Picture
									Gallery</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="card-block-wrapper">
					<div class="card card-block card-stretch card-height reg-card">
						<div class="card-body">
							<input type="hidden" name="totalpage" id="totalpage"
								value="${totalpages}" /> <input type="hidden" name="dashname"
								id="dashname" value="${dashname}" />
							<div class="demo-gallery custom-light-gallery" id="allNData">
							</div>
							<ul id="pagination" class="pagination-wrapper">
							</ul>

						</div>
					</div>
					<div class="card card-block card-stretch card-height news-card">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">
									What's New Scroll<span class="blink-image"><img
										class="img-fluid" src="assets/images/new_blink.gif"></span>
								</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<marquee id="marq_id" behavior="scroll" loop="true"
										direction="up" scrolldelay="50" class="marquee-content">
										<ul class="news-wrapper" id="allwhatsnew">


										</ul>
									</marquee>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




