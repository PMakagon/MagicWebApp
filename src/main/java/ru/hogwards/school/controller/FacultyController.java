package ru.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.services.FacultyService;

import java.util.Collection;


@RestController
 @RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

     @PostMapping /// http://localhost:8080/school/faculty/create
    public Faculty createFaculty( @RequestBody Faculty faculty){
       return facultyService.addFaculty(faculty);
    }

    @GetMapping("{id}") /// http://localhost:8080/school/faculty/1
    public Faculty getFaculty(@PathVariable long id){
        return facultyService.getFaculty(id);
    }

    @GetMapping("/getAll") /// http://localhost:8080/school/faculty/getAll
    public Collection<Faculty> getFaculty(){
        return facultyService.getAll();
    }

    @PutMapping("{id}")
    public Faculty editFaculty(@RequestBody Faculty faculty){
        return facultyService.editFaculty(faculty);
    }

    @GetMapping("/color/{color}")
    public Collection<Faculty> getByColor(@PathVariable String color){
        return facultyService.getByColor(color);
    }

    @DeleteMapping("{id}") /// http://localhost:8080/school/faculty/remove/1
    public ResponseEntity<Faculty> removeFaculty(@PathVariable long id){
        facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }

}
