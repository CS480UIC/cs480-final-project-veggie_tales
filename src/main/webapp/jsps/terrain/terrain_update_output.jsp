<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Update Terrain</title>

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
			<h1>Update Terrain</h1>
			<p style="color: red; font-weight: 900">${msg }</p>
			<form>
				Terrain :<input type="text" name="terrain_type" value="${terrain.getTerraintype() }" disabled />
				<br />
				Minerals：<input type="text" name="minerals" value="${terrain.getMinerals()}" disabled />
				<br />
				Soil ：<input type="text" name="soil" value="${terrain.getSoil()}" disabled />
				<br />
				Fertilizer ：<input type="text" name="fertilizer" value="${terrain.getFertilizer()}" disabled />
				<br />
			</form>
			<h1>Update the values below</h1>
			<form action="<c:url value='/TerrainServletUpdate'/>" method="post">
				<input type="hidden" name="method" value="update" />
				<input type="hidden" name="terrain_type" value="${terrain.getTerraintype() }" />
				Minerals ：<input type="text" name="minerals" value="${form.minerals}" />
				<span style="color: red; font-weight: 900">${errors.minerals }</span>
				<br />
				Soil ：<input type="text" name="soil" value="${form.soil}" />
				<span style="color: red; font-weight: 900">${errors.soil }</span>
				<br />
				Fertilizer ：<input type="text" name="fertilizer" value="${form.fertilizer}" />
				<span style="color: red; font-weight: 900">${errors.fertilizer }</span>
				<br />
				<input type="submit" value="Update Terrain" />
			</form>

		</body>

		</html>