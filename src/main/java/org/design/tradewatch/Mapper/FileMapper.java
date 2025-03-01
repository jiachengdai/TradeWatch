package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.design.tradewatch.Entity.File;

@Mapper
public interface FileMapper {

    @Insert("insert into file (userid,filename,fileurl) values (#{username},#{filename},#{fileurl})")
    void addFile(String username, String filename, String fileurl);
}
