<!-- header start -->
<script src="assets/dev_module_list/headernotification.js"></script>
<div class="iq-top-navbar">
	<div class="iq-navbar-custom">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div
				class="iq-navbar-logo d-flex align-items-center justify-content-between">
				<i class="ri-menu-line wrapper-menu"></i> <a href="index.html"
					class="header-logo"> <img
					src="assets/images/outerimages/iaflogo.png"
					class="img-fluid  light-logo" alt="logo">
					<h5 class="logo-title">FFL</h5>
				</a>
				<div class="navbar-breadcrumb">
					<h1>Friends For Life</h1>
				</div>
			</div>
			<div class="d-flex align-items-center justify-content-between">
				<!-- 				<div class="iq-search-bar device-search"> -->
				<!-- 					<form action="#" class="searchbox mb-0"> -->
				<!-- 						<a class="search-link" href="#"><i class="ri-search-line"></i></a> -->
				<!-- 						<input type="text" class="text search-input" -->
				<!-- 							placeholder="Search for your document , people,..."> -->
				<!-- 					</form> -->
				<!-- 				</div> -->
				<div class="d-flex align-items-center">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent"
						aria-label="Toggle navigation">
						<i class="ri-menu-3-line"></i>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto navbar-list align-items-center">
							<!-- 							<li class="nav-item nav-icon search-content"><a href="#" -->
							<!-- 								class="search-toggle rounded" id="dropdownSearch" -->
							<!-- 								data-bs-toggle="dropdown" aria-haspopup="true" -->
							<!-- 								aria-expanded="false"> <i class="ri-search-line"></i> -->
							<!-- 							</a> -->
							<!-- 								<div class="iq-search-bar iq-sub-dropdown dropdown-menu" -->
							<!-- 									aria-labelledby="dropdownSearch"> -->
							<!-- 									<form action="#" class="searchbox p-2"> -->
							<!-- 										<div class="form-group mb-0 position-relative"> -->
							<!-- 											<input type="text" class="text search-input font-size-12" -->
							<!-- 												placeholder="type here to search..."> <a href="#" -->
							<!-- 												class="search-link"><i class="las la-search"></i></a> -->
							<!-- 										</div> -->
							<!-- 									</form> -->
							<!-- 								</div></li> -->
							<li class="nav-item nav-icon dropdown"><a href="#"
								class="search-toggle dropdown-toggle" id="dropdownMenuButtontwo"
								data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="ri-notification-line"></i>
									<sup class="dots1" id="notificationcount">${countdata}</sup> <span
									class="bg-primary dots"></span>
							</a>
								<div class="iq-sub-dropdown dropdown-menu"
									aria-labelledby="dropdownMenuButtontwo">
									<div class="card shadow-none m-0 notification">
										<div class="card-body p-0 notification">
