/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : userdb

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-02-03 11:02:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_gender
-- ----------------------------
DROP TABLE IF EXISTS `t_gender`;
CREATE TABLE `t_gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gender
-- ----------------------------
INSERT INTO `t_gender` VALUES ('1', 'boy');
INSERT INTO `t_gender` VALUES ('2', 'gril');

-- ----------------------------
-- Table structure for t_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` varchar(32) DEFAULT NULL COMMENT '科目',
  `user_id` int(11) DEFAULT NULL,
  `grade` float(15,0) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '语文', '1', '98');
INSERT INTO `t_grade` VALUES ('2', '数学', '1', '88');
INSERT INTO `t_grade` VALUES ('3', '英语', '1', '100');
INSERT INTO `t_grade` VALUES ('4', '历史', '2', '100');

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `pay_card` varchar(21) DEFAULT NULL COMMENT '卡号',
  `momey` float DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pay
-- ----------------------------
INSERT INTO `t_pay` VALUES ('1', '公众号 聊点', '6626881209089045', '199900');
INSERT INTO `t_pay` VALUES ('2', '架构师知音', '6566881209089067', '200000');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '出生年月日',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `photo` varchar(100) DEFAULT NULL COMMENT '头像路径',
  `mobile_no` varchar(30) NOT NULL COMMENT '手机号',
  `gender_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '聊点', '2019-02-03 10:23:23', 'happyhuangjinjin@sina.com', '公众号 聊点', '/user/pic/4.png', '13711645813', '1');
INSERT INTO `t_user` VALUES ('2', '聊点', '2019-02-02 21:28:46', 'happyhuangjinjin@sina.com', '公众号 聊点', '/user/pic/4.png', '13711645813', '2');
INSERT INTO `t_user` VALUES ('3', '聊点', '2019-02-03 10:22:39', '414679493@qq.com', '公众号 聊点', '/user/pic/1.png', '13711645815', null);
