package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * 常用数据操作
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT * FROM t_student WHERE username = #{username}")
    Student findByUsername(@Param("username") String username);

    @Insert("INSERT IGNORE INTO t_student VALUES(" +
            "#{name}, #{userID}, #{username}, #{password}, #{majorName}, #{direction}" +
            ")")
    void insertStudent(@Param("name") String name,
                          @Param("userID") Integer userID,
                          @Param("username") String username,
                          @Param("password") String password,
                          @Param("majorName") String majorName,
                          @Param("direction") Integer direction);


    @Delete("DELETE FROM t_student WHERE userID = #{userID}")
    void deleteStudentByID(@Param("userID") Integer userID);

    @Select("SELECT * FROM t_student WHERE userID = #{userID}")
    Student findByID(@Param("userID") Integer userID);

}
