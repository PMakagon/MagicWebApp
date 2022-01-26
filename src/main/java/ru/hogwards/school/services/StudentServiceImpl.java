package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Student;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import ru.hogwards.school.exceptions.WrongKeyException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{

    private final Map<Long,Student> studentData = new HashMap<>();
    private Long key = 0L;

    @PostConstruct
    public void psd(){
        addStudent("stud",1);
        addStudent("stud2",2);
    }

    private void checkIsAvailable(long id){
        if(id > key){
            throw new ObjectNotFoundException("Object not found");
        }
    }

    private void incrementKey() {
        key++;
    }

    private void decrementKey() {
        if(key>0){
            key--;
        }else{
            throw new WrongKeyException("Вы не должны это увидеть никогда");
        }
    }

    private void checkForNull(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new BadRequestException();
        }
    }

    private void checkForNull(Object object) {
        if (object == null) {
            throw new BadRequestException();
        }
    }

    @Override
    public Student addStudent(String name, int age) {
        checkForNull(name, age);
        incrementKey();
        return studentData.put(key,new Student(key,name,age));
    }


    @Override
    public Student addStudent(Student student) {
        checkForNull(student);
        return studentData.put(student.getId(), student);
    }

    @Override
    public Student getStudent(long id) {
        checkIsAvailable(id);
        return studentData.get(id);
    }

    @Override
    public Student editStudent(long id, String name, int age) {
        checkIsAvailable(id);
        Student studentToEdit = studentData.get(id);
        studentToEdit.setName(name);
        studentToEdit.setAge(age);
        return studentToEdit;
    }

    @Override
    public Collection<Student> getAll() {
        return Collections.unmodifiableCollection(studentData.values());
    }

    @Override
    public Student removeStudent(long id) {
        checkIsAvailable(id);
        decrementKey();
        return studentData.remove(id);
    }
}
