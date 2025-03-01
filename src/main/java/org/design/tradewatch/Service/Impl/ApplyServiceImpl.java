package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Mapper.ApplyMapper;
import org.design.tradewatch.Service.ApplyService;
import org.design.tradewatch.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    public void newApply(String algorithm ,String datawrite,String multialgo){
      String applytime=  LocalDateTime.now().toString().substring(0,19);
        Map<String ,Object>mp= ThreadLocalUtil.get();
      String userid=(String) mp.get("username");
      applyMapper.newApply( userid,applytime,algorithm,datawrite,multialgo);
    }


}
