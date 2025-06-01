package com.t1.project.api.mapper.transaction;

import com.t1.project.api.dto.transaction.TransactionUpdateDto;
import com.t1.project.core.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransactionUpdateMapper {
    void updateFromDto(TransactionUpdateDto dto, @MappingTarget Transaction transaction);
}
