<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
  <head>
      <base href="<%=basePath%>">

      <title>My JSP 'alumnitop.jsp' starting page</title>

      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
      <meta http-equiv="description" content="This is my page">
      <!--
      <link rel="stylesheet" type="text/css" href="styles.css">
      -->
      <style type="text/css">
          a:hover{
              color:red;
          }
      </style>
  </head>
  
  <body>
     <div style="text-align:right"><a href="index.jsp" target="_parent">退至主页</a></div>
    <h3 style="color:red">欢迎来到校友管理界面</h3>
  </body>
</html>
