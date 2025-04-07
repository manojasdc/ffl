<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />

<!-- carousal css start-->
<link rel="stylesheet" href="admin/assets/vendor/owlcarousel/owl.css">
<!-- carousal css end-->

<div class="main-page-content landing-page">
	<!-- marquee css start-->
	<section class="marquee-block">
		<input type="hidden" id="thought" name="thought" value='${thought}'>
		<div class="container-fluid">
			<marquee direction="left" loop="true" scrollamount="4"
				behavior="scroll" scrolldelay="50" id="top_marq_id" class="marquee">
				<ul class="list-unstyled list-inline custom-m-line">
					<li class="list-inline-item"><a href="#"><span
							class="latest-update">Latest :</span>You can read latest
							notifications here.</a></li>
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
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-12 col-12">
					<div class="service-item">
						<div class="icon">
							<img src="admin/assets/images/outerimages/history-img.png"
								alt="History" title="History">
						</div>
						<div class="main-content">
							<h4>History</h4>
							<p>The Indian Air Force Educational and Cultural Society,
								hereinafter referred to as the ‘Society’, was originally
								registered on 25 Sep 1980 as ‘The Indian Air Force Education
								Society’ under the Societies Registration Act 1860, vide
								registration no. S/11214. It was subsequently renamed and
								re-registered as ‘The Indian Air Force Educational and Cultural
								Society’ on 10 Nov 1987.</p>
							<div class="main-button">
								<a href="history">Read More</a>
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
							<h4>Vision</h4>
							<p>To bring good education and culture within the financial
								reach of the personnel of the IAF, their children and families.
								To ensure uniform provision of healthy, liberal and sound
								Pre-Primary, Primary, Middle, Secondary and Senior Secondary
								education, including mental, moral and physical education and to
								promote development of academic excellence, discipline, personal
								character, high sense of values and national integration. To
								provide, as far as possible, artistic surroundings and
								opportunities for the development of the aesthetic side of the
								minds of the beneficiaries.</p>
							<div class="main-button">
								<a href="vision">Read More</a>
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
			</div>
		</div>
	</div>

	<div class="section spac-sm custom-section-bg-left">
		<div class="container">
			<div class="row">

				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<h6 class="custom-table-title">Air force schools under air HQ</h6>
					<div class="table-responsive">
						<table class="table basic-table table-striped table-hover">
							<thead>
								<tr>
									<th class="table-block-sm">Sr No.</th>
									<th>Name Of The School</th>
									<th>Location</th>
									<th>Category</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="table-block-sm">1</td>
									<td>AF Nursery School AFND</td>
									<td>New Delhi</td>
									<td>Pre-Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">2</td>
									<td>AF School Sohna Road</td>
									<td>Gurgaon</td>
									<td>Pre-Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">3</td>
									<td>AF School Dadri</td>
									<td>PMG, Dadri</td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">4</td>
									<td>AF School Naraina</td>
									<td>New Delhi</td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">5</td>
									<td>AF Junior School AFND(OWC)</td>
									<td>New Delhi</td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">6</td>
									<td>AF School Kasauli</td>
									<td>New Delhi</td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">7</td>
									<td>AF School CAMERO</td>
									<td>New Delhi</td>
									<td>Primary</td>
								</tr>
								<tr>
									<td class="table-block-sm">8</td>
									<td>AF School ASTE</td>
									<td>Bengaluru</td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">9</td>
									<td>Air Force Bal Bharati School</td>
									<td>Bengaluru</td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">10</td>
									<td>The Air Force School</td>
									<td>New Delhi</td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">11</td>
									<td>Air Force Golden Jubilee Institute</td>
									<td>New Delhi</td>
									<td>Sr Secondary</td>
								</tr>
								<tr>
									<td class="table-block-sm">12</td>
									<td>AFSSS, Race Course</td>
									<td>New Delhi</td>
									<td>Sr Secondary</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section about-us">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-12 col-sm-12 col-12 offset-lg-1">
					<div class="accordion" id="accordionExample">
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingOne">
								<button class="accordion-button" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne">
									Vision</button>
							</h2>
							<div id="collapseOne" class="accordion-collapse collapse show"
								aria-labelledby="headingOne" data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<p class="custom-accordian-text">To bring good education
										and culture within the financial reach of the personnel of the
										IAF, their children and families. To ensure uniform provision
										of healthy, liberal and sound Pre-Primary, Primary, Middle,
										Secondary and Senior Secondary education, including mental,
										moral and physical education and to promote development of
										academic excellence, discipline, personal character, high
										sense of values and national integration. To provide, as far
										as possible, artistic surroundings and opportunities for the
										development of the aesthetic side of the minds of the
										beneficiaries.
									<p>
									<div class="main-button">
										<a href="vision">Read More</a>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingTwo">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo">Aim</button>
							</h2>
							<div id="collapseTwo" class="accordion-collapse collapse"
								aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
								<div class="accordion-body">
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
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingThree">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseThree"
									aria-expanded="false" aria-controls="collapseThree">
									Functions</button>
							</h2>
							<div id="collapseThree" class="accordion-collapse collapse"
								aria-labelledby="headingThree"
								data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<p class="custom-accordian-text">To issue directions and
										exercise all the powers as considered necessary or expedient
										for implementing the aims and objectives set out in the
										Memorandum of Association of the Society. To ensure that
										adequate schooling facilities are available to wards of all
										Air Force personnel posted at various stations/units. It will
										ensure that Air Force Schools are established at all Air Force
										Stations and gradually upgraded to Senior Secondary level. To
										issue policy directives, guidelines, rules and regulations and
										bye-laws for the purpose of these rules, as applicable to all
										Air Force Schools/Institutions. To make, adopt, amend and
										vary, from time to time, the Education Code for Administration
										of Air Force Schools. To decide upon and provide initial
										corpus to various schools/institutions, control of central
										funds and annual budget of the Society. To lay down terms and
										conditions of service, admissible benefits and duties of the
										staff employed in Air Force Schools/Institutions. To carry out
										inspections of Air Force Schools/Institutions registered with
										the Society. To issue directions and frame policy for the
										administration and functioning of the Air Force Auditorium at
										New Delhi.</p>
									<div class="main-button">
										<a href="function">Read More</a>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingFour">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseFour"
									aria-expanded="false" aria-controls="collapseFour">History</button>
							</h2>
							<div id="collapseFour" class="accordion-collapse collapse"
								aria-labelledby="headingFour" data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<p class="custom-accordian-text">The Indian Air Force
										Educational and Cultural Society, hereinafter referred to as
										the ‘Society’, was originally registered on 25 Sep 1980 as
										‘The Indian Air Force Education Society’ under the Societies
										Registration Act 1860, vide registration no. S/11214. It was
										subsequently renamed and re-registered as ‘The Indian Air
										Force Educational and Cultural Society’ on 10 Nov 1987.</p>
									<div class="main-button">
										<a href="history">Read More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5 col-md-12 col-sm-12 col-12 align-self-center">
					<div class="section-heading">
						<h6>About Us</h6>
						<h2>What make us the best education society?</h2>
						<p>The academic standards at these institutions are extremely
							high. Students are given the required environment to successfully
							compete in national examinations. Leadership in these schools is
							drawn from the armed forces and thus reflects high standards and
							constant innovation and up-gradation.</p>
						<!-- <div class="main-button">
							<a href="#">Discover More</a>
						</div> -->
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
			</ul>
			<div class="row event_box">
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 wac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img1.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									WAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 wac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img2.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									WAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 design eac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img3.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									EAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 eac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img4.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									EAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 wordpress sac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img5.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									SAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">Event Place</span>
							<h4>Event Name</h4>
						</div>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer col-md-6 wordpress sac">
					<div class="events_item">
						<div class="thumb">
							<a href="#"><img
								src="admin/assets/images/outerimages/gallery-img6.jpg" alt=""></a>
							<span class="category">Event Type</span> <span class="price"><h6>
									SAC</h6></span>
						</div>
						<div class="down-content">
							<span class="author">David Hutson</span>
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
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="150"
										data-speed="1000"></h2>
									<p class="count-text ">Happy Students</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="804"
										data-speed="1000"></h2>
									<p class="count-text ">Course Hours</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter">
									<h2 class="timer count-title count-number" data-to="50"
										data-speed="1000"></h2>
									<p class="count-text ">Employed Students</p>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-12 col-12">
								<div class="counter end">
									<h2 class="timer count-title count-number" data-to="15"
										data-speed="1000"></h2>
									<p class="count-text ">Years Experience</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="team section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
					<div class="section-heading">
						<h6>Our Commands</h6>
						<h2>Zone Commands</h2>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/WAC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">WAC</span> -->
							<h4>Western Air Command (WAC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_wac"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/SWAC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">SWAC</span> -->
							<h4>South Western Air Command (SWAC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_swac"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/EAC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">EAC</span> -->
							<h4>Eastern Air Command (EAC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_eac"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/CAC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">CAC</span> -->
							<h4>Central Air Command (CAC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_cac"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/SAC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">SAC</span> -->
							<h4>Southern Air Command (SAC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_sac"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/MC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">MC</span> -->
							<h4>Maintenance Command (MC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_mc"><i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-12">
					<div class="team-member">
						<div class="main-content">
							<div class="logo-list">
								<img src="admin/assets/images/outerimages/TC.png"
									class="img-fluid" alt="">
							</div>
							<!-- <span class="category">TC</span> -->
							<h4>Training Command (TC)</h4>
							<div class="custom-redirect-btn">
								<a href="iaf_edu_tc"><i class="fa fa-angle-right"></i></a>
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
									alt=""> <span class="category">Master</span>
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
									alt=""> <span class="category">Expert</span>
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
									alt=""> <span class="category">Master</span>
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

	<div class="section events" id="events">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
					<div class="section-heading">
						<h6>Schedule</h6>
						<h2>Upcoming Events</h2>
					</div>
				</div>
				<div class="col-lg-12 col-md-6">
					<div class="item">
						<div class="row">
							<div class="col-lg-3 col-md-12 col-sm-12 col-12">
								<div class="image">
									<img src="admin/assets/images/outerimages/gallery-img7.jpg"
										alt="">
								</div>
							</div>
							<div class="col-lg-9 col-md-12 col-sm-12 col-12">
								<ul>
									<li><span class="category">Event Type</span>
										<h4>Event Title</h4></li>
									<li><span>Date:</span>
										<h6>16 Feb 2036</h6></li>
									<li><span>Duration:</span>
										<h6>22 Hours</h6></li>
									<li><span>Price:</span>
										<h6>Free</h6></li>
								</ul>
								<a href="#" class="custom-redirect-arrow"><i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-12 col-md-6">
					<div class="item">
						<div class="row">
							<div class="col-lg-3">
								<div class="image">
									<img src="admin/assets/images/outerimages/gallery-img8.jpg"
										alt="">
								</div>
							</div>
							<div class="col-lg-9">
								<ul>
									<li><span class="category">Event Type</span>
										<h4>Event Title</h4></li>
									<li><span>Date:</span>
										<h6>24 Feb 2036</h6></li>
									<li><span>Duration:</span>
										<h6>30 Hours</h6></li>
									<li><span>Price:</span>
										<h6>Free</h6></li>
								</ul>
								<a href="#" class="custom-redirect-arrow"><i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-12 col-md-6">
					<div class="item">
						<div class="row">
							<div class="col-lg-3">
								<div class="image">
									<img src="admin/assets/images/outerimages/gallery-img9.jpg"
										alt="">
								</div>
							</div>
							<div class="col-lg-9">
								<ul>
									<li><span class="category">Event Type</span>
										<h4>Event Title</h4></li>
									<li><span>Date:</span>
										<h6>12 Mar 2036</h6></li>
									<li><span>Duration:</span>
										<h6>48 Hours</h6></li>
									<li><span>Price:</span>
										<h6>Free</h6></li>
								</ul>
								<a href="#" class="custom-redirect-arrow"><i
									class="fa fa-angle-right"></i></a>
							</div>
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
