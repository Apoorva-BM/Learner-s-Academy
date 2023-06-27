package org.simplilearn.portal.services.impl;

import org.simplilearn.portal.dao.UserDao;
import org.simplilearn.portal.dao.impl.UserDaoImpl;
import org.simplilearn.portal.dao.models.LoginModel;
import org.simplilearn.portal.dao.models.UserModel;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDaoImpl();
	@Override
	public void register(UserModel userModel) {
		User user=new User();
		user.setUsername(userModel.getUsername());
		user.setPassword(userModel.getPassword());
		user.setEmail(userModel.getEmail());
		dao.insert(user);
	}
	@Override
	public User getUser(LoginModel loginModel) {
		return dao.get(loginModel.getUsername(), loginModel.getPassword());
	}

}
