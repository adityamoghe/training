package com.yash.training.tmp.domain;

import java.io.Serializable;

public class Role implements  Serializable{

	int role_id;
	int role;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
}
