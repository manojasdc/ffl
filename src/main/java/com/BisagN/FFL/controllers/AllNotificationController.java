package com.BisagN.FFL.controllers;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbNotificationDtl;
import com.BisagN.FFL.repository.NotificationRepository;
import com.BisagN.controller.AESGCM;
import com.BisagN.models.UserLogin;
import com.BisagN.util.Base64Service;

@RestController
public class AllNotificationController {

	@Autowired
	NotificationRepository notificationRepository;

	@RequestMapping(value = "/admin/allnotificationinside", method = RequestMethod.GET)
	public ModelAndView allnotification(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
//		int totaldata = notificationRepository.LoadNotificationshowData1(Integer.parseInt(sessionuserid));
//
//		int totalpages = (totaldata / 10)+1;
		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request);

		model.addObject("totalpages", totalpages);
		model.setViewName("allnotificationinside");
		return model;
	}

	public long getTotalNumberOfPages(int userId, HttpServletRequest request) {
		long totalRecords = 0;
		int startPage = 1;
		int pageLength = 10;

		totalRecords = (long) LoadCountNotificationData(startPage, pageLength, userId, request);

		// Calculate the total number of pages
		return totalRecords;
	}

	public long LoadCountNotificationData(int startPage, int pageLength, int userId, HttpServletRequest request) {

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		int total = notificationRepository.LoadNotificationshowData1(Integer.parseInt(sessionuserid));

		long lastPage = (total / pageLength);

		if (total % pageLength != 0) {
			lastPage = Math.max(1, lastPage + 1);
		}

		return lastPage;

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getAllNotifications", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getAllNotifications(@RequestBody String data, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		int recordsPerPage = 10;
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("currentPage") != null) {
				String currentPage = jsonObject.get("currentPage").toString();
				int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
				List<TbNotificationDtl> getNotification = notificationRepository.LoadNotificationData1(offset,
						recordsPerPage, Integer.parseInt(sessionuserid));
				int j = 0;
				String notdata = "";
				if (getNotification.size() != 0) {

					for (int i = 0; i < getNotification.size(); i++) {

						j += 1;
						TbNotificationDtl tbNotificationDtl = getNotification.get(i);
						String hidden = "<input type='hidden' name='hid" + j + "' id='hid" + j + "' value='"
								+ Base64Service.encode(
										AESGCM.encrypt(String.valueOf(tbNotificationDtl.getId())).getBytes())
								+ "' /> ";
						String Description = tbNotificationDtl.getDescription();
						Object Time = tbNotificationDtl.getCreatedDate();
						String TimeShow = "";
						Timestamp timestamp = (Timestamp) Time;
						LocalDateTime dateTime = timestamp.toLocalDateTime();

						LocalDateTime currentTime = LocalDateTime.now();
						Duration duration = Duration.between(dateTime, currentTime);

						long minutes = duration.toMinutes();
						long hours = duration.toHours();
						long days = duration.toDays();

						if (days > 0) {
							TimeShow = days + " days ago";
						} else if (hours > 0) {
							TimeShow = hours + " hours ago";
						} else if (minutes > 0) {
							TimeShow = minutes + " minutes ago";
						} else {
							TimeShow = "Just now";
						}

						notdata += "<div class=\"media media-sm bg-warning-10\">\r\n"
								+ "  <div class=\"media-body\">\r\n"
								+ "    <div class=\"d-flex justify-content-between align-items-center\">\r\n"
								+ "      <div class=\"notification-icon\">\r\n"
								+ "        <i class=\"fas fa-bell\"></i>\r\n" + "      </div>\r\n"
								+ "      <div class=\"notification-details\">\r\n" + "        <span>" + Description
								+ "</span>\r\n" + "        <span class=\"time discribe\">\r\n" + "          <time>"
								+ TimeShow + "</time>...\r\n" + "        </span>\r\n" + "      </div>\r\n"
								+ "      <div>\r\n"
								+ "        <a class=\"btn btn-sm icon-btn\" title=\"mark as read\">\r\n"
								+ "          <i class=\"fas fa-times markasreadClassAll\">" + hidden + "</i>\r\n"
								+ "        </a>\r\n" + "      </div>\r\n" + "    </div>\r\n" + "  </div>\r\n"
								+ "</div>";

					}

				}

				int NotificationCounts = notificationRepository
						.LoadNotificationshowData1(Integer.parseInt(sessionuserid));

				jsonobjectout.put("NotificationCounts", NotificationCounts);
				jsonobjectout.put("notdata", notdata);
				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", " Notification Successfully");
				returnstring = jsonobjectout.toJSONString();

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
	@RequestMapping(value = "/admin/getNotifications", method = RequestMethod.POST, produces = { "application/json" })
	public String getNotifications(HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		int recordsPerPage = 10;
		try {
			// Add Server Side Validation TODO

			List<TbNotificationDtl> getNotification = notificationRepository
					.LoadNotificationshowData(Integer.parseInt(sessionuserid));

			int j = 0;
			String notdata = "";
			if (getNotification.size() != 0) {

				for (int i = 0; i < getNotification.size(); i++) {

					j += 1;
					TbNotificationDtl tbNotificationDtl = getNotification.get(i);
					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tbNotificationDtl.getId())).getBytes())
							+ "' /> ";
					String Description = tbNotificationDtl.getDescription();
					Object Time = tbNotificationDtl.getCreatedDate();
					String TimeShow = "";
					Timestamp timestamp = (Timestamp) Time;
					LocalDateTime dateTime = timestamp.toLocalDateTime();

					LocalDateTime currentTime = LocalDateTime.now();
					Duration duration = Duration.between(dateTime, currentTime);

					long minutes = duration.toMinutes();
					long hours = duration.toHours();
					long days = duration.toDays();

					if (days > 0) {
						TimeShow = days + " days ago";
					} else if (hours > 0) {
						TimeShow = hours + " hours ago";
					} else if (minutes > 0) {
						TimeShow = minutes + " minutes ago";
					} else {
						TimeShow = "Just now";
					}

					notdata += "<div class=\"media media-sm bg-warning-10\">\r\n" + "  <div class=\"media-body\">\r\n"
							+ "    <div class=\"d-flex justify-content-between align-items-center\">\r\n"
							+ "      <div class=\"notification-icon\">\r\n"
							+ "        <i class=\"fas fa-bell bell-icon\"></i>\r\n" + "      </div>\r\n"
							+ "      <div class=\"notification-details notify_dtl\" >\r\n"
							+ "        <div class=\"d-flex justify-content-between align-items-center\">\r\n"
							+ "          <div>\r\n" + "            <span class=\"notifydes\">" + Description
							+ "</span>\r\n" + "            <span class=\"time discribe\" >\r\n" + "              <time>"
							+ TimeShow + "</time>...\r\n" + "            </span>\r\n" + "          </div>\r\n"
							+ "          <div>\r\n"
							+ "            <a class=\"btn btn-sm icon-btn\" title=\"Mark as Read\">\r\n"
							+ "              <i class=\"fas fa-times markasreadClass\">" + hidden + "</i>\r\n"
							+ "            </a>\r\n" + "          </div>\r\n" + "        </div>\r\n"
							+ "      </div>\r\n" + "    </div>\r\n" + "  </div>\r\n" + "</div>";

				}

			}

			int NotificationCounts = notificationRepository.LoadNotificationshowData1(Integer.parseInt(sessionuserid));

			jsonobjectout.put("NotificationCounts", NotificationCounts);
			jsonobjectout.put("notdata", notdata);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", " Notification Successfully");
			returnstring = jsonobjectout.toJSONString();

