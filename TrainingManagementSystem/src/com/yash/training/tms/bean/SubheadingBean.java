package com.yash.training.tms.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.service.SubheadingService;

@ManagedBean
@SessionScoped
public class SubheadingBean {

	String heading_id;
	String subheadin;
	String completion_status;

	public String getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(String heading_id) {
		this.heading_id = heading_id;
	}

	
	public String getSubheadin() {
		return subheadin;
	}

	public void setSubheadin(String subheadin) {
		this.subheadin = subheadin;
	}

	
	
	public String getCompletion_status() {
		return completion_status;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public String saveSubheading(){
		
		Subheading subheading = new Subheading(); 
		SubheadingService subheadingService = new SubheadingService();
		
		subheading.setHeading_id(heading_id);
		subheading.setSubheadin(subheadin);
		subheading.setCompletion_status(completion_status);
		
		subheadingService.saveSubheadingService(subheading);
		
		return "createdetailcourse";
	}
	
	
}
