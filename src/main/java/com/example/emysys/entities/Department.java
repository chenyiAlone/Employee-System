package com.example.emysys.entities;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: Department.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 13:11
 * Description: 实体类-Department
 *
 */
public class Department {
	private Integer id;

	private String departmentName;

	public Department() {
	}
	
	public Department(int i, String string) {
		this.id = i;
		this.departmentName = string;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	
}
