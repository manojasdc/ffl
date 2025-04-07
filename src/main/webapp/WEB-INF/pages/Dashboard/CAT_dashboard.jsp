<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<!-- Select End -->


<div class="content-page demo-dashboard">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">${username} Dashboard</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">${username}
									Dashboard</li>
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
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">${username} Insight</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-1">
										<div class="custom-dcard-icon camo-1-light">
											<i class="fa fa-book"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">E - Journals</h4>
												<h5 class="custom-dcard-count">5</h5>
											</div>
											<div class="cutom-redirect-btn camo-1-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-2">
										<div class="custom-dcard-icon camo-2-light">
											<i class="fa fa-envelope"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">FFL - New Letters</h4>
												<h5 class="custom-dcard-count">4</h5>
											</div>
											<div class="cutom-redirect-btn camo-2-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-3">
										<div class="custom-dcard-icon camo-3-light">
											<i class="fa fa-medal"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">Hall Of Fame</h4>
												<h5 class="custom-dcard-count">6</h5>
											</div>
											<div class="cutom-redirect-btn camo-3-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-4">
										<div class="custom-dcard-icon camo-4-light">
											<i class="fa fa-images"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">Picture Gallery</h4>
												<h5 class="custom-dcard-count">22</h5>
											</div>
											<div class="cutom-redirect-btn camo-4-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-5">
										<div class="custom-dcard-icon camo-5-light">
											<i class="fa fa-graduation-cap"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">FFC Alumni</h4>
												<h5 class="custom-dcard-count">155</h5>
											</div>
											<div class="cutom-redirect-btn camo-5-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-6">
										<div class="custom-dcard-icon camo-6-light">
											<i class="fa fa-tasks"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">MISC Activities</h4>
												<h5 class="custom-dcard-count">2</h5>
											</div>
											<div class="cutom-redirect-btn camo-6-light">
												<a href="#"><i class="fa fa-share-square"
													aria-hidden="true"></i></a>
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
								<h4 class="card-title">What's New Scroll</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<marquee id="marq_id" behavior="scroll" loop="true"
										direction="up" scrolldelay="50"
										class="marquee-content">
										<ul class="news-wrapper">
											<li><p>Website content owned by <a href="#">Army Training Command.</a></p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
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





