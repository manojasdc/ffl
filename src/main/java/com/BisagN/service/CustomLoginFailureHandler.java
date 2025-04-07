//package com.BisagN.service;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import com.BisagN.models.UserLogin;
//import com.BisagN.util.Base64Service;
//
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.GCMParameterSpec;
//import javax.crypto.spec.PBEKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//
//
//@Component
//public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
//
//	@Autowired
//	UserDetailsServiceImpl userDetailsServiceImpl;
//	
//	public static final int MAX_FAILED_ATTEMPTS = 3;
//
//	private static final long LOCK_TIME_DURATION = 1 * 60 * 1000;
//
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException exception) throws IOException, ServletException {
//
//		String username =request.getParameter("username");
//		String salt = request.getParameter("salt");
//		String iv =  request.getParameter("iv");
//		String key =  request.getParameter("key");
//        byte[] ivBytes = null;
//        byte[] saltBytes = null;
//        String PassKey = null;
//        byte[] encryptedData =null;
//		try {
//			saltBytes=Base64Service.decode(salt);
//			ivBytes = Base64Service.decode(iv);
//			encryptedData=Base64Service.decode(username);
//			PassKey=new String(Base64Service.decode(key));
//			username= decryptData(encryptedData, ivBytes, saltBytes,PassKey);
//		} catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
//		}
//		
//		String message= "";
//		UserLogin user = userDetailsServiceImpl.findByUsername(username);
//		System.out.println("DIKSHA CAPTCHA"+request.getSession().getAttribute("captchaValidate").toString());
//		if (user != null && request.getSession().getAttribute("captchaValidate").toString().equalsIgnoreCase("true")) {
//			if (user.getUserName() != null) {
//				long lockTimeInMillis = user.getCap_locked_date().getTime();
//				long currentTimeInMillis = System.currentTimeMillis();
//				if (user.getEnabled() != 0 && user.getAccountnonlocked() != 0) {
//					if (user.getAttempt_captcha_count() < MAX_FAILED_ATTEMPTS) {
//						userDetailsServiceImpl.updateFailAttemptsCap(username);
//					}
//					else {
//						userDetailsServiceImpl.lock(username);
//						exception = new LockedException("Your account has been locked due to 3 failed attempts."
//								+ " It will be unlocked after 10 Minute.");
//						message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
//						
//					}
//				}
//			
//				else if (currentTimeInMillis - lockTimeInMillis > LOCK_TIME_DURATION) {
//					if (user.getAttempt_captcha_count() > 0) {
//						exception = new LockedException("Please Enter Valid Credentials.");
//					}
//				}
//			}
//		} else 
//			
//			if (user != null && !request.getSession().getAttribute("captchaValidate").toString().equalsIgnoreCase("true")) {
//
//			long lockTimeInMillis1 = user.getCap_locked_date().getTime();
//			long currentTimeInMillis1 = System.currentTimeMillis();
//			if (user.getEnabled() != 0 && user.getAccountnonlocked() != 0) {
//				if (user.getAttempt_captcha_count() < MAX_FAILED_ATTEMPTS) {
//					userDetailsServiceImpl.updateFailAttemptsCap(username);
//					exception = new LockedException("Please Enter Valid Captcha!.");
//				}
//				else {
//					userDetailsServiceImpl.lock(username);
//					exception = new LockedException("Your account has been locked due to 3 failed attempts."
//							+ " It will be unlocked after 10 Minute.");
//					message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
//					
//
//				}
//			} else if (currentTimeInMillis1 - lockTimeInMillis1 > LOCK_TIME_DURATION) {
//				if (user.getAttempt_captcha_count() > 0) {
//					exception = new LockedException("Please Enter Valid Captcha!");
//					
//				}
//			} else if (currentTimeInMillis1 - lockTimeInMillis1 < LOCK_TIME_DURATION) {
//				if (user.getAttempt_captcha_count() > 0) {
//					exception = new LockedException("Your account has been locked due to 3 failed attempts."
//							+ " It will be unlocked after 10 Minute.");
//					message = "Your account has been locked due to 3 failed attempts.It will be unlocked after 10 Minute.";
//				}
//			}
//		}
//		else {
//			exception = new LockedException("Please Enter Valid Credentials");
//		}
//
//		super.setDefaultFailureUrl("/signin?error=true");
//		super.onAuthenticationFailure(request, response, exception);
//	}
//	
//	public static SecretKey deriveKey(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        int iterations = 600000;
//        int keyLength = 256; 
//
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
//        SecretKey tmp = factory.generateSecret(spec);
//        return new SecretKeySpec(tmp.getEncoded(), "AES");
//    }
//   
//    public static String decryptData(byte[] encryptedData, byte[] iv, byte[] salt,String PassKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
//        String password=PassKey;
//    	SecretKey key = deriveKey(password, salt);
//
//        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
//        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
//
//        byte[] decryptedContent = cipher.doFinal(encryptedData);
//        return new String(decryptedContent);
//    }
//
//}