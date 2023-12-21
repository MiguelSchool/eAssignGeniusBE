package org.example.eassigngeniusbe.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eassigngeniusbe.mapper.GradeLevelMapper;
import org.example.eassigngeniusbe.model.dto.gradlelevel.*;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.example.eassigngeniusbe.repository.GradeLevelRepository;
import org.example.eassigngeniusbe.service.GradLevelService;
import org.example.eassigngeniusbe.share.customException.GradleLevelNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
class GradLevelServiceImpl implements GradLevelService {

    private final GradeLevelRepository gradeLevelRepository;
    private final GradeLevelMapper gradeLevelMapper;

    @Override
    public ResponseEntity<CreateGradeLevelResponseDto> createGradeLevel(CreateGradeLevelRequestDto createGradeLevelRequestDto,
                                                                        UriComponentsBuilder uriComponentsBuilder) {
        GradeLevelEntity gradeLevelEntityToCreate = gradeLevelMapper.mapCreateRequestDtoToToEntity(createGradeLevelRequestDto);
        GradeLevelEntity createdEntity = gradeLevelRepository.save(gradeLevelEntityToCreate);
        UriComponents uriComponents = uriComponentsBuilder.path("/gradeLevel/{id}")
                .buildAndExpand(createdEntity.getId());
        CreateGradeLevelResponseDto createdDto = gradeLevelMapper.mapEntityToCreateResponseDto(createdEntity);
        log.debug("gradle level with id {} has been created", createdEntity.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(createdDto);
    }

    @Override
    public UpdateGradeLevelResponseDto updateGradeLevel(UpdateGradeLevelRequestDto updateGradeLevelRequestDto) {
        GradeLevelEntity gradeLevelEntityToUpdate = gradeLevelRepository.findById(updateGradeLevelRequestDto.id())
                .orElseThrow(() -> createGradeLevelNotFoundException(updateGradeLevelRequestDto.id()));
        gradeLevelEntityToUpdate.setName(updateGradeLevelRequestDto.name());
        gradeLevelEntityToUpdate.setBeginGradle(updateGradeLevelRequestDto.beginGradle());
        gradeLevelEntityToUpdate.setEndGradle(updateGradeLevelRequestDto.endGradle());
        gradeLevelEntityToUpdate.setUpdatedAt(LocalDateTime.now());
        GradeLevelEntity updatedEntity = gradeLevelRepository.save(gradeLevelEntityToUpdate);
        UpdateGradeLevelResponseDto updatedDto = gradeLevelMapper.mapEntityToUpdateResponseDto(updatedEntity);
        log.debug("gradle level with id {} has been updated", updatedEntity.getId());
        return updatedDto;
    }

    @Override
    public GetGradeLevelDto findGradeLevelById(Long gradleLevelId) {
        GradeLevelEntity gradeLevelEntity = gradeLevelRepository.findById(gradleLevelId).orElseThrow(() ->
                createGradeLevelNotFoundException(gradleLevelId)
        );
        return gradeLevelMapper.mapEntityToGetDto(gradeLevelEntity);
    }

    @Override
    public GradeLevelEntity findGradeLevelEntityById(Long gradleLevelId) {
        return gradeLevelRepository.findById(gradleLevelId).orElseThrow(()-> createGradeLevelNotFoundException(gradleLevelId));
    }

    @Override
    public Collection<GetGradeLevelDto> getAllGradeLevels() {
        return gradeLevelRepository.findAll().stream()
                .map(gradeLevelMapper::mapEntityToGetDto)
                .collect(Collectors.toSet());
    }

    @Override
    public GradeLevelEntity deleteGradleLevel(Long gradleLevelId) {
        GradeLevelEntity existingEntity = gradeLevelRepository.findById(gradleLevelId).orElseThrow(()->
                createGradeLevelNotFoundException(gradleLevelId)
        );
        gradeLevelRepository.deleteById(gradleLevelId);
        return existingEntity;
    }

    private GradleLevelNotFoundException createGradeLevelNotFoundException(Long gradeLevelId) {
       return new GradleLevelNotFoundException("gradeLevel with gradeLevelId " + gradeLevelId + " not found");
    }
}
