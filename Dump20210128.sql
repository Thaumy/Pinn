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
  `sender_id` bigint DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `content` varchar(8192) DEFAULT NULL,
  KEY `index` (`index`) USING BTREE,
  FULLTEXT KEY `content` (`content`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia`
--

LOCK TABLES `historia` WRITE;
/*!40000 ALTER TABLE `historia` DISABLE KEYS */;
INSERT INTO `historia` VALUES (2,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(3,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(1,'thaumy',1951327599,'2021-01-07 21:33:25','2333'),(4,'田所浩二',114514,'2021-01-01 00:17:10','114514'),(5,NULL,NULL,NULL,'雅子姐 正在玩 NMB rails'),(6,NULL,NULL,NULL,'miyabi on rails'),(7,NULL,NULL,NULL,'这nm到底是个什么东西'),(8,NULL,NULL,NULL,'你把机顶盒插自己的路由器上了？'),(9,NULL,NULL,NULL,'连接不能'),(10,NULL,NULL,NULL,'这玩意跟猫mac绑定'),(11,NULL,NULL,NULL,'解绑权限不在我这'),(12,NULL,NULL,NULL,'iptv好了'),(13,NULL,NULL,NULL,'窝。'),(14,NULL,NULL,NULL,'这决定窝的吃饭方式。'),(15,NULL,NULL,NULL,'好。'),(16,NULL,NULL,NULL,'不'),(17,NULL,NULL,NULL,'在锁桩上放了两个小时'),(18,NULL,NULL,NULL,'我共享单车没还上'),(19,NULL,NULL,NULL,'请再次刷卡下车'),(20,NULL,NULL,NULL,'开mc服什么的，零成本'),(21,NULL,NULL,NULL,'但是综合素质绝对要优于云服务器'),(22,NULL,NULL,NULL,'可能速度稍微慢了点'),(23,NULL,NULL,NULL,'这是啥。'),(24,NULL,NULL,NULL,'电脑'),(25,NULL,NULL,NULL,'荣成一号线。'),(26,NULL,NULL,NULL,'荣成站——哈理工荣成'),(27,NULL,NULL,NULL,'谢谢合作'),(28,NULL,NULL,NULL,'与经济基础和实际需求毫不相符的交通设施.jpg'),(29,NULL,NULL,NULL,'窝直呼牛逼。'),(30,NULL,NULL,NULL,'草'),(31,NULL,NULL,NULL,'一中小壁灯们放寒假了'),(32,NULL,NULL,NULL,'妈逼'),(33,NULL,NULL,NULL,'这iptv怎么搞'),(34,NULL,NULL,NULL,'两个小时弄了两页书'),(35,NULL,NULL,NULL,'嘉 禾'),(36,NULL,NULL,NULL,'它动起来了。'),(37,NULL,NULL,NULL,'在考虑要不要玩树莓派'),(38,NULL,NULL,NULL,'头真疼。。'),(39,NULL,NULL,NULL,'哪里有卖rj45转usb'),(40,NULL,NULL,NULL,'\r\n这tm是轨道交通。'),(41,NULL,NULL,NULL,'老年卡'),(42,NULL,NULL,NULL,'飞刃'),(43,NULL,NULL,NULL,'近地轨道交通'),(44,NULL,NULL,NULL,'每公里1块、'),(45,NULL,NULL,NULL,'无起步费、'),(46,NULL,NULL,NULL,'理解不能。'),(47,NULL,NULL,NULL,'噢。'),(48,NULL,NULL,NULL,'窝没交建筑费好像。'),(49,NULL,NULL,NULL,'我急用'),(50,NULL,NULL,NULL,'jss有个大jb拓展五'),(51,NULL,NULL,NULL,'奥那个啊'),(52,NULL,NULL,NULL,'hub'),(53,NULL,NULL,NULL,'rj45-typec'),(54,NULL,NULL,NULL,'你再tpc-usba'),(55,NULL,NULL,NULL,'我以后得天天用'),(56,NULL,NULL,NULL,'等等'),(57,NULL,NULL,NULL,'总不能抢过来'),(58,NULL,NULL,NULL,'义乌有卖的没'),(59,NULL,NULL,NULL,'吧'),(60,NULL,NULL,NULL,'肯定有'),(61,NULL,NULL,NULL,'我去康康'),(62,NULL,NULL,NULL,'我拓展坞有rj45母口'),(63,NULL,NULL,NULL,'抓到月月鸟'),(64,NULL,NULL,NULL,'我操。'),(65,NULL,NULL,NULL,'空格也写的字'),(66,'1',1,'2021-01-20 19:15:06','1111'),(67,'1\r\n',NULL,NULL,NULL),(68,'Thaumy',1951327599,'2021-01-28 22:57:00','测试'),(69,'Thaumy',1951327599,'2021-01-28 22:57:34','学习功能开了'),(70,'Thaumy',1951327599,'2021-01-28 23:01:55','来不'),(71,'血璃猫丶hprstable',2019766667,'2021-01-28 23:07:37','GTX1080TI 只有11.5T的单精度浮点运算性能'),(72,'Thaumy',1951327599,'2021-01-28 23:08:43','蔚来et7的算力'),(73,'Thaumy',1951327599,'2021-01-28 23:08:47','有1000T'),(74,'血璃猫丶hprstable',2019766667,'2021-01-28 23:09:37','？'),(75,'血璃猫丶hprstable',2019766667,'2021-01-28 23:10:49','TFLOPS≠TOPS'),(76,'血璃猫丶hprstable',2019766667,'2021-01-28 23:11:11','这里是单精度浮点性能'),(77,'血璃猫丶hprstable',2019766667,'2021-01-28 23:13:07','挺好'),(78,'void **Soulstar',1374723172,'2021-01-28 23:13:42','1 . 7 k'),(79,'KGAMEJOKER',736193679,'2021-01-28 23:13:54','你科二都没考'),(80,'void **Soulstar',1374723172,'2021-01-28 23:13:56','女子'),(81,'KGAMEJOKER',736193679,'2021-01-28 23:13:59','就开始准备买车了'),(82,'KGAMEJOKER',736193679,'2021-01-28 23:14:05','有钱'),(83,'血璃猫丶hprstable',2019766667,'2021-01-28 23:14:06','？'),(84,'血璃猫丶hprstable',2019766667,'2021-01-28 23:14:10','看看还不让'),(85,'void **Soulstar',1374723172,'2021-01-28 23:14:10','你懂个屁'),(86,'void **Soulstar',1374723172,'2021-01-28 23:14:19','这叫游 戏 主 机'),(87,'void **Soulstar',1374723172,'2021-01-28 23:14:24','你的下一台游戏机'),(88,'void **Soulstar',1374723172,'2021-01-28 23:14:32','何必是游戏机'),(89,'血璃猫丶hprstable',2019766667,'2021-01-28 23:14:37','确实'),(90,'KGAMEJOKER',736193679,'2021-01-28 23:14:38','虽然'),(91,'KGAMEJOKER',736193679,'2021-01-28 23:14:42','他之前跟我说过'),(92,'KGAMEJOKER',736193679,'2021-01-28 23:14:53','他要买个电动汽车'),(93,'KGAMEJOKER',736193679,'2021-01-28 23:15:02','反正我是没拿钱'),(94,'血璃猫丶hprstable',2019766667,'2021-01-28 23:15:06','大中控屏'),(95,'血璃猫丶hprstable',2019766667,'2021-01-28 23:15:17','就是难看了点'),(96,'血璃猫丶hprstable',2019766667,'2021-01-28 23:15:22','就感觉不协调'),(97,'血璃猫丶hprstable',2019766667,'2021-01-28 23:15:58','看看多少钱'),(98,'KGAMEJOKER',736193679,'2021-01-28 23:17:33','你的意思是'),(99,'Thaumy',1951327599,'2021-01-28 23:39:54','打电话'),(100,'void **Soulstar',1374723172,'2021-01-28 23:40:00','4008515151'),(101,'Thaumy',1951327599,'2021-01-28 23:40:03','?4008515151'),(102,'void **Soulstar',1374723172,'2021-01-28 23:40:27','增强你的体质晴请喝千年铁皮疯狗'),(103,'血璃猫丶hprstable',2019766667,'2021-01-28 23:40:37','@2951121593 触控不用 语言助手也不用'),(104,'血璃猫丶hprstable',2019766667,'2021-01-28 23:40:41','那啥好用'),(105,'星辰',2951121593,'2021-01-28 23:41:35','。。'),(106,'Thaumy',1951327599,'2021-01-28 23:41:36','懂得都懂'),(107,'星辰',2951121593,'2021-01-28 23:41:40','我不是说触控不用'),(108,'星辰',2951121593,'2021-01-28 23:41:47','是纯触控不好用'),(109,'星辰',2951121593,'2021-01-28 23:42:14','我只是说纯触控不好用，我也没说纯触控不用语音助手也不用吧'),(110,'星辰',2951121593,'2021-01-28 23:45:36','触控和机械半分中控，基本功能保留机械式操作。比如音量旋钮(这个可以在方向盘实现)，紧急灯，独立式空调旋钮，座椅加热。这些在机械旋钮上都可以实现段落触感分级调节，不用看就可以扭'),(111,'Thaumy',1951327599,'2021-01-28 23:48:09','van一会吃鸡'),(112,'void **Soulstar',1374723172,'2021-01-28 23:48:14','这都什么jb事'),(113,'星辰',2951121593,'2021-01-28 23:48:16','但是不可否认，汽车中控还是在向近乎于纯屏幕的方向发展');
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

-- Dump completed on 2021-01-28 23:49:15
