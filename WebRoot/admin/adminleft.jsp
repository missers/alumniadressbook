<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>功能</title>
    
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
           color: red;
       }
       a:link{
            text-decoration: none;
       }
   </style>
  </head>
  
  <body>
    <table frame="void" height="100px" >
      <tr>
         <td><a href="AdminServlet?doWhat=showall" target="adminright">显示全部校友信息</a></td>
     </tr>
      <tr>
         <td><a href="admin/adminselect.jsp" target="adminright">查找校友信息</a></td>
     </tr>
      <tr>
         <td><a href="admin/addalumni.jsp" target="adminright">增加校友信息</a></td>
     </tr>
    </table>
  </body>
</html>
