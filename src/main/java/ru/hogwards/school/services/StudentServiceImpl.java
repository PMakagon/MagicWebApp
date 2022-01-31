package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import ru.hogwards.school.repository.StudentRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private void checkForNull(Object object) {
        if (object == null) {
            throw new BadRequestException();
        }
    }

    @Override
    public Collection<Student> getByAge(int age){
       return getAll().stream().filter(student -> student.getAge()==age).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Student addStudent(Student student) {
        checkForNull(student);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public Student editStudent(Student student) {
        checkForNull(student);
        return studentRepository.save(student);
    }

    @Override
    public Collection<Student> getAll() {
        return Collections.unmodifiableCollection(studentRepository.findAll());
    }

    @Override
    public void removeStudent(long id) {
        studentRepository.deleteById(id);
    }
}
