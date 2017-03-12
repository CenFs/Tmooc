/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 11:02:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `courseid` int(5) NOT NULL,
  `coursename` varchar(100) DEFAULT NULL,
  `teachername` varchar(100) DEFAULT NULL,
  `teacherid` int(5) DEFAULT NULL,
  `coursetype` int(1) DEFAULT NULL,
  `studentnum` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`courseid`),
  KEY `teacherid` (`teacherid`),
  KEY `teachername` (`teachername`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `courseinfo_ibfk_1` FOREIGN KEY (`teacherid`) REFERENCES `teacherinfo` (`teacherid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `courseinfo_ibfk_2` FOREIGN KEY (`teachername`) REFERENCES `teacherinfo` (`teachername`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseinfo
-- ----------------------------
INSERT INTO `courseinfo` VALUES ('1', '111', '计算机网络', '辛雯', '61364', '21', '1');
INSERT INTO `courseinfo` VALUES ('2', '222', '计算机系统结构', '赵欣然', '61351', '22', '2');
INSERT INTO `courseinfo` VALUES ('3', '333', '数字逻辑', '张雨', '61147', '23', '3');
INSERT INTO `courseinfo` VALUES ('4', '444', '编译原理', '白静宜', '61023', '24', '4');
