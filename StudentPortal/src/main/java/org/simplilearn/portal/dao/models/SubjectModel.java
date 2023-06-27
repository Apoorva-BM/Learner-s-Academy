package org.simplilearn.portal.dao.models;

public class SubjectModel {

	private String name;
	private int marks;
	private String className;
	
	public SubjectModel() {
		
	}

	

	public String getClassName() {
		return className;
	}



	public void setClassName(String className) {
		this.className = className;
	}



	public SubjectModel(String name, int marks, String className) {
		super();
		this.name = name;
		this.marks = marks;
		this.className = className;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
