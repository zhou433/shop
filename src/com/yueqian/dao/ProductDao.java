package com.yueqian.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.domain.Product;
import com.shop.utils.C3P0Utils;

public class ProductDao {
	public List<Product> findProductList() {
		List<Product> list = new ArrayList<Product>();
		try {
			// 查询数据库 返回List集合
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourece());

			// 编写sql

			String sql = "SELECT * FROM product";
			list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 获取商品总记录数
	public int getTotalCount() {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourece());
		String sql = "SELECT COUNT(*) from product";
		int i = 0;
		try {
			/**
			 * 这里强转的时候转为long类型 将来如果数据很多 那么这个数字非常大  
			 * 
			 */
			Long query = (Long)qr.query(sql,new ScalarHandler());
			 i = query.intValue();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	public List<Product> getProductListByLimit(int index, int currentTootal) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourece());
		String sql = "SELECT * from product LIMIT ?,?";
		Object[]params = {index,currentTootal};
		List<Product> productList = qr.query(sql,new BeanListHandler<Product>(Product.class),params);
		return productList;
	}

	public Product findProductBypid(String pid) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourece());
		String sql = "SELECT * FROM product WHERE pid = ?";
		Object [] params = {pid};
		Product product = qr.query(sql,new BeanHandler<Product>(Product.class),params);
		return product;
	}
}
