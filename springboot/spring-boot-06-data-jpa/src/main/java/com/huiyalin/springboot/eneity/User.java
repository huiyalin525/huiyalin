package com.huiyalin.springboot.eneity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity//告诉jpa这是一个实体类
@Table(name = "table_user")//@Table来指定和那个数据表对应；如果省略默认表名就是user
public class User {

    private Integer id;

    private String lastName;

    private String email;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "last_name",length = 50)//这是和数据表对应的一个列
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column//省略 默认列名就是属性名
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
