package com.yash.training.tmp.domain;

import java.io.Serializable;

public class Status implements  Serializable {

	int status_id;
	int status;
	
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}

