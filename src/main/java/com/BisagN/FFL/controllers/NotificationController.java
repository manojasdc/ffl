package com.BisagN.FFL.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BisagN.FFL.models.TbNotificationDtl;
import com.BisagN.FFL.repository.NotificationRepository;


@Service
public class NotificationController {

	@Autowired
	NotificationRepository notificationRepository;

	public String SaveNotification(String description, Integer notoficationfrom, Integer notificationto, Integer createdby) {

		String returnstring = "";
		JSONObject jsonobjectout = new JSONObject();
		try {

			TbNotificationDtl notificationmst1 = new TbNotificationDtl();
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

			Date ff = sdf.parse(new Date().toString());

			notificationmst1.setDescription(description);
			notificationmst1.setNotificationFromId(notoficationfrom);
			notificationmst1.setNotificationToId(notificationto);
			notificationmst1.setReadStatus('N');
			notificationmst1.setCreatedBy(createdby);
			notificationmst1.setCreatedDate(ff);
			notificationmst1.setStatus('1');
			notificationRepository.save(notificationmst1);
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}
		return returnstring;
	}
	
	public String SaveNotificationregistraion(String description, Integer notoficationfrom, Integer notificationto) {

		String returnstring = "";
		JSONObject jsonobjectout = new JSONObject();
		try {

			TbNotificationDtl notificationmst1 = new TbNotificationDtl();
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

			Date ff = sdf.parse(new Date().toString());

			notificationmst1.setDescription(description);
			notificationmst1.setNotificationFromId(notoficationfrom);
			notificationmst1.setNotificationToId(notificationto);
			notificationmst1.setReadStatus('N');
			notificationmst1.setCreatedBy(notoficationfrom);
			notificationmst1.setCreatedDate(ff);
			notificationmst1.setStatus('1');
			notificationRepository.save(notificationmst1);
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", e.getMessage());
			returnstring = jsonobjectout.toJSONString();
		}
		return returnstring;
	}

	public void sharedMethod() {
	}
}