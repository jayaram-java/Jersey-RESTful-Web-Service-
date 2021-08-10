package com.ram.resource;

import java.net.URISyntaxException;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.ram.model.SMSServiceInternal;
import com.ram.service.SMSService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "smsservice")
@Path("/smsservice")
public class SMSServiceResource {
	
	@Autowired
	SMSService smsService;
	
	@RolesAllowed("ADMIN")
	@POST
	@Consumes("application/json")
	public Response createNewSMSDetail(SMSServiceInternal smsServiceInternal) throws URISyntaxException {

		boolean response = smsService.createNewSMSDetails(smsServiceInternal);
		return Response.status(201).entity("SMS details saved successfully. Response : " + response).build();

	}
	
	
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SMSServiceInternal getSingleSMSDetail() {
		SMSServiceInternal sMSServiceInternal = smsService.getSMSDetail(1);
		return sMSServiceInternal;
	}
	
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendPushNotifications")
	public Response sendNotification() {

		boolean response = smsService.send();

		return Response.status(201).entity("Push notification result. Response : " + response).build();
	}
	
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendSMSForInternalPurpose")
	public Response sendSMSForInternalPurpose() {

		boolean response = smsService.sendSMSForInternalPurpose();

		return Response.status(201).entity("SMS process is . Response : " + response).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
