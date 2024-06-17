package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StudentService {
    @Autowired
    private StudentDao stuDao;
    public void save(Student stu) {
        System.out.println("执行StudentService.save()");
        stuDao.save(stu);
    }
}
