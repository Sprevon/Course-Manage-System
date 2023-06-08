package classes.java.coursesystem.controller;

import classes.java.coursesystem.entity.Course;
import classes.java.coursesystem.entity.HTTP.HTTPDirection;
import classes.java.coursesystem.entity.HTTP.HTTPElectiveCourse;
import classes.java.coursesystem.service.DataChangeService;
import classes.java.coursesystem.service.DataCheckService;
import classes.java.coursesystem.service.DataQueryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    public final DataChangeService dataChangeService;
    private final DataQueryService dataQueryService;
    private final DataCheckService dataCheckService;

    @Autowired
    public CourseController(DataChangeService dataChangeService, DataQueryService dataQueryService, DataCheckService dataCheckService) {
        this.dataChangeService = dataChangeService;
        this.dataQueryService = dataQueryService;
        this.dataCheckService = dataCheckService;
    }

    //查询所有已选课
    @GetMapping(value = "/course/query")
    @ResponseBody
    public List<Course> queryMajorCourse(@Param("userID")Integer userID ){
        return dataQueryService.getCourseByID(userID);
    }

    //查询选修课
    @GetMapping(value = "/course/queryElective")
    @ResponseBody
    public List<Course> queryElectiveCourse(@Param("userID") Integer userID){
        return dataQueryService.getElectiveCourseForEach(userID);
    }

    //查询所有课程
    @GetMapping(value = "/course/queryAllElective")
    @ResponseBody
    public List<Course> queryAllElectiveCourse(){
        return dataQueryService.getAllElectiveCourse();
    }


    /**
     * 选课
     * @param electiveCourse
     * @return true表示成功， false表示失败.
     */
    @PostMapping(value = "/course/selectElective")
    @ResponseBody
    public boolean selectElective(@RequestBody HTTPElectiveCourse electiveCourse){
        Integer userID = electiveCourse.getUserID();
        Integer courseID = electiveCourse.getCourseID();
        if (!dataCheckService.isChosen(userID, courseID)){
            return dataChangeService.SelectElectiveCourse(userID, courseID);
        }else {
            return false;
        }
    }


    /**
     * 退课
     * @param electiveCourse
     * @return
     */
    @PostMapping(value = "/course/unselectElective")
    @ResponseBody
    public boolean unselectCourse( @RequestBody HTTPElectiveCourse electiveCourse){
        Integer userID = electiveCourse.getUserID();
        Integer courseID = electiveCourse.getCourseID();
        if (!dataCheckService.isChosen(userID, courseID)){
            return dataChangeService.unselectElectiveCourse( userID, courseID);
        }else {
            return false;
        }
    }

    /**
     * 选方向
     * @param httpDirection
     * @return true表示成功,false表示失败
     */
    @PostMapping(value = "/course/chooseDirection")
    @ResponseBody
    public boolean chooseDirection(@RequestBody HTTPDirection httpDirection){
        Integer userID = httpDirection.getUserID();
        Integer direction = httpDirection.getDirection();
        return dataChangeService.chooseDirection(userID, direction);
    }

    /**
     * 查询方向名
     * @param majorName
     * @param direction
     * @return
     */
    @GetMapping(value = "/course/getDirection")
    @ResponseBody
    public String getDirection(@Param("majorName")String  majorName, @Param("direction")Integer direction){
        return dataQueryService.getDirectionName(majorName, direction);
    }


    @GetMapping(value = "/course/getDirectionCourse")
    @ResponseBody
    public List<Course> getDirectionCourse(@Param("majorName")String  majorName, @Param("direction")Integer direction){
        return dataQueryService.getDirectionCourse(majorName, direction);
    }
}
