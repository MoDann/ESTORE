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
    
    <title>杰普电子商务门户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK href="css/main.css" rel=stylesheet>
	<script language = "JavaScript" src = "js/main.js"></script>

  </head>
  
 <body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','images/top/topxmas/jp_on.gif','images/top/topxmas/download_on.gif','images/top/topxmas/bbs_on.gif','images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<c:import url="header.jsp"></c:import>	

	<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					订单列表
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单编号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单金额</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>付款方式</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
                
		
	 <c:forEach var="order" items="${orders.list }" varStatus="os">
			<tr>
			<td class=tablebody2 valign=middle align=center width="">${os.index+1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="orderInfo.action?orderid=${order.id }">${order.id }</a></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥${order.cost }</td>
			<td class=tablebody1 valign=middle align=center width="" name="status">
				<c:choose>
					<c:when test="${order.status == 0 }">
						<span id="span${os.index }">待付款</span>
					</c:when>
					<c:otherwise>
						<span id="span${os.index }">已付款</span>
					</c:otherwise>
				</c:choose><td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${order.payway } </td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:if(confirm('确认删除?'))location='removeOrder.action?orderid=${order.id}';">&nbsp;
			<input type="button" value="明细" onclick="javascript:window.location='orderInfo.action?orderid=${order.id}';">&nbsp;
			<input type="button" value="付款" id="pay${os.index }" onclick="javascript:window.location='payway?orderid=${order.id}';"/></td>
			</tr>
        </c:forEach>    
        <tr  bgcolor="#FFFFFF"><td align="center" colspan="6"><font color="red">${msg }</font></td></tr>
        <c:remove var="msg" scope="session"/>
        
        <!-- 分页 -->
		<tr align="center" bgcolor="#FFFFFF">
			<td colspan="6">共条${orders.total }记录 每页 5 条 第${orders.pageNum }页 /共${orders.pages }页
			
			<a	href="order.action?page=1">首页</a>
				<c:if test="${orders.hasPreviousPage }">
					<a href="order.action?page=${orders.prePage }">上一页</a>
				</c:if>
				<c:if test="${orders.hasNextPage }">
					<a href="order.action?page=${orders.nextPage }">下一页</a>
				</c:if>
				<a href="order.action?page=${orders.lastPage }">尾页</a>
			</td>
		</tr>
	</table><br>
	<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>
</body>
	<!-- <script type="text/javascript">
		function p_del() {
			var massage = "确定认删除吗？\n\n请确认！";
			if (confirm(massage)==true){
				window.location='removeOrder.action?orderid=${order.id}';		
				return true;
			}else{
				return false;
			}
		}
	</script> -->
	<script type="text/javascript">
		window.onload = function() {
			var status = document.getElementsByName("status");
			for (var i = 0; i < status.length; i++) {
				var span = document.getElementById("span"+i);
				if(span.innerHTML == "已付款") {
					var button = document.getElementById("pay"+i);
					button.type = "hidden";
				}
			}
		}
	</script>
</html>
