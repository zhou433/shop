package com.shop.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.Product;
import com.yueqian.service.ProductService;


public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收用户从jsp传递过来的pid
		String pid = request.getParameter("pid");
		
		//调用service
		ProductService service = new ProductService();
		Product product = null;
		try {
			product = service.findProductBypid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将查询到的商品信息存在request域中
		request.setAttribute("product",product);
		
		//进行转发到jsp
		request.getRequestDispatcher("/product_info.jsp").forward(request,response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
