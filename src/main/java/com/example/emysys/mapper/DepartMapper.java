package com.example.emysys.mapper;

import com.example.emysys.entities.Department;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * ClassName: DepartMapper.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:14
 * Description: Mybatis 映射文件 - Department 操作
 */
@Mapper
public interface DepartMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findById(Integer id);

    @Select("SELECT * FROM department")
    @MapKey("id")
    Map<Integer, Department> getMap();


    @Select("SELECT * FROM department")
    List<Department> findAll();

}
