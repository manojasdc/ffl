<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<!DOCTYPE html>

<html lang="en">

<head>
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />


<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Bisag-N</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="admin/login_file/images/favicon.png" rel="icon">

<!-- Vendor CSS Files -->
<link
	href="admin/login_file/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="admin/login_file/assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link href="admin/login_file/assets/vendor/aos/aos.css" rel="stylesheet">
<link
	href="admin/login_file/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="admin/login_file/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="admin/login_file/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="admin/login_file/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="admin/login_file/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="admin/login_file/assets/css/style.css" rel="stylesheet">

<script src="admin/login_file/js/jquery-3.6.0.min.js"></script>
<script src="admin/login_file/js/jquery-3.6.0.min.js"></script>
<script src="admin/login_file/js/jquery.blockUI.js"></script>
<script src="admin/login_file/js/local/loginfunction.js"></script>
<!-- <link rel="stylesheet" href="admin/login_file/css/sweetalert.css">
<link rel="stylesheet" href="admin/login_file/css/sweetalert.min.css">
<script type="text/javascript"
	src="admin/login_file/js/sweetalert.min.js"></script>  -->

<script type="text/javascript" src="admin/login_file/js/aes.js"></script>

<script type="text/javascript" src="admin/login_file/js/pbkdf2.js"></script>

<script type="text/javascript" src="admin/login_file/js/AesUtil.js"></script>

<link rel="stylesheet"
	href="admin/login_file/css/jquery-confirm.min.css">
<script type="text/javascript"
	src="admin/login_file/js/jquery-confirm.min.js"></script>


