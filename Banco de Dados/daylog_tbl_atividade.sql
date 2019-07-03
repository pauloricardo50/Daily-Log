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
-- Table structure for table `tbl_atividade`
--

DROP TABLE IF EXISTS `tbl_atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_atividade` (
  `id_atividade` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `horarioInicio` time NOT NULL,
  `horarioFim` time NOT NULL,
  `data` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_expediente` int(11) NOT NULL,
  `id_subcategoria` int(11) NOT NULL,
  `flag_ativo` varchar(1) NOT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `fk_UserUsuario` (`id_usuario`),
  KEY `fk_Expediente` (`id_expediente`),
  CONSTRAINT `fk_Expediente` FOREIGN KEY (`id_expediente`) REFERENCES `tbl_expediente` (`id_expediente`),
  CONSTRAINT `fk_UserUsuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_atividade`
--

LOCK TABLES `tbl_atividade` WRITE;
/*!40000 ALTER TABLE `tbl_atividade` DISABLE KEYS */;
INSERT INTO `tbl_atividade` VALUES (1,'Teste de Titulo 1','teste','12:00:00','18:00:00','2010-10-10',1,1,1,'A'),(2,'teste','teste','12:00:00','12:00:00','2010-10-10',1,2,4,'A'),(3,'testea','testeb','12:30:00','15:00:00','2010-10-10',1,4,5,'A'),(5,'Teste de Titulo 20','Teste de Descricao 20','17:00:00','18:10:00','2019-06-26',1,4,10,'A'),(6,'Teste de Titulo 3','Teste de Descricao 3','17:00:00','18:30:00','2019-06-26',1,4,9,'A'),(7,'Teste de Titulo 4','Teste de Descricao 4','17:10:00','18:20:00','2019-06-25',1,2,6,'A'),(8,'Teste de Titulo 4','Teste de Descricao 4','17:20:00','18:20:00','2019-06-25',1,2,6,'A'),(9,'Teste de Titulo 4','Teste de Descricao 4','17:50:00','18:20:00','2019-06-25',1,2,6,'A'),(10,'Teste de Titulo 6','Teste de Descricao 4','17:50:00','18:30:00','2019-06-25',1,1,1,'A'),(11,'Teste de Titulo 7','Teste de Descricao 1','17:00:00','18:10:00','2019-06-25',1,4,5,'A'),(12,'Jogar','Teste de renovaÃ§Ã£o','12:00:00','13:00:00','2019-12-01',1,2,19,'A');
/*!40000 ALTER TABLE `tbl_atividade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03  3:13:55
