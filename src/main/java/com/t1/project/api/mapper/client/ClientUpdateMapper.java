package com.t1.project.api.mapper.client;

import com.t1.project.api.dto.client.ClientUpdateDto;
import com.t1.project.core.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientUpdateMapper {
    void updateFromDto(ClientUpdateDto dto, @MappingTarget Client client);
}
