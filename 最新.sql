 create database newhoteldb;
 use newhoteldb;
 
 create table Room(	
		roomname varchar(50) primary key,	
		roomintroduce varchar(150),		
		roomnumber varchar(5), 	
		roomprice double
 );

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
 create table roomorder(		#订单
	orderid int auto_increment,  #订单号
	uid char(55),		#用户id
	roomnumber int(4),		#订房数量
	ordertime  datetime,	#入住时间
	orderday     int(4), 		#入住天数
	primary key(orderid,uid),
	foreign key (uid) references user (uid)
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

