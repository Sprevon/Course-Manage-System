package classes.java.coursesystem.controller;

import classes.java.coursesystem.entity.LoginRequest;
import classes.java.coursesystem.entity.Student;
import classes.java.coursesystem.service.DataChangeService;
import classes.java.coursesystem.service.DataCheckService;
import classes.java.coursesystem.service.DataQueryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    public final DataChangeService dataChangeService;
    private final DataQueryService dataQueryService;
    private final DataCheckService dataCheckService;

    @Autowired
    public LoginController(DataChangeService dataChangeService, DataQueryService dataQueryService, DataCheckService dataCheckService) {
        this.dataChangeService = dataChangeService;
        this.dataQueryService = dataQueryService;
        this.dataCheckService = dataCheckService;
    }

    //http://localhost:4567/login?username=zhangsan&password=123
    @PostMapping(value = "/login")
    @ResponseBody
    public String Login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        boolean isValidStudent = dataCheckService.isValidStudent(username, password);

        if (isValidStudent){
            return "Login success";
        }else {
            return "Login fail";
        }
    }

    @GetMapping(value = "/login/getByID")
    @ResponseBody
    public Student getStudentInfo(@Param("username") String username){
        return dataQueryService.getStudentInfoByID(username);
    }
}
