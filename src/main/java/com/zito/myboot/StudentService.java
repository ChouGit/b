package com.zito.myboot;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;

    public void insertTwo(){

        Student studentA = new Student();
        studentA.setAge(18);
        studentA.setName("小明");
        studentRepository.save(studentA);

        Student studentB = new Student();
        studentB.setAge(18);
        studentB.setName("小明");
        studentRepository.save(studentA);

    }
}
