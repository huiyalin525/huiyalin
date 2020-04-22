package com.huiyalin.cache.mapper;

import com.huiyalin.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    Employee getEmpId(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},d_id=#{dId},gender=#{gender} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmp(Integer id);

    @Insert("insert into employee (lastName,gender,email,d_id) values(#{lastName},#{gender},#{email},#{d_id})")
    void insertEmp(Employee employee);
    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
