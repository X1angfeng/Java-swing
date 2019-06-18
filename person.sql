--创建本实验所要用的数据库--
create database java
on primary
(name=java_data,
filename='D:\java\java_data,mdf',
size=20MB,
maxsize=unlimited
),
(name=java_data1,
filename='D:\java\java_data1.ndf',
size=20MB,
maxsize=unlimited
)
log on
(name=java_log,
filename='D:\java\java_log.ldf',
size=20MB,
maxsize=50MB,
filegrowth=2
)
select  *from usedata
alter table usedata drop xm


--使用java数据库，继续进行后续建表操作--
use java

--创建管理员表--
create table admindata
(
aID char(10) not null  primary key,
aPWD varchar(20) not null 
)
--创建保存用户账号密码的userdata表--
create table usedata
(
ID char(10) not null  primary key,
PWD varchar(20) not null unique
)
--创建日记表diary--
create table diary
(
dtime datetime  not null primary key,
weather char(8) not null,
devent text not null,
ID char(10),
foreign key(ID) references usedata(ID)
)
--创建备忘录表memo--
create table memo
(
mtime datetime  not null primary key,
mlocation char(8) not null,
mevent text not null,
ID char(10),
foreign key(ID) references usedata(ID)
)
--创建通讯信息表communication--
create table communication
(
telephone char(20) check( telephone like '[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') not null primary key,
cname char(8) not null,
city char(8) not null,
place varchar(30) not null,
remarks text not null,
ID char(10),
foreign key(ID) references usedata(ID)
)
--创建财务表finance--
create table finance
(
 ftime datetime not null primary key,
 project varchar(30) not null,
 fmoney int not null,
 Balance int not null,
 income int not null,
 ID char(10),
 foreign key(ID) references usedata(ID)
)

--（1）两张表等值连接--
--内连接查询用户日记表和备忘表的所有信息--
select *from diary join memo on diary.ID=memo.ID
--查询余额大于1万元的用户的日记信息--
select *from diary join finance on diary.ID=finance.ID where Balance>1000 
--外连接查询余额大于1千的用户的联系人的姓名，工作地点，备注信息--
select communication.ID  用户,cname 姓名 , place 工作地点, remarks 备注 from communication left join finance on communication.ID=finance.ID where Balance>1500
--（2）创建视图--
--为日记表创建视图,当天气为晴时用户的日记信息--
create view diary_view as
select dtime as 时间,devent as 事件,weather as 天气,ID as 账号
from diary
where weather='晴'
select *from  diary_view
--为备忘录表创建视图，当用户备忘录的日期在2018-8-15前的信息。--
create view memo_view as
select mtime as 时间,mlocation as 地点, mevent as 事件,ID as 账号
from memo
where mtime<'2018-8-15' and ID='001'
select *from memo_view
--为通讯录创建视图包含城市是洛阳的用户的所有信息--
create view communication_view as
select telephone as 电话, cname 姓名,city 城市,place 工作地点,remarks 备注, ID 账号  from communication
where city='洛阳'
select *from communication_view
--(3）子查询的SQL语句--
--查询日记表中天气为晴的用户的备忘录信息--
select * from memo where ID in (select ID from diary where weather='多云')
--（4）有修改语句--
--修改用户ID为003的日记中的天气信息--
update diary set weather='雨' where ID='003'
--修改日期为2018-7-20日记中的天气信息--
update diary set weather='阴' where dtime='2018-7-20'

--(5)删除语句--
--删除2018年5-20号的日记信息--
delete from diary where dtime='2018-5-20'
--(6)聚集函数--
--查询收入表中的最大收入--
select max(income) 最大收入 from finance
--查询支出表中的最小支出--
select min(fmoney) 最小支出 from finance
--(7)记录过滤语句，
--查找备忘录中2018-7-1要做的事情-
select mevent 事件 from memo where mtime='2018-7-1'
--（8）修改表结构的SQL语句--
alter table communication add QQ char(10)
--（9）用T-SQL语句写出一个对数据表处理的人机交互程序
create proc proc_Search
@Tid varchar(20)
as
select weather,devent,dtime from diary 
where diary.ID =@Tid
exec proc_Search'001'

--(10)触发器--
create TRIGGER tri_Credit
on diary 
for insert
as
declare @text varchar(50)
if exists (select *from inserted
			where inserted.ID not in( select ID from usedata))
		begin
			set @text='用户ID不存在，将取消操作'
			print @text
			rollback
		end
	else
	  set @text='日记已完成'
	  print @text



