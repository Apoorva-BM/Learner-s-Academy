package org.simplilearn.portal.dao.models;

public class ClassModel {

	private String className;
	public ClassModel(String className) {
		super();
		this.className = className;
	}
	
	public ClassModel() {
		
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
