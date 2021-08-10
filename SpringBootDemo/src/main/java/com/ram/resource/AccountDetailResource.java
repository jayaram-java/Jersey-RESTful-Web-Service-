package com.ram.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.ram.exception.EmployeeNotfoundException;
import com.ram.model.AccountDetail;
import com.ram.model.AccountDetails;
import com.ram.model.Employee;
import com.ram.service.AccountDetailService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "accountdetails")
@Path("/accountdetails")
public class AccountDetailResource {

	@Autowired
	private AccountDetailService accountDetailService;

	@PermitAll
	@POST
	@Consumes("application/json")
	public Response createNewAccount(AccountDetail accountDetail) throws URISyntaxException {

		boolean response = accountDetailService.createNewAccount(accountDetail);
		return Response.status(201).entity("Bank Account is created successfully. Response : " + response).build();

	}

	@PermitAll
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateAccountDetail(@PathParam("id") int id, AccountDetail accountDetail)
			throws URISyntaxException {
		boolean isAccountExist = accountDetailService.isAccountExist(id);
		if (isAccountExist) {
			accountDetailService.updateAccount(accountDetail);
			return Response.status(200).entity("Bank Account details is updated successsfully").build();

		} else {

			return Response.status(404).entity("Bank Account not found").build();
		}

	}

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AccountDetails getAllAccountDetail() {
		AccountDetails accountDetail = new AccountDetails();
		ArrayList<AccountDetail> accountlist = (ArrayList<AccountDetail>) accountDetailService.getAllAccountDetails();
		accountDetail.setAccountDetails(accountlist);
		return accountDetail;
	}
	
	
	
	@PermitAll
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountById(@PathParam("id") int id) throws URISyntaxException {
		boolean isAccountExist = accountDetailService.isAccountExist(id);
		if (isAccountExist) {
			AccountDetail account = accountDetailService.getAccountDetail(id);
			return Response.status(200).entity(account).contentLocation(new URI("/accountdetails/" + id)).build();
		} else {
			return Response.status(404).entity("Account not found").build();
		}

	}
	
	
	@PermitAll
	@DELETE
	@Path("/{id}")
	public Response deleteAccount(@PathParam("id") int id) throws URISyntaxException {
		boolean isAccountExist = accountDetailService.isAccountExist(id);
		if (isAccountExist) {
			accountDetailService.deleteAccountDetail(id);
			return Response.status(200).entity("Account is deleted successsfully").build();
		} else {
			return Response.status(404).entity("Account not found").build();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
