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
						<h1 class="page-title">Dashboard</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<!-- <li class="breadcrumb-item active" aria-current="demo_page">Demo
									Page</li> -->
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-info custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-info-light">
							<i class="fa fa-school"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Schools</h4>
							<h5 class="custom-dcard-count">456</h5>
							</div>
							<div class="cutom-redirect-btn bg-info-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-secondary custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-secondary-light">
							<i class="fa fa-chalkboard-teacher"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Teachers</h4>
							<h5 class="custom-dcard-count">4564</h5>
							</div>
							<div class="cutom-redirect-btn bg-secondary-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-warning custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-warning-light">
							<i class="fa fa-graduation-cap"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Students</h4>
							<h5 class="custom-dcard-count">45667</h5>
							</div>
						<div class="cutom-redirect-btn bg-warning-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-danger custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-danger-light">
							<i class="fa fa-school"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Schools</h4>
							<h5 class="custom-dcard-count">456</h5>
							</div>
						<div class="cutom-redirect-btn bg-danger-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-successful custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-successful-light">
							<i class="fa fa-chalkboard-teacher"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Teachers</h4>
							<h5 class="custom-dcard-count">4566</h5>
							</div>
						<div class="cutom-redirect-btn bg-successful-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
					<div class="iq-option bg-lightblue custom-data-card" title="Click Here">
						<div class="custom-dcard-icon bg-lightblue-light">
							<i class="fa fa-graduation-cap"></i>
						</div>
						<div class="media-body">
						<div class="custom-dcard-value">
							<h4 class="custom-dcard-title">Students</h4>
							<h5 class="custom-dcard-count">45667</h5>
							</div>
						<div class="cutom-redirect-btn bg-lightblue-light">
							<a href="#"><i class="fa fa-share-square" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-skyblue custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-skyblue-light">
								<i class="fa fa-school"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Schools</h4>
									<h5 class="custom-dcard-count">1489115</h5>
								</div>
								<div class="cutom-redirect-btn bg-skyblue-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-skyblue-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Urban Area</h6>
							<h5 class="custom-mcard-count">2.54<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Rural Area</h6>
							<h5 class="custom-mcard-count">12.34<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>			
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-secondary custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-secondary-light">
								<i class="fa fa-chalkboard-teacher"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Teachers</h4>
									<h5 class="custom-dcard-count">9507123</h5>
								</div>
								<div class="cutom-redirect-btn bg-secondary-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-secondary-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Male</h6>
							<h5 class="custom-mcard-count">48.76<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Female</h6>
							<h5 class="custom-mcard-count">46.30<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-warning custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-warning-light">
								<i class="fa fa-graduation-cap"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Students</h4>
									<h5 class="custom-dcard-count">265235830</h5>
								</div>
								<div class="cutom-redirect-btn bg-warning-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-warning-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Girls</h6>
							<h5 class="custom-mcard-count">12.73<span class="custom-mcard-counttype">in Crores</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Boys</h6>
							<h5 class="custom-mcard-count">13.79<span class="custom-mcard-counttype">in Crores</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-danger custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-danger-light">
								<i class="fa fa-school"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Schools</h4>
									<h5 class="custom-dcard-count">1489115</h5>
								</div>
								<div class="cutom-redirect-btn bg-danger-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-danger-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Urban Area</h6>
							<h5 class="custom-mcard-count">2.54<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Rural Area</h6>
							<h5 class="custom-mcard-count">12.34<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>			
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-successful custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-successful-light">
								<i class="fa fa-chalkboard-teacher"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Teachers</h4>
									<h5 class="custom-dcard-count">9507123</h5>
								</div>
								<div class="cutom-redirect-btn bg-successful-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-successful-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Male</h6>
							<h5 class="custom-mcard-count">48.76<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Female</h6>
							<h5 class="custom-mcard-count">46.30<span class="custom-mcard-counttype">in Lakhs</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-12 col-12">
				<a href="#" title="">
				<div class="custom-multidata-card">
						<div class="iq-option bg-lightblue custom-data-card"
							title="Click Here">
							<div class="custom-dcard-icon bg-lightblue-light">
								<i class="fa fa-graduation-cap"></i>
							</div>
							<div class="media-body">
								<div class="custom-dcard-value">
									<h4 class="custom-dcard-title">Students</h4>
									<h5 class="custom-dcard-count">265235830</h5>
								</div>
								<div class="cutom-redirect-btn bg-lightblue-light">
									<a href="#"><i class="fa fa-share-square"
										aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
						<div class="custom-multidata-block">
						<div class="custom-mcard-value bg-lightblue-light">
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Girls</h6>
							<h5 class="custom-mcard-count">12.73<span class="custom-mcard-counttype">in Crores</span></h5>
						</div> 
						<div class="mcard-value-block">
							<h4 class="custom-mcard-title">Boys</h6>
							<h5 class="custom-mcard-count">13.79<span class="custom-mcard-counttype">in Crores</span></h5>
						</div>
						</div>
						</div>
					</div>
				</a>
			</div>
			
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="d-flex align-items-center justify-content-between">
							<div class="header-title">
								<h4 class="card-title">Card Title</h4>
							</div>
							<div class="dropdown">
								<span class="dropdown-toggle1" id="dropdownMenuButtontwenty"
									data-bs-toggle="dropdown" aria-expanded="false" role="button">
									<i class="fa fa-bars"></i>
								</span>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenuButtontwenty">
									<a class="dropdown-item" href="#">Show activity</a> <a
										class="dropdown-item" href="#">View details</a> <a
										class="dropdown-item" href="#">Copy campaign</a> <a
										class="dropdown-item" href="#">Create list</a> <a
										class="dropdown-item" data-extra-toggle="delete"
										data-closest-elem=".item" href="#">Delete</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">							
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<h1 class="text-center">Graph</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="d-flex align-items-center justify-content-between">
							<div class="header-title">
								<h4 class="card-title">Card Title</h4>
							</div>
							<div class="dropdown">
								<span class="dropdown-toggle1" id="dropdownMenuButtontwenty"
									data-bs-toggle="dropdown" aria-expanded="false" role="button">
									<i class="fa fa-bars"></i>
								</span>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenuButtontwenty">
									<a class="dropdown-item" href="#">Show activity</a> <a
										class="dropdown-item" href="#">View details</a> <a
										class="dropdown-item" href="#">Copy campaign</a> <a
										class="dropdown-item" href="#">Create list</a> <a
										class="dropdown-item" data-extra-toggle="delete"
										data-closest-elem=".item" href="#">Delete</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">						
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<h1 class="text-center">Graph</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="d-flex align-items-center justify-content-between">
							<div class="header-title">
								<h4 class="card-title">Card Title</h4>
							</div>
							<div class="dropdown">
								<span class="dropdown-toggle1" id="dropdownMenuButtontwenty"
									data-bs-toggle="dropdown" aria-expanded="false" role="button">
									<i class="fa fa-bars"></i>
								</span>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenuButtontwenty">
									<a class="dropdown-item" href="#">Show activity</a> <a
										class="dropdown-item" href="#">View details</a> <a
										class="dropdown-item" href="#">Copy campaign</a> <a
										class="dropdown-item" href="#">Create list</a> <a
										class="dropdown-item" data-extra-toggle="delete"
										data-closest-elem=".item" href="#">Delete</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">							
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<h1 class="text-center">Graph</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-12">
				<div class="card">
					<div class="card-header">
						<div class="d-flex align-items-center justify-content-between">
							<div class="header-title">
								<h4 class="card-title">Card Title</h4>
							</div>
							<div class="dropdown">
								<span class="dropdown-toggle1" id="dropdownMenuButtontwenty"
									data-bs-toggle="dropdown" aria-expanded="false" role="button">
									<i class="fa fa-bars"></i>
								</span>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenuButtontwenty">
									<a class="dropdown-item" href="#">Show activity</a> <a
										class="dropdown-item" href="#">View details</a> <a
										class="dropdown-item" href="#">Copy campaign</a> <a
										class="dropdown-item" href="#">Create list</a> <a
										class="dropdown-item" data-extra-toggle="delete"
										data-closest-elem=".item" href="#">Delete</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body custom-field-block">
						<div class="row">							
							<div class="col-lg-12 col-md-12 col-sm-12 col-12">
								<h1 class="text-center">Graph</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


