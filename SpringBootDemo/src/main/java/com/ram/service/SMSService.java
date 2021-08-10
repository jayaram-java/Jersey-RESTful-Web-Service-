package com.ram.service;

import com.ram.model.SMSServiceInternal;

public interface SMSService {

	SMSServiceInternal getSMSDetail(int n);

	public boolean send();

	public void check();

	public boolean createNewSMSDetails(SMSServiceInternal smsServiceInternal);

	public boolean sendSMSForInternalPurpose();

}
