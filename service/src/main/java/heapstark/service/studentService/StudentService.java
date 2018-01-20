package heapstark.service.studentService;

import heapstark.domain.dao.Student;

import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
public interface StudentService {

    int add(String name, int id);


    int delete(int id);


    Student findAccount(int id);


    List<Student> findAccountList();
}
