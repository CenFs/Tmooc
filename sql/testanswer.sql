/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:55:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for testanswer
-- ----------------------------
DROP TABLE IF EXISTS `testanswer`;
CREATE TABLE `testanswer` (
  `answerpaperid` int(5) NOT NULL AUTO_INCREMENT,
  `courseid` int(5) DEFAULT '222',
  `paperid` int(5) DEFAULT NULL,
  `teacherid` int(5) DEFAULT '61364',
  `studentid` int(5) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`answerpaperid`),
  KEY `courseid` (`courseid`),
  KEY `paperid` (`paperid`),
  KEY `teacherid` (`teacherid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `testanswer_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `testanswer_ibfk_2` FOREIGN KEY (`paperid`) REFERENCES `test` (`paperid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `testanswer_ibfk_3` FOREIGN KEY (`studentid`) REFERENCES `stuinfo` (`studentid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `testanswer_ibfk_4` FOREIGN KEY (`teacherid`) REFERENCES `teacherinfo` (`teacherid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testanswer
-- ----------------------------
INSERT INTO `testanswer` VALUES ('1', '222', '5', '61364', '61234', '77', 'a');
INSERT INTO `testanswer` VALUES ('2', '333', '5', '61023', '61234', '88', 'b');
INSERT INTO `testanswer` VALUES ('3', '222', '5', '61023', '63234', '23', 'a');
INSERT INTO `testanswer` VALUES ('9', '222', '4', '61364', '61234', null, 'yes');
INSERT INTO `testanswer` VALUES ('10', '222', '1', '61364', '61234', null, 'wo');
INSERT INTO `testanswer` VALUES ('11', '222', '1', '61364', '61234', null, 'wo~~');
INSERT INTO `testanswer` VALUES ('12', '222', '4', '61364', '61234', null, 'yes~!!');
INSERT INTO `testanswer` VALUES ('13', '222', '3', '61364', '61234', null, '-3 -4');
INSERT INTO `testanswer` VALUES ('14', '222', '4', '61364', '61234', null, 'no!');
