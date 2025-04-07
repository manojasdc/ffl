<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<link rel="stylesheet" href="assets/dev_module_list/css/ejournal.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>

<script src="assets/dev_module_list/FFL/alumniapproval.js"></script>


<div id="halloffamediv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Alumni Approval</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Alumni Approval</li>
								</ol>
							</nav>
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
									<h4 class="card-title">Alumni Data</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="alumnitbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th>No</th>
													
													<th>Line 1</th>
													<th>Line 2</th>
													<th>Country</th>
													<th>State</th>
													<th>City</th>
													<th>Pin Code</th>
													<th>Profile Picture</th>
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
			<input id="idalumni1" name="idalumni1" value="${mapid}" hidden>


			<!-- Modal -->
<!-- 			<div class="modal fade" id="PDFModal" tabindex="-1" role="dialog" -->
<!-- 				aria-labelledby="PDFModalLabel" aria-hidden="true"> -->
<!-- 				<div class="modal-dialog modal-lg"> -->
<!-- 					<div class="modal-content"> -->
<!-- 						<div class="modal-header"> -->
<!-- 							<h6 class="modal-title" id="PDFModalLabel">PDF Viewer</h6> -->
<!-- 						</div> -->
<!-- 						<div class="modal-body"> -->
<!-- 							<div id="flip-container"></div> -->
<!-- 						</div> -->
<!-- 						<div class="modal-footer"> -->
<!-- 							<button type="button" class="close" data-dismiss="modal" -->
<!-- 								aria-label="Close"> -->
<!-- 								Close <span aria-hidden="true">&times;</span> -->
<!-- 							</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 		</div> -->
	</div>

</div>