package ru.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.services.FacultyService;

import java.util.Collection;

//localhost:8080/school/swagger-ui/index.html#
@RestController
 @RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

     @PostMapping
    public Faculty createFaculty( @RequestBody Faculty faculty){
       return facultyService.addFaculty(faculty);
    }

    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable long id){
        return facultyService.getFaculty(id);
    }

    @GetMapping("/all")
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

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> removeFaculty(@PathVariable long id){
        facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/filter")
    public Collection<Faculty> getByNameIgnoreCase(@RequestParam String name){
        return facultyService.findByNameIgnoreCase(name);
    }
    @GetMapping("/filter")
    public Collection<Faculty> getByNameOrColorIgnoreCase(@RequestParam String color){
        return facultyService.getByColorIgnoreCase(color);
    }
}
