package com.t1.project.core.service;

import com.t1.project.api.dto.account.AccountCreateDto;
import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.api.dto.account.AccountUpdateDto;
import com.t1.project.core.model.Account;

import java.util.List;

public interface AccountService {
    AccountDto create(AccountCreateDto account);

    List<AccountDto> getAll();

    AccountDto getById(long id);

    List<Account> getAllByClientId(long clientId);

    AccountDto update(AccountUpdateDto account);

    void delete(long id);
}
