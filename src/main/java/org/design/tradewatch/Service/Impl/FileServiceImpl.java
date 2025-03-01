package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.File;
import org.design.tradewatch.Mapper.FileMapper;
import org.design.tradewatch.Service.FileService;
import org.design.tradewatch.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;
    @Override
    public void addFile(String filename,String fielurl) {
            Map<String ,Object>mp= ThreadLocalUtil.get();
           String username=(String) mp.get("username");
            fileMapper.addFile(username,filename,fielurl);
    }
}
