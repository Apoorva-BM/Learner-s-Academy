package org.simplilearn.portal.services.impl;

import java.util.Set;

import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.ReportModel;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.ReportService;

public class ReportServiceImpl implements ReportService{
	private UserDao userDao=new UserDaoImpl();
	private ReportModel reportModel= new ReportModel();
	
	@Override
	public ReportModel generateClassReport(User user) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		
		Set<AcdemicClass> classes = user.getClasses();
		Set<Subject> subjects = user.getSubjects();
	    Set<Teacher> teachers = user.getTeachers();
	    Set<Student> students =user.getStudents();
	    
	    reportModel.setClasses(classes);
	    reportModel.setStudents(students);
	    reportModel.setSubjects(subjects);
	    reportModel.setTeachers(teachers);
	    
		return reportModel;
	}

}
