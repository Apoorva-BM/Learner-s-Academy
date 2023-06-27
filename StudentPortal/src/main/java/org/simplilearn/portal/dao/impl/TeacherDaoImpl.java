package org.simplilearn.portal.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.portal.config.HibConfig;
import org.simplilearn.portal.dao.TeacherDao;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;


public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void add(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public void delete(String tname) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Teacher teacher = session.createQuery(" FROM org.simplilearn.portal.entities.Teacher WHERE name = :name", Teacher.class)
                    .setParameter("name", tname)
                    .uniqueResult();
			if (teacher != null) {	
				User user = teacher.getUser();
				
				if (user != null) {
                    user.removeFromTeacher(teacher);
                    session.merge(user); 
                }
                session.delete(teacher);
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
	public List<Teacher> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Teacher> query=session.createQuery("select t from org.simplilearn.portal.entities.Teacher t");
		return query.list();
	}

}
