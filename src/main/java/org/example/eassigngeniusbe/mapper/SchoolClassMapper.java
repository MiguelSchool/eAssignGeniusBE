package org.example.eassigngeniusbe.mapper;

import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassRequestDto;
import org.example.eassigngeniusbe.model.dto.SchoolClass.CreateSchoolClassResponseDto;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {

    SchoolClassEntity mapCreateSchoolClassDtoToSchoolClassEntity(CreateSchoolClassRequestDto createSchoolClassRequestDto);
    CreateSchoolClassResponseDto mapToCreateSchoolClassResponseDto(SchoolClassEntity schoolClassEntity);
}
