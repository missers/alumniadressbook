<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="team.aab.bean.AlumniBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<AlumniBean> aluList = (List)request.getAttribute("aluList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alumniselectresult.jsp' starting page</title>
    
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
   <h2>查询结果</h2><hr>

<table border="1">
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>班级</th>
        <th>电话</th>
        <th>邮箱</th>
    </tr>
        <% for(int i=0;i<aluList.size();i++){
         AlumniBean alumni = aluList.get(i);
         String username = alumni.getUsername();
         String password = alumni.getPassword();
         String name = alumni.getName();
         String sex = alumni.getSex();
         String birthday = alumni.getBirthday();
         String className = alumni.getClassName();
         String tel = alumni.getTel();
         String email = alumni.getEmail();

     %>
    <tr>
        <td><%=username %></td>
        <td><%=password %></td>
        <td><%=name %></td>
        <td><%=sex%></td>
        <td><%=birthday %></td>
        <td><%=className %></td>
        <td><%=tel %></td>
        <td><%=email%></td>
    </tr>
        <% }%>
  </body>
</html>
