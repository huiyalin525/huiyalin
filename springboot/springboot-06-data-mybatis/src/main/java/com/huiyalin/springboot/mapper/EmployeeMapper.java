package com.huiyalin.springboot.mapper;

import com.huiyalin.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//@Mapper或者MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);

}
