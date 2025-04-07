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

import com.BisagN.FFL.models.TbHallOfFame;
import com.BisagN.FFL.models.TbPictureGallary;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.repository.PhotoGallaryRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PictureGallaryController {

	@Autowired
	PhotoGallaryRepository photoGallaryRepository;

	@Autowired
	UserLoginRepository userLoginRepository;
	@Autowired
	RoleRepository roleRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();
//
//	// IMAGE
	private String pathforPictureGallary;

//
	@Value("${pathforPictureGallary}")
	public void pathforNotificationImage(String pathforPictureGallary) {
		this.pathforPictureGallary = pathforPictureGallary;
	}

//	@RequestMapping(value = "/admin/add_picture_gallary", method = RequestMethod.GET)
//	public ModelAndView add_picture_gallary(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("add_picture_gallary");
//		return model1;
//	}
	@RequestMapping(value = "/admin/add_picture_gallary", method = RequestMethod.GET)
	public ModelAndView add_picture_gallary(HttpSession session, HttpServletRequest request, ModelMap Mmap,
			Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/add_picture_gallary", Integer.parseInt(roleid));
		Integer val1 = val.size();
//		val1 = true;

		String rolename = request.getSession().getAttribute("role").toString();
		if (rolename.equalsIgnoreCase("ADMIN")) {
			Mmap.put("dashboardurl", "instituteDashboard");
		}
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
		model.setViewName("add_picture_gallary");
		return model;
	}

	@RequestMapping(value = "/admin/SavePictureGallaryData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String SavePictureGallaryData(@Valid @RequestParam("picturegallary") String picturegallary,
			HttpServletRequest request, @RequestParam(value = "imageUpload", required = false) MultipartFile imageUpload)
			throws IOException, DecoderException, ParseException {

		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();
		JSONObject jsonObject = new JSONObject();
		
		String actionType = request.getHeader("X-Action-Type");
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(picturegallary);
		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}

		TbPictureGallary tb_journal = mapper.readValue(jsonNodes1.toString(), TbPictureGallary.class);
//		TbPictureGallary tb_journal = mapper.readValue(picturegallary, TbPictureGallary.class);
		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<TbPictureGallary>> constraintViolations = validator.validate(tb_journal);

		if (constraintViolations != null && !constraintViolations.isEmpty()) {

			for (ConstraintViolation c : constraintViolations) {
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put(c.getPropertyPath(), c.getMessageTemplate());
				jSONArray.add(jsonObject1);

			}

			jsonObject.put("status", "0");
			jsonObject.put("message", jSONArray.toJSONString());
			return jsonObject.toJSONString();
		}

		try {
			JSONObject jsonobjectout = new JSONObject();
			if (tb_journal.getCategory() == null || tb_journal.getCategory().toString() == "-1"
					|| tb_journal.getCategory() == "") {

				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Category is Mandatory");
				return jsonobjectout.toJSONString();
			}

			if (tb_journal.getId() == null || tb_journal.getId() == 0) {
				if (imageUpload == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Picture is mandatory");
					return jsonobjectout.toJSONString();
				}
			}

			if (tb_journal.getCategory() == null || tb_journal.getCategory().toString() == "-1"
					|| tb_journal.getCategory() == "") {

				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Category is Mandatory");
				return jsonobjectout.toJSONString();
			}
			if (imageUpload != null) {
				if (imageUpload.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Upload Picture size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
			}
			if (imageUpload != null) {
				String message = imageValidationController.checkFileFormats(imageUpload,
						imageUpload.getOriginalFilename(), "image");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For Upload Picture");
					return jsonobjectout.toJSONString();
				} else {
				}
			} else {
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String photo1 = "";
			if (imageUpload != null) {
				byte[] bytes = imageUpload.getBytes();

				File dir = new File(pathforPictureGallary);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = imageUpload.getOriginalFilename();
				String photoname = dir.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + tb_journal.getCategory() + "_m_" + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				photo1 = photoname;
				tb_journal.setImageUpload(photoname);
			}
//			List checkpicturegallaryExists = photoGallaryRepository.checkPictureGallaryExists(
//					photo1.toLowerCase().trim(), tb_journal.getCategory().toLowerCase().trim(),
//					tb_journal.getDescription().toLowerCase().trim());
//			if (checkpicturegallaryExists.isEmpty()) {

			if (tb_journal.getId() == null || tb_journal.getId() == 0) {

				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
				tb_journal.setCategory(tb_journal.getCategory());
				tb_journal.setDescription(tb_journal.getDescription());

				tb_journal.setStatus('1');

				tb_journal.setCreatedBy(Integer.parseInt(sessionuserid));
//		tb_journal.setCreatedDate(new Date());

				if (roleName.equalsIgnoreCase("USER")) {
					tb_journal.setInstituteMap(userLogin.get().getRole_map());
				} else {
					tb_journal.setInstituteMap(Integer.parseInt(sessionuserid));
				}
				photoGallaryRepository.save(tb_journal);

				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "Picture Gallery Submitted Successfully");
				returnstring = jsonobjectout.toJSONString();
			} else {

				Optional<TbPictureGallary> journal1 = photoGallaryRepository.findById(tb_journal.getId());
				if (journal1 != null) {
					
					
					TbPictureGallary picturegallarydtll = journal1.get();

					if (picturegallarydtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

					TbPictureGallary obj2 = journal1.get();

					if (imageUpload == null) {
						tb_journal.setImageUpload(obj2.getImageUpload());

					}
					tb_journal.setStatus(obj2.getStatus());
					tb_journal.setDescription(tb_journal.getDescription());
					tb_journal.setCategory(tb_journal.getCategory());
					tb_journal.setCreatedBy(obj2.getCreatedBy());
					tb_journal.setInstituteMap(obj2.getInstituteMap());
					photoGallaryRepository.save(tb_journal);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Picture Gallery updated Successfully");
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
//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "Picture Gallary already exist");
//				returnstring = jsonobjectout.toJSONString();
//			}

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
	@RequestMapping(value = "/admin/LoadPictureGallaryData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadPictureGallaryData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
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
				sortyby = "description";
			} else if (orderId == 2) {
				sortyby = "category";
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
			Page<TbPictureGallary> tb_journal3;

			tb_journal3 = photoGallaryRepository.LoadPictureGallaryData(Integer.parseInt(sessionuserid), search,
					pageable);

			int count = (int) tb_journal3.getPageable().getOffset();
			count = count + 1;
			List<TbPictureGallary> tb_journal4 = tb_journal3.getContent();

			File file = null;
			for (int i = 0; i < tb_journal4.size(); i++) {

				TbPictureGallary tb_journal = tb_journal4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("description", tb_journal.getDescription());
				jsonObject2.put("category", tb_journal.getCategory());

				jsonObject2.put("mapid", tb_journal.getId());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_journal.getId() + "") + "' /> ";

				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
						+ AESGCM.encrypt(tb_journal.getId() + "") + "' /> ";

//				if (tb_journal.getApprovalStatus().equalsIgnoreCase("Rejected")
//						|| tb_journal.getApprovalStatus().equalsIgnoreCase("Approved")) {
//
//					jsonObject2.put("action", "No Action Available");
//
//				} else {
				String action = "<ul class=\"list-inline custom-btn-group\">"
						+ "			<li class=\"list-inline-item\">"
						+ "				<a href=\"#\" class=\"btn btn-primary icon-btn btnedit\" title=\"Edit\">"
						+ "					<i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "			<li class=\"list-inline-item\">"
						+ " 			<a href=\"#\" class=\"btn btn-warning icon-btn btndelete\">"
						+ "					<i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i>"
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
	@RequestMapping(value = "/admin/DeletepicturegallaryData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeletepicturegallaryData(@RequestBody String data, HttpServletRequest request) {

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
				Optional<TbPictureGallary> obj = photoGallaryRepository.findById(id);

				if (obj != null) {
					
					
					TbPictureGallary picturegallarydtll = obj.get();

					if (picturegallarydtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					TbPictureGallary obj2 = obj.get();
					obj2.setStatus('0');
					photoGallaryRepository.delete(obj2);
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
	@RequestMapping(value = "/admin/GetpicturegallaryDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetpicturegallaryDataForUpdate(@RequestBody String data, HttpServletRequest request) {

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

				TbPictureGallary alumniEjournal = new TbPictureGallary();
				Optional<TbPictureGallary> alumni = photoGallaryRepository.findById(id);
				if (alumni != null) {
					
					TbPictureGallary picturegallarydtll = alumni.get();

					if (picturegallarydtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					alumniEjournal = alumni.get();
					jsonobjectout.put("status", "1");
					jsonobjectout.put("description", alumniEjournal.getDescription());
					jsonobjectout.put("category", alumniEjournal.getCategory());
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

	@RequestMapping(value = "/admin/Getimageforuser1", method = RequestMethod.POST, produces = { "application/json" })
	public String Getimageforuser1(@RequestBody String data, HttpServletRequest request)
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

				Optional<TbPictureGallary> tb_journal1 = photoGallaryRepository.findById(id);

				TbPictureGallary tb_journal2 = tb_journal1.get();
	TbPictureGallary pictuegallaryl = tb_journal1.get();
				
				if (pictuegallaryl.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
				if (tb_journal2.getImageUpload() != null) {

					String path = tb_journal2.getImageUpload();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_journal2.getImageUpload());
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

						String imagestr = imageEncoderDecoder(tb_journal2.getImageUpload());

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
				jsonobjectout.put("message", "No Data Found");
				returnstring = jsonobjectout.toJSONString();
			}
			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Unauthorized Access");
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

//
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