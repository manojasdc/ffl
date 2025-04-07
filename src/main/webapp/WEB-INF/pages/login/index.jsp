<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />

<!-- slick css start -->
<link rel="stylesheet" type="text/css"
	href="admin/assets/vendor/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="admin/assets/vendor/slick/slick-theme.css">
<link rel="stylesheet" type="text/css"
	href="admin/assets/vendor/slick/custom-slick.css">
<!-- slick css end -->

<div class="main-page-content welcome-page" id="top">
	<section class="min-height-block welcome-bg">
		<div class="row">
			<div class="col-xl-3 col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="custom-info-left">
				<div class="custom-info-section c-hist-blc">
					<div class="custom-info-header">
						<h5 class="title">History of Military Cooperation & Joint
							Training</h5>
					</div>
					<div class="custom-info-alerts">
						<marquee id="marq_id" behavior="scroll" loop="true" direction="up"
							scrollamount="6" scrolldelay="50">
							<p class="custom-info-text">The use of military exercises and
								war games can be found to date back to as early as the early
								19th century, wherein it was the officers of the Prussian Army
								who created the contemporary, tactical form of wargames that
								have since been more widely used and developed by other military
								conglomerations throughout the world. Non-tactical forms of
								wargames have existed for much longer, however, in the forms of
								tabletop games such as chess and Go.</p>
							<p class="custom-info-text">The modern use of military
								exercises grew out of the military need to study warfare and to
								reenact old battles for learning purposes. During the age of
								Kabinettskriege (Cabinet wars), Frederick the Great, King of
								Prussia from 1740 to 1786, "put together his armies as a
								well-oiled clockwork mechanism whose components were robot-like
								warriors. No individual initiative was allowed to Frederick's
								soldiers; their only role was to cooperate in the creation of
								walls of projectiles through synchronized firepower." This was
								in the pursuit of a more effective army, and such practices made
								it easier to look at war from a top-down perspective.
								Disciplined troops should respond predictably, allowing study to
								be confined to maneuvers and command.</p>
						</marquee>
					</div>
				</div>
				<div class="custom-info-section c-event-blc">
					<div class="custom-info-header">
						<h5 class="title">Latest Events</h5>
					</div>
					<div class="custom-img-slider" id="pg-slider">
						<div class="photo-gallery-thumb">
							<div title="" class="img-thumb">
								<img src="admin/assets/images/11878.webp" alt=""
									class="img-fluid">
							</div>

						</div>
						<div class="photo-gallery-thumb">
							<div title="" class="img-thumb">
								<img src="admin/assets/images/11879.webp" alt=""
									class="img-fluid">
							</div>

						</div>
						<div class="photo-gallery-thumb">
							<div title="" class="img-thumb">
								<img src="admin/assets/images/11881.webp" alt=""
									class="img-fluid">
							</div>

						</div>
						<div class="photo-gallery-thumb">
							<div title="" class="img-thumb">
								<img src="admin/assets/images/11882.webp" alt=""
									class="img-fluid">
							</div>

						</div>
					</div>
					<div class="ticker-controls">
						<div class="ticker-ctrl-block">
							<a class="ctrl-btns prev_btn" href="javascript:void(0)"
								id="pg_slider_Pre" title="Click to Previous"><i
								class="fa-solid fa-arrow-left"></i></a> <a class="ctrl-btns nex_btn"
								href="javascript:void(0)" id="pg_slider_Nxt"
								title="Click to Next"><i class="fa-solid fa-arrow-right"></i></a>
							<a class="ctrl-btns pause_btn" href="javascript:void(0)"
								id="pg_slider_Toggle_btn" title="Click to Play/Pause"> <i
								class="fa fa-pause-circle"></i>
							</a>
						</div>

					</div>
				</div>
