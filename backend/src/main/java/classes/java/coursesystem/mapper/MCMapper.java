package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 对专业课程数据进行数据操作的Mapper接口
 * <br>
 * 以多表查询为主要操作
 */
@Mapper
public interface MCMapper extends BaseMapper<Course> {
    /**
     * 查询个人培养计划
     * @param userID
     * @return List
     */
    @Select("SELECT c.* " +
        "FROM t_course c " +
        "JOIN t_mc mc ON c.courseID = mc.courseID " +
        "WHERE mc.userID = #{userID}")
    public List<Course> getCoursesByStudentId(@Param("userID") Integer userID);

    /**
     * 查询个人选修课
     * @param userID
     * @return List
     */
    @Select("SELECT c.* " +
            "FROM t_course c " +
            "JOIN t_mc mc ON c.courseID = mc.courseID " +
            "WHERE mc.userID = #{userID} AND c.isCompulsory = 0")
    public List<Course> getElectiveCoursesByStudentId(@Param("userID") Integer userID);


    /**
     * 查询所有选修课
     * @return List
     */
    @Select("SELECT c.* " +
            "FROM t_course c " +
            "WHERE c.isCompulsory = 0")
    public List<Course> getElectiveCourses();



    /**
     * 查询专业方向选修课
     * @param majorID
     * @param direction
     * @return List
     */
    @Select("SELECT c.* " +
            "FROM t_course c " +
            "JOIN t_dc dc ON dc.courseID = c.CourseID " +
            "WHERE c.direction = #{direction} AND dc.majorID = #{majorID}")
    public List<Course> getMajorDirectionCourse(@Param("majorID") Integer majorID, @Param("direction") Integer direction);




    /**
     * 插入个人选课
     * @param majorID
     * @param userID
     * @param courseID
     */
    @Insert("INSERT INTO t_mc " +
            "VALUES(" +
            "#{majorID}, #{userID}, #{courseID}" +
            ")")
    public void selectCourse(@Param("majorID") Integer majorID, @Param("userID") Integer userID, @Param("courseID") Integer courseID);


    /**
     * 删除个人选课
     * @param majorID
     * @param userID
     * @param courseID
     */
    @Delete("DELETE FROM t_mc WHERE majorID = #{majorID} AND userID = #{userID} AND courseID = #{courseID} ")
    void deleteCourseInMCTable(@Param("majorID") Integer majorID, @Param("userID") Integer userID, @Param("courseID") Integer courseID);






}










