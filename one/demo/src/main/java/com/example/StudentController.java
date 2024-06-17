package com.example;

@Component
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Student student;
    public void save(String stuName, int age) {
        System.out.println("执行StudentController.save()");
        student.setStuName(stuName);
        student.setAge(age);
        studentService.save(student);
    }
}
