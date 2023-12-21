package org.example.eassigngeniusbe.controller;

import lombok.RequiredArgsConstructor;
import org.example.eassigngeniusbe.model.dto.gradlelevel.*;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.example.eassigngeniusbe.service.interfaces.GradLevelServiceI;
import org.example.eassigngeniusbe.share.customException.GradleLevelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;


/**
 * Controller class for managing GradeLevels.
 */
@RestController
@RequestMapping("/gradeLevel")
@RequiredArgsConstructor
public class GradeLevelController {

    private final GradLevelServiceI gradleLevelService;

    /**
     * Creates a new grade level.
     *
     * @param dtoToCreate           The DTO containing the information of the grade level to create.
     * @param uriComponentsBuilder The URI components builder for building the URI of the created grade level.
     * @return The ResponseEntity containing the created grade level DTO.
     */
    @PostMapping
    public ResponseEntity<CreateGradeLevelResponseDto> createGradeLevel(@RequestBody CreateGradeLevelRequestDto dtoToCreate, UriComponentsBuilder uriComponentsBuilder) {
        return gradleLevelService.createGradeLevel(dtoToCreate, uriComponentsBuilder);
    }

    /**
     * Updates the grade level.
     *
     * @param updateGradeLevelRequestDto The DTO containing the information of the grade level to update.
     * @return The ResponseEntity containing the updated grade level DTO.
     */
    @PutMapping
    public ResponseEntity<UpdateGradeLevelResponseDto> updateGradeLevel(@RequestBody UpdateGradeLevelRequestDto updateGradeLevelRequestDto) {
        return ResponseEntity.ok(gradleLevelService.updateGradeLevel(updateGradeLevelRequestDto));
    }

    /**
     * Retrieves a single grade level by its ID.
     *
     * @param gradleLevelId The ID of the grade level.
     * @return The ResponseEntity containing the grade level DTO if found, or HttpStatus.NOT_FOUND if the grade level is not found.
     */
    @GetMapping("/{gradleLevelId}")
    public ResponseEntity<GetGradeLevelDto> getSingleGradeLevel(@PathVariable Long gradleLevelId) {
        return ResponseEntity.ok(gradleLevelService.findGradeLevelById(gradleLevelId));
    }

    /**
     * Retrieves all grade levels.
     *
     * @return The ResponseEntity containing the collection of GetGradeLevelDto if found, or an empty collection if none is found.
     */
    @GetMapping
    public ResponseEntity<Collection<GetGradeLevelDto>> getAllGradeLevels() {
        return ResponseEntity.ok(gradleLevelService.getAllGradeLevels());
    }

    /**
     * Deletes a grade level by its ID.
     *
     * @param gradleLevelId The ID of the grade level to delete.
     * @return The ResponseEntity containing the deleted GradeLevelEntity.
     */
    @DeleteMapping("/{gradleLevelId}")
    public ResponseEntity<GradeLevelEntity> deleteGradleLevel(@PathVariable Long gradleLevelId) {
        return ResponseEntity.ok(gradleLevelService.deleteGradleLevel(gradleLevelId));
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
