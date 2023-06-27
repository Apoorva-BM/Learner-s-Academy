package org.simplilearn.portal.services;

import org.simplilearn.portal.dao.models.LoginModel;
import org.simplilearn.portal.dao.models.UserModel;
import org.simplilearn.portal.entities.User;

public interface UserService {
	void register(UserModel userModel);
	User getUser(LoginModel userModel);
}