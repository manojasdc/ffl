package com.BisagN.FFL.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;

import com.BisagN.FFL.models.TbNewsLetter;
import com.BisagN.FFL.repository.newsLetterRepository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.BisagN.util.Base64Service;
import com.BisagN.controller.AESGCM;
import com.BisagN.repository.RoleRepository;

import org.json.simple.parser.ParseException;
import java.util.Base64;

@RestController
public class newsLetterApprovalController {
	
	@Autowired newsLetterRepository newsLetterRepository;
	@Autowired
	RoleRepository roleRepository;

//	@RequestMapping(value = "/admin/newsLetterApproval", method = RequestMethod.GET)
//	public ModelAndView newsLetter() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("newsLetterApproval");
//		return model;
//	}
	
	@RequestMapping(value = "/admin/newsLetterApproval", method = RequestMethod.GET)
	public ModelAndView newsLetterApproval(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/newsLetterApproval", Integer.parseInt(roleid));
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
		model.setViewName("newsLetterApproval");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/LoadNewsLetterApprovalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadNewsLetterApprovalData(HttpServletRequest request, @RequestParam int pageno,
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

			if (orderId == 0) {
				sortyby = "id";
			} else if (orderId == 1) {
				sortyby = "description";
			} else if (orderId == 2) {
				sortyby = "newsLetterName";
			}
			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

			Page<TbNewsLetter> tb_dtl3 = newsLetterRepository.LoadNewsLetterApprovalData(Integer.parseInt(sessionuserid),search,
					pageable);

			int count = (int) tb_dtl3.getPageable().getOffset();
			count = count + 1;
			List<TbNewsLetter> tb_dtl4 = tb_dtl3.getContent();

			File file = null;
			for (int i = 0; i < tb_dtl4.size(); i++) {

				TbNewsLetter tb_detail = tb_dtl4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", "<span class='avtar avatar-blue'>" + count + "</span>");
				jsonObject2.put("name",  tb_detail.getNewsLetterName());
				jsonObject2.put("description",  tb_detail.getDescription());
				jsonObject2.put("mapid", tb_detail.getId());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt( tb_detail.getId() + "") + "' /> ";

				jsonObject2.put("ShowImage",
						"<a href=\"#\" class=\"btn btn-danger document_status\">View</a> &nbsp" + hidden1);

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ Base64Service.encode(AESGCM.encrypt(String.valueOf( tb_detail.getId())).getBytes()) + "' /> ";

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
			jsonobjectout.put("TotalCount", tb_dtl3.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@RequestMapping(value = "/admin/pdfNewsLetter", method = RequestMethod.POST, produces = { "application/json" })
	public String pdfNewsLetter(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);
			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
			if (id != 0) {

				Optional<TbNewsLetter> tb_dtl1 = newsLetterRepository.findById(id);

				TbNewsLetter tb_dtl2 = tb_dtl1.get();

				if (tb_dtl2.getUploadPdf() != null) {

					String path = tb_dtl2.getUploadPdf();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_dtl2.getUploadPdf());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_dtl2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_dtl2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(tb_dtl2.getUploadPdf());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_dtl2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_dtl2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", tb_dtl2.getId());
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
	@RequestMapping(value = "/admin/acceptNewsLetter", method = RequestMethod.POST, produces = { "application/json" })
	public String acceptNewsLetter(@RequestBody String data, HttpServletRequest request,
			TbNewsLetter tbnewsLetter) {
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

				java.util.Optional<TbNewsLetter > edtl = newsLetterRepository.findById(id);

				if (edtl != null) {
					TbNewsLetter  alumniEjournal = edtl.get();

					String roleName = request.getSession().getAttribute("role").toString();

					alumniEjournal.setApprovalStatus("Approved");

					newsLetterRepository.save(alumniEjournal);
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
	@RequestMapping(value = "/admin/rejectNewsLetter", method = RequestMethod.POST, produces = { "application/json" })
	public String rejectNewsLetter(@RequestBody String data, HttpServletRequest request) {

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

				java.util.Optional<TbNewsLetter> enews = newsLetterRepository.findById(id);

				if (enews != null) {
					TbNewsLetter tbENews = enews.get();
					String remarks = jsonObject.get("rejectedRemarks").toString();
					tbENews.setApprovalStatus("Rejected");
					tbENews.setRejectedRemarks(remarks);

					newsLetterRepository.save(tbENews);
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
