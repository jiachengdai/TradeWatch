package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {
    @Insert("INSERT INTO apply(userid,applytime,algorithm,datawrite,multialgo) values (#{userid},#{applytime},#{algorithm},#{datawrite},#{multialgo})")
     void newApply(String userid,String applytime,String algorithm,String datawrite,String multialgo) ;
}
