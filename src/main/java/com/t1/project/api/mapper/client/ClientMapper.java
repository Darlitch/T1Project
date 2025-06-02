package com.t1.project.api.mapper.client;

import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.core.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    ClientDto toDto(Client client);
    List<ClientDto> toDto(List<Client> clients);
}
