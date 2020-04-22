package com.huiyalin.springboot.mapper;

import com.huiyalin.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

//@MapperScan(value = "com.huiyalin.springboot.mapper")扫描所有的mapper下的包
//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);
    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName)values(#{departmentName})")
    int insertDept(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
