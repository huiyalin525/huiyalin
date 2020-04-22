package com.huiyalin.cache.controller;

import com.huiyalin.cache.bean.Employee;
import com.huiyalin.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/Emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }
    @GetMapping("/Emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
    @GetMapping("/delete")
    public String deleteEmp(Integer id){
        employeeService.deleEmp(id);
        return "success";
    }
    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
