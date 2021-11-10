
CREATE TABLE edible (
    crop VARCHAR(30) NOT NULL,
    dishes VARCHAR(40),
    allergen TINYINT UNSIGNED,

    PRIMARY KEY (crop)
);

CREATE TABLE predator (
    species VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(40) NOT NULL,
    vore_type VARCHAR(10),

    PRIMARY KEY (species)
);

CREATE TABLE climate (
    climate_name VARCHAR(30) NOT NULL,
    rainfall TINYINT NOT NULL,
    humidity TINYINT NOT NULL,

    PRIMARY KEY (climate_name)
);

CREATE TABLE terrain (
    terrain_type VARCHAR(30) NOT NULL,
    minerals VARCHAR(20),
    soil VARCHAR(20),
    fertilizer VARCHAR(30),

    PRIMARY KEY(terrain_type)
);


CREATE TABLE discoverer (
    discoverer_name VARCHAR(40) NOT NULL,
    date DATE,
    discovered_location VARCHAR(40),

    PRIMARY KEY(discoverer_name)
);

CREATE TABLE photo (
    photo_id MEDIUMINT NOT NULL,
    date_taken DATE,
    photo_url VARCHAR(300) NOT NULL,

    PRIMARY KEY(photo_id)
);


CREATE TABLE user (
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(20),

    PRIMARY KEY(username)
);


CREATE TABLE season (
    season_name VARCHAR(6) NOT NULL,
    temperature TINYINT NOT NULL,
    duration TINYINT NOT NULL,
    season_climate VARCHAR(30) NOT NULL,

    PRIMARY KEY(season_name),
    FOREIGN KEY (season_climate) REFERENCES climate(climate_name)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE visitor_location (
    zip_code VARCHAR(10) UNIQUE NOT NULL,
    continent VARCHAR(15),
    country VARCHAR(60),
    city VARCHAR(80),
    climate VARCHAR(30) NOT NULL,
    terrain VARCHAR(30) NOT NULL,

    PRIMARY KEY(zip_code),
    FOREIGN KEY (climate) REFERENCES climate(climate_name),
    FOREIGN KEY (terrain) REFERENCES terrain(terrain_type)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE plant (
    plant_name VARCHAR(50) NOT NULL,
    measurement TINYINT NOT NULL,
    classification VARCHAR(30) NOT NULL,
    growth_season VARCHAR(10),
    plant_discoverer VARCHAR(40),
    photo_id MEDIUMINT NOT NULL,
    plant_predator VARCHAR(50),
  
    PRIMARY KEY(plant_name),
    FOREIGN KEY (growth_season) REFERENCES season(season_name),
    FOREIGN KEY (plant_discoverer) REFERENCES discoverer(discoverer_name),
    FOREIGN KEY (photo_id) REFERENCES photo(photo_id),
    FOREIGN KEY (plant_predator) REFERENCES predator(species)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

