package ru.hogwards.school.services;

import ru.hogwards.school.domain.Student;
import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudent(long id);
    Student editStudent(Student student);
    Collection<Student> getAll();
    Collection<Student> getByAge(int age);
    Student removeStudent(long id);
}
