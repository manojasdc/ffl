<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />

<!-- carousal css start-->
<link rel="stylesheet" href="admin/assets/vendor/owlcarousel/owl.css">
<!-- carousal css end-->
<script src="admin/assets/dev_module_list/landingpage.js"></script>
<link rel="stylesheet"
	href="admin/assets/dev_module_list/css/commonstyle.css">
<script src="admin/assets/js/outerjs/marqueetagstop.js"></script>
<link rel="stylesheet" href="admin/assets/css/outercss/responsive.css">

<div class="main-page-content landing-page">
	<!-- marquee css start-->
	<section class="marquee-block">
		<div class="container-fluid">
			<marquee direction="left" loop="true" scrollamount="5"
				behavior="scroll" scrolldelay="50" id="top_marq_id" class="marquee">
				<ul class="list-unstyled list-inline custom-m-line" id="marqueeList">
				</ul>
			</marquee>
		</div>
	</section>
	</section>
	<!-- marquee css end-->
	<div class="main-banner" id="top">
		<div class="container-fluid">
			<div class="background-header-sticky">
				<div class="row justify-content-center">
					<div class="col-lg-10 col-md-12 col-sm-12 col-12">
						<div class="header-text">
							<h2>Friends For Life</h2>
						</div>
					</div>

					<!-- 					<div class="header-text"> -->
					<!-- 						<h2>Indian Air Force Educational and Cultural Society</h2> -->
					<!-- 					</div> -->

					<div class="col-lg-10 col-md-12 col-sm-12 col-12">
						<div class="owl-carousel owl-banner custom-owl-carousel">
							<div class="item item-1">
								<!-- 								<div class="header-text"> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<span class="category">Indian Air Force</span> -->
								<!-- 									<h2>Indian Air Force Educational and Cultural Society</h2> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<p>The Educational and Cultural Society, herein after -->
								<!-- 																			referred to as the ‘Society’, was originally registered on 25 -->
								<!-- 																			Sep 1980.</p> -->
								<!-- 																		<div class="buttons"> -->
								<!-- 																			<div class="main-button"> -->
								<!-- 																				<a href="history">Explore More</a> -->
								<!-- 																			</div> -->
								<!-- 																			<div class="icon-button"> -->
								<!-- 																				<a href="#"><i class="fa fa-play"></i> Explore IAF -->
								<!-- 																					Videoes?</a> -->
								<!-- 																			</div> -->
								<!-- 																		</div> -->
								<!-- 								</div> -->
							</div>
							<div class="item item-2">
								<!-- 								<div class="header-text"> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<span class="category">IAF-Aim</span> -->
								<!-- 									<h2>Indian Air Force Educational and Cultural Society</h2> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<p>The Society is a non-profit making welfare institution, -->
								<!-- 																			with its primary aim being promotion of education and -->
								<!-- 																			instructions etc.</p> -->
								<!-- 																		<div class="buttons"> -->
								<!-- 																			<div class="main-button"> -->
								<!-- 																				<a href="aim">Explore More</a> -->
								<!-- 																			</div> -->
								<!-- 																			<div class="icon-button"> -->
								<!-- 																				<a href="#"><i class="fa fa-play"></i> Explore IAF -->
								<!-- 																					Videoes?</a> -->
								<!-- 																			</div> -->
								<!-- 																		</div> -->
								<!-- 								</div> -->
							</div>
							<div class="item item-3">
								<!-- 								<div class="header-text"> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<span class="category">IAF-Vision</span> -->
								<!-- 									<h2>Indian Air Force Educational and Cultural Society</h2> -->
								<!-- 																	26-06-23 -->
								<!-- 																		<p>To bring good education and culture within the financial -->
								<!-- 																			reach of the personnel of the IAF, their children and -->
								<!-- 																			families.</p> -->
								<!-- 																		<div class="buttons"> -->
								<!-- 																			<div class="main-button"> -->
								<!-- 																				<a href="vision">Explore More</a> -->
								<!-- 																			</div> -->
								<!-- 																			<div class="icon-button"> -->
								<!-- 																				<a href="#"><i class="fa fa-play"></i> Explore IAF -->
								<!-- 																					Videoes?</a> -->
								<!-- 																			</div> -->
								<!-- 																		</div> -->
								<!-- 								</div> -->
							</div>

							<div class="item item-4"></div>
							<div class="item item-5"></div>
							<div class="item item-6"></div>
							<div class="item item-7"></div>
							<div class="item item-8"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="services section">
		<div class="container">
			<div class="row event-box">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center d-none">
					<div class="section-heading">
						<h6>About Us</h6>
						<h2>Indian Air Force</h2>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12 col-12">
					<div class="service-item">
						<div class="icon">
							<img src="admin/assets/images/outerimages/history-img.png"
								alt="History" title="History">
						</div>
						<div class="main-content">
							<h4>Registration</h4>
							<p>The Army Training Command, abbreviated as ARTRAC, is one
								of the seven commands of the Indian Army. It is currently based
								at Shimla. It was established in 1991.</p>
							<div class="main-button">
								<a href="reg_page">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12 col-12">
					<div class="service-item">
						<div class="icon">
							<img src="admin/assets/images/outerimages/vision-img.png"
								alt="Vision" title="Vision">
						</div>
						<div class="main-content">
							<h4>Aim</h4>
							<p>Planning , co-ordination, supervision and implementation
								of training policy and conduct of training courses, at specified
								training establishments of the Indian Army . Supervision and
								monitoring of training in all other training establishments.</p>
							<div class="main-button">
								<a href="aim">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12 col-12">
					<div class="service-item">
						<div class="icon">
							<img src="admin/assets/images/outerimages/aim-img.png" alt="Aim"
								title="Aim">
						</div>
						<div class="main-content">
							<h4>History</h4>
							<p>The Army Training Command was established on 1 October
								1991 at Mhow in Madhya Pradesh and moved to Shimla on 31 March
								1993. The main aim of the command is to maximize effectiveness
								of the training. In 2019, it was decided to merge the
								Directorate General of Military Training (DGMT) with ARTRAC</p>
							<div class="main-button">
								<a href="objective">Read More</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <section class="section gallery">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
					<div class="section-heading">
						<!-- 								26-06-23 -->
						<!-- 						<h6>Photo Gallery</h6> -->
						<!-- 						<h2>AF School Zone Gallery</h2> -->
						<h2>Photo Gallery</h2>
					</div>
				</div>
			</div>
						<ul class="event_filter" id="event_filter">${ulString}</ul>
			<div class="row event_box" id="homepageEventPhotoes">${photoesString}</div>
		</div>
	</section> --%>

	<section class="section gallery">

		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
					<div class="section-heading">
						<!-- 								26-06-23 -->
						<!-- 						<h6>Photo Gallery</h6> -->
						<!-- 						<h2>AF School Zone Gallery</h2> -->
						<h2>CAT 'A' EST</h2>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="team-boxed">
					<div class="container">
						<div class="row people people1">
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/AAD.png">
									<h3 class="name">Army Air Defence College (AAD)</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/OTAChennai.jpg">
									<h3 class="name">Officers Training Acedemy (OTA) Chennai</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/RVC.png">
									<h3 class="name">Remount Veterinary Corps (RVC)</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/Schoolofarty.png">
									<h3 class="name">School of Artillery (Arty)</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/ACcenterandschool.png">
									<h3 class="name">Armoured Corps(AC) Center and School</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-lg-2 item">
								<div class="box box1">
									<img class="rounded-circle"
										src="admin/assets/images/instituteimages/ASC.png">
									<h3 class="name">Army Service Corps (ASC)</h3>
									<div class="social">
										<a href="#"><i class="fa fa-facebook-official"></i></a><a
											href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="section gallery">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
					<div class="section-heading">
						<!-- 								26-06-23 -->
						<!-- 						<h6>Photo Gallery</h6> -->
						<!-- 						<h2>AF School Zone Gallery</h2> -->
						<h2>Photo Gallery</h2>
					</div>
				</div>
			</div>
			<%-- 			<ul class="event_filter" id="event_filter">${ulString}</ul> --%>
			<div class="row event_box" id="homepageEventPhotoes">
				<%-- 			${photoesString} --%>
				<div class="row event_box __web-inspector-hide-shortcut__"
					id="homepageEventPhotoes"
					style="position: relative; height: 1680px;">
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer IAF E &amp; C Society"
						style="position: absolute; left: 0px; top: 0px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/image2.jpg" alt=""
									title="This title is Static"></a>
								<!--             <span class="price"> -->
								<!--                <h6> -->
								<!--                   IAF E &amp; C Society -->
								<!--                </h6> -->
								<!--             </span> -->
							</div>
							<div></div>
						</div>
					</div>
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer SR SECONDARY"
						style="position: absolute; left: 0px; top: 280px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/image3.jpg" alt=""
									title="This title is Static"></a>
								<!-- 									<span class="price"> -->
								<!-- 									<h6>SR SECONDARY</h6> -->
								<!-- 								</span> -->
							</div>
							<div></div>
						</div>
					</div>
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer SECONDARY"
						style="position: absolute; left: 0px; top: 560px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/image4.jpg" alt=""
									title="This title is Static"></a>
								<!-- 									<span class="price"> -->
								<!-- 									<h6>SECONDARY</h6> -->
								<!-- 								</span> -->
							</div>
							<div></div>
						</div>
					</div>
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer MIDDLE"
						style="position: absolute; left: 0px; top: 840px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/image5.jpeg" alt=""
									title="This title is Static"></a>
								<!-- 									<span class="price"> -->
								<!-- 									<h6>MIDDLE</h6> -->
								<!-- 								</span> -->
							</div>
							<div></div>
						</div>
					</div>
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer PRIMARY"
						style="position: absolute; left: 0px; top: 1120px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/indo-bang.jpg" alt=""
									title="This title is Static"></a>
								<!-- 									<span class="price"> -->
								<!-- 									<h6>PRIMARY</h6> -->
								<!-- 								</span> -->
							</div>
							<div></div>
						</div>
					</div>
					<div
						class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer PRE-PRIMARY"
						style="position: absolute; left: 0px; top: 1400px;">
						<div class="events_item">
							<div class="thumb">
								<a href="#"><img class="card-image"
									src="admin/assets/images/FFCimages/image6.jpeg" alt=""
									title="This title is Static"></a>
								<!-- 									<span class="price"> -->
								<!-- 									<h6>PRE-PRIMARY</h6> -->
								<!-- 								</span> -->
							</div>
							<div></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="section fun-facts">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="wrapper">
						<div class="row">
							<!-- 								26-06-23 -->
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="32"
										data-speed="1000"></h2>
									<p class="count-text ">Training Institutes</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="60000"
										data-speed="1000"></h2>
									<p class="count-text ">Students</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="5500"
										data-speed="1000"></h2>
									<p class="count-text ">Training Officers</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number"
										data-to="${Visitor_count}" data-speed="1000"></h2>
									<p class="count-text ">Total Visitors</p>
								</div>
							</div>

							<!-- 								26-06-23 -->
							<!-- 							<div class="col-lg-2 col-md-6 col-sm-12 col-12"> -->
							<!-- 								<div class="counter end"> -->
							<!-- 									<h2 class="timer count-title count-number" -->
							<%-- 										data-to='${Visitor_count}' data-speed="1000"></h2> --%>
							<!-- 									<p class="count-text ">Total Visitors</p> -->
							<%-- 																		<p class="count-text ">Daily Visitors ${hitsToday}</p> --%>
							<!-- 								</div> -->
							<!-- 							</div> -->
							<!-- 							<div class="col-lg-2 col-md-6 col-sm-12 col-12"> -->
							<!-- 								<div class="counter end"> -->
							<!-- 									<h2 class="timer count-title count-number" -->
							<%-- 										data-to='${hitsToday}' data-speed="1000"></h2> --%>
							<!-- 									<p class="count-text ">Daily Visitors</p> -->
							<!-- 								</div> -->
							<!-- 							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="section testimonials">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-12 col-sm-12 col-12">
					<div class="owl-carousel owl-testimonials">
						<div class="item custom-image-card">
							<img src="admin/assets/images/outerimages/SS_Mahal.jpg" alt=""
								title="" class="img-fluid"> <span class="category">Lieutenant
								General</span>
							<h4>Surinder Singh Mahal</h4>
							<h4>AVSM, VSM</h4>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-12 col-sm-12 col-12 align-self-center">
					<div class="section-heading">
						<h4>Thoughts Of The Day</h4>
						<h6>“${thought}”</h6>
					</div>
				</div>

			</div>
		</div>
	</div>


	<div class="section custom-section-bg custom-logo-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="owl-carousel custom-logo-owl">
						<div class="item">
							<a href="https://www.mygov.in/" target="_blank"><img
								src="admin/assets/images/outerimages/lg1.png" alt="my-gov"
								title="my-gov" class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://data.gov.in/" target="_blank"><img
								src="admin/assets/images/outerimages/lg2.png" alt="data-gov"
								title="data-gov" class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://www.india.gov.in/" target="_blank"
								class="hvr-icon-grow"><img
								src="admin/assets/images/outerimages/lg3.png" alt="india-gov"
								title="india-gov" class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://www.makeinindia.com/" target="_blank"><img
								src="admin/assets/images/outerimages/lg4.png"
								alt="Make In India" title="Make In India" class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://amritmahotsav.nic.in/" target="_blank"><img
								src="admin/assets/images/outerimages/amrit-mahotsav.png"
								title="Azadi Ka Amrit Mahotsav" alt="Azadi Ka Amrit Mahotsav"
								class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://igod.gov.in/" target="_blank"><img
								src="admin/assets/images/outerimages/lg6.png"
								alt="Goi Web Directory" title="Goi Web Directory"
								class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://www.digitalindia.gov.in/" target="_blank"> <img
								src="admin/assets/images/outerimages/lg7.png"
								alt="Digital India" title="Digital India" class="img-fluid"></a>
						</div>
						<div class="item">
							<a href="https://pmgatishakti.gov.in/pmgatishakti/login"
								target="_blank"> <img
								src="admin/assets/images/outerimages/pm_gatishakti.png"
								alt="PM Gati Shakti National Master Plan"
								title="PM Gati Shakti National Master Plan" class="img-fluid"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- carousal scripts start-->
<script src="admin/assets/vendor/owlcarousel/owl-carousel.js"></script>
<!-- carousal scripts end-->
<!-- counter scripts start-->
<script src="admin/assets/vendor/counter/counter.js"></script>
<!-- counter scripts end-->
