package com.ram.service;

import java.util.List;

import com.ram.model.WebSiteLinkDetails;

public interface WebSiteLinkService {

	public abstract WebSiteLinkDetails createWebSiteLink(WebSiteLinkDetails webSiteLinkDetails);

	public abstract List<WebSiteLinkDetails> getWebSiteLinksBasedonProperty(String property);

}
