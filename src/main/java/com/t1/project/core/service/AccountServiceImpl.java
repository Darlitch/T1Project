package com.t1.project.core.service;

import com.t1.project.core.model.Account;
import com.t1.project.core.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    private Account getEntityById(long id) {
        return accountRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
