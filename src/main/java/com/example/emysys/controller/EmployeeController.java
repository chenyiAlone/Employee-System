package com.example.emysys.controller;

import com.example.emysys.dao.DepartmentDao;
import com.example.emysys.dao.EmployeeDao;
import com.example.emysys.entities.Department;
import com.example.emysys.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
/**
 * ClassName: EmployeeController.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:01
 * Description: Employee 控制器
 *
 * 用于控制员工管理操作
 * 1. 员工显示
 * 2. 添加员工
 * 3. 信息更改
 * 4. 删除员工
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String  list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
//        List<Employee> employees = empMapper.findAll();
        Map<Integer, Department> departments = departmentDao.getMap();
//        Map<Integer, Department> departments = departMapper.getMap();
//        Collection<Employee> employees = employeeRepository.findAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        model.addAttribute("depts",departments);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
//        Collection<Department> departments = departMapper.findAll();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
//        empMapper.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);

//        Employee employee = empMapper.findById(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
//        Collection<Department> departments = departMapper.findAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.update(employee);
//        empMapper.save(employee);
        return "redirect:/emps";  // 重定向
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
//        empMapper.delete(id);
        return "redirect:/emps";
    }



}
