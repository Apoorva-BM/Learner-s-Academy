package org.simplilearn.portal.dao.models;

import java.util.Set;

import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.Teacher;

public class ReportModel {

	private Set<AcdemicClass> classes;
	private Set<Subject> subjects;
	private Set<Teacher> teachers;
	private Set<Student> students;
	
	public ReportModel() {
		// TODO Auto-generated constructor stub
	}

	public ReportModel(Set<AcdemicClass> classes, Set<Subject> subjects, Set<Teacher> teachers, Set<Student> students) {
		super();
		this.classes = classes;
		this.subjects = subjects;
		this.teachers = teachers;
		this.students = students;
	}

	public Set<AcdemicClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<AcdemicClass> classes) {
		this.classes = classes;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
