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
<script src="assets/dev_module_list/FFL/newsLetter.js"></script>

<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="journaldiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">News Letter</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">News
										Letter</li>
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
								<h4 class="card-title" id="titleupdate">News Letter</h4>
							</div>
						</div>
						<div class="card-body custom-field-block">
							<div class="row">

								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0">

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>News Letter Name<span class="mandatory">*</span></label>
										<input class="form-control" type="text"
											placeholder="Enter News Letter Name" id="name" name="name">
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>News Letter Description<span class="mandatory">*</span></label>
										<input class="form-control" type="text"
											placeholder="Enter News Letter Description" id="description"
											name=description>
									</div>
								</div>


								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Upload News Letter<span class="mandatory">*</span></label>
										<input type="file" class="form-control"
											accept=".jpg,.jpeg,.png,.pdf" id="uploadPdf" name="uploadPdf"
											autocomplete="off" maxlength="256" tabindex="2"> <a
											href='#' id="viewimage" name="viewimage"
											class="fa fa-download form-group"></a>
									</div>
								</div>

								<!-- 								<div class="col-lg-6 col-md-6 col-sm-12 col-12"> -->
								<!-- 															<div class="form-group"> -->
								<!-- 																<label for="">Upload Photo </label> <input type="file" -->
								<!-- 																	id="staffphoto" name="staffphoto" class="form-control" -->
								<!-- 																	accept=".jpg,.jpeg,.png"> <a href='#' -->
								<!-- 																	id="viewimage" name="viewimage" -->
								<!-- 																	class="fa fa-download form-group"></a> -->
								<!-- 															</div> -->
								<!-- 														</div> -->

								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="btn-bottom">
										<button type="button" class="btn btn-info btnsubmit"
											id="submitbtn" name="submitbtn">Submit</button>
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

			<section class="single-detail-block" id="kak">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<div class="card-header">
								<div class="header-title">
									<h4 class="card-title">News Letter Details</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="datatbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th data-orderable="false">Sr No.</th>
													<th>News Letter Name</th>
													<th>News Letter Description</th>
													<th>Show Document</th>
													<!-- 													<th>Rejected Remarks</th> -->
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