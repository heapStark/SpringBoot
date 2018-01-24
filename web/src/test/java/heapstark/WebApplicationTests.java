package heapstark;

import heapstark.dao.mapper.StudentMapper;
import heapstark.domain.dao.Student;
import heapstark.domain.vo.PageParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(WebApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    StudentMapper studentmapper;

    @Test
    public void limitIntercept() {
        List<Student> studentList = studentmapper.findAllStudent();
    }

    @Test
    public void pageIntercept() {
        PageParams pageParams = new PageParams();
        List<Student> list = studentmapper.findAllStudentByPage(pageParams);
        logger.info("===========end===========");

    }
}
