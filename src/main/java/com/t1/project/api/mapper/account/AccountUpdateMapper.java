package com.t1.project.api.mapper.account;

import com.t1.project.api.dto.account.AccountUpdateDto;
import com.t1.project.core.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
       nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
       unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountUpdateMapper {
    void updateFromDto(AccountUpdateDto dto, @MappingTarget Account account);
}
