package com.BisagN.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.BisagN.FFL.models.TbNotificationDtl;
import com.BisagN.FFL.repository.NotificationRepository;
import com.BisagN.models.Role;

import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_SCREEN_MASTER;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;

import com.BisagN.models.UserLogin;

import com.BisagN.repository.RoleRepository;

import com.BisagN.repository.UserLoginRepository;
import com.BisagN.service.UserDetailsServiceImpl;

public class redirectLogin extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	NotificationRepository NotificationRepositoryr;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	public static final int MAX_FAILED_ATTEMPTS = 3;
	private static final long LOCK_TIME_DURATION = 10 * 60 * 1000;

	public final Integer SESSION_TIMEOUT_IN_SECONDS = 60 * 1800;

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		String txtInput = request.getParameter("txtInput").replaceAll("\\s", "").toString();
		String capcha = request.getSession().getAttribute("capcha").toString();
		String username = authentication.getName();
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//		String tempusername = "";
		String message = "";
		AuthenticationException exception = null;
		UserLogin userlogin = userLoginRepository.findUser(username);
		// UserLogin login = new UserLogin();

		long lockTimeInMillis1 = userlogin.getCap_locked_date().getTime();
		long currentTimeInMillis1 = System.currentTimeMillis();
		
		if(request.getSession().getAttribute("captchaValidate") == null || request.getSession().getAttribute("captchaValidate") == "") {
			String temp = "../signin?msg=Please Enter Valid Captcha";
//			request.getSession().invalidate();
			request.getSession().setAttribute("errormessagediv", "Please Enter Valid Captcha");

			response.sendRedirect(temp);
		}else {

			if (!request.getSession().getAttribute("captchaValidate").toString().equalsIgnoreCase("true")) {
				
//				tempusername = username;

				if (userlogin.getEnabled() != 0 && userlogin.getAccountnonlocked() != 0) {

					if (userlogin.getAttempt_captcha_count() < MAX_FAILED_ATTEMPTS) {
						UserLogin userloginlock = userLoginRepository.updateFailAttemptsCap(username);
						userloginlock.setAttempt_captcha_count(userlogin.getAttempt_captcha_count()+1);
						userloginlock.setCap_locked_date(new Date());
						userLoginRepository.save(userloginlock);
						message = "Please Enter Valid Captcha";
						exception = new LockedException("Please Enter Valid Captcha!.");
					} else {
						
						UserLogin userloginlock = userLoginRepository.lock(username);
						userloginlock.setAccountnonlocked(0);
						userLoginRepository.save(userloginlock);
						

						exception = new LockedException("Your account has been locked due to 3 failed attempts."
								+ " It will be unlocked after 10 Minute.");
						message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
						request.getSession().setAttribute("errormessagediv", message);

					}
				} else if (currentTimeInMillis1 - lockTimeInMillis1 > LOCK_TIME_DURATION) {
					if (userlogin.getAttempt_captcha_count() > 0) {
						UserLogin userloginlock = userLoginRepository.updateFailAttemptsCap(username);
						userloginlock.setAttempt_captcha_count(1);
						userloginlock.setCap_locked_date(new Date());
						userloginlock.setAccountnonlocked(1);
						userLoginRepository.save(userloginlock);
						exception = new LockedException(
								"Please Enter Valid Captcha");
						message = "Please Enter Valid Captcha";
						request.getSession().setAttribute("errormessagediv", message);
					}
				} else if (currentTimeInMillis1 - lockTimeInMillis1 < LOCK_TIME_DURATION) {

					if (userlogin.getAttempt_captcha_count() > 0) {
						exception = new LockedException("Your account has been locked due to 3 failed attempts."
								+ " It will be unlocked after 10 Minute.");
						message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
						request.getSession().setAttribute("errormessagediv", message);

					}
				}
				String temp = "../signin?msg=" + message;
//				request.getSession().invalidate();
				request.getSession().setAttribute("errormessagediv", "Please Enter Valid Captcha");

				response.sendRedirect(temp);

//				response.sendRedirect("../signin?msg=Please Enter Valid Captcha Diksha");
			} else {

				String role1 = null;
				for (String role : roles) {
					request.getSession().setAttribute("role", role);
					role1 = role;
				}
				UserLogin userLogin = userLoginRepository.findUser(authentication.getName());
				int userId = userLogin.getUserId();
				Role roleList = roleRepository.findRole_url(role1);

				request.getSession().setAttribute("userId_for_jnlp", userId);
				request.getSession().setAttribute("username", authentication.getName());

				String RoleUrl = "";
				if (roleList.getRole_url() != null) {
					RoleUrl = roleList.getRole_url();
				}
				String RoleType = "";
				if (roleList.getRole_type() != null) {
					RoleType = roleList.getRole_type();
				}
				String Acces_lvl = "";
				if (roleList.getAccess_lvl() != null) {
					Acces_lvl = roleList.getAccess_lvl();
				}
				String subAcces_lvl = "";
				if (roleList.getSub_access_lvl() != null) {
					subAcces_lvl = roleList.getSub_access_lvl();
				}

				String staff_lvl = "";
				if (roleList.getStaff_lvl() != null) {
					staff_lvl = roleList.getStaff_lvl();
				}
				String role = "";
				if (roleList.getRole() != null) {
					role = roleList.getRole();
				}

				request.getSession().setAttribute("roleSusNo", "");
				request.getSession().setAttribute("roleUrl", RoleUrl);
				request.getSession().setAttribute("roleType", RoleType);
				request.getSession().setAttribute("roleAccess", Acces_lvl);
				request.getSession().setAttribute("roleSubAccess", subAcces_lvl);
				request.getSession().setAttribute("roleStaff_lvl", staff_lvl);
				request.getSession().setAttribute("roleStaff_lvl", staff_lvl);
				request.getSession().setAttribute("role", role);

				int roleid = roleList.getRoleId();
				UserLogin addData = userLoginRepository.findByRoleId(userId);

				// Chnage
				if (roleid != 0) {
					request.getSession().setAttribute("roleid", roleid);
				}
				request.getSession().setAttribute("successValue", "Fail");

				String login_name = "";
				if (addData.getLogin_name() != null) {
					login_name = addData.getLogin_name();
				}

				request.getSession().setAttribute("username", addData.getUserName());
				if (roleid != 0) {
					request.getSession().setAttribute("roleid", roleid);
				}
				request.getSession().setAttribute("roleloginName", login_name);

				String ip = getClientIp(request);
				request.getSession().setAttribute("ip", ip);

				String userAgent = request.getHeader("User-Agent");
				request.getSession().setAttribute("user_agentWithIp", userAgent + "_" + ip);
				request.getSession().setAttribute("user_agent", userAgent);
				request.getSession().setAttribute("KeySpec", "dc0da04af8fee58593442bf834b30739");

				final long fileSizeLimit = 2 * 1024 * 1024;
				request.getSession().setAttribute("fileSizeLimit", fileSizeLimit);

				String curDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
				request.getSession().setAttribute("curDate", curDate);

				request.getSession().setAttribute("regScript", "^[a-zA-Z0-9\\\\[\\\\] \\\\+ \\\\* \\\\-.,/ ~!@#$^&%_]+$");

				request.getSession().setAttribute("helpdeskFilePath", "/srv" + File.separator + "HELP");
				request.getSession().setAttribute("handingTakingOverPath", "/srv" + File.separator + "handingTakingOver");
			
					List<TB_LDAP_MODULE_MASTER> module = userLoginRepository.getModulelist(roleid);
					String menu = "";

					

					if (roleList.getRole().equalsIgnoreCase("USER1")) {
						for (int mod = 0; mod < module.size(); mod++) {
							menu += "<li class='' id='" + module.get(mod).getModule_name() + "_menu'>";
							menu += "<a class='collapsed svg-icon' id='Dropdown_" + module.get(mod).getModule_name()
									+ "' role='button' data-bs-toggle='collapse' aria-expanded='false'><i class='fa fa-th'></i>"
									+ module.get(mod).getModule_name()
									+ " <i class='las la-angle-right iq-arrow-right arrow-active'></i> "
									+ "<i class='las la-angle-down iq-arrow-right arrow-hover'></i></a>";
							menu += "<ul id='otherpage' class='iq-submenu collapse' data-bs-parent='#iq-sidebar-toggle'' >";
							List<TB_LDAP_SUBMODULE_MASTER> submodule = userLoginRepository
									.getSubModulelist(module.get(mod).getId(), roleid);

							menu += "</ul>";
							menu += "</li>";

							menu += "</ul>";
							menu += "</li>";
						}
					} else {
						for (int mod = 0; mod < module.size(); mod++) {
							List<TB_LDAP_SCREEN_MASTER> screen = userLoginRepository.getScreenlist(roleid);
							 String[] screenOrder = {"COMMON DASHBOARD", "ALUMNI E JOURNAL", "NEWS LETTER", "HALL OF FAME", "PICTURE GALLERY","INSTITUTE BLOG","BLOG  APPROVAL","REGISTRATION APPROVAL","WHAT’S NEW SCROLL"};
						        List<String> orderedScreenNames = Arrays.asList(screenOrder);
						        screen.sort(Comparator.comparingInt(ss -> orderedScreenNames.indexOf(ss.getScreen_name())));
						        
							for (int scr = 0; scr < screen.size(); scr++) {

								menu += "<li class=''><a href='../admin" + screen.get(scr).getScreen_url()
										+ "' class='dashname' value='" + screen.get(scr).getScreen_name()
										+ "' onclick='localStorage.Abandon();'> <i class='fa fa-angle-right'></i>"
										+ screen.get(scr).getScreen_name() + "</a></li>";

							}
							menu += "</ul>";
							menu += "</li>";
							menu += "</ul>";
							menu += "</li>";
						}
					}
					request.getSession().setAttribute("menu", menu);

//				Integer notification_to_id = Integer
//						.parseInt(request.getSession().getAttribute("userId_for_jnlp").toString());
	//
//				List<TbNotificationDtl> tb_notification_master3 = NotificationRepositoryr
//						.LoadNotificationshowData(notification_to_id);
//				Integer tb_notification_master4 = NotificationRepositoryr.LoadNotificationshowData1(notification_to_id);
	//
//				String notdata = "";
//				for (int i = 0; i < tb_notification_master3.size(); i++) {
//					TbNotificationDtl tbNotificationDtl = tb_notification_master3.get(i);
	//
//					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
	//
//					notdata += "<ul class=\"custom-infilist-block\"  >\r\n"
//							+ "																						\r\n"
//							+ "																							<li class=\"iq-sub-card\">\r\n"
//							+ "																							<div class=\"media\">\r\n"
//							+ "																							 <div class=\"custom-info-img\">\r\n"
//							+ "																							 <img class=\"img-fluid\" src=\"assets/images/user.png\" alt=\"01\">\r\n"
//							+ "																							</div> \r\n"
//							+ "																							<div class=\"media-body\">\r\n"
//							+ "																							<div class=\"ci-title-block\">\r\n"
//							+ "																							<h5 class=\"ci-title\">"
//							+ tbNotificationDtl.getDescription() + "</h5>\r\n"
//							+ "																							<span class=\"text-dark ci-time\"><b>"
//							+ dateFormat.format(tbNotificationDtl.getCreatedDate()) + "</b></span>\r\n"
//							+ "																							</div> \r\n"
//							+ "																								</div>\r\n"
//							+ "																							</div>\r\n"
//							+ "																							</li> </ul>";
	//
//				}
//				request.getSession().setAttribute("notdata", notdata);
//				request.getSession().setAttribute("countdata", tb_notification_master4);

					request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);

					if (currentTimeInMillis1 - lockTimeInMillis1 < LOCK_TIME_DURATION) {
						if (userlogin.getAttempt_captcha_count() == 3) {

							exception = new LockedException("Your account has been locked due to 3 failed attempts."
									+ " It will be unlocked after 10 Minute.");
							message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
							request.getSession().setAttribute("errormessagediv", message);
							String temp = "../signin?msg=" + message;
							response.sendRedirect(temp);
						} else {
							
							UserLogin userloginlock = userLoginRepository.resetFailAttemptsCap(username);
							userloginlock.setAttempt_captcha_count(0);
							userloginlock.setCap_locked_date(new Date());
							userloginlock.setAccountnonlocked(1);
							userLoginRepository.save(userloginlock);
							if (role1.equalsIgnoreCase("SUPER ADMIN")) {
								response.sendRedirect("../admin/adminDashboard");
							}

							else if (role1.equalsIgnoreCase("ADMIN")) {
								response.sendRedirect("../admin/instituteDashboard");
							} else if (role1.equalsIgnoreCase("EMBASSY ADMIN")) {
								response.sendRedirect("../admin/EmbasyDashboard");
							}

							else {
								response.sendRedirect("../admin/commonDashboard");
							}
						}
					} else {
						UserLogin userloginlock = userLoginRepository.resetFailAttemptsCap(username);
						userloginlock.setAttempt_captcha_count(0);
						userloginlock.setCap_locked_date(new Date());
						userloginlock.setAccountnonlocked(1);
						userLoginRepository.save(userloginlock);
						if (role1.equalsIgnoreCase("SUPER ADMIN")) {
							response.sendRedirect("../admin/adminDashboard");
						}

						else if (role1.equalsIgnoreCase("ADMIN")) {
							response.sendRedirect("../admin/instituteDashboard");
						} else if (role1.equalsIgnoreCase("EMBASSY ADMIN")) {
							response.sendRedirect("../admin/EmbasyDashboard");
						}

						else {
							response.sendRedirect("../admin/commonDashboard");
						}

					}
			

			}
		}
		
		

	}

	private static String getClientIp(HttpServletRequest request) {
		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		return remoteAddr;
	}
}
