package classes.java.coursesystem.mapper;

import classes.java.coursesystem.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MajorMapper extends BaseMapper<Major> {
    @Select("SELECT * " +
            "FROM t_major" +
            " WHERE majorName = #{majorName}")
    public Major selectMajorByName(String majorName);
}
