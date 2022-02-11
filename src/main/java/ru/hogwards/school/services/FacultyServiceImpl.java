package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> facultyData = new HashMap<>();
    private Long key = 0L;

    private void checkForNull(Object object) {
        if (object == null) {
            throw new BadRequestException();
        }
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        checkForNull(faculty);
        faculty.setId(++key);
        facultyData.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty getFaculty(long id) {
        return facultyData.get(id);
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        checkForNull(faculty);
        if (facultyData.containsKey(faculty.getId())) {
            facultyData.put(faculty.getId(), faculty);
            return faculty;
        }
        throw new ObjectNotFoundException("faculty not found");
    }

    @Override
    public Collection<Faculty> getAll() {
        return Collections.unmodifiableCollection(facultyData.values());
    }

    @Override
    public Collection<Faculty> getByColor(String color) {
        return getAll().stream().filter(student -> student.getColor().equals(color)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Faculty removeFaculty(long id) {
        if (facultyData.containsKey(id)) {
            return facultyData.remove(id);
        }
        throw new ObjectNotFoundException("faculty not found");
    }
}
