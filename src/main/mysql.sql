/*
MySQL Data Transfer
Source Host: localhost
Source Database: admin_manage
Target Host: localhost
Target Database: admin_manage
Date: 2016/10/6 14:31:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for menu
-- ----------------------------
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL,
  `label` varchar(20) NOT NULL,
  `path` varchar(200) DEFAULT '0',
  `order` smallint(6) DEFAULT '1',
  `level` smallint(6) DEFAULT '1' COMMENT '层级，方便根据层级查询',
  `url` varchar(200) DEFAULT NULL,
  `disabled` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
CREATE TABLE `resource` (
  `id` varchar(50) NOT NULL COMMENT '编码',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
  `disabled` smallint(6) NOT NULL DEFAULT '0',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `description` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL COMMENT '角色',
  `disabled` smallint(6) NOT NULL DEFAULT '0',
  `description` varchar(60) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
CREATE TABLE `role_menu` (
  `role_id` varchar(50) DEFAULT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  KEY `role_id_rm` (`role_id`),
  KEY `menu_code_rm` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
CREATE TABLE `role_resource` (
  `role_id` varchar(50) DEFAULT NULL,
  `resource_id` varchar(50) DEFAULT NULL,
  KEY `roleid_rr` (`role_id`),
  KEY `resource_rr` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
CREATE TABLE `syslog` (
  `uid` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `content` varchar(600) NOT NULL DEFAULT '' COMMENT '日志内容',
  `operation` varchar(250) DEFAULT NULL COMMENT '用户操作',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `user` varchar(50) DEFAULT NULL COMMENT '用户'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `username` varchar(20) NOT NULL COMMENT '登录名称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `salt` varchar(50) DEFAULT '0' COMMENT '密码的盐',
  `disabled` smallint(6) NOT NULL DEFAULT '1' COMMENT '0、禁用 1、正常',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
CREATE TABLE `user_role` (
  `uid` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  KEY `uid` (`uid`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `menu` VALUES ('blog', '博客管理', '0', '1', '1', 'blog', '0');
INSERT INTO `menu` VALUES ('comment', '评论', '0,blog', '2', '2', '/comment', '0');
INSERT INTO `menu` VALUES ('menu', '菜单管理', '0,system', '2', '1', '/menu', '0');
INSERT INTO `menu` VALUES ('resource', '资源管理', '0,system', '2', '4', '/resource', '0');
INSERT INTO `menu` VALUES ('role', '角色管理', '0,system', '2', '3', '/role', '0');
INSERT INTO `menu` VALUES ('syslog', '系统日志', '0,system', '2', '5', '/syslog', '0');
INSERT INTO `menu` VALUES ('system', '系统管理', '0', '1', '1', null, '0');
INSERT INTO `menu` VALUES ('user', '用户管理', '0,system', '2', '2', '/user', '0');

INSERT INTO `resource` VALUES ('admin', 'fa', '0', '/user/*', 'fa');
INSERT INTO `role` VALUES ('1', 'admin', '0', 'fa');
INSERT INTO `role_menu` VALUES ('1', 'system');
INSERT INTO `role_resource` VALUES ('1', 'admin');
INSERT INTO `user` VALUES ('1', 'root', '5442b02dabc5ed9401be4dfe1ca8adb9', null, 'r', '0', '2016-09-27 19:53:20', '2016-09-27 19:53:22');
INSERT INTO `user` VALUES ('2f66b4f2-3fa7-40fd-b7b1-a7bf28aec6fc', 'rootga', '114056f7bff58af12b6e53e64598503f', null, '0', '0', '2016-10-05 16:19:44', null);
INSERT INTO `user_role` VALUES ('1', '1');
