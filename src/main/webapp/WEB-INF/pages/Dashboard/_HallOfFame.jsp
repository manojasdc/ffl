<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/viewhalloffame.js"></script>
<!-- Select End -->


<div class="content-page HallOfFame">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Hall Of Fame</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="MCTE_dashboard">MCTE
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">Hall
									Of Fame</li>
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
							<div class="row" id="allNData">
								<input type="hidden" name="totalpage" id="totalpage"
									value="${totalpages}" />
							</div>
							<div class="pagination center">
								<ul class="pagination-list" id="pagination">
								</ul>
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
<!-- 						<div class="card-body"> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-lg-12 col-md-12 col-sm-12 col-12"> -->
<!-- 									<marquee id="marq_id" behavior="scroll" loop="true" -->
<!-- 										direction="up" scrolldelay="50" class="marquee-content"> -->
<!-- 										<ul class="news-wrapper"> -->
<!-- 											<li><p> -->
<!-- 													Website content owned by <a href="#">Army Training -->
<!-- 														Command.</a> -->
<!-- 												</p></li> -->
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
<!-- 											<li><p>Let us go green to get our planet clean.</p></li> -->

<!-- 										</ul> -->
<!-- 									</marquee> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




