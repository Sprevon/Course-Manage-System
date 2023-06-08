package classes.java.coursesystem.service;
import classes.java.coursesystem.entity.Course;
import classes.java.coursesystem.entity.Student;
import classes.java.coursesystem.mapper.CourseMapper;
import classes.java.coursesystem.mapper.MCMapper;
import classes.java.coursesystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class DataCheckService {
    private final StudentMapper studentMapper;
    private final MCMapper mcMapper;
    private final CourseMapper courseMapper;
    @Autowired
    public DataCheckService(StudentMapper studentMapper, MCMapper mcMapper, CourseMapper courseMapper) {
        this.studentMapper = studentMapper;
        this.mcMapper = mcMapper;
        this.courseMapper = courseMapper;
    }


    /**
     * 确认学生登录信息是否合法
     * @param username
     * @param password
     * @return boolean
     */
    public  boolean isValidStudent(String username, String password){
        try {
            Student student = studentMapper.findByUsername(username);
            if(Objects.equals(password, student.getPassword())){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 确认课程是否已被选择
     * @param userID
     * @param courseID
     * @return ture 表示已选, false 表示未选
     */
    public boolean isChosen(Integer userID, Integer courseID){
        List<Course> courseList = mcMapper.getCoursesByStudentId(userID);
        Course course = courseMapper.getCourseByID(courseID);
        HashSet<Course> courseHashSet = new HashSet<>(courseList);
        return courseHashSet.contains(course);
    }
}
