package com.BisagN.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class ExtraParamSource implements AuthenticationDetailsSource<HttpServletRequest, ExtraParam> {

	public ExtraParam buildDetails(HttpServletRequest context) {

		try {
			return new ExtraParam(context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}