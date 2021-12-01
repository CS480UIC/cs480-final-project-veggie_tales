<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Predator</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PredatorServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="species" value="${predator.getSpecies() }"/>
	Species    :<input type="text" name="species" value="${predator.getSpecies() }" disabled/>
	<br/>
	
	Name：<input type="text" name="name" value="${predator.getName() }" disabled/>
	<br/>
	Vore Type：<input type="text" name="vore_type" value="${predator.getVoreType() }" disabled/>
	<br/>
	<input type="submit" value="Delete Predator"/>
</form>

</body>
</html>