</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top">
		<div class="container d-flex align-items-center">
			<!--       <a href="index.html" class="logo me-auto"><img data-src="login_file/assets/img/amclogo.png" alt=""></a> -->
			<h1 class="logo me-auto">
				<a href="#">AFMS</a>
			</h1>

			<nav id="navbar" class="navbar order-last order-lg-0">
				<ul>
					<li><a class="nav-link scrollto" href="#hero">Home</a></li>
					<li><a class="nav-link scrollto" href="#about">About</a></li>
					<li><a class="nav-link scrollto" href="#services">Services</a></li>
					<li class="dropdown"><a href="#"><span>Drop Down</span> <i
							class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="#">Drop Down 1</a></li>
							<li class="dropdown"><a href="#"><span>Deep Drop
										Down</span> <i class="bi bi-chevron-right"></i></a>
								<ul>
									<li><a href="#">Deep Drop Down 1</a></li>
									<li><a href="#">Deep Drop Down 2</a></li>
									<li><a href="#">Deep Drop Down 3</a></li>
									<li><a href="#">Deep Drop Down 4</a></li>
									<li><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
							<li><a href="#">Drop Down 2</a></li>
							<li><a href="#">Drop Down 3</a></li>
							<li><a href="#">Drop Down 4</a></li>
						</ul></li>
					<li><a class="nav-link scrollto" href="#contact">Contact</a></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->

		</div>
	</header>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div id="heroCarousel" data-bs-interval="5000"
			class="carousel slide carousel-fade" data-bs-ride="carousel">

			<ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

			<div class="carousel-inner" role="listbox">

				<!-- Slide 1 -->
				<div class="carousel-item carousel-item1 active">
					<div class="container">
						<div class="row">
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
							<div class="col-sm-6 col-8">
								<h2>
									Welcome to <span>AFMS</span>
								</h2>
								<p>Armed Forces Medical Services</p>
								<p class="red">
									<c:if test="${not empty error}">${error}</c:if>
								</p>
								<p class="red">
									<c:if test="${not empty msg}">${msg}</c:if>
								</p>
								<a class="btn-get-started scrollto" data-bs-toggle="modal"
									data-bs-target="#myModal">Login Here</a> <a
									class="btn-get-started scrollto" data-bs-toggle="modal"
									data-bs-target="#regModal">Register Here</a>
								<!--             <button type="button" class="btn-get-started scrollto" data-bs-toggle="modal" data-bs-target="#myModal">Login Here</button> -->
							</div>
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
						</div>
					</div>
				</div>

				<!-- Slide 2 -->
				<div class="carousel-item carousel-item2">
					<div class="container">
						<div class="row">
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
							<div class="col-sm-6 col-8">
								<h2>
									Welcome to <span>AFMS</span>
								</h2>
								<p>Armed Forces Medical Services</p>
								<p class="red">
									<c:if test="${not empty error}">${error}</c:if>
								</p>
								<p class="red">
									<c:if test="${not empty msg}">${msg}</c:if>
								</p>
								<a href="" class="btn-get-started scrollto"
									data-bs-toggle="modal" data-bs-target="#myModal">Login Here</a>
								<a href="registrationUrl" class="btn-get-started scrollto">Register
									Here</a>
							</div>
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
						</div>
					</div>
				</div>


				<!-- Slide 3 -->
				<div class="carousel-item carousel-item3">
					<div class="container">
						<div class="row">
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
							<div class="col-sm-6 col-8">
								<h2>
									Welcome to <span>AFMS</span>
								</h2>
								<p>Armed Forces Medical Services</p>
								<p class="red">
									<c:if test="${not empty error}">${error}</c:if>
								</p>
								<p class="red">
									<c:if test="${not empty msg}">${msg}</c:if>
								</p>
								<a href="" class="btn-get-started scrollto"
									data-bs-toggle="modal" data-bs-target="#myModal">Login Here</a>
								<a href="registrationUrl" class="btn-get-started scrollto">Register
									Here</a>
							</div>
							<div class="col-sm-3 col-2">
								<a href="#" class="logo me-auto"><img
									data-src="login_file/assets/img/amclogo.png" alt=""
									class="lazyload"></a>
							</div>
						</div>
					</div>
				</div>

			</div>

			<a class="carousel-control-prev" href="#heroCarousel" role="button"
				data-bs-slide="prev"> <span
				class="carousel-control-prev-icon bi bi-chevron-left"
				aria-hidden="true"></span>
			</a> <a class="carousel-control-next" href="#heroCarousel" role="button"
				data-bs-slide="next"> <span
				class="carousel-control-next-icon bi bi-chevron-right"
				aria-hidden="true"></span>
			</a>

		</div>
	</section>
	<!-- End Hero -->

	<main id="main">

		<!-- ======= Featured Services Section ======= -->
		<section id="featured-services" class="featured-services">
			<div class="container" data-aos="fade-up">

				<div class="row">
					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="100">
							<div class="icon">
								<i class="fas fa-heartbeat"></i>
							</div>
							<h4 class="title">
								<a href="">title</a>
							</h4>
							<p class="description">description</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="200">
							<div class="icon">
								<i class="fas fa-pills"></i>
							</div>
							<h4 class="title">
								<a href="">title</a>
							</h4>
							<p class="description">description</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="300">
							<div class="icon">
								<i class="fas fa-thermometer"></i>
							</div>
							<h4 class="title">
								<a href="">title</a>
							</h4>
							<p class="description">description</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="400">
							<div class="icon">
								<i class="fas fa-dna"></i>
							</div>
							<h4 class="title">
								<a href="">title</a>
							</h4>
							<p class="description">description</p>
						</div>
					</div>

				</div>

			</div>
		</section>
		<!-- End Featured Services Section -->

		<!-- ======= About Us Section ======= -->
		<section id="about" class="about section-bg">
			<div class="container" data-aos="fade-up">

				<div class="section-title">
					<h2>About Us</h2>
				</div>

				<div class="row">
					<div class="col-lg-6" data-aos="fade-right">
						<img data-src="login_file/assets/img/afmc.jpg"
							class="img-fluid lazyload" alt="">
					</div>
					<div class="col-lg-6 pt-4 pt-lg-0 content" data-aos="fade-left">
						<h3>Introduction.</h3>
						<p class="fst-italic">The Department of Defence is mandated
							with Defence of India and every part thereof including defence
							policy. It deals with Inter-Services Organizations, Defence
							Accounts Department,Canteen Stores Department (CSD), Coast Guard,
							National Cadet Corps, Border Roads Organisation, Institute for
							Defence Studies and Analysis, National Defence College etc. It is
							responsible for the Defence Budget, defence lands and
							cantonments, matters relating to Parliament, and defence
							cooperation with foreign countries. It is headed by Defence
							Secretary who is assisted by Director General (Acquisition),
							Additional Secretaries and Joint Secretaries. Defence Secretary
							is also responsible for coordinating the activities of the other
							Departments i.e. DMA, DDP, DESW and DDR&D in Ministry of
							Defence..</p>
					</div>
				</div>

			</div>
		</section>
		<!-- End About Us Section -->

		<!-- ======= Counts Section ======= -->
		<section id="counts" class="counts">
			<div class="container" data-aos="fade-up">

				<div class="row no-gutters">

					<div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
						<div class="count-box">
							<i class="fas fa-user-md"></i> <span data-purecounter-start="0"
								data-purecounter-end="85" data-purecounter-duration="1"
								class="purecounter"></span>

							<p>
								<strong>Doctors</strong> consequuntur quae qui deca rode
							</p>
							<a href="#">Find out more &raquo;</a>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
						<div class="count-box">
							<i class="far fa-hospital"></i> <span data-purecounter-start="0"
								data-purecounter-end="26" data-purecounter-duration="1"
								class="purecounter"></span>
							<p>
								<strong>Departments</strong> adipisci atque cum quia aut numquam
								delectus
							</p>
							<a href="#">Find out more &raquo;</a>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
						<div class="count-box">
							<i class="fas fa-flask"></i> <span data-purecounter-start="0"
								data-purecounter-end="14" data-purecounter-duration="1"
								class="purecounter"></span>
							<p>
								<strong>Research Lab</strong> aut commodi quaerat. Aliquam
								ratione
							</p>
							<a href="#">Find out more &raquo;</a>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
						<div class="count-box">
							<i class="fas fa-award"></i> <span data-purecounter-start="0"
								data-purecounter-end="150" data-purecounter-duration="1"
								class="purecounter"></span>
							<p>
								<strong>Awards</strong> rerum asperiores dolor molestiae
								doloribu
							</p>
							<a href="#">Find out more &raquo;</a>
						</div>
					</div>

				</div>

			</div>
		</section>
		<!-- End Counts Section -->

		<!-- ======= Services Section ======= -->
		<section id="services" class="services services section-bg">
			<div class="container" data-aos="fade-up">

				<div class="section-title">
					<h2>Services</h2>
				</div>

				<div class="row">
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="100">
						<div class="icon">
							<i class="fas fa-heartbeat"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="200">
						<div class="icon">
							<i class="fas fa-pills"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="300">
						<div class="icon">
							<i class="fas fa-hospital-user"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="100">
						<div class="icon">
							<i class="fas fa-dna"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="200">
						<div class="icon">
							<i class="fas fa-wheelchair"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in"
						data-aos-delay="300">
						<div class="icon">
							<i class="fas fa-notes-medical"></i>
						</div>
						<h4 class="title">
							<a href="">title</a>
						</h4>
						<p class="description">description</p>
					</div>
				</div>

			</div>
		</section>
		<!-- End Services Section -->

		<!-- ======= Gallery Section ======= -->
		<section id="gallery" class="gallery">
			<div class="container" data-aos="fade-up">

				<div class="section-title">
					<h2>Gallery</h2>
				</div>

				<div class="gallery-slider swiper">
					<div class="swiper-wrapper align-items-center">
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-1.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-1.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-2.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-2.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-3.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-3.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-4.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-4.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-5.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-5.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-6.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-6.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-7.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-7.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
						<div class="swiper-slide">
							<a class="gallery-lightbox"
								href="login_file/assets/img/gallery/gallery-8.jpg"><img
								data-src="login_file/assets/img/gallery/gallery-8.jpg"
								class="img-fluid lazyload" alt=""></a>
						</div>
					</div>
					<div class="swiper-pagination"></div>
				</div>

			</div>
		</section>
		<!-- End Gallery Section -->

		<!-- ======= Frequently Asked Questioins Section ======= -->
		<section id="faq" class="faq section-bg">
			<div class="container" data-aos="fade-up">

				<div class="section-title">
					<h2>Frequently Asked Questioins</h2>
				</div>

				<ul class="faq-list">

					<li>
						<div data-bs-toggle="collapse" class="collapsed question"
							href="#faq1">
							Question 1 ? <i class="bi bi-chevron-down icon-show"></i><i
								class="bi bi-chevron-up icon-close"></i>
						</div>
						<div id="faq1" class="collapse" data-bs-parent=".faq-list">
							<p>Answer 1.</p>
						</div>
					</li>

					<li>
						<div data-bs-toggle="collapse" href="#faq2"
							class="collapsed question">
							Question 2 ? <i class="bi bi-chevron-down icon-show"></i><i
								class="bi bi-chevron-up icon-close"></i>
						</div>
						<div id="faq2" class="collapse" data-bs-parent=".faq-list">
							<p>Answer 2.</p>
						</div>
					</li>

				</ul>

			</div>
		</section>
		<!-- End Frequently Asked Questioins Section -->

		<!-- ======= Contact Section ======= -->
		<section id="contact" class="contact">
			<div class="container">

				<div class="section-title">
					<h2>Contact</h2>
				</div>
			</div>

			<div class="container">

				<div class="row mt-5">

					<div class="col-lg-6">

						<div class="row">
							<div class="col-md-12">
								<div class="info-box">
									<i class="bx bx-map"></i>
									<h3>Our Address</h3>
									<p>
										Room No 234 - South Block, Ministry of Defence, <br /> New
										Delhi.
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="info-box mt-4">
									<i class="bx bx-envelope"></i>
									<h3>Email Us</h3>
									<p>jse[at]nic[dot]in</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="info-box mt-4">
									<i class="bx bx-phone-call"></i>
									<h3>Call Us</h3>
									<p>23019474</p>
								</div>
							</div>
						</div>

					</div>

					<div class="col-lg-6">
						<form action="forms/contact.php" method="post" role="form"
							class="php-email-form">
							<div class="row">
								<div class="col form-group">
									<input type="text" name="name" class="form-control" id="name"
										placeholder="Your Name" required>
								</div>
								<div class="col form-group">
									<input type="email" class="form-control" name="email"
										id="email" placeholder="Your Email" required>
								</div>
							</div>
							<div class="form-group mt-3">
								<input type="text" class="form-control" name="subject"
									id="subject" placeholder="Subject" required>
							</div>
							<div class="form-group mt-3">
								<textarea class="form-control" name="message" rows="5"
									placeholder="Message" required></textarea>
							</div>
							<div class="my-3">
								<div class="loading">Loading</div>
								<div class="error-message"></div>
								<div class="sent-message">Your message has been sent.
									Thank you!</div>
							</div>
							<div class="text-center">
								<button type="button" class="btn-get-started scrollto">Send
									Message</button>
							</div>
						</form>
					</div>

				</div>

			</div>
		</section>
		<!-- End Contact Section -->

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="row">

					<div class="col-lg-12 col-md-12">
						<div class="footer-info">
							<div class="social-links text-center">
								<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
									href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
									href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
								<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
								<a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="credits">
				Designed by <a href="#">Bisag-N</a>
			</div>
		</div>
	</footer>
	<!-- End Footer -->

	<!-- The Modal -->
	<div class="modal" id="myModal">
		<form role="form" name='loginForm'
			action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />"
			method='POST' id="myFormId" class="login-form inputHeight">

			<input type="hidden" id="salt" name="salt" /> <input type="hidden"
				id="iv" name="iv" /> <input type="hidden" id="key" name="key" />

			<div class="modal-dialog modal-fullscreen-md-down">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<!-- color: #c41234; -->
						<h4 class="modal-title">SIGNIN</h4>
						<br />
						<!--         <p>Please enter your credentials to login.</p> -->
						<%-- <p class="red">
							<c:if test="${not empty error}">${error}</c:if>
						</p>
						<p class="red">
							<c:if test="${not empty msg}">${msg}</c:if>
						</p> --%>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="login-content">
							<!-- 					<div class="login-logo">  -->
							<!-- 							<h2>LOGIN</h2> -->

							<!-- 					</div> -->
							<div class="login-form">

								<div class="form-group">
									<input id="username" type='text' name='username'
										class="form-control disablecopypaste" maxlength="30" size="35"
										autocomplete="off" placeholder="Enter Username">
								</div>
								<div class="form-group">
									<input id="password" type='password' name='password'
										class="form-control disablecopypaste" maxlength="28" size="35"
										pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!^\\&_.~*]).{8,28}$"
										autocomplete="off" placeholder="Enter Password" />
								</div>
								<div class="row">
									<div class="col-6 enter_captcha">
										<div class="form-group">
											<input type='text' class="form-control disablecopypaste"
												size="35" id="txtInput" name="txtInput"
												placeholder="Enter Captcha" maxlength="5" autocomplete="off" />
										</div>
									</div>
									<div class="col-6">
										<div class="form-group captcha">
											<div class="input-group">
												<img id="capcha" src="genCapchaCode" class="imgcaptcha"
													class="form-control disablecopypaste" /> <span
													class="input-group-btn d-flex">
													<button class="btn btn-primary btn-sm" id="btnrefresh"
														tabindex="-1" type="button">
														<img src="admin/login_file/images/referesh.ico">
													</button>
												</span>
											</div>
										</div>
									</div>
								</div>

								<input type="hidden" id="csrfIdSet" name="" value="" /> <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />


							</div>
						</div>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">

						<a href="#" title="Forgot Password" id="forgotpassword"
							name="forgotpassword" data-bs-toggle="modal"
							data-bs-target="#forgotModal"><i class="fa fa-key"></i>
							Forgot Password</a>



						<div class="form-group login">
							<button type="submit" id="loginbutton" class="btn btn-primary">LOGIN</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<!-- The Modal -->
	<div class="modal" id="regModal">
		<div class="modal-dialog modal-dialog-centered ">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Registration Form</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<div
						class="container-fluid w3-border w3-padding w3-round ws-grey mb-3">

						<div class="mb-3 mt-3">
							<label for="sel1" class="form-label">Select Service</label> <select
								class="form-select" id="servicetype" name="servicetype"
								tabindex="1">
								<option>Army</option>
								<option>Navy</option>
								<option>Air Force</option>
							</select>
						</div>
						<div class="mb-3 mt-3" id="apptypediv">
							<div class="d-flex">
								<div class="form-check">
									<input type="radio" class="form-check-input" id="apptypeneet"
										name="apptype" value="NEET-PG" checked>NEET-PG<label
										class="form-check-label" for="apptypeneet"></label>
								</div>
								<div class="form-check">
									<input type="radio" class="form-check-input"
										id="apptypednbpdcet" name="apptype" value="DNB-PDCET">DNB-PDCET
									<label class="form-check-label" for="apptypednbpdcet"></label>
								</div>

							</div>
						</div>
						<div class="mb-3 mt-3">
							<label for="email">First Name </label> <input type="textbox"
								class="form-control" id=fnameforreg
								placeholder="Enter your First Name as per NEET-PG"
								name="fnameforreg" maxlength="32" tabindex="2"
								autocomplete="off">
						</div>
						<div class="mb-3 mt-3">
							<label for="email">Middle Name </label> <input type="textbox"
								class="form-control" id=mnameforreg
								placeholder="Enter your Middle Name as per NEET-PG"
								name="mnameforreg" maxlength="32" tabindex="2"
								autocomplete="off">
						</div>
						<div class="mb-3 mt-3">
							<label for="email">Last Name </label> <input type="textbox"
								class="form-control" id=lnameforreg
								placeholder="Enter your Last Name as per NEET-PG"
								name="lnameforreg" maxlength="32" tabindex="2"
								autocomplete="off">
						</div>
						<div class="mb-3 mt-3">
							<label for="email">Email </label> <input type="email"
								class="form-control" id=emailforreg
								placeholder="Enter your email" name="emailforreg"
								maxlength="128" tabindex="3" autocomplete="off">
						</div>

						<div class="mb-3 mt-3" id="neetdiv">
							<label for="neetregno" id="apptypelbl">NEET Registration
								No. </label> <input type="textbox" class="form-control" id=neetregno
								placeholder="Enter Neet Registration Number" name="neetregno"
								maxlength="16" tabindex="4" autocomplete="off">
						</div>
						<div class="mb-3 mt-3" id="dnbdiv">
							<label for="neetregno" id="apptypelbl">DNB-PDCET
								Registration No. </label> <input type="textbox" class="form-control"
								id=dnbpdcetno placeholder="Enter DNB-PDCET Registration Number"
								name="id=dnbpdcetno" maxlength="16" tabindex="4"
								autocomplete="off">
						</div>
						<!-- <div class="mb-3 mt-3">
							<label for="email">Aadhaar Number </label> <input type="textbox"
								class="form-control" id=aadhaarnumber
								placeholder="Enter Aadhaar Number " name="aadhaarnumber"
								maxlength="12" tabindex="5" autocomplete="off">
						</div> -->


						<div class="mb-3 mt-3">
							<button id="otpNo" name="otpNo" type="button"
								class="btn btn btn-primary mb-3" id="otpNo" name="otpNo"
								tabindex="6" autocomplete="off">Send OTP</button>

							<input type="text" class="form-control" id="otp"
								placeholder="enter your otp" name="otp" tabindex="7"
								maxlength="6" autocomplete="off">
							<!-- Time left =  -->
							<div id="timer_div">
								<span class="text-red" id="timer"></span>
							</div>
						</div>
						<div id="otpdivforenter" name="otpdivforenter">
							<div class="mb-3 mt-3">
								<small id="otp_sent" class="form-text text-danger"></small> <span
									for="text-input" class="form-control-label" id="lblOTPText"></span>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn btn-success"
						id="verifyandregister" name="verifyandregister" tabindex="8">Verify
						and Register</button>
				</div>

			</div>
		</div>
	</div>


	<div class="modal" id="forgotModal">
		<div class="modal-dialog modal-dialog-centered ">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Forgot Password</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<div
						class="container-fluid w3-border w3-padding w3-round ws-grey mb-3">


						<div class="mb-3 mt-3">
							<label for="email">User Name </label> <input type="textbox"
								class="form-control" id="usernameforforgot"
								placeholder="Enter your User Name" name="usernameforforgot"
								maxlength="128" tabindex="2" autocomplete="off">
						</div>
						<div class="mb-3 mt-3">
							<label for="email">Email </label> <input type="email"
								class="form-control" id=emailforforgot
								placeholder="Enter your email" name="emailforforgot"
								maxlength="128" tabindex="3" autocomplete="off">
						</div>
						<div class="mb-3 mt-3">
							<button id="otpNoforforgot" name="otpNoforforgot" type="button"
								class="btn btn btn-primary mb-3" tabindex="6" autocomplete="off">Send
								OTP</button>

							<input type="text" class="form-control" id="otpforforgot"
								placeholder="enter your otp" name="otpforforgot" tabindex="7"
								maxlength="6" autocomplete="off">
							<!-- Time left =  -->
							<div id="timer_div">
								<span class="text-red" id="timerforgot"></span>
							</div>
						</div>
						<div id="otpdivforenter" name="otpdivforenter">
							<div class="mb-3 mt-3">
								<small id="otp_sent" class="form-text text-danger"></small> <span
									for="text-input" class="form-control-label" id="lblOTPText"></span>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn btn-success" id="verify"
						name="verify" tabindex="8">Verify</button>
				</div>

			</div>
		</div>
	</div>

	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="admin/layout_file/js/lazysizes.min.js"></script>
	<!--   <script src="admin/login_file/assets/vendor/purecounter/purecounter.js"></script> -->
	<script src="admin/login_file/assets/vendor/aos/aos.js"></script>
	<script
		src="admin/login_file/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="admin/login_file/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="admin/login_file/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<!--   <script src="admin/login_file/assets/vendor/php-email-form/validate.js"></script> -->

	<!-- Template Main JS File -->
	<script src="admin/login_file/assets/js/main.js"></script>


</body>

</html>