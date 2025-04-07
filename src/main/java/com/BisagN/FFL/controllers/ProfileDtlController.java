package com.BisagN.FFL.controllers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.codec.DecoderException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbHallOfFame;
import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbProfileDtl;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.ProfileRepository;
import com.BisagN.FFL.repository.RegistrationRepository;
import com.BisagN.controller.AES;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.AesGcmEncryption;
import com.BisagN.controller.AesUtil;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProfileDtlController {

	

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();

	private String pathforProfilephoto;

	@Value("${pathforProfilephoto}")
	public void pathforProfilephoto(String pathforProfilephoto) {
		this.pathforProfilephoto = pathforProfilephoto;
	}

	public static String GeneratedKey;
	public static String GeneratedIV;
	public static String GeneratedSalt;
	public static String Generatedpassword;

	@RequestMapping(value = "/admin/myprofile", method = RequestMethod.GET)
	public ModelAndView myprofile(HttpServletRequest request, ModelMap Mmap) throws Exception {
		ModelAndView model = new ModelAndView();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

//		AesGcmEncryption aesgcm = new AesGcmEncryption();
//		GeneratedKey = aesgcm.getEncodedKey();
//		GeneratedIV = aesgcm.getEncodedIV();
//		GeneratedSalt = aesgcm.getEncodedSalt();
//		Generatedpassword = aesgcm.getEncodedPassword();
		
		

		AesGcmEncryption aesGcmEncryption1 = new AesGcmEncryption();
		String keyjson = aesGcmEncryption1.GenerateKey();
		JSONParser jsonp = new JSONParser();
		System.err.println("Encrypted keyjson "+keyjson);
		JSONObject jsonObject2 = (JSONObject)jsonp.parse(keyjson);
		GeneratedIV = jsonObject2.get("IV").toString();
		GeneratedSalt = jsonObject2.get("Salt").toString();
		Generatedpassword = jsonObject2.get("password").toString();
		
		
		Mmap.addAttribute("GeneratedKey", "");
		Mmap.addAttribute("GeneratedIV", GeneratedIV);
		Mmap.addAttribute("GeneratedSalt", GeneratedSalt);
		Mmap.addAttribute("Generatedpassword", Generatedpassword);
		model.setViewName("myprofile");

		return model;
	}

	@RequestMapping(value = "/admin/saveProfiledtl", method = RequestMethod.POST, produces = { "application/json" })
	public String saveProfiledtl(@Valid @RequestParam("ProfileDtl") String profileDtl, HttpServletRequest request,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage)
			throws IOException, DecoderException, ParseException {
		String returnstring = "";

		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonobjectout = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonObject2 = new JSONObject();
		
		try {
			
			int iterationCount = Integer.parseInt("1000");
			int keySize = Integer.parseInt("128");
			AesUtil aesUtil = new AesUtil(keySize, iterationCount);

			ObjectMapper objectMapper = new ObjectMapper();

			jsonobjectout = (JSONObject) jsonp.parse(profileDtl);

			byte[] data1 = Base64Service.decode(jsonobjectout.get("data").toString());

			JsonNode[] jsonNodes = objectMapper.readValue(data1, JsonNode[].class);
			int j = 1;
		

			String name = "";
			String contactNumber = "";
			String emailId = "";
			String dateOfBirth = "";
			String gender = "";
			String address = "";
			String salt = "";
			String iv = "";
			String key = "";

			for (JsonNode jsonNode : jsonNodes) {
				String randomKey = jsonNode.fieldNames().next();
				//String value = jsonNode.get(randomKey).asText();

				if (j == 1) {
					name = jsonNode.get(randomKey).asText();
					
				}
				if (j == 2) {
					emailId = jsonNode.get(randomKey).asText();
				}
				if (j == 3) {
					dateOfBirth = jsonNode.get(randomKey).asText();
				}
				if (j == 4) {
					contactNumber = jsonNode.get(randomKey).asText();
				}
				
				if (j == 5) {
					gender = jsonNode.get(randomKey).asText();
				}
				if (j == 6) {
					address = jsonNode.get(randomKey).asText();
				}

				if (j == 7) {
					salt = jsonNode.get(randomKey).asText();
				}
				if (j == 8) {
					iv = jsonNode.get(randomKey).asText();
				}

				if (j == 9) {
					key = jsonNode.get(randomKey).asText();
				}

				j++;

			}
//			userName = aesUtil.decrypt(salt, iv, key, userName);
			
			
			byte[] ivBytes = null;
			byte[] saltBytes = null;
			byte[] encryptedData = null;
			String PassKey = null;

			try {
				saltBytes = Base64Service.decode(salt);
				ivBytes = Base64Service.decode(iv);
				PassKey = new String(Base64Service.decode(key));

			} catch (IOException e) {
				e.getMessage();
			}
			
			emailId = decryptData(Base64Service.decode(emailId), ivBytes, saltBytes, PassKey);

			contactNumber =decryptData(Base64Service.decode(contactNumber), ivBytes, saltBytes, PassKey);

			if (uploadImage != null) {
				if (uploadImage.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Profile Photo size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
			}

			if (uploadImage != null) {
				String message = imageValidationController.checkFileFormats(uploadImage,
						uploadImage.getOriginalFilename(), "image");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For JPEG");
					return jsonobjectout.toJSONString();
				} else {
				}
			} else {
			}

			
			String dateFormat = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date dob = sdf.parse(dateOfBirth);
		  
			TbProfileDtl profiledtl = new TbProfileDtl();
			profiledtl.setAddress(address);
			profiledtl.setContactNo(contactNumber);
			profiledtl.setDateOfBirth(dob);
			profiledtl.setPhoto(profiledtl.getPhoto());
			profiledtl.setEmailId(emailId);
			profiledtl.setGender(gender);
			profiledtl.setName(name);
			String roleName = request.getSession().getAttribute("role").toString();

			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

			Set<ConstraintViolation<TbProfileDtl>> constraintViolations = validator.validate(profiledtl);

			if (constraintViolations != null && !constraintViolations.isEmpty()) {

				for (ConstraintViolation c : constraintViolations) {
					JSONObject jsonObject = new JSONObject();
					jsonObject1.put(c.getPropertyPath(), c.getMessageTemplate());
					jsonArray.add(jsonObject1);

				}
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("status", "0");
				jsonObject.put("message", jsonArray.toJSONString());
				return jsonObject.toJSONString();
			}
	
			
			
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

			if (uploadImage != null) {
				byte[] bytes = uploadImage.getBytes();

				File dir = new File(pathforProfilephoto);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = uploadImage.getOriginalFilename();
				String photoname = dir.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + profiledtl.getName() + "_m_" + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				profiledtl.setPhoto(photoname);
			}
			TbProfileDtl tbProfileDtl1 = profileRepository.getDetails(Integer.parseInt(sessionuserid));

			if (tbProfileDtl1 == null) {
				
			
				profiledtl.setCreatedBy(Integer.parseInt(sessionuserid));
				profiledtl.setStatus("1");
				jsonobjectout.put("status", "1");

				profileRepository.save(profiledtl);
				jsonobjectout.put("message", "profile Details saved Successfully");
				returnstring = jsonobjectout.toJSONString();
			} else {
				TbProfileDtl obj2 = tbProfileDtl1;

				if (uploadImage == null) {
					profiledtl.setPhoto(obj2.getPhoto());
				}
				
				
				profiledtl.setCreatedBy(obj2.getCreatedBy());
				profiledtl.setStatus(obj2.getStatus());
				profiledtl.setId(obj2.getId());
				profileRepository.save(profiledtl);
				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "Profile Details updated Successfully");
				returnstring = jsonobjectout.toJSONString();
			}

		} 
		catch (ParseException e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message","Invalid Json Formate.");
			returnstring = jsonobjectout.toJSONString();
		}
		catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}
		return returnstring;
	}

	@RequestMapping(value = "/admin/loadProfiledtl", method = RequestMethod.POST, produces = { "application/json" })
	public String loadProfiledtl(HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();

		String returnstring = "";

		try {
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			TbProfileDtl tbProfileDtl = profileRepository.getDetails(Integer.parseInt(sessionuserid));

			if (tbProfileDtl != null) {
				jsonobjectout.put("status", "1");
				jsonobjectout.put("Message", "Success");
System.err.println("helloinprofiole+ ");
				AesGcmEncryption aesgcm = new AesGcmEncryption();

				String salt = ProfileDtlController.GeneratedSalt;
				String iv = ProfileDtlController.GeneratedIV;
				String key = ProfileDtlController.GeneratedKey;
				String password = ProfileDtlController.Generatedpassword;
//				System.out.println("salt "+salt);
//				System.out.println("iv "+iv);
//				System.out.println("key "+key);
//				System.out.println("password "+password);
//				
				
				String emailId = tbProfileDtl.getEmailId();
				String contactNo = tbProfileDtl.getContactNo();
				
				
				AesGcmEncryption aesGcmEncryption1 = new AesGcmEncryption();
				String encryptedemail = aesGcmEncryption1.encryptData1(emailId, Generatedpassword, GeneratedSalt, GeneratedIV);
				String encryptedcontatcno = aesGcmEncryption1.encryptData1(contactNo, Generatedpassword, GeneratedSalt, GeneratedIV);
//				System.err.println("Encrypted Data "+encryptedemail);
				JSONObject obj1= (JSONObject) jsonp.parse(encryptedemail);
				jsonobjectout.put("emailId", obj1.get("Ciphertext"));
				jsonobjectout.put("emailIdAuth", obj1.get("AuthTag"));
				obj1= (JSONObject) jsonp.parse(encryptedcontatcno);
				jsonobjectout.put("contactNo", obj1.get("Ciphertext"));
				jsonobjectout.put("contactNoAuth", obj1.get("AuthTag"));


				jsonobjectout.put("name", tbProfileDtl.getName());
			
				
				jsonobjectout.put("gender", tbProfileDtl.getGender());
				Date dateOfBirth = tbProfileDtl.getDateOfBirth();
				if (dateOfBirth != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String formattedDate = sdf.format(dateOfBirth);
					jsonobjectout.put("dateOfBirth", formattedDate);
				} else {
					jsonobjectout.put("dateOfBirth", dateOfBirth); 
				}
				jsonobjectout.put("address", tbProfileDtl.getAddress());
				jsonobjectout.put("uploadPic", "No Image");
				if (tbProfileDtl.getPhoto() != null && !tbProfileDtl.getPhoto().equalsIgnoreCase("")) {
					String imagestr = imageEncoderDecoder(tbProfileDtl.getPhoto());
					if (!imagestr.equalsIgnoreCase("")) {
						jsonobjectout.put("uploadPic", imagestr);
					}
				}
				jsonobjectout.put("id", tbProfileDtl.getId());
				returnstring = jsonobjectout.toJSONString();
				jsonArray1.add(jsonobjectout);
			} else {
				
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "No Data Found");
				returnstring = jsonobjectout.toJSONString();
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			jsonobjectout.put("data", jsonArray1);

			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}
		System.out.println("returnstring "+returnstring);
		return returnstring;
	}
