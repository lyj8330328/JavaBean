<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcom.jsp' starting page</title>
    
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
    <form action="loginout.jsp" method="post">
    	<table>
    		<tr>
    			<td colspan="2">登陆成功</td>
    		</tr>
    		<tr>
    			<td>欢迎你：</td>
    			<td><%=session.getAttribute("username")%></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="退出"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
