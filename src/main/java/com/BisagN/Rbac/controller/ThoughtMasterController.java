package com.BisagN.Rbac.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.controller.AESGCM;
import com.BisagN.controller.ImageValidationController;

import com.BisagN.models.TbThoughtDtl;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.ThoughtMasterRepository;


@RestController
@EnableScheduling
public class ThoughtMasterController {

	public static String thought = "";

	@Autowired
	ThoughtMasterRepository ThoughtMasterRepositorynr;
	
	@Autowired
	RoleRepository roleRepository;

	public ImageValidationController imageValidationController = new ImageValidationController();

//	@RequestMapping(value = "/admin/Thoughtoftheday", method = RequestMethod.GET)
//	public ModelAndView Thoughtoftheday() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("Thoughtoftheday");
//		return model;
//	}
	
	@RequestMapping(value = "/admin/Thoughtoftheday", method = RequestMethod.GET)
	public ModelAndView Thoughtoftheday(HttpSession session, HttpServletRequest request, ModelMap Mmap, Model model1) {
		ModelAndView model = new ModelAndView();

		String roleid = session.getAttribute("roleid").toString();
		List val = roleRepository.ScreenRedirect("/Thoughtoftheday", Integer.parseInt(roleid));
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
		model.setViewName("Thoughtoftheday");
		return model;
	}
	@ResponseBody
	@RequestMapping(value = "/admin/SaveThoughtData", method = RequestMethod.POST, produces = { "application/json" })
	public String SaveThoughtData(HttpServletRequest request, @RequestBody String data) {
		JSONArray jsonp = new JSONArray();
		JSONObject object = new JSONObject();
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		ImageValidationController imageValidationController = new ImageValidationController();
		String res = "";
		try {

			System.err.println("Data" + data);
			object = (JSONObject) jsonparser.parse(data);

			res = SaveThoughtOfthedayData(object, request);
		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout = new JSONObject();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Something went wrong");
			res = jsonobjectout.toJSONString();
		}

		return res;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/UploadExcelForThoughtOfDay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String UploadExcelForThoughtOfDay(HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();

		JSONObject responsedata = new JSONObject();
		JSONArray jSONArray = new JSONArray();
		JSONParser jsonParser = new JSONParser();
		JSONObject responsedata1 = new JSONObject();

		String response = "";
		try {
			JSONArray sheetArray = new JSONArray();
			String checkDoc = "";
			ArrayList<String> columnNames = new ArrayList<String>();

			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile fileDoc = multipartRequest.getFile("uploadDocument");
				String documentAttachmentName = multipartRequest.getParameter("documentAttachmentName");
				String uploadDocName = multipartRequest.getParameter("uploadedDocumentName");
				String attachmentName = multipartRequest.getParameter("attachmentName");
				ImageValidationController imageValidationController = new ImageValidationController();
				if (fileDoc.getSize() != 0) {
					checkDoc = imageValidationController.checkFileFormats(fileDoc, uploadDocName, "xls");
					if (checkDoc.equalsIgnoreCase("Success")) {
						DataFormatter formatter = new DataFormatter();
						HSSFWorkbook wb = new HSSFWorkbook(fileDoc.getInputStream());
						// creating a Sheet object to retrieve the object
						HSSFSheet sheet = wb.getSheetAt(0);
						// evaluating cell type
						FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
						for (Row row : sheet) // iteration over row using for each loop
						{

							if (!isRowEmpty(row)) {
								JSONObject jsonObject = new JSONObject();
								if (row.getRowNum() != 0) {
									for (int j = 0; j < columnNames.size(); j++) {
										row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
										if (row.getCell(j) != null) {
											if (row.getCell(j).getCellTypeEnum() == CellType.STRING) {
												jsonObject.put(columnNames.get(j), row.getCell(j).getStringCellValue());
											} else if (row.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
												jsonObject.put(columnNames.get(j),
														row.getCell(j).getNumericCellValue());
											} else if (row.getCell(j).getCellTypeEnum() == CellType.BOOLEAN) {
												jsonObject.put(columnNames.get(j),
														row.getCell(j).getBooleanCellValue());
											} else if (row.getCell(j).getCellTypeEnum() == CellType.BLANK) {
												jsonObject.put(columnNames.get(j), "");
											}
										} else {
											jsonObject.put(columnNames.get(j), "");
										}

									}

									sheetArray.add(jsonObject);
								} else {
									// store column names
									for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
										columnNames.add(row.getCell(k).getStringCellValue());
									}
								}
							}

						}
//						System.out.println("sheetArray" + sheetArray.toJSONString());
						int count = 2;
						outer: for (int i = 0; i < sheetArray.size(); i++) {
//
							JSONObject object = (JSONObject) sheetArray.get(i);
							object.put("actiontype", "add");
							response = SaveThoughtOfthedayData(object, request);
							JSONObject jsonObject = (JSONObject) jsonParser.parse(response);

							if (jsonObject.get("status").toString().equalsIgnoreCase("0")) {
								String message = jsonObject.get("message").toString();
								jsonObject.put("message", message + " on " + count + " Row");
								response = jsonObject.toJSONString();
								break outer;
							}
							count++;

						}

					} else {
						responsedata.put("status", "0");
						responsedata.put("message", checkDoc);
						response = responsedata.toJSONString();

					}
				} else {
					responsedata.put("status", "0");
					responsedata.put("message", "Please Choose File");
					response = responsedata.toJSONString();
				}
			}

		} catch (Exception e) {
			responsedata.put("status", "0");
			responsedata.put("message", "Error");
			response = responsedata.toJSONString();
			e.printStackTrace();

		}
		return response;
	}

	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

	public String SaveThoughtOfthedayData(JSONObject object, HttpServletRequest request1) {
		JSONObject jsonobjectout = new JSONObject();
		ImageValidationController imageValidationController = new ImageValidationController();
		JSONParser jsonp = new JSONParser();
		String sessionuserid = request1.getSession().getAttribute("userId_for_jnlp").toString();
		TbThoughtDtl tbThoughtDtl = new TbThoughtDtl();
		JSONObject jsonObject = new JSONObject();
		String returnstring = "";
		try {
			if (object.get("id") != null) {
				Integer tb_thought_dtl = Integer.parseInt(object.get("id").toString());
				tbThoughtDtl.setId(tb_thought_dtl);
//				System.out.println("IDDDD" + object.get("id").toString());
			}
			List CheckThoughtsexist = ThoughtMasterRepositorynr
					.CheckThoughtsexist(object.get("thoughtOfDay").toString().trim().toLowerCase());

			if (tbThoughtDtl.getId() != null && tbThoughtDtl.getId() != 0 && tbThoughtDtl.getId() != -1) {
				Optional<TbThoughtDtl> tbThoughtDtl1 = ThoughtMasterRepositorynr.findById(tbThoughtDtl.getId());
				if (tbThoughtDtl1 != null) {
					TbThoughtDtl obj2 = tbThoughtDtl1.get();
					if (CheckThoughtsexist.isEmpty() || obj2.getThoughtOfDay().toLowerCase()
							.equalsIgnoreCase(object.get("thoughtOfDay").toString().toLowerCase())) {
					
						tbThoughtDtl.setThoughtOfDay(object.get("thoughtOfDay").toString());
						tbThoughtDtl.setStatus(obj2.getStatus());
						tbThoughtDtl.setCreatedBy(obj2.getCreatedBy());
						tbThoughtDtl.setCreatedDate(obj2.getCreatedDate());
						tbThoughtDtl.setModifyBy(Integer.parseInt(sessionuserid));
						tbThoughtDtl.setModifyDate(new Date());
						ThoughtMasterRepositorynr.save(tbThoughtDtl);
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Details updated Successfully");
						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "1");
						jsonobjectout.put("message", "Thoughts already exist");
						returnstring = jsonobjectout.toJSONString();

					}

				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select The Id For Update");
					returnstring = jsonobjectout.toJSONString();
				}
			} else {
				if (CheckThoughtsexist.isEmpty()) {
					tbThoughtDtl.setThoughtOfDay(object.get("thoughtOfDay").toString());
					tbThoughtDtl.setStatus('1');
					tbThoughtDtl.setCreatedBy(Integer.parseInt(sessionuserid));
					tbThoughtDtl.setCreatedDate(new Date());
					ThoughtMasterRepositorynr.save(tbThoughtDtl);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Thought Details added Successfully");
					returnstring = jsonobjectout.toJSONString();
				} else {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Thoughts already exist");
					returnstring = jsonobjectout.toJSONString();
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}

		System.out.println("Thought Output-->" + returnstring);

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadThoughtData", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadThoughtData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		List<String> Columns = new ArrayList<String>();
		Pageable pageable = null;
		int formcounter = 1;
		try {
			// Add Server Side Validation TODO

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE);
			} else {
				pageable = PageRequest.of(pageno, length);
			}
			Page<TbThoughtDtl> object3 = ThoughtMasterRepositorynr.LoadData(pageable);

			int count = (int) object3.getPageable().getOffset();
			count = count + 1;

			List<TbThoughtDtl> object4 = object3.getContent();

			for (int i = 0; i < object4.size(); i++) {

				TbThoughtDtl object = object4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", "<span class='avtar avatar-blue'>" + count + "</span>");
				jsonObject2.put("name", object.getThoughtOfDay());

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(object.getId() + "") + "' /> ";

				jsonObject2.put("action",
						"<a href=\"#\" ><i class=\"las la-edit mr-0 text-center edit_thought\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp"
								+ " <a href=\"#\" ><i class=\"fa fa-trash delete_thought\" aria-hidden=\"true\"></i></a>"
								+ hidden);

				jsonArray1.add(jsonObject2);
				count++;
				formcounter++;

			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", object3.getTotalElements());
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}
		System.out.println("Data Load Output-->" + returnstring);

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/GetThoughtDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetThoughtDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();

		String returnstring = "";
		try {
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));

				TbThoughtDtl tbThoughtDtl = new TbThoughtDtl();
				Optional<TbThoughtDtl> thought_dtl = ThoughtMasterRepositorynr.findById(id);
				if (thought_dtl != null) {
					tbThoughtDtl = thought_dtl.get();
					jsonobjectout.put("status", "1");
					jsonobjectout.put("thoughtoftheday", tbThoughtDtl.getThoughtOfDay());
					jsonobjectout.put("id", tbThoughtDtl.getId());
					System.out.println("DATATHOUGHT" + tbThoughtDtl.getThoughtOfDay());
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
		System.out.println("Output-->" + returnstring);

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/DeleteThoughtData", method = RequestMethod.POST, produces = { "application/json" })
	public String DeleteThoughtData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {

			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("id") != null) {

				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
				Optional<TbThoughtDtl> obj = ThoughtMasterRepositorynr.findById(id);

				if (obj != null) {
					TbThoughtDtl obj2 = obj.get();
					obj2.setStatus('0');
					obj2.setModifyBy(null);
					obj2.setModifyDate(new Date());
					ThoughtMasterRepositorynr.delete(obj2);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Data Deleted Successfully");
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
		System.out.println("Output-->" + returnstring);

		return returnstring;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put(fieldName, errorMessage);
			jsonArray.add(jsonObject1);
		});
		jsonObject.put("status", "0");
		jsonObject.put("message", jsonArray.toJSONString());
		return jsonArray.toJSONString();
	}

	@Scheduled(cron = "0 0 0 * * ?")	
	public void ScheduleCronForThoughts() {
		String cronthought = ThoughtMasterRepositorynr.findRandamthoughts();
		System.out.println("CRON Execute and Message " + cronthought);
		thought = cronthought;

	}

}
