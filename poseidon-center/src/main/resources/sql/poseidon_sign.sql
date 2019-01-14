/*
Navicat MySQL Data Transfer

Source Server         : 119.23.75.58
Source Server Version : 50724
Source Host           : 119.23.75.58:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-04 16:22:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for poseidon_sign
-- ----------------------------
DROP TABLE IF EXISTS `poseidon_sign`;
CREATE TABLE `poseidon_sign` (
  `id` bigint(20) NOT NULL,
  `auth_type` varchar(50) DEFAULT NULL,
  `principal` varchar(100) DEFAULT NULL,
  `credentials` varchar(100) DEFAULT NULL,
  `enable` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `principal` (`principal`,`delete_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of poseidon_sign
-- ----------------------------
