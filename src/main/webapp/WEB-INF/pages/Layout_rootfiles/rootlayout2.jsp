<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<!doctype html>
<html>
<tiles:importAttribute name="title" />
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta property="og:locale" content="en_US">
<meta property="og:type" content="website">
<meta property="og:title" content="Home - Friends For Life">
<meta property="og:url" content="http://localhost:8012/FriendsForLife/index">
<meta property="og:site_name" content="Friends For Life & English Proficiency Test">
<meta property="article:modified_time" content="2023-01-09T12:41:28+00:00">
<meta name="author" content="Friends For Life & English Proficiency Test">
<meta name="description" content="This portal is the alumni portal for Cat'A Institute. After completing their training, all  trainees can connect through this software.">
<meta name="keywords" content="This portal is the alumni portal for Cat'A Institute. After completing their training, all trainees can connect through this software.">

<title>Welcome Page</title>

<!-- Favicons -->
<link rel="icon" type="image/png" sizes="32x32"
	href="admin/assets/images/favicon-32x32.png">
<!-- favicon end-->

<!-- bootstrap start -->
<link rel="stylesheet"
	href="admin/assets/vendor/bootstrap/css/bootstrap.min.css">
<script src="admin/assets/vendor/bootstrap/js/popper.min.js"></script>
<script src="admin/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- bootstrap end -->

<!-- Jquery Start -->
<script src="admin/assets/js/jquery-3.7.1.min.js"></script>
<!-- Jquery End -->

<!-- icon start -->
<link rel="stylesheet" href="admin/assets/fonts/line-awesome/dist/line-awesome/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css" href="admin/assets/fonts/fontawesome/css/all.min.css">
<link rel="stylesheet" href="admin/assets/fonts/remixicon/fonts/remixicon.css">
<!-- icon end -->

<!-- compulsory js start -->
<script src="admin/login_file/js/jquery.blockUI.js"></script>
<script src="admin/login_file/js/loginfunction.js"></script>
<script type="text/javascript" src="admin/login_file/js/aes.js"></script>
<script type="text/javascript" src="admin/login_file/js/pbkdf2.js"></script>
<script type="text/javascript" src="admin/login_file/js/AesUtil.js"></script>
<!-- compulsory js end -->

<!--munu css start-->
<!-- <link href="admin/assets/vendor/ace_menu/css/ace-responsive-menu.css" rel="stylesheet" type="text/css" /> -->
<!--munu css start-->

<!-- carousal css start-->
<!-- <script src="admin/assets/vendor/owlcarousel/owl-carousel.js"></script> -->
<!-- <link rel="stylesheet" href="admin/assets/vendor/owlcarousel/owl.css"> -->
<!-- carousal css end-->

<!-- additional css files start-->
<link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">
<link rel="stylesheet" href="admin/assets/css/outercss/responsive.css">
<link rel="stylesheet" href="admin/assets/css/outercss/animate.css">
<!-- additional css files end-->

<!-- jquery confirm alert start -->
<link rel="stylesheet" href="admin/assets/vendor/jquery_confirm/jquery-confirm.min.css">
<script type="text/javascript" src="admin/assets/vendor/jquery_confirm/jquery-confirm.min.js"></script>
<!-- Jquery confirm alert end -->

<!-- Theme switch mode Files -->
<link rel="stylesheet" type="text/css" href="admin/assets/vendor/themeSwitchMode/switchmodestyle.css">
<link rel="stylesheet" type="text/css" href="admin/assets/vendor/themeSwitchMode/themeswitch-mode.css">
<script src="admin/assets/vendor/themeSwitchMode/themeswitchermode.js"></script>

<!-- language js start -->
<!-- 	<script src="assets/vendor/g_translate/g_translate.js"></script> -->
<%-- <script src="https://translate.google.com/translate_a/element.js?cb=initializeGoogleTranslate" nonce="${cspNonce}"></script> --%>
<!-- language js end -->

</head>

<body class="custom-page-body <c:choose><c:when test="${title == 'common'}">header1</c:when><c:when test="${title == 'common2'}">header2</c:when><c:otherwise>theme-default</c:otherwise></c:choose> light-mode" id="body">

	<c:if test="${not empty msg}">
		<input type="hidden" name="msg" id="msg" value="${msg}"
			disabled="disabled" />
	</c:if>
	<c:choose>
		<c:when test="${title == 'common'}">
			<tiles:insertAttribute name="header" />
		</c:when>
	    <c:when test="${title == 'common2'}">
			<tiles:insertAttribute name="header2" />
		</c:when>
		<c:otherwise>
			<tiles:insertAttribute name="header" />
		</c:otherwise>
		</c:choose>
	<!-- ***** preloader start ***** -->
	<div id="js-preloader" class="js-preloader">
		<div class="preloader-inner">
			<span class="dot"></span>
			<div class="dots">
				<span></span> <span></span> <span></span>
			</div>
		</div>
	</div>
	<!-- ***** preloader end ***** -->
	<!-- ***** page content start ***** -->
	<tiles:insertAttribute name="body" />
	<!-- ***** page content end ***** -->
<%-- 	<tiles:insertAttribute name="footer" /> --%>
    <c:choose>
		<c:when test="${title == 'common'}">
			<tiles:insertAttribute name="footer" />
		</c:when>
	     <c:when test="${title == 'common2'}">
			<tiles:insertAttribute name="footer2" />
		</c:when>
		<c:otherwise>
			<tiles:insertAttribute name="footer" />
		</c:otherwise>
		</c:choose>
	<!-- Menu scripts start-->
<!-- 	<script src="admin/assets/vendor/ace_menu/js/ace-responsive-menu.js" -->
<!-- 		type="text/javascript"></script> -->
	<!-- Menu scripts end-->
	<!-- scripts start-->
	<script src="admin/assets/vendor/page-fontsize/page_fontsize.js"></script>
	<script src="admin/assets/js/outerjs/isotope.min.js"></script>
	<script src="admin/assets/js/outerjs/custom.js"></script>
	<!-- scripts end-->
</body>

</html>
