 create database newhoteldb;
 use newhoteldb;

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomname` varchar(50) NOT NULL,
  `roomintroduce` varchar(150) DEFAULT NULL,
  `roomnumber` int(4) DEFAULT NULL,
  `roomprice` double(16,4) DEFAULT NULL,
  PRIMARY KEY (`roomname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Structure for table "roomorder"
#

DROP TABLE IF EXISTS `roomorder`;
CREATE TABLE `roomorder` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `roomname` varchar(50) NOT NULL,
  `uid` char(55) NOT NULL DEFAULT '',
  `uname` varchar(20) DEFAULT NULL,
  `uphone` varchar(20) DEFAULT NULL,
  `roomnumber` int(4) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `leavetime` datetime DEFAULT NULL,
  `orderday` int(4) DEFAULT NULL,
  `totalprice` double(16,4) DEFAULT NULL,
  `orderstatus` int(4) DEFAULT '1',
  `cid` int(11) DEFAULT NULL,
  `arrivetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`orderid`,`uid`,`roomname`),
  KEY `uid` (`uid`),
  KEY `roomname` (`roomname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 

 create table user(		#用户
	uid char(55) NOT NULL primary key,  #接收openid
	ubalance double, #余额
	ugrade int 	#积分
	`token` char(36) NOT NULL unique,
	nickName varchar(50),
	avatarUrl varchar(150),  #头像地址
	gender tinyint(4) DEFAULT NULL,#性别
	gmt_create bigint(20) DEFAULT NULL,
 	gmt_modified bigint(20) DEFAULT NULL,
 	status tinyint(4) DEFAULT 1
);


<<<<<<< HEAD
create table essay( #文章
  aid int primary key ,
  uid char(55),
  tiile varchar(200),
  content text, #内容
  create_time date ,#生成时间
  image Blob  #图片url
)

CREATE TABLE Coupon ( #优惠卷
  `cid` int primary key ,
  `cname` varchar(60) NOT NULL ,
  `min_amount` double ,#满减到达金额
  `amount` double ,#抵扣金额
  #优惠卷的有效期的开始和结束日期
  `send_start_date`  VARCHAR(50) ,
  `send_end_date`VARCHAR(50)
  #是否过期标识
)

create table getCoupon(  #领卷
  uid char(55),
  cid int,  #优惠卷id
  status tinyint(4) DEFAULT 0 ,#零代表卷还未使用
	#用户使用有效期
  `use_start_date` VARCHAR(50) ,
  `use_end_date` VARCHAR(50) ,
	PRIMARY KEY(uid,cid)
)

