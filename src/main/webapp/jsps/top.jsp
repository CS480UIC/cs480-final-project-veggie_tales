<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>
			<title>top</title>

			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<meta http-equiv="content-type" content="text/html;charset=utf-8">
			<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
			<style type="text/css">
				body {
					background: #c1e1c1;
				}

				a {
					text-transform: none;
					text-decoration: none;
				}

				a:hover {
					text-decoration: underline;
				}
			</style>
		</head>

		<body>
			<h1 style="text-align: center;">veggie_tales</h1>
			<div style="font-size: 10pt;">
				<c:choose>
					<c:when test="${empty sessionScope.session_user }">
						<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp;
						<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp;
						<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
						<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp;
					</c:when>
					<c:otherwise>
						Hello：${sessionScope.session_user.username };
						<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">List All Users</a> |&nbsp;&nbsp;
						<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp;
						<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/discoverer/menu.jsp'/>" target="body">CRUD Discoverer</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/predator/menu.jsp'/>" target="body">CRUD Predator</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/season/menu.jsp'/>" target="body">CRUD Season</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/edible/menu.jsp'/>" target="body">CRUD Edible</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/terrain/menu.jsp'/>" target="body">CRUD Terrain</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/visitor_location/menu.jsp'/>" target="body">CRUD Visitor Location</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/plant/menu.jsp'/>" target="body">CRUD Plant</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/photo/menu.jsp'/>" target="body">CRUD Photo</a> |&nbsp;&nbsp;
						<a href="<c:url value='/jsps/climate/menu.jsp'/>" target="body">CRUD Climate</a> |&nbsp;&nbsp;

					</c:otherwise>
				</c:choose>

			</div>
		</body>

		</html>