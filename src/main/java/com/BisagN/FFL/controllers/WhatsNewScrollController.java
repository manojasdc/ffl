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
import java.util.Set;

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

import com.BisagN.FFL.models.TbPictureGallary;
import com.BisagN.FFL.models.TbWhatsNewScroll;
import com.BisagN.FFL.repository.PhotoGallaryRepository;
import com.BisagN.FFL.repository.WhatsNewScrollRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WhatsNewScrollController {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	WhatsNewScrollRepository whatsNewScrollRepository;
	@Autowired
	RoleRepository roleRepository;

//	@RequestMapping(value = "/admin/whats_new_scroll", method = RequestMethod.GET)
//	public ModelAndView whats_new_scroll(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("whats_new_scroll");
//		return model1;
//	}

	@RequestMapping(value = "/admin/whats_new_scroll", method = RequestMethod.GET)
	public ModelAndView whats_new_scroll(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/whats_new_scroll", Integer.parseInt(roleid));
		Integer val1 = val.size();
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
			String rolename = request.getSession().getAttribute("role").toString();
			if (rolename.equalsIgnoreCase("ADMIN")) {
				Mmap.put("dashboardurl", "instituteDashboard");
			}
		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		model.setViewName("whats_new_scroll");
		return model;
	}

	@RequestMapping(value = "/admin/SaveWhatsNewData", method = RequestMethod.POST, produces = { "application/json" })
	public String SaveWhatsNewData(@Valid @RequestParam("whatsnewscroll") String whatsnewscroll,
			HttpServletRequest request) throws IOException, DecoderException, ParseException {

		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();
//		TbWhatsNewScroll tb_journal = mapper.readValue(whatsnewscroll, TbWhatsNewScroll.class);
//		String roleName = request.getSession().getAttribute("role").toString();
//		String returnstring = "";
		String actionType = request.getHeader("X-Action-Type");
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(whatsnewscroll);

		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}
		TbWhatsNewScroll tb_journal = mapper.readValue(jsonNodes1.toString(), TbWhatsNewScroll.class);
		try {
			JSONObject jsonobjectout = new JSONObject();

			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

			Set<ConstraintViolation<TbWhatsNewScroll>> constraintViolations = validator.validate(tb_journal);

			if (constraintViolations != null && !constraintViolations.isEmpty()) {

				for (ConstraintViolation c : constraintViolations) {
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put(c.getPropertyPath(), c.getMessageTemplate());
					jSONArray.add(jsonObject1);

				}
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("status", "0");
				jsonObject.put("message", jSONArray.toJSONString());
				return jsonObject.toJSONString();
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

			if (tb_journal.getId() == null || tb_journal.getId() == 0) {
				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
				tb_journal.setDescription(tb_journal.getDescription());

				tb_journal.setStatus('1');
				tb_journal.setCreatedBy(Integer.parseInt(sessionuserid));
				if (roleName.equalsIgnoreCase("USER")) {
					tb_journal.setInstituteMap(userLogin.get().getRole_map());
				} else {
					tb_journal.setInstituteMap(Integer.parseInt(sessionuserid));
				}
				whatsNewScrollRepository.save(tb_journal);

				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "What's new scroll Submitted Successfully");
				returnstring = jsonobjectout.toJSONString();
			} else {

				Optional<TbWhatsNewScroll> journal1 = whatsNewScrollRepository.findById(tb_journal.getId());
				if (journal1 != null) {

					TbWhatsNewScroll obj2 = journal1.get();

					if (obj2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
//					TbWhatsNewScroll obj2 = journal1.get();
						tb_journal.setStatus(obj2.getStatus());
						tb_journal.setDescription(tb_journal.getDescription());
						tb_journal.setCreatedBy(obj2.getCreatedBy());
						tb_journal.setInstituteMap(obj2.getInstituteMap());
						whatsNewScrollRepository.save(tb_journal);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Whats new scroll updated Successfully");
						returnstring = jsonobjectout.toJSONString();

					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Unauthorized Access");
						returnstring = jsonobjectout.toJSONString();
					}

				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select The Id For Update");
					returnstring = jsonobjectout.toJSONString();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jsonobjectout = new JSONObject();
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadwhatsnewscrollData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadwhatsnewscrollData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		List<String> Columns = new ArrayList<String>();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
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

			String sortyby = "id";

			if (orderId == 1) {
				sortyby = "description";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			Page<TbWhatsNewScroll> tb_whats_new3;

			tb_whats_new3 = whatsNewScrollRepository.LoadWhatsNewScrollData1(Integer.parseInt(sessionuserid), search,
					pageable);

			int count = (int) tb_whats_new3.getPageable().getOffset();
			count = count + 1;
			List<TbWhatsNewScroll> tb_whats_new4 = tb_whats_new3.getContent();

			File file = null;
			for (int i = 0; i < tb_whats_new4.size(); i++) {

				TbWhatsNewScroll tb_whats_new = tb_whats_new4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("description", tb_whats_new.getDescription());
//				jsonObject2.put("rejectedRemarks", tb_whats_new.getRejectedRemarks());
//				jsonObject2.put("mapid", tbHallOfFame.getId());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_whats_new.getId() + "") + "' /> ";

//				String action = "<a href=\"#\" ><i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
//						+ " <a href=\"#\" ><i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i></a>" + hidden1;

				String action = "<ul class=\"list-inline custom-btn-group\">"
						+ "			<li class=\"list-inline-item\">"
						+ "				<a href=\"#\" class=\"btn btn-primary icon-btn btnedit\" title=\"Edit\">"
						+ "					<i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "			<li class=\"list-inline-item\">"
						+ " 			<a href=\"#\" class=\"btn btn-warning icon-btn btndelete\">"
						+ "					<i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "		</ul>" + hidden1;

				jsonObject2.put("action", action);

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tb_whats_new3.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/DeletewhatsnewscrollData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeletewhatsnewscrollData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		try {

			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
				Optional<TbWhatsNewScroll> obj = whatsNewScrollRepository.findById(id);

				if (obj != null) {
					TbWhatsNewScroll obj2 = obj.get();

					if (obj2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
//					TbWhatsNewScroll obj2 = obj.get();
					obj2.setStatus('0');
					whatsNewScrollRepository.delete(obj2);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Data Deleted Successfully");
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

////
	@ResponseBody
	@RequestMapping(value = "/admin/GetwhatsnewscrollDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetwhatsnewscrollDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();

		String returnstring = "";
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		try {
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));

				TbWhatsNewScroll alumniEjournal = new TbWhatsNewScroll();
				Optional<TbWhatsNewScroll> alumni = whatsNewScrollRepository.findById(id);
				if (alumni != null) {
					
					alumniEjournal = alumni.get();

					if (alumniEjournal.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					alumniEjournal = alumni.get();
					jsonobjectout.put("status", "1");
					jsonobjectout.put("description", alumniEjournal.getDescription());
					jsonobjectout.put("docid", AESGCM.encrypt(alumniEjournal.getId() + ""));
					jsonobjectout.put("id", AESGCM.encrypt(alumniEjournal.getId() + ""));
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

}