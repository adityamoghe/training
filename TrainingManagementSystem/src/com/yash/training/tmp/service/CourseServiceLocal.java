package com.yash.training.tmp.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Courses;

@Local
public interface CourseServiceLocal {

	public List<Courses> getAllCoursesService();
    
	public void changeStatusMethod(int status, int selectedCourse_id);
	
	public int getStatus(int selectedCourse_id);
	
}
