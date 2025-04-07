<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="layout_file/js/commondashboard.js"></script>

<script src="layout_file/js/core.js"></script>
<script src="layout_file/js/charts.js"></script>
<script src="layout_file/js/animated.js"></script>

<div id="commondashboard" name="commondashboard">
	<meta name="_csrf" content="${_csrf.token}" />
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}" />
	<div class="container mt-4">

		<div
			class="container-fluid w3-border w3-round w3-padding  ws-grey mb-3 main-form">
			<div class="row" align="center">
				<div class="col-12">
					<h6>WelCome ${username}</h6>
				</div>
			</div>
		</div>
		<div
			class="container-fluid w3-border w3-round w3-padding  ws-grey mb-3 main-form">
			<div class="row" align="center">
				<div class="col-12">
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
				</div>
			</div>
		</div>

		<div class="row" align="center">
			<div class="col-6">
				<div id="chartdiv"></div>
			</div>
			<div class="col-6">
				<div id="chartdiv1"></div>
			</div>
		</div>


		<div class="row" align="center">
			<div class="col-12">
				<div id="chartdiv2"></div>
			</div>
		</div>

	</div>
</div>