package com.t1.project.api.mapper.account;

import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.core.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
    AccountDto toDto(Account account);
    List<AccountDto> toDto(List<Account> accounts);
}
