/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 21/12/2020 17:46:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID,主键自增',
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同ID,主键自增',
  `contract_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同名称',
  `customer_id` int(11) NOT NULL COMMENT '客户ID,关联客户表主键',
  `contract_price` double(12, 2) NULL DEFAULT 0.00 COMMENT '合同金额',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `customer_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户签约人',
  `conmpany_sign_id` int(11) NOT NULL COMMENT '公司签约人ID,关联员工表主键',
  `charge_id` int(11) NOT NULL COMMENT '合同负责人ID,关联员工表主键',
  `approval1_id` int(11) NOT NULL COMMENT '审批人1ID关联员工表主键',
  `approval2_id` int(11) NOT NULL COMMENT '审批人2ID关联员工表主键',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '合同状态 0: 已创建,待审核 1: 审批人1通过 2:审批人1未通过 3:审批人2通过 4: 审批人2未通过',
  PRIMARY KEY (`contract_id`) USING BTREE,
  INDEX `customer_id`(`customer_id`) USING BTREE,
  INDEX `conmpany_sign_id`(`conmpany_sign_id`) USING BTREE,
  INDEX `charge_id`(`charge_id`) USING BTREE,
  INDEX `approval1_id`(`approval1_id`) USING BTREE,
  INDEX `approval2_id`(`approval2_id`) USING BTREE,
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`conmpany_sign_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_ibfk_3` FOREIGN KEY (`charge_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_ibfk_4` FOREIGN KEY (`approval1_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_ibfk_5` FOREIGN KEY (`approval2_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_product
-- ----------------------------
DROP TABLE IF EXISTS `contract_product`;
CREATE TABLE `contract_product`  (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `contract_id` int(11) NOT NULL COMMENT '合同ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `count` int(11) NULL DEFAULT 1 COMMENT '产品数量',
  PRIMARY KEY (`cp_id`) USING BTREE,
  INDEX `contract_id`(`contract_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `contract_product_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '合同产品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID,主键自增',
  `customer_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int(11) NULL DEFAULT NULL COMMENT '客户状态 0: 未签约 1:已签约',
  `charge_id` int(11) NOT NULL COMMENT '负责人ID,关联员工表主键',
  `create_id` int(11) NOT NULL COMMENT '创建人ID,关联员工表主键',
  `source_id` int(11) NOT NULL COMMENT '客户来源ID,关联来源表主键',
  `industry_id` int(11) NOT NULL COMMENT '客户行业ID,关联行业表主键',
  `level_id` int(11) NOT NULL COMMENT '客户级别ID,关联级别表主键',
  `flag` int(11) NOT NULL COMMENT '标识位 0:线索 1: 客户 2: 公海',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `next_time` datetime(0) NULL DEFAULT NULL COMMENT '下次联系时间',
  PRIMARY KEY (`customer_id`) USING BTREE,
  INDEX `charge_id`(`charge_id`) USING BTREE,
  INDEX `create_id`(`create_id`) USING BTREE,
  INDEX `source_id`(`source_id`) USING BTREE,
  INDEX `industry_id`(`industry_id`) USING BTREE,
  INDEX `level_id`(`level_id`) USING BTREE,
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`charge_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`create_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_4` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_5` FOREIGN KEY (`level_id`) REFERENCES `level` (`level_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID,主键自增',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '成立时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工ID,主键自增',
  `emp_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工名称',
  `age` int(11) NULL DEFAULT 0 COMMENT '员工年龄',
  `dept_id` int(11) NOT NULL COMMENT '部门ID关联部门表主键',
  `hire_date` datetime(0) NULL DEFAULT NULL COMMENT '入职时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'images/users/avatar.jpg' COMMENT '头像',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `industry_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业ID,主键自增',
  `industry_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业名称',
  PRIMARY KEY (`industry_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户行业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level`  (
  `level_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户级别ID,主键自增',
  `level_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户级别名称',
  PRIMARY KEY (`level_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户级别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID,主键自增',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `category_id` int(11) NOT NULL COMMENT '分类ID,关联分类表主键',
  `price` double(10, 2) NULL DEFAULT 0.00 COMMENT '产品价格',
  `create_id` int(11) NOT NULL COMMENT '创建人ID,关联员工表主键',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(11) NULL DEFAULT 1 COMMENT '上下架 0: 下架 1:上架',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `create_id`(`create_id`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`create_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `source_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '来源ID,主键自增',
  `source_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源名称',
  PRIMARY KEY (`source_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户来源表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
