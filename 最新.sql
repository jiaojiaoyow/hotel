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
	orderid int auto_increment,  #订单号，自增
	
	uid varchar(20),		#用户id
	roomnumber int(4),		#订房数量
	ordertime  datetime,	#入住时间
	orderday     int(4), 		#入住天数
	primary key(orderid,uid),
	foreign key (uid) references user (uid)
);

create table essay(		#文章
	uid char(55),
	aname varchar(50),
	

)