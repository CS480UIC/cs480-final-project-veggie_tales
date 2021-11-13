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