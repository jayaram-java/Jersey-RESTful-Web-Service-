package com.ram.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ram.model.WebSiteLinkDetails;
import com.ram.service.WebSiteLinkService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "websitelinkresources")
@Path("/websitelinkresources")
public class WebSiteLinkResource {

	@Autowired
	private WebSiteLinkService webSiteLinkService;

	@RolesAllowed("ADMIN")
	@POST
	@Consumes("application/json")
	public Response createWebLink(WebSiteLinkDetails webSiteLinkDetails) throws URISyntaxException {

		webSiteLinkDetails = webSiteLinkService.createWebSiteLink(webSiteLinkDetails);
		return Response.status(201).entity("Web link is created successfully with id = " + webSiteLinkDetails.getId())
				.contentLocation(new URI("/employees/" + webSiteLinkDetails.getId())).build();
	}
	
	
	@PermitAll
	@GET
	@Path("/{property}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getAllEmployees(@PathParam("property") String property) throws URISyntaxException
	{
		JsonObject jsonObject = new JsonObject();
		List<WebSiteLinkDetails> webSiteLinkDetails = webSiteLinkService.getWebSiteLinksBasedonProperty(property);
		
		jsonObject.add("web link", new Gson().toJsonTree(webSiteLinkDetails));
		
		return jsonObject;
	}

}
