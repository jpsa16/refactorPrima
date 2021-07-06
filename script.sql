CREATE DATABASE demo 

DROP TABLE IF EXISTS `log_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_values` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(255) NOT NULL,
  `valor` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;