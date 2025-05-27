package com.t1.project.api.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.t1.project.api.dto.client.ClientDto;
import com.t1.project.api.dto.transaction.TransactionDto;
import com.t1.project.core.model.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountDto {
    Long id;
    ClientDto client;
    AccountType accountType;
    BigDecimal balance;
}
