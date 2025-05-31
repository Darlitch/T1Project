package com.t1.project.core.service;

import com.t1.project.api.dto.client.ClientCreateDto;
import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.api.dto.client.ClientUpdateDto;
import com.t1.project.core.model.Client;
import com.t1.project.core.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    ClientDto create(ClientCreateDto client);

    List<ClientDto> getAll();

    ClientDto getById(long id);

    ClientDto getByFullName(String name);

    ClientDto getByLastName(String lastName);

    ClientDto update(ClientUpdateDto clent);

    void delete(long id);

    private Client getEntityById(long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
