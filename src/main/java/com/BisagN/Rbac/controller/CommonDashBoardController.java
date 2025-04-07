package com.BisagN.Rbac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class CommonDashBoardController {

	

	@RequestMapping(value = "/admin/SocietyDashboard", method = RequestMethod.GET)
	public ModelAndView SocietyDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		System.out.println("commonDashboard");
		JSONParser jsonParser = new JSONParser();
		return new ModelAndView("SocietyDashboard");
	}
	@RequestMapping(value = "/admin/RODashboard", method = RequestMethod.GET)
	public ModelAndView RODashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		System.out.println("commonDashboard");
		JSONParser jsonParser = new JSONParser();

		return new ModelAndView("RODashboard");

	}

	@RequestMapping(value = "/admin/SchoolDashboard", method = RequestMethod.GET)
	public ModelAndView SchoolDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		System.out.println("commonDashboard");
		JSONParser jsonParser = new JSONParser();
		return new ModelAndView("SchoolDashboard");

	}
	
	@RequestMapping(value = "/admin/StudentDashboard", method = RequestMethod.GET)
	public ModelAndView StudentDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		System.out.println("StudentDashboard");
		JSONParser jsonParser = new JSONParser();
		return new ModelAndView("StudentDashboard");
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getStudentdata", method = RequestMethod.POST, produces = { "application/json" })
	public String getStudentdata(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		
		
//
//		List list1 = SchoolDashboardRepositorynr.getstudentdata();
//
//		for (int i = 0; i < list1.size(); i++) {
//			Object[] obj = (Object[]) list1.get(i);
//
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("classname", obj[0]);
//			jsonObject.put("boys", obj[1]);
//			jsonObject.put("girls", obj[2]);
//			jsonObject.put("totalstudent", obj[3]);
//			jSONArray.add(jsonObject);
//		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getSchoolstudentdata", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getSchoolstudentdata(HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();

//		List list1 = RODashboardRepositorynr.getschoolstudentdata();
//
//		for (int i = 0; i < list1.size(); i++) {
//			Object[] obj = (Object[]) list1.get(i);
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("schoolid", obj[0]);
//			jsonObject.put("schoolname", obj[1]);
//			jsonObject.put("boys", obj[2]);
//			jsonObject.put("girls", obj[3]);
//			jsonObject.put("totalstudent", obj[4]);
//			jSONArray.add(jsonObject);
//		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

	@RequestMapping(value = "admin/getSocietydata", method = RequestMethod.POST, produces = { "application/json" })
	public String getSocietydata() {
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		try {

//			List<TbSocietyDtl> list1 = SocietyDashboardRepositorynr.getSocietydata();
//
//			System.out.println("List Size " + list1.size());
//
////			ObjectMapper objectMapper = new ObjectMapper();
//			// Set pretty printing of json
////	        objectMapper.enable(SerializationFeature.EAGER_SERIALIZER_FETCH);
//
////	        String json = objectMapper.writeValueAsString(list);
////	        System.out.println("1. Convert List of State objects to JSON :");
////	        System.out.println(json);
//
//			for (int i = 0; i < list1.size(); i++) {
//
//				JSONObject jsonObject1 = new JSONObject();
//
//				TbSocietyDtl tbSocietyDtl = list1.get(i);
//
//				jsonObject1.put("name", tbSocietyDtl.getSocietyName());
//				// jsonObject1.put("id", tbSocietyDtl.getId());
//				JSONArray jsonArray = new JSONArray();
//
//				List<TbRegOfficeDtl> list2 = RODashboardRepositorynr.getROdata(tbSocietyDtl.getId());
//
//				if (list2.isEmpty()) {
//
//				} else {
//					for (TbRegOfficeDtl tbRegOfficeDtl : list2) {
//
//						JSONObject jsonObject2 = new JSONObject();
//						jsonObject2.put("name", tbRegOfficeDtl.getRegOfficeName());
//						JSONArray jsonArrayunit = new JSONArray();
//
//						int count = SchoolDashboardRepositorynr.getSchooldata(tbRegOfficeDtl.getId());
//
//						if (count <= 0) {
//
//						} else {
//
//							JSONObject jsonObject3 = new JSONObject();
//							jsonObject3.put("name",count);
//							jsonArrayunit.add(jsonObject3);
//
//							jsonObject2.put("children", jsonArrayunit);
//						}
//						jsonArray.add(jsonObject2);
//
//					}
//					jsonObject1.put("children", jsonArray);
//				}
//
//				jsonArray1.add(jsonObject1);
//
//			}
//			System.out.println("JSOn DATA" + jsonObject.toJSONString());
			jsonObject = new JSONObject();
			jsonObject.put("status", "1");
			jsonObject.put("message", "Success");
			jsonObject.put("data", jsonArray1);
			
			
			
			
//			jsonObject.put("json", json);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("staus", "0");
			jsonObject.put("message", "Failure");
		}
		
		System.err.println("OutPut -- >"+jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}

}
