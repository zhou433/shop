package com.shop.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.domain.Product;
import com.shop.utils.C3P0Utils;
import com.shop.utils.PageBean;
import com.yueqian.service.ProductService;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService service	= new ProductService();
	//	List<Product> productList = service.findProductList();
		//2.将数据库查询出的数据储存在request中
		
		/**
		      * 在Pagebean中已经包含分页的所有信息
		 * 比如说页码
		 * 比如List
		 * 
		 */
		//web层调用service层拿到需要的分页数据
		
		//当前页码
		//String parameter = request.getParameter("page");
		
		//接收用户从前台jsp中传入的页码编号值
		String currentPageStr = request.getParameter("currentPage");
		
		/**
		 * 处理当currentPage为null的时候
		 */
		if (currentPageStr==null) currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr); 
		

		//每页显示记录数
		int currentTootal = 12;
		
		
		PageBean<Product> pageBean = null;
		pageBean = service.findPageBean(currentPage,currentTootal);   
		
		request.setAttribute("pageBean",pageBean);	
		//request.setAttribute("productList",productList);		
			//3.转发给jsp显示
			request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}	


	

