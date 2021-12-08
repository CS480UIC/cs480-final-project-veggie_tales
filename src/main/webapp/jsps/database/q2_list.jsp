<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<!-- CityHumidityList -->
	<h3 align="center"> City Humidity Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>rainfall</th>
		<th>city</th>
		<th>humidity</th>
	</tr>
<c:forEach items="${CityHumidityList}" var="CityHumidityList">
	<tr>
		<td>${CityHumidityList.get('rainfall')}</td>
		<td>${CityHumidityList.get('city')}</td>
		<td>${CityHumidityList.get('humidity')}</td>
	</tr>
</c:forEach>
</table>

<!-- PlantSeasonGrowth -->
	<h3 align="center"> Plant Season Growth Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>dishes</th>
		<th>growth_season</th>
		<th>measurement</th>
	</tr>
<c:forEach items="${PlantSeasonGrowthList}" var="PlantSeasonGrowthList">
	<tr>
		<td>${PlantSeasonGrowthList.get('dishes')}</td>
		<td>${PlantSeasonGrowthList.get('growth_season')}</td>
		<td>${PlantSeasonGrowthList.get('measurement')}</td>
	</tr>
</c:forEach>
</table>

<!-- PlantTemperature -->
	<h3 align="center"> Plant Temperature Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>season</th>
		<th>temperature</th>
		<th>plant_name</th>
	</tr>
<c:forEach items="${PlantTemperatureList}" var="PlantTemperatureList">
	<tr>
		<td>${PlantTemperatureList.get('season')}</td>
		<td>${PlantTemperatureList.get('temperature')}</td>
		<td>${PlantTemperatureList.get('plant_name')}</td>
	</tr>
</c:forEach>
</table>

<!-- Plant Classification Location -->
	<h3 align="center"> Plant Classification Location Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>season</th>
		<th>temperature</th>
	</tr>
<c:forEach items="${PlantClassificationLocationList}" var="PlantClassificationLocationList">
	<tr>
		<td>${PlantClassificationLocationList.get('classification')}</td>
		<td>${PlantClassificationLocationList.get('discovered_location')}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
