package com.BisagN.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.BisagN.util.Base64Service;




public class ExtraParam extends WebAuthenticationDetails {
	private static final long serialVersionUID = 1L;

	private final String salt;
	private final String iv;
	private final String key;

	public ExtraParam(HttpServletRequest request) throws IOException {
		super(request);
		this.salt = request.getParameter("salt");
		this.iv = request.getParameter("iv");
		this.key =  request.getParameter("key");

//		this.key =  new String(Base64Service.decode(request.getParameter("key")));
	}

	public String getSalt() {
		return salt;
	}

	public String getIv() {
		return iv;
	}

	public String getKey() {
		return key;
	}

}
