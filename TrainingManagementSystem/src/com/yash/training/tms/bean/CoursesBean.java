package com.yash.training.tms.bean;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.DetailsPrint;
import com.yash.training.tmp.service.CourseService;

@ManagedBean
@SessionScoped
public class CoursesBean {

	String courseTitle;
	String description;
	String referenceCode;
	String status;
	String image;
	String value;
	private int selectedCourse_id;
	private int userid;
	
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSelectedCourse_id() {
		return selectedCourse_id;
	}

	public void setSelectedCourse_id(int selectedCourse_id) {
		this.selectedCourse_id = selectedCourse_id;
	}

	List<Courses> courseList = new ArrayList<>();

	List<DetailsPrint> courseDetailsList = new ArrayList<>();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<DetailsPrint> getCourseDetailsList() {
		return courseDetailsList;
	}

	public void setCourseDetailsList(List<DetailsPrint> courseDetailsList) {
		this.courseDetailsList = courseDetailsList;
	}

	public List<Courses> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String save() {

		Courses courses = new Courses();
		CourseService courseService = new CourseService();

		courses.setCourseTitle(courseTitle);
		courses.setDescription(description);
		courses.setImage(image);
		courses.setReferenceCode(referenceCode);
		courses.setStatus(status);
		System.out.println(courseTitle);
		System.out.println(description);
		System.out.println(courses);
		courseService.saveCourses(courses);

		return "homemaincontent";

	}

	CourseService courseService = new CourseService();

	public String printCourses() {

		courseList = courseService.getAllCoursesService();

		return "courses";
	}

	public String displayDetails() {

		courseDetailsList = courseService.getCoursesDetailsService();

		return "details";

	}
	
	
	
	public String changeStatusMethod() {
		
		int receivedStatus = courseService.getStatus(selectedCourse_id);
		courseService.changeStatusMethod(receivedStatus,selectedCourse_id);
		
		return "courses";
	}
	
	public List<Courses> getCourseList1() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		courseList = courseService.getAllCoursesService(userid);
		return courseList;
	}

}
