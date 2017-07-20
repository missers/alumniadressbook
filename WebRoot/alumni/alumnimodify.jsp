<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="team.aab.bean.AlumniBean" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    AlumniBean alumni = (AlumniBean)request.getAttribute("alumni");
    
    String username = alumni.getUsername();
    String password = alumni.getPassword();
    String name = alumni.getName();
    String sex = alumni.getSex();
    String birthday = alumni.getBirthday();
    String className = alumni.getClassName();
    String tel = alumni.getTel();
    String email = alumni.getEmail();
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>修改个人信息页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        a:hover {
            color: red;
        }
    </style>
</head>
<body>
修改个人信息页面
<hr>
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
        <th colspan="2">操作</th>
    </tr>
    <tr>
        <td><%=username %></td>
        <td><%=password %></td>
        <td><%=name %></td>
        <td><%=sex%></td>
        <td><%=birthday %></td>
        <td><%=className %></td>
        <td><%=tel %></td>
        <td><%=email%></td>
        <td><a href="AlumniServlet?dowhat=update">修改</a></td>
        <td><a href="AlumniServlet?dowhat=delete" target="_top">删除</a></td>
    </tr>
</body>
</html>
