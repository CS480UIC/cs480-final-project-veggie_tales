<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Delete Plant</title>

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
			<h1>Delete Plant</h1>
			<!--Hey Maryam, I'm about to log out for like 10 mins-->
			<form action="<c:url value='/PlantServletDelete'/>" method="post">
				<input type="hidden" name="method" value="search" />
				Delete Plant Name :<input type="text" name="plant_name" value="${plant.getPlantName() }" />
				<span style="color: red; font-weight: 900">${errors.getPlantName() }</span>
				<br />
				<input type="submit" value="Delete Plant" />
			</form>
		</body>

		</html>