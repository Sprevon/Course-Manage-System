package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    //Query all elective course
    @Select("SELECT * FROM t_course WHERE isCompulsory = 0")
    List<Course> getElective();

    @Select("SELECT * FROM t_course WHERE courseID = #{courseID}")
    Course getCourseByID(@Param("courseID")Integer courseID);
}
