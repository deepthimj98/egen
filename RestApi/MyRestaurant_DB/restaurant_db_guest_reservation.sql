-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant_db
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `guest_reservation`
--

DROP TABLE IF EXISTS `guest_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_reservation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `reserve_date` date NOT NULL,
  `reserve_time` time NOT NULL,
  `no_guests` int(10) NOT NULL,
  `guest_name` varchar(20) NOT NULL,
  `guest_email` varchar(15) NOT NULL,
  `guest_phone` varchar(10) NOT NULL,
  `ccode` varchar(10) NOT NULL,
  `resreve_status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_reservation`
--

LOCK TABLES `guest_reservation` WRITE;
/*!40000 ALTER TABLE `guest_reservation` DISABLE KEYS */;
INSERT INTO `guest_reservation` VALUES (2,'2014-01-10','08:00:00',4,'ass','ass@gmail','9808298002','yyy','confirm'),(3,'2014-01-10','02:00:00',2,'sandy','san@gmail','9808298002','xxx','confirm'),(4,'2014-01-10','04:00:00',3,'deepak','deep@gmail','9808298002','eee','confirm'),(5,'2014-01-10','09:00:00',3,'ass','ass@gmail','9808298002','sss','confirm');
/*!40000 ALTER TABLE `guest_reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-19 15:27:00
