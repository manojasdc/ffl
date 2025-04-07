<%-- <%@page import="com.itextpdf.text.log.SysoLogger"%> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
 
<%
	HttpSession sess = request.getSession(false);
	if (sess.getAttribute("username") == null) {
		sess.invalidate();
		response.sendRedirect("/login"); return; 
	} 
	
	String user_agentWithIp = String.valueOf(sess.getAttribute("user_agentWithIp"));
	String userAgent = request.getHeader("User-Agent");
    String ip = "";

	if (request != null) {
        ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null || "".equals(ip)){
            ip = request.getRemoteAddr();
        }
    }
	String currentuser_agentWithIp = userAgent+"_"+ip;
	currentuser_agentWithIp = currentuser_agentWithIp.replace("&#40;","(");
	currentuser_agentWithIp = currentuser_agentWithIp.replace("&#41;",")");
	
	//out.print(currentuser_agentWithIp+"<=c = s=>"+user_agentWithIp);
	if(!user_agentWithIp.equals(currentuser_agentWithIp)){
		sess.invalidate();
		response.sendRedirect("/login"); return; 
	}
%>
<sec:csrfMetaTags /> 
<!doctype html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="myapp.title" /></title>
  	<link rel="shortcut icon" href="admin/layout_file/images/favicon.png" >
  	<link rel="stylesheet" href="admin/layout_file/css/font-awesome.min.css">
  	<link rel="stylesheet" href="admin/layout_file/bootstrap/css/bootstrap.min.css">
  	<script type="text/javascript" src="admin/layout_file/bootstrap/js/bootstrap.bundle.min.js"></script> 
	<link rel="stylesheet" href="admin/layout_file/css/style.css">
	<link rel="stylesheet" href="admin/layout_file/css/horizontalnavbar.css">	
	<script type="text/javascript" src="admin/layout_file/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="admin/layout_file/js/jquery.blockUI.js"></script> 
	<script src="admin/layout_file/js/plugins.js"></script> 
	<script src="admin/layout_file/js/main.js"></script> 
	
	<script type="text/javascript" src="js/AES_ENC_DEC/lib/aes.js"></script>
	<script type="text/javascript" src="js/AES_ENC_DEC/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="js/AES_ENC_DEC/AesUtil.js"></script> 
	
<link href="js/jquery/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/jquery/jquery-ui.js" type="text/javascript"></script>

	<link rel="stylesheet" href="admin/layout_file/datatable/css/datatables.min.css">	
	<script type="text/javascript" src="admin/layout_file/datatable/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="admin/layout_file/datatable/js/jquery.mockjax.js"></script>
	
	
		<link rel="stylesheet" href="admin/layout_file/css/sweetalert.css">	
