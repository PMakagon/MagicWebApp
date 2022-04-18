package ru.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.domain.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long studentId);
}

