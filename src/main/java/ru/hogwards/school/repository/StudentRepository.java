package ru.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwards.school.domain.Student;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);
    @Query(value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    Integer getAmountOfStudents();
    @Query(value = "SELECT AVG(amount) FROM student", nativeQuery = true)
    Integer averageStudentsAge();
    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<Student> fiveLastStudents();
}
