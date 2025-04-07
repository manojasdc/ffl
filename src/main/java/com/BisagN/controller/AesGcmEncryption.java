package com.BisagN.controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONObject;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class AesGcmEncryption {

	private SecretKey key;
	private String password;
	private byte[] iv;
	private byte[] salt;

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public AesGcmEncryption() throws Exception {
		this.salt = new byte[16];
		new SecureRandom().nextBytes(this.salt);
		this.password = generateRandomString(10);

		this.key = deriveKey(password, this.salt);

		this.iv = new byte[12];
		new SecureRandom().nextBytes(this.iv);

	}

	public AesGcmEncryption(String encodedKey, String encodedIV, String encodedSalt, String encodedPassword) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

		this.iv = Base64.getDecoder().decode(encodedIV);
		this.salt = Base64.getDecoder().decode(encodedSalt); // Decode and set the salt
		this.password = encodedPassword;
	}

	// Method to derive key from password and salt
	public static SecretKey deriveKey(String password, byte[] salt) throws Exception {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 600000, 256);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] keyBytes = factory.generateSecret(spec).getEncoded();
		return new SecretKeySpec(keyBytes, "AES");
	}

	public String encryptData2(String data) throws Exception {

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv); // 128-bit auth tag
		cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

		byte[] ciphertextWithTag = cipher.doFinal(data.getBytes("UTF-8"));
		byte[] authTag = new byte[16];
		byte[] ciphertext = new byte[ciphertextWithTag.length - 16];
		System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, ciphertext.length);
		System.arraycopy(ciphertextWithTag, ciphertext.length, authTag, 0, authTag.length);

		JSONObject obj = new JSONObject();
//		obj.put("Salt", Base64.getEncoder().encodeToString(salt));
		obj.put("Ciphertext", Base64.getEncoder().encodeToString(ciphertext));
		obj.put("AuthTag", Base64.getEncoder().encodeToString(authTag));
//return Base64.getEncoder().encodeToString(ciphertext);
		return obj.toString();
	}

	public String getEncodedKey() {
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}

	public String getEncodedIV() {
		return Base64.getEncoder().encodeToString(iv);
	}

	public String getEncodedPassword() {
		return password;
	}

	public String getEncodedSalt() {
		return Base64.getEncoder().encodeToString(salt); // Return the encoded salt
	}

	// Encrypt method
	public static String encryptData(String data, String password) throws Exception {
		// Generate random salt (16 bytes)
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);

		// Derive key from password and salt
		SecretKey key = deriveKey(password, salt);

		// Generate random IV (12 bytes for GCM)
		byte[] iv = new byte[12];
		new SecureRandom().nextBytes(iv);

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv); // 128-bit auth tag
		cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

		// Encrypt the data
		byte[] ciphertextWithTag = cipher.doFinal(data.getBytes("UTF-8"));

		// Separate ciphertext and authTag (last 16 bytes are the auth tag)
		byte[] ciphertext = new byte[ciphertextWithTag.length - 16];
		byte[] authTag = new byte[16];
		System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, ciphertext.length);
		System.arraycopy(ciphertextWithTag, ciphertext.length, authTag, 0, authTag.length);

		// Print Base64-encoded values
