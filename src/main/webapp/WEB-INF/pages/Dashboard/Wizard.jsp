<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Form Wizard Start -->
<link rel="stylesheet"
	href="assets/vendor/formwizard/custom-formwizard.css">
<!-- Form Wizard End -->


<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="card card-block card-stretch card-height">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">Student Form</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="custom-formwizard">
										<form id="form-wizard1">
											<ul id="top-tab-list" class="custom-tab-list list-inline">
												<li id="st_basic_info" class="custom-tab-listitem active"><a
													href="javascript:void();"> <span class="iq-icon">
															<i class="fa fa-unlock" aria-hidden="true"></i>
													</span> <span class="dark-wizard">Basic info</span>
												</a></li>
												<li id="st_parent_info" class="custom-tab-listitem"><a
													href="javascript:void();"> <span class="iq-icon">
															<i class="fa fa-user" aria-hidden="true"></i>
													</span> <span class="dark-wizard">Parent info</span>
												</a></li>
												<li id="st_address_info" class="custom-tab-listitem"><a
													href="javascript:void();"> <span class="iq-icon">
															<i class="fa fa-camera"></i>

													</span> <span class="dark-wizard">Address info</span>
												</a></li>

												<li id="st_other_info" class="custom-tab-listitem"><a
													href="javascript:void();"> <span class="iq-icon">
															<i class="fa fa-camera"></i>

													</span> <span class="dark-wizard">Other info</span>
												</a></li>

												<li id="confirm" class="custom-tab-listitem"><a
													href="javascript:void();"> <span class="iq-icon">
															<i class="fa fa-check" aria-hidden="true"></i>
													</span> <span class="dark-wizard">Finish</span>
												</a></li>
											</ul>


											<!-- Basic Information -->
											<fieldset>
												<div class="form-card text-start">
													<div class="row">
														<div class="col-lg-7 col-md-7 col-sm-12 col-12">
															<h3 class="custom-tab-title">Basic Information:</h3>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-12">
															<h2 class="steps">Step 1 - 5</h2>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label>File Upload<span class="mandatory">*</span></label>
																<input class="form-control" type="file">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Roll No <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="rollNo"
																	placeholder="Please Enter Roll No" name="rollNo"
																	autocomplete="off" maxlength="128" tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Addmission No <span
																	class="mandatory">*</span></label> <input type="text"
																	class="form-control" id="admissionNo"
																	placeholder="Please Enter admissionNo"
																	name="admissionNo" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Addmission Date <span
																	class="mandatory">*</span></label> <input type="date"
																	class="form-control" id="admissionDate"
																	placeholder="Please Enter Date Of Admission"
																	name="admissionDate" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">First Name <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="firstName"
																	placeholder="Please Enter First Name" name="firstName"
																	autocomplete="off" maxlength="128" tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Middle Name <span
																	class="mandatory">*</span></label> <input type="text"
																	class="form-control" id="middleName"
																	placeholder="Please Enter Middle Name"
																	name="middleName" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Last Name <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="lastName"
																	placeholder="Please Enter Last Name" name="lastName"
																	autocomplete="off" maxlength="128" tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Admission type <span
																	class="mandatory">*</span></label> <select class="form-select"
																	id="admissionType" name="admissionType" tabindex="7">
																	<option value="-1">Please Select Admission
																		Type</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Student Date of Join <span
																	class="mandatory">*</span></label> <input type="date"
																	class="form-control" id="dateOfJoin"
																	placeholder="Please Enter Date Of Join"
																	name="dateOfJoin" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Class Name </label> <select
																	class="form-select" id="classId" name="classId"
																	tabindex="7">
																	<option value="-1">Please Select Class</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Section </label> <select
																	class="form-select" id="sectionId" name="sectionId"
																	tabindex="7">
																	<option value="-1">Please Select Section</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Stream </label> <select
																	class="form-select" id="streamId" name="streamId"
																	tabindex="7">
																	<option value="-1">Please Select Stream</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Fee Group </label> <select
																	class="form-select" id="feeGroup" name="feeGroup"
																	tabindex="7">
																	<option value="-1">Please Select Fee Group</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Email Address </label> <input type="email"
																	class="form-control" id="emailId"
																	placeholder="Please Enter Email address" name="emailId"
																	autocomplete="off" maxlength="128" tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mobile No <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="mobileNo"
																	placeholder="Please Enter Mobile Number"
																	name="mobileNo" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">SMS Mobile No <span
																	class="mandatory">*</span></label> <input type="text"
																	class="form-control" id="smsMobileNo"
																	placeholder="Please Enter SMS Mobile Number"
																	name="smsMobileNo" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Emergency Mobile No </label> <input
																	type="text" class="form-control" id="emeMobileNo"
																	placeholder="Please Enter Emergency Mobile Number"
																	name="emeMobileNo" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Date Of Birth <span
																	class="mandatory">*</span></label> <input type="date"
																	class="form-control" id="dateOfBirth"
																	placeholder="Please Enter Date Of Birth"
																	name="dateOfBirth" autocomplete="off" maxlength="128"
																	tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-control">
																<label for="">Gender <span class="mandatory">*</span></label>
																<input type="radio" value="M" name="gender">
																Male <input type="radio" value="F" name="gender">
																Female <input type="radio" value="O" name="gender">
																Other
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Blood_Group </label> <select
																	class="form-select" id="bloodGroup" name="bloodGroup">
																	<option value="-1">Please Select Blood_Group</option>
																	<option value="A+">A+</option>
																	<option value="A-">A-</option>
																	<option value="B+">B+</option>
																	<option value="B-">B-</option>
																	<option value="O+">O+</option>
																	<option value="O-">O-</option>
																	<option value="AB+">AB+</option>
																	<option value="AB-">AB-</option>
																</select>
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Nationality <span
																	class="mandatory">*</span></label> <select class="form-select"
																	id="nationality" name="nationality" tabindex="7">
																	<option value="-1">Please Select nationality</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Religion <span class="mandatory">*</span></label>
																<select class="form-select" id="religionId"
																	name="religionId">
																	<option value="-1">Please Select Religion</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Cast </label> <select class="form-select"
																	id="castId" name="castId">
																	<option value="-1">Please Select nationality</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother_Tongue </label> <select
																	class="form-select" id="motherTongue"
																	name="motherTongue">
																	<option value="-1">Please Select Mother_Tongue</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Adhar Card Number <span
																	class="mandatory">*</span></label> <input type="text"
																	class="form-control" id="aadharNo" name="aadharNo"
																	placeholder="Please Enter Adhar Number"
																	autocomplete="off" maxlength="12" tabindex="1">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Area <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="area"
																	name="area" placeholder="Please Enter Area">
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Country </label> <select
																	class="form-select" id="country" name="country"
																	tabindex="7">
																	<option value="-1">Please Select Your Country</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">State </label> <select class="form-select"
																	id="stateId" name="stateId" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">City </label> <select class="form-select"
																	id="cityId" name="cityId" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Address </label>
																<textarea class="form-control" id="address"
																	placeholder="Please Enter Address" name="address"
																	autocomplete="off"></textarea>
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">pincode</label> <input type="text"
																	class="form-control" id="pincode" name="pincode"
																	placeholder="Please Enter pincode" autocomplete="off"
																	maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">House <span class="mandatory">*</span></label>
																<select class="form-select" id="houseId" name="houseId"
																	tabindex="7">
																	<option value="-1">Please Select House</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Quota </label> <select class="form-select"
																	id="quota" name="quota" tabindex="7">
																	<option value="-1">Please Select Quota</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Category </label> <select
																	class="form-select" id="categoryId" name="categoryId"
																	tabindex="7">
																	<option value="-1">Please Select Category</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Sub-Category </label> <select
																	class="form-select" id="subCategoryId"
																	name="subCategoryId" tabindex="7">
																	<option value="-1">Please Select Sub-Category</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Join In Class <span
																	class="mandatory">*</span></label> <select class="form-select"
																	id="joinClass" name="joinClass" tabindex="7">
																	<option value="-1">Please Select Join Class</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label>Normal Input<span class="mandatory">*</span></label>
																<input class="form-control" type="text"
																	placeholder="Enter Input">
															</div>
														</div>


														<!-- Birth Detail -->
														<div class="row">
															<div class="col-12 col-sm-12 ">
																<h3 class="custom-tab-title">Birth Details:</h3>
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Place of Birth </label>. <input
																	type="text" class="form-control" id="birthPlace"
																	name="birthPlace"
																	placeholder="Please Enter Place of Birth">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Birth Country</label> <select
																	class="form-select" id="birthCountry"
																	name="birthCountry" tabindex="7">
																	<option value="-1">Please Select Birth Country</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Certificate No</label> <input type="text"
																	class="form-control" id="birthCertificateNo"
																	name="birthCertificateNo"
																	placeholder="Please Enter birth Certificate No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Certificate Date</label> <input
																	type="date" class="form-control"
																	id="birthCertificateDate" name="birthCertificateDate"
																	placeholder="Please Enter birth Certificate No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Certificate corpoNo</label> <input
																	type="text" class="form-control"
																	id="birthCertificateCorpoNo"
																	name="birthCertificateCorpoNo"
																	placeholder="Please Enter birth Certificate Corpo No">
															</div>
														</div>
													</div>
												</div>
												<button type="button" name="next"
													class="btn btn-primary next action-button float-end"
													value="Next">Next</button>
											</fieldset>


											<!--Parent Information -->
											<fieldset>
												<div class="form-card text-start">
													<div class="row">
														<div class="col-lg-7 col-md-7 col-sm-12 col-12">
															<h3 class="custom-tab-title">Parent's Information:</h3>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-12">
															<h2 class="steps">Step 2 - 5</h2>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Fee no</label> <input type="text"
																	class="form-control" id="feeNo" name="feeNo"
																	placeholder="Please Enter Fee No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Profile Pic </label> <input
																	type="file" class="form-control" id="fProfilepic"
																	name="fProfilepic">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Profile Pic </label> <input
																	type="file" class="form-control" id="mProfilepic"
																	name="mProfilepic">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Guardian's Profile Pic </label> <input
																	type="file" class="form-control" id="gProfilepic"
																	name="gProfilepic">
															</div>
														</div>
														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Father's Information:</h3>
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Title </label> <select
																	class="form-select" id="fTitle" name="fTitle"
																	tabindex="7">
																	<option value="-1">Please Select Father Title</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Name</label> <input type="text"
																	class="form-control" id="fName" name="fName"
																	placeholder="Please Enter fatherName">
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Email</label> <input type="email"
																	class="form-control" id="fEmail" name="fEmail"
																	placeholder="Please Enter Father's Email">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Qualification </label> <select
																	class="form-select" id="fQualification"
																	name="fQualification" tabindex="7">
																	<option value="-1">Please Select Father
																		Qualification</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Designation </label> <select
																	class="form-select" id="fDesignation"
																	name="fDesignation" tabindex="7">
																	<option value="-1">Please Select Father
																		Designation</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Organisation's Name</label> <input
																	type="text" class="form-control" id="fOrgName"
																	name="fOrgName"
																	placeholder="Please Enter Organisation Name">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Organisation's Address</label> <input
																	type="text" class="form-control" id="fOrgAddress"
																	name="fOrgAddress"
																	placeholder="Please Enter Organisation Address">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Country </label> <select
																	class="form-select" id="fCountry" name="fCountry"
																	tabindex="7">
																	<option value="-1">Please Select Your Country</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">State </label> <select class="form-select"
																	id="fState" name="fState" tabindex="7">
																	<option value="-1">Please Select Your State</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">City </label> <select class="form-select"
																	id="fCity" name="fCity" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Pincode</label> <input
																	type="text" class="form-control" id="fPincode"
																	name="fPincode" placeholder="Please Enter pincode"
																	autocomplete="off" maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Nationality </label> <select
																	class="form-select" id="fNationality"
																	name="fNationality" tabindex="7">
																	<option value="-1">Please Select nationality</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Annual income</label> <input
																	type="text" class="form-control" id="fAnnualIncome"
																	name="fAnnualIncome"
																	placeholder="Please Enter fAnnualIncome"
																	autocomplete="off" maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Service Number</label> <input
																	type="text" class="form-control" id="fServiceNo"
																	name="fServiceNo"
																	placeholder="Please Enter father Service No"> </select>
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Telephone</label> <input
																	type="text" class="form-control" id="fTelephoneNo"
																	name="fTelephoneNo"
																	placeholder="Please Enter fTelephoneNo"
																	autocomplete="off" maxlength="6"> </select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Mobile Number</label> <input
																	type="text" class="form-control" id="fMobileNo"
																	name="fMobileNo" placeholder="Please Enter fMobileNo">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Rank</label> <input type="text"
																	class="form-control" id="fRank" name="fRank"
																	placeholder="Please Enter fRank" autocomplete="off"
																	maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Serving / Retired</label> <input
																	type="text" class="form-control" id="fServingRetired"
																	name="fServingRetired"
																	placeholder="Please Enter fServingRetired">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Father's Date of Retirement</label> <input
																	type="date" class="form-control" id="fDateOfRetirement"
																	name="fDateOfRetirement">
															</div>
														</div>

														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Mother's Information:</h3>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Title </label> <select
																	class="form-select" id="mTitle" name="mTitle"
																	tabindex="7">
																	<option value="-1">Please Select Mother Title</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Name</label> <input type="text"
																	class="form-control" id="mName" name="mName"
																	placeholder="Please Enter fatherName">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Email</label> <input type="email"
																	class="form-control" id="mEmail" name="mEmail"
																	placeholder="Please Enter mother's Email">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Qualification </label> <select
																	class="form-select" id="mQualification"
																	name="mQualification" tabindex="7">
																	<option value="-1">Please Select Father
																		Qualification</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Designation </label> <select
																	class="form-select" id="mDesignation"
																	name="mDesignation" tabindex="7">
																	<option value="-1">Please Select Father
																		Designation</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Organisation's Name</label> <input
																	type="text" class="form-control" id="mOrgName"
																	name="mOrgName"
																	placeholder="Please Enter Organisation Name">
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Organisation's Address</label> <input
																	type="text" class="form-control" id="mOrgAddress"
																	name="mOrgAddress"
																	placeholder="Please Enter Organisation Address">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Country </label> <select
																	class="form-select" id="mCountry" name="mCountry"
																	tabindex="7">
																	<option value="-1">Please Select Your Country</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">State </label> <select class="form-select"
																	id="mState" name="mState" tabindex="7">
																	<option value="-1">Please Select Your State</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">City </label> <select class="form-select"
																	id="mCity" name="mCity" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Pincode</label> <input
																	type="text" class="form-control" id="mPincode"
																	name="mPincode" placeholder="Please Enter pincode"
																	autocomplete="off" maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Nationality </label> <select
																	class="form-select" id="mNationality"
																	name="mNationality" tabindex="7">
																	<option value="-1">Please Select nationality</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Annual income</label> <input
																	type="text" class="form-control" id="mAnnualIncome"
																	name="mAnnualIncome"
																	placeholder="Please Enter fAnnualIncome"
																	autocomplete="off" maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Service Number</label> <input
																	type="text" class="form-control" id="mServiceNo"
																	name="mServiceNo"
																	placeholder="Please Enter father Service No">
															</div>
														</div>

														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Telephone</label> <input
																	type="text" class="form-control" id="mTelephoneNo"
																	name="mTelephoneNo"
																	placeholder="Please Enter fTelephoneNo"
																	autocomplete="off" maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Mobile Number</label> <input
																	type="text" class="form-control" id="mMobileNo"
																	name="mMobileNo" placeholder="Please Enter fMobileNo">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Rank</label> <input type="text"
																	class="form-control" id="mRank" name="mRank"
																	placeholder="Please Enter fRank" autocomplete="off"
																	maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Serving / Retired</label> <input
																	type="text" class="form-control" id="mServingRetired"
																	name="mServingRetired"
																	placeholder="Please Enter fServingRetired">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Mother's Date of Retirement</label> <input
																	type="date" class="form-control" id="mDateOfRetirement"
																	name="mDateOfRetirement">
															</div>
														</div>

														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Guardian's
																	Information:</h3>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Guardian's Name</label> <input type="text"
																	class="form-control" id="gName" name="gName"
																	placeholder="Please Enter Guardian's Name">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Guardian's Email</label> <input
																	type="email" class="form-control" id="gEmail"
																	name="gEmail"
																	placeholder="Please Enter Guardian's Email">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Relation with Student</label> <input
																	type="text" class="form-control" id="gRelation"
																	name="gRelation"
																	placeholder="Please Enter Guardian's Name">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Guardian's Mobile No</label> <input
																	type="text" class="form-control" id="gMobileNo"
																	name="gMobileNo"
																	placeholder="Please Enter Guardian's Mobile">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Guardian's Address </label>
																<textarea class="form-control" id="gAddress"
																	placeholder="Please Enter Address" name="gAddress"
																	autocomplete="off"></textarea>
															</div>
														</div>
													</div>
												</div>
												<button type="button" name="next"
													class="btn btn-primary next action-button float-end"
													value="Next">Next</button>
												<button type="button" name="previous"
													class="btn btn-dark previous action-button-previous float-end me-1"
													value="Previous">Previous</button>
											</fieldset>

											<!-- Permanent Address Information -->
											<fieldset>
												<div class="form-card text-start">
													<div class="row">
														<div class="col-lg-7 col-md-7 col-sm-12 col-12">
															<h3 class="custom-tab-title">Permanent Address
																Information:</h3>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-12">
															<h2 class="steps">Step 3 - 5</h2>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Country </label> <select
																	class="form-select" id="prCountry" name="prCountry"
																	tabindex="7">
																	<option value="-1">Please Select Your Country</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">State </label> <select class="form-select"
																	id="prState" name="prState" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">City </label> <select class="form-select"
																	id="prCityId" name="prCityId" tabindex="7">
																	<option value="-1">Please Select Your City</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Address </label>
																<textarea class="form-control" id="prAddress"
																	placeholder="Please Enter Address" name="prAddress"
																	autocomplete="off"></textarea>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">pincode</label> <input type="text"
																	class="form-control" id="prPincode" name="prPincode"
																	placeholder="Please Enter pincode" autocomplete="off"
																	maxlength="6">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Permanent MobileNo</label> <input
																	type="text" class="form-control" id="prMobileNo"
																	name="prMobileNo"
																	placeholder="Please Enter Permanent MobileNo">
															</div>
														</div>
													</div>
												</div>
												<button type="button" name="next"
													class="btn btn-primary next action-button float-end"
													value="Next">Next</button>
												<button type="button" name="previous"
													class="btn btn-dark previous action-button-previous float-end me-1"
													value="Previous">Previous</button>
											</fieldset>


											<!-- Other Information -->
											<fieldset>
												<div class="form-card text-start">
													<div class="row">
														<div class="col-lg-7 col-md-7 col-sm-12 col-12">
															<h3 class="custom-tab-title">Previous School
																Information:</h3>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-12">
															<h2 class="steps">Step 4 - 5</h2>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">School Name </label> <select
																	class="form-select" id="prevSchoolName"
																	name="prevSchoolName" tabindex="7">
																	<option value="-1">Please Select Your Previous
																		School</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Class </label> <select class="form-select"
																	id="prevClass" name="prevClass" tabindex="7">
																	<option value="-1">Please Select Your Previous
																		Class</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">TC No </label> <input type="text"
																	class="form-control" id="tcNo" name="tcNo"
																	placeholder="Please Enter TC No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">TC Date </label> <input type="date"
																	class="form-control" id="tcDate" name="tcDate"
																	placeholder="Please Enter TC Date">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Syllabus </label> <input type="text"
																	class="form-control" id="prevSyllabus"
																	name="prevSyllabus"
																	placeholder="Please Enter Previous Syllabus">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Leaving Reason</label> <input type="text"
																	class="form-control" id="leavingReason"
																	name="leavingReason"
																	placeholder="Please Enter Your Leaving Reason">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Address </label>
																<textarea class="form-control" id="prevAddress"
																	placeholder="Please Enter Previous Address"
																	name="prevAddress" autocomplete="off"></textarea>
															</div>
														</div>

														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Boarding's
																	Information:</h3>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Board Reg No </label>. <input type="text"
																	class="form-control" id="boardRegNo" name="boardRegNo"
																	placeholder="Please Enter Board Reg No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Select Boarding Category</label> <select
																	class="form-select" id="boardingCategory"
																	name="boardingCategory" tabindex="7">
																	<option value="-1">Please Select Boarding
																		Category</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Board Roll No </label>. <input type="text"
																	class="form-control" id="boardRollNo"
																	name="boardRollNo"
																	placeholder="Please Enter Board Roll No">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Select Board</label> <select
																	class="form-select" id="board" name="board"
																	tabindex="7">
																	<option value="-1">Please Select Board</option>
																</select>
															</div>
														</div>

														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Transportation
																	Information:</h3>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">With Effect From<span
																	class="mandatory">*</span></label> <input type="date"
																	class="form-control" id="startDate" name="startDate"
																	autocomplete="off" tabindex="1" />
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Transport Left Date<span
																	class="mandatory">*</span></label> <input type="date"
																	class="form-control" id="leftDate" name="leftDate"
																	autocomplete="off" tabindex="1" />
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Pick Up Route<span
																	class="mandatory">*</span></label> <select name="pickRoute"
																	id="pickRoute" class="form-control">
																	<option value="-1">Select Pick Up Route</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Pick Up Stop<span
																	class="mandatory">*</span></label> <select name="pickStop"
																	id="pickStop" class="form-control">
																	<option value="-1">--Select Pick Up Stop
																		Name---</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Drop Route<span class="mandatory">*</span></label>
																<select name="dropRoute" id="dropRoute"
																	class="form-control">
																	<option value="-1">--Select Drop Route Name---</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Drop Stop<span class="mandatory">*</span></label>
																<select name="dropStop" id="dropStop"
																	class="form-control">
																	<option value="-1">--Select Drop Stop Name---</option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Remark</label>
																<textarea id="remark" name="remark" rows="2" cols="50"
																	class="form-control"> </textarea>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Language Known </label>.
																	<label class="checkbox-inline"> <input
																		type="checkbox" name="languageKnown[]">
																		English &nbsp <input type="checkbox"
																		name="languageKnown[]"> Hindi &nbsp <input
																		type="checkbox" name="languageKnown[]">
																		Marathi &nbsp <input type="checkbox"
																		name="languageKnown[]"> Gujarati &nbsp
																	</label>
															</div>
														</div>


														<div class="row">
															<div class="col-lg-7 col-md-7 col-sm-12 col-12">
																<h3 class="custom-tab-title">Other Information:</h3>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Hobbies <span class="mandatory">*</span></label>
																<input type="text" class="form-control" id="hobbies"
																	name="hobbies" placeholder="Please Enter Hobbies">
															</div>
														</div>
														<div class="col-lg-4 col-md-6 col-sm-12 col-12">
															<div class="form-group">
																<label for="">Language Known </label> <label
																	class="checkbox-inline"> <input type="checkbox"
																	name="languageKnown[]"> English &nbsp <input
																	type="checkbox" name="languageKnown[]"> Hindi
																	&nbsp <input type="checkbox" name="languageKnown[]">
																	Marathi &nbsp <input type="checkbox"
																	name="languageKnown[]"> Gujarati &nbsp
																</label>

															</div>
														</div>

													</div>
												</div>
												<button type="button" name="next"
													class="btn btn-primary next action-button float-end"
													value="Submit">Submit</button>
												<button type="button" name="previous"
													class="btn btn-dark previous action-button-previous float-end me-1"
													value="Previous">Previous</button>
											</fieldset>
											<fieldset>
												<div class="form-card text-start">
													<div class="row">
														<div class="col-lg-7 col-md-7 col-sm-12 col-12">
															<h3 class="custom-tab-title">Finish:</h3>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-12">
															<h2 class="steps">Step 5 - 5</h2>
														</div>
													</div>

													<h2 class="text-center text-success">
														<strong>SUCCESS !</strong>
													</h2>

													<div class="row justify-content-center">
														<div class="col-lg-3 col-md-3 col-sm-3 col-3">
															<img src="assets/images/img-success.png"
																class="img-fluid" alt="fit-image">
														</div>
													</div>

													<div class="row justify-content-center">
														<div class="col-lg-12 col-md-12 col-sm-12 col-12">
															<h5 class="text-center">You Have Successfully Signed
																Up</h5>
														</div>
													</div>
												</div>
											</fieldset>
										</form>
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

<!-- Form Wizard Start -->
<script src="assets/vendor/formwizard/form-wizard.js"></script>
<!-- Form Wizard End -->
