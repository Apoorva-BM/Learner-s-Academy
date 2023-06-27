package org.simplilearn.portal.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.portal.config.HibConfig;
import org.simplilearn.portal.dao.AcademicClassDao;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;


public class AcademicClassDaoImpl implements AcademicClassDao{

	@Override
	public void add(AcdemicClass acdemicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(acdemicClass);
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
			AcdemicClass acdemicClass = session.createQuery(" FROM org.simplilearn.portal.entities.AcdemicClass WHERE name = :name", AcdemicClass.class)
                    .setParameter("name", name)
                    .uniqueResult();
			if (acdemicClass != null) {	
				User user = acdemicClass.getUser();
				
				if (user != null) {
                    user.removeFromClass(acdemicClass);
//                    acdemicClass.getSubjects().clear();
//                    acdemicClass.getTeachers().clear();
                    session.merge(user); 
                }
                session.delete(acdemicClass);
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
	public List<AcdemicClass> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<AcdemicClass> query=session.createQuery("select a from org.simplilearn.portal.entities.AcdemicClass a");
		return query.list();
	}

}
