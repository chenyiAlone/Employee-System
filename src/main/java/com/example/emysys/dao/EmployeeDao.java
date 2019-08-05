package com.example.emysys.dao;

import java.util.Collection;

import com.example.emysys.entities.Employee;
import com.example.emysys.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * ClassName: EmployeeDao.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:16
 * Description: Employee 的数据库操作
 */
@Repository
public class EmployeeDao {
	@Autowired
	private EmpMapper empMapper;

	public void save(Employee employee){
		empMapper.save(employee);
	}

	public void update(Employee employee) {
		empMapper.update(employee);
	}

	//查询所有员工
	public Collection<Employee> getAll(){
//		return employees.values();
		return empMapper.findAll();
	}
	
	public Employee get(Integer id){
//		return employees.get(id);
		return empMapper.findById(id);
	}
	
	public void delete(Integer id){
//		employees.remove(id);
		empMapper.delete(id);
	}
}
