<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<!-- Photo -->
	<h3 align="center"> Photo Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Photo ID</th>
		<th>Date Taken</th>
		<th>Photo URL</th>
	</tr>
<c:forEach items="${PhotoList}" var="photo">
	<tr>
		<td>${photo.getPhotoId()}</td>
		<td>${photo.getDateTaken()}</td>
		<td>${photo.getPhotoDir()}</td>
	</tr>
</c:forEach>
</table>


<!-- Predators -->
	<h3 align="center"> Predator Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Species </th>
		<th>Name </th>
		<th>Vore Type</th>
	</tr>
<c:forEach items="${PredatorList}" var="predator">
	<tr>
		<td>${predator.getSpecies()}</td>
		<td>${predator.getName()}</td>
		<td>${predator.getVoreType()}</td>
	</tr>
</c:forEach>
</table>

<!-- Edibles -->
	<h3 align="center"> Edible Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Crop </th>
		<th>Dishes </th>
		<th>Allergen</th>
	</tr>
<c:forEach items="${EdibleList}" var="edible">
	<tr>
		<td>${edible.getCrop()}</td>
		<td>${edible.getDishes()}</td>
		<td>${edible.getAllergen()}</td>
	</tr>
</c:forEach>
</table>

<!-- Season -->
	<h3 align="center"> Season Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Season </th>
		<th>Temperature </th>
		<th>Duration </th>
	</tr>
<c:forEach items="${SeasonList}" var="season">
	<tr>
		<td>${season.getSeason()}</td>
		<td>${season.getTemperature()}</td>
		<td>${season.getDuration()}</td>
	</tr>
</c:forEach>
</table>


</body>
</html>
