package com.yash.training.tms.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.service.HeadingService;

@ManagedBean
@SessionScoped
public class HeadingBean {

	String heading_text;
	int course_id;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getHeading_text() {
		return heading_text;
	}

	public void setHeading_text(String heading_text) {
		this.heading_text = heading_text;
	}

	public String headingSave() {

		Heading heading = new Heading();
		HeadingService headingService = new HeadingService();

		heading.setHeading_text(heading_text);

		headingService.saveHeadingService(heading);

		return "createdetailcourse";
	}

}
