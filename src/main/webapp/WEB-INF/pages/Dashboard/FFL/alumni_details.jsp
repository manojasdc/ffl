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
<script src="assets/dev_module_list/FFL/alumnidetails.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>


<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="alumnidiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Alumni</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Alumni
										Details</li>
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
								<h4 class="card-title">Alumni Details</h4>
							</div>
						</div>
						<div class="card-body custom-field-block">
							<div class="row">

								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0">


								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Upload Profile Picture<span class="mandatory">*</span></label>
										<input type="file" class="form-control"
											accept=".jpg,.jpeg,.png," id="profilePicture"
											name="profilePicture" autocomplete="off" maxlength="256"
											tabindex="2" /><a href='#' id="viewimage" name="viewimage"
											class="fa fa-download form-group"></a>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Line 1<span class="mandatory">*</span></label> <input
											class="form-control" type="text" placeholder="Enter Address(ex. B-501,Sriramkunj Apartment)"
											id="line1" name="line1">
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Line 2<span class="mandatory">*</span></label> <input
											class="form-control" type="text" placeholder="Enter Street Area."
											id="line2" name="line2">
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Select Country Name<span class="mandatory">*</span></label>
										<select class="searchwithselect form-control" id="countryId"
											name="countryId">
											<option value='-1'>--Select Country--</option>
										</select>
									</div>
								</div>


								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Select State Name<span class="mandatory">*</span></label>
										<select class="searchwithselect form-control" id="stateId"
											name="stateId">
											<option value='-1'>--Select State--</option>
										</select>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Select City Name<span class="mandatory">*</span></label>
										<select class="searchwithselect form-control" id="cityId"
											name="cityId">
											<option value='-1'>--Select City--</option>
										</select>
									</div>
								</div>


                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Pin Code<span class="mandatory">*</span></label> <input
											class="form-control" type="text" placeholder="Enter Pincode"
											id="pincode" name="pincode" maxlength="10">
									</div>
								</div>



								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="btn-bottom">
										<button type="button" class="btn btn-info btnsubmit"
											id="submitBtn" name="submitBtn">Submit</button>
										<button type="button" class="btn btn-secondary btnsubmit"
											id="reset">Reset</button>
										<!-- <button type="button" class="btn btn-success btnsave">Save</button> -->
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
									<h4 class="card-title">Alumni Data</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="alumnitbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th>No</th>
													
													<th>Line 1</th>
													<th>Line 2</th>
													<th>Country</th>
													<th>State</th>
													<th>City</th>
													<th>Pin Code</th>
<!-- 													<th>Rejected Remarks</th> -->
													<th>Profile Picture</th>
													<!-- <th>Rejected Remarks</th> -->
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