//        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
//        System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));
//        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
//        System.out.println("AuthTag: " + Base64.getEncoder().encodeToString(authTag));

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Salt", Base64.getEncoder().encodeToString(salt));
		jsonObject.put("IV", Base64.getEncoder().encodeToString(iv));
		jsonObject.put("Ciphertext", Base64.getEncoder().encodeToString(ciphertext));
		jsonObject.put("AuthTag", Base64.getEncoder().encodeToString(authTag));

		return jsonObject.toJSONString();

	}

	public static String GenerateKey() {
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);

		// Derive key from password and salt

		// Generate random IV (12 bytes for GCM)
		byte[] iv = new byte[12];
		new SecureRandom().nextBytes(iv);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Salt", Base64.getEncoder().encodeToString(salt));
		jsonObject.put("IV", Base64.getEncoder().encodeToString(iv));
		jsonObject.put("password", generateRandomString(10));

		return jsonObject.toJSONString();

	}

	public static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(randomIndex);
			sb.append(randomChar);
		}
		return sb.toString();
	}

	public static String encryptData1(String data, String password, String salt, String iv) throws Exception {
		// Generate random salt (16 bytes)

		SecretKey key = deriveKey(password, Base64.getDecoder().decode(salt));
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, Base64.getDecoder().decode(iv)); // 128-bit auth tag
		cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

		// Encrypt the data
		byte[] ciphertextWithTag = cipher.doFinal(data.getBytes("UTF-8"));

		// Separate ciphertext and authTag (last 16 bytes are the auth tag)
		byte[] ciphertext = new byte[ciphertextWithTag.length - 16];
		byte[] authTag = new byte[16];
		System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, ciphertext.length);
		System.arraycopy(ciphertextWithTag, ciphertext.length, authTag, 0, authTag.length);

//        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
//        System.out.println("AuthTag: " + Base64.getEncoder().encodeToString(authTag));

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Ciphertext", Base64.getEncoder().encodeToString(ciphertext));
		jsonObject.put("AuthTag", Base64.getEncoder().encodeToString(authTag));

		return jsonObject.toJSONString();

	}

	public static void main(String[] args) throws Exception {
		String data = "Hello, World!";
		String password = "securePassword123";

		encryptData(data, password);
	}
}

//package com.BisagN.controller;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.GCMParameterSpec;
//import javax.crypto.spec.PBEKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.json.simple.JSONObject;
//
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Random;
//
//public class AesGcmEncryption {
//
//	private SecretKey key;
//	private String password;
//	private byte[] iv;
//	private byte[] salt; 
//	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//
//	public AesGcmEncryption() throws Exception {
//		this.salt = new byte[16];
//		new SecureRandom().nextBytes(this.salt);
//		this.password = generateRandomString(10);
//
//		this.key = deriveKey(password, this.salt);
//
//		this.iv = new byte[12];
//		new SecureRandom().nextBytes(this.iv);
//
//	}
//
//	public AesGcmEncryption(String encodedKey, String encodedIV, String encodedSalt,
//			String encodedPassword) {
//		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//		this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//
//		this.iv = Base64.getDecoder().decode(encodedIV);
//		this.salt = Base64.getDecoder().decode(encodedSalt); // Decode and set the salt
//		this.password = encodedPassword;
//	}
//
//	public static String generateRandomString(int length) {
//		Random random = new Random();
//		StringBuilder sb = new StringBuilder(length);
//		for (int i = 0; i < length; i++) {
//			int randomIndex = random.nextInt(CHARACTERS.length());
//			char randomChar = CHARACTERS.charAt(randomIndex);
//			sb.append(randomChar);
//		}
//		return sb.toString();
//	}
//
//	public static SecretKey deriveKey(String password, byte[] salt) throws Exception {
//		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 600000, 256);
//		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//		byte[] keyBytes = factory.generateSecret(spec).getEncoded();
//		return new SecretKeySpec(keyBytes, "AES");
//	}
//
//	public String encryptData(String data) throws Exception {
//
//		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv); // 128-bit auth tag
//		cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);
//
//		byte[] ciphertextWithTag = cipher.doFinal(data.getBytes("UTF-8"));
//		   byte[] authTag = new byte[16];
//		byte[] ciphertext = new byte[ciphertextWithTag.length - 16];
//		System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, ciphertext.length);
//		System.arraycopy(ciphertextWithTag, ciphertext.length, authTag, 0, authTag.length);
//
//		JSONObject obj = new JSONObject();
////		obj.put("Salt", Base64.getEncoder().encodeToString(salt));
//		obj.put("Ciphertext", Base64.getEncoder().encodeToString(ciphertext));
//		obj.put("AuthTag", Base64.getEncoder().encodeToString(authTag));
//		
//		
//		System.err.println("Ceipher TE cx x "+Base64.getEncoder().encodeToString(ciphertext));
//		System.err.println("Ceipher TE cx x "+Base64.getEncoder().encodeToString(authTag));
//		
////return Base64.getEncoder().encodeToString(ciphertext);
//		return obj.toString();
//	}
//
//	public String getEncodedKey() {
//		return Base64.getEncoder().encodeToString(key.getEncoded());
//	}
//
//	public String getEncodedIV() {
//		return Base64.getEncoder().encodeToString(iv);
//	}
//
//	public String getEncodedPassword() {
//		return password;
//	}
//
//
//	public String getEncodedSalt() {
//		return Base64.getEncoder().encodeToString(salt); // Return the encoded salt
//	}
//
//
//}

