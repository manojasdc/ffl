<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">

<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/dev_module_list/FFL/view_registration.js"></script>
<script src="assets/dev_module_list/FFL/AESGCM.js"></script>
<!-- <link rel="stylesheet" href="https://cdn.lineawesome.com/1.3.0/line-awesome/css/line-awesome.min.css"> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->



<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="registrationdiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Registration Details</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href=${dashboardurl}>Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Registration
										Details</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>


			<section class="single-detail-block" id="kak">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-12">
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
							<div class="card-header">
								<div class="header-title">
									<h4 class="card-title">Registration Details</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="registrationtbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th data-orderable="false">Sr No.</th>
													<th>Alumni Name</th>
													<th>Email ID</th>
													<th>Contact No</th>
													<th>Passout Year</th>
													<th>Course No</th>
													<th>Institute Name</th>
													<th>Country Name</th>
													<th>Registration Status</th>
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

</div>