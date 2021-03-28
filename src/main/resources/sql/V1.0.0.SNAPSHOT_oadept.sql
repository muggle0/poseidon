/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.29-log : Database - p_oa
*********************************************************************
*/




/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''NO_AUTO_VALUE_ON_ZERO'' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `oa_attachment_list` */

CREATE TABLE `oa_attachment_list` (
  `attachment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment_name` varchar(255) DEFAULT NULL,
  `attachment_path` varchar(255) DEFAULT NULL,
  `attachment_shuffix` varchar(255) DEFAULT NULL,
  `attachment_size` varchar(255) DEFAULT NULL,
  `attachment_type` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_attachment_list` */

insert  into `oa_attachment_list`(`attachment_id`,`attachment_name`,`attachment_path`,`attachment_shuffix`,`attachment_size`,`attachment_type`,`model`,`upload_time`,`user_id`) values (3,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-09-18 16:33:25'',''1''),(6,''4.jpg'',''oasys.jpg'',''jpg'',''133831'',''image/jpeg'',''note'',''2017-09-15 11:01:08'',''1''),(7,''3.jpg'',''oasys.jpg'',''jpg'',''231999'',''image/jpeg'',''note'',''2017-09-15 11:04:38'',''1''),(8,''3.jpg'',''oasys.jpg'',''jpg'',''231999'',''image/jpeg'',''note'',''2017-09-15 11:09:21'',''1''),(9,''2.jpg'',''oasys.jpg'',''jpg'',''302654'',''image/jpeg'',''note'',''2017-09-23 16:43:50'',''1''),(10,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-09-15 20:11:22'',''1''),(11,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-09-15 20:14:50'',''1''),(12,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-09-15 20:37:24'',''1''),(13,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-09-15 23:06:24'',''1''),(44,''1.jpg'',''oasys.jpg'',''jpg'',''191177'',''image/jpeg'',''note'',''2017-09-23 15:30:09'',''1''),(46,''4.jpg'',''oasys.jpg'',''jpg'',''133831'',''image/jpeg'',''note'',''2017-09-23 16:11:11'',''1''),(47,''1.jpg'',''oasys.jpg'',''jpg'',''191177'',''image/jpeg'',''note'',''2017-09-23 16:37:05'',''1''),(48,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 19:40:05'',''1''),(49,''30D06FF1176D3C568E37CBE221D2E542.png'',''oasys.jpg'',''png'',''71260'',''image/png'',''mail'',''2017-09-28 21:24:38'',''1''),(50,''wenwu.gif'',''oasys.jpg'',''gif'',''3532'',''image/gif'',''mail'',''2017-09-28 21:27:45'',''1''),(51,''wenwu.gif'',''oasys.jpg'',''gif'',''3532'',''image/gif'',''mail'',''2017-09-28 21:30:40'',''1''),(52,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 21:37:44'',''1''),(53,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 21:46:48'',''1''),(54,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 21:53:24'',''1''),(55,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 22:00:37'',''1''),(56,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 22:03:46'',''1''),(57,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-09-28 22:20:12'',''1''),(58,''截图.png'',''oasys.jpg'',''png'',''195652'',''image/png'',''mail'',''2017-09-29 22:09:51'',''1''),(59,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-01 12:46:44'',''2''),(60,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-01 19:39:14'',''1''),(61,''30D06FF1176D3C568E37CBE221D2E542.png'',''oasys.jpg'',''png'',''71260'',''image/png'',''mail'',''2017-10-02 14:49:56'',''1''),(62,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-06 11:02:49'',''1''),(64,''4.jpg'',''oasys.jpg'',''jpg'',''133831'',''image/jpeg'',''note'',''2017-10-07 16:03:03'',''1''),(65,''1.jpg'',''oasys.jpg'',''jpg'',''191177'',''image/jpeg'',''note'',''2017-10-07 16:03:58'',''1''),(66,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''aoa_bursement'',''2017-10-12 23:25:57'',''18''),(67,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''aoa_bursement'',''2017-10-14 21:22:35'',''3''),(68,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''aoa_bursement'',''2017-10-15 19:17:46'',''18''),(69,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-16 17:17:51'',''18''),(70,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-16 17:42:16'',''1''),(71,''3.jpg'',''oasys.jpg'',''jpg'',''231999'',''image/jpeg'',''note'',''2017-10-18 16:13:02'',''1''),(72,''touxiang.jpg'',''oasys.jpg'',''jpg'',''12124'',''image/jpeg'',''mail'',''2017-10-18 17:45:16'',''1''),(73,''timg.jpeg'',''oasys.jpg'',''jpeg'',''696381'',''image/jpeg'',''note'',''2017-10-19 23:37:37'',''5''),(74,''2.jpg'',''oasys.jpg'',''jpg'',''302654'',''image/jpeg'',''note'',''2017-10-20 10:35:00'',''4''),(75,''3.jpg'',''oasys.jpg'',''jpg'',''231999'',''image/jpeg'',''note'',''2017-10-20 10:36:07'',''4''),(76,''5.jpg'',''oasys.jpg'',''jpg'',''175797'',''image/jpeg'',''note'',''2017-10-20 10:40:03'',''7''),(77,''3.jpg'',''oasys.jpg'',''jpg'',''231999'',''image/jpeg'',''note'',''2017-10-22 09:21:27'',''1''),(78,''4.jpg'',''oasys.jpg'',''jpg'',''133831'',''image/jpeg'',''note'',''2017-10-22 09:13:12'',''1''),(79,''4.jpg'',''oasys.jpg'',''jpg'',''133831'',''image/jpeg'',''note'',''2017-10-22 09:26:33'',''1''),(80,''2.jpg'',''oasys.jpg'',''jpg'',''302654'',''image/jpeg'',''note'',''2017-10-22 09:33:49'',''1''),(81,''1.jpg'',''oasys.jpg'',''jpg'',''191177'',''image/jpeg'',''note'',''2017-10-22 10:00:19'',''1''),(82,''1.jpg'',''oasys.jpg'',''jpg'',''191177'',''image/jpeg'',''note'',''2017-10-22 11:28:16'',''1'');

/*Table structure for table `oa_attends_list` */

CREATE TABLE `oa_attends_list` (
  `attends_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attends_ip` varchar(20) DEFAULT NULL,
  `attends_remark` varchar(20) DEFAULT NULL,
  `attends_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `attends_user_id` bigint(20) DEFAULT NULL,
  `attend_hmtime` varchar(255) DEFAULT NULL,
  `week_ofday` varchar(255) DEFAULT NULL,
  `holiday_days` double(255,0) DEFAULT ''0'',
  `holiday_start` date DEFAULT NULL,
  PRIMARY KEY (`attends_id`),
  KEY `FKaxgqsm98npnl1rxysh9upfjee` (`attends_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_attends_list` */

insert  into `oa_attends_list`(`attends_id`,`attends_ip`,`attends_remark`,`attends_time`,`status_id`,`type_id`,`attends_user_id`,`attend_hmtime`,`week_ofday`,`holiday_days`,`holiday_start`) values (1,''127.0.0.1'',''上班正常4'',''2017-09-27 08:16:36'',10,8,4,''08:16'',''星期三'',0,NULL),(2,''127.0.0.1'',''上班迟到2'',''2017-08-15 12:40:35'',11,8,4,''12:40'',''星期二'',0,NULL),(3,''127.0.0.1'',''下班正常'',''2017-09-02 18:49:13'',10,9,4,''18:49'',''星期六'',0,NULL),(12,NULL,NULL,''2017-09-28 22:17:16'',11,8,2,''22:17'',''星期四'',0,NULL),(13,NULL,NULL,''2017-09-28 22:35:24'',10,9,2,''22:35'',''星期四'',0,NULL),(14,NULL,NULL,''2017-09-29 13:04:10'',11,8,2,''09:50'',''星期五'',0,NULL),(15,NULL,NULL,''2017-09-29 18:49:42'',10,9,2,''18:49'',''星期五'',0,NULL),(22,NULL,NULL,''2017-09-06 20:02:40'',NULL,8,2,NULL,NULL,0,NULL),(23,NULL,NULL,''2017-09-14 20:03:20'',NULL,8,2,NULL,NULL,0,NULL),(24,NULL,NULL,''2017-10-01 10:49:32'',11,8,2,''10:49'',''星期日'',0,NULL),(25,NULL,NULL,''2017-10-01 20:29:38'',10,9,2,''20:29'',''星期日'',0,NULL),(26,NULL,NULL,''2017-10-02 13:10:48'',11,8,2,''13:10'',''星期一'',0,NULL),(27,NULL,NULL,''2017-10-02 18:53:15'',10,9,2,''18:53'',''星期一'',0,NULL),(28,NULL,NULL,''2017-10-03 12:30:51'',11,8,2,''12:30'',''星期二'',0,NULL),(29,NULL,NULL,''2017-10-05 13:26:12'',11,8,2,''13:26'',''星期四'',0,NULL),(30,NULL,NULL,''2017-10-05 13:29:58'',12,9,2,''13:29'',''星期四'',0,NULL),(31,NULL,NULL,''2017-10-07 16:11:07'',11,8,2,''16:11'',''星期六'',0,NULL),(32,NULL,NULL,''2017-10-07 16:24:15'',10,9,2,''16:24'',''星期六'',0,NULL),(33,NULL,NULL,''2017-10-08 10:19:24'',11,8,2,''10:19'',''星期日'',0,NULL),(34,NULL,NULL,''2017-10-09 10:59:13'',11,8,2,''10:59'',''星期一'',0,NULL),(35,''192.168.43.91'',NULL,''2017-10-09 14:05:52'',12,9,2,''14:05'',''星期一'',0,NULL),(36,''172.31.16.188'',NULL,''2017-10-09 16:08:00'',11,8,1,''16:08'',''星期一'',0,NULL),(37,''192.168.43.91'',NULL,''2017-10-12 15:22:36'',11,8,1,''15:22'',''星期四'',0,NULL),(39,''172.31.17.170'',NULL,''2017-10-21 15:08:36'',11,8,5,''15:08'',''星期六'',0,NULL),(40,''172.31.17.170'',NULL,''2017-10-21 15:09:16'',12,9,5,''15:09'',''星期六'',0,NULL),(41,''172.31.17.170'',''娃娃'',''2017-10-21 15:09:58'',11,8,6,''15:09'',''星期六'',0,NULL),(42,''172.31.17.170'',NULL,''2017-10-21 15:10:05'',12,9,6,''15:10'',''星期六'',0,NULL),(43,''172.31.17.170'',NULL,''2017-10-21 15:10:53'',11,8,7,''15:10'',''星期六'',0,NULL),(44,''172.31.17.170'',NULL,''2017-10-21 15:11:09'',12,9,7,''15:11'',''星期六'',0,NULL),(45,''172.31.17.170'',''迟到了 尴尬'',''2017-10-21 16:03:34'',11,8,4,''16:03'',''星期六'',0,NULL),(46,NULL,NULL,NULL,46,NULL,7,NULL,NULL,3,''2017-10-19''),(47,''172.31.17.170'',NULL,''2017-10-21 16:18:39'',11,8,3,''16:18'',''星期六'',0,NULL),(48,''192.168.1.233'',NULL,''2017-10-22 10:28:57'',11,8,7,''10:28'',''星期日'',NULL,NULL);

/*Table structure for table `oa_authority` */

CREATE TABLE `oa_authority` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `url_id` bigint(20) DEFAULT NULL,
  `relation_code` varchar(100) DEFAULT NULL COMMENT ''为了方便扩展冗余字段'',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_creator` bigint(20) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `gmt_modifitor` bigint(20) DEFAULT NULL,
  `role_code` varchar(150) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_relation_code` (`relation_code`),
  KEY `idx_url_role_code` (`url`,`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_authority` */

/*Table structure for table `oa_bursement` */

CREATE TABLE `oa_bursement` (
  `bursement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `all_money` double DEFAULT NULL,
  `allinvoices` int(11) DEFAULT NULL,
  `burse_time` datetime DEFAULT NULL,
  `financial_advice` varchar(255) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `operation_name` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `user_name` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`bursement_id`),
  KEY `FKt3xu5y23deh0mtqkfk3ly6219` (`operation_name`),
  KEY `FK666vswh4nl3voq8qalu73v2sq` (`pro_id`),
  KEY `FKgnqp4eax31sh7mn3lt2su7olr` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_bursement` */

/*Table structure for table `oa_catalog` */

CREATE TABLE `oa_catalog` (
  `catalog_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `cata_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`catalog_id`),
  KEY `FKbsk5nkjlqmd8j9rmkarse6j1x` (`cata_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_catalog` */

insert  into `oa_catalog`(`catalog_id`,`catalog_name`,`parent_id`,`cata_user_id`) values (1,''note'',1,1),(2,''诗词记录'',1,1),(9,''秒懂百科'',1,2),(11,''上课要案'',1,3),(12,''错题收集'',1,3),(32,''规划(3)'',1,1),(33,''根目录'',1,NULL),(34,''规划(4)'',1,1);

/*Table structure for table `oa_comment_list` */

CREATE TABLE `oa_comment_list` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `comment_user_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK2k00kkfhh93949ybod7qn56ax` (`comment_user_id`),
  KEY `FKeopff14rxco5thbwwlu7exglo` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_comment_list` */

insert  into `oa_comment_list`(`comment_id`,`comment`,`time`,`comment_user_id`,`reply_id`) values (2,''范德萨发'',''2017-10-01 22:07:29'',2,2),(8,''@朱丽叶 你要干嘛？'',''2017-10-02 13:37:48'',1,2),(9,''哇哇哇，interesting'',''2017-10-02 13:38:20'',1,3),(10,''N这个死鬼'',''2017-10-02 13:48:28'',1,4),(15,''有什么问题么？'',''2017-10-02 16:48:21'',1,8),(21,''fasd fds '',''2017-10-03 00:35:14'',1,7),(23,''年轻人，年轻的一批'',''2017-10-03 00:52:28'',1,16),(24,''你要干嘛？'',''2017-10-03 00:55:03'',1,14),(25,'' 哇哇，你真的是过分呀'',''2017-10-03 00:55:27'',1,9),(26,''大四范德萨'',''2017-10-03 01:03:01'',1,17),(27,''范德萨发爱迪生'',''2017-10-03 01:03:43'',1,17),(29,''@罗密欧 你好；'',''2017-10-03 11:20:37'',1,17),(30,''@罗密欧 你好；；'',''2017-10-03 11:21:25'',1,17),(31,'' 回复你又没有问题；'',''2017-10-03 11:22:06'',1,18),(34,''发生大法师'',''2017-10-04 01:33:18'',2,61),(35,''富士达发'',''2017-10-04 01:36:40'',2,61),(36,''范德萨'',''2017-10-04 01:36:48'',2,61),(37,''@朱丽叶 有意思'',''2017-10-04 01:37:51'',2,61),(38,''你哟啊干嘛？'',''2017-10-04 01:38:05'',2,61),(39,''@朱丽叶 回复可以么？'',''2017-10-04 01:40:22'',2,61),(40,'' 来恢复把'',''2017-10-04 01:41:28'',2,62),(41,''第一次回复是可以的'',''2017-10-04 01:45:47'',2,61),(42,''@朱丽叶 第二次回复'',''2017-10-04 01:46:07'',2,61),(43,''@朱丽叶 第二次回复，第三次回复'',''2017-10-04 01:46:25'',2,61),(44,''@朱丽叶  你就是朱丽叶呀'',''2017-10-04 01:46:43'',2,61),(45,''@朱丽叶  你就是朱丽叶呀，我不是，我什么都不是'',''2017-10-04 01:46:58'',2,61),(46,'' 没有东西是吧'',''2017-10-04 01:51:41'',2,64),(47,''@朱丽叶  克可达'',''2017-10-04 01:51:51'',2,64),(48,''你要干啥？'',''2017-10-04 01:52:00'',2,64),(49,'' 我也想知道为什么？'',''2017-10-04 01:53:02'',2,66),(50,'' 来，再加一条'',''2017-10-04 01:54:12'',2,66),(51,''这一次试试'',''2017-10-04 01:56:16'',2,67),(52,''第八条'',''2017-10-04 01:57:53'',2,67),(53,'' 再试一下'',''2017-10-04 01:59:52'',2,67),(54,''发生'',''2017-10-04 03:25:38'',2,60),(55,''范德萨'',''2017-10-04 03:25:43'',2,60),(56,''@朱丽叶发 是粉色是'',''2017-10-04 03:25:59'',2,60),(57,''@朱丽叶 现在开始没有entity了'',''2017-10-04 03:26:34'',2,60),(58,'' 再是一次'',''2017-10-04 03:29:28'',2,60),(59,'' 回复一下'',''2017-10-04 03:30:23'',2,60),(60,'' 没有评论，我怎么办嘛\n'',''2017-10-04 03:31:42'',2,71),(61,''再来一次'',''2017-10-04 03:31:56'',2,72),(64,''@朱丽叶6666666'',''2017-10-05 23:02:39'',2,73),(65,''@朱丽叶 地方撒'',''2017-10-05 23:03:14'',2,73),(66,''@朱丽叶6767'',''2017-10-05 23:04:05'',2,73),(67,''@朱丽叶鼎折覆餗'',''2017-10-05 23:04:24'',2,73),(68,''让他'',''2017-10-05 23:07:36'',2,58),(69,''手动阀'',''2017-10-05 23:07:47'',2,58),(70,''@朱丽叶大'',''2017-10-05 23:07:54'',2,58),(71,''发生'',''2017-10-05 23:18:47'',7,73),(72,''@甄姬而我若'',''2017-10-05 23:19:06'',7,73),(73,'' 加一条评论'',''2017-10-06 13:38:56'',1,33),(74,'' 再加一条'',''2017-10-06 13:39:19'',1,33),(75,'' 哟哟\n'',''2017-10-06 13:46:02'',2,2),(76,''@朱丽叶  回复有问题么？'',''2017-10-06 13:46:13'',2,2),(82,'' 有问题么？'',''2017-10-06 15:25:41'',2,58),(83,''没有问题撒'',''2017-10-06 16:53:48'',2,2),(84,'''',''2017-10-06 16:54:05'',2,2),(85,''@朱丽叶 一点点小小的问题'',''2017-10-06 16:54:05'',2,2),(86,'''',''2017-10-06 16:54:18'',2,2),(87,''@朱丽叶 ？？'',''2017-10-06 16:54:18'',2,2),(88,'''',''2017-10-06 16:54:18'',2,2),(89,'''',''2017-10-06 16:54:18'',2,2),(90,'' 不知道发生什么问题了'',''2017-10-06 16:56:22'',2,2),(91,''该配合你演出的我视而不见???'',''2017-10-08 15:24:03'',8,73),(92,''@罗密欧 好吧，你很棒棒'',''2017-10-08 15:27:41'',8,3),(94,''111'',''2020-03-27 22:23:44'',1,89);

/*Table structure for table `oa_dept` */

CREATE TABLE `oa_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_addr` varchar(255) DEFAULT NULL,
  `dept_fax` varchar(255) DEFAULT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `dept_tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `deptmanager` bigint(20) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_dept` */

insert  into `oa_dept`(`dept_id`,`dept_addr`,`dept_fax`,`dept_name`,`dept_tel`,`email`,`deptmanager`,`end_time`,`start_time`) values (1,''五楼'',NULL,''总经办'',''888888888'',''hq@fjhirg.com'',3,''2017-11-15 22:50:05'',''2017-11-07 22:50:11''),(2,''四楼'',NULL,''研发部'',''66666666'',''as@fwgh'',4,''2017-09-13 19:04:07'',''2010-05-23 00:00:00''),(3,''三楼'',NULL,''财务部'',''233333'',''153@qq.com'',5,''2017-09-19 16:46:26'',''2016-09-19 16:46:32''),(4,''六楼'',NULL,''市场部'',''666888'',''aaluoxiang@foxmail.com'',6,''2016-07-19 16:48:09'',''2014-09-19 16:48:20''),(5,''六楼'',NULL,''人事部'',''33332222'',''103@qq.com'',7,''2017-10-07 14:12:05'',''2017-05-09 14:12:14'');

/*Table structure for table `oa_detailsburse` */

CREATE TABLE `oa_detailsburse` (
  `detailsburse_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descript` varchar(255) DEFAULT NULL,
  `detailmoney` double NOT NULL,
  `invoices` int(11) DEFAULT NULL,
  `produce_time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `bursment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`detailsburse_id`),
  KEY `FKi02w0bghxr73fsc5sbpeyqdnn` (`bursment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_detailsburse` */

/*Table structure for table `oa_director` */

CREATE TABLE `oa_director` (
  `director_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `company_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_path` int(11) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`director_id`),
  KEY `FKi6pfdnqhbc6js940e2o1vape5` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_director` */

insert  into `oa_director`(`director_id`,`address`,`company_number`,`email`,`image_path`,`phone_number`,`pinyin`,`remark`,`sex`,`user_name`,`user_id`,`companyname`) values (1,'''','''',''153@qq.com'',NULL,''18173328976'',''zhangsan'','''',''男'',''张三'',1,''百度科技有限公司''),(2,''35栋517'',''66666'',''123@qq.com'',NULL,''18634344455'',''xiongtao'',''nice！'',''男'',''熊涛'',1,''517小分队''),(3,''湖南省株洲市'',''10023'',''153@gmail.com'',NULL,''18877665544'',''wangwu'',''范德萨'',''男'',''王五'',1,''google公司''),(5,''湖南省株洲市天元区'',''96578888888'',''1899999@qq.com'',NULL,''18899999900'',''zhangqifeng'',''卫龙、你爱吗？，我不是很爱'',''女'',''张奇风'',2,''辣条有限公司+百度''),(6,''34栋'',''888666'',''188@qq.com'',NULL,''18866554433'',''songjia'',''宋氏集团总裁'',''男'',''宋佳'',1,''宋氏集团''),(7,''泰山西路'',''41233243'',''123@qq.com'',NULL,''18877665544'',''xiaoli'',''没有什么备注'',''男'',''小李'',2,''xi小小公司''),(8,''湖工大'',''98877'',''123@qq.com'',NULL,''18877665544'',''xiongxiong'',''interesting'',''男'',''熊熊'',1,''工大ccu''),(9,''35栋517'',''517666'',''asdf@163.com'',NULL,''18899887766'',''xuxu'',''小分队的名字不错'',''男'',''xuxu'',1,''517小分队''),(10,''团员去'',''98877'',''12345@qq.com'',NULL,''18173328976'',''aa'',''有事'',''男'',''aa'',18,''google''),(11,''timg.jpeg'',''12342'',''12345@qq.com'',73,''18876665544'',''wanglaowu'',''有意思'',''男'',''王老五'',5,''联通'');

/*Table structure for table `oa_director_users` */

CREATE TABLE `oa_director_users` (
  `director_users_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catelog_name` varchar(255) DEFAULT NULL,
  `is_handle` int(11) DEFAULT NULL,
  `director_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `share_user_id` bigint(20) DEFAULT NULL,
  `sharetime` datetime DEFAULT NULL,
  PRIMARY KEY (`director_users_id`),
  KEY `FK675oqfmv4kx9w6bgi9rgsb8nw` (`director_id`),
  KEY `FK7hq4xk2ja9eka4210qkqq03hi` (`user_id`),
  KEY `FKibwkjvmp9383ltkfew1kyy6ny` (`share_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_director_users` */

insert  into `oa_director_users`(`director_users_id`,`catelog_name`,`is_handle`,`director_id`,`user_id`,`share_user_id`,`sharetime`) values (2,''大学咯'',1,2,1,NULL,''2017-10-15 18:49:46''),(4,''大学同学'',1,NULL,2,NULL,NULL),(5,'''',1,5,1,NULL,NULL),(10,'''',1,1,1,NULL,NULL),(14,'''',1,6,1,NULL,''2017-10-15 18:39:36''),(15,''同学情'',1,3,2,1,''2017-10-14 16:20:49''),(19,NULL,1,1,3,1,''2017-10-14 16:30:26''),(20,''小李父斯基的分类'',1,1,4,1,''2017-10-14 16:30:27''),(21,NULL,0,1,5,1,''2017-10-14 16:30:27''),(22,''重要客户'',1,5,2,1,''2017-10-14 16:31:31''),(23,NULL,1,5,3,1,''2017-10-14 16:31:31''),(25,NULL,0,5,5,1,''2017-10-14 16:31:31''),(26,NULL,1,3,8,1,''2017-10-14 16:32:35''),(27,NULL,0,3,10,1,''2017-10-14 16:33:23''),(28,NULL,0,2,9,1,''2017-10-14 16:37:02''),(29,NULL,0,6,6,1,''2017-10-14 16:39:48''),(30,NULL,0,3,14,1,''2017-10-14 16:40:55''),(31,NULL,0,3,22,1,''2017-10-14 16:42:22''),(32,'''',1,3,23,1,''2017-10-14 16:48:06''),(33,NULL,0,5,14,1,''2017-10-14 16:48:39''),(34,''重要客户'',1,7,1,2,''2017-10-14 21:46:48''),(36,'''',1,8,1,NULL,''2017-10-15 18:46:05''),(37,''大学咯'',0,NULL,1,NULL,''2017-10-15 18:48:56''),(38,NULL,0,NULL,1,NULL,''2017-10-15 18:50:57''),(39,NULL,1,9,1,NULL,''2017-10-15 18:52:05''),(40,''重要客户'',0,NULL,1,NULL,''2017-10-15 18:53:02''),(41,''同学情'',0,NULL,2,NULL,''2017-10-15 18:58:34''),(42,NULL,0,NULL,3,NULL,''2017-10-15 19:01:00''),(43,''第二分类'',0,NULL,3,NULL,''2017-10-15 19:01:35''),(44,''小李父斯基的分类'',0,NULL,4,NULL,''2017-10-15 19:11:54''),(45,NULL,0,1,7,4,''2017-10-15 19:13:26''),(46,NULL,0,1,8,4,''2017-10-15 19:13:26''),(47,NULL,0,1,9,4,''2017-10-15 19:13:27''),(48,''yoyo'',0,NULL,4,NULL,''2017-10-15 23:54:26''),(49,NULL,0,5,7,4,''2017-10-15 23:54:50''),(50,'''',1,10,18,NULL,''2017-10-18 19:54:11''),(51,''aaa'',0,NULL,18,NULL,''2017-10-18 19:54:46''),(52,'''',1,11,5,NULL,''2017-10-19 23:37:37''),(53,NULL,0,3,9,23,''2018-02-03 22:16:38''),(54,NULL,0,3,13,23,''2018-02-03 22:20:57''),(55,NULL,0,5,11,1,''2018-02-03 22:34:09'');

/*Table structure for table `oa_discuss_list` */

CREATE TABLE `oa_discuss_list` (
  `discuss_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment_id` int(11) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `visit_num` int(11) DEFAULT NULL,
  `discuss_user_id` bigint(20) DEFAULT NULL,
  `vote_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`discuss_id`),
  KEY `FKt8hvx0ai5fto20mmxmy2g8j4g` (`discuss_user_id`),
  KEY `FK17yi8arj4vjdr5mm5dhjov10j` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_discuss_list` */

insert  into `oa_discuss_list`(`discuss_id`,`attachment_id`,`content`,`create_time`,`status_id`,`title`,`type_id`,`visit_num`,`discuss_user_id`,`vote_id`,`modify_time`) values (1,NULL,''fdsfasfdsfasfsa'',''2017-09-29 21:48:28'',NULL,''fsda'',19,12,1,NULL,''2017-09-29 21:48:28''),(6,NULL,''富士达奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥'',''2017-09-29 21:48:28'',NULL,''what????'',20,7,2,NULL,''2017-10-04 18:06:39''),(7,NULL,''发生地方撒范德萨反反复复付付付付付付付付付付付付8'',''2017-09-30 13:07:03'',NULL,''发生富士达'',19,20,2,NULL,''2017-10-05 22:58:38''),(8,NULL,''fsdaaaaaaaaaaaaaaafsaaaaaaaaaaa'',''2017-09-30 13:12:33'',NULL,''同一人'',19,30,2,NULL,''2017-10-05 22:59:02''),(9,NULL,''发生的多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多'',''2017-09-30 13:16:51'',NULL,''范德萨'',20,11,2,NULL,''2017-09-30 13:07:03''),(12,NULL,''fsdaaaaaaaaaaaaaaafsaaaaaaaaaaa'',''2017-09-30 15:30:26'',NULL,''修改了这个名字2333'',19,96,2,NULL,''2017-10-04 21:24:09''),(13,NULL,''<p>\r\n	今天还是不错的，完成了一些内容，比如：修复了分页的小bug；还有一些其他的东西；再把讨论区好好的晚上一下\r\n</p>'',''2017-10-01 14:25:26'',NULL,''第一天的公告,++小整合'',19,339,1,NULL,''2017-10-01 14:25:26''),(14,NULL,''afsdddddddd fasdddddddddddddddd'',''2017-10-01 14:37:39'',NULL,''fads '',19,29,1,NULL,''2017-10-01 14:37:39''),(15,NULL,''afsddddddddddddddddddddddddddddddddddddddd'',''2017-10-01 14:40:08'',NULL,''dsaf '',19,24,1,NULL,''2017-10-01 14:40:08''),(17,NULL,''<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	每个对象在出生的时候就有一把钥匙（监视器Monitor），那么被synchronized 修饰的方法相当于给方法加了一个锁，这个方法就可以进行同步，在多线程的时候，不会出现线程安全问题。\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<span>注：Monitor是 Java中用以实现线程之间的互斥与协作的主要手段，它可以看成是对象或者 Class的锁。每一个对象都有，也仅有一个 Monitor。</span>\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	下面通过一张图片进行讲解：\r\n</p>\r\n<h4 id=\"1一张图片\" style=\"font-family:&quot;font-weight:300;color:#3F3F3F;font-size:1.25em;background-color:#FFFFFF;\">\r\n	<a name=\"t0\"></a>1.一张图片\r\n</h4>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<span>图片看不清，请点击这里 ：</span>&nbsp;<a href=\"http://img.blog.csdn.net/20170929230249738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMDY0ODU1NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" target=\"_blank\">高清大图</a>\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<img src=\"http://img.blog.csdn.net/20170929230249738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMDY0ODU1NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\" title=\"\" style=\"height:auto;\" />\r\n</p>\r\n<h4 id=\"2图片对应的代码\" style=\"font-family:&quot;font-weight:300;color:#3F3F3F;font-size:1.25em;background-color:#FFFFFF;\">\r\n	<a name=\"t1\"></a>2.图片对应的代码\r\n</h4>\r\n<pre class=\"prettyprint\"><span class=\"hljs-keyword\" style=\"color:#000088;\">import</span> java.util.Date; <span class=\"hljs-javadoc\" style=\"color:#880000;\">/**\r\n * 测试的object类\r\n *\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @author</span>:dufy\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @version</span>:1.0.0\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @date</span> 2017/9/29\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @email</span> 742981086@qq.com\r\n */</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\" style=\"color:#000088;\">class</span> <span class=\"hljs-title\" style=\"color:#660066;\">ObjectTest</span> {</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">synchronized</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodA</span>(){ <span class=\"hljs-keyword\" style=\"color:#000088;\">try</span> {\r\n            System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodA ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n            Thread.sleep(<span class=\"hljs-number\" style=\"color:#006666;\">1000</span>);\r\n        } <span class=\"hljs-keyword\" style=\"color:#000088;\">catch</span> (InterruptedException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n    } <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodB</span>(){\r\n\r\n        System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodB ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n    } <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">synchronized</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodC</span>(){ <span class=\"hljs-keyword\" style=\"color:#000088;\">try</span> {\r\n            System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodC ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n            Thread.sleep(<span class=\"hljs-number\" style=\"color:#006666;\">3000</span>);\r\n        } <span class=\"hljs-keyword\" style=\"color:#000088;\">catch</span> (InterruptedException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n    }\r\n\r\n\r\n}</pre>'',''2017-10-01 15:18:40'',NULL,''fsdaaaaaaaaaa '',21,8,1,NULL,''2017-10-01 15:18:40''),(23,NULL,''afdsssssssssssssssssssssssssssssssssssssssssfffffffffffffffffHHHHHHFFFFFFFFFF1111112222222'',''2017-10-01 16:38:44'',NULL,''yyyyyyyyyyHHHHHHHHHFFFFFF11111112222'',21,4,1,NULL,''2017-10-01 16:38:44''),(31,NULL,''投票标题test1111投票标题test1111投票标题test1111投票标题test1111'',''2017-10-03 21:53:12'',NULL,''投票标题test1111'',21,15,2,1,''2017-10-03 21:53:12''),(32,NULL,''他的44444他的44444他的44444他的44444'',''2017-10-03 21:55:10'',NULL,''他的44444'',21,71,2,2,''2017-10-03 21:55:09''),(33,NULL,''&nbsp;投票的测试&nbsp;投票的测试&nbsp;投票的测试&nbsp;投票的测试'',''2017-10-03 23:25:08'',NULL,'' 投票的测试随机颜色的测试'',21,92,2,3,''2017-10-03 23:25:07''),(34,NULL,''这是一个多选的投票这是一个多选的投票这是一个多选的投票'',''2017-10-04 02:58:16'',NULL,''这是一个多选的投票'',21,16,2,4,''2017-10-04 02:58:15''),(35,NULL,''想去哪个地方，尽情发言，，，，，，，反正我们也不会去的，<img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" />'',''2017-10-04 03:19:52'',NULL,''旅欧地点投票，单选'',21,24,2,5,''2017-10-04 03:19:52''),(37,NULL,''未开始时间投票测试未开始时间投票测试未开始时间投票测试'',''2017-10-04 15:27:36'',NULL,''xiugai ；未开始时间投票测试'',21,24,2,7,''2017-10-04 18:05:52''),(38,NULL,''dfasfsdfafdsfsfasddddddddddddddddddd222'',''2017-10-04 16:01:49'',NULL,''修改d  ;我知道能够修改成功,在修改依稀呢？'',21,10,2,8,''2017-10-04 18:03:16''),(39,NULL,''333333333333333333333333333333333333333333333333333333'',''2017-10-05 22:54:27'',NULL,''电风扇'',21,1,2,9,''2017-10-05 22:54:26''),(40,NULL,''<h2>\r\n	这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234\r\n</h2>'',''2017-10-05 22:57:41'',NULL,''这是投票11234'',21,2,2,10,''2017-10-05 22:57:41''),(41,NULL,''4555555555555555555555555555555555555555555'',''2017-10-05 22:58:29'',NULL,''手动阀123'',21,3,2,11,''2017-10-06 17:03:53''),(42,NULL,''4444444444444这是投票11234这是投票11234'',''2017-10-05 23:17:52'',NULL,''大师傅'',20,4,7,NULL,''2017-10-05 23:17:52''),(43,NULL,''188@qq.com188@qq.com188@qq.com188@qq.com188@qq.com188@qq.com'',''2017-10-05 23:25:50'',NULL,''范德萨'',21,2,7,12,''2017-10-05 23:25:50'');

/*Table structure for table `oa_evection` */

CREATE TABLE `oa_evection` (
  `evection_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`evection_id`),
  KEY `FKql1c10e5u2vefisjqjbu2d5pa` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_evection` */

insert  into `oa_evection`(`evection_id`,`type_id`,`pro_id`,`personnel_advice`,`manager_advice`) values (1,28,12,NULL,''发发发''),(2,28,21,NULL,NULL),(3,28,22,NULL,NULL),(4,28,23,NULL,NULL);

/*Table structure for table `oa_evectionmoney` */

CREATE TABLE `oa_evectionmoney` (
  `evectionmoney_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `financial_advice` varchar(255) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `money` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `pro` int(255) DEFAULT NULL,
  PRIMARY KEY (`evectionmoney_id`),
  KEY `FKcpuubnshaf2cg47hns9m0h1dq` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_evectionmoney` */

insert  into `oa_evectionmoney`(`evectionmoney_id`,`financial_advice`,`manager_advice`,`money`,`name`,`pro_id`,`pro`) values (1,NULL,''去项目支持'',1100,''刘敏'',10,NULL),(2,''批准'',''情况属实！！！！'',2800,''刘敏'',11,NULL),(3,NULL,'''',940,''得到'',24,23);

/*Table structure for table `oa_file_list` */

CREATE TABLE `oa_file_list` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_shuffix` varchar(255) DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `path_id` bigint(20) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `file_user_id` bigint(20) DEFAULT NULL,
  `file_istrash` bigint(1) unsigned zerofill DEFAULT ''0'',
  `file_isshare` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FKfshy9n300pqxjsweo9247jgqs` (`path_id`),
  KEY `FKlj6l9qroivus28aiqluue4bew` (`file_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_file_list` */

insert  into `oa_file_list`(`file_id`,`file_name`,`file_path`,`file_shuffix`,`content_type`,`model`,`path_id`,`size`,`upload_time`,`file_user_id`,`file_istrash`,`file_isshare`) values (130,''cat-cat-face-cat-s-eyes-animal-323fbf7e29263055ebc5891435fefec4.jpg'',''/2020/03/罗密欧/8ce4e8e1-8713-45ec-b56f-fbda0c9fc123.jpg'',''jpg'',''image/jpeg'',NULL,NULL,2398027,''2020-03-28 00:02:02'',1,1,0);

/*Table structure for table `oa_file_path` */

CREATE TABLE `oa_file_path` (
  `path_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `path_name` varchar(255) DEFAULT NULL,
  `path_user_id` bigint(20) DEFAULT NULL,
  `path_istrash` bigint(20) DEFAULT ''0'',
  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_file_path` */

insert  into `oa_file_path`(`path_id`,`parent_id`,`path_name`,`path_user_id`,`path_istrash`) values (1,0,''根目录'',NULL,0),(6,1,''罗密欧'',1,0),(89,1,''无双'',10,0),(90,1,''甄姬'',7,0),(91,90,''新建文件夹'',7,0),(92,91,''新建文件5夹'',7,0),(93,1,''于彤'',13,0),(94,6,''test'',1,0);

/*Table structure for table `oa_holiday` */

CREATE TABLE `oa_holiday` (
  `holiday_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `leave_days` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`holiday_id`),
  KEY `FK1glo2wpb4kuiop1ymjxs0knxj` (`pro_id`),
  CONSTRAINT `FK1glo2wpb4kuiop1ymjxs0knxj` FOREIGN KEY (`pro_id`) REFERENCES `oa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_holiday` */

insert  into `oa_holiday`(`holiday_id`,`leave_days`,`type_id`,`pro_id`,`manager_advice`,`personnel_advice`) values (1,2,38,16,''准假'',NULL),(2,1,37,25,''as电饭锅'',''as电饭锅和'');

/*Table structure for table `oa_in_mail_list` */

CREATE TABLE `oa_in_mail_list` (
  `mail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail_content` text,
  `mail_create_time` datetime DEFAULT NULL,
  `mail_file_id` bigint(20) DEFAULT NULL,
  `mail_title` varchar(255) NOT NULL,
  `mail_type` bigint(20) DEFAULT NULL,
  `mail_in_push_user_id` bigint(20) DEFAULT NULL,
  `in_receiver` varchar(255) DEFAULT NULL,
  `mail_status_id` bigint(20) DEFAULT NULL,
  `mail_number_id` bigint(20) DEFAULT NULL,
  `mail_del` int(11) DEFAULT NULL,
  `mail_push` int(11) DEFAULT NULL,
  `mail_star` int(11) DEFAULT NULL,
  PRIMARY KEY (`mail_id`),
  KEY `FK33o7j8f0xk8n8vrk576iktglc` (`mail_file_id`),
  KEY `FK933q7ouoddu584qg08rbvwvxi` (`mail_in_push_user_id`),
  KEY `FKghibt111d1yvc3f02x06sihjp` (`mail_number_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_in_mail_list` */

insert  into `oa_in_mail_list`(`mail_id`,`mail_content`,`mail_create_time`,`mail_file_id`,`mail_title`,`mail_type`,`mail_in_push_user_id`,`in_receiver`,`mail_status_id`,`mail_number_id`,`mail_del`,`mail_push`,`mail_star`) values (2,''<p>\r\n	咕咕咕咕\r\n</p>\r\n<p>\r\n	一月又一月\r\n</p>'',''2017-09-28 19:40:05'',48,''啊啊啊啊'',16,1,''朱丽叶'',20,NULL,0,1,0),(3,''<p>\r\n	哈哈哈哈或\r\n</p>\r\n<p>\r\n	哈哈哈哈或或\r\n</p>'',''2017-09-28 20:08:25'',NULL,''啊啊啊啊啊'',16,1,''664303632@qq.com'',20,1,0,1,0),(4,''<p>\r\n	的点点滴滴多多多多\r\n</p>\r\n<p>\r\n	咯咯咯咯咯过过过\r\n</p>\r\n<p>\r\n	哈哈哈哈或或或或\r\n</p>'',''2017-09-28 21:24:39'',49,''趣味体育活动当天的决定'',16,1,''1533047354@qq.com'',20,1,0,1,0),(5,''反反复复付'',''2017-09-28 21:27:45'',50,''多对多'',16,1,''伊丽莎白'',20,NULL,0,1,0),(6,''凄凄切切群群群群群'',''2017-09-28 21:30:40'',51,''凄凄切切'',16,1,''1057245260@qq.com'',20,1,0,1,0),(7,''<p>\r\n	咯咯咯咯咯\r\n</p>\r\n<p>\r\n	哈哈哈哈或\r\n</p>'',''2017-09-28 21:37:44'',52,''凄凄切切'',16,1,''1533047354@qq.com'',20,1,1,1,0),(8,''沉浸在这美好的安然中，你会喜欢上这最绚丽的色彩，爱上这段沉静的时光，恋上这份清怡的静美。'',''2017-09-28 21:46:48'',53,''试试'',16,1,''1057245260@qq.com；1533047354@qq.com'',20,1,0,1,0),(9,''<p>\r\n	沉浸在这美好的安然中，你会喜欢上这最绚丽的色彩，\r\n</p>\r\n<p>\r\n	爱上这段沉静的时光，恋上这份清怡的静美。\r\n</p>'',''2017-09-28 21:53:25'',54,''试试'',16,1,''1057245260@qq.com;1533047354@qq.com'',20,1,0,1,0),(10,''<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">他便过来抱着我说：“孩子，爸爸也想给你一个妈妈。”可是，爸爸真的做不到。</span>\r\n</p>\r\n<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">爸爸会尽力像妈妈一样的爱你。我总是能从他的眼里看到晶莹闪光的东西，想掉又掉不下来。</span>\r\n</p>\r\n<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">那一年我四岁半,似懂非懂的点点头，迎合着我唯一能抓住的亲人。</span>\r\n</p>'',''2017-09-28 22:00:37'',55,''再试试'',16,1,''1533047354@qq.com;1057245260@qq.com'',20,1,1,1,0),(11,''<a href=\"http://www.jj59.com/zti/tongnian/\" class=\"keywordlink\">童年</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">的时光总是很短暂，最</span><a href=\"http://www.jj59.com/zti/kuaile/\" class=\"keywordlink\">快乐</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">的几年都在恍惚的小学中度过了，那个时候学习没有什么压力，爸爸每天忙着赚钱。基本上也不怎么过问我的功课，但是只要我成绩下来了。就一定尝到劈头盖脸的一顿臭骂。无论他怎么忙，每天下班回家一定陪我，周末的</span><a href=\"http://www.jj59.com/zti/time/\" class=\"keywordlink\">时间</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">全是我的。所以，我放学就可以和朋友尽情玩耍。白天有同学陪，放学有爸爸陪。渐渐的也就忘却了妈妈的存在。随着时光的推移也就理解了爸爸口中的遥远是什么含义。</span><br />\r\n<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\"> </span>'',''2017-09-28 22:03:46'',56,''咯咯咯咯咯过过过'',16,1,''1533047357@qq.com;1057245260@qq.com'',20,1,0,1,0),(12,''<span style=\"color:#111111;font-family:Arial, Helvetica, sans-serif;font-size:14px;background-color:#FFFFFF;\">最近有个朋友生日，聚会上有人送了他一对精致的杯子做礼物，据说这对杯子做工质地讲究，连配图都出自绘画大师之手。然而，就在朋友得知这对杯子价格近千块的时候，他直接炸了：“不就是个盛水的东西，跟我用的十块钱的玻璃杯有什么区别？这俩杯子哪里值千多块钱啊！</span>'',''2017-09-28 22:20:12'',57,''最后一次'',16,1,''1533047354@qq.com;1057245260@qq.com'',20,1,0,1,0),(13,''发发发发发发付或或或'',''2017-09-29 13:57:20'',NULL,''大家点击度假酒店'',16,1,''朱丽叶;伊丽莎白'',20,NULL,0,1,0),(15,''通过副本'',''2017-09-29 19:53:52'',NULL,''根本'',16,2,''罗密欧'',20,NULL,1,1,0),(16,''<p>\r\n	我去复制一段话来\r\n</p>\r\n<p>\r\n	<span style=\"color:#404040;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">1953年秋天，27岁的赫夫纳向亲友借了8000美元，花500美元买下梦露半裸照的版权，创办了《花花公子》</span>\r\n</p>'',''2017-09-29 22:09:52'',58,''我自己这边发的'',16,1,''1057245260@qq.com;664303632@qq.com'',20,1,0,1,0),(17,''儿歌个TV登革热vgt'',''2017-09-30 15:52:07'',NULL,''私事客服'',16,2,''伊丽莎白;小李父斯基'',20,NULL,0,1,0),(18,''柔柔弱弱'',''2017-09-30 16:24:46'',NULL,''呃呃呃'',18,2,''罗密欧'',20,NULL,1,1,0),(19,''哈哈不过'',''2017-09-30 17:02:22'',NULL,''得到'',16,2,''小李父斯基'',21,NULL,0,1,1),(20,''闺女胡'',''2017-09-30 17:04:19'',NULL,''嘉年华'',16,2,''朱丽叶'',22,NULL,0,1,0),(21,''房地产和好'',''2017-09-30 17:26:05'',NULL,''办法VSX'',16,2,''朱丽叶'',20,NULL,1,1,0),(22,''还好吧GV'',''2017-09-30 21:01:57'',NULL,''密密麻麻'',16,2,NULL,20,NULL,0,0,1),(23,''发v'',''2017-10-01 12:46:44'',59,''信息'',16,2,''罗密欧;朱丽叶'',20,NULL,0,1,0),(24,''得出'',''2017-10-01 12:47:15'',NULL,''就你那'',17,2,''朱丽叶;伊丽莎白'',22,NULL,0,1,0),(25,''反复发热的是v车<br />\r\n<hr />\r\n调查色粉'',''2017-10-01 16:59:41'',NULL,''【回复】发v显示'',16,1,''朱丽叶;罗密欧'',20,NULL,0,1,0),(26,''湖不过均'',''2017-10-01 12:48:07'',NULL,''客家话'',16,2,''朱丽叶;伊丽莎白'',20,NULL,0,1,0),(27,''护肤措施'',''2017-10-01 12:48:25'',NULL,''举横幅'',16,2,''朱丽叶;伊丽莎白'',20,NULL,0,1,0),(28,''高铁都不'',''2017-10-01 12:48:46'',NULL,''好一点v'',16,2,''小李父斯基;soli;红之花'',20,NULL,0,1,0),(29,''谷朊粉'',''2017-10-01 12:49:10'',NULL,''共同市场'',16,2,''伊丽莎白;soli'',20,NULL,0,1,0),(30,''柔肤水过一遍'',''2017-10-01 12:49:33'',NULL,''枯黄的'',16,2,''朱丽叶;伊丽莎白;soli;红之花'',20,NULL,0,1,0),(32,''包含'',''2017-10-01 14:36:12'',NULL,''包含'',18,1,''朱丽叶;伊丽莎白'',22,NULL,0,1,0),(33,''<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;八月的夜空，月色清明，云彩轻扬；八月的芳草地，花香迷朦，一池秋水清浅温婉。在花开花谢的流转里，时光坐在月色背后，冷艳如初。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; ——题记\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月光开始沉醉，起初，只是一抹淡淡的凝脂色，夜色宁静，慢慢明亮，圆润。像极了伊宁静盈暖的眼眸。七夕刚过，夜带着神秘的气息，薄薄的云彩，清透含蓄。抬头寻找，记忆中的渺渺银河，偌大的天宇，两三点星光，若隐若无，温柔的隔海相望。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月光总是太美，让人遐想，让人怜爱。夏天的花影，次第流转，清风明月思年华，而爱情总是太美，遥远如星空，茫茫人间，有烟火色便为红尘，遇见，爱上，一生何求？\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 如果可以，有一片海可以穿越爱的极限，我愿意，与你一同前往。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 轻拨心灵的琴弦，远处，是否有伊在轻轻和奏？\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	<img src=\"https://www.yueduwen.com/uploads/allimg/c1408/140920921250-H521.jpg\" /><span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 爱是感动，爱是相守，爱是牵挂，爱是月光里最美的诗行。我知道，有一片天空，始终有我的等待，那是你的方向。只是，天涯咫尺，我只能执手泪眼问相思。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 用心把远方托付给远方，把故事深藏在星光深处。那些苦涩的回忆不是忧伤，那甜美的记忆已成芬芳，是我幸福的奢华，余有暗香。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 恬淡，遥远。像今夜的月亮。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 我还站在昨天的月光里，用心轻吻一朵月色下的玫瑰。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 今夜的月光是行走的思念，静静与我，相守。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 内心，一半是海水的潮湿，一半是火焰的炽热。守在月色下，开始朝着你的方向一路飞奔，把爱放在温热的掌心，一路小心的呵护，担心遗落在风雨中。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月下的人间，盛开一条河流，我坐在河对岸，静静祈祷，相思过去，一切如旧，不曾挑明，只是以一种形式的相守，坚守你我的这份爱。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 就像今晚的月亮，这么明亮，这么清澈，是你么，带着温暖的耳语，仿佛遥远，又近在咫尺。\r\n</p>'',''2017-10-01 15:21:25'',NULL,''的放入他'',16,1,''朱丽叶'',20,NULL,0,1,0),(34,''发发发通天塔<br />\r\n<hr />\r\n反复发热的是v车<br />\r\n<hr />\r\n调查色粉'',''2017-10-01 17:16:14'',NULL,''【回复】【回复】发v显示'',16,1,''朱丽叶'',20,NULL,0,1,0),(35,''给你<br />\r\n<hr />\r\n发v'',''2017-10-01 17:24:15'',NULL,''【转发】信息'',16,1,''朱丽叶'',20,NULL,0,1,0),(37,''<table width=\"100%\" style=\"padding:0px;margin:0px;color:#333333;font-family:Helvetica, Arial, sans-serif;font-size:16px;background-color:#FFFFFF;\">\r\n	<tbody>\r\n		<tr>\r\n			<td>\r\n				<div id=\"contentMidPicAD\" style=\"padding:0px;margin:0px;vertical-align:top;\">\r\n				</div>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					<img alt=\"唯美图片爱情\" src=\"https://www.yueduwen.com/uploads/allimg/1702/1-1F226213T1602.jpg\" />\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					太过用力，会纠缠于内心，会让所有的饱满太过张力，是一张拉满了的弓，射得一定远吗?怕是会断掉。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					一场情事，泼墨太多了，用力太猛了，自己都收不住。洪水泛滥的结果是将自己淹没了。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					也许好的爱情应该是云淡风轻，安静地看着对方，对方是自己的一块清新的糖，想起时，安静地抿一下，就够了，有的时候，爱情需要距离，需要空间。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱上一个人，总会动荡些时日，半夜跑去写情书，私情这东西总怕沉溺。但不沉溺又是错的。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱这个人，哪怕知道他坏他烂，可是，因为贪恋这人世间的一点点爱一点点温暖，便飞蛾一样，扑向了火。这一场盛宴，是一个人的盛宴，与现实的爱情如此格格不入，不温暖，不体贴，不妥当，带着罂粟的邪恶与放荡——但她一意孤行，一定要一意孤行。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最坚固的爱情是懂得一个人的灵魂与心，就像杨绛懂得钱钟书，这种懂得，似读一本值得读的好书，读一生，也不会倦。而他们的用力，是持续的温度，是持续的力度，一直是这样，不高，不低，不温，不火。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					用力地爱一个人，趁着还有一颗爱的心，其实是幸福——哪怕最后碎了灭了，而心里，永远会有这个人，永远会有。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					女人总对事物有所迷恋，而迷人比迷东西更诱人。大体说来，一是迷恋衣服，二是迷恋男人。衣服和男人同时到来，则男人第一。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱情是最不实用的东西，伤筋动骨的，不如迷恋别的东西实惠。迷恋这个东西，带着痴的成分，爱情这个东西，当个点缀时还好，可是，一用力起来就会盛大，又惊心动魄又无聊。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					太浓烈的爱情，来得快，一定去得也快。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱情原来是有条件的，原来是和别的气氛在一起的——特别是人前，如果感觉到他们在相爱，一个眼神就足够了。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最干净的爱情，一定清淡似水，应该浓烈时浓烈，应该清淡时就清淡。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					只剩下爱情，一定离分手很近了，因为再也没有别的话——有趣的爱情，是和趣味、气味、气场相互联系的，比如两个人的共同爱好，哪怕一起爱上美食，其实最后拼的是生活习惯和灵魂距离。如果单纯色相吸引，爱情最难维持，时间最短的爱情一定是一见钟情——只凭貌相，那样的爱情过于单薄，连维持下去都要努力。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最厚实的爱情，一定是踏实肯定，连缺点也要喜欢，连习惯都雷同，爱到忘记了爱是怎么回事，只记得他爱吃茴香馅，她爱穿安瑞井……如果只是为爱而爱，哪怕私奔到天涯，一定还要离散。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱一个人，需要傻到没有自己，和爱情相比，自己太轻了，太单了，太势孤了，而只有爱情，可以让人焕发了光彩，那样的熠熠夺目，是自己没有过的样子。就像张中行老先生说，还是男女之情最有意思。因为像鸦片，有瘾，有毒，离不了，忘不了，相互吸引，又相互刺痛。\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>'',''2017-10-01 19:39:14'',60,''来了'',16,1,''664303632@qq.com；1057245260@qq.com'',20,1,0,1,0),(42,''咕咕咕咕拖拖拖拖多多多多多'',''2017-10-01 20:29:51'',NULL,''点点滴滴'',16,1,''1057245260@qq.com'',20,1,0,1,0),(43,''麻烦得很'',''2017-10-02 14:49:56'',61,''给你给你'',16,1,''1071766245@qq.com'',20,1,0,1,0),(44,''<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	在一档电视节目中，主持人问马云，如果人生可以重来，你有什么遗憾需要弥补?马云淡淡地说，我的人生一切都刚刚好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	这样的回答，可以说是自信，因为一切都恰到好处;也可以说是知足，因为没有留下遗憾。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	一切都刚刚好，这话说出来简单，做起来却大不易。什么叫刚刚好，理性一点说就是适度。什么叫度，理科老师告诉你，度就是一定事物保持自己质的数量界限，比如说冰点、熔点、沸点;文科老师告诉你，度就是事物所达到的境界，比如说高度、风度、气度。在《登徒子好色赋》中，宋玉用两个排比句，来描述东邻女孩的美貌：增之一分则太长，减之一分则太短;着粉则太白，施朱则太赤。这话听起来有些夸张，其实不过是说这个女孩长得恰如其分，刚刚好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	世间一切事物，都是由过程表现出来的，这个过程无非是由量变到质变，由渐变到突变。变与不变的节点就是度。作为人生哲学的度，则是指在做人处世中拿捏的分寸，掌握的火候，遵循的法则。这种度，不是衡器测量出来的，而是用心掂量出来的。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	古代圣贤留给我们的人生智慧和哲理很多，以至于穷其一生也未必都能学完、用好，但若看多了、悟透了，就会觉得，大道至简，道法自然，归根结底不过两个字：适度。就是说，凡事有度，适可而止，过犹不及，物极必反。即便是优点，过了头也会坏事;即便是美德，过了头也会显得不美;只有恰到好处，才会趋于完美。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	比方说，性情耿直的人心直口快是优点，倘若不注意场合与对象，出言不逊，出口伤人，就会让人讨厌。蔡明表演的以“毒舌”为语言特征的小品，为什么会一再登上央视春晚舞台，并非人们喜欢“毒舌”，而是因为她塑造的“毒舌”，形象惟妙惟肖，语言尖酸刻薄，对缺乏口德者的讽刺力度入木三分，从而使人们在爆笑的同时，更加讨厌“毒舌”，远离“毒舌”，也能让那些以“刀子嘴豆腐心”自诩的人反观自照，明心见性，在社会交往中不再以“毒舌”相向。即便以“毒舌”显示幽默，也要看对方的接受能力，顾及他人的尊严。\r\n</p>'',''2017-10-02 14:55:07'',NULL,''多对多多对多多'',16,1,''1071766245@qq.com'',20,1,0,1,0),(45,''<table width=\"100%\" style=\"padding:0px;margin:0px;color:#333333;font-family:Helvetica, Arial, sans-serif;font-size:16px;background-color:#FFFFFF;\">\r\n	<tbody>\r\n		<tr>\r\n			<td>\r\n				<div id=\"contentMidPicAD\" style=\"padding:0px;margin:0px;vertical-align:top;\">\r\n				</div>\r\n<img alt=\"\" height=\"441\" src=\"http://www.yueduwen.com/uploads/allimg/c170225/14X01CI261Z-1131J.jpg\" width=\"590\" />\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					他一岁的时候，父亲被打成右派，被送进江西某农场劳动改造。他的母亲是一名小学教师，因为身边还带着大他一岁的哥哥，母亲自知没有多余的精力把他拉扯成人。就在一个雨夜，母亲怀抱着他，把他托付给原来的老邻居，即他日后经常挂在嘴边的张公张婆。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					张公是安徽人，人长得高大，心地善良，日本侵华时，他挑着担子，逃难来到湖南沅陵麻溪铺。张公的左脚就是在逃难时被日本飞机丢响的炸弹震坏的，因此，走起路来，一颠一颠的。保姆婆是从凤凰逃难到本地，当年她只有十五岁。两位苦难的人在异乡相依为命，他们一生没有生育。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					在麻溪铺镇上，临着街，张公和张婆拥有一间不大的屋子，那屋子由裱有报纸的隔板分成两小间。靠外的一间，是现代意义上的客厅。中间有一个火塘，火塘上有一个木架，常年挂着几排黑乎乎的东西，那是当地人喜欢的腊肉。在隆冬季节，大雪封山的日子，张婆会切下一段腊肉，把肉皮在炭火上烧烤。几分钟，洗出来之后，黑色的肉皮就变成黄金糕的颜色了。腊肉的香味极具诱惑。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					靠里那一间，他和张公张婆挤在一张木板床上，怕他半夜摔下来，老人让他睡在中间。那屋子下雨时漏雨，刮风时透风。于是，张公就在屋顶扯起一块塑料布。每逢下雨，瓦缝的水有节奏地滴进塑料布里，发出嗒—嗒—嗒—的声音。南方雨水多，那嗒嗒嗒的雨声就成了他的催眠曲。为了防止泥巴地发潮，张公张婆在那木板床的下面，塞满了黑乎乎的木炭，果木的清香残留在木炭的骨子里，伴着他一天天长大成人。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					转眼，他六岁了，到了读书的时候。有一天，张公拿过他削得尖尖的铅笔说，崽呀，这铅笔你若削尖了，一用力就断了，很浪费。张公示范着说，铅笔只要用菜刀把木头削掉，露出铅笔芯就可以写字了，这样既节省又不易折断。他一直按照张公的办法去做，以至于现在不仅能写得一手好字，关键是字粗而且大，极易辨认。在每一个小鸟啼叫的早晨和炊烟袅袅的黄昏，像吊死鬼儿一样贴在他屁股上的黄色书包里，除了几本卷了角的书本，就是一支秃头秃脑的铅笔。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					张婆做得一手好菜。当他还没有灶台高的时候，张婆搬来一个高脚竹椅子摆在灶台边，把他抱上去，他就趴在灶台上，看张婆怎样炒菜，怎样放佐料。他打小就明白了切菜的刀功极为重要，也懂得炒菜的时候哪些应该盖锅盖，哪些菜是不需要盖锅盖的。在每一道菜出锅的时候，他记得张婆都会用洁白的抹布在碗口边缘擦一圈，残留的痕迹便不复存在了。张婆常说，孔夫子不吃豆腐，吃东西讲究色香味，讲究刀法，老祖宗留下的够我们一辈子去学。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					如今，他做饭做得可口，全家人都跟着他享口福。看到全家老小一脸享受地吃着他做的饭菜，他一脸的幸福。他夹一口菜，刨一口饭，敲一下碗边儿，嗯，可以，可以，这味道可以。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					距离张公张婆的屋不远，有一所女子中学，张公是那学校的校工。当时的学校，没有电铃，上课下课，都是靠敲钟。张公就是那敲钟的人。钟也不是什么好材料做的，是一个长锈的铁环，用麻绳系着，挂在一根房梁上面。\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>'',''2017-10-06 11:02:49'',62,''最后一试'',16,1,''1057245260@qq.com'',20,1,0,1,0),(46,''<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	<img alt=\"\" src=\"https://www.yueduwen.com/uploads/allimg/1705/1-1F520161G2E9.jpg\" /><img src=\"https://www.yueduwen.com/uploads/allimg/1705/1-1F520161G2E9.jpg\" />\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	去岁盛夏返乡，时近黄昏，禽鸟归巢，晚风吹拂，我独自漫步在房前不远处的三米宽的水泥质地镶有不锈钢围栏的小桥上。桥下流水潺潺，清澈见底。举目四望，满眼青翠，一片碧绿：周围稻田碧浪翻滚，稻穗飘香;稍远处玉米吐穗，绿叶婆娑;远处青山含黛，松柏飘香。白练似的水泥小路盘旋乡间逶迤远方，随之一同飘去的还有我的一片思绪。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	小时候，穿过一条狭窄蜿蜒的田埂来到小河边，就见一座木石结构的小桥横跨河上。小桥宽约两米，长有丈余，全桥由三根直径约二十公分的柏树为基底，上以质地坚硬的青石板严密覆盖，下有两根柏木立柱在河中支撑。我们村两个组的近三百群众都要通过该桥来往，去到对岸的碎石公路，走向远方。印象中，小桥从我记事起就一直存在，它是我们对外联系的纽带。尽管它外形单调，结构简单，却十分坚固，即使人们牵着体型硕大的黑水牛从上面悠然走过也安然无恙，而且还经受住了几次巨大洪水冲击的考验呢。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	童年的夏天，好像比现在还要炎热许多，蝉也叫得特别响亮，我和小伙伴们常在桥下游泳，河中嬉戏。有时仰头看着小桥，感觉它无比高大雄伟。如果有人敢站在桥上做出各种姿势往下跳水，常会赢得孩子们的无比羡慕和大声喝彩。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	小桥也是通向对岸外婆家的唯一大道，傍晚回家，外婆家的大黄狗必要送我回来。让我百思不得其解的是，大黄狗每次都是把我送到小桥边就默默离去了，从来不越雷池半步，好像它对桥心存敬畏，很放心把我交给小桥似的。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	遗憾的是，我长大成年了，小桥却衰老了。年久失修，上面的青石板风化掉落得厉害，最后只剩下三根孤零零的朽木了，大人们在上面还能如履平地，年幼的孩子们就惨了，很多只能在上面缓缓爬行，战战兢兢，如履薄冰。又过了一年，小桥的通过能力几乎完全丧失，大人们也早将关注的重点转移到了农作上，忙于打理自家的承包地。再加上雨水连年减少，河床干涸见底，河底裂纹密布，人们下河底爬河堤也不甚费力，小桥就渐渐被人们遗忘了，最后就连几根枯朽的柏木也不见踪影，可能是被村民扛回去作柴禾了吧。河水充盈时，人们往往行走于集体夯筑的土堰上，但不得不面对土堰随时崩塌的危险。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	一年夏天，暴发了三十年未遇的特大洪水。顷刻间，一切堤堰土崩瓦解，想要出行十分困难，况且还有许多农产品要运出去许多农资要运进来呢。人们这才认识到架座小桥的必要性，于是乎发动群众，有钱出钱，有力出力，准备建一座有两个桥墩的水泥板桥。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	乡民的本性始终是淳朴良善的，认为修桥补路是积德行善，都踊跃出钱出力，很快前期准备就完成了。修桥由经验丰富的老石匠亲自掌墨，开始挖基脚，抬石头，拌水泥，砌桥墩，搭桥板。老石匠认为这可能是自己人生最后一件大作品，认真到了严苛的程度，所谓慢工出细活，这桥修了近半年之久。看到这座新落成的水泥板桥，听到人们的啧啧称赞，老石匠就好像看着自己的刚出生的孩子，高兴得裂开干瘪的嘴唇，嘿嘿地笑出声来。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	这一下，新桥很快就成了人们聚集谈天的场所。盛夏的夜晚，在桥上休憩纳凉的人语声久久不绝，争相述说着生活的美好;严冬的中午，沐浴暖阳的人笑声不断，竞相谈论着故乡的变迁。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	后来，村民个人集资，再加上国家补贴，开始将小桥两边安上不锈钢栏杆，并将穿过小桥两边的乡间小道拓宽硬化，通到家家户户，大大方便了人们出行。远在他乡多年未归的游子也纷纷驾车返乡，当漂亮舒适的轿车轻吻小桥时，他们说分明听到了小桥的咯咯笑声，好像是独自在家的慈母在热烈欢迎久别孩子的归来。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	突然“滴——滴——”声起，将我的思绪拉回眼前，原来是阔别多年的儿时好友晓敏在打招呼。我俩就在桥头攀谈起来，诉说着各自的生活和家乡的美好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	此时，夜色渐浓，小桥无语。是啊，故乡的小桥不仅见证了家乡由贫穷到富裕的发展变化，见证了家乡人们从奔波到闲适的生活，也必将见证家乡不可限量的辉煌未来。\r\n</p>'',''2017-10-07 21:51:26'',NULL,''ssss'',16,1,''1057245260@qq.com'',20,1,0,1,0),(47,''发发发发发发付付付'',''2017-10-16 17:17:51'',69,''啛啛喳喳'',16,18,''甄嬛;无双'',20,NULL,0,1,0),(48,''多对多'',''2017-10-16 17:42:16'',70,''多对多'',16,1,''无双'',20,NULL,0,1,0),(49,''少时诵诗书所所所所所'',''2017-10-18 17:45:16'',72,''少时诵诗书'',16,1,''1057245260@qq.com'',20,1,0,1,0);

/*Table structure for table `oa_love_discuss_user` */

CREATE TABLE `oa_love_discuss_user` (
  `discuss_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`discuss_id`,`user_id`),
  KEY `FKkl0fitgg3qixkg5gg9mmjp5e7` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_love_discuss_user` */

insert  into `oa_love_discuss_user`(`discuss_id`,`user_id`) values (8,1),(12,1),(15,1),(33,1),(7,2),(12,2),(13,2),(33,2),(37,2),(38,2),(39,2),(33,3),(33,7),(13,8);

/*Table structure for table `oa_love_user` */

CREATE TABLE `oa_love_user` (
  `reply_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK7fv96y8gbqcnb44qao4ey4rmn` (`user_id`),
  KEY `FKcuptpmm0l1e0b9pjv0xksqqai` (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_love_user` */

insert  into `oa_love_user`(`reply_id`,`user_id`) values (7,2),(9,2),(6,1),(3,1),(2,1),(9,1),(16,1),(15,1),(14,1),(17,1),(18,1),(62,2),(61,2),(67,2),(4,2),(2,2),(2,2),(3,2),(3,2),(60,2),(68,2),(69,2),(72,2),(72,2),(73,2),(73,2),(59,2),(59,2),(59,2),(59,2),(59,2),(59,2),(73,8),(73,1),(89,1);

/*Table structure for table `oa_mail_reciver` */

CREATE TABLE `oa_mail_reciver` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_read` int(11) NOT NULL,
  `mail_id` bigint(20) DEFAULT NULL,
  `mail_reciver_id` bigint(20) DEFAULT NULL,
  `is_star` int(11) DEFAULT NULL,
  `is_del` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FKj8ki52vm052q6qdal2rkh2c9q` (`mail_id`),
  KEY `FK65vdrbmq9hu4hrhvtw6slwxlc` (`mail_reciver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_mail_reciver` */

insert  into `oa_mail_reciver`(`pk_id`,`is_read`,`mail_id`,`mail_reciver_id`,`is_star`,`is_del`) values (3,1,5,3,0,0),(5,0,13,3,0,0),(6,1,15,1,0,0),(7,1,18,1,0,0),(8,0,19,4,0,0),(10,1,21,2,1,0),(11,1,23,1,0,0),(12,0,23,2,0,0),(13,0,24,2,0,0),(14,0,24,3,0,0),(15,1,25,1,0,0),(16,0,25,2,0,0),(17,0,25,4,0,0),(18,0,26,2,0,0),(19,0,26,3,0,0),(20,0,27,2,0,0),(21,0,27,3,0,0),(22,0,28,4,0,0),(23,0,28,5,0,0),(24,0,28,6,0,0),(25,0,29,3,0,0),(26,0,29,5,0,0),(27,0,30,2,0,0),(28,0,30,3,0,0),(29,0,30,5,0,0),(30,0,30,6,0,0),(31,0,32,2,0,0),(32,0,32,3,0,0),(33,0,33,2,0,0),(36,1,34,2,0,0),(37,1,35,2,0,0),(38,0,47,9,0,0),(39,0,47,10,0,0),(40,0,48,10,0,0);

/*Table structure for table `oa_mailnumber` */

CREATE TABLE `oa_mailnumber` (
  `mail_number_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail_account` varchar(255) NOT NULL,
  `mail_create_time` datetime DEFAULT NULL,
  `mail_des` varchar(255) DEFAULT NULL,
  `mail_type` bigint(20) DEFAULT NULL,
  `mail_user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` bigint(20) DEFAULT NULL,
  `mail_num_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mail_number_id`),
  KEY `FKn9qg20uba4xn2k5m62jrcyc6c` (`mail_num_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_mailnumber` */

insert  into `oa_mailnumber`(`mail_number_id`,`mail_account`,`mail_create_time`,`mail_des`,`mail_type`,`mail_user_name`,`password`,`status`,`mail_num_user_id`) values (1,''1057245260@qq.com'',''2017-09-24 12:23:26'',NULL,1,''宋佳'',''scdvszfjjfrpbeaa'',1,1),(2,''664303632@qq.com'',''2017-09-13 13:29:28'',NULL,1,''李明'',''123456'',2,1),(3,''ffffff'',''2017-09-22 14:02:51'',NULL,2,''ggg'',''33333'',1,1),(4,''66@qq.com'',''2017-09-24 18:26:31'',''的点点滴滴'',1,''私事'',''333'',1,1),(5,''66@qq.com'',''2017-09-24 18:27:26'',''的点点滴滴'',1,''哈哈哈哈'',''55555'',1,1),(6,''66@qq.com'',''2017-09-24 18:37:06'',''的点点滴滴'',1,''滚滚滚'',''55555'',2,1),(8,''ggg'',''2017-09-28 20:33:06'',''hhh'',1,''llll'',''11111'',1,2),(9,''10@qq.com'',''2017-09-25 18:45:52'','''',1,''多对多'',''发vwv '',1,1),(10,''45@qq.com'',''2017-09-25 18:46:22'',''是是是'',1,''吗vwjrerg '',''14982'',1,1),(11,''1234@qq.com'',''2017-09-25 18:46:53'','''',1,''点点滴滴'',''dbetet'',2,1),(12,''12@qq.com'',''2017-09-25 18:47:15'','''',1,''反反复复'',''34455'',1,1),(13,''34@qq.com'',''2017-09-25 18:47:35'','''',1,''别发额'',''457895780'',1,1);

/*Table structure for table `oa_note_list` */

CREATE TABLE `oa_note_list` (
  `note_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(15000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `attach_id` bigint(20) DEFAULT NULL,
  `is_collected` bigint(20) DEFAULT ''0'',
  `createman_id` bigint(20) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `FK3e1rxyyg851r231ln3ucnrg7q` (`catalog_id`),
  CONSTRAINT `FK3e1rxyyg851r231ln3ucnrg7q` FOREIGN KEY (`catalog_id`) REFERENCES `oa_catalog` (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=210 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_note_list` */

insert  into `oa_note_list`(`note_id`,`content`,`create_time`,`status_id`,`title`,`type_id`,`catalog_id`,`attach_id`,`is_collected`,`createman_id`,`receiver`) values (1,''sdfa'',''2017-09-08 20:43:08'',8,''hg'',6,1,46,1,1,NULL),(90,''zxc'',''2017-09-07 19:12:07'',8,''90'',6,2,3,1,1,NULL),(93,''dfasf'',''2017-09-14 10:04:34'',9,''93'',6,1,3,1,1,NULL),(96,''哈哈'',''2017-09-15 11:01:08'',8,''这张图片必须显示96'',5,1,6,0,2,NULL),(101,''分享应该可以了吧'',''2017-09-15 20:11:23'',8,''666101'',7,1,10,1,2,NULL),(102,''快点老兄'',''2017-09-15 20:14:51'',8,''666102'',7,1,11,0,1,NULL),(111,''的说法'',''2017-09-15 23:53:04'',8,''地方撒111'',7,1,7,0,1,''小李父斯基''),(120,''dsaf'',''2017-09-18 11:04:48'',8,''werq 120'',5,1,9,1,1,NULL),(122,''dsaf但是'',''2017-09-18 11:06:24'',8,''修改122'',5,1,NULL,1,1,NULL),(126,''大'',''2017-09-23 11:43:05'',8,''地方撒发生126'',7,1,NULL,0,1,''soli;红之花''),(127,''dsfa'',''2017-09-23 12:34:05'',8,''dfsa的127'',5,1,NULL,1,1,NULL),(128,''sdaf'',''2017-09-23 12:37:21'',8,''dsa128'',6,1,42,1,1,NULL),(137,''第三方'',''2017-10-01 14:18:54'',8,''大师傅137'',7,1,NULL,0,1,'';伊丽莎白''),(138,''发多少'',''2017-10-01 14:30:48'',8,''分公司'',7,1,NULL,0,1,''伊丽莎白''),(139,''士大夫'',''2017-10-01 14:31:26'',8,''士大夫'',6,1,NULL,1,1,NULL),(140,''士大夫'',''2017-10-01 14:36:19'',8,''手动阀'',7,1,NULL,0,1,''伊丽莎白;小李父斯基''),(143,''发多少'',''2017-10-01 14:57:13'',8,''fdas '',7,1,NULL,1,1,'';发给''),(145,''fd'',''2017-10-01 16:01:33'',8,''fggfd'',5,1,NULL,0,1,NULL),(146,'''',''2017-10-01 16:02:51'',8,''新建发给'',5,1,NULL,1,1,NULL),(149,''地方撒1222222222222222'',''2017-10-01 17:50:20'',8,''范德萨'',5,1,NULL,0,1,NULL),(150,''士大夫1111111111111'',''2017-10-01 17:55:31'',8,''的是非得失'',5,1,NULL,0,1,NULL),(151,''更丰富付付付付付付付付付付付付付付付付'',''2017-10-01 18:06:21'',8,''华哥'',5,1,NULL,0,1,NULL),(152,''22222222222222222222'',''2017-10-01 18:09:32'',8,''地方撒'',5,1,NULL,0,1,NULL),(153,''1111111111111111111111'',''2017-10-01 18:11:05'',8,''大师'',5,1,NULL,0,1,NULL),(154,''222222222222222222222'',''2017-10-01 18:19:10'',8,''第三方'',5,1,NULL,0,1,NULL),(155,''哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或发凡方法付付'',''2017-10-01 18:25:10'',8,''过后会或或'',5,1,NULL,0,1,NULL),(156,''东方时尚所说付发的大多多多多多多多'',''2017-10-01 18:30:08'',8,'' 胡歌封帝'',5,1,NULL,1,1,NULL),(157,''东方时尚所所所所所所所所所'',''2017-10-01 18:35:07'',8,''咯咯咯咯咯滚滚滚'',5,1,NULL,0,1,NULL),(158,''333333333333333'',''2017-10-01 19:20:29'',8,''第三方'',5,1,NULL,0,1,NULL),(159,''2111111111111111111111111111'',''2017-10-01 19:38:13'',8,''的说法'',5,1,NULL,0,1,NULL),(160,''2222222222222222222222222'',''2017-10-01 19:42:55'',8,''的说法'',5,1,NULL,0,1,NULL),(161,''2222222222222222222222222222'',''2017-10-01 19:49:55'',8,''大方法'',5,1,NULL,0,1,NULL),(162,''43333333333333333333333333'',''2017-10-01 19:57:19'',8,''的说法'',5,1,NULL,0,1,NULL),(163,''444444444444444444444444444444444'',''2017-10-01 19:59:18'',8,''第三方'',5,1,NULL,0,1,NULL),(164,''55555555555555555555555555555555'',''2017-10-01 20:03:07'',8,''的说法'',5,1,NULL,0,1,NULL),(165,''3443242243333333333333'',''2017-10-01 20:05:10'',8,''范德萨'',5,1,NULL,1,1,NULL),(166,''22222222222222222222222222'',''2017-10-01 20:08:25'',8,''大对方是否收费'',5,1,NULL,0,1,NULL),(167,''3333333333333333333333'',''2017-10-01 20:17:13'',8,''发生的'',5,1,NULL,0,1,NULL),(168,''11111111111111111111111'',''2017-10-01 20:26:29'',8,''地方撒'',5,1,NULL,0,1,NULL),(169,''333333333333333333333'',''2017-10-01 20:26:58'',8,''第'',5,1,NULL,0,1,NULL),(170,''知道吗 这个世界 随处都有万有引力'',''2017-10-05 19:49:17'',8,''无语的n此房'',7,1,NULL,0,1,''罗密欧;甄姬''),(171,''11111111111111111111111111111111111'',''2017-10-05 20:19:31'',8,''的说法'',5,2,NULL,0,1,NULL),(172,''阿斯蒂芬三分333333333333'',''2017-10-05 20:23:02'',8,''地方撒'',5,2,NULL,0,1,NULL),(173,''(⊙o⊙)…334334'',''2017-10-05 20:23:27'',8,''的说法'',5,2,NULL,1,1,NULL),(174,''1321131314124'',''2017-10-05 20:25:30'',8,''三大东方'',7,2,NULL,0,1,''罗密欧;伊丽莎白''),(175,''213131对方是否收费 23'',''2017-10-05 20:27:17'',8,''范德萨23'',7,1,NULL,0,1,''罗密欧;伊丽莎白''),(176,''2222222222222222222222222222'',''2017-10-05 20:40:18'',8,''听说对方'',6,2,NULL,0,1,NULL),(177,''233333333333333333333333'',''2017-10-05 20:43:01'',8,''发生的发生'',7,2,NULL,0,1,''小李父斯基;soli''),(178,''2333333333333333333333333333333'',''2017-10-05 20:43:31'',9,''地方撒发生'',5,2,NULL,0,1,NULL),(179,''2333333333333333333333333333'',''2017-10-05 20:48:03'',8,''大三'',5,1,NULL,0,1,NULL),(180,''33333333333333333333333'',''2017-10-05 20:48:49'',8,''地方'',5,2,NULL,0,1,NULL),(181,''22222222222222222222222222222222'',''2017-10-05 20:50:57'',8,''33333333333333'',5,2,NULL,0,1,NULL),(182,''3333333333333333'',''2017-10-05 20:57:28'',9,''地方撒'',5,2,NULL,0,1,NULL),(183,''大师傅444444444444444444444'',''2017-10-05 21:01:41'',8,''的说法'',5,2,NULL,0,1,NULL),(184,''3333333333333333333333333333333333'',''2017-10-05 21:03:03'',8,''ad231'',5,2,NULL,0,1,NULL),(187,''44444444444444444444444444444444444444'',''2017-10-05 21:22:28'',8,''安抚第三方'',5,1,NULL,1,1,NULL),(188,''324242533333333333333333390'',''2017-10-05 22:48:20'',8,''大三'',5,1,NULL,0,1,NULL),(189,''dsafffffff555555555555555555555555'',''2017-10-06 11:15:14'',8,''dfas '',5,33,NULL,0,1,NULL),(190,''3333333333333333333333333333333333333'',''2017-10-06 11:23:34'',8,''sdfa '',5,33,NULL,0,1,NULL),(191,''222222222222222222222222222222222222222222222222'',''2017-10-06 11:29:14'',8,''34242423'',5,33,NULL,0,7,NULL),(192,''2323232323232323232323232323232323'',''2017-10-06 22:29:33'',8,''发给'',5,33,NULL,0,1,NULL),(193,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/IT/16684878\">IT</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Applet\">Applet</a><i>（Applet是一种将小程序嵌入到网页中进行执行的技术）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，并将Oak更名为Java</span>'',''2017-10-06 22:32:04'',8,''最终版本'',7,33,81,0,1,''丹琪;于彤''),(194,''444444444444444444444444444444'',''2017-10-07 16:03:03'',8,''有附件'',5,33,64,0,1,NULL),(195,''322222222222222222222222222222222222222222222'',''2017-10-07 20:14:48'',9,''范德萨'',6,33,NULL,0,23,NULL),(196,''<a target=\"_blank\" href=\"https://baike.baidu.com/item/Java/85979\">Java</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">是一门</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1\">面向对象</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">编程语言，不仅吸收了</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/C%2B%2B\">C++</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">语言的各种优点，还摒弃了C++里难以理解的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%9A%E7%BB%A7%E6%89%BF\">多继承</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8C%87%E9%92%88\">指针</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[1]</span><a name=\"ref_[1]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。</span>'',''2017-10-08 16:22:44'',8,''上课要义'',5,33,77,0,1,NULL),(198,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">由于在开发Oak语言时，尚且不存在运行字节码的硬件平台，所以为了在开发时可以对这种语言进行实验研究，他们就在已有的硬件和软件平台基础上，按照自己所指定的规范，用软件建设了一个运行平台，整个系统除了比C++更加简单之外，没有什么大的区别。1992年的夏天，当Oak语言开发成功后，研究者们向硬件生产商进行演示了Green操作系统、Oak的程序设计语言、类库和其硬件，以说服他们使用Oak语言生产硬件芯片，但是，硬件生产商并未对此产生极大的热情。因为他们认为，在所有人对Oak语言还一无所知的情况下，就生产硬件产品的风险实在太大了，所以Oak语言也就因为缺乏硬件的支持而无法进入市场，从而被搁置了下来</span>'',''2017-10-18 15:39:45'',8,''测试'',5,33,NULL,0,1,NULL),(199,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">由于</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/C%2B%2B\">C++</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">所具有的优势，该项目组的研究人员首先考虑采用C++来编写程序。但对于</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A1%AC%E4%BB%B6\">硬件</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">资源极其匮乏的单片式系统来说，C++程序过于复杂和庞大。另外由于消费电子产品所采用的嵌入式处理器芯片的种类繁杂，如何让编写的程序</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%B7%A8%E5%B9%B3%E5%8F%B0\">跨平台</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">运行也是个难题。为了解决困难，他们首先着眼于语言的开发，假设了一种结构简单、符合嵌入式应用需要的硬件平台体系结构并为其制定了相应的规范，其中就定义了这种硬件平台的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%8C%E8%BF%9B%E5%88%B6\">二进制</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">机器码指令系统</span><i>（即后来成为“</i><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%AD%97%E8%8A%82%E7%A0%81\"><i>字节码</i></a><i>”的指令系统）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，以待语言开发成功后，能有</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%8A%E5%AF%BC%E4%BD%93%E8%8A%AF%E7%89%87\">半导体芯片</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">生产商开发和生产这种硬件平台。对于新语言的设计，Sun公司研发人员并没有开发一种全新的语言，而是根据嵌入式软件的要求，对C++进行了改造，去除了留在C++的一些不太实用及影响安全的成分，并结合嵌入式系统的实时性要求，开发了一种称为</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Oak\">Oak</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E8%AF%AD%E8%A8%80\">面向对象语言</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">。</span>'',''2017-10-18 15:40:44'',8,''讨论'',7,33,NULL,0,1,''甄姬2;无双''),(201,''312111111111111111111111111111111111111111111111111111111111'',''2017-10-19 23:15:51'',8,''1231321'',5,33,NULL,0,10,NULL),(202,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">20世纪90年代，硬件领域出现了单片式计算机系统，这种价格低廉的系统一出现就立即引起了自动控制领域人员的注意，因为使用它可以大幅度提升消费类电子产品</span><i>（如电视机顶盒、面包烤箱、移动电话等）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%99%BA%E8%83%BD%E5%8C%96\">智能化</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">程度。Sun公司为了抢占市场先机，在1991年成立了一个称为Green的项目小组，</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B8%95%E7%89%B9%E9%87%8C%E5%85%8B/4831889\">帕特里克</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%A9%B9%E5%A7%86%E6%96%AF%C2%B7%E9%AB%98%E6%96%AF%E6%9E%97\">詹姆斯·高斯林</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、麦克·舍林丹和其他几个工程师一起组成的工作小组在</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8A%A0%E5%88%A9%E7%A6%8F%E5%B0%BC%E4%BA%9A\">加利福尼亚</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">州</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%97%A8%E6%B4%9B%E5%B8%95%E5%85%8B\">门洛帕克</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">市沙丘路的一个小工作室里面研究开发新技术，专攻计算机在家电产品上的嵌入式应用。</span>'',''2017-10-22 01:04:54'',9,''2017某次笔记'',7,33,79,0,1,''甄姬;甄姬2''),(203,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">毛不易，网综《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%98%8E%E6%97%A5%E4%B9%8B%E5%AD%90/20478071\">明日之子</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》参赛选手，参加海选状况不断，他是明日之子唯一一个刚上场就录了三次音的选手，结果刚开口就被薛之谦闻到一股酒味，原来他上场前喝了几两白酒来缓解紧张，好不容易开始唱了，刚弹吉他，弦就断了，节目组帮忙换掉，张大大说不管怎么样都会送给他一把吉他，看起来他是一个十分有趣的小男生，一首《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A6%82%E6%9E%9C%E6%9C%89%E4%B8%80%E5%A4%A9%E6%88%91%E5%8F%98%E5%BE%97%E5%BE%88%E6%9C%89%E9%92%B1\">如果有一天我变得很有钱</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》内容很有趣，但是其中的落寞自嘲讥讽味道被薛之谦敏锐的发现了，他觉得毛不易可以走向更大的舞台，最终毛不易成功晋级。此后《巨星》唱出生活中的无奈，和《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A6%82%E6%9E%9C%E6%9C%89%E4%B8%80%E5%A4%A9%E6%88%91%E5%8F%98%E5%BE%97%E5%BE%88%E6%9C%89%E9%92%B1\">如果有一天我变得很有钱</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》异曲同工。之后他独创的《消愁》《像我这样的人》歌词字字扎入人心，听哭无数深夜里迷茫的人，“你写词写到我想给你跪”薛之谦这样赞赏他，“你被生活打了多少巴掌？”杨幂这样问到，一夜之间毛不易的《消愁》《像我这样的人》置顶流行音乐榜单，然而扎心依旧不断，一曲《借》直接让华晨宇给了他满分，他不仅歌唱的 好，词写的好，作曲的旋律也很美妙，其词曲不华丽不酷炫，却深深击中黑暗中迷茫前进的心。</span>'',''2017-10-22 08:08:10'',9,''变重要'',7,33,80,0,1,''小李父斯基;甄姬''),(204,''<div>\r\n	<div>\r\n		<p>\r\n			从2014年以来，知乎就成为了我最重要的社交和资讯平台。<br />\r\n天涯几乎再没上过，微博都是地震了才会用一下。<br />\r\n《一人饮酒醉》这首歌。我就是上个月从这个问题知道的。<br />\r\n当时看了最高票的答案觉得挺有意思。<br />\r\n百度搜了一下，第一段就把我震地关了浏览器，太炸耳朵了。<br />\r\n转身就回来把写的不错嘲讽的答案都点了个赞。\r\n		</p>\r\n		<p>\r\n			两天以后，我反思了一下，这样好像不太好。<br />\r\n我记得自己在30岁生日的时候警醒过自己，万事不可太狭隘。<br />\r\n你不应该强烈排斥尚未真正了解的东西。<br />\r\n于是我去下了个直播软件。\r\n		</p>\r\n		<p>\r\n			我出身知识分子家庭，受过高等教育，从事传统行业，衣食无忧生活稳定。<br />\r\n说实话，我挺保守甚至有些落后。<br />\r\n天天看网上说直播怎么赚钱了，快手怎么样了，我都从来没了解过。\r\n		</p>\r\n	</div>\r\n<br />\r\n作者：柯阿卡<br />\r\n链接：https://www.zhihu.com/question/38130123/answer/131454481<br />\r\n来源：知乎<br />\r\n著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\r\n</div>'',''2017-10-22 08:14:15'',8,''一人饮酒'',7,33,NULL,0,1,''伊丽莎白;小李父斯基''),(205,''<div>\r\n	<div>\r\n		<p>\r\n			下了直播软件我都不知道怎么玩，就在推荐的热门里面一个个点开看。纯粹好奇。<br />\r\n主播小姑娘绝大多数都很漂亮，小伙子也各有风采。<br />\r\n有的真的美丽俊朗到我想不通。\r\n		</p>\r\n		<p>\r\n			直播间里放烟花一样的撒礼物，哗啦哗啦的，浓妆艳抹的小姑娘不停的谢谢哥谢谢哥谢谢哥。<br />\r\n然后那些“哥”就继续哗啦哗啦的撒礼物。<br />\r\n一个比我胖3圈的胖妹直播吃火锅粉，全程无话，就呼哧呼哧的吃。收了2000金币……<br />\r\n简直颠覆我的认知。天上掉钱是不是就这个意思？\r\n		</p>\r\n		<p>\r\n			就在我准备关掉软件直接卸载的时候，鬼使神差看到了一个小伙子，戴着个大墨镜的头像，写着满满的“喊麦”两个字。<br />\r\n巧了，进去看看你吧。\r\n		</p>\r\n	</div>\r\n<br />\r\n作者：柯阿卡<br />\r\n链接：https://www.zhihu.com/question/38130123/answer/131454481<br />\r\n来源：知乎<br />\r\n著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\r\n</div>'',''2017-10-22 09:12:41'',8,''今日笔记'',5,33,78,0,1,NULL),(206,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2ME\">J2ME</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2SE\">J2SE</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2EE\">J2EE</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。</span>'',''2017-10-22 11:28:16'',9,''论讲究'',7,32,82,0,1,NULL),(207,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Apple/3860362\">Apple</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/XML\">XML</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">支持、安全套接字</span><i>（Socket）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">支持</span><i>（通过SSL与TLS协议）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0</span><i>（内部版本号1.5.0）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。</span>'',''2017-10-22 11:33:02'',8,''我的'',5,2,NULL,0,1,NULL),(208,''<div class=\"para\" style=\"font-size:14px;color:#333333;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">\r\n	2005年6月，在Java One大会上，Sun公司发布了Java SE 6。此时，Java的各种版本已经更名，已取消其中的数字2，如J2EE更名为<a target=\"_blank\" href=\"https://baike.baidu.com/item/JavaEE\">JavaEE</a>，J2SE更名为JavaSE，J2ME更名为<a target=\"_blank\" href=\"https://baike.baidu.com/item/JavaME\">JavaME</a>。<span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;\">[8]</span><a name=\"ref_[8]_12654100\"></a>&nbsp;\r\n</div>\r\n<div class=\"para\" style=\"font-size:14px;color:#333333;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">\r\n	2006年11月13日，Java技术的发明者Sun公司宣布，将Java技术作为免费软件对外发布。Sun公司正式发布的有关Java平台标准版的第一批源代码，以及Java迷你版的可执行源代码。从2007年3月起，全世界所有的开发人员均可对Java源代码进行修改<span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;\">[9]</span><a name=\"ref_[9]_12654100\"></a>&nbsp;&nbsp;。\r\n</div>'',''2017-10-22 11:34:15'',8,''编程'',5,33,NULL,0,1,NULL),(209,''<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">2009年，甲骨文公司宣布收购Sun</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[10]</span><a name=\"ref_[10]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。2010年，Java编程语言的共同创始人之一詹姆斯·高斯林从Oracle公司辞职。2011年，甲骨文公司举行了全球性的活动，以庆祝Java7的推出，随后Java7正式发布。2014年，甲骨文公司发布了Java8正式版</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[11]</span><a name=\"ref_[11]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。</span>'',''2017-10-22 11:38:37'',8,''已经建立了'',5,33,NULL,0,1,NULL);

/*Table structure for table `oa_notepaper` */

CREATE TABLE `oa_notepaper` (
  `notepaper_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `concent` text,
  `create_time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `notepaper_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notepaper_id`),
  KEY `FKsavcqw29haox5bu7y90it8jb7` (`notepaper_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_notepaper` */

insert  into `oa_notepaper`(`notepaper_id`,`concent`,`create_time`,`title`,`notepaper_user_id`) values (1,''反反复复付付'',''2017-09-21 22:49:12'',''wergfbebhet'',1),(2,''gggggg'',''2017-09-21 17:07:31'',''ggggg'',1),(3,''咯咯咯咯咯'',''2017-09-21 22:46:21'',''点点滴滴'',NULL),(5,''密密麻麻木木木木木木'',''2017-09-21 22:59:40'',''咕咕咕咕'',1),(6,''呃呃呃'',''2017-09-22 13:54:46'',''凄凄切切'',1),(9,''巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不'',''2017-09-22 15:08:28'',''凄凄切切'',1),(10,''反反复复'',''2017-09-25 17:04:12'',''咕咕咕咕'',1),(11,''呜呜呜呜'',''2017-09-25 17:04:27'',''额鹅鹅鹅'',1),(12,''哈哈哈哈或'',''2017-09-25 17:04:41'',''哈哈哈哈或'',1),(13,''短发儿童heat哈人员建议他已经拿到挥汗如雨'',''2017-09-25 17:04:51'',''啦啦啦啦绿'',1),(14,''斤斤计较军军军'',''2017-09-25 17:05:02'',''咯咯咯咯咯过过过过'',1),(15,''郭碧婷混合双打国庆套qyy6u7ugv '',''2017-09-25 17:05:18'',''点点滴滴'',1),(16,''dsadssssssssss'',''2017-10-14 23:59:39'',''fd'',1),(17,''此夜星辰非昨夜'',''2017-10-15 00:00:20'',''今天'',1),(18,''的说法'',''2017-10-15 00:03:41'',''是滴'',1),(23,''的说法'',''2017-10-15 00:32:12'',''无标题'',1),(24,''士大夫'',''2017-10-15 00:32:53'',''无标题'',1),(25,''的说法'',''2017-10-15 00:33:35'',''无标题'',1),(26,''网速慢'',''2017-10-15 00:33:52'',''无标题'',1),(27,''哈哈ui'',''2017-10-15 00:36:55'',''无标题'',1),(28,''范德萨'',''2017-10-16 18:28:08'',''无标题'',1),(29,''范德萨'',''2017-10-16 18:28:11'',''无标题'',1),(30,''123456789'',''2017-10-16 18:30:09'',''无标题'',1),(31,''范德萨'',''2017-10-18 18:50:07'',''无标题'',18),(32,''我们不一样'',''2017-10-22 00:34:34'',''无标题'',1),(33,''我们不一样'',''2017-10-22 00:34:36'',''无标题'',1),(34,''我们不一样'',''2017-10-22 00:34:37'',''无标题'',1),(35,''我们不一样'',''2017-10-22 00:34:38'',''无标题'',1),(36,''我们不一样'',''2017-10-22 00:34:40'',''无标题'',1),(37,''一万头草泥吗'',''2017-10-22 00:35:47'',''无标题'',1),(38,''我们确实不一样'',''2020-03-27 19:32:26'',''无标题'',1);

/*Table structure for table `oa_notice_list` */

CREATE TABLE `oa_notice_list` (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `is_top` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `notice_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_notice_list` */

insert  into `oa_notice_list`(`notice_id`,`content`,`is_top`,`modify_time`,`notice_time`,`status_id`,`title`,`type_id`,`url`,`user_id`) values (1,''fdsa范德萨'',0,''2017-09-21 12:40:10'',''2017-09-21 12:39:36'',14,''interesting'',10,''http://baidu.com'',1),(3,''fsd fd a'',1,''2017-09-20 20:39:31'',''2017-08-21 12:39:07'',14,''fsa '',12,''fs '',1),(4,''fsdafds fdsa '',1,''2017-09-21 13:25:39'',''2017-09-21 12:39:13'',16,''fdsafsa'',10,'''',1),(5,''fsd afs afsdf  s'',0,''2017-09-21 13:04:53'',''2017-09-18 12:39:18'',14,''what？？'',10,''http://gson.cn/stu/996_1_20_2_cdetail_.html'',1),(7,''额，这个怎么描述呢？'',0,''2017-09-24 21:47:33'',''2017-09-23 00:19:25'',15,''今天新增一个任务'',10,''http://www.zxyoo.cn'',1),(8,''11111111'',0,''2017-09-23 16:39:19'',''2017-09-23 16:39:19'',14,''11111'',11,''http://www.zxyoo.cn'',1),(9,''2222222222'',0,''2017-09-23 16:39:40'',''2017-09-23 16:39:40'',14,''2222222'',10,''http://www.zxyoo.cn'',1),(10,''33333333333333'',0,''2017-09-23 16:39:55'',''2017-09-23 16:39:55'',14,''333333333'',10,''http://www.zxyoo.cn'',1),(11,''444444444444'',0,''2017-09-23 16:40:18'',''2017-09-23 16:40:18'',14,''4444444444444'',10,''http://www.zxyoo.cn'',1),(12,''555555555'',0,''2017-09-23 16:40:43'',''2017-09-23 16:40:43'',14,''555555555'',10,''http://www.zxyoo.cn'',1),(13,''6666666666'',0,''2017-09-23 16:40:58'',''2017-09-23 16:40:58'',14,''66666666'',10,''http://www.zxyoo.cn'',1),(14,''77777777777'',0,''2017-09-23 16:41:12'',''2017-09-23 16:41:12'',14,''77777777'',10,''http://www.zxyoo.cn'',1),(15,''fdsfa fdsa fds '',0,''2017-09-24 15:35:55'',''2017-09-24 15:35:55'',14,''fdsfa '',10,'''',1),(16,''fsd afsdf sa'',0,''2017-09-24 15:36:08'',''2017-09-24 15:36:08'',14,''fsd fs afa '',10,'''',1),(17,''312321'',0,''2017-09-24 18:44:39'',''2017-09-24 15:36:18'',14,''31231'',11,'''',1),(18,''312413123'',0,''2017-09-24 15:36:27'',''2017-09-24 15:36:27'',14,''321313'',10,'''',1),(19,''312312314121414'',1,''2017-09-24 15:36:38'',''2017-09-24 15:36:38'',14,''31231'',10,'''',1),(20,'''',0,''2017-09-24 15:36:48'',''2017-09-24 15:36:48'',14,''312312'',10,'''',1),(21,''41241'',0,''2017-09-25 15:47:50'',''2017-09-24 15:37:03'',14,''21313'',10,'''',1),(22,''412431'',0,''2017-09-24 15:37:13'',''2017-09-24 15:37:13'',14,''321312'',10,'''',1),(23,'''',0,''2017-09-24 18:45:05'',''2017-09-24 15:37:21'',14,''31231231'',12,'''',1),(24,''怎么办嘛？ 我没有树下？'',0,''2017-10-06 21:33:34'',''2017-10-06 21:33:34'',16,''我下面没有员工，'',10,'''',2),(25,''ijdfd'',0,''2018-02-04 01:07:27'',''2018-02-04 01:07:27'',15,''tonight so beatiful'',10,'''',1);

/*Table structure for table `oa_notice_user_relation` */

CREATE TABLE `oa_notice_user_relation` (
  `relatin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_read` int(11) DEFAULT NULL,
  `relatin_notice_id` bigint(20) DEFAULT NULL,
  `relatin_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`relatin_id`),
  KEY `FKhxq8glkpb5qi1smn5gu142rky` (`relatin_notice_id`),
  KEY `FK52evvby6j47j24624ydi0o221` (`relatin_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_notice_user_relation` */

insert  into `oa_notice_user_relation`(`relatin_id`,`is_read`,`relatin_notice_id`,`relatin_user_id`) values (1,1,3,2),(2,0,3,3),(3,0,3,4),(4,1,4,2),(5,0,4,3),(6,0,4,4),(7,0,5,2),(8,0,5,3),(9,0,5,4),(14,1,3,1),(15,1,4,1),(16,1,5,1),(17,1,7,2),(18,0,7,3),(19,0,7,4),(20,0,8,2),(21,0,8,3),(22,0,8,4),(23,0,9,2),(24,0,9,3),(25,0,9,4),(26,0,10,2),(27,0,10,3),(28,0,10,4),(29,0,11,2),(30,0,11,3),(31,0,11,4),(32,0,12,2),(33,0,12,3),(34,0,12,4),(35,0,13,2),(36,0,13,3),(37,0,13,4),(38,0,14,2),(39,0,14,3),(40,0,14,4),(41,0,15,2),(42,0,15,3),(43,0,15,4),(44,0,16,2),(45,0,16,3),(46,0,16,4),(47,0,17,2),(48,0,17,3),(49,0,17,4),(50,0,18,2),(51,0,18,3),(52,0,18,4),(53,1,19,2),(54,0,19,3),(55,1,19,4),(56,0,20,2),(57,0,20,3),(58,0,20,4),(59,1,21,2),(60,0,21,3),(61,0,21,4),(62,0,22,2),(63,0,22,3),(64,0,22,4),(65,1,23,2),(66,0,23,3),(67,0,23,4),(68,0,24,5),(69,0,24,6),(70,1,24,7),(71,1,24,8),(72,1,25,2);

/*Table structure for table `oa_overtime` */

CREATE TABLE `oa_overtime` (
  `overtime_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`overtime_id`),
  KEY `FK5o36fvdsrrhvr9q4dvffxkuoc` (`pro_id`),
  CONSTRAINT `FK5o36fvdsrrhvr9q4dvffxkuoc` FOREIGN KEY (`pro_id`) REFERENCES `oa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_overtime` */

insert  into `oa_overtime`(`overtime_id`,`type_id`,`pro_id`,`personnel_advice`,`manager_advice`) values (1,33,14,NULL,''公司没人'');

/*Table structure for table `oa_plan_list` */

CREATE TABLE `oa_plan_list` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `plan_comment` varchar(5000) DEFAULT '''',
  `plan_content` varchar(10000) DEFAULT NULL,
  `plan_summary` varchar(800) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `plan_user_id` bigint(20) DEFAULT NULL,
  `attach_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`plan_id`,`start_time`),
  KEY `FKsqqfaj3e7rdl3jalr2sm0y4ln` (`plan_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_plan_list` */

insert  into `oa_plan_list`(`plan_id`,`create_time`,`end_time`,`label`,`plan_comment`,`plan_content`,`plan_summary`,`start_time`,`status_id`,`title`,`type_id`,`plan_user_id`,`attach_id`) values (1,''2017-08-04 20:29:27'',''2017-09-27 20:37:29'',''无语'',''dsadsa'',''sadadfa1的说法3222222222222'','''',''2017-09-22 20:37:29'',17,''sadadfadsfds1'',13,1,9),(3,''2017-09-26 20:37:46'',''2017-09-09 16:59:49'','''',''发大水saddsf dsf dsfafdds '',''sadadfad2'',''nice'',''2017-09-23 16:59:49'',18,''sadadfadsfds3'',13,1,47),(5,''2017-10-07 20:46:42'',''2017-09-07 20:37:29'','''','''',''sadadfad3'','''',''2017-09-22 20:37:29'',18,''sadadfadsfds5'',13,5,NULL),(6,''2017-09-28 20:48:43'',''2017-08-04 20:37:29'','''',''sdfafdsadsf22233dfaf111'',''sadadfads4'','''',''2017-09-22 20:37:29'',18,''sadadfadsfds6'',13,5,NULL),(7,''2017-09-22 20:58:41'',''2017-09-23 20:37:29'','''',''fdasdsfdfsd'',''sadadfad5'','''',''2017-09-22 20:37:29'',18,''sadadfadsfds7'',13,2,NULL),(11,''2017-09-30 18:27:42'',''2017-10-01 18:27:29'','''',''sa'',''dsafdfsafssdadsdsadfsadsaf'','''',''2017-09-30 18:27:29'',17,''adsfsaf的'',13,3,NULL),(12,''2017-09-30 19:44:37'',''2017-10-07 19:44:34'','''','''',''asddddddddffffffffffffffffffffffffffffffffffffffffffffffffff'','''',''2017-09-30 19:44:34'',17,''dasfasfdsa'',14,1,NULL),(13,''2017-09-30 20:13:50'',''2017-10-01 20:13:43'','''','''',''sadffdsadafsadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:13:43'',17,''sadffdsadaf'',13,1,NULL),(14,''2017-09-30 20:14:00'',''2017-10-01 20:13:53'','''','''',''sadffdsadafsadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:13:53'',17,''sadffdsadaf'',13,1,NULL),(15,''2017-09-30 20:14:11'',''2017-10-30 20:14:05'','''','''',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:05'',17,''sadffdsadaf'',15,1,NULL),(16,''2017-09-30 20:14:19'',''2017-10-01 20:14:14'','''','''',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:14'',17,''sadffdsadaf'',13,1,NULL),(17,''2017-09-30 20:14:27'',''2017-10-01 20:14:22'','''','''',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:22'',17,''sadffdsadaf'',13,1,NULL),(18,''2017-09-30 20:14:36'',''2017-10-01 20:14:30'','''','''',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:30'',17,''sadffdsadaf'',13,1,NULL),(19,''2017-09-30 20:14:44'',''2017-10-01 20:14:39'','''','''',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:39'',17,''sadffdsadaf'',13,1,NULL),(20,''2017-09-30 20:14:51'',''2017-10-01 20:14:47'','''',''hah '',''sadffdsadafsadffdsadafsadffdsadaf'','''',''2017-09-30 20:14:47'',17,''sadffdsadaf'',13,1,NULL),(21,''2017-10-01 20:12:31'',''2017-10-02 20:12:22'','''','''',''2222222222222222222222222222222222222222'','''',''2017-10-01 20:12:22'',17,''创造性'',13,1,NULL),(22,''2017-10-03 20:57:47'',''2017-10-04 20:57:38'','''','''',''55555555555555555555555'','''',''2017-10-03 20:57:38'',17,''士大夫'',13,1,NULL),(23,''2017-10-07 16:03:58'',''2017-10-08 16:03:33'',''2313'',''222二维222222222222222222222222222222222'',''22222222222222222222222222222222222222222'',''222二维222222222222222222222222222222222'',''2017-10-07 16:03:33'',17,''发生的'',13,1,65),(24,''2017-10-09 14:17:25'',''2017-10-10 14:17:13'',''dsf'',''sd'',''33333333333333333333333333333333333333333333333'',''33333333333333333333333333333333333333333333333'',''2017-10-09 14:17:13'',17,''sdf '',13,2,NULL),(25,''2017-10-09 14:53:50'',''2017-10-10 14:53:33'',''dsfad'',''dsafdsffdsfds哈哈的说法但是哈哈'',''3333333333333333333333333333324'',''ewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww'',''2017-10-09 14:53:33'',18,''dsfdf'',14,2,NULL),(26,''2017-10-18 15:46:23'',''2017-10-20 15:45:57'','''',NULL,''3333333333333333333333333333333333333333333333333'',''3333333333333333333333333333333333333333333333333'',''2017-10-18 15:45:57'',17,''ok'',13,1,NULL),(27,''2017-10-18 15:46:49'',''2017-10-19 15:46:27'','''',NULL,''321444444444444444444444444444444444444444444'','''',''2017-10-18 15:46:27'',17,''地方'',13,1,NULL),(28,''2017-10-18 15:47:27'',''2017-10-19 15:46:54'',''纳尼'',NULL,''超级不爽 真是无语 哈哈  。。，，，，，，，，，，，，，，，，，，，，，'','''',''2017-10-18 15:46:54'',17,''无语 '',13,1,NULL),(29,''2017-10-18 16:13:02'',''2017-10-19 16:12:22'',''哈哈'',NULL,''带你去看海带你去看海带你去看海带你去看海'','''',''2017-10-18 16:12:22'',17,''带你去看海'',13,1,71),(30,''2017-10-18 16:13:35'',''2017-10-19 16:13:18'','''',NULL,''真无语啊真无语啊真无语啊真无语啊真无语啊真无语啊'','''',''2017-10-18 16:13:18'',17,''真是无语'',14,1,NULL),(31,''2017-10-18 16:15:00'',''2017-11-18 16:14:37'','''',NULL,''。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。'','''',''2017-10-18 16:14:37'',17,''无语'',15,1,NULL),(32,''2017-10-18 16:23:34'',''2017-10-25 16:23:16'','''',''感觉啥都没有干 库'',''无语的n此房无语的n此房无语的n此房无语的n此房无语的n此房'','''',''2017-10-18 16:23:16'',17,''无语的n此房'',14,3,NULL),(33,''2017-10-18 16:23:58'',''2017-11-18 16:23:43'','''',NULL,''我也很无奈我也很无奈我也很无奈我也很无奈我也很无奈我也很无奈'','''',''2017-10-18 16:23:43'',17,''我也很无奈'',15,3,NULL),(34,''2017-10-18 16:31:41'',''2017-10-19 16:31:25'','''',''666'',''也无语是吧也无语是吧也无语是吧也无语是吧也无语是吧也无语是吧'','''',''2017-10-18 16:31:25'',17,''也无语是吧'',15,3,NULL),(35,''2017-10-20 10:20:27'',''2017-10-27 10:19:46'',''这首歌'',NULL,''仅仅代表着仅仅代表着仅仅代表着仅仅代表着仅仅代表着仅仅代表着'','''',''2017-10-20 10:19:46'',18,''仅仅代表着'',14,1,NULL),(36,''2017-10-20 10:22:31'',''2017-10-27 10:21:44'',''在人间彷徨'',NULL,''三月春花三月春花三月春花三月春花三月春花三月春花'','''',''2017-10-20 10:21:44'',18,''三月春花'',14,5,NULL),(37,''2017-10-20 10:23:09'',''2017-10-21 10:22:37'',''远方有情'',NULL,''轻轻唱轻轻唱轻轻唱轻轻唱轻轻唱轻轻唱轻轻唱轻轻唱轻轻唱'','''',''2017-10-20 10:22:37'',17,''轻轻唱'',13,5,NULL),(38,''2017-10-20 10:23:49'',''2017-11-20 10:23:18'',''泪已拆两行'',NULL,''雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶'','''',''2017-10-20 10:23:18'',18,''雨打死了眼眶'',15,5,NULL),(39,''2017-10-20 10:24:39'',''2017-10-27 10:23:54'',''轻轻唱'',NULL,''折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁'','''',''2017-10-20 10:23:54'',18,''折菊寄到你身旁'',14,5,NULL),(40,''2017-10-20 10:25:58'',''2017-10-21 10:24:44'',''谁一颦一笑摇曳了星云'',NULL,''多年不减你深情多年不减你深情多年不减你深情多年不减你深情多年不减你深情'','''',''2017-10-20 10:24:44'',17,''多年不减你深情'',13,5,NULL),(41,''2017-10-20 10:29:20'',''2017-10-27 10:26:14'',''和落下的老爷爷一样'',''小伙子可以啊'',''又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上'','''',''2017-10-20 10:26:14'',18,''又是一个安静的晚上'',14,5,NULL),(42,''2017-10-20 10:30:13'',''2017-11-20 10:29:29'',''素面朝天要多纯洁有多纯洁'',NULL,''我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结'','''',''2017-10-20 10:29:29'',17,''我做我的改成又何必纠结'',15,5,NULL),(43,''2017-10-20 10:32:37'',''2017-10-21 10:32:14'','''',NULL,''曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间'','''',''2017-10-20 10:32:14'',17,''曾经对上的瞬间'',13,4,NULL),(44,''2017-10-20 10:34:10'',''2017-10-27 10:32:45'','''',NULL,''瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌'','''',''2017-10-20 10:32:45'',17,''瘦马未得好歌'',14,4,NULL),(45,''2017-10-20 10:34:28'',''2017-10-27 10:34:15'','''',NULL,''千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度'','''',''2017-10-20 10:34:15'',18,''千百度'',14,4,NULL),(46,''2017-10-20 10:35:00'',''2017-11-20 10:34:36'','''',NULL,''课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处'','''',''2017-10-20 10:34:36'',17,''课你却不在灯火阑珊处'',15,4,74),(47,''2017-10-20 10:36:07'',''2017-10-21 10:35:23'','''',NULL,''日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮'','''',''2017-10-20 10:35:23'',17,''日出到迟暮'',13,4,75),(48,''2017-10-20 10:36:33'',''2017-10-21 10:36:18'','''',''df'',''灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处'','''',''2017-10-20 10:36:18'',17,''灯火阑珊处'',13,4,NULL),(49,''2017-10-20 10:37:59'',''2017-10-21 10:37:16'','''',NULL,''为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河'','''',''2017-10-20 10:37:16'',17,''如果有时不那么开心'',13,7,NULL),(50,''2017-10-20 10:38:23'',''2017-10-27 10:38:04'','''',NULL,''为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧'','''',''2017-10-20 10:38:04'',17,''为你辗转反侧'',14,7,NULL),(51,''2017-10-20 10:38:52'',''2017-10-21 10:38:27'','''',NULL,''天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨'','''',''2017-10-20 10:38:27'',17,''天空好像下雨'',13,7,NULL),(52,''2017-10-20 10:39:16'',''2017-10-27 10:38:58'','''',NULL,''亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌'','''',''2017-10-20 10:38:58'',17,''亲手买冰激凌'',14,7,NULL),(53,''2017-10-20 10:39:41'',''2017-10-21 10:39:20'','''',NULL,''为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾'','''',''2017-10-20 10:39:20'',18,''为你做一只铺货的飞蛾'',13,7,NULL),(54,''2017-10-20 10:40:03'',''2017-10-27 10:39:48'','''',NULL,''啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦'','''',''2017-10-20 10:39:48'',19,''啦啦啦啦'',14,7,76),(55,''2017-10-22 10:32:33'',''2017-10-23 10:29:49'',''这次计划'',''这个计划 nice'',''1996年1月，Sun公司发布了Java的第一个开发工具包（JDK 1.0），这是Java发展历程中的重要里程碑，标志着Java成为一种独立的开发工具。9月，约8.3万个网页应用了Java技术来制作。10月，Sun公司发布了Java平台的第一个即时（JIT）编译器。\r\n1997年2月，JDK 1.1面世，在随后的3周时间里，达到了22万次的下载量。4月2日，Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。9月，Java Developer Connection社区成员超过10万。'',''Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。9月，Java Developer Connection社区成员超过10万。'',''2017-10-22 10:29:49'',19,''周计划'',14,7,NULL);

/*Table structure for table `oa_position` */

CREATE TABLE `oa_position` (
  `position_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `describtion` varchar(255) DEFAULT NULL,
  `deptid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_position` */

insert  into `oa_position`(`position_id`,`level`,`name`,`describtion`,`deptid`) values (1,1,''超级管理员'',''管理系统最高权限'',1),(2,2,''CEO'',''CEO类！~'',1),(3,3,''总经理'',''总经理类！~'',1),(4,4,''研发部经理'',NULL,2),(5,5,''财务部经理'',NULL,3),(6,6,''市场部经理'',NULL,4),(7,7,''人事部经理'',NULL,5),(8,8,''人事专员'',NULL,5),(9,9,''劳资专员'',NULL,5),(10,10,''程序员'',NULL,2),(11,11,''初级工程师'',NULL,2),(12,12,''中级工程师'',NULL,2),(13,13,''高级工程师'',NULL,2),(14,14,''系统架构师'',NULL,2),(15,15,''需求分析师'',NULL,2),(16,16,''调查专员'',NULL,4),(17,17,''企业推广员'',NULL,4),(18,18,''平面设计师'',NULL,4),(19,19,''培训专员'',NULL,4),(20,20,''市场督导员'',NULL,4),(21,21,''核算会计'',NULL,3),(22,22,''税务会计'',NULL,3),(23,23,''出纳员'',NULL,3),(25,2222,''测试岗位！~'',''emmm！~~'',NULL),(26,1,''测试职位1'',''啊实打实的'',19);

/*Table structure for table `oa_process_list` */

CREATE TABLE `oa_process_list` (
  `process_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_time` datetime DEFAULT NULL,
  `deeply_id` bigint(20) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `process_des` text,
  `process_name` varchar(255) DEFAULT NULL,
  `procsee_days` int(11) DEFAULT NULL,
  `is_checked` int(10) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `pro_file_id` bigint(20) DEFAULT NULL,
  `process_user_id` bigint(20) DEFAULT NULL,
  `shenuser` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`process_id`),
  KEY `FKiltoi9iw3vjixl6u4cd60fi1p` (`pro_file_id`),
  KEY `FKhtdg4du5ryotah5v1dgyjfh2t` (`process_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_process_list` */

insert  into `oa_process_list`(`process_id`,`apply_time`,`deeply_id`,`end_time`,`process_des`,`process_name`,`procsee_days`,`is_checked`,`start_time`,`status_id`,`type_name`,`pro_file_id`,`process_user_id`,`shenuser`) values (1,''2017-10-06 21:54:42'',22,NULL,NULL,''费用报销'',NULL,0,NULL,23,''费用报销'',NULL,1,NULL),(6,''2017-10-07 22:08:53'',22,NULL,NULL,''得到'',NULL,0,NULL,23,''费用报销'',NULL,18,NULL),(7,''2017-10-12 12:58:25'',22,NULL,''打了电话'',''报销电话费'',NULL,0,NULL,24,''费用报销'',NULL,11,NULL),(8,''2017-10-12 22:07:35'',22,NULL,''该交房租了'',''房费'',NULL,0,NULL,23,''费用报销'',NULL,18,NULL),(9,''2017-10-12 23:25:57'',22,NULL,''该交房租了'',''房租'',NULL,0,NULL,23,''费用报销'',66,18,NULL),(10,''2017-10-13 17:02:36'',22,''2017-10-14 17:01:11'',''出差两天'',''出差'',1,0,''2017-10-13 17:01:11'',24,''出差费用'',NULL,18,NULL),(11,''2017-10-14 00:13:20'',22,''2017-10-18 00:10:06'',''经理安排到广州出差'',''到广州出差'',2,0,''2017-10-16 00:10:06'',25,''出差费用'',NULL,18,NULL),(12,''2017-10-14 13:06:12'',22,''2017-10-15 13:01:35'',''到北京出差两天'',''出差'',1,0,''2017-10-14 13:01:35'',24,''出差申请'',NULL,10,NULL),(14,''2017-10-14 20:19:19'',22,''2017-10-15 20:19:00'',''加班'',''加班呀'',1,0,''2017-10-14 20:19:00'',24,''加班申请'',NULL,4,NULL),(16,''2017-10-14 21:22:35'',22,''2017-10-16 21:21:29'',''家里有急事'',''请假'',2,0,''2017-10-14 21:21:29'',24,''请假申请'',67,3,NULL),(17,''2017-10-14 22:17:29'',22,''2017-10-14 22:32:51'',NULL,''转正'',90,0,''2017-07-14 22:32:20'',24,''转正申请'',NULL,28,NULL),(19,''2017-10-15 00:04:31'',22,NULL,''不干了'',''离职'',NULL,0,NULL,24,''离职申请'',NULL,28,NULL),(20,''2017-10-15 16:13:20'',22,NULL,''双宿双飞人'',''得到'',NULL,0,NULL,24,''离职申请'',NULL,18,''红之花;soli''),(21,''2017-10-15 19:17:46'',22,''2017-10-19 19:16:37'',''销售需要'',''来看几个特别'',2,0,''2017-10-17 19:16:37'',23,''出差申请'',68,18,''红之花''),(22,''2017-10-15 20:04:02'',22,''2017-10-16 20:03:07'',''反反复复'',''哈哈'',1,0,''2017-10-15 20:03:07'',23,''出差申请'',NULL,10,''小李父斯基''),(23,''2017-10-15 20:12:22'',22,''2017-10-22 20:11:40'',''反反复复'',''还有'',4,0,''2017-10-18 20:11:40'',23,''出差申请'',NULL,10,''小李父斯基''),(24,''2017-10-15 20:14:13'',22,''2017-10-22 20:12:25'',''得到'',''女'',4,0,''2017-10-18 20:12:25'',26,''出差费用'',NULL,10,''小李父斯基''),(25,''2017-10-19 23:43:29'',22,''2017-10-22 23:43:14'',''大大方方大锅饭哈哈'',''试试'',3,0,''2017-10-19 23:43:14'',25,''请假申请'',NULL,10,''小李父斯基;甄姬'');

/*Table structure for table `oa_receiver_note` */

CREATE TABLE `oa_receiver_note` (
  `note_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK904cmor3q468pj3ft6mdrnqwk` (`user_id`),
  KEY `FKcx7spjjefkofw62v8yxmgjxao` (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_receiver_note` */

insert  into `oa_receiver_note`(`note_id`,`user_id`,`id`) values (128,1,19),(122,1,22),(127,1,24),(120,1,25),(137,3,42),(126,6,43),(126,5,44),(111,4,45),(138,3,46),(139,1,47),(140,4,48),(140,3,49),(1,1,57),(143,1,59),(145,1,61),(146,1,63),(149,1,66),(150,1,67),(151,1,68),(152,1,69),(153,1,70),(154,1,71),(155,1,72),(156,1,73),(157,1,74),(158,1,75),(159,1,76),(160,1,77),(161,1,78),(162,1,79),(163,1,80),(164,1,81),(165,1,82),(166,1,83),(167,1,84),(168,1,85),(169,1,87),(170,7,117),(171,1,118),(172,1,119),(173,1,120),(174,1,121),(174,3,122),(175,1,123),(175,3,124),(176,1,125),(177,1,126),(177,4,127),(177,5,128),(178,1,129),(179,1,130),(180,1,131),(181,1,132),(182,1,133),(183,1,134),(184,1,135),(187,1,142),(189,1,144),(190,1,145),(191,7,146),(192,1,147),(194,1,151),(195,23,152),(188,1,155),(201,10,162),(204,4,170),(204,3,171),(204,1,172),(205,1,174),(196,1,175),(203,4,193),(203,7,194),(203,1,195),(199,10,199),(199,1,200),(199,8,201),(198,1,202),(193,12,218),(193,13,219),(193,1,220),(202,1,221),(202,7,222),(202,8,223);

/*Table structure for table `oa_regular` */

CREATE TABLE `oa_regular` (
  `regular_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `advice` varchar(255) DEFAULT NULL,
  `deficiency` varchar(255) DEFAULT NULL,
  `dobetter` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  `pullulate` varchar(255) DEFAULT NULL,
  `understand` varchar(255) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  PRIMARY KEY (`regular_id`),
  KEY `FK96uphskhww1otsi3fe916dfor` (`pro_id`),
  CONSTRAINT `FK96uphskhww1otsi3fe916dfor` FOREIGN KEY (`pro_id`) REFERENCES `oa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_regular` */

insert  into `oa_regular`(`regular_id`,`advice`,`deficiency`,`dobetter`,`experience`,`personnel_advice`,`pullulate`,`understand`,`pro_id`,`manager_advice`,`days`) values (1,''咕咕咕咕'',''是是是'',''反反复复'',''是是是'',NULL,''是是是'',''是是是'',17,''经过实习期间观察，合格'',90);

/*Table structure for table `oa_reply_list` */

CREATE TABLE `oa_reply_list` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `replay_time` datetime DEFAULT NULL,
  `discuss_id` bigint(20) DEFAULT NULL,
  `reply_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `FK94s0c9f8hxomde6bede3d20y2` (`discuss_id`),
  KEY `FK2bn8fpyqw7mom14ks4kvrhtp9` (`reply_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_reply_list` */

insert  into `oa_reply_list`(`reply_id`,`content`,`replay_time`,`discuss_id`,`reply_user_id`) values (2,''富士达发的所所所所所\n范德萨发啊'',''2017-10-01 22:05:46'',13,1),(3,''内容应该要清空了'',''2017-10-01 22:06:05'',13,1),(4,''阿西吧，这么好'',''2017-10-01 22:06:17'',13,2),(5,''what？\n'',''2017-10-02 13:51:26'',13,2),(6,''发生的多多多'',''2017-10-02 13:52:28'',13,2),(7,''发生的范德萨'',''2017-10-02 13:54:23'',13,1),(8,''范德萨'',''2017-10-02 13:55:04'',13,1),(9,''yayaya,不错'',''2017-10-02 16:52:35'',13,1),(14,''fdsa fsdf afsdfasdf'',''2017-10-03 00:35:42'',13,1),(15,''fdsa fdsf'',''2017-10-03 00:36:57'',13,1),(16,''fsdfas fsd'',''2017-10-03 00:37:03'',13,1),(17,''加一条讨论的记录'',''2017-10-03 01:02:48'',14,1),(18,''范德萨是'',''2017-10-03 01:03:54'',14,1),(33,''fdsa'',''2017-10-03 01:38:58'',15,1),(36,''fdsa'',''2017-10-03 01:42:04'',15,1),(37,''fsdafds'',''2017-10-03 01:42:19'',15,1),(38,''fsfsd'',''2017-10-03 01:43:23'',15,1),(39,''fsdfasdfs'',''2017-10-03 01:43:49'',15,1),(47,''ljljllj;'',''2017-10-03 01:55:34'',1,1),(49,''ds'',''2017-10-03 02:01:20'',23,1),(50,''回复'',''2017-10-03 11:21:38'',14,1),(51,'' 回复你之后会怎么样？ 第13楼么？'',''2017-10-03 11:26:50'',13,1),(58,''fsdfsdfjl'',''2017-10-03 15:18:37'',7,1),(59,''fdsfasd '',''2017-10-03 15:19:06'',7,1),(60,''发的发'',''2017-10-03 23:25:25'',33,2),(61,''发范德萨'',''2017-10-04 01:33:05'',32,2),(62,'' 回复可以么？'',''2017-10-04 01:39:49'',32,2),(63,''@朱丽叶 回复可以么？ 可以么？'',''2017-10-04 01:40:58'',32,2),(64,''回复试试'',''2017-10-04 01:50:57'',32,2),(65,''没意义问题的'',''2017-10-04 01:52:20'',32,2),(66,'' 接下来就不会报错了'',''2017-10-04 01:52:46'',32,2),(67,'' 加第七条'',''2017-10-04 01:56:01'',32,2),(68,''富士达'',''2017-10-04 03:24:56'',33,2),(69,''好吧，合情合理'',''2017-10-04 03:25:15'',33,2),(70,''范德萨'',''2017-10-04 03:25:48'',33,2),(71,''没有问题吧？'',''2017-10-04 03:26:08'',33,2),(72,''再加一个呢？'',''2017-10-04 03:27:00'',33,2),(73,''地方撒'',''2017-10-05 23:00:14'',8,2),(74,''让人头疼'',''2017-10-05 23:05:59'',7,2),(75,''大师傅'',''2017-10-05 23:06:18'',7,2),(76,''都是'',''2017-10-05 23:06:26'',7,2),(77,''大师傅发的'',''2017-10-05 23:06:42'',7,2),(78,''12312'',''2017-10-06 10:22:11'',38,1),(79,''范德萨发生'',''2017-10-06 10:53:53'',42,1),(80,''fdsfadsaf'',''2017-10-06 10:55:54'',42,1),(81,''fdfa fdsa '',''2017-10-06 10:58:10'',42,1),(82,''fdsaffdsaf'',''2017-10-06 10:59:12'',42,1),(83,''fdsfafd'',''2017-10-06 10:59:28'',42,1),(85,'' 哟哟；interesting'',''2017-10-06 13:47:18'',37,2),(86,'' 好吧，有趣'',''2017-10-06 13:47:29'',37,2),(87,''你很有意思'',''2017-10-06 14:22:59'',9,2),(88,''你也不错'',''2017-10-06 14:23:18'',6,2),(89,''hd'',''2020-03-27 22:23:04'',37,1);

/*Table structure for table `oa_resign` */

CREATE TABLE `oa_resign` (
  `resign_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `financial_advice` varchar(255) DEFAULT NULL,
  `is_finish` bit(1) DEFAULT NULL,
  `nofinish` varchar(255) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  `suggest` varchar(255) DEFAULT NULL,
  `hand_user` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resign_id`),
  KEY `FK3t0d1mt9o7g5q59ha10e3mwpr` (`hand_user`),
  KEY `FKam7ii5j1kdforxq8s6q3mm13n` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_resign` */

insert  into `oa_resign`(`resign_id`,`financial_advice`,`is_finish`,`nofinish`,`personnel_advice`,`suggest`,`hand_user`,`pro_id`,`manager_advice`) values (1,NULL,''\0'',''没有'',NULL,NULL,8,19,''准了''),(2,NULL,'''',''没有'',NULL,NULL,10,20,''多对多'');

/*Table structure for table `oa_reviewed` */

CREATE TABLE `oa_reviewed` (
  `reviewed_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `advice` varchar(255) DEFAULT NULL,
  `reviewed_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `del` int(11) DEFAULT NULL,
  PRIMARY KEY (`reviewed_id`),
  KEY `FKevjvy6myxg1l0ibiuph3i7jw2` (`pro_id`),
  KEY `FK2iljei0wvy0cylwwyfh5dr9yk` (`user_id`),
  CONSTRAINT `FK2iljei0wvy0cylwwyfh5dr9yk` FOREIGN KEY (`user_id`) REFERENCES `oa_user_info` (`user_id`),
  CONSTRAINT `FKevjvy6myxg1l0ibiuph3i7jw2` FOREIGN KEY (`pro_id`) REFERENCES `oa_process_list` (`process_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_reviewed` */

/*Table structure for table `oa_role` */

CREATE TABLE `oa_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_code` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_creator` bigint(20) DEFAULT NULL,
  `gmt_modifier` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `idx_role_code` (`role_code`) COMMENT ''权限编码''
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_role` */

insert  into `oa_role`(`role_id`,`role_name`,`role_code`,`enabled`,`gmt_modified`,`gmt_created`,`gmt_creator`,`gmt_modifier`,`parent_id`) values (1,''超级管理员'',''ADMIN'',1,''2020-05-29 16:30:54'',''2020-05-29 16:30:57'',NULL,NULL,NULL),(2,''来宾'',''GUEST'',1,''2020-05-29 16:46:20'',''2020-05-29 16:46:23'',NULL,NULL,NULL);

/*Table structure for table `oa_schedule_list` */

CREATE TABLE `oa_schedule_list` (
  `rc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `filedescribe` varchar(255) DEFAULT NULL,
  `is_remind` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `miaoshu` varchar(255) DEFAULT NULL,
  `isreminded` int(11) DEFAULT NULL,
  PRIMARY KEY (`rc_id`),
  KEY `FKgcip21xf5ihmgm2bnh5o4jv15` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_schedule_list` */

insert  into `oa_schedule_list`(`rc_id`,`create_time`,`end_time`,`filedescribe`,`is_remind`,`start_time`,`status_id`,`title`,`type_id`,`user_id`,`miaoshu`,`isreminded`) values (1,''2017-10-18 17:35:16'',''2017-10-19 11:09:11'',''问请问'',0,''2017-10-04 11:09:06'',27,''qwew'',44,1,''请问请问'',0),(2,''2017-10-17 11:09:15'',''2017-11-18 11:09:11'',''方法都是'',1,''2017-10-05 11:09:06'',28,''问问去'',44,1,''大撒大撒'',0),(3,''2017-10-17 11:09:15'',''2017-10-29 11:09:11'',''撒打算'',1,''2017-10-11 11:09:06'',29,''请问请问'',45,1,''阿斯顿'',0),(5,''2017-10-18 16:50:28'',''2017-10-20 00:00:00'',NULL,0,''2017-10-18 00:00:00'',27,''Z现在'',44,1,''啊实打实的'',0),(6,''2017-10-18 16:53:33'',''2017-10-25 00:00:00'',NULL,1,''2017-10-18 00:00:00'',29,''测试'',45,1,''啊实打实的撒'',0),(7,''2017-10-18 16:55:23'',''2017-10-26 00:00:00'',NULL,0,''2017-10-18 00:00:00'',27,''啊实打实的撒'',44,1,''啊实打实大苏打撒'',0),(8,''2017-10-18 16:58:05'',''2017-10-20 00:00:00'',NULL,0,''2017-10-18 00:00:00'',27,''sa撒打算'',44,1,''撒大苏打撒'',0),(9,''2017-10-18 17:01:43'',''2017-10-21 00:00:00'',NULL,0,''2017-10-18 00:00:00'',27,''sasa\''d撒旦撒'',44,1,''啊实打实的'',0),(10,''2017-10-18 17:03:36'',''2017-10-20 00:00:00'',NULL,0,''2017-10-18 00:00:00'',27,''现在反倒反倒是'',44,1,''打发士大夫但是'',0);

/*Table structure for table `oa_schedule_user` */

CREATE TABLE `oa_schedule_user` (
  `rcid` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FKh6hw8vp7p2lgfovi0o7bhhlyp` (`user_id`),
  KEY `FKcmd578ftbv7i53l6mxbbva137` (`rcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_schedule_user` */

insert  into `oa_schedule_user`(`rcid`,`user_id`) values (6,2),(6,3),(1,2),(1,3),(1,4);

/*Table structure for table `oa_status_list` */

CREATE TABLE `oa_status_list` (
  `status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_color` varchar(255) DEFAULT NULL,
  `status_model` varchar(255) DEFAULT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  `sort_value` int(11) DEFAULT NULL,
  `sort_precent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_status_list` */

insert  into `oa_status_list`(`status_id`,`status_color`,`status_model`,`status_name`,`sort_value`,`sort_precent`) values (1,''label-success'',''aoa_mailnumber'',''有效'',0,NULL),(2,''label-default'',''aoa_mailnumber'',''无效'',1,NULL),(3,''label-warning'',''aoa_task_list'',''新任务'',0,''20%''),(4,''label-info'',''aoa_task_list'',''已接收'',1,''40%''),(5,''label-primary'',''aoa_task_list'',''进行中'',2,''60%''),(6,''label-danger'',''aoa_task_list'',''已提交'',3,''80%''),(7,''label-success'',''aoa_task_list'',''已完成'',4,''100%''),(8,''label-info'',''aoa_note_list'',''一般'',0,NULL),(9,''label-danger'',''aoa_note_list'',''重要'',1,NULL),(10,''label-info'',''aoa_attends_list'',''正常'',0,NULL),(11,''label-warning'',''aoa_attends_list'',''迟到'',1,NULL),(12,''label-danger'',''aoa_attends_list'',''早退'',2,NULL),(13,''label-danger'',''a'',''旷工'',3,NULL),(14,''label-primary'',''inform'',''一般'',0,NULL),(15,''label-warning'',''inform'',''重要'',1,''''),(16,''label-danger'',''inform'',''紧急'',2,NULL),(17,''label-warning'',''aoa_plan_list'',''未完成'',0,NULL),(18,''label-success'',''aoa_plan_list'',''已完成'',1,NULL),(19,''label-info'',''aoa_plan_list'',''已取消'',2,NULL),(20,''label-primary'',''aoa_in_mail_list'',''一般'',0,NULL),(21,''label-warning'',''aoa_in_mail_list'',''重要'',1,NULL),(22,''label-danger'',''aoa_in_mail_list'',''紧急'',2,NULL),(23,''label-info'',''aoa_process_list'',''未处理'',0,NULL),(24,''label-primary'',''aoa_process_list'',''处理中'',1,NULL),(25,''label-success'',''aoa_process_list'',''已批准'',2,NULL),(26,''label-danger'',''aoa_process_list'',''未通过'',3,NULL),(27,''label-primary'',''aoa_schedule_list'',''一般'',0,NULL),(28,''label-warning'',''aoa_schedule_list'',''重要'',1,NULL),(29,''label-danger'',''aoa_schedule_list'',''紧急'',2,NULL);

/*Table structure for table `oa_stay` */

CREATE TABLE `oa_stay` (
  `stay_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `day` int(11) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `stay_city` varchar(255) DEFAULT NULL,
  `stay_money` double DEFAULT NULL,
  `stay_time` datetime DEFAULT NULL,
  `evemoney_id` bigint(20) DEFAULT NULL,
  `user_name` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stay_id`),
  KEY `FK50vbdodv3kd8dixbmyf9ixyc` (`evemoney_id`),
  KEY `FKho0k9o03kbn6dd96l57xvcx3y` (`user_name`),
  CONSTRAINT `FK50vbdodv3kd8dixbmyf9ixyc` FOREIGN KEY (`evemoney_id`) REFERENCES `oa_evectionmoney` (`evectionmoney_id`),
  CONSTRAINT `FKho0k9o03kbn6dd96l57xvcx3y` FOREIGN KEY (`user_name`) REFERENCES `oa_user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_stay` */

/*Table structure for table `oa_subject` */

CREATE TABLE `oa_subject` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_subject` */

insert  into `oa_subject`(`subject_id`,`name`,`parent_id`) values (1,''报销科目'',0),(2,''办公室费用'',1),(3,''第三方采购费'',1),(4,''管理费用'',1),(5,''投标保证金'',1),(6,''销售费用'',1),(7,''预付款'',1),(9,''差旅费'',2),(10,''采购费'',3),(11,''外包费用'',3),(12,''外包服务费'',3),(13,''房租'',4),(14,''工资'',4),(15,''公积金'',4),(16,''固定电话费'',4),(17,''社保金'',4),(18,''水费'',4),(19,''印刷费'',4),(20,''电费'',4),(21,''投标保证金'',5),(22,''车辆油费'',6),(23,''市场推广费'',6),(24,''市内交通费'',6),(25,''招待费'',6),(26,''预付款'',7);

/*Table structure for table `oa_sys_menu` */

CREATE TABLE `oa_sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_show` int(11) DEFAULT NULL,
  `menu_grade` int(11) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_sys_menu` */

insert  into `oa_sys_menu`(`menu_id`,`is_show`,`menu_grade`,`menu_icon`,`menu_name`,`menu_url`,`parent_id`,`sort_id`) values (1,1,NULL,''glyphicon-cog'',''系统管理'',''##'',0,0),(2,1,NULL,''glyphicon-education'',''用户管理'',''#'',0,2),(3,1,NULL,''glyphicon-user'',''角色列表'',''#'',0,3),(4,1,NULL,''glyphicon-time'',''考勤管理'',''#'',0,4),(5,1,NULL,''glyphicon-hourglass'',''流程管理'',''#'',0,5),(6,1,NULL,''glyphicon-bell'',''公告管理'',''#'',0,6),(7,1,NULL,''glyphicon-envelope'',''邮件管理'',''#'',0,7),(8,1,NULL,''glyphicon-flag'',''任务管理'',''#'',0,8),(9,1,NULL,''glyphicon-calendar'',''日程管理'',''#'',0,9),(10,1,NULL,''glyphicon-plane'',''工作计划'',''#'',0,10),(11,1,NULL,''glyphicon-folder-open'',''文件管理'',''#'',0,11),(12,1,NULL,''glyphicon-edit'',''笔记管理'',''#'',0,12),(13,1,NULL,''glyphicon-comment'',''讨论区'',''#'',0,14),(14,1,NULL,''glyphicon-record'',''菜单管理'',''/testsysmenu'',1,2),(15,1,NULL,''glyphicon-record'',''类型管理'',''/testsystype'',1,1),(16,1,NULL,''glyphicon-record'',''状态管理'',''/testsysstatus'',1,3),(17,1,NULL,''glyphicon-record'',''部门管理'',''/deptmanage'',2,1),(18,1,NULL,''glyphicon-record'',''职位管理'',''/positionmanage'',2,3),(19,1,NULL,''glyphicon-record'',''用户管理'',''/usermanage'',2,4),(20,1,NULL,''glyphicon-record'',''在线用户'',''/morelogrecord'',2,2),(21,1,NULL,''glyphicon-record'',''角色列表'',''/rolemanage'',3,1),(22,1,NULL,''glyphicon-record'',''考勤管理'',''/attendceatt'',4,1),(23,1,NULL,''glyphicon-record'',''考勤周报表'',''/attendceweek'',4,2),(24,1,NULL,''glyphicon-record'',''考勤月报表'',''/attendcemonth'',4,3),(25,1,NULL,''glyphicon-record'',''我的申请'',''/flowmanage'',5,1),(26,1,NULL,''glyphicon-record'',''流程审核'',''/audit'',5,2),(27,1,NULL,''glyphicon-record'',''通知管理'',''/infrommanage'',6,1),(28,1,NULL,''glyphicon-record'',''通知列表'',''/infromlist'',6,2),(29,1,NULL,''glyphicon-record'',''账号管理'',''/accountmanage'',7,1),(30,1,NULL,''glyphicon-record'',''邮件管理'',''/mail'',7,2),(31,1,NULL,''glyphicon-record'',''任务管理'',''/taskmanage'',8,1),(32,1,NULL,''glyphicon-record'',''我的任务'',''/mytask'',8,2),(33,1,NULL,''glyphicon-record'',''日程管理'',''/daymanage'',9,1),(34,1,NULL,''glyphicon-record'',''我的日历'',''/daycalendar'',9,2),(35,1,NULL,''glyphicon-record'',''计划管理'',''/planview'',10,1),(36,1,NULL,''glyphicon-record'',''计划报表'',''/myplan'',10,2),(37,1,NULL,''glyphicon-record'',''文件管理'',''/filemanage'',11,1),(38,1,NULL,''glyphicon-record'',''笔记管理'',''/noteview'',12,0),(39,1,NULL,''glyphicon-earphone'',''通讯录'',''#'',0,13),(40,1,NULL,''glyphicon-record'',''通讯录'',''/addrmanage'',39,1),(41,1,NULL,''glyphicon-record'',''我的管理'',''/chatmanage'',13,1),(42,1,NULL,''glyphicon-record'',''讨论区列表'',''/chatlist'',13,2),(67,1,NULL,''glyphicon-record'',''考勤列表'',''/attendcelist'',4,4),(76,NULL,NULL,''21'',''12'',''21'',NULL,NULL),(77,0,NULL,''额'',''额'',''e'',NULL,NULL),(78,0,NULL,''312'',''31'',''312'',NULL,NULL),(79,0,NULL,''放大'',''范德萨'',''富士达'',NULL,NULL),(80,NULL,NULL,''富士达'',''任务'',''富士达'',NULL,NULL),(81,1,NULL,''富士达'',''任务'',''富士达'',NULL,NULL),(82,1,NULL,''21'',''12'',''21'',NULL,NULL),(86,1,NULL,''glyphicon-record'',''fds'',''fdsa'',999,0),(87,1,NULL,''glyphicon-record'',''1'',''1'',999,0),(88,0,NULL,''glyphicon-record'',''1'',''1'',999,0),(89,1,NULL,''glyphicon-record'',''超级管理员'',''/adminmanage'',13,0),(90,1,NULL,''glyphicon-record'',''新建流程'',''/xinxeng'',5,0);

/*Table structure for table `oa_task_list` */

CREATE TABLE `oa_task_list` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `is_cancel` int(11) DEFAULT ''0'',
  `is_top` int(11) DEFAULT ''0'',
  `modify_time` datetime DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `star_time` datetime DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `task_describe` varchar(255) NOT NULL,
  `ticking` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `task_push_user_id` bigint(20) DEFAULT NULL,
  `reciverlist` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK7qch0fh6s2y73dvngy1m87aw7` (`task_push_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_task_list` */

insert  into `oa_task_list`(`task_id`,`comment`,`end_time`,`is_cancel`,`is_top`,`modify_time`,`publish_time`,`star_time`,`status_id`,`task_describe`,`ticking`,`title`,`type_id`,`task_push_user_id`,`reciverlist`) values (1,''无法把淘宝'',''2017-09-10 00:00:00'',0,0,NULL,''2017-09-18 18:39:01'',''2017-09-09 00:00:00'',5,''入股'',NULL,''24日'',3,1,''罗密欧''),(13,''噁7ikea'',''2017-09-26 00:00:00'',1,1,NULL,''2017-09-18 18:41:48'',''2017-09-13 00:00:00'',3,''6uj'',NULL,''熱土啊u就'',3,1,''朱丽叶;伊丽莎白''),(14,'''',''2017-09-21 18:44:14'',0,1,''2017-09-20 18:44:20'',''2017-09-20 18:44:20'',''2017-09-20 18:44:14'',7,''給我如果 '',NULL,''的v我如果1111'',3,1,''朱丽叶;伊丽莎白''),(19,''tttbthhry'',''2017-09-21 13:49:33'',1,0,''2017-09-20 13:49:37'',''2017-09-20 13:49:37'',''2017-09-20 13:49:33'',7,''ergget'',NULL,''啦啦啦啦绿绿绿绿绿'',3,1,''朱丽叶;伊丽莎白''),(20,''1'',''2017-09-30 00:00:00'',1,1,NULL,''2017-09-16 15:54:10'',''2017-09-16 00:00:00'',3,''1'',NULL,''1'',3,1,''朱丽叶;伊丽莎白''),(21,''31'',''2017-09-14 00:00:00'',1,1,''2017-10-16 09:22:58'',''2017-10-16 09:22:58'',''2017-09-13 00:00:00'',7,''312'',NULL,''噼噼啪啪铺铺铺铺'',3,1,''朱丽叶;伊丽莎白''),(26,''犯得上'',''2017-09-12 00:00:00'',0,1,NULL,''2017-09-18 18:42:59'',''2017-09-07 00:00:00'',3,''富士達'',NULL,''飛灑'',3,1,''伊丽莎白''),(27,'''',''2017-09-21 13:33:36'',0,0,''2017-09-20 13:33:47'',''2017-09-20 13:33:47'',''2017-09-20 13:33:36'',3,''FDSA '',NULL,''的方法'',4,1,''朱丽叶''),(30,'''',''2017-09-21 13:27:51'',0,1,''2017-09-20 13:27:56'',''2017-09-20 13:27:56'',''2017-09-20 13:27:51'',3,''多对多'',NULL,''的'',4,1,''朱丽叶''),(31,'''',''2017-09-20 20:58:22'',0,0,''2017-09-19 21:01:16'',''2017-09-19 21:01:16'',''2017-09-19 20:58:22'',3,''点点滴滴'',NULL,''凄凄切切'',3,1,''朱丽叶;伊丽莎白''),(32,'''',''2017-09-24 12:48:55'',0,1,''2017-09-23 12:49:28'',''2017-09-23 12:49:28'',''2017-09-23 12:48:55'',3,''少时诵诗书'',NULL,''凄凄切切'',3,4,''soli;红之花''),(33,'''',''2017-09-24 12:49:44'',0,0,''2017-09-23 12:49:56'',''2017-09-23 12:49:56'',''2017-09-23 12:49:44'',3,''密密麻麻'',NULL,''哈哈哈'',3,4,''红之花''),(34,'' 烦死哒'',''2017-09-26 12:13:03'',0,1,''2017-10-16 09:34:02'',''2017-10-16 09:34:02'',''2017-09-25 12:13:03'',7,''烦死哒大多数'',NULL,''范德萨类型'',3,1,''朱丽叶''),(35,'''',''2017-09-26 16:39:29'',0,0,''2017-09-25 16:39:45'',''2017-09-25 16:39:45'',''2017-09-25 16:39:29'',3,''反反复复付'',NULL,''男男女女女'',3,1,''朱丽叶;伊丽莎白;小李父斯基''),(36,'''',''2017-09-26 16:39:51'',0,1,''2017-09-25 16:40:04'',''2017-09-25 16:40:04'',''2017-09-25 16:39:51'',3,''啦啦啦啦绿绿绿'',NULL,''斤斤计较军军'',3,1,''朱丽叶;伊丽莎白;小李父斯基''),(37,'''',''2017-09-26 16:40:16'',0,1,''2017-10-16 09:33:12'',''2017-10-16 09:33:12'',''2017-09-25 16:40:16'',7,''巴巴爸爸'',NULL,''啦啦啦啦木木木木'',3,1,''朱丽叶;伊丽莎白;小李父斯基''),(38,''123'',''2017-10-04 19:14:10'',0,1,''2017-10-16 09:33:52'',''2017-10-16 09:33:52'',''2017-10-03 19:14:10'',7,''231'',NULL,''221'',3,1,''伊丽莎白''),(39,'''',''2017-10-16 14:05:02'',0,1,''2017-10-15 14:05:39'',''2017-10-15 14:05:39'',''2017-10-15 14:05:02'',3,''he疼合同号'',NULL,''的vzfbhtrhet'',3,4,''甄嬛;无双''),(40,''地方撒'',''2017-10-17 09:29:41'',0,1,''2017-10-16 09:32:41'',''2017-10-16 09:32:41'',''2017-10-16 09:29:41'',5,''的说法'',NULL,''发给'',3,1,''朱丽叶''),(41,''nicw'',''2017-10-17 09:30:13'',0,1,''2017-10-16 09:33:41'',''2017-10-16 09:33:41'',''2017-10-16 09:30:13'',7,''完成了'',NULL,''哈哈'',3,1,''朱丽叶''),(42,'''',''2017-10-17 09:30:44'',0,1,''2017-10-16 09:32:52'',''2017-10-16 09:32:52'',''2017-10-16 09:30:44'',5,''已经完成'',NULL,''以完成'',3,1,''朱丽叶''),(43,''完成'',''2017-10-21 09:36:33'',0,0,''2017-10-20 09:37:01'',''2017-10-20 09:37:01'',''2017-10-20 09:36:33'',7,''任务完成'',NULL,''任务 '',3,5,''盛如思;李楚堂''),(44,'''',''2017-10-21 09:37:13'',0,0,''2017-10-20 09:37:46'',''2017-10-20 09:37:46'',''2017-10-20 09:37:13'',7,''ok'',NULL,''这个人已经完成'',3,5,''盛如思;李楚堂;支晓璇''),(45,'''',''2017-10-21 09:48:26'',0,0,''2017-10-20 09:48:40'',''2017-10-20 09:48:40'',''2017-10-20 09:48:26'',7,''ok'',NULL,''ok'',3,3,''soli;红之花''),(46,'''',''2017-10-21 09:52:49'',0,0,''2017-10-20 09:53:02'',''2017-10-20 09:53:02'',''2017-10-20 09:52:49'',7,''ok'',NULL,''ok'',3,6,''薛邵琴;光宇''),(47,'''',''2017-10-21 09:53:11'',0,0,''2017-10-20 09:53:51'',''2017-10-20 09:53:51'',''2017-10-20 09:53:11'',7,''月也彷徨'',NULL,''如今灯下闲读'',3,6,''光宇;朱茵''),(48,'''',''2017-10-21 09:54:59'',0,0,''2017-10-20 09:55:42'',''2017-10-20 09:55:42'',''2017-10-20 09:54:59'',7,''家乡月光'',NULL,''难诉衷肠'',3,4,''甄姬2;甄嬛'');

/*Table structure for table `oa_task_logger` */

CREATE TABLE `oa_task_logger` (
  `logger_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `logger_ticking` varchar(255) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `logger_statusid` int(11) DEFAULT NULL,
  PRIMARY KEY (`logger_id`),
  KEY `FK5gu0thq54i7ujc6cict009h4y` (`task_id`),
  CONSTRAINT `FK5gu0thq54i7ujc6cict009h4y` FOREIGN KEY (`task_id`) REFERENCES `oa_task_list` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_task_logger` */

insert  into `oa_task_logger`(`logger_id`,`create_time`,`logger_ticking`,`task_id`,`username`,`logger_statusid`) values (1,''2017-09-15 19:54:58'',''土豪阅海万家无可'',19,''罗密欧'',NULL),(3,''2017-09-15 21:17:31'',''heenrnm'',19,''罗密欧'',7),(4,''2017-09-15 21:19:13'',''ujw5ukj5wuk'',19,''罗密欧'',7),(5,''2017-09-15 21:22:34'',''yukd68kd6'',19,''罗密欧'',7),(6,''2017-09-15 21:23:19'',''fwrgqetbh'',19,''罗密欧'',7),(17,''2017-09-19 21:08:06'',''点点滴滴'',14,''罗密欧'',5),(29,''2017-09-22 13:42:21'',''立刻开口'',1,''罗密欧'',5),(30,''2017-10-15 14:04:36'','''',35,''小李父斯基'',4),(31,''2017-10-15 14:09:01'','''',39,''甄嬛'',4),(32,''2018-02-09 00:51:03'','''',34,''罗密欧'',7);

/*Table structure for table `oa_task_user` */

CREATE TABLE `oa_task_user` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `task_recive_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FK2714kl5ywm5chya4dxte8c788` (`task_id`),
  KEY `FK654dfo0oouy3fk07fs7rqo4ld` (`task_recive_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_task_user` */

insert  into `oa_task_user`(`pk_id`,`status_id`,`task_id`,`task_recive_user_id`) values (1,5,1,1),(6,7,19,2),(7,7,19,3),(8,3,20,2),(9,3,20,3),(10,7,21,2),(21,7,21,3),(24,3,13,2),(25,3,13,3),(26,7,14,2),(27,7,14,3),(28,3,26,3),(29,3,27,2),(32,3,30,2),(33,3,31,2),(34,3,31,3),(36,3,32,5),(37,3,32,6),(38,3,33,6),(39,7,34,2),(40,3,35,2),(41,3,35,3),(42,4,35,4),(43,3,36,2),(44,3,36,3),(45,3,36,4),(46,7,37,2),(47,7,37,3),(48,7,37,4),(49,7,38,3),(50,4,39,9),(51,3,39,10),(52,5,40,2),(53,7,41,2),(54,5,42,2),(55,7,43,14),(56,7,43,15),(57,7,44,14),(58,7,44,15),(59,7,44,16),(60,7,45,5),(61,7,45,6),(62,7,46,17),(63,7,46,18),(64,7,47,18),(65,7,47,19),(66,7,48,8),(67,7,48,9);

/*Table structure for table `oa_traffic` */

CREATE TABLE `oa_traffic` (
  `traffic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(255) DEFAULT NULL,
  `depart_time` datetime DEFAULT NULL,
  `reach_name` varchar(255) DEFAULT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `traffic_money` double DEFAULT NULL,
  `traffic_name` varchar(255) DEFAULT NULL,
  `evection_id` bigint(20) DEFAULT NULL,
  `user_name` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`traffic_id`),
  KEY `FKt5gk2fg5t802gnq8y03p9e7di` (`evection_id`),
  KEY `FKejkemcx58mfj2lgi2jo2rlih3` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_traffic` */

insert  into `oa_traffic`(`traffic_id`,`depart_name`,`depart_time`,`reach_name`,`seat_type`,`traffic_money`,`traffic_name`,`evection_id`,`user_name`) values (1,''长沙'',''2017-10-13 17:01:11'',''上海'',''二等座'',500,''高铁'',1,18),(2,''长沙'',''2017-10-16 00:10:06'',''广州'',''商务舱'',1200,''飞机'',2,18),(3,''广州'',''2017-10-18 00:11:12'',''长沙'',''商务舱'',1200,''飞机'',2,18),(4,''vv'',''2017-10-18 20:12:25'',''v'',''vv'',140,''vv'',3,10);

/*Table structure for table `oa_type_list` */

CREATE TABLE `oa_type_list` (
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_color` varchar(255) DEFAULT NULL,
  `type_model` varchar(255) DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `sort_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_type_list` */

insert  into `oa_type_list`(`type_id`,`type_color`,`type_model`,`type_name`,`sort_value`) values (1,''red'',''aoa_mailnumber'',''系统邮件'',0),(2,''red'',''aoa_mailnumber'',''公司邮件'',1),(3,''red'',''aoa_task_list'',''公事'',0),(4,''red'',''aoa_task_list'',''私事'',1),(5,''red'',''aoa_note_list'',''我的笔记'',0),(6,''red'',''aoa_note_list'',''公司笔记'',1),(7,''red'',''aoa_note_list'',''共享笔记'',2),(8,''red'',''aoa_attends_list'',''上班'',1),(9,''red'',''aoa_attends_list'',''下班'',2),(10,''red'',''inform'',''公告'',0),(11,''red'',''inform'',''通知'',1),(12,''red'',''inform'',''投票'',2),(13,''red'',''aoa_plan_list'',''日计划'',0),(14,''red'',''aoa_plan_list'',''周计划'',1),(15,''red'',''aoa_plan_list'',''月计划'',2),(16,''red'',''aoa_in_mail_list'',''邮件'',0),(17,''red'',''aoa_in_mail_list'',''通知'',1),(18,''red'',''aoa_in_mail_list'',''公告'',2),(19,''label-danger'',''chat'',''公告'',0),(20,''label-success'',''chat'',''讨论'',1),(21,''label-warning'',''chat'',''投票'',2),(22,''red'',''aoa_process_list'',''正常'',0),(23,''red'',''aoa_process_list'',''重要'',1),(24,''red'',''aoa_process_list'',''紧急'',2),(25,''red'',''aoa_bursement'',''银行卡'',0),(26,''red'',''aoa_bursement'',''现金'',1),(27,''red'',''aoa_bursement'',''其他'',2),(28,''red'',''aoa_evection'',''销售拜访'',0),(29,''red'',''aoa_evection'',''售前支持'',1),(30,''red'',''aoa_evection'',''项目支持'',2),(31,''red'',''aoa_evection'',''客服外出'',3),(32,''red'',''aoa_evection'',''其他'',4),(33,''red'',''aoa_overtime'',''工作日'',0),(34,''red'',''aoa_overtime'',''休息日'',1),(35,''red'',''aoa_overtime'',''节假日'',2),(36,''red'',''aoa_overtime'',''其他'',3),(37,''1、年假：工作满一年以上每年可享受带薪年假，当年的年假使用期至次年3月1日止；未经用人单位批准，员工不得自行休假。'',''aoa_holiday'',''年假'',7),(38,''2、事假：按照平均工作日扣发薪资（包含工资及各类补贴福利）；单次事假原则上不应超过3天，当年累计事假超过15天的视为主动放弃继续履行岗位职责的权利，特殊情况除外。  '',''aoa_holiday'',''事假'',4),(39,''3、病假：两天及以上病假必须持工作地二级甲等以上医院相关病假证明单或就医记录证明，否则无法享受病假工资；单次病假超过5天，应当持有工作所在地三级甲等医院提供的病假证明单。原则上当年累计病假超过15天应视为不具备继续履行岗位职责身体条件，特殊情况除外。  '',''aoa_holiday'',''病假'',NULL),(40,''4、婚假：婚假为十天，包含休息日，请婚假必须持结婚证明，结婚证必须在泛微工作期间领取，且婚假必须在一年内使用完毕，不得分次休假，国家或地方政府有其他规定的按照当地要求执行；  '',''aoa_holiday'',''婚假'',10),(41,''5、产假及哺乳假：按国家及地方法律法规执行，包含休息日与法定节假日；  '',''aoa_holiday'',''产假及哺乳假'',180),(42,''6、陪产假：泛微正式男性员工在工作期间配偶生育的，可凭子女出生证明，享受十个自然日陪产假。  '',''aoa_holiday'',''陪产假'',10),(43,''7、丧假：直系亲属：配偶、子女、父母可享受三天，岳父母、祖父母、外祖父母可享受一天'',''aoa_holiday'',''丧假'',NULL),(44,'''',''aoa_schedule_list'',''日程提醒'',0),(45,'''',''aoa_schedule_list'',''假日安排'',1),(46,''red'',''aoa_attends_list'',''请假'',3),(47,''red'',''aoa_attends_list'',''出差'',4);

/*Table structure for table `oa_url_info` */

CREATE TABLE `oa_url_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(150) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT ''描述'',
  `gmt_create` date DEFAULT NULL COMMENT ''创建时间'',
  `enable` tinyint(1) DEFAULT NULL COMMENT ''是否有效'',
  `request_type` varchar(10) DEFAULT NULL COMMENT ''请求类型'',
  `class_name` varchar(255) DEFAULT NULL COMMENT ''类名'',
  `method_name` varchar(255) DEFAULT NULL COMMENT ''方法名'',
  `parent_id` bigint(20) DEFAULT NULL COMMENT ''父行id'',
  `parent_url` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=463771663068340244 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_url_info` */

insert  into `oa_url_info`(`id`,`url`,`description`,`gmt_create`,`enable`,`request_type`,`class_name`,`method_name`,`parent_id`,`parent_url`) values (1,'''',''管理员'',''2020-06-10'',1,NULL,NULL,NULL,NULL,NULL),(463771663068340238,''/poseidon/oa-url-info'',''URL信息接口'',''2020-06-08'',1,''POST'',''com.muggle.poseidon.oa.controller.OaUrlInfoController'',NULL,NULL,NULL),(463771663068340239,''/poseidon/oa-url-info/query_url'',''查询url  该查询接口后端使用的是查询组件 （查询组件使用方式请看文档）'',''2020-06-08'',1,''POST'',''com.muggle.poseidon.oa.controller.OaUrlInfoController'',''getUrlInfo'',467387852474589184,''/poseidon/oa-url-info''),(463771663068340240,''/user'',NULL,''2020-06-08'',1,''GET'',''com.muggle.poseidon.oa.controller.UserController'',NULL,NULL,NULL),(463771663068340241,''/user/info'',''查询用户信息（受权限控制）'',''2020-06-08'',1,''GET'',''com.muggle.poseidon.oa.controller.UserController'',''getUserInfo'',467387852474589186,''/user''),(463771663068340242,''/user/my_info.json'',''查询当前用户信息（受权限控制）'',''2020-06-08'',1,''GET'',''com.muggle.poseidon.oa.controller.UserController'',''getMyUserInfo'',467387852474589186,''/user''),(463771663068340243,''/user/regester.json'',''注册用户'',''2020-06-08'',1,''POST'',''com.muggle.poseidon.oa.controller.UserController'',''regester'',467387852474589186,''/user'');

/*Table structure for table `oa_user_info` */

CREATE TABLE `oa_user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL COMMENT ''地址'',
  `bank` varchar(30) DEFAULT NULL COMMENT ''银行卡号'',
  `birth` datetime DEFAULT NULL COMMENT ''生日'',
  `eamil` varchar(30) DEFAULT NULL COMMENT ''邮箱'',
  `hire_time` datetime DEFAULT NULL COMMENT ''入职时间'',
  `id_card` varchar(30) DEFAULT NULL COMMENT ''身份证号码'',
  `img_path` varchar(255) DEFAULT NULL COMMENT ''头像'',
  `account_non_locked` tinyint(1) DEFAULT NULL COMMENT ''未锁定'',
  `last_login_ip` varchar(25) DEFAULT NULL COMMENT ''上次登录ip'',
  `last_login_time` datetime DEFAULT NULL COMMENT ''上次登录时间'',
  `gmt_modified` datetime DEFAULT NULL,
  `modify_user_id` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT ''密码'',
  `real_name` varchar(20) DEFAULT NULL COMMENT ''真实姓名'',
  `salary` float DEFAULT NULL COMMENT ''用户薪水'',
  `user_school` varchar(100) DEFAULT NULL COMMENT ''毕业院校'',
  `gender` tinyint(1) DEFAULT NULL COMMENT ''性别'',
  `user_edu` varchar(10) DEFAULT NULL COMMENT ''学历'',
  `username` varchar(50) DEFAULT NULL COMMENT ''用户名'',
  `user_sign` varchar(255) DEFAULT NULL COMMENT ''个性签名'',
  `user_tel` varchar(20) DEFAULT NULL,
  `holiday` int(11) DEFAULT NULL COMMENT ''在职天数'',
  `nickname` varchar(20) DEFAULT NULL COMMENT ''昵称'',
  `account_non_expired` tinyint(1) DEFAULT ''1'' COMMENT ''未过期'',
  `credentials_non_expired` tinyint(1) DEFAULT ''1'' COMMENT ''凭证有效'',
  `enabled` tinyint(1) DEFAULT ''1'' COMMENT ''可用'',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_username` (`username`) COMMENT ''用户名唯一索引''
) ENGINE=InnoDB AUTO_INCREMENT=466237207096893441 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_user_info` */

insert  into `oa_user_info`(`user_id`,`address`,`bank`,`birth`,`eamil`,`hire_time`,`id_card`,`img_path`,`account_non_locked`,`last_login_ip`,`last_login_time`,`gmt_modified`,`modify_user_id`,`password`,`real_name`,`salary`,`user_school`,`gender`,`user_edu`,`username`,`user_sign`,`user_tel`,`holiday`,`nickname`,`account_non_expired`,`credentials_non_expired`,`enabled`) values (466237207096893440,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,''0:0:0:0:0:0:0:1'',''2020-06-10 03:24:12'',''2020-06-10 03:24:12'',NULL,''$2a$10$9oOzAr6TJ0pg.tylLPLaUOUI1XCQ4.nd6/y3SHiXJfh0nf488gNxy'',NULL,NULL,NULL,1,NULL,''muggle'',NULL,NULL,NULL,NULL,1,1,1);

/*Table structure for table `oa_user_login_record` */

CREATE TABLE `oa_user_login_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `browser` varchar(20) DEFAULT NULL,
  `ip_addr` varchar(25) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FKks6qpqj3ss4e4timjt0xok1p0` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_user_login_record` */

/*Table structure for table `oa_user_role_relation` */

CREATE TABLE `oa_user_role_relation` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `relation_code` varchar(150) DEFAULT NULL COMMENT ''冗余字段'',
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_user_role_relation` */

insert  into `oa_user_role_relation`(`user_id`,`role_id`,`relation_code`,`username`) values (466237207096893440,1,''ADMIN'',''muggle''),(466237207096893440,2,''GUEST'',''muggle'');

/*Table structure for table `oa_vote_list` */

CREATE TABLE `oa_vote_list` (
  `vote_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_time` datetime DEFAULT NULL,
  `selectone` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_vote_list` */

insert  into `oa_vote_list`(`vote_id`,`end_time`,`selectone`,`start_time`) values (1,''2017-10-04 21:52:48'',1,''2017-10-03 21:52:48''),(2,''2017-10-04 21:54:36'',1,''2017-10-03 21:54:36''),(3,''2017-10-04 23:18:52'',1,''2017-10-03 23:18:52''),(4,''2017-10-03 02:57:33'',2,''2017-10-04 02:57:33''),(5,''2017-10-05 03:18:25'',1,''2017-10-04 03:18:25''),(7,''2017-10-30 15:27:03'',2,''2017-10-27 15:27:03''),(8,''2017-10-18 16:01:25'',2,''2017-10-04 16:01:25''),(9,''2017-10-06 22:53:22'',2,''2017-10-05 22:53:22''),(10,''2017-10-06 22:56:45'',2,''2017-10-05 22:56:45''),(11,''2017-10-06 22:57:59'',1,''2017-10-05 22:57:59''),(12,''2017-10-13 23:25:24'',1,''2017-10-12 23:25:24'');

/*Table structure for table `oa_vote_title_user` */

CREATE TABLE `oa_vote_title_user` (
  `vote_title_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vote_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `title_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vote_title_user_id`),
  KEY `FKb2pou179gr3wf10lx0wy6qrli` (`user_id`),
  KEY `FK79ia8m9w7faxi7wmth7or8mqg` (`title_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_vote_title_user` */

insert  into `oa_vote_title_user`(`vote_title_user_id`,`vote_id`,`user_id`,`title_id`) values (1,3,1,7),(2,3,2,8),(3,3,3,9),(4,3,4,7),(5,1,2,2),(6,2,2,4),(7,4,2,11),(8,4,2,12),(9,4,2,13),(13,5,2,15),(17,8,2,23),(18,8,2,24),(19,8,2,25),(20,11,2,32),(21,8,1,23),(22,8,1,24),(23,8,1,25);

/*Table structure for table `oa_vote_titles` */

CREATE TABLE `oa_vote_titles` (
  `title_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `vote_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`title_id`),
  KEY `FKnl21d99b8hc6gtfrrfsc9alge` (`vote_id`),
  CONSTRAINT `FKnl21d99b8hc6gtfrrfsc9alge` FOREIGN KEY (`vote_id`) REFERENCES `oa_vote_list` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

/*Data for the table `oa_vote_titles` */

insert  into `oa_vote_titles`(`title_id`,`color`,`title`,`vote_id`) values (1,''#5bc0de'',''22222'',1),(2,''#5bc0de'',''111111'',1),(3,''#5bc0de'',''33333'',1),(4,''#5bc0de'',''我的33333'',2),(5,''#5bc0de'',''你的2222222'',2),(6,''#5bc0de'',''他的44444'',2),(7,''#7589d2'',''fsdfadsf'',3),(8,''#292fce'',''fsafas'',3),(9,''#5af4a3'',''dfa '',3),(10,''#5bc0de'',''他的44444'',3),(11,''#8d0282'',''多选2 '',4),(12,''#57427f'',''多选三'',4),(13,''#29bcfc'',''多选1'',4),(14,''#79d8b7'',''去泰国'',5),(15,''#4a7647'',''哇塞，去香港'',5),(16,''#5627a7'',''去北京'',5),(20,''#6653e0'',''222'',7),(21,''#af8675'',''1111'',7),(22,''#4414e5'',''333'',7),(23,''#9cb08f'',''32131'',8),(24,''#72e6e2'',''31231'',8),(25,''#9a46f7'',''112312'',8),(26,''#8da9b7'',''大师傅3'',9),(27,''#efe79f'',''大师傅'',9),(28,''#118a0a'',''这是投票4'',10),(29,''#1c6035'',''这是投票1'',10),(30,''#bf617e'',''这是投票3'',10),(31,''#97dc10'',''这是投票2'',10),(32,''#b90601'',''范德萨'',11),(33,''#4c6a51'',''电风扇'',11),(34,''#4504de'',''范德萨'',12),(35,''#530145'',''地方撒'',12);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
