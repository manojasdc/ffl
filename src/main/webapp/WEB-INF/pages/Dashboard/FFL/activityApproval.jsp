<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<link rel="stylesheet" href="assets/dev_module_list/css/ejournal.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/dev_module_list/gsap.js"></script>
<script src=></script>
<script src="assets/dev_module_list/FFL/activityapproval.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>


<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="activitydiv">
	<div class="content-page">
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
									<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Blog</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>

			<section class="single-detail-block" id="kak">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<div class="card-header">
								<div class="header-title">
									<h4 class="card-title">Blog Details</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-4 col-md-6 col-sm-12 col-12">
										<div class="form-group">
											<label>Category<span class="mandatory">*</span></label> <select
												class="searchwithselect form-control" id="category"
												name="category">
												<option value='Pending'>Pending</option>
												<option value='Approved'>Approved</option>
												<option value='Rejected'>Rejected</option>
											</select>
										</div>
									</div>

									<div class="btn-bottom">
										<button type="button" class="btn btn-info btnsubmit"
											id="submitbtn" name="submitbtn">Search</button>
										<button type="button" class="btn btn-secondary btnsubmit"
											id="reset">Reset</button>
									</div>

									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="activitytbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th data-orderable="false">Sr No.</th>
													<th>User Name</th>
													<th>Blog Title</th>
													<th>Blog Description</th>
													<!--<th>Blog Year</th>-->
													<th>Country</th>
													<th>Blog Document</th>
													<th>Action</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<input id="idactivity1" name="idactivity1" value="${mapid}" hidden>

		</div>

	</div>