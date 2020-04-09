package com.huiyalin.cache;

import com.huiyalin.cache.bean.Employee;
import com.huiyalin.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBoot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串的
    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的

    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * String(字符串)、list(列表)、set(集合)、hash(散列)、ZSet(有序集合)
     * stringRedisTemplate.opsForValue();String(字符串)操作字符串
     * stringRedisTemplate.opsForList();list(列表)
     * stringRedisTemplate.opsForSet();set(集合)、
     * stringRedisTemplate.opsForHash();hash(散列)
     * stringRedisTemplate.opsForZSet();ZSet(有序集合)
     */
    @Test
    public void test01(){
        //stringRedisTemplate.opsForValue().append("msg","hello");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
    }
    @Test
    public void test02(){
        Employee empId = employeeMapper.getEmpId(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis
        //redisTemplate.opsForValue().set("emp-01",empId);
        //1、将数据以json的方式保存
        //(1)、自己将对象转为json
        //(2)、redisTemplate默认的序列化规则:改变默认的序列化规则;
        employeeRedisTemplate.opsForValue().set(1,empId);
        System.out.println(employeeRedisTemplate.opsForValue().get("emp-01"));
    }
    @Test
    void contextLoads() {
        Employee empId = employeeMapper.getEmpId(1);
        System.out.println(empId);
    }

}
