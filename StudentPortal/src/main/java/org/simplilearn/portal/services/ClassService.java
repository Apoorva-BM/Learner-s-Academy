package org.simplilearn.portal.services;

import org.simplilearn.portal.dao.models.ClassModel;
import org.simplilearn.portal.dao.models.SubjectModel;
import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.User;

public interface ClassService {
	void addClass(User user,ClassModel classModel,TeacherModel teacherModel,SubjectModel subjectModel);
	void deleteClass(User user,String model);
}
