<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Season</title>
    
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
  <h1>Update Season</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Season    :<input type="text" name="season" value="${season.getSeason() }" disabled/>
	<br/>
	
	Temperature: <input type="text" name="temperature" value="${season.getTemperature() }" disabled />
	<br/>
	Duration	：<input type="text" name="duration" value="${season.getDuration() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/SeasonServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="season" value="${season.getSeason() }"/>
	Temperature: <input type="text" name="temperature" value="${form.temperature }"/>
	<span style="color: red; font-weight: 900">${errors.temperature }</span>
	<br/>
	Duration	：<input type="text" name="duration" value="${form.duration }"/>
	<span style="color: red; font-weight: 900">${errors.duration }</span>
	<br/>
	<input type="submit" value="Update Season"/>
</form>

</body>
</html>
