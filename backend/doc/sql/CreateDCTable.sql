#专业课程数据据表
drop table if exists t_dc;

create table if not exists t_dc(
majorID int,
direction int,
courseID int references t_course(courseID),
primary key (majorID, direction, courseID)
);

insert into t_dc values (201, 1, 20006105);
insert into t_dc values (201, 1, 20006106);
insert into t_dc values (201, 2, 20006107);
insert into t_dc values (201, 2, 20006108);

insert into t_dc values (202, 1, 20006109);
insert into t_dc values (202, 1, 20006110);
insert into t_dc values (202, 2, 20006111);
insert into t_dc values (202, 2, 20006112);

insert into t_dc values (203, 1, 20006113);
insert into t_dc values (203, 1, 20006114);
insert into t_dc values (203, 2, 20006115);
insert into t_dc values (203, 2, 20006116);

insert into t_dc values (204, 1, 20006117);
insert into t_dc values (204, 1, 20006118);
insert into t_dc values (204, 2, 20006119);
insert into t_dc values (204, 2, 20006120);