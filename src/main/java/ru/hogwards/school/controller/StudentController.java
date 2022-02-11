package ru.hogwards.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.services.StudentService;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping /// http://localhost:8080/school/student/create
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("{id}") /// http://localhost:8080/school/student/1
    public Student getFaculty(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/getAll") /// http://localhost:8080/school/student/getAll
    public Collection<Student> getStudent(){
        return studentService.getAll();
    }

    @PutMapping("{id}")
    public Student editStudent(@RequestBody Student student){
        return studentService.editStudent(student);
    }

    @GetMapping("/age/{age}")
    public Collection<Student> getByAge(@PathVariable int age){
        return studentService.getByAge(age);
    }

    @DeleteMapping("{id}") /// http://localhost:8080/school/student/remove/1
    public Student removeStudent(@PathVariable long id){
        return studentService.removeStudent(id);
    }

}