//package com.BisagN.controller;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.GCMParameterSpec;
//import javax.crypto.spec.PBEKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.json.simple.JSONObject;
//
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Random;
//
//public class AesGcmEncryption {
//
//	private SecretKey key;
//	private String password;
//	private byte[] iv;
//	private byte[] salt; 
//	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//
//	public AesGcmEncryption() throws Exception {
//		this.salt = new byte[16];
//		new SecureRandom().nextBytes(this.salt);
//		this.password = generateRandomString(10);
//
//		this.key = deriveKey(password, this.salt);
//
//		this.iv = new byte[12];
//		new SecureRandom().nextBytes(this.iv);
//
//	}
//
//	public AesGcmEncryption(String encodedKey, String encodedIV, String encodedSalt,
//			String encodedPassword) {
//		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//		this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//
//		this.iv = Base64.getDecoder().decode(encodedIV);
//		this.salt = Base64.getDecoder().decode(encodedSalt); // Decode and set the salt
//		this.password = encodedPassword;
//	}
//
//	public static String generateRandomString(int length) {
//		Random random = new Random();
//		StringBuilder sb = new StringBuilder(length);
//		for (int i = 0; i < length; i++) {
//			int randomIndex = random.nextInt(CHARACTERS.length());
//			char randomChar = CHARACTERS.charAt(randomIndex);
//			sb.append(randomChar);
//		}
//		return sb.toString();
//	}
//
//	public static SecretKey deriveKey(String password, byte[] salt) throws Exception {
//		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 600000, 256);
//		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//		byte[] keyBytes = factory.generateSecret(spec).getEncoded();
//		return new SecretKeySpec(keyBytes, "AES");
//	}
//
//	public String encryptData(String data) throws Exception {
//
//		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv); // 128-bit auth tag
//		cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);
//
//		byte[] ciphertextWithTag = cipher.doFinal(data.getBytes("UTF-8"));
//		   byte[] authTag = new byte[16];
//		byte[] ciphertext = new byte[ciphertextWithTag.length - 16];
//		System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, ciphertext.length);
//		System.arraycopy(ciphertextWithTag, ciphertext.length, authTag, 0, authTag.length);
//
//		JSONObject obj = new JSONObject();
////		obj.put("Salt", Base64.getEncoder().encodeToString(salt));
//		obj.put("Ciphertext", Base64.getEncoder().encodeToString(ciphertext));
//		obj.put("AuthTag", Base64.getEncoder().encodeToString(authTag));
////return Base64.getEncoder().encodeToString(ciphertext);
//		return obj.toString();
//	}
//
//	public String getEncodedKey() {
//		return Base64.getEncoder().encodeToString(key.getEncoded());
//	}
//
//	public String getEncodedIV() {
//		return Base64.getEncoder().encodeToString(iv);
//	}
//
//	public String getEncodedPassword() {
//		return password;
//	}
//
//
//	public String getEncodedSalt() {
//		return Base64.getEncoder().encodeToString(salt); // Return the encoded salt
//	}
//
//
//}
