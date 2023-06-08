package classes.java.coursesystem.service;

import classes.java.coursesystem.entity.DC;
import classes.java.coursesystem.entity.Major;
import classes.java.coursesystem.entity.Student;
import classes.java.coursesystem.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class DataChangeService {
    private final MCMapper mcMapper;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final MajorMapper majorMapper;
    private final DCMapper dcMapper;
    @Autowired
    public DataChangeService(MCMapper mcMapper, StudentMapper studentMapper, CourseMapper courseMapper, MajorMapper majorMapper, DCMapper dcMapper) {
        this.mcMapper = mcMapper;
        this.studentMapper = studentMapper;
        this.courseMapper = courseMapper;
        this.majorMapper = majorMapper;
        this.dcMapper = dcMapper;
    }

    /**
     * 选择选修课
     * @param userID
     * @param courseID
     * @return true as success, false as fail
     */
    public boolean SelectElectiveCourse( Integer userID, Integer courseID){
        try {
            Student student = studentMapper.findByID(userID);
            Major major = majorMapper.selectMajorByName(student.getMajorName());
            Integer majorID = major.getMajorID();
            mcMapper.selectCourse(majorID, userID, courseID);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    /**
     * 删除选修课
     * @param userID
     * @param courseID
     * @return true as success, false as fail
     */
    public boolean unselectElectiveCourse(Integer userID, Integer courseID){
        try {
            Student student = studentMapper.findByID(userID);
            Major major = majorMapper.selectMajorByName(student.getMajorName());
            Integer majorID = major.getMajorID();
            mcMapper.deleteCourseInMCTable(majorID, userID, courseID);
            return true;
        }catch (Exception e){
            return false;
        }
    }



    public boolean chooseDirection(Integer userID, Integer direction){
        if (direction == 1 ||direction == 2){
            //学生方向数据修改
            Student student = studentMapper.findByID(userID);
            System.out.println("======student found");
            studentMapper.deleteStudentByID(student.getUserID());
            System.out.println("======student deleted");
            student.setDirection(direction);

            studentMapper.insertStudent(student.getName(), student.getUserID(), student.getUsername(), student.getPassword(), student.getMajorName(), student.getDirection());
            System.out.println("======student inserted");

            //学生方向课程数据修改
            Major major = majorMapper.selectMajorByName(student.getMajorName());
            List<DC> dcList = dcMapper.getMajorDirectionCourseData(major.getMajorID(), student.getDirection());
            List<DC> delList = dcMapper.getMajorDirectionCourseData(major.getMajorID(),3 - student.getDirection());
            try {
                for (DC dcElement : delList) {
                    //删除另一个方向的课程
                    mcMapper.deleteCourseInMCTable(major.getMajorID(), student.getUserID(), dcElement.getCourseID());
                }
                for (DC dcElement : dcList) {
                    //添加此方向的课程
                    mcMapper.selectCourse(major.getMajorID(), student.getUserID(), dcElement.getCourseID());
                }
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }
    }



}
