package classes.java.coursesystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_course")
public class Course {
    @TableId
    private Integer courseID;
    private String courseName;
    private Integer isCompulsory;
    private Integer direction;
    private Integer term;

    public Course() {
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getIsCompulsory() {
        return isCompulsory;
    }

    public void setIsCompulsory(Integer isCompulsory) {
        this.isCompulsory = isCompulsory;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
