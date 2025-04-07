package com.BisagN.Rbac.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_ROLE_TYPE;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;
import com.BisagN.repository.ModuleMasterRepository;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.RoleTypeRepository;
import com.BisagN.repository.SubModuleMasterRepository;

@Controller
public class SubModuleMaster {

	@Autowired
	ModuleMasterRepository moduleMasterRepository;

	@Autowired
	SubModuleMasterRepository subModuleMasterRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/admin/SubModuleMaster", method = RequestMethod.GET)
	public ModelAndView SubModuleMaster(ModelMap Mmap, HttpSession session, HttpServletRequest request,
			Model model) {
		
		ModelAndView model1 = new ModelAndView();
		String roleid = session.getAttribute("roleid").toString();
	      
		/*
		 * List val = roleRepository.ScreenRedirect("SubModuleMaster",
		 * Integer.parseInt(roleid)); Integer val1 = val.size(); // val1 = true; String
		 * msg = null; try { if (val1 == 0) { model.addAttribute("errorMessage",
		 * "You are not authorized to access this Page!!!!"); return new
		 * ModelAndView("loginError"); } else { } if (request.getHeader("Referer") ==
		 * null) { msg = ""; }
		 * 
		 * } catch (Exception e) { // Handle exception } Mmap.put("msg", msg);
		 */
		model1.setViewName("SubModuleMaster");
		return model1;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getModuleName", method = RequestMethod.POST, produces = { "application/json" })
	public String getModuleName(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			System.out.println("dsg");
			List<TB_LDAP_MODULE_MASTER> list1 = moduleMasterRepository.LoadModuleDataList();

			System.out.println("list1.size()" + list1.size());
			if (!list1.isEmpty()) {

				for (TB_LDAP_MODULE_MASTER tb_LDAP_MODULE_MASTER : list1) {
					object = new JSONObject();

					object.put("id", tb_LDAP_MODULE_MASTER.getId());
					object.put("name", tb_LDAP_MODULE_MASTER.getModule_name());
					jSONArray.add(object);
				}
				object1.put("modulelist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("modulelist", jSONArray);
			}

			object1.put("Status", "1");
			object1.put("Message", "Success");

		} catch (Exception e) {
			e.printStackTrace();
			object1 = new JSONObject();
			object1.put("Status", "0");
			object1.put("Message", "Something went wrong");
		}
		System.out.println("object1.toJSONString()" + object1.toJSONString());
		return object1.toJSONString();
	}

	@ResponseBody
	@RequestMapping(value = "/admin/LoadSubModuleMasterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadSubModuleMasterData(HttpServletRequest request, @RequestParam int pageno,
			@RequestParam int length, String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

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

			String sortyby = "mm.module_name";

			if (orderId == 1) {
				sortyby = "mm.module_name";
			}
			else if(orderId ==2) {
				sortyby = "submodule_name";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			System.out.println("pageno" + pageno + "search" + search);
			System.out.println("pageable" + pageable);

//			if (length == -1) {
//				pageable = PageRequest.of(pageno, Integer.MAX_VALUE);
//			} else {
//				pageable = PageRequest.of(pageno, length);
//			}
			// Add Server Side Validation TODO
			List<Map<String, Object>> sublist = subModuleMasterRepository.LoadSubModuleDataList(search.toLowerCase(),pageable);
			int accmst3 = subModuleMasterRepository.LoadSubModuleDataListCount(search.toLowerCase());
			int counter = (int) pageable.getOffset();
			counter = counter + 1;
			for (int i = 0; i < sublist.size(); i++) {

				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("srno", counter);
				jsonObject2.put("modulename", sublist.get(i).get("module_name"));
				jsonObject2.put("submodulename", sublist.get(i).get("submodule_name"));
//				jsonObject2.put("action", "");

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(sublist.get(i).get("id") + "") + "' /> ";

				jsonObject2.put("action", "<button type=\"button\"\n"
						+ "																class=\"btn btn-primary icon-btn btnedit edit_module\" title=\"Edit\">\n"
						+ "																<i class=\"ri-pencil-fill\"></i>\n"
						+ "															</button> <button type=\"button\"\n"
						+ "																class=\"btn btn-warning icon-btn btndelete delete_module\"\n"
						+ "																title=\"Delete\">\n"
						+ "																<i class=\"ri-delete-bin-2-fill\"></i>\n"
						+ "															</button>" + hidden);

				jsonArray1.add(jsonObject2);
				counter++;
				formcounter++;
			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Saved Successfully");
			jsonobjectout.put("TotalCount", accmst3);
			returnstring = jsonobjectout.toJSONString();
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
	@RequestMapping(value = "/admin/SaveSubModuleMasterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String SaveSubModuleMasterData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			String actiontype = jsonObject.get("actiontype").toString();

			String submodname = "";
			if (jsonObject.get("submodname") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Enter Sub Module Name");
				return jsonobjectout.toJSONString();
			} else {
				submodname = jsonObject.get("submodname").toString().trim();
				submodname = jsonObject.get("submodname").toString().toUpperCase();
				if (submodname.length() < 2) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Sub Module Name must be of atleast 2 letters.");
					return jsonobjectout.toJSONString();
				} else {
					if (!submodname.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")) {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Sub Module Name contains Letter and Digits only");
						return jsonobjectout.toJSONString();
					}
				}
			}

			String modulename = "";
			if (jsonObject.get("modulename") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select Module");
				return jsonobjectout.toJSONString();
			} else {
				modulename = jsonObject.get("modulename").toString().trim();
				if (modulename.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select Module");
					return jsonobjectout.toJSONString();
				}
			}

			boolean CheckSubmodulenameexist = false;
			List submoduleexistcheck = subModuleMasterRepository.CheckSubModuleNameexist(Integer.parseInt(modulename),
					submodname);
			if (actiontype.equalsIgnoreCase("add")) {
				if (submoduleexistcheck.isEmpty()) {
					CheckSubmodulenameexist = true;
				}
			} else {
				if (submoduleexistcheck.isEmpty() || submoduleexistcheck.size() == 1) {
					CheckSubmodulenameexist = true;
				}
			}
			if (CheckSubmodulenameexist) {

				TB_LDAP_SUBMODULE_MASTER tb_LDAP_SUBMODULE_MASTER = new TB_LDAP_SUBMODULE_MASTER();
				tb_LDAP_SUBMODULE_MASTER.setSubmodule_name(submodname);

				TB_LDAP_MODULE_MASTER tb_LDAP_MODULE_MASTER = new TB_LDAP_MODULE_MASTER();
				tb_LDAP_MODULE_MASTER.setId(Integer.parseInt(modulename));

				tb_LDAP_SUBMODULE_MASTER.setModule(tb_LDAP_MODULE_MASTER);

				if (actiontype.equalsIgnoreCase("add")) {

					subModuleMasterRepository.save(tb_LDAP_SUBMODULE_MASTER);
					jsonobjectout.put("message", "Data Saved Successfully");
					jsonobjectout.put("status", "1");

					returnstring = jsonobjectout.toJSONString();
				} else {

					TB_LDAP_SUBMODULE_MASTER submodule_MASTER = subModuleMasterRepository
							.getById(Integer.parseInt(jsonObject.get("submoduleid").toString()));
					if (submodule_MASTER != null) {
						submodule_MASTER.setSubmodule_name(submodname);

						tb_LDAP_MODULE_MASTER = new TB_LDAP_MODULE_MASTER();
						tb_LDAP_MODULE_MASTER.setId(Integer.parseInt(modulename));

						submodule_MASTER.setModule(tb_LDAP_MODULE_MASTER);
						subModuleMasterRepository.save(submodule_MASTER);
						jsonobjectout.put("message", "Data Updated Successfully");
						jsonobjectout.put("status", "1");

						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Role ID Not Found");
						returnstring = jsonobjectout.toJSONString();
					}

				}

			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Sub Module Name already exist");
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
	@RequestMapping(value = "/admin/DeleteSubModuleData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeleteSubModuleData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("submoduleid") != null) {

				int submoduleid = Integer.parseInt(AESGCM.decrypt(jsonObject.get("submoduleid").toString()));
				TB_LDAP_SUBMODULE_MASTER tb_LDAP_SUBMODULE_MASTER = subModuleMasterRepository.getById(submoduleid);
				if (tb_LDAP_SUBMODULE_MASTER != null) {
					subModuleMasterRepository.delete(tb_LDAP_SUBMODULE_MASTER);
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
	@RequestMapping(value = "/admin/GetSubModuleDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetSubModuleDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("submoduleid") != null) {

				int submoduleid = Integer.parseInt(AESGCM.decrypt(jsonObject.get("submoduleid").toString()));

				TB_LDAP_SUBMODULE_MASTER tb_LDAP_SUBMODULE_MASTER = subModuleMasterRepository.getById(submoduleid);
				if (tb_LDAP_SUBMODULE_MASTER != null) {
					jsonobjectout.put("status", "1");
					jsonobjectout.put("submodname", tb_LDAP_SUBMODULE_MASTER.getSubmodule_name());
					jsonobjectout.put("modulename", tb_LDAP_SUBMODULE_MASTER.getModule().getId());

					jsonobjectout.put("submoduleid", tb_LDAP_SUBMODULE_MASTER.getId());
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
