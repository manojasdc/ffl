package com.BisagN.Rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.AesUtil;
import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_USER_MASTER;
import com.BisagN.models.TB_STU_STREAM_DTL;

import com.BisagN.models.UserLogin;
//import com.BisagN.models.UserRole;
import com.BisagN.models.UserRole;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.codec.DecoderException;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.QueryException;
import org.hibernate.exception.SQLGrammarException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.repository.RoleRepository;

import com.BisagN.repository.UserLoginRepository;
import com.BisagN.repository.UserRoleRepository;
import com.BisagN.util.Base64Service;
import com.BisagN.validation.PasswordValidator;
import com.BisagN.validation.ValidationController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserMasterController {
	@Autowired
	UserLoginRepository userLoginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserLoginChildRepository userLoginChildRepository;

	ValidationController validation = new ValidationController();

	@RequestMapping(value = "/admin/userLogin", method = RequestMethod.GET)
	public ModelAndView userLogin(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
		ModelAndView model1 = new ModelAndView();
		String roleid = session.getAttribute("roleid").toString();
		String rolename = request.getSession().getAttribute("role").toString();
		if (rolename.equalsIgnoreCase("SUPER ADMIN")) {
			Mmap.put("dashboardurl", "adminDashboard");
		}

		List val = roleRepository.ScreenRedirect("/userLogin", Integer.parseInt(roleid));
		Integer val1 = val.size();
//		val1 = true;
		String msg = null;
		try {
//			
//	
			if (val1 == 0) {
				model.addAttribute("errorMessage", "You are not authorized to access this Page!!!!");
				return new ModelAndView("loginError");
			} else {
			}
			if (request.getHeader("Referer") == null) {
				msg = "";
			}

		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		model1.setViewName("user_mstTiles");
		return model1;
//		ModelAndView model = new ModelAndView();
//		model.setViewName("user_mstTiles");
//		return model;
	}
	
	@RequestMapping(value = "/admin/addPhoto", method = RequestMethod.GET)
	public ModelAndView addPhoto(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
	    ModelAndView model1 = new ModelAndView();
	    model1.setViewName("addphoto");
	    return model1;
	}
	@RequestMapping(value = "/admin/uploadImage", method = RequestMethod.GET)
	public ModelAndView uploadImage(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
	    ModelAndView model1 = new ModelAndView();
	    model1.setViewName("uploadImage");
	    return model1;
	}

	
	/* GET ROLE DATA */
	@ResponseBody
	@RequestMapping(value = "/admin/getRoleDetail", method = RequestMethod.POST, produces = { "application/json" })
	public String getRoleDetail(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		try {

			String rolename = request.getSession().getAttribute("role").toString();
			List<Role> list1;
			if (rolename.equalsIgnoreCase("SUPER ADMIN")) {
				list1 = roleRepository.LoadRoleData2();
			} else {
				list1 = roleRepository.LoadRoleData1();
			}
			System.out.println("list1.size()" + list1.size());
			if (!list1.isEmpty()) {
				for (int i = 0; i < list1.size(); i++) {
					object = new JSONObject();
					Role role = list1.get(i);
					object.put("id", role.getRoleId());
					object.put("roleName", role.getRole().equals("ADMIN") ? "INSTITUTE ADMIN":role.getRole());
					jSONArray.add(object);
				}

				object1.put("roleList", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("roleList", jSONArray);
			}

			object1.put("Status", "1");
			object1.put("Message", "Success");

		} catch (Exception e) {
			e.printStackTrace();
			object1 = new JSONObject();
			object1.put("Status", "0");
			object1.put("Message", "Something went wrong");
		}
		System.out.println("Institute Data " + object1.toJSONString());
		return object1.toJSONString();
	}

	/* SAVE USER DATA */

	@RequestMapping(value = "/admin/SaveUserData", method = RequestMethod.POST, produces = { "application/json" })
	public String SaveUserData(@Valid @RequestBody String data, HttpServletRequest request) throws Exception {
		String rolename = request.getSession().getAttribute("role").toString();
		JSONArray jsonArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobjectOut = new JSONObject();
		UserLogin usrmaster = new UserLogin();

		int iterationCount = Integer.parseInt("1000");
		int keySize = Integer.parseInt("128");
		AesUtil aesUtil = new AesUtil(keySize, iterationCount);

		String returnstring = "";
		JSONObject jsonobjectout = new JSONObject();

		ObjectMapper objectMapper = new ObjectMapper();
		jsonobjectout = (JSONObject) jsonParser.parse(data);

		byte[] data1 = Base64Service.decode(jsonobjectout.get("data").toString());
		JsonNode[] jsonNodes = objectMapper.readValue(data1, JsonNode[].class);

		int i = 1;
		String encryptedText = "";
		String salt = "";
		String iv = "";
		String key = "";

		for (JsonNode jsonNode : jsonNodes) {
			String randomKey = jsonNode.fieldNames().next();
			String value = jsonNode.get(randomKey).asText();

			if (i == 1) {
				encryptedText = jsonNode.get(randomKey).asText();
			}
			if (i == 2) {
				salt = jsonNode.get(randomKey).asText();
			}
			if (i == 3) {
				iv = jsonNode.get(randomKey).asText();
			}
			if (i == 4) {
				key = new String(jsonNode.get(randomKey).asText());
			}
			i++;

		}

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
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(encryptedText);
		JSONObject decrptobject = new JSONObject();
		for (Object key1 : jsonNodes1.keySet()) {
			// Fetch the value associated with each key
			Object value = jsonNodes1.get(key1);
			String decrypt = decryptData(Base64Service.decode(value.toString()), ivBytes, saltBytes, PassKey);

			decrptobject.put(key1, decrypt);
		}

		TB_LDAP_USER_MASTER user = mapper.readValue(decrptobject.toJSONString(), TB_LDAP_USER_MASTER.class);
		List<UserLogin> CheckLoginNameDetailsexist = userLoginRepository
				.CheckLoginNameDetailsexist(user.getUser_name().trim().toLowerCase());

		List<UserLogin> existingInstituteUsers = userLoginRepository.CheckLoginNameDetailsexist2(user.getInstituteId(),user.getUser_role_id());

		List<UserLogin> existingEmbassyusers = userLoginRepository.CheckLoginNameDetailsexist3(user.getInstituteId(),
				user.getUser_role_id());
		try {

			boolean pass_valid = validate(user.getUser_password());
			if (pass_valid == false) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Enter Password in defined format");
				returnstring = jsonobjectout.toJSONString();
				return returnstring;
			}

			if (user.getUser_password().equals(user.getUser_re_password())) {
				String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
				if ((user.getId() != null && user.getId() != 0)) {
					Optional<UserLogin> user1 = userLoginRepository.findById(user.getId());
					if (user1 != null) {
						UserLogin user2 = user1.get();
						String modifydate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						user2.setEnabled(1);
						BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
						String hashedPassword = passwordEncoder.encode(user.getUser_password());
						user2.setPassword(hashedPassword);
						user2.setAc_dc_date(modifydate);
						user2.setAccountnonexpired(1);
						user2.setAccountnonlocked(1);
						user2.setCreated_by(sessionuserid.toString());// Integer.parseInt(sessionuserid)
//						user2.setRole_map(Integer.parseInt(sessionuserid));
						user2.setRole_map(user2.getRole_map());
						user2.setCreated_on(new Date());
						user2.setInstituteId(user.getInstituteId());
						user2.setAttempt_captcha_count(0);
						user2.setCap_locked_date(new Date());
						userLoginRepository.save(user2);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Details updated Successfully");
						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Please Select The Id For Update");
						returnstring = jsonobjectout.toJSONString();
					}

				} else {

					if (CheckLoginNameDetailsexist.isEmpty()) {
						if (existingInstituteUsers.isEmpty()) {

							if (existingEmbassyusers.isEmpty()) {
								String modifydate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
								final String currentUserName = SecurityContextHolder.getContext().getAuthentication()
										.getName();
								UserLogin userLogin = new UserLogin();
								userLogin.setEnabled(1);
								BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
								String hashedPassword = passwordEncoder.encode(user.getUser_password());
								userLogin.setPassword(hashedPassword);
								userLogin.setUserName(user.getUser_name());
								userLogin.setLogin_name(user.getLogin_name());
								userLogin.setArmy_no(UUID.randomUUID().toString().substring(0,4));
								userLogin.setAc_dc_date(modifydate);
								userLogin.setAccountnonexpired(1);
								userLogin.setAccountnonlocked(1);
								userLogin.setCreated_by(currentUserName);// Integer.parseInt(sessionuserid)
								userLogin.setCreated_on(new Date());
								userLogin.setInstituteId(user.getInstituteId());
								userLogin.setAttempt_captcha_count(0);
								userLogin.setCap_locked_date(new Date());
								userLogin.setRole_map(Integer.parseInt(sessionuserid));// currentUserName

								String roleName = request.getSession().getAttribute("role").toString();

								userLogin.setRoleRoType("0");/// TO CHECLDLKF

								userLoginRepository.save(userLogin);
								UserRole urole = new UserRole();//
								Role role = new Role();
								role.setRoleId(user.getUser_role_id());

								urole.setRole_id(role);
								urole.setUserid(userLogin);
								urole.setCreated_on(new Date());
								userRoleRepository.save(urole);

								Optional<Role> rolecheck = roleRepository.findById(role.getRoleId());

								if (rolecheck.get().getRole().equalsIgnoreCase("ADMIN")) {
									TbInstituteDetail tib = new TbInstituteDetail();
									tib.setId(user.getInstituteId());
									Userloginchild userloginchild = new Userloginchild();
									userloginchild.setUserId(userLogin);
									userloginchild.setInstituteId(tib);
									userLoginChildRepository.save(userloginchild);
								}
								jsonobjectout.put("status", "1");
								jsonobjectout.put("message", "Details submitted Successfully");
								returnstring = jsonobjectout.toJSONString();

							} else {
								jsonobjectout.put("status", "0");
								jsonobjectout.put("message", "Embassy Admin Already exists-->"+existingEmbassyusers.get(0).getUserName());
								returnstring = jsonobjectout.toJSONString();

							}
						} else {

							jsonobjectout.put("status", "0");
							jsonobjectout.put("message", "Institute Aadmin Already exists-->"+existingInstituteUsers.get(0).getUserName());
							returnstring = jsonobjectout.toJSONString();

						}
					}

					else {

						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "User name already exists-->"+CheckLoginNameDetailsexist.get(0).getUserName());
						returnstring = jsonobjectout.toJSONString();

					}
				}
			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "PASSWORD AND CONFIRM PASSWORD MUST BE SAME");
				returnstring = jsonobjectout.toJSONString();

			}

		} 
		
		catch (Exception e) {

			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}

		System.out.println("Output3-->" + returnstring);

		return returnstring;
	}

	/* LOAD USER DATA */

	@ResponseBody
	@RequestMapping(value = "/admin/LoadUserData", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadUserData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		List<String> Columns = new ArrayList<String>();

		String username = request.getSession().getAttribute("username").toString();

		Pageable pageable = null;
		int formcounter = 1;
		try {

			int orderId = 0;
			String orderType = "asc";
			if (!order.equalsIgnoreCase("")) {
				String[] orderparts = order.split(",");
				if (orderparts.length > 0) {
					orderId = Integer.parseInt(orderparts[0]); // "1"
				}
				if (orderparts.length > 1) {
					orderType = orderparts[1];
				}
			}

			String sortyby = "userId";

			if (orderId == 0) {
				sortyby = "created_on";
			} else if (orderId == 1) {
				sortyby = "login_name";
			} else if (orderId == 2) {
				sortyby = "userName";
			} else if (orderId == 3) {
				sortyby = "army_no";
			} else if (orderId == 4) {
				sortyby = "lc.instituteId.instituteName";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			Page<UserLogin> user = userLoginRepository.LoadUserData1(search.toLowerCase(), username, pageable);

			int count = (int) user.getPageable().getOffset();
			count = count + 1;
			List<UserLogin> user1 = user.getContent();

			for (int i = 0; i < user1.size(); i++) {

				UserLogin user2 = user1.get(i);

				Userloginchild userloginchild = userLoginChildRepository.findByuseridId(user2.getUserId());
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("srno", count);
				jsonObject2.put("login_name", user2.getLogin_name());
				jsonObject2.put("user_name", user2.getUserName());
				jsonObject2.put("army_no", user2.getArmy_no());
				if (!userloginchild.getInstituteId().equals(-1)) {
					jsonObject2.put("institute_name", userloginchild.getInstituteId().getInstituteName());
				} else {
					jsonObject2.put("institute_name", "");
				}
				String f = "";

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(String.valueOf(user2.getUserId())) + "' /> ";

				if (user2.getEnabled() == 1) {

					String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
							+ "' value='Deactivate' /> ";
					jsonObject2.put("action",
							"<ul class=\"buttons-group\"><input id=\"deactivatebtn\" name=\"deactivatebtn\"\n"
									+ "								class=\"btn btn-secondary actdeactclass\" type=\"button\" value=\"Deactivate\"\n"
									+ "								 /></ul>" + hidden + hidden1);

				} else {
					String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
							+ "' value='Activate' /> ";
					jsonObject2.put("action",
							"<ul class=\"buttons-group\"><input id=\"activatebtn\" name=\"activatebtn\"\n"
									+ "								class=\"btn btn-primary	 btn-hover-success actdeactclass\" type=\"button\" value=\"Activate\"\n"
									+ "								 /></ul>" + hidden + hidden1);
				}

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", user.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	/* ACTIVATE AND DEACTIVATE USER DATA */

	@ResponseBody
	@RequestMapping(value = "/admin/ActivateDeactivateUser", method = RequestMethod.POST, produces = {
			"application/json" })
	public String ActivateDeactivateUser(HttpServletRequest request, @RequestBody String data) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			TB_LDAP_USER_MASTER user = new TB_LDAP_USER_MASTER();

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String modifydate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("userid") != null) {
				String username = request.getSession().getAttribute("username").toString();
				int userid = Integer.parseInt(AESGCM.decrypt(jsonObject.get("userid").toString()));

				String action = jsonObject.get("action").toString();
				UserLogin userLogin = userLoginRepository.GetUserDataByIDForActivateORDeactivate(userid);
				if (userLogin != null) {
					if (action.equalsIgnoreCase("Deactivate")) {
						userLogin.setEnabled(0);
						userLogin.setAc_dc_date(modifydate);
//						userLogin.setAccountnonexpired(1);
//						userLogin.setAccountnonlocked(1);
//						userLogin.setCreated_by(sessionuserid.toString());// Integer.parseInt(sessionuserid)
//						userLogin.setCreated_on(new Date());
						userLoginRepository.save(userLogin);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "User Deactivated Successfully");
						returnstring = jsonobjectout.toJSONString();
					} else {
						userLogin.setEnabled(1);
						userLogin.setAc_dc_date(modifydate);
//						userLogin.setAccountnonexpired(0);
//						userLogin.setAccountnonlocked(0);
//						userLogin.setCreated_by(sessionuserid.toString());// Integer.parseInt(sessionuserid)
//						userLogin.setCreated_on(new Date());
						userLoginRepository.save(userLogin);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "User Activated Successfully");
						returnstring = jsonobjectout.toJSONString();
					}
				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "No Data Found");
					returnstring = jsonobjectout.toJSONString();
				}

			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "No Data Found");
				returnstring = jsonobjectout.toJSONString();
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	/* UPDATE USER DATA */

