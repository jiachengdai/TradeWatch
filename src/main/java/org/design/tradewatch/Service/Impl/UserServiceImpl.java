package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.User;
import org.design.tradewatch.Mapper.UserMapper;
import org.design.tradewatch.Service.UserService;
import org.design.tradewatch.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getInfo() {
        Map<String ,Object> mp= ThreadLocalUtil.get();
        String username=(String) mp.get("username");
      return   userMapper.getInfo(username);
    }

    @Override
    public void update(User user) {
        Map<String ,Object> mp= ThreadLocalUtil.get();
        String username=(String) mp.get("username");
        userMapper.update(user,username);
    }

    @Override
    public void addUser(String username) {
        userMapper.addUser(username);
    }
}
