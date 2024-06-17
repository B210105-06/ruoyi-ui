package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class StudentMain {
    public static void main(String[] args) {
        ApplicationContext appContext = new
                ClassPathXmlApplicationContext("application-context.xml");
        StudentController stuCon = (StudentController)
                appContext.getBean("studentController");
        stuCon.save("李四", 17);
    }
}