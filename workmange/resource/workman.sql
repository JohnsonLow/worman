/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : workman

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2014-01-27 17:26:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(100) NOT NULL COMMENT '登陆账号',
  `password` varchar(50) NOT NULL COMMENT 'm密码',
  `auth_level` int(1) DEFAULT NULL COMMENT '权限类别',
  `department_code` int(4) DEFAULT NULL COMMENT '部门编号，纯数字',
  `name` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `phone` char(11) DEFAULT NULL COMMENT '联系电话',
  `weibo` varchar(50) DEFAULT NULL COMMENT '微博账号',
  `postion` int(4) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account_username` (`username`),
  KEY `fk_account_dep_code` (`department_code`),
  KEY `fk_account_postion_code` (`postion`),
  KEY `fk_account_auth_level` (`auth_level`),
  CONSTRAINT `fk_account_auth_level` FOREIGN KEY (`auth_level`) REFERENCES `auth` (`level`),
  CONSTRAINT `fk_account_dep_code` FOREIGN KEY (`department_code`) REFERENCES `department` (`code`),
  CONSTRAINT `fk_account_postion_code` FOREIGN KEY (`postion`) REFERENCES `position` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='员工账号表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO account VALUES ('1', 'sysadmin', 'c984aed014aec7623a54f0591da07a85fd4b762d', '1', '2', '超级管理员', '13839663548', 'sdf@test.com', null);
INSERT INTO account VALUES ('2', 'sdfs', 'c984aed014aec7623a54f0591da07a85fd4b762d', '2', '2', '测试2', '', 'sdf@sss.com', '1');
INSERT INTO account VALUES ('3', 'sss', 'c984aed014aec7623a54f0591da07a85fd4b762d', '2', '2', 'java', '18822514622', 'ss@ss.con', '2');

-- ----------------------------
-- Table structure for `auth`
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `level` int(1) NOT NULL AUTO_INCREMENT COMMENT '权限等级',
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`level`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO auth VALUES ('1', '超级管理员', '超级管理员，可以访问所有菜单');
INSERT INTO auth VALUES ('2', '普通管理员', '可以新建任务');
INSERT INTO auth VALUES ('3', '普通人员', '普通人员');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `code` int(4) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `description` varchar(300) DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO department VALUES ('2', '人力资源部', '主管招聘');
INSERT INTO department VALUES ('3', '项目管理部门', '管理项目');
INSERT INTO department VALUES ('4', '技术部', '技术开发');

-- ----------------------------
-- Table structure for `handle_type`
-- ----------------------------
DROP TABLE IF EXISTS `handle_type`;
CREATE TABLE `handle_type` (
  `code` int(1) NOT NULL AUTO_INCREMENT COMMENT '处理类型编码',
  `name` varchar(30) DEFAULT NULL COMMENT '处理类型名称',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='处理类型表';

-- ----------------------------
-- Records of handle_type
-- ----------------------------
INSERT INTO handle_type VALUES ('1', '回复上一级');
INSERT INTO handle_type VALUES ('2', '回复下一级');
INSERT INTO handle_type VALUES ('3', '转发');
INSERT INTO handle_type VALUES ('4', '完成');

-- ----------------------------
-- Table structure for `mission`
-- ----------------------------
DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission` (
  `code` int(11) NOT NULL AUTO_INCREMENT COMMENT '������',
  `title` varchar(50) DEFAULT NULL COMMENT '�������',
  `content` varchar(5000) DEFAULT NULL COMMENT '��������',
  `sponsor_id` int(11) NOT NULL COMMENT '������id',
  `handler_id` int(11) NOT NULL COMMENT '������id',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `handlertime` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
  `committime` timestamp NULL DEFAULT NULL COMMENT '���ʱ��',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mission
-- ----------------------------

-- ----------------------------
-- Table structure for `mission_handle`
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
-- Records of mission_handle
-- ----------------------------

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `code` int(4) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `name` varchar(50) NOT NULL COMMENT '职位名称',
  `description` varchar(300) DEFAULT NULL COMMENT '职位描述',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='职位表';

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO position VALUES ('1', '部门经理', '部门经理');
INSERT INTO position VALUES ('2', '部门成员', '部门普通成员');

-- ----------------------------
-- Table structure for `weiboinfo`
-- ----------------------------
DROP TABLE IF EXISTS `weiboinfo`;
CREATE TABLE `weiboinfo` (
  `username` varchar(50) DEFAULT NULL COMMENT '微博账号',
  `screen_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `image_url` varchar(100) DEFAULT NULL COMMENT '头像地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微博账号信息';

-- ----------------------------
-- Records of weiboinfo
-- ----------------------------
