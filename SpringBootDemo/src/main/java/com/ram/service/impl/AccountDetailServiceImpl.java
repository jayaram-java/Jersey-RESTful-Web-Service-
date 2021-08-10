package com.ram.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.AccountDetail;
import com.ram.model.Employee;
import com.ram.repository.AccountDetailRepository;
import com.ram.service.AccountDetailService;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

	@Autowired
	private AccountDetailRepository accountDetailRepository;

	@Override
	public boolean createNewAccount(AccountDetail accountDetail) {

		accountDetail.setCreatedBy("Ram");

		accountDetail.setCreatedDate(new Date());

		accountDetailRepository.save(accountDetail);

		return true;
	}

	@Override
	public void updateAccount(AccountDetail accountDetail) {

		accountDetail.setModifiedBy("Ram");

		accountDetail.setModifiedDate(new Date());

		accountDetailRepository.save(accountDetail);

	}

	@Override
	public AccountDetail getAccountDetail(int id) {

		Optional<AccountDetail> optional = accountDetailRepository.findById(id);

		AccountDetail accountDetail = optional.get();

		return accountDetail;
	}

	@Override
	public List<AccountDetail> getAllAccountDetails() {

		List<AccountDetail> accountDetails = (List<AccountDetail>) accountDetailRepository.findAll();

		return accountDetails;
	}

	@Override
	public void deleteAccountDetail(int id) {

		accountDetailRepository.deleteById(id);
	}

	@Override
	public boolean isAccountExist(int id) {

		return accountDetailRepository.existsById(id);
	}

}
