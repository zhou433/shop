package com.yueqian.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.domain.Product;
import com.shop.utils.PageBean;
import com.yueqian.dao.ProductDao;

public class ProductService {
	public List<Product>findProductList()
	{
		ProductDao dao = new ProductDao();
		return dao.findProductList();
	}

	public PageBean findPageBean(int currentPage, int currentTootal)  {
		
		// 当前页码
		//private int currentPage;
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		// 每页显示记录数
		// int currentTootal;
		pageBean.setCurrentTootal(currentTootal);
		
		// 总记录数
		//private int totalCount;
		//查询总记录数
		ProductDao dao = new ProductDao();
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		// 总页码
		//private int totalPage;
		//int/int 返回int
		
		int totalPage =(int) Math.ceil((totalCount*1.0/currentTootal));
		//double可以直接转int
		
		pageBean.setTotalPage(totalPage);
		/**
		 * 总页码应该怎么求
		 * 
		 * 总记录数  每页显示几条  总页码
		 * 10       4           3
		 * 公式：[（总记录数-1）/每页记录数 ] + 1
		 */
		// 使用分页limit查询返回的数据,每页显示的数据
		//private List<T> ProductList = new ArrayList<T>();
		/**
		 * 1.开始索引
		 * 
		 * 2.每页显示几条
		 * 
		 * 
		 */
		//(当前页-1)*每页记录数（10）
		int index = (currentPage-1)*currentTootal;
		
		List<Product> productList = null;
		try {
			productList = dao.getProductListByLimit(index,currentTootal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setProductList(productList);
		
		return pageBean;
	}

	public Product findProductBypid(String pid) throws SQLException {
		//调用dao层
		ProductDao dao = new ProductDao();
		Product product = dao.findProductBypid(pid);
		return product;
	}
}
