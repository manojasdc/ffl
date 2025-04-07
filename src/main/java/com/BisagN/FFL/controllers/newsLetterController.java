package com.BisagN.FFL.controllers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbNewsLetter;
import com.BisagN.FFL.repository.ActivityRepository;
//import com.BisagN.FFL.models.TbUserletter;
import com.BisagN.FFL.repository.newsLetterRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.util.Base64Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class newsLetterController {
	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	newsLetterRepository NewsLetterRepository;
	@Autowired
	RoleRepository roleRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();

	private String pathforNewsLetter;

	@Value("${pathforNewsLetter}")
	public void pathforNewsLetter(String pathforNewsLetter) {
		this.pathforNewsLetter = pathforNewsLetter;

	}

//	@RequestMapping(value = "/admin/newsLetter", method = RequestMethod.GET)
//	public ModelAndView newsLetter(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		
//		model1.setViewName("newsLetter");
//		return model1;
//	}

	@RequestMapping(value = "/admin/newsLetter", method = RequestMethod.GET)
	public ModelAndView newsLetter(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/newsLetter", Integer.parseInt(roleid));
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
		model.setViewName("newsLetter");
		return model;
	}

	@RequestMapping(value = "/admin/saveNewsLetterData", method = RequestMethod.POST, produces = { "application/json" })
	public String saveNewsLetterData(@Valid @RequestParam("newsLetterDetail") String NewsLetterDetail,
			HttpServletRequest request, @RequestParam(value = "uploadPdf", required = false) MultipartFile uploadPdf)
			throws IOException, DecoderException, ParseException {

		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();
		

		String actionType = request.getHeader("X-Action-Type");
		System.out.println(NewsLetterDetail);
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(NewsLetterDetail);
		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}

		TbNewsLetter tb_detail = mapper.readValue(jsonNodes1.toString(), TbNewsLetter.class);
		
//		TbNewsLetter tb_detail = mapper.readValue(NewsLetterDetail, TbNewsLetter.class);
		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<TbNewsLetter>> constraintViolations = validator.validate(tb_detail);

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

		try {
			JSONObject jsonobjectout = new JSONObject();
			if (tb_detail.getId() == null || tb_detail.getId() == 0) {
				if (uploadPdf == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "News Letter is mandatory");
					return jsonobjectout.toJSONString();
				}
			}
			if (uploadPdf != null) {
				if (uploadPdf.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "News Letter PDF size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
			}
			if (uploadPdf != null) {
				String message = imageValidationController.checkFileFormats(uploadPdf, uploadPdf.getOriginalFilename(),
						"pdf");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For Upload NewsLetter");
					return jsonobjectout.toJSONString();
				} else {
				}
			} else {
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String photo1 = "";
			if (uploadPdf != null) {
				byte[] bytes = uploadPdf.getBytes();

				File dir = new File(pathforNewsLetter);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = uploadPdf.getOriginalFilename();
				String photoname = dir.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + tb_detail.getNewsLetterName() + "_m_" + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				photo1 = photoname;
				tb_detail.setUploadPdf(photoname);
			}
			List checknewsletterExists = NewsLetterRepository
					.checkNewsletterExists(tb_detail.getNewsLetterName().toLowerCase().trim());

			if (tb_detail.getId() == null || tb_detail.getId() == 0) {
				if (checknewsletterExists.isEmpty()) {
					Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
					tb_detail.setNewsLetterName(tb_detail.getNewsLetterName());
					tb_detail.setDescription(tb_detail.getDescription());

					tb_detail.setStatus('1');
					tb_detail.setCreatedBy(Integer.parseInt(sessionuserid));
					tb_detail.setCreatedDate(new Date());
					if (roleName.equalsIgnoreCase("USER")) {
						tb_detail.setInstituteMap(userLogin.get().getRole_map());
					} else {
						tb_detail.setInstituteMap(Integer.parseInt(sessionuserid));
					}
					System.out.println(tb_detail.toString());
					NewsLetterRepository.save(tb_detail);

					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "News Letter Details submitted Successfully");
					returnstring = jsonobjectout.toJSONString();

				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "NewsLetter already exist");
					returnstring = jsonobjectout.toJSONString();
				}
			} else {

				Optional<TbNewsLetter> letter1 = NewsLetterRepository.findById(tb_detail.getId());
				if (letter1 != null) {
					TbNewsLetter newsletterdtll = letter1.get();

					if (newsletterdtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					
					TbNewsLetter obj2 = letter1.get();
					if (checknewsletterExists.isEmpty() || obj2.getNewsLetterName().toLowerCase()
							.equalsIgnoreCase(tb_detail.getNewsLetterName().toLowerCase())) {
						if (uploadPdf == null) {
							tb_detail.setUploadPdf(obj2.getUploadPdf());
							// tbStaffPayinfo.setp(tbStaffPayinfo.getph());

						}
						tb_detail.setStatus(obj2.getStatus());
						tb_detail.setNewsLetterName(tb_detail.getNewsLetterName());
						tb_detail.setDescription(tb_detail.getDescription());

						tb_detail.setModifiedBy(Integer.parseInt(sessionuserid));
						tb_detail.setModifiedDate(new Date());
						tb_detail.setCreatedBy(obj2.getCreatedBy());
						tb_detail.setCreatedDate(obj2.getCreatedDate());
						tb_detail.setInstituteMap(obj2.getInstituteMap());
						NewsLetterRepository.save(tb_detail);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "News Letter Details Updated Successfully");
						returnstring = jsonobjectout.toJSONString();

					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "NewsLetter already exist");
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

	@RequestMapping(value = "/admin/GetPDFuser", method = RequestMethod.POST, produces = { "application/json" })
	public String GetPDFuser(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
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

				Optional<TbNewsLetter> tb_letter1 = NewsLetterRepository.findById(id);

				TbNewsLetter tb_letter2 = tb_letter1.get();
				TbNewsLetter halloffamedtll = tb_letter1.get();
				String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

				if (halloffamedtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
				if (tb_letter2.getUploadPdf() != null) {

					String path = tb_letter2.getUploadPdf();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_letter2.getUploadPdf());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(tb_letter2.getUploadPdf());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", tb_letter2.getId());
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

	@RequestMapping(value = "/admin/GetPDFNews", method = RequestMethod.POST, produces = { "application/json" })
	public String GetPDFNews(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		//
//			List<String> Columns = new ArrayList<String>();
		//
		try {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject = (JSONObject) jsonp.parse(data);

			int id = Integer.parseInt(AESGCM.decrypt(new String(Base64Service.decode(jsonObject.get("id").toString()))));

			if (id != 0) {
				//Optional<TbMiscActivity> miscact = activityRepository.findById(id);
				Optional<TbNewsLetter> tb_letter1 = NewsLetterRepository.findById(id);
				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));

				TbNewsLetter tb_letter2 = tb_letter1.get();
				TbNewsLetter halloffamedtll = tb_letter1.get();
				
				String rolename = request.getSession().getAttribute("role").toString();
				boolean access= false;
				
				if (rolename.equalsIgnoreCase("ADMIN")) {
					access=halloffamedtll.getInstituteMap().equals(Integer.parseInt(sessionuserid));
				} else if (rolename.equalsIgnoreCase("USER")) {
					access=halloffamedtll.getInstituteMap().equals(userLogin.get().getRole_map());
				}

				if (access) {
				
				
				//if (halloffamedtll.getInstituteMap().equals(userLogin.get().getInstituteId())) {
					
					
					
					
				if (tb_letter2.getUploadPdf() != null) {

					String path = tb_letter2.getUploadPdf();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(tb_letter2.getUploadPdf());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(tb_letter2.getUploadPdf());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", tb_letter2.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", tb_letter2.getId());
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

	@ResponseBody
	@RequestMapping(value = "/admin/GetNewsLetterDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetNewsLetterDataForUpdate(@RequestBody String data, HttpServletRequest request) {

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

				TbNewsLetter letter = new TbNewsLetter();
				Optional<TbNewsLetter> output = NewsLetterRepository.findById(id);
				if (output != null) {
					
					TbNewsLetter newsletterdtll = output.get();

					if (newsletterdtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

					letter = output.get();
					jsonobjectout.put("status", "1");
					jsonobjectout.put("newsLetterName", letter.getNewsLetterName());
					jsonobjectout.put("description", letter.getDescription());
					//jsonobjectout.put("uploadpdf", letter.getUploadPdf());
					// jsonobjectout.put("category", letter.getCategory());
					jsonobjectout.put("docid", AESGCM.encrypt(letter.getId() + ""));
					jsonobjectout.put("id", AESGCM.encrypt(letter.getId() + ""));
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
	@RequestMapping(value = "/admin/deleteNewsLetterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String deleteNewsLetterData(@RequestBody String data, HttpServletRequest request) {

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
				Optional<TbNewsLetter> obj = NewsLetterRepository.findById(id);

				if (obj != null) {
					

					TbNewsLetter newsletterdtll = obj.get();

					if (newsletterdtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					TbNewsLetter obj2 = obj.get();
					obj2.setStatus('0');
					NewsLetterRepository.delete(obj2);
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

	@ResponseBody
	@RequestMapping(value = "/admin/LoadNewsLetterData", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadNewsLetterData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
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

			String sortyby = "createdDate";

			if (orderId == 0) {
				sortyby = "createdDate";
			} else if (orderId == 1) {
				sortyby = "newsLetterName";
			} else if (orderId == 2) {
				sortyby = "description";
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
			Page<TbNewsLetter> tb_letter3;

			tb_letter3 = NewsLetterRepository.loadNewsLetterData(Integer.parseInt(sessionuserid), search, pageable);

			int count = (int) tb_letter3.getPageable().getOffset();
			count = count + 1;
			List<TbNewsLetter> tb_letter4 = tb_letter3.getContent();

			File file = null;
			for (int i = 0; i < tb_letter4.size(); i++) {

				TbNewsLetter tb_detail = tb_letter4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("name", tb_detail.getNewsLetterName());
				jsonObject2.put("description", tb_detail.getDescription());
				jsonObject2.put("rejectedRemarks", tb_detail.getRejectedRemarks());

				jsonObject2.put("mapid", tb_detail.getId());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tb_detail.getId() + "") + "' /> ";

				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
						+ AESGCM.encrypt(tb_detail.getId() + "") + "' /> ";

//				if (tb_detail.getApprovalStatus().equalsIgnoreCase("Rejected")
//						|| tb_detail.getApprovalStatus().equalsIgnoreCase("Accepted")) {
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
			jsonobjectout.put("TotalCount", tb_letter3.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}
}
