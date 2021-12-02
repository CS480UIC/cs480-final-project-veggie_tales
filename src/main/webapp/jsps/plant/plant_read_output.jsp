<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Read Plant Output</title>

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
			<h1>Read Plant Output</h1>
			<p style="color: red; font-weight: 900">${msg }</p>
			<form>
				Name of Plant :<input type="text" name="plant_name" value="${plant.getPlantName() }" disabled />
				<br />

				Average Measurement：<input type="text" name="measurement" value="${plant.getMeasurement() }" disabled />
				<br />
				Classification ：<input type="text" name="classification" value="${plant.getClassification() }"
					disabled />
				<br />
				Growth Season ：<input type="text" name="growth_season" value="${plant.getGrowthSeason() }" disabled />
				<br />
				Discovered By ：<input type="text" name="plant_discoverer" value="${plant.getPlantDiscoverer() }"
					disabled />
				<br />
				Photo ID：<input type="text" name="photo_id" value="${plant.getPhotoId() }" disabled />
				<br />
				Eaten By ：<input type="text" name="plant_predator" value="${plant.getPlantPredator() }" disabled />
				<br />
			</form>

			<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
		</body>

		</html>