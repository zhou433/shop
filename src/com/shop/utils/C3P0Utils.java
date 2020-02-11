package com.shop.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0Utils {
	
	public static ComboPooledDataSource  dataSource = new ComboPooledDataSource();
	/**
	 * �÷����Ǹ���Ҫdatasoure�����ķ���ʹ��
	 * @return
	 */
	public static DataSource getDataSourece()
	{
//		ComboPooledDataSource  ds = new ComboPooledDataSource();
//		return ds;
		return  dataSource;
	}

	
	/**
	 * ר��Ϊԭ��jdbc�ṩһ��connection
	 * @return
	 */
	public static Connection getC3P0Connection()
	{
		
		Connection con = null;
		
		try {
			//ComboPooledDataSource  ds = new ComboPooledDataSource();
			con =  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}
}
