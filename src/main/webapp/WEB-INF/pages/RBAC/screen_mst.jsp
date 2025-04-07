<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/dev_module_list/rbac/screen_master.js"></script>

<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Screen Master</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="screen_master">Screen Master</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">

			<input type="hidden" id="actiontype" name="actiontype" value="add">
			<input type="hidden" id="screen_id" name="screen_id" value="0">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="header-title">
							<h4 class="card-title" id="screenMasterHeader">Screen Master</h4>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">


							<div class="row mb-3">
								<div class="col-md-2">
									<label for="text-input">Screen Name<span
										class="mandatory">*</span></label>
								</div>
								<div class="col-md-4">
									<input id="screen_name" name="screen_name"
										placeholder="Enter Screen Name"
										class="form-control font_arial" autocomplete="off"
										maxlength="80">
								</div>
								<div class="col-md-2">
									<label for="text-input">Screen URL<span
										class="mandatory">*</span></label>
								</div>
								<div class="col-md-4">
									<input id="screen_url" name="screen_url"
										placeholder="Enter Screen URL" class="form-control font_arial"
										autocomplete="off" maxlength="125">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-md-2">
									<label class=" form-control-label">Module Name<span
										class="mandatory">*</span></label>
								</div>
								<div class="col-md-4">
									<select name="module.id" class="searchwithselect form-control"
										id="screen_module_id">
										<option value="-1">--Select--</option>

									</select>
								</div>
								<div class="col-md-2">
									<label class=" form-control-label">Sub Module Name<span
										class="mandatory">*</span></label>
								</div>
								<div class="col-md-4">
									<!-- <select name="" class="form-control" id ="modulelist"  onchange="myFunction(event)">  </select> -->
									<select name="sub_module.id" class="searchwithselect form-control"
										id="screen_submodule_id">
										<option value="-1">--Select--</option>
									</select>
								</div>
							</div>



							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="btn-bottom">
									<ul class="list-inline custom-btn-group">
										<li class="list-inline-item"><button type="button"
												class="btn btn-info btnsubmit" id="save_btn">Submit</button></li>

										<li class="list-inline-item"><button type="button"
												class="btn btn-secondary btnsubmit" id="resetbtn">Reset</button></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- datatable -->

		<section class="single-detail-block">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="card">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">Screen Master Data</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<table id="screentbl"
										class="table data-table table-striped table-hover custom-datatable datatable-responsive"
										width="100%">
										<thead>
											<tr>
												<th>Sr No.</th>
												<th>Screen Master Name</th>
												<th>Module Name</th>
												<th>Sub Module Name</th>
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



