package org.simplilearn.portal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.portal.config.HibConfig;
import org.simplilearn.portal.dao.StudentDao;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.User;


public class StudentDaoImpl implements StudentDao{
	@Override
	public void add(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public void delete(String sname) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Student student = session.createQuery(" FROM org.simplilearn.portal.entities.Student WHERE sname = :sname", Student.class)
                    .setParameter("sname", sname)
                    .uniqueResult();
			if (student != null) {	
				User user = student.getUser();
				
				if (user != null) {
                    user.removeFromHashSet(student);
                    session.merge(user); 
                }
                session.delete(student);
                tx.commit();
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found!");
            }
			
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
		}
		session.close();
	}

	@Override
	public List<Student> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Student> query=session.createQuery("select s from org.simplilearn.portal.entities.Student s");
		return query.list();
	}

}

