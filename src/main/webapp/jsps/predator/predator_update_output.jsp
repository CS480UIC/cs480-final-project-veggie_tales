<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Predator</title>
    
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
  <h1>Update Predator</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Species:<input type="text" name="species" value="${predator.getSpecies()}" disabled/>
	<br/>
	
	Name ：<input type="text" name="name" value="${predator.getName() }" disabled />
	<br/>
	Vore Type	：<input type="text" name="vore_type" value="${predator.getVoreType() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/PredatorServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="species" value="${predator.getSpecies() }"/>
	Name ：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	Vore Type	：<input type="text" name="vore_type" value="${form.vore_type }"/>
	<span style="color: red; font-weight: 900">${errors.vore_type }</span>
	<br/>
	<input type="submit" value="Update Predator"/>
</form>

</body>
</html>
