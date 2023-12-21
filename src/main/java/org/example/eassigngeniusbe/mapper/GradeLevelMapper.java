package org.example.eassigngeniusbe.mapper;

import org.example.eassigngeniusbe.model.dto.gradlelevel.CreateGradeLevelRequestDto;
import org.example.eassigngeniusbe.model.dto.gradlelevel.CreateGradeLevelResponseDto;
import org.example.eassigngeniusbe.model.dto.gradlelevel.GetGradeLevelDto;
import org.example.eassigngeniusbe.model.dto.gradlelevel.UpdateGradeLevelResponseDto;
import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradeLevelMapper {

    GradeLevelEntity mapCreateGradeLevelDtoToToEntity(CreateGradeLevelRequestDto gradeLevel);

    CreateGradeLevelResponseDto mapToCreateGradeLevelResponseDto(GradeLevelEntity gradeLevelEntity);

    UpdateGradeLevelResponseDto mapUpdateGradeLevelEntityToResponseDto(GradeLevelEntity gradeLevelEntity);

    GetGradeLevelDto mapGetGradeLevelToDto(GradeLevelEntity gradeLevelEntity);
}
