package com.t1.project.api.controller;

import com.t1.project.api.dto.transaction.TransactionCreateDto;
import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.api.dto.transaction.TransactionUpdateDto;
import com.t1.project.core.service.TransactionService;
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
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{accountId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDto create(@PathVariable Long accountId,@Valid @RequestBody TransactionCreateDto transactionDto) {
        return transactionService.create(accountId, transactionDto);
    }

    @GetMapping
    public List<TransactionDto> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/by-account/{accountId}")
    public List<TransactionDto> getAllByAccountId(@PathVariable Long accountId) {
        return transactionService.getAllByAccountId(accountId);
    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @PatchMapping("/{id}")
    public TransactionDto update(@PathVariable Long id,@Valid @RequestBody TransactionUpdateDto transactionDto) {
        return transactionService.update(id, transactionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }

}
