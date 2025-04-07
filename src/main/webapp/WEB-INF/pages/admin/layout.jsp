
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%
HttpSession sess = request.getSession(false);
if (sess.getAttribute("username") == null) {
	sess.invalidate();
	response.sendRedirect("../login");
	return;
}

String user_agentWithIp = String.valueOf(sess.getAttribute("user_agentWithIp"));
String userAgent = request.getHeader("User-Agent");
String ip = "";

if (request != null) {
	ip = request.getHeader("X-FORWARDED-FOR");
	if (ip == null || "".equals(ip)) {
		ip = request.getRemoteAddr();
	}
}
String currentuser_agentWithIp = userAgent + "_" + ip;
currentuser_agentWithIp = currentuser_agentWithIp.replace("&#40;", "(");
currentuser_agentWithIp = currentuser_agentWithIp.replace("&#41;", ")");

//out.print(currentuser_agentWithIp+"<=c = s=>"+user_agentWithIp);
if (!user_agentWithIp.equals(currentuser_agentWithIp)) {
	sess.invalidate();
	response.sendRedirect("/login");
	return;
}
%>
<sec:csrfMetaTags />
<!doctype html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title><spring:message code="myapp.title" /></title>

<!-- favicon start-->
<!-- <link rel="shortcut icon" href="assets/images/favicon.ico" /> -->
 <link rel="shortcut icon" type="image/png" sizes="32x32" href="assets/images/favicon-32x32.png"> 
<!-- favicon end-->

<!-- bootstrap start -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<script src="assets/vendor/bootstrap/js/popper.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- bootstrap end -->

<!-- Jquery Start -->
<script src="assets/js/jquery-3.7.1.min.js"></script>
<!-- Jquery End -->

<!-- icon start -->
<link rel="stylesheet" href="assets/fonts/line-awesome/dist/line-awesome/css/line-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/@fortawesome/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="assets/fonts/remixicon/fonts/remixicon.css">
<!-- icon end -->

<!-- datatable start -->
<link href="assets/vendor/datatable/datatables.min.css" rel="stylesheet" />
<script src="assets/vendor/datatable/datatables.min.js"></script>
<link href="assets/vendor/datatable/custom-datatable.css" rel="stylesheet" />
<script src="assets/vendor/datatable/jquery.mockjax.js"></script>
<!-- datatable end -->

<!-- jquery confirm alert start -->
<link rel="stylesheet" href="assets/vendor/jquery_confirm/jquery-confirm.min.css">
<script type="text/javascript" src="assets/vendor/jquery_confirm/jquery-confirm.min.js"></script>
<!-- Jquery confirm alert end -->

 <!-- compulsory js start -->
<script type="text/javascript" src="assets/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="assets/js/AES_ENC_DEC/lib/aes.js"></script>
<script type="text/javascript" src="assets/js/AES_ENC_DEC/lib/pbkdf2.js"></script>
<script type="text/javascript" src="assets/js/AES_ENC_DEC/AesUtil.js"></script>
<script type="text/javascript" src="assets/dev_module_list/CommonValidation.js"></script>
<script src="assets/js/layout.js"></script>
 <!-- compulsory js end -->

<!-- dashboard style start -->
<link rel="stylesheet" href="assets/css/db-style.css">
<link rel="stylesheet" href="assets/css/db-responsive.css">
<!-- dashboard style end -->
</head>

<body class="page-block" oncontextmenu="return false">
	<c:if test="${not empty msg}">
		<input type="hidden" name="msg" id="msg" value="${msg}"
			disabled="disabled" />
	</c:if>
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<!-- wrapper start -->
	<div class="wrapper">
	    <!-- loader start -->
		<div id="loading">
			<div id="loading-center"></div>
			<div id="loading-center1"></div>
		</div>
		<!-- loader end -->
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />	
	</div>
	<!-- wrapper end-->
	<tiles:insertAttribute name="footer"/>
	<!-- app javaScript start-->
    <script src="assets/js/main.js"></script>
    <!-- app javaScript end-->
</body>
</html>