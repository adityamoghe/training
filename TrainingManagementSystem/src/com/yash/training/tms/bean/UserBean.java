package com.yash.training.tms.bean;

import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;


import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.ManagerMenu;
import com.yash.training.tmp.domain.TraineeMenu;
import com.yash.training.tmp.domain.TrainerMenu;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.UserServiceBeanLocal;

@ManagedBean
@javax.faces.bean.SessionScoped
public class UserBean {
	@EJB
	UserServiceBeanLocal userbeanservice;
	private String userName;
	private String password;
	private String name;
	private String contact;
	private int designation;
	
	private String email;
	/*List<String> managerMenuList = new ArrayList<String>();
	List<String> trainerMenuList = new ArrayList<String>();
	List<String> traineeMenuList = new ArrayList<String>();*/
	List<String> listToBePopulated = new ArrayList<>();
	User user = new User();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public List<String> getManagerMenuList() {
		return managerMenuList;
	}

	public void setManagerMenuList(List<String> managerMenuList) {
		this.managerMenuList = managerMenuList;
	}

	public List<String> getTrainerMenuList() {
		return trainerMenuList;
	}

	public void setTrainerMenuList(List<String> trainerMenuList) {
		this.trainerMenuList = trainerMenuList;
	}

	public List<String> getTraineeMenuList() {
		return traineeMenuList;
	}

	public void setTraineeMenuList(List<String> traineeMenuList) {
		this.traineeMenuList = traineeMenuList;
	}
*/
	public List<String> getListToBePopulated() {
		return listToBePopulated;
	}

	public void setListToBePopulated(List<String> listToBePopulated) {
		this.listToBePopulated = listToBePopulated;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String LoginAction() throws Exception {
		System.out.println("inside login");
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		System.out.println("login" + user);
		String message = userbeanservice.authencticateUser(user);
		System.out.println(message);
	if (message.equals("success")) {
			
			int designation_id = user.getDesignation().getUser_designationid();
			System.out.println("Designation:"+designation_id);
			if (designation_id == 1) {
				ManagerMenu managerMenu=new ManagerMenu();
				listToBePopulated.add(managerMenu.getAddTrainees());
				listToBePopulated.add(managerMenu.getRemoveTrainer());
				listToBePopulated.add(managerMenu.getSeeTraineeMarks());
				for (String printList: listToBePopulated){
					System.out.println(printList);
				}
			}

			else if (designation_id == 2) {
				TrainerMenu trainerMenu=new TrainerMenu();
				listToBePopulated.add(trainerMenu.getAddTrainees());
				listToBePopulated.add(trainerMenu.getRemoveTrainee());
				listToBePopulated.add(trainerMenu.getSeeTraineeMarks());
				for (String printList: listToBePopulated){
					System.out.println(printList);
				}
			}

			else if (designation_id == 3) {
				TraineeMenu traineeMenu=new TraineeMenu();
				listToBePopulated.add(traineeMenu.getSeeTraineeMarks());
				for (String printList: listToBePopulated){
					System.out.println(printList);
				}
			}

			

			
			return "content";
		} else {
			return "index?err=" + message + " faces-redirect=true";
		}
	
		// index?err=invalid username or password faces-redirect=true
	}

	
	public String LoginAction1() throws Exception {
		System.out.println("inside login");
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		System.out.println("login" + user);
		String message = userbeanservice.authencticateUser(user);
		System.out.println(message);
	
		if (message.equals("success")) {
			

			
			return "homemaincontent";}
		else{
			return "index?err=" + message + " faces-redirect=true";
		}
		} 
	
		
	
	
	public String registrationAction() throws Exception {
		System.out.println("inside registration" + designation);
		User user = new User();
		user.setUser_name(name);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUser_email_id(email);
		user.setUser_contact(contact);

		userbeanservice.registerUser(user, designation);
		return "index.xhtml";

	}

	Designation desi = new Designation();
/*
	@Inject
	ManagerMenu managerMenu;
	@Inject
	TrainerMenu trainerMenu;
	@Inject
	TraineeMenu traineeMenu;
*/
	/*User userAuthenticate(String username, String password) {
		
		
		
		
		int designation_id = user.getDesignation().getUser_designationid();

		if (designation_id == 1) {
			ManagerMenu managerMenu=new ManagerMenu();
			listToBePopulated.add(managerMenu.getAddTrainees());
			listToBePopulated.add(managerMenu.getRemoveTrainer());
			listToBePopulated.add(managerMenu.getSeeTraineeMarks());
			for (String printList: listToBePopulated){
				System.out.println(printList);
			}
		}

		else if (designation_id == 2) {
			TrainerMenu trainerMenu=new TrainerMenu();
			listToBePopulated.add(trainerMenu.getAddTrainees());
			listToBePopulated.add(trainerMenu.getRemoveTrainee());
			listToBePopulated.add(trainerMenu.getSeeTraineeMarks());
			for (String printList: listToBePopulated){
				System.out.println(printList);
			}
		}

		else if (designation_id == 3) {
			TraineeMenu traineeMenu=new TraineeMenu();
			listToBePopulated.add(traineeMenu.getSeeTraineeMarks());
			for (String printList: listToBePopulated){
				System.out.println(printList);
			}
		}

		return user ;

	}
*/
}
