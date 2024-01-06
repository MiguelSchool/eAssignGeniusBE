package org.example.eassigngeniusbe.service;

import org.example.eassigngeniusbe.model.dto.gradlelevel.*;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

public interface GradLevelService {

    ResponseEntity<CreateGradeLevelResponseDto> createGradeLevel(CreateGradeLevelRequestDto createGradeLevelRequestDto, UriComponentsBuilder uriComponentsBuilder);

    UpdateGradeLevelResponseDto updateGradeLevel(UpdateGradeLevelRequestDto updateGradeLevelRequestDto);

    GetGradeLevelDto findGradeLevelById(Long gradleLevelId);

    GradeLevelEntity findGradeLevelEntityById(Long gradleLevelId);

    Collection<GetGradeLevelDto> getAllGradeLevels();

    GradeLevelEntity deleteGradleLevel(Long gradleLevelId);

    GradeLevelEntity mapDtoToEntity(GetGradeLevelDto gradeLevelDto);
}
