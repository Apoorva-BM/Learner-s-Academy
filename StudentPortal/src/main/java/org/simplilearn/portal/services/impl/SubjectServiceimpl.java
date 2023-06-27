package org.simplilearn.portal.services.impl;

import org.simplilearn.portal.dao.SubjectDao;
import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.SubjectDaoImpl;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.ClassModel;
import org.simplilearn.portal.dao.models.SubjectModel;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.SubjectService;

public class SubjectServiceimpl implements SubjectService{
	private UserDao userDao=new UserDaoImpl();
	private SubjectDao dao =  new SubjectDaoImpl();

	@Override
	public void addSubject(User user, SubjectModel model,ClassModel  classModel) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Subject subject = new Subject();
		subject.setName(model.getName());
		subject.setMarks(model.getMarks());
		user1.addSubject(subject);
		subject.setUser(user1);
		AcdemicClass acdemicClass = new AcdemicClass();
		acdemicClass.setName(classModel.getClassName());
		subject.setAcdemicClass(acdemicClass);
		dao.add(subject);
	}

	@Override
	public void deleteSubject(User user, String sname) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Subject subject = new Subject();
		subject.setName(sname);
		if (user1 != null) {
            user1.removeFromSubject(subject);
        }
		dao.delete(subject.getName());
		
	}

}
