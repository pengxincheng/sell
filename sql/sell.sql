/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-02 18:19:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('5');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(40) NOT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `product_id` varchar(40) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) DEFAULT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) DEFAULT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d5e61f0004', '20180402181010481315', '2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', null, 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d5e6210005', '20180402181010481315', '9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', null, 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d5e6230006', '20180402181010481315', '11fdd81d-6045-4a2a-887d-6f69f2a8ffad', '土豆鸡块', '17.00', null, 'http://p6e4qlpue.bkt.clouddn.com/690ed7dd-1bf7-46d1-991a-a0b6c99ce88d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d5e6260007', '20180402181010481315', '5902df10-9973-4cda-b6e0-3a4a91ccdf9c', '黄焖鸡米饭', '25.00', null, 'http://p6e4qlpue.bkt.clouddn.com/b5fb077b-3c45-432b-b7a5-439f9bd0665c.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d62b4b0008', '20180402181028122624', '2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', null, 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d62b4d0009', '20180402181028122624', '9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', null, 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d62b50000a', '20180402181028122624', '11fdd81d-6045-4a2a-887d-6f69f2a8ffad', '土豆鸡块', '17.00', null, 'http://p6e4qlpue.bkt.clouddn.com/690ed7dd-1bf7-46d1-991a-a0b6c99ce88d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d48d016285d62b52000b', '20180402181028122624', '5902df10-9973-4cda-b6e0-3a4a91ccdf9c', '黄焖鸡米饭', '25.00', null, 'http://p6e4qlpue.bkt.clouddn.com/b5fb077b-3c45-432b-b7a5-439f9bd0665c.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285d8bcb20000', '20180402181316738172', '2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', null, 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285d8bcbc0001', '20180402181316738172', '9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', null, 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285d8bcbe0002', '20180402181316738172', '5902df10-9973-4cda-b6e0-3a4a91ccdf9c', '黄焖鸡米饭', '25.00', null, 'http://p6e4qlpue.bkt.clouddn.com/b5fb077b-3c45-432b-b7a5-439f9bd0665c.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285da70020003', '20180402181508172790', '2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', null, 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285da70050004', '20180402181508172790', '9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', null, 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285dbd67f0005', '20180402181612382271', '2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', null, 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', null, null);
INSERT INTO `order_detail` VALUES ('4028b8816285d7a0016285dbd6810006', '20180402181612382271', '9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', null, 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', null, null);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(40) NOT NULL,
  `buyer_name` varchar(32) DEFAULT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) DEFAULT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) DEFAULT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) DEFAULT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) DEFAULT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('20180402181508172790', '彭新成', '130112301312', '策动', '123', '90.00', '0', '0', '2018-04-02 18:15:08', '2018-04-02 18:15:08');
INSERT INTO `order_master` VALUES ('20180402181612382271', '认购', '放灯', '封', '123', '90.00', '0', '0', '2018-04-02 18:16:40', '2018-04-02 18:16:40');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) DEFAULT NULL COMMENT '类目名字',
  `category_type` int(11) DEFAULT NULL COMMENT '类目编号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '招牌', '1', '2018-03-29 14:02:53', '2018-03-29 14:02:55');
INSERT INTO `product_category` VALUES ('2', '热卖', '2', '2018-03-27 14:04:32', '2018-03-29 14:03:00');
INSERT INTO `product_category` VALUES ('3', '精品套餐', '3', '2018-03-30 11:51:33', '2018-03-30 11:51:33');
INSERT INTO `product_category` VALUES ('4', '商务套餐', '4', '2018-03-30 11:52:00', '2018-03-30 11:52:00');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(40) NOT NULL,
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) DEFAULT NULL COMMENT '单价',
  `product_stock` int(11) DEFAULT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('11fdd81d-6045-4a2a-887d-6f69f2a8ffad', '土豆鸡块', '17.00', '96', '便宜实惠，好吃的很', 'http://p6e4qlpue.bkt.clouddn.com/690ed7dd-1bf7-46d1-991a-a0b6c99ce88d.png', '0', '4', '2018-03-30 11:56:21', '2018-03-30 16:54:45');
INSERT INTO `product_info` VALUES ('2fd5b4f3-c8cd-415c-ade9-e8208ae6a059', '红烧肉', '22.00', '86', '肥而不腻', 'http://p6e4qlpue.bkt.clouddn.com/90f1855d-3c60-40b4-8f14-89e138a03d36.png', '0', '1', '2018-03-29 17:31:13', '2018-03-30 16:55:00');
INSERT INTO `product_info` VALUES ('5902df10-9973-4cda-b6e0-3a4a91ccdf9c', '黄焖鸡米饭', '25.00', '94', '要吃就吃黄焖鸡', 'http://p6e4qlpue.bkt.clouddn.com/b5fb077b-3c45-432b-b7a5-439f9bd0665c.png', '0', '4', '2018-03-30 11:57:39', '2018-03-30 16:55:12');
INSERT INTO `product_info` VALUES ('9a56d2e2-57a8-45db-b484-925319236dd5', '糖醋排骨', '23.00', '87', '酸甜可口，好吃的很', 'http://p6e4qlpue.bkt.clouddn.com/3f277113-a5a6-44d4-899e-d9c88b400e4d.png', '0', '2', '2018-03-30 11:55:29', '2018-03-30 16:55:30');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `openid` varchar(64) DEFAULT NULL COMMENT '微信openid',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';

-- ----------------------------
-- Records of seller_info
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
