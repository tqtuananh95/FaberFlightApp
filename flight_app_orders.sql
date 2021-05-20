-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_app
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `arrival_date_and_time` datetime(6) DEFAULT NULL,
  `departure_date_and_time` datetime(6) NOT NULL,
  `price_per_flight` decimal(19,0) NOT NULL,
  `return_type` int NOT NULL,
  `time_of_order` time NOT NULL,
  `total_adult_senior_child` varchar(255) NOT NULL,
  `total_price_for_order` decimal(19,0) NOT NULL,
  `arrival_airport_id` int NOT NULL,
  `departure_airport_id` int NOT NULL,
  `flight_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKajodfavfovdwdmr2jj0o8deyf` (`arrival_airport_id`),
  KEY `FKpb64pgmn0tv2ayf42h2ba8vw5` (`departure_airport_id`),
  KEY `FK6g4eds5g0ma9s4q7ux9x8w22l` (`flight_id`),
  CONSTRAINT `FK6g4eds5g0ma9s4q7ux9x8w22l` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`),
  CONSTRAINT `FKajodfavfovdwdmr2jj0o8deyf` FOREIGN KEY (`arrival_airport_id`) REFERENCES `arrival_airport` (`arrival_airport_id`),
  CONSTRAINT `FKpb64pgmn0tv2ayf42h2ba8vw5` FOREIGN KEY (`departure_airport_id`) REFERENCES `departure_airport` (`departure_airport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2021-05-30 00:00:00.000000','2021-05-20 00:00:00.000000',650,1,'10:49:44','1,0,0',650,2,1,399),(2,'2021-06-01 00:00:00.000000','2021-05-30 00:00:00.000000',700,2,'10:50:36','1,1,1',2100,1,3,348),(3,'2021-05-30 00:00:00.000000','2021-05-20 00:00:00.000000',700,2,'10:50:36','1,1,1',2100,3,1,596),(4,'2021-05-30 00:00:00.000000','2021-05-20 00:00:00.000000',900,1,'10:51:21','1,0,2',2700,12,1,554);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-20 11:01:21
