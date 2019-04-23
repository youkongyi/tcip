/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : tcip

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-23 13:41:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_ip_accesstoken
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_accesstoken`;
CREATE TABLE `t_ip_accesstoken` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL COMMENT '第三方应用ID',
  `orgcode` varchar(255) DEFAULT NULL COMMENT '机构代码',
  `dataorgid` int(11) DEFAULT NULL COMMENT '公司ID',
  `expiredate` date DEFAULT NULL COMMENT '失效日期',
  `secret` varchar(255) DEFAULT NULL COMMENT '私钥',
  `accesstoken` varchar(255) NOT NULL DEFAULT '' COMMENT '公钥',
  `area` varchar(255) DEFAULT NULL COMMENT '区域',
  `url` varchar(255) DEFAULT NULL COMMENT 'TCIS服务器地址',
  `state` tinyint(11) DEFAULT '0' COMMENT '状态',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `createby` varchar(255) DEFAULT NULL COMMENT '创建人',
  `lastmodifytime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `modifyby` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`pkid`,`accesstoken`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_accesstoken
-- ----------------------------
INSERT INTO `t_ip_accesstoken` VALUES ('11', 'VCC', 'ZS0105', '11302', '2099-08-31', 'SDFD', 'VCC', null, 'http://10.72.32.165:7001/default/VccWebServiceService?wsdl', '0', '2017-09-19 14:36:35', null, '2017-09-19 14:36:35', null);
INSERT INTO `t_ip_accesstoken` VALUES ('14', 'hotline', 'SU0105', '1', '2099-12-31', '1', 'T3BZdzI5bW4zektjS09nTFFJQ3lUY0cwWXZCQm1mQUs=', null, 'http://www.baidu.com', '0', '2017-08-10 11:34:39', null, '2017-08-10 11:34:39', null);
INSERT INTO `t_ip_accesstoken` VALUES ('15', 'GS', 'ZS01015', '11302', '2099-12-31', 'gs', 'c0xjKzN5Z2JrSm5Qa0d3UW4wNnJ5c0cwWXZCQm1mQUs=', null, 'www.baidu.com', '0', '2017-10-12 15:36:29', null, '2017-10-12 15:36:29', null);
INSERT INTO `t_ip_accesstoken` VALUES ('20', 'VCC', 'DY0105', '11301', '2017-11-07', 'TEST', 'alhjY1NpaENwZG9WRlBLdDZieTZJVDNjamRDVkRJdDcwLjEwOTI5ODgwNDM1Mzc2MDgz', null, 'http://10.72.32.165:7001/default/VccWebServiceService?wsdl', '0', '2017-11-16 11:34:12', null, '2017-11-16 11:34:12', null);
INSERT INTO `t_ip_accesstoken` VALUES ('21', 'VCC', 'DY0105', '11104', '2017-11-07', 'TEST', 'WFJoWE1QNTY3VFFWRlBLdDZieTZJVDNjamRDVkRJdDcwLjU1NzMwMDE1MjY3MDcyNDE=', null, 'http://10.72.32.165:7001/default/VccWebServiceService?wsdl', '0', '2017-11-16 11:34:20', null, '2017-11-16 11:34:20', null);
INSERT INTO `t_ip_accesstoken` VALUES ('22', '123', '123', '123', '2018-05-02', '123', 'VWVxb2YrM1VNMEQvM003SkRSSWIrdz09MC4yOTU0MDQ1MTcwMzMyMjMyNA==', null, '123', '0', '2018-05-31 21:03:31', null, '2018-05-31 21:03:31', null);

