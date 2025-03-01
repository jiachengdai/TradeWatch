package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.design.tradewatch.Entity.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user(userid) values (#{userid})")
    void addUser(String userid);
    @Select("select * from user where userid=#{username}")
    User getInfo(String username);
    @Update("update user set name=#{user.name},tel=#{user.tel} where userid=#{username}")
    void update(User user, String username);
}
