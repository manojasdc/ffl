package com.BisagN.Rbac.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.controller.AESGCM;
import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_SCREEN_MASTER;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;
import com.BisagN.repository.ModuleMasterRepository;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.ScreenMasterRepository;
import com.BisagN.repository.SubModuleMasterRepository;

@RestController
public class ScreenMasterController {

	@Autowired
	ModuleMasterRepository moduleMasterRepository;
	@Autowired
	SubModuleMasterRepository subModuleMasterRepository;

	@Autowired
	ScreenMasterRepository screenMasterRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/admin/ScreenMaster", method = RequestMethod.GET)
	public ModelAndView ScreenMaster(ModelMap Mmap, HttpSession session, HttpServletRequest request,
			Model model) {

		ModelAndView model1 = new ModelAndView();
		String roleid = session.getAttribute("roleid").toString();
		/*
		 * List val = roleRepository.ScreenRedirect("ScreenMaster",
		 * Integer.parseInt(roleid)); Integer val1 = val.size(); // val1 = true; String
		 * msg = null; try { if (val1 == 0) { model.addAttribute("errorMessage",
		 * "You are not authorized to access this Page!!!!"); return new
		 * ModelAndView("loginError"); } else { } if (request.getHeader("Referer") ==
		 * null) { msg = ""; }
		 * 
		 * } catch (Exception e) { // Handle exception } Mmap.put("msg", msg);
		 */
		model1.setViewName("screen_mstTiles");
		return model1;
		
	}

//	@RequestMapping(value = "/admin/ScreenMaster2", method = RequestMethod.GET)
//	public ModelAndView ScreenMaster2() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("screen_mstTiles2");
//		return model;
//	}

