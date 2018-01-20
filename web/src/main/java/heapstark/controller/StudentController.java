package heapstark.controller;

import heapstark.domain.dao.Student;
import heapstark.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@RestController("/student")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/insert")
    public Integer insert(int id, String name) {

        return studentService.add(name, id);
    }

    @RequestMapping("/select")
    public Student select(int id) {

        return studentService.findAccount(id);
    }
}
