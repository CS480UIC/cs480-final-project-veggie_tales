DELIMITER $$
CREATE DEFINER=`veggie_tales`@`localhost` PROCEDURE `SelectAllClimates`()
BEGIN
	SELECT * FROM climate;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`veggie_tales`@`localhost` PROCEDURE `SelectAllPlants`()
BEGIN
	SELECT * FROM plant;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`veggie_tales`@`localhost` PROCEDURE `SelectAllPredators`()
BEGIN
	SELECT * FROM predator;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`veggie_tales`@`localhost` PROCEDURE `SelectAllTerrain`()
BEGIN
	SELECT * FROM terrain;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` FUNCTION `CheckCountry`(countryName VARCHAR(60)) RETURNS tinyint
    DETERMINISTIC
BEGIN
	DECLARE possibleCountry VARCHAR(60) DEFAULT NULL;
    
	SELECT country INTO possibleCountry
	FROM visistor_location
	WHERE country LIKE countryName;
    
    IF possibleCountry = NULL THEN
		RETURN 0;
    END IF;
	RETURN 1;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`%` FUNCTION `CountPlants`() RETURNS int
    DETERMINISTIC
BEGIN

	DECLARE numPlants INTEGER;
    
	SELECT COUNT(*) INTO numPlants
    FROM plants;
    
RETURN numPlants;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`%` FUNCTION `IsEdible`(plant VARCHAR(30)) RETURNS tinyint
    DETERMINISTIC
BEGIN
	DECLARE edible_bool TINYINT DEFAULT 0;
    
    SELECT allergen INTO edible_bool
    FROM edible
    WHERE crop LIKE plant;

RETURN edible_bool;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`%` FUNCTION `doesAllPlantsHaveDiscoverer`() RETURNS tinyint
    DETERMINISTIC
BEGIN
	
    DECLARE numDiscoverers INTEGER DEFAULT 0;
    DECLARE allPlants INTEGER DEFAULT 0;
    
    SELECT COUNT(plant_discoverer) INTO numDiscoverers
    FROM plant
    WHERE plant_discoverer = NULL;
    
    SELECT COUNT(*) INTO allPlants
    FROM plant;
    
    
    IF numDiscoverers != allPlants THEN
		RETURN 0;
	END IF;

RETURN 1;
END$$
DELIMITER ;