	@ResponseBody
	@RequestMapping(value = "/admin/getModuleName1", method = RequestMethod.POST, produces = { "application/json" })
	public String getModuleName1(HttpServletRequest request) {
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
	@RequestMapping(value = "/admin/getSubModuleName1", method = RequestMethod.POST, produces = { "application/json" })
	public String getSubModuleName1(@RequestParam(value = "id", required = false)Integer id) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

		try {
			List<TB_LDAP_SUBMODULE_MASTER> list1 = subModuleMasterRepository.LoadSubModuleData2(id);

			if (!list1.isEmpty()) {

				for (TB_LDAP_SUBMODULE_MASTER TB_LDAP_SUBMODULE_MASTER : list1) {
					object = new JSONObject();

					object.put("id", TB_LDAP_SUBMODULE_MASTER.getId());
					object.put("subname", TB_LDAP_SUBMODULE_MASTER.getSubmodule_name());
					jSONArray.add(object);
				}
				object1.put("submodulelist", jSONArray);
			} else {
				jSONArray = new JSONArray();
				object1.put("submodulelist", jSONArray);
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
	@RequestMapping(value = "/admin/SaveScreenMasterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String SaveScreenMasterData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			String actiontype = jsonObject.get("actiontype").toString();

			System.err.println("===actiontype=====" + actiontype);
			String screen_name = "";
			String screen_url = "";
			 if (jsonObject.get("screen_name") == null) {
	                jsonobjectout.put("status", "0");

	                jsonobjectout.put("message", "Enter Screen Name");
	                return jsonobjectout.toJSONString();
	            } else {
	                screen_name = jsonObject.get("screen_name").toString().trim();
	                screen_name = jsonObject.get("screen_name").toString().toUpperCase();
	                screen_url = jsonObject.get("screen_url").toString().trim();
	            
	                String worlds[] = screen_url.split(" ");
//	                System.out.println("lentgh"+worlds.length);
	                if (screen_name.length() < 2) {
	                    jsonobjectout.put("status", "0");
	                    jsonobjectout.put("message", "Screen Name must be of atleast 2 letters.");
	                    return jsonobjectout.toJSONString();
	                }
	                else {
	                    if (!screen_name.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")) {
	                        jsonobjectout.put("status", "0");
	                        jsonobjectout.put("message", "Screen Name contains Letter and Digits only");
	                        return jsonobjectout.toJSONString();
	                    }
	                }
	                //screen url
	                if (jsonObject.get("screen_url") == null) {
	                    jsonobjectout.put("status", "0");

	                    jsonobjectout.put("message", "Please Enter Screen url");
	                    return jsonobjectout.toJSONString();
	                } 
	                if (screen_url.length() < 2) {
	                    jsonobjectout.put("status", "0");
	                    jsonobjectout.put("message", "Screen url must be of atleast 2 letters.");
	                    return jsonobjectout.toJSONString();
	                }
	                if ( worlds.length != 1)
	                 {
	                    jsonobjectout.put("status", "0");
	                    jsonobjectout.put("message", "No space allowed.");
	                    return jsonobjectout.toJSONString();
	                }
	                else {
	                    if (!screen_url.matches("^[/A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")) {
	                        jsonobjectout.put("status", "0");
	                        jsonobjectout.put("message", "Screen url contains Letter and Digits only");
	                        return jsonobjectout.toJSONString();
	                    }
	                }
	                
	                
	            }
			// Module
			String screen_module_id = "";
			
			if (jsonObject.get("screen_module_id") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select Module");
				return jsonobjectout.toJSONString();
			} else {
				screen_module_id = jsonObject.get("screen_module_id").toString().trim();
				if (screen_module_id.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select Module");
					return jsonobjectout.toJSONString();
				}
			}

			// SubModule
			String screen_submodule_id = "";
			if (jsonObject.get("screen_submodule_id") == null) {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Please Select SubModule");
				return jsonobjectout.toJSONString();
			} else {
				screen_submodule_id = jsonObject.get("screen_submodule_id").toString().trim();
				if (screen_submodule_id.equalsIgnoreCase("-1")) {
					jsonobjectout.put("status", "0");
					jsonobjectout.put("message", "Please Select SubModule");
					return jsonobjectout.toJSONString();
				}
			}

			boolean Checkscreennameexist = false;
			List screenexistcheck = screenMasterRepository.CheckScreenNameexist(screen_name);
			if (actiontype.equalsIgnoreCase("add")) {
				if (screenexistcheck.isEmpty()) {
					Checkscreennameexist = true;
				}
			} else {
				if (screenexistcheck.isEmpty() || screenexistcheck.size() == 1) {
					Checkscreennameexist = true;
				}
			}
			if (Checkscreennameexist) {

				TB_LDAP_SCREEN_MASTER screen = new TB_LDAP_SCREEN_MASTER();
				TB_LDAP_SUBMODULE_MASTER tb_LDAP_SUBMODULE_MASTER = new TB_LDAP_SUBMODULE_MASTER();
				TB_LDAP_MODULE_MASTER tb_LDAP_MODULE_MASTER = new TB_LDAP_MODULE_MASTER();

				screen.setScreen_name(screen_name);
				screen.setScreen_url(screen_url);

				tb_LDAP_MODULE_MASTER.setId(Integer.parseInt(screen_module_id));
				screen.setModule(tb_LDAP_MODULE_MASTER);

				tb_LDAP_SUBMODULE_MASTER.setId(Integer.parseInt(screen_submodule_id));
				screen.setSub_module(tb_LDAP_SUBMODULE_MASTER);

//				System.out.println("tttttttttttttttttttttttttttscreen_submodule_id" + screen_submodule_id);
//				System.out.println("tttttttttttttttttttttttttttscreen_module_id" + screen_module_id);

				if (actiontype.equalsIgnoreCase("add")) {

//					System.out.println("addtttttttttttttttttttttttttttactiontype" + actiontype);
					screenMasterRepository.save(screen);
					jsonobjectout.put("message", "Data Saved Successfully");
					jsonobjectout.put("status", "1");

					returnstring = jsonobjectout.toJSONString();
				} else {

					TB_LDAP_SCREEN_MASTER screenupdate = screenMasterRepository
							.getById(Integer.parseInt(jsonObject.get("screen_id").toString()));

					if (screenupdate != null) {

						screenupdate.setScreen_name(screen_name);
						tb_LDAP_MODULE_MASTER.setId(Integer.parseInt(screen_module_id));
						screenupdate.setModule(tb_LDAP_MODULE_MASTER);
						tb_LDAP_SUBMODULE_MASTER.setId(Integer.parseInt(screen_submodule_id));
						screenupdate.setSub_module(tb_LDAP_SUBMODULE_MASTER);

						screenupdate.setScreen_url(screen_url);
						screenMasterRepository.save(screenupdate);
						jsonobjectout.put("message", "Data Updated Successfully");
						jsonobjectout.put("status", "1");

						returnstring = jsonobjectout.toJSONString();
					} else {
						jsonobjectout.put("status", "0");
						jsonobjectout.put("message", "Screen ID Not Found");
						returnstring = jsonobjectout.toJSONString();
					}

				}

			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Screen Name Already Exist");
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

	// load data

	@ResponseBody
	@RequestMapping(value = "/admin/LoadScreenMasterData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String LoadScreenMasterData(HttpServletRequest request, @RequestParam int pageno, @RequestParam int length,
			String search, String order) {

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

			String sortyby = "screen_submodule_id";

			
			if (orderId == 0) {
				sortyby = "screen_submodule_id";
			}
			else if (orderId == 1) {
				sortyby = "screen_name";
			}
			else if(orderId ==2) {
				sortyby = "mm.module_name";
			}
			else if(orderId ==3) {
				sortyby = "sm.submodule_name";
			}

			if (length == -1) {
				pageable = PageRequest.of(pageno, Integer.MAX_VALUE,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));

			} else {
				pageable = PageRequest.of(pageno, length,
						Sort.by(orderType.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortyby));
			}
			// Add Server Side Validation TODO
			List<Map<String, Object>> sclist = screenMasterRepository.LoadScreenDataList(search.toLowerCase(),
					pageable);
			int accmst3 = screenMasterRepository.LoadScreenMasterDataListCount(search.toLowerCase());
			int counter = (int) pageable.getOffset();
			counter = counter + 1;
			for (int i = 0; i < sclist.size(); i++) {

				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("srno", counter);
				jsonObject2.put("screen_name", sclist.get(i).get("screen_name"));
				jsonObject2.put("screen_url", sclist.get(i).get("screen_url"));
				jsonObject2.put("screen_module_id", sclist.get(i).get("module_name"));
				jsonObject2.put("screen_submodule_id", sclist.get(i).get("submodule_name"));
				jsonObject2.put("actiontype", "update");

				String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
						+ AESGCM.encrypt(sclist.get(i).get("id") + "") + "' /> ";

				jsonObject2.put("action", "<button type=\"button\"\n"
						+ "																class=\"btn btn-primary icon-btn btnedit edit_screen\" title=\"Edit\">\n"
						+ "																<i class=\"ri-pencil-fill\"></i>\n"
						+ "															</button> <button type=\"button\"\n"
						+ "																class=\"btn btn-warning icon-btn btndelete delete_screen\"\n"
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

	// delee

	@ResponseBody
	@RequestMapping(value = "/admin/DeleteScreenModuleData", method = RequestMethod.POST, produces = {
			"application/json" })
	public String DeleteScreenModuleData(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("screen_id") != null) {

				int screen_id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("screen_id").toString()));
				TB_LDAP_SCREEN_MASTER tb_LDAP_SCREEN_MASTER = screenMasterRepository.getById(screen_id);
//				System.out.println("rrrrrrrrrrrr" + screen_id);
				if (tb_LDAP_SCREEN_MASTER != null) {
					screenMasterRepository.delete(tb_LDAP_SCREEN_MASTER);
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

	// Update

	@ResponseBody
	@RequestMapping(value = "/admin/GetScreenDataForUpdate", method = RequestMethod.POST, produces = {
			"application/json" })
	public String GetScreenDataForUpdate(@RequestBody String data, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			if (jsonObject.get("screen_id") != null) {

				int screen_id = Integer.parseInt(AESGCM.decrypt(jsonObject.get("screen_id").toString()));

				TB_LDAP_SCREEN_MASTER tb_LDAP_SCREEN_MASTER = screenMasterRepository.getById(screen_id);
				if (tb_LDAP_SCREEN_MASTER != null) {
					jsonobjectout.put("status", "1");
					jsonobjectout.put("screen_name", tb_LDAP_SCREEN_MASTER.getScreen_name());
					jsonobjectout.put("screen_url", tb_LDAP_SCREEN_MASTER.getScreen_url());
					jsonobjectout.put("screen_module_id", tb_LDAP_SCREEN_MASTER.getModule().getId());
					jsonobjectout.put("screen_submodule_id", tb_LDAP_SCREEN_MASTER.getSub_module().getId());

					jsonobjectout.put("screen_id", tb_LDAP_SCREEN_MASTER.getId());
					System.out.println("deepdeep" + tb_LDAP_SCREEN_MASTER.getModule().getId());
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