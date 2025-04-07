package com.BisagN.FFL.controllers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.ActivityApprovalRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.EjournalApprovalRepository;
import com.BisagN.FFL.repository.HallOfFameRepository;
import com.BisagN.FFL.repository.HallofFameApprovalRepository;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.RegistrationRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;

@RestController
public class ActivityApprovalController {

	@Autowired
	ActivityApprovalRepository ActivityApprovalRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	NotificationController notificationController;

	@Autowired
	UserLoginChildRepository userLoginChildRepository;

	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	InstituteRepository instituteRepository;
	
	public ImageValidationController imageValidationController = new ImageValidationController();

	private String pathforactivity;

	@Value("${pathforActivity}")
	public void pathforactivity(String pathforactivity) {
		this.pathforactivity = pathforactivity;
	}

//	@RequestMapping(value = "/admin/blogapproval", method = RequestMethod.GET)
//	public ModelAndView blogapproval(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("activityapproval");
//		return model1;
//	}

	@RequestMapping(value = "/admin/blogapproval", method = RequestMethod.GET)
	public ModelAndView blogapproval(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/blogapproval", Integer.parseInt(roleid));
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

		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		model.setViewName("activityapproval");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadActivityApprovalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadActivityApprovalData(HttpServletRequest request, @RequestParam int pageno,
			@RequestParam int length, String search, String order,
			@RequestParam(value = "category", required = false) String category) {

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
			String orderType = "desc";
			if (!order.equalsIgnoreCase("")) {
				String[] orderparts = order.split(",");
				orderId = Integer.parseInt(orderparts[0]); // "1"
				orderType = orderparts[1]; // "desc"
			}

			String sortyby = "createdBy";

			if (orderId == 0) {
				sortyby = "createdBy";
			}

			else if (orderId == 1) {
				sortyby = "miscTitle";
			}

			else if (orderId == 2) {
				sortyby = "miscDescription";
			}

//			else if (orderId == 3) {
//				sortyby = "year";
//			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			Page<TbMiscActivity> tb_activity = ActivityApprovalRepository
					.LoadActivityApprovalData(Integer.parseInt(sessionuserid),category, search, pageable);

			int count = (int) tb_activity.getPageable().getOffset();
			count = count + 1;
			List<TbMiscActivity> miscactivity = tb_activity.getContent();
			File file = null;
			for (int i = 0; i < miscactivity.size(); i++) {

				TbMiscActivity tb_misc = miscactivity.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("username", tb_misc.getUserid());
				jsonObject2.put("title", tb_misc.getMiscTitle());
				jsonObject2.put("description", tb_misc.getMiscDescription());
//				sjsonObject2.put("year", tb_misc.getYear());
				jsonObject2.put("year", "");
				if(tb_misc.getUserid() != null) {
					
					
					
					TbRegistrationDetail tbRegistrationDetail = registrationRepository.FindDataByUserId(Integer.parseInt(tb_misc.getUserid()));
					if(tbRegistrationDetail != null) {
						jsonObject2.put("username", tbRegistrationDetail.getAlumniName());
						jsonObject2.put("country", tbRegistrationDetail.getCountryId().getCountryName());	
					}else {
						String insname = instituteRepository.FindInsName(tb_misc.getInstituteMap());
						jsonObject2.put("username", insname);
						jsonObject2.put("country", "");
					}
					}else {
						String insname = instituteRepository.FindInsName(tb_misc.getInstituteMap());
						jsonObject2.put("username", insname);
						jsonObject2.put("country", "");
					}	
				
				
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_misc.getId() + "") + "' /> ";

//				jsonObject2.put("ShowImage",
//						"<a href=\"#\" class=\"btn btn-secondary document_status\">View</a> &nbsp" + hidden1);

				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tb_misc.getId())).getBytes()) + "' /> ";

				jsonObject2.put("action", "<ul class=\"list-inline custom-btn-group\">\n"
						+ "    <li class=\"list-inline-item\">\n"
						+ "        <button type=\"button\" class=\"btn icon-btn btnappr approvecls1\"title=\"Accept\">\n"
						+ "            <i class=\"ri-user-follow-fill\"></i>\n" + "        </button>\n" + "    </li>\n"
						+ "<li class=\"list-inline-item\"><button type=\"button\" class=\"btn icon-btn btnreje rejectcls\" title=\"Reject\">\n"
						+ "            <i class=\"ri-user-unfollow-fill\"></i>\n" + "        </button>\n"
						+ "    </li>\n" + "</ul>" + hidden);

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tb_activity.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

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

	@RequestMapping(value = "/admin/Getimageforactivity", method = RequestMethod.POST, produces = {
			"application/json" })
	public String Getimageforactivity(@RequestBody String data, HttpServletRequest request)
			throws ParseException, IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		//
