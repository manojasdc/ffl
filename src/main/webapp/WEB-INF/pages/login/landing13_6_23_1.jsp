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

<div class="main-page-content landing-page">
	<!-- marquee css start-->
	<section class="marquee-block">
		<div class="container-fluid">
			 <marquee direction="left" loop="true" scrollamount="2"
                behavior="scroll" scrolldelay="50" id="top_marq_id" class="marquee">
                <ul class="list-unstyled list-inline custom-m-line" id="marqueeList">
                </ul>
            </marquee>
		</div>
	</section>
	<!-- marquee css end-->
	<div class="main-banner" id="top">
		<div class="container-fluid">
			<div class="background-header-sticky">
				<div class="row justify-content-center">
					<div class="col-lg-10 col-md-12 col-sm-12 col-12">
						<div class="owl-carousel owl-banner custom-owl-carousel">
							<div class="item item-1">
								<div class="header-text">
									<span class="category">Indian Air Force</span>
									<h2>Welcome to the Indian Air Force Educational and
										Cultural Society</h2>
									<p>The Educational and Cultural Society, herein after
										referred to as the ‘Society’, was originally registered on 25
										Sep 1980.</p>
									<div class="buttons">
										<div class="main-button">
											<a href="history">Explore More</a>
										</div>
										<div class="icon-button">
											<a href="#"><i class="fa fa-play"></i> Explore IAF
												Videoes?</a>
										</div>
									</div>
								</div>
							</div>
							<div class="item item-2">
								<div class="header-text">
									<span class="category">IAF-Aim</span>
									<h2>The Indian Air Force Educational and Cultural Society</h2>
									<p>The Society is a non-profit making welfare institution,
										with its primary aim being promotion of education and
										instructions etc.</p>
									<div class="buttons">
										<div class="main-button">
											<a href="aim">Explore More</a>
										</div>
										<div class="icon-button">
											<a href="#"><i class="fa fa-play"></i> Explore IAF
												Videoes?</a>
										</div>
									</div>
								</div>
							</div>
							<div class="item item-3">
								<div class="header-text">
									<span class="category">IAF-Vision</span>
									<h2>About IAF Educational and Cultural Society</h2>
									<p>To bring good education and culture within the financial
										reach of the personnel of the IAF, their children and
										families.</p>
									<div class="buttons">
										<div class="main-button">
											<a href="vision">Explore More</a>
										</div>
										<div class="icon-button">
											<a href="#"><i class="fa fa-play"></i> Explore IAF
												Videoes?</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="services section">
		<div class="container">
			<div class="row event-box">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
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
							<p>The Indian Air Force Educational and Cultural Society,
								hereinafter referred to as the ‘Society’, was originally
								registered on 25 Sep 1980 as ‘The Indian Air Force Education
								Society’ under the Societies Registration Act 1860, vide
								registration no. S/11214. It was subsequently renamed and
								re-registered as ‘The Indian Air Force Educational and Cultural
								Society’ on 10 Nov 1987.</p>
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
						<h6>Photo Gallery</h6>
						<h2>AF School Zone Gallery</h2>
					</div>
				</div>
			</div>
			<ul class="event_filter">
				<li><a class="is_active" href="#!" data-filter="*">Show All</a></li>
				<li><a href="#!" data-filter=".wac">WAC</a></li>
				<li><a href="#!" data-filter=".sac">SAC</a></li>
				<li><a href="#!" data-filter=".eac">EAC</a></li>
				<li><a href="#!" data-filter=".swac">SWAC</a></li>
				<li><a href="#!" data-filter=".cac">CAC</a></li>
				<li><a href="#!" data-filter=".mc">MC</a></li>
				<li><a href="#!" data-filter=".tc">TC</a></li>
			</ul>
			<div class="row event_box">


				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer wac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img1.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>WAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer wac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img2.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>WAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer eac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img3.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>EAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer eac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img4.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>EAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer sac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img5.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>SAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>

				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer swac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img7.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>SWAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer cac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img8.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>CAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer mc">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img9.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>MC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer tc">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img10.jpg" alt=""
								title=""></a> <span class="category">Event Type</span> <span
								class="price"><h6>TC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
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
							<div class="col-lg-2 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="130"
										data-speed="1000"></h2>
									<p class="count-text ">Schools</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="8024"
										data-speed="1000"></h2>
									<p class="count-text ">Staff Members</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="34250"
										data-speed="1000"></h2>
									<p class="count-text ">Students</p>
								</div>
							</div>
							<div class="col-lg-2 col-md-6 col-sm-12 col-12">
								<div class="counter end">
									<h2 class="timer count-title count-number"
										data-to='${totalHits}' data-speed="1000"></h2>
									<p class="count-text ">Total Visitors</p>
									<%-- 									<p class="count-text ">Daily Visitors ${hitsToday}</p> --%>
								</div>
							</div>
							<div class="col-lg-2 col-md-6 col-sm-12 col-12">
								<div class="counter end">
									<h2 class="timer count-title count-number"
										data-to='${hitsToday}' data-speed="1000"></h2>
									<p class="count-text ">Daily Visitors</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section testimonials">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-12 col-sm-12 col-12">
					<div class="owl-carousel owl-testimonials">
						<div class="item">
							<p>“Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Quis ipsum suspendisse ultrices gravid risus commodo.”</p>
							<div class="author">
								<img
									src="admin/assets/images/outerimages/testimonial-author.jpg"
									alt="" title=""> <span class="category">Master</span>
								<h4>Name</h4>
							</div>
						</div>
						<div class="item">
							<p>“Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Quis ipsum suspendisse ultrices gravid risus commodo.”</p>
							<div class="author">
								<img
									src="admin/assets/images/outerimages/testimonial-author.jpg"
									alt="" title=""> <span class="category">Expert</span>
								<h4>Name</h4>
							</div>
						</div>
						<div class="item">
							<p>“Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Quis ipsum suspendisse ultrices gravid risus commodo.”</p>
							<div class="author">
								<img
									src="admin/assets/images/outerimages/testimonial-author.jpg"
									alt="" title=""> <span class="category">Master</span>
								<h4>Name</h4>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5 col-md-12 col-sm-12 col-12 align-self-center">
					<div class="section-heading">
						<h4>Thoughts Of The Day</h4>
						<h6>${thought}</h6>
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
