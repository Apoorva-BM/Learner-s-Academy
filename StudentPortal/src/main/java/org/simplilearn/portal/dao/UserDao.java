package org.simplilearn.portal.dao;

import org.simplilearn.portal.entities.User;

public interface UserDao {
	void insert(User user);
	User get(String username,String password);
}
