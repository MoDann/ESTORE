<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'confirmOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>杰普电子商务门户</title>
	<LINK href="./css/main.css" rel=stylesheet>
	<script language = "JavaScript" src = "./js/main.js"></script>

  </head>
  
  <body onLoad="MM_preloadImages('./images/index_on.gif','./images/reg_on.gif','./images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<c:import url="header.jsp"></c:import>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="./images/Forum_nav.gif" align="middle">
                  <a href=index>杰普电子商务门户</a> →
					<img border="0" src="./images/dog.gif" width="19" height="18">
					确认定单&nbsp;&nbsp;<font color="red">${username }</font>
                </td>
                </tr>
		</table>
              <br>

		<form name="order" method="post" action="saveOrder.action"/>
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="./images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font><input type="button" value="修改" onclick="javascript:window.location='userinfo';"></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customer.name }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customer.address }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customer.zip }</td>
		</tr>
		<!-- <tr>
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">sdfadsf</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">sdfadsfa</td>
		</tr> -->
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customer.phone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customer.email }</td>
		</tr>
	</table>
<br>
<!--文件尾开始-->
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="./images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">
                          <select name="payway">
                            
		                          	<option value="1">邮局汇款 </option>
		                          	<option value="2">货到付款</option>
		                          	<option value="3">银行转帐</option>
		                          	<option value="4">线上支付</option>
                          	
                          </select></td>
		</tr>
		</table>
		<br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="./images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font><input type="button" value="修改" onclick="javascript:window.location='shopcart.action';"></td>
		</tr>
        <c:forEach var="car" items="${cart.lines }">
       	 <tr>
        	<%-- <c:forEach var="i" begin="1" end="car.size()" step="1">
        	
        	</c:forEach> --%>
			<td class=tablebody2 valign=middle align=center width="">${car.value.book.id }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="./productDetail.jsp?productid=${car.value.book.id  }" target="_blank">${car.value.book.name } </a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：￥${car.value.book.price }</td>
			<td class=tablebody1 valign=middle align=center width="">数量：￥${car.value.num }</td>
			<td class=tablebody2 valign=middle align=left width="">小计：￥${car.value.book.price*car.value.num }</td>
		</tr>
        </c:forEach>
		
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4"><font color="red"><b>${massage }</b></font>　</td>
			<c:remove var="massage" scope="session"/>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>￥${cost }</b></font></td>
		</tr>
		        </table>
		        <p align="center">请认真检查以上订单信息，确认无误后，点击 → <a onclick="javascript:document.order.submit();" style="cursor:hand">
		        <img src="./images/submit.gif"></a>
		</form>
	</p>
	<c:import url="footer.jsp"></c:import>
</body>
</html>
