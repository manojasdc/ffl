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
import org.springframework.jdbc.core.JdbcTemplate;
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

import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.TbWhatsNewScroll;
import com.BisagN.FFL.repository.UserEjournalRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.TbThoughtDtl;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserEjournalController {

	@Autowired
	UserEjournalRepository userEjournalRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired JdbcTemplate templet;

	public ImageValidationController imageValidationController = new ImageValidationController();

	// IMAGE
	private String pathforUserJournal;
	private String pathforCoverphoto;

	@Value("${pathforUserJournal}")
	public void pathforNotificationImage(String pathforUserJournal) {
		this.pathforUserJournal = pathforUserJournal;
	}

	@Value("${pathforCoverphoto}")
	public void pathforCoverphoto(String pathforCoverphoto) {
		this.pathforCoverphoto = pathforCoverphoto;
	}

//	@RequestMapping(value = "/admin/user_ejournal", method = RequestMethod.GET)
//	public ModelAndView user_ejournal(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("user_ejournal");
//		return model1;
//	}

	@RequestMapping(value = "/admin/user_ejournal", method = RequestMethod.GET)
	public ModelAndView user_ejournal(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/user_ejournal", Integer.parseInt(roleid));
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
		model.setViewName("user_ejournal");
		return model;
	}

	@RequestMapping(value = "/admin/SaveUserEJournalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String SaveUserEJournalData(@Valid @RequestParam("journaldetail") String tbjournaldetail,
			HttpServletRequest request, @RequestParam(value = "uploadPdf", required = false) MultipartFile uploadPdf,
			@RequestParam(value = "coverphoto", required = false) MultipartFile coverphoto)
			throws IOException, DecoderException, ParseException {

		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();

		String actionType = request.getHeader("X-Action-Type");
		System.out.println(tbjournaldetail);
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(tbjournaldetail);
		
		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}
		TbUserAlumniEjournal tb_journal = mapper.readValue(jsonNodes1.toString(), TbUserAlumniEjournal.class);
//		TbUserAlumniEjournal tb_journal = mapper.readValue(tbjournaldetail, TbUserAlumniEjournal.class);
		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		try {

			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

			Set<ConstraintViolation<TbUserAlumniEjournal>> constraintViolations = validator.validate(tb_journal);

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

			JSONObject jsonobjectout = new JSONObject();

			if (tb_journal.getId() == null || tb_journal.getId() == 0) {
				if (coverphoto == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Cover Photo is mandatory");
					return jsonobjectout.toJSONString();
				}

				if (uploadPdf == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "PDF is mandatory");
					return jsonobjectout.toJSONString();
				}

				if (tb_journal.getPublisherDate() == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Publisher Date is mandatory");
					return jsonobjectout.toJSONString();
				}
			}
			if (uploadPdf != null) {
				String message = imageValidationController.checkFileFormats(uploadPdf, uploadPdf.getOriginalFilename(),
						"pdf");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For Upload Journal PDF");
					return jsonobjectout.toJSONString();
				} else {
				}
			}

			if (coverphoto != null) {
				String message = imageValidationController.checkFileFormats(coverphoto,
						coverphoto.getOriginalFilename(), "image");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For CoverPhoto");
					return jsonobjectout.toJSONString();
				} else {
				}
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String photo1 = "";
			String photo2 = "";
			if (uploadPdf != null) {
				byte[] bytes = uploadPdf.getBytes();

				File dir = new File(pathforUserJournal);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = uploadPdf.getOriginalFilename();
				String photoname = dir.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + tb_journal.getName() + "_m_" + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				photo2 = photoname;

				tb_journal.setUploadPdf(photoname);
			}

			if (coverphoto != null) {
				byte[] bytes1 = coverphoto.getBytes();

				File dir1 = new File(pathforCoverphoto);
				if (!dir1.exists()) {
					dir1.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename1 = coverphoto.getOriginalFilename();
				String photoname1 = dir1.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + tb_journal.getName() + "_m_" + filename1;
				File serverFile1 = new File(photoname1);
				BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(serverFile1));
				stream1.write(bytes1);
				stream1.close();
				photo1 = photoname1;
				tb_journal.setCoverPhoto(photoname1);
			}
			System.err.println(tb_journal.getPublisherDate().toString());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = formatter.format(tb_journal.getPublisherDate());
			System.err.println("DATE pasrse ------ " + dateStr);
			List checkuserejournalExists = userEjournalRepository.checkUserejournalExists(tb_journal.getName().toLowerCase().trim());
			Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
			if (tb_journal.getId() == null || tb_journal.getId() == 0) {
				if (checkuserejournalExists.isEmpty()) {
					
					tb_journal.setName(tb_journal.getName());
					tb_journal.setDescription(tb_journal.getDescription());
					tb_journal.setCategory(tb_journal.getCategory());
					tb_journal.setApprovalStatus("Pending");
					tb_journal.setStatus('1');
					tb_journal.setCreatedBy(Integer.parseInt(sessionuserid));
					tb_journal.setCreatedDate(new Date());
					tb_journal.setInstituteMap(templet.queryForObject(
						"SELECT institute_id FROM userloginchild WHERE user_id = ? limit 1",
						new Object[]{userLogin.get().getUserId()}, 
						Integer.class
					));
					userEjournalRepository.save(tb_journal);

					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "User E-journal Details submitted Successfully");
					returnstring = jsonobjectout.toJSONString();
				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "User E-Journal Details already exist");
					returnstring = jsonobjectout.toJSONString();
				}
			}

			else {

				Optional<TbUserAlumniEjournal> journal1 = userEjournalRepository.findById(tb_journal.getId());
				if (journal1 != null) {

					TbUserAlumniEjournal obj2 = journal1.get();
					if (obj2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
//					TbUserAlumniEjournal obj2 = journal1.get();
						if (checkuserejournalExists.isEmpty()
								|| obj2.getName().toLowerCase().equalsIgnoreCase(tb_journal.getName().toLowerCase())) {
							if (coverphoto == null) {
								tb_journal.setCoverPhoto(obj2.getCoverPhoto());

							}

							if (uploadPdf == null) {
								tb_journal.setUploadPdf(obj2.getUploadPdf());

							}
							tb_journal.setStatus(obj2.getStatus());
							tb_journal.setName(tb_journal.getName());
							tb_journal.setDescription(tb_journal.getDescription());
							tb_journal.setCategory(tb_journal.getCategory());
							tb_journal.setPublisherDate(tb_journal.getPublisherDate());
							tb_journal.setCoverPhoto(tb_journal.getCoverPhoto());
							tb_journal.setUploadPdf(tb_journal.getUploadPdf());
							tb_journal.setApprovalStatus(obj2.getApprovalStatus());
							tb_journal.setModifiedBy(Integer.parseInt(sessionuserid));
							tb_journal.setModifiedDate(new Date());
							tb_journal.setCreatedBy(obj2.getCreatedBy());
							tb_journal.setCreatedDate(obj2.getCreatedDate());
							tb_journal.setInstituteMap(userLogin.get().getInstituteId());
							userEjournalRepository.save(tb_journal);
							jsonobjectout.put("status", "1");
							jsonobjectout.put("message", "User E-journal Details Updated Successfully");
							returnstring = jsonobjectout.toJSONString();

						} else {
							jsonobjectout.put("status", "0");
							jsonobjectout.put("message", "User E-Journal Details already exist");
							returnstring = jsonobjectout.toJSONString();
						}
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
	@RequestMapping(value = "/admin/LoadUserJournalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadUserJournalData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		List<String> Columns = new ArrayList<String>();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

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
				sortyby = "id.name";
			} else if (orderId == 2) {
				sortyby = "description";
			} else if (orderId == 3) {
				sortyby = "author";
			} else if (orderId == 4) {
				sortyby = "category";
			}
//			else if (orderId == 6) {
//				sortyby = "rejectedRemarks";
//			}
			else if (orderId == 6) {
				sortyby = "publisher";
			} else if (orderId == 7) {
				sortyby = "publisherDate";
			} else if (orderId == 8) {
				sortyby = "language";
			} else if (orderId == 9) {
				sortyby = "bookLength";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			String roleName = request.getSession().getAttribute("role").toString();
			Page<TbUserAlumniEjournal> tb_journal3;

			tb_journal3 = userEjournalRepository.LoadUserejournalData(Integer.parseInt(sessionuserid), search,pageable);

			int count = (int) tb_journal3.getPageable().getOffset();
			count = count + 1;
			List<TbUserAlumniEjournal> tb_journal4 = tb_journal3.getContent();

			File file = null;
			for (int i = 0; i < tb_journal4.size(); i++) {

				TbUserAlumniEjournal tb_journal = tb_journal4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("name", tb_journal.getName());
				jsonObject2.put("description", tb_journal.getDescription());
				jsonObject2.put("author", tb_journal.getAuthor());
				jsonObject2.put("category", tb_journal.getCategory());
				jsonObject2.put("rejectedRemarks", tb_journal.getRejectedRemarks());
				jsonObject2.put("publisher", tb_journal.getPublisher());
				jsonObject2.put("publisherDate", tb_journal.getPublisherDate().toString());
				jsonObject2.put("language", tb_journal.getLanguage());
				jsonObject2.put("bookLength", tb_journal.getBookLength());
				jsonObject2.put("mapid", tb_journal.getId());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_journal.getId() + "") + "' /> ";

//				jsonObject2.put("ShowImage",
//						"<a href=\"#\" class=\"btn btn-danger document_status\">View</a> &nbsp" + hidden1);
				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

				jsonObject2.put("coverPhoto", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview coverphoto\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);
//				jsonObject2.put("coverPhoto",
//						"<a href=\"#\" class=\"btn btn-danger coverphoto\">View</a> &nbsp" + hidden1);

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
						+ AESGCM.encrypt(tb_journal.getId() + "") + "' /> ";

//				if (tb_journal.getApprovalStatus().equalsIgnoreCase("Rejected")
//						|| tb_journal.getApprovalStatus().equalsIgnoreCase("Accepted")) {
//
//					jsonObject2.put("action", "No Action Available");
//
//				} else {
//					String action = "<a href=\"#\" class=\"btn btn-primary icon-btn btnedit\" title=\"Edit\"><i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
//				              + " <a href=\"#\" class=\"btn btn-warning icon-btn btndelete\" title=\"Delete\"><i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i></a>";

				String action = "<ul class=\"list-inline custom-btn-group\">"
						+ "			<li class=\"list-inline-item\">"
						+ "				<a href=\"#\" class=\"btn btn-primary icon-btn btnedit edit_imagedata\" title=\"Edit\">"
						+ "					<i class=\"ri-edit-2-fill\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "			<li class=\"list-inline-item\">"
						+ " 			<a href=\"#\" class=\"btn btn-warning icon-btn btndelete delete_imagedata\">"
						+ "					<i class=\"ri-delete-bin-2-fill\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "		</ul>";
				jsonObject2.put("action", action);
//				}

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tb_journal3.getTotalElements());
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
	@RequestMapping(value = "/admin/DeleteuserejournalData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeleteuserejournalData(@RequestBody String data, HttpServletRequest request) {

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
				Optional<TbUserAlumniEjournal> obj = userEjournalRepository.findById(id);

				if (obj != null) {

					TbUserAlumniEjournal obj2 = obj.get();
					if (obj2.getCreatedBy().toString().equals(sessionuserid)) {
						obj2.setStatus('0');
						userEjournalRepository.delete(obj2);
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

	@ResponseBody
	@RequestMapping(value = "/admin/GetuserejournalDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetuserejournalDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		String returnstring = "";
		try {
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));

				TbUserAlumniEjournal alumniEjournal = new TbUserAlumniEjournal();
				Optional<TbUserAlumniEjournal> alumni = userEjournalRepository.findById(id);
				if (alumni != null) {

					alumniEjournal = alumni.get();

					if (alumniEjournal.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

						alumniEjournal = alumni.get();
						jsonobjectout.put("status", "1");
						jsonobjectout.put("name", alumniEjournal.getName());
						jsonobjectout.put("description", alumniEjournal.getDescription());
						jsonobjectout.put("author", alumniEjournal.getAuthor());
						jsonobjectout.put("category", alumniEjournal.getCategory());
						jsonobjectout.put("publisher", alumniEjournal.getPublisher());
						jsonobjectout.put("publisherDate", alumniEjournal.getPublisherDate().toString());
						jsonobjectout.put("language", alumniEjournal.getLanguage());
						jsonobjectout.put("bookLength", alumniEjournal.getBookLength());

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

	@RequestMapping(value = "/admin/GetPDFJournal", method = RequestMethod.POST, produces = { "application/json" })
	public String GetPDFJournal(@RequestBody String data, HttpServletRequest request)
			throws ParseException, IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);

			int id = Integer.parseInt(AESGCM.decrypt(new String(Base64Service.decode(jsonObject.get("id").toString()))));
			if (id != 0) {

				Optional<TbUserAlumniEjournal> tb_journal1 = userEjournalRepository.findById(id);
				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
				TbUserAlumniEjournal tb_journal2 = tb_journal1.get();
				if (tb_journal2.getInstituteMap().equals(templet.queryForObject(
					"SELECT institute_id FROM userloginchild WHERE user_id = ? limit 1",
					new Object[]{userLogin.get().getUserId()}, 
					Integer.class
				))) {
					if (tb_journal2.getUploadPdf() != null) {

						String path = tb_journal2.getUploadPdf();
						String[] bits = path.split("\\.(?=[^\\.]+$)");

						String docType = bits[bits.length - 1];
						if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
								|| docType.equalsIgnoreCase("png")) {

							String imagestr = imageEncoderDecoder(tb_journal2.getUploadPdf());
							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Image is not uploaded");
							} else {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}
						} else if (docType.equalsIgnoreCase("pdf")) {

							String imagestr = imageEncoderDecoder(tb_journal2.getUploadPdf());

							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Image is not uploaded");
							} else {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}

						} else {
							jsonObject2.put("mapid", tb_journal2.getId());
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
					jsonobjectout.put("message", "Unauthorized Access");
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

	@RequestMapping(value = "/admin/GetPDFuser1", method = RequestMethod.POST, produces = { "application/json" })
	public String GetPDFuser1(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);

			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
			if (id != 0) {

				Optional<TbUserAlumniEjournal> tb_journal1 = userEjournalRepository.findById(id);

				TbUserAlumniEjournal tb_journal2 = tb_journal1.get();
				if (tb_journal2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

					if (tb_journal2.getUploadPdf() != null) {

						String path = tb_journal2.getUploadPdf();
						String[] bits = path.split("\\.(?=[^\\.]+$)");

						String docType = bits[bits.length - 1];
						if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
								|| docType.equalsIgnoreCase("png")) {

							String imagestr = imageEncoderDecoder(tb_journal2.getUploadPdf());
							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Image is not uploaded");
							} else {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}
						} else if (docType.equalsIgnoreCase("pdf")) {

							String imagestr = imageEncoderDecoder(tb_journal2.getUploadPdf());

							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Image is not uploaded");
							} else {
								jsonObject2.put("mapid", tb_journal2.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}

						} else {
							jsonObject2.put("mapid", tb_journal2.getId());
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
					jsonobjectout.put("message", "Unauthorized Access");
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

	@RequestMapping(value = "/admin/Getcoverphoto", method = RequestMethod.POST, produces = { "application/json" })
	public String Getcoverphoto(@RequestBody String data, HttpServletRequest request)
			throws ParseException, IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);

			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
			if (id != 0) {

				Optional<TbUserAlumniEjournal> tb_journal1 = userEjournalRepository.findById(id);

				TbUserAlumniEjournal tb_journal2 = tb_journal1.get();
				if (tb_journal2.getCreatedBy().toString().equalsIgnoreCase(sessionuserid)) {
				if (tb_journal2.getUploadPdf() != null) {

					String path = tb_journal2.getCoverPhoto();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_journal2.getCoverPhoto());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_journal2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_journal2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(tb_journal2.getCoverPhoto());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_journal2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_journal2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", tb_journal2.getId());
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
					jsonobjectout.put("message", "Unauthorized Access");
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
		// image path declaration
		// String imgPath = "src/main/resources/images/bean.png";

		// read image from file
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