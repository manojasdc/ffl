package com.BisagN.Rbac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.data.domain.Sort;
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

import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_ROLEMASTER;
import com.BisagN.models.TB_LDAP_ROLE_TYPE;
import com.BisagN.models.TB_LDAP_SCREEN_MASTER;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.ModuleMasterRepository;
import com.BisagN.repository.RoleMasterRepository;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.RoleTypeRepository;
import com.BisagN.repository.ScreenMasterRepository;
import com.BisagN.repository.SubModuleMasterRepository;

@Controller
public class RoleMasterController {

	@Autowired
	RoleTypeRepository roleTypeRepository;

	@Autowired
	ModuleMasterRepository moduleMasterRepository;

	@Autowired
	SubModuleMasterRepository subModuleMasterRepository;

	@Autowired
	ScreenMasterRepository screenMasterRepository;

	@Autowired
	RoleMasterRepository rolemasterRepository;

	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/admin/RoleMaster", method = RequestMethod.GET)
	public ModelAndView RoleMaster(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model) {
		
		ModelAndView model1 = new ModelAndView();
		String roleid = session.getAttribute("roleid").toString();
	      
		/*
		 * List val = roleRepository.ScreenRedirect("RoleMaster",
		 * Integer.parseInt(roleid)); Integer val1 = val.size(); // val1 = true; String
		 * msg = null; try { if (val1 == 0) { model.addAttribute("errorMessage",
		 * "You are not authorized to access this Page!!!!"); return new
		 * ModelAndView("loginError"); } else { } if (request.getHeader("Referer") ==
		 * null) { msg = ""; }
		 * 
		 * } catch (Exception e) { // Handle exception } Mmap.put("msg", msg);
		 */
		model1.setViewName("RoleMaster");
		return model1;
		
	}


