-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pinn
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `historia`
--

DROP TABLE IF EXISTS `historia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historia` (
  `index` tinyint NOT NULL AUTO_INCREMENT,
  `sender_nick` varchar(255) DEFAULT NULL,
  `sender_id` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `content` varchar(8192) DEFAULT NULL,
  KEY `index` (`index`) USING BTREE,
  FULLTEXT KEY `content` (`content`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia`
--

LOCK TABLES `historia` WRITE;
/*!40000 ALTER TABLE `historia` DISABLE KEYS */;
INSERT INTO `historia` VALUES (2,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(3,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(1,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(4,'田所浩二',114514,'2021-01-01 00:17:10','114514'),(5,NULL,NULL,NULL,'雅子姐 正在玩 NMB rails'),(6,NULL,NULL,NULL,'miyabi on rails'),(7,NULL,NULL,NULL,'这nm到底是个什么东西'),(8,NULL,NULL,NULL,'你把机顶盒插自己的路由器上了？'),(9,NULL,NULL,NULL,'连接不能'),(10,NULL,NULL,NULL,'这玩意跟猫mac绑定'),(11,NULL,NULL,NULL,'解绑权限不在我这'),(12,NULL,NULL,NULL,'iptv好了'),(13,NULL,NULL,NULL,'窝。'),(14,NULL,NULL,NULL,'这决定窝的吃饭方式。'),(15,NULL,NULL,NULL,'好。'),(16,NULL,NULL,NULL,'不'),(17,NULL,NULL,NULL,'在锁桩上放了两个小时'),(18,NULL,NULL,NULL,'我共享单车没还上'),(19,NULL,NULL,NULL,'请再次刷卡下车'),(20,NULL,NULL,NULL,'开mc服什么的，零成本'),(21,NULL,NULL,NULL,'但是综合素质绝对要优于云服务器'),(22,NULL,NULL,NULL,'可能速度稍微慢了点'),(23,NULL,NULL,NULL,'这是啥。'),(24,NULL,NULL,NULL,'电脑'),(25,NULL,NULL,NULL,'荣成一号线。'),(26,NULL,NULL,NULL,'荣成站——哈理工荣成'),(27,NULL,NULL,NULL,'谢谢合作'),(28,NULL,NULL,NULL,'与经济基础和实际需求毫不相符的交通设施.jpg'),(29,NULL,NULL,NULL,'窝直呼牛逼。'),(30,NULL,NULL,NULL,'草'),(31,NULL,NULL,NULL,'一中小壁灯们放寒假了'),(32,NULL,NULL,NULL,'妈逼'),(33,NULL,NULL,NULL,'这iptv怎么搞'),(34,NULL,NULL,NULL,'两个小时弄了两页书'),(35,NULL,NULL,NULL,'嘉 禾'),(36,NULL,NULL,NULL,'它动起来了。'),(37,NULL,NULL,NULL,'在考虑要不要玩树莓派'),(38,NULL,NULL,NULL,'头真疼。。'),(39,NULL,NULL,NULL,'哪里有卖rj45转usb'),(40,NULL,NULL,NULL,'\r\n这tm是轨道交通。'),(41,NULL,NULL,NULL,'老年卡'),(42,NULL,NULL,NULL,'飞刃'),(43,NULL,NULL,NULL,'近地轨道交通'),(44,NULL,NULL,NULL,'每公里1块、'),(45,NULL,NULL,NULL,'无起步费、'),(46,NULL,NULL,NULL,'理解不能。'),(47,NULL,NULL,NULL,'噢。'),(48,NULL,NULL,NULL,'窝没交建筑费好像。'),(49,NULL,NULL,NULL,'我急用'),(50,NULL,NULL,NULL,'jss有个大jb拓展五'),(51,NULL,NULL,NULL,'奥那个啊'),(52,NULL,NULL,NULL,'hub'),(53,NULL,NULL,NULL,'rj45-typec'),(54,NULL,NULL,NULL,'你再tpc-usba'),(55,NULL,NULL,NULL,'我以后得天天用'),(56,NULL,NULL,NULL,'等等'),(57,NULL,NULL,NULL,'总不能抢过来'),(58,NULL,NULL,NULL,'义乌有卖的没'),(59,NULL,NULL,NULL,'吧'),(60,NULL,NULL,NULL,'肯定有'),(61,NULL,NULL,NULL,'我去康康'),(62,NULL,NULL,NULL,'我拓展坞有rj45母口'),(63,NULL,NULL,NULL,'抓到月月鸟'),(64,NULL,NULL,NULL,'我操。'),(65,NULL,NULL,NULL,'空格也写的字');
/*!40000 ALTER TABLE `historia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pinn'
--

--
-- Dumping routines for database 'pinn'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-27 23:55:24
