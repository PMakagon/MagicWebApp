package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.domain.Faculty;
import ru.hogwards.school.exceptions.BadRequestException;
import ru.hogwards.school.exceptions.ObjectNotFoundException;
import ru.hogwards.school.repository.FacultyRepository;
import java.util.Collection;
import java.util.Collections;


@Service
public class FacultyServiceImpl implements FacultyService {

   private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    private void checkForNull(Object object) {
        if (object == null) {
            throw new BadRequestException();
        }
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        checkForNull(faculty);
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow();
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        checkForNull(faculty);
        return facultyRepository.save(faculty);
    }

    @Override
    public Collection<Faculty> getAll() {
        return Collections.unmodifiableCollection(facultyRepository.findAll());
    }

    @Override
    public Collection<Faculty> getByColor(String color) {
        if(color==null) {
            throw new BadRequestException();
        }
        return facultyRepository.findByColor(color);
    }

    @Override
    public void removeFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getByColorIgnoreCase(String color){
        return facultyRepository.findByColorIgnoreCase(color);
    }

    @Override
    public Collection<Faculty> getByNameOrColor(String name, String color){
        if(color==null) {
            throw new BadRequestException();
        }
        return facultyRepository.findByNameOrColorIgnoreCase(name,color);
    }

}
