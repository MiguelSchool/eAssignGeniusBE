package org.example.eassigngeniusbe.model.dto.gradlelevel;

import java.time.LocalDate;

public record UpdateGradeLevelResponseDto(Long id, String name, LocalDate beginGradle, LocalDate endGradle) { }
