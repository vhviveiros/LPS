-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `tbl_address`
--

DROP TABLE IF EXISTS `tbl_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `district` varchar(45) COLLATE tis620_bin NOT NULL,
  `address` varchar(45) COLLATE tis620_bin NOT NULL,
  `city` varchar(45) COLLATE tis620_bin NOT NULL,
  `state` varchar(2) COLLATE tis620_bin NOT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`number`,`state`,`city`,`address`,`district`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_address`
--

LOCK TABLES `tbl_address` WRITE;
/*!40000 ALTER TABLE `tbl_address` DISABLE KEYS */;
INSERT INTO `tbl_address` VALUES (50,'hriuyturtyu','rtyewrtrew','fdherytrwey','AC',123),(49,'tewtwetewtr','dsgwerteew','fdsgwrtwrt','AC',654),(51,'Novo Bairro','Rua Antonio Carlos','Antonio Carlos','MG',999);
/*!40000 ALTER TABLE `tbl_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_booking`
--

DROP TABLE IF EXISTS `tbl_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE tis620_bin NOT NULL,
  `details` text COLLATE tis620_bin,
  `price` float NOT NULL,
  `date` date NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_booking_tbl_user1_idx` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_booking`
--

LOCK TABLES `tbl_booking` WRITE;
/*!40000 ALTER TABLE `tbl_booking` DISABLE KEYS */;
INSERT INTO `tbl_booking` VALUES (1,'stgwret','wrrtwewt',0,'2021-08-22',19),(2,'teste 2','teste aaaa',5,'2022-06-22',19),(10,'teste 23','asgadf ad',15,'2022-06-22',19);
/*!40000 ALTER TABLE `tbl_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_credentials`
--

DROP TABLE IF EXISTS `tbl_credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_credentials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE tis620_bin NOT NULL,
  `password` varchar(45) COLLATE tis620_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_credentials`
--

LOCK TABLES `tbl_credentials` WRITE;
/*!40000 ALTER TABLE `tbl_credentials` DISABLE KEYS */;
INSERT INTO `tbl_credentials` VALUES (1,'teste','teste');
/*!40000 ALTER TABLE `tbl_credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `details` text COLLATE tis620_bin,
  `cleaner_id` int NOT NULL,
  `tbl_booking_id` int NOT NULL,
  `tbl_payment_id` int NOT NULL,
  `tbl_rating_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_order_tbl_user1_idx` (`cleaner_id`),
  KEY `fk_tbl_order_tbl_booking1_idx` (`tbl_booking_id`),
  KEY `fk_tbl_order_tbl_payment1_idx` (`tbl_payment_id`),
  KEY `fk_tbl_order_tbl_rating1_idx` (`tbl_rating_id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order_supply`
--

DROP TABLE IF EXISTS `tbl_order_supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order_supply` (
  `tbl_order_id` int NOT NULL,
  `tbl_supply_id` int NOT NULL,
  PRIMARY KEY (`tbl_order_id`,`tbl_supply_id`),
  KEY `fk_tbl_order_supply_tbl_order1_idx` (`tbl_order_id`),
  KEY `fk_tbl_order_supply_tbl_supply1_idx` (`tbl_supply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order_supply`
--

LOCK TABLES `tbl_order_supply` WRITE;
/*!40000 ALTER TABLE `tbl_order_supply` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_order_supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_payment`
--

DROP TABLE IF EXISTS `tbl_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` float NOT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_payment`
--

LOCK TABLES `tbl_payment` WRITE;
/*!40000 ALTER TABLE `tbl_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_rating`
--

DROP TABLE IF EXISTS `tbl_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rating`
--

LOCK TABLES `tbl_rating` WRITE;
/*!40000 ALTER TABLE `tbl_rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_rating_reply`
--

DROP TABLE IF EXISTS `tbl_rating_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rating_reply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reply` text COLLATE tis620_bin NOT NULL,
  `tbl_rating_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_rating_reply_tbl_rating1_idx` (`tbl_rating_id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rating_reply`
--

LOCK TABLES `tbl_rating_reply` WRITE;
/*!40000 ALTER TABLE `tbl_rating_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_rating_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_supply`
--

DROP TABLE IF EXISTS `tbl_supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_supply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE tis620_bin NOT NULL,
  `details` text COLLATE tis620_bin,
  `amount` float NOT NULL,
  `expiration_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `cleaner_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_supply_tbl_user1_idx` (`cleaner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_supply`
--

LOCK TABLES `tbl_supply` WRITE;
/*!40000 ALTER TABLE `tbl_supply` DISABLE KEYS */;
INSERT INTO `tbl_supply` VALUES (1,'teste','',231,'2021-08-22',0,19),(2,'aaaaaaaaaaaaaaaa','',132,'2021-08-22',0,19),(3,'vassoura','',2,NULL,0,-1),(4,'vassoura','vassoura quebrada',2,'2025-08-22',0,21);
/*!40000 ALTER TABLE `tbl_supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE tis620_bin NOT NULL,
  `birthdate` date NOT NULL,
  `gender` tinyint NOT NULL,
  `cpf` bigint NOT NULL,
  `identity` bigint NOT NULL,
  `user_type` tinyint NOT NULL,
  `tbl_credentials_id` int NOT NULL,
  `tbl_address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`,`user_type`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`,`user_type`),
  KEY `fk_tbl_user_tbl_credentials_idx` (`tbl_credentials_id`),
  KEY `fk_tbl_user_tbl_address1_idx` (`tbl_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (19,'asgsarf','1996-08-22',1,65487867468,89765416,0,1,49),(20,'dfyertrewt','1996-08-31',1,54687987987,56465666,0,1,50),(21,'Faxineiro','2021-03-31',1,0,0,0,9999,9999);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-31 17:39:37
