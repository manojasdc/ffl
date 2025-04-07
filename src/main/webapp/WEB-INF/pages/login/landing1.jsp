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
							<h2>Indian Air Force Educational and Cultural Society</h2>
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
							<p>The Indian Air Force Educational and Cultural Society, was
								registered on 25 Sep 1980 as The Indian Air Force Education
								Society under the Societies Registration Act 1860, vide
								registration no. S/11214. It was subsequently renamed and
								re-registered as The Indian Air Force Educational and Cultural
								Society on 10 Nov 1987.</p>
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
							<p>The Society is a non-profit making welfare institution,
								with its primary aim being promotion of education and
								instructions, diffusion of useful knowledge and promotion of
								science, literature, fine arts and culture, mainly amongst the
								past and present employees of Indian Air Force, their children
								and families.</p>
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
							<h4>Governing Body</h4>
							<p>The Governing Body of the Society is the apex body of the
								Indian Air Force Educational and Cultural Society, with the Air
								Officer-in-Charge Administration (AOA) at Air Headquarters, New
								Delhi as its ex-officio Chairman and the Director General (Adm)
								at Air HQ New Delhi as the ex-officio Senior Vice Chairman. In
								order to ensure uniformity, it lays down broad policy framework
								within which all the Air Force Schools function. Assistant Chief
								of the Air Staff (ACAS) (Edn) at the Directorate of Education,
								Air HQ New Delhi is the ex-officio Executive Vice Chairman of
								the Society, responsible for the functioning of the Society on
								behalf of the Chairman. All members of the Governing Body are
								ex-officio members and do not get any pay/honorarium for their
								role in the Society. The appointment of the members in Governing
								Body of society is co-terminus with their appointment on
								specified portfolio.</p>
							<div class="main-button">
								<a href="bog">Read More</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

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
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="130"
										data-speed="1000"></h2>
									<p class="count-text ">Schools</p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="60000"
										data-speed="1000"></h2>
									<p class="count-text ">Students</p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="5500"
										data-speed="1000"></h2>
									<p class="count-text ">Staff Members</p>
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
				<!-- 				<div class="col-lg-7 col-md-12 col-sm-12 col-12"> -->
				<!-- 					<div class="owl-carousel owl-testimonials"> -->
				<!-- 						<div class="item"> -->
				<%-- 							<p>“${thought}”</p> --%>
				<!-- 						</div> -->
				<!-- 						<div class="item"> -->
				<%-- 							<p>“${thought}”</p> --%>
				<!-- 						</div> -->
				<!-- 						<div class="item"> -->
				<!-- 							<p></p> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 align-self-center">
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
