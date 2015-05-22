CREATE DATABASE  IF NOT EXISTS `tpv` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tpv`;
-- MySQL dump 10.15  Distrib 10.0.17-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: tpv
-- ------------------------------------------------------
-- Server version	10.0.17-MariaDB-log

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
-- Table structure for table `Facturas`
--

DROP TABLE IF EXISTS `Facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Facturas` (
  `numero` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `cif` varchar(10) NOT NULL,
  `razonSocial` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facturas`
--

LOCK TABLES `Facturas` WRITE;
/*!40000 ALTER TABLE `Facturas` DISABLE KEYS */;
INSERT INTO `Facturas` VALUES (00001,'00000000T','Phone TPV','2015-04-19'),(00002,'00000000T','Phone TPV','2015-04-19'),(00003,'00000000T','Phone TPV','2015-04-19'),(00004,'00000000T','Phone TPV','2015-04-19'),(00005,'00000000T','Phone TPV','2015-04-19'),(00006,'00000000T','Phone TPV','2015-04-19'),(00007,'00000000T','Phone TPV','2015-04-21'),(00008,'00000000T','Phone TPV','2015-04-21');
/*!40000 ALTER TABLE `Facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LineasTicket`
--

DROP TABLE IF EXISTS `LineasTicket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LineasTicket` (
  `cod_ticket` varchar(12) NOT NULL,
  `linea` int(2) NOT NULL,
  `cod_producto` int(5) unsigned NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(4) DEFAULT NULL,
  `iva` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`cod_ticket`,`linea`),
  KEY `cod_producto` (`cod_producto`),
  CONSTRAINT `cod_producto` FOREIGN KEY (`cod_producto`) REFERENCES `Productos` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LineasTicket`
--

LOCK TABLES `LineasTicket` WRITE;
/*!40000 ALTER TABLE `LineasTicket` DISABLE KEYS */;
INSERT INTO `LineasTicket` VALUES ('201505172249',1,2,'Google Nexus 5 16GB Rojo',359.37,5,21,1796.85),('201505172249',2,3,'LG G2 32GB',423.5,3,21,1270.5),('201505172249',3,4,'Sony Xperia Z3',665.5,3,21,1996.5),('201505172250',1,20,'iPhone 6 32GB',847,7,21,5929),('201505180021',1,2,'Google Nexus 5 16GB Rojo',359.37,2,21,718.74),('201505180021',2,12,'Samsung Galaxy A5',302.5,2,21,605),('201505180021',3,9,'Samsung Galaxy S6 128GB',931.6999999999999,2,21,1863.3999999999999),('201505180024',1,23,'Xiaomi M4',363,5,21,1815),('201505180024',2,21,'iPhone 6 64GB',968,6,21,5808),('201505180024',3,19,'iPhone 6 16GB',726,5,21,3630),('201505180030',1,2,'Google Nexus 5 16GB Rojo',359.37,3,21,1078.1100000000001),('201505180030',2,4,'Sony Xperia Z3',665.5,3,21,1996.5),('201505180031',1,3,'LG G2 32GB',423.5,3,21,1270.5),('201505180031',2,5,'Sony Xperia Z3 Compact',484,2,21,968),('201505180035',1,2,'Google Nexus 5 16GB Rojo',359.37,1,21,359.37),('201505181621',1,2,'Google Nexus 5 16GB Rojo',359.37,4,21,1437.48),('201505190103',1,1,'Google Nexus 5 32GB',399.3,4,21,1597.2),('201505190103',2,2,'Google Nexus 5 16GB Rojo',359.37,3,21,1078.1100000000001),('201505190103',3,3,'LG G2 32GB',423.5,1,21,423.5),('201505190103',4,4,'Sony Xperia Z3',665.5,1,21,665.5),('201505190103',5,11,'Samsung Galaxy S5 32GB',484,1,21,484),('201505190103',6,10,'Samsung Galaxy S6 EDGE 32GB',847,1,21,847),('201505190103',7,6,'Xiaomi Red Rice 8GB',121,2,21,242),('201505190103',8,8,'Samsung Galaxy S6 32GB',726,1,21,726),('201505190103',9,5,'Sony Xperia Z3 Compact',484,1,21,484),('201505190103',10,19,'iPhone 6 16GB',726,1,21,726),('201505190103',11,18,'iPhone 5 64GB',544.5,1,21,544.5),('201505190103',12,17,'iPhone 5 32GB',423.5,1,21,423.5),('201505190103',13,16,'iPhone 5 16GB',302.5,1,21,302.5),('201505190103',14,22,'Wolder xelfie',119.78999999999999,1,21,119.78999999999999),('201505190103',15,21,'iPhone 6 64GB',968,1,21,968),('201505210035',1,1,'Google Nexus 5 32GB',399.3,2,21,798.6),('201505210035',2,2,'Google Nexus 5 16GB Rojo',359.37,2,21,718.74),('201505210035',3,3,'LG G2 32GB',423.5,3,21,1270.5),('201505210036',1,14,'HUAWEI Y635',96.8,2,21,193.6),('201505210036',2,15,'Alcatel Pop D5',72.6,10,21,726),('201505210036',3,16,'iPhone 5 16GB',302.5,2,21,605),('201505210036',4,19,'iPhone 6 16GB',726,6,21,4356),('201505210036',5,17,'iPhone 5 32GB',423.5,1,21,423.5),('201505211352',1,3,'LG G2 32GB',423.5,1,21,423.5),('201505211352',2,2,'Google Nexus 5 16GB Rojo',359.37,1,21,359.37),('201505211352',3,1,'Google Nexus 5 32GB',399.3,1,21,399.3),('201505211352',4,11,'Samsung Galaxy S5 32GB',484,1,21,484),('201505211352',5,10,'Samsung Galaxy S6 EDGE 32GB',847,1,21,847),('201505211352',6,12,'Samsung Galaxy A5',302.5,1,21,302.5),('201505211352',7,16,'iPhone 5 16GB',302.5,1,21,302.5),('201505211352',8,15,'Alcatel Pop D5',72.6,1,21,72.6),('201505211352',9,14,'HUAWEI Y635',96.8,1,21,96.8),('201505211354',1,9,'Samsung Galaxy S6 128GB',931.6999999999999,1,21,931.6999999999999),('201505211354',2,10,'Samsung Galaxy S6 EDGE 32GB',847,1,21,847),('201505211354',3,8,'Samsung Galaxy S6 32GB',726,1,21,726),('201505211354',4,12,'Samsung Galaxy A5',302.5,1,21,302.5),('201505211354',5,15,'Alcatel Pop D5',72.6,1,21,72.6),('201505211354',6,19,'iPhone 6 16GB',726,1,21,726),('201505211354',7,20,'iPhone 6 32GB',847,1,21,847),('201505211354',8,22,'Wolder xelfie',119.78999999999999,1,21,119.78999999999999),('201505211355',1,12,'Samsung Galaxy A5',302.5,1,21,302.5),('201505211355',2,11,'Samsung Galaxy S5 32GB',484,1,21,484),('201505211355',3,10,'Samsung Galaxy S6 EDGE 32GB',847,1,21,847),('201505211355',4,15,'Alcatel Pop D5',72.6,5,21,363),('201505211355',5,14,'HUAWEI Y635',96.8,1,21,96.8),('201505211355',6,19,'iPhone 6 16GB',726,1,21,726),('201505211355',7,21,'iPhone 6 64GB',968,1,21,968),('201505211356',1,1,'Google Nexus 5 32GB',399.3,1,21,399.3),('201505211356',2,2,'Google Nexus 5 16GB Rojo',359.37,1,21,359.37),('201505211356',3,4,'Sony Xperia Z3',665.5,1,21,665.5),('201505211356',4,5,'Sony Xperia Z3 Compact',484,1,21,484),('201505211356',5,19,'iPhone 6 16GB',726,1,21,726),('201505211356',6,18,'iPhone 5 64GB',544.5,1,21,544.5),('201505211356',7,17,'iPhone 5 32GB',423.5,1,21,423.5),('201505211356',8,16,'iPhone 5 16GB',302.5,2,21,605),('201505211356',9,22,'Wolder xelfie',119.78999999999999,1,21,119.78999999999999),('201505211356',10,21,'iPhone 6 64GB',968,1,21,968),('201505211356',11,23,'Xiaomi M4',363,1,21,363),('201505211356',12,15,'Alcatel Pop D5',72.6,1,21,72.6);
/*!40000 ALTER TABLE `LineasTicket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Productos` (
  `codigo` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `precio` double unsigned NOT NULL,
  `iva` double unsigned NOT NULL,
  `precioIva` double unsigned NOT NULL,
  `stock` int(5) unsigned NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
INSERT INTO `Productos` VALUES (00001,'Google Nexus 5 32GB',330,21,399.3,4),(00002,'Google Nexus 5 16GB Rojo',297,21,359.37,36),(00003,'LG G2 32GB',350,21,423.5,0),(00004,'Sony Xperia Z3',550,21,665.5,42),(00005,'Sony Xperia Z3 Compact',400,21,484,33),(00006,'Xiaomi Red Rice 8GB',100,21,121,18),(00008,'Samsung Galaxy S6 32GB',600,21,726,51),(00009,'Samsung Galaxy S6 128GB',770,21,931.6999999999999,2),(00010,'Samsung Galaxy S6 EDGE 32GB',700,21,847,11),(00011,'Samsung Galaxy S5 32GB',400,21,484,20),(00012,'Samsung Galaxy A5',250,21,302.5,208),(00013,'Samsung i9505 Galaxy S4 16GB',150,21,181.5,0),(00014,'HUAWEI Y635',80,21,96.8,26),(00015,'Alcatel Pop D5',60,21,72.6,25),(00016,'iPhone 5 16GB',250,21,302.5,24),(00017,'iPhone 5 32GB',350,21,423.5,20),(00018,'iPhone 5 64GB',450,21,544.5,11),(00019,'iPhone 6 16GB',600,21,726,38),(00020,'iPhone 6 32GB',700,21,847,5),(00021,'iPhone 6 64GB',800,21,968,25),(00022,'Wolder xelfie',99,21,119.78999999999999,27),(00023,'Xiaomi M4',300,21,363,3);
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tickets`
--

DROP TABLE IF EXISTS `Tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tickets` (
  `codigo` varchar(12) NOT NULL,
  `cod_cliente` varchar(12) NOT NULL,
  `fecha` date NOT NULL,
  `num_factura` int(5) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cod_cliente` (`cod_cliente`),
  KEY `num_factura_idx` (`num_factura`),
  CONSTRAINT `cod_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `Usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `num_factura` FOREIGN KEY (`num_factura`) REFERENCES `Facturas` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tickets`
--

LOCK TABLES `Tickets` WRITE;
/*!40000 ALTER TABLE `Tickets` DISABLE KEYS */;
INSERT INTO `Tickets` VALUES ('201505172249','cliente','2015-05-17',00003),('201505172250','cliente','2015-05-17',00004),('201505180021','admin','2015-05-18',00002),('201505180024','cliente','2015-05-18',00004),('201505180030','admin','2015-05-18',00001),('201505180031','admin','2015-05-18',00001),('201505180035','admin','2015-05-18',00005),('201505181621','admin','2015-05-18',00006),('201505190103','admin','2015-05-19',00007),('201505210035','admin','2015-05-21',00007),('201505210036','admin','2015-05-21',00007),('201505211352','admin','2015-05-21',00008),('201505211354','admin','2015-05-21',00008),('201505211355','admin','2015-05-21',00008),('201505211356','admin','2015-05-21',00008);
/*!40000 ALTER TABLE `Tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `usuario` varchar(12) NOT NULL,
  `contrasena` varchar(12) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  `fechaAlta` date NOT NULL,
  `nivel` int(1) NOT NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE KEY `DNI` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES ('admin','admin','00000000C','Pedro','Fuster','Calle Progres','2015-04-10',1),('admin2','admin2','52144289P','ljsdfn','sdolnkf','oisdnlkf','2015-05-08',1),('admin3','admin3','52144289I','ljsdfn','sdolnkf','oisdnlkf','2015-05-08',1),('andreu','andreu','75757575G','Andreu','Moll','Pego','2015-05-15',0),('cliente','cliente','99999999C','Pepe','Garcia','Calle Colon','2015-04-10',0),('cliente2','cliente2','87878787P','Miguelito','Garcia','lokfslkfskldf','2015-05-08',0),('juanje','123456','53478874N','Juan','Gregori','Calle Santa Maria','2015-03-23',1),('miguel','1234562','65478987O','Miguel2','Garcia Tomas2','Calle Mayor2','2015-03-23',1),('pedro','pedro','77777777V','Pedro','Sanchez','sdlflksdfnkdsf','2015-05-11',0),('quique','123456','52147789L','Enrique','Gil Boix','Calle Santo Tomas','2015-03-23',1),('Santo','Santo','64656353R','Santo','Santo','sdfsdfdsf','2015-05-12',0);
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-21 22:44:28
