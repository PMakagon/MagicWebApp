package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import ru.hogwards.school.exceptions.WrongKeyException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> facultyData = new HashMap<>();
    private Long key = 0L;

    @PostConstruct
    public void sdada() {
        addFaculty("a", "a");
        addFaculty("a2", "a2");
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
        }
        throw new WrongKeyException("Вы не должны это увидеть никогда");
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
    public Faculty addFaculty(String name, String color) {
        checkForNull(name, color);
        incrementKey();
        return facultyData.put(key, new Faculty(key, name, color));
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        checkForNull(faculty);
        return facultyData.put(faculty.getId(), faculty);
    }

    @Override
    public Faculty getFaculty(long id) {
        checkIsAvailable(id);
        return facultyData.get(id);
    }

    @Override
    public Faculty editFaculty(long id,String name, String color) {
        checkIsAvailable(id);
        Faculty facultyToEdit = facultyData.get(id);
        facultyToEdit.setName(name);
        facultyToEdit.setColor(color);
        return facultyToEdit;
    }

    @Override
    public Collection<Faculty> getAll() {
        return Collections.unmodifiableCollection(facultyData.values());
    }

    @Override
    public Faculty removeFaculty(long id) {
        checkIsAvailable(id);
        decrementKey();
        return facultyData.remove(id);
    }
}
