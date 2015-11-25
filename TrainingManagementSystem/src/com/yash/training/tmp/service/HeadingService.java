package com.yash.training.tmp.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.util.DBUtil;

/**
 * Session Bean implementation class HeadingService
 */
@Stateless
@LocalBean
public class HeadingService implements HeadingServiceLocal {

    /**
     * Default constructor. 
     */
    public HeadingService() {
        // TODO Auto-generated constructor stub
    }

	public void saveHeadingService(Heading heading) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO HEADING (HEADING_TEXT) VALUES ('"
				+ heading.getHeading_text() + "')";
		
		DBUtil.update(query);
 		
	}

}
