/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `teacherid` int(5) NOT NULL,
  `teachername` varchar(100) DEFAULT NULL,
  `teacherpwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacherid`),
  KEY `teacherid` (`teacherid`),
  KEY `teachername` (`teachername`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('1', '61364', '辛雯', '123');
INSERT INTO `teacherinfo` VALUES ('2', '61351', '赵欣然', '321');
INSERT INTO `teacherinfo` VALUES ('3', '61147', '张雨', '456');
INSERT INTO `teacherinfo` VALUES ('4', '61023', '白静宜', '654');
