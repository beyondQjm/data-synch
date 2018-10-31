/*
Navicat MySQL Data Transfer

Source Server         : mini132
Source Server Version : 50717
Source Host           : 192.168.135.132:3306
Source Database       : grg_hr

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-31 16:59:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hr_education_experience
-- ----------------------------
DROP TABLE IF EXISTS `hr_education_experience`;
CREATE TABLE `hr_education_experience` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(24) DEFAULT NULL COMMENT '关联员工',
  `graduate_from` varchar(100) DEFAULT NULL COMMENT '毕业院校',
  `graduate_from_other` varchar(100) DEFAULT NULL COMMENT '毕业院校选择其他时 其他院校',
  `education` int(11) DEFAULT NULL COMMENT '学历	 1 高中及以下 2 大专  3 本科 4 研究生 ',
  `degree` int(11) DEFAULT NULL COMMENT '学位  1 无 2 学士 3 硕士 4 博士',
  `edu_major` varchar(100) DEFAULT NULL COMMENT '专业',
  `startdt` date DEFAULT NULL COMMENT '开始时间',
  `enddt` date DEFAULT NULL COMMENT '结束时间',
  `table_date` datetime DEFAULT NULL COMMENT '修改和删除，都是重新添加一条记录',
  `table_status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 可用 2 修改',
  `extend_field_1` varchar(24) DEFAULT NULL COMMENT '扩展字段1',
  `extend_field_2` varchar(24) DEFAULT NULL COMMENT '扩展字段2',
  `extend_field_3` int(11) DEFAULT NULL COMMENT '扩展字段3',
  `extend_field_4` int(11) DEFAULT NULL COMMENT '扩展字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16595 DEFAULT CHARSET=utf8 COMMENT='教育经历表';

-- ----------------------------
-- Records of hr_education_experience
-- ----------------------------
INSERT INTO `hr_education_experience` VALUES ('16496', '748451234561', '华南理工大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:00', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16497', '748451234562', '华南理工大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16498', '748451234563', '华南理工大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16499', '748451234564', '华南理工大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16500', '748451234565', '华南理工大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16501', '748451234566', '华南理工大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16502', '748451234567', '华南理工大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16503', '748451234568', '华南理工大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16504', '748451234569', '华南理工大学', null, '2', '2', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16505', '7484512345610', '华南理工大学', null, '2', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16506', '7484512345611', '华南理工大学', null, '1', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16507', '7484512345612', '华南理工大学', null, '3', '3', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16508', '7484512345613', '华南理工大学', null, '2', '2', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16509', '7484512345614', '华南理工大学', null, '3', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16510', '7484512345615', '华南理工大学', null, '1', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16511', '7484512345616', '中山大学', null, '1', '2', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16512', '7484512345617', '中山大学', null, '1', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16513', '7484512345618', '中山大学', null, '3', '1', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16514', '7484512345619', '中山大学', null, '2', '3', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16515', '7484512345620', '中山大学', null, '1', '2', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16516', '7484512345621', '中山大学', null, '2', '3', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16517', '7484512345622', '中山大学', null, '3', '3', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16518', '7484512345623', '中山大学', null, '3', '3', '会计学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16519', '7484512345624', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:01', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16520', '7484512345625', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16521', '7484512345626', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16522', '7484512345627', '中山大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16523', '7484512345628', '中山大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16524', '7484512345629', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16525', '7484512345630', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16526', '7484512345631', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16527', '7484512345632', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16528', '7484512345633', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16529', '7484512345634', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16530', '7484512345635', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16531', '7484512345636', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16532', '7484512345637', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16533', '7484512345638', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16534', '7484512345639', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16535', '7484512345640', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16536', '7484512345641', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16537', '7484512345642', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16538', '7484512345643', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16539', '7484512345644', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16540', '7484512345645', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16541', '7484512345646', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16542', '7484512345647', '中山大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16543', '7484512345648', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16544', '7484512345649', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:02', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16545', '7484512345650', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16546', '7484512345651', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16547', '7484512345652', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16548', '7484512345653', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16549', '7484512345654', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16550', '7484512345655', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16551', '7484512345656', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16552', '7484512345657', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16553', '7484512345658', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16554', '7484512345659', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16555', '7484512345660', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16556', '7484512345661', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16557', '7484512345662', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16558', '7484512345663', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16559', '7484512345664', '中山大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16560', '7484512345665', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16561', '7484512345666', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16562', '7484512345667', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16563', '7484512345668', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16564', '7484512345669', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16565', '7484512345670', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16566', '7484512345671', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16567', '7484512345672', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16568', '7484512345673', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16569', '7484512345674', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16570', '7484512345675', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16571', '7484512345676', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16572', '7484512345677', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16573', '7484512345678', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:03', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16574', '7484512345679', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16575', '7484512345680', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16576', '7484512345681', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16577', '7484512345682', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16578', '7484512345683', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16579', '7484512345684', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16580', '7484512345685', '中山大学', null, '3', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16581', '7484512345686', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16582', '7484512345687', '中山大学', null, '2', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16583', '7484512345688', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16584', '7484512345689', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16585', '7484512345690', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16586', '7484512345691', '中山大学', null, '1', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16587', '7484512345692', '中山大学', null, '3', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16588', '7484512345693', '中山大学', null, '1', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16589', '7484512345694', '中山大学', null, '1', '3', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16590', '7484512345695', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16591', '7484512345696', '中山大学', null, '2', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16592', '7484512345697', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16593', '7484512345698', '中山大学', null, '3', '1', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
INSERT INTO `hr_education_experience` VALUES ('16594', '7484512345699', '中山大学', null, '2', '2', '计算机科学', '2011-09-01', '2014-07-01', '2018-09-22 19:05:04', '1', null, null, null, null);
