package com.BisagN.config;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import com.BisagN.models.UserLogin;

//@Configuration
@Component
public class CSPNonceFilter extends GenericFilterBean {

	private static final int NONCE_SIZE = 32; // recommended is at least 128 bits/16 bytes
	private static final String CSP_NONCE_ATTRIBUTE = "cspNonce";

	private SecureRandom secureRandom = new SecureRandom();

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		System.out.println("NONCE CONTROLLER CALLED----------------------------");
		final String nonce;
		final Object existingNonce = request.getAttribute(CSP_NONCE_ATTRIBUTE);

		if (existingNonce == null) {
			byte[] nonceArray = new byte[NONCE_SIZE];

			secureRandom.nextBytes(nonceArray);

			nonce = Base64.getEncoder().encodeToString(nonceArray);

			request.setAttribute(CSP_NONCE_ATTRIBUTE, nonce);
			
		} else {
			nonce = (String) existingNonce;
			
		}

		chain.doFilter(request, new CSPNonceResponseWrapper((HttpServletResponse) response, nonce));
	}
	
	

	public static class CSPNonceResponseWrapper extends HttpServletResponseWrapper {
		private final String nonce;

		public CSPNonceResponseWrapper(HttpServletResponse response, String nonce) {
			super(response);
			this.nonce = nonce;
		}
		
		
		
		

		@Override
		public void setHeader(String name, String value) {
			if (name.equals("Content-Security-Policy") && StringUtils.isNotBlank(value)) {
				super.setHeader(name, value.replace("{nonce}", nonce));
			} else {
				super.setHeader(name, value);
			}
		}

		@Override
		public void addHeader(String name, String value) {
			if (name.equals("Content-Security-Policy") && StringUtils.isNotBlank(value)) {
				super.addHeader(name, value.replace("{nonce}", nonce));
			} else {
				super.addHeader(name, value);
			}
		}
	}

}
