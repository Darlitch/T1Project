package com.t1.project.core.service;

import com.t1.project.api.dto.account.AccountCreateDto;
import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.api.dto.account.AccountUpdateDto;
import com.t1.project.api.mapper.account.AccountMapper;
import com.t1.project.api.mapper.account.AccountUpdateMapper;
import com.t1.project.core.aspect.annotation.Cached;
import com.t1.project.core.aspect.annotation.LogDataSourceError;
import com.t1.project.core.aspect.annotation.Metric;
import com.t1.project.core.exception.ErrorCode;
import com.t1.project.core.exception.ServiceException;
import com.t1.project.core.model.Account;
import com.t1.project.core.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final  AccountMapper accountMapper;
    private final AccountUpdateMapper accountUpdateMapper;
    private final ClientService clientService;

    @Override
    @Cached
    @LogDataSourceError
    public AccountDto create(Long clientId, AccountCreateDto accountDto) {
        Account account = Account.builder()
                .client(clientService.getEntityById(clientId))
                .accountType(accountDto.getAccountType())
                .build();
        return accountMapper.toDto(accountRepository.save(account));
    }


    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public List<AccountDto> getAll() {
        return accountMapper.toDto(accountRepository.findAll());
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public AccountDto getById(long id) {
        return accountMapper.toDto(getEntityById(id));
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public Account getEntityById(long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ServiceException("There is no account with ID: " + id, ErrorCode.NOT_FOUND));
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public List<AccountDto> getAllByClientId(long clientId) {
        return accountMapper.toDto(accountRepository.findAllByClientId(clientId));
    }

    @Override
    @Metric
    @LogDataSourceError
    public AccountDto update(long id, AccountUpdateDto accountDto) {
        Account account = getEntityById(id);
        accountUpdateMapper.updateFromDto(accountDto, account);
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    @Metric
    @LogDataSourceError
    public void delete(long id) {
        accountRepository.delete(getEntityById(id));
    }
}
