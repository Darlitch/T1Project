package com.t1.project.api.mapper;

import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.core.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    TransactionDto toDto(Transaction transaction);
    List<TransactionDto> toDto(List<Transaction> transactions);
}
