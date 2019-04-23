/*
 Navicat MySQL Data Transfer

 Source Server         : 
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 
 Source Schema         : tcip

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 01/01/2019 18:30:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ip_appschedule
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_appschedule`;
CREATE TABLE `t_ip_appschedule`  (
  `id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����id',
  `schedule_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ʱ����id',
  `app_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'tcis����id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_ip_appschedule
-- ----------------------------
INSERT INTO `t_ip_appschedule` VALUES ('1', '1', 'MTL');
INSERT INTO `t_ip_appschedule` VALUES ('2', '2', 'MTL');
INSERT INTO `t_ip_appschedule` VALUES ('3', '3', 'MTL');
INSERT INTO `t_ip_appschedule` VALUES ('4', '4', 'MTL');

-- ----------------------------
-- Table structure for t_ip_bankschedule
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_bankschedule`;
CREATE TABLE `t_ip_bankschedule`  (
  `id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����id',
  `schedule_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ʱ����id',
  `dataorgid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����id',
  `org_code` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ֹ�˾id',
  `bank_code` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '���д���',
  `flow_no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ˮ��',
  `file_name_input` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����ļ���',
  `file_name_back` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����ļ���',
  `file_input_size` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����ļ���С',
  `file_back_size` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����ļ���С',
  `create_date` time(0) NULL DEFAULT NULL COMMENT '����ʱ��',
  `back_date` time(0) NULL DEFAULT NULL COMMENT '����ʱ��',
  `status` int(1) NULL DEFAULT 0 COMMENT '״̬(0:δ����,1:�ѻ���)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for t_ip_org_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_org_schedule`;
CREATE TABLE `t_ip_org_schedule`  (
  `id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����ID',
  `schedule_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ʱ����ID',
  `org_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_ip_org_schedule
-- ----------------------------
INSERT INTO `t_ip_org_schedule` VALUES ('1', '1', '1');
INSERT INTO `t_ip_org_schedule` VALUES ('2', '2', '1');
INSERT INTO `t_ip_org_schedule` VALUES ('3', '3', '1');
INSERT INTO `t_ip_org_schedule` VALUES ('4', '4', '1');

-- ----------------------------
-- Table structure for t_ip_orginfo
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_orginfo`;
CREATE TABLE `t_ip_orginfo`  (
  `id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����ID',
  `dataorgid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����id',
  `org_code` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����ֹ�˾ID',
  `org_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��������',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_ip_orginfo
-- ----------------------------
INSERT INTO `t_ip_orginfo` VALUES ('1', '11002', 'YH0105', '����', '2018-12-27 16:20:26');

-- ----------------------------
-- Table structure for t_ip_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_schedule`;
CREATE TABLE `t_ip_schedule`  (
  `id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
  `export_cron` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron���ʽ',
  `start_time` time(0) NULL DEFAULT NULL COMMENT '��ʼʱ��',
  `run_time` time(0) NULL DEFAULT NULL COMMENT '����ʱ��',
  `status` int(1) NULL DEFAULT NULL COMMENT '״̬��0��δ���� 1�������� 2:������ɣ�',
  `type` int(1) NULL DEFAULT NULL COMMENT '�������ͣ�0���ֶ� 1�����ڣ�',
  `tcis_code` int(5) NULL DEFAULT NULL COMMENT 'tcis3.0Api�������',
  `bank_code` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '���д���',
  `create_userId` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������id',
  `repeat_count` int(9) NULL DEFAULT 0 COMMENT '���д���',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_ip_schedule
-- ----------------------------
INSERT INTO `t_ip_schedule` VALUES ('1', '�й��������۶�ʱ����', '0 0/2 * * * ?', '22:30:01', '22:30:01', 2, 0, 2008, 'ZG', '1', 0);
INSERT INTO `t_ip_schedule` VALUES ('2', '�й����л��̶�ʱ����', '0 0/5 * * * ?', '22:30:02', '22:30:02', 2, 0, 2009, 'ZG', '1', 0);
INSERT INTO `t_ip_schedule` VALUES ('3', '�����������۶�ʱ����', '0 0/2 * * * ?', '18:22:05', '18:22:05', 2, 1, 2008, 'JS', '1', 37);
INSERT INTO `t_ip_schedule` VALUES ('4', '�������л��̶�ʱ����', '0 0/5 * * * ?', '18:21:26', '18:15:02', 2, 1, 2009, 'JS', '1', 35);

SET FOREIGN_KEY_CHECKS = 1;
