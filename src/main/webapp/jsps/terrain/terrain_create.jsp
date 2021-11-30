<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Terrain Create</title>
    
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
  <h1>Terrain Create</h1>
<form action="<c:url value='/TerrainServletCreate'/>" method="post">
	Terrain Type    :<input type="text" name="terrain_type" value="${form.terrain_type}"/>
	<span style="color: red; font-weight: 900">${errors.terrain_type }</span>
	<br/>
	Minerals<input type="text" name="minerals" value="${form.minerals}"/>
	<span style="color: red; font-weight: 900">${errors.minerals}</span>
	<br/>
	Soil	：<input type="text" name="soil" value="${form.soil}"/>
	<span style="color: red; font-weight: 900">${errors.soil}</span>
	<br/>
	Fertilizer<input type="text" name="fertilizer" value="${form.fertilizer}"/>
	<span style="color: red; font-weight: 900">${errors.fertilizer }</span>
	<br/>
	<input type="submit" value="Create Terrain"/>
</form>
  </body>
</html>
