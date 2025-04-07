
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/dev_module_list/thoughtoftheday.js"></script>
<!-- <script src="assets/dev_module_list/CommonValidation.js"></script>
<script src="assets/dev_module_list/jquery.blockUI.js"></script>
<script src="assets/dev_module_list/jquery-confirm.min.js"></script> -->

<!-- Dashboard Style end -->

<div class="content-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">Thought of the day Master</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">Thought
									of the day</li>
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
							<h4 class="card-title">Add Thought Of The Day</h4>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">
							<div class="col-6 col-sm-6 col-md-6 col-lg-4">
								<div class="input-style-2 mb-0">
									<h5 class="mb-2">Choose Any One</h5>
								</div>
								<div class="input-style-form-check">
									<div class="form-check radio-style">
										<input type="radio" class="form-check-input upload"
											id="Upload" name="Choise" value="Upload"> <label
											for="Upload" class="form-check-label">Upload Through
											Excel</label>
									</div>
									<div class="form-check radio-style">
										<input type="radio" class="form-check-input fill"
											id="Fillform" name="Choise" value="Fillform"
											checked="checked"> <label class="form-check-label"
											for="Fill">Fill Up Form</label>
									</div>
								</div>
								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0">
							</div>
						</div>

						<div id="fillform" class="hide1">
							<div class="row">


								<div class="col-lg-4 col-md-6 col-sm-6 col-6">
									<div class="form-group">
										<label>Thought of the day<span class="mandatory">*</span></label>
										<input id="thought" name="thought" class="form-control"
											type="text" placeholder="Enter Thought Of the day">
									</div>
								</div>
							</div>
						</div>

						<div id="UploadExcel" class="hide2">
							<div class="row">



								<div class="col-6 col-sm-6 col-md-6 col-lg-4">
									<div class="input-style-2">
										<label>Upload Excel<span class="mandatory">*</span></label> <input
											type="file" class="form-control"
											placeholder="upload your document" name="thoughtdoc"
											id="thoughtdoc" tabindex="5" accept=".xls,.xlsx"> <a
											href="assets/thought.xls" id='downlaod' name='downlaod'
											tabindex="4" class="main-btn info-btn square-btn btn-hover">
<!-- 											<i class="fa fa-download mr-5"></i> -->
										</a>
									</div>
									<!-- end input -->
								</div>
							</div>
						</div>

						<div class="col-lg-12 col-md-12 col-sm-12 col-12">
							<div class="btn-bottom">

								<button type="button" class="btn btn-info btnsubmit"
									id="thoughtbtn" name="thoughtbtn">Submit</button>

								<button type="button" class="btn btn-secondary btnsubmit"
									id="resetbtn"">Reset</button>

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
								<h4 class="card-title">Thought Of the Day Data</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<table id="thoughtofthedaytbl"
										class="table data-table table-striped table-hover custom-datatable datatable-responsive"
										width="100%">
										<thead>
											<tr>
												<th class="table-block-sm">Sr No.</th>
												<th>Thought Of The Day</th>
												<th>Action</th>

											</tr>
										</thead>
										<tbody>

										</tbody>
										<tfoot>
											<tr>
												<th>Sr No.</th>
												<th>Thought Of The Day</th>
												<th>Action</th>
											</tr>
										</tfoot>
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

