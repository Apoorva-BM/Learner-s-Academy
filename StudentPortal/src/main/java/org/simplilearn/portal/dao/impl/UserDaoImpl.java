package org.simplilearn.portal.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.portal.config.HibConfig;
import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.entities.User;


public class UserDaoImpl implements UserDao{
	
	@Override
	public void insert(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public User get(String username, String password) {
		SessionFactory factory=null;
		Session session=null;
		Query<User> query=null;
		User user=null;
		try
		{
		factory=HibConfig.getSessionFactory();
		session=factory.openSession();
		query=session.createQuery("select u from org.simplilearn.portal.entities.User u where u.username=?1 and u.password=?2");
		query.setParameter(1, username);
		query.setParameter(2, password);
		user=query.uniqueResult();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return user;
	}

}