//			} else {
//				jsonobjectout.put("status", "0");
//				jsonobjectout.put("message", "No Data Found");
//				returnstring = jsonobjectout.toJSONString();
//			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/MarkAsReadNotification", method = RequestMethod.POST, produces = {
			"application/json" })
	public String MarkAsReadNotification(@RequestBody String data, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);

			if (jsonObject.get("id") != null) {
				int id = Integer
						.parseInt(AESGCM.decrypt(new String(Base64Service.decode(jsonObject.get("id").toString()))));
				java.util.Optional<TbNotificationDtl> tbnotificationdtl = notificationRepository.findById(id);

				if (tbnotificationdtl != null) {
					TbNotificationDtl tbnotificationdtl2 = tbnotificationdtl.get();
					tbnotificationdtl2.setReadStatus('Y');
					notificationRepository.save(tbnotificationdtl2);

					jsonobjectout.put("status", "1");
					jsonobjectout.put("message", "Notification Read Successfully");
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

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/ClearAllNotification", method = RequestMethod.POST, produces = {
    "application/json" })
public String ClearAllNotification(HttpServletRequest request) {
JSONObject jsonObject = new JSONObject();
JSONObject jsonobjectout = new JSONObject();
String returnstring = "";

try {
    // Add Server Side Validation TODO
    List<TbNotificationDtl> tbnotificationdtl = notificationRepository.findAll();

    for (TbNotificationDtl notification : tbnotificationdtl) {
        notification.setReadStatus('Y'); // Mark as read
        notificationRepository.save(notification); // Save updated notification
    }

    jsonobjectout.put("status", "1");
    jsonobjectout.put("message", "Notifications cleared successfully for all users.");
    returnstring = jsonobjectout.toJSONString();
} catch (Exception e) {
    e.printStackTrace();
    jsonobjectout.put("status", "0");
    jsonobjectout.put("message", "Failure");
    returnstring = jsonobjectout.toJSONString();
}

return returnstring;
}
	
	
}

