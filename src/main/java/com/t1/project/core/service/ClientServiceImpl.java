package com.t1.project.core.service;

import com.t1.project.api.dto.client.ClientCreateDto;
import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.api.dto.client.ClientUpdateDto;
import com.t1.project.api.mapper.client.ClientMapper;
import com.t1.project.api.mapper.client.ClientUpdateMapper;
import com.t1.project.core.model.Client;
import com.t1.project.core.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientUpdateMapper clientUpdateMapper;

    @Override
    public ClientDto create(ClientCreateDto clientDto) {
        Client client = Client.builder()
                .firstName(clientDto.getFirstName())
                .middleName(clientDto.getMiddleName())
                .lastName(clientDto.getLastName())
                .build();
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public List<ClientDto> getAll() {
        return clientMapper.toDto(clientRepository.findAll());
    }

    @Override
    public ClientDto getById(long id) {
        return clientMapper.toDto(getEntityById(id));
    }

    @Override
    public Client getEntityById(long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ClientDto> getByLastName(String lastName) {
        return clientMapper.toDto(getEntityByLastName(lastName));
    }

    @Override
    public List<Client> getEntityByLastName(String lastName) {
        return clientRepository.findByLastName(lastName);
    }

    @Override
    public ClientDto update(long id, ClientUpdateDto clientDto) {
        Client client = getEntityById(id);
        clientUpdateMapper.updateFromDto(clientDto, client);
        return clientMapper.toDto(clientRepository.save(client));

    }

    @Override
    public void delete(long id) {
        clientRepository.delete(getEntityById(id));
    }
}
