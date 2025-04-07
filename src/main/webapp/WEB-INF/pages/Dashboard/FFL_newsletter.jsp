<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>
<script src="assets/dev_module_list/viewallnewsletter.js"></script>

<!-- Select End -->


<div class="content-page FFL_newsletter">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">FFL News Letters</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">FFL
									News Letters</li>
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
								<h4 class="card-title">Latest News</h4>
							</div>
						</div>
						<div class="card-body">
						
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12 z-1">
									<div class="marquee-content-wrapper" id="allNData">
										<marquee id="marq_id" behavior="scroll" loop="true"
											direction="up" scrollamount="4" scrolldelay="50"
											class="marquee-content">
											<ul class="updates-data">
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">21</span> <span class="info-sub">Dec -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Indian Army conducts patrolling on LoC opposite Pak posts at 4,000 feet height amid heavy snow.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">09</span> <span class="info-sub">Jan -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">The Indian Army will host a two-day conference of Army chiefs of the Indo-Pacific nations to discuss strategies for peace and stability in the region.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">15</span> <span class="info-sub">Dec -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">The poignant arrival of the mortal remains of national heroes, who tragically lost their lives during an encounter with terrorists in Anantnag on September 13, 2023, has brought forth emotional scenes as they reach their respective hometowns.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">24</span> <span class="info-sub">Aug -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Filling up the post of -->
<!-- 																Director General, Central Council for Research.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">15</span> <span class="info-sub">Dec -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Filling up the post of -->
<!-- 																Director General, Central Council for Research.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">04</span> <span class="info-sub">Nov -->
<!-- 																2022</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Filling up the post of -->
<!-- 																Director General, Central Council for Research.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">21</span> <span class="info-sub">Dec -->
<!-- 																2021</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Filling up the post of -->
<!-- 																Director General, Central Council for Research.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 												<li class="update-wrapper"> -->
<!-- 													<div class="date-with-list"> -->
<!-- 														<div class="info-date"> -->
<!-- 															<span class="info-main">29</span> <span class="info-sub">Dec -->
<!-- 																2024</span> -->
<!-- 														</div> -->
<!-- 														<div class="info-content"> -->
<!-- 															<a href="#" target="_blank">Filling up the post of -->
<!-- 																Director General, Central Council for Research.</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</li> -->
												
												${ffl_newsletter}
											</ul>
										</marquee>
										<div class="btn-wrapper">
											<a href="all_news" class="view-all-btn">View More<i class="fa fa-angle-right"></i></a>
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





