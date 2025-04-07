<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<!-- Select End -->

<!-- Datepicker start -->
<link rel="stylesheet" href="assets/vendor/datepicker/jquery-ui.css">
<link rel="stylesheet"
	href="assets/vendor/datepicker/custom-jquery-ui.css">
<script src="assets/vendor/datepicker/jquery-ui.js"></script>
<script src="assets/vendor/datepicker/datePicketValidation.js"></script>
<!-- Datepicker End -->


<script
	src="assets/dev_module_list/FFL/allnotificationinside.js"></script>

<!-- bm-datepicker start -->
<!-- <script src="assets/vendor/bm-datepicker/js/material.min.js"></script> -->
<!-- <script type="text/javascript" -->
<!-- 	src="assets/vendor/bm-datepicker/js/moment-with-locales.min.js"></script> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="assets/vendor/bm-datepicker/css/bootstrap-material-datetimepicker.css" /> -->
<!-- <script -->
<!-- 	src="assets/vendor/bm-datepicker/js/bootstrap-material-datetimepicker.js"></script> -->
<!-- <script src="assets/vendor/bm-datepicker/js/custom-bm-datepicker.js"></script> -->
<!-- bm-datepicker end -->
<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<work class="single-detail-block">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">All Notifications</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="band_booking">
									All Notifications</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
			</work>
		</div>

		<div class="row">


			<div class="col-12 col-sm-12 col-md-12 col-lg-12">
				<div class="card card-default">
					<div
						class="card-header d-flex justify-content-between align-items-center">
						<div class="d-flex justify-content-end align-items-center mt-3">
							<span id="lastUpdateAll" class="mr-2">Last updated Just
								Now</span>
							<button id="refresh-button" href="javascript:"
								class="btn btn-secondary btn-refresh">
								<i class="fas fa-sync-alt"></i>
							</button>
						</div>

						<div class="d-flex justify-content-end align-items-center">
							<a class="clearAll" id="clearAll">Clear All <i
								class="fa fa-solid fa-trash"></i></a>
						</div>
					</div>

					<div class="card-body">


						<div class="d-flex justify-content-end">
							<div class="pagination-info">
								<span id="paginationInfo">Displaying 1-10 of 28 / Per
									Page 10</span>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="tab-content" id="myTabContent">
									<input type="hidden" name="totalpage" id="totalpage"
										value="${totalpages}" />
									<div class="tab-pane fade show active" id="allNData"
										role="tabpanel" aria-labelledby="all-tabs"></div>
								</div>
							</div>


						</div>
					</div>
					<!-- Pagination -->

					<div class="pagination center">
						<ul class="pagination-list" id="pagination">
						</ul>
					</div>
				</div>
			</div>
		</div>





	</div>
</div>