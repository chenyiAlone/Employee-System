package com.example.emysys.mapper;

import com.example.emysys.entities.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: EmpMapper.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:13
 * Description: Mybatis 映射文件 - Employee 操作
 */
@Mapper
public interface EmpMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee findById(Integer id);

    @Select("SELECT * FROM employee")
    List<Employee> findAll();

    @Insert("INSERT INTO employee(lastname, email, gender, did, birth) " +
            "VALUES(#{lastName}, #{email}, #{gender}, #{dId}, #{birth})")
    void save(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE employee SET lastname = #{lastName}, email = #{email}, " +
            "gender = #{gender}, did = #{dId}, birth = #{birth} WHERE id = #{id}")
    void update(Employee employee);

}
