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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.ActivityRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.HallOfFameRepository;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;

import com.BisagN.models.UserLogin;
import com.BisagN.repository.UserLoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import javax.imageio.ImageIO;

@RestController
public class ActivityController {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	UserLoginChildRepository userLoginChildRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();

	// IMAGE
	private String pathforactivity;

	private String pathforbackkgroundactivity;

	@Value("${pathforActivity}")
	public void pathforactivity(String pathforactivity) {
		this.pathforactivity = pathforactivity;
	}

	@Value("${pathforbackkgroundactivity}")
	public void pathforbackkgroundactivity(String pathforbackkgroundactivity) {
		this.pathforbackkgroundactivity = pathforbackkgroundactivity;
	}

	@RequestMapping(value = "/admin/addBlog", method = RequestMethod.GET)
	public ModelAndView activity(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
		ModelAndView model1 = new ModelAndView();

		String roleName = request.getSession().getAttribute("role").toString();
		String rolename = request.getSession().getAttribute("role").toString();
		if (rolename.equalsIgnoreCase("ADMIN")) {
			Mmap.put("dashboardurl", "instituteDashboard");
		} else if (rolename.equalsIgnoreCase("USER")) {
			Mmap.put("dashboardurl", "commonDashboard");
		}

		Mmap.put("roleName", roleName);
		model1.setViewName("addactivity");
		return model1;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getInstituteforActivity", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getInstituteforActivity(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));

			List<Userloginchild> userloginchild = userLoginChildRepository
					.findbyuserloginid(userLogin.get().getUserId());

//			List<TbInstituteDetail> list1 = instituteRepository.LoadInstituteData1();

			if (!userloginchild.isEmpty()) {

				for (Userloginchild tbInstituteDetail : userloginchild) {

					object = new JSONObject();

					object.put("id", tbInstituteDetail.getInstituteId().getId());
					object.put("institute_name", tbInstituteDetail.getInstituteId().getInstituteName());
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

	@RequestMapping(value = "/admin/saveActivityDetail", method = RequestMethod.POST, produces = { "application/json" })
	public String saveActivityDetail(@Valid @RequestParam("activitydetail") String tbmiscActivity,
			HttpServletRequest request,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage,
			@RequestParam(value = "uploadbackgroundImage", required = false) MultipartFile uploadbackgroundImage)
			throws IOException, DecoderException, ParseException {
		String actionType = request.getHeader("X-Action-Type");
		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();

		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(tbmiscActivity);
		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}

		
		TbMiscActivity TbmiscActivity = mapper.readValue(jsonNodes1.toString(), TbMiscActivity.class);
		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<TbMiscActivity>> constraintViolations = validator.validate(TbmiscActivity);

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
			if (TbmiscActivity.getId() == null || TbmiscActivity.getId() == 0) {
				if (uploadImage == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Blog Document is mandatory");
					return jsonobjectout.toJSONString();
				}

				if (uploadbackgroundImage == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Upload Image is mandatory");
					return jsonobjectout.toJSONString();
				}
			}
			if (uploadImage != null) {
				// Assuming you have a MultipartFile object named 'image'
				if (uploadImage.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Image size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
				if (uploadbackgroundImage.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Image size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
			}
			if (uploadImage != null) {
				String message = imageValidationController.checkFileFormatsForAllowImagePDFVideo(uploadImage,
						uploadImage.getOriginalFilename());

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For Blog Document");
					return jsonobjectout.toJSONString();
				} else {
				}
			} else {
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String sessionuser = request.getSession().getAttribute("username").toString();
			
			if (uploadImage != null) {
				byte[] bytes = uploadImage.getBytes();

				File dir = new File(pathforactivity);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = uploadImage.getOriginalFilename();
				String photoname = dir.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + TbmiscActivity.getMiscTitle() + "_m_" + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				TbmiscActivity.setMiscPhoto(photoname);
			}

			if (uploadbackgroundImage != null) {
				String message = imageValidationController.checkFileFormats(uploadbackgroundImage,
						uploadbackgroundImage.getOriginalFilename(), "image");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + " For Upload Image");
					return jsonobjectout.toJSONString();
				} else {
				}
			}

			if (uploadbackgroundImage != null) {
				byte[] bytes1 = uploadbackgroundImage.getBytes();

				File dir1 = new File(pathforbackkgroundactivity);
				if (!dir1.exists()) {
					dir1.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename1 = uploadbackgroundImage.getOriginalFilename();
				String photoname1 = dir1.getAbsolutePath()
						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
								.replace(" ", "").toString().replace("-", "").toString()
						+ "_" + TbmiscActivity.getMiscTitle() + "_m_" + filename1;
				File serverFile1 = new File(photoname1);
				BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(serverFile1));
				stream1.write(bytes1);
				stream1.close();
				TbmiscActivity.setImage(photoname1);
			}
			List checkBlogExists = activityRepository
					.checkmiscactExists(TbmiscActivity.getMiscTitle().toLowerCase().trim());

			if (TbmiscActivity.getId() == null || TbmiscActivity.getId() == 0) {
				if (checkBlogExists.isEmpty()) {
					Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
					TbmiscActivity.setMiscPhoto(TbmiscActivity.getMiscPhoto());
					TbmiscActivity.setMiscTitle(TbmiscActivity.getMiscTitle());
					TbmiscActivity.setMiscDescription(TbmiscActivity.getMiscDescription());
					//TbmiscActivity.setYear(TbmiscActivity.getYear());
					if (roleName.equalsIgnoreCase("ADMIN")) {
					    TbmiscActivity.setApprovalStatus("Approved");
					} else {
					    TbmiscActivity.setApprovalStatus("Pending");
					}
					TbmiscActivity.setStatus('1');
					TbmiscActivity.setCreatedBy(Integer.parseInt(sessionuserid));
					TbmiscActivity.setCreatedDate(new Date());
					TbmiscActivity.setUserid(sessionuserid);

					if (roleName.equalsIgnoreCase("USER")) {
						Userloginchild userloginchild = userLoginChildRepository.findByuserinstitueid(
								Integer.parseInt(sessionuserid), TbmiscActivity.getInstituteMap());
						UserLogin userLogin1 = userLoginRepository
								.findUserinstituteFromInsID(userloginchild.getInstituteId().getId());

						TbmiscActivity.setInstituteMap(userLogin1.getUserId());
					} else {
						TbmiscActivity.setInstituteMap(Integer.parseInt(sessionuserid));
					}
					activityRepository.save(TbmiscActivity);

					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Blog Details submitted Successfully");
					returnstring = jsonobjectout.toJSONString();
				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Blog Details already exist");
					returnstring = jsonobjectout.toJSONString();
				}
			} else {

				Optional<TbMiscActivity> tbmiscact = activityRepository.findById(TbmiscActivity.getId());
				if (tbmiscact != null) {
					TbMiscActivity obj2 = tbmiscact.get();
					if (obj2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
						if (checkBlogExists.isEmpty() || obj2.getMiscTitle().toLowerCase()
								.equalsIgnoreCase(TbmiscActivity.getMiscTitle().toLowerCase())) {

							if (uploadImage == null) {
								TbmiscActivity.setMiscPhoto(obj2.getMiscPhoto());

							}
							if (uploadbackgroundImage == null) {
								TbmiscActivity.setImage(obj2.getImage());

							}
							TbmiscActivity.setMiscPhoto(TbmiscActivity.getMiscPhoto());
							TbmiscActivity.setMiscTitle(TbmiscActivity.getMiscTitle());
							TbmiscActivity.setMiscDescription(TbmiscActivity.getMiscDescription());
							//TbmiscActivity.setYear(TbmiscActivity.getYear());
							TbmiscActivity.setImage(TbmiscActivity.getImage());
							TbmiscActivity.setModifyBy(Integer.parseInt(sessionuserid));
							TbmiscActivity.setModifyDate(new Date());
							TbmiscActivity.setCreatedBy(obj2.getCreatedBy());
							TbmiscActivity.setCreatedDate(obj2.getCreatedDate());
							TbmiscActivity.setStatus(obj2.getStatus());
							TbmiscActivity.setApprovalStatus(obj2.getApprovalStatus());
							if (roleName.equalsIgnoreCase("USER")) {
								Userloginchild userloginchild = userLoginChildRepository.findByuserinstitueid(
										Integer.parseInt(sessionuserid), TbmiscActivity.getInstituteMap());
								UserLogin userLogin1 = userLoginRepository
										.findUserinstituteFromInsID(userloginchild.getInstituteId().getId());

								TbmiscActivity.setInstituteMap(userLogin1.getUserId());
							} else {
								TbmiscActivity.setInstituteMap(Integer.parseInt(sessionuserid));
							}

							activityRepository.save(TbmiscActivity);
							jsonobjectout.put("status", "1");
							jsonobjectout.put("message", "Blog Details updated Successfully");
							returnstring = jsonobjectout.toJSONString();

						} else {
							jsonobjectout.put("status", "0");
							jsonobjectout.put("message", "Blog Details already exist");
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
	@RequestMapping(value = "/admin/LoadActivity", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadActivity(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
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
				sortyby = "miscTitle";
			} else if (orderId == 2) {
				sortyby = "miscDescription";
			}
			
//			else if (orderId == 3) {
//				sortyby = "year";
//			}

			else if (orderId == 4) {
				System.out.println("inside");
				sortyby = "rejectedRemarks";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			Page<TbMiscActivity> tbMiscActi = activityRepository.LoadActivityDetail(Integer.parseInt(sessionuserid),
					search, pageable);

			int count = (int) tbMiscActi.getPageable().getOffset();
			count = count + 1;
			List<TbMiscActivity> activities = tbMiscActi.getContent();

			File file = null;
			for (int i = 0; i < activities.size(); i++) {

				TbMiscActivity miscActivity = activities.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("title", miscActivity.getMiscTitle());
				jsonObject2.put("description", miscActivity.getMiscDescription());
				//jsonObject2.put("year", miscActivity.getYear());
				jsonObject2.put("year", "");
				jsonObject2.put("rejectedRemarks", miscActivity.getRejectedRemarks());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(miscActivity.getId() + "") + "' /> ";
				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
						+ AESGCM.encrypt(miscActivity.getId() + "") + "' /> ";
//				jsonObject2.put("ShowImage",
//						"<a href=\"#\" class=\"btn btn-secondary document_status\">View</a> &nbsp" + hidden1);
				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

				if (miscActivity.getApprovalStatus().equalsIgnoreCase("Rejected")
						|| miscActivity.getApprovalStatus().equalsIgnoreCase("Accepted")) {

					jsonObject2.put("action", "No Action Available");

				} else {
					String action = "<ul class=\"list-inline custom-btn-group\">"
							+ "			<li class=\"list-inline-item\">"
							+ "				<a href=\"#\" class=\"btn btn-primary icon-btn btnedit edit_imagedata\" title=\"Edit\">"
							+ "					<i class=\"ri-edit-2-fill \" aria-hidden=\"true\"></i>"
							+ "				</a>" + "			</li>" + "			<li class=\"list-inline-item\">"
							+ " 			<a href=\"#\" class=\"btn btn-warning icon-btn btndelete delete_imagedata\">"
							+ "					<i class=\"ri-delete-bin-2-fill \" aria-hidden=\"true\"></i>"
							+ "				</a>" + "			</li>" + "		</ul>" + hidden1;

					jsonObject2.put("action", action);
				}
				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tbMiscActi.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

//	@RequestMapping(value = "/admin/Getactimage", method = RequestMethod.POST, produces = { "application/json" })
//	public String Getactimage(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//		
//		 String clientIp = request.getHeader("X-Forwarded-For"); // Check if behind a proxy
//	        if (clientIp == null || clientIp.isEmpty()) {
//	            clientIp = request.getRemoteAddr(); // Get IP directly
//	        }
//
//	        // Get current date and time
//	        LocalDateTime currentTime = LocalDateTime.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	        String formattedTime = currentTime.format(formatter);
//
//	        System.out.println("User IP: " + clientIp + " | Date & Time: " + formattedTime);
//		try {
//			JSONObject jsonObject2 = new JSONObject();
//			jsonObject = (JSONObject) jsonp.parse(data);
//
//			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//			if (id != 0) {
//
//				Optional<TbMiscActivity> miscact = activityRepository.findById(id);
//				/*
//				 * Optional<UserLogin> userLogin =
//				 * userLoginRepository.findById(Integer.parseInt(sessionuserid));
//				 */
//				TbMiscActivity tbMiscActivity = miscact.get();
//				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
//				String rolename = request.getSession().getAttribute("role").toString();
//				boolean access= false;
//				if (rolename.equalsIgnoreCase("ADMIN")) {
//					access=tbMiscActivity.getInstituteMap().equals(Integer.parseInt(sessionuserid));
//				} else if (rolename.equalsIgnoreCase("USER")) {
//					access=tbMiscActivity.getInstituteMap().equals(userLogin.get().getRole_map());
//				}
//
//				if (access) {
//					
//				
//					if (tbMiscActivity.getMiscPhoto() != null) {
//
//						String path = tbMiscActivity.getMiscPhoto();
//						String[] bits = path.split("\\.(?=[^\\.]+$)");
//
//						String docType = bits[bits.length - 1];
//
//						if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
//								|| docType.equalsIgnoreCase("png")) {
//
//							String imagestr = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());
//							if (imagestr.equalsIgnoreCase("")) {
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType);
//								jsonObject2.put("document", "Image is not uploaded");
//							} else {
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType);
//								jsonObject2.put("document", imagestr);
//							}
//						} else if (docType.equalsIgnoreCase("pdf")) {
//
//					        
//							if (imagestr.equalsIgnoreCase("")) {
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType); 
//								jsonObject2.put("document", "Pdf is not uploaded");
//							} else {
//								
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType);
//								jsonObject2.put("document", encodedPdf);
//							}
//
//						} else if (docType.equalsIgnoreCase("mp4")) {
//
//							String imagestr = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());
//							//imagestr contains image 
//							byte[] imageBytes = Base64.getDecoder().decode(imagestr);
//							System.out.println(imageBytes);
//							
//							if (imagestr.equalsIgnoreCase("")) {
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType);
//								jsonObject2.put("document", "Video is not uploaded");
//							} else {
//								jsonObject2.put("mapid", tbMiscActivity.getId());
//								jsonObject2.put("DocumentImageType", docType);
//								jsonObject2.put("document", imagestr);
//							}
//
//						}
//
//						else {
//							jsonObject2.put("mapid", tbMiscActivity.getId());
//							jsonObject2.put("DocumentImageType", docType);
//							jsonObject2.put("document", "");
//						}
//
//						jsonobjectout.put("status", "1");
//						jsonobjectout.put("data", jsonObject2);
//						jsonobjectout.put("message", "Data Load Successfully");
//						returnstring = jsonobjectout.toJSONString();
//					}
//				} else {
//					jsonobjectout.put("status", "0");
//					jsonobjectout.put("message", "Unauthorized Access");
//					returnstring = jsonobjectout.toJSONString();
//				}
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
	@RequestMapping(value = "/admin/Getactimage", method = RequestMethod.POST, produces = { "application/json" })
	public String Getactimage(@RequestBody String data, HttpServletRequest request) {
	    JSONObject jsonResponse = new JSONObject();
	    try {
	        JSONParser jsonParser = new JSONParser();
	        JSONObject requestData = (JSONObject) jsonParser.parse(data);

	        int id = Integer.parseInt(AESGCM.decrypt(requestData.get("id").toString()));
	        String sessionUserId = request.getSession().getAttribute("userId_for_jnlp").toString();
	        String roleName = request.getSession().getAttribute("role").toString();
	        
	        if (id == 0) return createErrorResponse("No Data Found");

	        String clientIp = request.getSession().getAttribute("ip").toString();
	        String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//	        System.out.println("User IP: " + clientIp + " | Date & Time: " + formattedTime);

	        Optional<TbMiscActivity> miscActivityOpt = activityRepository.findById(id);
	        if (!miscActivityOpt.isPresent()) return createErrorResponse("No Data Found");

	        TbMiscActivity miscActivity = miscActivityOpt.get();
	        Optional<UserLogin> userLoginOpt = userLoginRepository.findById(Integer.parseInt(sessionUserId));
	        boolean access = roleName.equalsIgnoreCase("ADMIN") 
	            ? miscActivity.getInstituteMap().equals(Integer.parseInt(sessionUserId)) 
	            : userLoginOpt.isPresent() && miscActivity.getInstituteMap().equals(userLoginOpt.get().getRole_map());

	        if (!access) return createErrorResponse("Unauthorized Access");

	        return processDocument(miscActivity.getMiscPhoto(), miscActivity.getId(), clientIp, formattedTime);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return createErrorResponse("Failure");
	    }
	}

	// Helper method to generate an error response
	private String createErrorResponse(String message) {
	    JSONObject jsonResponse = new JSONObject();
	    jsonResponse.put("status", "0");
	    jsonResponse.put("message", message);
	    return jsonResponse.toJSONString();
	}

	// Processes the document based on its type
	private String processDocument(String filePath, int mapId, String clientIp, String formattedTime) throws IOException {
	    JSONObject jsonResponse = new JSONObject();
	    JSONObject jsonData = new JSONObject();

	    if (filePath == null || filePath.isEmpty()) {
	        return createErrorResponse("Document is not uploaded");
	    }

	    String[] parts = filePath.split("\\.(?=[^\\.]+$)");
	    String docType = parts[parts.length - 1].toLowerCase();
	    String base64Content = imageEncoderDecoder(filePath);

	    if (base64Content.isEmpty()) {
	        jsonData.put("mapid", mapId);
	        jsonData.put("DocumentImageType", docType);
	        jsonData.put("document", docType.equals("pdf") ? "PDF is not uploaded" : "Image is not uploaded");
	    } else {
	        switch (docType) {
	            case "jpeg":
	            case "jpg":
	            case "png":
	            	System.out.println("in png");
	                jsonData.put("mapid", mapId);
	                jsonData.put("DocumentImageType", docType);
	                jsonData.put("document",processImage(base64Content, docType, clientIp, formattedTime));
	                break;
	            case "pdf":
	                jsonData.put("mapid", mapId);
	                jsonData.put("DocumentImageType", docType);
	                jsonData.put("document", processPdf(base64Content, clientIp, formattedTime));
	                break;
	            default:
	                jsonData.put("mapid", mapId);
	                jsonData.put("DocumentImageType", docType);
	                jsonData.put("document", "");
	        }
	    }

	    jsonResponse.put("status", "1");
	    jsonResponse.put("data", jsonData);
	    jsonResponse.put("message", "Data Load Successfully");
	    return jsonResponse.toJSONString();
	}

	// Adds watermark to PDF and returns Base64 string
	private String processPdf(String base64Pdf, String clientIp, String formattedTime) throws IOException {
	    byte[] pdfBytes = Base64.getDecoder().decode(base64Pdf);
	    ByteArrayInputStream bais = new ByteArrayInputStream(pdfBytes);
	    PDDocument document = PDDocument.load(bais);

	    float fontSize = 25f;
	    Color textColor = new Color(150, 150, 150, 100);

	    for (PDPage page : document.getPages()) {
	        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
	        contentStream.setNonStrokingColor(textColor);
	        contentStream.beginText();
	        contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
	        contentStream.setTextMatrix(0.707f, 0.707f, -0.707f, 0.707f, page.getMediaBox().getWidth() / 4, page.getMediaBox().getHeight() / 4);
	        contentStream.showText("IP: " + clientIp + " | Date: " + formattedTime);
	        contentStream.endText();
	        contentStream.close();
	    }

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    document.save(baos);
	    document.close();
	    return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
	
	private String processImage(String base64Image, String imageType, String clientIp, String formattedTime) throws IOException {
	    byte[] imageBytes = Base64.getDecoder().decode(base64Image);
	    ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
	    BufferedImage image = ImageIO.read(bais);
	    
	    Graphics2D graphics = image.createGraphics();
	    graphics.setFont(new Font("Arial", Font.BOLD, 30));
	    graphics.setColor(new Color(150, 150, 150, 100)); 
	    graphics.drawString("IP: " + clientIp + " | Date: " + formattedTime, 20, image.getHeight() - 100);
	    graphics.dispose();

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(image, imageType, baos);
	    return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
	@RequestMapping(value = "/admin/Getactimageapproval", method = RequestMethod.POST, produces = {
			"application/json" })
	public String Getactimageapproval(@RequestBody String data, HttpServletRequest request)
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

				Optional<TbMiscActivity> miscact = activityRepository.findById(id);

				TbMiscActivity tbMiscActivity = miscact.get();
				if (tbMiscActivity.getInstituteMap().equals(Integer.parseInt(sessionuserid))) {
					if (tbMiscActivity.getMiscPhoto() != null) {

						String path = tbMiscActivity.getMiscPhoto();
						String[] bits = path.split("\\.(?=[^\\.]+$)");

						String docType = bits[bits.length - 1];

						if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
								|| docType.equalsIgnoreCase("png")) {

							String imagestr = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());
							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Image is not uploaded");
							} else {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}
						} else if (docType.equalsIgnoreCase("pdf")) {

							String imagestr = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());

							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Pdf is not uploaded");
							} else {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}

						} else if (docType.equalsIgnoreCase("mp4")) {

							String imagestr = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());
							if (imagestr.equalsIgnoreCase("")) {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", "Video is not uploaded");
							} else {
								jsonObject2.put("mapid", tbMiscActivity.getId());
								jsonObject2.put("DocumentImageType", docType);
								jsonObject2.put("document", imagestr);
							}

						}

						else {
							jsonObject2.put("mapid", tbMiscActivity.getId());
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
	@RequestMapping(value = "/admin/deleteActivity", method = RequestMethod.POST, produces = { "application/json" })
	public String deleteActivity(@RequestBody String data, HttpServletRequest request) {

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
				Optional<TbMiscActivity> obj = activityRepository.findById(id);

				if (obj != null) {
					TbMiscActivity obj2 = obj.get();
					if (obj2.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
						obj2.setStatus('0');
						activityRepository.delete(obj2);
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
	@RequestMapping(value = "/admin/GetActivityDetailforUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetActivityDetailforUpdate(@RequestBody String data, HttpServletRequest request) {

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

				TbMiscActivity miscActivity = new TbMiscActivity();
				Optional<TbMiscActivity> alumni = activityRepository.findById(id);
				if (alumni != null) {
					miscActivity = alumni.get();
					if (miscActivity.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

						jsonobjectout.put("status", "1");
						jsonobjectout.put("title", miscActivity.getMiscTitle());
						jsonobjectout.put("desc", miscActivity.getMiscDescription());
						
						//jsonobjectout.put("year", miscActivity.getYear());
						jsonobjectout.put("year", "");
						Userloginchild userloginchild = userLoginChildRepository
								.findByuseridId(miscActivity.getInstituteMap());
						jsonobjectout.put("instituteId", userloginchild.getInstituteId().getId());

						jsonobjectout.put("docid", AESGCM.encrypt(miscActivity.getId() + ""));
						jsonobjectout.put("id", AESGCM.encrypt(miscActivity.getId() + ""));
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

	@RequestMapping(value = "/admin/Getcoverphoto1", method = RequestMethod.POST, produces = { "application/json" })
	public String Getcoverphoto1(@RequestBody String data, HttpServletRequest request)
			throws ParseException, IOException {
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

				Optional<TbMiscActivity> misc = activityRepository.findById(id);

				TbMiscActivity misc1 = misc.get();

				if (misc1.getImage() != null) {

					String path = misc1.getImage();
					String[] bits = path.split("\\.(?=[^\\.]+$)");

					String docType = bits[bits.length - 1];
					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
							|| docType.equalsIgnoreCase("png")) {

						String imagestr = imageEncoderDecoder(misc1.getImage());
						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", misc1.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", misc1.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}
					} else if (docType.equalsIgnoreCase("pdf")) {

						String imagestr = imageEncoderDecoder(misc1.getImage());

						if (imagestr.equalsIgnoreCase("")) {
							jsonObject2.put("mapid", misc1.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", "Image is not uploaded");
						} else {
							jsonObject2.put("mapid", misc1.getId());
							jsonObject2.put("DocumentImageType", docType);
							jsonObject2.put("document", imagestr);
						}

					} else {
						jsonObject2.put("mapid", misc1.getId());
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

}