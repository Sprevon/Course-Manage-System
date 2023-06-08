package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.DC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DCMapper {
    /**
     * 根据专业和方向获取课程信息
     * @param majorID
     * @param direction
     * @return  List(DC)
     */
    @Select("SELECT * FROM t_dc WHERE majorID = #{majorID} AND direction = #{direction}")
    public List<DC> getMajorDirectionCourseData(@Param("majorID") Integer majorID, @Param("direction") Integer direction);


}
