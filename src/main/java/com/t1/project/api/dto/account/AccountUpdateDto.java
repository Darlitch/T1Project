package com.t1.project.api.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.t1.project.core.model.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountUpdateDto {
    AccountType accountType;
}
