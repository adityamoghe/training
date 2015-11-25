package com.yash.training.tmp.domain;

public class ManagerMenu {
	
	public String getAddTrainees() {
		return addTrainees;
	}
	public void setAddTrainees(String addTrainees) {
		this.addTrainees = addTrainees;
	}
	public String getRemoveTrainer() {
		return removeTrainer;
	}
	public void setRemoveTrainer(String removeTrainer) {
		this.removeTrainer = removeTrainer;
	}
	public String getSeeTraineeMarks() {
		return seeTraineeMarks;
	}
	public void setSeeTraineeMarks(String seeTraineeMarks) {
		this.seeTraineeMarks = seeTraineeMarks;
	}
	private String addTrainees = "Add Trainees";
	private String removeTrainer = "Remove Trainer";
	private String seeTraineeMarks = "See Trainees Marks";
}
