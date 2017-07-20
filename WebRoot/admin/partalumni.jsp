<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="team.aab.bean.AlumniBean" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<AlumniBean> aluList =(List) request.getAttribute("aluList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'admaintop.jsp' starting page</title>

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
查找成功<hr>

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
        <td><input type="button" value="修改" onclick="update('<%=username%>')"></td>
        <td><input type="button" value="删除" onclick="querenDelete('<%=username%>')"></td>
    </tr>
        <% }%>

    <script type="text/javascript">
        function querenDelete(username) {
            var flag= window.confirm("确认删除？");
            if(flag==true){
                this.location.href="AdminServlet?doWhat=delete&username="+username;
            }
        }
        function update(username) {
            window.location.href="AdminServlet?doWhat=toUpdate&username="+username;
        }
    </script>
</body>
</html>
