SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for history
-- ----------------------------
use graduationProject;
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `hid` varchar(255) NOT NULL COMMENT 'id',
  `huid` varchar(255) NOT NULL COMMENT 'id',
  `hoid` int(11) NOT NULL COMMENT 'id',
  `fraction` int(8) default null COMMENT '分数',
  `type` varchar(255) NOT NULL,
  `filepath` varchar(255) NOT NULL,
  `uptime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `filesize` double NOT NULL,
  PRIMARY KEY (`hid`),
  KEY `FK_hoid_oid` (`hoid`) USING BTREE,
  KEY `FK_huid_uid` (`huid`) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`hoid`) REFERENCES `orderinfo` (`oid`),
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`huid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
作业批次实体
*/
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `oid` int(11)  NOT NULL AUTO_INCREMENT COMMENT'id',
  `uid` varchar(255) default NULL COMMENT '老师id',
  `oname` varchar(255) NOT NULL COMMENT'作业名',
  `osubject` varchar(255) NOT NULL COMMENT'科目名',
  `ostate` bit(1) NOT NULL COMMENT'是否允许上传',
  `describtion` varchar(1000) default NULL COMMENT'布置作业内容',
  `answer` varchar(64) default NULL COMMENT'作业的答案',
  `otime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT'修改时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8;


INSERT INTO `orderinfo` VALUES ('1492109980', '1','第一次作业', '数据结构与算法', 1,'对于给定的数组[8,3,9,4,19],利用冒泡排序来进行排序，然后返回其结果。' ,'[3,4,8,9,19]','2019-03-28 14:48:53');
INSERT INTO `orderinfo` VALUES ('795960272', '1','第二次作业', '数据结构与算法', 1, '对于给定的数组[8,3,9,4,19],利用快速排序来进行排序，然后返回其结果。','[3,4,8,9,19]','2019-03-28 14:38:11');


/*
作业相关的提问和回答
*/
DROP TABLE IF EXISTS `order_questions_reply`;
CREATE TABLE `order_questions_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT'id',
  `history_id` varchar(255) NOT NULL COMMENT '作业实体id应该是hid',
  `identity_mark` int(1) DEFAULT null COMMENT '标记是学生提问还是 老师答复 0->学生提问 1->老师回答',
  `status_questions` varchar(1000) DEFAULT NULL COMMENT'作业问题',
  `teacher_reply`varchar(1000) DEFAULT NULL COMMENT'作业答复',
  `quest_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT'回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8;

INSERT INTO `order_questions_reply` VALUES ('1000', '8a23718b675c4f36801f0b9512f5b3cd','0', '对于冒泡排序算法，有没有算法复杂度为O的实现方式','冒泡排序根据其特殊的机理，需要双次的循环所以算法复杂度为O平方', '2019-03-28 14:38:11');
INSERT INTO `order_questions_reply` VALUES ('1001', '795960272','1', '对于快速排序算法的一些小的问题','快速排序算法根据其特殊的机理，需要双次的循环所以算法复杂度为O平方', '2019-03-29 18:38:11');

-- ----------------------------
-- Records of orderinfo
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `headimg` varchar(255) DEFAULT NULL,
  `firstlogin` bit(1) NOT NULL DEFAULT b'1',
  `name` varchar(255) NOT NULL,
  `percode` varchar(255) NOT NULL,
  `userOpenID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '200002021421', '123456789', null, 1, '孙老师', 'admin', null);
INSERT INTO `user` VALUES ('2', '201402021423', '123456789', null, 0, '小李', 'user', null);
INSERT INTO `user` VALUES ('3', '201402021421', '123456789', null, 0, '小红', 'user', null);
INSERT INTO `user` VALUES ('4', '201402021420', '123456789', null, 0, '天天', 'user', null);
INSERT INTO `user` VALUES ('5', '200002021422', '123456789', null, 0, '李老师', 'admin', null);
INSERT INTO `user` VALUES ('8', '201402021424', '123456789', null, 1, '小李', 'user', null);


/*
管理员布置作业内容
*/
DROP TABLE IF EXISTS `subject_content`;
CREATE TABLE `subject_content` (  
  `sid` varchar(255) NOT NULL COMMENT'作业id',
  `uid` varchar(64) NOT NULL COMMENT'老师id',
  `oid` int(11) NOT NULL COMMENT'作业信息对应id',
  `describtion` varchar(64) NOT NULL COMMENT'布置作业内容',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



