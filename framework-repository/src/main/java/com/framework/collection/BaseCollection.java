package com.framework.collection;

import org.springframework.data.annotation.Id;

public class BaseCollection {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
