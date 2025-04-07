<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Select Start -->
<link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
<link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
<script src="assets/vendor/dropDown/select2.min.js"></script>
<script src="assets/vendor/dropDown/custom-select2.js"></script>
<script src="assets/js/outerjs/marqueetagstop.js"></script>
<script src="assets/dev_module_list/viewwhatsnewscroll.js"></script>
<script src="assets/dev_module_list/viewallnews.js"></script>

<!-- Select End -->


<div class="content-page all_news">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="custom-breadcrum">
					<div class="iq-members">
						<h1 class="page-title">FFL All News Letters</h1>
					</div>
					<div class="page-breadcrumb">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="commonDashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="commonDashboard">${dashname}
										Dashboard</a></li>
								<li class="breadcrumb-item"><a href="FFL_newsletter">FFL
										News Letters</a></li>
								<li class="breadcrumb-item active" aria-current="demo_page">FFL
									All News Letters</li>
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
						<div class="card-header">
							<div class="header-title">
								<h4 class="card-title">All Latest News</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<input type="hidden" name="totalpage" id="totalpage"
									value="${totalpages}" /> <input type="hidden" name="dashname"
									id="dashname" value="${dashname}" />
								<div class="col-lg-12 col-md-12 col-sm-12 col-12 z-1"
									id="allNData">
									<ul class="updates-data all-data">
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">21</span> <span class="info-sub">Dec -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">Indian -->
										<!-- 														Army conducts patrolling on LoC opposite Pak posts at -->
										<!-- 														4,000 feet height amid heavy snow.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">09</span> <span class="info-sub">Jan -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">The -->
										<!-- 														Indian Army will host a two-day conference of Army chiefs -->
										<!-- 														of the Indo-Pacific nations to discuss strategies for -->
										<!-- 														peace and stability in the region.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">15</span> <span class="info-sub">Dec -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">The -->
										<!-- 														poignant arrival of the mortal remains of national heroes, -->
										<!-- 														who tragically lost their lives during an encounter with -->
										<!-- 														terrorists in Anantnag on September 13, 2023, has brought -->
										<!-- 														forth emotional scenes as they reach their respective -->
										<!-- 														hometowns.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">24</span> <span class="info-sub">Aug -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">Filling -->
										<!-- 														up the post of Director General, Central Council for -->
										<!-- 														Research.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">15</span> <span class="info-sub">Dec -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">The -->
										<!-- 														poignant arrival of the mortal remains of national heroes, -->
										<!-- 														who tragically lost their lives during an encounter with -->
										<!-- 														terrorists in Anantnag on September 13, 2023, has brought -->
										<!-- 														forth emotional scenes as they reach their respective -->
										<!-- 														hometowns.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">15</span> <span class="info-sub">Dec -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">The -->
										<!-- 														poignant arrival of the mortal remains of national heroes, -->
										<!-- 														who tragically lost their lives during an encounter with -->
										<!-- 														terrorists in Anantnag on September 13, 2023, has brought -->
										<!-- 														forth emotional scenes as they reach their respective -->
										<!-- 														hometowns.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">21</span> <span class="info-sub">Dec -->
										<!-- 														2021</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">Filling -->
										<!-- 														up the post of Director General, Central Council for -->
										<!-- 														Research.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">21</span> <span class="info-sub">Dec -->
										<!-- 														2021</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">Filling -->
										<!-- 														up the post of Director General, Central Council for -->
										<!-- 														Research.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">15</span> <span class="info-sub">Dec -->
										<!-- 														2022</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">The -->
										<!-- 														poignant arrival of the mortal remains of national heroes, -->
										<!-- 														who tragically lost their lives during an encounter with -->
										<!-- 														terrorists in Anantnag on September 13, 2023, has brought -->
										<!-- 														forth emotional scenes as they reach their respective -->
										<!-- 														hometowns.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->
										<!-- 										<li class="update-wrapper"> -->
										<!-- 											<div class="date-with-list"> -->
										<!-- 												<div class="info-date"> -->
										<!-- 													<span class="info-main">29</span> <span class="info-sub">Dec -->
										<!-- 														2024</span> -->
										<!-- 												</div> -->
										<!-- 												<div class="info-content"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" target="_blank">Filling -->
										<!-- 														up the post of Director General, Central Council for -->
										<!-- 														Research.</a> -->
										<!-- 												</div> -->
										<!-- 												<div class="pdf-btn"> -->
										<!-- 													<a href="assets/pdf/sample.pdf" class="view-pdf-btn" -->
										<!-- 														target="_blank" -->
										<!-- 														title="Click Here to View PDF file that opens in new window"> -->
										<!-- 														<i class="fas fa-file-pdf"></i> -->
										<!-- 													</a> <span class="pdf-size">(222 KB)</span> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</li> -->

									</ul>
								</div>
								<ul id="pagination" class="pagination-wrapper">
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





