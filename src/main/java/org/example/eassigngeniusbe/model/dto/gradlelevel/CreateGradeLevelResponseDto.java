package org.example.eassigngeniusbe.model.dto.gradlelevel;

import java.time.LocalDate;

public record CreateGradeLevelResponseDto(Long id, String name, LocalDate beginGradle, LocalDate endGradle) { }
