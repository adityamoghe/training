package com.yash.training.tmp.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;

public class TestUtil {

	@EJB
	DBUtil dbutil = new DBUtil();

	@Inject
	User user = new User();

	public void selectall() throws SQLException {

		String selectall = "SELECT * FROM USER";
		ResultSet resultSet = dbutil.select(selectall);
		while (resultSet.next())
			;
		{
			user.setUser_id(resultSet.getInt("user_id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setUser_contact(resultSet.getString("user_contact"));
			user.setUser_email_id(resultSet.getString("user_email_id"));
			user.getDesignation().setDesignation(resultSet.getInt("user_designation"));
			user.getStatus().setStatus(resultSet.getInt("user_status"));
			user.getRole().setRole(resultSet.getInt("role"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			System.out.println(user);
			System.out.println("running");
		}
	}

	/*
	 * LoggerProvider.getLogger().info(user);
	 * 
	 * LoggerProvider.getLogger().info(resultSet.getInt("user_id"));
	 * LoggerProvider.getLogger().info(resultSet.getString("firstname"));
	 * LoggerProvider.getLogger().info(resultSet.getString("lastname"));
	 * LoggerProvider.getLogger().info(resultSet.getString("contact"));
	 * LoggerProvider.getLogger().info(resultSet.getString("email"));
	 * LoggerProvider.getLogger().info(resultSet.getInt("designation"));
	 * LoggerProvider.getLogger().info(resultSet.getInt("status"));
	 * LoggerProvider.getLogger().info(resultSet.getInt("role"));
	 * LoggerProvider.getLogger().info(resultSet.getString("username"));
	 * LoggerProvider.getLogger().info(resultSet.getString("password"));
	 */

	public void selectone() throws SQLException {
		String selectone = "SELECT * FROM USER WHERE USER_ID='1'";
		ResultSet resultSet = dbutil.select(selectone);
		while (resultSet.next())
			;
		{
			user.setUser_id(resultSet.getInt("user_id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setUser_contact(resultSet.getString("user_contact"));
			user.setUser_email_id(resultSet.getString("user_email_id"));
			user.getDesignation().setDesignation(resultSet.getInt("user_designation"));
			user.getStatus().setStatus(resultSet.getInt("user_status"));
			user.getRole().setRole(resultSet.getInt("role"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
		}
	}

	public void insert() {
		// TODO Auto-generated method stub

	}

	public void delete() {

	}

	public void deleteone() {

	}

	public static void main(String[] args) throws Exception {

		TestUtil test = new TestUtil();

		/*
		 * LoggerProvider.getLogger().info("check log"); --->:check log working.
		 * 
		 * test.selectall(); // get all user from db success
		 * 
		 * test.selectone(); // get user with id from db success
		 * 
		 * test.insert(); // insert single entry in db success
		 * 
		 * test.deleteone(); // delete selected user in db success
		 */ }

}