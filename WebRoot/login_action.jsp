<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_action.jsp' starting page</title>
    
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
    <%@ page import="data.*" %>
    <%@ page import="java.sql.*" %>
  
   <%
   		String us=request.getParameter("username");
   		String ps=request.getParameter("password");
   		if(us==null||"".equals(us.trim())||ps==null||"".equals(ps.trim())){
   			System.out.print("用户名或者密码不能为空!");
   			response.sendRedirect("index.jsp");
   			
   		}
 		
   		UserBean userBean=new UserBean();
   		boolean isValid=userBean.valid(us, ps);
   		System.out.print(isValid);
   		if(isValid){
   			System.out.println("登陆成功！");
   			session.setAttribute("username", us);
   			response.sendRedirect("welcom.jsp");
   		}
   		else{
   			System.out.print("用户名或者密码错误！");
   			response.sendRedirect("login.jsp");
   		}
   		
    %>
  </body>
</html>
