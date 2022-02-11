package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final Map<Long,Student> studentData = new HashMap<>();
    private Long key = 0L;

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
        student.setId(++key);
        studentData.put(student.getId(), student);
        return student;
    }

    @Override
    public Student getStudent(long id) {
        return studentData.get(id);
    }

    @Override
    public Student editStudent(Student student) {
        checkForNull(student);
        if (studentData.containsKey(student.getId())) {
            studentData.put(student.getId(), student);
            return student;
        }
        throw new ObjectNotFoundException("student not found");
    }

    @Override
    public Collection<Student> getAll() {
        return Collections.unmodifiableCollection(studentData.values());
    }

    @Override
    public Student removeStudent(long id) {
        if (studentData.containsKey(id)) {
            return studentData.remove(id);
        }
        throw new ObjectNotFoundException("student not found");
    }
}
