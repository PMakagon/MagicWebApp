package ru.hogwards.school.services;


import ru.hogwards.school.domain.Faculty;

import java.util.Collection;


public interface FacultyService {


    Faculty addFaculty(String name,String color);
    Faculty addFaculty(Faculty faculty);
    Faculty getFaculty(long id);
    Faculty editFaculty(long id,String name, String color);
    Collection<Faculty> getAll();
    Faculty removeFaculty(long id);



}
