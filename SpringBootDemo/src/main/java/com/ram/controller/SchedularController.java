package com.ram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.ram.service.SMSService;

//@RestController
public class SchedularController {

	@Autowired
	SMSService smsService;

	/*second, minute, hour, day, month, weekday*/
	
	@Scheduled(cron = "0 58 10 ? * *")
	public void sendNotification() {
		
		System.out.println("Schedular concept");

		boolean response = smsService.send();


	}

}
