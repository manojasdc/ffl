<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/viewFFCAlumni.js"></script>
<!-- Select End -->


<div class="content-page FFC_Alumni">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">FFC Alumni</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="${dashname}_dashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">
									FFC Alumni</li>
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
									value="${totalpages}" /> <input type="hidden" name="dashname"
									id="dashname" value="${dashname}" />

								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 									<div class="card profile-card"> -->
								<!-- 										<div class="profile-image"> -->
								<!-- 											<img class="img-fluid" src="assets/images/no-user.png"> -->
								<!-- 										</div> -->
								<!-- 										<div class="profile-info"> -->
								<!-- 											<div class="profile-name"> -->
								<!-- 												<h2>Bradley Steve</h2> -->
								<!-- 											</div> -->
								<!-- 											<div class="profile-dtl"> -->
								<!-- 												<p><i class="fa fa-graduation-cap"></i>PassOut Year : <span class="dn-dtl">2024</span> -->
								<!-- 												<p><i class="ri-phone-fill"></i>Contact No : <span class="dn-dtl">9999999999</span> -->
								<!-- 												<p><i class="fa fa-envelope"></i>Email ID : <span class="dn-dtl">info@gmail.com</span> -->
								<!-- 											</div> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
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
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<marquee id="marq_id" behavior="scroll" loop="true"
										direction="up" scrolldelay="50" class="marquee-content">
										<ul class="news-wrapper">
											<li><p>
													Website content owned by <a href="#">Army Training
														Command.</a>
												</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
											<li><p>Let us go green to get our planet clean.</p></li>
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





