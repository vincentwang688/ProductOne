<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理系统</title>
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
    <h1 align=center>欢迎您的注册
    </h1>
    <br>
    <font size="6"><a href="<%=path%>/register.jsp"><font color="#0000ff">点击注册 </font>
    </a></font>
    <br>
    <font size="6"><a href="<%=path%>/login.jsp"><font color="#0000ff">点击登录 </font>
    </a></font>
  </body>
</html>
