<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Predator Create</title>
    
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
  <h1>Predator Create</h1>
<form action="<c:url value='/PredatorServletCreate'/>" method="post">
	Species    :<input type="text" name="species" value="${form.species}"/>
	<span style="color: red; font-weight: 900">${errors.species }</span>
	<br/>
	Name：<input type="text" name="name" value="${form.name}"/>
	<span style="color: red; font-weight: 900">${errors.name}</span>
	<br/>
	Vore type 	：<input type="text" name="vore_type" value="${form.vore_type}"/>
	<span style="color: red; font-weight: 900">${errors.vore_type }</span>
	<br/>
	<input type="submit" value="Create Predator"/>
</form>
  </body>
</html>
