package com.yash.training.tmp.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.util.DBUtil;

/**
 * Session Bean implementation class SubheadingService
 */
@Stateless
@LocalBean
public class SubheadingService implements SubheadingServiceLocal {

    /**
     * Default constructor. 
     */
    public SubheadingService() {
        // TODO Auto-generated constructor stub
    }

	public void saveSubheadingService(Subheading subheading) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO SUBHEADING (HEADING_ID,SUBHEADING,COMPLETION_STATUS) VALUES ('"+ Integer.parseInt(subheading.getHeading_id()) + "','"+ subheading.getSubheadin() + "','"+ subheading.getCompletion_status() + "')";
		
		DBUtil.update(query);
	}

}
