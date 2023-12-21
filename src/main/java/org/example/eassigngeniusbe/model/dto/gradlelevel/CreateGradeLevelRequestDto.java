package org.example.eassigngeniusbe.model.dto.gradlelevel;

import java.time.LocalDate;

public record CreateGradeLevelRequestDto(String name, LocalDate beginGradle, LocalDate endGradle) { }
