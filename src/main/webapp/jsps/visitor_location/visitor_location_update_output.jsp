<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Update Visitor Location</title>

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
			<h1>Update Entity</h1>
			<p style="color: red; font-weight: 900">${msg }</p>
			<form>
				Zip Code :<input type="text" name="zip" value="${visitor_location.getZip() }" disabled />
				<br />

				Continent：<input type="text" name="continent" value="${visitor_location.getContinent() }" disabled />
				<br />
				Country：<input type="text" name="country" value="${visitor_location.getCountry() }" disabled />
				<br />
				City ：<input type="text" name="city" value="${visitor_location.getCity()}" disabled />
				<br />
				Climate ：<input type="text" name="climate" value="${visitor_location.getClimate()}" disabled />
				<br />
				Terrain ：<input type="text" name="terrain" value="${visitor_location.getTerrain()}" disabled />
				<br />
			</form>
			<h1>Update the values below</h1>
			<form action="<c:url value='/VisitorLocationServletUpdate'/>" method="post">
				<input type="hidden" name="method" value="update" />
				<input type="hidden" name="zip_code" value="${visitor_location.getZip() }" />
				Continent :<input type="text" name="continent" value="${form.getContinent()}" />
				<span style="color: red; font-weight: 900">${errors.getContinent() }</span>
				<br />
				Country ：<input type="text" name="country" value="${form.getCountry() }" />
				<span style="color: red; font-weight: 900">${errors.getCountry() }</span>
				<br />
				City ：<input type="text" name="city" value="${form.getCity() }" />
				<span style="color: red; font-weight: 900">${errors.getCity() }</span>
				<br />
				Climate ：<input type="text" name="climate" value="${form.getClimate() }" />
				<span style="color: red; font-weight: 900">${errors.getClimate() }</span>
				<br />
				Terrain ：<input type="text" name="terrain" value="${form.getTerrain() }" />
				<span style="color: red; font-weight: 900">${errors.getTerrain() }</span>
				<br />
				<input type="submit" value="Update Visitor Location" />
			</form>

		</body>

		</html>