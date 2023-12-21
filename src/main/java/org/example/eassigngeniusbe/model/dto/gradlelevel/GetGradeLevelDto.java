package org.example.eassigngeniusbe.model.dto.gradlelevel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record GetGradeLevelDto(Long id, String name, LocalDate beginGradle, LocalDate endGradle, LocalDateTime createdAt, LocalDateTime updatedAt) { }
