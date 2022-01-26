package ru.hogwards.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition
public class MagicWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagicWebAppApplication.class, args);
//        Student student1 = new Student(1,"a",10);
//        Student student2 = new Student(2,"b",11);
//        Student student3 = new Student(3,"c",12);
//        Faculty faculty1 = new Faculty(1,"aa","red");
//        Faculty faculty2 = new Faculty(2,"ab","blue");
//        Faculty faculty3 = new Faculty(3,"ac","green");
//        List<Faculty> faculties = new ArrayList<>();
//        faculties.add(faculty1);
//        faculties.add(faculty2);
//        faculties.add(faculty3);
//        List<Student> students = new ArrayList<>();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        System.out.println(Arrays.toString(students.toArray()));
//        System.out.println(Arrays.toString(faculties.toArray()));

    }

}
