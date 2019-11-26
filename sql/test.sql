/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 26/11/2019 17:08:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `isbn` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(10, 2) NOT NULL,
  `pubdate` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('123-166-890-China', '华夏传奇', 66.50, '1949-10-01');
INSERT INTO `books` VALUES ('120-166-890-China', '大中华帝国', 86.50, '1949-10-01');
INSERT INTO `books` VALUES ('122-166-890-China', '华夏传奇', 66.50, '1949-10-01');
INSERT INTO `books` VALUES ('128-166-890-China', '炎黄传奇', 112.50, '1949-10-01');
INSERT INTO `books` VALUES ('138-166-890-China', '华夏传奇', 66.50, '1949-10-01');
INSERT INTO `books` VALUES ('120-166-990-China', '人性的弱点', 65.60, '2017-10-16');
INSERT INTO `books` VALUES ('190-33-PRC', '贞观之治', 23.40, '2017-10-21');
INSERT INTO `books` VALUES ('191-39-PRC', '大唐盛世', 23.40, '2017-10-21');
INSERT INTO `books` VALUES ('191-39-PRC', '大唐盛世2', 23.40, '2017-10-21');
INSERT INTO `books` VALUES ('isbn-123', '古文观止', 321.50, '2017-10-24');
INSERT INTO `books` VALUES ('isbn-123-C', '古文观止大全', 321.50, '2017-10-25');
INSERT INTO `books` VALUES ('isbn-333-C', '古文大全', 321.50, '2017-10-25');
INSERT INTO `books` VALUES ('isbn-333-', '古文大全', 321.50, '2017-10-25');

-- ----------------------------
-- Table structure for cake
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蛋糕id',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '蛋糕名称',
  `level` int(2) NOT NULL COMMENT '等级',
  `price` int(9) NOT NULL COMMENT '价格',
  `small_img` mediumblob NOT NULL COMMENT '图片',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cate
-- ----------------------------
DROP TABLE IF EXISTS `cate`;
CREATE TABLE `cate`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cateName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pId` smallint(5) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `cateName`(`cateName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cate
-- ----------------------------
INSERT INTO `cate` VALUES (1, '服装', 0);
INSERT INTO `cate` VALUES (2, '数码', 0);
INSERT INTO `cate` VALUES (3, '玩具', 0);
INSERT INTO `cate` VALUES (4, '男装', 1);
INSERT INTO `cate` VALUES (5, '女装', 1);
INSERT INTO `cate` VALUES (6, '内衣', 1);
INSERT INTO `cate` VALUES (7, '电视', 2);
INSERT INTO `cate` VALUES (8, '冰箱', 2);
INSERT INTO `cate` VALUES (9, '洗衣机', 2);
INSERT INTO `cate` VALUES (10, '积木', 3);
INSERT INTO `cate` VALUES (11, '娃娃', 3);
INSERT INTO `cate` VALUES (12, '玩具车', 3);
INSERT INTO `cate` VALUES (13, '夹克', 4);
INSERT INTO `cate` VALUES (14, '衬衫', 4);
INSERT INTO `cate` VALUES (15, '裤子', 4);
INSERT INTO `cate` VALUES (16, '液晶电视', 7);
INSERT INTO `cate` VALUES (17, '等离子电视', 7);
INSERT INTO `cate` VALUES (18, '背投电视', 7);

