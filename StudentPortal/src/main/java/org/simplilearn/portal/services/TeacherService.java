package org.simplilearn.portal.services;

import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.User;

public interface TeacherService {
	void addTeacher(User user,TeacherModel teacherModel);
	void deleteTeacher(User user,String model);
}

