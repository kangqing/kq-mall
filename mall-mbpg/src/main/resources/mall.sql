/*
 Navicat Premium Data Transfer

 Source Server         : local80
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/01/2021 17:19:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_resource
-- ----------------------------
DROP TABLE IF EXISTS `menu_resource`;
CREATE TABLE `menu_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节点名称',
  `method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法（get、post等）',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标样式',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态：0-禁用，1-启用',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型：01=菜单， 02=按钮',
  `grades` int(11) NULL DEFAULT NULL COMMENT '层级',
  `seq` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '乐观锁版本号',
  `del_code` int(11) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu_resource
-- ----------------------------
INSERT INTO `menu_resource` VALUES (1, 1, '首页', NULL, '', NULL, 1, 1, 1, NULL, NULL, 0, '2019-07-20 15:58:07', NULL);
INSERT INTO `menu_resource` VALUES (2, 1, '系统管理', NULL, NULL, NULL, 1, 1, 1, NULL, NULL, 0, '2019-07-20 15:58:48', NULL);
INSERT INTO `menu_resource` VALUES (3, 2, '用户管理', NULL, NULL, NULL, 1, 1, 2, NULL, NULL, 0, '2019-07-20 15:59:09', NULL);
INSERT INTO `menu_resource` VALUES (4, 2, '角色管理', NULL, NULL, NULL, 1, 1, 2, NULL, NULL, 0, '2019-07-20 15:59:21', NULL);
INSERT INTO `menu_resource` VALUES (10, 3, '新增用户', 'POST', '/user/add', NULL, 1, 2, 3, NULL, NULL, 0, '2019-07-20 15:59:54', NULL);
INSERT INTO `menu_resource` VALUES (11, 3, '删除用户', 'DELETE', '/user/delete', NULL, 1, 2, 3, NULL, NULL, 0, '2019-07-20 16:00:15', NULL);
INSERT INTO `menu_resource` VALUES (12, 3, '查询用户', 'GET', '/user/list', NULL, 1, 2, 3, NULL, NULL, 0, '2019-07-20 16:01:23', NULL);
INSERT INTO `menu_resource` VALUES (13, 1, '查询Hello', 'GET', '/hello', NULL, 1, 2, 3, NULL, NULL, 0, '2021-01-07 22:14:06', NULL);
INSERT INTO `menu_resource` VALUES (14, 1, '操作日志管理', 'GET', '/sys_oper_log', NULL, 1, 2, 3, NULL, NULL, 0, '2021-01-11 13:42:51', NULL);
INSERT INTO `menu_resource` VALUES (15, 2, '操作日志分页查询', 'GET', '/sys_oper_log/list', NULL, 1, 2, 3, NULL, NULL, 0, '2021-01-11 13:47:25', NULL);
INSERT INTO `menu_resource` VALUES (16, 2, '导出操作日志', 'GET', '/sys_oper_log/export', NULL, 1, 2, 3, NULL, NULL, 0, '2021-01-11 13:48:10', NULL);

-- ----------------------------
-- Table structure for mmall_cart
-- ----------------------------
DROP TABLE IF EXISTS `mmall_cart`;
CREATE TABLE `mmall_cart`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `checked` int(11) NULL DEFAULT NULL COMMENT '是否选择,1=已勾选,0=未勾选',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_cart
-- ----------------------------
INSERT INTO `mmall_cart` VALUES ('1274842949028225025', '1267803844083834881', '27', 2, 1, '2020-06-22 07:13:39', '2020-06-22 07:26:13');

-- ----------------------------
-- Table structure for mmall_category
-- ----------------------------
DROP TABLE IF EXISTS `mmall_category`;
CREATE TABLE `mmall_category`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别Id',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '类别状态1-正常,2-已废弃',
  `sort_order` int(11) NULL DEFAULT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_category
-- ----------------------------
INSERT INTO `mmall_category` VALUES ('100001', '0', '家用电器', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `mmall_category` VALUES ('100002', '0', '数码3C', 1, NULL, '2017-03-25 16:46:21', '2017-03-25 16:46:21');
INSERT INTO `mmall_category` VALUES ('100003', '0', '服装箱包', 1, NULL, '2017-03-25 16:49:53', '2017-03-25 16:49:53');
INSERT INTO `mmall_category` VALUES ('100004', '0', '食品生鲜', 1, NULL, '2017-03-25 16:50:19', '2017-03-25 16:50:19');
INSERT INTO `mmall_category` VALUES ('100005', '0', '酒水饮料', 1, NULL, '2017-03-25 16:50:29', '2017-03-25 16:50:29');
INSERT INTO `mmall_category` VALUES ('100006', '100001', '冰箱', 1, NULL, '2017-03-25 16:52:15', '2017-03-25 16:52:15');
INSERT INTO `mmall_category` VALUES ('100007', '100001', '电视', 1, NULL, '2017-03-25 16:52:26', '2017-03-25 16:52:26');
INSERT INTO `mmall_category` VALUES ('100008', '100001', '洗衣机', 1, NULL, '2017-03-25 16:52:39', '2017-03-25 16:52:39');
INSERT INTO `mmall_category` VALUES ('100009', '100001', '空调', 1, NULL, '2017-03-25 16:52:45', '2017-03-25 16:52:45');
INSERT INTO `mmall_category` VALUES ('100010', '100001', '电热水器', 1, NULL, '2017-03-25 16:52:54', '2017-03-25 16:52:54');
INSERT INTO `mmall_category` VALUES ('100011', '100002', '电脑', 1, NULL, '2017-03-25 16:53:18', '2017-03-25 16:53:18');
INSERT INTO `mmall_category` VALUES ('100012', '100002', '手机', 1, NULL, '2017-03-25 16:53:27', '2017-03-25 16:53:27');
INSERT INTO `mmall_category` VALUES ('100013', '100002', '平板电脑', 1, NULL, '2017-03-25 16:53:35', '2017-03-25 16:53:35');
INSERT INTO `mmall_category` VALUES ('100014', '100002', '数码相机', 1, NULL, '2017-03-25 16:53:56', '2017-03-25 16:53:56');
INSERT INTO `mmall_category` VALUES ('100015', '100002', '3C配件', 1, NULL, '2017-03-25 16:54:07', '2017-03-25 16:54:07');
INSERT INTO `mmall_category` VALUES ('100016', '100003', '女装', 1, NULL, '2017-03-25 16:54:44', '2017-03-25 16:54:44');
INSERT INTO `mmall_category` VALUES ('100017', '100003', '帽子', 1, NULL, '2017-03-25 16:54:51', '2017-03-25 16:54:51');
INSERT INTO `mmall_category` VALUES ('100018', '100003', '旅行箱', 1, NULL, '2017-03-25 16:55:02', '2017-03-25 16:55:02');
INSERT INTO `mmall_category` VALUES ('100019', '100003', '手提包', 1, NULL, '2017-03-25 16:55:09', '2017-03-25 16:55:09');
INSERT INTO `mmall_category` VALUES ('100020', '100003', '保暖内衣', 1, NULL, '2017-03-25 16:55:18', '2017-03-25 16:55:18');
INSERT INTO `mmall_category` VALUES ('100021', '100004', '零食', 1, NULL, '2017-03-25 16:55:30', '2017-03-25 16:55:30');
INSERT INTO `mmall_category` VALUES ('100022', '100004', '生鲜', 1, NULL, '2017-03-25 16:55:37', '2017-03-25 16:55:37');
INSERT INTO `mmall_category` VALUES ('100023', '100004', '半成品菜', 1, NULL, '2017-03-25 16:55:47', '2017-03-25 16:55:47');
INSERT INTO `mmall_category` VALUES ('100024', '100004', '速冻食品', 1, NULL, '2017-03-25 16:55:56', '2017-03-25 16:55:56');
INSERT INTO `mmall_category` VALUES ('100025', '100004', '进口食品', 1, NULL, '2017-03-25 16:56:06', '2017-03-25 16:56:06');
INSERT INTO `mmall_category` VALUES ('100026', '100005', '白酒', 1, NULL, '2017-03-25 16:56:22', '2017-03-25 16:56:22');
INSERT INTO `mmall_category` VALUES ('100027', '100005', '红酒', 1, NULL, '2017-03-25 16:56:30', '2017-03-25 16:56:30');
INSERT INTO `mmall_category` VALUES ('100028', '100005', '饮料', 1, NULL, '2017-03-25 16:56:37', '2017-03-25 16:56:37');
INSERT INTO `mmall_category` VALUES ('100029', '100005', '调制鸡尾酒', 1, NULL, '2017-03-25 16:56:45', '2017-03-25 16:56:45');
INSERT INTO `mmall_category` VALUES ('100030', '100005', '进口洋酒', 1, NULL, '2017-03-25 16:57:05', '2017-03-25 16:57:05');
INSERT INTO `mmall_category` VALUES ('1268186467817852930', '100001', '电风扇', 1, NULL, '2020-06-03 22:23:10', '2020-06-03 22:24:43');
INSERT INTO `mmall_category` VALUES ('1268188008154984449', '1268186467817852930', '华生电风扇', 1, NULL, '2020-06-03 22:29:18', '2020-06-03 22:29:18');

-- ----------------------------
-- Table structure for mmall_order
-- ----------------------------
DROP TABLE IF EXISTS `mmall_order`;
CREATE TABLE `mmall_order`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单id',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payment` decimal(20, 2) NULL DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(11) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付',
  `postage` int(11) NULL DEFAULT NULL COMMENT '运费,单位是元',
  `status` int(11) NULL DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime(0) NULL DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_no_index`(`order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_order
-- ----------------------------
INSERT INTO `mmall_order` VALUES ('103', '1491753014256', '1', '25', 13998.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-09 23:50:14', '2017-04-09 23:50:14');
INSERT INTO `mmall_order` VALUES ('104', '1491830695216', '1', '26', 13998.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-10 21:24:55', '2017-04-10 21:24:55');
INSERT INTO `mmall_order` VALUES ('105', '1492089528889', '1', '29', 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:18:48', '2017-04-13 21:18:48');
INSERT INTO `mmall_order` VALUES ('106', '1492090946105', '1', '29', 27894.00, 1, 0, 20, '2017-04-13 21:42:40', NULL, NULL, NULL, '2017-04-13 21:42:26', '2017-04-13 21:42:41');
INSERT INTO `mmall_order` VALUES ('107', '1492091003128', '1', '29', 8597.00, 1, 0, 20, '2017-04-13 21:43:38', NULL, NULL, NULL, '2017-04-13 21:43:23', '2017-04-13 21:43:38');
INSERT INTO `mmall_order` VALUES ('108', '1492091051313', '1', '29', 1999.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:11', '2017-04-13 21:44:11');
INSERT INTO `mmall_order` VALUES ('109', '1492091061513', '1', '29', 6598.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:21', '2017-04-13 21:44:21');
INSERT INTO `mmall_order` VALUES ('110', '1492091069563', '1', '29', 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:29', '2017-04-13 21:44:29');
INSERT INTO `mmall_order` VALUES ('111', '1492091076073', '1', '29', 4299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:36', '2017-04-13 21:44:36');
INSERT INTO `mmall_order` VALUES ('112', '1492091083720', '1', '29', 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:43', '2017-04-13 21:44:43');
INSERT INTO `mmall_order` VALUES ('113', '1492091089794', '1', '29', 6999.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:49', '2017-04-13 21:44:49');
INSERT INTO `mmall_order` VALUES ('114', '1492091096400', '1', '29', 6598.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:56', '2017-04-13 21:44:56');
INSERT INTO `mmall_order` VALUES ('115', '1492091102371', '1', '29', 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:45:02', '2017-04-13 21:45:02');
INSERT INTO `mmall_order` VALUES ('116', '1492091110004', '1', '29', 8598.00, 1, 0, 40, '2017-04-13 21:55:16', '2017-04-13 21:55:31', NULL, NULL, '2017-04-13 21:45:09', '2017-04-13 21:55:31');
INSERT INTO `mmall_order` VALUES ('117', '1492091141269', '1', '29', 22894.00, 1, 0, 20, '2017-04-13 21:46:06', NULL, NULL, NULL, '2017-04-13 21:45:41', '2017-04-13 21:46:07');

-- ----------------------------
-- Table structure for mmall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mmall_order_item`;
CREATE TABLE `mmall_order_item`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单子表id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
  `current_unit_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `total_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_no_index`(`order_no`) USING BTREE,
  INDEX `order_no_user_id_index`(`user_id`, `order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_order_item
-- ----------------------------
INSERT INTO `mmall_order_item` VALUES ('113', '1', '1491753014256', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-09 23:50:14', '2017-04-09 23:50:14');
INSERT INTO `mmall_order_item` VALUES ('114', '1', '1491830695216', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-10 21:24:55', '2017-04-10 21:24:55');
INSERT INTO `mmall_order_item` VALUES ('115', '1', '1492089528889', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:18:48', '2017-04-13 21:18:48');
INSERT INTO `mmall_order_item` VALUES ('116', '1', '1492090946105', '29', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES ('117', '1', '1492090946105', '28', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES ('118', '1', '1492090946105', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES ('119', '1', '1492090946105', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES ('120', '1', '1492091003128', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:43:23', '2017-04-13 21:43:23');
INSERT INTO `mmall_order_item` VALUES ('121', '1', '1492091003128', '28', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:43:23', '2017-04-13 21:43:23');
INSERT INTO `mmall_order_item` VALUES ('122', '1', '1492091051313', '28', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:44:11', '2017-04-13 21:44:11');
INSERT INTO `mmall_order_item` VALUES ('123', '1', '1492091061513', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:44:21', '2017-04-13 21:44:21');
INSERT INTO `mmall_order_item` VALUES ('124', '1', '1492091069563', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:44:29', '2017-04-13 21:44:29');
INSERT INTO `mmall_order_item` VALUES ('125', '1', '1492091076073', '29', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 1, 4299.00, '2017-04-13 21:44:36', '2017-04-13 21:44:36');
INSERT INTO `mmall_order_item` VALUES ('126', '1', '1492091083720', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:44:43', '2017-04-13 21:44:43');
INSERT INTO `mmall_order_item` VALUES ('127', '1', '1492091089794', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 1, 6999.00, '2017-04-13 21:44:49', '2017-04-13 21:44:49');
INSERT INTO `mmall_order_item` VALUES ('128', '1', '1492091096400', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:44:56', '2017-04-13 21:44:56');
INSERT INTO `mmall_order_item` VALUES ('129', '1', '1492091102371', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:45:02', '2017-04-13 21:45:02');
INSERT INTO `mmall_order_item` VALUES ('130', '1', '1492091110004', '29', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:45:09', '2017-04-13 21:45:09');
INSERT INTO `mmall_order_item` VALUES ('131', '1', '1492091141269', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 1, 6999.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES ('132', '1', '1492091141269', '27', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES ('133', '1', '1492091141269', '29', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES ('134', '1', '1492091141269', '28', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 2, 3998.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');

-- ----------------------------
-- Table structure for mmall_pay_info
-- ----------------------------
DROP TABLE IF EXISTS `mmall_pay_info`;
CREATE TABLE `mmall_pay_info`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `pay_platform` int(11) NULL DEFAULT NULL COMMENT '支付平台:1-支付宝,2-微信',
  `platform_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝支付流水号',
  `platform_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝支付状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_pay_info
-- ----------------------------
INSERT INTO `mmall_pay_info` VALUES ('53', '1', '1492090946105', 1, '2017041321001004300200116250', 'WAIT_BUYER_PAY', '2017-04-13 21:42:33', '2017-04-13 21:42:33');
INSERT INTO `mmall_pay_info` VALUES ('54', '1', '1492090946105', 1, '2017041321001004300200116250', 'TRADE_SUCCESS', '2017-04-13 21:42:41', '2017-04-13 21:42:41');
INSERT INTO `mmall_pay_info` VALUES ('55', '1', '1492091003128', 1, '2017041321001004300200116251', 'WAIT_BUYER_PAY', '2017-04-13 21:43:31', '2017-04-13 21:43:31');
INSERT INTO `mmall_pay_info` VALUES ('56', '1', '1492091003128', 1, '2017041321001004300200116251', 'TRADE_SUCCESS', '2017-04-13 21:43:38', '2017-04-13 21:43:38');
INSERT INTO `mmall_pay_info` VALUES ('57', '1', '1492091141269', 1, '2017041321001004300200116252', 'WAIT_BUYER_PAY', '2017-04-13 21:45:59', '2017-04-13 21:45:59');
INSERT INTO `mmall_pay_info` VALUES ('58', '1', '1492091141269', 1, '2017041321001004300200116252', 'TRADE_SUCCESS', '2017-04-13 21:46:07', '2017-04-13 21:46:07');
INSERT INTO `mmall_pay_info` VALUES ('59', '1', '1492091110004', 1, '2017041321001004300200116396', 'WAIT_BUYER_PAY', '2017-04-13 21:55:08', '2017-04-13 21:55:08');
INSERT INTO `mmall_pay_info` VALUES ('60', '1', '1492091110004', 1, '2017041321001004300200116396', 'TRADE_SUCCESS', '2017-04-13 21:55:17', '2017-04-13 21:55:17');

-- ----------------------------
-- Table structure for mmall_product
-- ----------------------------
DROP TABLE IF EXISTS `mmall_product`;
CREATE TABLE `mmall_product`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `category_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类id,对应mmall_category表的主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `subtitle` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品主图,url相对地址',
  `sub_images` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片地址,json格式,扩展用',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品详情',
  `price` decimal(20, 2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `status` int(11) NULL DEFAULT 1 COMMENT '商品状态.1-在售 2-下架',
  `del_code` int(11) NULL DEFAULT NULL COMMENT '逻辑删除标志位，0正常，1删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_product
-- ----------------------------
INSERT INTO `mmall_product` VALUES ('26', '100002', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', 'iPhone 7，现更以红色呈现。', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg,b6c56eb0-1748-49a9-98dc-bcc4b9788a54.jpeg,92f17532-1527-4563-aa1d-ed01baa0f7b2.jpeg,3adbe4f7-e374-4533-aa79-cc4a98c529bf.jpeg', '<p><img alt=\"10000.jpg\" src=\"http://img.happymmall.com/00bce8d4-e9af-4c8d-b205-e6c75c7e252b.jpg\" width=\"790\" height=\"553\"><br></p><p><img alt=\"20000.jpg\" src=\"http://img.happymmall.com/4a70b4b4-01ee-46af-9468-31e67d0995b8.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"30000.jpg\" src=\"http://img.happymmall.com/0570e033-12d7-49b2-88f3-7a5d84157223.jpg\" width=\"790\" height=\"365\"><br></p><p><img alt=\"40000.jpg\" src=\"http://img.happymmall.com/50515c02-3255-44b9-a829-9e141a28c08a.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"50000.jpg\" src=\"http://img.happymmall.com/c138fc56-5843-4287-a029-91cf3732d034.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"60000.jpg\" src=\"http://img.happymmall.com/c92d1f8a-9827-453f-9d37-b10a3287e894.jpg\" width=\"790\" height=\"525\"><br></p><p><br></p><p><img alt=\"TB24p51hgFkpuFjSspnXXb4qFXa-1776456424.jpg\" src=\"http://img.happymmall.com/bb1511fc-3483-471f-80e5-c7c81fa5e1dd.jpg\" width=\"790\" height=\"375\"><br></p><p><br></p><p><img alt=\"shouhou.jpg\" src=\"http://img.happymmall.com/698e6fbe-97ea-478b-8170-008ad24030f7.jpg\" width=\"750\" height=\"150\"><br></p><p><img alt=\"999.jpg\" src=\"http://img.happymmall.com/ee276fe6-5d79-45aa-8393-ba1d210f9c89.jpg\" width=\"790\" height=\"351\"><br></p>', 6999.00, 9991, 1, 0, '2020-06-07 20:55:13', '2020-06-07 21:45:41');
INSERT INTO `mmall_product` VALUES ('27', '100006', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', '送品牌烤箱，五一大促', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg,4bb02f1c-62d5-48cc-b358-97b05af5740d.jpeg,36bdb49c-72ae-4185-9297-78829b54b566.jpeg', '<p><img alt=\"miaoshu.jpg\" src=\"http://img.happymmall.com/9c5c74e6-6615-4aa0-b1fc-c17a1eff6027.jpg\" width=\"790\" height=\"444\"><br></p><p><img alt=\"miaoshu2.jpg\" src=\"http://img.happymmall.com/31dc1a94-f354-48b8-a170-1a1a6de8751b.jpg\" width=\"790\" height=\"1441\"><img alt=\"miaoshu3.jpg\" src=\"http://img.happymmall.com/7862594b-3063-4b52-b7d4-cea980c604e0.jpg\" width=\"790\" height=\"1442\"><img alt=\"miaoshu4.jpg\" src=\"http://img.happymmall.com/9a650563-dc85-44d6-b174-d6960cfb1d6a.jpg\" width=\"790\" height=\"1441\"><br></p>', 3299.00, 8876, 1, 0, '2017-04-13 18:51:54', '2017-04-13 21:45:41');
INSERT INTO `mmall_product` VALUES ('28', '100012', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', 'NOVA青春版1999元', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg,13da2172-4445-4eb5-a13f-c5d4ede8458c.jpeg,58d5d4b7-58d4-4948-81b6-2bae4f79bf02.jpeg', '<p><img alt=\"11TB2fKK3cl0kpuFjSsziXXa.oVXa_!!1777180618.jpg\" src=\"http://img.happymmall.com/5c2d1c6d-9e09-48ce-bbdb-e833b42ff664.jpg\" width=\"790\" height=\"966\"><img alt=\"22TB2YP3AkEhnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.happymmall.com/9a10b877-818f-4a27-b6f7-62887f3fb39d.jpg\" width=\"790\" height=\"1344\"><img alt=\"33TB2Yyshk.hnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.happymmall.com/7d7fbd69-a3cb-4efe-8765-423bf8276e3e.jpg\" width=\"790\" height=\"700\"><img alt=\"TB2diyziB8kpuFjSspeXXc7IpXa_!!1777180618.jpg\" src=\"http://img.happymmall.com/1d7160d2-9dba-422f-b2a0-e92847ba6ce9.jpg\" width=\"790\" height=\"393\"><br></p>', 1999.00, 9994, 1, 0, '2017-04-13 18:57:18', '2017-04-13 21:45:41');
INSERT INTO `mmall_product` VALUES ('29', '100008', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '门店机型 德邦送货', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg,42b1b8bc-27c7-4ee1-80ab-753d216a1d49.jpeg,2f1b3de1-1eb1-4c18-8ca2-518934931bec.jpeg', '<p><img alt=\"1TB2WLZrcIaK.eBjSspjXXXL.XXa_!!2114960396.jpg\" src=\"http://img.happymmall.com/ffcce953-81bd-463c-acd1-d690b263d6df.jpg\" width=\"790\" height=\"920\"><img alt=\"2TB2zhOFbZCO.eBjSZFzXXaRiVXa_!!2114960396.jpg\" src=\"http://img.happymmall.com/58a7bd25-c3e7-4248-9dba-158ef2a90e70.jpg\" width=\"790\" height=\"1052\"><img alt=\"3TB27mCtb7WM.eBjSZFhXXbdWpXa_!!2114960396.jpg\" src=\"http://img.happymmall.com/2edbe9b3-28be-4a8b-a9c3-82e40703f22f.jpg\" width=\"790\" height=\"820\"><br></p>', 4299.00, 9993, 1, 0, '2017-04-13 19:07:47', '2017-04-13 21:45:41');

-- ----------------------------
-- Table structure for mmall_shipping
-- ----------------------------
DROP TABLE IF EXISTS `mmall_shipping`;
CREATE TABLE `mmall_shipping`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货固定电话',
  `receiver_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货移动电话',
  `receiver_province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mmall_shipping
-- ----------------------------
INSERT INTO `mmall_shipping` VALUES ('29', '1267803844083834881', '1', '1', '1', '1', '1', '1', '1', '1', '2017-04-09 18:33:32', '2020-06-29 22:26:17');
INSERT INTO `mmall_shipping` VALUES ('4', '13', 'geely', '010', '18688888888', '北京', '北京市', '海淀区', '中关村', '100000', '2017-01-22 14:26:25', '2017-01-22 14:26:25');
INSERT INTO `mmall_shipping` VALUES ('7', '17', 'Rosen', '13800138000', '13800138000', '北京', '北京', NULL, '中关村', '100000', '2017-03-29 12:11:01', '2017-03-29 12:11:01');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点id',
  `role_index` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所有父级节点和当前节点',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称描述',
  `seq` int(11) NULL DEFAULT NULL COMMENT '角色排序',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '乐观锁版本号',
  `del_code` int(11) NULL DEFAULT NULL COMMENT '逻辑删除标识符， 是否删除0否1是',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 1, '1', '超级管理员', NULL, NULL, NULL, 0, '2019-07-20 16:11:30', NULL);
INSERT INTO `role` VALUES (2, 1, '1,2', '普通用户', NULL, NULL, NULL, 0, '2019-07-20 16:11:33', NULL);

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (2, 1);
INSERT INTO `role_resource` VALUES (2, 2);
INSERT INTO `role_resource` VALUES (2, 3);
INSERT INTO `role_resource` VALUES (2, 4);

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `oper_module` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作模块',
  `oper_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类型',
  `oper_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '操作用户id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '操作开始时间',
  `spend_time` int(11) NULL DEFAULT NULL COMMENT '操作消耗时间',
  `base_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '根路径',
  `method_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方法路径',
  `uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'uri',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法请求类型',
  `parameter` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `result` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求结果',
  `exception_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '异常名',
  `exception_msg` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '乐观锁版本号',
  `del_code` int(11) NULL DEFAULT NULL COMMENT '逻辑删除，是否删除，1是 0否',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, 'Hello模块', '查询', '获取Hello详情', 1, NULL, 0, 'http://localhost:8080', 'com.yunqing.mall.controller.HelloController.hello', '/mall/hello', 'http://localhost:8080/mall/hello', 'admin', 'GET', '{}', 'hello...', NULL, NULL, 1, 0, '2021-01-10 09:47:23', '2021-01-10 09:47:23');
INSERT INTO `sys_oper_log` VALUES (2, 'Hello模块', '查询', '获取Hello详情', 1, '2021-01-10 09:50:42', 1, 'http://localhost:8080', 'com.yunqing.mall.controller.HelloController.hello', '/mall/hello', 'http://localhost:8080/mall/hello', 'admin', 'GET', '{}', 'hello...', NULL, NULL, 1, 0, '2021-01-10 09:50:42', '2021-01-10 09:50:42');
INSERT INTO `sys_oper_log` VALUES (3, '操作日志模块', 'QUERY', '查询单条操作日志', 1, '2021-01-11 13:45:40', 55, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.detail', '/mall/sys_oper_log', 'http://localhost:8080/mall/sys_oper_log', '0:0:0:0:0:0:0:1', 'GET', '{\"id\":\"1\"}', '{\"msg\":\"SUCCESS\",\"code\":\"200\",\"data\":{\"methodPath\":\"com.yunqing.mall.controller.HelloController.hello\",\"delCode\":0,\"operDesc\":\"获取Hello详情\",\"method\":\"GET\",\"ip\":\"admin\",\"updateTime\":1610243243000,\"operModule\":\"Hello模块\",\"operType\":\"查询\",\"userId\":1,\"uri\":\"/mall/hello\",\"version\":1,\"url\":\"http://localhost:8080/mall/hello\",\"result\":\"hello...\",\"basePath\":\"http://localhost:8080\",\"createTime\":1610243243000,\"parameter\":\"{}\",\"id\":1,\"spendTime\":0},\"status\":true}', NULL, NULL, 1, 0, '2021-01-11 13:45:40', '2021-01-11 13:45:40');
INSERT INTO `sys_oper_log` VALUES (4, '操作日志模块', 'QUERY', '查询操作日志分页列表', 1, '2021-01-11 13:50:19', 5, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.list', '/mall/sys_oper_log/list', 'http://localhost:8080/mall/sys_oper_log/list', '0:0:0:0:0:0:0:1', 'GET', '{\"limit\":\"5\",\"page\":\"1\"}', '{\"msg\":\"SUCCESS\",\"code\":\"200\",\"data\":{\"hitCount\":false,\"records\":[{\"operDesc\":\"查询单条操作日志\",\"logMethod\":\"GET\",\"operModule\":\"操作日志模块\",\"operType\":\"QUERY\",\"userId\":\"1\",\"logIp\":\"0:0:0:0:0:0:0:1\",\"createTime\":1610343940000,\"logParams\":\"{\\\"id\\\":\\\"1\\\"}\",\"id\":3,\"username\":\"admin\",\"spendTime\":55},{\"operDesc\":\"获取Hello详情\",\"logMethod\":\"GET\",\"operModule\":\"Hello模块\",\"operType\":\"查询\",\"userId\":\"1\",\"logIp\":\"admin\",\"createTime\":1610243442000,\"logParams\":\"{}\",\"id\":2,\"username\":\"admin\",\"spendTime\":1},{\"operDesc\":\"获取Hello详情\",\"logMethod\":\"GET\",\"operModule\":\"Hello模块\",\"operType\":\"查询\",\"userId\":\"1\",\"logIp\":\"admin\",\"createTime\":1610243243000,\"logParams\":\"{}\",\"id\":1,\"username\":\"admin\",\"spendTime\":0}],\"total\":3,\"current\":1,\"size\":5,\"orders\":[],\"isSearchCount\":true},\"status\":true}', NULL, NULL, 1, 0, '2021-01-11 13:50:19', '2021-01-11 13:50:19');
INSERT INTO `sys_oper_log` VALUES (5, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 13:53:25', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '0:0:0:0:0:0:0:1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 13:53:25', '2021-01-11 13:53:25');
INSERT INTO `sys_oper_log` VALUES (6, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 13:56:31', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '0:0:0:0:0:0:0:1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 13:56:31', '2021-01-11 13:56:31');
INSERT INTO `sys_oper_log` VALUES (7, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 14:04:22', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '0:0:0:0:0:0:0:1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 14:04:22', '2021-01-11 14:04:22');
INSERT INTO `sys_oper_log` VALUES (1348531418263412737, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 15:25:19', 17, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '0:0:0:0:0:0:0:1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 15:25:19', '2021-01-11 15:25:19');
INSERT INTO `sys_oper_log` VALUES (1348531435711717377, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 15:25:23', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '0:0:0:0:0:0:0:1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 15:25:23', '2021-01-11 15:25:23');
INSERT INTO `sys_oper_log` VALUES (1348533272724594690, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 15:32:41', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '127.0.0.1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 15:32:41', '2021-01-11 15:32:41');
INSERT INTO `sys_oper_log` VALUES (1348533368677687297, '操作日志模块', 'EXPORT', '导出操作日志', 1, '2021-01-11 15:33:04', 0, 'http://localhost:8080', 'com.yunqing.mall.scaffold.controller.log.SysOperLogController.exportSysLogList', '/mall/sys_oper_log/export', 'http://localhost:8080/mall/sys_oper_log/export', '127.0.0.1', 'GET', '{}', NULL, NULL, NULL, 1, 0, '2021-01-11 15:33:04', '2021-01-11 15:33:04');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(126) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `actual_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别: 0-女，1-男',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `post_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位称呼',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态: 0-禁用，1-启用',
  `del_code` int(11) NULL DEFAULT NULL COMMENT '逻辑删除标志位，0正常，1删除',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$3LZ0PbXV2wLV00FwW73mZeq5OUvhAN.g3/0eWLQKn3MZja9RbkUzW', NULL, '张三', 0, 'abc@qq.com', '13696003468', '成都市', '部门经理', 1, 0, NULL, '2019-07-20 16:03:57', NULL);
INSERT INTO `user` VALUES (2, 'test', '$2a$10$64iuSLkKNhpTN19jGHs7xePvFsub7ZCcCmBqEYw8fbACGTE3XetYq', NULL, '小美', 1, '234@163.com', '19263231589', '达州市', '普通员工', 1, 0, NULL, '2019-07-20 16:04:37', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
