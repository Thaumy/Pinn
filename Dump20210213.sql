-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pilipala_test
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
-- Table structure for table `comment_lake`
--

DROP TABLE IF EXISTS `comment_lake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_lake` (
  `CommentID` int NOT NULL,
  `PostID` int NOT NULL,
  `User` varchar(32) NOT NULL DEFAULT '',
  `Email` varchar(64) NOT NULL DEFAULT '',
  `Content` longtext NOT NULL,
  `WebSite` varchar(128) NOT NULL DEFAULT '',
  `HEAD` int NOT NULL,
  `Time` datetime NOT NULL,
  `Floor` tinyint NOT NULL,
  PRIMARY KEY (`CommentID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_lake`
--

LOCK TABLES `comment_lake` WRITE;
/*!40000 ALTER TABLE `comment_lake` DISABLE KEYS */;
INSERT INTO `comment_lake` VALUES (30000,12431,'Pinn','pinn@amml.com','来自小品的钦定！','',0,'2020-09-21 22:49:22',2),(30001,12431,'雅爱方雏丶YAMAHA','yamaha@yamaha.cn','来自雅爱方雏的钦定！雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎雅虎！','www.ralhavenorid.com',0,'2020-09-21 22:52:28',3),(30002,12431,'王晟睿','wsr@h2om.com','雅子我爱你呀~哼哼哼啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊','',30001,'2020-09-21 22:53:11',4),(30003,12431,'Thaumy','studio_ai@outlook.com','我看你是欠日','www.thaumy.cn',30002,'2020-09-21 22:54:19',5),(30004,12431,'jss','jss@h2om.com','爷爷王来啦~','',0,'2020-09-27 15:55:57',6),(30008,12366,'Hodpel','i@dkhodpel.top','话说我也没用那插件了..\r\n感觉地址的话中文的不太好… 可以改成拼音或翻译成英文','www.dkhodpel.top',0,'2017-08-05 06:30:00',2),(30009,12366,'Hodpel','i@dkhodpel.top','(评论是要审核么2333)\r\n还有 既然都用pjax了就顺便加个ajax评论吧…\r\n而且我用的是jquery.pjax.js(滑稽)','',0,'2017-08-05 06:32:00',3),(30010,12366,'Thaumy','studio_ai@outlook.com','emmmmmm……..','www.thaumy.cn',30009,'2017-08-05 13:26:00',4),(30011,12366,'Thaumy','studio_ai@outlook.com','感觉中文的用户体验好一些吧，不影响什么速度也方便我维护','www.dkhodpel.top',30008,'2017-08-05 13:30:00',5),(30012,12384,'RealLuna HeheAndroid','ralhavenorid@126.com','支持一下。。。','www.ralhavenorid.com',0,'2017-12-09 13:53:00',3),(30013,12384,'Thaumy','studio_ai@outlook.com','哈喽！欢迎评论~！','www.thaumy.cn',0,'2017-07-16 07:12:00',2),(30016,12381,'c','Studio_ai@outlook.com','c','',0,'2020-12-17 09:44:47',2);
/*!40000 ALTER TABLE `comment_lake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `neg>dirty>union`
--

DROP TABLE IF EXISTS `neg>dirty>union`;
/*!50001 DROP VIEW IF EXISTS `neg>dirty>union`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `neg>dirty>union` AS SELECT 
 1 AS `PostID`,
 1 AS `UUID`,
 1 AS `CT`,
 1 AS `Mode`,
 1 AS `Type`,
 1 AS `User`,
 1 AS `UVCount`,
 1 AS `StarCount`,
 1 AS `ArchiveID`,
 1 AS `LCT`,
 1 AS `Title`,
 1 AS `Summary`,
 1 AS `Content`,
 1 AS `ArchiveName`,
 1 AS `Label`,
 1 AS `Cover`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `neg>union`
--

DROP TABLE IF EXISTS `neg>union`;
/*!50001 DROP VIEW IF EXISTS `neg>union`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `neg>union` AS SELECT 
 1 AS `PostID`,
 1 AS `UUID`,
 1 AS `CT`,
 1 AS `Mode`,
 1 AS `Type`,
 1 AS `User`,
 1 AS `UVCount`,
 1 AS `StarCount`,
 1 AS `ArchiveID`,
 1 AS `LCT`,
 1 AS `Title`,
 1 AS `Summary`,
 1 AS `Content`,
 1 AS `ArchiveName`,
 1 AS `Label`,
 1 AS `Cover`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pl_archive`
--

DROP TABLE IF EXISTS `pl_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pl_archive` (
  `ArchiveID` int NOT NULL,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`ArchiveID`,`Name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pl_archive`
--

LOCK TABLES `pl_archive` WRITE;
/*!40000 ALTER TABLE `pl_archive` DISABLE KEYS */;
INSERT INTO `pl_archive` VALUES (0,'无'),(1,'生活'),(2,'技术'),(3,'维护日志'),(4,'置顶'),(5,'特殊'),(6,'页面');
/*!40000 ALTER TABLE `pl_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pl_index`
--

DROP TABLE IF EXISTS `pl_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pl_index` (
  `PostID` int unsigned NOT NULL,
  `UUID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `CT` datetime NOT NULL,
  `Mode` varchar(10) NOT NULL DEFAULT '',
  `Type` varchar(8) NOT NULL DEFAULT '',
  `User` char(24) NOT NULL DEFAULT '',
  `UVCount` int unsigned NOT NULL,
  `StarCount` int unsigned NOT NULL,
  `ArchiveID` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`PostID`) USING BTREE,
  UNIQUE KEY `ID` (`PostID`) USING BTREE,
  UNIQUE KEY `GUID` (`UUID`) USING BTREE,
  KEY `CT` (`CT`) USING BTREE,
  KEY `UNI` (`PostID`,`UUID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pl_index`
--

LOCK TABLES `pl_index` WRITE;
/*!40000 ALTER TABLE `pl_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `pl_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pl_stack`
--

DROP TABLE IF EXISTS `pl_stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pl_stack` (
  `PostID` int unsigned NOT NULL,
  `UUID` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `LCT` datetime NOT NULL,
  `Title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Summary` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Label` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Cover` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`UUID`) USING BTREE,
  UNIQUE KEY `GUID` (`UUID`) USING BTREE,
  KEY `ID` (`PostID`) USING BTREE,
  KEY `LCT` (`LCT`) USING BTREE,
  KEY `UNI` (`PostID`,`UUID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pl_stack`
--

LOCK TABLES `pl_stack` WRITE;
/*!40000 ALTER TABLE `pl_stack` DISABLE KEYS */;
/*!40000 ALTER TABLE `pl_stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pl_user`
--

DROP TABLE IF EXISTS `pl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pl_user` (
  `Account` bigint NOT NULL,
  `PWD` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Name` char(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Bio` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `GroupType` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `PrivateKey` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `TokenTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Name`,`Account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pl_user`
--

LOCK TABLES `pl_user` WRITE;
/*!40000 ALTER TABLE `pl_user` DISABLE KEYS */;
INSERT INTO `pl_user` VALUES (1522700134,'15a37a23b406e8435aac360dd462fbae','Pinn','源于镜像','admin','studio_ai@outlook.com','http://thblog-img.test.upcdn.net/ui_img/Mai.jpg','','2020-11-01 20:35:01'),(1951327599,'c81ff1fccffffc6a078b528be03afd5a','Thaumy','一个纯粹的人','user','studio_ai@outlook.com','http://q1.qlogo.cn/g?b=qq&nk=1951327599&s=640','-----BEGIN RSA PRIVATE KEY-----\nMIIEpAIBAAKCAQEA3Lh8pHTaCjZUIqAUMrPoRjyF6oB/IH80PNkXGROUYJ3cXb3s\ndhw+VBvrwi637m1ujZes9cka4cbC1fPRdZDRZPdiMngGQNFy8q/Bp8BfJdEfN1Mg\nmX/cs2cQXxYUQgnNKI775GRn7ZhuuUrPc/9MtbTlNjUJQVkhH/VQnV6pSvJkkwSc\nMCfxG99/a7tdOtd6rvKhXYFivv/+RU/qZYEUKoq+xxTP6omi/5B8R2Eu5B9KYFJD\nwhBuj/yWj/y9FLjGU5HjUpePZgHPE9VabGBBle5L6hTTnPKiAKi242YKBGJe5fz1\neSUMTE/g+09YZ4/1mNkGYkFYcFwslCBu+c+FiQIDAQABAoIBADY9W9vqHz7NNQXB\nQtVm4piH/PywkQ0CVWryijuOVTMc9+9NYdNwg1yV8+ynIGoGGFnRQR6xSdrbxjtf\njESQzvQ52ra+SgMZtV6wFC3OF1OqvToSQnuWMT0hAaPsQBQuZm0mHf51MhjwEZ2V\nJb/CqC4rAvy8MccOSRaaaTIS9hVFYK1VuZo9K1bH9zBNPeLhTozpB7oSlPzHgNda\nU3zWkd975ttaUBlkTk4Sad/awJ7qq1QEfvvKE5aF7Kw8t8cjDIWOLKSF5dwh3jXA\n6L0bPsnrb7UUGoUqXBY8POwaO0oKV9XqhmqofHkBA1Mh4loXRpkw1lKcJgd7UsVP\npPZkabUCgYEA4Fc6Vp88TPZF8kV2S5szyhYtnopDAhof5wnJfl2vv1+dX2Y2ZkQI\n0Z4MJAzi3MZ4ak5WRT4uTlU2GI2SPKp4QajSr/ZCUozlatLpDFH97z0iZF8GebIN\nSjdZTDbs6GqHkUwrTbpSnblBBWqu3w0W7HtTz/TY2R5E4x3oaYvreQcCgYEA+955\n31NcMHmKQpxBsisGjdx52JrG++xZtvRjpQ/H0HXTSEclmi9DYsnke4tgadZjC2QW\nnpSGbv/DLsx1uUa2R2U5VwT+VHPkOgpqNPzVkSn66feQIUbm6Z6sPrd8htYW2+ch\nPVpIiOfitctjzvO6oEqwYIs4k90f+lbBMlWAOO8CgYEApE8+6zK1d6jokglOGxIR\nXHHh97xMV73Kn+0LJwJ3NjNRkA3MyhoKW3zmZ4EIp6q1hybZCN4CDF1cwZ7u/H/e\nlDiSF07GRK/tV9Ah4GQtGIwuJFV06K0ADtt7C9curQtZP5IKJWPSHrMQbGc2rSdp\nIssxF569NEh3K+E72BIi5QECgYBh8GTbnoKepuRIepJhQbHOwAjxXV463/ES331P\n1g8Q1IBP/rp0diRx6afbEptvDFp/N3BEQeT0jKfNLtwoK4L9yDK/z8VF+bqphxs9\nd4NkazqSeB2nkvZ/qZ+404istds1r26ReOXztpfFsU0iUEwlwGVNZVWeycGBivKd\nK/osKQKBgQCntQCkT7I7PNzAPghWZBOypFfppbV0xazrWwprc+18JFd4MTEYHe/X\ng1xAR+rwPTX2VLz0aauvIz32s1oeI73lgElEQQSstvaoW2o6Yz3Jb9QJbQLDH5np\nLCGg08rPRptDapbZg1SAZpELb/ZioljNa+IQXcId1P2/uA68csy28Q==\n-----END RSA PRIVATE KEY-----','2020-12-26 16:48:25');
/*!40000 ALTER TABLE `pl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pos>dirty>union`
--

DROP TABLE IF EXISTS `pos>dirty>union`;
/*!50001 DROP VIEW IF EXISTS `pos>dirty>union`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pos>dirty>union` AS SELECT 
 1 AS `PostID`,
 1 AS `UUID`,
 1 AS `CT`,
 1 AS `Mode`,
 1 AS `Type`,
 1 AS `User`,
 1 AS `UVCount`,
 1 AS `StarCount`,
 1 AS `ArchiveID`,
 1 AS `LCT`,
 1 AS `Title`,
 1 AS `Summary`,
 1 AS `Content`,
 1 AS `ArchiveName`,
 1 AS `Label`,
 1 AS `Cover`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `pos>union`
--

DROP TABLE IF EXISTS `pos>union`;
/*!50001 DROP VIEW IF EXISTS `pos>union`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pos>union` AS SELECT 
 1 AS `PostID`,
 1 AS `UUID`,
 1 AS `CT`,
 1 AS `Mode`,
 1 AS `Type`,
 1 AS `User`,
 1 AS `UVCount`,
 1 AS `StarCount`,
 1 AS `ArchiveID`,
 1 AS `LCT`,
 1 AS `Title`,
 1 AS `Summary`,
 1 AS `Content`,
 1 AS `ArchiveName`,
 1 AS `Label`,
 1 AS `Cover`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'pilipala_test'
--

--
-- Dumping routines for database 'pilipala_test'
--

--
-- Final view structure for view `neg>dirty>union`
--

/*!50001 DROP VIEW IF EXISTS `neg>dirty>union`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `neg>dirty>union` AS select `pl_index`.`PostID` AS `PostID`,`pl_stack`.`UUID` AS `UUID`,`pl_index`.`CT` AS `CT`,`pl_index`.`Mode` AS `Mode`,`pl_index`.`Type` AS `Type`,`pl_index`.`User` AS `User`,`pl_index`.`UVCount` AS `UVCount`,`pl_index`.`StarCount` AS `StarCount`,`pl_index`.`ArchiveID` AS `ArchiveID`,`pl_stack`.`LCT` AS `LCT`,`pl_stack`.`Title` AS `Title`,`pl_stack`.`Summary` AS `Summary`,`pl_stack`.`Content` AS `Content`,`pl_archive`.`Name` AS `ArchiveName`,`pl_stack`.`Label` AS `Label`,`pl_stack`.`Cover` AS `Cover` from ((`pl_index` join `pl_stack` on((`pl_index`.`PostID` = `pl_stack`.`PostID`))) join `pl_archive` on((`pl_archive`.`ArchiveID` = `pl_index`.`ArchiveID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `neg>union`
--

/*!50001 DROP VIEW IF EXISTS `neg>union`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `neg>union` AS select `pl_index`.`PostID` AS `PostID`,`pl_stack`.`UUID` AS `UUID`,`pl_index`.`CT` AS `CT`,`pl_index`.`Mode` AS `Mode`,`pl_index`.`Type` AS `Type`,`pl_index`.`User` AS `User`,`pl_index`.`UVCount` AS `UVCount`,`pl_index`.`StarCount` AS `StarCount`,`pl_index`.`ArchiveID` AS `ArchiveID`,`pl_stack`.`LCT` AS `LCT`,`pl_stack`.`Title` AS `Title`,`pl_stack`.`Summary` AS `Summary`,`pl_stack`.`Content` AS `Content`,`pl_archive`.`Name` AS `ArchiveName`,`pl_stack`.`Label` AS `Label`,`pl_stack`.`Cover` AS `Cover` from ((`pl_index` join `pl_stack` on((`pl_index`.`PostID` = `pl_stack`.`PostID`))) join `pl_archive` on((convert(`pl_archive`.`ArchiveID` using utf8mb4) = `pl_index`.`ArchiveID`))) where (`pl_index`.`Mode` <> 'hidden') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pos>dirty>union`
--

/*!50001 DROP VIEW IF EXISTS `pos>dirty>union`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pos>dirty>union` AS select `pl_index`.`PostID` AS `PostID`,`pl_index`.`UUID` AS `UUID`,`pl_index`.`CT` AS `CT`,`pl_index`.`Mode` AS `Mode`,`pl_index`.`Type` AS `Type`,`pl_index`.`User` AS `User`,`pl_index`.`UVCount` AS `UVCount`,`pl_index`.`StarCount` AS `StarCount`,`pl_index`.`ArchiveID` AS `ArchiveID`,`pl_stack`.`LCT` AS `LCT`,`pl_stack`.`Title` AS `Title`,`pl_stack`.`Summary` AS `Summary`,`pl_stack`.`Content` AS `Content`,`pl_archive`.`Name` AS `ArchiveName`,`pl_stack`.`Label` AS `Label`,`pl_stack`.`Cover` AS `Cover` from ((`pl_index` join `pl_stack` on((convert(`pl_index`.`UUID` using utf8mb4) = `pl_stack`.`UUID`))) join `pl_archive` on((convert(`pl_archive`.`ArchiveID` using utf8mb4) = `pl_index`.`ArchiveID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pos>union`
--

/*!50001 DROP VIEW IF EXISTS `pos>union`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pos>union` AS select `pl_index`.`PostID` AS `PostID`,`pl_index`.`UUID` AS `UUID`,`pl_index`.`CT` AS `CT`,`pl_index`.`Mode` AS `Mode`,`pl_index`.`Type` AS `Type`,`pl_index`.`User` AS `User`,`pl_index`.`UVCount` AS `UVCount`,`pl_index`.`StarCount` AS `StarCount`,`pl_index`.`ArchiveID` AS `ArchiveID`,`pl_stack`.`LCT` AS `LCT`,`pl_stack`.`Title` AS `Title`,`pl_stack`.`Summary` AS `Summary`,`pl_stack`.`Content` AS `Content`,`pl_archive`.`Name` AS `ArchiveName`,`pl_stack`.`Label` AS `Label`,`pl_stack`.`Cover` AS `Cover` from ((`pl_index` join `pl_stack` on((convert(`pl_index`.`UUID` using utf8mb4) = `pl_stack`.`UUID`))) join `pl_archive` on((convert(`pl_archive`.`ArchiveID` using utf8mb4) = `pl_index`.`ArchiveID`))) where (`pl_index`.`Mode` <> 'hidden') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-13 10:03:47
