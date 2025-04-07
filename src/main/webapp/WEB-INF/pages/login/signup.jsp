.<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- <script src="admin/assets/js/outerjs/togglepassword.js"></script> -->

<link rel="stylesheet"
	href="admin/assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet"
	href="admin/assets/vendor/dropDown/custom-select2.css">
<script src="admin/assets/vendor/dropDown/select2.min.js"></script>
<script src="admin/assets/vendor/dropDown/custom-select2.js"></script>
<script src="admin/assets/dev_module_list/registration.js"></script>
<script src="admin/assets/dev_module_list/FFL/AESGCM.js"></script>
<script src="admin/assets/dev_module_list/CommonValidation.js"></script>


<sec:csrfMetaTags />
<div id="registrationdiv">
	<div class="main-page-content custom-signin-page" id="top">
		<div class="custom-main-breadcrum">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="custom-breadcrum">
							<div class="iq-members">
								<h1 class="page-title">Sign Up</h1>
							</div>
							<div class="page-breadcrumb">
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item"><a href="landing">Home</a></li>
										<li class="breadcrumb-item active" aria-current="signin">Sign
											Up</li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="contact-us section custom-contact-block">
			<div class="container">
				<div class="background-header-sticky">
					<div class="row">

						<div
							class="col-lg-6 col-md-12 col-sm-12 col-12 align-self-center order-lg-1 order-2">
							<div class="section-heading">
								<!-- 							<h6>Sign In to Explore More</h6> -->
								<!-- 							<h2>Sign In to Explore More</h2> -->
								<div class="special-offer">
									<span class="offer"><em><i class="fa fa-user-check"></i></em></span>
									<h4>
										<em>Already User ?</em>
									</h4>
									<h6>
										Click Here For <em>Sign In</em>
									</h6>
									<a href="signin"><i class="fa fa-angle-right"></i></a>
								</div>
							</div>
						</div>
						
						<div
													class="col-lg-12 col-md-12 col-sm-12 col-12 order-lg-2 order-1">
													<input type="hidden" id="actiontype" name="actiontype"
														value="add">
													<div class="contact-us-content">
														<h2 class="sign-up-content-label">Sign Up</h2>
														<div class="row">
														
															<input type="hidden" id="salt" name="salt" /> <input
																type="hidden" id="iv" name="iv" /> <input type="hidden"
																id="key" name="key" />
																
															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																<div class="form-group">
																	<label for="username">Alumni Name<span
																		class="mandatory">*</span></label> <input type="text"
																		name="alumniName" id="alumniName" class="form-control"
																		placeholder="Enter Alumni Name" autocomplete="off">
																</div>
															</div>
															
															
															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																<div class="form-group">
																	<label for="username">Email Id<span class="mandatory">*</span></label>
																	<input type="email" name="emailId" id="emailId"
																		class="form-control" placeholder="Enter Email Id"
																		autocomplete="off">
																</div>
															</div>
															
															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																															<div class="form-group">
																																<label for="username">User ID<span class="mandatory">*</span></label>
																																<input type="text" name="Username" id="Username"
																																	class="form-control" placeholder="Enter User ID"
																																	autocomplete="off">
																															</div>
																														</div>
																														
																														<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																																														<div class="form-group">
																																															<label for="Password">Password<span class="mandatory">*</span></label>
																																															<input type="password" name="passsWord" id="passsWord"
																																																class="form-control" placeholder="Enter Password"
																																																autocomplete="off">
																																														</div>
																																													</div>															
															

															
															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																<div class="form-group">
																	<label>Country Name<span class="mandatory">*</span></label> 
																	<select class="searchwithselect form-control" id="countryId" name="countryId">
																	</select>
																</div>
															</div>

															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																<div class="form-group">
																	<label for="username">Contact No.<span
																		class="mandatory">*</span></label>	
																	<div class="d-flex">											
																		<input type="text"
																		name="contactPrefix" id="contactPrefix" class="form-control w-20"
																		placeholder="+"
																		>
																		
																		&nbsp
																		<input type="text"
																		name="contactNumber" id="contactNumber" class="form-control"
																		placeholder="Enter Contact No." maxlength="10"
																		autocomplete="off">
																    </div>		
																</div>
															</div>
															
															<div class="col-lg-6 col-md-6 col-sm-12 col-12">
																<div class="form-group" id="optradio1">
																	<label for="">Gender <span class="mandatory">*</span></label><br>
																	<input type="radio" value="Male" name="gender"> <span
																		style="color: white;">Male</span> <input type="radio"
																		value="Female" name="gender"> <span
																		style="color: white;">Female</span> <!--<input type="radio"
																		value="Other" name="gender"> <span
																		style="color: white;">Other</span>-->

																</div>
															</div>

														</div>


								<div class="col-lg-12 col-md-12 col-sm-12 col-12" id="bookiddiv">
									<h6 class="custom-card-subtitle" style="color: white;">Add
										Other Details</h6>
									<div class="table-responsive">
										<table class="table table-hover table-striped basic-table">
											<thead>
												<tr>
													<!-- 													<th class="table-block-sm">Sr No.</th> -->
													<th>Institute<span style="color: red;"
														class="mandatory">*</span>
													</th>
													<th>Course Name & Number<span style="color: red;"
														class="mandatory">*</span>
													</th>
													<th>Pass Out Year<span style="color: red;"
														class="mandatory">*</span>
													</th>
													<!-- 													<th>Action</th> -->
												</tr>
											</thead>
											<tbody id="bkreport">
												<input type="hidden" id="actiontype1" name="actiontype1"
													value="add">
												<input type="hidden" id="id" name="id" value="0">
												<input type="hidden" id="actiontype1" name="actiontype1"
													value="add">
												<tr id="bookreport_" class="CommonLibraryBookClass">
													<!-- 													<td class="table-block-sm">1</td> -->

													<td>
														<div class="form-group">
															<select name="instituteId_1"
																class="singleselect form-control instituteclass"
																id="instituteId_1">
																<option value="-1">---Select Institute---</option>

															</select>
														</div>
													</td>


													<td>
														<div class="form-group">
															<input type="text" class="form-control" id="rollNumber_1"
																placeholder="Enter Course No." name="rollNumber_1"
																autocomplete="off" tabindex="1" maxlength="10">
														</div>
													</td>

													<td>
														<div class="form-group">
															<!-- 															<input type="text" class="form-control" -->
															<!-- 																id="passoutYear_1" placeholder="Enter Pass Out year" -->
															<!-- 																name="passoutYear_1" autocomplete="off" tabindex="1"> -->

															<select name="passoutYear_1"
																class="singleselect form-control " id="passoutYear_1">
																<option value="-1">---Select Passout Year---</option>
															</select>

														</div>

													</td>

													<td>
														<ul class="custom-btn-group btn-group-sm">
															<li class="list-inline-item">
																<button type="button"
																	class="btn btn-info icon-btn btnadd" title="Add">
																	<i class="ri-add-line"></i>
																</button>
															</li>
														</ul>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
									<button type="submit" id="signUpButton" name="signUpButton"
										class="btn btn-a" title="Sign up">Sign Up</button>
								</div>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>