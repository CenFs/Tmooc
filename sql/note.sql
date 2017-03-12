/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `noteid` int(5) NOT NULL,
  `studentid` int(5) DEFAULT NULL,
  `notetitle` varchar(100) DEFAULT NULL,
  `notetext` varchar(255) DEFAULT NULL,
  `notedate` date DEFAULT NULL,
  PRIMARY KEY (`id`,`noteid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `stuinfo` (`studentid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', '1', '61234', '我试试', '真的挺开心的 哈哈哈没啥大事', '2015-07-07');
INSERT INTO `note` VALUES ('2', '2', '62234', '321', '今天太6了', '2015-07-16');
INSERT INTO `note` VALUES ('3', '3', '61234', '1234567', '开心极了没带语文书', '2015-07-12');
