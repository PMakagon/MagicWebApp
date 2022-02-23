package ru.hogwards.school.services;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwards.school.domain.Avatar;

import java.io.IOException;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
}
