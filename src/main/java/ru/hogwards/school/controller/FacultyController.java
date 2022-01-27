package ru.hogwards.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.services.FacultyService;

import java.util.Collection;


@RestController
 @RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/create") /// http://localhost:8080/school/faculty/create
    public Faculty createFaculty( String name, String color){
       return facultyService.addFaculty( name, color);
    }

    @GetMapping("{id}") /// http://localhost:8080/school/faculty/1
    public Faculty getFaculty(@PathVariable long id){
        return facultyService.getFaculty(id);
    }

    @GetMapping("/getAll") /// http://localhost:8080/school/faculty/getAll
    public Collection<Faculty> getFaculty(){
        return facultyService.getAll();
    }

    @PutMapping("/edit/{id}")
    public Faculty editFaculty(@PathVariable long id, @RequestParam String name, @RequestParam String color){
        return facultyService.editFaculty(id,name,color);
    }

    @GetMapping("/filter/color/{color}")
    public Collection<Faculty> filterByColor(@PathVariable String color){
        return facultyService.filterByColor(color);
    }

    @DeleteMapping("/remove/{id}") /// http://localhost:8080/school/faculty/remove/1
    public Faculty removeFaculty(@PathVariable long id){
        return facultyService.removeFaculty(id);
    }

}
