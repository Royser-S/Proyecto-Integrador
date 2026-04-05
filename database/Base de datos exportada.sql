CREATE DATABASE  IF NOT EXISTS `gestion_equipos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestion_equipos`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion_equipos
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `id_equipo` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `fecha_adquisicion` date DEFAULT NULL,
  PRIMARY KEY (`id_equipo`),
  UNIQUE KEY `codigo_equipo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fallas`
--

DROP TABLE IF EXISTS `fallas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fallas` (
  `id_falla` bigint NOT NULL AUTO_INCREMENT,
  `id_equipo` bigint DEFAULT NULL,
  `fecha_reporte` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`id_falla`),
  KEY `id_equipo` (`id_equipo`),
  KEY `FKtgypidf6vqa1ljhq8g43yd8ai` (`id_usuario`),
  CONSTRAINT `fallas_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id_equipo`) ON DELETE CASCADE,
  CONSTRAINT `FKtgypidf6vqa1ljhq8g43yd8ai` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fallas`
--


--
-- Table structure for table `mantenimientos`
--

DROP TABLE IF EXISTS `mantenimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenimientos` (
  `id_mantenimiento` bigint NOT NULL AUTO_INCREMENT,
  `id_equipo` bigint DEFAULT NULL,
  `fecha_mantenimiento` date NOT NULL,
  `descripcion` text,
  `tipo_mantenimiento` varchar(255) NOT NULL,
  `responsable` varchar(255) DEFAULT NULL,
  `estado` varchar(255) NOT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  KEY `id_equipo` (`id_equipo`),
  CONSTRAINT `mantenimientos_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id_equipo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes` (
  `id_reporte` bigint NOT NULL AUTO_INCREMENT,
  `id_usuario` bigint DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `tipo_reporte` varchar(255) DEFAULT NULL,
  `fecha_generacion` date NOT NULL,
  `contenido` text,
  PRIMARY KEY (`id_reporte`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `reportes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping events for database 'gestion_equipos'
--

--
-- Dumping routines for database 'gestion_equipos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-05  6:31:01
