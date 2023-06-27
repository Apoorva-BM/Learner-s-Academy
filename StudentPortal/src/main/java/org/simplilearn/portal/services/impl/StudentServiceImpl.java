package org.simplilearn.portal.services.impl;

import org.simplilearn.portal.dao.StudentDao;
import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.StudentDaoImpl;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.StudentModel;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao dao=new StudentDaoImpl();
	private UserDao userDao=new UserDaoImpl();
	@Override
	public void addStudent(User user, StudentModel studentModel) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Student student=new Student();
		student.setSname(studentModel.getName());
		student.setAddress(studentModel.getAddress());
		user1.addStudent(student);
		student.setUser(user1);
		dao.add(student);
	}
	@Override
	public void deleteStudent(User user,String model) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Student student=new Student();
		student.setSname(model);
		if (user1 != null) {
            user1.removeFromHashSet(student);
        }
		dao.delete(student.getSname());
		
	}

}
