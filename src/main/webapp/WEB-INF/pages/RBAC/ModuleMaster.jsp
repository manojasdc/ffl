
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="assets/dev_module_list/rbac/modulemaster.js"></script>

<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>


<script src="assets/vendor/dropDown/jquery.blockUI.js"></script>
<script src="assets/vendor/dropDown/jquery-confirm.min.js"></script>


<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Module Master</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="module_master">Module
									Master</li>
							</ol>
						</nav>
					</div>
				</div>

				<div class="row">

					<input type="hidden" id="actiontype" name="actiontype" value="add">
					<input type="hidden" id="moduleid" name="moduleid" value="0">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<div class="card-header">
								<div class="header-title">
									<h4 class="card-title" id="moduleHeader">Module Master</h4>
								</div>
							</div>
							<div class="card-body custom-field-block">
								<div class="row">
									<div class="col-12 col-md-6">
										<div class="form-group">
											<label for="">Module Name<span class="mandatory">*</span></label>
											<input type="text" class="form-control" id="modulename"
												placeholder="Enter Module Name" name="modulename"
												autocomplete="off" maxlength="55" tabindex="1">
										</div>
									</div>


									<div class="row m-0">
										<div
											class="col-12 mt-3 mb-3 w3-border w3-round w3-footer-padding ws-lightgreen text-center">

											<ul class="list-inline custom-btn-group">
												<li class="list-inline-item"><button type="button"
														class="btn btn-info btnsubmit" id="modulebtn">Submit</button></li>

												<li class="list-inline-item"><button type="button"
														class="btn btn-secondary btnsubmit" id="reset_btn">Reset</button></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- new -->

				<section class="single-detail-block">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-12">
							<div class="card">
								<div class="card-header">
									<div class="header-title">
										<h4 class="card-title">Module Master Data</h4>
									</div>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-12">
											<table id="modulemastertbl"
												class="table data-table table-striped table-hover custom-datatable datatable-responsive"
												width="100%">
												<thead>
													<tr>
														<th>Sr No.</th>
														<th>Module Name</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody></tbody>
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
	</div>

	<!-- <div id="rolemasterdiv">
	<div class="container mt-4">
		<div class="col-12">
			<div
				class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
				<h5 class="m-0">Module Master</h5>
			</div>
		</div>
		<div
			class="container-fluid w3-border w3-round w3-padding  ws-grey mb-3 main-form">
			<div class="row">
				<input type="hidden" id="actiontype" name="actiontype" value="add">
				<input type="hidden" id="moduleid" name="moduleid" value="0">

				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Module Name <strong class="text-red">*</strong></label>
						<input type="text" class="form-control" id="modulename"
							placeholder="Please Enter Module Name" name="modulename"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>



			</div>



			<div class="row m-0">
				<div
					class="col-12 mt-3 mb-3 w3-border w3-round w3-footer-padding ws-lightgreen text-center">
					<button type="button" class="btn btn-primary"
						 id="modulebtn"
						name="modulebtn">Submit</button>
					<input type="reset" class="btn btn-success btn-sm" value="Clear" id="reset_btn"
						>

				</div>
			</div>

		</div>
	</div>


	<div class="container mt-3">
		<div class="table-wrapper">
			<table id="modulemastertbl"
				class="table no-margin table-striped table-hover table-bordered ">
				<thead>
					<tr>
						<th>No</th>
						<th>Module Name</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody></tbody>

			</table>
		</div>
	</div>
</div> -->