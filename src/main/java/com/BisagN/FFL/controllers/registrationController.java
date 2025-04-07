
package com.BisagN.FFL.controllers;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbAdminSetting;
import com.BisagN.FFL.models.TbCountryName;
import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.TbRegistrationDetailChild;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.AddPhotoRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.RegistrationRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.FFL.repository.RegistrationChildRepository;

import com.BisagN.controller.AESGCM;
import com.BisagN.controller.AesUtil;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@RestController
public class registrationController {

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RegistrationChildRepository registrationChildRepository;

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	UserLoginChildRepository userLoginChildRepository;

	@Autowired
	NotificationController notificationController;

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	private AddPhotoRepository adminSettingRepository;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView model = new ModelAndView();
		model.setViewName("registration");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getInstitute", method = RequestMethod.POST, produces = { "application/json" })
	public String getInstitute(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TbInstituteDetail> list1 = instituteRepository.LoadInstituteData();

			if (!list1.isEmpty()) {

				for (TbInstituteDetail tbInstituteDetail : list1) {
					object = new JSONObject();

					object.put("id", tbInstituteDetail.getId());
					object.put("institute_name", tbInstituteDetail.getInstituteName());
					jSONArray.add(object);
				}
				object1.put("institutelist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("institutelist", jSONArray);
			}

			object1.put("Status", "1");
			object1.put("Message", "Success");

		} catch (Exception e) {
			e.printStackTrace();
			object1 = new JSONObject();
			object1.put("Status", "0");
			object1.put("Message", "Something went wrong");
		}
		return object1.toJSONString();
	}
//	 @ResponseBody
//	    @PostMapping(value = "/admin/getInstitute", produces = "application/json")
//	    public String getInstitute(HttpServletRequest request) {
//	        JSONArray jsonArray = new JSONArray();
//	        JSONObject responseObject = new JSONObject();
//
//	        try {
//	        	List<TbAdminSetting> list = adminSettingRepository.findByFlag("institute"); 
//
//	            if (!list.isEmpty()) {
//	                for (TbAdminSetting setting : list) {
//	                    JSONObject object = new JSONObject();
//	                    object.put("id", setting.getId());
//	                    object.put("institute_name", setting.getText());  // Assuming 'text' field stores the institute name
//	                    jsonArray.add(object);
//	                }
//	            }
//
//	            responseObject.put("institutelist", jsonArray);
//	            responseObject.put("Status", "1");
//	            responseObject.put("Message", "Success");
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            responseObject.put("Status", "0");
//	            responseObject.put("Message", "Something went wrong");
//	        }
//	        return responseObject.toJSONString();
//	    }
	@RequestMapping(value = "/admin/SaveRegistrationDetails", method = RequestMethod.POST, produces = {
			"application/json" })
	public String SaveRegistrationDetails(@RequestParam("tbRegistrationDetail") String tbRegistrationDetail1,
			@RequestParam("registrationchild") String registrationchild, HttpServletRequest request)
			throws IOException, DecoderException {

		String returnstring = "";
		JSONObject jsonobjectout = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject2 = new JSONObject();
		JSONParser JsonParser = new JSONParser();

//		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		try {

			int iterationCount = Integer.parseInt("1000");
			int keySize = Integer.parseInt("128");
			AesUtil aesUtil = new AesUtil(keySize, iterationCount);

			ObjectMapper objectMapper = new ObjectMapper();

			jsonobjectout = (JSONObject) JsonParser.parse(tbRegistrationDetail1);

			byte[] data1 = Base64Service.decode(jsonobjectout.get("data").toString());

			JsonNode[] jsonNodes = objectMapper.readValue(data1, JsonNode[].class);
			int j = 1;

			String alumniName = "";
			String userName = "";
			String contactNumber = "";
			String emailId = "";
			String gender = "";
			String countryId = "";
			String salt = "";
			String iv = "";
			String key = "";
			String passWord = "";
			

			for (JsonNode jsonNode : jsonNodes) {
				String randomKey = jsonNode.fieldNames().next();
				String value = jsonNode.get(randomKey).asText();

				if (j == 1) {
					alumniName = jsonNode.get(randomKey).asText();
				}
				if (j == 2) {
					userName = jsonNode.get(randomKey).asText();
				}
				if (j == 3) {
					contactNumber = jsonNode.get(randomKey).asText();
				}
				if (j == 4) {
					emailId = jsonNode.get(randomKey).asText();
				}
				if (j == 5) {
					gender = jsonNode.get(randomKey).asText();
				}
				if (j == 6) {
					countryId = jsonNode.get(randomKey).asText();
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
				if (j == 10) {
					passWord = jsonNode.get(randomKey).asText();
				}

				j++;

			}
//			userName = aesUtil.decrypt(salt, iv, key, userName);
			
			byte[] ivBytes = null;
			byte[] saltBytes = null;
			byte[] encryptedData = null;
			String passBytes = null;
			String PassKey = null;

			try {
				saltBytes = Base64Service.decode(salt);
				ivBytes = Base64Service.decode(iv);
				PassKey = new String(Base64Service.decode(key));
				passBytes = new String(Base64Service.decode(passWord));

			} catch (IOException e) {
				e.getMessage();
			}
			
			
			userName = decryptData(Base64Service.decode(userName), ivBytes, saltBytes, PassKey);
			
			
			
			List userlist = userLoginRepository.CheckLoginNameDetailsexist(userName);
			if(userlist != null && !userlist.isEmpty() && userlist.size() != 0) {
				jsonobjectout = new JSONObject();
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "User ID already exist");
				returnstring = jsonobjectout.toJSONString();
				return returnstring;
			}

			emailId = decryptData(Base64Service.decode(emailId), ivBytes, saltBytes, PassKey);

			contactNumber =decryptData(Base64Service.decode(contactNumber), ivBytes, saltBytes, PassKey);
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(passWord);

			TbRegistrationDetail tbRegistrationDetail = new TbRegistrationDetail();

			tbRegistrationDetail.setAlumniName(alumniName);
			tbRegistrationDetail.setContactNumber(contactNumber);
			TbCountryName tbCountryName = new TbCountryName();
			tbCountryName.setId(Integer.parseInt(countryId));

			tbRegistrationDetail.setCountryId(tbCountryName);
			tbRegistrationDetail.setEmailId(emailId);
			tbRegistrationDetail.setGender(gender);
			tbRegistrationDetail.setUserName(userName);
			tbRegistrationDetail.setPassworddd(hashedPassword);
			
			tbRegistrationDetail.setCreatedDate(new Date());
			registrationRepository.save(tbRegistrationDetail);

			jsonArray = (JSONArray) JsonParser.parse(registrationchild);

			String message = "";

			for (int i = 0; i < jsonArray.size(); i++) {

//				List<TbRegistrationDetailChild> tbRegistrationDetailChildren = mapper.readValue(registrationchild,
//						new TypeReference<List<TbRegistrationDetailChild>>() {
//						});

//				for (TbRegistrationDetailChild child : tbRegistrationDetailChildren) {
//					List CheckCIPexist = registrationChildRepository.checkCIPExist(
//							tbRegistrationDetail.getCountryId().getId(), child.getInstituteId().getId(),
//							child.getPassoutYear());
//					if (CheckCIPexist.isEmpty()) {

				TbInstituteDetail instituteDetail = new TbInstituteDetail();
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);

				int country_id = tbRegistrationDetail.getCountryId().getId();
				int ins_id = Integer.parseInt(jsonObject.get("instituteId_").toString());
				String rollnumber = jsonObject.get("rollNumber_").toString();
				rollnumber =decryptData(Base64Service.decode(rollnumber), ivBytes, saltBytes, PassKey);
				
				System.err.println("country_id "+country_id);
				System.err.println("ins_id "+ins_id);
				System.err.println("rollnumber "+rollnumber);
				

				Integer CheckCIPexist = registrationChildRepository.CheckRollNumberExist(country_id, rollnumber,
						ins_id);
				if (CheckCIPexist.toString().equalsIgnoreCase("0")) {

					TbRegistrationDetailChild registrationDetailChild = new TbRegistrationDetailChild();
					instituteDetail.setId(Integer.parseInt(jsonObject.get("instituteId_").toString()));
					registrationDetailChild.setInstituteId(instituteDetail);
					registrationDetailChild.setRegistrationId(tbRegistrationDetail);

//					String rollnumber1 =decryptData(Base64Service.decode(rollnumber), ivBytes, saltBytes, PassKey);

					registrationDetailChild.setRollNumber(rollnumber);
					registrationDetailChild.setPassoutYear(Integer.parseInt(jsonObject.get("passoutYear_").toString()));
					registrationDetailChild.setRegistrationStatus("Pending");

					Optional<TbCountryName> countryName = countryRepository
							.findById(tbRegistrationDetail.getCountryId().getId());

					if (countryName.get().getCountryName().equalsIgnoreCase("INDIA")) {
						registrationDetailChild.setEmbasyStatus("Accepted");
					} else {
						registrationDetailChild.setEmbasyStatus("Pending");
					}
					Optional<TbInstituteDetail> instituteDetail2 = instituteRepository
							.findById(instituteDetail.getId());
//					String shortInstituteName = instituteDetail2.get().getInstituteName().substring(
//							instituteDetail2.get().getInstituteName().indexOf('(') + 1,
//							instituteDetail2.get().getInstituteName().indexOf(')'));
					
					UserLogin userLogin = userLoginRepository.findUserinstituteFromInsID(ins_id);
					
					notificationController.SaveNotificationregistraion(
							"Registation Request For " + tbRegistrationDetail.getAlumniName(),
							tbRegistrationDetail.getId(), userLogin.getUserId());

					registrationChildRepository.save(registrationDetailChild);

					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Registration Successful, your request is pending for approval ");
					returnstring = jsonobjectout.toJSONString();
				} else {

					if (message.equalsIgnoreCase("")) {
						message = rollnumber;
					} else {
						message = message + " , " + rollnumber;
					}
				}
				if (message.equalsIgnoreCase("")) {
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Registration Successful, your request is pending for approval");
					returnstring = jsonobjectout.toJSONString();
				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Data Already Exist." + message);
					returnstring = jsonobjectout.toJSONString();
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
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
