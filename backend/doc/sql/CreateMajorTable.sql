#创建专业数据表
drop table t_major;

create table if not exists t_major(
majorID int primary key ,
majorName varchar(20)
);

insert into t_major values(201,'信息管理与信息系统');
insert into t_major values(202,'工商管理');
insert into t_major values(203,'财务管理');
insert into t_major values(204,'工程管理')