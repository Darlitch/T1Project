package com.t1.project.api.dto.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.t1.project.api.dto.account.AccountDto;
import com.t1.project.api.dto.account.AccountShortDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ClientDto {
    Long id;
    String firstName;
    String middleName;
    String lastName;
    List<AccountShortDto> accounts;
}
