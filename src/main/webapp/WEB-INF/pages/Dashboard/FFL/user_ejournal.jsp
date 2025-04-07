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
<script src="assets/dev_module_list/FFL/userejournal.js"></script>

<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="journaldiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">E-journal</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">E-journal</li>
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
								<h4 class="card-title" id="titleupdate">E-journal</h4>
							</div>
						</div>
						<div class="card-body custom-field-block">
							<div class="row">

								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0">

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Journal Title<span class="mandatory">*</span></label> <input
											class="form-control" type="text" maxlength="100"
											placeholder="Enter Journal Title" id="name" name=name>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Journals Description<span class="mandatory">*</span></label>
										<input class="form-control" type="text" maxlength="125"
											placeholder="Enter Journal Description" id="description"
											name=description>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Journals Category<span class="mandatory">*</span></label>
										<input class="form-control" type="text" maxlength="125"
											placeholder="Enter Journal Category" id="category"
											name=category>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Publisher<span class="mandatory">*</span></label> <input
											class="form-control" type="text" maxlength="125"
											placeholder="Enter Journal Publisher" id="publisher"
											name=publisher>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Publisher Date<span class="mandatory">*</span></label>
										<input type="date" class="form-control" id="publisherDate"
											placeholder="yyyy mm dd" data-date=""
											data-date-format="YYYY MM DD" name="publisherDate"
											autocomplete="off">
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Language<span class="mandatory">*</span></label> <input
											class="form-control" type="text" maxlength="100"
											placeholder="Enter Journal Language" id="language"
											name=language>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Book Length<span class="mandatory">*</span></label> <input
											class="form-control" type="text"
											placeholder="Enter Book Length" id="bookLength"
											name=bookLength>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Cover Photo<span class="mandatory">*</span></label> <input
											type="file" class="form-control" accept=".jpg,.jpeg,.png"
											id="coverPhoto" name="coverPhoto" autocomplete="off"
											maxlength="256" tabindex="2"> <a href='#'
											id="viewimage1" name="viewimage1"
											class="fa fa-download form-group"></a>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Upload Journal PDF<span class="mandatory">*</span></label>
										<input type="file" class="form-control"
											accept=".jpg,.jpeg,.png,.pdf" id="uploadPdf" name="uploadPdf"
											autocomplete="off" maxlength="256" tabindex="2"> <a
											href='#' id="viewimage" name="viewimage"
											class="fa fa-download form-group"></a>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Author Name<span class="mandatory">*</span></label> <input
											class="form-control" type="text" placeholder="Enter Author Name"
											id="author" name=author maxlength="100">
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="btn-bottom">
										<button type="button" class="btn btn-info btnsubmit"
											id="journalbtn" name="journalbtn">Submit</button>
										<button type="button" class="btn btn-secondary btnsubmit"
											id="reset">Reset</button>
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
									<h4 class="card-title">E-journal Details</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="journaltbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th data-orderable="false"><b>Sr No.</b></th>
													<th>Journal Title</th>
													<th>Journal Description</th>
													<th>Author Name</th>
													<th>Journal Category</th>
													<th>Book PDF</th>
													<!-- 													<th>Journal Rejected Remarks</th> -->
													<th>Publisher</th>
													<th>Publisher Date</th>
													<th>Language</th>
													<th>Book Length</th>
													<th>Cover Photo</th>
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