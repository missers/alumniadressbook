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
    
    <title>校友注册页面</title>
    
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
    <h1>校友通讯录系统注册</h1><hr>
    <form action="AlumniServlet?dowhat=signup" method="post">
    	自定义用户名：<input type="text" name="username"><font color="red">（*不得为空）</font><br>
    	自定义密码：<input type="password" name="password"><font color="red">（*不得为空）</font><br>
    	姓名：<input type="text" name="name"><font color="red">（*不得为空）</font><br>
    	性别选择： 男<input type="radio" value="男" name="sex">
    		          女<input type="radio" value="女" name="sex"><br>
    	出生日期：<input type="text" name="birthday"><br>
    	所属班级：<input type="text" name="className"><font color="red">（*不得为空）</font><br>
    	联系电话：<input type="text" name="tel"><br>
    	电子邮箱：<input type="text" name="email"><br>
      	<input type="submit" value="点击提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="alumni/alumnilogin.jsp">返回上一级</a><br>
    </form>
    <%=msg %>
  </body>
</html>
