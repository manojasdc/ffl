<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Select Start -->
<!-- <link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css"> -->
<!-- <link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css"> -->
<!-- <script src="assets/vendor/dropDown/select2.min.js"></script> -->
<!-- <script src="assets/vendor/dropDown/custom-select2.js"></script> -->
<!-- Select End -->

<script src="assets/dev_module_list/rbac/rolemaster.js"></script>
<div class="content-page rolemasterdiv">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Link Role Master</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">Link Role Master
									</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="header-title">
							<h4 class="card-title" id="LinkRoleMasterHeader">Link Role Master</h4>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">

							<input type="hidden" id="actiontype" name="actiontype"
								value="add"> <input type="hidden" id="id" name="id"
								value="0">
							<div class="col-12 col-md-6">
								<div class="mb-3">
									<label for="">Role Name<strong style="color: red;">*</strong></label>
									<select class="form-select" id="role_name" name="role_name"
										tabindex="7">
										<option value="-1">Please Select Role Name</option>
									</select>
								</div>
							</div>
							<div class="col-12 col-md-6">
								<div class="mb-3">
									<label for="">Module Name<strong style="color: red;">*</strong></label>
									<select class="form-select" id="module" name="module"
										tabindex="7">
										<option value="-1">Please Select Module name</option>
										<!-- 								<option value="Test1">Test1</option> -->
										<!-- 								<option value="Test2">Test2</option> -->
									</select>
								</div>
							</div>

							<div class="col-12 col-md-6">
								<div class="mb-3">
									<label for="">Sub-Module Name<strong
										style="color: red;">*</strong></label> <select class="form-select"
										id="sub_module" name="sub_module" tabindex="7">
										<option value="-1">--Select Sub-Module Name--</option>
									</select>
								</div>
							</div>
							<div class="col-12 col-md-6">
								<div class="mb-3">
									<label for="">Screen<strong style="color: red;">*</strong></label>
									<select class="form-select" id="screenid" name="screenid"
										tabindex="7">
										<option value="-1">--Select Screen Name--</option>
									</select>
								</div>
							</div>




							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="btn-bottom">
									<button type="button" class="btn btn-info btnsubmit"
										id="submitbtn" name="submitbtn">Submit</button>
									<button type="button" class="btn btn-secondary btnsubmit"
										id="resetbtn">Reset</button>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<section class="single-detail-block">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="card">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">Link Role Master Data</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<table id="linkrolemastertbl"
										class="table data-table table-striped table-hover custom-datatable datatable-responsive"
										width="100%">
										<thead>
											<tr>
												<th>Sr No.</th>
												<th>Role Name</th>
												<th>Module Name</th>
												<th>Sub-Module Name</th>
												<th>Screen</th>
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

	</div>
</div>







