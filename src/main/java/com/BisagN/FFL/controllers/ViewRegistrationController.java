package com.BisagN.FFL.controllers;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.TbRegistrationDetailChild;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.RegistrationChildRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.FFL.repository.ViewRegistrationRepository;
import com.BisagN.controller.AES;
import com.BisagN.controller.AesGcmEncryption;
import com.BisagN.models.Logininformation;
import com.BisagN.models.Role;
import com.BisagN.models.UserLogin;
import com.BisagN.models.UserRole;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.repository.UserRoleRepository;
import com.BisagN.util.Base64Service;
import com.BisagN.controller.AESGCM;

@RestController
public class ViewRegistrationController {

	@Autowired
	ViewRegistrationRepository viewRegistrationRepository;

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserLoginChildRepository userloginchildRepositroy;

	@Autowired
	RegistrationChildRepository registrationChildRepository;

	public static String GeneratedKey;
	public static String GeneratedIV;
	public static String GeneratedSalt;
	public static String Generatedpassword;

//	@RequestMapping(value = "/admin/view_registration", method = RequestMethod.GET)
//	public ModelAndView view_registration(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("view_registration");
//		return model1;
//	}

	@RequestMapping(value = "/admin/view_registration", method = RequestMethod.GET)
	public ModelAndView view_registration(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1)
			throws Exception {
		ModelAndView model = new ModelAndView();

		AesGcmEncryption aesgcm1 = new AesGcmEncryption();
		GeneratedKey = aesgcm1.getEncodedKey();
		GeneratedIV = aesgcm1.getEncodedIV();
		GeneratedSalt = aesgcm1.getEncodedSalt();
		Generatedpassword = aesgcm1.getEncodedPassword();
		model1.addAttribute("GeneratedKey", GeneratedKey);
		model1.addAttribute("GeneratedIV", GeneratedIV);
		model1.addAttribute("GeneratedSalt", GeneratedSalt);
		model1.addAttribute("Generatedpassword", Generatedpassword);

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/view_registration", Integer.parseInt(roleid));
		Integer val1 = val.size();

		String rolename = request.getSession().getAttribute("role").toString();
		if (rolename.equalsIgnoreCase("ADMIN")) {
			Mmap.put("dashboardurl", "instituteDashboard");
		}

//		val1 = true;
		String msg = null;
		try {
			if (val1 == 0) {
				model1.addAttribute("errorMessage", "You are not authorized to access this Page!!!!");
				return new ModelAndView("loginError");
			} else {
			}
			if (request.getHeader("Referer") == null) {
				msg = "";
			}
			if (rolename.equalsIgnoreCase("ADMIN")) {
				Mmap.put("dashboardurl", "instituteDashboard");
			}
		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		model.setViewName("view_registration");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadRegistrationData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadRegistrationData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		List<String> Columns = new ArrayList<String>();
		Pageable pageable = null;
		int formcounter = 1;

		try {

			int orderId = 0;
			String orderType = "asc";
			if (!order.equalsIgnoreCase("")) {
				String[] orderparts = order.split(",");
				orderId = Integer.parseInt(orderparts[0]); // "1"
				orderType = orderparts[1]; // "desc"
			}

			String sortyby = "id";

			if (orderId == 1) {
				sortyby = "alumniName";
			} else if (orderId == 2) {
				sortyby = "emailId";
			} else if (orderId == 3) {
				sortyby = "contactNumber";
			} else if (orderId == 4) {
				sortyby = "rc.passoutYear";
			} else if (orderId == 5) {
				sortyby = "rc.rollNumber";
			} else if (orderId == 6) {
				sortyby = "i.instituteName";
			} else if (orderId == 7) {
				sortyby = "countryId.countryName";
			} else if (orderId == 8) {
				sortyby = "rc.registrationStatus";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			// Add Server Side Validation TODO

			String roleName = request.getSession().getAttribute("role").toString();
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			Integer id = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(id);
			Userloginchild userloginchild = userloginchildRepositroy.findByuseridId(userLogin.get().getUserId());

			String username = userLogin.get().getUserName();

			Page<TbRegistrationDetail> tbRegistrationDetail = viewRegistrationRepository.loadRegistrationData(id,
					search.toLowerCase(), pageable);

			int count = (int) tbRegistrationDetail.getPageable().getOffset();
			count = count + 1;
			List<TbRegistrationDetail> tbRegistrationDetail1 = tbRegistrationDetail.getContent();

			// AesGcmEncryption aesGcmEncryption2 = new AesGcmEncryption();

			String iv = ViewRegistrationController.GeneratedIV;
			String salt = ViewRegistrationController.GeneratedSalt;
			String key = ViewRegistrationController.GeneratedKey;
			String password = ViewRegistrationController.Generatedpassword;
			AesGcmEncryption aesgcm1 = new AesGcmEncryption(key, iv, salt, password);

			for (int i = 0; i < tbRegistrationDetail1.size(); i++) {

				TbRegistrationDetail tbRegistrationDetails = tbRegistrationDetail1.get(i);
				Optional<TbRegistrationDetailChild> child1 = Optional
						.ofNullable(registrationChildRepository.findbyregistrationchild(tbRegistrationDetails.getId(),
								userloginchild.getInstituteId().getId()));

				if (child1.isPresent()) {
					TbRegistrationDetailChild child = child1.get();
				} else {
					System.out.println("No data found for registration child");
				}

				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("srno", count);
				jsonObject2.put("alumniName", tbRegistrationDetails.getAlumniName());

				/////////////////////

				String EmailID = tbRegistrationDetails.getEmailId();
				String ContactNo = tbRegistrationDetails.getContactNumber();
				String rollNumber = child1.get().getRollNumber().toString();
				// System.out.println("Date " + new Date());

				String encryptedemail = aesgcm1.encryptData2(EmailID);
				String encryptedcontatcno = aesgcm1.encryptData2(ContactNo);
				String encryptedRollNo = aesgcm1.encryptData2(rollNumber);
//				System.out.println("Date Compeletd" + new Date());
//				System.out.println("Date " + new Date());
//				System.err.println("Encrypted Data " + encryptedemail);
				JSONObject obj1 = (JSONObject) jsonp.parse(encryptedemail);
				jsonObject2.put("EmailID", obj1.get("Ciphertext"));
				jsonObject2.put("EmailIDAuth", obj1.get("AuthTag"));
				obj1 = (JSONObject) jsonp.parse(encryptedcontatcno);
				jsonObject2.put("ContactNo", obj1.get("Ciphertext"));
				jsonObject2.put("ContactNoAuth", obj1.get("AuthTag"));
				obj1 = (JSONObject) jsonp.parse(encryptedRollNo);
				jsonObject2.put("rollNumber", obj1.get("Ciphertext"));
				jsonObject2.put("rollNumberAuth", obj1.get("AuthTag"));
				// System.out.println("Date Compeletd" + new Date());
				//////////////////
//				jsonObject2.put("EmailID", tbRegistrationDetails.getEmailId());
//				jsonObject2.put("ContactNo", tbRegistrationDetails.getContactNumber());

				jsonObject2.put("passoutYear", child1.get().getPassoutYear().toString());

//				jsonObject2.put("rollNumber", child1.get().getRollNumber().toString());
				jsonObject2.put("instituteName", userloginchild.getInstituteId().getInstituteName());
				jsonObject2.put("country", tbRegistrationDetails.getCountryId().getCountryName());
				jsonObject2.put("registrationStatus", child1.get().getRegistrationStatus());

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(tbRegistrationDetails.getId() + "") + "' /> ";
//				jsonObject2.put("action",
//						"<a href=\"#\" title=\"Approve\"><i class=\"las la-check-circle la-2x approve_alumni\" aria-hidden=\"true\" ></i></a> &nbsp;&nbsp"
//								+ "<a href=\"#\" title=\"Reject\"><i class=\"las la-times-circle la-2x reject_alumni\" aria-hidden=\"true\" ></i></a>"
//								+ hidden);

				jsonObject2.put("action", "<ul class=\"list-inline custom-btn-group\">\n"
						+ "    <li class=\"list-inline-item\">\n"
						+ "        <button type=\"button\" class=\"btn icon-btn btnappr approve_alumni\"title=\"Approve\">\n"
						+ "            <i class=\"ri-user-follow-fill\"></i>\n" + "        </button>\n" + "    </li>\n"
						+ "<li class=\"list-inline-item\"><button type=\"button\" class=\"btn icon-btn btnreje reject_alumni\" title=\"Reject\">\n"
						+ "            <i class=\"ri-user-unfollow-fill\"></i>\n" + "        </button>\n"
						+ "    </li>\n" + "</ul>" + hidden);

				jsonArray1.add(jsonObject2);
				formcounter++;
				count++;

			}

			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tbRegistrationDetail.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		}

		catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;

	}

//	@ResponseBody
//	@RequestMapping(value = "/admin/ApproveAlumni", method = RequestMethod.POST, produces = { "application/json" })
//	public String ApproveAlumni(@RequestBody String data, HttpServletRequest request,
//			TbRegistrationDetail registrationDetail) {
//
//		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//		String username = request.getSession().getAttribute("username").toString();
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		try {
//			// Add Server Side Validation TODO
//			jsonObject = (JSONObject) jsonp.parse(data);
//
//			if (jsonObject.get("id") != null) {
//
//				int id = Integer.parseInt(AESGCM.decrypt(new String(jsonObject.get("id").toString())));
//
//				java.util.Optional<TbRegistrationDetail> registrationmst = viewRegistrationRepository.findById(id);
//
//				if (registrationmst != null) {
//
//					TbRegistrationDetail registrationmst2 = registrationmst.get();
//					UserLogin abcd = userLoginRepository.findByRoleId(Integer.parseInt(sessionuserid));
//
////					registrationmst2.setRegistrationStatus("Accepted");
////					viewRegistrationRepository.save(registrationmst2);
//					System.err.println("Hii"+registrationmst2.getId()+"Hii3"+Integer.parseInt(sessionuserid));
//					TbRegistrationDetailChild registrationchildmst = registrationChildRepository.findbyregistrationchild(registrationmst2.getId(),abcd.getInstituteId());
//
//					registrationchildmst.setRegistrationStatus("Accepted");
//					registrationChildRepository.save(registrationchildmst);
//
////					SAVE IN USER LOGIN
//					String alumni_name = registrationmst2.getEmailId();
//					BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//					String hashedPassword = passwordEncoder.encode("123Bisag#");
//					String roll_number = registrationchildmst.getRollNumber();
//
//					UserLogin userLogin = new UserLogin();
//					userLogin.setUserName(alumni_name);
//					userLogin.setPassword(hashedPassword);
//					userLogin.setEnabled(1);
//					userLogin.setAccountnonexpired(1);
//					userLogin.setAccountnonlocked(1);
//					userLogin.setCredentialsnonexpired(1);
//					userLogin.setLogin_name(alumni_name);
//					userLogin.setCreated_on(new Date());
//					userLogin.setAc_dc_date(new Date().toString());
//					userLogin.setArmy_no(roll_number);
//					userLogin.setCreated_by(username);
//					userLogin.setRole_map(Integer.parseInt(sessionuserid));
//					userLogin.setInstituteId(Integer.parseInt(sessionuserid));
//					userLogin.setRoleRoType("0");
//					userLoginRepository.save(userLogin);
//
//					UserLogin abc = userLoginRepository.findByRoleId(Integer.parseInt(sessionuserid));
//					TbInstituteDetail tib = new TbInstituteDetail();
//					tib.setId(abc.getInstituteId());
//					Userloginchild userloginchild = new Userloginchild();
//					userloginchild.setUserId(userLogin);
//					userloginchild.setInstituteId(tib);
//					userloginchildRepositroy.save(userloginchild);
//
////					SAVE IN USERROLE INFORMATION
//					Integer role_id = roleRepository.getroleid();
//					Optional<Role> role = roleRepository.findById(role_id);
//
//					UserRole userRole = new UserRole();
//					userRole.setUserid(userLogin);
//					userRole.setRole_id(role.get());
//					userRole.setCreated_on(new Date());
//					userRoleRepository.save(userRole);
//
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("message", " Accepted Successfully");
//					returnstring = jsonobjectout.toJSONString();
//
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
//
//		return returnstring;
//	}

	@ResponseBody
	@RequestMapping(value = "/admin/ApproveAlumni", method = RequestMethod.POST, produces = { "application/json" })
	public String ApproveAlumni(@RequestBody String data, HttpServletRequest request,
			TbRegistrationDetail registrationDetail) {

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String username = request.getSession().getAttribute("username").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(new String(jsonObject.get("id").toString())));

				java.util.Optional<TbRegistrationDetail> registrationmst = viewRegistrationRepository.findById(id);

				if (registrationmst != null) {

					TbRegistrationDetail registrationmst2 = registrationmst.get();
					Userloginchild userloginchid = userloginchildRepositroy
							.findByuseridId(Integer.parseInt(sessionuserid));
					TbRegistrationDetailChild registrationchildmst = registrationChildRepository
							.findbyregistrationchild(registrationmst2.getId(), userloginchid.getInstituteId().getId());
					if (registrationchildmst.getInstituteId().getId().equals(userloginchid.getInstituteId().getId())) {
						registrationchildmst.setRegistrationStatus("Accepted");
						registrationChildRepository.save(registrationchildmst);

						// SAVE IN USER LOGIN
						String alumni_name = registrationmst2.getAlumniName();
						BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
						String hashedPassword = registrationmst2.getPassworddd();
						String roll_number = registrationchildmst.getRollNumber();
						List<UserLogin> existingUserLogins = userLoginRepository
								.CheckLoginNameDetailsexist1(alumni_name);

						if (existingUserLogins.size() == 0) {
							// Create new user login
							UserLogin userLogin = new UserLogin();
							userLogin.setUserName(registrationmst2.getUserName());
							userLogin.setPassword(hashedPassword);
							userLogin.setEnabled(1);
							userLogin.setAccountnonexpired(1);
							userLogin.setAccountnonlocked(1);
							userLogin.setCredentialsnonexpired(1);
							userLogin.setLogin_name(alumni_name);
							userLogin.setCreated_on(new Date());
							userLogin.setAc_dc_date(new Date().toString());
							userLogin.setArmy_no(roll_number);
							userLogin.setCreated_by(username);
							userLogin.setRole_map(Integer.parseInt(sessionuserid));
							userLogin.setInstituteId(Integer.parseInt(sessionuserid));
							userLogin.setRoleRoType("0");
							userLogin.setAttempt_captcha_count(0);
							userLogin.setCap_locked_date(new Date());
							userLoginRepository.save(userLogin);

							UserLogin abc = userLoginRepository.findByRoleId(Integer.parseInt(sessionuserid));
							TbInstituteDetail tib = new TbInstituteDetail();
							tib.setId(abc.getInstituteId());
							Userloginchild userloginchild = new Userloginchild();
							userloginchild.setUserId(userLogin);
							userloginchild.setInstituteId(tib);
							userloginchildRepositroy.save(userloginchild);

							// SAVE IN USERROLE INFORMATION
							Integer role_id = roleRepository.getroleid();
							Optional<Role> role = roleRepository.findById(role_id);

							UserRole userRole = new UserRole();
							userRole.setUserid(userLogin);
							userRole.setRole_id(role.get());
							userRole.setCreated_on(new Date());
							userRoleRepository.save(userRole);
							
							registrationmst2.setUserid(userLogin.getUserId());
							viewRegistrationRepository.save(registrationmst2);
							
						} else {
							UserLogin abc = userLoginRepository.findByRoleId(Integer.parseInt(sessionuserid));
							Optional<UserLogin> existinguserid = userLoginRepository
									.findById(existingUserLogins.get(0).getUserId());
							TbInstituteDetail tib = new TbInstituteDetail();
							tib.setId(abc.getInstituteId());
							Userloginchild userloginchild = new Userloginchild();
							userloginchild.setUserId(existinguserid.get());
							userloginchild.setInstituteId(tib);
							userloginchildRepositroy.save(userloginchild);
						}

						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", " Approved Successfully");
						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Unauthorized Access");
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


	@ResponseBody
	@RequestMapping(value = "/admin/RejectAlumni", method = RequestMethod.POST, produces = { "application/json" })
	public String RejectAlumni(@RequestBody String data, HttpServletRequest request) {

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(new String(jsonObject.get("id").toString())));
				java.util.Optional<TbRegistrationDetail> registrationmst = viewRegistrationRepository.findById(id);

				if (registrationmst != null) {
					TbRegistrationDetail registrationmst2 = registrationmst.get();

					Userloginchild userloginchid = userloginchildRepositroy
							.findByuseridId(Integer.parseInt(sessionuserid));
					TbRegistrationDetailChild registrationchildmst = registrationChildRepository
							.findbyregistrationchild(registrationmst2.getId(), userloginchid.getInstituteId().getId());
					if (registrationchildmst.getInstituteId().getId().equals(userloginchid.getInstituteId().getId())) {
						registrationchildmst.setRegistrationStatus("Rejected");
						registrationChildRepository.save(registrationchildmst);

						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Rejected Successfully");
						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Unauthorized Access");
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

}