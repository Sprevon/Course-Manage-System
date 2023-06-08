package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MDMapper {
    /**
     * 查询方向名
     * @param majorID
     * @param direction
     * @return String Name
     */
   @Select("SELECT directionName " +
           "FROM t_md " +
           "WHERE majorID = #{majorID} AND direction = #{direction}")
    public String getDirectionName(@Param("majorID") Integer majorID, @Param("direction") Integer direction);


}
