CREATE INDEX climateIndex
ON climate (humidity);

CREATE INDEX discovererIndex
ON discoverer (discovered_location);

CREATE INDEX edibleIndex
ON edible (dishes);

CREATE INDEX photoIndex
ON photo (photo_id,date_taken);

CREATE INDEX plantIndex
ON plant (plant_name,classification);

CREATE INDEX predatorIndex
ON predator (vore_type);

CREATE INDEX seasonIndex
ON season (season_name,temperature);

CREATE INDEX terrainIndex
ON terrain (soil);

CREATE INDEX visitor_locationIndex
ON visitor_location (continent,country,city);
