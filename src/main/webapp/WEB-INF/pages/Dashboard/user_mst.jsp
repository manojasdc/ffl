<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- jQuery (should be included before Bootstrap JS) -->

<!-- Select Start -->
<!-- <script src="admin/assets/js/outerjs/main.js"></script> -->
<!-- <script src="admin/assets/vendor/datatable/jquery.mockjax.js"></script> -->
<!-- <script src="js/JS_CSS/jquery-2.2.3.min.js"></script> -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<!-- Select End -->

<script src="assets/dev_module_list/userlogin.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>
<script src="assets/dev_module_list/FFL/AESGCM.js"></script>

<div class="content-page" id="userdiv">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">User Creation</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">User
									Creation</li>
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
							<h4 class="card-title">Create User Login</h4>
						</div>
					</div>
					<form name='userCreationMasterForm' id='userCreationMasterForm'>
						<div class="card-body custom-field-block">
							<div class="row">

								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0"> <input type="hidden" id="salt" name="salt" />
								<input type="hidden" id="iv" name="iv" /> <input type="hidden"
									id="key" name="key" />

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Appointment Name<span class="mandatory">*</span></label> <input
											type="text" class="form-control" id="login_name"
											name="login_name" maxlength="70" autocomplete="off"
											placeholder="Enter Appointment Name" required />
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>User ID<span class="mandatory">*</span></label> <input
											type="text" class="form-control" id="user_name"
											name="user_name" autocomplete="off"
											placeholder="Enter User ID" required />
									</div>
								</div>

								<!--<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="">
										<label>Army number(ID)<span class="mandatory">*</span></label>

										<input type="text" class="form-control" id="army_no"
											name="army_no" maxlength="9"
											onkeyup="this.value = this.value.toUpperCase();"
											placeholder="Enter Army Number" autocomplete="off" required />
									</div>
								</div>-->

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">

										<label>Password<span class="mandatory">*</span></label> <input
											type="password" class="form-control" id="user_password"
											name="user_password" maxlength="28"
											onkeyup="this.value = this.value.toUpperCase();"
											placeholder="Enter Password" autocomplete="off" required
											pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" />
									</div>
								</div>
								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Re-Password<span class="mandatory">*</span></label> <input
											type="password" class="form-control" id="user_re_password"
											name="user_re_password" maxlength="28"
											onkeyup="this.value = this.value.toUpperCase();"
											placeholder="Enter Re-Password" autocomplete="off" required
											pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" />
									</div>
								</div>


								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Role <span class="mandatory">*</span></label> <select
											name="user_role_id" id="user_role_id" class="form-control">
											<option value="0">Select Role</option>
										</select>
									</div>
								</div>



								<div class="col-lg-4 col-md-6 col-sm-12 col-12"
									id="hideinstitutename">
									<div class="form-group">
										<label>Institute Name<span class="mandatory">*</span></label>
										<select name="type" class="searchwithselect form-control"
											id="instituteId" name="instituteId">
										</select>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-6 col-sm-12 col-12"
								id="hidecountryname">
								<div class="form-group">
									<label>Country Name<span class="mandatory">*</span></label>
									<select name="type" class="searchwithselect form-control"
										id="countryId" name="countryId">
									</select>
								</div>
							</div>
							</div>

							<div class="row">
								<div class="col-12 col-md-12">
									<div class="form-group">


										<div class="inst_block">
											<h6 class="mb-1">Instruction</h6>
											<ul class="inst_list">
												<li>
													<p class="inst_text">Password should be a mix of
														alphabets, numerals and special characters ($#^@%_.~!*)
														without any space in between.</p>
												</li>
												<li>
													<p class="inst_text">Password must contain both upper
														and lowercase letters.</p>
												</li>
												<li>
													<p class="inst_text">Password length should be between
														8 to 28 characters.</p>
												</li>

											</ul>
										</div>

									</div>
								</div>


							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="btn-bottom">
									<button type="button" class="btn btn-info btnsubmit"
										id="userbtn" name="userbtn">Submit</button>
									<button type="reset" class="btn btn-secondary btnsubmit"
										id="reset">Reset</button>
								</div>
							</div>
						</div>
					</form>
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
							<h4 class="card-title">User Creation Details</h4>
						</div>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<table id="usertbl"
									class="table data-table table-striped table-hover custom-datatable datatable-responsive"
									width="100%">
									<thead>
										<tr>
											<th data-orderable="false"><strong>Sr No.</strong></th>
											<th>Appointment Name</th>
											<th>User ID</th>
											<!--<th>Army number(ID)</th>-->
											<th>Institute Name</th>
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


<div class="modal fade" id="okcancleModalToggle" aria-hidden="true"
	aria-labelledby="okcancleModalToggle" tabindex="-1">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body" id="confirmid"></div>
			<div class="modal-footer">
				<!--                   <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button> -->
				<ul class="buttons-group">
					<li><a href="#0"
						class="main-btn success-btn-outline square-btn btn-hover"
						id="okmsgid">Ok</a></li>
					<li><a href="#0"
						class="main-btn danger-btn-outline square-btn btn-hover"
						id="cancelmsgid">Cancel</a></li>
				</ul>

			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="okModalToggle" aria-hidden="true"
	aria-labelledby="okModalToggle" tabindex="-1">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">Merit generated.</div>
			<div class="modal-footer">
				<!--                   <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button> -->
				<ul class="buttons-group">
					<li><a href="#0"
						class="main-btn success-btn-outline square-btn btn-hover">Ok</a></li>
				</ul>

			</div>
		</div>
	</div>
</div>


