package heapstark;

import heapstark.dao.mapper.StudentMapper;
import heapstark.domain.dao.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    StudentMapper studentmapper;

    @Test
    public void limitIntercept() {
        List<Student> studentList = studentmapper.findAllStudent();
    }
}
