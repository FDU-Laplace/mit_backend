package com.missiongroup.starring.common.domain;

import java.io.Serializable;

public class PropertyObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String type;

	private String bProperty;

	private String sProperty;

	private String description;

	public PropertyObject() {
		
	}
	
	public PropertyObject(String type, String bProperty, String sProperty, String description) {
		this.type = type;
		this.bProperty = bProperty;
		this.sProperty = sProperty;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getbProperty() {
		return bProperty;
	}

	public void setbProperty(String bProperty) {
		this.bProperty = bProperty;
	}

	public String getsProperty() {
		return sProperty;
	}

	public void setsProperty(String sProperty) {
		this.sProperty = sProperty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
