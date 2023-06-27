package org.simplilearn.portal.services.impl;

import java.util.Set;

import org.simplilearn.portal.dao.AcademicClassDao;
import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.AcademicClassDaoImpl;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.ClassModel;
import org.simplilearn.portal.dao.models.SubjectModel;
import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.ClassService;

public class ClassServiceImpl implements ClassService{
	private UserDao userDao=new UserDaoImpl();
	private AcademicClassDao dao = new AcademicClassDaoImpl();

	@Override
	public void addClass(User user, ClassModel classModel,TeacherModel teacherModel,SubjectModel subjectModel ) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		AcdemicClass acdemicClass = new AcdemicClass();
		Teacher teacher= new Teacher();
		Subject subject = new Subject();
		subject.setName(subjectModel.getClassName());
		teacher.setName(teacherModel.getName());
		user1.addClass(acdemicClass);
		acdemicClass.setUser(user1);
		acdemicClass.setName(classModel.getClassName());
		acdemicClass.addSubject(subject);
		acdemicClass.addTeacher(teacher);
		dao.add(acdemicClass);
	}

	@Override
	public void deleteClass(User user, String model) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		AcdemicClass acdemicClass = new AcdemicClass();
		acdemicClass.setName(model);
		if (user1 != null) {
           Set<Teacher> teacher= acdemicClass.getTeachers();
           for (Teacher teach :teacher) {
            acdemicClass.removeFromTeacher(teach);
           }
            Set<Subject> subject =  acdemicClass.getSubjects();
            		for (Subject subjects :subject) {
            			acdemicClass.removeFromSubject(subjects);
            		}
            user1.removeFromClass(acdemicClass);
        }
		dao.delete(acdemicClass.getName());
		
		
	}

}
