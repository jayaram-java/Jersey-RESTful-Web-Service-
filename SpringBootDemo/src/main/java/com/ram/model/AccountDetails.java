package com.ram.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "accountdetails")
public class AccountDetails {

	@XmlElement(name = "accountdetails")
	private ArrayList<AccountDetail> accountDetails;

	public ArrayList<AccountDetail> getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(ArrayList<AccountDetail> accountDetails) {
		this.accountDetails = accountDetails;
	}

}
