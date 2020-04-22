package com.huiyalin.cache.controller;

import com.huiyalin.cache.bean.Department;
import com.huiyalin.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id")Integer id){
        return departmentService.getDeptById(id);
    }

}
