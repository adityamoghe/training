package com.yash.training.tmp.service;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Heading;

@Local
public interface HeadingServiceLocal {
	
	public void saveHeadingService(Heading heading);
}
