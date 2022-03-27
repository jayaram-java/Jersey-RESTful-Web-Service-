package com.ram.resource;

import java.net.URISyntaxException;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.ram.model.PresentActivity;
import com.ram.service.PresentActivityService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "presentactivity")
@Path("/presentactivity")
public class PresentActivityResource {

	@Autowired
	private PresentActivityService presentActivityService;
	
	@RolesAllowed("ADMIN")
	@POST
	@Consumes("application/json")
	public Response updateDailyActivity(PresentActivity presentActivity) throws URISyntaxException {

		presentActivityService.updateDailyActivity(presentActivity);

		return Response.status(201).entity("daily activity updated successfully").build();

	}

}
