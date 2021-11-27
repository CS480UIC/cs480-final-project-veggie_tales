<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Edible Create</title>

			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<meta http-equiv="content-type" content="text/html;charset=utf-8">
			<!--
	<link rel="stylesheett" type="text/css" href="styles.css">
	-->

		</head>

		<body>
			<h1>Edible Create</h1>
			<form action="<c:url value='/EdibleServletCreate'/>" method="post">
				Crop :<input type="text" name="crop" value="${form.crop }" />
				<span style="color: red; font-weight: 900">${errors.crop }</span>
				<br />
				Dishes :<input type="text" name="dishes" value="${form.dishes }" />
				<span style="color: red; font-weight: 900">${errors.dishes }</span>
				<br />
				Allergen ：<input type="text" name="allergen" value="${form.allergen }" />
				<span style="color: red; font-weight: 900">${errors.allergen }</span>
				<br />
				<input type="submit" value="Create Edible" />
			</form>
		</body>

		</html>