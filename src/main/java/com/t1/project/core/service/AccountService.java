package com.t1.project.core.service;

import com.t1.project.api.dto.account.AccountCreateDto;
import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.api.dto.account.AccountUpdateDto;
import com.t1.project.core.model.Account;

import java.util.List;

public interface AccountService {
    AccountDto create(Long clientId, AccountCreateDto account);

    List<AccountDto> getAll();

    AccountDto getById(long id);

    Account getEntityById(long id);

    List<AccountDto> getAllByClientId(long clientId);

    AccountDto update(long id, AccountUpdateDto account);

    void delete(long id);
}
