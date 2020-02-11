package com.shop.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.Cart;
import com.shop.domain.CartItem;
import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		//接收用户从jsp传递过来的参数
		//商品id
		String pid = request.getParameter("pid");
		//购买数量
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		
		System.out.println(pid);
		System.out.println(buyNum);
		//将数据封装成CartItem
		//product
/*		Product product = null;
		ProductService service = new ProductService();
		try {
			product = service.findProductBypid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//buyNum
		
		//subtotal(单价*数量)
		
		//获取单价
		double shop_price = product.getShop_price();
		
		double subtotal = shop_price * buyNum;
		
		//购物车项 在一个购物车中有若干个购物车项
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);
		
		//将cartItem 封装在真正的购物车中
		
		//先判断是否有购物车，我们这里使用session来实现购物车，
		//所以我们就去判断session域中是否存储的有购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart==null)
		{
			//你没有购物车,需要创建一个新的
			cart = new Cart();
		}
		//将若干个cartItem项存储在购物车中
		cart.getCartItems().put(product.getPid(),item);
		
		System.out.println("cart:"+cart);
		//将装满东西的篮子存放在session域中
		session.setAttribute("cart",cart);
		//转发或重新定向
		request.getRequestDispatcher("/cart.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
*/	}

}
