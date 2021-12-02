<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Terrain Output</title>
    
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
  <h1>Read Terrain Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Terrain    :<input type="text" name="terrain_type" value="${terrain.getTerraintype() }" disabled/>
	<br/>
	Minerals：<input type="text" name="minerals" value="${terrain.getMinerals()}" disabled/>
	<br/>
	Soil	：<input type="text" name="soil" value="${terrain.getSoil()}" disabled/>
	<br/>
	Fertilizer	：<input type="text" name="fertilizer" value="${terrain.getFertilizer()}" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
