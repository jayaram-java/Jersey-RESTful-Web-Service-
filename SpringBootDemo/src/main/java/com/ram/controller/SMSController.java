package com.ram.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.SMSServiceInternal;
import com.ram.service.SMSService;

//@RestController
public class SMSController {

	@Autowired
	SMSService smsService;

	@PermitAll
	@RequestMapping("/sendPushNotifications")
	public Response sendNotification() {

		boolean response = smsService.send();

		return Response.status(201).entity("Push notification result. Response : " + response).build();
	}

	@RolesAllowed("ADMIN")
	@RequestMapping("/createnewsmsdetail")
	public boolean createNewSMSDetail(@RequestBody SMSServiceInternal smsServiceInternal) {

		boolean response = smsService.createNewSMSDetails(smsServiceInternal);
		return response;

	}

	@PermitAll
	@RequestMapping("/sendSMSForInternalPurpose")
	public Response sendSMSForInternalPurpose() {

		boolean response = smsService.sendSMSForInternalPurpose();

		return Response.status(201).entity("SMS process is . Response : " + response).build();
	}

}
