/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `paperid` int(11) NOT NULL,
  `papername` varchar(20) CHARACTER SET utf8 NOT NULL,
  `questiontype` int(11) NOT NULL,
  `question` varchar(20) CHARACTER SET utf8 NOT NULL,
  `option1` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `option2` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `option3` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `option4` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `studentid` int(5) DEFAULT NULL,
  PRIMARY KEY (`questionid`),
  KEY `paperid` (`paperid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `stuinfo` (`studentid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '1', '语文试卷', '1', '以下读音不同的事？', '我', '窝', '喔', '蜗', '61234');
INSERT INTO `test` VALUES ('2', '2', '语文试卷', '4', '三顾茅庐和三顾冒菜有什么区别？', null, null, null, null, '61234');
INSERT INTO `test` VALUES ('3', '3', '数学试卷', '2', '以下哪个是负数', '1', '2', '-3', '-4', '61234');
INSERT INTO `test` VALUES ('4', '4', '英语试卷', '3', 'hello是你好的意思吗', '是', '否', null, null, '61234');
INSERT INTO `test` VALUES ('5', '5', '语文试卷', '1', '以下读音不同的事？', '我', '窝', '喔', '蜗', '62234');
INSERT INTO `test` VALUES ('6', '6', '语文试卷', '4', '三顾茅庐和三顾冒菜有什么区别？', '', '', '', '', '62234');
INSERT INTO `test` VALUES ('7', '7', '数学试卷', '2', '以下哪个是负数', '1', '2', '-3', '-4', '62234');
INSERT INTO `test` VALUES ('8', '8', '英语试卷', '3', 'hello是你好的意思吗', '是', '否', '', '', '62234');
INSERT INTO `test` VALUES ('9', '9', '语文试卷', '1', '以下读音不同的事？', '我', '窝', '喔', '蜗', '66665');
INSERT INTO `test` VALUES ('10', '10', '语文试卷', '4', '三顾茅庐和三顾冒菜有什么区别？', '', '', '', '', '66665');
INSERT INTO `test` VALUES ('11', '11', '数学试卷', '2', '以下哪个是负数', '1', '2', '-3', '-4', '66665');
INSERT INTO `test` VALUES ('12', '12', '英语试卷', '3', 'hello是你好的意思吗', '是', '否', '', '', '66665');
