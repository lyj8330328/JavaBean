<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="data.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register_action.jsp' starting page</title>
    
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
  	
  	<%
  		String username=request.getParameter("username");
  		String password1=request.getParameter("password1");
  		String password2=request.getParameter("password2");
  		String email=request.getParameter("email");
  		if(username==null||"".equals(username.trim())||password1==null
  		||"".equals(password1)||password2==null||"".equals(password2)||!password1.equals(password2)){
  			System.out.print("用户名或密码不能为空！");
  			response.sendRedirect("register.jsp");
  			return;
  		}
  		UserBean userbean=new UserBean();
  		boolean isExit=userbean.isExist(username);
  		if(!isExit){
  			userbean.add(username, password1, email);
  			System.out.print("注册成功，请登陆！");
  			response.sendRedirect("login.jsp");
  			
  		}
  		else{
  			System.out.print("用户名已存在！");
  			response.sendRedirect("register.jsp");
  			
  		}
  	 %>
  </body>
</html>
