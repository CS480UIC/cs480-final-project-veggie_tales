<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>

			<title>Delete Entity</title>

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
			<h1>Update Photo</h1>
			<p style="color: red; font-weight: 900">${msg }</p>
			<form>
				Photo ID :<input type="text" name="photo_id" value="${photo.getPhotoId() }" disabled />
				<br />
				Date Taken：<input type="text" name="date_taken" value="${photo.getDateTaken() }" disabled />
				<br />
				Photo Directory：<input type="text" name="photo_url" value="${photo.getPhotoDir() }" disabled />
				<br />
			</form>
			<h1>Update the values below</h1>
			<form action="<c:url value='/PhotoServletUpdate'/>" method="post">
				<input type="hidden" name="method" value="update" />
				<input type="hidden" name="photo_id" value="${photo.getPhotoId() }" />
				Date Taken：<input type="text" name="date_taken" value="${photo.getDateTaken() }" />
				<span style="color: red; font-weight: 900">${errors.getDateTaken() }</span>
				<br />
				Photo Directory ：<input type="text" name="photo_url" value="${photo.getPhotoDir() }" />
				<span style="color: red; font-weight: 900">${errors.getPhotoDir() }</span>
				<br />
				<input type="submit" value="Update Edible" />
			</form>
			

		</body>

		</html>