//
//	@RequestMapping(value = "/admin/loadProfiledtl", method = RequestMethod.POST, produces = { "application/json" })
//	public String loadProfiledtl(HttpServletRequest request) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//
//		String returnstring = "";
//
//		try {
//			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//			TbProfileDtl tbProfileDtl = profileRepository.getDetails(Integer.parseInt(sessionuserid));
//
//			if (tbProfileDtl != null) {
//				jsonobjectout.put("status", "1");
//				jsonobjectout.put("Message", "Success");
//
//				AesGcmEncryption aesgcm = new AesGcmEncryption();
//				GeneratedKey = aesgcm.getEncodedKey();
//				GeneratedIV = aesgcm.getEncodedIV();
//				GeneratedSalt = aesgcm.getEncodedSalt();
//				Generatedpassword = aesgcm.getEncodedPassword();
//
//				String iv = GeneratedIV;
//				String salt = GeneratedSalt;
//				String key = GeneratedKey;
//				String password = Generatedpassword;
//				String api_url_encrypted = rs.getString("api_url");
//		
//				String encryptedApiUrl = aesgcm.encryptData(api_url_encrypted);
//				JSONObject obj=new JSONObject(encryptedApiUrl);
//				// Encrypt email ID and contact number
//				String emailId = tbProfileDtl.getEmailId();
//				String contactNo = tbProfileDtl.getContactNo();
//				String encryptedEmailId = aesgcm.encryptData(emailId);
//				String encryptedContactNo = aesgcm.encryptData(contactNo);
//
//				jsonobjectout.put("encryptedApiUrl", obj.get("Ciphertext"));
//				jsonobjectout.put("authTag", obj.get("AuthTag"));
//				jsonobjectout.put("name", tbProfileDtl.getName());
//				jsonobjectout.put("emailId", encryptedEmailId);
//				jsonobjectout.put("contactNo", encryptedContactNo);
//				jsonobjectout.put("gender", tbProfileDtl.getGender());
//				Date dateOfBirth = tbProfileDtl.getDateOfBirth();
//				if (dateOfBirth != null) {
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					String formattedDate = sdf.format(dateOfBirth);
//					jsonobjectout.put("dateOfBirth", formattedDate);
//				} else {
//					jsonobjectout.put("dateOfBirth", dateOfBirth); // Or you could put an empty string or some default
//																	// value
//				}
//				jsonobjectout.put("address", tbProfileDtl.getAddress());
//				jsonobjectout.put("uploadPic", "No Image");
//				if (tbProfileDtl.getPhoto() != null && !tbProfileDtl.getPhoto().equalsIgnoreCase("")) {
//					String imagestr = imageEncoderDecoder(tbProfileDtl.getPhoto());
//					if (!imagestr.equalsIgnoreCase("")) {
//						jsonobjectout.put("uploadPic", imagestr);
//					}
//				}
//				jsonobjectout.put("id", tbProfileDtl.getId());
//				returnstring = jsonobjectout.toJSONString();
//				jsonArray1.add(jsonobjectout);
//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "No Data Found");
//				returnstring = jsonobjectout.toJSONString();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonobjectout.put("data", jsonArray1);
//
//			jsonobjectout.put("status", "0");
//			jsonobjectout.put("message", "Failure");
//			returnstring = jsonobjectout.toJSONString();
//		}

