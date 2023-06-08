#创建专业方向表

drop table if exists t_md;

create table if not exists t_md(
majorID int references t_major(majorID),
direction int references t_student(direction),
directionName varchar(20),
primary key (majorID, direction)
);

insert into t_md values (201, 1, '数字运营');
insert into t_md values (201, 2, '智能商务');

insert into t_md values (202, 1, '数据分析');
insert into t_md values (202, 2, '市场调研');

insert into t_md values (203, 1, '公司理财');
insert into t_md values (203, 2, '财务会计');

insert into t_md values (204, 1, '房地产管理');
insert into t_md values (204, 2, '房地产开发');