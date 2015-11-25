package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.DetailsPrint;
import com.yash.training.tmp.util.DBUtil;


/**
 * Session Bean implementation class CourseService
 */
@Stateless
@LocalBean
public class CourseService implements CourseServiceLocal {

	/**
	 * Default constructor.
	 */
	public CourseService() {
		// TODO Auto-generated constructor stub
	}

	public void saveCourses(Courses courses) {
		// TODO Auto-generated method stub

		String query = "INSERT INTO COURSES (COURSE_TITLE,DESCRIPTION,REFERENCE_CODE,IMAGE,STATUS) VALUES ('"
				+ courses.getCourseTitle() + "','" + courses.getDescription() + "','" + courses.getReferenceCode()
				+ "','" + courses.getImage() + "','" + courses.getStatus() + "') ";

		DBUtil.update(query);

	}

	public List<Courses> getAllCoursesService() {
		// TODO Auto-generated method stub

		String query = "SELECT * FROM COURSES";

		ResultSet resultSet = DBUtil.select(query);

		List<Courses> listOfCourses = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Courses courses = new Courses();
				courses.setCourseTitle(resultSet.getString("COURSE_TITLE"));
				courses.setDescription(resultSet.getString("DESCRIPTION"));
				courses.setReferenceCode(resultSet.getString("REFERENCE_CODE"));
				courses.setStatus(resultSet.getString("STATUS"));
				courses.setCourseTitle(resultSet.getString("COURSE_ID"));
				listOfCourses.add(courses);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfCourses;

	}

	public List<DetailsPrint> getCoursesDetailsService() {
		// TODO Auto-generated method stub

		String query = "SELECT c.course_title, c.reference_code, h.heading_text, s.subheading, s.completion_status FROM courses AS c , heading AS h , subheading AS s WHERE c.course_id=h.course_id AND h.heading_id= h.heading_id";
		// String query = "SELECT * FROM COURSES";

		ResultSet resultSet = DBUtil.select(query);

		List<DetailsPrint> detailsOfCourses = new ArrayList<>();

		try {
			while (resultSet.next()) {
				/*
				 * Courses courses = new Courses();
				 * 
				 * courses.setCourseTitle(resultSet.getString("COURSE_TITLE"));
				 * courses.setReferenceCode(resultSet.getString("REFERENCE_CODE"
				 * ));
				 * 
				 * detailsOfCourses.add(courses);
				 */

				DetailsPrint detailsPrint = new DetailsPrint();

				detailsPrint.setCourseTitle(resultSet.getString("COURSE_TITLE"));
				detailsPrint.setReferenceCode(resultSet.getString("REFERENCE_CODE"));
				detailsPrint.setHeading_text(resultSet.getString("HEADING_TEXT"));
				detailsPrint.setSubheading(resultSet.getString("SUBHEADING"));
				detailsPrint.setCompletion_status(resultSet.getString("COMPLETION_STATUS"));
				
				
				detailsOfCourses.add(detailsPrint);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(detailsOfCourses);
		return detailsOfCourses;

	}

	public List<DetailsPrint> getCoursesDetailsService1() {
		// TODO Auto-generated method stub

		String query = "SELECT c.course_title, c.reference_code, h.heading_text, s.subheading, s.completion_status FROM courses AS c , heading AS h , subheading AS s WHERE c.course_id=h.course_id AND h.heading_id= s.heading_id";
		// String query = "SELECT * FROM COURSES";

		ResultSet resultSet = DBUtil.select(query);

		List<DetailsPrint> detailsOfCourses = new ArrayList<>();

		try {
			while (resultSet.next()) {
				/*
				 * Courses courses = new Courses();
				 * 
				 * courses.setCourseTitle(resultSet.getString("COURSE_TITLE"));
				 * courses.setReferenceCode(resultSet.getString("REFERENCE_CODE"
				 * ));
				 * 
				 * detailsOfCourses.add(courses);
				 */

				DetailsPrint detailsPrint = new DetailsPrint();

				detailsPrint.setCourseTitle("COURSE_TITLE");
				detailsPrint.setReferenceCode("REFERENCE_CODE");
				detailsPrint.setHeading_text("HEADING_TEXT");
				detailsPrint.setSubheading("SUBHEADING");
				detailsPrint.setCompletion_status("COMPLETION_STATUS");

				detailsOfCourses.add(detailsPrint);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(detailsOfCourses);
		return detailsOfCourses;

	}

	@Override
	public void changeStatusMethod(int status, int selectedCourse_id) {
		// TODO Auto-generated method stub

		String query = "UPDATE COURSEs SET STATUS = " + status + " WHERE COURSE_ID = " + selectedCourse_id;

		DBUtil.select(query);

	}

	@Override
	public int getStatus(int selectedCourse_id) {
		// TODO Auto-generated method stub
		
		String query = "SELECT STATUS FROM COURSES WHERE COURSE_ID = " +selectedCourse_id ;
		int status = 0;
		ResultSet resultSet = DBUtil.select(query);
			try {
				while(resultSet.next()){
				if(resultSet.getInt(1) == 1){
				}
				else{
					status = 1;
				}
			 } 
		   }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return status;

	}
	
	
	public List<Courses> getAllCoursesService(int userid) {

		String sql = "SELECT * FROM COURSES WHERE USER_ID = "+userid;
		ResultSet resultSet = DBUtil.select(sql);
		List<Courses> clist = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Courses course = new Courses();
				course.setCourse_id(resultSet.getInt("COURSE_ID"));
				course.setCourseTitle(resultSet.getString("COURSE_TITLE"));
				course.setReferenceCode(resultSet.getString("REFERENCE_CODE"));
				course.setDescription(resultSet.getString("DESCRIPTION"));
				course.setStatus(resultSet.getString("STATUS"));
				
				String statustdb= resultSet.getString("STATUS");
				int status = Integer.parseInt(statustdb);

				
				if(status == 1){
					course.setButton_value("Deactivate");
				}
				
				if(resultSet.getInt("COURSE_STATUS") == 0){
					course.setButton_value("Activate");
				}
				clist.add(course);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clist;
	}

}
