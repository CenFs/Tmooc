/*
Navicat MySQL Data Transfer

Source Server         : db_tmooc
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tmooc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-07-16 09:54:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `dataid` int(5) NOT NULL,
  `courseid` int(5) DEFAULT NULL,
  `dataname` varchar(100) DEFAULT NULL,
  `datapath` varchar(255) DEFAULT NULL,
  `datadate` date DEFAULT NULL,
  PRIMARY KEY (`id`,`dataid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `data_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('1', '1', '111', 'test.jpg', 'http://localhost:8080/tmoocSystem-zz/DownloadData/test.jpg', '2015-07-14');
INSERT INTO `data` VALUES ('2', '2', '111', 'log.txt', 'http://localhost:8080/tmoocSystem-zz/DownloadData/log.txt', '2015-07-14');
INSERT INTO `data` VALUES ('3', '3', '333', 'testcase.doc', 'http://localhost:8080/tmoocSystem-zz/DownloadData/testcase.doc', '2015-07-14');
INSERT INTO `data` VALUES ('4', '4', '222', '0714.txt', 'http://localhost:8080/tmoocSystem-zz/DownloadData/0714.txt', '2015-07-14');
INSERT INTO `data` VALUES ('5', '5', '111', 'development.xlsx', 'http://localhost:8080/tmoocSystem-zz/DownloadData/development.xlsx', '2015-07-14');
