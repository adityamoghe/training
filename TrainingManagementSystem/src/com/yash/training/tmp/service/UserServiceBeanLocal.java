package com.yash.training.tmp.service;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.User;

@Local
public interface UserServiceBeanLocal {
	public String authencticateUser(User user) throws Exception;

	public void registerUser(User user, int designation) throws Exception;
}
