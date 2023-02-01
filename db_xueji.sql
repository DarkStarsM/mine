/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : db_xueji

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/01/2023 09:34:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPw` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '123456a.');
INSERT INTO `t_admin` VALUES (2, 'kjh', '4815');

-- ----------------------------
-- Table structure for t_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `banji_id` int(11) NOT NULL,
  `banji_id2` int(255) NOT NULL,
  `del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_apply
-- ----------------------------
INSERT INTO `t_apply` VALUES (1, 1, 2, 1, 'yes');
INSERT INTO `t_apply` VALUES (2, 4, 4, 3, 'yes');
INSERT INTO `t_apply` VALUES (3, 2, 2, 4, 'yes');

-- ----------------------------
-- Table structure for t_banji
-- ----------------------------
DROP TABLE IF EXISTS `t_banji`;
CREATE TABLE `t_banji`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhuanye_id` int(10) NULL DEFAULT NULL,
  `del` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_banji
-- ----------------------------
INSERT INTO `t_banji` VALUES (1, '通信工程专业1班 ', 1, 'no');
INSERT INTO `t_banji` VALUES (2, '信息工程专业1班 ', 2, 'no');
INSERT INTO `t_banji` VALUES (3, '软工大数据01', 5, 'no');
INSERT INTO `t_banji` VALUES (4, '移动应用开发01', 5, 'no');

-- ----------------------------
-- Table structure for t_chengji
-- ----------------------------
DROP TABLE IF EXISTS `t_chengji`;
CREATE TABLE `t_chengji`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_id` int(10) NULL DEFAULT NULL,
  `kecheng_id` int(10) NULL DEFAULT NULL,
  `chengji` int(10) NULL DEFAULT NULL,
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chengji
-- ----------------------------
INSERT INTO `t_chengji` VALUES (35, 2, 2, 68, '1.80', 'no');
INSERT INTO `t_chengji` VALUES (36, 4, 2, 86, '3.60', 'no');
INSERT INTO `t_chengji` VALUES (37, 4, 2, 43, 's', 'no');
INSERT INTO `t_chengji` VALUES (38, 4, 4, 60, '1.0', 'no');
INSERT INTO `t_chengji` VALUES (39, 1, 4, 97, '4.7', 'no');
INSERT INTO `t_chengji` VALUES (40, 1, 5, 59, '0', 'no');
INSERT INTO `t_chengji` VALUES (41, 5, 2, 86, '3.6', 'no');
INSERT INTO `t_chengji` VALUES (42, 5, 1, 72, '2.2', 'no');
INSERT INTO `t_chengji` VALUES (43, 2, 1, 60, '1.0', 'no');
INSERT INTO `t_chengji` VALUES (44, 2, 2, 61, '1.1', 'no');
INSERT INTO `t_chengji` VALUES (45, 1, 1, 87, '3.7', 'yes');
INSERT INTO `t_chengji` VALUES (46, 1, 1, 97, '4.7', 'no');
INSERT INTO `t_chengji` VALUES (47, 1, 2, 67, '1.7', 'no');

-- ----------------------------
-- Table structure for t_jiangcheng
-- ----------------------------
DROP TABLE IF EXISTS `t_jiangcheng`;
CREATE TABLE `t_jiangcheng`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_id` int(10) NULL DEFAULT NULL,
  `shijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shuxing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_jiangcheng
-- ----------------------------
INSERT INTO `t_jiangcheng` VALUES (1, 1, '大一上', '三好学生', '成绩优良', 'no');
INSERT INTO `t_jiangcheng` VALUES (2, 2, '大二下', '优秀奖金', '成绩前十', 'no');

-- ----------------------------
-- Table structure for t_kecheng
-- ----------------------------
DROP TABLE IF EXISTS `t_kecheng`;
CREATE TABLE `t_kecheng`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xuefen` int(10) NULL DEFAULT NULL,
  `xuenian` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tid` int(10) NULL DEFAULT NULL,
  `del` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_kecheng
-- ----------------------------
INSERT INTO `t_kecheng` VALUES (1, '高等数学2', 6, '大一下', '大类基础课', 2, 'no');
INSERT INTO `t_kecheng` VALUES (2, '通信原理', 3, '大二下', '通识课程', 1, 'no');
INSERT INTO `t_kecheng` VALUES (4, '大学英语', 4, '大一上', '通识课程', 1, 'no');
INSERT INTO `t_kecheng` VALUES (5, '大学英语', 4, '大一上', '通识课程', 1, 'yes');
INSERT INTO `t_kecheng` VALUES (6, '高等数学1', 5, '大一上', '大类基础课', 2, 'no');
INSERT INTO `t_kecheng` VALUES (7, 'Java程序设计', 3, '大二上', '专业课程', 3, 'no');
INSERT INTO `t_kecheng` VALUES (8, '算法分析与设计', 3, '大二上', '专业课程', 3, 'no');
INSERT INTO `t_kecheng` VALUES (9, '数据库设计', 2, '大二下', '专业课程', 3, 'no');
INSERT INTO `t_kecheng` VALUES (10, '数据结构课程设计', 1, '大二上', '实践课程', 4, 'no');
INSERT INTO `t_kecheng` VALUES (11, '计算机网络原理课程设计', 2, '大二上', '实践课程', 4, 'no');
INSERT INTO `t_kecheng` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_kecheng` VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_kecheng` VALUES (14, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `xuehao` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name1` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banji_id` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ruxueshijian` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `biyeshijian` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xuezhi` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xuexiao` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avggrade` double(4, 3) NULL DEFAULT NULL,
  `del` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES (1, '20200310209', '张三', '男', '20', '1', '2020-09-10', '2024-06-15', '四年', '浙江工业大学', 3.911, 'no');
INSERT INTO `t_stu` VALUES (2, '202003150210', '李四', '男', '19', '4', '2020-09-10', '2024-06-15', '四年', '浙江工业大学', 1.225, 'no');
INSERT INTO `t_stu` VALUES (4, '202003150211', '陈虎', '男', '20', '3', '2020-09-10', '2024-06-15', '四年', '浙江工业大学', 2.114, 'no');
INSERT INTO `t_stu` VALUES (5, '202003150212', '王丹', '女', '21', '3', '2020-09-10', '2024-06-15', '四年', '浙江工业大学', 2.667, 'no');

-- ----------------------------
-- Table structure for t_zhuanye
-- ----------------------------
DROP TABLE IF EXISTS `t_zhuanye`;
CREATE TABLE `t_zhuanye`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jieshao` varchar(555) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_zhuanye
-- ----------------------------
INSERT INTO `t_zhuanye` VALUES (1, '通信工程专业', '通信工程专业', 'no');
INSERT INTO `t_zhuanye` VALUES (2, '信息工程专业', '信息工程专业', 'no');
INSERT INTO `t_zhuanye` VALUES (3, '计算机专业', '计算机专业', 'yes');
INSERT INTO `t_zhuanye` VALUES (5, '计算机科学与技术', '好', 'no');

SET FOREIGN_KEY_CHECKS = 1;
