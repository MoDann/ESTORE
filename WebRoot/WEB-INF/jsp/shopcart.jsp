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
  
  <body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<c:import url="header.jsp"></c:import>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
		
        <c:forEach var="map" items="${cart.getLines() }" varStatus="cs">
          <tr>
			<form method="get" name="f1">
			<input type="hidden" name="number" id="number" value="1">
			<input type="hidden" name="bookid" id="bookid" value="${map.value.book.id }">
			<td class=tablebody2 valign=middle align=center width="">${cs.index+1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?bookid=${map.value.book.id }">${map.value.book.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">
			<input type="hidden"  value="${map.value.book.price }"><p id="price">${map.value.book.price }</p></td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="text" name="num" id="${map.value.id}num" value="${map.value.num }" size="4" 
			onblur="modifynum(${map.value.book.id},${map.value.book.price})" /> 
			</td>
			<td class=tablebody2 valign=middle align=left width="" id="${map.value.book.id}cost"  >&nbsp;&nbsp;<b id="total"><span id="${map.value.book.id}cost">${map.value.book.price*map.value.num }</span></b></td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="取消" onclick="javascript:window.location='removeProduct.action?bookid=${map.value.book.id }';"> 
			<!-- <input type="submit" value="保存修改"> -->
			</td>
			</form>
			</tr>
        
        </c:forEach>     
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b ><span id="cost">${cost }</span></b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6">
			<input type="button" value="提交订单" onclick="javascript:window.location='confirmOrder';"> 
			<input type="button" value="继续购物" onclick="javascript:window.location='index';"> 
			<input type="button" value="清空购物车" onclick="javascript:window.location='removeAllProduct.action';"></td>
		</tr>
                </table><br>
<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>
  </body>
  <script type="text/javascript">
  	
 	<%-- $(function(){
 		$("#num").blur(function(){
 			var num = $("#num").val();
 			var price = $("#price").val();
 			var bookid = $("#bookid").val();
 			var url = "<%= basePath%>updateCart/" + bookid +"&"+num;
			$.getJSON(url,function(data){
				if(data.status == 200) {
					var total = num*price;
					var cost = <%=session.getAttribute("cost")%>;
					$("#total").html(total);
					$("#cost").html(cost);
				}	
			});
			
 		});
 	}); --%>
 	
	function modifynum(bookid,price){
      var num = document.getElementById(bookid+"num").value;
      if(num <= 0){
      	alert("数量不能小于1！");
      	number.value=this.value;
      	this.focus();
      } else {
      	 var url = "<%=basePath%>updateCart/" + bookid + "/" + num;
     	 var smallcostinput = document.getElementById(bookid+"cost");
     	 var smallcost = num * price;
	 	 smallcostinput.innerHTML = "&nbsp;&nbsp;"+smallcost+".0";
     	 $.getJSON(url,function(data){
				if(data.status == 200) {
					var costinput = document.getElementById("cost");
					costinput.innerHTML = data.data+".0";
					
				}	
			});
    	  }
      }
  </script>
</html>
