package com.framework.dto.user;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String id = "";

	private String name = "";

	private int age = 0;

	private String height = "";

	//	private List<AddressDTO> AddressDto = null;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//	public List<AddressDTO> getAddressDto() {
	//		return AddressDto;
	//	}
	//
	//	public void setAddressDto(List<AddressDTO> addressDto) {
	//		AddressDto = addressDto;
	//	}

}
