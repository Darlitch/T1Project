package com.t1.project.core.service;

import com.t1.project.api.dto.transaction.TransactionCreateDto;
import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.api.dto.transaction.TransactionUpdateDto;
import com.t1.project.api.mapper.transaction.TransactionMapper;
import com.t1.project.api.mapper.transaction.TransactionUpdateMapper;
import com.t1.project.core.aspect.annotation.Cached;
import com.t1.project.core.aspect.annotation.LogDataSourceError;
import com.t1.project.core.aspect.annotation.Metric;
import com.t1.project.core.exception.ErrorCode;
import com.t1.project.core.exception.ServiceException;
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

    @Override
    @Cached
    @LogDataSourceError
    public TransactionDto create(long accountId, TransactionCreateDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .account(accountService.getEntityById(accountId))
                .amount(transactionDto.getAmount())
                .build();
        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public List<TransactionDto> getAll() {
        return transactionMapper.toDto(transactionRepository.findAll());
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public TransactionDto getById(long id) {
        return transactionMapper.toDto(getEntityById(id));
    }

    @Metric
    @Cached
    @LogDataSourceError
    private Transaction getEntityById(long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new ServiceException("There is no transaction with ID: " + id, ErrorCode.NOT_FOUND));
    }

    @Override
    @Metric
    @Cached
    @LogDataSourceError
    public List<TransactionDto> getAllByAccountId(long accountId) {
        return transactionMapper.toDto(transactionRepository.findAllByAccountId(accountId));
    }

    @Override
    @Metric
    @LogDataSourceError
    public TransactionDto update(long id, TransactionUpdateDto transactionDto) {
        Transaction transaction = getEntityById(id);
        transactionUpdateMapper.updateFromDto(transactionDto, transaction);
        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    @Override
    @Metric
    @LogDataSourceError
    public void delete(long id) {
        transactionRepository.delete(getEntityById(id));
    }

}
