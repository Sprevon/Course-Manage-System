package classes.java.coursesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:4789
@SpringBootApplication
@MapperScan("classes.java.coursesystem.mapper")
public class CourseSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseSystemApplication.class, args);
    }

}
