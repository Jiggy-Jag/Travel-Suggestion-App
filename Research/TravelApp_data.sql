-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: travel_suggestion
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beaches`
--

DROP TABLE IF EXISTS `beaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `beaches` (
  `dest_name` int(11) NOT NULL,
  `beaches` varchar(45) DEFAULT NULL,
  `weather` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`),
  KEY `fk_beaches_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_beaches_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beaches`
--

LOCK TABLES `beaches` WRITE;
/*!40000 ALTER TABLE `beaches` DISABLE KEYS */;
/*!40000 ALTER TABLE `beaches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinations`
--

DROP TABLE IF EXISTS `destinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `destinations` (
  `dest_id` int(11) NOT NULL,
  `dest_name` varchar(45) NOT NULL,
  `images` varchar(45) DEFAULT NULL,
  `booking_website` varchar(45) DEFAULT NULL,
  `weather_website` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dest_id`,`dest_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinations`
--

LOCK TABLES `destinations` WRITE;
/*!40000 ALTER TABLE `destinations` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diverse_food`
--

DROP TABLE IF EXISTS `diverse_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `diverse_food` (
  `dest_name` int(11) NOT NULL,
  `weather` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `food` varchar(45) DEFAULT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`,`destinations_dest_id`),
  KEY `fk_diverse_food_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_diverse_food_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diverse_food`
--

LOCK TABLES `diverse_food` WRITE;
/*!40000 ALTER TABLE `diverse_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `diverse_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historic landmarks`
--

DROP TABLE IF EXISTS `historic landmarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historic landmarks` (
  `dest_name` int(11) NOT NULL,
  `weather` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `historic_places` varchar(45) DEFAULT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`),
  KEY `fk_historic landmarks_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_historic landmarks_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historic landmarks`
--

LOCK TABLES `historic landmarks` WRITE;
/*!40000 ALTER TABLE `historic landmarks` DISABLE KEYS */;
/*!40000 ALTER TABLE `historic landmarks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multicultural`
--

DROP TABLE IF EXISTS `multicultural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `multicultural` (
  `dest_name` varchar(45) NOT NULL,
  `weather` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`,`destinations_dest_id`),
  KEY `fk_multicultural_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_multicultural_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multicultural`
--

LOCK TABLES `multicultural` WRITE;
/*!40000 ALTER TABLE `multicultural` DISABLE KEYS */;
/*!40000 ALTER TABLE `multicultural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping`
--

DROP TABLE IF EXISTS `shopping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopping` (
  `dest_name` varchar(45) NOT NULL,
  `weather` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`,`destinations_dest_id`),
  KEY `fk_shopping_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_shopping_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping`
--

LOCK TABLES `shopping` WRITE;
/*!40000 ALTER TABLE `shopping` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sightseeing`
--

DROP TABLE IF EXISTS `sightseeing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sightseeing` (
  `des_name` varchar(45) NOT NULL,
  `weather` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`des_name`,`destinations_dest_id`),
  KEY `fk_sightseeing_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_sightseeing_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sightseeing`
--

LOCK TABLES `sightseeing` WRITE;
/*!40000 ALTER TABLE `sightseeing` DISABLE KEYS */;
/*!40000 ALTER TABLE `sightseeing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_reviews`
--

DROP TABLE IF EXISTS `user_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_reviews` (
  `username` int(11) NOT NULL,
  `dest_name` varchar(45) NOT NULL,
  `review_content` varchar(45) DEFAULT NULL,
  `users_username` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_user_reviews_users1_idx` (`users_username`),
  CONSTRAINT `fk_user_reviews_users1` FOREIGN KEY (`users_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_reviews`
--

LOCK TABLES `user_reviews` WRITE;
/*!40000 ALTER TABLE `user_reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `username` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `second_name` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_basket`
--

DROP TABLE IF EXISTS `users_basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_basket` (
  `username` int(11) NOT NULL,
  `dest_name` varchar(45) NOT NULL,
  `users_username` int(11) NOT NULL,
  PRIMARY KEY (`username`,`dest_name`),
  KEY `fk_users_basket_users1_idx` (`users_username`),
  CONSTRAINT `fk_users_basket_users1` FOREIGN KEY (`users_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_basket`
--

LOCK TABLES `users_basket` WRITE;
/*!40000 ALTER TABLE `users_basket` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_basket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wildlife`
--

DROP TABLE IF EXISTS `wildlife`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wildlife` (
  `dest_name` int(11) NOT NULL,
  `weather` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `destinations_dest_id` int(11) NOT NULL,
  PRIMARY KEY (`dest_name`),
  KEY `fk_wildlife_destinations1_idx` (`destinations_dest_id`),
  CONSTRAINT `fk_wildlife_destinations1` FOREIGN KEY (`destinations_dest_id`) REFERENCES `destinations` (`dest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wildlife`
--

LOCK TABLES `wildlife` WRITE;
/*!40000 ALTER TABLE `wildlife` DISABLE KEYS */;
/*!40000 ALTER TABLE `wildlife` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-30 11:43:38
