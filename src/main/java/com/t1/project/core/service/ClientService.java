package com.t1.project.core.service;

import com.t1.project.api.dto.client.ClientCreateDto;
import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.api.dto.client.ClientUpdateDto;
import com.t1.project.core.model.Client;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientCreateDto client);

    List<ClientDto> getAll();

    ClientDto getById(long id);

    ClientDto getByFullName(String name);

    ClientDto getByLastName(String lastName);

    ClientDto update(ClientUpdateDto clent);

    void delete(long id);
}
