package org.simplilearn.portal.dao.models;

public class TeacherModel {
	private String name;
	private String qualification;
	public TeacherModel() {
	}
	public TeacherModel(String name, String qualification) {
		super();
		this.name = name;
		this.qualification = qualification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
}