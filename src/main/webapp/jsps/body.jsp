<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>Welcome to our Veggie Tales Project!!!</h1>


    
	<h2>Initialize Database</h2>
	<form action="<c:url value='/DatabaseServletCreate'/>" method="post">
		<input type="submit" value="Initialize" />
	</form>
	
	<h2>Delete Database</h2>
	<form action="<c:url value='/DatabaseServletDelete'/>" method="post">
		<input type="submit" value="Delete" />
	</form>
	

    <c:choose>
    <c:when test="${!empty sessionScope.session_user }">

	<h2>Complex Query</h2>
	<form action="<c:url value='/DatabaseServletComplex'/>" method="post"> <!-- was update -->
		<input type="submit" value="Complex" />
	</form>
	
	<h2>Aggregate Query</h2>
	<form action="<c:url value='/DatabaseServletAggregate'/>" method="post"> <!-- was read -->
		<input type="submit" value="Aggregate" />
	</form>
	
	<h2>Simple Query</h2>
	<form action="<c:url value='/DatabaseServletSimple'/>" method="post">
		<input type="submit" value="Simple" />
	</form>

	</c:when>
	</c:choose>

		
    
  </body>
</html>
