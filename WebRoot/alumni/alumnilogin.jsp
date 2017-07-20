<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String msg = (String)request.getAttribute("msg");

if(msg == null){
	msg = "";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校友登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>校友登录</h1><hr>
	<form action="AlumniServlet?dowhat=login" method="post">
	     用户名:<input type="text" name="username"><br>
	     密码:&nbsp;&nbsp;&nbsp;<input type="password" name="password"><br>
	  <input type="submit" value="登陆">
	</form>
	<a href="alumni/alumnisignup.jsp">没有账号？注册一个</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回上一级</a><br>
	<font color="red"><%=msg %></font>
  </body>
</html>
