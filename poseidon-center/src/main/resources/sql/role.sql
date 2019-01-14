/*
Navicat MySQL Data Transfer

Source Server         : 119.23.75.58
Source Server Version : 50724
Source Host           : 119.23.75.58:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-04 16:23:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `hash_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_id` bigint(20) DEFAULT NULL,
  `delete_id` bigint(20) DEFAULT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `enable` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`delete_time`) USING BTREE,
  UNIQUE KEY `role_code` (`role_code`,`delete_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('846949099369111552', 'admin:', null, '超级管理员', '0', '2019-01-01 12:29:16', null, null, null, null, null, '1');
