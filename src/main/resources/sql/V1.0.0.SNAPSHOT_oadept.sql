/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.29-log : Database - p_oa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
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

insert  into `oa_dept`(`dept_id`,`dept_addr`,`dept_fax`,`dept_name`,`dept_tel`,`email`,`deptmanager`,`end_time`,`start_time`) values (1,'五楼',NULL,'总经办','888888888','hq@fjhirg.com',3,'2017-11-15 22:50:05','2017-11-07 22:50:11'),(2,'四楼',NULL,'研发部','66666666','as@fwgh',4,'2017-09-13 19:04:07','2010-05-23 00:00:00'),(3,'三楼',NULL,'财务部','233333','153@qq.com',5,'2017-09-19 16:46:26','2016-09-19 16:46:32'),(4,'六楼',NULL,'市场部','666888','aaluoxiang@foxmail.com',6,'2016-07-19 16:48:09','2014-09-19 16:48:20'),(5,'六楼',NULL,'人事部','33332222','103@qq.com',7,'2017-10-07 14:12:05','2017-05-09 14:12:14');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
