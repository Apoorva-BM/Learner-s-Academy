package org.simplilearn.portal.dao.models;


public class StudentModel {
	private String name;
	private String address;
	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
	public StudentModel(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
