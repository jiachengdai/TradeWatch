package org.design.tradewatch.Service;


import org.design.tradewatch.Entity.Account;

public interface AccountService {
  

    Account findByUsername(String username);

    void register(String username, String password, Integer type);
}
