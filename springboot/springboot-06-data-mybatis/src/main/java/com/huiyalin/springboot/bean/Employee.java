package com.huiyalin.springboot.bean;

public class Employee {

    private Integer id;
    private String lastName;
    private Integer gender;
    private String emil;
    private Integer dId;

    public Employee(Integer id, String lastName, Integer gender, String emil, Integer dId) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.emil = emil;
        this.dId = dId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
