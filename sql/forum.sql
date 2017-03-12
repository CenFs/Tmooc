/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `forumid` int(5) NOT NULL,
  `forumname` varchar(100) DEFAULT NULL,
  `foruminformation` varchar(255) DEFAULT NULL,
  `forumdate` date DEFAULT NULL,
  `forummainid` int(5) DEFAULT NULL,
  `forumtype` int(1) DEFAULT NULL,
  `studentid` int(5) NOT NULL,
  PRIMARY KEY (`id`,`forumid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `studentid` FOREIGN KEY (`studentid`) REFERENCES `stuinfo` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('1', '111', '求语文书', '卧槽卧槽卧槽我特么没带书快借我一本跪求', '2015-07-12', '111', '1', '61234');
INSERT INTO `forum` VALUES ('2', '112', '沙比', '啊 我也没有', '2015-07-12', '111', '2', '62234');
INSERT INTO `forum` VALUES ('3', '113', '哈哈', '哈哈哈沙比了吧', '2015-07-12', '111', '2', '63234');
INSERT INTO `forum` VALUES ('4', '114', 'test', 'testtest', '2015-07-14', null, null, '61234');
INSERT INTO `forum` VALUES ('5', '115', 'hehehe', 'heiheihaha', '2015-07-14', null, null, '61234');
INSERT INTO `forum` VALUES ('7', '116', 'forumsendtest', 'wo yao fa tie a ~~', '2015-07-15', null, null, '61234');
INSERT INTO `forum` VALUES ('8', '117', 'hehehaa', 'hehe', '2015-07-15', null, null, '61234');
INSERT INTO `forum` VALUES ('9', '118', 'hhh', 'aaa', '2015-07-15', null, null, '61234');
INSERT INTO `forum` VALUES ('10', '119', 'nihao', 'helloworld', '2015-07-15', null, null, '61234');
INSERT INTO `forum` VALUES ('11', '120', 'shishi', 'testtest24567', '2015-07-15', null, null, '61234');
INSERT INTO `forum` VALUES ('12', '121', '5', '123', '2015-07-15', null, null, '66665');
