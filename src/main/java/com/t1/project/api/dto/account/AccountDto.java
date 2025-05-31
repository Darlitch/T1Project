package com.t1.project.api.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.t1.project.api.dto.client.ClientShortDto;
import com.t1.project.core.model.enums.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountDto {
    Long id;
    ClientShortDto client;
    AccountType accountType;
    BigDecimal balance;
}
