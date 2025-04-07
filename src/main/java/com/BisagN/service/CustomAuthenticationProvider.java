package com.BisagN.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.BisagN.controller.AesUtil;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Date;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * A custom Authentication provider example. To create custom
 * AuthenticationProvider, we need to implement the AuthenticationProvider
 * provide the implementation for the authenticate and support method.
 * </p>
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	UserLoginRepository userLoginRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	 

	public static final int MAX_FAILED_ATTEMPTS = 3;

	private static final long LOCK_TIME_DURATION = 10 * 60 * 1000;

	public void kakauth(HttpServletRequest request) {
		if (!request.getSession().getAttribute("captchaValidate").toString().equalsIgnoreCase("true")) {
			throw new BadCredentialsException("Please Enter Valid Captcha");
		}

	}
	
	@Bean
	public RequestContextListener requestContextListener() {
	    return new RequestContextListener();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
		System.out.println("((ExtraParam) authentication.getDetails()).getSalt(); "
				+ ((ExtraParam) authentication.getDetails()).getSalt());
		System.out.println("( authentication.getDetails()).getSalt(); " + authentication.getDetails());
		String salt = ((ExtraParam) authentication.getDetails()).getSalt();
		String iv = ((ExtraParam) authentication.getDetails()).getIv();
		String key = ((ExtraParam) authentication.getDetails()).getKey();

		byte[] ivBytes = null;
		byte[] saltBytes = null;
		String PassKey = null;
		byte[] encryptedData = null;
		try {
			saltBytes = Base64Service.decode(salt);
			ivBytes = Base64Service.decode(iv);
			encryptedData = Base64Service.decode(username);
			PassKey = new String(Base64Service.decode(key));

		} catch (IOException e) {
		}

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attributes.getRequest();
		
		System.err.println("request.getSession().getAttribute(\"captchaValidate\").toString() "+request.getSession().getAttribute("captchaValidate").toString());

		if (request.getSession().getAttribute("captchaValidate") == null) {
			throw new LockedException("Please Enter Valid Captcha.");
		}

		int iterationCount = Integer.parseInt("1000");
		int keySize = Integer.parseInt("128");
		AesUtil aesUtil = new AesUtil(keySize, iterationCount);
		System.out.println("salt------------" + salt);

		if (StringUtils.isEmpty(username)) {
			throw new BadCredentialsException("invalid login details");
		}
		// get user details using Spring security user details service
		UserDetails user = null;
		try {
			username = decryptData(encryptedData, ivBytes, saltBytes, PassKey);
			byte[] password1 = Base64.getDecoder().decode(authentication.getCredentials().toString());
			String password = decryptData(password1, ivBytes, saltBytes, PassKey);

			System.err.println("username " + username);
			System.err.println("password " + password);

			user = userDetailsServiceImpl.loadUserByUsername(username);
//		UserLogin user1 = userDetailsServiceImpl.findByUsername(username);
			UserLogin user1 = userLoginRepository.findUser(username);
			String tempusername = "";
			tempusername = username;
			String message = "";
			AuthenticationException exception = null;
			long lockTimeInMillis1 = user1.getCap_locked_date().getTime();
			long currentTimeInMillis1 = System.currentTimeMillis();
			if (user == null) {
				throw new BadCredentialsException("invalid login details");
			} else {
				if (!passwordEncoder.matches(password, user.getPassword())) {
					throw new BadCredentialsException("Invalid Username and Password.");
				} else {
					if (!request.getSession().getAttribute("captchaValidate").toString().equalsIgnoreCase("true")) {
					if (user1.getEnabled() != 0 && user1.getAccountnonlocked() != 0) {

						if (user1.getAttempt_captcha_count() < MAX_FAILED_ATTEMPTS) {
							UserLogin userloginlock = userLoginRepository.updateFailAttemptsCap(username);
							userloginlock.setAttempt_captcha_count(user1.getAttempt_captcha_count()+1);
							userloginlock.setCap_locked_date(new Date());
							userLoginRepository.save(userloginlock);
							message = "Please Enter Valid Captcha";
							throw new LockedException("Please Enter Valid Captcha!.");
						} else {
							
							UserLogin userloginlock = userLoginRepository.lock(username);
							userloginlock.setAccountnonlocked(0);
							userLoginRepository.save(userloginlock);
							

							throw new LockedException("Your account has been locked due to 3 failed attempts."
									+ " It will be unlocked after 10 Minute.");
//							message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
//							request.getSession().setAttribute("errormessagediv", message);

						}
					} else if (currentTimeInMillis1 - lockTimeInMillis1 > LOCK_TIME_DURATION) {
						if (user1.getAttempt_captcha_count() > 0) {
							UserLogin userloginlock = userLoginRepository.updateFailAttemptsCap(username);
							userloginlock.setAttempt_captcha_count(1);
							userloginlock.setCap_locked_date(new Date());
							userloginlock.setAccountnonlocked(1);
							userLoginRepository.save(userloginlock);
							throw new LockedException(
									"Please Enter Valid Captcha");
//							message = "Please Enter Valid Captcha";
//							request.getSession().setAttribute("errormessagediv", message);
						}
					} else if (currentTimeInMillis1 - lockTimeInMillis1 < LOCK_TIME_DURATION) {

						if (user1.getAttempt_captcha_count() > 0) {
							throw new LockedException("Your account has been locked due to 3 failed attempts."
									+ " It will be unlocked after 10 Minute.");
//							message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
//							request.getSession().setAttribute("errormessagediv", message);

						}
					}
					}
					
					
				}
			}
//		
		} catch (UsernameNotFoundException exception) {
			throw new UsernameNotFoundException("USer Name Not Found");
		} catch (BadCredentialsException exception) {
			throw new BadCredentialsException("invalid login details");
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			throw new BadCredentialsException("invalid login details");
		}
		return createSuccessfulAuthentication(authentication, user);

//		String salt = ((ExtraParam) authentication.getDetails()).getSalt();
//		String iv = ((ExtraParam) authentication.getDetails()).getIv();
//		String key = ((ExtraParam) authentication.getDetails()).getKey();
//		int iterationCount = Integer.parseInt("1000");
//		int keySize = Integer.parseInt("128");
//		AesUtil aesUtil = new AesUtil(keySize, iterationCount);
//
//		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
//		if (StringUtils.isEmpty(username)) {
//			throw new BadCredentialsException("invalid login details");
//		}
//		// get user details using Spring security user details service
//		UserDetails user = null;
//		try {
//			username = aesUtil.decrypt(salt, iv, key, username);
//			String password = aesUtil.decrypt(salt, iv, key, authentication.getCredentials().toString());
//			user = userDetailsServiceImpl.loadUserByUsername(username);
//			if (user == null) {
//				throw new BadCredentialsException("invalid login details");
//			} else {
//				if (!passwordEncoder.matches(password, user.getPassword())) {
//					throw new BadCredentialsException("Invalid Username and Password.");
//				} else {
//
//				}
//			}
//
//		} catch (UsernameNotFoundException exception) {
//			throw new UsernameNotFoundException("USer Name Not Found");
//		} catch (BadCredentialsException exception) {
//			throw new BadCredentialsException("invalid login details");
//		}
//		return createSuccessfulAuthentication(authentication, user);
	}

	private Authentication createSuccessfulAuthentication(final Authentication authentication, final UserDetails user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
				authentication.getCredentials(), user.getAuthorities());
		token.setDetails(authentication.getDetails());
		return token;
	}

//    @Override
//    public boolean supports(Class << ? > authentication) {
//        return authentication.equals(ExternalServiceAuthenticationToken.class);
//    }

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public static SecretKey deriveKey(String password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iterations = 600000;
		int keyLength = 256;

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
		SecretKey tmp = factory.generateSecret(spec);
		return new SecretKeySpec(tmp.getEncoded(), "AES");
	}

	public static String decryptData(byte[] encryptedData, byte[] iv, byte[] salt, String PassKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		String password = PassKey;
		SecretKey key = deriveKey(password, salt);

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

		byte[] decryptedContent = cipher.doFinal(encryptedData);
		return new String(decryptedContent);
	}
}
