/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : ksj

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2017-07-28 17:09:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(64) NOT NULL COMMENT '账号',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `hashed_password` varchar(128) NOT NULL COMMENT '密码',
  `status` int(2) DEFAULT '0' COMMENT '状态（0：启用 1：停用）',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否删除（0：未删除 1：已删除）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `updated_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_users_account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '0', '0', '2017-04-25 14:37:37', '2017-06-12 10:32:29', null, null);
