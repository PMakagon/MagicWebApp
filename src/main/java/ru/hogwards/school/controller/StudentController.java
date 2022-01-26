package ru.hogwards.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.services.StudentService;
import java.util.Collection;


@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create") /// http://localhost:8080/student/create
    public Student createStudent(String name, int age){
        return studentService.addStudent( name, age);
    }

    @GetMapping("{id}") /// http://localhost:8080/student/1
    public Student getFaculty(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/getAll") /// http://localhost:8080/student/getAll
    public Collection<Student> getStudent(){
        return studentService.getAll();
    }

    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable long id, @RequestParam String name, @RequestParam int age){
        return studentService.editStudent(id,name,age);
    }

    @DeleteMapping("/remove/{id}") /// http://localhost:8080/student/remove/1
    public Student removeStudent(@PathVariable long id){
        return studentService.removeStudent(id);
    }

}
