package ru.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.domain.Student;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findByAge(int age);
}