//	@ResponseBody
//	@RequestMapping(value = "/admin/GetUserUpdate", method = RequestMethod.POST, produces = { "application/json" })
//	public String GetUserUpdate(@RequestBody String data, HttpServletRequest request) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		try {
//
//			System.out.println("Output12-->");
//			// Add Server Side Validation TODO
//			jsonObject = (JSONObject) jsonp.parse(data);
//
//			if (jsonObject.get("id") != null) {
//				System.out.println("Output-->");
//				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//				UserLogin emp1 = new UserLogin();
//				java.util.Optional<UserLogin> emp2 = userLoginRepository.findById(id);
//				if (emp2 != null) {
//					System.out.println("Outpu123t-->" + returnstring);
//					emp1 = emp2.get();
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("login_name", emp1.getLogin_name());
//					jsonobjectout.put("password", emp1.getPassword());
//					jsonobjectout.put("user_name", emp1.getUserName());
//					jsonobjectout.put("army_no", emp1.getArmy_no());
//					jsonobjectout.put("id", emp1.getUserId());
//
//					returnstring = jsonobjectout.toJSONString();
//				} else {
//					jsonobjectout.put("status", "0");
//					jsonobjectout.put("message", "No Data Found");
//					returnstring = jsonobjectout.toJSONString();
//				}
//
//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "No Data Found");
//				returnstring = jsonobjectout.toJSONString();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonobjectout.put("status", "0");
//			jsonobjectout.put("message", "Failure");
//			returnstring = jsonobjectout.toJSONString();
//		}
//		System.out.println("Output-->" + returnstring);
//
//		return returnstring;
//	}

	/* DELETE USER DATA */

