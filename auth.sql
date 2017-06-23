/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - pp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `operation_http` */

CREATE TABLE `operation_http` (
  `id` char(36) NOT NULL,
  `operation_id` char(36) NOT NULL,
  `http_verb` varchar(20) NOT NULL,
  `resource_path` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `operation_http` */

LOCK TABLES `operation_http` WRITE;

insert  into `operation_http`(`id`,`operation_id`,`http_verb`,`resource_path`) values ('H001','P9','POST','/api/v1/orders'),('H002','P10','GET','/api/v1/orders');

UNLOCK TABLES;

/*Table structure for table `operations` */

CREATE TABLE `operations` (
  `id` char(36) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `resource_id` char(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `operations` */

LOCK TABLES `operations` WRITE;

insert  into `operations`(`id`,`code`,`name`,`resource_id`) values ('P10','P10','查询','R001'),('P9','P9','审批','R001');

UNLOCK TABLES;

/*Table structure for table `permissions` */

CREATE TABLE `permissions` (
  `role_id` char(36) NOT NULL,
  `operation_id` char(36) NOT NULL,
  `tenant_id` char(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permissions` */

LOCK TABLES `permissions` WRITE;

insert  into `permissions`(`role_id`,`operation_id`,`tenant_id`) values ('A001','P9','1');

UNLOCK TABLES;

/*Table structure for table `resources` */

CREATE TABLE `resources` (
  `id` char(36) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resources` */

LOCK TABLES `resources` WRITE;

insert  into `resources`(`id`,`code`,`name`) values ('R1001','R1001','销售订单');

UNLOCK TABLES;

/*Table structure for table `roles` */

CREATE TABLE `roles` (
  `id` char(36) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `tenant_id` char(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

LOCK TABLES `roles` WRITE;

insert  into `roles`(`id`,`code`,`name`,`status`,`tenant_id`) values ('A001','A001','销售顾问',1,'1'),('A002','A002','库管员',1,'1');

UNLOCK TABLES;

/*Table structure for table `user_roles` */

CREATE TABLE `user_roles` (
  `user_id` char(36) NOT NULL,
  `role_id` char(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

LOCK TABLES `user_roles` WRITE;

insert  into `user_roles`(`user_id`,`role_id`) values ('lvnan','A001'),('lvnan','A002');

UNLOCK TABLES;

/*Table structure for table `users` */

CREATE TABLE `users` (
  `id` char(36) NOT NULL,
  `username` varchar(100) NOT NULL,
  `tenant_id` char(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

LOCK TABLES `users` WRITE;

insert  into `users`(`id`,`username`,`tenant_id`) values ('lvnan','lvnan','1');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
