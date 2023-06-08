#创建多对多联系数据表

drop table if exists t_mc;
#创建表格
create table if not exists t_mc(
majorID int references t_major(majorID),
userID int references t_student(userID),
courseID int references t_course(courseId),
primary key (majorID, userID, courseID)
);

#初始化课程(仅保留通用课程)
DELIMITER //
drop procedure insert_data;

CREATE PROCEDURE insert_data()
BEGIN
    DECLARE majorCounter INT DEFAULT 201;
    DECLARE courseCounter INT DEFAULT 20006101;
    DECLARE studentCounter INT DEFAULT 20210101;

    WHILE majorCounter <= 204 DO
            SET courseCounter = 20006101;
            WHILE courseCounter <= 20006104 DO
                insert into t_mc values (majorCounter, studentCounter, courseCounter);
                set courseCounter = courseCounter + 1;
            end while;
            SET studentCounter = studentCounter + 1;
            set majorCounter = majorCounter + 1;
    END WHILE;

END //

DELIMITER ;

call insert_data();
