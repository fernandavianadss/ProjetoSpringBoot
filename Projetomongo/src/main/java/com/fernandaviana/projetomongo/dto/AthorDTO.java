package com.fernandaviana.projetomongo.dto;

import com.fernandaviana.projetomongo.domain.User;

public class AthorDTO {
	
	private String id;
	private String name;
	
	public AthorDTO() {
		
	}
	
	public AthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
