<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<link rel="stylesheet"
	href="admin/assets/dev_module_list/css/commonstyle.css">

<div class="main-page-content custom-cac-page" id="top">
	<div class="custom-main-breadcrum">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<input id="idval" name="idval" value="${id}" hidden>
							<%-- 							<h1 class="page-title">${name}</h1> --%>
							<%-- 							<h1 class="page-title">${name}</h1> --%>
							<%-- 							<h1 class="page-title">${id1} SCHOOLS</h1> --%>
							<h1 class="page-title">Institutes</h1>

						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="landing">Home</a></li>
									<%-- 									<li class="breadcrumb-item active" aria-current="${id1}">${id1}</li> --%>
									<li class="breadcrumb-item active" aria-current="${id1}">Institutes</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section class="custom-detail-block custom-section-bg-left d-none">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<h6 class="custom-table-title">Air Force Schools Under Air HQ
						Region</h6>
					<div class="table-responsive">
						<table class="table basic-table table-striped table-hover">
							<thead>
								<tr>
									<th class="table-block-sm">Sr No.</th>
									<th>Name Of The School</th>
									<th>Category</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="table-block-sm">1</td>
									<td><a href="#">AF Nursery School AFND, </a><b>New
											Delhi</b></td>
									<td>Pre-Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">2</td>
									<td><a href="#">AF School Sohna Road, </a><b>Gurgaon</b></td>
									<td>Pre-Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">3</td>
									<td><a href="#">AF School Dadri, </a><b>PMG, Dadri</b></td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">4</td>
									<td><a href="#">AF School Naraina, </a><b>New Delhi</b></td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">5</td>
									<td><a href="#">AF Junior School AFND(OWC), </a><b>New
											Delhi</b></td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">6</td>
									<td><a href="#">AF School Kasauli, </a><b>New Delhi</b></td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">7</td>
									<td><a href="#">AF School CAMERO, </a><b>New Delhi</b></td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">8</td>
									<td><a href="#">AF School ASTE, </a><b>Bengaluru</b></td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">9</td>
									<td><a href="#">Air Force Bal Bharati School, </a><b>Bengaluru</b></td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">10</td>
									<td><a href="#">The Air Force School, </a><b>New Delhi</b></td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">11</td>
									<td><a href="#">Air Force Golden Jubilee Institute, </a><b>New
											Delhi</b></td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">12</td>
									<td><a href="#">AFSSS, Race Course, </a><b>New Delhi</b></td>
									<td>Sr Secondary</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>



	<div class="section">
		<div class="container">
			<!-- 			<ul class="nav nav-pills mb-3 custom-tab-card justify-content-center" -->
			<!-- 				id="pills-tab" role="tablist"> -->

			<!-- 				<li class="nav-item clr1" role="presentation"> -->
			<!-- 					<button class="nav-link" id="pills-preprimary-tab" -->
			<!-- 						data-bs-toggle="pill" data-bs-target="#pills-preprimary" -->
			<!-- 						type="button" role="tab" aria-controls="pills-preprimary" -->
			<!-- 						aria-selected="true">PRE-PRIMARY</button> -->
			<!-- 				</li> -->
			<!-- 				<li class="nav-item clr2" role="presentation"> -->
			<!-- 					<button class="nav-link" id="pills-primary-tab" -->
			<!-- 						data-bs-toggle="pill" data-bs-target="#pills-primary" -->
			<!-- 						type="button" role="tab" aria-controls="pills-primary" -->
			<!-- 						aria-selected="false">PRIMARY</button> -->
			<!-- 				</li> -->
			<!-- 				<li class="nav-item clr3" role="presentation"> -->
			<!-- 					<button class="nav-link" id="pills-middle-tab" -->
			<!-- 						data-bs-toggle="pill" data-bs-target="#pills-middle" type="button" -->
			<!-- 						role="tab" aria-controls="pills-middle" aria-selected="false">MIDDLE</button> -->
			<!-- 				</li> -->
			<!-- 				<li class="nav-item clr4" role="presentation"> -->
			<!-- 					<button class="nav-link" id="pills-srsecondary-tab" -->
			<!-- 						data-bs-toggle="pill" data-bs-target="#pills-srsecondary" -->
			<!-- 						type="button" role="tab" aria-controls="pills-srsecondary" -->
			<!-- 						aria-selected="false">SR SECONDARY</button> -->
			<!-- 				</li> -->
			<!-- 				<li class="nav-item clr5" role="presentation"> -->
			<!-- 					<button class="nav-link" id="pills-secondary-tab" -->
			<!-- 						data-bs-toggle="pill" data-bs-target="#pills-secondary" -->
			<!-- 						type="button" role="tab" aria-controls="pills-secondary" -->
			<!-- 						aria-selected="false">SECONDARY</button> -->
			<!-- 				</li> -->
			<!-- 			</ul> -->
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-showall"
					role="tabpanel" aria-labelledby="pills-showall-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${SchoolDetails}</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="pills-preprimary" role="tabpanel"
					aria-labelledby="pills-preprimary-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${preprimaryHtml}</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="pills-primary" role="tabpanel"
					aria-labelledby="pills-primary-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${primaryHtml}</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="pills-middle" role="tabpanel"
					aria-labelledby="pills-middle-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${middleHtml}</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="pills-srsecondary" role="tabpanel"
					aria-labelledby="pills-srsecondary-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${srsecHtml}</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="pills-secondary" role="tabpanel"
					aria-labelledby="pills-secondary-tab">
					<div class="custom-card-section">
						<div class="container">

							<div class="row">${secHtml}</div>
						</div>
					</div>
				</div>

			</div>
		</div>



	</div>
