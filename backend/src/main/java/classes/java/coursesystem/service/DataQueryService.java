package classes.java.coursesystem.service;

import classes.java.coursesystem.entity.Course;
import classes.java.coursesystem.entity.Major;
import classes.java.coursesystem.entity.Student;
import classes.java.coursesystem.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataQueryService {
    private final StudentMapper studentMapper;
    private final MCMapper mcMapper;
    private final MDMapper mdMapper;
    private final CourseMapper courseMapper;
    public final MajorMapper majorMapper;

    @Autowired
    public DataQueryService(StudentMapper studentMapper, MCMapper mcMapper, MDMapper mdMapper, CourseMapper courseMapper, MajorMapper majorMapper) {
        this.studentMapper = studentMapper;
        this.mcMapper = mcMapper;
        this.mdMapper = mdMapper;
        this.courseMapper = courseMapper;
        this.majorMapper = majorMapper;
    }

    /**
     * 学生信息查询
     * @param username
     * @return Student
     */
    public Student getStudentInfoByID(String username){
        try {
            return studentMapper.findByUsername(username);
        }catch (Exception e){
            return new Student();
        }
    }

    /**
     * 学生培养计划查询
     * @param userID
     * @return List
     */
    public List<Course> getCourseByID(Integer userID){
        return mcMapper.getCoursesByStudentId(userID);
    }

    /**
     * 学生选修课查询
     * @param userID
     * @return List
     */
    public List<Course> getElectiveCourseForEach(Integer userID){
        return mcMapper.getElectiveCoursesByStudentId(userID);
    }

    /**
     * 查询所有选修课
     * @return List
     */
    public List<Course> getAllElectiveCourse(){
        return mcMapper.getElectiveCourses();
    }

    /**
     * 获取专业方向名称
     * @param direction
     * @return String Name
     */
    public String getDirectionName(String majorName,Integer direction){
        Major major = majorMapper.selectMajorByName(majorName);
        return mdMapper.getDirectionName(major.getMajorID(), direction);
    }

    /**
     * 查询方向课程
     * @param majorName
     * @param direction
     * @return 课表
     */
    public List<Course> getDirectionCourse(String majorName,Integer direction){
        Major major = majorMapper.selectMajorByName(majorName);
        return mcMapper.getMajorDirectionCourse(major.getMajorID(), direction);
    }
}
