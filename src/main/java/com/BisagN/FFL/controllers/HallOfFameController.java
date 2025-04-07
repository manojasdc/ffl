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

import com.BisagN.FFL.models.TbCountryName;
import com.BisagN.FFL.models.TbHallOfFame;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.HallOfFameRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;

import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.UserLoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HallOfFameController {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	HallOfFameRepository hallOfFameRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RoleRepository roleRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();

	// IMAGE
	private String pathforhallofFame;

	@Value("${pathforHallofFame}")
	public void pathforHallofFameImage(String pathforhallofFame) {
		this.pathforhallofFame = pathforhallofFame;
	}

//	@RequestMapping(value = "/admin/addhallOfFame", method = RequestMethod.GET)
//	public ModelAndView Ejournal(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
//		ModelAndView model1 = new ModelAndView();
//		String rolename = request.getSession().getAttribute("role").toString();
//		if (rolename.equalsIgnoreCase("ADMIN")) {
//			Mmap.put("dashboardurl", "instituteDashboard");
//		}
//		model1.setViewName("addhallOfFame");
//		return model1;
//	}

	@RequestMapping(value = "/admin/addhallOfFame", method = RequestMethod.GET)
	public ModelAndView addhallOfFame(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/addhallOfFame", Integer.parseInt(roleid));
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
		model.setViewName("addhallOfFame");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getCountry", method = RequestMethod.POST, produces = { "application/json" })
	public String getCountry(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TbCountryName> list1 = countryRepository.LoadCountryData();

			if (!list1.isEmpty()) {

				for (TbCountryName tbCountryName : list1) {
					object = new JSONObject();

					object.put("id", tbCountryName.getId());
					object.put("code", tbCountryName.getCountry_code());
					object.put("country_name", tbCountryName.getCountryName());
					jSONArray.add(object);
				}
				object1.put("countrylist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("countrylist", jSONArray);
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

	@RequestMapping(value = "/admin/saveHallOfFame", method = RequestMethod.POST, produces = { "application/json" })
	public String saveHallOfFame(@Valid @RequestParam("halloffamedetail") String tbhallOfFame,
			HttpServletRequest request,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage)
			throws IOException, DecoderException, ParseException {

		JSONArray jSONArray = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonobject = new JSONObject();

		String actionType = request.getHeader("X-Action-Type");
		JSONObject jsonNodes1 = (JSONObject) jsonParser.parse(tbhallOfFame);
		Integer id = 0;
		if (actionType.equalsIgnoreCase("update")) {
			id = Integer.parseInt(AESGCM.decrypt(jsonNodes1.get("id").toString()));
			jsonNodes1.put("id", id);
		}

		TbHallOfFame hallOfFame = mapper.readValue(jsonNodes1.toString(), TbHallOfFame.class);

//		TbHallOfFame hallOfFame = mapper.readValue(tbhallOfFame, TbHallOfFame.class);
		String roleName = request.getSession().getAttribute("role").toString();
		String returnstring = "";

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<TbHallOfFame>> constraintViolations = validator.validate(hallOfFame);

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

//		String actiontype = jsonobject.get("actiontype").toString();

		try {

			JSONObject jsonobjectout = new JSONObject();

			if (hallOfFame.getId() == null || hallOfFame.getId() == 0) {
				if (uploadImage == null) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Photo is mandatory");
					return jsonobjectout.toJSONString();
				}
			}

			if (uploadImage != null) {
				if (uploadImage.getSize() > 2097152) { // 2097152 bytes = 2 MB
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Upload Image size must be less than or equal to 2 MB.");
					return jsonobjectout.toJSONString();
				}
			}

			if (uploadImage != null) {
				String message = imageValidationController.checkFileFormats(uploadImage,
						uploadImage.getOriginalFilename(), "image");

				if (!message.equalsIgnoreCase("success")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", message + "  Photo");
					return jsonobjectout.toJSONString();
				} else {
				}
			} else {
			}

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String photo1 = "";

			if (uploadImage != null) {
				byte[] bytes = uploadImage.getBytes();

				File dir = new File(pathforhallofFame);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String curdate = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
				String filename = uploadImage.getOriginalFilename();
				String photoname = dir.getAbsolutePath() + File.separator + filename;
				File serverFile = new File(photoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				photo1 = photoname;
				hallOfFame.setPhoto(photoname);
			}
//				List checkhalloffameExists = hallOfFameRepository.checkhalloffameExists(hallOfFame.getAchievement().toLowerCase().trim());

//				if (checkhalloffameExists.isEmpty()) {

			if (hallOfFame.getId() == null || hallOfFame.getId() == 0) {

				Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
				hallOfFame.setPhoto(hallOfFame.getPhoto());
				hallOfFame.setAchievement(hallOfFame.getAchievement());
				hallOfFame.setInstituteMap(userLogin.get().getRole_map());
				hallOfFame.setStatus("1");
				hallOfFame.setCreatedBy(Integer.parseInt(sessionuserid));
				hallOfFame.setCreatedDate(new Date());

				if (roleName.equalsIgnoreCase("USER")) {
					hallOfFame.setInstituteMap(userLogin.get().getRole_map());
				} else {
					hallOfFame.setInstituteMap(Integer.parseInt(sessionuserid));
				}
				hallOfFameRepository.save(hallOfFame);

				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "Hall Of fame Details submitted Successfully");
				returnstring = jsonobjectout.toJSONString();
			} else {

				Optional<TbHallOfFame> tb_hall_of_fame = hallOfFameRepository.findById(hallOfFame.getId());

				if (tb_hall_of_fame != null) {

					TbHallOfFame halloffamedtll = tb_hall_of_fame.get();

					if (halloffamedtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
						TbHallOfFame obj2 = tb_hall_of_fame.get();

						if (uploadImage == null) {
							hallOfFame.setPhoto(obj2.getPhoto());
							// tbStaffPayinfo.setp(tbStaffPayinfo.getph());

						}
						hallOfFame.setPhoto(hallOfFame.getPhoto());
						hallOfFame.setAchievement(hallOfFame.getAchievement());
						hallOfFame.setInstituteMap(obj2.getInstituteMap());
						hallOfFame.setModifyBy(Integer.parseInt(sessionuserid));
						hallOfFame.setModifedDate(new Date());
						hallOfFame.setCreatedBy(obj2.getCreatedBy());
						hallOfFame.setCreatedDate(obj2.getCreatedDate());
						hallOfFame.setStatus(obj2.getStatus());
						hallOfFameRepository.save(hallOfFame);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Hall Of Fame Details updated Successfully");
						returnstring = jsonobjectout.toJSONString();

					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Unauthorized Access");
						jsonobjectout.put("error", "Unauthorized Access"); // Add this line

						returnstring = jsonobjectout.toJSONString();
					}

				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select The Id For Update");
					returnstring = jsonobjectout.toJSONString();
				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			JSONObject jsonobjectout = new JSONObject();
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadhallOfFame", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadhallOfFame(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
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
				sortyby = "achievement";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}

			Page<TbHallOfFame> tbHallOffame = hallOfFameRepository.LoadHallOfFame(Integer.parseInt(sessionuserid),
					search.toLowerCase(), pageable);

			int count = (int) tbHallOffame.getPageable().getOffset();
			count = count + 1;
			List<TbHallOfFame> hallOfFames = tbHallOffame.getContent();

			File file = null;
			for (int i = 0; i < hallOfFames.size(); i++) {

				TbHallOfFame tbHallOfFame = hallOfFames.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("achievement", tbHallOfFame.getAchievement());
				jsonObject2.put("rejectedRemarks", tbHallOfFame.getRejectedRemarks());
				String hidden1 = "<input type='hidden' name='hida" + formcounter + "' id='hida" + formcounter
						+ "' value='" + AESGCM.encrypt(tbHallOfFame.getId() + "") + "' /> ";
				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid' value='"
						+ AESGCM.encrypt(tbHallOfFame.getId() + "") + "' /> ";
//				jsonObject2.put("ShowImage",
//						"<a href=\"#\" class=\"btn btn-secondary document_status\">View</a> &nbsp" + hidden1);
				jsonObject2.put("ShowImage", "<li class=\"list-inline-item\">"
						+ "<button type=\"button\" class=\"btn btn-secondary icon-btn btnview document_status\" title=\"View\">"
						+ "<i class=\"ri-eye-fill\"></i>" + "</button>" + "</li>" + hidden1);

//				String action = "<a href=\"#\" ><i class=ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
//						+ " <a href=\"#\" ><i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i></a>";

//				String action = "<a href=\"#\" class=\"btn btn-primary icon-btn btnedit\" title=\"Edit\"><i class=\"ri-edit-2-fill edit_imagedata\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
//			              + " <a href=\"#\" class=\"btn btn-warning icon-btn btndelete\" title=\"Delete\"><i class=\"ri-delete-bin-2-fill delete_imagedata\" aria-hidden=\"true\"></i></a>";
				String action = "<ul class=\"list-inline custom-btn-group\">"
						+ "			<li class=\"list-inline-item\">"
						+ "				<a href=\"#\" class=\"btn btn-primary icon-btn btnedit edit_imagedata\" title=\"Edit\">"
						+ "					<i class=\"ri-edit-2-fill\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "			<li class=\"list-inline-item\">"
						+ " 			<a href=\"#\" class=\"btn btn-warning icon-btn btndelete delete_imagedata\">"
						+ "					<i class=\"ri-delete-bin-2-fill\" aria-hidden=\"true\"></i>"
						+ "				</a>" + "			</li>" + "		</ul>";
				jsonObject2.put("action", action);

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", tbHallOffame.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@RequestMapping(value = "/admin/Getimage", method = RequestMethod.POST, produces = { "application/json" })
	public String Getimage(@RequestBody String data, HttpServletRequest request) throws ParseException, IOException {
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

			int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
			if (id != 0) {

				Optional<TbHallOfFame> tb_journal1 = hallOfFameRepository.findById(id);

				TbHallOfFame tb_journal2 = tb_journal1.get();
				TbHallOfFame halloffamedtll = tb_journal1.get();

				if (halloffamedtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {
					if (tb_journal2.getPhoto() != null) {

						String path = tb_journal2.getPhoto();
						String[] bits = path.split("\\.(?=[^\\.]+$)");

						String docType = bits[bits.length - 1];
						if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg")
								|| docType.equalsIgnoreCase("png")) {

							String imagestr = imageEncoderDecoder(tb_journal2.getPhoto());
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

							String imagestr = imageEncoderDecoder(tb_journal2.getPhoto());

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
	@RequestMapping(value = "/admin/DeleteHallOfFame", method = RequestMethod.POST, produces = { "application/json" })
	public String DeleteHallOfFame(@RequestBody String data, HttpServletRequest request) {

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
				Optional<TbHallOfFame> obj = hallOfFameRepository.findById(id);

				if (obj != null) {
					TbHallOfFame halloffamedtll = obj.get();

					if (halloffamedtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

						TbHallOfFame obj2 = obj.get();
						obj2.setStatus("0");
						hallOfFameRepository.delete(obj2);
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
		System.out.println("Output-->" + returnstring);

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/GetHallOfFameForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetHallOfFameForUpdate(@RequestBody String data, HttpServletRequest request) {

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

				TbHallOfFame tbHallOfFame = new TbHallOfFame();
				Optional<TbHallOfFame> alumni = hallOfFameRepository.findById(id);
				if (alumni != null) {

					tbHallOfFame = alumni.get();

					TbHallOfFame halloffamedtll = alumni.get();

					if (halloffamedtll.getCreatedBy().equals(Integer.parseInt(sessionuserid))) {

						tbHallOfFame = alumni.get();
						jsonobjectout.put("status", "1");
						jsonobjectout.put("achievement", tbHallOfFame.getAchievement());
						jsonobjectout.put("docid", AESGCM.encrypt(tbHallOfFame.getId() + ""));
						jsonobjectout.put("id", AESGCM.encrypt(tbHallOfFame.getId() + ""));
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