<link rel="stylesheet" href="admin/layout_file/css/sweetalert.min.css">		
	<script type="text/javascript" src="admin/layout_file/js/sweetalert.min.js"></script>

	<script type="text/javascript">
	
	 jQuery(function($){
		  var token = $("meta[name='_csrf']").attr("content");
		  var header = $("meta[name='_csrf_header']").attr("content");
		  $(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		  });
		});
	
		var roleAccess = '${roleAccess}';
		var role = '${role}';
		var user_agent = '${user_agent}';
		var army_no = '${army_no}';
		var otpKey = '${otpKey}';
		var $=jQuery;
		var tbl, div;
     	function resetTimer() {
        	if (jQuery('#div_timeout').length) {  jQuery('#div_timeout').html(timeout());  }
     	}
     	function timeout() { return '1800'; }
     	function getsubmodule(id){ localStorage.setItem("subModule", id); }
     	function getmodule(id){localStorage.setItem("Module", id); }
     	function getpagelink(id){localStorage.setItem("pagelink", id); }
     	
     	var key = "${_csrf.parameterName}";
     	var value = "${_csrf.token}";
     	
     	jQuery(document).on('keypress', function(event) {
     		localStorage.setItem("army_no", army_no);
     		
     		var regex = new RegExp("${regScript}");
     	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
     	    if (!regex.test(key)) {
     	       event.preventDefault();
     	       return false;
     	    } 
     	});
     	
   		jQuery(document).ready(function() {	
   			/* jQuery('body').bind('cut copy paste', function (e) {
	   	        e.preventDefault();
	   	    }); */
   			
   			// set current sub module
   			jQuery('ul#Dropdown_'+localStorage.getItem("Module")).parent().attr("class","nav-item dropdown dropdown-item show");
   			jQuery('ul#Dropdown_'+localStorage.getItem("subModule")).parent().attr("class","dropdown-item dropdown create_search  show");
   			jQuery('ul#Dropdown_'+localStorage.getItem("subModule")).attr("class","dropdown-menu scrollbar show");
   			jQuery('ul#Dropdown_'+localStorage.getItem("Module")).attr("class","dropdown-menu show");
   			jQuery('li#Dropdown_scr'+localStorage.getItem("pagelink")).attr("class","dropdown-item active");
   			
   			setInterval(function() {
				var today = new Date();
				var date =("0" + today.getDate()).slice(-2)+'-'+ ("0" + (today.getMonth()+1)).slice(-2)+'-'+today.getFullYear();
				var time = ("0" + today.getHours()).slice(-2) + ":" + ("0" + today.getMinutes()).slice(-2);// + ":" + ("0" + today.getSeconds()).slice(-2);
				var dateTime = date+' '+time;
				jQuery("#datetime").text(dateTime);
				
				if (jQuery('#div_timeout').length) {
	            	 var tt = jQuery('#div_timeout').html();
	                 if (tt === undefined) {
	                     tt = timeout();
	                 }
	                 var ct = parseInt(tt, 10) - 1;
	                 jQuery('#div_timeout').html(ct.toString().padStart(3, '0'));
	                 if (ct === 0) {
	                	 formSubmit();
	                 }
	             } else {
	            	 formSubmit();
	             }
			}, 1000);
			try
			{
				var msg = document.getElementById("msg").value;
				if(msg != null )
				{
					alert(msg);
				}
			}
			catch (e) {
			}
		});
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
		popupWindow = null;
		function parent_disable() {
			if(popupWindow && !popupWindow.closed)
				popupWindow.focus();
		}
	</script>
	<script>
		document.onkeydown = function(e) {
			if(e.keyCode == 123) { return false; }
			if(e.keyCode == 44) {  return false; }
			if(e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)){ return false; } 
			if(e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'S'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'H'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'A'.charCodeAt(0)){ return false; }
			if(e.ctrlKey && e.keyCode == 'E'.charCodeAt(0)){ return false; }
		}
		
	</script>
</head>
<body  onFocus="parent_disable();" onclick="parent_disable();" oncontextmenu="return false" >
		<c:if test="${not empty msg}">
			<input type="hidden" name="msg" id="msg" value="${msg}"  disabled="disabled"/>
		</c:if>
		<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
		<div class="wrapper">
		<header id="header" class="header py-1">
			<div class="row mx-0 align-items-center">
				<div class="col-6 col-md-4 d-flex justify-content-start align-items-center">
					<img src="admin/layout_file/images/amclogo.png" class="img-fluid">
					<h1 class="heading my-0">&nbsp;&nbsp;AFMS</h1>
				</div>
				<div class="col-6 col-md-3 d-flex justify-content-end multi_drop">
					<div class="dropdown multi">
						<button type="button" class="btn dropdown-toggle"
							data-bs-toggle="dropdown">${username}</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#"><i
									class="menu-icon fa fa-user"></i> ${username}</a></li>
							<li><a class="dropdown-item" href="#"><span
									class="sessiontimeout"> Session timeout in &nbsp; <i
										class="fa fa-hourglass fa-spin"></i> : <b class="timecount"
										id="div_timeout">385</b></span></a></li>
							<li><a class="dropdown-item" href="#"><i
									class="fa fa-calendar"></i>&nbsp;<span id="datetime">01-06-2022
										15:54</span></a></li>
							<li><a class="dropdown-item" href="javascript:formSubmit();"
								type="submit" onclick="localStorage.clear();"><i
									class="fa fa-sign-out"></i> Logout</a></li>
						</ul>
					</div>
				</div>
				<div class="col-12 col-md-5 d-flex justify-content-end">
					<div class="menubar">
						<tiles:insertAttribute name="menu" />
					</div>
				</div> 
			</div>
		</header>	
		<div class="middle_content">
			<div class="row mx-0">
				<div class="outer_col body-content">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>

		<div id="WaitLoader" align="center">
			<span id="">Processing Data.Please Wait ...<i
				class="fa fa-hourglass fa-spin"></i></span>
		</div>
		
	</div>
	</body>
</html>