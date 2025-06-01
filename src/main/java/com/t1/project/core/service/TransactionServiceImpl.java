package com.t1.project.core.service;

import com.t1.project.api.dto.transaction.TransactionCreateDto;
import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.api.dto.transaction.TransactionUpdateDto;
import com.t1.project.api.mapper.transaction.TransactionMapper;
import com.t1.project.api.mapper.transaction.TransactionUpdateMapper;
import com.t1.project.core.model.Transaction;
import com.t1.project.core.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionUpdateMapper transactionUpdateMapper;
    private final AccountService accountService;

    public TransactionDto create(long accountId, TransactionCreateDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .account(accountService.getEntityById(accountId))
                .amount(transactionDto.getAmount())
                .build();
        return transactionMapper.toDto(transaction);
    }

    public List<TransactionDto> getAll() {
        return transactionMapper.toDto(transactionRepository.findAll());
    }

    public TransactionDto getById(long id) {
        return transactionMapper.toDto(getEntityById(id));
    }

    private Transaction getEntityById(long id) {
        return transactionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<TransactionDto> getAllByAccountId(long accountId) {
        return transactionMapper.toDto(transactionRepository.findAllByAccountId(accountId));
    }

    public TransactionDto update(long id, TransactionUpdateDto transactionDto) {
        Transaction transaction = getEntityById(id);
        transactionUpdateMapper.updateFromDto(transactionDto, transaction);
        return transactionMapper.toDto(transaction);
    }

    public void delete(long id) {
        transactionRepository.delete(getEntityById(id));
    }

}
