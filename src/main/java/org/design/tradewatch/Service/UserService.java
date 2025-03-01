package org.design.tradewatch.Service;

import org.design.tradewatch.Entity.User;

public interface UserService {

    User getInfo();

    void update(User user);

    void addUser(String username);
}
