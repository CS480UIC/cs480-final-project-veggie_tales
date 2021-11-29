-- 6.1

CREATE VIEW RecentPhotos
AS
SELECT * 
FROM photo
WHERE DATE(date_taken) > 2015-01-01
ORDER BY photo_id DESC;

CREATE VIEW SpringPlants
AS
SELECT plant_name, classification, growth_season
FROM plant
WHERE growth_season = 'spring'
ORDER BY classification ASC;

CREATE VIEW ChinaVisitors
AS
SELECT * 
FROM visitor_location
WHERE country = 'South Korea'
ORDER BY zip_code ASC;

CREATE VIEW HerbivorePredators
AS
SELECT *
FROM predator
WHERE vore_type LIKE '%Bug%'
ORDER BY species ASC;


-- 6.2

CREATE VIEW NumberOfRecentDiscoverers
AS
SELECT COUNT(*) 
FROM discoverer
WHERE DATE(date) > 2000-01-01;

CREATE VIEW RoundedPlantMeasurements
AS
SELECT ROUND(measurement, 1)
FROM plant;

CREATE VIEW PredatorVSPlantSize
AS
SELECT measurement, growth_season
FROM plant
GROUP BY measurement, growth_season
HAVING measurement > 10;


CREATE VIEW LabeledDiscoverers
AS
SELECT CONCAT('Discoverer: ', discoverer_name) AS DiscovererName
FROM discoverer
WHERE DATE(date) > 2000-01-01;

-- 6.3

CREATE VIEW CityHumidity
AS
SELECT rainfall, city, humidity
FROM climate c
INNER JOIN visitor_location v
ON c.climate_name = v.climate
WHERE (v.city = 'Lagos' OR v.city = 'Karachi')
GROUP BY c.rainfall, v.city, c.humidity
ORDER BY c.humidity;

CREATE VIEW PlantSeasonGrowth
AS
SELECT dishes, growth_season, measurement
FROM edible e
INNER JOIN plant p
ON e.crop = p.plant_name
WHERE measurement >
 (SELECT AVG(measurement)
	FROM plant
	WHERE plant_name = plant.plant_name)
GROUP BY growth_season,dishes,measurement
ORDER BY measurement ASC;


CREATE VIEW PlantTemperature
AS
SELECT season_name, temperature, plant_name
FROM season s
INNER JOIN plant p
ON s.season_name = p.growth_season
WHERE temperature >
	(SELECT AVG(temperature) 
	FROM season
	WHERE temperature > 50)
GROUP BY season_name, temperature, plant_name
ORDER BY temperature DESC;


CREATE VIEW PlantClassificationLocation
AS
SELECT classification, discovered_location
FROM plant P
INNER JOIN discoverer L 
ON P.plant_discoverer = L.discoverer_name
WHERE EXISTS
	(SELECT *
	FROM photo
	WHERE photo_id = P.photo_id AND date_taken  > 2021-05-02)
GROUP BY P.classification, L.discovered_location;

