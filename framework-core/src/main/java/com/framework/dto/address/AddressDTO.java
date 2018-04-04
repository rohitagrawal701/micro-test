package com.framework.dto.address;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String id = "";

	private String city = "";

	private String state = "";

	private String userId = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