	@ResponseBody
	@RequestMapping(value = "/admin/getRoleType", method = RequestMethod.POST, produces = { "application/json" })
	public String getRoleType(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<Role> list1 = roleRepository.getRoleType();

			if (!list1.isEmpty()) {

				for (Role role : list1) {
					object = new JSONObject();

					object.put("id", role.getRoleId());
					object.put("roletype", role.getRole());
					jSONArray.add(object);
				}
				object1.put("roletypelist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("roletypelist", jSONArray);
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
	@RequestMapping(value = "/admin/getModuleMaster", method = RequestMethod.POST, produces = { "application/json" })
	public String getModuleMaster(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TB_LDAP_MODULE_MASTER> list2 = moduleMasterRepository.LoadModuleData1();

			if (!list2.isEmpty()) {

				for (TB_LDAP_MODULE_MASTER TB_LDAP_MODULE_MASTER : list2) {
					object = new JSONObject();

					object.put("id", TB_LDAP_MODULE_MASTER.getId());
					object.put("modulemaster", TB_LDAP_MODULE_MASTER.getModule_name());
					jSONArray.add(object);
				}
				object1.put("modulemasterlist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("modulemasterlist", jSONArray);
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
	@RequestMapping(value = "/admin/getSubModuleMaster", method = RequestMethod.POST, produces = { "application/json" })
	public String getSubModuleMaster(@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TB_LDAP_SUBMODULE_MASTER> list3 = subModuleMasterRepository.LoadSubModuleData1(id);
			System.out.println(list3 + "");
			if (!list3.isEmpty()) {

				for (TB_LDAP_SUBMODULE_MASTER TbLdapSubmoduleMaster : list3) {
					object = new JSONObject();

					object.put("id", TbLdapSubmoduleMaster.getId());
					object.put("submodulemaster", TbLdapSubmoduleMaster.getSubmodule_name());
					jSONArray.add(object);
				}
				object1.put("submodulemasterlist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("submodulemasterlist", jSONArray);
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
	@RequestMapping(value = "/admin/getScreenMaster", method = RequestMethod.POST, produces = { "application/json" })
	public String getScreenMaster(@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request) {
		System.out.println("IDDD OUT" + id);
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TB_LDAP_SCREEN_MASTER> list4 = screenMasterRepository.getScreenName(id);

			if (!list4.isEmpty()) {

				for (TB_LDAP_SCREEN_MASTER TbLdapScreenMaster : list4) {
					object = new JSONObject();

					object.put("id", TbLdapScreenMaster.getId());
					object.put("screenmaster", TbLdapScreenMaster.getScreen_name());
					System.out.println("DATAQUERY" + TbLdapScreenMaster.getScreen_name());
					jSONArray.add(object);
				}
				object1.put("screenmasterlist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("screenmasterlist", jSONArray);
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

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/admin/SaveRoleMasterData", method = RequestMethod.POST, produces = { "application/json" })
	public String SaveRoleMasterData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			System.out.println("data==" + data);

			String actiontype = jsonObject.get("actiontype").toString();
			String sessionuserid = request.getSession().getAttribute("username").toString();

			String role_name = "";
			if (jsonObject.get("roleid") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select Role Name");
				return jsonobjectout.toJSONString();
			} else {
				role_name = jsonObject.get("roleid").toString().trim();
				if (role_name.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select Role Name");
					return jsonobjectout.toJSONString();
				}
			}

			String module = "";
			module = jsonObject.get("moduleid").toString().trim();

//			String module_name = "";
			if (jsonObject.get("moduleid") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select Module");
				return jsonobjectout.toJSONString();
			} else {
				module = jsonObject.get("moduleid").toString().trim();
				if (module.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select Module");
					return jsonobjectout.toJSONString();
				}
			}

			String sub_module = "";
			if (jsonObject.get("submoduleid") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select SubModule");
				return jsonobjectout.toJSONString();
			} else {
				sub_module = jsonObject.get("submoduleid").toString().trim();
				if (sub_module.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select SubModule");
					return jsonobjectout.toJSONString();
				}
			}

			String screen = "";
			if (jsonObject.get("screenid") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select Screen");
				return jsonobjectout.toJSONString();
			} else {
				screen = jsonObject.get("screenid").toString().trim();
				if (screen.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select Screen");
					return jsonobjectout.toJSONString();
				}
			}

			boolean CheckRoleNameExist = false;
			List rolenameexistcheck = rolemasterRepository.CheckRoleNameexist1(Integer.parseInt(role_name),
					Integer.parseInt(module), Integer.parseInt(sub_module), Integer.parseInt(screen));

			if (actiontype.equalsIgnoreCase("add")) {
				if (rolenameexistcheck.isEmpty()) {
					CheckRoleNameExist = true;
				}
			} else {
				if (rolenameexistcheck.isEmpty() || rolenameexistcheck.size() == 1) {
					CheckRoleNameExist = true;
				}
			}
			if (CheckRoleNameExist) {

//				Role role = new Role();
//				role.setRole(role_name);

				TB_LDAP_ROLEMASTER role_master = new TB_LDAP_ROLEMASTER();
				role_master.setRoleid(Integer.parseInt(role_name));
				role_master.setCreation_date(new Date());
				role_master.setCreation_by(sessionuserid);
//				UserLogin login = new UserLogin();
//				login.setUserId(Integer.parseInt(role_name));
//				role_master.setCreation_by(login);

				TB_LDAP_MODULE_MASTER TB_LDAP_MODULE_MASTER = new TB_LDAP_MODULE_MASTER();
				TB_LDAP_MODULE_MASTER.setId(Integer.parseInt(module));
				role_master.setModule(TB_LDAP_MODULE_MASTER);
				System.out.println("TB_LDAP_MODULE_MASTER===" + TB_LDAP_MODULE_MASTER);

				TB_LDAP_SUBMODULE_MASTER TbLdapSubmoduleMaster = new TB_LDAP_SUBMODULE_MASTER();
				TbLdapSubmoduleMaster.setId(Integer.parseInt(sub_module));
				role_master.setSub_module(TbLdapSubmoduleMaster);

				TB_LDAP_SCREEN_MASTER TbLdapScreenMaster = new TB_LDAP_SCREEN_MASTER();
				TbLdapScreenMaster.setId(Integer.parseInt(screen));
				role_master.setScreen(TbLdapScreenMaster);

				if (actiontype.equalsIgnoreCase("add")) {

					rolemasterRepository.save(role_master);
					jsonobjectout.put("message", "Data Saved Successfully");
					jsonobjectout.put("status", "1");

					returnstring = jsonobjectout.toJSONString();
				} else {

					Role Role = roleRepository.getById(Integer.parseInt(jsonObject.get("id").toString()));
					TB_LDAP_ROLEMASTER ldap_ROLEMASTER = rolemasterRepository
							.getById(Integer.parseInt(jsonObject.get("id").toString()));

					Optional<TB_LDAP_ROLEMASTER> ldap_ROLEMASTER1 = rolemasterRepository
							.findById(ldap_ROLEMASTER.getId());
					

					if (Role != null) {
						TB_LDAP_ROLEMASTER obj2 = ldap_ROLEMASTER1.get();

//						Role.setRole(role_name);
						// TB_LDAP_ROLEMASTER.setRoleid(TB_LDAP_ROLEMASTER);
//						TB_LDAP_ROLEMASTER ldap_ROLEMASTER = new TB_LDAP_ROLEMASTER();
						obj2.setRoleid(Integer.parseInt(role_name));

						TB_LDAP_MODULE_MASTER ldap_MODULE_MASTER = new TB_LDAP_MODULE_MASTER();
						ldap_MODULE_MASTER.setId(Integer.parseInt(module));
						obj2.setModule(ldap_MODULE_MASTER);

						TB_LDAP_SUBMODULE_MASTER ldap_SUBMODULE_MASTER1 = new TB_LDAP_SUBMODULE_MASTER();
						ldap_SUBMODULE_MASTER1.setId(Integer.parseInt(sub_module));
						obj2.setSub_module(ldap_SUBMODULE_MASTER1);

						TB_LDAP_SCREEN_MASTER TbLdapScreenMaster1 = new TB_LDAP_SCREEN_MASTER();
						TbLdapScreenMaster1.setId(Integer.parseInt(screen));
						obj2.setScreen(TbLdapScreenMaster1);

						rolemasterRepository.save(ldap_ROLEMASTER);
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
				jsonobjectout.put("message", "Role Name already exist");
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

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/admin/LoadRoleMasterData1", method = RequestMethod.POST, produces = { "application/json" })
	public String LoadRoleMasterData1(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		List<String> Columns = new ArrayList<String>();
//		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

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

			String sortyby = "screen.screen_name";

			 if (orderId == 2) {
				sortyby = "module.module_name";
			} else if (orderId == 3) {
				sortyby = "sub_module.submodule_name";
			} else if (orderId == 4) {
				sortyby = "screen.screen_name";
			}
			

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			
			
			
			
			
			// Add Server Side Validation TODO

//			if (length == -1) {
//				pageable = PageRequest.of(pageno, Integer.MAX_VALUE);
//			} else {
//				pageable = PageRequest.of(pageno, length);
//			}

			Page<TB_LDAP_ROLEMASTER> sublist = rolemasterRepository.LoadRoleMasterData1(search.toLowerCase(), pageable);

			int count = (int) sublist.getPageable().getOffset();
			count = count + 1;
			List<TB_LDAP_ROLEMASTER> sublist1 = sublist.getContent();

			int counter = 1;
			for (int i = 0; i < sublist1.size(); i++) {
//			for (TB_LDAP_ROLEMASTER ldap_ROLEMASTER : sublist1) {
				TB_LDAP_ROLEMASTER ldap_ROLEMASTER = sublist1.get(i);
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("srno", counter);
//                System.out.println("hello"+ldap_ROLEMASTER.getRoleid());
				Optional<Role> role1 = roleRepository.findById(ldap_ROLEMASTER.getRoleid());

				if (role1.isPresent()) {
				    jsonObject2.put("role_name", role1.get().getRole());
				} else {
				    jsonObject2.put("role_name", "");
				}
//				jsonObject2.put("role_name", ldap_ROLEMASTER.getRoleid());
				jsonObject2.put("module", ldap_ROLEMASTER.getModule().getModule_name());
				jsonObject2.put("sub_module", ldap_ROLEMASTER.getSub_module().getSubmodule_name());
				jsonObject2.put("screen", ldap_ROLEMASTER.getScreen().getScreen_name());

//				jsonObject2.put("action", "<a href=\"#\" onclick=\"GetScreenMasterDataForUpdate('"
//						+ AESGCM.encrypt(submodule_MASTER.getId() + "")
//						+ "')\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a> &nbsp;&nbsp; <a href=\"#\" onclick=\"DeleteSubModuleData('"
//						+ AESGCM.encrypt(submodule_MASTER.getId() + "")
//						+ "')\"><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></a>");
//				jsonArray1.add(jsonObject2);
//				counter++;

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(ldap_ROLEMASTER.getId() + "") + "' /> ";

				jsonObject2.put("action",
						"<ul class=\"list-inline custom-btn-group\"><li class=\"list-inline-item\"><a href=\"#\" class=\"btn btn-primary icon-btn\" title=\"Edit\"><i class=\"ri-pencil-fill mr-0 text-center editrolemaster\" aria-hidden=\"true\"></i></a></li><li class=\"list-inline-item\">"
								+ " <a href=\"#\" class=\"btn btn-warning icon-btn\" title=\"Delete\"><i class=\"ri-delete-bin-2-fill deleterolemaster\" aria-hidden=\"true\"></i></a></li></ul>"
								+ hidden);
				jsonArray1.add(jsonObject2);
				formcounter++;
				counter++;
			}
			jsonobjectout.put("status", "1");
			jsonobjectout.put("data", jsonArray1);
			jsonobjectout.put("message", "Data Load Successfully");
			jsonobjectout.put("TotalCount", sublist.getTotalElements());
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
	@RequestMapping(value = "/admin/DeleteRoleMasterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeleteRoleMasterData(@RequestBody String data, HttpServletRequest request) {

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
//				Role role = roleRepository.getById(roleid);
				TB_LDAP_ROLEMASTER ldap_ROLEMASTER = rolemasterRepository.getById(id);

				if (ldap_ROLEMASTER != null) {
					rolemasterRepository.delete(ldap_ROLEMASTER);
					jsonobjectout.put("status", "1");
					jsonobjectout.put("message",  "Data Deleted Successfully");
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

//	@ResponseBody
//	@RequestMapping(value = "/admin/GetRoleMasterDataForUpdate", method = RequestMethod.POST, produces = {
//			"application/json" })
//	public String GetRoleMasterDataForUpdate(@RequestBody String data, HttpServletRequest request) {
//
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray1 = new JSONArray();
//		JSONParser jsonp = new JSONParser();
//		JSONObject jsonobjectout = new JSONObject();
//		String returnstring = "";
//		try {
//			// Add Server Side Validation TODO
//			jsonObject = (JSONObject) jsonp.parse(data);
//			if (jsonObject.get("id") != null) {
//
//				int id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("id").toString()));
//
//				TB_LDAP_ROLEMASTER tb_LDAP_ROLEMASTER = rolemasterRepository.getById(id);
//
//				if (tb_LDAP_ROLEMASTER != null) {
//					jsonobjectout.put("status", "1");
//					jsonobjectout.put("role_name", tb_LDAP_ROLEMASTER.getRoleid());
//
//					jsonobjectout.put("module", tb_LDAP_ROLEMASTER.getModule().getId());
//					jsonobjectout.put("sub_module", tb_LDAP_ROLEMASTER.getSub_module().getId());
//					jsonobjectout.put("screen", tb_LDAP_ROLEMASTER.getScreen().getId());
//
//					jsonobjectout.put("id", tb_LDAP_ROLEMASTER.getId());
//					
//					System.out.println("in update rolemaster"+tb_LDAP_ROLEMASTER.getId() );
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
//		System.out.println("Output-->" + returnstring);
//
//		return returnstring;
//	}
	@ResponseBody
	@RequestMapping(value = "/admin/GetRoleMasterDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetRoleMasterDataForUpdate(@RequestBody String data, HttpServletRequest request) {

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
//				System.out.println("yyyyyyyyyyyyyy"+id);
				TB_LDAP_ROLEMASTER tb_LDAP_ROLEMASTER = rolemasterRepository.getById(id);
				if (tb_LDAP_ROLEMASTER != null) {
					jsonobjectout.put("status", "1");
					jsonobjectout.put("role_name", tb_LDAP_ROLEMASTER.getRoleid());

					jsonobjectout.put("module", tb_LDAP_ROLEMASTER.getModule().getId());
					jsonobjectout.put("sub_module", tb_LDAP_ROLEMASTER.getSub_module().getId());
					jsonobjectout.put("screen", tb_LDAP_ROLEMASTER.getScreen().getId());
//					System.out.println("inscreenupdate"+tb_LDAP_ROLEMASTER.getScreen().getId());

					jsonobjectout.put("id", tb_LDAP_ROLEMASTER.getId());
//					
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
	
	
}
