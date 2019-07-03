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
-- Table structure for table `tbl_participacaoatividade`
--

DROP TABLE IF EXISTS `tbl_participacaoatividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_participacaoatividade` (
  `id_participacaoAtividade` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `horarioInicial` time NOT NULL,
  `horarioFinal` time NOT NULL,
  `id_atividade` int(11) NOT NULL,
  `titulo` varchar(55) NOT NULL,
  `dataInicial` date NOT NULL,
  `dataFinal` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_participacaoAtividade`),
  KEY `fk_ParticipacaoAtividade` (`id_atividade`),
  CONSTRAINT `fk_ParticipacaoAtividade` FOREIGN KEY (`id_atividade`) REFERENCES `tbl_atividade` (`id_atividade`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_participacaoatividade`
--

LOCK TABLES `tbl_participacaoatividade` WRITE;
/*!40000 ALTER TABLE `tbl_participacaoatividade` DISABLE KEYS */;
INSERT INTO `tbl_participacaoatividade` VALUES (1,'Teste de participacao titulo','22:00:00','23:00:00',1,'teste de participacao desc 2','2019-05-01','2019-05-01',1),(2,'Execucao','12:00:00','13:00:00',1,'Execucao','2019-05-21','2019-05-21',4),(3,'Teste','14:00:00','15:00:00',2,'Teste','2019-05-21','2019-05-21',1),(4,'Produca','12:00:00','13:00:00',1,'Produc','2019-05-21','2019-05-21',2),(5,'Portos2m','12:00:00','13:00:00',1,'Portos','2019-05-21','2019-05-21',3),(6,'tesssss','14:00:00','15:00:00',1,'teste','2019-05-21','2019-05-21',1),(7,'Teste de Descricao 1','08:55:00','08:55:00',1,'Teste de Titulo 1','2019-06-25','2019-06-25',3),(8,'Teste de Descricao 2','08:55:00','08:55:00',1,'Teste de Titulo 2','2019-06-25','2019-06-25',5),(9,'Teste de Descricao 3','08:55:00','08:55:00',1,'Teste de Titulo 3','2019-06-25','2019-06-25',4),(10,'Teste de Descricao 1','17:00:00','18:20:00',6,'Teste de Titulo 1','2019-06-25','2019-06-25',3),(11,'Teste de Descricao 1','08:55:00','18:00:00',7,'Teste de Titulo 1','2019-06-25','2019-06-25',8),(12,'Teste de Descricao 1','08:55:00','08:55:00',10,'Teste de Titulo 2','2019-06-25','2019-06-25',2),(13,'Teste de Descricao 7','17:00:00','18:30:00',1,'Teste de Titulo 7','2019-06-25','2019-06-25',12),(14,'Teste de Descricao 1','08:55:00','08:55:00',1,'Teste de Titulo 6','2019-06-25','2019-06-25',1),(15,'Teste de descricao','14:00:00','15:00:00',12,'Primeiro gamplay','2019-12-01','2019-12-01',16),(16,'Teste de gameplay','12:00:00','15:00:00',1,'Primeiro gamplay - 2','2019-12-01','2019-12-01',1);
/*!40000 ALTER TABLE `tbl_participacaoatividade` ENABLE KEYS */;
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
