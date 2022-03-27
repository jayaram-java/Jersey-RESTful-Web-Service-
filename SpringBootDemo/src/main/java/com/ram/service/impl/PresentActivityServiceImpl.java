package com.ram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.PresentActivity;
import com.ram.repository.PresentActivityRepository;
import com.ram.service.PresentActivityService;

@Service
public class PresentActivityServiceImpl implements PresentActivityService {

	@Autowired
	private PresentActivityRepository presentActivityRepository;

	@Override
	public void updateDailyActivity(PresentActivity presentActivity) {
		
		System.out.println(presentActivity.getName());
		
		System.out.println(presentActivity.getId());

		Optional<PresentActivity> presentActivitz = presentActivityRepository.findById(presentActivity.getId());
		
		PresentActivity presentActivityk = presentActivitz.get();

		presentActivityk.setName(presentActivity.getName());
		
		presentActivityk.setModifiedDate(new Date());

		presentActivityRepository.save(presentActivityk);

	}
	
	

}
