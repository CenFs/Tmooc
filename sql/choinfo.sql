/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for choinfo
-- ----------------------------
DROP TABLE IF EXISTS `choinfo`;
CREATE TABLE `choinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `courseid` int(5) DEFAULT NULL,
  `studentid` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studentid` (`studentid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `choinfo_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `stuinfo` (`studentid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `choinfo_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choinfo
-- ----------------------------
