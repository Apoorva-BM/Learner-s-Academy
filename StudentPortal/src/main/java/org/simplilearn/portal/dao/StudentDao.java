package org.simplilearn.portal.dao;

import java.util.List;

import org.simplilearn.portal.entities.Student;


public interface StudentDao {
	void add(Student student);
	void delete(String sname);
	List<Student> getAll();
}