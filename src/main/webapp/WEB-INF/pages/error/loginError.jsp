<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript" src="assets/dev_module_list/error.js"></script>

<div class="content-page error-page">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="iq-error">
					<img src="assets/images/outerimages/oops.png" class="img-fluid iq-error-img" alt="404-error">
					<h1>${errorCode}</h1>
					<p class="custom-errormessage">${errorMessage}</p>
					<a href="commonDashboard"><button type="button"
							class="btn btn-success btn-err">
							<i class="ri-home-8-fill"></i>Back to Home
						</button></a>
				</div>
			</div>
		</div>
	</div>
</div>
