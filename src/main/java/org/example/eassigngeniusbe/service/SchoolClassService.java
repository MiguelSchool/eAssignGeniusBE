package org.example.eassigngeniusbe.service;

import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassRequestDto;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface SchoolClassService {
    ResponseEntity<CreateSchoolClassResponseDto> createSchoolClass(CreateSchoolClassRequestDto createSchoolClassRequestDto, UriComponentsBuilder uriComponentsBuilder);
}
