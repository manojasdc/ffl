<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<link rel="stylesheet" href="admin/assets/vendor/calender/calendar.css">

<div class="main-page-content custom-aim-page" id="top">
	<div class="custom-main-breadcrum">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="custom-breadcrum">
						<div class="iq-members">
							<h1 class="page-title">Academic Calendar</h1>
						</div>
						<div class="page-breadcrumb">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="landing">Home</a></li>
									<li class="breadcrumb-item active" aria-current="aim">Calendar</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="custom-caledar-base">
			<div class="calendar-base">

				<div class="year">2017</div>
				<!-- year -->

				<div class="triangle-left"></div>
				<!--triangle -->
				<div class="triangle-right"></div>
				<!--  triangle -->

				<div class="months">
					<span class="month-hover">Jan</span> <span class="month-hover">Feb</span>
					<span class="month-hover">Mar</span> <strong class="month-color">Apr</strong>
					<span class="month-hover">May</span> <span class="month-hover">Jun</span>
					<span class="month-hover">July</span> <span class="month-hover">Aug</span>
					<span class="month-hover">Sep</span> <span class="month-hover">Oct</span>
					<span class="month-hover">Nov</span> <span class="month-hover">Dec</span>
				</div>
				<!-- months -->
				<hr class="month-line" />

				<div class="days">SUN MON TUE WED THU FRI SAT</div>
				<!-- days -->

				<div class="num-dates">

					<div class="first-week">
						<span class="grey">26 27 28 29 30 31</span> 01
					</div>
					<!-- first week -->
					<div class="second-week">02 03 04 05 06 07 08</div>
					<!-- week -->
					<div class="third-week">09 10 11 12 13 14 15</div>
					<!-- week -->
					<div class="fourth-week">16 17 18 19 20 21 22</div>
					<!-- week -->
					<div class="fifth-week">
						23 24 25 26 <strong class="white">27</strong> 28 29
					</div>
					<!-- week -->
					<div class="sixth-week">
						30 <span class="grey">01 02 03 04 05 06</span>
					</div>
					<!-- week -->
				</div>
				<!-- num-dates -->
				<div class="event-indicator"></div>
				<!-- event-indicator -->
				<div class="active-day"></div>
				<!-- active-day -->
				<div class="event-indicator two"></div>
				<!-- event-indicator -->

			</div>
			<!-- calendar-base -->
			<div class="calendar-left">

				<div class="hamburger">
					<div class="burger-line"></div>
					<!-- burger-line -->
					<div class="burger-line"></div>
					<!-- burger-line -->
					<div class="burger-line"></div>
					<!-- burger-line -->
				</div>
				<!-- hamburger -->


				<div class="num-date">27</div>
				<!--num-date -->
				<div class="day">THURSDAY</div>
				<!--day -->
				<div class="current-events">
					Current Events <br />
					<ul>
						<li>Day 09 Daily CSS Image</li>
					</ul>
					<span class="posts">See post events</span>
				</div>
				<!--current-events -->

				<div class="create-event">Create an Event</div>
				<!-- create-event -->
				<hr class="event-line" />
				<div class="add-event">
					<span class="add">+</span>
				</div>
				<!-- add-event -->

			</div>
			<!-- calendar-left -->

		</div>
	</div>
	<!-- container -->

</div>
