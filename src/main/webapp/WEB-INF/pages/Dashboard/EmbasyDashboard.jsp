<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/js/outerjs/marqueetagstop.js"></script>
<!-- <script src="assets/dev_module_list/viewwhatsnewscroll.js"></script> -->

<script src="assets/dev_module_list/EmbasyDashboard.js"></script>
<!-- Select End -->
<!-- <script src="__layout_file/js/core.js"></script> -->
<!-- <script src="__layout_file/js/charts.js"></script> -->
<!-- <script src="layout_file/js/animated.js"></script> -->


<script src="assets/dev_module_list/index.js"></script>
<script src="assets/dev_module_list/xy.js"></script>
<script src="assets/dev_module_list/Animated.js"></script>
<script src="assets/dev_module_list/percent.js"></script>

<div class="content-page MCTE_dashboard">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<%-- 						<h1 class="page-title">${dashname} Dashboard</h1> --%>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${dashboardurl}">Dashboard</a></li>
								<%-- 								<li class="breadcrumb-item active" aria-current="demo_page">${dashname} --%>
								<!-- 									Dashboard</li> -->
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<input type="hidden" name="dashname" id="dashname"
					value="${dashname}" />
				<div class="card-block-wrapper">
					<div class="card card-block card-stretch card-height reg-card">
						<div class="card-header">
							<div class="header-title">
								<%-- 								<h4 class="card-title">${dashname} Insight</h4> --%>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="iq-option custom-data-card camo-1">
										<div class="custom-dcard-icon camo-1-light">
											<i class="fa fa-book"></i>
										</div>
										<div class="media-body">
											<div class="custom-dcard-value">
												<h4 class="custom-dcard-title">No. of Pending Users</h4>
												<h5 class="custom-dcard-count">${pendingembasycount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-1-light" >
<!-- 												<a  id= "insthide" title="Click here"><i -->
<!-- 													class="fa fa-share-square" aria-hidden="true"></i></a> -->
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
												<h4 class="custom-dcard-title">No. of Accepted Users</h4>
												<h5 class="custom-dcard-count">${acceptedembasycount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-2-light">
<!-- 												<a id= "counthide" title="Click here"><i -->
<!-- 													class="fa fa-share-square" aria-hidden="true"></i></a> -->
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
												<h4 class="custom-dcard-title">No. of Rejected Users</h4>
												<h5 class="custom-dcard-count">${rejectedembasycount}</h5>
											</div>
											<div class="cutom-redirect-btn camo-3-light">
<!-- 												<a id= "userhide" title="Click here"><i -->
<!-- 													class="fa fa-share-square" aria-hidden="true"></i></a> -->
											</div>
										</div>
									</div>
								</div>


								<div class="card-body custom-field-block" id="hideonyear">
									<div class="row" id="hideyear1">
										<div class="col-lg-4 col-md-4 col-sm-12 col-12">
											<div class="form-group">
												<label>Year</label> <select id="year"
													class="searchwithselect form-control">

												</select>
											</div>
										</div>
									</div>




									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="btn-bottom">

											<input type="reset" class="btn btn-secondary" value="Reset"
												id="reset">
										</div>
									</div>
								</div>

								
										<div class="col-lg-12 col-md-12 col-sm-12 col-12" id="hideonusers">
									<div class="card">
										<div class="card-header">
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="header-title">
													<h4 class="card-title" id="title3">Year Wise Users Registered
														Chart</h4>
												</div>
												<div class="dropdown  d-none">
													<span class="dropdown-toggle1"
														id="dropdownMenuButtontwenty" data-bs-toggle="dropdown"
														aria-expanded="false" role="button"> <i
														class="fa fa-bars"></i>
													</span>
													<div class="dropdown-menu dropdown-menu-right"
														aria-labelledby="dropdownMenuButtontwenty">
														<a class="dropdown-item" href="#">Show activity</a> <a
															class="dropdown-item" href="#">View details</a> <a
															class="dropdown-item" href="#">Copy campaign</a> <a
															class="dropdown-item" href="#">Create list</a> <a
															class="dropdown-item" data-extra-toggle="delete"
															data-closest-elem=".item" href="#">Delete</a>
													</div>
												</div>
											</div>
										</div>
										<div class="card-body custom-field-block">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-12">
													<div id="chartdiv5"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								
								

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>





