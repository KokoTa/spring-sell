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

 Date: 21/11/2019 18:26:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
INSERT INTO `product_info` VALUES ('1111', '可乐', 3.20, 100, '肥宅快乐水', 'http://xxx.com', 0, 2, '2019-11-21 14:37:37', '2019-11-21 17:54:07');
INSERT INTO `product_info` VALUES ('1234', '雪碧', 2.50, 200, '肥宅快乐水', 'http://xxx.com', 0, 2, '2019-11-21 15:35:15', '2019-11-21 17:54:05');
INSERT INTO `product_info` VALUES ('2222', '电脑', 2000.00, 10, '普通电脑', 'http://ooo.com', 0, 3, '2019-11-21 17:51:15', '2019-11-21 17:51:15');

SET FOREIGN_KEY_CHECKS = 1;
