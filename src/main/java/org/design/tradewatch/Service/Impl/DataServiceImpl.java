package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Controller.DataController;
import org.design.tradewatch.Entity.EveryDayTrade;
import org.design.tradewatch.Entity.TradeTypeStatic;
import org.design.tradewatch.Mapper.DataMapper;
import org.design.tradewatch.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<EveryDayTrade> getEveryDayTrade() {
        return dataMapper.getEveryDayTrade();
    }

    @Override
    public List<TradeTypeStatic> getTypeStatic() {
      List<TradeTypeStatic>tradeTypeStatics=  dataMapper.getTypeStatic();
      for(TradeTypeStatic tradeTypeStatic:tradeTypeStatics){
          if(tradeTypeStatic.getType()==0){
              tradeTypeStatic.setName("庞氏骗局");
          }
          else if (tradeTypeStatic.getType()==1){
              tradeTypeStatic.setName("洗钱");
          }
          else if (tradeTypeStatic.getType()==2){
              tradeTypeStatic.setName("电信诈骗");
          }
          else if (tradeTypeStatic.getType()==3){
              tradeTypeStatic.setName("频繁交易");
          }
          else{
              tradeTypeStatic.setName("其他");
          }
      }
      return tradeTypeStatics;
    }
}
