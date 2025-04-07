//package com.BisagN.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import com.BisagN.util.Base64Service;
//
//@Controller
//public class CustomErrorController implements ErrorController {
//		
//	@RequestMapping("/toomanyrequest")
//	public String toomanyrequest(Model model, HttpServletRequest request) {
//// model.addAttribute("errorMessage", "An error occurred@@@@@@@@@@@@@@@@@@@@");
//		return "toomanyrequest";
//	}
//	
//	
//
//	@RequestMapping("/admin/toomanyrequestLogin")
//	public String toomanyrequestLogin(Model model, HttpServletRequest request) {
//// model.addAttribute("errorMessage", "An error occurred@@@@@@@@@@@@@@@@@@@@");
//
//		return "toomanyrequestLogin";
//
//	}
//	
//	
//	
//	
////	@RequestMapping("/FriendsForLife/403")
////	public String toomanyrequest403(Model model, HttpServletRequest request) {
////// model.addAttribute("errorMessage", "An error occurred@@@@@@@@@@@@@@@@@@@@");
////		return "toomanyrequest";
////	}
////	
////	@RequestMapping("/FriendsForLife/admin/403")
////	public String toomanyrequestadmin403(Model model, HttpServletRequest request) {
////// model.addAttribute("errorMessage", "An error occurred@@@@@@@@@@@@@@@@@@@@");
////		return "toomanyrequestLogin";
////	}
//	
//
//	@RequestMapping("/error")
//	public void handleError(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
////       500,505,405,403,404,400
////               Object status = model.getAttribute("javax.servlet.error.status_code");
//		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//// System.out.println("erorstatus " + status);
//
//		Object sessionUser = request.getSession().getAttribute("userId_for_jnlp");
//		boolean checkLogin = false;
//		if (sessionUser != null) {
//			checkLogin = true;
//		}
//		
//		if (status != null) {
//			int statusCode = Integer.parseInt(status.toString());
//// System.out.println("statusCode" + statusCode);
//			model.addAttribute("errorCode", "Error - " + statusCode);
//
//			if (statusCode == HttpStatus.BAD_REQUEST.value()) {
//				model.addAttribute("errorMessage",
//						"Your request is invalid or improperly formatted. Please double-check your request and try again.");
//			} else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
//				model.addAttribute("errorMessage",
//						"You are not authorized to access this resource. Please log in or authenticate to access this page.");
//			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
//				model.addAttribute("errorMessage",
//						"Access to this resource is forbidden. You do not have the necessary permissions to view this content.");
//			} else if (statusCode == HttpStatus.NOT_FOUND.value()) {
//				model.addAttribute("errorMessage",
//						"The page you are looking for could not be found. Please check the URL or navigate to a different page.");
//			} else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
//				model.addAttribute("errorMessage",
//						"The HTTP method you used is not allowed for this resource. Please use a different HTTP method and try again.");
//			} else if (statusCode == HttpStatus.NOT_ACCEPTABLE.value()) {
//				model.addAttribute("errorMessage",
//						"The requested resource is not available in a format that can be served based on your request's `Accept` headers.");
//			} else if (statusCode == HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value()) {
//				model.addAttribute("errorMessage",
//						"Authentication with the proxy server is required. Please provide the necessary credentials.");
//			} else if (statusCode == HttpStatus.REQUEST_TIMEOUT.value()) {
//				model.addAttribute("errorMessage",
//						"The server timed out while waiting for your request. Please try your request again.");
//			} else if (statusCode == HttpStatus.CONFLICT.value()) {
//				model.addAttribute("errorMessage",
//						"A conflict occurred while processing your request. Please resolve the conflict and try again.");
//			} else if (statusCode == HttpStatus.GONE.value()) {
//				model.addAttribute("errorMessage",
//						"The requested resource is no longer available on the server and will not be available again.");
//			} else if (statusCode == HttpStatus.LENGTH_REQUIRED.value()) {
//				model.addAttribute("errorMessage",
//						"The `Content-Length` header is required for this request, but it is missing. Please include the `Content-Length` header.");
//			} else if (statusCode == HttpStatus.PRECONDITION_FAILED.value()) {
//				model.addAttribute("errorMessage",
//						"A precondition for this request has failed. Please meet the necessary conditions and try again.");
//			} else if (statusCode == HttpStatus.PAYLOAD_TOO_LARGE.value()) {
//				model.addAttribute("errorMessage",
//						"The request payload is too large for the server to process. Please reduce the size of your request.");
//			} else if (statusCode == HttpStatus.URI_TOO_LONG.value()) {
//				model.addAttribute("errorMessage",
//						"The requested URL is too long for the server to process. Please shorten the URL and try again.");
//			} else if (statusCode == HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()) {
//				model.addAttribute("errorMessage",
//						"The media type of your request is not supported by the server. Please use a supported media type.");
//			} else if (statusCode == HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value()) {
//				model.addAttribute("errorMessage",
//						"The requested range is not satisfiable by the server. Please adjust your range request.");
//			} else if (statusCode == HttpStatus.EXPECTATION_FAILED.value()) {
//				model.addAttribute("errorMessage",
//						"The server cannot meet the requirements of the `Expect` request header. Please adjust your request.");
//			} else if (statusCode == HttpStatus.UNPROCESSABLE_ENTITY.value()) {
//				model.addAttribute("errorMessage",
//						"The request cannot be processed due to semantic errors. Please fix the errors and try again.");
//			} else if (statusCode == HttpStatus.LOCKED.value()) {
//				model.addAttribute("errorMessage",
//						"The resource is locked and cannot be accessed. Please try again later or contact the administrator.");
//			} else if (statusCode == HttpStatus.FAILED_DEPENDENCY.value()) {
//				model.addAttribute("errorMessage",
//						"The request failed due to a failed dependency. Please resolve the dependency issue and try again.");
//			} else if (statusCode == HttpStatus.UPGRADE_REQUIRED.value()) {
//				model.addAttribute("errorMessage",
//						"The server requires an upgrade to a newer version of the protocol. Please update your client or request.");
//			} else if (statusCode == HttpStatus.PRECONDITION_REQUIRED.value()) {
//				model.addAttribute("errorMessage",
//						"The server requires a precondition for this request. Please include the necessary precondition headers.");
//			} else if (statusCode == HttpStatus.TOO_MANY_REQUESTS.value()) {
//				model.addAttribute("errorMessage",
//						"You have exceeded the rate limit for making requests to this server. Please wait and try again later.");
//			} else if (statusCode == HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.value()) {
//				model.addAttribute("errorMessage",
//						"The request headers are too large for the server to process. Please reduce the size of your headers.");
//			} else if (statusCode == HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value()) {
//				model.addAttribute("errorMessage",
//						"Access to this resource is unavailable due to legal reasons. Please consult the law or regulations for more information.");
//			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//				model.addAttribute("errorMessage",
//						"An internal server error occurred while processing your request. Please try again later or contact the system administrator.");
//			} else if (statusCode == HttpStatus.NOT_IMPLEMENTED.value()) {
//				model.addAttribute("errorMessage",
//						"The server does not support the requested feature or method. Please use a different method or contact the administrator.");
//			} else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
//				model.addAttribute("errorMessage",
//						"The server received an invalid response from an upstream server. Please try again later.");
//			} else if (statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
//				model.addAttribute("errorMessage",
//						"The server is temporarily unavailable due to maintenance or overload. Please try again later.");
//			} else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
//				model.addAttribute("errorMessage",
//						"The server did not receive a timely response from an upstream server or proxy. Please try again later.");
//			} else if (statusCode == HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value()) {
//				model.addAttribute("errorMessage",
//						"The HTTP version used in the request is not supported by the server. Please use a different HTTP version and try again.");
//			} else {
//				model.addAttribute("errorMessage", "An error occurred, ErrorCode : " + statusCode);
//			}
//
//			if (checkLogin) {
////				response.sendRedirect(request.getContextPath() + "/admin/loginError1?message="
////						+ model.getAttribute("errorMessage") + "&&errorCode=" + model.getAttribute("errorCode"));
//
//				String encryptedlmData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorMessage"))).getBytes());
//				String encryptedleData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorCode"))).getBytes());
//				response.sendRedirect(request.getContextPath() + "/admin/loginError1?encryptedlmData="
//						+ encryptedlmData + "&&encryptedleData=" + encryptedleData);
//
//			} else {
////				response.sendRedirect(request.getContextPath() + "/error1?message=" + model.getAttribute("errorMessage")
////				+ "&&errorCode=" + model.getAttribute("errorCode"));
//				String encryptedmData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorMessage"))).getBytes());
//				String encryptedeData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorCode"))).getBytes());
//				response.sendRedirect(request.getContextPath() + "/error1?encryptedmData=" + encryptedmData + "&&encryptedeData=" + encryptedeData);
//			}
//		} else {
//			model.addAttribute("errorMessage", "An error occurred");
//			if (checkLogin) {
////				response.sendRedirect(request.getContextPath() + "/admin/loginError1?message="
////						+ model.getAttribute("errorMessage") + "&&errorCode=" + model.getAttribute("errorCode"));
//				
//				String encryptedlmData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorMessage"))).getBytes());
//				String encryptedleData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorCode"))).getBytes());
//				response.sendRedirect(request.getContextPath() + "/admin/loginError1?encryptedlmData="
//						+ encryptedlmData + "&&encryptedleData=" + encryptedleData);
//
//			} else {
////				response.sendRedirect(request.getContextPath() + "/error1?message=" + model.getAttribute("errorMessage")
////						+ "&&errorCode=" + model.getAttribute("errorCode"));
//				String encryptedmData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorMessage"))).getBytes());
//				String encryptedeData = Base64Service.encode(AESGCM.encrypt(String.valueOf(model.getAttribute("errorCode"))).getBytes());
//				response.sendRedirect(request.getContextPath() + "/error1?encryptedmData=" + encryptedmData + "&&encryptedeData=" + encryptedeData);
//			}
//		}
//	}
//
////       @Override
//	public String getErrorPath() {
//		return "/error";
//	}
//
//	@RequestMapping(value = "/admin/loginError1", method = RequestMethod.GET)
//	public String loginError1(HttpServletRequest request, @RequestParam String encryptedlmData, @RequestParam String encryptedleData,
//			Model model) throws IOException {
//		String message = AESGCM.decrypt(new String(Base64Service.decode(encryptedlmData.toString())));
//		String errorCode = AESGCM.decrypt(new String(Base64Service.decode(encryptedleData.toString())));
//
//		System.err.println("encryptedmData1 loginError1---------------" + message);
//		System.err.println("encryptedeData1 loginError1---------------" + errorCode);
//
//		model.addAttribute("errorMessage", message);
//		model.addAttribute("errorCode", errorCode);
//		return "loginError";
//	}
//
//	
//	//// for inside complaint mgt syst error handling 
//	
//	@RequestMapping(value = "/admin/loginError2", method = RequestMethod.GET)
//	public String loginError2(HttpServletRequest request, @RequestParam String encryptedlmData, @RequestParam String encryptedleData,
//			Model model) throws IOException {
//		String message = AESGCM.decrypt(new String(Base64Service.decode(encryptedlmData.toString())));
//		String errorCode = AESGCM.decrypt(new String(Base64Service.decode(encryptedleData.toString())));
//
//		System.err.println("encryptedmData1 loginError1---------------" + message);
//		System.err.println("encryptedeData1 loginError1---------------" + errorCode);
//
//		model.addAttribute("errorMessage", message);
//		model.addAttribute("errorCode", errorCode);
//		return "loginError";
//	}
//	//////////////////
//	
//	@RequestMapping(value = "/error1", method = RequestMethod.GET)
//	public String error1(HttpServletRequest request, @RequestParam String encryptedmData, @RequestParam String encryptedeData,
//			Model model) throws IOException {
//		
//		String message = AESGCM.decrypt(new String(Base64Service.decode(encryptedmData.toString())));
//		String errorCode = AESGCM.decrypt(new String(Base64Service.decode(encryptedeData.toString())));
//		
//		System.err.println("encryptedmData1 ---------------" + message);
//		System.err.println("encryptedeData1 ---------------" + errorCode);
//		
//		model.addAttribute("errorMessage", message);
//		model.addAttribute("errorCode", errorCode);
//
//		return "error";
//	}
//	
////	@RequestMapping(value = "/error1", method = RequestMethod.GET)
////	public String error1(HttpServletRequest request, @RequestParam String encryptedmData, @RequestParam String encryptedeData,
////			Model model) throws IOException {
////		
////		String message = AESGCM.decrypt(new String(Base64Service.decode(encryptedmData.toString())));
////		String errorCode = AESGCM.decrypt(new String(Base64Service.decode(encryptedeData.toString())));
////		
////		System.err.println("encryptedmData1 ---------------" + message);
////		System.err.println("encryptedeData1 ---------------" + errorCode);
////		
////		model.addAttribute("errorMessage", message);
////		model.addAttribute("errorCode", errorCode);
////
////		return "error";
////	}
//}


