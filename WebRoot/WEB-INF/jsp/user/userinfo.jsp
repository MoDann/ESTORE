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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="description" content="杰普电子商务门户">
	<title>杰普电子商务门户</title>
	<LINK href="./css/main.css" rel=stylesheet>
	<script language = "JavaScript" src = "./js/main.js"></script>

  </head>
  
 <body onLoad="MM_preloadImages('./images/index_on.gif','./images/reg_on.gif','./images/order_on.gif','./images/top/topxmas/jp_on.gif','./images/top/topxmas/download_on.gif','./images/top/topxmas/bbs_on.gif','./images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<c:import url="header.jsp"></c:import>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="./images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户信息修改
                </td>
                </tr>
		</table>
              <br>

<form method="post" name="reg" action="modify.action" id="userinfo" onsubmit="">
	<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="./images/bg2.gif">
			<font color="#ffffff"><b>用户信息修改</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>用户名</b>：<br>
			注册用户名长度限制为0－16字节</td>
			<td width="60%" class="tablebody1">
			<input type="hidden" name="id" value="${customer.getId() }">
			<input type="hidden" name="name" id="userid" value="${customer.getName() }">
			<input type="text" maxLength="8" size="32" disabled value="${customer.getName() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"> 
			<%-- <input type="text" maxLength="8" size="32" name="userid" value="${customer.getName() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"> --%>
			<font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请输入密码，区分大小写。<br>
			请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'
			</td>
			<td width="60%" class="tablebody1">
			<input type="password" maxLength="8" size="32" name="password" id="password" value="${customer.password }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<span id="pwdError"><font color="#FF0000">*</font></span></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请再输一遍确认</td>
			<td class="tablebody1">
			<input type="password" maxLength="8" size="32" name="password2" id="password2" value="${customer.password }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<span id="conpwdError"><font color="#FF0000">*</font></span></td>
		</tr>
		<tr>
			<td class="tablebody1"><b>所在地区</b>：</td>
			<td class="tablebody1">
			<select name="country" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
				<option value="中国">中国</option>
				<option value="中国香港">中国香港</option>
				<option value="中国台湾">中国台湾</option>
			</select>
			<select name="province" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                <option value="安徽" >安徽</option>

                <option value="北京" >北京</option>

                <option value="重庆" >重庆</option>

                <option value="福建" >福建</option>

                <option value="广东" >广东</option>

                <option value="甘肃" >甘肃</option>

                <option value="广西" >广西</option>

                <option value="贵州" >贵州</option>

                <option value="河南" >河南</option>

                <option value="湖北" >湖北</option>

                <option value="河北" >河北</option>

                <option value="海南" >海南</option>

                <option value="香港" >香港</option>

                <option value="黑龙江" >黑龙江</option>

                <option value="湖南" >湖南</option>

                <option value="吉林" >吉林</option>

                <option value="江苏" >江苏</option>

                <option value="江西" >江西</option>

                <option value="辽宁" >辽宁</option>

                <option value="澳门" >澳门</option>

                <option value="内蒙古" >内蒙古</option>

                <option value="宁夏" >宁夏</option>

                <option value="青海" >青海</option>

                <option value="四川" >四川</option>

                <option value="山东" >山东</option>

                <option value="上海" >上海</option>

                <option value="陕西" >陕西</option>

                <option value="山西" >山西</option>

                <option value="天津" >天津</option>

                <option value="台湾" >台湾</option>

                <option value="新疆" >新疆</option>

                <option value="西藏" >西藏</option>

                <option value="云南" >云南</option>

                <option value="浙江" >浙江</option>

                <option value="其它" >其它</option>
			</select>省
			<input type="text" size="8" name="city" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000" value="${customer.city }">市/县</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="address" value="${customer.getAddress() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<!-- <tr>
			<td class="tablebody1"><b>联系地址2</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="street2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr> -->
		<tr>
			<td class="tablebody1"><b>邮编</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="8" name="zip" value="${customer.getZip() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<!-- <tr>
			<td class="tablebody1"><b>家庭电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="homephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>办公室电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="officephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr> -->
		<tr>
			<td class="tablebody1"><b>手机</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="phone" id="phone" value="${customer.getPhone() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<span id="phoneError"><font color="#FF0000">*</font></span></td>
		</tr>
		<tr>
			<td class="tablebody1"><b>Email地址</b>：<br>
			请输入有效的邮件地址</td>
			<td class="tablebody1">
			<input maxLength="50" size="32" maxlength="32" name="email" id="email" value="${customer.getEmail() }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<span id="emailError"><font color="#FF0000">*</font></span></td>
		</tr>
		<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input type="submit" value="修 改" onclick="return check();"></td>
		</tr>
		<tr>
		 <td class="tablebody2" valign="middle" colspan="2" align="center">
		<a href="login">没有登录，点此登录</a></td>
		</tr>
	</table>
</form>
<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>
	</body>
	<script type="text/javascript">
		// 密码合法性的判断
		$(function() {
			$("#password").blur(function() {
				var len = $("#password").val().length;
				if (len == 0) {
					$("#pwdError").html("<font color=\"red\">密码不能为空</font>");
					$("#userinfo").attr("onsubmit", "return false");
				}
				else if (len > 0 && len < 6) {
					$("#pwdError").html("<font color=\"red\">密码位数最少为6位</font>");
					$("#userinfo").attr("onsubmit", "return false");
				}
				else if (len > 8) {
					$("#pwdError").html("<font color=\"red\">密码位数最多为8位</font>");
					$("#userinfo").attr("onsubmit", "return false");
				}
				else {
					$("#pwdError").html("<font color=\"green\">√</font>");
					$("#userinfo").attr("onsubmit", "return true");
				}
			});
		});
		// 确认两次密码
		$(function() {
			$("#password2").blur(function() {
				var oldpwd = $("#password").val();
				var conpwd = $("#password2").val();
				var number = $("#password2").val().length;
				if (number == 0) {
					$("#conpwdError").html("<font color=\"red\">密码不能为空</font>");
					$("#userinfo").attr("onsubmit", "return false");
				} else if (oldpwd != conpwd) {
					$("#conpwdError").html("<font color=\"red\">两次密码不一致</font>");
					$("#userinfo").attr("onsubmit", "return false");
				} else {
					$("#conpwdError").html("<font color=\"green\">√</font>");
					$("#userinfo").attr("onsubmit", "return true");
				}
			});
		});
		// 手机号判断
		$(function() {
			$("#phone").blur(function() {
				var phone = $("#phone").val();
				var len = $("#phoner").val().length;
				if(len==0||phone==null){
 					$("#phoneError").html("<font color=\"red\">手机号不能为空</font>");
					$("#userinfo").attr("onsubmit", "return false");
				} else if (!checkContactNumber()) {
					$("#phoneError").html("<font color=\"red\">不符合手机号格式</font>");
					$("#userinfo").attr("onsubmit", "return false");
				} else {
					$("#phoneError").html("<font color=\"green\">√</font>");
					$("#userinfo").attr("onsubmit", "return true");
				}
			});
		});
		//判断邮箱
		$(function() {
			$("#email").blur(function() {
				var email = $("#email").val();
				if (IsEmail(email)) {
					$("#emailError").html("<font color=\"red\">不符合邮箱格式</font>");
					$("#userinfo").attr("onsubmit", "return false");
				} else {
					$("#emailError").html("<font color=\"green\">√</font>");
					$("#userinfo").attr("onsubmit", "return true");
				}
			});
		});
		
		function check() {
			fr = document.reg;
			if (fr.name.value == "") {
				fr.name.focus();
				return false;
			}
			if ((fr.password.value == "")) {
				fr.password.focus();
				return false;
			}
			if ((fr.password2.value == "")) {
				fr.password2.focus();
				return false;
			}
			fr.submit();
		}
		
		function checkContactNumber() {
			var mobile = $.trim($("#phone").val());
			var isMobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
			if (!isMobile.exec(mobile) && mobile.length != 11) {
				$("#phone").focus();
				return false;
			}
			return true;
		}
	
		function IsEmail(item) {
			var etext;
			var elen;
			var i;
			var aa;
			etext = item;
			elen = etext.length;
			if (elen < 5)
				return true;
			i = etext.indexOf("@", 0);
			if (i == 0 || i == -1 || i == elen - 1)
				return true;
			else {
				if (etext.indexOf("@", i + 1) != -1)
					return true;
			}
			if (etext.indexOf("..", i + 1) != -1)
				return true;
			i = etext.indexOf(".", 0);
			if (i == 0 || i == -1 || etext.charAt(elen - 1) == '.')
				return true;
			if (etext.charAt(0) == '-' || etext.charAt(elen - 1) == '-')
				return true;
			if (etext.charAt(0) == '_' || etext.charAt(elen - 1) == '_')
				return true;
			for (i = 0; i <= elen - 1; i++) {
				aa = etext.charAt(i);
				if (!((aa == '.') || (aa == '@') || (aa == '-') || (aa == '_')
						|| (aa >= '0' && aa <= '9') || (aa >= 'a' && aa <= 'z') || (aa >= 'A' && aa <= 'Z')))
					return true;
			}
			return false;
		}
		
	</script>
</html>
