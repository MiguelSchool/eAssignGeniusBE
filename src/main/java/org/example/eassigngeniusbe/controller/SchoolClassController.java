package org.example.eassigngeniusbe.controller;

import lombok.RequiredArgsConstructor;
import org.example.eassigngeniusbe.model.dto.schoolclass.*;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.example.eassigngeniusbe.service.SchoolClassService;
import org.example.eassigngeniusbe.share.customException.GradleLevelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/school-class")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassService schoolClassService;


    @PostMapping
    public ResponseEntity<CreateSchoolClassResponseDto> createSchoolClass(@RequestBody CreateSchoolClassRequestDto createSchoolClassRequestDto,
                                                                          UriComponentsBuilder uriComponentsBuilder) {
        return schoolClassService.createSchoolClass(createSchoolClassRequestDto, uriComponentsBuilder);
    }

    @GetMapping("/{schoolClassId}")
    public ResponseEntity<GetSchoolClassResponseDto> getSchoolClass(@PathVariable Long schoolClassId) {
        return schoolClassService.getSchoolClass(schoolClassId);
    }

    @GetMapping
    public ResponseEntity<Collection<GetSchoolClassResponseDto>> getAllSchoolClasses() {
        return schoolClassService.getAllSchoolClassDtos();
    }

    @PutMapping
    public ResponseEntity<UpdateSchoolClassResponseDto> updateSchoolClass(@RequestBody UpdateSchoolClassRequestDto updateSchoolClassRequestDto) {
        return schoolClassService.updateSchoolClass(updateSchoolClassRequestDto);
    }

    @DeleteMapping("/{schoolClassId}")
    public ResponseEntity<SchoolClassEntity> deleteSchoolClass(@PathVariable Long schoolClassId) {
        return schoolClassService.deleteSchoolClass(schoolClassId);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Collection<GetSchoolClassResponseDto>> getSchoolClassesByTeacher(@PathVariable Long teacherId) {
        return schoolClassService.getSchoolClassesByTeacher(teacherId);
    }

    @GetMapping("/grade-level/{gradeLevelId}")
    public ResponseEntity<Set<GetSchoolClassResponseDto>> getSchoolClassesByGradeLevel(@PathVariable Long gradeLevelId) {
        return schoolClassService.getSchoolClassesByGradeLevel(gradeLevelId);
    }

    /**
     * Handles the exception when a GradleLevel is not found.
     *
     * @param ex The GradleLevelNotFoundException that occurred.
     * @return The ResponseEntity containing the error message and HttpStatus.NOT_FOUND.
     */
    @ExceptionHandler(GradleLevelNotFoundException.class)
    public ResponseEntity<String> handleNotFound(GradleLevelNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
