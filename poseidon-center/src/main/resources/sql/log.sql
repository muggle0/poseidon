/*
 Navicat Premium Data Transfer

 Source Server         : vim
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 192.168.56.128:3306
 Source Schema         : log

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 21/05/2019 20:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event`  (
  `timestmp` bigint(20) NOT NULL,
  `formatted_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `logger_name` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level_string` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `thread_name` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reference_flag` smallint(6) NULL DEFAULT NULL,
  `arg0` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `arg1` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `arg2` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `arg3` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `caller_filename` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `caller_class` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `caller_method` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `caller_line` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logging_event
-- ----------------------------
INSERT INTO `logging_event` VALUES (1551160220963, 'Time-Consuming : 339 ms ,startTime 1551160220624', 'requestLog', 'INFO', 'main', 0, '339', '1551160220624', NULL, NULL, '?', '?', '?', '-1', 46);
INSERT INTO `logging_event` VALUES (1551160295768, 'Time-Consuming : 41 ms ,startTime 1551160295727', 'requestLog', 'INFO', 'main', 0, '41', '1551160295727', NULL, NULL, '?', '?', '?', '-1', 47);
INSERT INTO `logging_event` VALUES (1551160295872, 'URL : http://localhost/v1/doc/processing_charges_parent, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [{}] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/processing_charges_parent', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 48);
INSERT INTO `logging_event` VALUES (1551160426928, 'Time-Consuming : 37 ms ,startTime 1551160426891', 'requestLog', 'INFO', 'main', 0, '37', '1551160426891', NULL, NULL, '?', '?', '?', '-1', 49);
INSERT INTO `logging_event` VALUES (1551160596143, 'Time-Consuming : 65 ms ,startTime 1551160596078', 'requestLog', 'INFO', 'main', 0, '65', '1551160596078', NULL, NULL, '?', '?', '?', '-1', 50);
INSERT INTO `logging_event` VALUES (1551160596254, 'URL : http://localhost/v1/doc/doccustomer, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/doccustomer', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 51);
INSERT INTO `logging_event` VALUES (1551160704487, 'Time-Consuming : 40 ms ,startTime 1551160704447', 'requestLog', 'INFO', 'main', 0, '40', '1551160704447', NULL, NULL, '?', '?', '?', '-1', 52);
INSERT INTO `logging_event` VALUES (1551160704536, 'URL : http://localhost/v1/doc/gold_wage, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/gold_wage', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 53);
INSERT INTO `logging_event` VALUES (1551161404692, 'Time-Consuming : 5666 ms ,startTime 1551161399026', 'requestLog', 'INFO', 'main', 0, '5666', '1551161399026', NULL, NULL, '?', '?', '?', '-1', 54);
INSERT INTO `logging_event` VALUES (1551161404743, 'URL : http://localhost/v1/doc/gold_wage, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/gold_wage', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 55);
INSERT INTO `logging_event` VALUES (1551161461028, 'Time-Consuming : 4485 ms ,startTime 1551161456543', 'requestLog', 'INFO', 'main', 0, '4485', '1551161456543', NULL, NULL, '?', '?', '?', '-1', 56);
INSERT INTO `logging_event` VALUES (1551161486925, 'URL : http://localhost/v1/doc/gold_wage, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/gold_wage', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 57);
INSERT INTO `logging_event` VALUES (1551163010524, 'Time-Consuming : 39 ms ,startTime 1551163010485', 'requestLog', 'INFO', 'main', 0, '39', '1551163010485', NULL, NULL, '?', '?', '?', '-1', 58);
INSERT INTO `logging_event` VALUES (1551163010546, 'URL : http://localhost/v1/doc/gold_wage, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [{\"goldWageId\":123,\"refProcessId\":null,\"rowNum\":null,\"refFittingsId\":null,\"refMaterialId\":null,\"refKindId\":null,\"refGradeId\":null,\"lossStandard\":null,\"wage\":null,\"wageG\":null,\"remark\":null,\"corpId\":null,\"hiCode\":null,\"rowStatus\":null,\"createdId\":null,\"createdTime\":null,\"modifierId\":null,\"modifiedTime\":null,\"resourceFlag\":null,\"boolClose\":null}] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/gold_wage', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 59);
INSERT INTO `logging_event` VALUES (1551163195083, 'Time-Consuming : 2623 ms ,startTime 1551163192460', 'requestLog', 'INFO', 'main', 0, '2623', '1551163192460', NULL, NULL, '?', '?', '?', '-1', 60);
INSERT INTO `logging_event` VALUES (1551163195843, 'URL : http://localhost/v1/doc/gold_wage, 登录id: 262187798642307072 ,HTTP Method: GET,ip :127.0.0.1,Request Args : [{\"goldWageId\":123,\"refProcessId\":null,\"rowNum\":null,\"refFittingsId\":null,\"refMaterialId\":null,\"refKindId\":null,\"refGradeId\":null,\"lossStandard\":null,\"wage\":null,\"wageG\":null,\"remark\":null,\"corpId\":null,\"hiCode\":null,\"rowStatus\":null,\"createdId\":null,\"createdTime\":null,\"modifierId\":null,\"modifiedTime\":null,\"resourceFlag\":null,\"boolClose\":null}] 请求状态码：200', 'requestLog', 'INFO', 'main', 0, 'http://localhost/v1/doc/gold_wage', '262187798642307072', 'GET', '127.0.0.1', '?', '?', '?', '-1', 61);
INSERT INTO `logging_event` VALUES (1551180817327, 'Time-Consuming : 158 ms ,startTime 1551180817169', 'requestLog', 'INFO', 'main', 0, '158', '1551180817169', NULL, NULL, '?', '?', '?', '-1', 62);

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception`  (
  `event_id` bigint(20) NOT NULL,
  `i` smallint(6) NOT NULL,
  `trace_line` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`event_id`, `i`) USING BTREE,
  CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property`  (
  `event_id` bigint(20) NOT NULL,
  `mapped_key` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mapped_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`event_id`, `mapped_key`) USING BTREE,
  CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
