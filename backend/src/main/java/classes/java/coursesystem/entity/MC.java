package classes.java.coursesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_mc")
public class MC {
    private Integer majorID;
    private Integer userID;
    private Integer courseID;
    public MC() {
    }

    public Integer getMajorID() {
        return majorID;
    }

    public void setMajorID(Integer majorID) {
        this.majorID = majorID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }
}