//			List<String> Columns = new ArrayList<String>();
		//
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);

			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
			if (id != 0) {

				Optional<TbMiscActivity> tb_activity = ActivityApprovalRepository.findById(id);

				TbMiscActivity tb_activity2 = tb_activity.get();

				if (tb_activity2.getMiscPhoto() != null) {

					String path = tb_activity2.getMiscPhoto();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_activity2.getMiscPhoto());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_activity2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_activity2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(tb_activity2.getMiscPhoto());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_activity2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_activity2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", tb_activity2.getId());
						jsonObject2.put("DocumentImageType", docType);

						jsonObject2.put("document", "");
					}

					jsonobjectout.put("status", "1");
					jsonobjectout.put("data", jsonObject2);
					jsonobjectout.put("message", "Data Load Successfully");
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
	@RequestMapping(value = "/admin/Acceptapprovalforactivity", method = RequestMethod.POST, produces = {
			"application/json" })
	public String Acceptapprovalforactivity(@RequestBody String data, HttpServletRequest request,
			TbMiscActivity TbMiscActivity) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {
				int id = Integer
						.parseInt(AESGCM.decrypt(new String(Base64Service.decode(jsonObject.get("id").toString()))));

				Optional<TbMiscActivity> tb_miscactivity = ActivityApprovalRepository.findById(id);

				if (tb_miscactivity != null) {
					TbMiscActivity miscActivity = tb_miscactivity.get();
					if (miscActivity.getInstituteMap().equals(Integer.parseInt(sessionuserid))) {
						String roleName = request.getSession().getAttribute("role").toString();

						miscActivity.setApprovalStatus("Approved");

						ActivityApprovalRepository.save(miscActivity);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", " Approved Successfully");
						returnstring = jsonobjectout.toJSONString();

						Userloginchild userloginchild = userLoginChildRepository
								.findByuseridId(miscActivity.getInstituteMap());

						Optional<UserLogin> user = userLoginRepository.findById(miscActivity.getCreatedBy());
						notificationController.SaveNotification("Blog Approved For " + user.get().getUserName(),
								Integer.parseInt(sessionuserid), miscActivity.getCreatedBy(),
								Integer.parseInt(sessionuserid));
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
	@RequestMapping(value = "/admin/RejectApprovalforactivity", method = RequestMethod.POST, produces = {
			"application/json" })
	public String RejectApprovalforactivity(@RequestBody String data, HttpServletRequest request) {

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
				Integer id = Integer
						.parseInt(AESGCM.decrypt(new String(Base64Service.decode(jsonObject.get("id").toString()))));

				Optional<TbMiscActivity> miscActivity = ActivityApprovalRepository.findById(id);

				if (miscActivity != null) {
					TbMiscActivity tbMiscActivity = miscActivity.get();

					if (tbMiscActivity.getInstituteMap().equals(Integer.parseInt(sessionuserid))) {
						String remarks = jsonObject.get("rejectedRemarks").toString();
						tbMiscActivity.setApprovalStatus("Rejected");
						tbMiscActivity.setRejectedRemarks(remarks);

						ActivityApprovalRepository.save(tbMiscActivity);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Rejected Successfully");
						returnstring = jsonobjectout.toJSONString();

						Userloginchild userloginchild = userLoginChildRepository
								.findByuseridId(tbMiscActivity.getInstituteMap());
						Optional<UserLogin> user = userLoginRepository.findById(tbMiscActivity.getCreatedBy());
						notificationController.SaveNotification("Blog Rejected For " + user.get().getUserName(),
								Integer.parseInt(sessionuserid), tbMiscActivity.getCreatedBy(),
								Integer.parseInt(sessionuserid));

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