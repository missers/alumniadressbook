<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alumnileft.jsp' starting page</title>
    
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
         <td><a href="AlumniServlet?dowhat=showall" target="alumniright">显示全部校友信息</a></td>
     </tr>
      <tr>
         <td><a href="alumni/alumniselect.jsp" target="alumniright">查询校友信息</a></td>
     </tr>
     <tr>
         <td><a href="AlumniServlet?dowhat=modify" target="alumniright">修改删除个人信息</a></td>
     </tr>
    </table>
  </body>
</html>
