/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : workman

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2014-02-16 21:10:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for access_token
-- ----------------------------
DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token` (
  `uid` varchar(50) NOT NULL COMMENT '微博账号id',
  `token` varchar(100) NOT NULL COMMENT '授权token',
  `account_id` int(8) NOT NULL COMMENT '站内账号ID',
  `weibo_name` varchar(50) NOT NULL COMMENT '微博账号',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微博认证信息';

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(100) NOT NULL COMMENT '登陆账号',
  `password` varchar(50) NOT NULL COMMENT 'm密码',
  `auth_level` int(1) DEFAULT NULL COMMENT '权限类别',
  `department_code` int(4) DEFAULT NULL COMMENT '部门编号，纯数字',
  `name` varchar(50) NOT NULL COMMENT '员工姓名',
  `phone` char(11) DEFAULT NULL COMMENT '联系电话',
  `weibo` varchar(50) NOT NULL COMMENT '微博账号',
  `postion` int(4) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account_username` (`username`),
  UNIQUE KEY `uk_account_weibo` (`weibo`),
  KEY `pk_account_dep_code` (`department_code`),
  KEY `pk_account_pos_code` (`postion`),
  CONSTRAINT `pk_account_dep_code` FOREIGN KEY (`department_code`) REFERENCES `department` (`code`),
  CONSTRAINT `pk_account_pos_code` FOREIGN KEY (`postion`) REFERENCES `position` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='员工账号表';

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `level` int(1) NOT NULL AUTO_INCREMENT COMMENT '权限等级',
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`level`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `code` int(4) NOT NULL COMMENT '部门编号',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `description` varchar(300) DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`code`),
  UNIQUE KEY `uk_dep_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Table structure for handle_type
-- ----------------------------
DROP TABLE IF EXISTS `handle_type`;
CREATE TABLE `handle_type` (
  `code` int(1) NOT NULL AUTO_INCREMENT COMMENT '处理类型编码',
  `name` varchar(30) DEFAULT NULL COMMENT '处理类型名称',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='处理类型表';

-- ----------------------------
-- Table structure for mission
-- ----------------------------
DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission` (
  `code` int(11) NOT NULL AUTO_INCREMENT COMMENT '������',
  `title` varchar(50) NOT NULL COMMENT '�������',
  `content` varchar(5000) NOT NULL COMMENT '��������',
  `sponsor_id` int(11) NOT NULL COMMENT '������id',
  `handler_id` int(11) NOT NULL COMMENT '������id',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `handlertime` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
  `committime` timestamp NULL DEFAULT NULL COMMENT '���ʱ��',
  `type` int(4) NOT NULL COMMENT '任务紧急程度',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mission_handle
-- ----------------------------
DROP TABLE IF EXISTS `mission_handle`;
CREATE TABLE `mission_handle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '处理id',
  `missionid` int(11) NOT NULL COMMENT '任务id',
  `addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始受理时间',
  `handletime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `content` varchar(100) NOT NULL COMMENT '处理说明',
  `handlepeo` int(11) NOT NULL COMMENT '处理人',
  `topeo` int(11) NOT NULL COMMENT '回复人',
  `handletype` int(11) NOT NULL COMMENT '处理类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务处理表';

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `code` int(4) NOT NULL COMMENT '职位编号',
  `name` varchar(50) NOT NULL COMMENT '职位名称',
  `description` varchar(300) DEFAULT NULL COMMENT '职位描述',
  PRIMARY KEY (`code`),
  UNIQUE KEY `uk_pos_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位表';

-- ----------------------------
-- Table structure for weiboinfo
-- ----------------------------
DROP TABLE IF EXISTS `weiboinfo`;
CREATE TABLE `weiboinfo` (
  `mission_id` int(11) NOT NULL COMMENT '微博账号',
  `handle_id` int(11) DEFAULT NULL COMMENT '昵称',
  `weibo_id` varchar(50) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`mission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微博账号信息';
