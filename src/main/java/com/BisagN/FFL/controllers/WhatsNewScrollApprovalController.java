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
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.TbWhatsNewScroll;
import com.BisagN.FFL.repository.ActivityApprovalRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.EjournalApprovalRepository;
import com.BisagN.FFL.repository.HallOfFameRepository;
import com.BisagN.FFL.repository.HallofFameApprovalRepository;
import com.BisagN.FFL.repository.WhatsNewScrollRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;

@RestController
public class WhatsNewScrollApprovalController {

	@Autowired
	WhatsNewScrollRepository whatsNewScrollRepository;

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	RoleRepository roleRepository;

//	@RequestMapping(value = "/admin/whatsNewScrollApproval", method = RequestMethod.GET)
//	public ModelAndView whatsNewScrollApproval() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("whatsNewScrollApproval");
//		return model;
//	}
	@RequestMapping(value = "/admin/whatsNewScrollApproval", method = RequestMethod.GET)
	public ModelAndView whatsNewScrollApproval(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/whatsNewScrollApproval", Integer.parseInt(roleid));
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
		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		model.setViewName("whatsNewScrollApproval");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadWhatsNewpprovalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadWhatsNewpprovalData(HttpServletRequest request, @RequestParam int pageno,
			@RequestParam int length, String search, String order) {

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

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

			Page<TbWhatsNewScroll>  tb_activity = whatsNewScrollRepository.LoadWhatsNewScrollApprovalData(Integer.parseInt(sessionuserid),search,
					pageable);

			int count = (int) tb_activity.getPageable().getOffset();
			count = count + 1;
			List<TbWhatsNewScroll> miscactivity = tb_activity.getContent();

			File file = null;
			for (int i = 0; i < miscactivity.size(); i++) {

				TbWhatsNewScroll tb_misc = miscactivity.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", "<span class='avtar avatar-blue'>" + count + "</span>");
				jsonObject2.put("description", tb_misc.getDescription());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_misc.getId() + "") + "' /> ";


				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tb_misc.getId())).getBytes()) + "' /> ";

				jsonObject2.put("action", "<ul class=\"list-inline custom-btn-group\">\n"
						+ "    <li class=\"list-inline-item\">\n"
						+ "        <button type=\"button\" class=\"btn btnapprove approvecls1\"  data-bs-target=\"#staticBackdrop2\" title=\"Accept\">\n"
						+ "            <i class=\"fas fa-check\"></i>\n" + "        </button>\n" + "    </li>\n"
						+ "<li class=\"list-inline-item\"><button type=\"button\" class=\"btn btnreject fc-daygrid-event-harness rejectcls\"  data-bs-target=\"#staticBackdrop2\" title=\"Reject\">\n"
						+ "            <i class=\"fas fa-times\"></i>\n" + "        </button>\n" + "    </li>\n"
						+ "</ul>"+hidden);

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
	
	@ResponseBody
	@RequestMapping(value = "/admin/acceptApprovalforNewScroll", method = RequestMethod.POST, produces = { "application/json" })
	public String acceptApprovalforNewScroll(@RequestBody String data, HttpServletRequest request,
			TbWhatsNewScroll TbMiscActivity) {
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

				Optional<TbWhatsNewScroll> tb_miscactivity = whatsNewScrollRepository.findById(id);

				if (tb_miscactivity != null) {
					TbWhatsNewScroll miscActivity = tb_miscactivity.get();

					String roleName = request.getSession().getAttribute("role").toString();

					miscActivity.setApprovalStatus("Approved");

					whatsNewScrollRepository.save(miscActivity);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", " Approved Successfully");
					returnstring = jsonobjectout.toJSONString();

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
	@RequestMapping(value = "/admin/RejectApprovalforNewScroll", method = RequestMethod.POST, produces = { "application/json" })
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

				Optional<TbWhatsNewScroll> miscActivity = whatsNewScrollRepository.findById(id);

				if (miscActivity != null) {
					TbWhatsNewScroll tbMiscActivity = miscActivity.get();
					String remarks = jsonObject.get("rejectedRemarks").toString();
					tbMiscActivity.setApprovalStatus("Rejected");
					tbMiscActivity.setRejectedRemarks(remarks);

					whatsNewScrollRepository.save(tbMiscActivity);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Rejected Successfully");
					returnstring = jsonobjectout.toJSONString();

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