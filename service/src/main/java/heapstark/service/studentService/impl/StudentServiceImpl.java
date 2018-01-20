package heapstark.service.studentService.impl;

import heapstark.dao.mapper.StudentMapper;
import heapstark.domain.dao.Student;
import heapstark.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentmapper;

    public int add(String name, int id) {
        return studentmapper.add(name, id);
    }

    public int delete(int id) {
        return studentmapper.delete(id);
    }

    public Student findAccount(int id) {
        return studentmapper.findAccount(id);
    }

    public List<Student> findAccountList() {
        return studentmapper.findAccountList();
    }
}