</div>
			</div>
			<div class="col-xl-6 col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="custom-info-center">
				<div class="row h-100">
					<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
						<div class="custom-card-v3 card-clr1 custom-card-height">
							<div class="outer">
								<div class="dot"></div>
								<div class="card">
									<div class="ray"></div>
									<div class="cardv3-img">
										<img src="admin/assets/images/ffl.webp" class="img-fluid"
											title="Friends For Life" alt="Friends For Life">
									</div>
									<div class="text">
										<h6 class="title-text">Friends For Life</h6>
										<p class="info-text">This portal is the alumni portal for
											Cat'A Institute. After completing their training, all
											trainees can connect through this software.</p>
									</div>
									<div class="cardv3-btn">
										<a class="box__link button-animation" href="/FriendsForLife/landing">Expore More<span></span>
											<span></span> <span></span> <span></span>
										</a>
									</div>
									<div class="line topl"></div>
									<div class="line leftl"></div>
									<div class="line bottoml"></div>
									<div class="line rightl"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
						<div class="custom-card-v3 card-clr2 custom-card-height">
							<div class="outer">
								<div class="dot"></div>
								<div class="card">
									<div class="ray"></div>
									<div class="cardv3-img">
										<img src="admin/assets/images/examimg.webp" class="img-fluid"
											title="English Proficiency Test"
											alt="English Proficiency Test">
									</div>
									<div class="text">
										<h6 class="title-text">English Proficiency Test</h6>
										<p class="info-text">English Language Proficiency of
											trainees for Friendly Foreign Countries (FFCs) in Indian Army
											Training Institutes.</p>
									</div>
									<div class="cardv3-btn">
										<a class="box__link button-animation" href="#">Expore More<span></span>
											<span></span> <span></span> <span></span>
										</a>
										<!-- 							<button class="box explorebtn"> -->
										<!-- 								<a href="#" class="text-button" title="Click Here to Redirect">Expore More</a> -->
										<!-- 							</button> -->
									</div>
									<div class="line topl"></div>
									<div class="line leftl"></div>
									<div class="line bottoml"></div>
									<div class="line rightl"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
			</div>
			<div class="col-xl-3 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-info-section notices-box custom-info-full">
					<div class="custom-info-header">
						<h5 class="title">Latest News</h5>
					</div>
					<div class="custom-info-alerts info-alerts-full">
						<div class="notice-body">
							<div class="newsBox">
								<ul class="news-list SliderLN verticleSlider">
									<li><a href="#" class="news-single"
										title="REGISTRATION OF VENDORS AS APPROVED CONTRACTORS - DIRECTORATE GENERAL OF SUPPLIES AND TRANSPORT">
											<div class="date">
												<h5>23</h5>
												<h6>Jul 2024</h6>
											</div>
											<div class="news-text">REGISTRATION OF VENDORS AS
												APPROVED CONTRACTORS - DIRECTORATE GENERAL OF SUPPLIES AND
												TRANSPORT</div>
									</a></li>
									<li><a href="#" class="news-single"
										title="ADVERTISEMENT ARMY HEADQUARTERS SELECTION BOARD FOR SPECIALISED FIELDS 2024">
											<div class="date">
												<h5>15</h5>
												<h6>Jul 2024</h6>
											</div>
											<div class="news-text">ADVERTISEMENT ARMY HEADQUARTERS
												SELECTION BOARD FOR SPECIALISED FIELDS 2024</div>
									</a></li>
									<li><a href="#" class="news-single"
										title="DGR EX-SERVICEMEN JOB FAIR AT BENGALURU ON 19 JUL 2024">
											<div class="date">
												<h5>10</h5>
												<h6>Jul 2024</h6>
											</div>
											<div class="news-text">DGR EX-SERVICEMEN JOB FAIR AT
												BENGALURU ON 19 JUL 2024</div>
									</a></li>
									<li><a href="#" class="news-single"
										title="CUNPK NEWSLETTER JUN 2024">
											<div class="date">
												<h5>1</h5>
												<h6>Jul 2024</h6>
											</div>
											<div class="news-text">CUNPK NEWSLETTER JUN 2024</div>
									</a></li>
									<li><a href="#" class="news-single"
										title="LAUNCH OF INTERACTIVE VOICE RESPONSE SYSTEM (IVRS)">
											<div class="date">
												<h5>28</h5>
												<h6>Jun 2024</h6>
											</div>
											<div class="news-text">LAUNCH OF INTERACTIVE VOICE
												RESPONSE SYSTEM (IVRS)</div>
									</a></li>
								</ul>
							</div>

							<div class="ticker-controls">
								<div class="ticker-ctrl-block">
									<a class="ctrl-btns prev_btn" href="javascript:void(0)"
										id="ltNews-prev" title="Click to Previous"><i
										class="fa fa-arrow-up"></i></a> <a class="ctrl-btns nex_btn"
										href="javascript:void(0)" id="ltNews-next"
										title="Click to Next"><i class="fa fa-arrow-down"></i></a> <a
										class="ctrl-btns pause_btn" href="javascript:void(0)"
										id="ltNews_Toggle_btn"> <i class="fa fa-pause-circle"
										title="Click to Play/Pause"></i>
									</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

</div>

<!-- slick js start -->
<script src="admin/assets/vendor/slick/slick.min.js"></script>
<script src="admin/assets/vendor/slick/newsticker.js"></script>
<script src="admin/assets/vendor/slick/custom-slick.js"></script>
<!-- slick js end -->
<script src="admin/assets/vendor/marquee/marquee.js"></script>
<!-- equal hight js start -->
<script
	src="admin/assets/vendor/equal-height/jquery-equal-height.min.js"></script>
<!-- equal hight js end -->
<script nonce="${cspNonce}">
	function equal_height() {
		// Equal Card Height and Text Height
		$('.custom-card-height').jQueryEqualHeight('.text .title-text');
		$('.custom-card-height').jQueryEqualHeight('.text .info-text');
	}
	$(window).on('load', function(event) {
		equal_height();
	});
	$(window).resize(function(event) {
		equal_height();
	});
</script>