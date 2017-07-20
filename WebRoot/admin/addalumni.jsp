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

    <title>修改校友信息页面</title>

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
添加校友信息页面
<hr>
<form action="AdminServlet?doWhat=add" method="post">
    <table frame="void">
        <tr><td>用户名：<input type="text" name="username"><font color="red">（*必填）</font></td></tr>
        <tr><td>密码：<input type="text" name="password"><font color="red">（*必填）</font></td></tr>
        <tr><td>姓名：<input type="text" name="name"><font color="red">（*必填）</font></td></tr>
        <tr><td>性别选择： 男<input type="radio" value="男" name="sex">
    		                              女<input type="radio" value="女" name="sex"></td></tr>
        <tr><td>出生日期：<input type="text" name="birthday"></td></tr>
        <tr><td>班级：<input type="text" name="className"><font color="red">（*必填）</font></td></tr>
        <tr><td> 电话：<input type="text" name="tel" ></td></tr>
        <tr><td>邮箱：<input type="text" name="email"></td></tr>
        <tr><td><input type="submit" value="添加"></td></tr>
    </table>
</form>
<font color="red"><%=msg %></font>
</body>
</html>
