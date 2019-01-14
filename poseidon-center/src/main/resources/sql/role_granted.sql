/*
Navicat MySQL Data Transfer

Source Server         : 119.23.75.58
Source Server Version : 50724
Source Host           : 119.23.75.58:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-04 16:23:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_granted
-- ----------------------------
DROP TABLE IF EXISTS `role_granted`;
CREATE TABLE `role_granted` (
  `id` bigint(20) NOT NULL,
  `granted_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_granted
-- ----------------------------
INSERT INTO `role_granted` VALUES ('846949099369111555', '846949099369111554', '846949099369111552');
