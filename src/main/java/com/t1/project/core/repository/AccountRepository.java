package com.t1.project.core.repository;

import com.t1.project.core.model.Account;
import com.t1.project.core.model.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByClientId(long clientId);
}
