package com.yueqian.service;

import com.shop.domain.User;
import com.yueqian.dao.UserDao;

public class UserService {
	public Boolean addUser(User user)
	{
		//调用dao层
		UserDao dao = new UserDao();
		int i = dao.addUser(user);
		return i>0?true:false;
	}
}
