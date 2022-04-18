package ru.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.domain.Faculty;
import java.util.Collection;

public interface FacultyRepository extends JpaRepository <Faculty,Long> {
    Collection<Faculty> findByColorIgnoreCase(String color);
    Collection<Faculty> findByNameIgnoreCase(String color);
    Collection<Faculty> findByColor(String color);
}

