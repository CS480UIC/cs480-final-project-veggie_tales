<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Read Visitor Location</title>

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
			<h1>Read Visitor Location</h1>
			<p style="color: red; font-weight: 900">${msg }</p>
			<form action="<c:url value='/VisitorLocationServletRead'/>" method="post">
				<input type="hidden" name="method" value="regist" />

				Zip Code :<input type="text" name="zip_code" value="${form.zip_code }" />
				<span style="color: red; font-weight: 900">${errors.zip_code }</span>
				<br />
				<!--
				Continent :<input type="text" name="continent" value="${form.continent }" />
				<span style="color: red; font-weight: 900">${errors.username }</span>
				<br />
				Country ：<input type="text" name="country" value="${form.country }" />
				<span style="color: red; font-weight: 900">${errors.password }</span>
				<br />
				City ：<input type="text" name="city" value="${form.city }" />
				<span style="color: red; font-weight: 900">${errors.email }</span>
				<br />
				-->

				<input type="submit" value="Read Visitor Location" />
			</form>
		</body>

		</html>