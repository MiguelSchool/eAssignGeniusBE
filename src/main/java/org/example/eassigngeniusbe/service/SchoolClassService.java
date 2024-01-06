package org.example.eassigngeniusbe.service;

import org.example.eassigngeniusbe.model.dto.schoolclass.*;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Set;


public interface SchoolClassService {
    ResponseEntity<CreateSchoolClassResponseDto> createSchoolClass(CreateSchoolClassRequestDto createSchoolClassRequestDto, UriComponentsBuilder uriComponentsBuilder);
    ResponseEntity<UpdateSchoolClassResponseDto> updateSchoolClass(UpdateSchoolClassRequestDto updateSchoolClassRequestDto);

    ResponseEntity<GetSchoolClassResponseDto> getSchoolClass(Long schoolClassId);
    ResponseEntity<Collection<GetSchoolClassResponseDto>> getAllSchoolClassDtos();

    ResponseEntity<SchoolClassEntity> deleteSchoolClass(Long schoolClassId);

    ResponseEntity<Collection<GetSchoolClassResponseDto>> getSchoolClassesByTeacher(Long teacherId);

    ResponseEntity<Set<GetSchoolClassResponseDto>> getSchoolClassesByGradeLevel(Long gradeLevelId);
}
