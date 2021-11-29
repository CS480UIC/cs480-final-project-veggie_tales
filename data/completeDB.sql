-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: veggietales-db
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `chinavisitors`
--

DROP TABLE IF EXISTS `chinavisitors`;
/*!50001 DROP VIEW IF EXISTS `chinavisitors`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `chinavisitors` AS SELECT 
 1 AS `zip_code`,
 1 AS `continent`,
 1 AS `country`,
 1 AS `city`,
 1 AS `climate`,
 1 AS `terrain`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cityhumidity`
--

DROP TABLE IF EXISTS `cityhumidity`;
/*!50001 DROP VIEW IF EXISTS `cityhumidity`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `cityhumidity` AS SELECT 
 1 AS `rainfall`,
 1 AS `city`,
 1 AS `humidity`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `climate`
--

DROP TABLE IF EXISTS `climate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `climate` (
  `climate_name` varchar(30) NOT NULL,
  `rainfall` tinyint NOT NULL,
  `humidity` tinyint NOT NULL,
  PRIMARY KEY (`climate_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `climate`
--

LOCK TABLES `climate` WRITE;
/*!40000 ALTER TABLE `climate` DISABLE KEYS */;
INSERT INTO `climate` VALUES ('Continental ',15,50),('Dry',10,0),('Polar',67,73),('Temperate',48,20),('Tropical',70,64);
/*!40000 ALTER TABLE `climate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discoverer`
--

DROP TABLE IF EXISTS `discoverer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discoverer` (
  `discoverer_name` varchar(40) NOT NULL,
  `date` date DEFAULT NULL,
  `discovered_location` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`discoverer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discoverer`
--

LOCK TABLES `discoverer` WRITE;
/*!40000 ALTER TABLE `discoverer` DISABLE KEYS */;
INSERT INTO `discoverer` VALUES ('Frank Vasek',NULL,'Greek\r'),('John Gardiner',NULL,'UK'),('Marco Polo','1254-09-15','Italy\r'),('Samuel McElvain','1973-04-11','USA\r');
/*!40000 ALTER TABLE `discoverer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edible`
--

DROP TABLE IF EXISTS `edible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edible` (
  `crop` varchar(30) NOT NULL,
  `dishes` varchar(40) DEFAULT NULL,
  `allergen` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`crop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edible`
--

LOCK TABLES `edible` WRITE;
/*!40000 ALTER TABLE `edible` DISABLE KEYS */;
INSERT INTO `edible` VALUES ('Catnip','N/A',1),('Chives','seafood',0),('Marigold','dessert',0),('Mint','soup',0),('Oregano','chicken',0);
/*!40000 ALTER TABLE `edible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `herbivorepredators`
--

DROP TABLE IF EXISTS `herbivorepredators`;
/*!50001 DROP VIEW IF EXISTS `herbivorepredators`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `herbivorepredators` AS SELECT 
 1 AS `species`,
 1 AS `name`,
 1 AS `vore_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `labeleddiscoverers`
--

DROP TABLE IF EXISTS `labeleddiscoverers`;
/*!50001 DROP VIEW IF EXISTS `labeleddiscoverers`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `labeleddiscoverers` AS SELECT 
 1 AS `DiscovererName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `numberofrecentdiscoverers`
--

DROP TABLE IF EXISTS `numberofrecentdiscoverers`;
/*!50001 DROP VIEW IF EXISTS `numberofrecentdiscoverers`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `numberofrecentdiscoverers` AS SELECT 
 1 AS `COUNT(*)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photo` (
  `photo_id` mediumint NOT NULL,
  `date_taken` date DEFAULT NULL,
  `photo_url` varchar(300) NOT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,'2021-05-02','NULL\r'),(2,'2021-09-01','NULL\r'),(3,'2021-06-04','https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fphotos%2Fplants&psig=AOvVaw2lTYlCRz6lsRZ423XI_8zN&ust=1634785425699000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIDn1baA2PMCFQAAAAAdAAAAABAD\r'),(4,'2021-03-12','https://www.google.com/url?sa=i&url=https%3A%2F%2Fdepositphotos.com%2Fstock-photos%2Fplant.html&psig=AOvVaw2lTYlCRz6lsRZ423XI_8zN&ust=1634785425699000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIDn1baA2PMCFQAAAAAdAAAAABAI\r'),(5,'2021-01-09','https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.gardeningknowhow.com%2Fhouseplants%2Fsnake-plant%2Fsnake-plant-care.htm&psig=AOvVaw2lTYlCRz6lsRZ423XI_8zN&ust=1634785425699000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIDn1baA2PMCFQAAAAAdAAAAABAO');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant`
--

DROP TABLE IF EXISTS `plant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant` (
  `plant_name` varchar(50) NOT NULL,
  `measurement` tinyint NOT NULL,
  `classification` varchar(30) NOT NULL,
  `growth_season` varchar(10) DEFAULT NULL,
  `plant_discoverer` varchar(40) DEFAULT NULL,
  `photo_id` mediumint NOT NULL,
  `plant_predator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`plant_name`),
  KEY `growth_season` (`growth_season`),
  KEY `plant_discoverer` (`plant_discoverer`),
  KEY `photo_id` (`photo_id`),
  KEY `plant_predator` (`plant_predator`),
  CONSTRAINT `plant_ibfk_1` FOREIGN KEY (`plant_name`) REFERENCES `edible` (`crop`),
  CONSTRAINT `plant_ibfk_2` FOREIGN KEY (`growth_season`) REFERENCES `season` (`season_name`),
  CONSTRAINT `plant_ibfk_3` FOREIGN KEY (`plant_discoverer`) REFERENCES `discoverer` (`discoverer_name`),
  CONSTRAINT `plant_ibfk_4` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`photo_id`),
  CONSTRAINT `plant_ibfk_5` FOREIGN KEY (`plant_predator`) REFERENCES `predator` (`species`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant`
--

LOCK TABLES `plant` WRITE;
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
INSERT INTO `plant` VALUES ('Catnip',5,'Herb','Spring','Samuel McElvain',2,'cat\r'),('Chives',15,'Vegetable','Spring','Marco Polo',3,'thrip\r'),('Marigold',36,'Flower','Summer',NULL,4,'aphids\r'),('Mint',12,'Herb','Summer','John Gardiner',5,'beetles'),('Oregano',18,'Herb','Spring','Frank Vasek',1,'leafhooper\r');
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `plantclassificationlocation`
--

DROP TABLE IF EXISTS `plantclassificationlocation`;
/*!50001 DROP VIEW IF EXISTS `plantclassificationlocation`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `plantclassificationlocation` AS SELECT 
 1 AS `classification`,
 1 AS `discovered_location`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `plantseasongrowth`
--

DROP TABLE IF EXISTS `plantseasongrowth`;
/*!50001 DROP VIEW IF EXISTS `plantseasongrowth`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `plantseasongrowth` AS SELECT 
 1 AS `dishes`,
 1 AS `growth_season`,
 1 AS `measurement`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `planttemperature`
--

DROP TABLE IF EXISTS `planttemperature`;
/*!50001 DROP VIEW IF EXISTS `planttemperature`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `planttemperature` AS SELECT 
 1 AS `season_name`,
 1 AS `temperature`,
 1 AS `plant_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `predator`
--

DROP TABLE IF EXISTS `predator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `predator` (
  `species` varchar(50) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `vore_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`species`),
  UNIQUE KEY `species` (`species`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predator`
--

LOCK TABLES `predator` WRITE;
/*!40000 ALTER TABLE `predator` DISABLE KEYS */;
INSERT INTO `predator` VALUES ('aphids',NULL,'Bug\r'),('beetles',NULL,'Bug'),('cat',NULL,'Mammal\r'),('leafhooper',NULL,'Bug\r'),('thrip',NULL,'Bug\r');
/*!40000 ALTER TABLE `predator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `predatorvsplantsize`
--

DROP TABLE IF EXISTS `predatorvsplantsize`;
/*!50001 DROP VIEW IF EXISTS `predatorvsplantsize`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `predatorvsplantsize` AS SELECT 
 1 AS `measurement`,
 1 AS `growth_season`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `recentphotos`
--

DROP TABLE IF EXISTS `recentphotos`;
/*!50001 DROP VIEW IF EXISTS `recentphotos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `recentphotos` AS SELECT 
 1 AS `photo_id`,
 1 AS `date_taken`,
 1 AS `photo_url`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `roundedplantmeasurements`
--

DROP TABLE IF EXISTS `roundedplantmeasurements`;
/*!50001 DROP VIEW IF EXISTS `roundedplantmeasurements`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `roundedplantmeasurements` AS SELECT 
 1 AS `ROUND(measurement, 1)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `season` (
  `season_name` varchar(10) NOT NULL,
  `temperature` tinyint NOT NULL,
  `duration` tinyint NOT NULL,
  PRIMARY KEY (`season_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
INSERT INTO `season` VALUES ('Fall',58,3),('Monsoon',67,3),('Spring',97,2),('Summer',110,4),('Winter',20,3);
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `springplants`
--

DROP TABLE IF EXISTS `springplants`;
/*!50001 DROP VIEW IF EXISTS `springplants`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `springplants` AS SELECT 
 1 AS `plant_name`,
 1 AS `classification`,
 1 AS `growth_season`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `terrain`
--

DROP TABLE IF EXISTS `terrain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `terrain` (
  `terrain_type` varchar(30) NOT NULL,
  `minerals` varchar(20) DEFAULT NULL,
  `soil` varchar(20) DEFAULT NULL,
  `fertilizer` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`terrain_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terrain`
--

LOCK TABLES `terrain` WRITE;
/*!40000 ALTER TABLE `terrain` DISABLE KEYS */;
INSERT INTO `terrain` VALUES ('Forest','palladium','alfisols','Nitrogen\r'),('Rainforest','clay','sandy-loam','guano\r'),('Savanna','agate','hydric-soils','nitrogen\r'),('Tundra','copper','largely-permafrost','inorganic');
/*!40000 ALTER TABLE `terrain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor_location`
--

DROP TABLE IF EXISTS `visitor_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor_location` (
  `zip_code` varchar(10) NOT NULL,
  `continent` varchar(15) DEFAULT NULL,
  `country` varchar(60) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `climate` varchar(30) NOT NULL,
  `terrain` varchar(30) NOT NULL,
  PRIMARY KEY (`zip_code`),
  UNIQUE KEY `zip_code` (`zip_code`),
  KEY `climate` (`climate`),
  KEY `terrain` (`terrain`),
  CONSTRAINT `visitor_location_ibfk_1` FOREIGN KEY (`climate`) REFERENCES `climate` (`climate_name`),
  CONSTRAINT `visitor_location_ibfk_2` FOREIGN KEY (`terrain`) REFERENCES `terrain` (`terrain_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor_location`
--

LOCK TABLES `visitor_location` WRITE;
/*!40000 ALTER TABLE `visitor_location` DISABLE KEYS */;
INSERT INTO `visitor_location` VALUES ('338361','South America','Brazil','Rio de Janeiro','Dry','Savanna '),('372819','Asia','Pakistan','Karachi','Temperate','Savanna'),('383301','Asia','South Korea','Busan','Continental','Forest'),('630928','Africa','Nigeria','Lagos','Tropical','Rainforest '),('982910','Asia','India','Hyderabad','Dry','Forest');
/*!40000 ALTER TABLE `visitor_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `chinavisitors`
--

/*!50001 DROP VIEW IF EXISTS `chinavisitors`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `chinavisitors` AS select `visitor_location`.`zip_code` AS `zip_code`,`visitor_location`.`continent` AS `continent`,`visitor_location`.`country` AS `country`,`visitor_location`.`city` AS `city`,`visitor_location`.`climate` AS `climate`,`visitor_location`.`terrain` AS `terrain` from `visitor_location` where (`visitor_location`.`country` = 'South Korea') order by `visitor_location`.`zip_code` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cityhumidity`
--

/*!50001 DROP VIEW IF EXISTS `cityhumidity`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `cityhumidity` AS select `c`.`rainfall` AS `rainfall`,`v`.`city` AS `city`,`c`.`humidity` AS `humidity` from (`climate` `c` join `visitor_location` `v` on((`c`.`climate_name` = `v`.`climate`))) where ((`v`.`city` = 'Lagos') or (`v`.`city` = 'Karachi')) group by `c`.`rainfall`,`v`.`city`,`c`.`humidity` order by `c`.`humidity` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `herbivorepredators`
--

/*!50001 DROP VIEW IF EXISTS `herbivorepredators`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `herbivorepredators` AS select `predator`.`species` AS `species`,`predator`.`name` AS `name`,`predator`.`vore_type` AS `vore_type` from `predator` where (`predator`.`vore_type` like '%Bug%') order by `predator`.`species` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `labeleddiscoverers`
--

/*!50001 DROP VIEW IF EXISTS `labeleddiscoverers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `labeleddiscoverers` AS select concat('Discoverer: ',`discoverer`.`discoverer_name`) AS `DiscovererName` from `discoverer` where (cast(`discoverer`.`date` as date) > ((2000 - 1) - 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `numberofrecentdiscoverers`
--

/*!50001 DROP VIEW IF EXISTS `numberofrecentdiscoverers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `numberofrecentdiscoverers` AS select count(0) AS `COUNT(*)` from `discoverer` where (cast(`discoverer`.`date` as date) > ((2000 - 1) - 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `plantclassificationlocation`
--

/*!50001 DROP VIEW IF EXISTS `plantclassificationlocation`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `plantclassificationlocation` AS select `P`.`classification` AS `classification`,`L`.`discovered_location` AS `discovered_location` from (`plant` `P` join `discoverer` `L` on((`P`.`plant_discoverer` = `L`.`discoverer_name`))) where exists(select 1 from `photo` where ((`photo`.`photo_id` = `P`.`photo_id`) and (`photo`.`date_taken` > ((2021 - 5) - 2)))) group by `P`.`classification`,`L`.`discovered_location` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `plantseasongrowth`
--

/*!50001 DROP VIEW IF EXISTS `plantseasongrowth`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `plantseasongrowth` AS select `e`.`dishes` AS `dishes`,`p`.`growth_season` AS `growth_season`,`p`.`measurement` AS `measurement` from (`edible` `e` join `plant` `p` on((`e`.`crop` = `p`.`plant_name`))) where (`p`.`measurement` > (select avg(`plant`.`measurement`) from `plant` where (`plant`.`plant_name` = `plant`.`plant_name`))) group by `p`.`growth_season`,`e`.`dishes`,`p`.`measurement` order by `p`.`measurement` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `planttemperature`
--

/*!50001 DROP VIEW IF EXISTS `planttemperature`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `planttemperature` AS select `s`.`season_name` AS `season_name`,`s`.`temperature` AS `temperature`,`p`.`plant_name` AS `plant_name` from (`season` `s` join `plant` `p` on((`s`.`season_name` = `p`.`growth_season`))) where (`s`.`temperature` > (select avg(`season`.`temperature`) from `season` where (`season`.`temperature` > 50))) group by `s`.`season_name`,`s`.`temperature`,`p`.`plant_name` order by `s`.`temperature` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `predatorvsplantsize`
--

/*!50001 DROP VIEW IF EXISTS `predatorvsplantsize`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `predatorvsplantsize` AS select `plant`.`measurement` AS `measurement`,`plant`.`growth_season` AS `growth_season` from `plant` group by `plant`.`measurement`,`plant`.`growth_season` having (`plant`.`measurement` > 10) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recentphotos`
--

/*!50001 DROP VIEW IF EXISTS `recentphotos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `recentphotos` AS select `photo`.`photo_id` AS `photo_id`,`photo`.`date_taken` AS `date_taken`,`photo`.`photo_url` AS `photo_url` from `photo` where (cast(`photo`.`date_taken` as date) > ((2015 - 1) - 1)) order by `photo`.`photo_id` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `roundedplantmeasurements`
--

/*!50001 DROP VIEW IF EXISTS `roundedplantmeasurements`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `roundedplantmeasurements` AS select round(`plant`.`measurement`,1) AS `ROUND(measurement, 1)` from `plant` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `springplants`
--

/*!50001 DROP VIEW IF EXISTS `springplants`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `springplants` AS select `plant`.`plant_name` AS `plant_name`,`plant`.`classification` AS `classification`,`plant`.`growth_season` AS `growth_season` from `plant` where (`plant`.`growth_season` = 'spring') order by `plant`.`classification` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-13 21:11:30
