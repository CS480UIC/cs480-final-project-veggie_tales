<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Create Plant</title>

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
			<h1>Create Plant</h1>
			<form action="<c:url value='/PlantServletCreate'/>" method="post">
				Name of Plant :<input type="text" name="plant_name" value="${form.plant_name}" />
				<span style="color: red; font-weight: 900">${errors.plant_name }</span>
				<br />
				Average Measurement ：<input type="text" name="measurement" value="${form.measurement }" />
				<span style="color: red; font-weight: 900">${errors.measurement }</span>
				<br />
				Classification ：<input type="text" name="classification" value="${form.classification }" />
				<span style="color: red; font-weight: 900">${errors.classification }</span>
				<br />
				Growth Season ：<input type="text" name="growth_season" value="${form.growth_season }" />
				<span style="color: red; font-weight: 900">${errors.growth_season }</span>
				<br />
				Discovered By ：<input type="text" name="plant_discoverer" value="${form.plant_discoverer }" />
				<span style="color: red; font-weight: 900">${errors.plant_discoverer }</span>
				<br />
				Photo ID ：<input type="text" name="photo_id" value="${form.photo_id }" />
				<span style="color: red; font-weight: 900">${errors.photo_id }</span>
				<br />
				Eaten By ：<input type="text" name="plant_predator" value="${form.plant_predator}" />
				<span style="color: red; font-weight: 900">${errors.plant_predator }</span>
				<br />
				<input type="submit" value="Create Plant" />
			</form>
		</body>

		</html>