<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>惠多多商城购物车</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>

<script type="text/javascript">
	function deleteCartItem(pid) {

		// 给用户一个友好提示 

		/*
		 判断如果点击了确定删除，应该发送请求给服务器
		 
		 
		 如果点击了取消按钮，应该重定向一下 (或者什么也不做)
		 */
		//alert(pid);
		//发送请求给后台服务器
		if (confirm("您确定要删除该商品吗?")) {
			location.href = "${pageContext.request.contextPath}/cart?method=delete&pid="+ pid;

		} else {
            return false;
		}

	}
	
	
	// 提交订单
	function submitOrder() {
		location.href = "${pageContext.request.contextPath}/cart?method=addOrder";	
	}
</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<!-- 如果购物车中购物项为null，应该显示一张卡哇伊图片 -->

	<c:if test="${empty cart.cartItems  }">

		<img alt=""
			src="${pageContext.request.contextPath }/images/cartEmpty.png">
		<a href="${pageContext.request.contextPath }/index.jsp">返回首页</a>
	</c:if>
	<c:if test="${!empty cart.cartItems  }">

		<div class="container">
			<div class="row">

				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong style="font-size: 16px; margin: 5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>

							<c:forEach items="${cart.cartItems }" var="entry">
								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id"
										value="22"> <img src="${entry.value.product.pimage }"
										width="70" height="60"></td>
									<td width="30%"><a target="_blank">${entry.value.product.pname }</a>
									</td>
									<td width="20%">￥${entry.value.product.shop_price }</td>
									<td width="10%"><input type="text" name="quantity"
										value="${entry.value.buyNum }" maxlength="4" size="10">
									</td>
									<td width="15%"><span class="subtotal">￥${entry.value.subtotal }</span>
									</td>
									<td><a href="javascript:;" class="delete"
										onclick="deleteCartItem('${entry.value.product.pid}')">删除</a>
									</td>
								</tr>
							</c:forEach>




						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right: 130px;">
				<div style="text-align: right;">
					<em style="color: #ff6600;"> 登录后确认是否享有优惠&nbsp;&nbsp; </em> 赠送积分: <em
						style="color: #ff6600;">${cart.total }</em>&nbsp; 总价: <strong
						style="color: #ff6600;">￥${cart.total }元</strong>
				</div>
				<div
					style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
					<a href="${pageContext.request.contextPath }/cart?method=clearCart" id="clear" class="clear">清空购物车</a> 
					<a href="javascript:void(0);"> 
						<input onclick="submitOrder()" type="button" width="100"
						value="提交订单" name="submit" border="0"
						style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
					</a>
				</div>
			</div>

		</div>
	</c:if>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>