-- ----------------------------
-- Table structure for copy
-- ----------------------------
DROP TABLE IF EXISTS `copy`;
CREATE TABLE `copy`  (
  `id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `age` tinyint(3) UNSIGNED NOT NULL DEFAULT 18 COMMENT '年龄',
  `card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `salary` float(8, 2) NOT NULL DEFAULT 0.00 COMMENT '薪水',
  `marrired` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0未婚 1结婚',
  `sex` enum('男','女','保密') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '保密' COMMENT '性别'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of copy
-- ----------------------------
INSERT INTO `copy` VALUES (1, 'a', 'a', '548575895@qq.com', 24, '350545654512345642', '12345678912', 1000.00, 0, '男');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (9);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `opr_time` datetime(0) NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `module` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `result` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('2019-11-06 17:33:32', 'login', 'admin', 'SelfController', 'login', '失败');
INSERT INTO `log` VALUES ('2019-11-06 17:36:17', 'login', 'a', 'SelfController', 'login', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:23', 'operation', 'a', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:28', 'operation', 'a', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:28', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:31', 'operation', 'a', 'LogController', 'loginLog', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:38', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:40', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:41', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:42', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:44', 'operation', 'a', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2019-11-06 17:36:46', 'operation', 'a', 'DepartmentController', 'list', '成功');

-- ----------------------------
-- Table structure for luckymoney
-- ----------------------------
DROP TABLE IF EXISTS `luckymoney`;
CREATE TABLE `luckymoney`  (
  `id` int(11) NOT NULL,
  `consumer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `producer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of luckymoney
-- ----------------------------
INSERT INTO `luckymoney` VALUES (1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for man
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man`  (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `man_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_gp3n4xlfjw1dsie3as1a6y9g4`(`man_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man
-- ----------------------------
INSERT INTO `man` VALUES (1, 24, 'A');

-- ----------------------------
-- Table structure for myisam1
-- ----------------------------
DROP TABLE IF EXISTS `myisam1`;
CREATE TABLE `myisam1`  (
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` tinyint(4) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(8, 2) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `udpate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `detail_id_idx`(`detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1574408108680106520', '1574408108620149070', '1111', '可乐', 3.20, 10, 'http://xxx.com', '2019-11-22 15:35:08', '2019-11-22 15:35:08');
INSERT INTO `order_detail` VALUES ('1574408108707124677', '1574408108620149070', '1234', '雪碧', 2.50, 10, 'http://xxx.com', '2019-11-22 15:35:08', '2019-11-22 15:35:08');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家openId',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态，默认 0 新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态，默认 0 未支付',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`order_id`, `buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1574408108620149070', 'Brain', '15274837465', 'YY街道', 'openid', 57.00, 0, 0, '2019-11-22 15:35:08', '2019-11-22 15:35:08');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`category_id`, `category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热销榜', 1, '2019-11-21 09:43:37', '2019-11-21 17:54:32');
INSERT INTO `product_category` VALUES (2, '饮料', 2, '2019-11-21 09:48:25', '2019-11-21 17:54:44');
INSERT INTO `product_category` VALUES (3, '电器', 3, '2019-11-21 10:01:00', '2019-11-21 10:01:00');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图',
  `product_status` int(2) NOT NULL COMMENT '状态 0 正常 1 下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udpate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1111', '可乐', 3.20, 990, '肥宅快乐水', 'http://xxx.com', 0, 2, '2019-11-21 14:37:37', '2019-11-22 15:35:08');
INSERT INTO `product_info` VALUES ('1234', '雪碧', 2.50, 990, '肥宅快乐水', 'http://xxx.com', 0, 2, '2019-11-21 15:35:15', '2019-11-22 15:35:08');
INSERT INTO `product_info` VALUES ('2222', '电脑', 2000.00, 10, '普通电脑', 'http://ooo.com', 0, 3, '2019-11-21 17:51:15', '2019-11-21 17:51:15');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info`  (
  `seller_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `openid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`seller_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1574732074184181758', 'admin', 'admin', 'abc', '2019-11-26 09:34:34', '2019-11-26 09:34:34');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `did` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_number` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `work_time` datetime(0) NULL DEFAULT NULL,
  `leave_time` datetime(0) NULL DEFAULT NULL,
  `born_date` date NULL DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_staff_dep`(`did`) USING BTREE,
  CONSTRAINT `fk_staff_dep` FOREIGN KEY (`did`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 'a', '123', '1', NULL, '1', '1', '1', '2019-11-06 17:36:09', '2019-11-06 17:36:07', NULL, '1');

-- ----------------------------
-- Table structure for test_alter
-- ----------------------------
DROP TABLE IF EXISTS `test_alter`;
CREATE TABLE `test_alter`  (
  `id` int(11) NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `age_index`(`age`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_alter
-- ----------------------------
INSERT INTO `test_alter` VALUES (1, 24, 'KokoTa');
INSERT INTO `test_alter` VALUES (2, 22, 'A');
INSERT INTO `test_alter` VALUES (3, 33, 'B');

-- ----------------------------
-- Table structure for test_float1
-- ----------------------------
DROP TABLE IF EXISTS `test_float1`;
CREATE TABLE `test_float1`  (
  `a` float NULL DEFAULT NULL,
  `b` double NULL DEFAULT NULL,
  `c` decimal(10, 0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_float1
-- ----------------------------
INSERT INTO `test_float1` VALUES (1.149, 1.149, 1);

-- ----------------------------
-- Table structure for test_increment
-- ----------------------------
DROP TABLE IF EXISTS `test_increment`;
CREATE TABLE `test_increment`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_increment
-- ----------------------------
INSERT INTO `test_increment` VALUES (1, 'KokoTa');

-- ----------------------------
-- Table structure for test_insert
-- ----------------------------
DROP TABLE IF EXISTS `test_insert`;
CREATE TABLE `test_insert`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_insert
-- ----------------------------
INSERT INTO `test_insert` VALUES (1, 'A');
INSERT INTO `test_insert` VALUES (2, 'B');
INSERT INTO `test_insert` VALUES (3, 'C');
INSERT INTO `test_insert` VALUES (4, 'D');
INSERT INTO `test_insert` VALUES (5, 'E');
INSERT INTO `test_insert` VALUES (6, 'A');
INSERT INTO `test_insert` VALUES (7, 'A');

-- ----------------------------
-- Table structure for test_insert2
-- ----------------------------
DROP TABLE IF EXISTS `test_insert2`;
CREATE TABLE `test_insert2`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_int1
-- ----------------------------
DROP TABLE IF EXISTS `test_int1`;
CREATE TABLE `test_int1`  (
  `a` tinyint(4) NULL DEFAULT NULL,
  `b` smallint(6) NULL DEFAULT NULL,
  `c` mediumint(9) NULL DEFAULT NULL,
  `d` int(11) NULL DEFAULT NULL,
  `e` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_int1
-- ----------------------------
INSERT INTO `test_int1` VALUES (-10, -10, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (20, NULL, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (20, NULL, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (20, NULL, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (10, NULL, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (10, NULL, NULL, NULL, NULL);
INSERT INTO `test_int1` VALUES (10, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for test_int2
-- ----------------------------
DROP TABLE IF EXISTS `test_int2`;
CREATE TABLE `test_int2`  (
  `a` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `b` smallint(5) UNSIGNED NULL DEFAULT NULL,
  `c` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `d` int(10) UNSIGNED NULL DEFAULT NULL,
  `e` bigint(20) UNSIGNED NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_int2
-- ----------------------------
INSERT INTO `test_int2` VALUES (10, 10, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for test_int3
-- ----------------------------
DROP TABLE IF EXISTS `test_int3`;
CREATE TABLE `test_int3`  (
  `a` tinyint(3) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `b` smallint(5) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `c` mediumint(8) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `d` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `e` bigint(20) UNSIGNED ZEROFILL NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_int3
-- ----------------------------
INSERT INTO `test_int3` VALUES (010, 00010, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for test_select1
-- ----------------------------
DROP TABLE IF EXISTS `test_select1`;
CREATE TABLE `test_select1`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` tinyint(4) NULL DEFAULT NULL,
  `user_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `user_group` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dep_id` int(10) UNSIGNED NOT NULL,
  `addr_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dep_id_key`(`dep_id`) USING BTREE,
  CONSTRAINT `dep_id_key` FOREIGN KEY (`dep_id`) REFERENCES `test_select2` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_select1
-- ----------------------------
INSERT INTO `test_select1` VALUES (1, 'AA', 20, NULL, 'X', 10, 1);
INSERT INTO `test_select1` VALUES (2, 'BB', 25, NULL, 'X', 10, 2);
INSERT INTO `test_select1` VALUES (3, 'CC', 40, NULL, 'Y', 2, 3);
INSERT INTO `test_select1` VALUES (4, 'DD', 16, NULL, 'Y', 2, 1);
INSERT INTO `test_select1` VALUES (5, 'AAA', 60, NULL, 'Y', 3, 2);
INSERT INTO `test_select1` VALUES (7, 'AAA', 60, NULL, 'Y', 3, 2);
INSERT INTO `test_select1` VALUES (8, 'AAA', 55, NULL, 'Y', 3, 2);

-- ----------------------------
-- Table structure for test_select2
-- ----------------------------
DROP TABLE IF EXISTS `test_select2`;
CREATE TABLE `test_select2`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dep` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `des` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_select2
-- ----------------------------
INSERT INTO `test_select2` VALUES (2, '部门2', NULL);
INSERT INTO `test_select2` VALUES (3, '部门3', NULL);
INSERT INTO `test_select2` VALUES (10, '部门1', NULL);

-- ----------------------------
-- Table structure for test_select3
-- ----------------------------
DROP TABLE IF EXISTS `test_select3`;
CREATE TABLE `test_select3`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `addr` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_select3
-- ----------------------------
INSERT INTO `test_select3` VALUES (1, '泉州');
INSERT INTO `test_select3` VALUES (2, '厦门');
INSERT INTO `test_select3` VALUES (3, '福州');

-- ----------------------------
-- Table structure for test_set1
-- ----------------------------
DROP TABLE IF EXISTS `test_set1`;
CREATE TABLE `test_set1`  (
  `a` set('A','B','C') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_set1
-- ----------------------------
INSERT INTO `test_set1` VALUES ('A');
INSERT INTO `test_set1` VALUES ('A');
INSERT INTO `test_set1` VALUES ('A,B');
INSERT INTO `test_set1` VALUES ('A,B,C');

-- ----------------------------
-- Table structure for test_str1
-- ----------------------------
DROP TABLE IF EXISTS `test_str1`;
CREATE TABLE `test_str1`  (
  `a` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_str1
-- ----------------------------
INSERT INTO `test_str1` VALUES (' A', ' A ');
INSERT INTO `test_str1` VALUES (' AAA', ' AAA ');
INSERT INTO `test_str1` VALUES (' AAAA', ' AAAA');
INSERT INTO `test_str1` VALUES (' AAAA', ' AAAA');

-- ----------------------------
-- Table structure for test_time1
-- ----------------------------
DROP TABLE IF EXISTS `test_time1`;
CREATE TABLE `test_time1`  (
  `a` time(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_time1
-- ----------------------------
INSERT INTO `test_time1` VALUES ('12:34:56');
INSERT INTO `test_time1` VALUES ('60:34:56');
INSERT INTO `test_time1` VALUES ('12:34:00');
INSERT INTO `test_time1` VALUES ('12:34:56');
INSERT INTO `test_time1` VALUES ('00:00:00');

-- ----------------------------
-- Table structure for test_time2
-- ----------------------------
DROP TABLE IF EXISTS `test_time2`;
CREATE TABLE `test_time2`  (
  `a` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_time2
-- ----------------------------
INSERT INTO `test_time2` VALUES ('2000-01-01');
INSERT INTO `test_time2` VALUES ('2000-01-01');
INSERT INTO `test_time2` VALUES ('2020-00-11');
INSERT INTO `test_time2` VALUES ('2000-01-01');

-- ----------------------------
-- Table structure for test_time3
-- ----------------------------
DROP TABLE IF EXISTS `test_time3`;
CREATE TABLE `test_time3`  (
  `a` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_time3
-- ----------------------------
INSERT INTO `test_time3` VALUES ('2000-01-01 01:01:01');
INSERT INTO `test_time3` VALUES ('2000-01-01 01:01:01');
INSERT INTO `test_time3` VALUES ('2020-00-01 01:11:01');
INSERT INTO `test_time3` VALUES ('2000-01-01 01:01:01');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `lastLogin` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
  `userStatus` int(1) NULL DEFAULT NULL COMMENT '状态 0 正常 1 锁定 2 删除',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (40, '小雯', '321321', 'x', 18, '1', '15746374857', '12741987@qq.com', '2019-10-23 01:24:44', '2019-10-23 01:24:44', '2019-10-23 01:24:44', 1, 'HAHA');
INSERT INTO `users` VALUES (41, '小dsa', '321321', 'x', 18, '1', '15746374857', '12741987@qq.com', '2019-10-23 01:24:13', '2019-10-23 01:24:13', '2019-10-23 01:24:13', 1, 'HAHA');
INSERT INTO `users` VALUES (42, '小qqq', '321321', 'x', 18, '1', '15746374857', '12741987@qq.com', '2019-10-23 01:24:13', '2019-10-23 01:24:13', '2019-10-23 01:24:13', 1, 'HAHA');
INSERT INTO `users` VALUES (43, '王小明', '12345', 'B', 18, '1', '15746374857', '12741987@qq.com', '2019-10-23 01:24:42', '2019-10-23 01:24:42', '2019-10-23 01:24:42', 1, 'HAHA');

SET FOREIGN_KEY_CHECKS = 1;
