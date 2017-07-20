<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String msg = (String)request.getAttribute("msg");
    if(msg==null){
        msg="";
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>查找界面</title>

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
        <form action="AdminServlet?doWhat=select" method="post">
            请输入要查找校友的用户名:<input type="text" name="username"><br>
            请输入要查找校友的姓名：<input type="text" name="name">
            <input type="submit" value="确认"><input type="reset" value="重置"><br>
            <font color="red">两者至少选择一个</font>
        </form>

        <font color="red"><%=msg %></font>
        </body>
</html>