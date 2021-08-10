package com.ram.service;

import java.util.List;

import com.ram.model.AccountDetail;

public interface AccountDetailService {
	
	public abstract boolean createNewAccount(AccountDetail accountDetail);
	
	public abstract void updateAccount(AccountDetail accountDetail);
	
	public abstract AccountDetail getAccountDetail(int id);
	
	public abstract List<AccountDetail> getAllAccountDetails();
	
	public abstract void deleteAccountDetail(int id);
	
	public abstract boolean isAccountExist(int id);

}
