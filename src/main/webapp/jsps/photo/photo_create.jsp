<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Create Photo</title>

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
			<h1>Create Photo</h1>
			<form action="<c:url value='/PhotoServletCreate'/>" method="post">
				Photo ID :<input type="text" name="photo_id" value="${form.photo_id }" />
				<span style="color: red; font-weight: 900">${errors.photo_id}</span>
				<br />
				Date Taken ：<input type="text" name="date_taken" value="${form.date_taken }" />
				<span style="color: red; font-weight: 900">${errors.date_taken }</span>
				<br />
				Photo Directory ：<input type="text" name="photo_dir" value="${form.photo_dir }" />
				<span style="color: red; font-weight: 900">${errors.photo_dir }</span>
				<br />
				<input type="submit" value="Create Photo" />
			</form>
		</body>

		</html>