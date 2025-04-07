<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>

<script src="assets/dev_module_list/FFL/alumnidashboard.js"></script>
<!-- <script src="assets/dev_module_list/viewwhatsnewscroll.js"></script> -->
<!-- Select End -->


<div class="content-page MCTE_dashboard">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">${bradcrumbs} Dashboard</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${dashboadURL}">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">${bradcrumbs} Dashboard</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<input type="hidden" name="dashname" id="dashname"
					value="${bradcrumbs}" />
					<input type="hidden" id="role" name="role" value="${role}">
				<div class="card-block-wrapper">
					<div class="card card-block card-stretch card-height reg-card">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">${bradcrumbs} Insight</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="col-lg-6 col-md-6 col-sm-12 col-12" id="usershow">
								<div class="form-group">
									<label>Select Institute Name<span class="mandatory">*</span></label>
									<select name="type" class="searchwithselect form-control"
										id="instituteId" name="instituteId">
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-1">
										<div class="custom-dcard-icon camo-1-light">
											<i class="fa fa-book"></i>
										</div>
										

										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">E Journals</h4>
												<h5 class="custom-dcard-count" id="userjournaldashboard">${Ejournalcount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-1-light">
												<a href="E_Journals" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-2">
										<div class="custom-dcard-icon camo-2-light">
											<i class="fa fa-envelope"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">FFL News Letters</h4>
												<h5 class="custom-dcard-count" id="usernewsdashboard">${NewsLettersCount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-2-light">
												<a href="all_news" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-3">
										<div class="custom-dcard-icon camo-3-light">
											<i class="fa fa-medal"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">Hall Of Fame</h4>
												<h5 class="custom-dcard-count" id="userhalloffamedashboard">${HallofFameCount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-3-light">
												<a href="HallOfFame" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-4">
										<div class="custom-dcard-icon camo-4-light">
											<i class="fa fa-images"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">Picture Gallery</h4>
												<h5 class="custom-dcard-count" id="userpicturedashboard">${photogallaryCount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-4-light">
												<a href="Picture_gallery" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12" id ="user">
									<div class="iq-option custom-data-card camo-5">
										<div class="custom-dcard-icon camo-5-light">
											<i class="fa fa-graduation-cap"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">FFC Alumni</h4>
												<h5 class="custom-dcard-count">${AlumniCount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-5-light">
												<a href="FFC_Alumni" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-6">
										<div class="custom-dcard-icon camo-6-light">
											<i class="fa fa-tasks"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">Blog</h4>
												<h5 class="custom-dcard-count" id="useractivitydashboard">${ActivityCount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-6-light">
												<a href="MISC_activities" title="Click here"><i
													class="fa fa-share-square" aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
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
											<!-- 											<li><p>Website content owned by <a href="#">Army Training Command.</a></p></li> -->
											<!-- 											<li><p><a href="#">Let us go green to get our planet clean.</a></p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->
											<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->

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





