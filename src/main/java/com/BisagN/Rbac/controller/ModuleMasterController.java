package com.BisagN.Rbac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.controller.AESGCM;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.repository.ModuleMasterRepository;
import com.BisagN.repository.RoleRepository;

import org.springframework.data.domain.Sort;
@Controller
public class ModuleMasterController {

	@Autowired
	ModuleMasterRepository moduleMasterRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/admin/ModuleMaster", method = RequestMethod.GET)
	public ModelAndView ModuleMaster(ModelMap Mmap, HttpSession session, HttpServletRequest request,
			Model model) {
		ModelAndView model1 = new ModelAndView();
		String roleid = session.getAttribute("roleid").toString();
	      
		/*
		 * List val = roleRepository.ScreenRedirect("ModuleMaster",
		 * Integer.parseInt(roleid)); Integer val1 = val.size(); // val1 = true; String
		 * msg = null; try { if (val1 == 0) { model.addAttribute("errorMessage",
		 * "You are not authorized to access this Page!!!!"); return new
		 * ModelAndView("loginError"); } else { } if (request.getHeader("Referer") ==
		 * null) { msg = ""; }
		 * 
		 * } catch (Exception e) { // Handle exception } Mmap.put("msg", msg);
		 */
		model1.setViewName("ModuleMaster");
		return model1;
		
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadModuleData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadModuleData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search,String order) {

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
			if(!order.equalsIgnoreCase("")) {
				String[] orderparts = order.split(",");
				orderId = Integer.parseInt(orderparts[0]); // "1"
				orderType = orderparts[1]; // "desc"
			}

			String sortyby = "created_date";
			if (orderId == 0) {
				sortyby = "created_date";
			}
			else if (orderId == 1) {
				sortyby = "module_name";
			}
			
			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE, Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
				
			} else {
				pageable = PageRequest.of(pageno, length, Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			System.out.println("pageno" + pageno + "search" + search);
			System.out.println("pageable"+pageable);
			
			// Add Server Side Validation TODO
			
			Page<TB_LDAP_MODULE_MASTER> object3 = moduleMasterRepository.LoadModuleData(search.toLowerCase(),pageable);
			
			int count = (int) object3.getPageable().getOffset();
			count = count + 1;
			
			List<TB_LDAP_MODULE_MASTER> object4 = object3.getContent();

			for (int i = 0; i < object4.size(); i++)
			{
				
				TB_LDAP_MODULE_MASTER object = object4.get(i);
				JSONObject jsonObject2 = new JSONObject();

				jsonObject2.put("srno", count);
				jsonObject2.put("modulename", object.getModule_name());

				
				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(object.getId() + "") + "' /> ";
				
				
				jsonObject2.put("action", "<button type=\"button\"\n"
						+ "class=\"btn btn-primary icon-btn btnedit edit_module\" title=\"Edit\">\n"
						+ "<i class=\"ri-pencil-fill\"></i></button> <button type=\"button\"class=\"btn btn-warning icon-btn btndelete delete_module\"\n"
						+ "title=\"Delete\"><i class=\"ri-delete-bin-2-fill\"></i></button>" +hidden);
				
				
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
	@RequestMapping(value = "/admin/SaveModuleMasterData", method = RequestMethod.POST, produces = { "application/json" })
	public String SaveModuleMasterData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			String actiontype = jsonObject.get("actiontype").toString();

			
			System.err.println("===actiontype====="+actiontype);
			String modulename = "";
			if (jsonObject.get("modulename") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Enter Module Name");
				return jsonobjectout.toJSONString();
			} else {
				modulename = jsonObject.get("modulename").toString().trim();
				modulename = jsonObject.get("modulename").toString().toUpperCase();
				if (modulename.length() < 2) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Module Name must be of atleast 2 letters.");
					return jsonobjectout.toJSONString();
				} else {
					if (!modulename.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")) {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Module Name contains Letter and Digits only");
						return jsonobjectout.toJSONString();
					}
				}
				
			}
		
			boolean Checkmodulenameexist = false;
			List moduleexistcheck = moduleMasterRepository.CheckModuleNameexist(modulename);
			if (actiontype.equalsIgnoreCase("add")) {
				if (moduleexistcheck.isEmpty()) {
					Checkmodulenameexist = true;
				}
			} else {
				if (moduleexistcheck.isEmpty() || moduleexistcheck.size() == 1) {
					Checkmodulenameexist = true;
				}
			}
			if (Checkmodulenameexist) {

				TB_LDAP_MODULE_MASTER module = new TB_LDAP_MODULE_MASTER();

				module.setModule_name(modulename);

				if (actiontype.equalsIgnoreCase("add")) {

					moduleMasterRepository.save(module);
					jsonobjectout.put("message", "Data Saved Successfully");
					jsonobjectout.put("status", "1");

					returnstring = jsonobjectout.toJSONString();
				} else {

					TB_LDAP_MODULE_MASTER moduleupdate = moduleMasterRepository.getById(Integer.parseInt(jsonObject.get("moduleid").toString()));
					if (moduleupdate != null) {
						moduleupdate.setModule_name(modulename);
						moduleMasterRepository.save(moduleupdate);
						jsonobjectout.put("message", "Data Updated Successfully");
						jsonobjectout.put("status", "1");

						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Module ID Not Found");
						returnstring = jsonobjectout.toJSONString();
					}

				}

			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Module Name already exist");
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
	@RequestMapping(value = "/admin/DeleteModuleData", method = RequestMethod.POST, produces = { "application/json" })
	public String DeleteModuleData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("moduleid") != null) {

				int moduleid = Integer.parseInt(AESGCM.decrypt(jsonObject.get("moduleid").toString()));
				TB_LDAP_MODULE_MASTER master = moduleMasterRepository.getById(moduleid);
				if (master != null) {
					moduleMasterRepository.delete(master);
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
//		System.out.println("Output-->" + returnstring);

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/GetModuleDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetModuleDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("moduleid") != null) {

				int moduleid = Integer.parseInt(AESGCM.decrypt(jsonObject.get("moduleid").toString()));
				System.out.println("yyyyyyyyyyyyyy"+moduleid);
				TB_LDAP_MODULE_MASTER tb_LDAP_MODULE_MASTER = moduleMasterRepository.getById(moduleid);
				if (tb_LDAP_MODULE_MASTER != null) {
					jsonobjectout.put("status", "1");
					jsonobjectout.put("modulename", tb_LDAP_MODULE_MASTER.getModule_name());
					
					jsonobjectout.put("moduleid", tb_LDAP_MODULE_MASTER.getId());
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

}
