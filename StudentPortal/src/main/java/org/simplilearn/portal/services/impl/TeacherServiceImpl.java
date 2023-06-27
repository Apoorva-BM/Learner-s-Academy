package org.simplilearn.portal.services.impl;

import org.simplilearn.portal.dao.TeacherDao;
import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.TeacherDaoImpl;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	private UserDao userDao=new UserDaoImpl();
	private TeacherDao teacherDao=new TeacherDaoImpl();
	@Override
	public void addTeacher(User user, TeacherModel teacherModel) {
			Teacher teacher=new Teacher();
			teacher.setName(teacherModel.getName());
			teacher.setQual(teacherModel.getQualification());
			User user1=userDao.get(user.getUsername(), user.getPassword());
			user1.addTeacher(teacher);
			teacher.setUser(user1);
			teacherDao.add(teacher);
	}
	@Override
	public void deleteTeacher(User user, String model) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Teacher teacher=new Teacher();
		teacher.setName(model);
		if (user1 != null) {
            user1.removeFromTeacher(teacher);
        }
		teacherDao.delete(teacher.getName());
		
	}
	
}
