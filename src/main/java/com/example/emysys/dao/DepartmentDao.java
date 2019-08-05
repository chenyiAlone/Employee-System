package com.example.emysys.dao;

import java.util.Collection;
import java.util.Map;

import com.example.emysys.entities.Department;
import com.example.emysys.mapper.DepartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * ClassName: DepartmentDao.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:15
 * Description: Department 的数据库操作
 */
@Repository
public class DepartmentDao {

	@Autowired
	private DepartMapper departMapper;

	public Collection<Department> getDepartments(){
		return departMapper.findAll();
	}
	
	public Department getDepartment(Integer id){
		return departMapper.findById(id);
}

	public Map<Integer, Department> getMap() {
		return departMapper.getMap();
	}
	
}
