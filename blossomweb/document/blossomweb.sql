/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.49 : Database - blossomweb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blossomweb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blossomweb`;

/*Table structure for table `tb_authorty` */

DROP TABLE IF EXISTS `tb_authorty`;

CREATE TABLE `tb_authorty` (
  `authortyId` int(11) NOT NULL COMMENT '权限编号',
  `parentAuthoryId` int(11) DEFAULT NULL COMMENT '父权限ID',
  `authortyName` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `authortyDescription` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `authortyUrl` varchar(200) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`authortyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

/*Data for the table `tb_authorty` */

/*Table structure for table `tb_group` */

DROP TABLE IF EXISTS `tb_group`;

CREATE TABLE `tb_group` (
  `groupId` int(11) NOT NULL COMMENT '组ID',
  `groupName` varchar(50) DEFAULT NULL COMMENT '组名称',
  `parentGroupId` int(11) DEFAULT NULL COMMENT '父组ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `groupDescription` varchar(100) DEFAULT NULL COMMENT '组描述',
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组';

/*Data for the table `tb_group` */

/*Table structure for table `tb_group_authorty` */

DROP TABLE IF EXISTS `tb_group_authorty`;

CREATE TABLE `tb_group_authorty` (
  `groupAuthortyId` int(11) NOT NULL COMMENT '组权限ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  `authortyId` int(11) DEFAULT NULL COMMENT '权限ID',
  `authortyType` int(11) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`groupAuthortyId`),
  KEY `groupId` (`groupId`),
  KEY `authortyId` (`authortyId`),
  CONSTRAINT `tb_group_authorty_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_group_authorty_ibfk_2` FOREIGN KEY (`authortyId`) REFERENCES `tb_authorty` (`authortyId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组权限';

/*Data for the table `tb_group_authorty` */

/*Table structure for table `tb_group_role` */

DROP TABLE IF EXISTS `tb_group_role`;

CREATE TABLE `tb_group_role` (
  `groupRoleId` int(11) NOT NULL COMMENT '组角色ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`groupRoleId`),
  KEY `groupId` (`groupId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_group_role_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_group_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组角色';

/*Data for the table `tb_group_role` */

/*Table structure for table `tb_handle_log` */

DROP TABLE IF EXISTS `tb_handle_log`;

CREATE TABLE `tb_handle_log` (
  `logType` int(11) DEFAULT '1' COMMENT '日志类型',
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `httpUrl` text,
  `httpMethod` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL COMMENT '方法名称',
  `requestIp` varchar(22) DEFAULT NULL COMMENT '请求IP',
  `exceptionCode` text COMMENT '异常代码',
  `exceptionDetail` text COMMENT '异常信息',
  `params` varchar(200) DEFAULT NULL COMMENT '参数',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `createDate` varchar(50) DEFAULT NULL COMMENT '发生时间',
  `broswer` varchar(100) DEFAULT NULL COMMENT '客户的浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录日志信息存储';

/*Data for the table `tb_handle_log` */

/*Table structure for table `tb_originization` */

DROP TABLE IF EXISTS `tb_originization`;

CREATE TABLE `tb_originization` (
  `organizationId` int(11) NOT NULL COMMENT '组织编号',
  `parentOrganizationId` int(11) DEFAULT NULL COMMENT '父组织ID',
  `organizationName` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `organizationDescription` varchar(100) DEFAULT NULL COMMENT '组织描述',
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织';

/*Data for the table `tb_originization` */

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `parentRoleId` int(11) DEFAULT NULL COMMENT '父角色ID',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleDescription` varchar(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `tb_role` */

/*Table structure for table `tb_role_authorty` */

DROP TABLE IF EXISTS `tb_role_authorty`;

CREATE TABLE `tb_role_authorty` (
  `id` int(11) NOT NULL COMMENT '角色权限ID',
  `authortyId` int(11) NOT NULL COMMENT '权限ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `authortyType` int(11) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`id`),
  KEY `authortyId` (`authortyId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_role_authorty_ibfk_1` FOREIGN KEY (`authortyId`) REFERENCES `tb_authorty` (`authortyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_authorty_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联';

/*Data for the table `tb_role_authorty` */

/*Table structure for table `tb_system_log` */

DROP TABLE IF EXISTS `tb_system_log`;

CREATE TABLE `tb_system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(200) DEFAULT NULL COMMENT '操作类',
  `methodName` varchar(100) DEFAULT NULL COMMENT '执行方法',
  `createTime` datetime DEFAULT NULL COMMENT '打印时间',
  `loglevel` varchar(50) DEFAULT NULL COMMENT '日志级别',
  `message` text COMMENT '日志内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_system_log` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `organizationId` int(11) DEFAULT NULL COMMENT '组织ID',
  `loginAccount` varchar(16) DEFAULT NULL COMMENT '登录账号',
  `loginPassword` varchar(18) DEFAULT NULL COMMENT '登录密码',
  `userName` varchar(16) DEFAULT NULL COMMENT '用户名',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `loginCount` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`userId`),
  KEY `organizationId` (`organizationId`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`organizationId`) REFERENCES `tb_originization` (`organizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `tb_user` */

/*Table structure for table `tb_user_authorty` */

DROP TABLE IF EXISTS `tb_user_authorty`;

CREATE TABLE `tb_user_authorty` (
  `userAuthortyId` int(11) NOT NULL COMMENT '用户权限ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户Id',
  `authortyId` int(11) DEFAULT NULL COMMENT '权限Id',
  `authortyType` varchar(50) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`userAuthortyId`),
  KEY `userId` (`userId`),
  KEY `authortyId` (`authortyId`),
  CONSTRAINT `tb_user_authorty_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_authorty_ibfk_2` FOREIGN KEY (`authortyId`) REFERENCES `tb_authorty` (`authortyId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限';

/*Data for the table `tb_user_authorty` */

/*Table structure for table `tb_user_group` */

DROP TABLE IF EXISTS `tb_user_group`;

CREATE TABLE `tb_user_group` (
  `userGroupId` int(11) NOT NULL COMMENT '用户组ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  PRIMARY KEY (`userGroupId`),
  KEY `userId` (`userId`),
  KEY `groupId` (`groupId`),
  CONSTRAINT `tb_user_group_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_group_ibfk_2` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色组';

/*Data for the table `tb_user_group` */

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `userRoleId` int(11) NOT NULL COMMENT '用户角色ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`userRoleId`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

/*Data for the table `tb_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
