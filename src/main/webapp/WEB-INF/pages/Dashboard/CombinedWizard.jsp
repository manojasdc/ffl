<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="layout_file/RBAC/studentmaster.js"></script>
<script src="layout_file/js/CommonValidation.js"></script>
<script src="layout_file/js/commondropdown.js"></script>

<!-- Form Wizard Start -->
<link rel="stylesheet"
	href="assets/vendor/formwizard/custom-formwizard.css">
<!-- Form Wizard End -->

<div id="studentmasterdiv">
	
	<div class="container mt-4">
	
		<a type="button" href="StudentMaster" class="btn ws-lightgreen mb-2" id="studentmaster" name="studentmaster">All Student Data</a>
		<div class="col-12">
			<div
				class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
				<h5 class="m-0">Student Detail Master</h5>
			</div>
		</div>
		<div class="container-fluid w3-border w3-round w3-padding  ws-grey mb-3 main-form">
			<div class="row">
				<input type="hidden" id="actiontype" name="actiontype" value="add">
				<input type="hidden" id="stuId" name="stuId" value="0">
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Profile Pic </label>
						<input type="file" class="form-control" id="profilePic" name="profilePic">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Roll No *</label>
						<input type="text" class="form-control" id="rollNo"
							placeholder="Please Enter Roll No" name="rollNo"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Addmission No *</label>
						<input type="text" class="form-control" id="admissionNo"
							placeholder="Please Enter admissionNo" name="admissionNo"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Addmission Date *</label>
						<input type="date" class="form-control" id="admissionDate"
							placeholder="Please Enter Date Of Admission" name="admissionDate"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">First Name *</label>
						<input type="text" class="form-control" id="firstName"
							placeholder="Please Enter First Name" name="firstName"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Middle Name *</label>
						<input type="text" class="form-control" id="middleName"
							placeholder="Please Enter Middle Name" name="middleName"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Last Name *</label>
						<input type="text" class="form-control" id="lastName"
							placeholder="Please Enter Last Name" name="lastName"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Admission type *</label>
						<select class="form-select" id="admissionType" name="admissionType"
							tabindex="7">
							<option value="-1">Please Select Admission Type</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Student Date of Join *</label>
						<input type="date" class="form-control" id="dateOfJoin"
							placeholder="Please Enter Date Of Join" name="dateOfJoin"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Class Name </label>
						<select class="form-select" id="classId" name="classId"
							tabindex="7">
							<option value="-1">Please Select Class</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Section </label>
						<select class="form-select" id="sectionId" name="sectionId"
							tabindex="7">
							<option value="-1">Please Select Section</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Stream </label>
						<select class="form-select" id="streamId" name="streamId"
							tabindex="7">
							<option value="-1">Please Select Stream</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Fee Group </label>
						<select class="form-select" id="feeGroup" name="feeGroup"
							tabindex="7">
							<option value="-1">Please Select Fee Group</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Email Address </label>
						<input type="email" class="form-control" id="emailId"
							placeholder="Please Enter Email address" name="emailId"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mobile No *</label>
						<input type="text" class="form-control" id="mobileNo"
							placeholder="Please Enter Mobile Number" name="mobileNo"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">SMS Mobile No *</label>
						<input type="text" class="form-control" id="smsMobileNo"
							placeholder="Please Enter SMS Mobile Number" name="smsMobileNo"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Emergency Mobile No </label>
						<input type="text" class="form-control" id="emeMobileNo"
							placeholder="Please Enter Emergency Mobile Number" name="emeMobileNo"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Date Of Birth *</label>
						<input type="date" class="form-control" id="dateOfBirth"
							placeholder="Please Enter Date Of Birth" name="dateOfBirth"
							autocomplete="off" maxlength="128" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Gender *</label>
						<fieldset id="gender" class="form-control">
					    	<input type="radio" value="M" name="gender"> Male
					    	<input type="radio" value="F" name="gender"> Female
					    	<input type="radio" value="O" name="gender"> Other
					  	</fieldset>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Blood_Group </label>
						<select class="form-select" id="bloodGroup" name="bloodGroup">
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
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Nationality *</label>
						<select class="form-select" id="nationality" name="nationality"
							tabindex="7">
							<option value="-1">Please Select nationality</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Religion *</label>
						<select class="form-select" id="religionId" name="religionId">
							<option value="-1">Please Select Religion</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Cast </label>
						<select class="form-select" id="castId" name="castId">
							<option value="-1">Please Select nationality</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother_Tongue </label>
						<select class="form-select" id="motherTongue" name="motherTongue">
							<option value="-1">Please Select Mother_Tongue</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Adhar Card Number *</label>
						<input type="text" class="form-control" id="aadharNo" name="aadharNo" placeholder="Please Enter Adhar Number"
							autocomplete="off" maxlength="12" tabindex="1">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Area *</label>
						<input type="text" class="form-control" id="area" name="area" placeholder="Please Enter Area">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Country </label>
						<select class="form-select" id="country" name="country" tabindex="7">
							<option value="-1">Please Select Your Country</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">State </label>
						<select class="form-select" id="stateId" name="stateId" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">City </label>
						<select class="form-select" id="cityId" name="cityId" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Address </label>
						<textarea class="form-control" id="address"
							placeholder="Please Enter Address" name="address"
							autocomplete="off"></textarea>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">pincode</label>
						<input type="text" class="form-control" id="pincode" name="pincode" placeholder="Please Enter pincode"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">House *</label>
						<select class="form-select" id="houseId" name="houseId"
							tabindex="7">
							<option value="-1">Please Select House</option>
						</select>
					</div>
				</div>		
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Quota </label>
						<select class="form-select" id="quota" name="quota"
							tabindex="7">
							<option value="-1">Please Select Quota</option>
						</select>
					</div>
				</div>		
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Category </label>
						<select class="form-select" id="categoryId" name="categoryId"
							tabindex="7">
							<option value="-1">Please Select Category</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Sub-Category </label>
						<select class="form-select" id="subCategoryId" name="subCategoryId"
							tabindex="7">
							<option value="-1">Please Select Sub-Category</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Join In Class *</label>
						<select class="form-select" id="joinClass" name="joinClass"
							tabindex="7">
							<option value="-1">Please Select Join Class</option>
						</select>
					</div>
				</div>

				<div class="col-12">
					<div class="col-12 col-lg-12 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Parent's Detail Master</h5>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Fee no</label>
						<input type="text" class="form-control" id="feeNo" name="feeNo" placeholder="Please Enter Fee No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">ParentID</label>
						<input type="text" class="form-control" id="parentId" name="parentId" placeholder="Please Enter Parent ID">
					</div>
				</div>
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Father Detail</h5>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Father's Profile Pic </label>
						<input type="file" class="form-control" id="fProfilepic" name="fProfilepic">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">`
						<label for="">Mother's Profile Pic </label>
						<input type="file" class="form-control" id="mProfilepic" name="mProfilepic">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Guardian's Profile Pic </label>
						<input type="file" class="form-control" id="gProfilepic" name="gProfilepic">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Father's Title </label>
						<select class="form-select" id="fTitle" name="fTitle" tabindex="7">
							<option value="-1">Please Select Father Title</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Father's Name</label>
						<input type="text" class="form-control" id="fName" name="fName" placeholder="Please Enter fatherName">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Father's Email</label>
						<input type="email" class="form-control" id="fEmail" name="fEmail" placeholder="Please Enter Father's Email">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Qualification </label>
						<select class="form-select" id="fQualification" name="fQualification" tabindex="7">
							<option value="-1">Please Select Father Qualification</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Designation </label>
						<select class="form-select" id="fDesignation" name="fDesignation" tabindex="7">
							<option value="-1">Please Select Father Designation</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Organisation's Name</label>
						<input type="text" class="form-control" id="fOrgName" name="fOrgName" placeholder="Please Enter Organisation Name">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Organisation's Address</label>
						<input type="text" class="form-control" id="fOrgAddress" name="fOrgAddress" placeholder="Please Enter Organisation Address">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Country </label>
						<select class="form-select" id="fCountry" name="fCountry" tabindex="7">
							<option value="-1">Please Select Your Country</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">State </label>
						<select class="form-select" id="fState" name="fState" tabindex="7">
							<option value="-1">Please Select Your State</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">City </label>
						<select class="form-select" id="fCity" name="fCity" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Pincode</label>
						<input type="text" class="form-control" id="fPincode" name="fPincode" placeholder="Please Enter pincode"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Nationality </label>
						<select class="form-select" id="fNationality" name="fNationality"
							tabindex="7">
							<option value="-1">Please Select nationality</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Annual income</label>
						<input type="text" class="form-control" id="fAnnualIncome" name="fAnnualIncome" placeholder="Please Enter fAnnualIncome"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Service Number</label>
						<input type="text" class="form-control" id="fServiceNo" name="fServiceNo" placeholder="Please Enter father Service No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Telephone</label>
						<input type="text" class="form-control" id="fTelephoneNo" name="fTelephoneNo" placeholder="Please Enter fTelephoneNo"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Mobile Number</label>
						<input type="text" class="form-control" id="fMobileNo" name="fMobileNo" placeholder="Please Enter fMobileNo">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Rank</label>
						<input type="text" class="form-control" id="fRank" name="fRank" placeholder="Please Enter fRank"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Serving / Retired</label>
						<input type="text" class="form-control" id="fServingRetired" name="fServingRetired" placeholder="Please Enter fServingRetired">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Father's Date of Retirement</label>
						<input type="date" class="form-control" id="fDateOfRetirement" name="fDateOfRetirement">
					</div>
				</div>
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Mother's Detail</h5>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Mother's Title </label>
						<select class="form-select" id="mTitle" name="mTitle" tabindex="7">
							<option value="-1">Please Select Mother Title</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Mother's Name</label>
						<input type="text" class="form-control" id="mName" name="mName" placeholder="Please Enter fatherName">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Mother's Email</label>
						<input type="email" class="form-control" id="mEmail" name="mEmail" placeholder="Please Enter mother's Email">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Qualification </label>
						<select class="form-select" id="mQualification" name="mQualification" tabindex="7">
							<option value="-1">Please Select Father Qualification</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Designation </label>
						<select class="form-select" id="mDesignation" name="mDesignation" tabindex="7">
							<option value="-1">Please Select Father Designation</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Organisation's Name</label>
						<input type="text" class="form-control" id="mOrgName" name="mOrgName" placeholder="Please Enter Organisation Name">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Organisation's Address</label>
						<input type="text" class="form-control" id="mOrgAddress" name="mOrgAddress" placeholder="Please Enter Organisation Address">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Country </label>
						<select class="form-select" id="mCountry" name="mCountry" tabindex="7">
							<option value="-1">Please Select Your Country</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">State </label>
						<select class="form-select" id="mState" name="mState" tabindex="7">
							<option value="-1">Please Select Your State</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">City </label>
						<select class="form-select" id="mCity" name="mCity" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Pincode</label>
						<input type="text" class="form-control" id="mPincode" name="mPincode" placeholder="Please Enter pincode"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Nationality </label>
						<select class="form-select" id="mNationality" name="mNationality"
							tabindex="7">
							<option value="-1">Please Select nationality</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Annual income</label>
						<input type="text" class="form-control" id="mAnnualIncome" name="mAnnualIncome" placeholder="Please Enter fAnnualIncome"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Service Number</label>
						<input type="text" class="form-control" id="mServiceNo" name="mServiceNo" placeholder="Please Enter father Service No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Telephone</label>
						<input type="text" class="form-control" id="mTelephoneNo" name="mTelephoneNo" placeholder="Please Enter fTelephoneNo"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Mobile Number</label>
						<input type="text" class="form-control" id="mMobileNo" name="mMobileNo" placeholder="Please Enter fMobileNo">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Rank</label>
						<input type="text" class="form-control" id="mRank" name="mRank" placeholder="Please Enter fRank"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Serving / Retired</label>
						<input type="text" class="form-control" id="mServingRetired" name="mServingRetired" placeholder="Please Enter fServingRetired">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Mother's Date of Retirement</label>
						<input type="date" class="form-control" id="mDateOfRetirement" name="mDateOfRetirement">
					</div>
				</div>
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Guardian's Detail</h5>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Guardian's Name</label>
						<input type="text" class="form-control" id="gName" name="gName" placeholder="Please Enter Guardian's Name">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Guardian's Email</label>
						<input type="email" class="form-control" id="gEmail" name="gEmail" placeholder="Please Enter Guardian's Email">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="mb-3">
						<label for="">Relation with Student</label>
						<input type="text" class="form-control" id="gRelation" name="gRelation" placeholder="Please Enter Guardian's Name">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Guardian's Mobile No</label>
						<input type="text" class="form-control" id="gMobileNo" name="gMobileNo" placeholder="Please Enter Guardian's Mobile">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Guardian's Address </label>
						<textarea class="form-control" id="gAddress" placeholder="Please Enter Address" name="gAddress"
							autocomplete="off"></textarea>
					</div>
				</div>
				
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Permanent Address Detail</h5>
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Country </label>
						<select class="form-select" id="prCountry" name="prCountry" tabindex="7">
							<option value="-1">Please Select Your Country</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">State </label>
						<select class="form-select" id="prState" name="prState" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">City </label>
						<select class="form-select" id="prCityId" name="prCityId" tabindex="7">
							<option value="-1">Please Select Your City</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Address </label>
						<textarea class="form-control" id="prAddress"
							placeholder="Please Enter Address" name="prAddress"
							autocomplete="off"></textarea>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">pincode</label>
						<input type="text" class="form-control" id="prPincode" name="prPincode" placeholder="Please Enter pincode"
							autocomplete="off" maxlength="6" >
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Permanent MobileNo</label>
						<input type="text" class="form-control" id="prMobileNo" name="prMobileNo" placeholder="Please Enter Permanent MobileNo">
					</div>
				</div>
				
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Birth Detail</h5>
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Place of Birth </label>.
						<input type="text" class="form-control" id="birthPlace" name="birthPlace" placeholder="Please Enter Place of Birth">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Birth Country</label>
						<select class="form-select" id="birthCountry" name="birthCountry" tabindex="7">
							<option value="-1">Please Select Birth Country</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Certificate No</label>
						<input type="text" class="form-control" id="birthCertificateNo" name="birthCertificateNo" placeholder="Please Enter birth Certificate No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Certificate Date</label>
						<input type="date" class="form-control" id="birthCertificateDate" name="birthCertificateDate" placeholder="Please Enter birth Certificate No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Certificate corpoNo</label>
						<input type="text" class="form-control" id="birthCertificateCorpoNo" name="birthCertificateCorpoNo" placeholder="Please Enter birth Certificate Corpo No">
					</div>
				</div>
				<div class="col-12">
					<div class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Student's Previous School Details</h5>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">School Name </label>
						<select class="form-select" id="prevSchoolName" name="prevSchoolName" tabindex="7">
							<option value="-1">Please Select Your Previous School</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Class </label>
						<select class="form-select" id="prevClass" name="prevClass" tabindex="7">
							<option value="-1">Please Select Your Previous Class</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">TC No </label>
						<input type="text" class="form-control" id="tcNo" name="tcNo" placeholder="Please Enter TC No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">TC Date </label>
						<input type="date" class="form-control" id="tcDate" name="tcDate" placeholder="Please Enter TC Date">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Syllabus </label>
						<input type="text" class="form-control" id="prevSyllabus" name="prevSyllabus" placeholder="Please Enter Previous Syllabus">
					</div>	
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Leaving Reason</label>
						<input type="text" class="form-control" id="leavingReason" name="leavingReason" placeholder="Please Enter Your Leaving Reason">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Address </label>
						<textarea class="form-control" id="prevAddress"
							placeholder="Please Enter Previous Address" name="prevAddress" autocomplete="off"></textarea>
					</div>
				</div>
				<div class="col-12">
					<div class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Boarding Detail</h5>
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Board Reg No </label>.
						<input type="text" class="form-control" id="boardRegNo" name="boardRegNo" placeholder="Please Enter Board Reg No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Select Boarding Category</label>
						<select class="form-select" id="boardingCategory" name="boardingCategory" tabindex="7">
							<option value="-1">Please Select Boarding Category</option>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Board Roll No </label>.
						<input type="text" class="form-control" id="boardRollNo" name="boardRollNo" placeholder="Please Enter Board Roll No">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Select Board</label>
						<select class="form-select" id="board" name="board" tabindex="7">
							<option value="-1">Please Select Board</option>
						</select>
					</div>
				</div>
				
				<div class="col-12">
					<div
						class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
						<h5 class="m-0">Other Information</h5>
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Language Known </label>.
						 <fieldset class="form-control">      
							<label class="checkbox-inline">
								<input type="checkbox" name="languageKnown[]"> English &nbsp 
								<input type="checkbox" name="languageKnown[]"> Hindi &nbsp
								<input type="checkbox" name="languageKnown[]"> Marathi &nbsp
								<input type="checkbox" name="languageKnown[]"> Gujarati &nbsp
							</label>
					    </fieldset> 
					</div>
				</div>
				
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Hobbies *</label>
						<input type="text" class="form-control" id="hobbies" name="hobbies" placeholder="Please Enter Hobbies">
					</div>
				</div>
			</div>

			<div class="row m-0">
				<div
					class="col-12 mt-3 mb-3 w3-border w3-round w3-footer-padding ws-lightgreen text-center">
						<button type="button" class="btn btn-primary"id="btn-save" name="btn-save">Submit</button>
						<button type="reset" class="btn btn-success" id="btn-reset" name="btn-reset" value="Clear">Clear</button>
				</div>
			</div>
	</div>

</div>