-- ----------------------------
-- Table structure for t_ip_app
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_app`;
CREATE TABLE `t_ip_app` (
  `appid` varchar(255) NOT NULL COMMENT '应用ID',
  `appname` varchar(255) DEFAULT NULL COMMENT '应用名',
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_app
-- ----------------------------
INSERT INTO `t_ip_app` VALUES ('DYS', '德云思');
INSERT INTO `t_ip_app` VALUES ('GS', '工商管理系统');
INSERT INTO `t_ip_app` VALUES ('HOTLINE', '热线');
INSERT INTO `t_ip_app` VALUES ('VCC', '虚拟客户中心');

-- ----------------------------
-- Table structure for t_ip_appinterface
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_appinterface`;
CREATE TABLE `t_ip_appinterface` (
  `appid` varchar(11) NOT NULL,
  `interfaceid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`appid`,`interfaceid`),
  KEY `interfaceid` (`interfaceid`),
  CONSTRAINT `apid` FOREIGN KEY (`appid`) REFERENCES `t_ip_app` (`appid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_appinterface
-- ----------------------------
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '1');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '2');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '3');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '4');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '5');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '6');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '7');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '8');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '9');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '10');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '11');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '12');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '13');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '14');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '15');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '16');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '17');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '18');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '19');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '20');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '21');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '22');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '23');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '24');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '25');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '26');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '27');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '29');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '30');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '31');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '32');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '33');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '34');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '35');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '36');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '37');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '38');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '39');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '40');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '41');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '42');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '43');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '44');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '45');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '46');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '47');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '48');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '49');
INSERT INTO `t_ip_appinterface` VALUES ('GS', '50');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '50');
INSERT INTO `t_ip_appinterface` VALUES ('VCC', '51');

-- ----------------------------
-- Table structure for t_ip_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_dict`;
CREATE TABLE `t_ip_dict` (
  `typecode` varchar(255) DEFAULT NULL COMMENT '字典类型',
  `dictid` varchar(255) DEFAULT NULL COMMENT '字典ID',
  `dictname` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `parentid` varchar(255) DEFAULT NULL COMMENT '交机构',
  `filter1` varchar(255) DEFAULT NULL COMMENT '过滤字段',
  `filter2` varchar(255) DEFAULT NULL COMMENT '过滤字段'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_ip_eventpushlog
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_eventpushlog`;
CREATE TABLE `t_ip_eventpushlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pushcode` varchar(10) DEFAULT NULL COMMENT '推送接口编码',
  `appid` varchar(255) DEFAULT NULL COMMENT '应用ID',
  `url` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '请求返回码',
  `message` blob,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '推送时间',
  `dataorgid` varchar(255) DEFAULT NULL COMMENT '分公司ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_eventpushlog
