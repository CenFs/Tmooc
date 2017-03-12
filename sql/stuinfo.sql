/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `studentid` int(5) NOT NULL,
  `studentname` varchar(100) DEFAULT NULL,
  `studentpwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`studentid`),
  KEY `studentid` (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuinfo
-- ----------------------------
INSERT INTO `stuinfo` VALUES ('1', '61234', '李虎', '123');
INSERT INTO `stuinfo` VALUES ('2', '62234', '马驰', '456');
INSERT INTO `stuinfo` VALUES ('3', '63234', '马锐', '789');
INSERT INTO `stuinfo` VALUES ('8', '66665', 'stella', '98789');
