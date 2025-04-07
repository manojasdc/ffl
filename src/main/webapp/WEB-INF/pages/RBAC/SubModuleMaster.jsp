<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>


<script src="assets/vendor/dropDown/jquery.blockUI.js"></script>
<script src="assets/vendor/dropDown/jquery-confirm.min.js"></script>
<script src="assets/dev_module_list/rbac/submodulemaster.js"></script>
<input type="hidden" id="submoduleid" name="submoduleid" value="0">

<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Sub Module Master</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active"
									aria-current="sub_module_master">Sub Module Master</li>
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
									<h4 class="card-title" id="submoduleHeader">Sub Module Master</h4>
								</div>
							</div>
							<div class="card-body custom-field-block">
								<div class="row">
									<div class="col-12 col-md-6 form-group">
										<label for="">Module Name<span class="mandatory">*</span></label>
										<select name="modulename" id="modulename"
											class="searchwithselect form-control">
											<option>---Select---</option>
										</select>
									</div>

									<div class="col-12 col-md-6">
										<div class="mb-3">
											<label for="">Sub Module Name<span class="mandatory">*</span></label>
											<input type="text" class="form-control" id="submodname"
												placeholder="Enter Sub Module Name" name="submodname"
												autocomplete="off" maxlength="60" tabindex="1">
										</div>
									</div>


									<div class="row m-0">
										<div
											class="col-12 mt-3 mb-3 w3-border w3-round w3-footer-padding ws-lightgreen text-center">
											<!-- 											<button type="button" class="btn btn-primary" -->
											<!-- 												id="submodulebtn" name="submodulebtn">Submit</button> -->

											<!-- 											<li class="list-inline-item"><button type="button" -->
											<!-- 													class="btn btn-secondary btnsubmit" id="reset_btn">Reset</button></li> -->

											<ul class="list-inline custom-btn-group">
												<li class="list-inline-item"><button type="button"
														class="btn btn-info btnsubmit" id="submodulebtn">Submit</button></li>

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
										<h4 class="card-title">Sub Module Master Data</h4>
									</div>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-12">
											<table id="submodulemastertbl"
												class="table data-table table-striped table-hover custom-datatable datatable-responsive"
												width="100%">
												<thead>
													<tr>
														<th>Sr No.</th>
														<th>Module Name</th>
														<th>Sub Module Name</th>
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
</div>