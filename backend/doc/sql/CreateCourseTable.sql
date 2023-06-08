#创建课程数据表

drop table if exists t_course;

create table if not exists t_course(
courseID int primary key ,
courseName varchar(20),
isCompulsory boolean,
direction int,#0代表通用,1代表第一个方向,2代表第二个方向
term int
);

#通用课程
insert into t_course values (20006101, '高等数学', true, 0, 1);
insert into t_course values (20006102, '管理学B', true, 0, 2);
insert into t_course values (20006103, '概率论与数理统计', true, 0, 3);
insert into t_course values (20006104, '马克思主义原理', true, 0, 4);


#信管方向课程
insert into t_course values (20006105, 'Web运营', true, 1, 3);#数字运营
insert into t_course values (20006106, '大数据开发', true, 1, 4);
insert into t_course values (20006107, '管理信息系统', true, 2, 3);#智能商务
insert into t_course values (20006108, '商务智能', true, 2, 4);
#工商方向课程
insert into t_course values (20006109, '数据分析python', true, 1, 3);#数据分析
insert into t_course values (20006110, '应用统计学A', true, 1, 4);
insert into t_course values (20006111, '市场调研与评估', true, 2, 3);#市场调研
insert into t_course values (20006112, '研究方法与论文写作', true, 2, 4);
#财管方向课程
insert into t_course values (20006113, '公司理财', true, 1, 3);#公司理财
insert into t_course values (20006114, '组织行为学', true, 1, 4);
insert into t_course values (20006115, '会计学A', true, 2, 3);#财务会计
insert into t_course values (20006116, '金融学', true, 2, 4);
#工程方向课程
insert into t_course values (20006117, '工程项目分析(R语言)', true, 1, 3);#房地产管理
insert into t_course values (20006118, '房地产项目管理', true, 1, 3);
insert into t_course values (20006119, '钢筋混凝土管理', true, 2, 4);#房地产开发
insert into t_course values (20006120, '工程制图', true, 2, 4);


#选修课
insert into t_course values (20006121, '程序设计语言python', false, 0, 1);
insert into t_course values (20006122, '电子商务A', false, 0, 2);
insert into t_course values (20006123, '电子商务B', false, 0, 3);
insert into t_course values (20006124, '计量经济学A', false, 0, 3);
insert into t_course values (20006125, '计量经济学B', false, 0, 4);
insert into t_course values (20006126, '机器学习', false, 0, 4);
insert into t_course values (20006127, '宏观经济学', false, 0, 2);
insert into t_course values (20006128, '决策智能与应用', false, 0, 4);
insert into t_course values (20006129, '财务思维', false, 0, 1);
insert into t_course values (20006130, '经济法', false, 0, 2);
insert into t_course values (20006131, '组织行为学', false, 0, 3);
insert into t_course values (20006132, '微观经济学', false, 0, 1);
insert into t_course values (20006133, '应用统计学', false, 0, 2);
insert into t_course values (20006134, '经济法', false, 0, 3);
insert into t_course values (20006135, '市场调研与评估', false, 0, 4);
