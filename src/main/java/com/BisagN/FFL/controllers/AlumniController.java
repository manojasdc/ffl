//package com.BisagN.FFL.controllers;
//
//import java.io.BufferedOutputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//import org.apache.commons.codec.DecoderException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.BisagN.FFL.models.TbAlumniDetails;
//import com.BisagN.FFL.models.TbCityName;
//import com.BisagN.FFL.models.TbCountryName;
//import com.BisagN.FFL.models.TbHallOfFame;
//import com.BisagN.FFL.models.TbStateName;
//import com.BisagN.FFL.models.TbUserAlumniEjournal;
//import com.BisagN.FFL.repository.AlumniRepository;
//import com.BisagN.FFL.repository.CityRepository;
//import com.BisagN.FFL.repository.CountryRepository;
//import com.BisagN.FFL.repository.HallOfFameRepository;
//import com.BisagN.FFL.repository.StateRepository;
//import com.BisagN.controller.AESGCM;
//import com.BisagN.controller.ImageValidationController;
//
//import com.BisagN.models.UserLogin;
//import com.BisagN.repository.UserLoginRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//public class AlumniController {
//
//	@Autowired
//	AlumniRepository alumniRepository;
//	
//	@Autowired
//	StateRepository stateRepository;
//	
//	@Autowired
//	CityRepository cityRepository;
//	
//	@Autowired
//	CountryRepository countryRepository;
//	
//	@Autowired
//	UserLoginRepository userLoginRepository;
//
//	public ImageValidationController imageValidationController = new ImageValidationController();
//
//	// IMAGE
//	private String pathforalumni;
//
//	@Value("${pathforAlumni}")
//	public void pathforHallofFameImage(String pathforalumni) {
//		this.pathforalumni = pathforalumni;
//	}
//
//	@RequestMapping(value = "/admin/addAlumniDetail", method = RequestMethod.GET)
//	public ModelAndView Ejournal() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("addAlumniDetail");
//		return model;
//	}
//	@ResponseBody
//	@RequestMapping(value = "/admin/getCountryName", method = RequestMethod.POST, produces = { "application/json" })
//	public String getCountryName(HttpServletRequest request) {
//		JSONArray jSONArray = new JSONArray();
//		JSONObject object = new JSONObject();
//
//		JSONObject object1 = new JSONObject();
//
//		try {
//
//			List<TbCountryName> list1 = countryRepository.LoadData();
//
//			if (!list1.isEmpty()) {
//				for (int i = 0; i < list1.size(); i++) {
//					object = new JSONObject();
//					TbCountryName tb_country = list1.get(i);
//					object.put("id", tb_country.getId());
//					object.put("countryName", tb_country.getCountryName());
//					jSONArray.add(object);
//				}
//
//				object1.put("countryList", jSONArray);
//			} else {
//				jSONArray = new JSONArray();
//				object1.put("countryList", jSONArray);
//			}
//
//			object1.put("Status", "1");
//			object1.put("Message", "Success");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			object1 = new JSONObject();
//			object1.put("Status", "0");
//			object1.put("Message", "Something went wrong");
//		}
//		return object1.toJSONString();
//	}
//
//@ResponseBody
//	@RequestMapping(value = "/admin/getCityName", method = RequestMethod.POST, produces = { "application/json" })
//	public String getCityName(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
//		JSONArray jSONArray = new JSONArray();
//		JSONObject object = new JSONObject();
//
//		JSONObject object1 = new JSONObject();
//
//		try {
//
//			List<TbCityName> list1 = cityRepository.LoadData(id);
//
//			if (!list1.isEmpty()) {
//				for (int i = 0; i < list1.size(); i++) {
//					object = new JSONObject();
//					TbCityName tb_city = list1.get(i);
//					object.put("id", tb_city.getId());
//					object.put("cityName", tb_city.getCityName());
//					jSONArray.add(object);
//				}
//
//				object1.put("cityList", jSONArray);
//			} else {
//				jSONArray = new JSONArray();
//				object1.put("cityList", jSONArray);
//			}
//
//			object1.put("Status", "1");
//			object1.put("Message", "Success");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			object1 = new JSONObject();
//			object1.put("Status", "0");
//			object1.put("Message", "Something went wrong");
//		}
//		return object1.toJSONString();
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/admin/getStateName", method = RequestMethod.POST, produces = { "application/json" })
//	public String getStateName(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
//		JSONArray jSONArray = new JSONArray();
//		JSONObject object = new JSONObject();
//
//		JSONObject object1 = new JSONObject();
//
//		try {
//
//			List<TbStateName> list1 = stateRepository.LoadData(id);
//
//			if (!list1.isEmpty()) {
//				for (int i = 0; i < list1.size(); i++) {
//					object = new JSONObject();
//					TbStateName tb_state = list1.get(i);
//					object.put("id", tb_state.getId());
//					object.put("stateName", tb_state.getStateName());
//					jSONArray.add(object);
//				}
//
//				object1.put("stateList", jSONArray);
//			} else {
//				jSONArray = new JSONArray();
//				object1.put("stateList", jSONArray);
//			}
//
//			object1.put("Status", "1");
//			object1.put("Message", "Success");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			object1 = new JSONObject();
//			object1.put("Status", "0");
//			object1.put("Message", "Something went wrong");
//		}
//		return object1.toJSONString();
//	}
//	
//	@RequestMapping(value = "/admin/saveAlumnidata", method = RequestMethod.POST, produces = { "application/json" })
//	public String saveAlumnidata(@RequestParam("alumnidetails") String alumnidetails,
//			HttpServletRequest request, @RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage)
//			throws IOException, DecoderException, ParseException {
//
//		JSONArray jSONArray = new JSONArray();
//		ObjectMapper mapper = new ObjectMapper();
//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonobject = new JSONObject();
//		TbAlumniDetails alumniDetails2 = mapper.readValue(alumnidetails, TbAlumniDetails.class);
//		String roleName = request.getSession().getAttribute("role").toString();
//		String returnstring = "";
//
//		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//		
//		Set<ConstraintViolation<TbAlumniDetails>> constraintViolations = validator.validate(alumniDetails2);
//		
//		if (constraintViolations != null && !constraintViolations.isEmpty()) {
//
//			for (ConstraintViolation c : constraintViolations) {
//				JSONObject jsonObject1 = new JSONObject();
//				jsonObject1.put(c.getPropertyPath(), c.getMessageTemplate());
//				jSONArray.add(jsonObject1);
//
//			}
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("status", "0");
//				jsonObject.put("message", jSONArray.toJSONString());
//				return jsonObject.toJSONString();
//		}
//
//		try {
//			JSONObject jsonobjectout = new JSONObject();
//			
//			if (alumniDetails2.getCountryId().getId() == null || alumniDetails2.getCountryId().getId() == -1) {
//				JSONObject jsonObject = new JSONObject();
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "Country Name is Mandatory");
//				return jsonobjectout.toJSONString();
//			}
//			if (alumniDetails2.getStateId().getId() == null || alumniDetails2.getStateId().getId() == -1) {
//
//				JSONObject jsonObject = new JSONObject();
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "State Name is Mandatory");
//				return jsonobjectout.toJSONString();
//			}
//			if (alumniDetails2.getCityId().getId() == null || alumniDetails2.getCityId().getId() == -1) {
//
//				JSONObject jsonObject = new JSONObject();
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "City Name is Mandatory");
//				return jsonobjectout.toJSONString();
//			}
//
//			if (uploadImage != null) {
//				String message = imageValidationController.checkFileFormats(uploadImage,
//						uploadImage.getOriginalFilename(), "image");
//
//				if (!message.equalsIgnoreCase("success")) {
//					jsonobjectout.put("status", "0");
//					jsonobjectout.put("message", message + " For JPEG");
//					return jsonobjectout.toJSONString();
//				} else {
//				}
//			} else {
//			}
//
//			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//
//			if (uploadImage != null) {
//				byte[] bytes = uploadImage.getBytes();
//
//				File dir = new File(pathforalumni);
//				if (!dir.exists()) {
//					dir.mkdirs();
//				}
//
//				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
//				String filename = uploadImage.getOriginalFilename();
//				String photoname = dir.getAbsolutePath()
//						+ File.separator + curdate.replace(":", "").toString().replace(".", ".").toString()
//								.replace(" ", "").toString().replace("-", "").toString()
//						+ "_"  + "_m_" + filename;
//				File serverFile = new File(photoname);
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//				alumniDetails2.setProfilePicture(photoname);
//			}
//
//			if (alumniDetails2.getId() == null || alumniDetails2.getId() == 0) {
//				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
////				alumniDetails2.setProfilePicture(alumniDetails2.getProfilePicture());
//				alumniDetails2.setCountryId(alumniDetails2.getCountryId());
//				alumniDetails2.setStateId(alumniDetails2.getStateId());
//				alumniDetails2.setCityId(alumniDetails2.getCityId());
//				alumniDetails2.setLine1(alumniDetails2.getLine1().toString());
//				alumniDetails2.setLine2(alumniDetails2.getLine2());
//				alumniDetails2.setPincode(alumniDetails2.getPincode());
//			
//				alumniDetails2.setStatus("1");
//				alumniDetails2.setCreatedBy(Integer.parseInt(sessionuserid));
//				alumniDetails2.setCreatedDate(new Date());
//				alumniDetails2.setInstituteMap(userLogin.get().getRole_map());
//				alumniRepository.save(alumniDetails2);
//				jsonobjectout.put("status", "1");
//				jsonobjectout.put("message", "Alumni Details added Successfully");
//				returnstring = jsonobjectout.toJSONString();
//			} else {
//
//				Optional<TbAlumniDetails> tb_alumni_detail = alumniRepository.findById(alumniDetails2.getId());
//				if (tb_alumni_detail != null) {
//					TbAlumniDetails obj2 = tb_alumni_detail.get();
//					
//					if (uploadImage == null) {
//						obj2.setProfilePicture(obj2.getProfilePicture());
//						
//					}
//					obj2.setProfilePicture(alumniDetails2.getProfilePicture());
//					obj2.setCountryId(alumniDetails2.getCountryId());
//					obj2.setStateId(alumniDetails2.getStateId());
//					obj2.setCityId(alumniDetails2.getCityId());
//					obj2.setLine1(alumniDetails2.getLine1());
//					obj2.setLine2(alumniDetails2.getLine2());
//					obj2.setPincode(alumniDetails2.getPincode());
//					obj2.setInstituteMap(obj2.getInstituteMap());
//					obj2.setModifyBy(Integer.parseInt(sessionuserid));
//					obj2.setModifedDate(new Date());
//					obj2.setCreatedBy(obj2.getCreatedBy());
//					obj2.setCreatedDate(obj2.getCreatedDate());
//					obj2.setStatus(obj2.getStatus());
//					alumniRepository.save(obj2);
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("message", "Alumni Details updated Successfully");
//					returnstring = jsonobjectout.toJSONString();
//
//				} else {
//					jsonobjectout.put("status", "0");
//					jsonobjectout.put("message", "Please Select The Id For Update");
//					returnstring = jsonobjectout.toJSONString();
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			JSONObject jsonobjectout = new JSONObject();
//			jsonobjectout.put("status", "1");
//			jsonobjectout.put("message", e.getMessage());
//			returnstring = jsonobjectout.toJSONString();
//		}
//
//		return returnstring;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/admin/Loadalumnidetails", method = RequestMethod.POST, produces = { "application/json" })
//	public String Loadalumnidetails(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
//			String search, String order) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//
//		List<String> Columns = new ArrayList<String>();
//		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//
//		Pageable pageable = null;
//		int formcounter = 1;
//		try {
//
//			int orderId = 0;
//			String orderType = "desc";
//			if (!order.equalsIgnoreCase("")) {
//				String[] orderparts = order.split(",");
//				orderId = Integer.parseInt(orderparts[0]); // "1"
//				orderType = orderparts[1]; // "desc"
//			}
//
//			String sortyby = "createdBy";
//
//			if (orderId == 0) {
//				sortyby = "createdBy";
//			}
//
//			else if (orderId == 1) {
//				sortyby = "line1";
//			}
//
//			else if (orderId == 2) {
//				sortyby = "line2";
//			}
//
//			
//			else if (orderId == 3) {
//				sortyby = "countryId.countryName";
//			}
//
//			else if (orderId == 4) {
//				sortyby = "stateId.stateName";
//			}
//
//			else if (orderId == 5) {
//				sortyby = "cityId.cityName";
//			}
//			else if (orderId == 6) {
//				sortyby = "pincode";
//			}
//			else if (orderId == 7) {
//				sortyby = "rejectedRemarks";
//			}
//			
//			if (length == -1) {
//				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
//						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
//			} else {
//				pageable = PageRequest.of(pageno, length,
//						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
//			}
//
//			// Add Server Side Validation TODO
//
//			Page<TbAlumniDetails> tb_alumni_details = alumniRepository.LoadAlumniDetails(Integer.parseInt(sessionuserid),search, pageable);
//
//			int count = (int) tb_alumni_details.getPageable().getOffset();
//			count = count + 1;
//			List<TbAlumniDetails> tb_alumni_detail1 = tb_alumni_details.getContent();
//
//			File file = null;
//			for (int i = 0; i < tb_alumni_detail1.size(); i++) {
//
//				TbAlumniDetails tb_alumni_detail2 = tb_alumni_detail1.get(i);
//				JSONObject jsonObject2 = new JSONObject();
//
//				jsonObject2.put("srno", "<span class='avtar avatar-blue'>" + count + "</span>");
//				jsonObject2.put("line1", tb_alumni_detail2.getLine1());
//				jsonObject2.put("line2", tb_alumni_detail2.getLine2());
//				jsonObject2.put("countryId", tb_alumni_detail2.getCountryId().getCountryName());
//				jsonObject2.put("stateId", tb_alumni_detail2.getStateId().getStateName());
//				jsonObject2.put("cityId", tb_alumni_detail2.getCityId().getCityName());
//				jsonObject2.put("pincode", tb_alumni_detail2.getPincode());
//				jsonObject2.put("rejectedRemarks", tb_alumni_detail2.getRejectedRemarks());
//				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
//						+ "' value='" + AESGCM.encrypt(tb_alumni_detail2.getId() + "") + "' /> ";
//				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
//						+ AESGCM.encrypt(tb_alumni_detail2.getId() + "") + "' /> ";
//				jsonObject2.put("ShowImage",
//						"<a href=\"#\" class=\"btn btn-secondary document_status\">View</a> &nbsp" + hidden1);
//
//
//				String action = "<a href=\"#\" class=\"btn btn-primary icon-btn btnedit\" title=\"Edit\"><i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
//			              + " <a href=\"#\" class=\"btn btn-warning icon-btn btndelete\" title=\"Delete\"><i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i></a>";
//
//
//				jsonObject2.put("action", action);
//
//				jsonArray1.add(jsonObject2);
//				count++;
//				formcounter++;
//
//			}
//			jsonobjectout.put("status", "1");
//			jsonobjectout.put("data", jsonArray1);
//			jsonobjectout.put("message", "Data Load Successfully");
//			jsonobjectout.put("TotalCount", tb_alumni_details.getTotalElements());
//			returnstring = jsonobjectout.toJSONString();
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
//
//	@RequestMapping(value = "/admin/Getimageforalumni", method = RequestMethod.POST, produces = { "application/json" })
//	public String Getimageforalumni(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		//
////			List<String> Columns = new ArrayList<String>();
//		//
//		try {
//			JSONObject jsonObject2 = new JSONObject();
//			jsonObject = (JSONObject) jsonp.parse(data);
//
//			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//			if (id != 0) {
//
//				Optional<TbAlumniDetails> tb_journal1 = alumniRepository.findById(id);
//
//				TbAlumniDetails tb_journal2 = tb_journal1.get();
//
//				if (tb_journal2.getProfilePicture() != null) {
//
//					String path = tb_journal2.getProfilePicture();
//					String[] bits = path.split("\\.(?=[^\\.]+$)");
//
//					String docType = bits[bits.length - 1];
//					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
//							|| docType.equalsIgnoreCase("png")) {
//
//						String imagestr = imageEncoderDecoder(tb_journal2.getProfilePicture());
//						if (imagestr.equalsIgnoreCase("")) {
//							jsonObject2.put("mapid", tb_journal2.getId());
//							jsonObject2.put("DocumentImageType", docType);
//							jsonObject2.put("document", "Image is not uploaded");
//						} else {
//							jsonObject2.put("mapid", tb_journal2.getId());
//							jsonObject2.put("DocumentImageType", docType);
//							jsonObject2.put("document", imagestr);
//						}
//					} else if (docType.equalsIgnoreCase("pdf")) {
//
//						String imagestr = imageEncoderDecoder(tb_journal2.getProfilePicture());
//
//						if (imagestr.equalsIgnoreCase("")) {
//							jsonObject2.put("mapid", tb_journal2.getId());
//							jsonObject2.put("DocumentImageType", docType);
//							jsonObject2.put("document", "Image is not uploaded");
//						} else {
//							jsonObject2.put("mapid", tb_journal2.getId());
//							jsonObject2.put("DocumentImageType", docType);
//							jsonObject2.put("document", imagestr);
//						}
//
//					} else {
//						jsonObject2.put("mapid", tb_journal2.getId());
//						jsonObject2.put("DocumentImageType", docType);
//
//						jsonObject2.put("document", "");
//					}
//
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("data", jsonObject2);
//					jsonobjectout.put("message", "Data Load Successfully");
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
//
//	public String imageEncoderDecoder(String imagepath) throws IOException {
//		String imageString = "";
//		// image path declaration
//		// String imgPath = "src/main/resources/images/bean.png";
//
//		// read image from file
//		try {
//			FileInputStream stream = new FileInputStream(imagepath);
//
//			// get byte array from image stream
//			int bufLength = 2048;
//			byte[] buffer = new byte[2048];
//			byte[] data;
//
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			int readLength;
//			while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
//				out.write(buffer, 0, readLength);
//			}
//
//			data = out.toByteArray();
//			imageString = Base64.getEncoder().withoutPadding().encodeToString(data);
//
//			out.close();
//			stream.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return imageString;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/admin/DeleteAlumni", method = RequestMethod.POST, produces = { "application/json" })
//	public String DeleteAlumni(@RequestBody String data, HttpServletRequest request) {
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
//			if (jsonObject.get("id") != null) {
//
//				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//				Optional<TbAlumniDetails> obj = alumniRepository.findById(id);
//
//				if (obj != null) {
//					TbAlumniDetails obj2 = obj.get();
//					obj2.setStatus("0");
//					alumniRepository.delete(obj2);
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("message", "Data Deleted Successfully");
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
//
//		return returnstring;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/admin/getAlumniforUpdate", method = RequestMethod.POST, produces = {
//			"application/json" })
//	public String getAlumniforUpdate(@RequestBody String data, HttpServletRequest request) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//
//		String returnstring = "";
//		try {
//			jsonObject = (JSONObject) jsonp.parse(data);
//
//			if (jsonObject.get("id") != null) {
//
//				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//
//				TbAlumniDetails tbHallOfFame = new TbAlumniDetails();
//				Optional<TbAlumniDetails> alumni = alumniRepository.findById(id);
//				if (alumni != null) {
//					tbHallOfFame = alumni.get();
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("profilePicture", tbHallOfFame.getProfilePicture());
//					jsonobjectout.put("line1", tbHallOfFame.getLine1());
//					jsonobjectout.put("line2", tbHallOfFame.getLine2());
//					jsonobjectout.put("countryId", tbHallOfFame.getCountryId().getId());
//					jsonobjectout.put("stateId", tbHallOfFame.getStateId().getId());
//					jsonobjectout.put("cityId", tbHallOfFame.getCityId().getId());
//					jsonobjectout.put("pincode", tbHallOfFame.getPincode());
//					jsonobjectout.put("docid", AESGCM.encrypt(tbHallOfFame.getId() + ""));
//					jsonobjectout.put("id", tbHallOfFame.getId());
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
//
//		return returnstring;
//	}
//
//}