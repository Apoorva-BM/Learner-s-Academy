package org.simplilearn.portal.dao;

import java.util.List;

import org.simplilearn.portal.entities.Subject;



public interface SubjectDao {
	void add(Subject subject);
	void delete(String sname);
	List<Subject> getAll();
}