-- ----------------------------
INSERT INTO `t_ip_eventpushlog` VALUES ('59', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDA8C9E8D2F8D0D0222C22757365726964223A2231383030373336343535222C2266656574797065223A2247222C226368726773756D223A22322E3236227D5D7D, '2017-08-18 11:21:54', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('60', '4007', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267436F6465223A223131333032222C2234303037223A5B7B227374617465223A22313031222C22757365726964223A2231383030373336343535222C226261636B636F6E74656E74223A22BFDBCAD5B3C9B9A6222C226368726773756D223A22322E3236227D5D7D, '2017-08-18 11:26:28', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('61', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D5D7D, '2017-08-18 14:18:57', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('62', '4005', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303035223A5B7B227374617465223A2237222C22757365726964223A2231383030303730313739222C22706B6964223A224253313730383138313632303538393232383835227D5D7D, '2017-08-18 16:23:49', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('63', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDBBCDA8D2F8D0D0222C22757365726964223A2231383030333034383035222C2266656574797065223A2247222C226368726773756D223A22343236372E32227D2C7B2262616E6B6E616D65223A22BDBBCDA8D2F8D0D0222C22757365726964223A2231383030333034383035222C2266656574797065223A2247222C226368726773756D223A2231303335227D5D7D, '2017-08-18 16:35:49', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('64', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDA8C9E8D2F8D0D0222C22757365726964223A2231383030303730313832222C2266656574797065223A2247222C226368726773756D223A2235332E3334227D5D7D, '2017-08-18 17:00:34', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('65', '4007', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267436F6465223A223131333032222C2234303037223A5B7B227374617465223A22313031222C22757365726964223A2231383030303730313832222C226261636B636F6E74656E74223A22BFDBCAD5B3C9B9A6222C226368726773756D223A2235332E3334227D5D7D, '2017-08-18 17:03:47', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('66', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D5D7D, '2017-08-18 17:05:57', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('67', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDA8C9E8D2F8D0D0222C22757365726964223A2231383030303730313832222C2266656574797065223A2247222C226368726773756D223A2233302E3438227D5D7D, '2017-08-18 17:08:53', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('68', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDA8C9E8D2F8D0D0222C22757365726964223A2231383030303730313832222C2266656574797065223A2247222C226368726773756D223A2234312E3931227D5D7D, '2017-08-18 17:18:14', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('69', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-18 17:23:33', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('70', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-18 17:25:47', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('71', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-18 17:27:31', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('72', '4003', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267436F6465223A223131333032222C2234303033223A5B7B22757365726964223A2231383030353237343634227D2C7B22757365726964223A2231383030353137363039227D2C7B22757365726964223A2231383030353433313134227D2C7B22757365726964223A2231383030353237343432227D5D7D, '2017-08-19 09:47:44', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('73', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030353533333137227D2C7B22757365726964223A2231383030313536303032227D5D7D, '2017-08-19 14:21:06', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('74', '4005', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303035223A5B7B227374617465223A2237222C22757365726964223A2231383030303730313832222C22706B6964223A224253313730383139313431383237383230373937227D5D7D, '2017-08-19 14:48:32', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('75', '4004', 'VCC', 'http://www.sohu.com', '405', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030353533333137227D2C7B22757365726964223A2231383030313536303032227D5D7D, '2017-08-19 16:23:31', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('76', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D2C7B22757365726964223A2231383030323435323033227D5D7D, '2017-08-19 17:50:58', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('77', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030303730313835227D5D7D, '2017-08-22 16:16:09', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('78', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030303730313835227D5D7D, '2017-08-22 16:17:22', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('79', '4006', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C2234303036223A5B7B2262616E6B6E616D65223A22BDA8C9E8D2F8D0D0222C22757365726964223A2231383030313436303233222C2266656574797065223A2247222C226368726773756D223A2237362E32227D5D7D, '2017-08-22 16:19:11', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('80', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030303730313835227D5D7D, '2017-08-22 16:27:57', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('81', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231393030303139303835227D2C7B22757365726964223A2231383030303730313835227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-23 11:11:12', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('82', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231393030303139303835227D2C7B22757365726964223A2231383030303730313835227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-23 11:13:30', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('83', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231393030303139303835227D2C7B22757365726964223A2231383030303730313835227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-23 11:17:50', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('84', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231393030303139303835227D2C7B22757365726964223A2231383030303730313835227D2C7B22757365726964223A2231383030303730313832227D5D7D, '2017-08-23 14:17:44', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('85', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D5D7D, '2017-09-04 16:34:19', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('86', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D5D7D, '2017-09-04 16:34:24', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('87', '4004', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303034223A5B7B22757365726964223A2231383030363832353334227D5D7D, '2017-09-04 16:34:29', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('88', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 10:58:16', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('89', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 10:58:21', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('90', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 10:58:26', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('91', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030303439323631227D5D7D, '2017-09-20 11:13:08', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('92', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030303439323631227D5D7D, '2017-09-20 11:13:13', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('93', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030303439323631227D5D7D, '2017-09-20 11:13:19', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('94', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 11:26:52', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('95', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 11:26:57', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('96', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030353933363134227D5D7D, '2017-09-20 11:27:02', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('97', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030323230383436227D5D7D, '2017-09-20 12:19:16', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('98', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030323230383436227D5D7D, '2017-09-20 12:19:22', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('99', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030323230383436227D5D7D, '2017-09-20 12:19:27', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('100', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030393633383137227D5D7D, '2017-09-20 12:58:25', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('101', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030393633383137227D5D7D, '2017-09-20 12:58:30', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('102', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030393633383137227D5D7D, '2017-09-20 12:58:35', '11302');
INSERT INTO `t_ip_eventpushlog` VALUES ('103', '4008', 'VCC', 'http://www.baidu.com', '302', 0x7B22646174616F72676964223A223131333032222C226F7267636F6465223A225A5330313035222C2234303038223A5B7B22757365726964223A2231383030393633383137227D5D7D, '2017-10-17 09:46:31', '11302');

-- ----------------------------
-- Table structure for t_ip_eventreg
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_eventreg`;
CREATE TABLE `t_ip_eventreg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `messagecode` varchar(255) DEFAULT NULL COMMENT '事件编码',
  `url` varchar(255) DEFAULT NULL COMMENT '第三方Web URL',
  `token` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT '',
  `appid` varchar(255) DEFAULT NULL,
  `cancelflag` int(1) DEFAULT '0' COMMENT '是否取消，0否，1是',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_eventreg
-- ----------------------------
INSERT INTO `t_ip_eventreg` VALUES ('31', '4007', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-08-14 16:30:04', null);
INSERT INTO `t_ip_eventreg` VALUES ('32', '4004', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-08-19 17:49:19', null);
INSERT INTO `t_ip_eventreg` VALUES ('33', '4005', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-08-19 17:53:44', null);
INSERT INTO `t_ip_eventreg` VALUES ('34', '4006', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-08-19 17:55:43', null);
INSERT INTO `t_ip_eventreg` VALUES ('35', '4003', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '1', '2017-08-19 17:58:11', '2017-08-19 17:58:11');
INSERT INTO `t_ip_eventreg` VALUES ('36', '4003', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-08-22 11:23:33', null);
INSERT INTO `t_ip_eventreg` VALUES ('37', '4008', 'http://www.baidu.com', 'VCC', 'push', 'VCC', '0', '2017-09-20 10:48:36', null);

-- ----------------------------
-- Table structure for t_ip_interservice
-- ----------------------------
DROP TABLE IF EXISTS `t_ip_interservice`;
CREATE TABLE `t_ip_interservice` (
  `id` varchar(255) DEFAULT NULL,
  `tciscode` varchar(255) DEFAULT NULL,
  `tcipcode` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ip_interservice
-- ----------------------------
INSERT INTO `t_ip_interservice` VALUES ('1', 'addr', null, '0', '地址信息同步', '增量地址');
INSERT INTO `t_ip_interservice` VALUES ('2', 'supplypoint', null, '0', '供气点信息', '定时同步供气点信息');
INSERT INTO `t_ip_interservice` VALUES ('4', '1002', 'query_contact', '1', '联系人信息查询', '根据户号，查询所有联系人信息');
INSERT INTO `t_ip_interservice` VALUES ('5', '3001', 'busi_modifycontinfo', '3', '联系人信息变更', '联系人信息变更（增加、修改）');
INSERT INTO `t_ip_interservice` VALUES ('6', '1003', 'query_user', '1', '用户信息查询', '根据根据户号，证件类型和证件号码、手机号码、IC卡信息查询,增加标签');
INSERT INTO `t_ip_interservice` VALUES ('7', '1004', 'query_users', '1', '批量用户信息查询', '根据地址批量查询客户信息（地址类型 地址编码）, 增加标签');
INSERT INTO `t_ip_interservice` VALUES ('8', 'user', null, '0', '用户信息同步', '定时同步用户信息');
INSERT INTO `t_ip_interservice` VALUES ('9', '1005', 'query_usermeter', '1', '用户表具查询', '根据户号查询气表信息');
INSERT INTO `t_ip_interservice` VALUES ('10', '1006', 'query_icinfo', '1', 'IC卡信息查询', '根据户号表号查询IC卡信息');
INSERT INTO `t_ip_interservice` VALUES ('11', 'meter', null, '0', '表具信息同步', '定时同步用户表具信息');
INSERT INTO `t_ip_interservice` VALUES ('12', '1007', 'query_userprice', '1', '查询用户气价信息', '根据编码查询气价明细');
INSERT INTO `t_ip_interservice` VALUES ('13', '1008', 'query_useamount', '1', '查询当期购气量', '根据户号查询累计购气量');
INSERT INTO `t_ip_interservice` VALUES ('14', '1009', 'query_userpresavingc', '1', '查询用户预存', '查询账户余额');
INSERT INTO `t_ip_interservice` VALUES ('15', '1010', 'query_bills', '1', '查询历史账单信息', '机械表历史账单查询，根据户号、账期查询历史账单，');
INSERT INTO `t_ip_interservice` VALUES ('16', '1011', 'query_arrearage', '1', '气费欠费账单查询', '根据户号，查询欠费账单');
INSERT INTO `t_ip_interservice` VALUES ('17', '1012', 'query_icpayrec', '1', 'IC卡充值历史 查询', '查询IC卡充值历史');
INSERT INTO `t_ip_interservice` VALUES ('18', '1013', 'query_payrec', '1', '缴费历史查询', '机械表营业费缴费历史');
INSERT INTO `t_ip_interservice` VALUES ('19', '1014', 'query_icvalidate', '1', 'IC卡充值前校验', 'IC卡充值前校验增加错误码');
INSERT INTO `t_ip_interservice` VALUES ('20', '2001', 'fee_icrecharge', '2', 'IC卡充值', 'IC卡充值，增加重试');
INSERT INTO `t_ip_interservice` VALUES ('21', '2002', 'fee_pay', '2', '交费', '违约金、气费、营业费、气费预充值');
INSERT INTO `t_ip_interservice` VALUES ('22', '1015', 'query_recorddata', '1', '抄表历史查询', '批量抄表历史，');
INSERT INTO `t_ip_interservice` VALUES ('23', '1016', 'query_validaterecordcycle', '1', '验证用户是否在抄表周期内', '验证用户是否在抄表周期内');
INSERT INTO `t_ip_interservice` VALUES ('24', '1017', 'query_lastreading', '1', '自报上期止码查询', '获取用户上期止码');
INSERT INTO `t_ip_interservice` VALUES ('25', '2003', 'busi_diytryfee', '2', '自报读数试算', '自报试算');
INSERT INTO `t_ip_interservice` VALUES ('26', '2004', 'busi_diyreading', '2', '自报读数', '自报读数');
INSERT INTO `t_ip_interservice` VALUES ('27', '1018', 'fee_checkreq', '1', '对账请求主', '对账文件生成通知接口');
INSERT INTO `t_ip_interservice` VALUES ('29', '1025', 'query_vccpayrec', '1', 'VCC缴费记录查询', '查询指定流水号的VCC缴费记录');
INSERT INTO `t_ip_interservice` VALUES ('30', '3002', 'busi_apply', '3', '诉求工单发起', '诉求工单发起');
INSERT INTO `t_ip_interservice` VALUES ('31', '3007', 'busi_busiapply', '3', '业务工单发起', '发起业务工单');
INSERT INTO `t_ip_interservice` VALUES ('32', '3006', 'busi_backwrite', '3', '业务记录回写', '基本信息，包含业务类型，操作时间等');
INSERT INTO `t_ip_interservice` VALUES ('33', '1019', 'busi_onwayorder', '1', '在途工单查询', '在途工单查询');
INSERT INTO `t_ip_interservice` VALUES ('34', '3003', 'busi_cancelorder', '3', '诉求工单取消', '取消诉求工单');
INSERT INTO `t_ip_interservice` VALUES ('35', '1020', 'query_orders', '1', '工单信息查询', '工单信息查询');
INSERT INTO `t_ip_interservice` VALUES ('36', '1021', 'query_inhouseappliance', '1', '内购燃气具信息查询', '查询用户内购燃气具信息');
INSERT INTO `t_ip_interservice` VALUES ('37', '1022', 'query_outhouseappliance', '1', '外购燃气具信息查询', '查询用户外购燃气具信息');
INSERT INTO `t_ip_interservice` VALUES ('38', '3004', 'busi_inhouseinstall', '3', '内购燃气具安装', '内购安装');
INSERT INTO `t_ip_interservice` VALUES ('39', '3005', 'busi_inhouserepair', '3', '内购燃气具维修', '内购维修');
INSERT INTO `t_ip_interservice` VALUES ('40', '1023', 'query_security', '1', '安检情况查询', '查询最近一次的安检结果');
INSERT INTO `t_ip_interservice` VALUES ('41', '1024', 'query_hidden', '1', '隐患情况查询', '查询隐患详情');
INSERT INTO `t_ip_interservice` VALUES ('42', '4001', 'event_reg', '4', '事件注册', '事件推送注册');
INSERT INTO `t_ip_interservice` VALUES ('43', '4002', 'event_cancel', '4', '事件取消', '事件推送事件取消');
INSERT INTO `t_ip_interservice` VALUES ('44', '4003', null, '4', '新账单提醒', '新账单提醒');
INSERT INTO `t_ip_interservice` VALUES ('45', '4004', null, '4', '账单逾期提醒', '账单逾期提醒');
INSERT INTO `t_ip_interservice` VALUES ('46', '4005', null, '4', '工单状态变化通知', '工单状态变化通知');
INSERT INTO `t_ip_interservice` VALUES ('47', '4006', null, '4', '银行代扣状态通知', '银行代扣状态通知');
INSERT INTO `t_ip_interservice` VALUES ('3', '1001', 'query_dict', '1', '数据字典查询', '根据字典类型查询字典值');
INSERT INTO `t_ip_interservice` VALUES ('48', '1026', 'query_stationusers', '1', '站箱用户查询', null);
INSERT INTO `t_ip_interservice` VALUES ('49', '1006', 'query_icinfoNoResid', '1', 'IC卡信息查询', null);
INSERT INTO `t_ip_interservice` VALUES ('50', '1101', 'ib', '1', '工商户最后一笔购气记录及购总', '');
INSERT INTO `t_ip_interservice` VALUES ('51', '2006', 'busi_transferstate', '2', '圈存状态回写', '');
INSERT INTO `t_ip_interservice` VALUES ('51', '4007', '', '4', '银行代扣回盘信息推送', '');
INSERT INTO `t_ip_interservice` VALUES ('51', '4008', '', '4', '燃气具销售订单推送', '');
INSERT INTO `t_ip_interservice` VALUES ('55', '3010', 'busi_cancelbusiorder', '3', '业务工单取消', '实时取消还未开始的业务工单');
INSERT INTO `t_ip_interservice` VALUES ('49', '3009', 'busi_openaccent', '3', '开户', null);
INSERT INTO `t_ip_interservice` VALUES ('56', '5001', 'busi_delmeter', '3', '表处理', '表处理');
INSERT INTO `t_ip_interservice` VALUES ('57', '5002', 'busi_openfire', '3', '点火', '点火');
INSERT INTO `t_ip_interservice` VALUES ('58', '5003', 'busi_fixmeter', '3', '挂表', '挂表');
INSERT INTO `t_ip_interservice` VALUES ('59', '5004', 'busi_fixmeterandopenfire', '3', '点火挂表', '点火挂表');
INSERT INTO `t_ip_interservice` VALUES ('60', '5005', 'busi_gasresinstall', '3', '燃气具安装', '燃气具安装');
INSERT INTO `t_ip_interservice` VALUES ('61', '5006', 'busi_gasresrepair', '3', '燃气具维修', '燃气具维修');
INSERT INTO `t_ip_interservice` VALUES ('62', '5007', 'busi_icrepair', '3', 'IC卡无工单维修', 'IC卡无工单维修');
INSERT INTO `t_ip_interservice` VALUES ('63', '1027', 'query_firefail', '1', '点火失败配置信息查询', '点火失败配置信息查询');
INSERT INTO `t_ip_interservice` VALUES ('64', '1028', 'query_factory', '1', '厂商信息查询', '厂商信息查询');
INSERT INTO `t_ip_interservice` VALUES ('65', '1029', 'query_material', '1', '材料信息查询', '材料信息查询');
INSERT INTO `t_ip_interservice` VALUES ('66', '1030', 'query_operator', '1', '员工信息查询', '员工信息查询');
INSERT INTO `t_ip_interservice` VALUES ('67', '2007', 'busi_makebusifee', '2', '营业费制定', '营业费制定');
INSERT INTO `t_ip_interservice` VALUES ('68', '1031', 'query_busirec', '1', '客户业务记录查询', '客户业务记录查询');
INSERT INTO `t_ip_interservice` VALUES ('69', '1032', 'query_detailorder', '1', '工单详情查询', '工单详情查询');
INSERT INTO `t_ip_interservice` VALUES ('70', '3011', 'busi_changresid', '3', '修改表具编号', '修改表具编号');


insert into tcip.t_ip_app values ('MTL','马蹄莲接口测试');
insert into tcip.t_ip_accesstoken values('131','MTL','TA01','1','2099-08-31','GEE','MTL',null,'http://127.0.0.1:8080/default/TcisApiWebServiceService?wsdl','0',SYSDATE(), null,sysdate(),null);
insert into tcip.t_ip_accesstoken values('132','MTL','SU','10912','2099-08-31','GEE','MTL',null,'http://127.0.0.1:8080/default/TcisApiWebServiceService?wsdl','0',SYSDATE(), null,sysdate(),null);
insert into tcip.t_ip_interservice values ('76','2008','busi_withHold','2','生成银行批扣文件','生成银行批扣文件');
insert into tcip.t_ip_interservice values ('77','2009','read_backfile','2','解析银行回盘文件','解析银行回盘文件');
insert into tcip.t_ip_appinterface values ('MTL', '76');
insert into tcip.t_ip_appinterface values ('MTL', '77');

DROP TABLE IF EXISTS `t_ip_schedule`;
CREATE TABLE `t_ip_schedule` (                                                                    
                 `id` varchar(20) NOT NULL COMMENT 'ID',                                                         
                 `name` varchar(200) DEFAULT NULL COMMENT '任务名',                                           
                 `export_cron` varchar(50) DEFAULT NULL COMMENT 'cron表达式',                                 
                 `start_time` time DEFAULT NULL COMMENT '开始时间',                                          
                 `run_time` time DEFAULT NULL COMMENT '运行时间',                                            
                 `status` varchar(1) NOT NULL COMMENT '状态（0：未运行 1：运行中 2:运行完成）',  
                 `params` varchar(255) DEFAULT NULL COMMENT '查询参数',                                      
                 `type` varchar(1) DEFAULT NULL COMMENT '调用类型（0：手动 1：周期）',               
                 `search_type` varchar(200) DEFAULT NULL COMMENT '检索类型',
                 `file_url` varchar(200) DEFAULT NULL COMMENT '文件地址',
                 `create_userId` varchar(200) DEFAULT NULL COMMENT '创建人id',                                
                 `group_type` varchar(1) DEFAULT NULL COMMENT '分组类型',                                    
                 `dataorgid` varchar(150) DEFAULT NULL COMMENT '机构ID',                                       
                 `bank_code` varchar(150) DEFAULT NULL COMMENT '银行代码',                                   
                 `repeat_count` varchar(3) DEFAULT '0' COMMENT '运行次数',                                   
                 `org_code` varchar(20) DEFAULT NULL COMMENT '分公司code',                                    
                 PRIMARY KEY (`id`)                                                                              
               ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tcip.t_ip_schedule values('1','工商银行批扣定时任务', '0 0/2 * * * ?',null, null, '0',null,'1','2008',null,'1','1','10912','GS','0','SU');
insert into tcip.t_ip_schedule values('2','工商银行回盘定时任务', '0 0/5 * * * ?',null, null, '0',null,'1','2009',null,'1','1','10912','GS','0','SU');
insert into tcip.t_ip_schedule values('3','中国银行回盘定时任务', '0 0/2 * * * ?',null, null, '0',null,'1','2008',null,'1','1','1','ZG','0','TA01');
insert into tcip.t_ip_schedule values('4','中国银行回盘定时任务', '0 0/5 * * * ?',null, null, '0',null,'1','2009',null,'1','1','1','ZG','0','TA01');

DROP TABLE IF EXISTS `t_ip_appschedule`;
CREATE TABLE `t_ip_appschedule` (                              
                    `id` varchar(20) NOT NULL COMMENT 'id',                      
                    `schedule_id` varchar(20) DEFAULT NULL COMMENT '任务ID',   
                    `app_id` varchar(20) DEFAULT NULL COMMENT '服务ID',        
                    `interface_id` varchar(20) DEFAULT NULL COMMENT '应用ID',  
                    `create_date` time DEFAULT NULL COMMENT '创建时间',      
                    PRIMARY KEY (`id`)                                           
                  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tcip.t_ip_appschedule values ('1','1','MTL','77',sysdate());
insert into tcip.t_ip_appschedule values ('1','2','MTL','76',sysdate());
   
DROP TABLE IF EXISTS `t_ip_bankschedule`;
CREATE TABLE `t_ip_bankschedule` (                                            
                     `id` varchar(33) NOT NULL,                                                  
                     `schedule_id` varchar(20) DEFAULT NULL COMMENT '任务id',                                     
                     `file_name_input` varchar(200) DEFAULT NULL COMMENT '传盘文件名',                                
                     `file_name_back` varchar(200) DEFAULT NULL COMMENT '回盘文件名',                                 
                     `file_size` varchar(200) DEFAULT NULL COMMENT '文件大小',                                      
                     `create_date` time DEFAULT NULL COMMENT '传盘时间',                                            
                     `back_date` time DEFAULT NULL COMMENT '回盘时间',                                              
                     `flow_no` varchar(200) DEFAULT NULL COMMENT '流水号',                                        
                     `status` varchar(1) DEFAULT '0' COMMENT '状态(0:未回盘,1:已回盘)',  
                     PRIMARY KEY (`id`)                                                          
                   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;



