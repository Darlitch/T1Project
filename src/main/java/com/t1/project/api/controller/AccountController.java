package com.t1.project.api.controller;


import com.t1.project.api.dto.account.AccountCreateDto;
import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.api.dto.account.AccountUpdateDto;
import com.t1.project.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto create(@PathVariable Long clientId, @RequestBody AccountCreateDto accountDto) {
        return accountService.create(clientId, accountDto);
    }

    @GetMapping
    public List<AccountDto> getAll() {
        return accountService.getAll();
    }

    @GetMapping("by-client/{clientId}")
    public List<AccountDto> getAllByClientId(@PathVariable Long clientId) {
        return accountService.getAllByClientId(clientId);
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @PutMapping("/{id}")
    public AccountDto update(@PathVariable Long id, @RequestBody AccountUpdateDto accountDto) {
        return accountService.update(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }
}
