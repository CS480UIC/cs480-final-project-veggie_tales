<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Discoverer</title>
    
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
  <h1>Create Discoverer</h1>
<form action="<c:url value='/DiscovererServletCreate'/>" method="post">
	Discoverer Name    :<input type="text" name="discoverer_name" value="${form.getDiscovererName() }"/>
	<span style="color: red; font-weight: 900">${errors.getDiscovererName()  }</span>
	<br/>
	Date	：<input type="text" name="date" value="${form.getDate() }"/>
	<span style="color: red; font-weight: 900">${errors.getDate()  }</span>
	<br/>
	Location	：<input type="text" name="discovered_location" value="${form.getDiscoveredLocation() }"/>
	<span style="color: red; font-weight: 900">${errors.getDiscoveredLocation() }</span>
	<br/>
	<input type="submit" value="Create Discoverer"/>
</form>
  </body>
</html>
