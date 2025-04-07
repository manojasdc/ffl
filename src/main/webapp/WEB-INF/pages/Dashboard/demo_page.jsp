<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<!-- Select End -->


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
							<h4 class="card-title">Card Title</h4>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="form-group">
									<label>Normal Input<span class="mandatory">*</span></label> <input
										class="form-control" type="text" placeholder="Enter Input">
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="form-group">
									<label>Single Select<span class="mandatory">*</span></label> <select
										name="type" class="singleselect form-control">
										<option></option>
										<option value="1">New List</option>
										<option value="2">Demo List</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="form-group">
									<label>Normal Input<span class="mandatory">*</span></label> <input
										class="form-control" type="text" placeholder="Enter Input">
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="btn-bottom">
									<ul class="list-inline custom-btn-group">
										<li class="list-inline-item"><button type="button"
												class="btn btn-info btnsubmit">Submit</button></li>
										<li class="list-inline-item"><button type="button"
												class="btn btn-secondary btnsubmit">Reset</button></li>
										<li class="list-inline-item"><button type="button"
												class="btn btn-success btnsave">Save</button></li>
									</ul>
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
								<h4 class="card-title">Datatable Title</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<table id="datatabledemo"
										class="table data-table table-striped table-hover custom-datatable datatable-responsive" width="100%">
										<thead>
											<tr>
												<th class="table-block-sm">Sr No.</th>
												<th>Name</th>
												<th>Position</th>
												<th>Office</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="table-block-sm">1</td>
												<td>Tiger Nixon</td>
												<td>System Architect</td>
												<td>Edinburgh</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">2</td>
												<td>Garrett Winters</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">3</td>
												<td>Ashton Cox</td>
												<td>Junior Technical Author</td>
												<td>San Francisco</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">4</td>
												<td>Cedric Kelly</td>
												<td>Senior Javascript Developer</td>
												<td>Edinburgh</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">5</td>
												<td>Airi Satou</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">6</td>
												<td>Brielle Williamson</td>
												<td>Integration Specialist</td>
												<td>New York</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">7</td>
												<td>Herrod Chandler</td>
												<td>Sales Assistant</td>
												<td>San Francisco</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">8</td>
												<td>Rhona Davidson</td>
												<td>Integration Specialist</td>
												<td>Tokyo</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">9</td>
												<td>Colleen Hurst</td>
												<td>Javascript Developer</td>
												<td>San Francisco</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">10</td>
												<td>Sonya Frost</td>
												<td>Software Engineer</td>
												<td>Edinburgh</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">11</td>
												<td>Jena Gaines</td>
												<td>Office Manager</td>
												<td>London</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">12</td>
												<td>Quinn Flynn</td>
												<td>Support Lead</td>
												<td>Edinburgh</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">13</td>
												<td>Charde Marshall</td>
												<td>Regional Director</td>
												<td>San Francisco</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">14</td>
												<td>Haley Kennedy</td>
												<td>Senior Marketing Designer</td>
												<td>London</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
											<tr>
												<td class="table-block-sm">15</td>
												<td>Tatyana Fitzpatrick</td>
												<td>Regional Director</td>
												<td>London</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">16</td>
												<td>Michael Silva</td>
												<td>Marketing Designer</td>
												<td>London</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">17</td>
												<td>Paul Byrd</td>
												<td>Chief Financial Officer (CFO)</td>
												<td>New York</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>

											</tr>
											<tr>
												<td class="table-block-sm">18</td>
												<td>Gloria Little</td>
												<td>Systems Administrator</td>
												<td>New York</td>
												<td><ul class="list-inline custom-btn-group">
														<li class="list-inline-item"><button type="button"
																class="btn btn-primary icon-btn btnedit" title="Edit">
																<i class="ri-edit-2-fill"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-info icon-btn btnadd" title="Add">
																<i class="ri-add-line"></i>
															</button></li>
														<li class="list-inline-item"><button type="button"
																class="btn btn-warning icon-btn btndelete"
																title="Delete">
																<i class="ri-delete-bin-2-fill"></i>
															</button></li>
													</ul></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th>Sr No.</th>
												<th>Name</th>
												<th>Position</th>
												<th>Office</th>
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

