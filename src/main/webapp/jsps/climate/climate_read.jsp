<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Climate</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Read Climate</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ClimateServletRead'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Climate Type    :<input type="text" name="climate" value="${form.climate }"/>
	<span style="color: red; font-weight: 900">${errors.climate }</span>
	<br/>
<%-- 	Rainfall: <input type="text" name="rainfall" value="${form.rainfall }"/>
	<span style="color: red; font-weight: 900">${errors.rainfall }</span>
	<br/>
	Humidity	：<input type="text" name="humidity" value="${form.humidity }"/>
	<span style="color: red; font-weight: 900">${errors.humidity }</span>
	<br/> --%>
	<input type="submit" value="Read Climate"/>
</form>
  </body>
</html>
