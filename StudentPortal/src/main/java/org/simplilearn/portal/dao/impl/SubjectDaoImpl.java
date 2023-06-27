package org.simplilearn.portal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.portal.config.HibConfig;
import org.simplilearn.portal.dao.SubjectDao;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.User;

public class SubjectDaoImpl implements SubjectDao{

	@Override
	public void add(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
	}

	@Override
	public void delete(String name) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Subject subject = session.createQuery("FROM org.simplilearn.portal.entities.Subject WHERE name = :name", Subject.class)
                    .setParameter("name", name)
                    .uniqueResult();
			if (subject != null) {	
				User user = subject.getUser();
				
				if (user != null) {
                    user.removeFromSubject(subject);
                    session.merge(user); 
                }
                session.delete(subject);
                tx.commit();
                System.out.println("User deleted successfully!");
                System.out.println(subject.getName());
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
	public List<Subject> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Subject> query=session.createQuery("select s from org.simplilearn.portal.entities.Subject s");
		return query.list();
	}

}
