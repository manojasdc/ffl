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
<script src="assets/dev_module_list/FFL/picture_gallary.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>



<div id="journaldiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Picture Gallery</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Picture
										Gallery</li>
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
								<h4 class="card-title" id="titleupdate">Picture Gallery</h4>
							</div>
						</div>
						<div class="card-body custom-field-block">
							<div class="row">

								<input type="hidden" id="actiontype" name="actiontype"
									value="add"> <input type="hidden" id="id" name="id"
									value="0">

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Picture Category<span class="mandatory">*</span></label>
										<select name="category" id="category" class="form-control">
											<option value="-1">----Select Picture Category----</option>
											<option value="Tech-Hackathon">Tech-Hackathon</option>
											<option value="Graduation Ceremony">Graduation
												Ceremony</option>
											<option value="Cultural Festival">Cultural Festival</option>
											<option value="Guest Lecture">Guest Lecture</option>
											<option value="Seminar">Seminar</option>
											<option value="Sports Event">Sports Event</option>
											<option value="Gym and Fitness">Gym and Fitness</option>
											<option value="Art & Craft">Art & Craft</option>
											<option value="Miscellaneous Activity">Miscellaneous Activity</option>
										</select>
									</div>
								</div>



								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Picture Description<span class="mandatory">*</span></label>
										<input class="form-control" type="text"
											placeholder="Enter Picture Description" id="description"
											name=description>
									</div>
								</div>

								<div class="col-lg-4 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label>Upload Picture <span class="mandatory">*</span></label>
										<input type="file" class="form-control"
											accept=".jpg,.jpeg,.png,.pdf" id="imageUpload"
											name="imageUpload" autocomplete="off" maxlength="256"
											tabindex="2"> <a href='#' id="viewimage"
											name="viewimage" class="fa fa-download form-group"></a>
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


			<section class="single-detail-block">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<div class="card-header">
								<div class="header-title">
									<h4 class="card-title">Photo Gallery Details</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="photogallarytbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th data-orderable="false">Sr No.</th>
													<th>Picture Description</th>
													<th>Picture Category</th>
													<th>Show Document</th>
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
			<input id="idejournal1" name="idejournal1" value="${mapid}" hidden>

		</div>

	</div>