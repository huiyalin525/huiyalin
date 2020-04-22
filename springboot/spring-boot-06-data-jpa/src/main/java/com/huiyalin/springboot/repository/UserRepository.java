package com.huiyalin.springboot.repository;

import com.huiyalin.springboot.eneity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//继承jpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {

}
