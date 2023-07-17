/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2023-06-02 09:56:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '今日头条');
INSERT INTO `t_category` VALUES ('2', '综合资讯');
INSERT INTO `t_category` VALUES ('3', '国内新闻');
INSERT INTO `t_category` VALUES ('4', '国际新闻');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL,
  `contentTitle` varchar(120) DEFAULT NULL,
  `titlePicUrl` varchar(120) DEFAULT NULL,
  `content` text,
  `contentAbstract` varchar(300) DEFAULT NULL,
  `keywords` varchar(100) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `publishStatus` char(1) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsId`),
  KEY `categoryId` (`categoryId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_news_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `t_category` (`categoryId`),
  CONSTRAINT `t_news_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '做好疫情加试题 确保脱贫高质量', '做好疫情加试题 确保脱贫高质量', null, '做好疫情加试题 确保脱贫高质量', '', '', '', '2022-05-20 13:44:39', null, '1', '1', null);
INSERT INTO `t_news` VALUES ('2', '扩大内需必须加快推进复工复产', '扩大内需必须加快推进复工复产', null, '扩大内需必须加快推进复工复产', '', '', '', '2023-03-17 13:45:56', null, '1', '2', null);
INSERT INTO `t_news` VALUES ('3', '做好疫情加试题 确保脱贫高质量', '做好疫情加试题 确保脱贫高质量', null, '新冠肺炎疫情是决战决胜脱贫攻坚的加试题，也是影响脱贫质量的最大不确定因素。要按照党中央的决策部署，坚持在常态化疫情防控中加快推进生产生活秩序全面恢复，积极推动贫困劳动力尽快就业务工，大力开展消费扶贫行动，切实解决制约扶贫项目开工建设的突出问题，织牢织密综合兜底保障网，坚决把疫情耽误的进度抢回来，力争把疫情的不利影响降到最低。脱贫工作越到最后时刻，越要狠抓工作作风转变，坚决克服形式主义、官僚主义，坚决纠正挂牌督战中只督不战、督强战弱、重督轻扶等问题，把提出问题与解决问题结合起来，上级下级捆到一起干，确保各项工作见真章、出实效。\r\n\r\n　　中共中央政治局委员、国务院副总理、国务院扶贫开发领导小组组长胡春华出席会议并讲话。他指出，要深入贯彻习近平总书记关于扶贫工作的重要论述，进一步提高思想认识和政治站位，全面落实县委书记一线总指挥责任，狠抓脱贫攻坚政策、工作落实。要坚持从严从实、督战一体，较真碰硬彻底整改发现问题。要加快推进脱贫攻坚各项工作，坚决防止松劲懈怠贻误战机，不折不扣完成好目标任务，确保如期打赢脱贫攻坚战。\r\n\r\n　　本次约谈以电视电话会议方式召开。中西部11个省区24位县委书记参加约谈，4位县委书记作代表性发言。\r\n\r\n', '中共中央政治局常委、全国政协主席汪洋4月13日在京主持召开脱贫攻坚约谈会议并讲话。他强调，县一级在我们党的组织结构中处于承上启下的关键环节，县委书记是脱贫攻坚的“一线指挥官”。党中央决定直接约谈部分脱贫攻坚任务重和考核发现问题较多县的县委书记，充分体现了对县级脱贫工作的格外重视，对决战决胜脱贫攻坚具有重要意义。约谈既是督战和加压，也是信任和加油。', '新冠肺炎，疫情', '人民日报', '2023-05-10 13:51:31', null, '1', '1', null);
INSERT INTO `t_news` VALUES ('4', '学校的放假', '学校的放假通知', null, '今天6月2号开始放假', '', '', '', '2023-06-02 08:36:42', null, '1', '1', null);
INSERT INTO `t_news` VALUES ('5', '明天上课', '上课', null, '明天要上课', '', '', '', '2023-06-02 09:01:16', null, '1', '1', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员');
INSERT INTO `t_role` VALUES ('2', '信息员');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '无为', 'admin', '123456', null, '2020-04-13 13:44:13', '2', '1');
INSERT INTO `t_user` VALUES ('2', 'user', 'user', '123456', '', '2020-04-13 13:44:34', '2', '2');
INSERT INTO `t_user` VALUES ('3', 'zhang', 'zhang', '123456', '', '2023-06-02 08:32:58', '2', '2');
INSERT INTO `t_user` VALUES ('4', 'lishi', 'lishi', '123456', '', '2023-06-02 08:33:58', '2', '2');
INSERT INTO `t_user` VALUES ('5', '刘三', '刘', '123456', '', '2023-06-02 09:03:57', '2', '2');
