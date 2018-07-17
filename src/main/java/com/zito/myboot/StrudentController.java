package com.zito.myboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StrudentController {

    @Autowired
    private  StudentRepository studentRepository;

    /**
     * 查询学生列表
     * @return
     */
    @GetMapping(value = "/list")
    public List<Student> list(){
       return studentRepository.findAll();
    }

    /**
     * 增加一个学生
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/add")
    public Student add(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);

        return student;
    }

    // 查询一个学生
    @GetMapping(value = "/find/{id}")
    public Optional<Student> findById(@PathVariable("id") Integer id){
        Student student = new Student();
        student.setId(id);
        Example<Student> example = Example.of(student);
        return studentRepository.findOne(example);
    }
    // 查询一个学生
    @GetMapping(value = "/one/{id}")
    public Optional<Student> one(@PathVariable("id") Integer id){
        return studentRepository.findById(id);
    }

    //更新一个学生
    @PutMapping(value = "/update/{id}")
    public Student update(@PathVariable("id") Integer id,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Integer age){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    //删除一个学生
    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        Student student = new Student();
        student.setId(id);
        studentRepository.delete(student);
        return ;
    }

    //通过年龄查询学生列表
    @PostMapping(value = "/findByAge/{id}")
    public List<Student> findByAge(@PathVariable("id") Integer age){
        return studentRepository.findByAge(age);
    }


}
