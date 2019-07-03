-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: daylog
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `tbl_aviso`
--

DROP TABLE IF EXISTS `tbl_aviso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_aviso` (
  `id_aviso` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `mensagem` varchar(255) NOT NULL,
  `flag_ativo` varchar(1) NOT NULL,
  PRIMARY KEY (`id_aviso`),
  KEY `fk_usuario_aviso_idx` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aviso`
--

LOCK TABLES `tbl_aviso` WRITE;
/*!40000 ALTER TABLE `tbl_aviso` DISABLE KEYS */;
INSERT INTO `tbl_aviso` VALUES (1,1,'Voce foi registrado como Participante na Atividade','H'),(2,2,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1','H'),(3,3,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1','H'),(4,4,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1','A'),(5,2,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1','H'),(6,4,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1 horaInicial: 12:00:00Hora Final: 13:00:00','A'),(7,3,'Voce foi registrado como Participante na Atividade: 1-Teste de Titulo 1 horaInicial: 12:00:00Hora Final: 15:00:00','H'),(8,3,'Voce foi registrado como Participante na Atividade: 2-teste horaInicial: 12:00:00Hora Final: 15:00:00','H'),(9,4,'Voce foi registrado como Participante na Atividade: 2-teste horaInicial: 12:00:00Hora Final: 15:00:00','A'),(10,1,'Voce foi registrado como Participante na Atividade: 0-null horaInicial: 12:00:00Hora Final: 15:00:00','H'),(11,1,'Voce foi registrado como Participante na Atividade: 4-teste horaInicial: 12:00:00Hora Final: 15:00:00','H'),(12,3,'Voce foi registrado como Participante na Atividade: 4-teste horaInicial: 12:00:00Hora Final: 15:00:00','H'),(13,4,'Voce foi registrado como Participante na Atividade: 4-teste horaInicial: 12:00:00Hora Final: 15:00:00','A'),(14,6,'Voce foi registrado como Participante na Atividade: 4-teste horaInicial: 14:00:00Hora Final: 15:00:00','A'),(15,1,'Voce foi registrado como Participante na Atividade: 4-teste horaInicial: 12:00:00Hora Final: 15:00:00','H');
/*!40000 ALTER TABLE `tbl_aviso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03  3:13:54
