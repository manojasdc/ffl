<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/dev_module_list/quill.js"></script>
<!-- <script src="assets/dev_module_list/quill-emoji.js"></script> -->
<!-- <script src="assets/dev_module_list/tinymce.min.js"></script> -->

<link href="assets/dev_module_list/css/quill.snow.css" rel="stylesheet">
<link href="assets/dev_module_list/css/theme.css" rel="stylesheet">
<!-- <link href="assets/dev_module_list/css/quill.snow.css" rel="stylesheet"> -->

<!-- <link href="assets/dev_module_list/css/quill.core.css" rel="stylesheet"> -->
<!-- <link href="assets/dev_module_list/css/quill-emoji.css" rel="stylesheet"> -->
<link href="assets/dev_module_list/css/editor.css" rel="stylesheet">
<!-- <link href="assets/dev_module_list/css/css_all.min.css" rel="stylesheet"> -->
<!-- <script src="assets/dev_module_list/quill.min.js"></script> -->
<!-- <script src="assets/dev_module_list/quill.core.js"></script> -->
<!-- <script src="assets/dev_module_list/quill.core.min.js"></script> -->



<script src="assets/dev_module_list/demorich.js"></script>

<!-- <script src="assets/dev_module_list/froala_editor.pkgd.min.js"></script> -->

<!-- <link href="assets/dev_module_list/css/froala_editor.pkgd.min.css" rel="stylesheet"> -->

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
						<h1 class="page-title">Form Control</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">Demo
									Page</li>
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
							<h4 class="card-title">RICH TEXT BOX</h4>
						</div>
					</div>


					<div class="card-body custom-field-block">
						<div class="row">


							<input type="hidden" id="actiontype" name="actiontype"
								value="add"> <input type="hidden" id="id" name="id"
								value="0">
							<div class="row">
								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group " role="group" aria-label="Photo">
										<label>Upload File<span class="mandatory">*</span></label> <input
											type="file" id="upload_file" name="upload_file"
											class="form-control" multiple="multiple">

									</div>
									<!-- 									<div id="fileViewContainer"></div> -->
								</div>


							</div>
							<div class="row">


								<div class="form-group">
									<label>Rich Text Box<span class="mandatory">*</span></label>
									<div id="editor" class="editor"></div>
								</div>

							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="btn-bottom">

									<button type="button" class="btn btn-info btnsubmit"
										id="savebtn" name="savebtn">Submit</button>

									<button type="button" class="btn btn-secondary btnsubmit"
										id="resetbtn"">Reset</button>
									<!--  <button type="button" class="btn btn-success btnsave">Save</button>-->
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
								<h4 class="card-title">Rich Text Title</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<table id="richtexttbl"
										class="table data-table table-striped table-hover custom-datatable datatable-responsive"
										width="100%">
										<thead>
											<tr>
												<th class="table-block-sm">Sr No.</th>
												<th>Content</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
										<tfoot>
											<tr>
												<th>Sr No.</th>
												<th>Content</th>
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










