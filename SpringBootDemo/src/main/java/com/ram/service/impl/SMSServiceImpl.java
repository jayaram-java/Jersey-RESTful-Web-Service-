package com.ram.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.AccountDetail;
import com.ram.model.NotificationSend;
import com.ram.model.SMSServiceInternal;
import com.ram.repository.NotificationSendRepository;
import com.ram.repository.SMSServiceInternalRepository;
import com.ram.service.SMSService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServiceImpl implements SMSService {

	@Autowired
	private NotificationSendRepository notificationSendRepository;

	@Autowired
	private SMSServiceInternalRepository smsServiceInternalRepository;

	private final String ACCOUNT_SID = "AC2001a8fb734c6e2addd54b47985d574d";

	private final String AUTH_TOKEN = "4f860051576b2f5d0f338d4a8d6978cf";

	private final String FROM_NUMBER = "+14243320699";

	@Override
	public boolean send() {

		boolean response = true;

		List<Object[]> obj = notificationSendRepository.findInitialNotificationList("00");

		List<NotificationSend> notifications = new ArrayList<NotificationSend>();

		for (Object[] ob : obj) {

			NotificationSend notification = new NotificationSend();

			notification.setId((Integer) ob[0]);

			notification.setMobileNumber((String) ob[3]);

			notification.setMessage((String) ob[2]);

			notifications.add(notification);

		}

		for (NotificationSend notificationSend : notifications) {

			Optional<NotificationSend> optional = notificationSendRepository.findById(notificationSend.getId());

			NotificationSend notification = optional.get();

			try {

				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

				Message message = Message.creator(new PhoneNumber(notification.getMobileNumber()),
						new PhoneNumber(FROM_NUMBER), notification.getMessage()).create();
				System.out.println("here is my status:" + message.getStatus());

				notification.setStatusId("02");

				notificationSendRepository.save(notification);

				response = true;

			} catch (Exception e) {

				notification.setStatusId("03");

				notificationSendRepository.save(notification);

				System.out.println(e.getMessage());

				response = false;
			}

		}

		return response;

	}

	@Override
	public void check() {

		for (int i = 0; i < 45; i++) {

			NotificationSend notificationSend = new NotificationSend();

			notificationSend.setMessage("RS.1000 created to A/c ...8982 - Federal bank");

			notificationSend.setMobileNumber("+919487272857");

			notificationSend.setVendorId("AC2001a8fb734c6e2addd54b47985d574d");

			notificationSend.setStatusId("00");

			notificationSend.setCustomerName("Raja");

			notificationSendRepository.save(notificationSend);

		}

	}

	@Override
	public boolean createNewSMSDetails(SMSServiceInternal smsServiceInternal) {

		smsServiceInternalRepository.save(smsServiceInternal);

		return true;
	}

	@Override
	public SMSServiceInternal getSMSDetail(int id) {

		Optional<SMSServiceInternal> optional = smsServiceInternalRepository.findById(id);

		SMSServiceInternal sMSServiceInternal = optional.get();

		return sMSServiceInternal;
	}

	@Override
	public boolean sendSMSForInternalPurpose() {

		boolean response = true;

		List<Object[]> obj = smsServiceInternalRepository.findInitialNotificationList("00");

		List<SMSServiceInternal> notifications = new ArrayList<SMSServiceInternal>();

		for (Object[] ob : obj) {

			SMSServiceInternal notification = new SMSServiceInternal();

			notification.setId((Integer) ob[0]);

			notification.setMobileNumber((String) ob[3]);

			notification.setMessage((String) ob[2]);

			notifications.add(notification);

		}

		for (SMSServiceInternal notificationSend : notifications) {

			Optional<SMSServiceInternal> optional = smsServiceInternalRepository.findById(notificationSend.getId());

			SMSServiceInternal notification = optional.get();

			try {

				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

				Message message = Message.creator(new PhoneNumber(notification.getMobileNumber()),
						new PhoneNumber(FROM_NUMBER), notification.getMessage()).create();
				System.out.println("here is my status:" + message.getStatus());

				notification.setStatusId("02");

				smsServiceInternalRepository.save(notification);

				response = true;

			} catch (Exception e) {

				notification.setStatusId("03");

				smsServiceInternalRepository.save(notification);

				System.out.println(e.getMessage());

				response = false;
			}

		}

		return response;
	}

}
