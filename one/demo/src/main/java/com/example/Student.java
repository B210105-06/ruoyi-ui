package com.example;

import org.springframework.stereotype.Component;
@Component
public class Student {
    private String stuName;

    private int age;
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "学生姓名：" + stuName + "年龄：" + age;
    }
}
