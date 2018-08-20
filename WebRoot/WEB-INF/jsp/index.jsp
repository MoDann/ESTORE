<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<style type="text/css">
		 .pagination{height: 30px;text-align: center;} 
		 .pagination li {display: inline-block;height: 30px;margin-right: 5px;} 
		 .pagination li a{float: left;display: block;height: 32px;line-height: 32px;padding: 0 12px;
		 font-size: 16px;border: 1px solid #dddddd;color: #555555;text-decoration: none;} 
		 .pagination li a:hover{background:#f5f5f5;color:#0099ff;} 
		 .pagination li.thisclass {background: #09f;color: #fff;} 
		 .pagination li.thisclass a,
		 .pagination li.thisclass a:hover{background: transparent;border-color: #09f;color: #fff;cursor: default;}
	</style>
  </head>

<body
	onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')"
	topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<c:import url="header.jsp"></c:import>

	<!--文件体开始-->

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="middle"> <a href=index.jsp>杰普电子商务门户</a> → <img
				border="0" src="images/dog.gif" width="19" height="18"> 欢迎<font
				color="red"></font>光临！<font color="red">${username }</font></td>
		</tr>
		<tr>
			<td align="center"><font color="red" size="3px">${msg }</font></td>
		</tr>
	</table>
	<br>
	<form action="select.action" method="get">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1
			bgcolor="">
			<tr>
				<td>书名：<input type="text" name="bookname"></td>
				<td>作者：<input type="text" name="author"></td>
				<td>类型:<select name="type">
						<option value="0">全部类型</option>
						<c:forEach var="type" items="${types }">
							<option value="${type.id }">${type.name }</option>
						</c:forEach>

				</select></td>
				<td>价格：<select name="price">
						<option value="0">0</option>
						<option value="10-20">10-20</option>
						<option value="20-30">20-30</option>
						<option value="30-40">30-40</option>
						<option value="40-50">40-50</option>
						<option value="50-60">50-60</option>
						<option value="60-70">60-70</option>
						<option value="70-80">70-80</option>
						<option value="80-90">80-90</option>
						<option value="90-100">90-100</option>
				</select></td>
				<td><input type="submit" value="搜素"></td>
			</tr>
		</table>
	</form>
	<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>

		<%-- 	<% List<Book> list=(List<Book>)application.getAttribute("list"); %>
       	<% for(Book book:list){ %> --%>
		<%-- 	<tr>
			<td class=tablebody2 valign=middle align=center width=""><%=book.getId() %></td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;
			<a href="productDetail.action?bookid=<%=book.getId()%>"><%=book.getName() %></a></td>
			<td class=tablebody2 valign=middle align=center width=""><%=book.getPrice() %></td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addProduct.action?bookid=<%=book.getId()%>">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr> --%>
		<%-- 	<%} %> --%>

		<%-- <c:forEach items="${list.getBookList() }" var="book" varStatus="ls"> --%>
		
		<c:forEach items="${pageinfo.list }" var="book" varStatus="ls">
			<tr>
				<td class=tablebody2 valign=middle align=center width="">${ls.index+1 }</td>
				<td class=tablebody1 valign=middle width="">&nbsp;&nbsp; <a
					href="productDetail.action?bookid=${book.id }">${book.name }</a></td>
				<td class=tablebody2 valign=middle align=center width="">${book.price }</td>
				<td class=tablebody1 valign=middle align=center width=""><a
					href="addProduct.action?bookid=${book.id }"> <img border="0"
						src="images/car_new.gif" width="97" height="18"></a></td>
			</tr>
		</c:forEach>
		
		<!-- 分页 -->
		<tr align="center" bgcolor="#FFFFFF">
			<td colspan="5">共条${pageinfo.total }记录 每页 5 条 第${pageinfo.pageNum }页 /共${pageinfo.pages }页
			
			<a	href="index?page=1">首页</a>
				<c:if test="${pageinfo.hasPreviousPage }">
					<a href="index?page=${pageinfo.prePage }">上一页</a>
				</c:if>
				<c:if test="${pageinfo.hasNextPage }">
					<a href="index?page=${pageinfo.nextPage }">下一页</a>
				</c:if>
				<a href="index?page=${pageinfo.lastPage }">尾页</a>
			</td>
		</tr>
		
		<%-- <tr align="center" bgcolor="#FFFFFF">
			<td colspan="5">共条${pageinfo.total }记录 每页 5 条 第${pageinfo.pageNum }页 /共${pageinfo.pages }页
			
			<a	href="select.action?page=1">首页</a>
				<c:if test="${pageinfo.hasPreviousPage }">
					<a href="select.action?page=${pageinfo.prePage }">上一页</a>
				</c:if>
				<c:if test="${pageinfo.hasNextPage }">
					<a href="select.action?page=${pageinfo.nextPage }">下一页</a>
				</c:if>
				<a href="select.action?page=${pageinfo.lastPage }">尾页</a>
			</td>
		</tr>
		 --%>
	</table>
	
	<c:import url="footer.jsp"></c:import>
	
</body>
<script type="text/javascript">

		function price(){
			var price1=document.getElementById("price1");
			var price2=document.getElementById("price2");
			if(price1<price2){
				alter("第二个价格不能低于第一个价格！");
				return true;
			}else{
				return false;
			}
		}
	</script>
</html>
