package com.ram.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.WebSiteLinkDetails;
import com.ram.repository.WebSiteLinkDetailsRepository;
import com.ram.service.WebSiteLinkService;

@Service
public class WebSiteLinkServiceImpl implements WebSiteLinkService {

	@Autowired
	private WebSiteLinkDetailsRepository webSiteLinkDetailsRepository;

	@Override
	public WebSiteLinkDetails createWebSiteLink(WebSiteLinkDetails webSiteLinkDetails) {
		
		webSiteLinkDetails.setCreatedDate(new Date());

		return webSiteLinkDetailsRepository.save(webSiteLinkDetails);
	}

	@Override
	public List<WebSiteLinkDetails> getWebSiteLinksBasedonProperty(String property) {
		
		 List<WebSiteLinkDetails>  webSiteLinkDetails = webSiteLinkDetailsRepository.findByName(property);

		return webSiteLinkDetails;
	}

}
