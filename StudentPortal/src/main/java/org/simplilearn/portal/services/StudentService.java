package org.simplilearn.portal.services;

import org.simplilearn.portal.dao.models.StudentModel;
import org.simplilearn.portal.entities.User;

public interface StudentService {
	void addStudent(User user,StudentModel studentModel);
	void deleteStudent(User user,String model);
}