package org.example.eassigngeniusbe.mapper;

import org.example.eassigngeniusbe.model.dto.schoolclass.*;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {

    SchoolClassEntity mapRequestDtoToEntity(CreateSchoolClassRequestDto createSchoolClassRequestDto);
    CreateSchoolClassResponseDto mapEntityToResponseDto(SchoolClassEntity schoolClassEntity);
    GetSchoolClassResponseDto mapEntityToGetSchoolClassDto(SchoolClassEntity schoolClassEntity);

    @Mapping(source="gradeLevelEntity.id", target="gradeLevelId")
    @Mapping(source="classTeacher.id", target="teacherId")
    UpdateSchoolClassResponseDto mapEntityToUpdatedResponseDto(SchoolClassEntity schoolClassEntity);
}
