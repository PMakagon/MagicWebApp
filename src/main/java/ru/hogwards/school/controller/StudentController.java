package ru.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.services.StudentService;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("{id}")
    public Student getFaculty(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/getAll")
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

    @DeleteMapping("{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable long id){
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/age")
    public Collection<Student> getByAgeBetween( @RequestParam(required = false) int min, @RequestParam(required = false) int max){
        return studentService.getByAgeBetween(min,max);
    }

}
