/*
Navicat MySQL Data Transfer

Source Server         : 119.23.75.58
Source Server Version : 50724
Source Host           : 119.23.75.58:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-04 16:22:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for poseidon_granted_authority
-- ----------------------------
DROP TABLE IF EXISTS `poseidon_granted_authority`;
CREATE TABLE `poseidon_granted_authority` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `enable` tinyint(4) DEFAULT NULL,
  `hash_code` varchar(255) DEFAULT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_id` bigint(20) DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `method` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`authority`,`delete_time`) USING BTREE,
  UNIQUE KEY `url` (`delete_time`,`url`,`method`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poseidon_granted_authority
-- ----------------------------
INSERT INTO `poseidon_granted_authority` VALUES ('846949099369111554', 'ROLE_admin', '超级管理员', '1', '1498420629', null, '2019-01-01 15:38:32', null, null, null, null, '/**', 'ALL');
