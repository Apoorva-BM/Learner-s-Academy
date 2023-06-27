package org.simplilearn.portal.services;

import org.simplilearn.portal.dao.models.ClassModel;
import org.simplilearn.portal.dao.models.SubjectModel;
import org.simplilearn.portal.entities.User;

public interface SubjectService {

	void addSubject(User user, SubjectModel model, ClassModel  classModel);
	void deleteSubject(User user, String sname);
	
}
