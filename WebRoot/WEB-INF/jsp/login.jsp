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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<c:import url="header.jsp"></c:import>

<!--文件体开始-->
		<center><span><font color="red" size="5px">${sessionScope.msg }</font></span></center>
		<c:remove var="msg" scope="session"/>
		
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户登录
                </td>
                </tr>
		</table>
              <br>

	<form action="login.action" method="post" name="loginFr" id="login" onsubmit="">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="images/bg2.gif" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT name="name" id="userid" type=text> &nbsp;
				<span id="userNameError"><font color="red">*</font></span>
			</td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT name="password" id="pwd" type=password> &nbsp;
			<span id="pwdError"><font color="red">*</font></span> </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<input type="submit" value="登 录" onclick="return check();"></td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<a href="register">没有注册？</a>
			</td>
		</tr>
		</table>
	</form>
<!--文件尾开始-->
		<c:import url="footer.jsp"></c:import>
	</body>
	
	<script type="text/javascript">
		//判断用户合法性
		$(function(){
			$("#userid").blur(function(){
				var user = $("#userid").val();
				var len = $("#userid").val().length;
				if(user == null || len == 0){
					$("#userNameError").html("<font color=\"red\">用户名不为空</font>");
					$("#login").attr("onsubmit", "return false");
				} else {
					$("#userNameError").html("<font color=\"green\">√</font>");
					$("#login").attr("onsubmit", "return true");
				}
			});
		});
		//判断密码合法性
		$(function(){
			$("#pwd").blur(function(){
				var password = $("#pwd").val().length;
				if(password == 0){
					$("#pwdError").html("<font color=\"red\">密码不能为空</font>");
					$("#login").attr("onsubmit","return false");
				} else {
					$("#pwdError").html("<font color=\"green\">√</font>");
					$("#login").attr("onsubmit","return true");
				}
			});
		});
		
		function check(){
			fr = document.loginFr;
			if(fr.name.value == ""){
				fr.name.focus();
				return false;
			}
			if(fr.password.value == ""){
				fr.password.focus();
				return false;
			}
			fr.submit();
		}
	</script>
	
</html>
