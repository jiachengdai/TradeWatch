package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.Account;
import org.design.tradewatch.Mapper.AccountMapper;
import org.design.tradewatch.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
     return   accountMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password, Integer type) {
        accountMapper.register(username,password,type);

    }
}
