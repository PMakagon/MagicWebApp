package ru.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.domain.Faculty;
import java.util.Collection;

public interface FacultyRepository extends JpaRepository <Faculty,Long> {
    Collection<Faculty> findByColor(String color);
    Collection<Faculty> findByNameOrColorIgnoreCase(String name, String color );
}
