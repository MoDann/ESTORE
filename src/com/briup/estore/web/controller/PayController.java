package com.briup.estore.web.controller;


import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.util.AlipayClientFactory;
import com.briup.estore.service.interfaces.IOrderService;


/**
 * 订单付款
 * 
 * @author danmo
 * @date 2018-8-2
 *
 */
@Controller
public class PayController {

	@Autowired
	private IOrderService orderService;
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response, String pay)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		try {
			Method method = this.getClass().getMethod(pay, HttpServletRequest.class, HttpServletResponse.class, Integer.class);
			System.out.println(method);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("orderSucessMsg", "系统出错");
			request.getRequestDispatcher("/payway").forward(request, response);
		}
	}*/
	
	@RequestMapping("/pay.action")
	public String zhifubao(HttpServletRequest request, HttpServletResponse response,Integer orderid) {
		//获取前台订单数据
		if (orderid.equals("")) {
			return "redirect:/error";
		}
		try {
			Order order = orderService.findOrderWithLineAndBookById(orderid);
			System.out.println(order);
			AlipayClient alipayClient = AlipayClientFactory.getAlipayClient(); // 获得初始化的AlipayClient
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
			alipayRequest.setReturnUrl("http://127.0.0.1:8888/briup-ssm_estore/order.action");
			// alipayRequest.setNotifyUrl("http:/127.0.0.1:8998/payServlet?paysuccess");//在公共参数中设置回跳和通知地址
			JSONObject json = new JSONObject();
			// 业务参数填充
			/* (必选) 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复 */
			json.put("out_trade_no", System.currentTimeMillis()); // 订单编号
			/* (必选) 订单标题 */
			json.put("subject", getOrderName(order)); // 订单名字
			/* (必选) 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] */
			json.put("total_amount", order.getCost()); // 订单总价钱
			/* (可选) 销售产品码 */
			json.put("product_code", "FAST_INSTANT_TRADE_PAY"); // 产品代码
			/* (可选) 订单描述 */
			json.put("body", "订单付账");
			alipayRequest.setBizContent(json.toString());
			String form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			order.setStatus(1);
			orderService.updateStatus(order);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(form);// 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "order";
	}
	
	/*public void weixin(HttpServletRequest request, HttpServletResponse response, Integer orderid) 
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("<h1>研发中，请选择<a href='payway'>支付宝</a>付款<h1>");
		response.getWriter().flush();
	}*/
	
	public String getOrderName(Order order) {
		if (order == null || order.getLines().size() <= 0) {
			return UUID.randomUUID().toString();
		}
		StringBuffer buffer = new StringBuffer();
		for (Line line : order.getLines()) {
			buffer.append(line.getBook().getName());
		}
		return buffer.toString();
	}
	
	public void paysuccess(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("---------------");
	}
}
