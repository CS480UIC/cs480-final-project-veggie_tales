<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Discoverer</title>
    
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
  <h1>Update Discoverer</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Discoverer Name    :<input type="text" name="discoverer_name" value="${discoverer.getDiscovererName() }" disabled/>
	<br/>
	
	Date Discovered：<input type="text" name="date" value="${discoverer.getDate() }" disabled />
	<br/>
	Location Discovered	：<input type="text" name="discovered_location" value="${discoverer.getDiscoveredLocation() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/DiscovererServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="discoverer_name" value="${discoverer.getDiscovererName() }"/>
	Date Discovered：<input type="text" name="password" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Location Discovered	：<input type="text" name="discovered_location" value="${form.discovered_location }"/>
	<span style="color: red; font-weight: 900">${errors.discovered_location }</span>
	<br/>
	<input type="submit" value="Update Discoverer"/>
</form>

</body>
</html>
