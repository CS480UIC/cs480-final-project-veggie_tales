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
				Zip Code :<input type="text" name="zip" value="${visitor_location.zip_code }" disabled />
				<br />

				Continent：<input type="text" name="continent" value="${visitor_location.continent }" disabled />
				<br />
				Country：<input type="text" name="country" value="${visitor_location.country }" disabled />
				<br />
				City ：<input type="text" name="city" value="${visitor_location.city}" disabled />
				<br />
			</form>
			<h1>Update the values below</h1>
			<form action="<c:url value='/VisitorLocationServletUpdate'/>" method="post">
				<input type="hidden" name="method" value="update" />
				<input type="hidden" name="zip_code" value="${visitor_location.zip_code }" />
				Continent :<input type="text" name="continent" value="${form.continent }" />
				<span style="color: red; font-weight: 900">${errors.username }</span>
				<br />
				Country ：<input type="text" name="country" value="${form.country }" />
				<span style="color: red; font-weight: 900">${errors.password }</span>
				<br />
				City ：<input type="text" name="city" value="${form.city }" />
				<span style="color: red; font-weight: 900">${errors.email }</span>
				<br />
				<input type="submit" value="Update Visitor Location" />
			</form>

		</body>

		</html>