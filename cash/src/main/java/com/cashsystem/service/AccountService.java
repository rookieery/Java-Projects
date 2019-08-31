package com.cashsystem.service;

import com.cashsystem.dao.AccountDao;
import com.cashsystem.entity.Account;

import java.util.List;

public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDao();
    }

    public Account login(String username, String password) {
        return this.accountDao.login(username, password);
    }
    public boolean register(Account account){
        return this.accountDao.register(account);
    }

    public List<Account> queryAllAccount() {
        return this.accountDao.queryAllAccount();
    }

    public boolean updatePassword(int id,String newPassword) {
        return this.accountDao.updatePassword(id,newPassword);
    }

    public boolean updateAccountStatus1(Integer id) {
        return this.accountDao.updateAccountStatus1(id);
    }

    public boolean updateAccountStatus2(Integer id) {
        return this.accountDao.updateAccountStatus2(id);
    }
}
