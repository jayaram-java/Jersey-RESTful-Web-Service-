package com.ram.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.NONE)
@Table(name = "website_link_details")
@XmlRootElement(name = "website_link_details")
public class WebSiteLinkDetails {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@XmlAttribute(name = "id")
	private Long id;

	@Column(name = "property_name")
	@XmlElement(name = "property_name")
	private String name;

	@Column(name = "description")
	@XmlElement(name = "description")
	private String description;

	@Column(name = "website_link")
	@XmlElement(name = "website_link")
	private String webSiteLink;

	@Column(name = "created_date")
	@XmlElement(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_date")
	@XmlElement(name = "modified_date")
	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebSiteLink() {
		return webSiteLink;
	}

	public void setWebSiteLink(String webSiteLink) {
		this.webSiteLink = webSiteLink;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
