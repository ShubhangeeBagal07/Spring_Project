CREATE DATABASE  IF NOT EXISTS `springboot_apis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springboot_apis`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springboot_apis
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `likedislikes`
--

DROP TABLE IF EXISTS `likedislikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedislikes` (
  `id` int NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedislikes`
--

LOCK TABLES `likedislikes` WRITE;
/*!40000 ALTER TABLE `likedislikes` DISABLE KEYS */;
INSERT INTO `likedislikes` VALUES (1,NULL,2,1,NULL,2),(2,NULL,1,1,NULL,1),(3,NULL,57,1,NULL,203),(4,NULL,3,0,NULL,3),(5,NULL,4,1,NULL,4),(6,NULL,3,0,NULL,4),(7,NULL,3,0,NULL,2),(8,NULL,56,1,NULL,153);
/*!40000 ALTER TABLE `likedislikes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedislikes_seq`
--

DROP TABLE IF EXISTS `likedislikes_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedislikes_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedislikes_seq`
--

LOCK TABLES `likedislikes_seq` WRITE;
/*!40000 ALTER TABLE `likedislikes_seq` DISABLE KEYS */;
INSERT INTO `likedislikes_seq` VALUES (101);
/*!40000 ALTER TABLE `likedislikes_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `created_time` varchar(255) DEFAULT NULL,
  `updated_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Hii This is Post Title','Hello This is Post Content ',1,NULL,NULL),(2,'java Progamming','Hello This is Post Content of java ',2,NULL,NULL),(3,'python Progamming','Hello This is Post Content of python',3,NULL,NULL),(4,'python Progamming changed','Hello This is Post Content of python changed',1,NULL,NULL),(52,'Hello This Was Post Titile','Demo Test content ',1,NULL,NULL),(53,'Hello This Was Post Titile','Demo Test content ',4,NULL,NULL),(54,'Hello This Was Post Titile','Demo Test content ',4,NULL,NULL),(55,'Hii This is Post Title','Hello This is Post Content ',50,NULL,NULL),(56,'Best Programming Languages','various Languages are available to used ',153,NULL,NULL),(57,'Best Programming Tools','various Tools are available to used ',203,NULL,NULL);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts_seq`
--

DROP TABLE IF EXISTS `posts_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts_seq`
--

LOCK TABLES `posts_seq` WRITE;
/*!40000 ALTER TABLE `posts_seq` DISABLE KEYS */;
INSERT INTO `posts_seq` VALUES (151);
/*!40000 ALTER TABLE `posts_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `is_admin` varchar(255) DEFAULT NULL,
  `register_time` varchar(255) DEFAULT NULL,
  `in_time` varchar(255) DEFAULT NULL,
  `out_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jolly','122333','1234',NULL,20,'1','10','11','12'),(2,'John','abc@gmail.com','1234',NULL,20,'1','10','11','12'),(3,'Abc','xyz@gmail.com','123456',NULL,21,'1','10','11','12'),(4,'xyz','kbc@gmail.com','87653','dhule',22,'1','12','12.2','13'),(50,'Demo user1','abc@gamil.com','1234','NSK',20,'0','11','1','2'),(52,'Demo User2','demouser2@gmail.com','demo@123','MH',24,'0','Thu Jun 29 05:18:02 IST 2023',NULL,NULL),(152,'sam','sam123@gmail.com','sk@123','MH',20,'0','Thu Jun 29 17:14:27 IST 2023',NULL,NULL),(153,'madhu','madhu@gmail.com','mr@123','Mumbai',21,'0','Thu Jun 29 18:33:05 IST 2023',NULL,NULL),(202,'sample user','sampleuser@gmail.com','nk@123','NSK',22,'0','Sun Jul 02 18:58:39 IST 2023',NULL,NULL),(203,'postman','post123@gmail.com','Pkt@123','DDE',23,'0','Sun Jul 02 19:00:06 IST 2023',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_seq`
--

DROP TABLE IF EXISTS `users_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_seq`
--

LOCK TABLES `users_seq` WRITE;
/*!40000 ALTER TABLE `users_seq` DISABLE KEYS */;
INSERT INTO `users_seq` VALUES (301);
/*!40000 ALTER TABLE `users_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'springboot_apis'
--

--
-- Dumping routines for database 'springboot_apis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-02 19:45:53
