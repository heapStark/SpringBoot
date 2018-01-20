package heapstark.dao.mapper;

import heapstark.domain.dao.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Mapper
@Repository
public interface StudentMapper {
    @Insert("insert into student(name, id) values(#{name}, #{id})")
    int add(@Param("name") String name, @Param("id") int id);


    @Delete("delete from student where id = #{id}")
    int delete(int id);

    @Select("select id, name , score  from student where id = #{id}")
    Student findAccount(@Param("id") int id);

    @Select("select id, name as name, score as score from account")
    List<Student> findAccountList();
}