//		try {
//			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//			TbProfileDtl tbProfileDtl = profileRepository.getDetails(Integer.parseInt(sessionuserid));
//			
//			if (tbProfileDtl != null) {
//				jsonobjectout.put("status", "1");
//				jsonobjectout.put("Message", "Success");
//				
//				AesGcmEncryption aesgcm = new AesGcmEncryption();
//				GeneratedKey = aesgcm.getEncodedKey();
//				GeneratedIV= aesgcm.getEncodedIV();
//				GeneratedSalt=aesgcm.getEncodedSalt();
//				Generatedpassword=aesgcm.getEncodedPassword();
//				
//				String iv = GeneratedIV;
//				String salt=GeneratedSalt;
//				String key=GeneratedKey;
//				String password=Generatedpassword;
////				AesGcmEncryption aesgcm = new AesGcmEncryption(key, iv, salt, password);
//				String api_url_encrypted = rs.getString("api_url");
//				String encryptedApiUrl = aesgcm.encryptData(api_url_encrypted);
//				
//				
//				jsonobjectout.put("encryptedApiUrl", obj.get("Ciphertext"));
//				jsonobjectout.put("authTag", obj.get("AuthTag"));
//				jsonobjectout.put("name", tbProfileDtl.getName());
//				jsonobjectout.put("emailId", tbProfileDtl.getEmailId());
//				jsonobjectout.put("contactNo", tbProfileDtl.getContactNo());
//				jsonobjectout.put("gender", tbProfileDtl.getGender());
//				Date dateOfBirth = tbProfileDtl.getDateOfBirth();
//				if (dateOfBirth != null) {
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					String formattedDate = sdf.format(dateOfBirth);
//					jsonobjectout.put("dateOfBirth", formattedDate);
//				} else {
//					jsonobjectout.put("dateOfBirth", dateOfBirth); // Or you could put an empty string or some default
//																	// value
//				}
//				jsonobjectout.put("address", tbProfileDtl.getAddress());
//				jsonobjectout.put("uploadPic", "No Image");
//				if (tbProfileDtl.getPhoto() != null && !tbProfileDtl.getPhoto().equalsIgnoreCase("")) {
//					String imagestr = imageEncoderDecoder(tbProfileDtl.getPhoto());
//					if (!imagestr.equalsIgnoreCase("")) {
//						jsonobjectout.put("uploadPic", imagestr);
//					}
//				}
//				jsonobjectout.put("id", tbProfileDtl.getId());
//				returnstring = jsonobjectout.toJSONString();
//				jsonArray1.add(jsonobjectout);
//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "No Data Found");
//				returnstring = jsonobjectout.toJSONString();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonobjectout.put("data", jsonArray1);
//
//			jsonobjectout.put("status", "0");
//			jsonobjectout.put("message", "Failure");
//			returnstring = jsonobjectout.toJSONString();
//		}

//	return returnstring;
//
//	}

	public String imageEncoderDecoder(String imagepath) throws IOException {
		String imageString = "";
		try {
			FileInputStream stream = new FileInputStream(imagepath);

			// get byte array from image stream
			int bufLength = 2048;
			byte[] buffer = new byte[2048];
			byte[] data;

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int readLength;
			while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
				out.write(buffer, 0, readLength);
			}

			data = out.toByteArray();
			imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

			out.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageString;
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