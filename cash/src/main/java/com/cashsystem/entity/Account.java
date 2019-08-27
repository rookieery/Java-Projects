package com.cashsystem.entity;

import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private AccountType accountType;
    private AccountStatus accountStatus;
}
