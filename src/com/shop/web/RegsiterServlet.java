package com.shop.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shop.domain.User;
import com.shop.utils.UUIDUtils;
import com.yueqian.service.UserService;

public class RegsiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegsiterServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	
		User user = new User();
		//1,接收用户从客户端传递的参数
		request.getParameter()*/
		User user = new User();
		
		Map<String,String[]> parameterMap = request.getParameterMap();
		
		//使用beanuntils将Map参数封装到Javabean中
		/**
		 * 自动封装，前提是map集合中key和javabean的属性名一致
		 * populate（object bean，Map properties）；
		 */
		
		try {
			BeanUtils.populate(user,parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//自己手动封装一些表单中没有的字段信息
		user.setUid(UUIDUtils.getUUID());
		user.setTelephone(null);
		user.setState(0);
		user.setCode(null);
		
		//调用service层
		UserService service = new UserService();
		Boolean isSuccess = service.addUser(user);
		if(isSuccess){
			//成功
			System.out.println("添加数据成功");
			
			//注册成功后跳转界面
			/**
			 * 1.跳转那个界面：登录界面  login.jsp
			 * 2.跳转界面使用重定向还是转发：重定向
			 *  转发地址会不变 刷新就会重新发送
			 *  转发：request.getRequestDispatcher("/login.jsp").forward(request,response);
			 */
			//重定向操作
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		else {
			//失败
			System.out.println("添加数据失败");
		}
		//isSuccess.booleanValue()...?;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
