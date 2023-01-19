/*



 Source Server Type    : MySQL
 Source Server Version :  8.0.31
 Source Host           : localhost:3306

 Date: 2023/1/19
*/

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE DATABASE IF NOT EXISTS douyin;
USE douyin;
DROP TABLE IF EXISTS `fans`;
DROP TABLE IF EXISTS `my_liked_vlog`;
DROP TABLE IF EXISTS `vlog`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `email` varchar(32) NOT NULL COMMENT 'email',
  `phone` char(20) NOT NULL COMMENT '手机号码',
  `follow_count` bigint NOT NULL COMMENT '关注总数',
  `follower_count` bigint NOT NULL COMMENT '粉丝总数',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`),
  UNIQUE KEY `email`  USING BTREE (`email`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
 -- PRIMARY KEY (`id`)USING BTREE
   -- 注意这里索引增加的格式 括号必须后置
 -- UNIQUE KEY `phone` (`phone`) USING BTREE,
-- 可能还有
-- ----------------------------
-- Records of user
-- ----------------------------

-- 不懂以下的
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` bigint AUTO_INCREMENT  NOT NULL,
  `uid` bigint NOT NULL COMMENT '对应用户表id，视频发布者',
  `play_url` varchar(255) NOT NULL COMMENT '视频播放地址',
  `cover_url` varchar(255) NOT NULL COMMENT '视频封面地址',
  `title` varchar(128) DEFAULT NULL COMMENT '视频标题，可以为空',
  `comments_count` bigint NOT NULL COMMENT '评论总数',
  `favorite_count` bigint NOT NULL COMMENT '点赞总数',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='短视频表';

-- ----------------------------
-- Records of video
-- ----------------------------
-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `uid` bigint NOT NULL COMMENT '发布留言的用户id',
  `vid` bigint NOT NULL COMMENT '评论的视频作者id',
  `content` varchar(128) NOT NULL COMMENT '留言内容',
  `create_time` datetime NOT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------


-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` bigint   AUTO_INCREMENT NOT NULL,
  `from_id` bigint NOT NULL COMMENT '发起关注的用户id',
  `to_id` bigint NOT NULL COMMENT '被关注的用户id',
  `is_friend` tinyint NOT NULL COMMENT '互关为1，否则为0',
   `create_time` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id`  USING BTREE (`from_id`,`to_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='粉丝表\n\n';

-- ----------------------------
-- Records of fans
-- ----------------------------


-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` bigint   AUTO_INCREMENT NOT NULL,
  `uid` bigint NOT NULL COMMENT '用户id',
  `vid` bigint NOT NULL COMMENT '喜欢的短视频id',
   `create_time` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `writer_id` USING BTREE (`uid`,`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点赞短视频关联表\n';

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint   AUTO_INCREMENT NOT NULL,
  `uid` bigint NOT NULL COMMENT '发送者 id',
  `vid` bigint NOT NULL COMMENT '接受者 id',
  `is_friend` tinyint NOT NULL COMMENT '互关为1，否则为0',
  `content` varchar(128) NOT NULL COMMENT '留言内容',
    `create_time` datetime NOT NULL COMMENT '关注时间',
    `message_status` tinyint COMMENT '0-未读，1-已读，2-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id` USING BTREE (`uid`,`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点赞短视频关联表\n';

-- ----------------------------
-- Records of message
-- ----------------------------



SET FOREIGN_KEY_CHECKS = 1;
