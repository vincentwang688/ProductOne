package com.product.dao.interfaces;

import java.util.Set;

import com.product.model.UserInfo;

public interface UserDaoInterface {
	public int addUser(UserInfo user);

	public int deleteUser(String name);

	public int updateUser(UserInfo user);

	public UserInfo findUser(String name);

	public Set<UserInfo> findAll();
}
