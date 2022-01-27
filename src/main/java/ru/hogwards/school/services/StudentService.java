package ru.hogwards.school.services;

import ru.hogwards.school.domain.Student;

import java.util.Collection;
import java.util.Map;

public interface StudentService {

    Student addStudent(String name, int age);
    Student addStudent(Student student);
    Student getStudent(long id);
    Student editStudent(long id,String name, int age);
    Collection<Student> getAll();
    Collection<Student> filterByAge(int age);
    Student removeStudent(long id);
}
