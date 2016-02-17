package com.product.service;

import java.util.Set;

import com.product.dao.UserInfoDao;
import com.product.dao.interfaces.UserDaoInterface;
import com.product.model.UserInfo;

public class UserInfoService {
	UserDaoInterface userInfoDao = new UserInfoDao();

	public int add(UserInfo User) {
		return this.userInfoDao.addUser(User);
	}

	public boolean login(UserInfo user) {
		UserInfo queryUser = find(user.getUserName());
		if (queryUser != null
				&& user.getPassword().equals(queryUser.getPassword())) {
			return true;
		}

		return false;
	}

	public int delete(String name) {
		return this.userInfoDao.deleteUser(name);
	}

	public int update(UserInfo user) {
		return this.userInfoDao.updateUser(user);
	}

	public UserInfo find(String name) {
		return this.userInfoDao.findUser(name);
	}

	public Set<UserInfo> findAll() {
		return this.userInfoDao.findAll();
	}
}
