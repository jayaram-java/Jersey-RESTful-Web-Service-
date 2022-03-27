/**
 * 
 */
package com.ram.model;

import java.io.Serializable;
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

/**
 * @author jayaram
 *
 */

@Entity
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "present_activity")
@Table(name = "present_activity")
public class PresentActivity  {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@XmlAttribute(name = "id")
	private Long id;

	@Column(name = "name")
	@XmlElement(name = "name")
	private String name;

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
