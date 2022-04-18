package ru.hogwards.school.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwards.school.domain.Avatar;

import java.util.Collection;
import java.util.Optional;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long studentId);
    Collection<Avatar> findAll();
}

