package com.asseco.poc.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asseco.poc.document.EventEntity;
import com.asseco.poc.dto.EventDto;

@Mapper(componentModel = "jsr330")
public interface EventMapper {

    List<EventDto> mapToDtoList(List<EventEntity> entity);

    EventEntity mapToEntity(EventDto dto);

    @InheritInverseConfiguration(name = "mapToEntity")
    EventDto mapToDto(EventEntity entity);


}
