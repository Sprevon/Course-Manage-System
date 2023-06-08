#创建学生数据表

drop table t_student;
#创建数据表
create table if not exists t_student(
name VARCHAR(20),
userID int primary key ,
username varchar(20),
password varchar(20),
majorName varchar(30) references coursemanagementsystem.t_major(majorName),
direction int
);
#定义自增

#插入数据
insert into t_student value('张三',20210101,'zhangsan','123','信息管理与信息系统', 0);
insert into t_student value('李四',20210102,'lisi','123','工程管理', 0);
insert into t_student value('王五',20210103,'wangwu','123','工商管理', 0);
insert into t_student value('赵六',20210104,'zhaoliu','123','财务管理', 0);


