<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<!-- <script src="assets/dev_module_list/E_journals.js"></script> -->
<script src="assets/dev_module_list/e_journals_dtl.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>

<!-- <script src="assets/vendor/custom-rating.js"></script> -->
<!-- Select End -->


<div class="content-page E_Journal_dtlPage">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">E Journals Detail Page</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item"><a href="E_Journals">E
										Journals ${dashname}</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">E
									Journals Detail Page</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="card-block-wrapper">
					<div class="card card-block card-stretch card-height reg-card">
						<div class="card-body">
							<div class="row" id="EjournalDtl">
							<input type="hidden" name="totalpage" id="totalpage"
									value="${totalpages}" />
<!-- 								<div class="col-lg-3 col-md-3 col-sm-12 col-12"> -->
<!-- 									<div class="custom-jcover-wrapper"> -->
<!-- 										<div class="custom-jcover"> -->
<!-- 											<img class="img-fluid" alt="Journal" -->
<!-- 												src="assets/images/journals/kargil.jpg"> -->
<!-- 										</div> -->
<!-- 										<div class="jcover-btn"> -->
<!-- 											<a href="assets/pdf/sample.pdf" class="btn btn-primary" target="blank"> -->
<!-- 												<i class="ri-book-open-fill"></i><span class="btn-text">Read Now</span> -->
<!-- 											</a> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-9 col-md-9 col-sm-12 col-12"> -->
<!-- 									<div class="custom-jinfo"> -->
<!-- 										<div class="custom-jinfo-detblc"> -->
<!-- 											<h3 class="custom-detblc-title">1971 : Charge of the -->
<!-- 												Gorkhas and Other Stories</h3> -->
<!-- 											<p class="custom-detblc-text"> -->
<!-- 												<span class="text-black-hl">By</span> <span -->
<!-- 													class="text-heighlight">Deepak Surana</span> -->
<!-- 											</p> -->
<!-- 											<div class="custom-rating-v2 custom-rating-count"> -->
<!-- 												<div class="score"> -->
<!-- 													<span class="score-rating js-score">4.0</span> -->
<!-- 												</div> -->
<!-- 												<div class="rating" data-vote="0"> -->
<!-- 													<div class="star animate"> -->
<!-- 														<span class="full star-colour" data-value="1"></span> <span -->
<!-- 															class="half star-colour" data-value="0.5"></span> <span -->
<!-- 															class="selected star-colour"></span> -->
<!-- 													</div> -->
<!-- 													<div class="star animate"> -->
<!-- 														<span class="full star-colour" data-value="2"></span> <span -->
<!-- 															class="half star-colour" data-value="1.5"></span> <span -->
<!-- 															class="selected star-colour"></span> -->
<!-- 													</div> -->
<!-- 													<div class="star animate"> -->
<!-- 														<span class="full star-colour" data-value="3"></span> <span -->
<!-- 															class="half star-colour" data-value="2.5"></span> <span -->
<!-- 															class="selected star-colour"></span> -->
<!-- 													</div> -->
<!-- 													<div class="star"> -->
<!-- 														<span class="full star-colour" data-value="4"></span> <span -->
<!-- 															class="half star-colour" data-value="3.5"></span> <span -->
<!-- 															class="selected star-colour"></span> -->
<!-- 													</div> -->
<!-- 													<div class="star"> -->
<!-- 														<span class="full" data-value="5"></span> <span -->
<!-- 															class="half last-star" data-value="4.5"></span> <span -->
<!-- 															class="selected"></span> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="custom-jinfo-ext"> -->
<!-- 											<ul class="custom-det-list"> -->
<!-- 												<li class="custom-det-item"><span -->
<!-- 													class="custom-data-value"> <span -->
<!-- 														class="custom-data-title"> <span -->
<!-- 															class="custom-dt-i"><i class="fa fa-user"></i></span>Publisher: -->
<!-- 													</span> <span class="custom-data-text">Penguin Random House -->
<!-- 															India (English), Prabhat Prakashan (Hindi)</span> -->
<!-- 												</span></li> -->
<!-- 												<li class="custom-det-item"><span -->
<!-- 													class="custom-data-value"><span -->
<!-- 														class="custom-data-title"><span class="custom-dt-i"><i -->
<!-- 																class="fa fa-calendar"></i></span>Publication Date:</span><span -->
<!-- 														class="custom-data-text">20 December 2021 -->
<!-- 															(English), 3 June 2023 (Hindi)</span></span></li> -->
<!-- 												<li class="custom-det-item"><span -->
<!-- 													class="custom-data-value"><span -->
<!-- 														class="custom-data-title"><span class="custom-dt-i"><i -->
<!-- 																class="fa fa-language"></i></span>Language:</span><span -->
<!-- 														class="custom-data-text">English, Hindi</span></span></li> -->
<!-- 												<li class="custom-det-item"><span -->
<!-- 													class="custom-data-value"><span -->
<!-- 														class="custom-data-title"><span class="custom-dt-i"><i -->
<!-- 																class="fa fa-book"></i></span>Book Length:</span><span -->
<!-- 														class="custom-data-text">200</span></span></li> -->
<!-- 											</ul> -->
<!-- 											<p class="custom-detblc-text">On the fiftieth anniversary -->
<!-- 												of the 1971 Indo-Pak war, revisit its battlefields through -->
<!-- 												stories of bravehearts from the army, navy and air force who -->
<!-- 												fought for a cause that meant more to them than their own -->
<!-- 												lives. Why do the Gorkha soldiers of 4/5 GR attack a heavily -->
<!-- 												defended enemy post with just naked khukris in their hands? -->
<!-- 												Does Pakistan find out the real identity of the young pilot -->
<!-- 												who, after having ejected from a burning plane, calls -->
<!-- 												himself Flt Lt Mansoor Ali Khan? What awaits the naval diver -->
<!-- 												who cuts made-in-India labels off his clothes and crosses -->
<!-- 												into East Pakistan with a machine gun slung across his back? -->
<!-- 												Why is a twenty-one-year-old Sikh paratrooper being taught -->
<!-- 												to jump off a stool in a deserted hangar at Dum Dum airport -->
<!-- 												with a Packet aircraft waiting nearby? 1971 is a deeply -->
<!-- 												researched collection of true stories of extraordinary human -->
<!-- 												grit and courage that shows you a side to war that few -->
<!-- 												military histories do.</p> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
							</div>
							<div class="pagination center">
								<ul class="pagination-list" id="pagination">
								</ul>
							</div>
						</div>
					</div>
					<div class="card card-block card-stretch card-height news-card">
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">
									What's New Scroll<span class="blink-image"><img
										class="img-fluid" src="assets/images/new_blink.gif"></span>
								</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-12">
									<marquee id="marq_id" behavior="scroll" loop="true"
										direction="up" scrolldelay="50" class="marquee-content">
										<ul class="news-wrapper" id="allwhatsnew">
											
										</ul>
									</marquee>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>