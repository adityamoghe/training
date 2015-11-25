package com.yash.training.tmp.service;

import java.sql.ResultSet; 


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;

@Stateless
@LocalBean
public class UserServiceBean implements UserServiceBeanLocal {
	@Override
	public String authencticateUser(User user) throws Exception {
		ResultSet resultSet;
		// TODO Auto-generated method stub
		System.out.println("inside UserServiceBean:"+user);
		String query="Select * from user where username='"+user.getUsername()+"' AND Password='"+user.getPassword()+"'";
		resultSet=DBUtil.select(query);
		if(resultSet.next()){
			
				Designation designation=new Designation();
				designation.setUser_designationid(resultSet.getInt("user_designationid_fk"));
				user.setDesignation(designation);
				return "success";
		}
			else{
				String query1="Select * from user where Username='"+user.getUsername()+"'";
				String query2="Select * from user where Password='"+user.getPassword()+"'";
				System.out.println(query1);
				System.out.println(query2);

				ResultSet result1=DBUtil.select(query1);
				ResultSet result2=DBUtil.select(query2);
				
					if(result1.next()){
						return "invalid Password";
					}
				
					else if(result2.next()){
						return "invalid username";
					}
				
					return "invalid username and password";		
			}
		
		
		
		
		
		/*String query1="Select * from user where Username='"+user.getUsername()+"'";
		String query2="Select * from user where Password='"+user.getPassword()+"'";
		System.out.println(query1);
		System.out.println(query2);
		ResultSet result1=DBUtil.select(query1);
		ResultSet result2=DBUtil.select(query2);
		System.out.println("authenticate1:"+result1);
		System.out.println("authencticate2:"+result2);
		try {
			while(result1.next()){
				 username=result1.getString("username");
				 password=result1.getString("password");
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
			return "success";
		}
		else if()
		return false;*/
	}

	public UserServiceBean(){
		
	}

	@Override
	public void registerUser(User user, int designation) throws Exception {
		System.out.println("inside registerUser()");
		String query="Insert into user(Name,Contact,Email,Designation,Username,Password) values(' "
				+ user.getUser_name()
				+ "','"
				+ user.getUser_contact()
				+ "','"
				+user.getUser_email_id()
				+ "','"
				+ designation
				+ "','"
				+ user.getUsername()
				+ "','"
				+ user.getPassword()
				+ "')";
		System.out.println(query);
		DBUtil.update(query);
		
	}

}

