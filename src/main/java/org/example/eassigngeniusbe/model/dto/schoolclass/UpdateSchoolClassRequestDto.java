package org.example.eassigngeniusbe.model.dto.schoolclass;
//TODO: add subjects
public record UpdateSchoolClassRequestDto(Long id, String classname, String classRoom, Long teacherId, Long gradeLevelId) { }
