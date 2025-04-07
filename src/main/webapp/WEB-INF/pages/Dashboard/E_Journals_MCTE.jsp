<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/E_journals.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>

<!-- Select End -->


<div class="content-page E_Journals_MCTE">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">E Journals ${dashname}</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">E
									Journals ${dashname}</li>
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
								<h4 class="card-title">Electronic Journals ${dashname}</h4>
							</div>
						</div>
						<div class="card-body">
						<input type="hidden" name="totalpage" id="totalpage"
									value="${totalpages}" /><input type="hidden" name="dashname"
									id="dashname" value="${dashname}" />
							<div class="row" id="ejournalData">
								
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/kargil.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="E_Journal_dtlPage" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read More</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i> </span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/Balidan-bookcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/1971IndoPak-frontcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/Bravehearts-bookcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card mb-0"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/Forces-frontcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card mb-0"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/Fearless1-bookcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card mb-0"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/Ghazi-frontcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-3 col-md-4 col-sm-6 col-12"> -->
<!-- 									<div class="card custom-j-card mb-0"> -->
<!-- 										<div class="card-cover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/TheBrave-bookcover.jpg"> -->
<!-- 										</div> -->
<!-- 										<a href="#" class="overlay-content" -->
<!-- 											title="Click here" target="/blank"> -->
<!-- 											<span class="oc-text">Read Now</span> <span class="oc-icon"><i -->
<!-- 												class="fa fa-angle-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
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