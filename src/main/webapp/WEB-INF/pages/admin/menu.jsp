<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	HttpSession sess = request.getSession(false);
	if (sess.getAttribute("userId") == null) {
		response.sendRedirect("/login");
		return;
	}
%> --%>
<!-- <script >
	var username="${username}";
	var curDate = "${curDate}";
</script> -->

<!-- menu start -->
<div class="iq-sidebar sidebar-default">
	<div class="iq-sidebar-logo">
		<a href="commonDashboard"><div class="indianarmy-logo">
						<img src="assets/images/outerimages/indianarmylogo.png"
							class="img-fluid light-logo" alt="logo">
					</div> <!-- 			<h5 class="logo-title text-white ml-3">Friends For Life</h5> -->
				</a>
		<a href="commonDashboard"><div class="header-logo">
				<img src="assets/images/outerimages/iaflogo.png"
					class="img-fluid light-logo" alt="logo">
			</div> <!-- 			<h5 class="logo-title text-white ml-3">Friends For Life</h5> -->
		</a>
		<div class="iq-menu-bt-sidebar ">
			<svg
				class="svg-icon feather feather-repeat wrapper-menu animated rotation"
				xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				viewBox="0 0 24 24" fill="none" stroke="currentColor"
				stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                        <polyline points="17 1 21 5 17 9"></polyline>
                        <path d="M3 11V9a4 4 0 0 1 4-4h14"></path>
                        <polyline points="7 23 3 19 7 15"></polyline>
                        <path d="M21 13v2a4 4 0 0 1-4 4H3"></path>
                    </svg>
		</div>
	</div>
	<div class="custom-scrollbar">
		<nav class="iq-sidebar-menu">
			<ul id="iq-sidebar-toggle" class="iq-menu">${menu}

			</ul>
		</nav>
		<div class="p-3"></div>
	</div>
</div>
<!-- menu end -->