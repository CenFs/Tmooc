/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 11:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `boardid` int(5) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`,`boardid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '150707', '缺少语文课本2本', '请同学们自行购买语文书', '2015-07-07');
INSERT INTO `board` VALUES ('2', '150710', '缺少英语课本1本', '请同学们自行购买英语书', '2015-07-10');
INSERT INTO `board` VALUES ('3', '150713', '通知公告', 'tmooc通知公告测试', '2015-07-13');
