package com.example;

@Component
public class StudentDao {
    public void save(Student stu) {
        System.out.println("执行StudentDao.save()");
        System.out.println("模拟保存学生信息到数据库");
        System.out.println(stu);
    }
}
