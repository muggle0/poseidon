/*
Navicat MySQL Data Transfer

Source Server         : 119.23.75.58
Source Server Version : 50724
Source Host           : 119.23.75.58:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-04 16:23:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for poseidon_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `poseidon_user_detail`;
CREATE TABLE `poseidon_user_detail` (
  `id` bigint(20) NOT NULL COMMENT 'user_detail',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL,
  `account_non_expired` tinyint(4) DEFAULT '1' COMMENT '账户未过期',
  `account_non_locked` tinyint(4) DEFAULT '1' COMMENT '账户未上锁',
  `credentials_non_expired` tinyint(4) DEFAULT '1' COMMENT '凭证未过期',
  `enabled` tinyint(2) DEFAULT '1' COMMENT '激活',
  `hash_code` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `creat_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hash_cod` (`hash_code`),
  UNIQUE KEY `username` (`username`,`delete_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poseidon_user_detail
-- ----------------------------
INSERT INTO `poseidon_user_detail` VALUES ('846949099364917248', 'admin', 'muggle', '$2a$10$2jMu7YFj5kLLuQU87eSjn.9r3WSrykzJZWWNu/Prz/m2yxrncQF42', '1', '1', '1', '1', null, 'localhost:8080/resources/admin.jpg', null, '2019-01-01 11:38:53', null, null, null, '1', '1977339740@qq.com');
