package com.huiyalin.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *@ConfigurationProperties:告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *    prefix = "preson"：配置文件中哪个下面的所有属性一一映射
 *
 *    只有这个组件是容器中的组件，才能用容器提供的@ConfigurationProperties
 * @PropertySource(value={"classpath:person.properties"})用于指定加载那个properties配置文件
 * @ImportRescource(locations = {"classpath:bean.xml"})导入Spring的配置文件让其生效
 */
@Component
@EnableConfigurationProperties(Person.class)
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private String age;

    private List<Integer> lists;
    private Map<Integer,Object> maps;

    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }

    public Map<Integer, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, Object> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person() {
    }

    public Person(String name, String age, List<Integer> lists, Map<Integer, Object> maps, Dog dog) {
        this.name = name;
        this.age = age;
        this.lists = lists;
        this.maps = maps;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", lists=" + lists +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
