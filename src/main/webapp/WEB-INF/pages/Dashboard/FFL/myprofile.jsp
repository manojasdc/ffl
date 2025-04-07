
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/dev_module_list/FFL/profiledtl.js"></script>
<script src="assets/dev_module_list/FFL/AESGCM.js"></script>

<!-- Select End -->

<div id="profiledtl">
	<div class="content-page myprofile-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">My Profile</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="My Profile">My
										Profile</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-lg-4 col-md-6 col-sm-12 col-12">
				<input type="hidden" id="salt" name="salt" /> <input
										type="hidden" id="iv" name="iv" /> <input type="hidden"
										id="key" name="key" />
					<input type="hidden" id="actiontype" name="actiontype"
						value="${actiontype}"><input type="hidden"
						id="GeneratedKey" name="GeneratedKey" value="${GeneratedKey}" />
					<input type="hidden" id="GeneratedIV" name="GeneratedIV"
						value="${GeneratedIV }" /> <input type="hidden" id="GeneratedSalt"
						name="GeneratedSalt" value="${GeneratedSalt }" /> <input
						type="hidden" id="Generatedpassword" name="Generatedpassword"
						value="${Generatedpassword }" /> <input type="hidden" id="id"
						name="id" value="${id}">
					<div class="card">
						<div class="card-body custom-field-block">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group custom-profile-img">
										<div class="crm-profile-img-edit">
											<img class="crm-profile-pic img-fluid rounded-circle"
												src="assets/images/user.png" alt="profile-pic">
											<div class="crm-p-image btn-primary">
												<i class="las la-pen upload-button"></i> <input
													class="file-upload" type="file" accept="image/*" id="photo"
													name="photo">
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group">
										<label>Name</label> <input class="form-control" type="text"
											id="name" name="name" placeholder="Enter Name">
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group">
										<label>Email ID<span class="mandatory">*</span></label> <input
											class="form-control" type="text" id="emailId" name="emailId"
											placeholder="Enter Email ID">
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group">
										<label>Contact No.<span class="mandatory">*</span></label> <input
											class="form-control" type="text" id="contactNo"
											name="contactNo" placeholder="Enter Contact No."
											maxlength="10">
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group" id="optradio1">
										<label for="">Gender <span class="mandatory">*</span></label><br>
										<input type="radio" value="Male" name="gender"> Male <input
											type="radio" value="Female" name="gender"> Female
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group">
										<label>Date of Birth<span class="mandatory">*</span></label> <input
											class="form-control" type="date" id="dateOfBirth"
											name="dateOfBirth" placeholder="Enter Date of Birth">
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="form-group">
										<label>Address<span class="mandatory">*</span></label> <input
											class="form-control" type="text" id="address" name="address"
											placeholder="Enter Address">
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="btn-bottom">
										<ul class="list-inline custom-btn-group">
											<li class="list-inline-item"><button type="button"
													class="btn btn-info btnsubmit" id="submitbtn">Submit</button></li>
											<li class="list-inline-item"><button type="button"
													class="btn btn-secondary btnreset" id="reset" name="reset">Reset</button></li>
										</ul>
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