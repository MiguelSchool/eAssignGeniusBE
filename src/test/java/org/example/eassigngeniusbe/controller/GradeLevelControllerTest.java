package org.example.eassigngeniusbe.controller;


import org.example.eassigngeniusbe.model.dto.gradlelevel.*;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.example.eassigngeniusbe.service.GradLevelService;
import org.example.eassigngeniusbe.share.customException.GradleLevelNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class GradeLevelControllerTest {

    @InjectMocks
    private GradeLevelController sut;

    @Mock
    private GradLevelService gradLevelService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateGradeLevel() {
        CreateGradeLevelRequestDto requestDto = new CreateGradeLevelRequestDto("mock", LocalDate.now(), LocalDate.now());
        ResponseEntity<CreateGradeLevelResponseDto> expectedResponse = new ResponseEntity<>(HttpStatus.CREATED);

        when(gradLevelService.createGradeLevel(eq(requestDto), any())).thenReturn(expectedResponse);
        ResponseEntity<CreateGradeLevelResponseDto> actualResponse = sut.createGradeLevel(requestDto, null);
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    void testUpdateGradeLevel() {
        UpdateGradeLevelRequestDto requestDto = new UpdateGradeLevelRequestDto(1L, "name", LocalDate.now(), LocalDate.now());
        ResponseEntity<UpdateGradeLevelResponseDto> expectedResponse = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<UpdateGradeLevelResponseDto> actualResponse = sut.updateGradeLevel(requestDto);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    void testGetSingleGradeLevel() {
        Long gradleLevelId = 1L;
        GetGradeLevelDto expectedResponse = new GetGradeLevelDto(1L, "mock", LocalDate.now(), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        GetGradeLevelDto expectedDto = new GetGradeLevelDto(1L, "mock", LocalDate.now(), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        when(gradLevelService.findGradeLevelById(gradleLevelId)).thenReturn(expectedDto);
        ResponseEntity<GetGradeLevelDto> actualResponse = sut.getSingleGradeLevel(gradleLevelId);

        assertEquals(expectedResponse, actualResponse.getBody());
    }

    @Test
    void testGetAllGradeLevels() {
        Collection<GetGradeLevelDto> expectedResponse = new ArrayList<>();

        ResponseEntity<Collection<GetGradeLevelDto>> actualResponse = sut.getAllGradeLevels();

        assertEquals(expectedResponse, actualResponse.getBody());
    }

    @Test
    void testDeleteGradleLevel() {
        Long gradleLevelId = 1L;
        GradeLevelEntity expectedResponse = new GradeLevelEntity();
        Mockito.when(gradLevelService.deleteGradleLevel(gradleLevelId))
                .thenReturn(expectedResponse);
        ResponseEntity<GradeLevelEntity> actualResponse = sut.deleteGradleLevel(gradleLevelId);

        assertEquals(expectedResponse, actualResponse.getBody());
    }

    @Test
    void testHandleNotFound() {
        GradleLevelNotFoundException exception = new GradleLevelNotFoundException("1L");
        ResponseEntity<String> expectedResponse = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        ResponseEntity<String> actualResponse = sut.handleNotFound(exception);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    void testDeleteGradeLevel_ServiceThrowsException() {
        final Long gradeLevelId = 1L;
        doThrow(GradleLevelNotFoundException.class).when(gradLevelService).deleteGradleLevel(gradeLevelId);
        assertThrows(GradleLevelNotFoundException.class, () -> sut.deleteGradleLevel(gradeLevelId));
    }
}
