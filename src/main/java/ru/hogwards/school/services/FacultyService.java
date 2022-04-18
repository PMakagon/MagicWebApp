package ru.hogwards.school.services;

import ru.hogwards.school.domain.Faculty;
import java.util.Collection;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty getFaculty(long id);
    Faculty editFaculty(Faculty faculty);
    Collection<Faculty> getAll();
    Collection<Faculty> getByColor(String color);
    void removeFaculty(long id);
    Collection<Faculty> getByColorIgnoreCase(String color);
    Collection<Faculty> findByNameIgnoreCase(String name);
}
