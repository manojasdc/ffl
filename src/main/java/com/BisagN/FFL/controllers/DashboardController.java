package com.BisagN.FFL.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbCountryName;
import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.ActivityRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.RegistrationChildRepository;
import com.BisagN.FFL.repository.RegistrationRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;
import com.BisagN.repository.RoleinformationRepository;
import com.BisagN.repository.UserLoginRepository;

@Controller
public class DashboardController {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	UserLoginChildRepository userloginchildRepositroy;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RegistrationChildRepository childRepository;

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	RoleinformationRepository roleinformationRepository;

	@RequestMapping(value = "/admin/adminDashboard", method = RequestMethod.GET)
	public ModelAndView adminDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model1) {

		ModelAndView model = new ModelAndView();
		String roleName = request.getSession().getAttribute("role").toString();
		String msg = null;
		try {
			if (roleName.equalsIgnoreCase("SUPER ADMIN")) {
				int allinstitutecount = instituteRepository.Loadallnoofinstitute();
				int allcontries = countryRepository.Loadallcounties();
				int allenduser = userLoginRepository.loadUserList().size();
				int allblogcount = activityRepository.Loadallblogs();
				List<Map<String,Object>> alluserlist = userLoginRepository.loadUserList();

				Mmap.put("alluserlist", alluserlist);
				Mmap.put("allinstitutecount", allinstitutecount);
				Mmap.put("allcontries", allcontries);
				Mmap.put("allenduser", allenduser);
				Mmap.put("allblogcount", allblogcount);
				Mmap.put("dashboardurl", "adminDashboard");

			} else {
				model1.addAttribute("errorMessage", "You are not authorized to access this Page!!!!");
				return new ModelAndView("loginError");
			}
			if (request.getHeader("Referer") == null) {
				msg = "";
			}

		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		return new ModelAndView("adminDashboard");
	}

	@RequestMapping(value = "/admin/instituteDashboard", method = RequestMethod.GET)
	public ModelAndView instituteDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request,
			Model model1) {

		ModelAndView model = new ModelAndView();
		String roleName = request.getSession().getAttribute("role").toString();
		String msg = null;
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		Integer userid = Integer.parseInt(sessionuserid);
		Integer instituteid = userLoginRepository.instituteid1(userid);
		try {
			if (roleName.equalsIgnoreCase("ADMIN")) {
				int allinstitutecount = instituteRepository.Loadallnoofinstitute();
				int allcontries = countryRepository.Loadallcounties();
				Integer allenduser = userLoginRepository.loaduserbyinstitutewise(instituteid);
			//changes required////
				
				// int allblogcount = activityRepository.Loadallblogs();
				Mmap.put("dashboardurl", "instituteDashboard");
				Mmap.put("allinstitutecount", allinstitutecount);
				Mmap.put("allcontries", allcontries);
				Mmap.put("allenduser", allenduser);

			} else {
				model1.addAttribute("errorMessage", "You are not authorized to access this Page!!!!");
				return new ModelAndView("loginError");
			}
			if (request.getHeader("Referer") == null) {
				msg = "";
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Mmap.put("msg", msg);
		return new ModelAndView("instituteDashboard");
	}

	@RequestMapping(value = "/admin/EmbasyDashboard", method = RequestMethod.GET)
	public ModelAndView EmbasyDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request, Model model1) {

		String sessionusername = request.getSession().getAttribute("username").toString();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
		ModelAndView model = new ModelAndView();
		String roleName = request.getSession().getAttribute("role").toString();
		String msg = null;
		try {
			if (roleName.equalsIgnoreCase("EMBASSY ADMIN")) {
				int pendingembasycount = childRepository.pendingembasycount(userLogin.get().getInstituteId());
				int acceptedembasycount = childRepository.acceptedembasycount(userLogin.get().getInstituteId());
				int rejectedembasycount = childRepository.rejectedembasycount(userLogin.get().getInstituteId());

				Mmap.put("pendingembasycount", pendingembasycount);
				Mmap.put("acceptedembasycount", acceptedembasycount);
				Mmap.put("rejectedembasycount", rejectedembasycount);
				Mmap.put("dashboardurl", "EmbasyDashboard");
			} else {
				model1.addAttribute("errorMessage", "You are not authorized to access this Page!!!!");
				return new ModelAndView("loginError");
			}
			if (request.getHeader("Referer") == null) {
				msg = "";
			}
		} catch (Exception e) {
			// Handle exception
		}
		Mmap.put("msg", msg);
		return new ModelAndView("EmbasyDashboard");
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getallinstituteblogchart", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getallinstituteblogchart(
			HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		List list1 = activityRepository.getallinstituteblogchart();
		for (int i = 0; i < list1.size(); i++) {
			Object[] obj = (Object[]) list1.get(i);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("blogs", obj[0]);
			jsonObject.put("institute", obj[1]);
			jSONArray.add(jsonObject);
		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getyear", method = RequestMethod.POST, produces = { "application/json" })
	public String getyear(HttpServletRequest request) {

		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		try {
			List<TbMiscActivity> list1 = activityRepository.getyeardata();

			if (!list1.isEmpty()) {
				for (int i = 0; i < list1.size(); i++) {
					object = new JSONObject();
					TbMiscActivity TbSchoolReportDtl = list1.get(i);
					object.put("id", TbSchoolReportDtl.getId());
					//object.put("year", TbSchoolReportDtl.getYear());
					object.put("year", "");
					jSONArray.add(object);
				}

				object1.put("yearList", jSONArray);

			} else {
				jSONArray = new JSONArray();
				object1.put("yearList", jSONArray);
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

	@ResponseBody
	@RequestMapping(value = "/admin/getallcountryuserschart", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getallcountryuserschart(
			HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		List list1 = null;
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("SUPER ADMIN")) {
			list1 = countryRepository.getcountryuserChart();
		} else {
			Integer id = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(id);
			Userloginchild userloginchild = userloginchildRepositroy.findByuseridId(userLogin.get().getUserId());

			list1 = countryRepository.getcountryuserChart1(userloginchild.getInstituteId().getId());

		}
		for (int i = 0; i < list1.size(); i++) {
			Object[] obj = (Object[]) list1.get(i);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("male", obj[0]);
			jsonObject.put("female", obj[1]);
			jsonObject.put("total", obj[2]);
			jsonObject.put("country", obj[3]);

			jSONArray.add(jsonObject);
		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getalluserschart", method = RequestMethod.POST, produces = { "application/json" })
	public String getalluserschart(@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "passoutyear", required = false) String passoutyear,
			HttpServletRequest request) {
		System.out.println();
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		List list1 = null;
		if (roleName.equalsIgnoreCase("SUPER ADMIN")) {

			list1 = registrationRepository.getInstituteWiseAlumni(Integer.parseInt(year != null ? year : "2025"));
		} else {
			Integer id = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(id);
			Userloginchild userloginchild = userloginchildRepositroy.findByuseridId(userLogin.get().getUserId());
			TbInstituteDetail institute=instituteRepository.getById(userloginchild.getUserId().getInstituteId());
			list1 = registrationRepository.getInstituteWiseAlumni1(Integer.parseInt(year != null ? year : "2025"),institute.getInstituteName());
		}

		for (int i = 0; i < list1.size(); i++) {
			Object[] obj = (Object[]) list1.get(i);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("month", obj[0]);
			jsonObject.put("male", obj[1]);
			jsonObject.put("female", obj[2]);
			jsonObject.put("total", obj[3]);
//			System.err.println("monthhhhhh"+obj[0] );
//			System.err.println("maleeeecount"+obj[1] );
//			System.err.println("femaleeeeecount"+obj[2] );
//			System.err.println("totalllcountt"+obj[3] );


			jSONArray.add(jsonObject);
		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/getpassoutuserschart", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getpassoutuserschart(HttpServletRequest request) {
		System.out.println();
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		List list1 = null;
		if (roleName.equalsIgnoreCase("SUPER ADMIN")) {

			list1 = registrationRepository.getPassoutData();
		} else {
			Integer id = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(id);
			Userloginchild userloginchild = userloginchildRepositroy.findByuseridId(userLogin.get().getUserId());
			TbInstituteDetail institute = instituteRepository.getById(userloginchild.getUserId().getInstituteId());
			System.out.println(institute.getId());
			list1 = registrationRepository.getPassoutData1(institute.getId());
		}
		for (int i = 0; i < list1.size(); i++) {
			Object[] obj = (Object[]) list1.get(i);

			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("total", obj[0]);
			jsonObject.put("year", obj[1]);
//			jsonObject.put("female", obj[2]);
//			jsonObject.put("total", obj[3]);
//
			jSONArray.add(jsonObject);
			System.out.println(jSONArray);
		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getusersinembasychart", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getusersinembasychart(@RequestParam(value = "year", required = false) String year,
			HttpServletRequest request) {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();

		JSONObject object1 = new JSONObject();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		List list1 = null;
		if (roleName.equalsIgnoreCase("EMBASSY ADMIN")) {
			
			Integer id = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(id);

			List<TbCountryName> tbCountryName = countryRepository.findbycountryname(userLogin.get().getInstituteId());
			
			list1 = registrationRepository.getusersinembasychart(Integer.parseInt(year), tbCountryName.get(0).getId());
		}

		for (int i = 0; i < list1.size(); i++) {
			Object[] obj = (Object[]) list1.get(i);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("month", obj[0]);
			jsonObject.put("male", obj[1]);
			jsonObject.put("female", obj[2]);
			jsonObject.put("total", obj[3]);

			jSONArray.add(jsonObject);
		}

		object = new JSONObject();
		object.put("status", "1");
		object.put("message", "success");
		object.put("data", jSONArray);
		return object.toJSONString();

	}

}