</div>



<div class="section custom-card-section d-none">
	<div class="container">

		<div class="row">
			<div class="col-lg-3 col-md-4 col-sm-12 col-12">
				<div class="custom-card">
					<div class="custom-content-block">
						<div class="custom-image-block">
							<img src="admin/assets/images/outerimages/demo-school.jpeg"
								alt="school-image" class="img-fluid">
						</div>
						<span class="category">Pre-Primary</span>
						<h4 class="custom-middle-content">
							<a href="#">AF Nursery School AFND</a>
						</h4>
						<p class="custom-down">New Delhi</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-4 col-sm-12 col-12">
				<div class="custom-card clr1">
					<div class="custom-content-block">
						<div class="custom-image-block">
							<img src="admin/assets/images/outerimages/demo-school.jpeg"
								alt="school-image" class="img-fluid">
						</div>
						<span class="category">Primary</span>
						<h4 class="custom-middle-content">
							<a href="#">AF School Dadri</a>
						</h4>
						<p class="custom-down">Dadri</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-4 col-sm-12 col-12">
				<div class="custom-card clr2">
					<div class="custom-content-block">
						<div class="custom-image-block">
							<img src="admin/assets/images/outerimages/demo-school.jpeg"
								alt="school-image" class="img-fluid">
						</div>
						<span class="category">Middel</span>
						<h4 class="custom-middle-content">
							<a href="#">AF School Panagarh</a>
						</h4>
						<p class="custom-down">Panagarh</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-4 col-sm-12 col-12">
				<div class="custom-card clr3">
					<div class="custom-content-block">
						<div class="custom-image-block">
							<img src="admin/assets/images/outerimages/demo-school.jpeg"
								alt="school-image" class="img-fluid">
						</div>
						<span class="category">Sr Secondary</span>
						<h4 class="custom-middle-content">
							<a href="#">Air Force Bal Bharati School</a>
						</h4>
						<p class="custom-down">Bengaluru</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-4 col-sm-12 col-12">
				<div class="custom-card clr4">
					<div class="custom-content-block">
						<div class="custom-image-block">
							<img src="admin/assets/images/outerimages/demo-school.jpeg"
								alt="school-image" class="img-fluid">
						</div>
						<span class="category">Secondary</span>
						<h4 class="custom-middle-content">
							<a href="#">AF School Tezpur</a>
						</h4>
						<p class="custom-down">Tezpur</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>


