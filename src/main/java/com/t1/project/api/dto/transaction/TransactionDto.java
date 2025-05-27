package com.t1.project.api.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.t1.project.api.dto.account.AccountDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TransactionDto {
    Long id;
    AccountDto account;
    BigDecimal amount;
    LocalDateTime transactionDate;
}
