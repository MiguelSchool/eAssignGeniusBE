package org.example.eassigngeniusbe.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eassigngeniusbe.mapper.GradeLevelMapper;
import org.example.eassigngeniusbe.mapper.SchoolClassMapper;
import org.example.eassigngeniusbe.model.dto.gradlelevel.GetGradeLevelDto;
import org.example.eassigngeniusbe.model.dto.schoolclass.*;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.example.eassigngeniusbe.repository.SchoolClassRepository;
import org.example.eassigngeniusbe.service.GradLevelService;
import org.example.eassigngeniusbe.service.SchoolClassService;
import org.example.eassigngeniusbe.share.customException.NotDeletedException;
import org.example.eassigngeniusbe.share.customException.SchoolClassNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
class SchoolClassServiceImpl implements SchoolClassService {
    private final GradeLevelMapper gradeLevelMapper;

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;
    private final GradLevelService gradLevelService;

    //TODO:: SUBJECT AND TEACHER

    @Override
    public ResponseEntity<CreateSchoolClassResponseDto> createSchoolClass(CreateSchoolClassRequestDto createSchoolClassRequestDto,
                                                                          UriComponentsBuilder uriComponentsBuilder) {
        SchoolClassEntity schoolClassEntityToCreate = schoolClassMapper.mapRequestDtoToEntity(createSchoolClassRequestDto);
        GradeLevelEntity gradeLevelEntity = gradLevelService.findGradeLevelEntityById(createSchoolClassRequestDto.GradeLevelId());
        schoolClassEntityToCreate.setGradeLevelEntity(gradeLevelEntity);
        SchoolClassEntity createdEntity = schoolClassRepository.save(schoolClassEntityToCreate);
        UriComponents uriComponents = uriComponentsBuilder.path("/school-class/{id}")
                .buildAndExpand(createdEntity.getId());
        CreateSchoolClassResponseDto responseDto = schoolClassMapper.mapEntityToResponseDto(createdEntity);
        return ResponseEntity.created(uriComponents.toUri()).body(responseDto);
    }

    @Override
    public ResponseEntity<UpdateSchoolClassResponseDto> updateSchoolClass(UpdateSchoolClassRequestDto updateSchoolClassRequestDto) {
        SchoolClassEntity schoolClassEntityToUpdate = getSchoolClassEntity(updateSchoolClassRequestDto.id());

        schoolClassEntityToUpdate.setClassRoom(updateSchoolClassRequestDto.classRoom());
        schoolClassEntityToUpdate.setClassname(updateSchoolClassRequestDto.classname());
//        schoolClassEntityToUpdate.setClassTeacher(updateSchoolClassRequestDto.); TODO: teacher
        GetGradeLevelDto gradeLevelDto = gradLevelService.findGradeLevelById(updateSchoolClassRequestDto.gradeLevelId());
        schoolClassEntityToUpdate.setGradeLevelEntity(gradLevelService.mapDtoToEntity(gradeLevelDto));
        schoolClassEntityToUpdate.setUpdatedAt(LocalDateTime.now());
        SchoolClassEntity updatedEntity = schoolClassRepository.save(schoolClassEntityToUpdate);
        return ResponseEntity.ok(schoolClassMapper.mapEntityToUpdatedResponseDto(updatedEntity));
    }

    @Override
    public ResponseEntity<GetSchoolClassResponseDto> getSchoolClass(Long schoolClassId) {
        SchoolClassEntity schoolClassEntity = getSchoolClassEntity(schoolClassId);
        return ResponseEntity.ok(schoolClassMapper.mapEntityToGetSchoolClassDto(schoolClassEntity));
    }

    @Override
    public ResponseEntity<Collection<GetSchoolClassResponseDto>> getAllSchoolClassDtos() {
        return ResponseEntity.ok(schoolClassRepository.findAll().stream()
                .map(schoolClassMapper::mapEntityToGetSchoolClassDto)
                .collect(Collectors.toSet())
        );
    }

    @Override
    public ResponseEntity<SchoolClassEntity> deleteSchoolClass(Long schoolClassId) {
        SchoolClassEntity entity = getSchoolClassEntity(schoolClassId);
        schoolClassRepository.delete(entity);
        if (!schoolClassRepository.existsById(schoolClassId)) {
            return ResponseEntity.ok(entity);
        }
        throw new NotDeletedException("school class entity with id: "+ schoolClassId + "was not deleted");
    }

    @Override
    public ResponseEntity<Collection<GetSchoolClassResponseDto>> getSchoolClassesByTeacher(Long teacherId) {
        return null;
    }

    @Override
    public ResponseEntity<Set<GetSchoolClassResponseDto>> getSchoolClassesByGradeLevel(Long gradeLevelId) {
        return ResponseEntity.ok(
                gradeLevelMapper.mapDtoToEntity(gradLevelService.findGradeLevelById(gradeLevelId)).getSchoolClassEntities().stream()
                        .map(schoolClassMapper::mapEntityToGetSchoolClassDto)
                        .collect(Collectors.toSet())
        );
    }

    private SchoolClassEntity getSchoolClassEntity(Long id) {
        return schoolClassRepository.findById(id)
                .orElseThrow(() -> new SchoolClassNotFoundException(id));
    }

}
