package org.example.eassigngeniusbe.controller;

import lombok.RequiredArgsConstructor;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassRequestDto;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassResponseDto;
import org.example.eassigngeniusbe.service.SchoolClassService;
import org.example.eassigngeniusbe.share.customException.GradleLevelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