package com.BisagN.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/toomanyrequest")
	public String toomanyrequest(Model model, HttpServletRequest request) {
		return "toomanyrequest";
	}

	@RequestMapping("/admin/toomanyrequestLogin")
	public String toomanyrequestLogin(Model model, HttpServletRequest request) {
		return "toomanyrequestLogin";
	}

	@RequestMapping("/error")
	public String handleError(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object sessionUser = request.getSession().getAttribute("userId_for_jnlp");
		boolean checkLogin = false;
		if (sessionUser != null) {
			checkLogin = true;
		}
		
		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			model.addAttribute("errorCode", "Error - " + statusCode);

			if (statusCode == HttpStatus.BAD_REQUEST.value()) {
				model.addAttribute("errorMessage",
						"Your request is invalid or improperly formatted. Please double-check your request and try again.");
			} else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
				model.addAttribute("errorMessage",
						"You are not authorized to access this resource. Please log in or authenticate to access this page.");
			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				model.addAttribute("errorMessage",
						"Access to this resource is forbidden. You do not have the necessary permissions to view this content.");
			} else if (statusCode == HttpStatus.NOT_FOUND.value()) {
				model.addAttribute("errorMessage",
						"The page you are looking for could not be found. Please check the URL or navigate to a different page.");
			} else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
				model.addAttribute("errorMessage",
						"The HTTP method you used is not allowed for this resource. Please use a different HTTP method and try again.");
			} else if (statusCode == HttpStatus.NOT_ACCEPTABLE.value()) {
				model.addAttribute("errorMessage",
						"The requested resource is not available in a format that can be served based on your request's `Accept` headers.");
			} else if (statusCode == HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value()) {
				model.addAttribute("errorMessage",
						"Authentication with the proxy server is required. Please provide the necessary credentials.");
			} else if (statusCode == HttpStatus.REQUEST_TIMEOUT.value()) {
				model.addAttribute("errorMessage",
						"The server timed out while waiting for your request. Please try your request again.");
			} else if (statusCode == HttpStatus.CONFLICT.value()) {
				model.addAttribute("errorMessage",
						"A conflict occurred while processing your request. Please resolve the conflict and try again.");
			} else if (statusCode == HttpStatus.GONE.value()) {
				model.addAttribute("errorMessage",
						"The requested resource is no longer available on the server and will not be available again.");
			} else if (statusCode == HttpStatus.LENGTH_REQUIRED.value()) {
				model.addAttribute("errorMessage",
						"The `Content-Length` header is required for this request, but it is missing. Please include the `Content-Length` header.");
			} else if (statusCode == HttpStatus.PRECONDITION_FAILED.value()) {
				model.addAttribute("errorMessage",
						"A precondition for this request has failed. Please meet the necessary conditions and try again.");
			} else if (statusCode == HttpStatus.PAYLOAD_TOO_LARGE.value()) {
				model.addAttribute("errorMessage",
						"The request payload is too large for the server to process. Please reduce the size of your request.");
			} else if (statusCode == HttpStatus.URI_TOO_LONG.value()) {
				model.addAttribute("errorMessage",
						"The requested URL is too long for the server to process. Please shorten the URL and try again.");
			} else if (statusCode == HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()) {
				model.addAttribute("errorMessage",
						"The media type of your request is not supported by the server. Please use a supported media type.");
			} else if (statusCode == HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value()) {
				model.addAttribute("errorMessage",
						"The requested range is not satisfiable by the server. Please adjust your range request.");
			} else if (statusCode == HttpStatus.EXPECTATION_FAILED.value()) {
				model.addAttribute("errorMessage",
						"The server cannot meet the requirements of the `Expect` request header. Please adjust your request.");
			} else if (statusCode == HttpStatus.UNPROCESSABLE_ENTITY.value()) {
				model.addAttribute("errorMessage",
						"The request cannot be processed due to semantic errors. Please fix the errors and try again.");
			} else if (statusCode == HttpStatus.LOCKED.value()) {
				model.addAttribute("errorMessage",
						"The resource is locked and cannot be accessed. Please try again later or contact the administrator.");
			} else if (statusCode == HttpStatus.FAILED_DEPENDENCY.value()) {
				model.addAttribute("errorMessage",
						"The request failed due to a failed dependency. Please resolve the dependency issue and try again.");
			} else if (statusCode == HttpStatus.UPGRADE_REQUIRED.value()) {
				model.addAttribute("errorMessage",
						"The server requires an upgrade to a newer version of the protocol. Please update your client or request.");
			} else if (statusCode == HttpStatus.PRECONDITION_REQUIRED.value()) {
				model.addAttribute("errorMessage",
						"The server requires a precondition for this request. Please include the necessary precondition headers.");
			} else if (statusCode == HttpStatus.TOO_MANY_REQUESTS.value()) {
				model.addAttribute("errorMessage",
						"You have exceeded the rate limit for making requests to this server. Please wait and try again later.");
			} else if (statusCode == HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.value()) {
				model.addAttribute("errorMessage",
						"The request headers are too large for the server to process. Please reduce the size of your headers.");
			} else if (statusCode == HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value()) {
				model.addAttribute("errorMessage",
						"Access to this resource is unavailable due to legal reasons. Please consult the law or regulations for more information.");
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				model.addAttribute("errorMessage",
						"An internal server error occurred while processing your request. Please try again later or contact the system administrator.");
			} else if (statusCode == HttpStatus.NOT_IMPLEMENTED.value()) {
				model.addAttribute("errorMessage",
						"The server does not support the requested feature or method. Please use a different method or contact the administrator.");
			} else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
				model.addAttribute("errorMessage",
						"The server received an invalid response from an upstream server. Please try again later.");
			} else if (statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
				model.addAttribute("errorMessage",
						"The server is temporarily unavailable due to maintenance or overload. Please try again later.");
			} else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
				model.addAttribute("errorMessage",
						"The server did not receive a timely response from an upstream server or proxy. Please try again later.");
			} else if (statusCode == HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value()) {
				model.addAttribute("errorMessage",
						"The HTTP version used in the request is not supported by the server. Please use a different HTTP version and try again.");
			} else {
				model.addAttribute("errorMessage", "An error occurred, ErrorCode : " + statusCode);
			}

			if (checkLogin) {

				model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
				model.addAttribute("errorCode", model.getAttribute("errorCode"));

				return "loginError";
			} else {

				model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
				model.addAttribute("errorCode", model.getAttribute("errorCode"));

				return "error1";
			}
		} else {
			model.addAttribute("errorMessage", "An error occurred");
			if (checkLogin) {

				model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
				model.addAttribute("errorCode", model.getAttribute("errorCode"));

				return "loginError";

			} else {

				model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
				model.addAttribute("errorCode", model.getAttribute("errorCode"));

				return "error1";
			}
		}
	}

//       @Override
	public String getErrorPath() {
		return "/error";
	}

}