<%-- 											${notdata} --%>
<header>
												<div class="nav nav-underline" id="nav-tab" role="tablist">
													<a class="nav-item nav-link active" id="all-tabs"
														data-bs-toggle="tab" href="#allData" role="tab"
														aria-controls="nav-home" aria-selected="true">Notifications</a>
												</div>
											</header>

											<div class="data-simplebar">
												<div class="tab-content" id="myTabContent">

													<div class="p-4" id="allData"></div>

												</div>
											</div>
											<!-- 																						<ul class="custom-infilist-block"  > -->

											<!-- 																							<li class="iq-sub-card"> -->
											<!-- 																							<div class="media"> -->
											<!-- 																							 <div class="custom-info-img"> -->
											<!-- 																							 <img class="img-fluid" src="assets/images/user.png" alt="01"> -->
											<!-- 																							</div>  -->
											<!-- 																							<div class="media-body"> -->
											<!-- 																							<div class="ci-title-block"> -->
											<!-- 																							<h5 class="ci-title">Emma Watson</h5> -->
											<!-- 																							<span class="text-dark ci-time"><b>12 : 47 pm</b></span> -->
											<!-- 																							</div>  -->
											<!-- 																							<p class="ci-text">Lorem ipsum dolor sit amet</p> -->
											<!-- 																								</div> -->
											<!-- 																							</div> -->
											<!-- 																							</li>  -->
											<!-- 																							<li class="iq-sub-card"> -->
											<!-- 																							<div class="media"> -->
											<!-- 																							 <div class="custom-info-img"> -->
											<!-- 																							 <img class="img-fluid" src="assets/images/user.png" alt="01"> -->
											<!-- 																							</div>  -->
											<!-- 																							<div class="media-body"> -->
											<!-- 																							<div class="ci-title-block"> -->
											<!-- 																							<h5 class="ci-title">Emma Watson</h5> -->
											<!-- 																							<span class="text-dark ci-time"><b>12 : 47 pm</b></span> -->
											<!-- 																							</div>  -->
											<!-- 																							<p class="ci-text">Lorem ipsum dolor sit amet</p> -->
											<!-- 																								</div> -->
											<!-- 																							</div> -->
											<!-- 																							</li>  -->
											<!-- 																							<li class="iq-sub-card"> -->
											<!-- 																							<div class="media"> -->
											<!-- 																							 <div class="custom-info-img"> -->
											<!-- 																							 <img class="img-fluid" src="assets/images/user.png" alt="01"> -->
											<!-- 																							</div>  -->
											<!-- 																							<div class="media-body"> -->
											<!-- 																							<div class="ci-title-block"> -->
											<!-- 																							<h5 class="ci-title">Emma Watson</h5> -->
											<!-- 																							<span class="text-dark ci-time"><b>12 : 47 pm</b></span> -->
											<!-- 																							</div>  -->
											<!-- 																							<p class="ci-text">Lorem ipsum dolor sit amet</p> -->
											<!-- 																								</div> -->
											<!-- 																							</div> -->
											<!-- 																							</li>  -->
											<!-- 																						</ul> -->

											<footer class="border-top dropdown-notify-footer">

												<div
													class="d-flex justify-content-between align-items-center py-2 px-4">
													<span id="lastUpdateAll">Last updated Just Now</span>
													<button id="refress-button" href="javascript:"
														class="btn btn-secondary btn-refresh">
														<i class="fas fa-sync-alt"></i>
													</button>
												</div>

											</footer>
											<a
												class="right-ic btn btn-primary btn-block position-relative iq-logout"
												href="allnotificationinside" role="button"> View All </a>
										</div>
									</div>
								</div></li>
							<li class="nav-item nav-icon dropdown custom-item-candidate">
								<a href="#" class="search-toggle iq-user-toggle dropdown-toggle"
								id="dropdownMenuButton" data-bs-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> <span
									class="custom-login-name">${username}</span> <img
									src="assets/images/user.png" class="img-fluid rounded-small"
									alt="user"></a>
								<div class="iq-sub-dropdown dropdown-menu"
									aria-labelledby="dropdownMenuButton">
									<div class="card mb-0">
										<div class="card-body p-0">
											<div class="custom-infilist-block profile-header">
												<a href="myprofile" class="iq-sub-card profile-details">

													<div class="media">
														<div class="rounded bg-info iq-card-icon-small">
															<i class="ri-file-user-line"></i>
														</div>
														<div class="media-body">
															<div class="ci-title-block">
																<h5 class="ci-title">My Profile</h5>
															</div>
															<p class="ci-text">View personal profile details</p>
														</div>
													</div>

												</a>

											</div>
											<span class="media-body d-none"> <!-- 															<h5 class="mb-0"></h5> -->
												<span class="sessiontimeout d-none"> Session timeout
													in &nbsp; <i class="fa fa-hourglass fa-spin"></i> : <b
													class="timecount" id="div_timeout">385</b>
											</span>
											</span>

											<!-- 												<div class="profile-details"> -->
											<!-- 													<a href="#" class="iq-sub-card"> <span -->
											<!-- 														class="rounded bg-success iq-card-icon-small"> <i -->
											<!-- 															class="ri-profile-line"></i> -->
											<!-- 													</span> <span class="media-body"> -->
											<!-- 															<h5 class="mb-0">Edit Profile</h5> -->
											<!-- 															<p class="mb-0 font-size-14">Modify Your details</p> -->
											<!-- 													</span> -->
											<!-- 													</a> -->
											<!-- 												</div> -->


											<!-- 												<div class="profile-details"> -->
											<!-- 													<a href="#" class="iq-sub-card border-none"> <span -->
											<!-- 														class="rounded bg-warning iq-card-icon-small"> <i -->
											<!-- 															class="ri-lock-line"></i> -->
											<!-- 													</span> <span class="media-body"> -->
											<!-- 															<h5 class="mb-0">Settings</h5> -->
											<!-- 															<p class="mb-0 font-size-14">Control your privacy -->
											<!-- 																parameters.</p> -->
											<!-- 													</span> -->
											<!-- 													</a> -->
											<!-- 												</div> -->
										</div>
										<a
											class="right-ic btn btn-primary btn-block position-relative iq-logout"
											type="submit" id="logout"> Log Out </a>
									</div>
								</div>
					</div>
					</li>
					</ul>
				</div>
			</div>
	</div>
	</nav>
</div>
</div>
<!-- header end -->