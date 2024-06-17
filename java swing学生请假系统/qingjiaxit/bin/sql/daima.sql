
//学生登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE userlist
(
   name      VARCHAR(50) not null,
   pwd    VARCHAR(30) not null,
   zhuanye       VARCHAR(20),
   
   PRIMARY KEY (name)
) DEFAULT CHARSET=utf8;

//辅导员登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE cuserlist
(
   name      VARCHAR(50) not null,
   pwd    VARCHAR(30) not null,
   zhuanye       VARCHAR(20),
   
   PRIMARY KEY (name)
) DEFAULT CHARSET=utf8;



//院长登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE yuserlist
(
   name      VARCHAR(50) not null,
   pwd    VARCHAR(30) not null,
   zhuanye       VARCHAR(20),
   
   PRIMARY KEY (name)
) DEFAULT CHARSET=utf8;


//辅导员登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE cuserlist
(
   name      VARCHAR(50) not null,
   pwd    VARCHAR(30) not null,
   zhuanye       VARCHAR(20),
   
   PRIMARY KEY (name)
) DEFAULT CHARSET=utf8;

//老师登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE tuserlist
(
   name      VARCHAR(50) not null,
   pwd    VARCHAR(30) not null,
  
   
   PRIMARY KEY (name)
) DEFAULT CHARSET=utf8;

//管理员登陆表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE guserlist
(
   id        BIGINT  not null,
   name      VARCHAR(50) not null,
   stuNum    VARCHAR(30) not null,
   pwd       VARCHAR(20),
   
   PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;
insert into guserlist values (10001, 'guser1', '10001', '10001');
insert into guserlist values (10002, 'guser2', '10002', '10002');
insert into guserlist values (10003, 'guser3', '10003', '10003');





//学生请假表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE user2
(
   a       VARCHAR(80)  not null,
   b     VARCHAR(50) not null,
  c  VARCHAR(80) not null,
    d      VARCHAR(20)not null,
   e      VARCHAR(70) not null,
   f      VARCHAR(60) not null,
   g     VARCHAR(50) not null,
  h     VARCHAR(50) not null,
   PRIMARY KEY (a)
) DEFAULT CHARSET=utf8;

//辅导员审核表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE user3
(
   a       VARCHAR(80)  not null,
   b     VARCHAR(50) not null,
  c  VARCHAR(80) not null,
    d      VARCHAR(20)not null,
   e      VARCHAR(70) not null,
   f      VARCHAR(60) not null,
   g     VARCHAR(50) not null,
  h     VARCHAR(50) not null,
  i    VARCHAR(50) not null,
   PRIMARY KEY (a)
) DEFAULT CHARSET=utf8;


//院长审核表
create database if not exists guanliyuan;
use guanliyuan;
CREATE TABLE user4
(
   a       VARCHAR(80)  not null,
   b     VARCHAR(50) not null,
  c  VARCHAR(80) not null,
    d      VARCHAR(20)not null,
   e      VARCHAR(70) not null,
   f      VARCHAR(60) not null,
   g     VARCHAR(50) not null,
  h     VARCHAR(50) not null,
   PRIMARY KEY (a)
) DEFAULT CHARSET=utf8;



