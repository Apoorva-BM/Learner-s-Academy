package org.simplilearn.portal.dao;

import java.util.List;

import org.simplilearn.portal.entities.Teacher;

public interface TeacherDao {
	void add(Teacher teacher);
	void delete(String tname);
	List<Teacher> getAll();
	
}
