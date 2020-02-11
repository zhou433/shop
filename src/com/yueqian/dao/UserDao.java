package com.yueqian.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.shop.domain.User;
import com.shop.utils.C3P0Utils;
import com.shop.utils.UUIDUtils;

public class UserDao {
	public int addUser(User user)
	{
		int row = 0;
		//查询数据库
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourece());
		try {
			String sql = "INSERT INTO user (uid,username,password,name,email,telephone,birthday,sex,state,code)VALUES(?,?,?,?,?,?,?,?,?,?)";
			Object [] params = {UUIDUtils.getUUID(),user.getUsername()
					,user.getPassword(),user.getName(),user.getEmail(),user.getTelephone()
					,user.getBirthday(),user.getSex(),user.getState(),user.getCode()} ;
			row = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
