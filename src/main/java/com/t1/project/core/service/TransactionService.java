package com.t1.project.core.service;

import com.t1.project.api.dto.transaction.TransactionCreateDto;
import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.api.dto.transaction.TransactionUpdateDto;
import com.t1.project.core.model.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionDto create(long accountId, TransactionCreateDto transactionDto);

    List<TransactionDto> getAll();

    TransactionDto getById(long id);

    List<TransactionDto> getAllByAccountId(long AccountId);

    TransactionDto update(long id, TransactionUpdateDto transactionDto);

    void delete(long id);
}
