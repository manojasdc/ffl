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
<script src="assets/dev_module_list/FFL/whatsnewscrollapproval.js"></script>
<script src="assets/dev_module_list/CommonValidation.js"></script>


<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

<div id="activitydiv">
	<div class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Whats new data</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="demo_page">Whats new data</li>
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
									<h4 class="card-title">Whats new Data</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-12">
										<table id="whatsnewtbl"
											class="table data-table table-striped table-hover custom-datatable datatable-responsive"
											width="100%">
											<thead>
												<tr>
													<th>No</th>
													<th>Picture Description</th>
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
				<input id="idwhatsnewscroll1" name="idwhatsnewscroll1" value="${mapid}" hidden> 



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



			<!-- 			</div> -->
		</div>

	</div>