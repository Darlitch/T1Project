package com.t1.project.api.controller;

import com.t1.project.api.dto.client.ClientCreateDto;
import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.api.dto.client.ClientUpdateDto;
import com.t1.project.core.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@Valid @RequestBody ClientCreateDto clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping
    public List<ClientDto> getAll () {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @GetMapping("/lastName/{lastName}")
    public List<ClientDto> getByLastName(@PathVariable String lastName) {
        return clientService.getByLastName(lastName);
    }

    @PatchMapping("/{id}")
    public ClientDto update(@PathVariable Long id,@Valid @RequestBody ClientUpdateDto clientDto) {
        return clientService.update(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
