package org.example.eassigngeniusbe.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eassigngeniusbe.mapper.SchoolClassMapper;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassRequestDto;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassResponseDto;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.example.eassigngeniusbe.repository.SchoolClassRepository;
import org.example.eassigngeniusbe.service.GradLevelService;
import org.example.eassigngeniusbe.service.SchoolClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
@Slf4j
class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;
    private final GradLevelService gradLevelService;

    //TODO:: SUBJECT AND TEACHER

    @Override
    public ResponseEntity<CreateSchoolClassResponseDto> createSchoolClass(CreateSchoolClassRequestDto createSchoolClassRequestDto,
                                                                          UriComponentsBuilder uriComponentsBuilder) {
        SchoolClassEntity schoolClassEntityToCreate = schoolClassMapper.mapCreateSchoolClassDtoToSchoolClassEntity(createSchoolClassRequestDto);
        GradeLevelEntity gradeLevelEntity = gradLevelService.findGradeLevelEntityById(createSchoolClassRequestDto.GradeLevelId());
        schoolClassEntityToCreate.setGradeLevelEntity(gradeLevelEntity);
        SchoolClassEntity createdEntity = schoolClassRepository.save(schoolClassEntityToCreate);
        UriComponents uriComponents = uriComponentsBuilder.path("/school-class/{id}")
                .buildAndExpand(createdEntity.getId());
        CreateSchoolClassResponseDto responseDto = schoolClassMapper.mapToCreateSchoolClassResponseDto(createdEntity);
        return ResponseEntity.created(uriComponents.toUri()).body(responseDto);
    }
}
