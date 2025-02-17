package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.design.tradewatch.Entity.Account;

@Mapper
public interface AccountMapper {
    @Insert("insert into account(username,password,type) values (#{username},#{password},1)")
    void register(String username, String password, Integer type);
@Select("select * from account where username=#{username}")
    Account findByUsername(String username);
}
