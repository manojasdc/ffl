<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/viewMiscActivity.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>
<!-- Select End -->


<div class="content-page MISC_activities">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Blog</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">
									MISC Activities</li>
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
							<div class="row" id="miscData">
							
				
							</div>
							<ul id="pagination" class="pagination-wrapper">
								</ul>
								
<!-- 								<div class="col-lg-12 col-md-12 col-sm-12 col-12"> -->
<!-- 									<div class="card blog-card"> -->
<!-- 										<div class="blog-image"> -->
<!-- 											<img class="img-fluid" -->
<!-- 												src="assets/images/outerimages/banner5.jpg"> -->
<!-- 										</div> -->
<!-- 										<div class="blog-info"> -->
<!-- 											<div class="blog-ttl"> -->
<!-- 												<a class="blog-ttl-wraper" href="#">Passing Out Parade of Directly Appointed Gazetted -->
<!-- 													Officers Marks Success at CRPF Academy, Gurugram</a> -->
<!-- 											</div> -->
<!-- 											<div class="blog-dtl"> -->
<!-- 												<p class="blog-auth-dtl"> -->
<!-- 													By <span class="blog-auth">Sh. Anish Dayal Singh</span><span class="auth-passout">2023</span> -->
<!-- 												</p> -->
<!-- 												<div class="blog-desc read-more-container"> -->
<!-- 													<p class="read-more-text read-less" id="read-more-text">The Passing Out Parade -->
<!-- 														of the 54th batch of 22 Directly Appointed Gazetted -->
<!-- 														Officers (DAGOs) of the Central Reserve Police Force -->
<!-- 														(CRPF) was conducted today at the CRPF Academy, Gurugram. -->
<!-- 														The Parade was the culmination of a comprehensive 52-week -->
<!-- 														arduous training covering a wide range of subjects, -->
<!-- 														including firearms handling, law enforcement, management, -->
<!-- 														human rights, VIP security, law and order maintenance, -->
<!-- 														physical fitness, unarmed combat, field engineering, IED -->
<!-- 														modules, fieldcraft, jungle survival, operational case -->
<!-- 														studies, and more.</p> -->
<!-- 													<span class="read-more-btn" id="read-more-btn">Read More...</span> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
							
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