//	@ResponseBody
//	@RequestMapping(value = "/admin/DeleteUser", method = RequestMethod.POST, produces = { "application/json" })
//	public String DeleteUser(@RequestBody String data, HttpServletRequest request) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		try {
//			
//			// Add Server Side Validation TODO
//			jsonObject = (JSONObject) jsonp.parse(data);
//			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//
//			if (jsonObject.get("id") != null) {
//
//				Optional<UserLogin> tb_sub_category_dtl = userLoginRepository.findById(id);
//
//				if (tb_sub_category_dtl != null) {
//					UserLogin tb_sub_category_dtl1 = tb_sub_category_dtl.get();
//					tb_sub_category_dtl1.setEnabled(0);
//					/*
//					 * tb_sub_category_dtl1.setModifyBy(null);
//					 * tb_sub_category_dtl1.setModifyDate(new Date());
//					 */
//					userLoginRepository.save(tb_sub_category_dtl1);
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("message", "Data Deactivated Successfully");
//					returnstring = jsonobjectout.toJSONString();
//				} else {
//					jsonobjectout.put("status", "0");
//					jsonobjectout.put("message", "No Data Found");
//					returnstring = jsonobjectout.toJSONString();
//				}
//
//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "No Data Found");
//				returnstring = jsonobjectout.toJSONString();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonobjectout.put("status", "0");
//			jsonobjectout.put("message", "Failure");
//			returnstring = jsonobjectout.toJSONString();
//		}
//		System.out.println("Deleted Output-->" + returnstring);
//
//		return returnstring;
//	}

	//////////////// PASSWORD_PATTERN //////////
	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$#^@&%_.~!*])(?!.*\\s).{8,28})";

	public UserMasterController() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	// TB_LDAP_USER_MASTER pass=new TB_LDAP_USER_MASTER ();
	public boolean validate(final String password) {
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/* Error handler */

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put(fieldName, errorMessage);
			jsonArray.add(jsonObject1);
		});
		jsonObject.put("status", "0");
		jsonObject.put("message", jsonArray.toJSONString());
		return jsonArray.toJSONString();
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

	public static String decryptData(byte[] encryptedData, byte[] iv, byte[] salt, String PassKey) throws Exception {
		String password = PassKey;
		SecretKey key = deriveKey(password, salt);

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

		byte[] decryptedContent = cipher.doFinal(encryptedData);

		return new String(decryptedContent);
	}
}