<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <sec:csrfMetaTags /> --%>
<script src="admin/assets/js/outerjs/hide_header_footer.js"></script>
<script type="text/javascript" src="admin/assets/dev_module_list/error.js"></script>

<div class="main-page-content error-page">
	<section class="page-p-tb" id="top-content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="iq-error">
						<img src="admin/assets/images/outerimages/oops.png"
							class="img-fluid iq-error-img img1" alt="500-error">
						<h1>${errorCode}</h1>
						<p class="custom-errormessage">${errorMessage}</p>
						<a class="btn btn-primary custom-btn-lg mt-4" href="landing"><i
							class="fa-solid fa-house mr-2"></i>Back to Home</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>





