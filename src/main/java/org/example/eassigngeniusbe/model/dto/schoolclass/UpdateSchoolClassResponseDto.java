package org.example.eassigngeniusbe.model.dto.schoolclass;

import java.time.LocalDateTime;

public record UpdateSchoolClassResponseDto(Long id, String classname, String classRoom, Long gradeLevelId, Long teacherId, LocalDateTime createdAt, LocalDateTime updatedAt) { }
