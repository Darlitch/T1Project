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

    Client getEntityById(long id);

    List<ClientDto> getByLastName(String lastName);

    List<Client> getEntityByLastName(String lastName);

    ClientDto update(long id, ClientUpdateDto clent);

    void delete(long id);
}
