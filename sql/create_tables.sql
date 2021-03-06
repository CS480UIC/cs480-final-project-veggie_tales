
CREATE TABLE edible (
    crop VARCHAR(30) NOT NULL,
    dishes VARCHAR(40),
    allergen TINYINT UNSIGNED,

    PRIMARY KEY (crop)
);

CREATE TABLE predator (
    species VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(40),
    vore_type VARCHAR(10),

    PRIMARY KEY (species)
);

CREATE TABLE climate (
    climate VARCHAR(30) NOT NULL,
    rainfall TINYINT NOT NULL,
    humidity TINYINT NOT NULL,

    PRIMARY KEY (climate)
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


CREATE TABLE season (
    season VARCHAR(10) NOT NULL,
    temperature TINYINT NOT NULL,
    duration TINYINT NOT NULL,

    PRIMARY KEY(season)
);

CREATE TABLE visitor_location (
    zip_code VARCHAR(10) UNIQUE NOT NULL,
    continent VARCHAR(15),
    country VARCHAR(60),
    city VARCHAR(80),
    climate VARCHAR(30) NOT NULL,
    terrain VARCHAR(30) NOT NULL,

    PRIMARY KEY(zip_code),
    FOREIGN KEY (climate) REFERENCES climate(climate),
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
    FOREIGN KEY (plant_name) REFERENCES edible(crop),
    FOREIGN KEY (growth_season) REFERENCES season(season),
    FOREIGN KEY (plant_discoverer) REFERENCES discoverer(discoverer_name),
    FOREIGN KEY (photo_id) REFERENCES photo(photo_id),
    FOREIGN KEY (plant_predator) REFERENCES predator(species)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE user
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);