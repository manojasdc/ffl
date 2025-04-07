package com.BisagN.service;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Configuration
public class LoginInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		try {
			String header = request.getHeader("User-Agent");
			String requestedURL = request.getRequestURI();
			System.out.println("requestedURL --->" + requestedURL);
			if (requestedURL.equalsIgnoreCase("/AFMS/login") || requestedURL.equalsIgnoreCase("/logout")
					|| requestedURL.equalsIgnoreCase("/auth/login_check?targetUrl")
					|| requestedURL.equalsIgnoreCase("/AFMS/checkCapchaCode")
					|| requestedURL.equalsIgnoreCase("/AFMS/genCapchaCode")
					|| requestedURL.equalsIgnoreCase("/AFMS/registrationUrl")
					|| requestedURL.equalsIgnoreCase("/AFMS/CheckEmailExistandSendEmail")
					|| requestedURL.equalsIgnoreCase("/AFMS/VerifyEmailandRegister")
					|| requestedURL.equalsIgnoreCase("/AFMS/admin/AccessTiles")
					|| requestedURL.equalsIgnoreCase("/AFMS/AccessTiles")
					|| requestedURL.contains("/AFMS/admin/layout_file/")
					|| requestedURL.contains("/AFMS/admin/login_file/")
					|| requestedURL.contains("commonDashboard")
					|| requestedURL.contains("commanDashboardStudent")
					) {
				return true;
			}

			HttpSession session = request.getSession(false);
			if (session != null) {
				System.out.println("Role Name -------------------->" + session.getAttribute("roleid"));
				
				String roleid = session.getAttribute("roleid").toString();
				
				response.sendRedirect("../admin/ChangePasswordadmin");
				
				return true;
				
//				if (Integer.parseInt(roleid) == 1 && requestedURL.equalsIgnoreCase("/AFMS/admin/commonDashboard")) {
//					response.sendRedirect("commonDashboard");
//					return true;
//				} 
//				if (Integer.parseInt(roleid) == 2 && requestedURL.equalsIgnoreCase("/AFMS/commanDashboardStudent")) {
//					response.sendRedirect("commanDashboardStudent");
//					return true;
//				} 
				
				//Boolean val = roledao.ScreenRedirect(requestedURL, roleid);
//				try {

//				if (val == false) {
//
//					// return new ModelAndView("AccessTiles");
//
//					response.sendRedirect("AccessTiles");
//					return false;
//				}
//				if (request.getHeader("Referer") == null) {
//					msg = "Unauthorized Access";
//				}
//				Mmap.put("msg", msg);
//				Mmap.put("getRoleNameList", roleMstrController.getRoleNameList());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				if (Integer.parseInt(roleid) == 1) {
//					response.sendRedirect("../admin/" + requestedURL);
//					return true;
//				} else {
//					response.sendRedirect("../" + requestedURL);
//					return true;
//				}
//				response.sendRedirect(requestedURL);
//				return true;
				// return new ModelAndView(requestedURL);

			} else {

				System.out.println("Request URL ----------->" + requestedURL);
				// response.sendRedirect("../" + requestedURL);
				return true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			// response.sendRedirect("../login");
			return false;
		}
		

	}

	@Override
	public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav)
			throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn)
			throws Exception {

	}
}
